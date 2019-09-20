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
public class UnifiedThread extends APINode {
  @SerializedName("can_reply")
  private Boolean mCanReply = null;
  @SerializedName("former_participants")
  private Object mFormerParticipants = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_subscribed")
  private Boolean mIsSubscribed = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("message_count")
  private Long mMessageCount = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("participants")
  private Object mParticipants = null;
  @SerializedName("scoped_thread_key")
  private String mScopedThreadKey = null;
  @SerializedName("senders")
  private Object mSenders = null;
  @SerializedName("snippet")
  private String mSnippet = null;
  @SerializedName("subject")
  private String mSubject = null;
  @SerializedName("unread_count")
  private Long mUnreadCount = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("wallpaper")
  private String mWallpaper = null;
  protected static Gson gson = null;

  UnifiedThread() {
  }

  public UnifiedThread(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public UnifiedThread(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public UnifiedThread fetch() throws APIException{
    UnifiedThread newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static UnifiedThread fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<UnifiedThread> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static UnifiedThread fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<UnifiedThread> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<UnifiedThread> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<UnifiedThread>)(
      new APIRequest<UnifiedThread>(context, "", "/", "GET", UnifiedThread.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<UnifiedThread>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", UnifiedThread.getParser())
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
  public static UnifiedThread loadJSON(String json, APIContext context, String header) {
    UnifiedThread unifiedThread = getGson().fromJson(json, UnifiedThread.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(unifiedThread.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    unifiedThread.context = context;
    unifiedThread.rawValue = json;
    unifiedThread.header = header;
    return unifiedThread;
  }

  public static APINodeList<UnifiedThread> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<UnifiedThread> unifiedThreads = new APINodeList<UnifiedThread>(request, json, header);
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
          unifiedThreads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return unifiedThreads;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                unifiedThreads.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            unifiedThreads.setPaging(previous, next);
            if (context.hasAppSecret()) {
              unifiedThreads.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              unifiedThreads.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  unifiedThreads.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              unifiedThreads.add(loadJSON(obj.toString(), context, header));
            }
          }
          return unifiedThreads;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              unifiedThreads.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return unifiedThreads;
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
              unifiedThreads.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return unifiedThreads;
          }

          // Sixth, check if it's pure JsonObject
          unifiedThreads.clear();
          unifiedThreads.add(loadJSON(json, context, header));
          return unifiedThreads;
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

  public APIRequestGetMessages getMessages() {
    return new APIRequestGetMessages(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMessage createMessage() {
    return new APIRequestCreateMessage(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Boolean getFieldCanReply() {
    return mCanReply;
  }

  public Object getFieldFormerParticipants() {
    return mFormerParticipants;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsSubscribed() {
    return mIsSubscribed;
  }

  public String getFieldLink() {
    return mLink;
  }

  public Long getFieldMessageCount() {
    return mMessageCount;
  }

  public String getFieldName() {
    return mName;
  }

  public Object getFieldParticipants() {
    return mParticipants;
  }

  public String getFieldScopedThreadKey() {
    return mScopedThreadKey;
  }

  public Object getFieldSenders() {
    return mSenders;
  }

  public String getFieldSnippet() {
    return mSnippet;
  }

  public String getFieldSubject() {
    return mSubject;
  }

  public Long getFieldUnreadCount() {
    return mUnreadCount;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public String getFieldWallpaper() {
    return mWallpaper;
  }



  public static class APIRequestGetMessages extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
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
               return APIRequestGetMessages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMessages(String nodeId, APIContext context) {
      super(context, nodeId, "/messages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMessages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMessages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMessages setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestGetMessages setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestGetMessages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMessages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMessages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMessages requestField (String field, boolean value) {
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
      "aloha_action",
      "android_key_hash",
      "applied_art_data",
      "associated_object_id",
      "attribution_app_id",
      "attribution_app_metadata",
      "audio_duration",
      "audio_type",
      "body",
      "broadcast_recipients",
      "client_tags",
      "coordinates",
      "copy_attachment",
      "copy_message",
      "customizations",
      "entry_point",
      "external_attachment_url",
      "image_type",
      "ios_bundle_id",
      "is_admin_model_v2_enabled",
      "is_broadcast",
      "is_montage",
      "is_voicemail",
      "lightweight_action_attachment",
      "link",
      "live_location_attachment",
      "location_attachment",
      "log_info",
      "mark_read_watermark_timestamp",
      "media",
      "message_attempt_id",
      "message_source_data",
      "montage_business_platform_data",
      "montage_frame_style",
      "montage_mentions",
      "montage_overlays",
      "montage_reply_data",
      "montage_supported_features",
      "montage_targets",
      "object_attachment",
      "offline_threading_id",
      "platform_xmd",
      "prng",
      "proxied_app_id",
      "recipients",
      "replied_to_message_id",
      "selected_cta_token",
      "shareable_attachment",
      "shown_cta_tokens",
      "skip_android_hash_check",
      "story_id",
      "tags",
      "tid",
      "tracking",
      "ttl",
      "use_existing_group",
      "video_thumbnail",
      "video_type",
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
         }
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


    public APIRequestCreateMessage setAlohaAction (String alohaAction) {
      this.setParam("aloha_action", alohaAction);
      return this;
    }

    public APIRequestCreateMessage setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }

    public APIRequestCreateMessage setAppliedArtData (Object appliedArtData) {
      this.setParam("applied_art_data", appliedArtData);
      return this;
    }
    public APIRequestCreateMessage setAppliedArtData (String appliedArtData) {
      this.setParam("applied_art_data", appliedArtData);
      return this;
    }

    public APIRequestCreateMessage setAssociatedObjectId (Object associatedObjectId) {
      this.setParam("associated_object_id", associatedObjectId);
      return this;
    }
    public APIRequestCreateMessage setAssociatedObjectId (String associatedObjectId) {
      this.setParam("associated_object_id", associatedObjectId);
      return this;
    }

    public APIRequestCreateMessage setAttributionAppId (String attributionAppId) {
      this.setParam("attribution_app_id", attributionAppId);
      return this;
    }

    public APIRequestCreateMessage setAttributionAppMetadata (String attributionAppMetadata) {
      this.setParam("attribution_app_metadata", attributionAppMetadata);
      return this;
    }

    public APIRequestCreateMessage setAudioDuration (Long audioDuration) {
      this.setParam("audio_duration", audioDuration);
      return this;
    }
    public APIRequestCreateMessage setAudioDuration (String audioDuration) {
      this.setParam("audio_duration", audioDuration);
      return this;
    }

    public APIRequestCreateMessage setAudioType (EnumAudioType audioType) {
      this.setParam("audio_type", audioType);
      return this;
    }
    public APIRequestCreateMessage setAudioType (String audioType) {
      this.setParam("audio_type", audioType);
      return this;
    }

    public APIRequestCreateMessage setBody (String body) {
      this.setParam("body", body);
      return this;
    }

    public APIRequestCreateMessage setBroadcastRecipients (Map<String, String> broadcastRecipients) {
      this.setParam("broadcast_recipients", broadcastRecipients);
      return this;
    }
    public APIRequestCreateMessage setBroadcastRecipients (String broadcastRecipients) {
      this.setParam("broadcast_recipients", broadcastRecipients);
      return this;
    }

    public APIRequestCreateMessage setClientTags (Map<String, String> clientTags) {
      this.setParam("client_tags", clientTags);
      return this;
    }
    public APIRequestCreateMessage setClientTags (String clientTags) {
      this.setParam("client_tags", clientTags);
      return this;
    }

    public APIRequestCreateMessage setCoordinates (Object coordinates) {
      this.setParam("coordinates", coordinates);
      return this;
    }
    public APIRequestCreateMessage setCoordinates (String coordinates) {
      this.setParam("coordinates", coordinates);
      return this;
    }

    public APIRequestCreateMessage setCopyAttachment (String copyAttachment) {
      this.setParam("copy_attachment", copyAttachment);
      return this;
    }

    public APIRequestCreateMessage setCopyMessage (String copyMessage) {
      this.setParam("copy_message", copyMessage);
      return this;
    }

    public APIRequestCreateMessage setCustomizations (Map<String, String> customizations) {
      this.setParam("customizations", customizations);
      return this;
    }
    public APIRequestCreateMessage setCustomizations (String customizations) {
      this.setParam("customizations", customizations);
      return this;
    }

    public APIRequestCreateMessage setEntryPoint (String entryPoint) {
      this.setParam("entry_point", entryPoint);
      return this;
    }

    public APIRequestCreateMessage setExternalAttachmentUrl (String externalAttachmentUrl) {
      this.setParam("external_attachment_url", externalAttachmentUrl);
      return this;
    }

    public APIRequestCreateMessage setImageType (EnumImageType imageType) {
      this.setParam("image_type", imageType);
      return this;
    }
    public APIRequestCreateMessage setImageType (String imageType) {
      this.setParam("image_type", imageType);
      return this;
    }

    public APIRequestCreateMessage setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestCreateMessage setIsAdminModelV2Enabled (Boolean isAdminModelV2Enabled) {
      this.setParam("is_admin_model_v2_enabled", isAdminModelV2Enabled);
      return this;
    }
    public APIRequestCreateMessage setIsAdminModelV2Enabled (String isAdminModelV2Enabled) {
      this.setParam("is_admin_model_v2_enabled", isAdminModelV2Enabled);
      return this;
    }

    public APIRequestCreateMessage setIsBroadcast (Boolean isBroadcast) {
      this.setParam("is_broadcast", isBroadcast);
      return this;
    }
    public APIRequestCreateMessage setIsBroadcast (String isBroadcast) {
      this.setParam("is_broadcast", isBroadcast);
      return this;
    }

    public APIRequestCreateMessage setIsMontage (Boolean isMontage) {
      this.setParam("is_montage", isMontage);
      return this;
    }
    public APIRequestCreateMessage setIsMontage (String isMontage) {
      this.setParam("is_montage", isMontage);
      return this;
    }

    public APIRequestCreateMessage setIsVoicemail (Boolean isVoicemail) {
      this.setParam("is_voicemail", isVoicemail);
      return this;
    }
    public APIRequestCreateMessage setIsVoicemail (String isVoicemail) {
      this.setParam("is_voicemail", isVoicemail);
      return this;
    }

    public APIRequestCreateMessage setLightweightActionAttachment (Object lightweightActionAttachment) {
      this.setParam("lightweight_action_attachment", lightweightActionAttachment);
      return this;
    }
    public APIRequestCreateMessage setLightweightActionAttachment (String lightweightActionAttachment) {
      this.setParam("lightweight_action_attachment", lightweightActionAttachment);
      return this;
    }

    public APIRequestCreateMessage setLink (String link) {
      this.setParam("link", link);
      return this;
    }

    public APIRequestCreateMessage setLiveLocationAttachment (Object liveLocationAttachment) {
      this.setParam("live_location_attachment", liveLocationAttachment);
      return this;
    }
    public APIRequestCreateMessage setLiveLocationAttachment (String liveLocationAttachment) {
      this.setParam("live_location_attachment", liveLocationAttachment);
      return this;
    }

    public APIRequestCreateMessage setLocationAttachment (Object locationAttachment) {
      this.setParam("location_attachment", locationAttachment);
      return this;
    }
    public APIRequestCreateMessage setLocationAttachment (String locationAttachment) {
      this.setParam("location_attachment", locationAttachment);
      return this;
    }

    public APIRequestCreateMessage setLogInfo (Map<String, String> logInfo) {
      this.setParam("log_info", logInfo);
      return this;
    }
    public APIRequestCreateMessage setLogInfo (String logInfo) {
      this.setParam("log_info", logInfo);
      return this;
    }

    public APIRequestCreateMessage setMarkReadWatermarkTimestamp (Long markReadWatermarkTimestamp) {
      this.setParam("mark_read_watermark_timestamp", markReadWatermarkTimestamp);
      return this;
    }
    public APIRequestCreateMessage setMarkReadWatermarkTimestamp (String markReadWatermarkTimestamp) {
      this.setParam("mark_read_watermark_timestamp", markReadWatermarkTimestamp);
      return this;
    }

    public APIRequestCreateMessage setMedia (List<String> media) {
      this.setParam("media", media);
      return this;
    }
    public APIRequestCreateMessage setMedia (String media) {
      this.setParam("media", media);
      return this;
    }

    public APIRequestCreateMessage setMessageAttemptId (String messageAttemptId) {
      this.setParam("message_attempt_id", messageAttemptId);
      return this;
    }

    public APIRequestCreateMessage setMessageSourceData (Object messageSourceData) {
      this.setParam("message_source_data", messageSourceData);
      return this;
    }
    public APIRequestCreateMessage setMessageSourceData (String messageSourceData) {
      this.setParam("message_source_data", messageSourceData);
      return this;
    }

    public APIRequestCreateMessage setMontageBusinessPlatformData (Map<String, String> montageBusinessPlatformData) {
      this.setParam("montage_business_platform_data", montageBusinessPlatformData);
      return this;
    }
    public APIRequestCreateMessage setMontageBusinessPlatformData (String montageBusinessPlatformData) {
      this.setParam("montage_business_platform_data", montageBusinessPlatformData);
      return this;
    }

    public APIRequestCreateMessage setMontageFrameStyle (EnumMontageFrameStyle montageFrameStyle) {
      this.setParam("montage_frame_style", montageFrameStyle);
      return this;
    }
    public APIRequestCreateMessage setMontageFrameStyle (String montageFrameStyle) {
      this.setParam("montage_frame_style", montageFrameStyle);
      return this;
    }

    public APIRequestCreateMessage setMontageMentions (Map<String, String> montageMentions) {
      this.setParam("montage_mentions", montageMentions);
      return this;
    }
    public APIRequestCreateMessage setMontageMentions (String montageMentions) {
      this.setParam("montage_mentions", montageMentions);
      return this;
    }

    public APIRequestCreateMessage setMontageOverlays (List<Map<String, String>> montageOverlays) {
      this.setParam("montage_overlays", montageOverlays);
      return this;
    }
    public APIRequestCreateMessage setMontageOverlays (String montageOverlays) {
      this.setParam("montage_overlays", montageOverlays);
      return this;
    }

    public APIRequestCreateMessage setMontageReplyData (Object montageReplyData) {
      this.setParam("montage_reply_data", montageReplyData);
      return this;
    }
    public APIRequestCreateMessage setMontageReplyData (String montageReplyData) {
      this.setParam("montage_reply_data", montageReplyData);
      return this;
    }

    public APIRequestCreateMessage setMontageSupportedFeatures (List<EnumMontageSupportedFeatures> montageSupportedFeatures) {
      this.setParam("montage_supported_features", montageSupportedFeatures);
      return this;
    }
    public APIRequestCreateMessage setMontageSupportedFeatures (String montageSupportedFeatures) {
      this.setParam("montage_supported_features", montageSupportedFeatures);
      return this;
    }

    public APIRequestCreateMessage setMontageTargets (List<String> montageTargets) {
      this.setParam("montage_targets", montageTargets);
      return this;
    }
    public APIRequestCreateMessage setMontageTargets (String montageTargets) {
      this.setParam("montage_targets", montageTargets);
      return this;
    }

    public APIRequestCreateMessage setObjectAttachment (String objectAttachment) {
      this.setParam("object_attachment", objectAttachment);
      return this;
    }

    public APIRequestCreateMessage setOfflineThreadingId (String offlineThreadingId) {
      this.setParam("offline_threading_id", offlineThreadingId);
      return this;
    }

    public APIRequestCreateMessage setPlatformXmd (String platformXmd) {
      this.setParam("platform_xmd", platformXmd);
      return this;
    }

    public APIRequestCreateMessage setPrng (JsonArray prng) {
      this.setParam("prng", prng);
      return this;
    }
    public APIRequestCreateMessage setPrng (String prng) {
      this.setParam("prng", prng);
      return this;
    }

    public APIRequestCreateMessage setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestCreateMessage setRecipients (List<Object> recipients) {
      this.setParam("recipients", recipients);
      return this;
    }
    public APIRequestCreateMessage setRecipients (String recipients) {
      this.setParam("recipients", recipients);
      return this;
    }

    public APIRequestCreateMessage setRepliedToMessageId (String repliedToMessageId) {
      this.setParam("replied_to_message_id", repliedToMessageId);
      return this;
    }

    public APIRequestCreateMessage setSelectedCtaToken (String selectedCtaToken) {
      this.setParam("selected_cta_token", selectedCtaToken);
      return this;
    }

    public APIRequestCreateMessage setShareableAttachment (Object shareableAttachment) {
      this.setParam("shareable_attachment", shareableAttachment);
      return this;
    }
    public APIRequestCreateMessage setShareableAttachment (String shareableAttachment) {
      this.setParam("shareable_attachment", shareableAttachment);
      return this;
    }

    public APIRequestCreateMessage setShownCtaTokens (List<String> shownCtaTokens) {
      this.setParam("shown_cta_tokens", shownCtaTokens);
      return this;
    }
    public APIRequestCreateMessage setShownCtaTokens (String shownCtaTokens) {
      this.setParam("shown_cta_tokens", shownCtaTokens);
      return this;
    }

    public APIRequestCreateMessage setSkipAndroidHashCheck (Boolean skipAndroidHashCheck) {
      this.setParam("skip_android_hash_check", skipAndroidHashCheck);
      return this;
    }
    public APIRequestCreateMessage setSkipAndroidHashCheck (String skipAndroidHashCheck) {
      this.setParam("skip_android_hash_check", skipAndroidHashCheck);
      return this;
    }

    public APIRequestCreateMessage setStoryId (Object storyId) {
      this.setParam("story_id", storyId);
      return this;
    }
    public APIRequestCreateMessage setStoryId (String storyId) {
      this.setParam("story_id", storyId);
      return this;
    }

    public APIRequestCreateMessage setTags (List<String> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreateMessage setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreateMessage setTid (String tid) {
      this.setParam("tid", tid);
      return this;
    }

    public APIRequestCreateMessage setTracking (String tracking) {
      this.setParam("tracking", tracking);
      return this;
    }

    public APIRequestCreateMessage setTtl (Long ttl) {
      this.setParam("ttl", ttl);
      return this;
    }
    public APIRequestCreateMessage setTtl (String ttl) {
      this.setParam("ttl", ttl);
      return this;
    }

    public APIRequestCreateMessage setUseExistingGroup (Boolean useExistingGroup) {
      this.setParam("use_existing_group", useExistingGroup);
      return this;
    }
    public APIRequestCreateMessage setUseExistingGroup (String useExistingGroup) {
      this.setParam("use_existing_group", useExistingGroup);
      return this;
    }

    public APIRequestCreateMessage setVideoThumbnail (File videoThumbnail) {
      this.setParam("video_thumbnail", videoThumbnail);
      return this;
    }
    public APIRequestCreateMessage setVideoThumbnail (String videoThumbnail) {
      this.setParam("video_thumbnail", videoThumbnail);
      return this;
    }

    public APIRequestCreateMessage setVideoType (EnumVideoType videoType) {
      this.setParam("video_type", videoType);
      return this;
    }
    public APIRequestCreateMessage setVideoType (String videoType) {
      this.setParam("video_type", videoType);
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

  public static class APIRequestGet extends APIRequest<UnifiedThread> {

    UnifiedThread lastResponse = null;
    @Override
    public UnifiedThread getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "can_reply",
      "former_participants",
      "id",
      "is_subscribed",
      "link",
      "message_count",
      "name",
      "participants",
      "scoped_thread_key",
      "senders",
      "snippet",
      "subject",
      "unread_count",
      "updated_time",
      "wallpaper",
    };

    @Override
    public UnifiedThread parseResponse(String response, String header) throws APIException {
      return UnifiedThread.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public UnifiedThread execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public UnifiedThread execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<UnifiedThread> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<UnifiedThread> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, UnifiedThread>() {
           public UnifiedThread apply(ResponseWrapper result) {
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

    public APIRequestGet requestCanReplyField () {
      return this.requestCanReplyField(true);
    }
    public APIRequestGet requestCanReplyField (boolean value) {
      this.requestField("can_reply", value);
      return this;
    }
    public APIRequestGet requestFormerParticipantsField () {
      return this.requestFormerParticipantsField(true);
    }
    public APIRequestGet requestFormerParticipantsField (boolean value) {
      this.requestField("former_participants", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsSubscribedField () {
      return this.requestIsSubscribedField(true);
    }
    public APIRequestGet requestIsSubscribedField (boolean value) {
      this.requestField("is_subscribed", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestMessageCountField () {
      return this.requestMessageCountField(true);
    }
    public APIRequestGet requestMessageCountField (boolean value) {
      this.requestField("message_count", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestParticipantsField () {
      return this.requestParticipantsField(true);
    }
    public APIRequestGet requestParticipantsField (boolean value) {
      this.requestField("participants", value);
      return this;
    }
    public APIRequestGet requestScopedThreadKeyField () {
      return this.requestScopedThreadKeyField(true);
    }
    public APIRequestGet requestScopedThreadKeyField (boolean value) {
      this.requestField("scoped_thread_key", value);
      return this;
    }
    public APIRequestGet requestSendersField () {
      return this.requestSendersField(true);
    }
    public APIRequestGet requestSendersField (boolean value) {
      this.requestField("senders", value);
      return this;
    }
    public APIRequestGet requestSnippetField () {
      return this.requestSnippetField(true);
    }
    public APIRequestGet requestSnippetField (boolean value) {
      this.requestField("snippet", value);
      return this;
    }
    public APIRequestGet requestSubjectField () {
      return this.requestSubjectField(true);
    }
    public APIRequestGet requestSubjectField (boolean value) {
      this.requestField("subject", value);
      return this;
    }
    public APIRequestGet requestUnreadCountField () {
      return this.requestUnreadCountField(true);
    }
    public APIRequestGet requestUnreadCountField (boolean value) {
      this.requestField("unread_count", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestWallpaperField () {
      return this.requestWallpaperField(true);
    }
    public APIRequestGet requestWallpaperField (boolean value) {
      this.requestField("wallpaper", value);
      return this;
    }
  }

  public static enum EnumAudioType {
      @SerializedName("FILE_ATTACHMENT")
      VALUE_FILE_ATTACHMENT("FILE_ATTACHMENT"),
      @SerializedName("VOICE_MESSAGE")
      VALUE_VOICE_MESSAGE("VOICE_MESSAGE"),
      @SerializedName("VOICE_MESSAGE_WITH_TRANSCRIPT")
      VALUE_VOICE_MESSAGE_WITH_TRANSCRIPT("VOICE_MESSAGE_WITH_TRANSCRIPT"),
      ;

      private String value;

      private EnumAudioType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumImageType {
      @SerializedName("FILE_ATTACHMENT")
      VALUE_FILE_ATTACHMENT("FILE_ATTACHMENT"),
      @SerializedName("MESSENGER_CAM")
      VALUE_MESSENGER_CAM("MESSENGER_CAM"),
      @SerializedName("TRANSPARENT")
      VALUE_TRANSPARENT("TRANSPARENT"),
      ;

      private String value;

      private EnumImageType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMontageFrameStyle {
      @SerializedName("no_border")
      VALUE_NO_BORDER("no_border"),
      ;

      private String value;

      private EnumMontageFrameStyle(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMontageSupportedFeatures {
      @SerializedName("LIGHTWEIGHT_REPLY")
      VALUE_LIGHTWEIGHT_REPLY("LIGHTWEIGHT_REPLY"),
      @SerializedName("SHOW_STORY_IN_MESSENGER_THREAD")
      VALUE_SHOW_STORY_IN_MESSENGER_THREAD("SHOW_STORY_IN_MESSENGER_THREAD"),
      ;

      private String value;

      private EnumMontageSupportedFeatures(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVideoType {
      @SerializedName("FILE_ATTACHMENT")
      VALUE_FILE_ATTACHMENT("FILE_ATTACHMENT"),
      @SerializedName("RECORDED_STICKER")
      VALUE_RECORDED_STICKER("RECORDED_STICKER"),
      @SerializedName("RECORDED_VIDEO")
      VALUE_RECORDED_VIDEO("RECORDED_VIDEO"),
      @SerializedName("SPEAKING_STICKER")
      VALUE_SPEAKING_STICKER("SPEAKING_STICKER"),
      @SerializedName("VIDEO_MAIL")
      VALUE_VIDEO_MAIL("VIDEO_MAIL"),
      ;

      private String value;

      private EnumVideoType(String value) {
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

  public UnifiedThread copyFrom(UnifiedThread instance) {
    this.mCanReply = instance.mCanReply;
    this.mFormerParticipants = instance.mFormerParticipants;
    this.mId = instance.mId;
    this.mIsSubscribed = instance.mIsSubscribed;
    this.mLink = instance.mLink;
    this.mMessageCount = instance.mMessageCount;
    this.mName = instance.mName;
    this.mParticipants = instance.mParticipants;
    this.mScopedThreadKey = instance.mScopedThreadKey;
    this.mSenders = instance.mSenders;
    this.mSnippet = instance.mSnippet;
    this.mSubject = instance.mSubject;
    this.mUnreadCount = instance.mUnreadCount;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mWallpaper = instance.mWallpaper;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<UnifiedThread> getParser() {
    return new APIRequest.ResponseParser<UnifiedThread>() {
      public APINodeList<UnifiedThread> parseResponse(String response, APIContext context, APIRequest<UnifiedThread> request, String header) throws MalformedResponseException {
        return UnifiedThread.parseResponse(response, context, request, header);
      }
    };
  }
}
