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
public class UserPageOneTimeOptInTokenSettings extends APINode {
  @SerializedName("creation_timestamp")
  private Long mCreationTimestamp = null;
  @SerializedName("next_eligible_time")
  private Long mNextEligibleTime = null;
  @SerializedName("notification_messages_frequency")
  private String mNotificationMessagesFrequency = null;
  @SerializedName("notification_messages_reoptin")
  private String mNotificationMessagesReoptin = null;
  @SerializedName("notification_messages_timezone")
  private String mNotificationMessagesTimezone = null;
  @SerializedName("notification_messages_token")
  private String mNotificationMessagesToken = null;
  @SerializedName("recipient_id")
  private String mRecipientId = null;
  @SerializedName("token_expiry_timestamp")
  private Long mTokenExpiryTimestamp = null;
  @SerializedName("topic_title")
  private String mTopicTitle = null;
  @SerializedName("user_token_status")
  private String mUserTokenStatus = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  UserPageOneTimeOptInTokenSettings() {
  }

  public UserPageOneTimeOptInTokenSettings(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public UserPageOneTimeOptInTokenSettings(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public UserPageOneTimeOptInTokenSettings fetch() throws APIException{
    UserPageOneTimeOptInTokenSettings newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static UserPageOneTimeOptInTokenSettings fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<UserPageOneTimeOptInTokenSettings> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static UserPageOneTimeOptInTokenSettings fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<UserPageOneTimeOptInTokenSettings> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<UserPageOneTimeOptInTokenSettings> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<UserPageOneTimeOptInTokenSettings>)(
      new APIRequest<UserPageOneTimeOptInTokenSettings>(context, "", "/", "GET", UserPageOneTimeOptInTokenSettings.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<UserPageOneTimeOptInTokenSettings>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", UserPageOneTimeOptInTokenSettings.getParser())
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
  public static UserPageOneTimeOptInTokenSettings loadJSON(String json, APIContext context, String header) {
    UserPageOneTimeOptInTokenSettings userPageOneTimeOptInTokenSettings = getGson().fromJson(json, UserPageOneTimeOptInTokenSettings.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(userPageOneTimeOptInTokenSettings.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    userPageOneTimeOptInTokenSettings.context = context;
    userPageOneTimeOptInTokenSettings.rawValue = json;
    userPageOneTimeOptInTokenSettings.header = header;
    return userPageOneTimeOptInTokenSettings;
  }

  public static APINodeList<UserPageOneTimeOptInTokenSettings> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<UserPageOneTimeOptInTokenSettings> userPageOneTimeOptInTokenSettingss = new APINodeList<UserPageOneTimeOptInTokenSettings>(request, json, header);
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
          userPageOneTimeOptInTokenSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return userPageOneTimeOptInTokenSettingss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                userPageOneTimeOptInTokenSettingss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            userPageOneTimeOptInTokenSettingss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              userPageOneTimeOptInTokenSettingss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              userPageOneTimeOptInTokenSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  userPageOneTimeOptInTokenSettingss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              userPageOneTimeOptInTokenSettingss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return userPageOneTimeOptInTokenSettingss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              userPageOneTimeOptInTokenSettingss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return userPageOneTimeOptInTokenSettingss;
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
              userPageOneTimeOptInTokenSettingss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return userPageOneTimeOptInTokenSettingss;
          }

          // Sixth, check if it's pure JsonObject
          userPageOneTimeOptInTokenSettingss.clear();
          userPageOneTimeOptInTokenSettingss.add(loadJSON(json, context, header));
          return userPageOneTimeOptInTokenSettingss;
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


  public Long getFieldCreationTimestamp() {
    return mCreationTimestamp;
  }

  public Long getFieldNextEligibleTime() {
    return mNextEligibleTime;
  }

  public String getFieldNotificationMessagesFrequency() {
    return mNotificationMessagesFrequency;
  }

  public String getFieldNotificationMessagesReoptin() {
    return mNotificationMessagesReoptin;
  }

  public String getFieldNotificationMessagesTimezone() {
    return mNotificationMessagesTimezone;
  }

  public String getFieldNotificationMessagesToken() {
    return mNotificationMessagesToken;
  }

  public String getFieldRecipientId() {
    return mRecipientId;
  }

  public Long getFieldTokenExpiryTimestamp() {
    return mTokenExpiryTimestamp;
  }

  public String getFieldTopicTitle() {
    return mTopicTitle;
  }

  public String getFieldUserTokenStatus() {
    return mUserTokenStatus;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<UserPageOneTimeOptInTokenSettings> {

    UserPageOneTimeOptInTokenSettings lastResponse = null;
    @Override
    public UserPageOneTimeOptInTokenSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_timestamp",
      "next_eligible_time",
      "notification_messages_frequency",
      "notification_messages_reoptin",
      "notification_messages_timezone",
      "notification_messages_token",
      "recipient_id",
      "token_expiry_timestamp",
      "topic_title",
      "user_token_status",
      "id",
    };

    @Override
    public UserPageOneTimeOptInTokenSettings parseResponse(String response, String header) throws APIException {
      return UserPageOneTimeOptInTokenSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public UserPageOneTimeOptInTokenSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public UserPageOneTimeOptInTokenSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<UserPageOneTimeOptInTokenSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<UserPageOneTimeOptInTokenSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, UserPageOneTimeOptInTokenSettings>() {
           public UserPageOneTimeOptInTokenSettings apply(ResponseWrapper result) {
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

    public APIRequestGet requestCreationTimestampField () {
      return this.requestCreationTimestampField(true);
    }
    public APIRequestGet requestCreationTimestampField (boolean value) {
      this.requestField("creation_timestamp", value);
      return this;
    }
    public APIRequestGet requestNextEligibleTimeField () {
      return this.requestNextEligibleTimeField(true);
    }
    public APIRequestGet requestNextEligibleTimeField (boolean value) {
      this.requestField("next_eligible_time", value);
      return this;
    }
    public APIRequestGet requestNotificationMessagesFrequencyField () {
      return this.requestNotificationMessagesFrequencyField(true);
    }
    public APIRequestGet requestNotificationMessagesFrequencyField (boolean value) {
      this.requestField("notification_messages_frequency", value);
      return this;
    }
    public APIRequestGet requestNotificationMessagesReoptinField () {
      return this.requestNotificationMessagesReoptinField(true);
    }
    public APIRequestGet requestNotificationMessagesReoptinField (boolean value) {
      this.requestField("notification_messages_reoptin", value);
      return this;
    }
    public APIRequestGet requestNotificationMessagesTimezoneField () {
      return this.requestNotificationMessagesTimezoneField(true);
    }
    public APIRequestGet requestNotificationMessagesTimezoneField (boolean value) {
      this.requestField("notification_messages_timezone", value);
      return this;
    }
    public APIRequestGet requestNotificationMessagesTokenField () {
      return this.requestNotificationMessagesTokenField(true);
    }
    public APIRequestGet requestNotificationMessagesTokenField (boolean value) {
      this.requestField("notification_messages_token", value);
      return this;
    }
    public APIRequestGet requestRecipientIdField () {
      return this.requestRecipientIdField(true);
    }
    public APIRequestGet requestRecipientIdField (boolean value) {
      this.requestField("recipient_id", value);
      return this;
    }
    public APIRequestGet requestTokenExpiryTimestampField () {
      return this.requestTokenExpiryTimestampField(true);
    }
    public APIRequestGet requestTokenExpiryTimestampField (boolean value) {
      this.requestField("token_expiry_timestamp", value);
      return this;
    }
    public APIRequestGet requestTopicTitleField () {
      return this.requestTopicTitleField(true);
    }
    public APIRequestGet requestTopicTitleField (boolean value) {
      this.requestField("topic_title", value);
      return this;
    }
    public APIRequestGet requestUserTokenStatusField () {
      return this.requestUserTokenStatusField(true);
    }
    public APIRequestGet requestUserTokenStatusField (boolean value) {
      this.requestField("user_token_status", value);
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

  public UserPageOneTimeOptInTokenSettings copyFrom(UserPageOneTimeOptInTokenSettings instance) {
    this.mCreationTimestamp = instance.mCreationTimestamp;
    this.mNextEligibleTime = instance.mNextEligibleTime;
    this.mNotificationMessagesFrequency = instance.mNotificationMessagesFrequency;
    this.mNotificationMessagesReoptin = instance.mNotificationMessagesReoptin;
    this.mNotificationMessagesTimezone = instance.mNotificationMessagesTimezone;
    this.mNotificationMessagesToken = instance.mNotificationMessagesToken;
    this.mRecipientId = instance.mRecipientId;
    this.mTokenExpiryTimestamp = instance.mTokenExpiryTimestamp;
    this.mTopicTitle = instance.mTopicTitle;
    this.mUserTokenStatus = instance.mUserTokenStatus;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<UserPageOneTimeOptInTokenSettings> getParser() {
    return new APIRequest.ResponseParser<UserPageOneTimeOptInTokenSettings>() {
      public APINodeList<UserPageOneTimeOptInTokenSettings> parseResponse(String response, APIContext context, APIRequest<UserPageOneTimeOptInTokenSettings> request, String header) throws MalformedResponseException {
        return UserPageOneTimeOptInTokenSettings.parseResponse(response, context, request, header);
      }
    };
  }
}
