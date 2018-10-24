/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
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
public class AsyncSession extends APINode {
  @SerializedName("app")
  private Application mApp = null;
  @SerializedName("complete_time")
  private String mCompleteTime = null;
  @SerializedName("error_code")
  private Long mErrorCode = null;
  @SerializedName("exception")
  private String mException = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("method")
  private String mMethod = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("percent_completed")
  private Long mPercentCompleted = null;
  @SerializedName("platform_version")
  private String mPlatformVersion = null;
  @SerializedName("result")
  private String mResult = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("uri")
  private String mUri = null;
  @SerializedName("user")
  private User mUser = null;
  protected static Gson gson = null;

  AsyncSession() {
  }

  public AsyncSession(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AsyncSession(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AsyncSession fetch() throws APIException{
    AsyncSession newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AsyncSession fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AsyncSession> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AsyncSession fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AsyncSession> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AsyncSession> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AsyncSession>)(
      new APIRequest<AsyncSession>(context, "", "/", "GET", AsyncSession.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AsyncSession>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AsyncSession.getParser())
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
  public static AsyncSession loadJSON(String json, APIContext context) {
    AsyncSession asyncSession = getGson().fromJson(json, AsyncSession.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(asyncSession.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    asyncSession.context = context;
    asyncSession.rawValue = json;
    return asyncSession;
  }

  public static APINodeList<AsyncSession> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AsyncSession> asyncSessions = new APINodeList<AsyncSession>(request, json);
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
          asyncSessions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return asyncSessions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                asyncSessions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            asyncSessions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              asyncSessions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              asyncSessions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  asyncSessions.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              asyncSessions.add(loadJSON(obj.toString(), context));
            }
          }
          return asyncSessions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              asyncSessions.add(loadJSON(entry.getValue().toString(), context));
          }
          return asyncSessions;
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
              asyncSessions.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return asyncSessions;
          }

          // Sixth, check if it's pure JsonObject
          asyncSessions.clear();
          asyncSessions.add(loadJSON(json, context));
          return asyncSessions;
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


  public Application getFieldApp() {
    if (mApp != null) {
      mApp.context = getContext();
    }
    return mApp;
  }

  public String getFieldCompleteTime() {
    return mCompleteTime;
  }

  public Long getFieldErrorCode() {
    return mErrorCode;
  }

  public String getFieldException() {
    return mException;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldMethod() {
    return mMethod;
  }

  public String getFieldName() {
    return mName;
  }

  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public Long getFieldPercentCompleted() {
    return mPercentCompleted;
  }

  public String getFieldPlatformVersion() {
    return mPlatformVersion;
  }

  public String getFieldResult() {
    return mResult;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldUri() {
    return mUri;
  }

  public User getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }



  public static class APIRequestGet extends APIRequest<AsyncSession> {

    AsyncSession lastResponse = null;
    @Override
    public AsyncSession getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "app",
      "complete_time",
      "error_code",
      "exception",
      "id",
      "method",
      "name",
      "page",
      "percent_completed",
      "platform_version",
      "result",
      "start_time",
      "status",
      "uri",
      "user",
    };

    @Override
    public AsyncSession parseResponse(String response) throws APIException {
      return AsyncSession.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AsyncSession execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AsyncSession execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AsyncSession> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AsyncSession> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AsyncSession>() {
           public AsyncSession apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGet requestAppField () {
      return this.requestAppField(true);
    }
    public APIRequestGet requestAppField (boolean value) {
      this.requestField("app", value);
      return this;
    }
    public APIRequestGet requestCompleteTimeField () {
      return this.requestCompleteTimeField(true);
    }
    public APIRequestGet requestCompleteTimeField (boolean value) {
      this.requestField("complete_time", value);
      return this;
    }
    public APIRequestGet requestErrorCodeField () {
      return this.requestErrorCodeField(true);
    }
    public APIRequestGet requestErrorCodeField (boolean value) {
      this.requestField("error_code", value);
      return this;
    }
    public APIRequestGet requestExceptionField () {
      return this.requestExceptionField(true);
    }
    public APIRequestGet requestExceptionField (boolean value) {
      this.requestField("exception", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMethodField () {
      return this.requestMethodField(true);
    }
    public APIRequestGet requestMethodField (boolean value) {
      this.requestField("method", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestPercentCompletedField () {
      return this.requestPercentCompletedField(true);
    }
    public APIRequestGet requestPercentCompletedField (boolean value) {
      this.requestField("percent_completed", value);
      return this;
    }
    public APIRequestGet requestPlatformVersionField () {
      return this.requestPlatformVersionField(true);
    }
    public APIRequestGet requestPlatformVersionField (boolean value) {
      this.requestField("platform_version", value);
      return this;
    }
    public APIRequestGet requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGet requestResultField (boolean value) {
      this.requestField("result", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestUriField () {
      return this.requestUriField(true);
    }
    public APIRequestGet requestUriField (boolean value) {
      this.requestField("uri", value);
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

  public AsyncSession copyFrom(AsyncSession instance) {
    this.mApp = instance.mApp;
    this.mCompleteTime = instance.mCompleteTime;
    this.mErrorCode = instance.mErrorCode;
    this.mException = instance.mException;
    this.mId = instance.mId;
    this.mMethod = instance.mMethod;
    this.mName = instance.mName;
    this.mPage = instance.mPage;
    this.mPercentCompleted = instance.mPercentCompleted;
    this.mPlatformVersion = instance.mPlatformVersion;
    this.mResult = instance.mResult;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mUri = instance.mUri;
    this.mUser = instance.mUser;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AsyncSession> getParser() {
    return new APIRequest.ResponseParser<AsyncSession>() {
      public APINodeList<AsyncSession> parseResponse(String response, APIContext context, APIRequest<AsyncSession> request) throws MalformedResponseException {
        return AsyncSession.parseResponse(response, context, request);
      }
    };
  }
}
