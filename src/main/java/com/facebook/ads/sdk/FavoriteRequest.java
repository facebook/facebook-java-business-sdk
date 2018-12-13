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
public class FavoriteRequest extends APINode {
  @SerializedName("api_version")
  private String mApiVersion = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("graph_path")
  private String mGraphPath = null;
  @SerializedName("hash")
  private String mHash = null;
  @SerializedName("http_method")
  private EnumHttpMethod mHttpMethod = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("post_params")
  private List<Object> mPostParams = null;
  @SerializedName("query_params")
  private List<Object> mQueryParams = null;
  protected static Gson gson = null;

  FavoriteRequest() {
  }

  public FavoriteRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public FavoriteRequest(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public FavoriteRequest fetch() throws APIException{
    FavoriteRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static FavoriteRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<FavoriteRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static FavoriteRequest fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<FavoriteRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<FavoriteRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<FavoriteRequest>)(
      new APIRequest<FavoriteRequest>(context, "", "/", "GET", FavoriteRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<FavoriteRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", FavoriteRequest.getParser())
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
  public static FavoriteRequest loadJSON(String json, APIContext context, String header) {
    FavoriteRequest favoriteRequest = getGson().fromJson(json, FavoriteRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(favoriteRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    favoriteRequest.context = context;
    favoriteRequest.rawValue = json;
    favoriteRequest.header = header;
    return favoriteRequest;
  }

  public static APINodeList<FavoriteRequest> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<FavoriteRequest> favoriteRequests = new APINodeList<FavoriteRequest>(request, json, header);
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
          favoriteRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return favoriteRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                favoriteRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            favoriteRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              favoriteRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              favoriteRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  favoriteRequests.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              favoriteRequests.add(loadJSON(obj.toString(), context, header));
            }
          }
          return favoriteRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              favoriteRequests.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return favoriteRequests;
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
              favoriteRequests.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return favoriteRequests;
          }

          // Sixth, check if it's pure JsonObject
          favoriteRequests.clear();
          favoriteRequests.add(loadJSON(json, context, header));
          return favoriteRequests;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldApiVersion() {
    return mApiVersion;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldGraphPath() {
    return mGraphPath;
  }

  public String getFieldHash() {
    return mHash;
  }

  public EnumHttpMethod getFieldHttpMethod() {
    return mHttpMethod;
  }

  public String getFieldId() {
    return mId;
  }

  public List<Object> getFieldPostParams() {
    return mPostParams;
  }

  public List<Object> getFieldQueryParams() {
    return mQueryParams;
  }



  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<FavoriteRequest> {

    FavoriteRequest lastResponse = null;
    @Override
    public FavoriteRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "api_version",
      "description",
      "graph_path",
      "hash",
      "http_method",
      "id",
      "post_params",
      "query_params",
    };

    @Override
    public FavoriteRequest parseResponse(String response, String header) throws APIException {
      return FavoriteRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public FavoriteRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public FavoriteRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<FavoriteRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<FavoriteRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, FavoriteRequest>() {
           public FavoriteRequest apply(ResponseWrapper result) {
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

    public APIRequestGet requestApiVersionField () {
      return this.requestApiVersionField(true);
    }
    public APIRequestGet requestApiVersionField (boolean value) {
      this.requestField("api_version", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestGraphPathField () {
      return this.requestGraphPathField(true);
    }
    public APIRequestGet requestGraphPathField (boolean value) {
      this.requestField("graph_path", value);
      return this;
    }
    public APIRequestGet requestHashField () {
      return this.requestHashField(true);
    }
    public APIRequestGet requestHashField (boolean value) {
      this.requestField("hash", value);
      return this;
    }
    public APIRequestGet requestHttpMethodField () {
      return this.requestHttpMethodField(true);
    }
    public APIRequestGet requestHttpMethodField (boolean value) {
      this.requestField("http_method", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPostParamsField () {
      return this.requestPostParamsField(true);
    }
    public APIRequestGet requestPostParamsField (boolean value) {
      this.requestField("post_params", value);
      return this;
    }
    public APIRequestGet requestQueryParamsField () {
      return this.requestQueryParamsField(true);
    }
    public APIRequestGet requestQueryParamsField (boolean value) {
      this.requestField("query_params", value);
      return this;
    }
  }

  public static enum EnumHttpMethod {
      @SerializedName("GET")
      VALUE_GET("GET"),
      @SerializedName("POST")
      VALUE_POST("POST"),
      @SerializedName("DELETE")
      VALUE_DELETE("DELETE"),
      NULL(null);

      private String value;

      private EnumHttpMethod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumApiVersion {
      @SerializedName("unversioned")
      VALUE_UNVERSIONED("unversioned"),
      @SerializedName("v1.0")
      VALUE_V1_0("v1.0"),
      @SerializedName("v2.0")
      VALUE_V2_0("v2.0"),
      @SerializedName("v2.1")
      VALUE_V2_1("v2.1"),
      @SerializedName("v2.2")
      VALUE_V2_2("v2.2"),
      @SerializedName("v2.3")
      VALUE_V2_3("v2.3"),
      @SerializedName("v2.4")
      VALUE_V2_4("v2.4"),
      @SerializedName("v2.5")
      VALUE_V2_5("v2.5"),
      @SerializedName("v2.6")
      VALUE_V2_6("v2.6"),
      @SerializedName("v2.7")
      VALUE_V2_7("v2.7"),
      @SerializedName("v2.8")
      VALUE_V2_8("v2.8"),
      @SerializedName("v2.9")
      VALUE_V2_9("v2.9"),
      @SerializedName("v2.10")
      VALUE_V2_10("v2.10"),
      @SerializedName("v2.11")
      VALUE_V2_11("v2.11"),
      @SerializedName("v2.12")
      VALUE_V2_12("v2.12"),
      @SerializedName("v3.0")
      VALUE_V3_0("v3.0"),
      @SerializedName("v3.1")
      VALUE_V3_1("v3.1"),
      @SerializedName("v3.2")
      VALUE_V3_2("v3.2"),
      @SerializedName("v4.0")
      VALUE_V4_0("v4.0"),
      NULL(null);

      private String value;

      private EnumApiVersion(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
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

  public FavoriteRequest copyFrom(FavoriteRequest instance) {
    this.mApiVersion = instance.mApiVersion;
    this.mDescription = instance.mDescription;
    this.mGraphPath = instance.mGraphPath;
    this.mHash = instance.mHash;
    this.mHttpMethod = instance.mHttpMethod;
    this.mId = instance.mId;
    this.mPostParams = instance.mPostParams;
    this.mQueryParams = instance.mQueryParams;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<FavoriteRequest> getParser() {
    return new APIRequest.ResponseParser<FavoriteRequest>() {
      public APINodeList<FavoriteRequest> parseResponse(String response, APIContext context, APIRequest<FavoriteRequest> request, String header) throws MalformedResponseException {
        return FavoriteRequest.parseResponse(response, context, request, header);
      }
    };
  }
}
