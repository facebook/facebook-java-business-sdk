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
public class WhitehatFBDLRun extends APINode {
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_pinned")
  private Boolean mIsPinned = null;
  @SerializedName("note")
  private String mNote = null;
  @SerializedName("result")
  private List<Map<String, String>> mResult = null;
  @SerializedName("run_code")
  private String mRunCode = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("user_type")
  private String mUserType = null;
  protected static Gson gson = null;

  WhitehatFBDLRun() {
  }

  public WhitehatFBDLRun(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public WhitehatFBDLRun(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public WhitehatFBDLRun fetch() throws APIException{
    WhitehatFBDLRun newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static WhitehatFBDLRun fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<WhitehatFBDLRun> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static WhitehatFBDLRun fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<WhitehatFBDLRun> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<WhitehatFBDLRun> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<WhitehatFBDLRun>)(
      new APIRequest<WhitehatFBDLRun>(context, "", "/", "GET", WhitehatFBDLRun.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<WhitehatFBDLRun>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", WhitehatFBDLRun.getParser())
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
  public static WhitehatFBDLRun loadJSON(String json, APIContext context, String header) {
    WhitehatFBDLRun whitehatFBDLRun = getGson().fromJson(json, WhitehatFBDLRun.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(whitehatFBDLRun.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    whitehatFBDLRun.context = context;
    whitehatFBDLRun.rawValue = json;
    whitehatFBDLRun.header = header;
    return whitehatFBDLRun;
  }

  public static APINodeList<WhitehatFBDLRun> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<WhitehatFBDLRun> whitehatFBDLRuns = new APINodeList<WhitehatFBDLRun>(request, json, header);
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
          whitehatFBDLRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return whitehatFBDLRuns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                whitehatFBDLRuns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            whitehatFBDLRuns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              whitehatFBDLRuns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              whitehatFBDLRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  whitehatFBDLRuns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              whitehatFBDLRuns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return whitehatFBDLRuns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              whitehatFBDLRuns.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return whitehatFBDLRuns;
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
              whitehatFBDLRuns.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return whitehatFBDLRuns;
          }

          // Sixth, check if it's pure JsonObject
          whitehatFBDLRuns.clear();
          whitehatFBDLRuns.add(loadJSON(json, context, header));
          return whitehatFBDLRuns;
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


  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsPinned() {
    return mIsPinned;
  }

  public String getFieldNote() {
    return mNote;
  }

  public List<Map<String, String>> getFieldResult() {
    return mResult;
  }

  public String getFieldRunCode() {
    return mRunCode;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldUserType() {
    return mUserType;
  }



  public static class APIRequestGet extends APIRequest<WhitehatFBDLRun> {

    WhitehatFBDLRun lastResponse = null;
    @Override
    public WhitehatFBDLRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_time",
      "id",
      "is_pinned",
      "note",
      "result",
      "run_code",
      "status",
      "user_type",
    };

    @Override
    public WhitehatFBDLRun parseResponse(String response, String header) throws APIException {
      return WhitehatFBDLRun.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WhitehatFBDLRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WhitehatFBDLRun execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WhitehatFBDLRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WhitehatFBDLRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WhitehatFBDLRun>() {
           public WhitehatFBDLRun apply(ResponseWrapper result) {
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
    public APIRequestGet requestIsPinnedField () {
      return this.requestIsPinnedField(true);
    }
    public APIRequestGet requestIsPinnedField (boolean value) {
      this.requestField("is_pinned", value);
      return this;
    }
    public APIRequestGet requestNoteField () {
      return this.requestNoteField(true);
    }
    public APIRequestGet requestNoteField (boolean value) {
      this.requestField("note", value);
      return this;
    }
    public APIRequestGet requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGet requestResultField (boolean value) {
      this.requestField("result", value);
      return this;
    }
    public APIRequestGet requestRunCodeField () {
      return this.requestRunCodeField(true);
    }
    public APIRequestGet requestRunCodeField (boolean value) {
      this.requestField("run_code", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestUserTypeField () {
      return this.requestUserTypeField(true);
    }
    public APIRequestGet requestUserTypeField (boolean value) {
      this.requestField("user_type", value);
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

  public WhitehatFBDLRun copyFrom(WhitehatFBDLRun instance) {
    this.mCreationTime = instance.mCreationTime;
    this.mId = instance.mId;
    this.mIsPinned = instance.mIsPinned;
    this.mNote = instance.mNote;
    this.mResult = instance.mResult;
    this.mRunCode = instance.mRunCode;
    this.mStatus = instance.mStatus;
    this.mUserType = instance.mUserType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<WhitehatFBDLRun> getParser() {
    return new APIRequest.ResponseParser<WhitehatFBDLRun>() {
      public APINodeList<WhitehatFBDLRun> parseResponse(String response, APIContext context, APIRequest<WhitehatFBDLRun> request, String header) throws MalformedResponseException {
        return WhitehatFBDLRun.parseResponse(response, context, request, header);
      }
    };
  }
}
