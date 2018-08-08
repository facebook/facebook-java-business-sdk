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
public class InstantArticle extends APINode {
  @SerializedName("canonical_url")
  private String mCanonicalUrl = null;
  @SerializedName("development_mode")
  private Boolean mDevelopmentMode = null;
  @SerializedName("html_source")
  private String mHtmlSource = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("most_recent_import_status")
  private Object mMostRecentImportStatus = null;
  @SerializedName("photos")
  private List<Object> mPhotos = null;
  @SerializedName("publish_status")
  private String mPublishStatus = null;
  @SerializedName("published")
  private Boolean mPublished = null;
  @SerializedName("videos")
  private List<Object> mVideos = null;
  protected static Gson gson = null;

  InstantArticle() {
  }

  public InstantArticle(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public InstantArticle(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public InstantArticle fetch() throws APIException{
    InstantArticle newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static InstantArticle fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<InstantArticle> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static InstantArticle fetchById(String id, APIContext context) throws APIException {
    InstantArticle instantArticle =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return instantArticle;
  }

  public static ListenableFuture<InstantArticle> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<InstantArticle> instantArticle =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return instantArticle;
  }

  public static APINodeList<InstantArticle> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<InstantArticle>)(
      new APIRequest<InstantArticle>(context, "", "/", "GET", InstantArticle.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<InstantArticle>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<InstantArticle>> instantArticle =
      new APIRequest(context, "", "/", "GET", InstantArticle.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return instantArticle;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static InstantArticle loadJSON(String json, APIContext context) {
    InstantArticle instantArticle = getGson().fromJson(json, InstantArticle.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instantArticle.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    instantArticle.context = context;
    instantArticle.rawValue = json;
    return instantArticle;
  }

  public static APINodeList<InstantArticle> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<InstantArticle> instantArticles = new APINodeList<InstantArticle>(request, json);
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
          instantArticles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return instantArticles;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instantArticles.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instantArticles.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instantArticles.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instantArticles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  instantArticles.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              instantArticles.add(loadJSON(obj.toString(), context));
            }
          }
          return instantArticles;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instantArticles.add(loadJSON(entry.getValue().toString(), context));
          }
          return instantArticles;
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
              instantArticles.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instantArticles;
          }

          // Sixth, check if it's pure JsonObject
          instantArticles.clear();
          instantArticles.add(loadJSON(json, context));
          return instantArticles;
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

  public APIRequestDeleteInstantArticles deleteInstantArticles() {
    return new APIRequestDeleteInstantArticles(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldCanonicalUrl() {
    return mCanonicalUrl;
  }

  public Boolean getFieldDevelopmentMode() {
    return mDevelopmentMode;
  }

  public String getFieldHtmlSource() {
    return mHtmlSource;
  }

  public String getFieldId() {
    return mId;
  }

  public Object getFieldMostRecentImportStatus() {
    return mMostRecentImportStatus;
  }

  public List<Object> getFieldPhotos() {
    return mPhotos;
  }

  public String getFieldPublishStatus() {
    return mPublishStatus;
  }

  public Boolean getFieldPublished() {
    return mPublished;
  }

  public List<Object> getFieldVideos() {
    return mVideos;
  }



  public static class APIRequestDeleteInstantArticles extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteInstantArticles.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteInstantArticles(String nodeId, APIContext context) {
      super(context, nodeId, "/instant_articles", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteInstantArticles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteInstantArticles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteInstantArticles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteInstantArticles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteInstantArticles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteInstantArticles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteInstantArticles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteInstantArticles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<InstantArticle> {

    InstantArticle lastResponse = null;
    @Override
    public InstantArticle getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "canonical_url",
      "development_mode",
      "html_source",
      "id",
      "most_recent_import_status",
      "photos",
      "publish_status",
      "published",
      "videos",
    };

    @Override
    public InstantArticle parseResponse(String response) throws APIException {
      return InstantArticle.parseResponse(response, getContext(), this).head();
    }

    @Override
    public InstantArticle execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstantArticle execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<InstantArticle> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstantArticle> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, InstantArticle>() {
           public InstantArticle apply(String result) {
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

    public APIRequestGet requestCanonicalUrlField () {
      return this.requestCanonicalUrlField(true);
    }
    public APIRequestGet requestCanonicalUrlField (boolean value) {
      this.requestField("canonical_url", value);
      return this;
    }
    public APIRequestGet requestDevelopmentModeField () {
      return this.requestDevelopmentModeField(true);
    }
    public APIRequestGet requestDevelopmentModeField (boolean value) {
      this.requestField("development_mode", value);
      return this;
    }
    public APIRequestGet requestHtmlSourceField () {
      return this.requestHtmlSourceField(true);
    }
    public APIRequestGet requestHtmlSourceField (boolean value) {
      this.requestField("html_source", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMostRecentImportStatusField () {
      return this.requestMostRecentImportStatusField(true);
    }
    public APIRequestGet requestMostRecentImportStatusField (boolean value) {
      this.requestField("most_recent_import_status", value);
      return this;
    }
    public APIRequestGet requestPhotosField () {
      return this.requestPhotosField(true);
    }
    public APIRequestGet requestPhotosField (boolean value) {
      this.requestField("photos", value);
      return this;
    }
    public APIRequestGet requestPublishStatusField () {
      return this.requestPublishStatusField(true);
    }
    public APIRequestGet requestPublishStatusField (boolean value) {
      this.requestField("publish_status", value);
      return this;
    }
    public APIRequestGet requestPublishedField () {
      return this.requestPublishedField(true);
    }
    public APIRequestGet requestPublishedField (boolean value) {
      this.requestField("published", value);
      return this;
    }
    public APIRequestGet requestVideosField () {
      return this.requestVideosField(true);
    }
    public APIRequestGet requestVideosField (boolean value) {
      this.requestField("videos", value);
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

  public InstantArticle copyFrom(InstantArticle instance) {
    this.mCanonicalUrl = instance.mCanonicalUrl;
    this.mDevelopmentMode = instance.mDevelopmentMode;
    this.mHtmlSource = instance.mHtmlSource;
    this.mId = instance.mId;
    this.mMostRecentImportStatus = instance.mMostRecentImportStatus;
    this.mPhotos = instance.mPhotos;
    this.mPublishStatus = instance.mPublishStatus;
    this.mPublished = instance.mPublished;
    this.mVideos = instance.mVideos;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstantArticle> getParser() {
    return new APIRequest.ResponseParser<InstantArticle>() {
      public APINodeList<InstantArticle> parseResponse(String response, APIContext context, APIRequest<InstantArticle> request) throws MalformedResponseException {
        return InstantArticle.parseResponse(response, context, request);
      }
    };
  }
}
