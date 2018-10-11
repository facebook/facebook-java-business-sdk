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
public class TimezoneOffset extends APINode {
  @SerializedName("abbr")
  private String mAbbr = null;
  @SerializedName("isdst")
  private Boolean mIsdst = null;
  @SerializedName("offset")
  private Long mOffset = null;
  @SerializedName("time")
  private String mTime = null;
  @SerializedName("ts")
  private Long mTs = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  TimezoneOffset() {
  }

  public TimezoneOffset(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public TimezoneOffset(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public TimezoneOffset fetch() throws APIException{
    TimezoneOffset newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static TimezoneOffset fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<TimezoneOffset> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static TimezoneOffset fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<TimezoneOffset> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<TimezoneOffset> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<TimezoneOffset>)(
      new APIRequest<TimezoneOffset>(context, "", "/", "GET", TimezoneOffset.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<TimezoneOffset>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", TimezoneOffset.getParser())
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
  public static TimezoneOffset loadJSON(String json, APIContext context) {
    TimezoneOffset timezoneOffset = getGson().fromJson(json, TimezoneOffset.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(timezoneOffset.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    timezoneOffset.context = context;
    timezoneOffset.rawValue = json;
    return timezoneOffset;
  }

  public static APINodeList<TimezoneOffset> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<TimezoneOffset> timezoneOffsets = new APINodeList<TimezoneOffset>(request, json);
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
          timezoneOffsets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return timezoneOffsets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                timezoneOffsets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            timezoneOffsets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              timezoneOffsets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              timezoneOffsets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  timezoneOffsets.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              timezoneOffsets.add(loadJSON(obj.toString(), context));
            }
          }
          return timezoneOffsets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              timezoneOffsets.add(loadJSON(entry.getValue().toString(), context));
          }
          return timezoneOffsets;
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
              timezoneOffsets.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return timezoneOffsets;
          }

          // Sixth, check if it's pure JsonObject
          timezoneOffsets.clear();
          timezoneOffsets.add(loadJSON(json, context));
          return timezoneOffsets;
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


  public String getFieldAbbr() {
    return mAbbr;
  }

  public Boolean getFieldIsdst() {
    return mIsdst;
  }

  public Long getFieldOffset() {
    return mOffset;
  }

  public String getFieldTime() {
    return mTime;
  }

  public Long getFieldTs() {
    return mTs;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<TimezoneOffset> {

    TimezoneOffset lastResponse = null;
    @Override
    public TimezoneOffset getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "abbr",
      "isdst",
      "offset",
      "time",
      "ts",
      "id",
    };

    @Override
    public TimezoneOffset parseResponse(String response) throws APIException {
      return TimezoneOffset.parseResponse(response, getContext(), this).head();
    }

    @Override
    public TimezoneOffset execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public TimezoneOffset execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<TimezoneOffset> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<TimezoneOffset> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, TimezoneOffset>() {
           public TimezoneOffset apply(String result) {
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

    public APIRequestGet requestAbbrField () {
      return this.requestAbbrField(true);
    }
    public APIRequestGet requestAbbrField (boolean value) {
      this.requestField("abbr", value);
      return this;
    }
    public APIRequestGet requestIsdstField () {
      return this.requestIsdstField(true);
    }
    public APIRequestGet requestIsdstField (boolean value) {
      this.requestField("isdst", value);
      return this;
    }
    public APIRequestGet requestOffsetField () {
      return this.requestOffsetField(true);
    }
    public APIRequestGet requestOffsetField (boolean value) {
      this.requestField("offset", value);
      return this;
    }
    public APIRequestGet requestTimeField () {
      return this.requestTimeField(true);
    }
    public APIRequestGet requestTimeField (boolean value) {
      this.requestField("time", value);
      return this;
    }
    public APIRequestGet requestTsField () {
      return this.requestTsField(true);
    }
    public APIRequestGet requestTsField (boolean value) {
      this.requestField("ts", value);
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

  public TimezoneOffset copyFrom(TimezoneOffset instance) {
    this.mAbbr = instance.mAbbr;
    this.mIsdst = instance.mIsdst;
    this.mOffset = instance.mOffset;
    this.mTime = instance.mTime;
    this.mTs = instance.mTs;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<TimezoneOffset> getParser() {
    return new APIRequest.ResponseParser<TimezoneOffset>() {
      public APINodeList<TimezoneOffset> parseResponse(String response, APIContext context, APIRequest<TimezoneOffset> request) throws MalformedResponseException {
        return TimezoneOffset.parseResponse(response, context, request);
      }
    };
  }
}
