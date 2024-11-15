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
public class MessengerBusinessTemplate extends APINode {
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("components")
  private List<Object> mComponents = null;
  @SerializedName("creation_time")
  private Long mCreationTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("language")
  private String mLanguage = null;
  @SerializedName("language_count")
  private Long mLanguageCount = null;
  @SerializedName("last_updated_time")
  private String mLastUpdatedTime = null;
  @SerializedName("library_template_name")
  private String mLibraryTemplateName = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("rejected_reason")
  private String mRejectedReason = null;
  @SerializedName("status")
  private String mStatus = null;
  protected static Gson gson = null;

  MessengerBusinessTemplate() {
  }

  public MessengerBusinessTemplate(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MessengerBusinessTemplate(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MessengerBusinessTemplate fetch() throws APIException{
    MessengerBusinessTemplate newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MessengerBusinessTemplate fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MessengerBusinessTemplate> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MessengerBusinessTemplate fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MessengerBusinessTemplate> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MessengerBusinessTemplate> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MessengerBusinessTemplate>)(
      new APIRequest<MessengerBusinessTemplate>(context, "", "/", "GET", MessengerBusinessTemplate.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MessengerBusinessTemplate>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MessengerBusinessTemplate.getParser())
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
  public static MessengerBusinessTemplate loadJSON(String json, APIContext context, String header) {
    MessengerBusinessTemplate messengerBusinessTemplate = getGson().fromJson(json, MessengerBusinessTemplate.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(messengerBusinessTemplate.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    messengerBusinessTemplate.context = context;
    messengerBusinessTemplate.rawValue = json;
    messengerBusinessTemplate.header = header;
    return messengerBusinessTemplate;
  }

  public static APINodeList<MessengerBusinessTemplate> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MessengerBusinessTemplate> messengerBusinessTemplates = new APINodeList<MessengerBusinessTemplate>(request, json, header);
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
          messengerBusinessTemplates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return messengerBusinessTemplates;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                messengerBusinessTemplates.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            messengerBusinessTemplates.setPaging(previous, next);
            if (context.hasAppSecret()) {
              messengerBusinessTemplates.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              messengerBusinessTemplates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  messengerBusinessTemplates.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              messengerBusinessTemplates.add(loadJSON(obj.toString(), context, header));
            }
          }
          return messengerBusinessTemplates;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              messengerBusinessTemplates.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return messengerBusinessTemplates;
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
              messengerBusinessTemplates.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return messengerBusinessTemplates;
          }

          // Sixth, check if it's pure JsonObject
          messengerBusinessTemplates.clear();
          messengerBusinessTemplates.add(loadJSON(json, context, header));
          return messengerBusinessTemplates;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldCategory() {
    return mCategory;
  }

  public List<Object> getFieldComponents() {
    return mComponents;
  }

  public Long getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLanguage() {
    return mLanguage;
  }

  public Long getFieldLanguageCount() {
    return mLanguageCount;
  }

  public String getFieldLastUpdatedTime() {
    return mLastUpdatedTime;
  }

  public String getFieldLibraryTemplateName() {
    return mLibraryTemplateName;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldRejectedReason() {
    return mRejectedReason;
  }

  public String getFieldStatus() {
    return mStatus;
  }



  public static class APIRequestGet extends APIRequest<MessengerBusinessTemplate> {

    MessengerBusinessTemplate lastResponse = null;
    @Override
    public MessengerBusinessTemplate getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "category",
      "components",
      "creation_time",
      "id",
      "language",
      "language_count",
      "last_updated_time",
      "library_template_name",
      "name",
      "rejected_reason",
      "status",
    };

    @Override
    public MessengerBusinessTemplate parseResponse(String response, String header) throws APIException {
      return MessengerBusinessTemplate.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MessengerBusinessTemplate execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MessengerBusinessTemplate execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MessengerBusinessTemplate> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MessengerBusinessTemplate> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MessengerBusinessTemplate>() {
           public MessengerBusinessTemplate apply(ResponseWrapper result) {
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

    public APIRequestGet requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGet requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGet requestComponentsField () {
      return this.requestComponentsField(true);
    }
    public APIRequestGet requestComponentsField (boolean value) {
      this.requestField("components", value);
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
    public APIRequestGet requestLanguageField () {
      return this.requestLanguageField(true);
    }
    public APIRequestGet requestLanguageField (boolean value) {
      this.requestField("language", value);
      return this;
    }
    public APIRequestGet requestLanguageCountField () {
      return this.requestLanguageCountField(true);
    }
    public APIRequestGet requestLanguageCountField (boolean value) {
      this.requestField("language_count", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedTimeField () {
      return this.requestLastUpdatedTimeField(true);
    }
    public APIRequestGet requestLastUpdatedTimeField (boolean value) {
      this.requestField("last_updated_time", value);
      return this;
    }
    public APIRequestGet requestLibraryTemplateNameField () {
      return this.requestLibraryTemplateNameField(true);
    }
    public APIRequestGet requestLibraryTemplateNameField (boolean value) {
      this.requestField("library_template_name", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestRejectedReasonField () {
      return this.requestRejectedReasonField(true);
    }
    public APIRequestGet requestRejectedReasonField (boolean value) {
      this.requestField("rejected_reason", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<MessengerBusinessTemplate> {

    MessengerBusinessTemplate lastResponse = null;
    @Override
    public MessengerBusinessTemplate getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "components",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MessengerBusinessTemplate parseResponse(String response, String header) throws APIException {
      return MessengerBusinessTemplate.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MessengerBusinessTemplate execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MessengerBusinessTemplate execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MessengerBusinessTemplate> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MessengerBusinessTemplate> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MessengerBusinessTemplate>() {
           public MessengerBusinessTemplate apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setComponents (List<Map<String, String>> components) {
      this.setParam("components", components);
      return this;
    }
    public APIRequestUpdate setComponents (String components) {
      this.setParam("components", components);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumStatus {
      @SerializedName("APPROVED")
      VALUE_APPROVED("APPROVED"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("DISABLED")
      VALUE_DISABLED("DISABLED"),
      @SerializedName("IN_APPEAL")
      VALUE_IN_APPEAL("IN_APPEAL"),
      @SerializedName("LIMIT_EXCEEDED")
      VALUE_LIMIT_EXCEEDED("LIMIT_EXCEEDED"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("PENDING_DELETION")
      VALUE_PENDING_DELETION("PENDING_DELETION"),
      @SerializedName("REJECTED")
      VALUE_REJECTED("REJECTED"),
      ;

      private String value;

      private EnumStatus(String value) {
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

  public MessengerBusinessTemplate copyFrom(MessengerBusinessTemplate instance) {
    this.mCategory = instance.mCategory;
    this.mComponents = instance.mComponents;
    this.mCreationTime = instance.mCreationTime;
    this.mId = instance.mId;
    this.mLanguage = instance.mLanguage;
    this.mLanguageCount = instance.mLanguageCount;
    this.mLastUpdatedTime = instance.mLastUpdatedTime;
    this.mLibraryTemplateName = instance.mLibraryTemplateName;
    this.mName = instance.mName;
    this.mRejectedReason = instance.mRejectedReason;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MessengerBusinessTemplate> getParser() {
    return new APIRequest.ResponseParser<MessengerBusinessTemplate>() {
      public APINodeList<MessengerBusinessTemplate> parseResponse(String response, APIContext context, APIRequest<MessengerBusinessTemplate> request, String header) throws MalformedResponseException {
        return MessengerBusinessTemplate.parseResponse(response, context, request, header);
      }
    };
  }
}
