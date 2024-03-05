/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
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
import com.google.common.util.concurrent.MoreExecutors;
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
  protected static Gson gson = null;

  public Recommendation() {
  }

  public String getId() {
    return null;
  }
  public static Recommendation loadJSON(String json, APIContext context, String header) {
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
      }
    }
    recommendation.context = context;
    recommendation.rawValue = json;
    recommendation.header = header;
    return recommendation;
  }

  public static APINodeList<Recommendation> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Recommendation> recommendations = new APINodeList<Recommendation>(request, json, header);
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
          recommendations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
              recommendations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  recommendations.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              recommendations.add(loadJSON(obj.toString(), context, header));
            }
          }
          return recommendations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              recommendations.add(loadJSON(entry.getValue().toString(), context, header));
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
              recommendations.add(loadJSON(value.toString(), context, header));
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
          recommendations.add(loadJSON(json, context, header));
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


  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public Recommendation setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public Boolean getFieldHasRating() {
    return mHasRating;
  }

  public Recommendation setFieldHasRating(Boolean value) {
    this.mHasRating = value;
    return this;
  }

  public Boolean getFieldHasReview() {
    return mHasReview;
  }

  public Recommendation setFieldHasReview(Boolean value) {
    this.mHasReview = value;
    return this;
  }

  public Object getFieldOpenGraphStory() {
    return mOpenGraphStory;
  }

  public Recommendation setFieldOpenGraphStory(Object value) {
    this.mOpenGraphStory = value;
    return this;
  }

  public Long getFieldRating() {
    return mRating;
  }

  public Recommendation setFieldRating(Long value) {
    this.mRating = value;
    return this;
  }

  public String getFieldRecommendationType() {
    return mRecommendationType;
  }

  public Recommendation setFieldRecommendationType(String value) {
    this.mRecommendationType = value;
    return this;
  }

  public String getFieldReviewText() {
    return mReviewText;
  }

  public Recommendation setFieldReviewText(String value) {
    this.mReviewText = value;
    return this;
  }

  public User getFieldReviewer() {
    if (mReviewer != null) {
      mReviewer.context = getContext();
    }
    return mReviewer;
  }

  public Recommendation setFieldReviewer(User value) {
    this.mReviewer = value;
    return this;
  }

  public Recommendation setFieldReviewer(String value) {
    Type type = new TypeToken<User>(){}.getType();
    this.mReviewer = User.getGson().fromJson(value, type);
    return this;
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
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Recommendation> getParser() {
    return new APIRequest.ResponseParser<Recommendation>() {
      public APINodeList<Recommendation> parseResponse(String response, APIContext context, APIRequest<Recommendation> request, String header) throws MalformedResponseException {
        return Recommendation.parseResponse(response, context, request, header);
      }
    };
  }
}
