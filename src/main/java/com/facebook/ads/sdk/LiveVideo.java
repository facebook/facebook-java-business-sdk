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
public class LiveVideo extends APINode {
  @SerializedName("ad_break_config")
  private LiveVideoAdBreakConfig mAdBreakConfig = null;
  @SerializedName("ad_break_failure_reason")
  private String mAdBreakFailureReason = null;
  @SerializedName("broadcast_start_time")
  private String mBroadcastStartTime = null;
  @SerializedName("copyright")
  private VideoCopyright mCopyright = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("dash_ingest_url")
  private String mDashIngestUrl = null;
  @SerializedName("dash_preview_url")
  private String mDashPreviewUrl = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("embed_html")
  private Object mEmbedHtml = null;
  @SerializedName("from")
  private Object mFrom = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ingest_streams")
  private List<LiveVideoInputStream> mIngestStreams = null;
  @SerializedName("is_manual_mode")
  private Boolean mIsManualMode = null;
  @SerializedName("is_reference_only")
  private Boolean mIsReferenceOnly = null;
  @SerializedName("live_views")
  private Long mLiveViews = null;
  @SerializedName("overlay_url")
  private String mOverlayUrl = null;
  @SerializedName("permalink_url")
  private Object mPermalinkUrl = null;
  @SerializedName("planned_start_time")
  private String mPlannedStartTime = null;
  @SerializedName("recommended_encoder_settings")
  private LiveVideoRecommendedEncoderSettings mRecommendedEncoderSettings = null;
  @SerializedName("seconds_left")
  private Long mSecondsLeft = null;
  @SerializedName("secure_stream_url")
  private String mSecureStreamUrl = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("stream_url")
  private String mStreamUrl = null;
  @SerializedName("targeting")
  private LiveVideoTargeting mTargeting = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("total_views")
  private String mTotalViews = null;
  @SerializedName("video")
  private AdVideo mVideo = null;
  protected static Gson gson = null;

  LiveVideo() {
  }

  public LiveVideo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LiveVideo(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LiveVideo fetch() throws APIException{
    LiveVideo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LiveVideo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LiveVideo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LiveVideo fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LiveVideo> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LiveVideo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LiveVideo>)(
      new APIRequest<LiveVideo>(context, "", "/", "GET", LiveVideo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LiveVideo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LiveVideo.getParser())
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
  public static LiveVideo loadJSON(String json, APIContext context, String header) {
    LiveVideo liveVideo = getGson().fromJson(json, LiveVideo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(liveVideo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    liveVideo.context = context;
    liveVideo.rawValue = json;
    liveVideo.header = header;
    return liveVideo;
  }

  public static APINodeList<LiveVideo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LiveVideo> liveVideos = new APINodeList<LiveVideo>(request, json, header);
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
          liveVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return liveVideos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                liveVideos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            liveVideos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              liveVideos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              liveVideos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  liveVideos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              liveVideos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return liveVideos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              liveVideos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return liveVideos;
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
              liveVideos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return liveVideos;
          }

          // Sixth, check if it's pure JsonObject
          liveVideos.clear();
          liveVideos.add(loadJSON(json, context, header));
          return liveVideos;
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

  public APIRequestGetBlockedUsers getBlockedUsers() {
    return new APIRequestGetBlockedUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetComments getComments() {
    return new APIRequestGetComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCrosspostSharedPages getCrosspostSharedPages() {
    return new APIRequestGetCrosspostSharedPages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCrosspostedBroadcasts getCrosspostedBroadcasts() {
    return new APIRequestGetCrosspostedBroadcasts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetErrors getErrors() {
    return new APIRequestGetErrors(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateInputStream createInputStream() {
    return new APIRequestCreateInputStream(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPolls getPolls() {
    return new APIRequestGetPolls(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePoll createPoll() {
    return new APIRequestCreatePoll(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetReactions getReactions() {
    return new APIRequestGetReactions(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public LiveVideoAdBreakConfig getFieldAdBreakConfig() {
    return mAdBreakConfig;
  }

  public String getFieldAdBreakFailureReason() {
    return mAdBreakFailureReason;
  }

  public String getFieldBroadcastStartTime() {
    return mBroadcastStartTime;
  }

  public VideoCopyright getFieldCopyright() {
    if (mCopyright != null) {
      mCopyright.context = getContext();
    }
    return mCopyright;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldDashIngestUrl() {
    return mDashIngestUrl;
  }

  public String getFieldDashPreviewUrl() {
    return mDashPreviewUrl;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Object getFieldEmbedHtml() {
    return mEmbedHtml;
  }

  public Object getFieldFrom() {
    return mFrom;
  }

  public String getFieldId() {
    return mId;
  }

  public List<LiveVideoInputStream> getFieldIngestStreams() {
    return mIngestStreams;
  }

  public Boolean getFieldIsManualMode() {
    return mIsManualMode;
  }

  public Boolean getFieldIsReferenceOnly() {
    return mIsReferenceOnly;
  }

  public Long getFieldLiveViews() {
    return mLiveViews;
  }

  public String getFieldOverlayUrl() {
    return mOverlayUrl;
  }

  public Object getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public String getFieldPlannedStartTime() {
    return mPlannedStartTime;
  }

  public LiveVideoRecommendedEncoderSettings getFieldRecommendedEncoderSettings() {
    return mRecommendedEncoderSettings;
  }

  public Long getFieldSecondsLeft() {
    return mSecondsLeft;
  }

  public String getFieldSecureStreamUrl() {
    return mSecureStreamUrl;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldStreamUrl() {
    return mStreamUrl;
  }

  public LiveVideoTargeting getFieldTargeting() {
    return mTargeting;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldTotalViews() {
    return mTotalViews;
  }

  public AdVideo getFieldVideo() {
    if (mVideo != null) {
      mVideo.context = getContext();
    }
    return mVideo;
  }



  public static class APIRequestGetBlockedUsers extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "uid",
    };

    public static final String[] FIELDS = {
      "about",
      "age_range",
      "birthday",
      "cover",
      "currency",
      "education",
      "email",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "is_guest_user",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "quotes",
      "relationship_status",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "supports_donate_button_in_live_video",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "verified",
      "video_upload_limits",
      "website",
    };

    @Override
    public APINodeList<User> parseResponse(String response, String header) throws APIException {
      return User.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<User>>() {
           public APINodeList<User> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBlockedUsers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBlockedUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/blocked_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBlockedUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBlockedUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBlockedUsers setUid (Object uid) {
      this.setParam("uid", uid);
      return this;
    }
    public APIRequestGetBlockedUsers setUid (String uid) {
      this.setParam("uid", uid);
      return this;
    }

    public APIRequestGetBlockedUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBlockedUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBlockedUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBlockedUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBlockedUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBlockedUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBlockedUsers requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetBlockedUsers requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetBlockedUsers requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetBlockedUsers requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetBlockedUsers requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetBlockedUsers requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetBlockedUsers requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetBlockedUsers requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetBlockedUsers requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetBlockedUsers requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetBlockedUsers requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetBlockedUsers requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetBlockedUsers requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBlockedUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetBlockedUsers requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetBlockedUsers requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetBlockedUsers requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestIsGuestUserField () {
      return this.requestIsGuestUserField(true);
    }
    public APIRequestGetBlockedUsers requestIsGuestUserField (boolean value) {
      this.requestField("is_guest_user", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetBlockedUsers requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetBlockedUsers requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetBlockedUsers requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetBlockedUsers requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetBlockedUsers requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetBlockedUsers requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetBlockedUsers requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetBlockedUsers requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetBlockedUsers requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBlockedUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetBlockedUsers requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetBlockedUsers requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetBlockedUsers requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetBlockedUsers requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetBlockedUsers requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetBlockedUsers requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetBlockedUsers requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetBlockedUsers requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetBlockedUsers requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetBlockedUsers requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestSupportsDonateButtonInLiveVideoField () {
      return this.requestSupportsDonateButtonInLiveVideoField(true);
    }
    public APIRequestGetBlockedUsers requestSupportsDonateButtonInLiveVideoField (boolean value) {
      this.requestField("supports_donate_button_in_live_video", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetBlockedUsers requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetBlockedUsers requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetBlockedUsers requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetBlockedUsers requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetBlockedUsers requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetBlockedUsers requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetBlockedUsers requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetBlockedUsers requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
  }

  public static class APIRequestGetComments extends APIRequest<Comment> {

    APINodeList<Comment> lastResponse = null;
    @Override
    public APINodeList<Comment> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "filter",
      "live_filter",
      "order",
      "since",
    };

    public static final String[] FIELDS = {
      "admin_creator",
      "application",
      "attachment",
      "can_comment",
      "can_hide",
      "can_like",
      "can_remove",
      "can_reply_privately",
      "comment_count",
      "created_time",
      "from",
      "id",
      "is_hidden",
      "is_private",
      "like_count",
      "live_broadcast_timestamp",
      "message",
      "message_tags",
      "object",
      "parent",
      "permalink_url",
      "private_reply_conversation",
      "user_likes",
    };

    @Override
    public APINodeList<Comment> parseResponse(String response, String header) throws APIException {
      return Comment.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Comment> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Comment> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Comment>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Comment>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Comment>>() {
           public APINodeList<Comment> apply(ResponseWrapper result) {
             try {
               return APIRequestGetComments.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestGetComments setFilter (Comment.EnumFilter filter) {
      this.setParam("filter", filter);
      return this;
    }
    public APIRequestGetComments setFilter (String filter) {
      this.setParam("filter", filter);
      return this;
    }

    public APIRequestGetComments setLiveFilter (Comment.EnumLiveFilter liveFilter) {
      this.setParam("live_filter", liveFilter);
      return this;
    }
    public APIRequestGetComments setLiveFilter (String liveFilter) {
      this.setParam("live_filter", liveFilter);
      return this;
    }

    public APIRequestGetComments setOrder (Comment.EnumOrder order) {
      this.setParam("order", order);
      return this;
    }
    public APIRequestGetComments setOrder (String order) {
      this.setParam("order", order);
      return this;
    }

    public APIRequestGetComments setSince (String since) {
      this.setParam("since", since);
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

    public APIRequestGetComments requestAdminCreatorField () {
      return this.requestAdminCreatorField(true);
    }
    public APIRequestGetComments requestAdminCreatorField (boolean value) {
      this.requestField("admin_creator", value);
      return this;
    }
    public APIRequestGetComments requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGetComments requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGetComments requestAttachmentField () {
      return this.requestAttachmentField(true);
    }
    public APIRequestGetComments requestAttachmentField (boolean value) {
      this.requestField("attachment", value);
      return this;
    }
    public APIRequestGetComments requestCanCommentField () {
      return this.requestCanCommentField(true);
    }
    public APIRequestGetComments requestCanCommentField (boolean value) {
      this.requestField("can_comment", value);
      return this;
    }
    public APIRequestGetComments requestCanHideField () {
      return this.requestCanHideField(true);
    }
    public APIRequestGetComments requestCanHideField (boolean value) {
      this.requestField("can_hide", value);
      return this;
    }
    public APIRequestGetComments requestCanLikeField () {
      return this.requestCanLikeField(true);
    }
    public APIRequestGetComments requestCanLikeField (boolean value) {
      this.requestField("can_like", value);
      return this;
    }
    public APIRequestGetComments requestCanRemoveField () {
      return this.requestCanRemoveField(true);
    }
    public APIRequestGetComments requestCanRemoveField (boolean value) {
      this.requestField("can_remove", value);
      return this;
    }
    public APIRequestGetComments requestCanReplyPrivatelyField () {
      return this.requestCanReplyPrivatelyField(true);
    }
    public APIRequestGetComments requestCanReplyPrivatelyField (boolean value) {
      this.requestField("can_reply_privately", value);
      return this;
    }
    public APIRequestGetComments requestCommentCountField () {
      return this.requestCommentCountField(true);
    }
    public APIRequestGetComments requestCommentCountField (boolean value) {
      this.requestField("comment_count", value);
      return this;
    }
    public APIRequestGetComments requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetComments requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetComments requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetComments requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetComments requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetComments requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetComments requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetComments requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetComments requestIsPrivateField () {
      return this.requestIsPrivateField(true);
    }
    public APIRequestGetComments requestIsPrivateField (boolean value) {
      this.requestField("is_private", value);
      return this;
    }
    public APIRequestGetComments requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetComments requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetComments requestLiveBroadcastTimestampField () {
      return this.requestLiveBroadcastTimestampField(true);
    }
    public APIRequestGetComments requestLiveBroadcastTimestampField (boolean value) {
      this.requestField("live_broadcast_timestamp", value);
      return this;
    }
    public APIRequestGetComments requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetComments requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGetComments requestMessageTagsField () {
      return this.requestMessageTagsField(true);
    }
    public APIRequestGetComments requestMessageTagsField (boolean value) {
      this.requestField("message_tags", value);
      return this;
    }
    public APIRequestGetComments requestObjectField () {
      return this.requestObjectField(true);
    }
    public APIRequestGetComments requestObjectField (boolean value) {
      this.requestField("object", value);
      return this;
    }
    public APIRequestGetComments requestParentField () {
      return this.requestParentField(true);
    }
    public APIRequestGetComments requestParentField (boolean value) {
      this.requestField("parent", value);
      return this;
    }
    public APIRequestGetComments requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetComments requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetComments requestPrivateReplyConversationField () {
      return this.requestPrivateReplyConversationField(true);
    }
    public APIRequestGetComments requestPrivateReplyConversationField (boolean value) {
      this.requestField("private_reply_conversation", value);
      return this;
    }
    public APIRequestGetComments requestUserLikesField () {
      return this.requestUserLikesField(true);
    }
    public APIRequestGetComments requestUserLikesField (boolean value) {
      this.requestField("user_likes", value);
      return this;
    }
  }

  public static class APIRequestGetCrosspostSharedPages extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "access_token",
      "ad_campaign",
      "affiliation",
      "app_id",
      "artists_we_like",
      "attire",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "connected_page_backed_instagram_account",
      "contact_address",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "delivery_and_pickup_option_info",
      "description",
      "description_html",
      "differently_open_offerings",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "followers_count",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_root_id",
      "has_added_app",
      "has_transitioned_to_new_page_experience",
      "has_whatsapp_business_number",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "instant_articles_review_status",
      "is_always_open",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messaging_feature_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_page_welcome_message",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mini_shop_storefront",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "owner_business",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "pickup_options",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "privacy_info_url",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "rating_count",
      "recipient",
      "record_label",
      "release_date",
      "restaurant_services",
      "restaurant_specialties",
      "schedule",
      "screenplay_by",
      "season",
      "single_line_address",
      "starring",
      "start_info",
      "store_code",
      "store_location_descriptor",
      "store_number",
      "studio",
      "supports_donate_button_in_live_video",
      "supports_instant_articles",
      "talking_about_count",
      "temporary_status",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response, String header) throws APIException {
      return Page.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Page>>() {
           public APINodeList<Page> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCrosspostSharedPages.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCrosspostSharedPages(String nodeId, APIContext context) {
      super(context, nodeId, "/crosspost_shared_pages", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCrosspostSharedPages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCrosspostSharedPages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCrosspostSharedPages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCrosspostSharedPages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCrosspostSharedPages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCrosspostSharedPages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCrosspostSharedPages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCrosspostSharedPages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCrosspostSharedPages requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetCrosspostSharedPages requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestConnectedPageBackedInstagramAccountField () {
      return this.requestConnectedPageBackedInstagramAccountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestConnectedPageBackedInstagramAccountField (boolean value) {
      this.requestField("connected_page_backed_instagram_account", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetCrosspostSharedPages requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetCrosspostSharedPages requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDeliveryAndPickupOptionInfoField () {
      return this.requestDeliveryAndPickupOptionInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDeliveryAndPickupOptionInfoField (boolean value) {
      this.requestField("delivery_and_pickup_option_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDifferentlyOpenOfferingsField () {
      return this.requestDifferentlyOpenOfferingsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDifferentlyOpenOfferingsField (boolean value) {
      this.requestField("differently_open_offerings", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetCrosspostSharedPages requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFollowersCountField () {
      return this.requestFollowersCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFollowersCountField (boolean value) {
      this.requestField("followers_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetCrosspostSharedPages requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHasTransitionedToNewPageExperienceField () {
      return this.requestHasTransitionedToNewPageExperienceField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHasTransitionedToNewPageExperienceField (boolean value) {
      this.requestField("has_transitioned_to_new_page_experience", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetCrosspostSharedPages requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetCrosspostSharedPages requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestInstantArticlesReviewStatusField () {
      return this.requestInstantArticlesReviewStatusField(true);
    }
    public APIRequestGetCrosspostSharedPages requestInstantArticlesReviewStatusField (boolean value) {
      this.requestField("instant_articles_review_status", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetCrosspostSharedPages requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMessagingFeatureStatusField () {
      return this.requestMessagingFeatureStatusField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMessagingFeatureStatusField (boolean value) {
      this.requestField("messaging_feature_status", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultPageWelcomeMessageField () {
      return this.requestMessengerAdsDefaultPageWelcomeMessageField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultPageWelcomeMessageField (boolean value) {
      this.requestField("messenger_ads_default_page_welcome_message", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMiniShopStorefrontField () {
      return this.requestMiniShopStorefrontField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMiniShopStorefrontField (boolean value) {
      this.requestField("mini_shop_storefront", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetCrosspostSharedPages requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCrosspostSharedPages requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetCrosspostSharedPages requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetCrosspostSharedPages requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetCrosspostSharedPages requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetCrosspostSharedPages requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetCrosspostSharedPages requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetCrosspostSharedPages requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetCrosspostSharedPages requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPickupOptionsField () {
      return this.requestPickupOptionsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPickupOptionsField (boolean value) {
      this.requestField("pickup_options", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPrivacyInfoUrlField () {
      return this.requestPrivacyInfoUrlField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPrivacyInfoUrlField (boolean value) {
      this.requestField("privacy_info_url", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetCrosspostSharedPages requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetCrosspostSharedPages requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetCrosspostSharedPages requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetCrosspostSharedPages requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetCrosspostSharedPages requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetCrosspostSharedPages requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetCrosspostSharedPages requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetCrosspostSharedPages requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetCrosspostSharedPages requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestSupportsDonateButtonInLiveVideoField () {
      return this.requestSupportsDonateButtonInLiveVideoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestSupportsDonateButtonInLiveVideoField (boolean value) {
      this.requestField("supports_donate_button_in_live_video", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestSupportsInstantArticlesField () {
      return this.requestSupportsInstantArticlesField(true);
    }
    public APIRequestGetCrosspostSharedPages requestSupportsInstantArticlesField (boolean value) {
      this.requestField("supports_instant_articles", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestTemporaryStatusField () {
      return this.requestTemporaryStatusField(true);
    }
    public APIRequestGetCrosspostSharedPages requestTemporaryStatusField (boolean value) {
      this.requestField("temporary_status", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetCrosspostSharedPages requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetCrosspostSharedPages requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetCrosspostSharedPages requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetCrosspostSharedPages requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetCrosspostSharedPages requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetCrosspostSharedPages requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetCrosspostSharedPages requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetCrosspostSharedPages requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestGetCrosspostedBroadcasts extends APIRequest<LiveVideo> {

    APINodeList<LiveVideo> lastResponse = null;
    @Override
    public APINodeList<LiveVideo> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_break_config",
      "ad_break_failure_reason",
      "broadcast_start_time",
      "copyright",
      "creation_time",
      "dash_ingest_url",
      "dash_preview_url",
      "description",
      "embed_html",
      "from",
      "id",
      "ingest_streams",
      "is_manual_mode",
      "is_reference_only",
      "live_views",
      "overlay_url",
      "permalink_url",
      "planned_start_time",
      "recommended_encoder_settings",
      "seconds_left",
      "secure_stream_url",
      "status",
      "stream_url",
      "targeting",
      "title",
      "total_views",
      "video",
    };

    @Override
    public APINodeList<LiveVideo> parseResponse(String response, String header) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<LiveVideo> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<LiveVideo> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<LiveVideo>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<LiveVideo>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<LiveVideo>>() {
           public APINodeList<LiveVideo> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCrosspostedBroadcasts.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCrosspostedBroadcasts(String nodeId, APIContext context) {
      super(context, nodeId, "/crossposted_broadcasts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCrosspostedBroadcasts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCrosspostedBroadcasts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCrosspostedBroadcasts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCrosspostedBroadcasts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCrosspostedBroadcasts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCrosspostedBroadcasts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCrosspostedBroadcasts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCrosspostedBroadcasts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCrosspostedBroadcasts requestAdBreakConfigField () {
      return this.requestAdBreakConfigField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestAdBreakConfigField (boolean value) {
      this.requestField("ad_break_config", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestAdBreakFailureReasonField () {
      return this.requestAdBreakFailureReasonField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestAdBreakFailureReasonField (boolean value) {
      this.requestField("ad_break_failure_reason", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestBroadcastStartTimeField () {
      return this.requestBroadcastStartTimeField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestBroadcastStartTimeField (boolean value) {
      this.requestField("broadcast_start_time", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestCopyrightField () {
      return this.requestCopyrightField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestCopyrightField (boolean value) {
      this.requestField("copyright", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestDashIngestUrlField () {
      return this.requestDashIngestUrlField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestDashIngestUrlField (boolean value) {
      this.requestField("dash_ingest_url", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestDashPreviewUrlField () {
      return this.requestDashPreviewUrlField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestDashPreviewUrlField (boolean value) {
      this.requestField("dash_preview_url", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestEmbedHtmlField () {
      return this.requestEmbedHtmlField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestEmbedHtmlField (boolean value) {
      this.requestField("embed_html", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestIngestStreamsField () {
      return this.requestIngestStreamsField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestIngestStreamsField (boolean value) {
      this.requestField("ingest_streams", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestIsManualModeField () {
      return this.requestIsManualModeField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestIsManualModeField (boolean value) {
      this.requestField("is_manual_mode", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestIsReferenceOnlyField () {
      return this.requestIsReferenceOnlyField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestIsReferenceOnlyField (boolean value) {
      this.requestField("is_reference_only", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestLiveViewsField () {
      return this.requestLiveViewsField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestLiveViewsField (boolean value) {
      this.requestField("live_views", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestOverlayUrlField () {
      return this.requestOverlayUrlField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestOverlayUrlField (boolean value) {
      this.requestField("overlay_url", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestPlannedStartTimeField () {
      return this.requestPlannedStartTimeField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestPlannedStartTimeField (boolean value) {
      this.requestField("planned_start_time", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestRecommendedEncoderSettingsField () {
      return this.requestRecommendedEncoderSettingsField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestRecommendedEncoderSettingsField (boolean value) {
      this.requestField("recommended_encoder_settings", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestSecondsLeftField () {
      return this.requestSecondsLeftField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestSecondsLeftField (boolean value) {
      this.requestField("seconds_left", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestSecureStreamUrlField () {
      return this.requestSecureStreamUrlField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestSecureStreamUrlField (boolean value) {
      this.requestField("secure_stream_url", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestStreamUrlField () {
      return this.requestStreamUrlField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestStreamUrlField (boolean value) {
      this.requestField("stream_url", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestTotalViewsField () {
      return this.requestTotalViewsField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestTotalViewsField (boolean value) {
      this.requestField("total_views", value);
      return this;
    }
    public APIRequestGetCrosspostedBroadcasts requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGetCrosspostedBroadcasts requestVideoField (boolean value) {
      this.requestField("video", value);
      return this;
    }
  }

  public static class APIRequestGetErrors extends APIRequest<LiveVideoError> {

    APINodeList<LiveVideoError> lastResponse = null;
    @Override
    public APINodeList<LiveVideoError> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_time",
      "error_code",
      "error_message",
      "error_type",
      "id",
    };

    @Override
    public APINodeList<LiveVideoError> parseResponse(String response, String header) throws APIException {
      return LiveVideoError.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<LiveVideoError> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<LiveVideoError> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<LiveVideoError>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<LiveVideoError>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<LiveVideoError>>() {
           public APINodeList<LiveVideoError> apply(ResponseWrapper result) {
             try {
               return APIRequestGetErrors.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetErrors(String nodeId, APIContext context) {
      super(context, nodeId, "/errors", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetErrors setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetErrors setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetErrors requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetErrors requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetErrors requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetErrors requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetErrors requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetErrors requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetErrors requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetErrors requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetErrors requestErrorCodeField () {
      return this.requestErrorCodeField(true);
    }
    public APIRequestGetErrors requestErrorCodeField (boolean value) {
      this.requestField("error_code", value);
      return this;
    }
    public APIRequestGetErrors requestErrorMessageField () {
      return this.requestErrorMessageField(true);
    }
    public APIRequestGetErrors requestErrorMessageField (boolean value) {
      this.requestField("error_message", value);
      return this;
    }
    public APIRequestGetErrors requestErrorTypeField () {
      return this.requestErrorTypeField(true);
    }
    public APIRequestGetErrors requestErrorTypeField (boolean value) {
      this.requestField("error_type", value);
      return this;
    }
    public APIRequestGetErrors requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetErrors requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateInputStream extends APIRequest<LiveVideoInputStream> {

    LiveVideoInputStream lastResponse = null;
    @Override
    public LiveVideoInputStream getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LiveVideoInputStream parseResponse(String response, String header) throws APIException {
      return LiveVideoInputStream.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveVideoInputStream execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveVideoInputStream execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveVideoInputStream> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveVideoInputStream> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveVideoInputStream>() {
           public LiveVideoInputStream apply(ResponseWrapper result) {
             try {
               return APIRequestCreateInputStream.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateInputStream(String nodeId, APIContext context) {
      super(context, nodeId, "/input_streams", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateInputStream setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateInputStream setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateInputStream requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateInputStream requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInputStream requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateInputStream requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInputStream requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateInputStream requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPolls extends APIRequest<VideoPoll> {

    APINodeList<VideoPoll> lastResponse = null;
    @Override
    public APINodeList<VideoPoll> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "close_after_voting",
      "default_open",
      "id",
      "question",
      "show_gradient",
      "show_results",
      "status",
    };

    @Override
    public APINodeList<VideoPoll> parseResponse(String response, String header) throws APIException {
      return VideoPoll.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<VideoPoll> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<VideoPoll> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<VideoPoll>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<VideoPoll>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<VideoPoll>>() {
           public APINodeList<VideoPoll> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPolls.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPolls(String nodeId, APIContext context) {
      super(context, nodeId, "/polls", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPolls setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPolls setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPolls requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPolls requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPolls requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPolls requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPolls requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPolls requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPolls requestCloseAfterVotingField () {
      return this.requestCloseAfterVotingField(true);
    }
    public APIRequestGetPolls requestCloseAfterVotingField (boolean value) {
      this.requestField("close_after_voting", value);
      return this;
    }
    public APIRequestGetPolls requestDefaultOpenField () {
      return this.requestDefaultOpenField(true);
    }
    public APIRequestGetPolls requestDefaultOpenField (boolean value) {
      this.requestField("default_open", value);
      return this;
    }
    public APIRequestGetPolls requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPolls requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPolls requestQuestionField () {
      return this.requestQuestionField(true);
    }
    public APIRequestGetPolls requestQuestionField (boolean value) {
      this.requestField("question", value);
      return this;
    }
    public APIRequestGetPolls requestShowGradientField () {
      return this.requestShowGradientField(true);
    }
    public APIRequestGetPolls requestShowGradientField (boolean value) {
      this.requestField("show_gradient", value);
      return this;
    }
    public APIRequestGetPolls requestShowResultsField () {
      return this.requestShowResultsField(true);
    }
    public APIRequestGetPolls requestShowResultsField (boolean value) {
      this.requestField("show_results", value);
      return this;
    }
    public APIRequestGetPolls requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetPolls requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestCreatePoll extends APIRequest<VideoPoll> {

    VideoPoll lastResponse = null;
    @Override
    public VideoPoll getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "close_after_voting",
      "correct_option",
      "default_open",
      "options",
      "question",
      "show_gradient",
      "show_results",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public VideoPoll parseResponse(String response, String header) throws APIException {
      return VideoPoll.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VideoPoll execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoPoll execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VideoPoll> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoPoll> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VideoPoll>() {
           public VideoPoll apply(ResponseWrapper result) {
             try {
               return APIRequestCreatePoll.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreatePoll(String nodeId, APIContext context) {
      super(context, nodeId, "/polls", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePoll setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePoll setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePoll setCloseAfterVoting (Boolean closeAfterVoting) {
      this.setParam("close_after_voting", closeAfterVoting);
      return this;
    }
    public APIRequestCreatePoll setCloseAfterVoting (String closeAfterVoting) {
      this.setParam("close_after_voting", closeAfterVoting);
      return this;
    }

    public APIRequestCreatePoll setCorrectOption (Long correctOption) {
      this.setParam("correct_option", correctOption);
      return this;
    }
    public APIRequestCreatePoll setCorrectOption (String correctOption) {
      this.setParam("correct_option", correctOption);
      return this;
    }

    public APIRequestCreatePoll setDefaultOpen (Boolean defaultOpen) {
      this.setParam("default_open", defaultOpen);
      return this;
    }
    public APIRequestCreatePoll setDefaultOpen (String defaultOpen) {
      this.setParam("default_open", defaultOpen);
      return this;
    }

    public APIRequestCreatePoll setOptions (List<String> options) {
      this.setParam("options", options);
      return this;
    }
    public APIRequestCreatePoll setOptions (String options) {
      this.setParam("options", options);
      return this;
    }

    public APIRequestCreatePoll setQuestion (String question) {
      this.setParam("question", question);
      return this;
    }

    public APIRequestCreatePoll setShowGradient (Boolean showGradient) {
      this.setParam("show_gradient", showGradient);
      return this;
    }
    public APIRequestCreatePoll setShowGradient (String showGradient) {
      this.setParam("show_gradient", showGradient);
      return this;
    }

    public APIRequestCreatePoll setShowResults (Boolean showResults) {
      this.setParam("show_results", showResults);
      return this;
    }
    public APIRequestCreatePoll setShowResults (String showResults) {
      this.setParam("show_results", showResults);
      return this;
    }

    public APIRequestCreatePoll requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePoll requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePoll requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePoll requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePoll requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePoll requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetReactions extends APIRequest<Profile> {

    APINodeList<Profile> lastResponse = null;
    @Override
    public APINodeList<Profile> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "type",
    };

    public static final String[] FIELDS = {
      "can_post",
      "id",
      "link",
      "name",
      "pic",
      "pic_crop",
      "pic_large",
      "pic_small",
      "pic_square",
      "profile_type",
      "username",
    };

    @Override
    public APINodeList<Profile> parseResponse(String response, String header) throws APIException {
      return Profile.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Profile> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Profile> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Profile>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Profile>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Profile>>() {
           public APINodeList<Profile> apply(ResponseWrapper result) {
             try {
               return APIRequestGetReactions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetReactions(String nodeId, APIContext context) {
      super(context, nodeId, "/reactions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetReactions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetReactions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetReactions setType (Profile.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestGetReactions setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestGetReactions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetReactions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReactions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetReactions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetReactions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetReactions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetReactions requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetReactions requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetReactions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetReactions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetReactions requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetReactions requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetReactions requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetReactions requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetReactions requestPicField () {
      return this.requestPicField(true);
    }
    public APIRequestGetReactions requestPicField (boolean value) {
      this.requestField("pic", value);
      return this;
    }
    public APIRequestGetReactions requestPicCropField () {
      return this.requestPicCropField(true);
    }
    public APIRequestGetReactions requestPicCropField (boolean value) {
      this.requestField("pic_crop", value);
      return this;
    }
    public APIRequestGetReactions requestPicLargeField () {
      return this.requestPicLargeField(true);
    }
    public APIRequestGetReactions requestPicLargeField (boolean value) {
      this.requestField("pic_large", value);
      return this;
    }
    public APIRequestGetReactions requestPicSmallField () {
      return this.requestPicSmallField(true);
    }
    public APIRequestGetReactions requestPicSmallField (boolean value) {
      this.requestField("pic_small", value);
      return this;
    }
    public APIRequestGetReactions requestPicSquareField () {
      return this.requestPicSquareField(true);
    }
    public APIRequestGetReactions requestPicSquareField (boolean value) {
      this.requestField("pic_square", value);
      return this;
    }
    public APIRequestGetReactions requestProfileTypeField () {
      return this.requestProfileTypeField(true);
    }
    public APIRequestGetReactions requestProfileTypeField (boolean value) {
      this.requestField("profile_type", value);
      return this;
    }
    public APIRequestGetReactions requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetReactions requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<LiveVideo> {

    LiveVideo lastResponse = null;
    @Override
    public LiveVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "target_token",
    };

    public static final String[] FIELDS = {
      "ad_break_config",
      "ad_break_failure_reason",
      "broadcast_start_time",
      "copyright",
      "creation_time",
      "dash_ingest_url",
      "dash_preview_url",
      "description",
      "embed_html",
      "from",
      "id",
      "ingest_streams",
      "is_manual_mode",
      "is_reference_only",
      "live_views",
      "overlay_url",
      "permalink_url",
      "planned_start_time",
      "recommended_encoder_settings",
      "seconds_left",
      "secure_stream_url",
      "status",
      "stream_url",
      "targeting",
      "title",
      "total_views",
      "video",
    };

    @Override
    public LiveVideo parseResponse(String response, String header) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveVideo>() {
           public LiveVideo apply(ResponseWrapper result) {
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


    public APIRequestGet setTargetToken (String targetToken) {
      this.setParam("target_token", targetToken);
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

    public APIRequestGet requestAdBreakConfigField () {
      return this.requestAdBreakConfigField(true);
    }
    public APIRequestGet requestAdBreakConfigField (boolean value) {
      this.requestField("ad_break_config", value);
      return this;
    }
    public APIRequestGet requestAdBreakFailureReasonField () {
      return this.requestAdBreakFailureReasonField(true);
    }
    public APIRequestGet requestAdBreakFailureReasonField (boolean value) {
      this.requestField("ad_break_failure_reason", value);
      return this;
    }
    public APIRequestGet requestBroadcastStartTimeField () {
      return this.requestBroadcastStartTimeField(true);
    }
    public APIRequestGet requestBroadcastStartTimeField (boolean value) {
      this.requestField("broadcast_start_time", value);
      return this;
    }
    public APIRequestGet requestCopyrightField () {
      return this.requestCopyrightField(true);
    }
    public APIRequestGet requestCopyrightField (boolean value) {
      this.requestField("copyright", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestDashIngestUrlField () {
      return this.requestDashIngestUrlField(true);
    }
    public APIRequestGet requestDashIngestUrlField (boolean value) {
      this.requestField("dash_ingest_url", value);
      return this;
    }
    public APIRequestGet requestDashPreviewUrlField () {
      return this.requestDashPreviewUrlField(true);
    }
    public APIRequestGet requestDashPreviewUrlField (boolean value) {
      this.requestField("dash_preview_url", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEmbedHtmlField () {
      return this.requestEmbedHtmlField(true);
    }
    public APIRequestGet requestEmbedHtmlField (boolean value) {
      this.requestField("embed_html", value);
      return this;
    }
    public APIRequestGet requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGet requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIngestStreamsField () {
      return this.requestIngestStreamsField(true);
    }
    public APIRequestGet requestIngestStreamsField (boolean value) {
      this.requestField("ingest_streams", value);
      return this;
    }
    public APIRequestGet requestIsManualModeField () {
      return this.requestIsManualModeField(true);
    }
    public APIRequestGet requestIsManualModeField (boolean value) {
      this.requestField("is_manual_mode", value);
      return this;
    }
    public APIRequestGet requestIsReferenceOnlyField () {
      return this.requestIsReferenceOnlyField(true);
    }
    public APIRequestGet requestIsReferenceOnlyField (boolean value) {
      this.requestField("is_reference_only", value);
      return this;
    }
    public APIRequestGet requestLiveViewsField () {
      return this.requestLiveViewsField(true);
    }
    public APIRequestGet requestLiveViewsField (boolean value) {
      this.requestField("live_views", value);
      return this;
    }
    public APIRequestGet requestOverlayUrlField () {
      return this.requestOverlayUrlField(true);
    }
    public APIRequestGet requestOverlayUrlField (boolean value) {
      this.requestField("overlay_url", value);
      return this;
    }
    public APIRequestGet requestPermalinkUrlField () {
      return this.requestPermalinkUrlField(true);
    }
    public APIRequestGet requestPermalinkUrlField (boolean value) {
      this.requestField("permalink_url", value);
      return this;
    }
    public APIRequestGet requestPlannedStartTimeField () {
      return this.requestPlannedStartTimeField(true);
    }
    public APIRequestGet requestPlannedStartTimeField (boolean value) {
      this.requestField("planned_start_time", value);
      return this;
    }
    public APIRequestGet requestRecommendedEncoderSettingsField () {
      return this.requestRecommendedEncoderSettingsField(true);
    }
    public APIRequestGet requestRecommendedEncoderSettingsField (boolean value) {
      this.requestField("recommended_encoder_settings", value);
      return this;
    }
    public APIRequestGet requestSecondsLeftField () {
      return this.requestSecondsLeftField(true);
    }
    public APIRequestGet requestSecondsLeftField (boolean value) {
      this.requestField("seconds_left", value);
      return this;
    }
    public APIRequestGet requestSecureStreamUrlField () {
      return this.requestSecureStreamUrlField(true);
    }
    public APIRequestGet requestSecureStreamUrlField (boolean value) {
      this.requestField("secure_stream_url", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestStreamUrlField () {
      return this.requestStreamUrlField(true);
    }
    public APIRequestGet requestStreamUrlField (boolean value) {
      this.requestField("stream_url", value);
      return this;
    }
    public APIRequestGet requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGet requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestTotalViewsField () {
      return this.requestTotalViewsField(true);
    }
    public APIRequestGet requestTotalViewsField (boolean value) {
      this.requestField("total_views", value);
      return this;
    }
    public APIRequestGet requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGet requestVideoField (boolean value) {
      this.requestField("video", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<LiveVideo> {

    LiveVideo lastResponse = null;
    @Override
    public LiveVideo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "allow_bm_crossposting",
      "content_tags",
      "cross_share_to_group_ids",
      "crossposting_actions",
      "custom_labels",
      "description",
      "direct_share_status",
      "embeddable",
      "end_live_video",
      "event_params",
      "is_audio_only",
      "is_manual_mode",
      "live_comment_moderation_setting",
      "master_ingest_stream_id",
      "og_icon_id",
      "og_phrase",
      "persistent_stream_key_status",
      "place",
      "planned_start_time",
      "privacy",
      "published",
      "schedule_custom_profile_image",
      "schedule_feed_background_image",
      "sponsor_id",
      "sponsor_relationship",
      "status",
      "stream_type",
      "tags",
      "targeting",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LiveVideo parseResponse(String response, String header) throws APIException {
      return LiveVideo.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LiveVideo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveVideo execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LiveVideo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveVideo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LiveVideo>() {
           public LiveVideo apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestUpdate setAllowBmCrossposting (Boolean allowBmCrossposting) {
      this.setParam("allow_bm_crossposting", allowBmCrossposting);
      return this;
    }
    public APIRequestUpdate setAllowBmCrossposting (String allowBmCrossposting) {
      this.setParam("allow_bm_crossposting", allowBmCrossposting);
      return this;
    }

    public APIRequestUpdate setContentTags (List<String> contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }
    public APIRequestUpdate setContentTags (String contentTags) {
      this.setParam("content_tags", contentTags);
      return this;
    }

    public APIRequestUpdate setCrossShareToGroupIds (List<String> crossShareToGroupIds) {
      this.setParam("cross_share_to_group_ids", crossShareToGroupIds);
      return this;
    }
    public APIRequestUpdate setCrossShareToGroupIds (String crossShareToGroupIds) {
      this.setParam("cross_share_to_group_ids", crossShareToGroupIds);
      return this;
    }

    public APIRequestUpdate setCrosspostingActions (List<Map<String, String>> crosspostingActions) {
      this.setParam("crossposting_actions", crosspostingActions);
      return this;
    }
    public APIRequestUpdate setCrosspostingActions (String crosspostingActions) {
      this.setParam("crossposting_actions", crosspostingActions);
      return this;
    }

    public APIRequestUpdate setCustomLabels (List<String> customLabels) {
      this.setParam("custom_labels", customLabels);
      return this;
    }
    public APIRequestUpdate setCustomLabels (String customLabels) {
      this.setParam("custom_labels", customLabels);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setDirectShareStatus (Long directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }
    public APIRequestUpdate setDirectShareStatus (String directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }

    public APIRequestUpdate setEmbeddable (Boolean embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }
    public APIRequestUpdate setEmbeddable (String embeddable) {
      this.setParam("embeddable", embeddable);
      return this;
    }

    public APIRequestUpdate setEndLiveVideo (Boolean endLiveVideo) {
      this.setParam("end_live_video", endLiveVideo);
      return this;
    }
    public APIRequestUpdate setEndLiveVideo (String endLiveVideo) {
      this.setParam("end_live_video", endLiveVideo);
      return this;
    }

    public APIRequestUpdate setEventParams (Object eventParams) {
      this.setParam("event_params", eventParams);
      return this;
    }
    public APIRequestUpdate setEventParams (String eventParams) {
      this.setParam("event_params", eventParams);
      return this;
    }

    public APIRequestUpdate setIsAudioOnly (Boolean isAudioOnly) {
      this.setParam("is_audio_only", isAudioOnly);
      return this;
    }
    public APIRequestUpdate setIsAudioOnly (String isAudioOnly) {
      this.setParam("is_audio_only", isAudioOnly);
      return this;
    }

    public APIRequestUpdate setIsManualMode (Boolean isManualMode) {
      this.setParam("is_manual_mode", isManualMode);
      return this;
    }
    public APIRequestUpdate setIsManualMode (String isManualMode) {
      this.setParam("is_manual_mode", isManualMode);
      return this;
    }

    public APIRequestUpdate setLiveCommentModerationSetting (List<LiveVideo.EnumLiveCommentModerationSetting> liveCommentModerationSetting) {
      this.setParam("live_comment_moderation_setting", liveCommentModerationSetting);
      return this;
    }
    public APIRequestUpdate setLiveCommentModerationSetting (String liveCommentModerationSetting) {
      this.setParam("live_comment_moderation_setting", liveCommentModerationSetting);
      return this;
    }

    public APIRequestUpdate setMasterIngestStreamId (String masterIngestStreamId) {
      this.setParam("master_ingest_stream_id", masterIngestStreamId);
      return this;
    }

    public APIRequestUpdate setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestUpdate setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestUpdate setPersistentStreamKeyStatus (LiveVideo.EnumPersistentStreamKeyStatus persistentStreamKeyStatus) {
      this.setParam("persistent_stream_key_status", persistentStreamKeyStatus);
      return this;
    }
    public APIRequestUpdate setPersistentStreamKeyStatus (String persistentStreamKeyStatus) {
      this.setParam("persistent_stream_key_status", persistentStreamKeyStatus);
      return this;
    }

    public APIRequestUpdate setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestUpdate setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestUpdate setPlannedStartTime (String plannedStartTime) {
      this.setParam("planned_start_time", plannedStartTime);
      return this;
    }

    public APIRequestUpdate setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestUpdate setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestUpdate setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestUpdate setScheduleCustomProfileImage (File scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }
    public APIRequestUpdate setScheduleCustomProfileImage (String scheduleCustomProfileImage) {
      this.setParam("schedule_custom_profile_image", scheduleCustomProfileImage);
      return this;
    }

    public APIRequestUpdate setScheduleFeedBackgroundImage (File scheduleFeedBackgroundImage) {
      this.setParam("schedule_feed_background_image", scheduleFeedBackgroundImage);
      return this;
    }
    public APIRequestUpdate setScheduleFeedBackgroundImage (String scheduleFeedBackgroundImage) {
      this.setParam("schedule_feed_background_image", scheduleFeedBackgroundImage);
      return this;
    }

    public APIRequestUpdate setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestUpdate setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestUpdate setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestUpdate setStatus (LiveVideo.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate setStreamType (LiveVideo.EnumStreamType streamType) {
      this.setParam("stream_type", streamType);
      return this;
    }
    public APIRequestUpdate setStreamType (String streamType) {
      this.setParam("stream_type", streamType);
      return this;
    }

    public APIRequestUpdate setTags (List<Long> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestUpdate setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestUpdate setTargeting (Object targeting) {
      this.setParam("targeting", targeting);
      return this;
    }
    public APIRequestUpdate setTargeting (String targeting) {
      this.setParam("targeting", targeting);
      return this;
    }

    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
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

  public static enum EnumProjection {
      @SerializedName("CUBEMAP")
      VALUE_CUBEMAP("CUBEMAP"),
      @SerializedName("EQUIRECTANGULAR")
      VALUE_EQUIRECTANGULAR("EQUIRECTANGULAR"),
      @SerializedName("HALF_EQUIRECTANGULAR")
      VALUE_HALF_EQUIRECTANGULAR("HALF_EQUIRECTANGULAR"),
      ;

      private String value;

      private EnumProjection(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSpatialAudioFormat {
      @SerializedName("ambiX_4")
      VALUE_AMBIX_4("ambiX_4"),
      ;

      private String value;

      private EnumSpatialAudioFormat(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("LIVE_NOW")
      VALUE_LIVE_NOW("LIVE_NOW"),
      @SerializedName("SCHEDULED_CANCELED")
      VALUE_SCHEDULED_CANCELED("SCHEDULED_CANCELED"),
      @SerializedName("SCHEDULED_LIVE")
      VALUE_SCHEDULED_LIVE("SCHEDULED_LIVE"),
      @SerializedName("SCHEDULED_UNPUBLISHED")
      VALUE_SCHEDULED_UNPUBLISHED("SCHEDULED_UNPUBLISHED"),
      @SerializedName("UNPUBLISHED")
      VALUE_UNPUBLISHED("UNPUBLISHED"),
      ;

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStereoscopicMode {
      @SerializedName("LEFT_RIGHT")
      VALUE_LEFT_RIGHT("LEFT_RIGHT"),
      @SerializedName("MONO")
      VALUE_MONO("MONO"),
      @SerializedName("TOP_BOTTOM")
      VALUE_TOP_BOTTOM("TOP_BOTTOM"),
      ;

      private String value;

      private EnumStereoscopicMode(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStreamType {
      @SerializedName("AMBIENT")
      VALUE_AMBIENT("AMBIENT"),
      @SerializedName("REGULAR")
      VALUE_REGULAR("REGULAR"),
      ;

      private String value;

      private EnumStreamType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBroadcastStatus {
      @SerializedName("LIVE")
      VALUE_LIVE("LIVE"),
      @SerializedName("LIVE_STOPPED")
      VALUE_LIVE_STOPPED("LIVE_STOPPED"),
      @SerializedName("PROCESSING")
      VALUE_PROCESSING("PROCESSING"),
      @SerializedName("SCHEDULED_CANCELED")
      VALUE_SCHEDULED_CANCELED("SCHEDULED_CANCELED"),
      @SerializedName("SCHEDULED_EXPIRED")
      VALUE_SCHEDULED_EXPIRED("SCHEDULED_EXPIRED"),
      @SerializedName("SCHEDULED_LIVE")
      VALUE_SCHEDULED_LIVE("SCHEDULED_LIVE"),
      @SerializedName("SCHEDULED_UNPUBLISHED")
      VALUE_SCHEDULED_UNPUBLISHED("SCHEDULED_UNPUBLISHED"),
      @SerializedName("UNPUBLISHED")
      VALUE_UNPUBLISHED("UNPUBLISHED"),
      @SerializedName("VOD")
      VALUE_VOD("VOD"),
      ;

      private String value;

      private EnumBroadcastStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSource {
      @SerializedName("owner")
      VALUE_OWNER("owner"),
      @SerializedName("target")
      VALUE_TARGET("target"),
      ;

      private String value;

      private EnumSource(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLiveCommentModerationSetting {
      @SerializedName("DEFAULT")
      VALUE_DEFAULT("DEFAULT"),
      @SerializedName("DISCUSSION")
      VALUE_DISCUSSION("DISCUSSION"),
      @SerializedName("FOLLOWED")
      VALUE_FOLLOWED("FOLLOWED"),
      @SerializedName("FOLLOWER")
      VALUE_FOLLOWER("FOLLOWER"),
      @SerializedName("NO_HYPERLINK")
      VALUE_NO_HYPERLINK("NO_HYPERLINK"),
      @SerializedName("PROTECTED_MODE")
      VALUE_PROTECTED_MODE("PROTECTED_MODE"),
      @SerializedName("RESTRICTED")
      VALUE_RESTRICTED("RESTRICTED"),
      @SerializedName("SLOW")
      VALUE_SLOW("SLOW"),
      @SerializedName("SUPPORTER")
      VALUE_SUPPORTER("SUPPORTER"),
      @SerializedName("TAGGED")
      VALUE_TAGGED("TAGGED"),
      ;

      private String value;

      private EnumLiveCommentModerationSetting(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPersistentStreamKeyStatus {
      @SerializedName("DISABLE")
      VALUE_DISABLE("DISABLE"),
      @SerializedName("ENABLE")
      VALUE_ENABLE("ENABLE"),
      @SerializedName("REGENERATE")
      VALUE_REGENERATE("REGENERATE"),
      ;

      private String value;

      private EnumPersistentStreamKeyStatus(String value) {
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

  public LiveVideo copyFrom(LiveVideo instance) {
    this.mAdBreakConfig = instance.mAdBreakConfig;
    this.mAdBreakFailureReason = instance.mAdBreakFailureReason;
    this.mBroadcastStartTime = instance.mBroadcastStartTime;
    this.mCopyright = instance.mCopyright;
    this.mCreationTime = instance.mCreationTime;
    this.mDashIngestUrl = instance.mDashIngestUrl;
    this.mDashPreviewUrl = instance.mDashPreviewUrl;
    this.mDescription = instance.mDescription;
    this.mEmbedHtml = instance.mEmbedHtml;
    this.mFrom = instance.mFrom;
    this.mId = instance.mId;
    this.mIngestStreams = instance.mIngestStreams;
    this.mIsManualMode = instance.mIsManualMode;
    this.mIsReferenceOnly = instance.mIsReferenceOnly;
    this.mLiveViews = instance.mLiveViews;
    this.mOverlayUrl = instance.mOverlayUrl;
    this.mPermalinkUrl = instance.mPermalinkUrl;
    this.mPlannedStartTime = instance.mPlannedStartTime;
    this.mRecommendedEncoderSettings = instance.mRecommendedEncoderSettings;
    this.mSecondsLeft = instance.mSecondsLeft;
    this.mSecureStreamUrl = instance.mSecureStreamUrl;
    this.mStatus = instance.mStatus;
    this.mStreamUrl = instance.mStreamUrl;
    this.mTargeting = instance.mTargeting;
    this.mTitle = instance.mTitle;
    this.mTotalViews = instance.mTotalViews;
    this.mVideo = instance.mVideo;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LiveVideo> getParser() {
    return new APIRequest.ResponseParser<LiveVideo>() {
      public APINodeList<LiveVideo> parseResponse(String response, APIContext context, APIRequest<LiveVideo> request, String header) throws MalformedResponseException {
        return LiveVideo.parseResponse(response, context, request, header);
      }
    };
  }
}
