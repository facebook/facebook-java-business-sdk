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
public class CTXPartnerAppWelcomeMessageFlow extends APINode {
  @SerializedName("compatible_platforms")
  private List<String> mCompatiblePlatforms = null;
  @SerializedName("eligible_platforms")
  private List<String> mEligiblePlatforms = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_used_in_ad")
  private Boolean mIsUsedInAd = null;
  @SerializedName("last_update_time")
  private String mLastUpdateTime = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("welcome_message_flow")
  private String mWelcomeMessageFlow = null;
  protected static Gson gson = null;

  CTXPartnerAppWelcomeMessageFlow() {
  }

  public CTXPartnerAppWelcomeMessageFlow(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CTXPartnerAppWelcomeMessageFlow(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CTXPartnerAppWelcomeMessageFlow fetch() throws APIException{
    CTXPartnerAppWelcomeMessageFlow newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CTXPartnerAppWelcomeMessageFlow fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CTXPartnerAppWelcomeMessageFlow> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CTXPartnerAppWelcomeMessageFlow fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CTXPartnerAppWelcomeMessageFlow> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CTXPartnerAppWelcomeMessageFlow> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CTXPartnerAppWelcomeMessageFlow>)(
      new APIRequest<CTXPartnerAppWelcomeMessageFlow>(context, "", "/", "GET", CTXPartnerAppWelcomeMessageFlow.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CTXPartnerAppWelcomeMessageFlow>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CTXPartnerAppWelcomeMessageFlow.getParser())
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
  public static CTXPartnerAppWelcomeMessageFlow loadJSON(String json, APIContext context, String header) {
    CTXPartnerAppWelcomeMessageFlow ctxPartnerAppWelcomeMessageFlow = getGson().fromJson(json, CTXPartnerAppWelcomeMessageFlow.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(ctxPartnerAppWelcomeMessageFlow.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    ctxPartnerAppWelcomeMessageFlow.context = context;
    ctxPartnerAppWelcomeMessageFlow.rawValue = json;
    ctxPartnerAppWelcomeMessageFlow.header = header;
    return ctxPartnerAppWelcomeMessageFlow;
  }

  public static APINodeList<CTXPartnerAppWelcomeMessageFlow> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CTXPartnerAppWelcomeMessageFlow> ctxPartnerAppWelcomeMessageFlows = new APINodeList<CTXPartnerAppWelcomeMessageFlow>(request, json, header);
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
          ctxPartnerAppWelcomeMessageFlows.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return ctxPartnerAppWelcomeMessageFlows;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                ctxPartnerAppWelcomeMessageFlows.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            ctxPartnerAppWelcomeMessageFlows.setPaging(previous, next);
            if (context.hasAppSecret()) {
              ctxPartnerAppWelcomeMessageFlows.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              ctxPartnerAppWelcomeMessageFlows.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  ctxPartnerAppWelcomeMessageFlows.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              ctxPartnerAppWelcomeMessageFlows.add(loadJSON(obj.toString(), context, header));
            }
          }
          return ctxPartnerAppWelcomeMessageFlows;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              ctxPartnerAppWelcomeMessageFlows.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return ctxPartnerAppWelcomeMessageFlows;
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
              ctxPartnerAppWelcomeMessageFlows.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return ctxPartnerAppWelcomeMessageFlows;
          }

          // Sixth, check if it's pure JsonObject
          ctxPartnerAppWelcomeMessageFlows.clear();
          ctxPartnerAppWelcomeMessageFlows.add(loadJSON(json, context, header));
          return ctxPartnerAppWelcomeMessageFlows;
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


  public List<String> getFieldCompatiblePlatforms() {
    return mCompatiblePlatforms;
  }

  public List<String> getFieldEligiblePlatforms() {
    return mEligiblePlatforms;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsUsedInAd() {
    return mIsUsedInAd;
  }

  public String getFieldLastUpdateTime() {
    return mLastUpdateTime;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldWelcomeMessageFlow() {
    return mWelcomeMessageFlow;
  }



  public static class APIRequestGet extends APIRequest<CTXPartnerAppWelcomeMessageFlow> {

    CTXPartnerAppWelcomeMessageFlow lastResponse = null;
    @Override
    public CTXPartnerAppWelcomeMessageFlow getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "compatible_platforms",
      "eligible_platforms",
      "id",
      "is_used_in_ad",
      "last_update_time",
      "name",
      "welcome_message_flow",
    };

    @Override
    public CTXPartnerAppWelcomeMessageFlow parseResponse(String response, String header) throws APIException {
      return CTXPartnerAppWelcomeMessageFlow.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CTXPartnerAppWelcomeMessageFlow execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CTXPartnerAppWelcomeMessageFlow execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CTXPartnerAppWelcomeMessageFlow> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CTXPartnerAppWelcomeMessageFlow> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CTXPartnerAppWelcomeMessageFlow>() {
           public CTXPartnerAppWelcomeMessageFlow apply(ResponseWrapper result) {
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

    public APIRequestGet requestCompatiblePlatformsField () {
      return this.requestCompatiblePlatformsField(true);
    }
    public APIRequestGet requestCompatiblePlatformsField (boolean value) {
      this.requestField("compatible_platforms", value);
      return this;
    }
    public APIRequestGet requestEligiblePlatformsField () {
      return this.requestEligiblePlatformsField(true);
    }
    public APIRequestGet requestEligiblePlatformsField (boolean value) {
      this.requestField("eligible_platforms", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsUsedInAdField () {
      return this.requestIsUsedInAdField(true);
    }
    public APIRequestGet requestIsUsedInAdField (boolean value) {
      this.requestField("is_used_in_ad", value);
      return this;
    }
    public APIRequestGet requestLastUpdateTimeField () {
      return this.requestLastUpdateTimeField(true);
    }
    public APIRequestGet requestLastUpdateTimeField (boolean value) {
      this.requestField("last_update_time", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestWelcomeMessageFlowField () {
      return this.requestWelcomeMessageFlowField(true);
    }
    public APIRequestGet requestWelcomeMessageFlowField (boolean value) {
      this.requestField("welcome_message_flow", value);
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

  public CTXPartnerAppWelcomeMessageFlow copyFrom(CTXPartnerAppWelcomeMessageFlow instance) {
    this.mCompatiblePlatforms = instance.mCompatiblePlatforms;
    this.mEligiblePlatforms = instance.mEligiblePlatforms;
    this.mId = instance.mId;
    this.mIsUsedInAd = instance.mIsUsedInAd;
    this.mLastUpdateTime = instance.mLastUpdateTime;
    this.mName = instance.mName;
    this.mWelcomeMessageFlow = instance.mWelcomeMessageFlow;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CTXPartnerAppWelcomeMessageFlow> getParser() {
    return new APIRequest.ResponseParser<CTXPartnerAppWelcomeMessageFlow>() {
      public APINodeList<CTXPartnerAppWelcomeMessageFlow> parseResponse(String response, APIContext context, APIRequest<CTXPartnerAppWelcomeMessageFlow> request, String header) throws MalformedResponseException {
        return CTXPartnerAppWelcomeMessageFlow.parseResponse(response, context, request, header);
      }
    };
  }
}
