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
public class Robot extends APINode {
  @SerializedName("bringup_vars")
  private List<Map<String, String>> mBringupVars = null;
  @SerializedName("configurations")
  private List<Map<String, String>> mConfigurations = null;
  @SerializedName("data_center")
  private String mDataCenter = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("init_pos")
  private List<Map<String, Double>> mInitPos = null;
  @SerializedName("last_pos")
  private List<Map<String, Double>> mLastPos = null;
  @SerializedName("meetup_link_hash")
  private String mMeetupLinkHash = null;
  @SerializedName("suite")
  private String mSuite = null;
  @SerializedName("target_map_image_uri")
  private String mTargetMapImageUri = null;
  @SerializedName("target_os_image_uri")
  private String mTargetOsImageUri = null;
  @SerializedName("target_sw_image_uri")
  private String mTargetSwImageUri = null;
  @SerializedName("user")
  private User mUser = null;
  protected static Gson gson = null;

  Robot() {
  }

  public Robot(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Robot(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Robot fetch() throws APIException{
    Robot newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Robot fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Robot> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Robot fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Robot> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Robot> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Robot>)(
      new APIRequest<Robot>(context, "", "/", "GET", Robot.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Robot>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Robot.getParser())
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
  public static Robot loadJSON(String json, APIContext context, String header) {
    Robot robot = getGson().fromJson(json, Robot.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(robot.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    robot.context = context;
    robot.rawValue = json;
    robot.header = header;
    return robot;
  }

  public static APINodeList<Robot> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Robot> robots = new APINodeList<Robot>(request, json, header);
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
          robots.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return robots;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                robots.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            robots.setPaging(previous, next);
            if (context.hasAppSecret()) {
              robots.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              robots.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  robots.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              robots.add(loadJSON(obj.toString(), context, header));
            }
          }
          return robots;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              robots.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return robots;
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
              robots.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return robots;
          }

          // Sixth, check if it's pure JsonObject
          robots.clear();
          robots.add(loadJSON(json, context, header));
          return robots;
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


  public List<Map<String, String>> getFieldBringupVars() {
    return mBringupVars;
  }

  public List<Map<String, String>> getFieldConfigurations() {
    return mConfigurations;
  }

  public String getFieldDataCenter() {
    return mDataCenter;
  }

  public String getFieldId() {
    return mId;
  }

  public List<Map<String, Double>> getFieldInitPos() {
    return mInitPos;
  }

  public List<Map<String, Double>> getFieldLastPos() {
    return mLastPos;
  }

  public String getFieldMeetupLinkHash() {
    return mMeetupLinkHash;
  }

  public String getFieldSuite() {
    return mSuite;
  }

  public String getFieldTargetMapImageUri() {
    return mTargetMapImageUri;
  }

  public String getFieldTargetOsImageUri() {
    return mTargetOsImageUri;
  }

  public String getFieldTargetSwImageUri() {
    return mTargetSwImageUri;
  }

  public User getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }



  public static class APIRequestGet extends APIRequest<Robot> {

    Robot lastResponse = null;
    @Override
    public Robot getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "bringup_vars",
      "configurations",
      "data_center",
      "id",
      "init_pos",
      "last_pos",
      "meetup_link_hash",
      "suite",
      "target_map_image_uri",
      "target_os_image_uri",
      "target_sw_image_uri",
      "user",
    };

    @Override
    public Robot parseResponse(String response, String header) throws APIException {
      return Robot.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Robot execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Robot execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Robot> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Robot> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Robot>() {
           public Robot apply(ResponseWrapper result) {
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

    public APIRequestGet requestBringupVarsField () {
      return this.requestBringupVarsField(true);
    }
    public APIRequestGet requestBringupVarsField (boolean value) {
      this.requestField("bringup_vars", value);
      return this;
    }
    public APIRequestGet requestConfigurationsField () {
      return this.requestConfigurationsField(true);
    }
    public APIRequestGet requestConfigurationsField (boolean value) {
      this.requestField("configurations", value);
      return this;
    }
    public APIRequestGet requestDataCenterField () {
      return this.requestDataCenterField(true);
    }
    public APIRequestGet requestDataCenterField (boolean value) {
      this.requestField("data_center", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInitPosField () {
      return this.requestInitPosField(true);
    }
    public APIRequestGet requestInitPosField (boolean value) {
      this.requestField("init_pos", value);
      return this;
    }
    public APIRequestGet requestLastPosField () {
      return this.requestLastPosField(true);
    }
    public APIRequestGet requestLastPosField (boolean value) {
      this.requestField("last_pos", value);
      return this;
    }
    public APIRequestGet requestMeetupLinkHashField () {
      return this.requestMeetupLinkHashField(true);
    }
    public APIRequestGet requestMeetupLinkHashField (boolean value) {
      this.requestField("meetup_link_hash", value);
      return this;
    }
    public APIRequestGet requestSuiteField () {
      return this.requestSuiteField(true);
    }
    public APIRequestGet requestSuiteField (boolean value) {
      this.requestField("suite", value);
      return this;
    }
    public APIRequestGet requestTargetMapImageUriField () {
      return this.requestTargetMapImageUriField(true);
    }
    public APIRequestGet requestTargetMapImageUriField (boolean value) {
      this.requestField("target_map_image_uri", value);
      return this;
    }
    public APIRequestGet requestTargetOsImageUriField () {
      return this.requestTargetOsImageUriField(true);
    }
    public APIRequestGet requestTargetOsImageUriField (boolean value) {
      this.requestField("target_os_image_uri", value);
      return this;
    }
    public APIRequestGet requestTargetSwImageUriField () {
      return this.requestTargetSwImageUriField(true);
    }
    public APIRequestGet requestTargetSwImageUriField (boolean value) {
      this.requestField("target_sw_image_uri", value);
      return this;
    }
    public APIRequestGet requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGet requestUserField (boolean value) {
      this.requestField("user", value);
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

  public Robot copyFrom(Robot instance) {
    this.mBringupVars = instance.mBringupVars;
    this.mConfigurations = instance.mConfigurations;
    this.mDataCenter = instance.mDataCenter;
    this.mId = instance.mId;
    this.mInitPos = instance.mInitPos;
    this.mLastPos = instance.mLastPos;
    this.mMeetupLinkHash = instance.mMeetupLinkHash;
    this.mSuite = instance.mSuite;
    this.mTargetMapImageUri = instance.mTargetMapImageUri;
    this.mTargetOsImageUri = instance.mTargetOsImageUri;
    this.mTargetSwImageUri = instance.mTargetSwImageUri;
    this.mUser = instance.mUser;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Robot> getParser() {
    return new APIRequest.ResponseParser<Robot>() {
      public APINodeList<Robot> parseResponse(String response, APIContext context, APIRequest<Robot> request, String header) throws MalformedResponseException {
        return Robot.parseResponse(response, context, request, header);
      }
    };
  }
}
