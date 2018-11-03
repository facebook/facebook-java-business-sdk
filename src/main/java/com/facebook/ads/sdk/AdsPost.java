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
public class AdsPost extends APINode {
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
  @SerializedName("type")
  private String mType = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  protected static Gson gson = null;

  public AdsPost() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdsPost loadJSON(String json, APIContext context) {
    AdsPost adsPost = getGson().fromJson(json, AdsPost.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsPost.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsPost.context = context;
    adsPost.rawValue = json;
    return adsPost;
  }

  public static APINodeList<AdsPost> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdsPost> adsPosts = new APINodeList<AdsPost>(request, json);
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
          adsPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adsPosts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsPosts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsPosts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsPosts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adsPosts.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsPosts.add(loadJSON(obj.toString(), context));
            }
          }
          return adsPosts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsPosts.add(loadJSON(entry.getValue().toString(), context));
          }
          return adsPosts;
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
              adsPosts.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsPosts;
          }

          // Sixth, check if it's pure JsonObject
          adsPosts.clear();
          adsPosts.add(loadJSON(json, context));
          return adsPosts;
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
    return new APIRequestGetInsights(this.getId(), context);
  }


  public User getFieldAdminCreator() {
    if (mAdminCreator != null) {
      mAdminCreator.context = getContext();
    }
    return mAdminCreator;
  }

  public AdsPost setFieldAdminCreator(User value) {
    this.mAdminCreator = value;
    return this;
  }

  public AdsPost setFieldAdminCreator(String value) {
    Type type = new TypeToken<User>(){}.getType();
    this.mAdminCreator = User.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public AdsPost setFieldCreationTime(String value) {
    this.mCreationTime = value;
    return this;
  }

  public String getFieldFeedAudienceDescription() {
    return mFeedAudienceDescription;
  }

  public AdsPost setFieldFeedAudienceDescription(String value) {
    this.mFeedAudienceDescription = value;
    return this;
  }

  public Targeting getFieldFeedTargeting() {
    return mFeedTargeting;
  }

  public AdsPost setFieldFeedTargeting(Targeting value) {
    this.mFeedTargeting = value;
    return this;
  }

  public AdsPost setFieldFeedTargeting(String value) {
    Type type = new TypeToken<Targeting>(){}.getType();
    this.mFeedTargeting = Targeting.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldId() {
    return mId;
  }

  public AdsPost setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public AdsPost setFieldMessage(String value) {
    this.mMessage = value;
    return this;
  }

  public String getFieldModifiedTime() {
    return mModifiedTime;
  }

  public AdsPost setFieldModifiedTime(String value) {
    this.mModifiedTime = value;
    return this;
  }

  public String getFieldOgActionSummary() {
    return mOgActionSummary;
  }

  public AdsPost setFieldOgActionSummary(String value) {
    this.mOgActionSummary = value;
    return this;
  }

  public String getFieldPermalinkUrl() {
    return mPermalinkUrl;
  }

  public AdsPost setFieldPermalinkUrl(String value) {
    this.mPermalinkUrl = value;
    return this;
  }

  public Place getFieldPlace() {
    if (mPlace != null) {
      mPlace.context = getContext();
    }
    return mPlace;
  }

  public AdsPost setFieldPlace(Place value) {
    this.mPlace = value;
    return this;
  }

  public AdsPost setFieldPlace(String value) {
    Type type = new TypeToken<Place>(){}.getType();
    this.mPlace = Place.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldPrivacyDescription() {
    return mPrivacyDescription;
  }

  public AdsPost setFieldPrivacyDescription(String value) {
    this.mPrivacyDescription = value;
    return this;
  }

  public Object getFieldPromotionInfo() {
    return mPromotionInfo;
  }

  public AdsPost setFieldPromotionInfo(Object value) {
    this.mPromotionInfo = value;
    return this;
  }

  public String getFieldScheduledPublishTime() {
    return mScheduledPublishTime;
  }

  public AdsPost setFieldScheduledPublishTime(String value) {
    this.mScheduledPublishTime = value;
    return this;
  }

  public String getFieldStoryToken() {
    return mStoryToken;
  }

  public AdsPost setFieldStoryToken(String value) {
    this.mStoryToken = value;
    return this;
  }

  public String getFieldThumbnail() {
    return mThumbnail;
  }

  public AdsPost setFieldThumbnail(String value) {
    this.mThumbnail = value;
    return this;
  }

  public String getFieldType() {
    return mType;
  }

  public AdsPost setFieldType(String value) {
    this.mType = value;
    return this;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public AdsPost setFieldVideoId(String value) {
    this.mVideoId = value;
    return this;
  }



  public static class APIRequestGetInsights extends APIRequest<InsightsResult> {

    APINodeList<InsightsResult> lastResponse = null;
    @Override
    public APINodeList<InsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
    public APINodeList<InsightsResult> parseResponse(String response) throws APIException {
      return InsightsResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<InsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<InsightsResult>>() {
           public APINodeList<InsightsResult> apply(String result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result);
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

  public AdsPost copyFrom(AdsPost instance) {
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
    this.mType = instance.mType;
    this.mVideoId = instance.mVideoId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsPost> getParser() {
    return new APIRequest.ResponseParser<AdsPost>() {
      public APINodeList<AdsPost> parseResponse(String response, APIContext context, APIRequest<AdsPost> request) throws MalformedResponseException {
        return AdsPost.parseResponse(response, context, request);
      }
    };
  }
}
