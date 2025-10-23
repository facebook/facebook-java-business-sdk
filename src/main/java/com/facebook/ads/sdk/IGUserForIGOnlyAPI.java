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
public class IGUserForIGOnlyAPI extends APINode {
  @SerializedName("account_type")
  private String mAccountType = null;
  @SerializedName("biography")
  private String mBiography = null;
  @SerializedName("followers_count")
  private Long mFollowersCount = null;
  @SerializedName("follows_count")
  private Long mFollowsCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("media_count")
  private Long mMediaCount = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("profile_picture_url")
  private String mProfilePictureUrl = null;
  @SerializedName("user_id")
  private Long mUserId = null;
  @SerializedName("username")
  private String mUsername = null;
  @SerializedName("website")
  private String mWebsite = null;
  protected static Gson gson = null;

  IGUserForIGOnlyAPI() {
  }

  public IGUserForIGOnlyAPI(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGUserForIGOnlyAPI(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGUserForIGOnlyAPI fetch() throws APIException{
    IGUserForIGOnlyAPI newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGUserForIGOnlyAPI fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGUserForIGOnlyAPI> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGUserForIGOnlyAPI fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGUserForIGOnlyAPI> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGUserForIGOnlyAPI> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGUserForIGOnlyAPI>)(
      new APIRequest<IGUserForIGOnlyAPI>(context, "", "/", "GET", IGUserForIGOnlyAPI.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGUserForIGOnlyAPI>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGUserForIGOnlyAPI.getParser())
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
  public static IGUserForIGOnlyAPI loadJSON(String json, APIContext context, String header) {
    IGUserForIGOnlyAPI igUserForIGOnlyAPI = getGson().fromJson(json, IGUserForIGOnlyAPI.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igUserForIGOnlyAPI.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igUserForIGOnlyAPI.context = context;
    igUserForIGOnlyAPI.rawValue = json;
    igUserForIGOnlyAPI.header = header;
    return igUserForIGOnlyAPI;
  }

  public static APINodeList<IGUserForIGOnlyAPI> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGUserForIGOnlyAPI> igUserForIGOnlyAPIs = new APINodeList<IGUserForIGOnlyAPI>(request, json, header);
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
          igUserForIGOnlyAPIs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igUserForIGOnlyAPIs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igUserForIGOnlyAPIs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igUserForIGOnlyAPIs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igUserForIGOnlyAPIs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igUserForIGOnlyAPIs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igUserForIGOnlyAPIs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igUserForIGOnlyAPIs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igUserForIGOnlyAPIs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igUserForIGOnlyAPIs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igUserForIGOnlyAPIs;
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
              igUserForIGOnlyAPIs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igUserForIGOnlyAPIs;
          }

          // Sixth, check if it's pure JsonObject
          igUserForIGOnlyAPIs.clear();
          igUserForIGOnlyAPIs.add(loadJSON(json, context, header));
          return igUserForIGOnlyAPIs;
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

  public APIRequestGetBusinessMessagingFeatureStatus getBusinessMessagingFeatureStatus() {
    return new APIRequestGetBusinessMessagingFeatureStatus(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetContentPublishingLimit getContentPublishingLimit() {
    return new APIRequestGetContentPublishingLimit(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetConversations getConversations() {
    return new APIRequestGetConversations(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLiveMedia getLiveMedia() {
    return new APIRequestGetLiveMedia(this.getPrefixedId().toString(), context);
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

  public APIRequestCreateMessageAttachment createMessageAttachment() {
    return new APIRequestCreateMessageAttachment(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMessage createMessage() {
    return new APIRequestCreateMessage(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteMessengerProfile deleteMessengerProfile() {
    return new APIRequestDeleteMessengerProfile(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMessengerProfile getMessengerProfile() {
    return new APIRequestGetMessengerProfile(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMessengerProfile createMessengerProfile() {
    return new APIRequestCreateMessengerProfile(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetStories getStories() {
    return new APIRequestGetStories(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteSubscribedApps deleteSubscribedApps() {
    return new APIRequestDeleteSubscribedApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSubscribedApps getSubscribedApps() {
    return new APIRequestGetSubscribedApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSubscribedApp createSubscribedApp() {
    return new APIRequestCreateSubscribedApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTags getTags() {
    return new APIRequestGetTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteWelcomeMessageFlows deleteWelcomeMessageFlows() {
    return new APIRequestDeleteWelcomeMessageFlows(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetWelcomeMessageFlows getWelcomeMessageFlows() {
    return new APIRequestGetWelcomeMessageFlows(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateWelcomeMessageFlow createWelcomeMessageFlow() {
    return new APIRequestCreateWelcomeMessageFlow(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountType() {
    return mAccountType;
  }

  public String getFieldBiography() {
    return mBiography;
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

  public Long getFieldMediaCount() {
    return mMediaCount;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldProfilePictureUrl() {
    return mProfilePictureUrl;
  }

  public Long getFieldUserId() {
    return mUserId;
  }

  public String getFieldUsername() {
    return mUsername;
  }

  public String getFieldWebsite() {
    return mWebsite;
  }



  public static class APIRequestGetBusinessMessagingFeatureStatus extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "feature",
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
               return APIRequestGetBusinessMessagingFeatureStatus.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetBusinessMessagingFeatureStatus(String nodeId, APIContext context) {
      super(context, nodeId, "/business_messaging_feature_status", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBusinessMessagingFeatureStatus setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBusinessMessagingFeatureStatus setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBusinessMessagingFeatureStatus setFeature (String feature) {
      this.setParam("feature", feature);
      return this;
    }

    public APIRequestGetBusinessMessagingFeatureStatus requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBusinessMessagingFeatureStatus requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessMessagingFeatureStatus requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBusinessMessagingFeatureStatus requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBusinessMessagingFeatureStatus requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBusinessMessagingFeatureStatus requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetContentPublishingLimit extends APIRequest<ContentPublishingLimitResponse> {

    APINodeList<ContentPublishingLimitResponse> lastResponse = null;
    @Override
    public APINodeList<ContentPublishingLimitResponse> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
    };

    public static final String[] FIELDS = {
      "config",
      "quota_usage",
    };

    @Override
    public APINodeList<ContentPublishingLimitResponse> parseResponse(String response, String header) throws APIException {
      return ContentPublishingLimitResponse.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ContentPublishingLimitResponse> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ContentPublishingLimitResponse> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ContentPublishingLimitResponse>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ContentPublishingLimitResponse>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ContentPublishingLimitResponse>>() {
           public APINodeList<ContentPublishingLimitResponse> apply(ResponseWrapper result) {
             try {
               return APIRequestGetContentPublishingLimit.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetContentPublishingLimit(String nodeId, APIContext context) {
      super(context, nodeId, "/content_publishing_limit", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetContentPublishingLimit setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetContentPublishingLimit setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetContentPublishingLimit requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetContentPublishingLimit requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetContentPublishingLimit requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetContentPublishingLimit requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetContentPublishingLimit requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetContentPublishingLimit requestQuotaUsageField () {
      return this.requestQuotaUsageField(true);
    }
    public APIRequestGetContentPublishingLimit requestQuotaUsageField (boolean value) {
      this.requestField("quota_usage", value);
      return this;
    }
  }

  public static class APIRequestGetConversations extends APIRequest<UnifiedThread> {

    APINodeList<UnifiedThread> lastResponse = null;
    @Override
    public APINodeList<UnifiedThread> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "folder",
      "platform",
      "tags",
      "user_id",
    };

    public static final String[] FIELDS = {
      "can_reply",
      "folder",
      "former_participants",
      "id",
      "is_owner",
      "is_subscribed",
      "link",
      "linked_group",
      "message_count",
      "name",
      "participants",
      "scoped_thread_key",
      "senders",
      "snippet",
      "unread_count",
      "updated_time",
      "wallpaper",
    };

    @Override
    public APINodeList<UnifiedThread> parseResponse(String response, String header) throws APIException {
      return UnifiedThread.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<UnifiedThread> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<UnifiedThread> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<UnifiedThread>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<UnifiedThread>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<UnifiedThread>>() {
           public APINodeList<UnifiedThread> apply(ResponseWrapper result) {
             try {
               return APIRequestGetConversations.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetConversations(String nodeId, APIContext context) {
      super(context, nodeId, "/conversations", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetConversations setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetConversations setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetConversations setFolder (String folder) {
      this.setParam("folder", folder);
      return this;
    }

    public APIRequestGetConversations setPlatform (UnifiedThread.EnumPlatform platform) {
      this.setParam("platform", platform);
      return this;
    }
    public APIRequestGetConversations setPlatform (String platform) {
      this.setParam("platform", platform);
      return this;
    }

    public APIRequestGetConversations setTags (List<String> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestGetConversations setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestGetConversations setUserId (String userId) {
      this.setParam("user_id", userId);
      return this;
    }

    public APIRequestGetConversations requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetConversations requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversations requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetConversations requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversations requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetConversations requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetConversations requestCanReplyField () {
      return this.requestCanReplyField(true);
    }
    public APIRequestGetConversations requestCanReplyField (boolean value) {
      this.requestField("can_reply", value);
      return this;
    }
    public APIRequestGetConversations requestFolderField () {
      return this.requestFolderField(true);
    }
    public APIRequestGetConversations requestFolderField (boolean value) {
      this.requestField("folder", value);
      return this;
    }
    public APIRequestGetConversations requestFormerParticipantsField () {
      return this.requestFormerParticipantsField(true);
    }
    public APIRequestGetConversations requestFormerParticipantsField (boolean value) {
      this.requestField("former_participants", value);
      return this;
    }
    public APIRequestGetConversations requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetConversations requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetConversations requestIsOwnerField () {
      return this.requestIsOwnerField(true);
    }
    public APIRequestGetConversations requestIsOwnerField (boolean value) {
      this.requestField("is_owner", value);
      return this;
    }
    public APIRequestGetConversations requestIsSubscribedField () {
      return this.requestIsSubscribedField(true);
    }
    public APIRequestGetConversations requestIsSubscribedField (boolean value) {
      this.requestField("is_subscribed", value);
      return this;
    }
    public APIRequestGetConversations requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetConversations requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetConversations requestLinkedGroupField () {
      return this.requestLinkedGroupField(true);
    }
    public APIRequestGetConversations requestLinkedGroupField (boolean value) {
      this.requestField("linked_group", value);
      return this;
    }
    public APIRequestGetConversations requestMessageCountField () {
      return this.requestMessageCountField(true);
    }
    public APIRequestGetConversations requestMessageCountField (boolean value) {
      this.requestField("message_count", value);
      return this;
    }
    public APIRequestGetConversations requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetConversations requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetConversations requestParticipantsField () {
      return this.requestParticipantsField(true);
    }
    public APIRequestGetConversations requestParticipantsField (boolean value) {
      this.requestField("participants", value);
      return this;
    }
    public APIRequestGetConversations requestScopedThreadKeyField () {
      return this.requestScopedThreadKeyField(true);
    }
    public APIRequestGetConversations requestScopedThreadKeyField (boolean value) {
      this.requestField("scoped_thread_key", value);
      return this;
    }
    public APIRequestGetConversations requestSendersField () {
      return this.requestSendersField(true);
    }
    public APIRequestGetConversations requestSendersField (boolean value) {
      this.requestField("senders", value);
      return this;
    }
    public APIRequestGetConversations requestSnippetField () {
      return this.requestSnippetField(true);
    }
    public APIRequestGetConversations requestSnippetField (boolean value) {
      this.requestField("snippet", value);
      return this;
    }
    public APIRequestGetConversations requestUnreadCountField () {
      return this.requestUnreadCountField(true);
    }
    public APIRequestGetConversations requestUnreadCountField (boolean value) {
      this.requestField("unread_count", value);
      return this;
    }
    public APIRequestGetConversations requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetConversations requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetConversations requestWallpaperField () {
      return this.requestWallpaperField(true);
    }
    public APIRequestGetConversations requestWallpaperField (boolean value) {
      this.requestField("wallpaper", value);
      return this;
    }
  }

  public static class APIRequestGetInsights extends APIRequest<InsightsResult> {

    APINodeList<InsightsResult> lastResponse = null;
    @Override
    public APINodeList<InsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdown",
      "metric",
      "metric_type",
      "period",
      "since",
      "timeframe",
      "until",
    };

    public static final String[] FIELDS = {
      "description",
      "description_from_api_doc",
      "id",
      "name",
      "period",
      "title",
      "values",
    };

    @Override
    public APINodeList<InsightsResult> parseResponse(String response, String header) throws APIException {
      return InsightsResult.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InsightsResult>>() {
           public APINodeList<InsightsResult> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestGetInsights setBreakdown (List<InsightsResult.EnumBreakdown> breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }
    public APIRequestGetInsights setBreakdown (String breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }

    public APIRequestGetInsights setMetric (List<InsightsResult.EnumMetric> metric) {
      this.setParam("metric", metric);
      return this;
    }
    public APIRequestGetInsights setMetric (String metric) {
      this.setParam("metric", metric);
      return this;
    }

    public APIRequestGetInsights setMetricType (InsightsResult.EnumMetricType metricType) {
      this.setParam("metric_type", metricType);
      return this;
    }
    public APIRequestGetInsights setMetricType (String metricType) {
      this.setParam("metric_type", metricType);
      return this;
    }

    public APIRequestGetInsights setPeriod (List<InsightsResult.EnumPeriod> period) {
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

    public APIRequestGetInsights setTimeframe (InsightsResult.EnumTimeframe timeframe) {
      this.setParam("timeframe", timeframe);
      return this;
    }
    public APIRequestGetInsights setTimeframe (String timeframe) {
      this.setParam("timeframe", timeframe);
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
    public APIRequestGetInsights requestDescriptionFromApiDocField () {
      return this.requestDescriptionFromApiDocField(true);
    }
    public APIRequestGetInsights requestDescriptionFromApiDocField (boolean value) {
      this.requestField("description_from_api_doc", value);
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

  public static class APIRequestGetLiveMedia extends APIRequest<APINode> {

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
               return APIRequestGetLiveMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetLiveMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/live_media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLiveMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLiveMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLiveMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLiveMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLiveMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMedia extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
      "until",
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
               return APIRequestGetMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestGetMedia setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetMedia setUntil (String until) {
      this.setParam("until", until);
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

  }

  public static class APIRequestCreateMedia extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "alt_text",
      "audio_name",
      "caption",
      "children",
      "collaborators",
      "cover_url",
      "image_url",
      "is_carousel_item",
      "location_id",
      "media_type",
      "product_tags",
      "share_to_feed",
      "thumb_offset",
      "trial_params",
      "upload_type",
      "user_tags",
      "video_url",
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
               return APIRequestCreateMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestCreateMedia setAltText (String altText) {
      this.setParam("alt_text", altText);
      return this;
    }

    public APIRequestCreateMedia setAudioName (String audioName) {
      this.setParam("audio_name", audioName);
      return this;
    }

    public APIRequestCreateMedia setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreateMedia setChildren (List<String> children) {
      this.setParam("children", children);
      return this;
    }
    public APIRequestCreateMedia setChildren (String children) {
      this.setParam("children", children);
      return this;
    }

    public APIRequestCreateMedia setCollaborators (List<String> collaborators) {
      this.setParam("collaborators", collaborators);
      return this;
    }
    public APIRequestCreateMedia setCollaborators (String collaborators) {
      this.setParam("collaborators", collaborators);
      return this;
    }

    public APIRequestCreateMedia setCoverUrl (String coverUrl) {
      this.setParam("cover_url", coverUrl);
      return this;
    }

    public APIRequestCreateMedia setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }

    public APIRequestCreateMedia setIsCarouselItem (Boolean isCarouselItem) {
      this.setParam("is_carousel_item", isCarouselItem);
      return this;
    }
    public APIRequestCreateMedia setIsCarouselItem (String isCarouselItem) {
      this.setParam("is_carousel_item", isCarouselItem);
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

    public APIRequestCreateMedia setProductTags (List<Map<String, String>> productTags) {
      this.setParam("product_tags", productTags);
      return this;
    }
    public APIRequestCreateMedia setProductTags (String productTags) {
      this.setParam("product_tags", productTags);
      return this;
    }

    public APIRequestCreateMedia setShareToFeed (Boolean shareToFeed) {
      this.setParam("share_to_feed", shareToFeed);
      return this;
    }
    public APIRequestCreateMedia setShareToFeed (String shareToFeed) {
      this.setParam("share_to_feed", shareToFeed);
      return this;
    }

    public APIRequestCreateMedia setThumbOffset (String thumbOffset) {
      this.setParam("thumb_offset", thumbOffset);
      return this;
    }

    public APIRequestCreateMedia setTrialParams (Map<String, String> trialParams) {
      this.setParam("trial_params", trialParams);
      return this;
    }
    public APIRequestCreateMedia setTrialParams (String trialParams) {
      this.setParam("trial_params", trialParams);
      return this;
    }

    public APIRequestCreateMedia setUploadType (String uploadType) {
      this.setParam("upload_type", uploadType);
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

  public static class APIRequestCreateMediaPublish extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "creation_id",
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
               return APIRequestCreateMediaPublish.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMediaPublish(String nodeId, APIContext context) {
      super(context, nodeId, "/mediapublish", "POST", Arrays.asList(PARAMS));
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
         },
         MoreExecutors.directExecutor()
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

  public static class APIRequestCreateMessageAttachment extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestCreateMessageAttachment.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMessageAttachment(String nodeId, APIContext context) {
      super(context, nodeId, "/messageattachments", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMessageAttachment setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMessageAttachment setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMessageAttachment setMessage (Object message) {
      this.setParam("message", message);
      return this;
    }
    public APIRequestCreateMessageAttachment setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateMessageAttachment requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMessageAttachment requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessageAttachment requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMessageAttachment requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessageAttachment requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMessageAttachment requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMessage extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "message",
      "messaging_type",
      "payload",
      "recipient",
      "sender_action",
      "tag",
      "thread_control",
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
               return APIRequestCreateMessage.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMessage(String nodeId, APIContext context) {
      super(context, nodeId, "/messages", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMessage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMessage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMessage setMessage (Object message) {
      this.setParam("message", message);
      return this;
    }
    public APIRequestCreateMessage setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateMessage setMessagingType (EnumMessagingType messagingType) {
      this.setParam("messaging_type", messagingType);
      return this;
    }
    public APIRequestCreateMessage setMessagingType (String messagingType) {
      this.setParam("messaging_type", messagingType);
      return this;
    }

    public APIRequestCreateMessage setPayload (String payload) {
      this.setParam("payload", payload);
      return this;
    }

    public APIRequestCreateMessage setRecipient (Object recipient) {
      this.setParam("recipient", recipient);
      return this;
    }
    public APIRequestCreateMessage setRecipient (String recipient) {
      this.setParam("recipient", recipient);
      return this;
    }

    public APIRequestCreateMessage setSenderAction (EnumSenderAction senderAction) {
      this.setParam("sender_action", senderAction);
      return this;
    }
    public APIRequestCreateMessage setSenderAction (String senderAction) {
      this.setParam("sender_action", senderAction);
      return this;
    }

    public APIRequestCreateMessage setTag (Object tag) {
      this.setParam("tag", tag);
      return this;
    }
    public APIRequestCreateMessage setTag (String tag) {
      this.setParam("tag", tag);
      return this;
    }

    public APIRequestCreateMessage setThreadControl (Object threadControl) {
      this.setParam("thread_control", threadControl);
      return this;
    }
    public APIRequestCreateMessage setThreadControl (String threadControl) {
      this.setParam("thread_control", threadControl);
      return this;
    }

    public APIRequestCreateMessage requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMessage requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMessage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMessage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteMessengerProfile extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "fields",
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
               return APIRequestDeleteMessengerProfile.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteMessengerProfile(String nodeId, APIContext context) {
      super(context, nodeId, "/messenger_profile", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteMessengerProfile setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteMessengerProfile setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteMessengerProfile setFields (List<EnumFields> fields) {
      this.setParam("fields", fields);
      return this;
    }
    public APIRequestDeleteMessengerProfile setFields (String fields) {
      this.setParam("fields", fields);
      return this;
    }

    public APIRequestDeleteMessengerProfile requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteMessengerProfile requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMessengerProfile requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteMessengerProfile requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMessengerProfile requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteMessengerProfile requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMessengerProfile extends APIRequest<APINode> {

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
               return APIRequestGetMessengerProfile.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetMessengerProfile(String nodeId, APIContext context) {
      super(context, nodeId, "/messenger_profile", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMessengerProfile setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMessengerProfile setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMessengerProfile requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMessengerProfile requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessengerProfile requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMessengerProfile requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessengerProfile requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMessengerProfile requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMessengerProfile extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ice_breakers",
      "persistent_menu",
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
               return APIRequestCreateMessengerProfile.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMessengerProfile(String nodeId, APIContext context) {
      super(context, nodeId, "/messenger_profile", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMessengerProfile setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMessengerProfile setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMessengerProfile setIceBreakers (List<Map<String, String>> iceBreakers) {
      this.setParam("ice_breakers", iceBreakers);
      return this;
    }
    public APIRequestCreateMessengerProfile setIceBreakers (String iceBreakers) {
      this.setParam("ice_breakers", iceBreakers);
      return this;
    }

    public APIRequestCreateMessengerProfile setPersistentMenu (List<Object> persistentMenu) {
      this.setParam("persistent_menu", persistentMenu);
      return this;
    }
    public APIRequestCreateMessengerProfile setPersistentMenu (String persistentMenu) {
      this.setParam("persistent_menu", persistentMenu);
      return this;
    }

    public APIRequestCreateMessengerProfile requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMessengerProfile requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessengerProfile requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMessengerProfile requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessengerProfile requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMessengerProfile requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetStories extends APIRequest<APINode> {

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
               return APIRequestGetStories.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

  }

  public static class APIRequestDeleteSubscribedApps extends APIRequest<APINode> {

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
               return APIRequestDeleteSubscribedApps.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteSubscribedApps(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_apps", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteSubscribedApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteSubscribedApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteSubscribedApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteSubscribedApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSubscribedApps extends APIRequest<APINode> {

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
               return APIRequestGetSubscribedApps.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSubscribedApps(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_apps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSubscribedApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSubscribedApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSubscribedApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSubscribedApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubscribedApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSubscribedApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubscribedApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSubscribedApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSubscribedApp extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "subscribed_fields",
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
               return APIRequestCreateSubscribedApp.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSubscribedApp(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSubscribedApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSubscribedApp setSubscribedFields (List<EnumSubscribedFields> subscribedFields) {
      this.setParam("subscribed_fields", subscribedFields);
      return this;
    }
    public APIRequestCreateSubscribedApp setSubscribedFields (String subscribedFields) {
      this.setParam("subscribed_fields", subscribedFields);
      return this;
    }

    public APIRequestCreateSubscribedApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSubscribedApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSubscribedApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetTags extends APIRequest<APINode> {

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
               return APIRequestGetTags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

  }

  public static class APIRequestDeleteWelcomeMessageFlows extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "flow_id",
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
               return APIRequestDeleteWelcomeMessageFlows.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteWelcomeMessageFlows(String nodeId, APIContext context) {
      super(context, nodeId, "/welcome_message_flows", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteWelcomeMessageFlows setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteWelcomeMessageFlows setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteWelcomeMessageFlows setFlowId (String flowId) {
      this.setParam("flow_id", flowId);
      return this;
    }

    public APIRequestDeleteWelcomeMessageFlows requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteWelcomeMessageFlows requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteWelcomeMessageFlows requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteWelcomeMessageFlows requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteWelcomeMessageFlows requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteWelcomeMessageFlows requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetWelcomeMessageFlows extends APIRequest<CTXPartnerAppWelcomeMessageFlow> {

    APINodeList<CTXPartnerAppWelcomeMessageFlow> lastResponse = null;
    @Override
    public APINodeList<CTXPartnerAppWelcomeMessageFlow> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "app_id",
      "flow_id",
    };

    public static final String[] FIELDS = {
      "compatible_platforms",
      "eligible_platforms",
      "id",
      "is_ig_only_flow",
      "is_used_in_ad",
      "last_update_time",
      "name",
      "welcome_message_flow",
      "welcome_message_sequence",
    };

    @Override
    public APINodeList<CTXPartnerAppWelcomeMessageFlow> parseResponse(String response, String header) throws APIException {
      return CTXPartnerAppWelcomeMessageFlow.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CTXPartnerAppWelcomeMessageFlow> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CTXPartnerAppWelcomeMessageFlow> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CTXPartnerAppWelcomeMessageFlow>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CTXPartnerAppWelcomeMessageFlow>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CTXPartnerAppWelcomeMessageFlow>>() {
           public APINodeList<CTXPartnerAppWelcomeMessageFlow> apply(ResponseWrapper result) {
             try {
               return APIRequestGetWelcomeMessageFlows.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetWelcomeMessageFlows(String nodeId, APIContext context) {
      super(context, nodeId, "/welcome_message_flows", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetWelcomeMessageFlows setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetWelcomeMessageFlows setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetWelcomeMessageFlows setAppId (String appId) {
      this.setParam("app_id", appId);
      return this;
    }

    public APIRequestGetWelcomeMessageFlows setFlowId (String flowId) {
      this.setParam("flow_id", flowId);
      return this;
    }

    public APIRequestGetWelcomeMessageFlows requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetWelcomeMessageFlows requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetWelcomeMessageFlows requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetWelcomeMessageFlows requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetWelcomeMessageFlows requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetWelcomeMessageFlows requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetWelcomeMessageFlows requestCompatiblePlatformsField () {
      return this.requestCompatiblePlatformsField(true);
    }
    public APIRequestGetWelcomeMessageFlows requestCompatiblePlatformsField (boolean value) {
      this.requestField("compatible_platforms", value);
      return this;
    }
    public APIRequestGetWelcomeMessageFlows requestEligiblePlatformsField () {
      return this.requestEligiblePlatformsField(true);
    }
    public APIRequestGetWelcomeMessageFlows requestEligiblePlatformsField (boolean value) {
      this.requestField("eligible_platforms", value);
      return this;
    }
    public APIRequestGetWelcomeMessageFlows requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetWelcomeMessageFlows requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetWelcomeMessageFlows requestIsIgOnlyFlowField () {
      return this.requestIsIgOnlyFlowField(true);
    }
    public APIRequestGetWelcomeMessageFlows requestIsIgOnlyFlowField (boolean value) {
      this.requestField("is_ig_only_flow", value);
      return this;
    }
    public APIRequestGetWelcomeMessageFlows requestIsUsedInAdField () {
      return this.requestIsUsedInAdField(true);
    }
    public APIRequestGetWelcomeMessageFlows requestIsUsedInAdField (boolean value) {
      this.requestField("is_used_in_ad", value);
      return this;
    }
    public APIRequestGetWelcomeMessageFlows requestLastUpdateTimeField () {
      return this.requestLastUpdateTimeField(true);
    }
    public APIRequestGetWelcomeMessageFlows requestLastUpdateTimeField (boolean value) {
      this.requestField("last_update_time", value);
      return this;
    }
    public APIRequestGetWelcomeMessageFlows requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetWelcomeMessageFlows requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetWelcomeMessageFlows requestWelcomeMessageFlowField () {
      return this.requestWelcomeMessageFlowField(true);
    }
    public APIRequestGetWelcomeMessageFlows requestWelcomeMessageFlowField (boolean value) {
      this.requestField("welcome_message_flow", value);
      return this;
    }
    public APIRequestGetWelcomeMessageFlows requestWelcomeMessageSequenceField () {
      return this.requestWelcomeMessageSequenceField(true);
    }
    public APIRequestGetWelcomeMessageFlows requestWelcomeMessageSequenceField (boolean value) {
      this.requestField("welcome_message_sequence", value);
      return this;
    }
  }

  public static class APIRequestCreateWelcomeMessageFlow extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "eligible_platforms",
      "flow_id",
      "name",
      "welcome_message_flow",
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
               return APIRequestCreateWelcomeMessageFlow.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateWelcomeMessageFlow(String nodeId, APIContext context) {
      super(context, nodeId, "/welcome_message_flows", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateWelcomeMessageFlow setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateWelcomeMessageFlow setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateWelcomeMessageFlow setEligiblePlatforms (List<EnumEligiblePlatforms> eligiblePlatforms) {
      this.setParam("eligible_platforms", eligiblePlatforms);
      return this;
    }
    public APIRequestCreateWelcomeMessageFlow setEligiblePlatforms (String eligiblePlatforms) {
      this.setParam("eligible_platforms", eligiblePlatforms);
      return this;
    }

    public APIRequestCreateWelcomeMessageFlow setFlowId (String flowId) {
      this.setParam("flow_id", flowId);
      return this;
    }

    public APIRequestCreateWelcomeMessageFlow setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateWelcomeMessageFlow setWelcomeMessageFlow (List<Object> welcomeMessageFlow) {
      this.setParam("welcome_message_flow", welcomeMessageFlow);
      return this;
    }
    public APIRequestCreateWelcomeMessageFlow setWelcomeMessageFlow (String welcomeMessageFlow) {
      this.setParam("welcome_message_flow", welcomeMessageFlow);
      return this;
    }

    public APIRequestCreateWelcomeMessageFlow requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateWelcomeMessageFlow requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateWelcomeMessageFlow requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateWelcomeMessageFlow requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateWelcomeMessageFlow requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateWelcomeMessageFlow requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<IGUserForIGOnlyAPI> {

    IGUserForIGOnlyAPI lastResponse = null;
    @Override
    public IGUserForIGOnlyAPI getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_type",
      "biography",
      "followers_count",
      "follows_count",
      "id",
      "media_count",
      "name",
      "profile_picture_url",
      "user_id",
      "username",
      "website",
    };

    @Override
    public IGUserForIGOnlyAPI parseResponse(String response, String header) throws APIException {
      return IGUserForIGOnlyAPI.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGUserForIGOnlyAPI execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGUserForIGOnlyAPI execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGUserForIGOnlyAPI> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGUserForIGOnlyAPI> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGUserForIGOnlyAPI>() {
           public IGUserForIGOnlyAPI apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

    public APIRequestGet requestAccountTypeField () {
      return this.requestAccountTypeField(true);
    }
    public APIRequestGet requestAccountTypeField (boolean value) {
      this.requestField("account_type", value);
      return this;
    }
    public APIRequestGet requestBiographyField () {
      return this.requestBiographyField(true);
    }
    public APIRequestGet requestBiographyField (boolean value) {
      this.requestField("biography", value);
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
    public APIRequestGet requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGet requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
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
    public APIRequestGet requestUserIdField () {
      return this.requestUserIdField(true);
    }
    public APIRequestGet requestUserIdField (boolean value) {
      this.requestField("user_id", value);
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

  public static enum EnumMessagingType {
      @SerializedName("MESSAGE_TAG")
      VALUE_MESSAGE_TAG("MESSAGE_TAG"),
      @SerializedName("RESPONSE")
      VALUE_RESPONSE("RESPONSE"),
      @SerializedName("UPDATE")
      VALUE_UPDATE("UPDATE"),
      @SerializedName("UTILITY")
      VALUE_UTILITY("UTILITY"),
      ;

      private String value;

      private EnumMessagingType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSenderAction {
      @SerializedName("MARK_SEEN")
      VALUE_MARK_SEEN("MARK_SEEN"),
      @SerializedName("REACT")
      VALUE_REACT("REACT"),
      @SerializedName("TYPING_OFF")
      VALUE_TYPING_OFF("TYPING_OFF"),
      @SerializedName("TYPING_ON")
      VALUE_TYPING_ON("TYPING_ON"),
      @SerializedName("UNREACT")
      VALUE_UNREACT("UNREACT"),
      ;

      private String value;

      private EnumSenderAction(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFields {
      @SerializedName("ACCOUNT_LINKING_URL")
      VALUE_ACCOUNT_LINKING_URL("ACCOUNT_LINKING_URL"),
      @SerializedName("COMMANDS")
      VALUE_COMMANDS("COMMANDS"),
      @SerializedName("DESCRIPTION")
      VALUE_DESCRIPTION("DESCRIPTION"),
      @SerializedName("GET_STARTED")
      VALUE_GET_STARTED("GET_STARTED"),
      @SerializedName("GREETING")
      VALUE_GREETING("GREETING"),
      @SerializedName("HOME_URL")
      VALUE_HOME_URL("HOME_URL"),
      @SerializedName("ICE_BREAKERS")
      VALUE_ICE_BREAKERS("ICE_BREAKERS"),
      @SerializedName("PERSISTENT_MENU")
      VALUE_PERSISTENT_MENU("PERSISTENT_MENU"),
      @SerializedName("PLATFORM")
      VALUE_PLATFORM("PLATFORM"),
      @SerializedName("SUBJECT_TO_NEW_EU_PRIVACY_RULES")
      VALUE_SUBJECT_TO_NEW_EU_PRIVACY_RULES("SUBJECT_TO_NEW_EU_PRIVACY_RULES"),
      @SerializedName("TITLE")
      VALUE_TITLE("TITLE"),
      @SerializedName("WHITELISTED_DOMAINS")
      VALUE_WHITELISTED_DOMAINS("WHITELISTED_DOMAINS"),
      ;

      private String value;

      private EnumFields(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSubscribedFields {
      @SerializedName("comment_poll_response")
      VALUE_COMMENT_POLL_RESPONSE("comment_poll_response"),
      @SerializedName("comments")
      VALUE_COMMENTS("comments"),
      @SerializedName("creator_marketplace_invited_creator_onboarding")
      VALUE_CREATOR_MARKETPLACE_INVITED_CREATOR_ONBOARDING("creator_marketplace_invited_creator_onboarding"),
      @SerializedName("creator_marketplace_projects")
      VALUE_CREATOR_MARKETPLACE_PROJECTS("creator_marketplace_projects"),
      @SerializedName("delta")
      VALUE_DELTA("delta"),
      @SerializedName("follow")
      VALUE_FOLLOW("follow"),
      @SerializedName("live_comments")
      VALUE_LIVE_COMMENTS("live_comments"),
      @SerializedName("mentions")
      VALUE_MENTIONS("mentions"),
      @SerializedName("message_edit")
      VALUE_MESSAGE_EDIT("message_edit"),
      @SerializedName("message_reactions")
      VALUE_MESSAGE_REACTIONS("message_reactions"),
      @SerializedName("messages")
      VALUE_MESSAGES("messages"),
      @SerializedName("messaging_handover")
      VALUE_MESSAGING_HANDOVER("messaging_handover"),
      @SerializedName("messaging_optins")
      VALUE_MESSAGING_OPTINS("messaging_optins"),
      @SerializedName("messaging_postbacks")
      VALUE_MESSAGING_POSTBACKS("messaging_postbacks"),
      @SerializedName("messaging_referral")
      VALUE_MESSAGING_REFERRAL("messaging_referral"),
      @SerializedName("messaging_seen")
      VALUE_MESSAGING_SEEN("messaging_seen"),
      @SerializedName("onboarding_welcome_message_series")
      VALUE_ONBOARDING_WELCOME_MESSAGE_SERIES("onboarding_welcome_message_series"),
      @SerializedName("share_to_story")
      VALUE_SHARE_TO_STORY("share_to_story"),
      @SerializedName("standby")
      VALUE_STANDBY("standby"),
      @SerializedName("story_insights")
      VALUE_STORY_INSIGHTS("story_insights"),
      @SerializedName("story_poll_response")
      VALUE_STORY_POLL_RESPONSE("story_poll_response"),
      @SerializedName("story_reactions")
      VALUE_STORY_REACTIONS("story_reactions"),
      ;

      private String value;

      private EnumSubscribedFields(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumEligiblePlatforms {
      @SerializedName("INSTAGRAM")
      VALUE_INSTAGRAM("INSTAGRAM"),
      @SerializedName("MESSENGER")
      VALUE_MESSENGER("MESSENGER"),
      @SerializedName("WHATSAPP")
      VALUE_WHATSAPP("WHATSAPP"),
      ;

      private String value;

      private EnumEligiblePlatforms(String value) {
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

  public IGUserForIGOnlyAPI copyFrom(IGUserForIGOnlyAPI instance) {
    this.mAccountType = instance.mAccountType;
    this.mBiography = instance.mBiography;
    this.mFollowersCount = instance.mFollowersCount;
    this.mFollowsCount = instance.mFollowsCount;
    this.mId = instance.mId;
    this.mMediaCount = instance.mMediaCount;
    this.mName = instance.mName;
    this.mProfilePictureUrl = instance.mProfilePictureUrl;
    this.mUserId = instance.mUserId;
    this.mUsername = instance.mUsername;
    this.mWebsite = instance.mWebsite;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGUserForIGOnlyAPI> getParser() {
    return new APIRequest.ResponseParser<IGUserForIGOnlyAPI>() {
      public APINodeList<IGUserForIGOnlyAPI> parseResponse(String response, APIContext context, APIRequest<IGUserForIGOnlyAPI> request, String header) throws MalformedResponseException {
        return IGUserForIGOnlyAPI.parseResponse(response, context, request, header);
      }
    };
  }
}
