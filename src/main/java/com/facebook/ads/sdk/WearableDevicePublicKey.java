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
public class WearableDevicePublicKey extends APINode {
  @SerializedName("base64_encoded_public_key")
  private String mBase64EncodedPublicKey = null;
  @SerializedName("creation_time_on_device")
  private String mCreationTimeOnDevice = null;
  @SerializedName("device_uuid")
  private String mDeviceUuid = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("key_type")
  private String mKeyType = null;
  @SerializedName("owner_id")
  private String mOwnerId = null;
  @SerializedName("product_use_case")
  private String mProductUseCase = null;
  @SerializedName("version")
  private String mVersion = null;
  protected static Gson gson = null;

  WearableDevicePublicKey() {
  }

  public WearableDevicePublicKey(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public WearableDevicePublicKey(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public WearableDevicePublicKey fetch() throws APIException{
    WearableDevicePublicKey newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static WearableDevicePublicKey fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<WearableDevicePublicKey> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static WearableDevicePublicKey fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<WearableDevicePublicKey> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<WearableDevicePublicKey> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<WearableDevicePublicKey>)(
      new APIRequest<WearableDevicePublicKey>(context, "", "/", "GET", WearableDevicePublicKey.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<WearableDevicePublicKey>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", WearableDevicePublicKey.getParser())
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
  public static WearableDevicePublicKey loadJSON(String json, APIContext context, String header) {
    WearableDevicePublicKey wearableDevicePublicKey = getGson().fromJson(json, WearableDevicePublicKey.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(wearableDevicePublicKey.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    wearableDevicePublicKey.context = context;
    wearableDevicePublicKey.rawValue = json;
    wearableDevicePublicKey.header = header;
    return wearableDevicePublicKey;
  }

  public static APINodeList<WearableDevicePublicKey> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<WearableDevicePublicKey> wearableDevicePublicKeys = new APINodeList<WearableDevicePublicKey>(request, json, header);
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
          wearableDevicePublicKeys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return wearableDevicePublicKeys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                wearableDevicePublicKeys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            wearableDevicePublicKeys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              wearableDevicePublicKeys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              wearableDevicePublicKeys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  wearableDevicePublicKeys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              wearableDevicePublicKeys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return wearableDevicePublicKeys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              wearableDevicePublicKeys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return wearableDevicePublicKeys;
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
              wearableDevicePublicKeys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return wearableDevicePublicKeys;
          }

          // Sixth, check if it's pure JsonObject
          wearableDevicePublicKeys.clear();
          wearableDevicePublicKeys.add(loadJSON(json, context, header));
          return wearableDevicePublicKeys;
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


  public String getFieldBase64EncodedPublicKey() {
    return mBase64EncodedPublicKey;
  }

  public String getFieldCreationTimeOnDevice() {
    return mCreationTimeOnDevice;
  }

  public String getFieldDeviceUuid() {
    return mDeviceUuid;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldKeyType() {
    return mKeyType;
  }

  public String getFieldOwnerId() {
    return mOwnerId;
  }

  public String getFieldProductUseCase() {
    return mProductUseCase;
  }

  public String getFieldVersion() {
    return mVersion;
  }



  public static class APIRequestGet extends APIRequest<WearableDevicePublicKey> {

    WearableDevicePublicKey lastResponse = null;
    @Override
    public WearableDevicePublicKey getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "base64_encoded_public_key",
      "creation_time_on_device",
      "device_uuid",
      "id",
      "key_type",
      "owner_id",
      "product_use_case",
      "version",
    };

    @Override
    public WearableDevicePublicKey parseResponse(String response, String header) throws APIException {
      return WearableDevicePublicKey.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WearableDevicePublicKey execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WearableDevicePublicKey execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WearableDevicePublicKey> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WearableDevicePublicKey> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WearableDevicePublicKey>() {
           public WearableDevicePublicKey apply(ResponseWrapper result) {
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

    public APIRequestGet requestBase64EncodedPublicKeyField () {
      return this.requestBase64EncodedPublicKeyField(true);
    }
    public APIRequestGet requestBase64EncodedPublicKeyField (boolean value) {
      this.requestField("base64_encoded_public_key", value);
      return this;
    }
    public APIRequestGet requestCreationTimeOnDeviceField () {
      return this.requestCreationTimeOnDeviceField(true);
    }
    public APIRequestGet requestCreationTimeOnDeviceField (boolean value) {
      this.requestField("creation_time_on_device", value);
      return this;
    }
    public APIRequestGet requestDeviceUuidField () {
      return this.requestDeviceUuidField(true);
    }
    public APIRequestGet requestDeviceUuidField (boolean value) {
      this.requestField("device_uuid", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestKeyTypeField () {
      return this.requestKeyTypeField(true);
    }
    public APIRequestGet requestKeyTypeField (boolean value) {
      this.requestField("key_type", value);
      return this;
    }
    public APIRequestGet requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGet requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
      return this;
    }
    public APIRequestGet requestProductUseCaseField () {
      return this.requestProductUseCaseField(true);
    }
    public APIRequestGet requestProductUseCaseField (boolean value) {
      this.requestField("product_use_case", value);
      return this;
    }
    public APIRequestGet requestVersionField () {
      return this.requestVersionField(true);
    }
    public APIRequestGet requestVersionField (boolean value) {
      this.requestField("version", value);
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

  public WearableDevicePublicKey copyFrom(WearableDevicePublicKey instance) {
    this.mBase64EncodedPublicKey = instance.mBase64EncodedPublicKey;
    this.mCreationTimeOnDevice = instance.mCreationTimeOnDevice;
    this.mDeviceUuid = instance.mDeviceUuid;
    this.mId = instance.mId;
    this.mKeyType = instance.mKeyType;
    this.mOwnerId = instance.mOwnerId;
    this.mProductUseCase = instance.mProductUseCase;
    this.mVersion = instance.mVersion;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<WearableDevicePublicKey> getParser() {
    return new APIRequest.ResponseParser<WearableDevicePublicKey>() {
      public APINodeList<WearableDevicePublicKey> parseResponse(String response, APIContext context, APIRequest<WearableDevicePublicKey> request, String header) throws MalformedResponseException {
        return WearableDevicePublicKey.parseResponse(response, context, request, header);
      }
    };
  }
}
