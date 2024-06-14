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
public class CreatorAssetCreative extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("moderation_status")
  private String mModerationStatus = null;
  @SerializedName("product_item_retailer_id")
  private String mProductItemRetailerId = null;
  @SerializedName("product_url")
  private String mProductUrl = null;
  @SerializedName("retailer_id")
  private String mRetailerId = null;
  @SerializedName("video_url")
  private String mVideoUrl = null;
  protected static Gson gson = null;

  CreatorAssetCreative() {
  }

  public CreatorAssetCreative(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CreatorAssetCreative(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CreatorAssetCreative fetch() throws APIException{
    CreatorAssetCreative newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CreatorAssetCreative fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CreatorAssetCreative> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CreatorAssetCreative fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CreatorAssetCreative> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CreatorAssetCreative> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CreatorAssetCreative>)(
      new APIRequest<CreatorAssetCreative>(context, "", "/", "GET", CreatorAssetCreative.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CreatorAssetCreative>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CreatorAssetCreative.getParser())
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
  public static CreatorAssetCreative loadJSON(String json, APIContext context, String header) {
    CreatorAssetCreative creatorAssetCreative = getGson().fromJson(json, CreatorAssetCreative.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(creatorAssetCreative.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    creatorAssetCreative.context = context;
    creatorAssetCreative.rawValue = json;
    creatorAssetCreative.header = header;
    return creatorAssetCreative;
  }

  public static APINodeList<CreatorAssetCreative> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CreatorAssetCreative> creatorAssetCreatives = new APINodeList<CreatorAssetCreative>(request, json, header);
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
          creatorAssetCreatives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return creatorAssetCreatives;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                creatorAssetCreatives.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            creatorAssetCreatives.setPaging(previous, next);
            if (context.hasAppSecret()) {
              creatorAssetCreatives.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              creatorAssetCreatives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  creatorAssetCreatives.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              creatorAssetCreatives.add(loadJSON(obj.toString(), context, header));
            }
          }
          return creatorAssetCreatives;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              creatorAssetCreatives.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return creatorAssetCreatives;
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
              creatorAssetCreatives.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return creatorAssetCreatives;
          }

          // Sixth, check if it's pure JsonObject
          creatorAssetCreatives.clear();
          creatorAssetCreatives.add(loadJSON(json, context, header));
          return creatorAssetCreatives;
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

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public String getFieldModerationStatus() {
    return mModerationStatus;
  }

  public String getFieldProductItemRetailerId() {
    return mProductItemRetailerId;
  }

  public String getFieldProductUrl() {
    return mProductUrl;
  }

  public String getFieldRetailerId() {
    return mRetailerId;
  }

  public String getFieldVideoUrl() {
    return mVideoUrl;
  }



  public static class APIRequestGet extends APIRequest<CreatorAssetCreative> {

    CreatorAssetCreative lastResponse = null;
    @Override
    public CreatorAssetCreative getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "image_url",
      "moderation_status",
      "product_item_retailer_id",
      "product_url",
      "retailer_id",
      "video_url",
    };

    @Override
    public CreatorAssetCreative parseResponse(String response, String header) throws APIException {
      return CreatorAssetCreative.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CreatorAssetCreative execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CreatorAssetCreative execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CreatorAssetCreative> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CreatorAssetCreative> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CreatorAssetCreative>() {
           public CreatorAssetCreative apply(ResponseWrapper result) {
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
    public APIRequestGet requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGet requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGet requestModerationStatusField () {
      return this.requestModerationStatusField(true);
    }
    public APIRequestGet requestModerationStatusField (boolean value) {
      this.requestField("moderation_status", value);
      return this;
    }
    public APIRequestGet requestProductItemRetailerIdField () {
      return this.requestProductItemRetailerIdField(true);
    }
    public APIRequestGet requestProductItemRetailerIdField (boolean value) {
      this.requestField("product_item_retailer_id", value);
      return this;
    }
    public APIRequestGet requestProductUrlField () {
      return this.requestProductUrlField(true);
    }
    public APIRequestGet requestProductUrlField (boolean value) {
      this.requestField("product_url", value);
      return this;
    }
    public APIRequestGet requestRetailerIdField () {
      return this.requestRetailerIdField(true);
    }
    public APIRequestGet requestRetailerIdField (boolean value) {
      this.requestField("retailer_id", value);
      return this;
    }
    public APIRequestGet requestVideoUrlField () {
      return this.requestVideoUrlField(true);
    }
    public APIRequestGet requestVideoUrlField (boolean value) {
      this.requestField("video_url", value);
      return this;
    }
  }

  public static enum EnumModerationStatus {
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("ELIGIBLE")
      VALUE_ELIGIBLE("ELIGIBLE"),
      @SerializedName("EXPIRED")
      VALUE_EXPIRED("EXPIRED"),
      @SerializedName("INELIGIBLE")
      VALUE_INELIGIBLE("INELIGIBLE"),
      @SerializedName("IN_REVIEW")
      VALUE_IN_REVIEW("IN_REVIEW"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumModerationStatus(String value) {
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

  public CreatorAssetCreative copyFrom(CreatorAssetCreative instance) {
    this.mId = instance.mId;
    this.mImageUrl = instance.mImageUrl;
    this.mModerationStatus = instance.mModerationStatus;
    this.mProductItemRetailerId = instance.mProductItemRetailerId;
    this.mProductUrl = instance.mProductUrl;
    this.mRetailerId = instance.mRetailerId;
    this.mVideoUrl = instance.mVideoUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CreatorAssetCreative> getParser() {
    return new APIRequest.ResponseParser<CreatorAssetCreative>() {
      public APINodeList<CreatorAssetCreative> parseResponse(String response, APIContext context, APIRequest<CreatorAssetCreative> request, String header) throws MalformedResponseException {
        return CreatorAssetCreative.parseResponse(response, context, request, header);
      }
    };
  }
}
