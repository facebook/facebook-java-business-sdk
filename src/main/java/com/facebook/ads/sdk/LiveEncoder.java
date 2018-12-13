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
public class LiveEncoder extends APINode {
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("current_broadcast")
  private LiveVideo mCurrentBroadcast = null;
  @SerializedName("current_input_stream")
  private LiveVideoInputStream mCurrentInputStream = null;
  @SerializedName("device_id")
  private String mDeviceId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_heartbeat_time")
  private String mLastHeartbeatTime = null;
  @SerializedName("model")
  private String mModel = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("version")
  private String mVersion = null;
  protected static Gson gson = null;

  LiveEncoder() {
  }

  public LiveEncoder(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LiveEncoder(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LiveEncoder fetch() throws APIException{
    LiveEncoder newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LiveEncoder fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LiveEncoder> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LiveEncoder fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LiveEncoder> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LiveEncoder> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LiveEncoder>)(
      new APIRequest<LiveEncoder>(context, "", "/", "GET", LiveEncoder.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LiveEncoder>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LiveEncoder.getParser())
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
  public static LiveEncoder loadJSON(String json, APIContext context, String header) {
    LiveEncoder liveEncoder = getGson().fromJson(json, LiveEncoder.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(liveEncoder.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    liveEncoder.context = context;
    liveEncoder.rawValue = json;
    liveEncoder.header = header;
    return liveEncoder;
  }

  public static APINodeList<LiveEncoder> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LiveEncoder> liveEncoders = new APINodeList<LiveEncoder>(request, json, header);
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
          liveEncoders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return liveEncoders;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                liveEncoders.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            liveEncoders.setPaging(previous, next);
            if (context.hasAppSecret()) {
              liveEncoders.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              liveEncoders.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  liveEncoders.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              liveEncoders.add(loadJSON(obj.toString(), context, header));
            }
          }
          return liveEncoders;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              liveEncoders.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return liveEncoders;
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
              liveEncoders.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return liveEncoders;
          }

          // Sixth, check if it's pure JsonObject
          liveEncoders.clear();
          liveEncoders.add(loadJSON(json, context, header));
          return liveEncoders;
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


  public String getFieldBrand() {
    return mBrand;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public LiveVideo getFieldCurrentBroadcast() {
    if (mCurrentBroadcast != null) {
      mCurrentBroadcast.context = getContext();
    }
    return mCurrentBroadcast;
  }

  public LiveVideoInputStream getFieldCurrentInputStream() {
    if (mCurrentInputStream != null) {
      mCurrentInputStream.context = getContext();
    }
    return mCurrentInputStream;
  }

  public String getFieldDeviceId() {
    return mDeviceId;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLastHeartbeatTime() {
    return mLastHeartbeatTime;
  }

  public String getFieldModel() {
    return mModel;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldVersion() {
    return mVersion;
  }



  public static class APIRequestGet extends APIRequest<LiveEncoder> {

    LiveEncoder lastResponse = null;
    @Override
    public LiveEncoder getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "brand",
      "creation_time",
      "current_broadcast",
      "current_input_stream",
      "device_id",
      "id",
      "last_heartbeat_time",
      "model",
      "name",
      "status",
      "version",
    };

    @Override
    public LiveEncoder parseResponse(String response, String header) throws APIException {
      return LiveEncoder.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveEncoder execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveEncoder execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveEncoder> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveEncoder> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveEncoder>() {
           public LiveEncoder apply(ResponseWrapper result) {
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

    public APIRequestGet requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGet requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCurrentBroadcastField () {
      return this.requestCurrentBroadcastField(true);
    }
    public APIRequestGet requestCurrentBroadcastField (boolean value) {
      this.requestField("current_broadcast", value);
      return this;
    }
    public APIRequestGet requestCurrentInputStreamField () {
      return this.requestCurrentInputStreamField(true);
    }
    public APIRequestGet requestCurrentInputStreamField (boolean value) {
      this.requestField("current_input_stream", value);
      return this;
    }
    public APIRequestGet requestDeviceIdField () {
      return this.requestDeviceIdField(true);
    }
    public APIRequestGet requestDeviceIdField (boolean value) {
      this.requestField("device_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLastHeartbeatTimeField () {
      return this.requestLastHeartbeatTimeField(true);
    }
    public APIRequestGet requestLastHeartbeatTimeField (boolean value) {
      this.requestField("last_heartbeat_time", value);
      return this;
    }
    public APIRequestGet requestModelField () {
      return this.requestModelField(true);
    }
    public APIRequestGet requestModelField (boolean value) {
      this.requestField("model", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestVersionField () {
      return this.requestVersionField(true);
    }
    public APIRequestGet requestVersionField (boolean value) {
      this.requestField("version", value);
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

  public LiveEncoder copyFrom(LiveEncoder instance) {
    this.mBrand = instance.mBrand;
    this.mCreationTime = instance.mCreationTime;
    this.mCurrentBroadcast = instance.mCurrentBroadcast;
    this.mCurrentInputStream = instance.mCurrentInputStream;
    this.mDeviceId = instance.mDeviceId;
    this.mId = instance.mId;
    this.mLastHeartbeatTime = instance.mLastHeartbeatTime;
    this.mModel = instance.mModel;
    this.mName = instance.mName;
    this.mStatus = instance.mStatus;
    this.mVersion = instance.mVersion;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LiveEncoder> getParser() {
    return new APIRequest.ResponseParser<LiveEncoder>() {
      public APINodeList<LiveEncoder> parseResponse(String response, APIContext context, APIRequest<LiveEncoder> request, String header) throws MalformedResponseException {
        return LiveEncoder.parseResponse(response, context, request, header);
      }
    };
  }
}
