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
public class LiveWithGuestSession extends APINode {
  @SerializedName("conference_name")
  private String mConferenceName = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("participant_call_states")
  private List<Object> mParticipantCallStates = null;
  @SerializedName("server_sdp")
  private String mServerSdp = null;
  protected static Gson gson = null;

  LiveWithGuestSession() {
  }

  public LiveWithGuestSession(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LiveWithGuestSession(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LiveWithGuestSession fetch() throws APIException{
    LiveWithGuestSession newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LiveWithGuestSession fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LiveWithGuestSession> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LiveWithGuestSession fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LiveWithGuestSession> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LiveWithGuestSession> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LiveWithGuestSession>)(
      new APIRequest<LiveWithGuestSession>(context, "", "/", "GET", LiveWithGuestSession.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LiveWithGuestSession>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LiveWithGuestSession.getParser())
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
  public static LiveWithGuestSession loadJSON(String json, APIContext context, String header) {
    LiveWithGuestSession liveWithGuestSession = getGson().fromJson(json, LiveWithGuestSession.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(liveWithGuestSession.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    liveWithGuestSession.context = context;
    liveWithGuestSession.rawValue = json;
    liveWithGuestSession.header = header;
    return liveWithGuestSession;
  }

  public static APINodeList<LiveWithGuestSession> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LiveWithGuestSession> liveWithGuestSessions = new APINodeList<LiveWithGuestSession>(request, json, header);
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
          liveWithGuestSessions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return liveWithGuestSessions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                liveWithGuestSessions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            liveWithGuestSessions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              liveWithGuestSessions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              liveWithGuestSessions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  liveWithGuestSessions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              liveWithGuestSessions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return liveWithGuestSessions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              liveWithGuestSessions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return liveWithGuestSessions;
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
              liveWithGuestSessions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return liveWithGuestSessions;
          }

          // Sixth, check if it's pure JsonObject
          liveWithGuestSessions.clear();
          liveWithGuestSessions.add(loadJSON(json, context, header));
          return liveWithGuestSessions;
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

  public APIRequestCreateHangup createHangup() {
    return new APIRequestCreateHangup(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateJoin createJoin() {
    return new APIRequestCreateJoin(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateRingUser createRingUser() {
    return new APIRequestCreateRingUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldConferenceName() {
    return mConferenceName;
  }

  public String getFieldId() {
    return mId;
  }

  public List<Object> getFieldParticipantCallStates() {
    return mParticipantCallStates;
  }

  public String getFieldServerSdp() {
    return mServerSdp;
  }



  public static class APIRequestCreateHangup extends APIRequest<LiveWithGuestSession> {

    LiveWithGuestSession lastResponse = null;
    @Override
    public LiveWithGuestSession getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LiveWithGuestSession parseResponse(String response, String header) throws APIException {
      return LiveWithGuestSession.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveWithGuestSession execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveWithGuestSession execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveWithGuestSession> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveWithGuestSession> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveWithGuestSession>() {
           public LiveWithGuestSession apply(ResponseWrapper result) {
             try {
               return APIRequestCreateHangup.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateHangup(String nodeId, APIContext context) {
      super(context, nodeId, "/hangup", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateHangup setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateHangup setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateHangup requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateHangup requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHangup requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateHangup requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateHangup requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateHangup requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateJoin extends APIRequest<LiveWithGuestSession> {

    LiveWithGuestSession lastResponse = null;
    @Override
    public LiveWithGuestSession getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "offer_sdp",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LiveWithGuestSession parseResponse(String response, String header) throws APIException {
      return LiveWithGuestSession.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveWithGuestSession execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveWithGuestSession execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveWithGuestSession> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveWithGuestSession> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveWithGuestSession>() {
           public LiveWithGuestSession apply(ResponseWrapper result) {
             try {
               return APIRequestCreateJoin.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateJoin(String nodeId, APIContext context) {
      super(context, nodeId, "/join", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateJoin setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateJoin setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateJoin setOfferSdp (String offerSdp) {
      this.setParam("offer_sdp", offerSdp);
      return this;
    }

    public APIRequestCreateJoin requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateJoin requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateJoin requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateJoin requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateJoin requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateJoin requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateRingUser extends APIRequest<LiveWithGuestSession> {

    LiveWithGuestSession lastResponse = null;
    @Override
    public LiveWithGuestSession getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LiveWithGuestSession parseResponse(String response, String header) throws APIException {
      return LiveWithGuestSession.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveWithGuestSession execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveWithGuestSession execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveWithGuestSession> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveWithGuestSession> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveWithGuestSession>() {
           public LiveWithGuestSession apply(ResponseWrapper result) {
             try {
               return APIRequestCreateRingUser.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateRingUser(String nodeId, APIContext context) {
      super(context, nodeId, "/ring_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateRingUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateRingUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateRingUser setUserIds (List<Long> userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }
    public APIRequestCreateRingUser setUserIds (String userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }

    public APIRequestCreateRingUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateRingUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateRingUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateRingUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateRingUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateRingUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<LiveWithGuestSession> {

    LiveWithGuestSession lastResponse = null;
    @Override
    public LiveWithGuestSession getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "conference_name",
      "id",
      "participant_call_states",
      "server_sdp",
    };

    @Override
    public LiveWithGuestSession parseResponse(String response, String header) throws APIException {
      return LiveWithGuestSession.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveWithGuestSession execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveWithGuestSession execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveWithGuestSession> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveWithGuestSession> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveWithGuestSession>() {
           public LiveWithGuestSession apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestGet requestConferenceNameField () {
      return this.requestConferenceNameField(true);
    }
    public APIRequestGet requestConferenceNameField (boolean value) {
      this.requestField("conference_name", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestParticipantCallStatesField () {
      return this.requestParticipantCallStatesField(true);
    }
    public APIRequestGet requestParticipantCallStatesField (boolean value) {
      this.requestField("participant_call_states", value);
      return this;
    }
    public APIRequestGet requestServerSdpField () {
      return this.requestServerSdpField(true);
    }
    public APIRequestGet requestServerSdpField (boolean value) {
      this.requestField("server_sdp", value);
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

  public LiveWithGuestSession copyFrom(LiveWithGuestSession instance) {
    this.mConferenceName = instance.mConferenceName;
    this.mId = instance.mId;
    this.mParticipantCallStates = instance.mParticipantCallStates;
    this.mServerSdp = instance.mServerSdp;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LiveWithGuestSession> getParser() {
    return new APIRequest.ResponseParser<LiveWithGuestSession>() {
      public APINodeList<LiveWithGuestSession> parseResponse(String response, APIContext context, APIRequest<LiveWithGuestSession> request, String header) throws MalformedResponseException {
        return LiveWithGuestSession.parseResponse(response, context, request, header);
      }
    };
  }
}
