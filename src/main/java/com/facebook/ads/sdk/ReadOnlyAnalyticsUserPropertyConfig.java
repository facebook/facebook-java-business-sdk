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
public class ReadOnlyAnalyticsUserPropertyConfig extends APINode {
  @SerializedName("active_properties")
  private List<String> mActiveProperties = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ReadOnlyAnalyticsUserPropertyConfig() {
  }

  public ReadOnlyAnalyticsUserPropertyConfig(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ReadOnlyAnalyticsUserPropertyConfig(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ReadOnlyAnalyticsUserPropertyConfig fetch() throws APIException{
    ReadOnlyAnalyticsUserPropertyConfig newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ReadOnlyAnalyticsUserPropertyConfig fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ReadOnlyAnalyticsUserPropertyConfig> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ReadOnlyAnalyticsUserPropertyConfig fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ReadOnlyAnalyticsUserPropertyConfig> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ReadOnlyAnalyticsUserPropertyConfig> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ReadOnlyAnalyticsUserPropertyConfig>)(
      new APIRequest<ReadOnlyAnalyticsUserPropertyConfig>(context, "", "/", "GET", ReadOnlyAnalyticsUserPropertyConfig.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ReadOnlyAnalyticsUserPropertyConfig>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ReadOnlyAnalyticsUserPropertyConfig.getParser())
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
  public static ReadOnlyAnalyticsUserPropertyConfig loadJSON(String json, APIContext context, String header) {
    ReadOnlyAnalyticsUserPropertyConfig readOnlyAnalyticsUserPropertyConfig = getGson().fromJson(json, ReadOnlyAnalyticsUserPropertyConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(readOnlyAnalyticsUserPropertyConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    readOnlyAnalyticsUserPropertyConfig.context = context;
    readOnlyAnalyticsUserPropertyConfig.rawValue = json;
    readOnlyAnalyticsUserPropertyConfig.header = header;
    return readOnlyAnalyticsUserPropertyConfig;
  }

  public static APINodeList<ReadOnlyAnalyticsUserPropertyConfig> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ReadOnlyAnalyticsUserPropertyConfig> readOnlyAnalyticsUserPropertyConfigs = new APINodeList<ReadOnlyAnalyticsUserPropertyConfig>(request, json, header);
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
          readOnlyAnalyticsUserPropertyConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return readOnlyAnalyticsUserPropertyConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                readOnlyAnalyticsUserPropertyConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            readOnlyAnalyticsUserPropertyConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              readOnlyAnalyticsUserPropertyConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              readOnlyAnalyticsUserPropertyConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  readOnlyAnalyticsUserPropertyConfigs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              readOnlyAnalyticsUserPropertyConfigs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return readOnlyAnalyticsUserPropertyConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              readOnlyAnalyticsUserPropertyConfigs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return readOnlyAnalyticsUserPropertyConfigs;
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
              readOnlyAnalyticsUserPropertyConfigs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return readOnlyAnalyticsUserPropertyConfigs;
          }

          // Sixth, check if it's pure JsonObject
          readOnlyAnalyticsUserPropertyConfigs.clear();
          readOnlyAnalyticsUserPropertyConfigs.add(loadJSON(json, context, header));
          return readOnlyAnalyticsUserPropertyConfigs;
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


  public List<String> getFieldActiveProperties() {
    return mActiveProperties;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ReadOnlyAnalyticsUserPropertyConfig> {

    ReadOnlyAnalyticsUserPropertyConfig lastResponse = null;
    @Override
    public ReadOnlyAnalyticsUserPropertyConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "active_properties",
      "id",
    };

    @Override
    public ReadOnlyAnalyticsUserPropertyConfig parseResponse(String response, String header) throws APIException {
      return ReadOnlyAnalyticsUserPropertyConfig.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ReadOnlyAnalyticsUserPropertyConfig execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ReadOnlyAnalyticsUserPropertyConfig execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ReadOnlyAnalyticsUserPropertyConfig> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ReadOnlyAnalyticsUserPropertyConfig> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ReadOnlyAnalyticsUserPropertyConfig>() {
           public ReadOnlyAnalyticsUserPropertyConfig apply(ResponseWrapper result) {
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

    public APIRequestGet requestActivePropertiesField () {
      return this.requestActivePropertiesField(true);
    }
    public APIRequestGet requestActivePropertiesField (boolean value) {
      this.requestField("active_properties", value);
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

  public ReadOnlyAnalyticsUserPropertyConfig copyFrom(ReadOnlyAnalyticsUserPropertyConfig instance) {
    this.mActiveProperties = instance.mActiveProperties;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReadOnlyAnalyticsUserPropertyConfig> getParser() {
    return new APIRequest.ResponseParser<ReadOnlyAnalyticsUserPropertyConfig>() {
      public APINodeList<ReadOnlyAnalyticsUserPropertyConfig> parseResponse(String response, APIContext context, APIRequest<ReadOnlyAnalyticsUserPropertyConfig> request, String header) throws MalformedResponseException {
        return ReadOnlyAnalyticsUserPropertyConfig.parseResponse(response, context, request, header);
      }
    };
  }
}
