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
public class Recommendation extends APINode {
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("has_rating")
  private Boolean mHasRating = null;
  @SerializedName("has_review")
  private Boolean mHasReview = null;
  @SerializedName("open_graph_story")
  private Object mOpenGraphStory = null;
  @SerializedName("rating")
  private Long mRating = null;
  @SerializedName("recommendation_type")
  private String mRecommendationType = null;
  @SerializedName("review_text")
  private String mReviewText = null;
  @SerializedName("reviewer")
  private User mReviewer = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  Recommendation() {
  }

  public Recommendation(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Recommendation(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Recommendation fetch() throws APIException{
    Recommendation newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Recommendation fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Recommendation> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Recommendation fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Recommendation> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Recommendation> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Recommendation>)(
      new APIRequest<Recommendation>(context, "", "/", "GET", Recommendation.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Recommendation>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Recommendation.getParser())
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
  public static Recommendation loadJSON(String json, APIContext context) {
    Recommendation recommendation = getGson().fromJson(json, Recommendation.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(recommendation.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    recommendation.context = context;
    recommendation.rawValue = json;
    return recommendation;
  }

  public static APINodeList<Recommendation> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Recommendation> recommendations = new APINodeList<Recommendation>(request, json);
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
          recommendations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return recommendations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                recommendations.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            recommendations.setPaging(previous, next);
            if (context.hasAppSecret()) {
              recommendations.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              recommendations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  recommendations.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              recommendations.add(loadJSON(obj.toString(), context));
            }
          }
          return recommendations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              recommendations.add(loadJSON(entry.getValue().toString(), context));
          }
          return recommendations;
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
              recommendations.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return recommendations;
          }

          // Sixth, check if it's pure JsonObject
          recommendations.clear();
          recommendations.add(loadJSON(json, context));
          return recommendations;
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


  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public Boolean getFieldHasRating() {
    return mHasRating;
  }

  public Boolean getFieldHasReview() {
    return mHasReview;
  }

  public Object getFieldOpenGraphStory() {
    return mOpenGraphStory;
  }

  public Long getFieldRating() {
    return mRating;
  }

  public String getFieldRecommendationType() {
    return mRecommendationType;
  }

  public String getFieldReviewText() {
    return mReviewText;
  }

  public User getFieldReviewer() {
    if (mReviewer != null) {
      mReviewer.context = getContext();
    }
    return mReviewer;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<Recommendation> {

    Recommendation lastResponse = null;
    @Override
    public Recommendation getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "created_time",
      "has_rating",
      "has_review",
      "open_graph_story",
      "rating",
      "recommendation_type",
      "review_text",
      "reviewer",
      "id",
    };

    @Override
    public Recommendation parseResponse(String response) throws APIException {
      return Recommendation.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Recommendation execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Recommendation execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Recommendation> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Recommendation> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Recommendation>() {
           public Recommendation apply(String result) {
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

    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestHasRatingField () {
      return this.requestHasRatingField(true);
    }
    public APIRequestGet requestHasRatingField (boolean value) {
      this.requestField("has_rating", value);
      return this;
    }
    public APIRequestGet requestHasReviewField () {
      return this.requestHasReviewField(true);
    }
    public APIRequestGet requestHasReviewField (boolean value) {
      this.requestField("has_review", value);
      return this;
    }
    public APIRequestGet requestOpenGraphStoryField () {
      return this.requestOpenGraphStoryField(true);
    }
    public APIRequestGet requestOpenGraphStoryField (boolean value) {
      this.requestField("open_graph_story", value);
      return this;
    }
    public APIRequestGet requestRatingField () {
      return this.requestRatingField(true);
    }
    public APIRequestGet requestRatingField (boolean value) {
      this.requestField("rating", value);
      return this;
    }
    public APIRequestGet requestRecommendationTypeField () {
      return this.requestRecommendationTypeField(true);
    }
    public APIRequestGet requestRecommendationTypeField (boolean value) {
      this.requestField("recommendation_type", value);
      return this;
    }
    public APIRequestGet requestReviewTextField () {
      return this.requestReviewTextField(true);
    }
    public APIRequestGet requestReviewTextField (boolean value) {
      this.requestField("review_text", value);
      return this;
    }
    public APIRequestGet requestReviewerField () {
      return this.requestReviewerField(true);
    }
    public APIRequestGet requestReviewerField (boolean value) {
      this.requestField("reviewer", value);
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

  public Recommendation copyFrom(Recommendation instance) {
    this.mCreatedTime = instance.mCreatedTime;
    this.mHasRating = instance.mHasRating;
    this.mHasReview = instance.mHasReview;
    this.mOpenGraphStory = instance.mOpenGraphStory;
    this.mRating = instance.mRating;
    this.mRecommendationType = instance.mRecommendationType;
    this.mReviewText = instance.mReviewText;
    this.mReviewer = instance.mReviewer;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Recommendation> getParser() {
    return new APIRequest.ResponseParser<Recommendation>() {
      public APINodeList<Recommendation> parseResponse(String response, APIContext context, APIRequest<Recommendation> request) throws MalformedResponseException {
        return Recommendation.parseResponse(response, context, request);
      }
    };
  }
}
