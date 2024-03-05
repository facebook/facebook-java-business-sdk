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
public class ReachFrequencyEstimatesPlacementBreakdown extends APINode {
  @SerializedName("android")
  private List<Double> mAndroid = null;
  @SerializedName("audience_network")
  private List<Double> mAudienceNetwork = null;
  @SerializedName("desktop")
  private List<Double> mDesktop = null;
  @SerializedName("facebook_search")
  private List<Double> mFacebookSearch = null;
  @SerializedName("fb_reels")
  private List<Double> mFbReels = null;
  @SerializedName("fb_reels_overlay")
  private List<Double> mFbReelsOverlay = null;
  @SerializedName("ig_android")
  private List<Double> mIgAndroid = null;
  @SerializedName("ig_ios")
  private List<Double> mIgIos = null;
  @SerializedName("ig_other")
  private List<Double> mIgOther = null;
  @SerializedName("ig_reels")
  private List<Double> mIgReels = null;
  @SerializedName("ig_story")
  private List<Double> mIgStory = null;
  @SerializedName("instant_articles")
  private List<Double> mInstantArticles = null;
  @SerializedName("instream_videos")
  private List<Double> mInstreamVideos = null;
  @SerializedName("ios")
  private List<Double> mIos = null;
  @SerializedName("msite")
  private List<Double> mMsite = null;
  @SerializedName("suggested_videos")
  private List<Double> mSuggestedVideos = null;
  protected static Gson gson = null;

  public ReachFrequencyEstimatesPlacementBreakdown() {
  }

  public String getId() {
    return null;
  }
  public static ReachFrequencyEstimatesPlacementBreakdown loadJSON(String json, APIContext context, String header) {
    ReachFrequencyEstimatesPlacementBreakdown reachFrequencyEstimatesPlacementBreakdown = getGson().fromJson(json, ReachFrequencyEstimatesPlacementBreakdown.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(reachFrequencyEstimatesPlacementBreakdown.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    reachFrequencyEstimatesPlacementBreakdown.context = context;
    reachFrequencyEstimatesPlacementBreakdown.rawValue = json;
    reachFrequencyEstimatesPlacementBreakdown.header = header;
    return reachFrequencyEstimatesPlacementBreakdown;
  }

  public static APINodeList<ReachFrequencyEstimatesPlacementBreakdown> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ReachFrequencyEstimatesPlacementBreakdown> reachFrequencyEstimatesPlacementBreakdowns = new APINodeList<ReachFrequencyEstimatesPlacementBreakdown>(request, json, header);
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
          reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return reachFrequencyEstimatesPlacementBreakdowns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                reachFrequencyEstimatesPlacementBreakdowns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            reachFrequencyEstimatesPlacementBreakdowns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              reachFrequencyEstimatesPlacementBreakdowns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return reachFrequencyEstimatesPlacementBreakdowns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return reachFrequencyEstimatesPlacementBreakdowns;
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
              reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return reachFrequencyEstimatesPlacementBreakdowns;
          }

          // Sixth, check if it's pure JsonObject
          reachFrequencyEstimatesPlacementBreakdowns.clear();
          reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(json, context, header));
          return reachFrequencyEstimatesPlacementBreakdowns;
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


  public List<Double> getFieldAndroid() {
    return mAndroid;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldAndroid(List<Double> value) {
    this.mAndroid = value;
    return this;
  }

  public List<Double> getFieldAudienceNetwork() {
    return mAudienceNetwork;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldAudienceNetwork(List<Double> value) {
    this.mAudienceNetwork = value;
    return this;
  }

  public List<Double> getFieldDesktop() {
    return mDesktop;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldDesktop(List<Double> value) {
    this.mDesktop = value;
    return this;
  }

  public List<Double> getFieldFacebookSearch() {
    return mFacebookSearch;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldFacebookSearch(List<Double> value) {
    this.mFacebookSearch = value;
    return this;
  }

  public List<Double> getFieldFbReels() {
    return mFbReels;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldFbReels(List<Double> value) {
    this.mFbReels = value;
    return this;
  }

  public List<Double> getFieldFbReelsOverlay() {
    return mFbReelsOverlay;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldFbReelsOverlay(List<Double> value) {
    this.mFbReelsOverlay = value;
    return this;
  }

  public List<Double> getFieldIgAndroid() {
    return mIgAndroid;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldIgAndroid(List<Double> value) {
    this.mIgAndroid = value;
    return this;
  }

  public List<Double> getFieldIgIos() {
    return mIgIos;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldIgIos(List<Double> value) {
    this.mIgIos = value;
    return this;
  }

  public List<Double> getFieldIgOther() {
    return mIgOther;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldIgOther(List<Double> value) {
    this.mIgOther = value;
    return this;
  }

  public List<Double> getFieldIgReels() {
    return mIgReels;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldIgReels(List<Double> value) {
    this.mIgReels = value;
    return this;
  }

  public List<Double> getFieldIgStory() {
    return mIgStory;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldIgStory(List<Double> value) {
    this.mIgStory = value;
    return this;
  }

  public List<Double> getFieldInstantArticles() {
    return mInstantArticles;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldInstantArticles(List<Double> value) {
    this.mInstantArticles = value;
    return this;
  }

  public List<Double> getFieldInstreamVideos() {
    return mInstreamVideos;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldInstreamVideos(List<Double> value) {
    this.mInstreamVideos = value;
    return this;
  }

  public List<Double> getFieldIos() {
    return mIos;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldIos(List<Double> value) {
    this.mIos = value;
    return this;
  }

  public List<Double> getFieldMsite() {
    return mMsite;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldMsite(List<Double> value) {
    this.mMsite = value;
    return this;
  }

  public List<Double> getFieldSuggestedVideos() {
    return mSuggestedVideos;
  }

  public ReachFrequencyEstimatesPlacementBreakdown setFieldSuggestedVideos(List<Double> value) {
    this.mSuggestedVideos = value;
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

  public ReachFrequencyEstimatesPlacementBreakdown copyFrom(ReachFrequencyEstimatesPlacementBreakdown instance) {
    this.mAndroid = instance.mAndroid;
    this.mAudienceNetwork = instance.mAudienceNetwork;
    this.mDesktop = instance.mDesktop;
    this.mFacebookSearch = instance.mFacebookSearch;
    this.mFbReels = instance.mFbReels;
    this.mFbReelsOverlay = instance.mFbReelsOverlay;
    this.mIgAndroid = instance.mIgAndroid;
    this.mIgIos = instance.mIgIos;
    this.mIgOther = instance.mIgOther;
    this.mIgReels = instance.mIgReels;
    this.mIgStory = instance.mIgStory;
    this.mInstantArticles = instance.mInstantArticles;
    this.mInstreamVideos = instance.mInstreamVideos;
    this.mIos = instance.mIos;
    this.mMsite = instance.mMsite;
    this.mSuggestedVideos = instance.mSuggestedVideos;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReachFrequencyEstimatesPlacementBreakdown> getParser() {
    return new APIRequest.ResponseParser<ReachFrequencyEstimatesPlacementBreakdown>() {
      public APINodeList<ReachFrequencyEstimatesPlacementBreakdown> parseResponse(String response, APIContext context, APIRequest<ReachFrequencyEstimatesPlacementBreakdown> request, String header) throws MalformedResponseException {
        return ReachFrequencyEstimatesPlacementBreakdown.parseResponse(response, context, request, header);
      }
    };
  }
}
