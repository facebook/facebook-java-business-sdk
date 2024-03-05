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
public class AdRuleEvaluationSpec extends APINode {
  @SerializedName("evaluation_type")
  private EnumEvaluationType mEvaluationType = null;
  @SerializedName("filters")
  private List<AdRuleFilters> mFilters = null;
  @SerializedName("trigger")
  private AdRuleTrigger mTrigger = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdRuleEvaluationSpec() {
  }

  public AdRuleEvaluationSpec(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdRuleEvaluationSpec(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdRuleEvaluationSpec fetch() throws APIException{
    AdRuleEvaluationSpec newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdRuleEvaluationSpec fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdRuleEvaluationSpec> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdRuleEvaluationSpec fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdRuleEvaluationSpec> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdRuleEvaluationSpec> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdRuleEvaluationSpec>)(
      new APIRequest<AdRuleEvaluationSpec>(context, "", "/", "GET", AdRuleEvaluationSpec.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdRuleEvaluationSpec>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdRuleEvaluationSpec.getParser())
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
  public static AdRuleEvaluationSpec loadJSON(String json, APIContext context, String header) {
    AdRuleEvaluationSpec adRuleEvaluationSpec = getGson().fromJson(json, AdRuleEvaluationSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adRuleEvaluationSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adRuleEvaluationSpec.context = context;
    adRuleEvaluationSpec.rawValue = json;
    adRuleEvaluationSpec.header = header;
    return adRuleEvaluationSpec;
  }

  public static APINodeList<AdRuleEvaluationSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdRuleEvaluationSpec> adRuleEvaluationSpecs = new APINodeList<AdRuleEvaluationSpec>(request, json, header);
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
          adRuleEvaluationSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adRuleEvaluationSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adRuleEvaluationSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adRuleEvaluationSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adRuleEvaluationSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adRuleEvaluationSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adRuleEvaluationSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adRuleEvaluationSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adRuleEvaluationSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adRuleEvaluationSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adRuleEvaluationSpecs;
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
              adRuleEvaluationSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adRuleEvaluationSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adRuleEvaluationSpecs.clear();
          adRuleEvaluationSpecs.add(loadJSON(json, context, header));
          return adRuleEvaluationSpecs;
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


  public EnumEvaluationType getFieldEvaluationType() {
    return mEvaluationType;
  }

  public List<AdRuleFilters> getFieldFilters() {
    return mFilters;
  }

  public AdRuleTrigger getFieldTrigger() {
    return mTrigger;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdRuleEvaluationSpec> {

    AdRuleEvaluationSpec lastResponse = null;
    @Override
    public AdRuleEvaluationSpec getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "evaluation_type",
      "filters",
      "trigger",
      "id",
    };

    @Override
    public AdRuleEvaluationSpec parseResponse(String response, String header) throws APIException {
      return AdRuleEvaluationSpec.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdRuleEvaluationSpec execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdRuleEvaluationSpec execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdRuleEvaluationSpec> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdRuleEvaluationSpec> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdRuleEvaluationSpec>() {
           public AdRuleEvaluationSpec apply(ResponseWrapper result) {
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

    public APIRequestGet requestEvaluationTypeField () {
      return this.requestEvaluationTypeField(true);
    }
    public APIRequestGet requestEvaluationTypeField (boolean value) {
      this.requestField("evaluation_type", value);
      return this;
    }
    public APIRequestGet requestFiltersField () {
      return this.requestFiltersField(true);
    }
    public APIRequestGet requestFiltersField (boolean value) {
      this.requestField("filters", value);
      return this;
    }
    public APIRequestGet requestTriggerField () {
      return this.requestTriggerField(true);
    }
    public APIRequestGet requestTriggerField (boolean value) {
      this.requestField("trigger", value);
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

  public static enum EnumEvaluationType {
      @SerializedName("SCHEDULE")
      VALUE_SCHEDULE("SCHEDULE"),
      @SerializedName("TRIGGER")
      VALUE_TRIGGER("TRIGGER"),
      ;

      private String value;

      private EnumEvaluationType(String value) {
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

  public AdRuleEvaluationSpec copyFrom(AdRuleEvaluationSpec instance) {
    this.mEvaluationType = instance.mEvaluationType;
    this.mFilters = instance.mFilters;
    this.mTrigger = instance.mTrigger;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdRuleEvaluationSpec> getParser() {
    return new APIRequest.ResponseParser<AdRuleEvaluationSpec>() {
      public APINodeList<AdRuleEvaluationSpec> parseResponse(String response, APIContext context, APIRequest<AdRuleEvaluationSpec> request, String header) throws MalformedResponseException {
        return AdRuleEvaluationSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
