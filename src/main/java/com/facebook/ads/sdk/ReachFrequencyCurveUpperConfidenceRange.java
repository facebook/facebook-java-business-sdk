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
public class ReachFrequencyCurveUpperConfidenceRange extends APINode {
  @SerializedName("impression_upper")
  private List<Long> mImpressionUpper = null;
  @SerializedName("num_points")
  private Long mNumPoints = null;
  @SerializedName("reach")
  private List<Long> mReach = null;
  @SerializedName("reach_upper")
  private List<Long> mReachUpper = null;
  @SerializedName("uniq_video_views_2s_upper")
  private List<Long> mUniqVideoViews2sUpper = null;
  @SerializedName("video_views_2s_upper")
  private List<Long> mVideoViews2sUpper = null;
  protected static Gson gson = null;

  public ReachFrequencyCurveUpperConfidenceRange() {
  }

  public String getId() {
    return null;
  }
  public static ReachFrequencyCurveUpperConfidenceRange loadJSON(String json, APIContext context, String header) {
    ReachFrequencyCurveUpperConfidenceRange reachFrequencyCurveUpperConfidenceRange = getGson().fromJson(json, ReachFrequencyCurveUpperConfidenceRange.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(reachFrequencyCurveUpperConfidenceRange.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    reachFrequencyCurveUpperConfidenceRange.context = context;
    reachFrequencyCurveUpperConfidenceRange.rawValue = json;
    reachFrequencyCurveUpperConfidenceRange.header = header;
    return reachFrequencyCurveUpperConfidenceRange;
  }

  public static APINodeList<ReachFrequencyCurveUpperConfidenceRange> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ReachFrequencyCurveUpperConfidenceRange> reachFrequencyCurveUpperConfidenceRanges = new APINodeList<ReachFrequencyCurveUpperConfidenceRange>(request, json, header);
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
          reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return reachFrequencyCurveUpperConfidenceRanges;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                reachFrequencyCurveUpperConfidenceRanges.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            reachFrequencyCurveUpperConfidenceRanges.setPaging(previous, next);
            if (context.hasAppSecret()) {
              reachFrequencyCurveUpperConfidenceRanges.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(obj.toString(), context, header));
            }
          }
          return reachFrequencyCurveUpperConfidenceRanges;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return reachFrequencyCurveUpperConfidenceRanges;
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
              reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return reachFrequencyCurveUpperConfidenceRanges;
          }

          // Sixth, check if it's pure JsonObject
          reachFrequencyCurveUpperConfidenceRanges.clear();
          reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(json, context, header));
          return reachFrequencyCurveUpperConfidenceRanges;
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


  public List<Long> getFieldImpressionUpper() {
    return mImpressionUpper;
  }

  public ReachFrequencyCurveUpperConfidenceRange setFieldImpressionUpper(List<Long> value) {
    this.mImpressionUpper = value;
    return this;
  }

  public Long getFieldNumPoints() {
    return mNumPoints;
  }

  public ReachFrequencyCurveUpperConfidenceRange setFieldNumPoints(Long value) {
    this.mNumPoints = value;
    return this;
  }

  public List<Long> getFieldReach() {
    return mReach;
  }

  public ReachFrequencyCurveUpperConfidenceRange setFieldReach(List<Long> value) {
    this.mReach = value;
    return this;
  }

  public List<Long> getFieldReachUpper() {
    return mReachUpper;
  }

  public ReachFrequencyCurveUpperConfidenceRange setFieldReachUpper(List<Long> value) {
    this.mReachUpper = value;
    return this;
  }

  public List<Long> getFieldUniqVideoViews2sUpper() {
    return mUniqVideoViews2sUpper;
  }

  public ReachFrequencyCurveUpperConfidenceRange setFieldUniqVideoViews2sUpper(List<Long> value) {
    this.mUniqVideoViews2sUpper = value;
    return this;
  }

  public List<Long> getFieldVideoViews2sUpper() {
    return mVideoViews2sUpper;
  }

  public ReachFrequencyCurveUpperConfidenceRange setFieldVideoViews2sUpper(List<Long> value) {
    this.mVideoViews2sUpper = value;
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

  public ReachFrequencyCurveUpperConfidenceRange copyFrom(ReachFrequencyCurveUpperConfidenceRange instance) {
    this.mImpressionUpper = instance.mImpressionUpper;
    this.mNumPoints = instance.mNumPoints;
    this.mReach = instance.mReach;
    this.mReachUpper = instance.mReachUpper;
    this.mUniqVideoViews2sUpper = instance.mUniqVideoViews2sUpper;
    this.mVideoViews2sUpper = instance.mVideoViews2sUpper;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReachFrequencyCurveUpperConfidenceRange> getParser() {
    return new APIRequest.ResponseParser<ReachFrequencyCurveUpperConfidenceRange>() {
      public APINodeList<ReachFrequencyCurveUpperConfidenceRange> parseResponse(String response, APIContext context, APIRequest<ReachFrequencyCurveUpperConfidenceRange> request, String header) throws MalformedResponseException {
        return ReachFrequencyCurveUpperConfidenceRange.parseResponse(response, context, request, header);
      }
    };
  }
}
