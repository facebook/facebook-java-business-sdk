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
public class ScheduledPost extends APINode {
  @SerializedName("admin_creator")
  private User mAdminCreator = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("feed_audience_description")
  private String mFeedAudienceDescription = null;
  @SerializedName("feed_targeting")
  private Targeting mFeedTargeting = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("modified_time")
  private String mModifiedTime = null;
  @SerializedName("og_action_summary")
  private String mOgActionSummary = null;
  @SerializedName("permalink_url")
  private String mPermalinkUrl = null;
  @SerializedName("place")
  private Place mPlace = null;
  @SerializedName("privacy_description")
  private String mPrivacyDescription = null;
  @SerializedName("promotion_info")
  private Object mPromotionInfo = null;
  @SerializedName("scheduled_publish_time")
  private String mScheduledPublishTime = null;
  @SerializedName("story_token")
  private String mStoryToken = null;
  @SerializedName("thumbnail")
  private String mThumbnail = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  protected static Gson gson = null;

  ScheduledPost() {
  }

  public ScheduledPost(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ScheduledPost(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ScheduledPost fetch() throws APIException{
    ScheduledPost newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ScheduledPost fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ScheduledPost> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ScheduledPost fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ScheduledPost> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ScheduledPost> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ScheduledPost>)(
      new APIRequest<ScheduledPost>(context, "", "/", "GET", ScheduledPost.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ScheduledPost>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ScheduledPost.getParser())
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
  public static ScheduledPost loadJSON(String json, APIContext context) {
    ScheduledPost scheduledPost = getGson().fromJson(json, ScheduledPost.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(scheduledPost.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    scheduledPost.context = context;
    scheduledPost.rawValue = json;
    return scheduledPost;
  }

  public static APINodeList<ScheduledPost> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ScheduledPost> scheduledPosts = new APINodeList<ScheduledPost>(request, json);
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
          scheduledPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return scheduledPosts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                scheduledPosts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            scheduledPosts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              scheduledPosts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              scheduledPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  scheduledPosts.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              scheduledPosts.add(loadJSON(obj.toString(), context));
            }
          }
          return scheduledPosts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              scheduledPosts.add(loadJSON(entry.getValue().toString(), context));
          }
          return scheduledPosts;
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
              scheduledPosts.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return scheduledPosts;
          }

          // Sixth, check if it's pure JsonObject
          scheduledPosts.clear();
          scheduledPosts.add(loadJSON(json, context));
          return scheduledPosts;
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


  public User getFieldAdminCreator() {
    if (mAdminCreator != null) {
      mAdminCreator.context = getContext();
    }
    return mAdminCreator;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldFeedAudienceDescription() {
    return mFeedAudienceDescription;
  }

  public Targeting getFieldFeedTargeting() {
    if (mFeedTargeting != null) {
      mFeedTargeting.context = getContext();
    }
    return mFeedTargeting;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public String getFieldModifiedTime() {
    return mModifiedTime;
  }

  public String getFieldOgActionSummary() {
    return mOgActionSummary;
  }

  public String getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public Place getFieldPlace() {
    if (mPlace != null) {
      mPlace.context = getContext();
    }
    return mPlace;
  }

  public String getFieldPrivacyDescription() {
    return mPrivacyDescription;
  }

  public Object getFieldPromotionInfo() {
    return mPromotionInfo;
  }

  public String getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public String getFieldStoryToken() {
    return mStoryToken;
  }

  public String getFieldThumbnail() {
    return mThumbnail;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }



  public static class APIRequestGet extends APIRequest<ScheduledPost> {

    ScheduledPost lastResponse = null;
    @Override
    public ScheduledPost getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "admin_creator",
      "creation_time",
      "feed_audience_description",
      "feed_targeting",
      "id",
      "message",
      "modified_time",
      "og_action_summary",
      "permalink_url",
      "place",
      "privacy_description",
      "promotion_info",
      "scheduled_publish_time",
      "story_token",
      "thumbnail",
      "video_id",
    };

    @Override
    public ScheduledPost parseResponse(String response) throws APIException {
      return ScheduledPost.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ScheduledPost execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ScheduledPost execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ScheduledPost> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ScheduledPost> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ScheduledPost>() {
           public ScheduledPost apply(String result) {
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

    public APIRequestGet requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGet requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestFeedAudienceDescriptionField () {
      return this.requestFeedAudienceDescriptionField(true);
    }
    public APIRequestGet requestFeedAudienceDescriptionField (boolean value) {
      this.requestField("feed_audience_description", value);
      return this;
    }
    public APIRequestGet requestFeedTargetingField () {
      return this.requestFeedTargetingField(true);
    }
    public APIRequestGet requestFeedTargetingField (boolean value) {
      this.requestField("feed_targeting", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGet requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGet requestModifiedTimeField () {
      return this.requestModifiedTimeField(true);
    }
    public APIRequestGet requestModifiedTimeField (boolean value) {
      this.requestField("modified_time", value);
      return this;
    }
    public APIRequestGet requestOgActionSummaryField () {
      return this.requestOgActionSummaryField(true);
    }
    public APIRequestGet requestOgActionSummaryField (boolean value) {
      this.requestField("og_action_summary", value);
      return this;
    }
    public APIRequestGet requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGet requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGet requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGet requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGet requestPrivacyDescriptionField () {
      return this.requestPrivacyDescriptionField(true);
    }
    public APIRequestGet requestPrivacyDescriptionField (boolean value) {
      this.requestField("privacy_description", value);
      return this;
    }
    public APIRequestGet requestPromotionInfoField () {
      return this.requestPromotionInfoField(true);
    }
    public APIRequestGet requestPromotionInfoField (boolean value) {
      this.requestField("promotion_info", value);
      return this;
    }
    public APIRequestGet requestScheduledPublishTimeField () {
      return this.requestScheduledPublishTimeField(true);
    }
    public APIRequestGet requestScheduledPublishTimeField (boolean value) {
      this.requestField("scheduled_publish_time", value);
      return this;
    }
    public APIRequestGet requestStoryTokenField () {
      return this.requestStoryTokenField(true);
    }
    public APIRequestGet requestStoryTokenField (boolean value) {
      this.requestField("story_token", value);
      return this;
    }
    public APIRequestGet requestThumbnailField () {
      return this.requestThumbnailField(true);
    }
    public APIRequestGet requestThumbnailField (boolean value) {
      this.requestField("thumbnail", value);
      return this;
    }
    public APIRequestGet requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGet requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
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

  public ScheduledPost copyFrom(ScheduledPost instance) {
    this.mAdminCreator = instance.mAdminCreator;
    this.mCreationTime = instance.mCreationTime;
    this.mFeedAudienceDescription = instance.mFeedAudienceDescription;
    this.mFeedTargeting = instance.mFeedTargeting;
    this.mId = instance.mId;
    this.mMessage = instance.mMessage;
    this.mModifiedTime = instance.mModifiedTime;
    this.mOgActionSummary = instance.mOgActionSummary;
    this.mPermalinkUrl = instance.mPermalinkUrl;
    this.mPlace = instance.mPlace;
    this.mPrivacyDescription = instance.mPrivacyDescription;
    this.mPromotionInfo = instance.mPromotionInfo;
    this.mScheduledPublishTime = instance.mScheduledPublishTime;
    this.mStoryToken = instance.mStoryToken;
    this.mThumbnail = instance.mThumbnail;
    this.mVideoId = instance.mVideoId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ScheduledPost> getParser() {
    return new APIRequest.ResponseParser<ScheduledPost>() {
      public APINodeList<ScheduledPost> parseResponse(String response, APIContext context, APIRequest<ScheduledPost> request) throws MalformedResponseException {
        return ScheduledPost.parseResponse(response, context, request);
      }
    };
  }
}
