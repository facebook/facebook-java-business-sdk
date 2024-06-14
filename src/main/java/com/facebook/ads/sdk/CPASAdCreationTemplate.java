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
public class CPASAdCreationTemplate extends APINode {
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_unused_template")
  private Boolean mIsUnusedTemplate = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("optimization_goal")
  private String mOptimizationGoal = null;
  @SerializedName("targeting_type")
  private String mTargetingType = null;
  @SerializedName("template_type")
  private String mTemplateType = null;
  protected static Gson gson = null;

  CPASAdCreationTemplate() {
  }

  public CPASAdCreationTemplate(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CPASAdCreationTemplate(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CPASAdCreationTemplate fetch() throws APIException{
    CPASAdCreationTemplate newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CPASAdCreationTemplate fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CPASAdCreationTemplate> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CPASAdCreationTemplate fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CPASAdCreationTemplate> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CPASAdCreationTemplate> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CPASAdCreationTemplate>)(
      new APIRequest<CPASAdCreationTemplate>(context, "", "/", "GET", CPASAdCreationTemplate.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CPASAdCreationTemplate>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CPASAdCreationTemplate.getParser())
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
  public static CPASAdCreationTemplate loadJSON(String json, APIContext context, String header) {
    CPASAdCreationTemplate cpasAdCreationTemplate = getGson().fromJson(json, CPASAdCreationTemplate.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(cpasAdCreationTemplate.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    cpasAdCreationTemplate.context = context;
    cpasAdCreationTemplate.rawValue = json;
    cpasAdCreationTemplate.header = header;
    return cpasAdCreationTemplate;
  }

  public static APINodeList<CPASAdCreationTemplate> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CPASAdCreationTemplate> cpasAdCreationTemplates = new APINodeList<CPASAdCreationTemplate>(request, json, header);
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
          cpasAdCreationTemplates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return cpasAdCreationTemplates;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                cpasAdCreationTemplates.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            cpasAdCreationTemplates.setPaging(previous, next);
            if (context.hasAppSecret()) {
              cpasAdCreationTemplates.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              cpasAdCreationTemplates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  cpasAdCreationTemplates.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              cpasAdCreationTemplates.add(loadJSON(obj.toString(), context, header));
            }
          }
          return cpasAdCreationTemplates;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              cpasAdCreationTemplates.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return cpasAdCreationTemplates;
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
              cpasAdCreationTemplates.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return cpasAdCreationTemplates;
          }

          // Sixth, check if it's pure JsonObject
          cpasAdCreationTemplates.clear();
          cpasAdCreationTemplates.add(loadJSON(json, context, header));
          return cpasAdCreationTemplates;
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


  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsUnusedTemplate() {
    return mIsUnusedTemplate;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldOptimizationGoal() {
    return mOptimizationGoal;
  }

  public String getFieldTargetingType() {
    return mTargetingType;
  }

  public String getFieldTemplateType() {
    return mTemplateType;
  }



  public static class APIRequestGet extends APIRequest<CPASAdCreationTemplate> {

    CPASAdCreationTemplate lastResponse = null;
    @Override
    public CPASAdCreationTemplate getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "description",
      "id",
      "is_unused_template",
      "name",
      "optimization_goal",
      "targeting_type",
      "template_type",
    };

    @Override
    public CPASAdCreationTemplate parseResponse(String response, String header) throws APIException {
      return CPASAdCreationTemplate.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASAdCreationTemplate execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASAdCreationTemplate execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASAdCreationTemplate> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASAdCreationTemplate> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASAdCreationTemplate>() {
           public CPASAdCreationTemplate apply(ResponseWrapper result) {
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

    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsUnusedTemplateField () {
      return this.requestIsUnusedTemplateField(true);
    }
    public APIRequestGet requestIsUnusedTemplateField (boolean value) {
      this.requestField("is_unused_template", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGet requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGet requestTargetingTypeField () {
      return this.requestTargetingTypeField(true);
    }
    public APIRequestGet requestTargetingTypeField (boolean value) {
      this.requestField("targeting_type", value);
      return this;
    }
    public APIRequestGet requestTemplateTypeField () {
      return this.requestTemplateTypeField(true);
    }
    public APIRequestGet requestTemplateTypeField (boolean value) {
      this.requestField("template_type", value);
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

  public CPASAdCreationTemplate copyFrom(CPASAdCreationTemplate instance) {
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mIsUnusedTemplate = instance.mIsUnusedTemplate;
    this.mName = instance.mName;
    this.mOptimizationGoal = instance.mOptimizationGoal;
    this.mTargetingType = instance.mTargetingType;
    this.mTemplateType = instance.mTemplateType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CPASAdCreationTemplate> getParser() {
    return new APIRequest.ResponseParser<CPASAdCreationTemplate>() {
      public APINodeList<CPASAdCreationTemplate> parseResponse(String response, APIContext context, APIRequest<CPASAdCreationTemplate> request, String header) throws MalformedResponseException {
        return CPASAdCreationTemplate.parseResponse(response, context, request, header);
      }
    };
  }
}
