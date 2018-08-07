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
public class UnifiedThread extends APINode {
  @SerializedName("can_reply")
  private Boolean mCanReply = null;
  @SerializedName("former_participants")
  private Object mFormerParticipants = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_subscribed")
  private Boolean mIsSubscribed = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("message_count")
  private Long mMessageCount = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("participants")
  private Object mParticipants = null;
  @SerializedName("scoped_thread_key")
  private String mScopedThreadKey = null;
  @SerializedName("senders")
  private Object mSenders = null;
  @SerializedName("snippet")
  private String mSnippet = null;
  @SerializedName("subject")
  private String mSubject = null;
  @SerializedName("unread_count")
  private Long mUnreadCount = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("wallpaper")
  private String mWallpaper = null;
  protected static Gson gson = null;

  UnifiedThread() {
  }

  public UnifiedThread(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public UnifiedThread(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public UnifiedThread fetch() throws APIException{
    UnifiedThread newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static UnifiedThread fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<UnifiedThread> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static UnifiedThread fetchById(String id, APIContext context) throws APIException {
    UnifiedThread unifiedThread =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return unifiedThread;
  }

  public static ListenableFuture<UnifiedThread> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<UnifiedThread> unifiedThread =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return unifiedThread;
  }

  public static APINodeList<UnifiedThread> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<UnifiedThread>)(
      new APIRequest<UnifiedThread>(context, "", "/", "GET", UnifiedThread.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<UnifiedThread>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<UnifiedThread>> unifiedThread =
      new APIRequest(context, "", "/", "GET", UnifiedThread.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return unifiedThread;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static UnifiedThread loadJSON(String json, APIContext context) {
    UnifiedThread unifiedThread = getGson().fromJson(json, UnifiedThread.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(unifiedThread.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    unifiedThread.context = context;
    unifiedThread.rawValue = json;
    return unifiedThread;
  }

  public static APINodeList<UnifiedThread> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<UnifiedThread> unifiedThreads = new APINodeList<UnifiedThread>(request, json);
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
          unifiedThreads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return unifiedThreads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                unifiedThreads.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            unifiedThreads.setPaging(previous, next);
            if (context.hasAppSecret()) {
              unifiedThreads.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              unifiedThreads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  unifiedThreads.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              unifiedThreads.add(loadJSON(obj.toString(), context));
            }
          }
          return unifiedThreads;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              unifiedThreads.add(loadJSON(entry.getValue().toString(), context));
          }
          return unifiedThreads;
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
              unifiedThreads.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return unifiedThreads;
          }

          // Sixth, check if it's pure JsonObject
          unifiedThreads.clear();
          unifiedThreads.add(loadJSON(json, context));
          return unifiedThreads;
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


  public Boolean getFieldCanReply() {
    return mCanReply;
  }

  public Object getFieldFormerParticipants() {
    return mFormerParticipants;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsSubscribed() {
    return mIsSubscribed;
  }

  public String getFieldLink() {
    return mLink;
  }

  public Long getFieldMessageCount() {
    return mMessageCount;
  }

  public String getFieldName() {
    return mName;
  }

  public Object getFieldParticipants() {
    return mParticipants;
  }

  public String getFieldScopedThreadKey() {
    return mScopedThreadKey;
  }

  public Object getFieldSenders() {
    return mSenders;
  }

  public String getFieldSnippet() {
    return mSnippet;
  }

  public String getFieldSubject() {
    return mSubject;
  }

  public Long getFieldUnreadCount() {
    return mUnreadCount;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public String getFieldWallpaper() {
    return mWallpaper;
  }



  public static class APIRequestGet extends APIRequest<UnifiedThread> {

    UnifiedThread lastResponse = null;
    @Override
    public UnifiedThread getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "can_reply",
      "former_participants",
      "id",
      "is_subscribed",
      "link",
      "message_count",
      "name",
      "participants",
      "scoped_thread_key",
      "senders",
      "snippet",
      "subject",
      "unread_count",
      "updated_time",
      "wallpaper",
    };

    @Override
    public UnifiedThread parseResponse(String response) throws APIException {
      return UnifiedThread.parseResponse(response, getContext(), this).head();
    }

    @Override
    public UnifiedThread execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public UnifiedThread execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<UnifiedThread> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<UnifiedThread> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, UnifiedThread>() {
           public UnifiedThread apply(String result) {
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

    public APIRequestGet requestCanReplyField () {
      return this.requestCanReplyField(true);
    }
    public APIRequestGet requestCanReplyField (boolean value) {
      this.requestField("can_reply", value);
      return this;
    }
    public APIRequestGet requestFormerParticipantsField () {
      return this.requestFormerParticipantsField(true);
    }
    public APIRequestGet requestFormerParticipantsField (boolean value) {
      this.requestField("former_participants", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsSubscribedField () {
      return this.requestIsSubscribedField(true);
    }
    public APIRequestGet requestIsSubscribedField (boolean value) {
      this.requestField("is_subscribed", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestMessageCountField () {
      return this.requestMessageCountField(true);
    }
    public APIRequestGet requestMessageCountField (boolean value) {
      this.requestField("message_count", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestParticipantsField () {
      return this.requestParticipantsField(true);
    }
    public APIRequestGet requestParticipantsField (boolean value) {
      this.requestField("participants", value);
      return this;
    }
    public APIRequestGet requestScopedThreadKeyField () {
      return this.requestScopedThreadKeyField(true);
    }
    public APIRequestGet requestScopedThreadKeyField (boolean value) {
      this.requestField("scoped_thread_key", value);
      return this;
    }
    public APIRequestGet requestSendersField () {
      return this.requestSendersField(true);
    }
    public APIRequestGet requestSendersField (boolean value) {
      this.requestField("senders", value);
      return this;
    }
    public APIRequestGet requestSnippetField () {
      return this.requestSnippetField(true);
    }
    public APIRequestGet requestSnippetField (boolean value) {
      this.requestField("snippet", value);
      return this;
    }
    public APIRequestGet requestSubjectField () {
      return this.requestSubjectField(true);
    }
    public APIRequestGet requestSubjectField (boolean value) {
      this.requestField("subject", value);
      return this;
    }
    public APIRequestGet requestUnreadCountField () {
      return this.requestUnreadCountField(true);
    }
    public APIRequestGet requestUnreadCountField (boolean value) {
      this.requestField("unread_count", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestWallpaperField () {
      return this.requestWallpaperField(true);
    }
    public APIRequestGet requestWallpaperField (boolean value) {
      this.requestField("wallpaper", value);
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

  public UnifiedThread copyFrom(UnifiedThread instance) {
    this.mCanReply = instance.mCanReply;
    this.mFormerParticipants = instance.mFormerParticipants;
    this.mId = instance.mId;
    this.mIsSubscribed = instance.mIsSubscribed;
    this.mLink = instance.mLink;
    this.mMessageCount = instance.mMessageCount;
    this.mName = instance.mName;
    this.mParticipants = instance.mParticipants;
    this.mScopedThreadKey = instance.mScopedThreadKey;
    this.mSenders = instance.mSenders;
    this.mSnippet = instance.mSnippet;
    this.mSubject = instance.mSubject;
    this.mUnreadCount = instance.mUnreadCount;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mWallpaper = instance.mWallpaper;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<UnifiedThread> getParser() {
    return new APIRequest.ResponseParser<UnifiedThread>() {
      public APINodeList<UnifiedThread> parseResponse(String response, APIContext context, APIRequest<UnifiedThread> request) throws MalformedResponseException {
        return UnifiedThread.parseResponse(response, context, request);
      }
    };
  }
}
