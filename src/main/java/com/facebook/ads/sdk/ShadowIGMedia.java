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
public class ShadowIGMedia extends APINode {
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("comments_count")
  private Long mCommentsCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_id")
  private String mIgId = null;
  @SerializedName("is_comment_enabled")
  private Boolean mIsCommentEnabled = null;
  @SerializedName("like_count")
  private Long mLikeCount = null;
  @SerializedName("media_type")
  private String mMediaType = null;
  @SerializedName("media_url")
  private String mMediaUrl = null;
  @SerializedName("owner")
  private ShadowIGUser mOwner = null;
  @SerializedName("permalink")
  private String mPermalink = null;
  @SerializedName("shortcode")
  private String mShortcode = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  @SerializedName("username")
  private String mUsername = null;
  protected static Gson gson = null;

  ShadowIGMedia() {
  }

  public ShadowIGMedia(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ShadowIGMedia(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public ShadowIGMedia fetch() throws APIException{
    ShadowIGMedia newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ShadowIGMedia fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ShadowIGMedia> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ShadowIGMedia fetchById(String id, APIContext context) throws APIException {
    ShadowIGMedia shadowIGMedia =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return shadowIGMedia;
  }

  public static ListenableFuture<ShadowIGMedia> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<ShadowIGMedia> shadowIGMedia =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return shadowIGMedia;
  }

  public static APINodeList<ShadowIGMedia> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ShadowIGMedia>)(
      new APIRequest<ShadowIGMedia>(context, "", "/", "GET", ShadowIGMedia.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ShadowIGMedia>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<ShadowIGMedia>> shadowIGMedia =
      new APIRequest(context, "", "/", "GET", ShadowIGMedia.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return shadowIGMedia;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ShadowIGMedia loadJSON(String json, APIContext context) {
    ShadowIGMedia shadowIGMedia = getGson().fromJson(json, ShadowIGMedia.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(shadowIGMedia.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    shadowIGMedia.context = context;
    shadowIGMedia.rawValue = json;
    return shadowIGMedia;
  }

  public static APINodeList<ShadowIGMedia> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ShadowIGMedia> shadowIGMedias = new APINodeList<ShadowIGMedia>(request, json);
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
          shadowIGMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return shadowIGMedias;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                shadowIGMedias.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            shadowIGMedias.setPaging(previous, next);
            if (context.hasAppSecret()) {
              shadowIGMedias.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              shadowIGMedias.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  shadowIGMedias.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              shadowIGMedias.add(loadJSON(obj.toString(), context));
            }
          }
          return shadowIGMedias;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              shadowIGMedias.add(loadJSON(entry.getValue().toString(), context));
          }
          return shadowIGMedias;
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
              shadowIGMedias.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return shadowIGMedias;
          }

          // Sixth, check if it's pure JsonObject
          shadowIGMedias.clear();
          shadowIGMedias.add(loadJSON(json, context));
          return shadowIGMedias;
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

  public APIRequestGetComments getComments() {
    return new APIRequestGetComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateComment createComment() {
    return new APIRequestCreateComment(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldCaption() {
    return mCaption;
  }

  public Long getFieldCommentsCount() {
    return mCommentsCount;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIgId() {
    return mIgId;
  }

  public Boolean getFieldIsCommentEnabled() {
    return mIsCommentEnabled;
  }

  public Long getFieldLikeCount() {
    return mLikeCount;
  }

  public String getFieldMediaType() {
    return mMediaType;
  }

  public String getFieldMediaUrl() {
    return mMediaUrl;
  }

  public ShadowIGUser getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public String getFieldPermalink() {
    return mPermalink;
  }

  public String getFieldShortcode() {
    return mShortcode;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }

  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public String getFieldUsername() {
    return mUsername;
  }



  public static class APIRequestGetComments extends APIRequest<ShadowIGComment> {

    APINodeList<ShadowIGComment> lastResponse = null;
    @Override
    public APINodeList<ShadowIGComment> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "hidden",
      "id",
      "like_count",
      "media",
      "text",
      "timestamp",
      "user",
      "username",
    };

    @Override
    public APINodeList<ShadowIGComment> parseResponse(String response) throws APIException {
      return ShadowIGComment.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<ShadowIGComment> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ShadowIGComment> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ShadowIGComment>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ShadowIGComment>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<ShadowIGComment>>() {
           public APINodeList<ShadowIGComment> apply(String result) {
             try {
               return APIRequestGetComments.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetComments(String nodeId, APIContext context) {
      super(context, nodeId, "/comments", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetComments setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetComments setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetComments requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetComments requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetComments requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetComments requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetComments requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetComments requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetComments requestHiddenField () {
      return this.requestHiddenField(true);
    }
    public APIRequestGetComments requestHiddenField (boolean value) {
      this.requestField("hidden", value);
      return this;
    }
    public APIRequestGetComments requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetComments requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetComments requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetComments requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetComments requestMediaField () {
      return this.requestMediaField(true);
    }
    public APIRequestGetComments requestMediaField (boolean value) {
      this.requestField("media", value);
      return this;
    }
    public APIRequestGetComments requestTextField () {
      return this.requestTextField(true);
    }
    public APIRequestGetComments requestTextField (boolean value) {
      this.requestField("text", value);
      return this;
    }
    public APIRequestGetComments requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetComments requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetComments requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGetComments requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
    public APIRequestGetComments requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetComments requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestCreateComment extends APIRequest<ShadowIGComment> {

    ShadowIGComment lastResponse = null;
    @Override
    public ShadowIGComment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "message",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ShadowIGComment parseResponse(String response) throws APIException {
      return ShadowIGComment.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ShadowIGComment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ShadowIGComment execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ShadowIGComment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ShadowIGComment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ShadowIGComment>() {
           public ShadowIGComment apply(String result) {
             try {
               return APIRequestCreateComment.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateComment(String nodeId, APIContext context) {
      super(context, nodeId, "/comments", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateComment setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateComment setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateComment setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateComment requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateComment requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateComment requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateComment requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateComment requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateComment requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInsights extends APIRequest<InstagramInsightsResult> {

    APINodeList<InstagramInsightsResult> lastResponse = null;
    @Override
    public APINodeList<InstagramInsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "metric",
      "period",
    };

    public static final String[] FIELDS = {
      "description",
      "id",
      "name",
      "period",
      "title",
      "values",
    };

    @Override
    public APINodeList<InstagramInsightsResult> parseResponse(String response) throws APIException {
      return InstagramInsightsResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<InstagramInsightsResult>>() {
           public APINodeList<InstagramInsightsResult> apply(String result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsights setMetric (List<InstagramInsightsResult.EnumMetric> metric) {
      this.setParam("metric", metric);
      return this;
    }
    public APIRequestGetInsights setMetric (String metric) {
      this.setParam("metric", metric);
      return this;
    }

    public APIRequestGetInsights setPeriod (List<InstagramInsightsResult.EnumPeriod> period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInsights requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetInsights requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetInsights requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInsights requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInsights requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetInsights requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetInsights requestPeriodField () {
      return this.requestPeriodField(true);
    }
    public APIRequestGetInsights requestPeriodField (boolean value) {
      this.requestField("period", value);
      return this;
    }
    public APIRequestGetInsights requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetInsights requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetInsights requestValuesField () {
      return this.requestValuesField(true);
    }
    public APIRequestGetInsights requestValuesField (boolean value) {
      this.requestField("values", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<ShadowIGMedia> {

    ShadowIGMedia lastResponse = null;
    @Override
    public ShadowIGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "caption",
      "comments_count",
      "id",
      "ig_id",
      "is_comment_enabled",
      "like_count",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public ShadowIGMedia parseResponse(String response) throws APIException {
      return ShadowIGMedia.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ShadowIGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ShadowIGMedia execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ShadowIGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ShadowIGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ShadowIGMedia>() {
           public ShadowIGMedia apply(String result) {
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

    public APIRequestGet requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGet requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGet requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGet requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGet requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGet requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGet requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGet requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGet requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGet requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGet requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGet requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGet requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGet requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGet requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGet requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGet requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGet requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGet requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGet requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<ShadowIGMedia> {

    ShadowIGMedia lastResponse = null;
    @Override
    public ShadowIGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "comment_enabled",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ShadowIGMedia parseResponse(String response) throws APIException {
      return ShadowIGMedia.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ShadowIGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ShadowIGMedia execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ShadowIGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ShadowIGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ShadowIGMedia>() {
           public ShadowIGMedia apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setCommentEnabled (Boolean commentEnabled) {
      this.setParam("comment_enabled", commentEnabled);
      return this;
    }
    public APIRequestUpdate setCommentEnabled (String commentEnabled) {
      this.setParam("comment_enabled", commentEnabled);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

  public ShadowIGMedia copyFrom(ShadowIGMedia instance) {
    this.mCaption = instance.mCaption;
    this.mCommentsCount = instance.mCommentsCount;
    this.mId = instance.mId;
    this.mIgId = instance.mIgId;
    this.mIsCommentEnabled = instance.mIsCommentEnabled;
    this.mLikeCount = instance.mLikeCount;
    this.mMediaType = instance.mMediaType;
    this.mMediaUrl = instance.mMediaUrl;
    this.mOwner = instance.mOwner;
    this.mPermalink = instance.mPermalink;
    this.mShortcode = instance.mShortcode;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mTimestamp = instance.mTimestamp;
    this.mUsername = instance.mUsername;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ShadowIGMedia> getParser() {
    return new APIRequest.ResponseParser<ShadowIGMedia>() {
      public APINodeList<ShadowIGMedia> parseResponse(String response, APIContext context, APIRequest<ShadowIGMedia> request) throws MalformedResponseException {
        return ShadowIGMedia.parseResponse(response, context, request);
      }
    };
  }
}
