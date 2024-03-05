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
public class CloudGame extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner")
  private Profile mOwner = null;
  @SerializedName("playable_ad_file_size")
  private Long mPlayableAdFileSize = null;
  @SerializedName("playable_ad_orientation")
  private String mPlayableAdOrientation = null;
  @SerializedName("playable_ad_package_name")
  private String mPlayableAdPackageName = null;
  @SerializedName("playable_ad_reject_reason")
  private String mPlayableAdRejectReason = null;
  @SerializedName("playable_ad_status")
  private String mPlayableAdStatus = null;
  @SerializedName("playable_ad_upload_time")
  private String mPlayableAdUploadTime = null;
  protected static Gson gson = null;

  CloudGame() {
  }

  public CloudGame(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CloudGame(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CloudGame fetch() throws APIException{
    CloudGame newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CloudGame fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CloudGame> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CloudGame fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CloudGame> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CloudGame> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CloudGame>)(
      new APIRequest<CloudGame>(context, "", "/", "GET", CloudGame.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CloudGame>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CloudGame.getParser())
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
  public static CloudGame loadJSON(String json, APIContext context, String header) {
    CloudGame cloudGame = getGson().fromJson(json, CloudGame.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(cloudGame.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    cloudGame.context = context;
    cloudGame.rawValue = json;
    cloudGame.header = header;
    return cloudGame;
  }

  public static APINodeList<CloudGame> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CloudGame> cloudGames = new APINodeList<CloudGame>(request, json, header);
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
          cloudGames.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return cloudGames;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                cloudGames.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            cloudGames.setPaging(previous, next);
            if (context.hasAppSecret()) {
              cloudGames.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              cloudGames.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  cloudGames.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              cloudGames.add(loadJSON(obj.toString(), context, header));
            }
          }
          return cloudGames;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              cloudGames.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return cloudGames;
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
              cloudGames.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return cloudGames;
          }

          // Sixth, check if it's pure JsonObject
          cloudGames.clear();
          cloudGames.add(loadJSON(json, context, header));
          return cloudGames;
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

  public String getFieldName() {
    return mName;
  }

  public Profile getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public Long getFieldPlayableAdFileSize() {
    return mPlayableAdFileSize;
  }

  public String getFieldPlayableAdOrientation() {
    return mPlayableAdOrientation;
  }

  public String getFieldPlayableAdPackageName() {
    return mPlayableAdPackageName;
  }

  public String getFieldPlayableAdRejectReason() {
    return mPlayableAdRejectReason;
  }

  public String getFieldPlayableAdStatus() {
    return mPlayableAdStatus;
  }

  public String getFieldPlayableAdUploadTime() {
    return mPlayableAdUploadTime;
  }



  public static class APIRequestGet extends APIRequest<CloudGame> {

    CloudGame lastResponse = null;
    @Override
    public CloudGame getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "name",
      "owner",
      "playable_ad_file_size",
      "playable_ad_orientation",
      "playable_ad_package_name",
      "playable_ad_reject_reason",
      "playable_ad_status",
      "playable_ad_upload_time",
    };

    @Override
    public CloudGame parseResponse(String response, String header) throws APIException {
      return CloudGame.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CloudGame execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CloudGame execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CloudGame> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CloudGame> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CloudGame>() {
           public CloudGame apply(ResponseWrapper result) {
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
    public APIRequestGet requestPlayableAdFileSizeField () {
      return this.requestPlayableAdFileSizeField(true);
    }
    public APIRequestGet requestPlayableAdFileSizeField (boolean value) {
      this.requestField("playable_ad_file_size", value);
      return this;
    }
    public APIRequestGet requestPlayableAdOrientationField () {
      return this.requestPlayableAdOrientationField(true);
    }
    public APIRequestGet requestPlayableAdOrientationField (boolean value) {
      this.requestField("playable_ad_orientation", value);
      return this;
    }
    public APIRequestGet requestPlayableAdPackageNameField () {
      return this.requestPlayableAdPackageNameField(true);
    }
    public APIRequestGet requestPlayableAdPackageNameField (boolean value) {
      this.requestField("playable_ad_package_name", value);
      return this;
    }
    public APIRequestGet requestPlayableAdRejectReasonField () {
      return this.requestPlayableAdRejectReasonField(true);
    }
    public APIRequestGet requestPlayableAdRejectReasonField (boolean value) {
      this.requestField("playable_ad_reject_reason", value);
      return this;
    }
    public APIRequestGet requestPlayableAdStatusField () {
      return this.requestPlayableAdStatusField(true);
    }
    public APIRequestGet requestPlayableAdStatusField (boolean value) {
      this.requestField("playable_ad_status", value);
      return this;
    }
    public APIRequestGet requestPlayableAdUploadTimeField () {
      return this.requestPlayableAdUploadTimeField(true);
    }
    public APIRequestGet requestPlayableAdUploadTimeField (boolean value) {
      this.requestField("playable_ad_upload_time", value);
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

  public CloudGame copyFrom(CloudGame instance) {
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mOwner = instance.mOwner;
    this.mPlayableAdFileSize = instance.mPlayableAdFileSize;
    this.mPlayableAdOrientation = instance.mPlayableAdOrientation;
    this.mPlayableAdPackageName = instance.mPlayableAdPackageName;
    this.mPlayableAdRejectReason = instance.mPlayableAdRejectReason;
    this.mPlayableAdStatus = instance.mPlayableAdStatus;
    this.mPlayableAdUploadTime = instance.mPlayableAdUploadTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CloudGame> getParser() {
    return new APIRequest.ResponseParser<CloudGame>() {
      public APINodeList<CloudGame> parseResponse(String response, APIContext context, APIRequest<CloudGame> request, String header) throws MalformedResponseException {
        return CloudGame.parseResponse(response, context, request, header);
      }
    };
  }
}
