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
public class ArAdsDataContainer extends APINode {
  @SerializedName("camera_facing_override")
  private String mCameraFacingOverride = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("effect")
  private List<Object> mEffect = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_published")
  private Boolean mIsPublished = null;
  @SerializedName("last_modified_time")
  private String mLastModifiedTime = null;
  @SerializedName("name")
  private String mName = null;
  protected static Gson gson = null;

  ArAdsDataContainer() {
  }

  public ArAdsDataContainer(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ArAdsDataContainer(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ArAdsDataContainer fetch() throws APIException{
    ArAdsDataContainer newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ArAdsDataContainer fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ArAdsDataContainer> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ArAdsDataContainer fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ArAdsDataContainer> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ArAdsDataContainer> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ArAdsDataContainer>)(
      new APIRequest<ArAdsDataContainer>(context, "", "/", "GET", ArAdsDataContainer.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ArAdsDataContainer>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ArAdsDataContainer.getParser())
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
  public static ArAdsDataContainer loadJSON(String json, APIContext context, String header) {
    ArAdsDataContainer arAdsDataContainer = getGson().fromJson(json, ArAdsDataContainer.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(arAdsDataContainer.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    arAdsDataContainer.context = context;
    arAdsDataContainer.rawValue = json;
    arAdsDataContainer.header = header;
    return arAdsDataContainer;
  }

  public static APINodeList<ArAdsDataContainer> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ArAdsDataContainer> arAdsDataContainers = new APINodeList<ArAdsDataContainer>(request, json, header);
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
          arAdsDataContainers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return arAdsDataContainers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                arAdsDataContainers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            arAdsDataContainers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              arAdsDataContainers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              arAdsDataContainers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  arAdsDataContainers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              arAdsDataContainers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return arAdsDataContainers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              arAdsDataContainers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return arAdsDataContainers;
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
              arAdsDataContainers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return arAdsDataContainers;
          }

          // Sixth, check if it's pure JsonObject
          arAdsDataContainers.clear();
          arAdsDataContainers.add(loadJSON(json, context, header));
          return arAdsDataContainers;
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


  public String getFieldCameraFacingOverride() {
    return mCameraFacingOverride;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public List<Object> getFieldEffect() {
    return mEffect;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsPublished() {
    return mIsPublished;
  }

  public String getFieldLastModifiedTime() {
    return mLastModifiedTime;
  }

  public String getFieldName() {
    return mName;
  }



  public static class APIRequestGet extends APIRequest<ArAdsDataContainer> {

    ArAdsDataContainer lastResponse = null;
    @Override
    public ArAdsDataContainer getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "camera_facing_override",
      "creation_time",
      "effect",
      "id",
      "is_published",
      "last_modified_time",
      "name",
    };

    @Override
    public ArAdsDataContainer parseResponse(String response, String header) throws APIException {
      return ArAdsDataContainer.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ArAdsDataContainer execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ArAdsDataContainer execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ArAdsDataContainer> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ArAdsDataContainer> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ArAdsDataContainer>() {
           public ArAdsDataContainer apply(ResponseWrapper result) {
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

    public APIRequestGet requestCameraFacingOverrideField () {
      return this.requestCameraFacingOverrideField(true);
    }
    public APIRequestGet requestCameraFacingOverrideField (boolean value) {
      this.requestField("camera_facing_override", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestEffectField () {
      return this.requestEffectField(true);
    }
    public APIRequestGet requestEffectField (boolean value) {
      this.requestField("effect", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGet requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGet requestLastModifiedTimeField () {
      return this.requestLastModifiedTimeField(true);
    }
    public APIRequestGet requestLastModifiedTimeField (boolean value) {
      this.requestField("last_modified_time", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
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

  public ArAdsDataContainer copyFrom(ArAdsDataContainer instance) {
    this.mCameraFacingOverride = instance.mCameraFacingOverride;
    this.mCreationTime = instance.mCreationTime;
    this.mEffect = instance.mEffect;
    this.mId = instance.mId;
    this.mIsPublished = instance.mIsPublished;
    this.mLastModifiedTime = instance.mLastModifiedTime;
    this.mName = instance.mName;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ArAdsDataContainer> getParser() {
    return new APIRequest.ResponseParser<ArAdsDataContainer>() {
      public APINodeList<ArAdsDataContainer> parseResponse(String response, APIContext context, APIRequest<ArAdsDataContainer> request, String header) throws MalformedResponseException {
        return ArAdsDataContainer.parseResponse(response, context, request, header);
      }
    };
  }
}
