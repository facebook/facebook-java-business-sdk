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
public class IGUser extends APINode {
  @SerializedName("biography")
  private String mBiography = null;
  @SerializedName("business_discovery")
  private IGUser mBusinessDiscovery = null;
  @SerializedName("followers_count")
  private Long mFollowersCount = null;
  @SerializedName("follows_count")
  private Long mFollowsCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_id")
  private Long mIgId = null;
  @SerializedName("is_ig_shopping_seller_policy_enabled")
  private Boolean mIsIgShoppingSellerPolicyEnabled = null;
  @SerializedName("media_count")
  private Long mMediaCount = null;
  @SerializedName("mentioned_comment")
  private IGComment mMentionedComment = null;
  @SerializedName("mentioned_media")
  private IGMedia mMentionedMedia = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("profile_picture_url")
  private String mProfilePictureUrl = null;
  @SerializedName("shopping_review_status")
  private String mShoppingReviewStatus = null;
  @SerializedName("username")
  private String mUsername = null;
  @SerializedName("website")
  private String mWebsite = null;
  protected static Gson gson = null;

  IGUser() {
  }

  public IGUser(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGUser(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGUser fetch() throws APIException{
    IGUser newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGUser fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGUser> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGUser fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGUser> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGUser> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGUser>)(
      new APIRequest<IGUser>(context, "", "/", "GET", IGUser.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGUser>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGUser.getParser())
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
  public static IGUser loadJSON(String json, APIContext context, String header) {
    IGUser igUser = getGson().fromJson(json, IGUser.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igUser.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igUser.context = context;
    igUser.rawValue = json;
    igUser.header = header;
    return igUser;
  }

  public static APINodeList<IGUser> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGUser> igUsers = new APINodeList<IGUser>(request, json, header);
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
          igUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igUsers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igUsers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igUsers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igUsers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igUsers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igUsers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igUsers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igUsers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igUsers;
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
              igUsers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igUsers;
          }

          // Sixth, check if it's pure JsonObject
          igUsers.clear();
          igUsers.add(loadJSON(json, context, header));
          return igUsers;
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

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMedia getMedia() {
    return new APIRequestGetMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMedia createMedia() {
    return new APIRequestCreateMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMediaPublish createMediaPublish() {
    return new APIRequestCreateMediaPublish(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMention createMention() {
    return new APIRequestCreateMention(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRecentlySearchedHashtags getRecentlySearchedHashtags() {
    return new APIRequestGetRecentlySearchedHashtags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetStories getStories() {
    return new APIRequestGetStories(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTags getTags() {
    return new APIRequestGetTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldBiography() {
    return mBiography;
  }

  public IGUser getFieldBusinessDiscovery() {
    if (mBusinessDiscovery != null) {
      mBusinessDiscovery.context = getContext();
    }
    return mBusinessDiscovery;
  }

  public Long getFieldFollowersCount() {
    return mFollowersCount;
  }

  public Long getFieldFollowsCount() {
    return mFollowsCount;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldIgId() {
    return mIgId;
  }

  public Boolean getFieldIsIgShoppingSellerPolicyEnabled() {
    return mIsIgShoppingSellerPolicyEnabled;
  }

  public Long getFieldMediaCount() {
    return mMediaCount;
  }

  public IGComment getFieldMentionedComment() {
    if (mMentionedComment != null) {
      mMentionedComment.context = getContext();
    }
    return mMentionedComment;
  }

  public IGMedia getFieldMentionedMedia() {
    if (mMentionedMedia != null) {
      mMentionedMedia.context = getContext();
    }
    return mMentionedMedia;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldProfilePictureUrl() {
    return mProfilePictureUrl;
  }

  public String getFieldShoppingReviewStatus() {
    return mShoppingReviewStatus;
  }

  public String getFieldUsername() {
    return mUsername;
  }

  public String getFieldWebsite() {
    return mWebsite;
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
      "since",
      "until",
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
    public APINodeList<InstagramInsightsResult> parseResponse(String response, String header) throws APIException {
      return InstagramInsightsResult.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InstagramInsightsResult>>() {
           public APINodeList<InstagramInsightsResult> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestGetInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetInsights setUntil (String until) {
      this.setParam("until", until);
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

  public static class APIRequestGetMedia extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "alt_text",
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
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMedia requestAltTextField () {
      return this.requestAltTextField(true);
    }
    public APIRequestGetMedia requestAltTextField (boolean value) {
      this.requestField("alt_text", value);
      return this;
    }
    public APIRequestGetMedia requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetMedia requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetMedia requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetMedia requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetMedia requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMedia requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMedia requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetMedia requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetMedia requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetMedia requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetMedia requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetMedia requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetMedia requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetMedia requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetMedia requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetMedia requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetMedia requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetMedia requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetMedia requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetMedia requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetMedia requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetMedia requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetMedia requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetMedia requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetMedia requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetMedia requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetMedia requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetMedia requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestCreateMedia extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "caption",
      "image_url",
      "location_id",
      "media_type",
      "thumb_offset",
      "user_tags",
      "video_url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGMedia parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMedia>() {
           public IGMedia apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/media", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMedia setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreateMedia setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }

    public APIRequestCreateMedia setLocationId (String locationId) {
      this.setParam("location_id", locationId);
      return this;
    }

    public APIRequestCreateMedia setMediaType (String mediaType) {
      this.setParam("media_type", mediaType);
      return this;
    }

    public APIRequestCreateMedia setThumbOffset (String thumbOffset) {
      this.setParam("thumb_offset", thumbOffset);
      return this;
    }

    public APIRequestCreateMedia setUserTags (List<Map<String, String>> userTags) {
      this.setParam("user_tags", userTags);
      return this;
    }
    public APIRequestCreateMedia setUserTags (String userTags) {
      this.setParam("user_tags", userTags);
      return this;
    }

    public APIRequestCreateMedia setVideoUrl (String videoUrl) {
      this.setParam("video_url", videoUrl);
      return this;
    }

    public APIRequestCreateMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMediaPublish extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "creation_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGMedia parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMedia>() {
           public IGMedia apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMediaPublish.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMediaPublish(String nodeId, APIContext context) {
      super(context, nodeId, "/media_publish", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMediaPublish setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMediaPublish setCreationId (Long creationId) {
      this.setParam("creation_id", creationId);
      return this;
    }
    public APIRequestCreateMediaPublish setCreationId (String creationId) {
      this.setParam("creation_id", creationId);
      return this;
    }

    public APIRequestCreateMediaPublish requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMediaPublish requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMediaPublish requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMention extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "comment_id",
      "media_id",
      "message",
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
               return APIRequestCreateMention.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMention(String nodeId, APIContext context) {
      super(context, nodeId, "/mentions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMention setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMention setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMention setCommentId (String commentId) {
      this.setParam("comment_id", commentId);
      return this;
    }

    public APIRequestCreateMention setMediaId (String mediaId) {
      this.setParam("media_id", mediaId);
      return this;
    }

    public APIRequestCreateMention setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateMention requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMention requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMention requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMention requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMention requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMention requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRecentlySearchedHashtags extends APIRequest<APINode> {

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
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetRecentlySearchedHashtags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetRecentlySearchedHashtags(String nodeId, APIContext context) {
      super(context, nodeId, "/recently_searched_hashtags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRecentlySearchedHashtags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRecentlySearchedHashtags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetStories extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "alt_text",
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
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetStories.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetStories(String nodeId, APIContext context) {
      super(context, nodeId, "/stories", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetStories setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetStories setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetStories requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetStories requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStories requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetStories requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStories requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetStories requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetStories requestAltTextField () {
      return this.requestAltTextField(true);
    }
    public APIRequestGetStories requestAltTextField (boolean value) {
      this.requestField("alt_text", value);
      return this;
    }
    public APIRequestGetStories requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetStories requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetStories requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetStories requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetStories requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetStories requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetStories requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetStories requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetStories requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetStories requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetStories requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetStories requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetStories requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetStories requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetStories requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetStories requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetStories requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetStories requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetStories requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetStories requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetStories requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetStories requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetStories requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetStories requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetStories requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetStories requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetStories requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetStories requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetTags extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "alt_text",
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
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTags(String nodeId, APIContext context) {
      super(context, nodeId, "/tags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTags requestAltTextField () {
      return this.requestAltTextField(true);
    }
    public APIRequestGetTags requestAltTextField (boolean value) {
      this.requestField("alt_text", value);
      return this;
    }
    public APIRequestGetTags requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetTags requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetTags requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetTags requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetTags requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTags requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTags requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetTags requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetTags requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetTags requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetTags requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetTags requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetTags requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetTags requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetTags requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetTags requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetTags requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetTags requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetTags requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetTags requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetTags requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetTags requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetTags requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetTags requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetTags requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetTags requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetTags requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetTags requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<IGUser> {

    IGUser lastResponse = null;
    @Override
    public IGUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "biography",
      "business_discovery",
      "followers_count",
      "follows_count",
      "id",
      "ig_id",
      "is_ig_shopping_seller_policy_enabled",
      "media_count",
      "mentioned_comment",
      "mentioned_media",
      "name",
      "profile_picture_url",
      "shopping_review_status",
      "username",
      "website",
    };

    @Override
    public IGUser parseResponse(String response, String header) throws APIException {
      return IGUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGUser>() {
           public IGUser apply(ResponseWrapper result) {
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

    public APIRequestGet requestBiographyField () {
      return this.requestBiographyField(true);
    }
    public APIRequestGet requestBiographyField (boolean value) {
      this.requestField("biography", value);
      return this;
    }
    public APIRequestGet requestBusinessDiscoveryField () {
      return this.requestBusinessDiscoveryField(true);
    }
    public APIRequestGet requestBusinessDiscoveryField (boolean value) {
      this.requestField("business_discovery", value);
      return this;
    }
    public APIRequestGet requestFollowersCountField () {
      return this.requestFollowersCountField(true);
    }
    public APIRequestGet requestFollowersCountField (boolean value) {
      this.requestField("followers_count", value);
      return this;
    }
    public APIRequestGet requestFollowsCountField () {
      return this.requestFollowsCountField(true);
    }
    public APIRequestGet requestFollowsCountField (boolean value) {
      this.requestField("follows_count", value);
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
    public APIRequestGet requestIsIgShoppingSellerPolicyEnabledField () {
      return this.requestIsIgShoppingSellerPolicyEnabledField(true);
    }
    public APIRequestGet requestIsIgShoppingSellerPolicyEnabledField (boolean value) {
      this.requestField("is_ig_shopping_seller_policy_enabled", value);
      return this;
    }
    public APIRequestGet requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGet requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
      return this;
    }
    public APIRequestGet requestMentionedCommentField () {
      return this.requestMentionedCommentField(true);
    }
    public APIRequestGet requestMentionedCommentField (boolean value) {
      this.requestField("mentioned_comment", value);
      return this;
    }
    public APIRequestGet requestMentionedMediaField () {
      return this.requestMentionedMediaField(true);
    }
    public APIRequestGet requestMentionedMediaField (boolean value) {
      this.requestField("mentioned_media", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestProfilePictureUrlField () {
      return this.requestProfilePictureUrlField(true);
    }
    public APIRequestGet requestProfilePictureUrlField (boolean value) {
      this.requestField("profile_picture_url", value);
      return this;
    }
    public APIRequestGet requestShoppingReviewStatusField () {
      return this.requestShoppingReviewStatusField(true);
    }
    public APIRequestGet requestShoppingReviewStatusField (boolean value) {
      this.requestField("shopping_review_status", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGet requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGet requestWebsiteField (boolean value) {
      this.requestField("website", value);
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

  public IGUser copyFrom(IGUser instance) {
    this.mBiography = instance.mBiography;
    this.mBusinessDiscovery = instance.mBusinessDiscovery;
    this.mFollowersCount = instance.mFollowersCount;
    this.mFollowsCount = instance.mFollowsCount;
    this.mId = instance.mId;
    this.mIgId = instance.mIgId;
    this.mIsIgShoppingSellerPolicyEnabled = instance.mIsIgShoppingSellerPolicyEnabled;
    this.mMediaCount = instance.mMediaCount;
    this.mMentionedComment = instance.mMentionedComment;
    this.mMentionedMedia = instance.mMentionedMedia;
    this.mName = instance.mName;
    this.mProfilePictureUrl = instance.mProfilePictureUrl;
    this.mShoppingReviewStatus = instance.mShoppingReviewStatus;
    this.mUsername = instance.mUsername;
    this.mWebsite = instance.mWebsite;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGUser> getParser() {
    return new APIRequest.ResponseParser<IGUser>() {
      public APINodeList<IGUser> parseResponse(String response, APIContext context, APIRequest<IGUser> request, String header) throws MalformedResponseException {
        return IGUser.parseResponse(response, context, request, header);
      }
    };
  }
}
