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
public class PublisherWhiteList extends APINode {
  @SerializedName("business_owner_id")
  private String mBusinessOwnerId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_updated_time")
  private String mLastUpdatedTime = null;
  @SerializedName("last_updated_user")
  private String mLastUpdatedUser = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("placement_type")
  private String mPlacementType = null;
  protected static Gson gson = null;

  PublisherWhiteList() {
  }

  public PublisherWhiteList(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PublisherWhiteList(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PublisherWhiteList fetch() throws APIException{
    PublisherWhiteList newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PublisherWhiteList fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PublisherWhiteList> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PublisherWhiteList fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PublisherWhiteList> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PublisherWhiteList> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PublisherWhiteList>)(
      new APIRequest<PublisherWhiteList>(context, "", "/", "GET", PublisherWhiteList.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PublisherWhiteList>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PublisherWhiteList.getParser())
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
  public static PublisherWhiteList loadJSON(String json, APIContext context, String header) {
    PublisherWhiteList publisherWhiteList = getGson().fromJson(json, PublisherWhiteList.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(publisherWhiteList.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    publisherWhiteList.context = context;
    publisherWhiteList.rawValue = json;
    publisherWhiteList.header = header;
    return publisherWhiteList;
  }

  public static APINodeList<PublisherWhiteList> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PublisherWhiteList> publisherWhiteLists = new APINodeList<PublisherWhiteList>(request, json, header);
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
          publisherWhiteLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return publisherWhiteLists;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                publisherWhiteLists.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            publisherWhiteLists.setPaging(previous, next);
            if (context.hasAppSecret()) {
              publisherWhiteLists.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              publisherWhiteLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  publisherWhiteLists.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              publisherWhiteLists.add(loadJSON(obj.toString(), context, header));
            }
          }
          return publisherWhiteLists;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              publisherWhiteLists.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return publisherWhiteLists;
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
              publisherWhiteLists.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return publisherWhiteLists;
          }

          // Sixth, check if it's pure JsonObject
          publisherWhiteLists.clear();
          publisherWhiteLists.add(loadJSON(json, context, header));
          return publisherWhiteLists;
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


  public String getFieldBusinessOwnerId() {
    return mBusinessOwnerId;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLastUpdatedTime() {
    return mLastUpdatedTime;
  }

  public String getFieldLastUpdatedUser() {
    return mLastUpdatedUser;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPlacementType() {
    return mPlacementType;
  }



  public static class APIRequestGet extends APIRequest<PublisherWhiteList> {

    PublisherWhiteList lastResponse = null;
    @Override
    public PublisherWhiteList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business_owner_id",
      "id",
      "last_updated_time",
      "last_updated_user",
      "name",
      "placement_type",
    };

    @Override
    public PublisherWhiteList parseResponse(String response, String header) throws APIException {
      return PublisherWhiteList.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PublisherWhiteList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PublisherWhiteList execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PublisherWhiteList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PublisherWhiteList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PublisherWhiteList>() {
           public PublisherWhiteList apply(ResponseWrapper result) {
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

    public APIRequestGet requestBusinessOwnerIdField () {
      return this.requestBusinessOwnerIdField(true);
    }
    public APIRequestGet requestBusinessOwnerIdField (boolean value) {
      this.requestField("business_owner_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedTimeField () {
      return this.requestLastUpdatedTimeField(true);
    }
    public APIRequestGet requestLastUpdatedTimeField (boolean value) {
      this.requestField("last_updated_time", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedUserField () {
      return this.requestLastUpdatedUserField(true);
    }
    public APIRequestGet requestLastUpdatedUserField (boolean value) {
      this.requestField("last_updated_user", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPlacementTypeField () {
      return this.requestPlacementTypeField(true);
    }
    public APIRequestGet requestPlacementTypeField (boolean value) {
      this.requestField("placement_type", value);
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

  public PublisherWhiteList copyFrom(PublisherWhiteList instance) {
    this.mBusinessOwnerId = instance.mBusinessOwnerId;
    this.mId = instance.mId;
    this.mLastUpdatedTime = instance.mLastUpdatedTime;
    this.mLastUpdatedUser = instance.mLastUpdatedUser;
    this.mName = instance.mName;
    this.mPlacementType = instance.mPlacementType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PublisherWhiteList> getParser() {
    return new APIRequest.ResponseParser<PublisherWhiteList>() {
      public APINodeList<PublisherWhiteList> parseResponse(String response, APIContext context, APIRequest<PublisherWhiteList> request, String header) throws MalformedResponseException {
        return PublisherWhiteList.parseResponse(response, context, request, header);
      }
    };
  }
}
