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
public class IGMediaBoostEligibilityInfo extends APINode {
  @SerializedName("boost_ineligible_reason")
  private String mBoostIneligibleReason = null;
  @SerializedName("eligible_to_boost")
  private Boolean mEligibleToBoost = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  IGMediaBoostEligibilityInfo() {
  }

  public IGMediaBoostEligibilityInfo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGMediaBoostEligibilityInfo(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGMediaBoostEligibilityInfo fetch() throws APIException{
    IGMediaBoostEligibilityInfo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGMediaBoostEligibilityInfo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGMediaBoostEligibilityInfo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGMediaBoostEligibilityInfo fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGMediaBoostEligibilityInfo> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGMediaBoostEligibilityInfo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGMediaBoostEligibilityInfo>)(
      new APIRequest<IGMediaBoostEligibilityInfo>(context, "", "/", "GET", IGMediaBoostEligibilityInfo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGMediaBoostEligibilityInfo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGMediaBoostEligibilityInfo.getParser())
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
  public static IGMediaBoostEligibilityInfo loadJSON(String json, APIContext context, String header) {
    IGMediaBoostEligibilityInfo igMediaBoostEligibilityInfo = getGson().fromJson(json, IGMediaBoostEligibilityInfo.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(igMediaBoostEligibilityInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igMediaBoostEligibilityInfo.context = context;
    igMediaBoostEligibilityInfo.rawValue = json;
    igMediaBoostEligibilityInfo.header = header;
    return igMediaBoostEligibilityInfo;
  }

  public static APINodeList<IGMediaBoostEligibilityInfo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGMediaBoostEligibilityInfo> igMediaBoostEligibilityInfos = new APINodeList<IGMediaBoostEligibilityInfo>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          igMediaBoostEligibilityInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igMediaBoostEligibilityInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igMediaBoostEligibilityInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igMediaBoostEligibilityInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igMediaBoostEligibilityInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igMediaBoostEligibilityInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igMediaBoostEligibilityInfos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igMediaBoostEligibilityInfos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igMediaBoostEligibilityInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igMediaBoostEligibilityInfos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igMediaBoostEligibilityInfos;
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
              igMediaBoostEligibilityInfos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igMediaBoostEligibilityInfos;
          }

          // Sixth, check if it's pure JsonObject
          igMediaBoostEligibilityInfos.clear();
          igMediaBoostEligibilityInfos.add(loadJSON(json, context, header));
          return igMediaBoostEligibilityInfos;
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


  public String getFieldBoostIneligibleReason() {
    return mBoostIneligibleReason;
  }

  public Boolean getFieldEligibleToBoost() {
    return mEligibleToBoost;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<IGMediaBoostEligibilityInfo> {

    IGMediaBoostEligibilityInfo lastResponse = null;
    @Override
    public IGMediaBoostEligibilityInfo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "boost_ineligible_reason",
      "eligible_to_boost",
      "id",
    };

    @Override
    public IGMediaBoostEligibilityInfo parseResponse(String response, String header) throws APIException {
      return IGMediaBoostEligibilityInfo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMediaBoostEligibilityInfo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMediaBoostEligibilityInfo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMediaBoostEligibilityInfo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMediaBoostEligibilityInfo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMediaBoostEligibilityInfo>() {
           public IGMediaBoostEligibilityInfo apply(ResponseWrapper result) {
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

    public APIRequestGet requestBoostIneligibleReasonField () {
      return this.requestBoostIneligibleReasonField(true);
    }
    public APIRequestGet requestBoostIneligibleReasonField (boolean value) {
      this.requestField("boost_ineligible_reason", value);
      return this;
    }
    public APIRequestGet requestEligibleToBoostField () {
      return this.requestEligibleToBoostField(true);
    }
    public APIRequestGet requestEligibleToBoostField (boolean value) {
      this.requestField("eligible_to_boost", value);
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

  public IGMediaBoostEligibilityInfo copyFrom(IGMediaBoostEligibilityInfo instance) {
    this.mBoostIneligibleReason = instance.mBoostIneligibleReason;
    this.mEligibleToBoost = instance.mEligibleToBoost;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGMediaBoostEligibilityInfo> getParser() {
    return new APIRequest.ResponseParser<IGMediaBoostEligibilityInfo>() {
      public APINodeList<IGMediaBoostEligibilityInfo> parseResponse(String response, APIContext context, APIRequest<IGMediaBoostEligibilityInfo> request, String header) throws MalformedResponseException {
        return IGMediaBoostEligibilityInfo.parseResponse(response, context, request, header);
      }
    };
  }
}
