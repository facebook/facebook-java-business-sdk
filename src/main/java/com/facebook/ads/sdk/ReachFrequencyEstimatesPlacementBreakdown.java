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
public class ReachFrequencyEstimatesPlacementBreakdown extends APINode {
  @SerializedName("android")
  private List<Double> mAndroid = null;
  @SerializedName("audience_network")
  private List<Double> mAudienceNetwork = null;
  @SerializedName("desktop")
  private List<Double> mDesktop = null;
  @SerializedName("ig_android")
  private List<Double> mIgAndroid = null;
  @SerializedName("ig_ios")
  private List<Double> mIgIos = null;
  @SerializedName("ig_other")
  private List<Double> mIgOther = null;
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
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ReachFrequencyEstimatesPlacementBreakdown() {
  }

  public ReachFrequencyEstimatesPlacementBreakdown(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ReachFrequencyEstimatesPlacementBreakdown(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ReachFrequencyEstimatesPlacementBreakdown fetch() throws APIException{
    ReachFrequencyEstimatesPlacementBreakdown newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ReachFrequencyEstimatesPlacementBreakdown fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ReachFrequencyEstimatesPlacementBreakdown> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ReachFrequencyEstimatesPlacementBreakdown fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ReachFrequencyEstimatesPlacementBreakdown> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ReachFrequencyEstimatesPlacementBreakdown> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ReachFrequencyEstimatesPlacementBreakdown>)(
      new APIRequest<ReachFrequencyEstimatesPlacementBreakdown>(context, "", "/", "GET", ReachFrequencyEstimatesPlacementBreakdown.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ReachFrequencyEstimatesPlacementBreakdown>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ReachFrequencyEstimatesPlacementBreakdown.getParser())
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
  public static ReachFrequencyEstimatesPlacementBreakdown loadJSON(String json, APIContext context) {
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
      };
    }
    reachFrequencyEstimatesPlacementBreakdown.context = context;
    reachFrequencyEstimatesPlacementBreakdown.rawValue = json;
    return reachFrequencyEstimatesPlacementBreakdown;
  }

  public static APINodeList<ReachFrequencyEstimatesPlacementBreakdown> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ReachFrequencyEstimatesPlacementBreakdown> reachFrequencyEstimatesPlacementBreakdowns = new APINodeList<ReachFrequencyEstimatesPlacementBreakdown>(request, json);
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
          reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(obj.toString(), context));
            }
          }
          return reachFrequencyEstimatesPlacementBreakdowns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(entry.getValue().toString(), context));
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
              reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(value.toString(), context));
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
          reachFrequencyEstimatesPlacementBreakdowns.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public List<Double> getFieldAndroid() {
    return mAndroid;
  }

  public List<Double> getFieldAudienceNetwork() {
    return mAudienceNetwork;
  }

  public List<Double> getFieldDesktop() {
    return mDesktop;
  }

  public List<Double> getFieldIgAndroid() {
    return mIgAndroid;
  }

  public List<Double> getFieldIgIos() {
    return mIgIos;
  }

  public List<Double> getFieldIgOther() {
    return mIgOther;
  }

  public List<Double> getFieldIgStory() {
    return mIgStory;
  }

  public List<Double> getFieldInstantArticles() {
    return mInstantArticles;
  }

  public List<Double> getFieldInstreamVideos() {
    return mInstreamVideos;
  }

  public List<Double> getFieldIos() {
    return mIos;
  }

  public List<Double> getFieldMsite() {
    return mMsite;
  }

  public List<Double> getFieldSuggestedVideos() {
    return mSuggestedVideos;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ReachFrequencyEstimatesPlacementBreakdown> {

    ReachFrequencyEstimatesPlacementBreakdown lastResponse = null;
    @Override
    public ReachFrequencyEstimatesPlacementBreakdown getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "android",
      "audience_network",
      "desktop",
      "ig_android",
      "ig_ios",
      "ig_other",
      "ig_story",
      "instant_articles",
      "instream_videos",
      "ios",
      "msite",
      "suggested_videos",
      "id",
    };

    @Override
    public ReachFrequencyEstimatesPlacementBreakdown parseResponse(String response) throws APIException {
      return ReachFrequencyEstimatesPlacementBreakdown.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ReachFrequencyEstimatesPlacementBreakdown execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ReachFrequencyEstimatesPlacementBreakdown execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ReachFrequencyEstimatesPlacementBreakdown> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ReachFrequencyEstimatesPlacementBreakdown> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ReachFrequencyEstimatesPlacementBreakdown>() {
           public ReachFrequencyEstimatesPlacementBreakdown apply(String result) {
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

    public APIRequestGet requestAndroidField () {
      return this.requestAndroidField(true);
    }
    public APIRequestGet requestAndroidField (boolean value) {
      this.requestField("android", value);
      return this;
    }
    public APIRequestGet requestAudienceNetworkField () {
      return this.requestAudienceNetworkField(true);
    }
    public APIRequestGet requestAudienceNetworkField (boolean value) {
      this.requestField("audience_network", value);
      return this;
    }
    public APIRequestGet requestDesktopField () {
      return this.requestDesktopField(true);
    }
    public APIRequestGet requestDesktopField (boolean value) {
      this.requestField("desktop", value);
      return this;
    }
    public APIRequestGet requestIgAndroidField () {
      return this.requestIgAndroidField(true);
    }
    public APIRequestGet requestIgAndroidField (boolean value) {
      this.requestField("ig_android", value);
      return this;
    }
    public APIRequestGet requestIgIosField () {
      return this.requestIgIosField(true);
    }
    public APIRequestGet requestIgIosField (boolean value) {
      this.requestField("ig_ios", value);
      return this;
    }
    public APIRequestGet requestIgOtherField () {
      return this.requestIgOtherField(true);
    }
    public APIRequestGet requestIgOtherField (boolean value) {
      this.requestField("ig_other", value);
      return this;
    }
    public APIRequestGet requestIgStoryField () {
      return this.requestIgStoryField(true);
    }
    public APIRequestGet requestIgStoryField (boolean value) {
      this.requestField("ig_story", value);
      return this;
    }
    public APIRequestGet requestInstantArticlesField () {
      return this.requestInstantArticlesField(true);
    }
    public APIRequestGet requestInstantArticlesField (boolean value) {
      this.requestField("instant_articles", value);
      return this;
    }
    public APIRequestGet requestInstreamVideosField () {
      return this.requestInstreamVideosField(true);
    }
    public APIRequestGet requestInstreamVideosField (boolean value) {
      this.requestField("instream_videos", value);
      return this;
    }
    public APIRequestGet requestIosField () {
      return this.requestIosField(true);
    }
    public APIRequestGet requestIosField (boolean value) {
      this.requestField("ios", value);
      return this;
    }
    public APIRequestGet requestMsiteField () {
      return this.requestMsiteField(true);
    }
    public APIRequestGet requestMsiteField (boolean value) {
      this.requestField("msite", value);
      return this;
    }
    public APIRequestGet requestSuggestedVideosField () {
      return this.requestSuggestedVideosField(true);
    }
    public APIRequestGet requestSuggestedVideosField (boolean value) {
      this.requestField("suggested_videos", value);
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

  public ReachFrequencyEstimatesPlacementBreakdown copyFrom(ReachFrequencyEstimatesPlacementBreakdown instance) {
    this.mAndroid = instance.mAndroid;
    this.mAudienceNetwork = instance.mAudienceNetwork;
    this.mDesktop = instance.mDesktop;
    this.mIgAndroid = instance.mIgAndroid;
    this.mIgIos = instance.mIgIos;
    this.mIgOther = instance.mIgOther;
    this.mIgStory = instance.mIgStory;
    this.mInstantArticles = instance.mInstantArticles;
    this.mInstreamVideos = instance.mInstreamVideos;
    this.mIos = instance.mIos;
    this.mMsite = instance.mMsite;
    this.mSuggestedVideos = instance.mSuggestedVideos;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReachFrequencyEstimatesPlacementBreakdown> getParser() {
    return new APIRequest.ResponseParser<ReachFrequencyEstimatesPlacementBreakdown>() {
      public APINodeList<ReachFrequencyEstimatesPlacementBreakdown> parseResponse(String response, APIContext context, APIRequest<ReachFrequencyEstimatesPlacementBreakdown> request) throws MalformedResponseException {
        return ReachFrequencyEstimatesPlacementBreakdown.parseResponse(response, context, request);
      }
    };
  }
}
