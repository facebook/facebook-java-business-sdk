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
public class MediaCopyrightUpdateRecord extends APINode {
  @SerializedName("action_types")
  private List<String> mActionTypes = null;
  @SerializedName("actor")
  private User mActor = null;
  @SerializedName("actor_type")
  private String mActorType = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ownership_countries")
  private List<Object> mOwnershipCountries = null;
  @SerializedName("whitelisted_accounts")
  private List<Object> mWhitelistedAccounts = null;
  protected static Gson gson = null;

  MediaCopyrightUpdateRecord() {
  }

  public MediaCopyrightUpdateRecord(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MediaCopyrightUpdateRecord(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MediaCopyrightUpdateRecord fetch() throws APIException{
    MediaCopyrightUpdateRecord newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MediaCopyrightUpdateRecord fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MediaCopyrightUpdateRecord> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MediaCopyrightUpdateRecord fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MediaCopyrightUpdateRecord> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MediaCopyrightUpdateRecord> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MediaCopyrightUpdateRecord>)(
      new APIRequest<MediaCopyrightUpdateRecord>(context, "", "/", "GET", MediaCopyrightUpdateRecord.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MediaCopyrightUpdateRecord>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MediaCopyrightUpdateRecord.getParser())
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
  public static MediaCopyrightUpdateRecord loadJSON(String json, APIContext context, String header) {
    MediaCopyrightUpdateRecord mediaCopyrightUpdateRecord = getGson().fromJson(json, MediaCopyrightUpdateRecord.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(mediaCopyrightUpdateRecord.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    mediaCopyrightUpdateRecord.context = context;
    mediaCopyrightUpdateRecord.rawValue = json;
    mediaCopyrightUpdateRecord.header = header;
    return mediaCopyrightUpdateRecord;
  }

  public static APINodeList<MediaCopyrightUpdateRecord> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MediaCopyrightUpdateRecord> mediaCopyrightUpdateRecords = new APINodeList<MediaCopyrightUpdateRecord>(request, json, header);
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
          mediaCopyrightUpdateRecords.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return mediaCopyrightUpdateRecords;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                mediaCopyrightUpdateRecords.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            mediaCopyrightUpdateRecords.setPaging(previous, next);
            if (context.hasAppSecret()) {
              mediaCopyrightUpdateRecords.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              mediaCopyrightUpdateRecords.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  mediaCopyrightUpdateRecords.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              mediaCopyrightUpdateRecords.add(loadJSON(obj.toString(), context, header));
            }
          }
          return mediaCopyrightUpdateRecords;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mediaCopyrightUpdateRecords.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return mediaCopyrightUpdateRecords;
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
              mediaCopyrightUpdateRecords.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return mediaCopyrightUpdateRecords;
          }

          // Sixth, check if it's pure JsonObject
          mediaCopyrightUpdateRecords.clear();
          mediaCopyrightUpdateRecords.add(loadJSON(json, context, header));
          return mediaCopyrightUpdateRecords;
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


  public List<String> getFieldActionTypes() {
    return mActionTypes;
  }

  public User getFieldActor() {
    if (mActor != null) {
      mActor.context = getContext();
    }
    return mActor;
  }

  public String getFieldActorType() {
    return mActorType;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldId() {
    return mId;
  }

  public List<Object> getFieldOwnershipCountries() {
    return mOwnershipCountries;
  }

  public List<Object> getFieldWhitelistedAccounts() {
    return mWhitelistedAccounts;
  }



  public static class APIRequestGet extends APIRequest<MediaCopyrightUpdateRecord> {

    MediaCopyrightUpdateRecord lastResponse = null;
    @Override
    public MediaCopyrightUpdateRecord getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "action_types",
      "actor",
      "actor_type",
      "creation_time",
      "id",
      "ownership_countries",
      "whitelisted_accounts",
    };

    @Override
    public MediaCopyrightUpdateRecord parseResponse(String response, String header) throws APIException {
      return MediaCopyrightUpdateRecord.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MediaCopyrightUpdateRecord execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MediaCopyrightUpdateRecord execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MediaCopyrightUpdateRecord> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MediaCopyrightUpdateRecord> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MediaCopyrightUpdateRecord>() {
           public MediaCopyrightUpdateRecord apply(ResponseWrapper result) {
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

    public APIRequestGet requestActionTypesField () {
      return this.requestActionTypesField(true);
    }
    public APIRequestGet requestActionTypesField (boolean value) {
      this.requestField("action_types", value);
      return this;
    }
    public APIRequestGet requestActorField () {
      return this.requestActorField(true);
    }
    public APIRequestGet requestActorField (boolean value) {
      this.requestField("actor", value);
      return this;
    }
    public APIRequestGet requestActorTypeField () {
      return this.requestActorTypeField(true);
    }
    public APIRequestGet requestActorTypeField (boolean value) {
      this.requestField("actor_type", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestOwnershipCountriesField () {
      return this.requestOwnershipCountriesField(true);
    }
    public APIRequestGet requestOwnershipCountriesField (boolean value) {
      this.requestField("ownership_countries", value);
      return this;
    }
    public APIRequestGet requestWhitelistedAccountsField () {
      return this.requestWhitelistedAccountsField(true);
    }
    public APIRequestGet requestWhitelistedAccountsField (boolean value) {
      this.requestField("whitelisted_accounts", value);
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

  public MediaCopyrightUpdateRecord copyFrom(MediaCopyrightUpdateRecord instance) {
    this.mActionTypes = instance.mActionTypes;
    this.mActor = instance.mActor;
    this.mActorType = instance.mActorType;
    this.mCreationTime = instance.mCreationTime;
    this.mId = instance.mId;
    this.mOwnershipCountries = instance.mOwnershipCountries;
    this.mWhitelistedAccounts = instance.mWhitelistedAccounts;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MediaCopyrightUpdateRecord> getParser() {
    return new APIRequest.ResponseParser<MediaCopyrightUpdateRecord>() {
      public APINodeList<MediaCopyrightUpdateRecord> parseResponse(String response, APIContext context, APIRequest<MediaCopyrightUpdateRecord> request, String header) throws MalformedResponseException {
        return MediaCopyrightUpdateRecord.parseResponse(response, context, request, header);
      }
    };
  }
}
