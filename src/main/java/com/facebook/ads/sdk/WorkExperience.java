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
public class WorkExperience extends APINode {
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("employer")
  private Page mEmployer = null;
  @SerializedName("end_date")
  private String mEndDate = null;
  @SerializedName("from")
  private User mFrom = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("location")
  private Page mLocation = null;
  @SerializedName("position")
  private Page mPosition = null;
  @SerializedName("projects")
  private List<Object> mProjects = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  @SerializedName("with")
  private List<User> mWith = null;
  protected static Gson gson = null;

  WorkExperience() {
  }

  public WorkExperience(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public WorkExperience(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public WorkExperience fetch() throws APIException{
    WorkExperience newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static WorkExperience fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<WorkExperience> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static WorkExperience fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<WorkExperience> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<WorkExperience> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<WorkExperience>)(
      new APIRequest<WorkExperience>(context, "", "/", "GET", WorkExperience.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<WorkExperience>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", WorkExperience.getParser())
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
  public static WorkExperience loadJSON(String json, APIContext context, String header) {
    WorkExperience workExperience = getGson().fromJson(json, WorkExperience.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(workExperience.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    workExperience.context = context;
    workExperience.rawValue = json;
    workExperience.header = header;
    return workExperience;
  }

  public static APINodeList<WorkExperience> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<WorkExperience> workExperiences = new APINodeList<WorkExperience>(request, json, header);
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
          workExperiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return workExperiences;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                workExperiences.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            workExperiences.setPaging(previous, next);
            if (context.hasAppSecret()) {
              workExperiences.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              workExperiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  workExperiences.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              workExperiences.add(loadJSON(obj.toString(), context, header));
            }
          }
          return workExperiences;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              workExperiences.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return workExperiences;
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
              workExperiences.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return workExperiences;
          }

          // Sixth, check if it's pure JsonObject
          workExperiences.clear();
          workExperiences.add(loadJSON(json, context, header));
          return workExperiences;
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

  public Page getFieldEmployer() {
    if (mEmployer != null) {
      mEmployer.context = getContext();
    }
    return mEmployer;
  }

  public String getFieldEndDate() {
    return mEndDate;
  }

  public User getFieldFrom() {
    if (mFrom != null) {
      mFrom.context = getContext();
    }
    return mFrom;
  }

  public String getFieldId() {
    return mId;
  }

  public Page getFieldLocation() {
    if (mLocation != null) {
      mLocation.context = getContext();
    }
    return mLocation;
  }

  public Page getFieldPosition() {
    if (mPosition != null) {
      mPosition.context = getContext();
    }
    return mPosition;
  }

  public List<Object> getFieldProjects() {
    return mProjects;
  }

  public String getFieldStartDate() {
    return mStartDate;
  }

  public List<User> getFieldWith() {
    return mWith;
  }



  public static class APIRequestGet extends APIRequest<WorkExperience> {

    WorkExperience lastResponse = null;
    @Override
    public WorkExperience getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "description",
      "employer",
      "end_date",
      "from",
      "id",
      "location",
      "position",
      "projects",
      "start_date",
      "with",
    };

    @Override
    public WorkExperience parseResponse(String response, String header) throws APIException {
      return WorkExperience.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WorkExperience execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WorkExperience execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WorkExperience> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WorkExperience> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WorkExperience>() {
           public WorkExperience apply(ResponseWrapper result) {
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
    public APIRequestGet requestEmployerField () {
      return this.requestEmployerField(true);
    }
    public APIRequestGet requestEmployerField (boolean value) {
      this.requestField("employer", value);
      return this;
    }
    public APIRequestGet requestEndDateField () {
      return this.requestEndDateField(true);
    }
    public APIRequestGet requestEndDateField (boolean value) {
      this.requestField("end_date", value);
      return this;
    }
    public APIRequestGet requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGet requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGet requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGet requestPositionField () {
      return this.requestPositionField(true);
    }
    public APIRequestGet requestPositionField (boolean value) {
      this.requestField("position", value);
      return this;
    }
    public APIRequestGet requestProjectsField () {
      return this.requestProjectsField(true);
    }
    public APIRequestGet requestProjectsField (boolean value) {
      this.requestField("projects", value);
      return this;
    }
    public APIRequestGet requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGet requestStartDateField (boolean value) {
      this.requestField("start_date", value);
      return this;
    }
    public APIRequestGet requestWithField () {
      return this.requestWithField(true);
    }
    public APIRequestGet requestWithField (boolean value) {
      this.requestField("with", value);
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

  public WorkExperience copyFrom(WorkExperience instance) {
    this.mDescription = instance.mDescription;
    this.mEmployer = instance.mEmployer;
    this.mEndDate = instance.mEndDate;
    this.mFrom = instance.mFrom;
    this.mId = instance.mId;
    this.mLocation = instance.mLocation;
    this.mPosition = instance.mPosition;
    this.mProjects = instance.mProjects;
    this.mStartDate = instance.mStartDate;
    this.mWith = instance.mWith;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<WorkExperience> getParser() {
    return new APIRequest.ResponseParser<WorkExperience>() {
      public APINodeList<WorkExperience> parseResponse(String response, APIContext context, APIRequest<WorkExperience> request, String header) throws MalformedResponseException {
        return WorkExperience.parseResponse(response, context, request, header);
      }
    };
  }
}
