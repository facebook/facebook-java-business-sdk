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
public class ALMEndAdvertiserInfo extends APINode {
  @SerializedName("estimated_ad_budget")
  private Long mEstimatedAdBudget = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("parent_advertiser_id")
  private String mParentAdvertiserId = null;
  @SerializedName("parent_advertiser_name")
  private String mParentAdvertiserName = null;
  @SerializedName("tag")
  private List<String> mTag = null;
  protected static Gson gson = null;

  ALMEndAdvertiserInfo() {
  }

  public ALMEndAdvertiserInfo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ALMEndAdvertiserInfo(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ALMEndAdvertiserInfo fetch() throws APIException{
    ALMEndAdvertiserInfo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ALMEndAdvertiserInfo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ALMEndAdvertiserInfo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ALMEndAdvertiserInfo fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ALMEndAdvertiserInfo> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ALMEndAdvertiserInfo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ALMEndAdvertiserInfo>)(
      new APIRequest<ALMEndAdvertiserInfo>(context, "", "/", "GET", ALMEndAdvertiserInfo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ALMEndAdvertiserInfo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ALMEndAdvertiserInfo.getParser())
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
  public static ALMEndAdvertiserInfo loadJSON(String json, APIContext context, String header) {
    ALMEndAdvertiserInfo almEndAdvertiserInfo = getGson().fromJson(json, ALMEndAdvertiserInfo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(almEndAdvertiserInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    almEndAdvertiserInfo.context = context;
    almEndAdvertiserInfo.rawValue = json;
    almEndAdvertiserInfo.header = header;
    return almEndAdvertiserInfo;
  }

  public static APINodeList<ALMEndAdvertiserInfo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ALMEndAdvertiserInfo> almEndAdvertiserInfos = new APINodeList<ALMEndAdvertiserInfo>(request, json, header);
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
          almEndAdvertiserInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return almEndAdvertiserInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                almEndAdvertiserInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            almEndAdvertiserInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              almEndAdvertiserInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              almEndAdvertiserInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  almEndAdvertiserInfos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              almEndAdvertiserInfos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return almEndAdvertiserInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              almEndAdvertiserInfos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return almEndAdvertiserInfos;
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
              almEndAdvertiserInfos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return almEndAdvertiserInfos;
          }

          // Sixth, check if it's pure JsonObject
          almEndAdvertiserInfos.clear();
          almEndAdvertiserInfos.add(loadJSON(json, context, header));
          return almEndAdvertiserInfos;
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


  public Long getFieldEstimatedAdBudget() {
    return mEstimatedAdBudget;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldParentAdvertiserId() {
    return mParentAdvertiserId;
  }

  public String getFieldParentAdvertiserName() {
    return mParentAdvertiserName;
  }

  public List<String> getFieldTag() {
    return mTag;
  }



  public static class APIRequestGet extends APIRequest<ALMEndAdvertiserInfo> {

    ALMEndAdvertiserInfo lastResponse = null;
    @Override
    public ALMEndAdvertiserInfo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "estimated_ad_budget",
      "id",
      "parent_advertiser_id",
      "parent_advertiser_name",
      "tag",
    };

    @Override
    public ALMEndAdvertiserInfo parseResponse(String response, String header) throws APIException {
      return ALMEndAdvertiserInfo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ALMEndAdvertiserInfo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ALMEndAdvertiserInfo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ALMEndAdvertiserInfo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ALMEndAdvertiserInfo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ALMEndAdvertiserInfo>() {
           public ALMEndAdvertiserInfo apply(ResponseWrapper result) {
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

    public APIRequestGet requestEstimatedAdBudgetField () {
      return this.requestEstimatedAdBudgetField(true);
    }
    public APIRequestGet requestEstimatedAdBudgetField (boolean value) {
      this.requestField("estimated_ad_budget", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestParentAdvertiserIdField () {
      return this.requestParentAdvertiserIdField(true);
    }
    public APIRequestGet requestParentAdvertiserIdField (boolean value) {
      this.requestField("parent_advertiser_id", value);
      return this;
    }
    public APIRequestGet requestParentAdvertiserNameField () {
      return this.requestParentAdvertiserNameField(true);
    }
    public APIRequestGet requestParentAdvertiserNameField (boolean value) {
      this.requestField("parent_advertiser_name", value);
      return this;
    }
    public APIRequestGet requestTagField () {
      return this.requestTagField(true);
    }
    public APIRequestGet requestTagField (boolean value) {
      this.requestField("tag", value);
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

  public ALMEndAdvertiserInfo copyFrom(ALMEndAdvertiserInfo instance) {
    this.mEstimatedAdBudget = instance.mEstimatedAdBudget;
    this.mId = instance.mId;
    this.mParentAdvertiserId = instance.mParentAdvertiserId;
    this.mParentAdvertiserName = instance.mParentAdvertiserName;
    this.mTag = instance.mTag;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ALMEndAdvertiserInfo> getParser() {
    return new APIRequest.ResponseParser<ALMEndAdvertiserInfo>() {
      public APINodeList<ALMEndAdvertiserInfo> parseResponse(String response, APIContext context, APIRequest<ALMEndAdvertiserInfo> request, String header) throws MalformedResponseException {
        return ALMEndAdvertiserInfo.parseResponse(response, context, request, header);
      }
    };
  }
}
