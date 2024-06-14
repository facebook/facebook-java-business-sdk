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
public class EducationExperience extends APINode {
  @SerializedName("classes")
  private List<Experience> mClasses = null;
  @SerializedName("concentration")
  private List<Page> mConcentration = null;
  @SerializedName("degree")
  private Page mDegree = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("school")
  private Page mSchool = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("with")
  private List<User> mWith = null;
  @SerializedName("year")
  private Page mYear = null;
  protected static Gson gson = null;

  EducationExperience() {
  }

  public EducationExperience(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public EducationExperience(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public EducationExperience fetch() throws APIException{
    EducationExperience newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static EducationExperience fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<EducationExperience> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static EducationExperience fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<EducationExperience> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<EducationExperience> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<EducationExperience>)(
      new APIRequest<EducationExperience>(context, "", "/", "GET", EducationExperience.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<EducationExperience>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", EducationExperience.getParser())
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
  public static EducationExperience loadJSON(String json, APIContext context, String header) {
    EducationExperience educationExperience = getGson().fromJson(json, EducationExperience.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(educationExperience.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    educationExperience.context = context;
    educationExperience.rawValue = json;
    educationExperience.header = header;
    return educationExperience;
  }

  public static APINodeList<EducationExperience> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<EducationExperience> educationExperiences = new APINodeList<EducationExperience>(request, json, header);
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
          educationExperiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return educationExperiences;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                educationExperiences.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            educationExperiences.setPaging(previous, next);
            if (context.hasAppSecret()) {
              educationExperiences.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              educationExperiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  educationExperiences.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              educationExperiences.add(loadJSON(obj.toString(), context, header));
            }
          }
          return educationExperiences;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              educationExperiences.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return educationExperiences;
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
              educationExperiences.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return educationExperiences;
          }

          // Sixth, check if it's pure JsonObject
          educationExperiences.clear();
          educationExperiences.add(loadJSON(json, context, header));
          return educationExperiences;
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


  public List<Experience> getFieldClasses() {
    return mClasses;
  }

  public List<Page> getFieldConcentration() {
    return mConcentration;
  }

  public Page getFieldDegree() {
    if (mDegree != null) {
      mDegree.context = getContext();
    }
    return mDegree;
  }

  public String getFieldId() {
    return mId;
  }

  public Page getFieldSchool() {
    if (mSchool != null) {
      mSchool.context = getContext();
    }
    return mSchool;
  }

  public String getFieldType() {
    return mType;
  }

  public List<User> getFieldWith() {
    return mWith;
  }

  public Page getFieldYear() {
    if (mYear != null) {
      mYear.context = getContext();
    }
    return mYear;
  }



  public static class APIRequestGet extends APIRequest<EducationExperience> {

    EducationExperience lastResponse = null;
    @Override
    public EducationExperience getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "classes",
      "concentration",
      "degree",
      "id",
      "school",
      "type",
      "with",
      "year",
    };

    @Override
    public EducationExperience parseResponse(String response, String header) throws APIException {
      return EducationExperience.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public EducationExperience execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public EducationExperience execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<EducationExperience> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<EducationExperience> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, EducationExperience>() {
           public EducationExperience apply(ResponseWrapper result) {
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

    public APIRequestGet requestClassesField () {
      return this.requestClassesField(true);
    }
    public APIRequestGet requestClassesField (boolean value) {
      this.requestField("classes", value);
      return this;
    }
    public APIRequestGet requestConcentrationField () {
      return this.requestConcentrationField(true);
    }
    public APIRequestGet requestConcentrationField (boolean value) {
      this.requestField("concentration", value);
      return this;
    }
    public APIRequestGet requestDegreeField () {
      return this.requestDegreeField(true);
    }
    public APIRequestGet requestDegreeField (boolean value) {
      this.requestField("degree", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestSchoolField () {
      return this.requestSchoolField(true);
    }
    public APIRequestGet requestSchoolField (boolean value) {
      this.requestField("school", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGet requestWithField () {
      return this.requestWithField(true);
    }
    public APIRequestGet requestWithField (boolean value) {
      this.requestField("with", value);
      return this;
    }
    public APIRequestGet requestYearField () {
      return this.requestYearField(true);
    }
    public APIRequestGet requestYearField (boolean value) {
      this.requestField("year", value);
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

  public EducationExperience copyFrom(EducationExperience instance) {
    this.mClasses = instance.mClasses;
    this.mConcentration = instance.mConcentration;
    this.mDegree = instance.mDegree;
    this.mId = instance.mId;
    this.mSchool = instance.mSchool;
    this.mType = instance.mType;
    this.mWith = instance.mWith;
    this.mYear = instance.mYear;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<EducationExperience> getParser() {
    return new APIRequest.ResponseParser<EducationExperience>() {
      public APINodeList<EducationExperience> parseResponse(String response, APIContext context, APIRequest<EducationExperience> request, String header) throws MalformedResponseException {
        return EducationExperience.parseResponse(response, context, request, header);
      }
    };
  }
}
