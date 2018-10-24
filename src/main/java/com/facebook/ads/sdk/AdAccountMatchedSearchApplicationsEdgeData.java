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
public class AdAccountMatchedSearchApplicationsEdgeData extends APINode {
  @SerializedName("app_id")
  private String mAppId = null;
  @SerializedName("icon_url")
  private String mIconUrl = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("search_source_store")
  private String mSearchSourceStore = null;
  @SerializedName("store")
  private String mStore = null;
  @SerializedName("unique_id")
  private String mUniqueId = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdAccountMatchedSearchApplicationsEdgeData() {
  }

  public AdAccountMatchedSearchApplicationsEdgeData(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountMatchedSearchApplicationsEdgeData(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAccountMatchedSearchApplicationsEdgeData fetch() throws APIException{
    AdAccountMatchedSearchApplicationsEdgeData newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountMatchedSearchApplicationsEdgeData fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountMatchedSearchApplicationsEdgeData> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountMatchedSearchApplicationsEdgeData fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAccountMatchedSearchApplicationsEdgeData> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAccountMatchedSearchApplicationsEdgeData> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountMatchedSearchApplicationsEdgeData>)(
      new APIRequest<AdAccountMatchedSearchApplicationsEdgeData>(context, "", "/", "GET", AdAccountMatchedSearchApplicationsEdgeData.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountMatchedSearchApplicationsEdgeData>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAccountMatchedSearchApplicationsEdgeData.getParser())
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
  public static AdAccountMatchedSearchApplicationsEdgeData loadJSON(String json, APIContext context) {
    AdAccountMatchedSearchApplicationsEdgeData adAccountMatchedSearchApplicationsEdgeData = getGson().fromJson(json, AdAccountMatchedSearchApplicationsEdgeData.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountMatchedSearchApplicationsEdgeData.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccountMatchedSearchApplicationsEdgeData.context = context;
    adAccountMatchedSearchApplicationsEdgeData.rawValue = json;
    return adAccountMatchedSearchApplicationsEdgeData;
  }

  public static APINodeList<AdAccountMatchedSearchApplicationsEdgeData> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAccountMatchedSearchApplicationsEdgeData> adAccountMatchedSearchApplicationsEdgeDatas = new APINodeList<AdAccountMatchedSearchApplicationsEdgeData>(request, json);
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
          adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAccountMatchedSearchApplicationsEdgeDatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountMatchedSearchApplicationsEdgeDatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountMatchedSearchApplicationsEdgeDatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountMatchedSearchApplicationsEdgeDatas.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(obj.toString(), context));
            }
          }
          return adAccountMatchedSearchApplicationsEdgeDatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAccountMatchedSearchApplicationsEdgeDatas;
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
              adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountMatchedSearchApplicationsEdgeDatas;
          }

          // Sixth, check if it's pure JsonObject
          adAccountMatchedSearchApplicationsEdgeDatas.clear();
          adAccountMatchedSearchApplicationsEdgeDatas.add(loadJSON(json, context));
          return adAccountMatchedSearchApplicationsEdgeDatas;
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


  public String getFieldAppId() {
    return mAppId;
  }

  public String getFieldIconUrl() {
    return mIconUrl;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldSearchSourceStore() {
    return mSearchSourceStore;
  }

  public String getFieldStore() {
    return mStore;
  }

  public String getFieldUniqueId() {
    return mUniqueId;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdAccountMatchedSearchApplicationsEdgeData> {

    AdAccountMatchedSearchApplicationsEdgeData lastResponse = null;
    @Override
    public AdAccountMatchedSearchApplicationsEdgeData getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "app_id",
      "icon_url",
      "name",
      "search_source_store",
      "store",
      "unique_id",
      "url",
      "id",
    };

    @Override
    public AdAccountMatchedSearchApplicationsEdgeData parseResponse(String response) throws APIException {
      return AdAccountMatchedSearchApplicationsEdgeData.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountMatchedSearchApplicationsEdgeData execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountMatchedSearchApplicationsEdgeData execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountMatchedSearchApplicationsEdgeData> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountMatchedSearchApplicationsEdgeData> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountMatchedSearchApplicationsEdgeData>() {
           public AdAccountMatchedSearchApplicationsEdgeData apply(String result) {
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

    public APIRequestGet requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGet requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGet requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGet requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestSearchSourceStoreField () {
      return this.requestSearchSourceStoreField(true);
    }
    public APIRequestGet requestSearchSourceStoreField (boolean value) {
      this.requestField("search_source_store", value);
      return this;
    }
    public APIRequestGet requestStoreField () {
      return this.requestStoreField(true);
    }
    public APIRequestGet requestStoreField (boolean value) {
      this.requestField("store", value);
      return this;
    }
    public APIRequestGet requestUniqueIdField () {
      return this.requestUniqueIdField(true);
    }
    public APIRequestGet requestUniqueIdField (boolean value) {
      this.requestField("unique_id", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
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

  public static enum EnumAppStore {
      @SerializedName("AMAZON_APP_STORE")
      VALUE_AMAZON_APP_STORE("AMAZON_APP_STORE"),
      @SerializedName("GOOGLE_PLAY")
      VALUE_GOOGLE_PLAY("GOOGLE_PLAY"),
      @SerializedName("ITUNES")
      VALUE_ITUNES("ITUNES"),
      @SerializedName("ITUNES_IPAD")
      VALUE_ITUNES_IPAD("ITUNES_IPAD"),
      @SerializedName("FB_CANVAS")
      VALUE_FB_CANVAS("FB_CANVAS"),
      @SerializedName("FB_GAMEROOM")
      VALUE_FB_GAMEROOM("FB_GAMEROOM"),
      @SerializedName("WINDOWS_STORE")
      VALUE_WINDOWS_STORE("WINDOWS_STORE"),
      @SerializedName("FB_ANDROID_STORE")
      VALUE_FB_ANDROID_STORE("FB_ANDROID_STORE"),
      @SerializedName("WINDOWS_10_STORE")
      VALUE_WINDOWS_10_STORE("WINDOWS_10_STORE"),
      @SerializedName("ROKU_STORE")
      VALUE_ROKU_STORE("ROKU_STORE"),
      @SerializedName("INSTANT_GAME")
      VALUE_INSTANT_GAME("INSTANT_GAME"),
      @SerializedName("DOES_NOT_EXIST")
      VALUE_DOES_NOT_EXIST("DOES_NOT_EXIST"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumAppStore(String value) {
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

  public AdAccountMatchedSearchApplicationsEdgeData copyFrom(AdAccountMatchedSearchApplicationsEdgeData instance) {
    this.mAppId = instance.mAppId;
    this.mIconUrl = instance.mIconUrl;
    this.mName = instance.mName;
    this.mSearchSourceStore = instance.mSearchSourceStore;
    this.mStore = instance.mStore;
    this.mUniqueId = instance.mUniqueId;
    this.mUrl = instance.mUrl;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountMatchedSearchApplicationsEdgeData> getParser() {
    return new APIRequest.ResponseParser<AdAccountMatchedSearchApplicationsEdgeData>() {
      public APINodeList<AdAccountMatchedSearchApplicationsEdgeData> parseResponse(String response, APIContext context, APIRequest<AdAccountMatchedSearchApplicationsEdgeData> request) throws MalformedResponseException {
        return AdAccountMatchedSearchApplicationsEdgeData.parseResponse(response, context, request);
      }
    };
  }
}
