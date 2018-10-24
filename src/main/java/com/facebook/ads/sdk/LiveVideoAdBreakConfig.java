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
public class LiveVideoAdBreakConfig extends APINode {
  @SerializedName("default_ad_break_duration")
  private Long mDefaultAdBreakDuration = null;
  @SerializedName("failure_reason_polling_interval")
  private Long mFailureReasonPollingInterval = null;
  @SerializedName("first_break_eligible_secs")
  private Long mFirstBreakEligibleSecs = null;
  @SerializedName("guide_url")
  private String mGuideUrl = null;
  @SerializedName("is_eligible_to_onboard")
  private Boolean mIsEligibleToOnboard = null;
  @SerializedName("is_enabled")
  private Boolean mIsEnabled = null;
  @SerializedName("onboarding_url")
  private String mOnboardingUrl = null;
  @SerializedName("preparing_duration")
  private Long mPreparingDuration = null;
  @SerializedName("time_between_ad_breaks_secs")
  private Long mTimeBetweenAdBreaksSecs = null;
  @SerializedName("viewer_count_threshold")
  private Long mViewerCountThreshold = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  LiveVideoAdBreakConfig() {
  }

  public LiveVideoAdBreakConfig(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LiveVideoAdBreakConfig(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LiveVideoAdBreakConfig fetch() throws APIException{
    LiveVideoAdBreakConfig newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LiveVideoAdBreakConfig fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LiveVideoAdBreakConfig> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LiveVideoAdBreakConfig fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LiveVideoAdBreakConfig> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LiveVideoAdBreakConfig> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LiveVideoAdBreakConfig>)(
      new APIRequest<LiveVideoAdBreakConfig>(context, "", "/", "GET", LiveVideoAdBreakConfig.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LiveVideoAdBreakConfig>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LiveVideoAdBreakConfig.getParser())
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
  public static LiveVideoAdBreakConfig loadJSON(String json, APIContext context) {
    LiveVideoAdBreakConfig liveVideoAdBreakConfig = getGson().fromJson(json, LiveVideoAdBreakConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(liveVideoAdBreakConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    liveVideoAdBreakConfig.context = context;
    liveVideoAdBreakConfig.rawValue = json;
    return liveVideoAdBreakConfig;
  }

  public static APINodeList<LiveVideoAdBreakConfig> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<LiveVideoAdBreakConfig> liveVideoAdBreakConfigs = new APINodeList<LiveVideoAdBreakConfig>(request, json);
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
          liveVideoAdBreakConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return liveVideoAdBreakConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                liveVideoAdBreakConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            liveVideoAdBreakConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              liveVideoAdBreakConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              liveVideoAdBreakConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  liveVideoAdBreakConfigs.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              liveVideoAdBreakConfigs.add(loadJSON(obj.toString(), context));
            }
          }
          return liveVideoAdBreakConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              liveVideoAdBreakConfigs.add(loadJSON(entry.getValue().toString(), context));
          }
          return liveVideoAdBreakConfigs;
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
              liveVideoAdBreakConfigs.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return liveVideoAdBreakConfigs;
          }

          // Sixth, check if it's pure JsonObject
          liveVideoAdBreakConfigs.clear();
          liveVideoAdBreakConfigs.add(loadJSON(json, context));
          return liveVideoAdBreakConfigs;
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


  public Long getFieldDefaultAdBreakDuration() {
    return mDefaultAdBreakDuration;
  }

  public Long getFieldFailureReasonPollingInterval() {
    return mFailureReasonPollingInterval;
  }

  public Long getFieldFirstBreakEligibleSecs() {
    return mFirstBreakEligibleSecs;
  }

  public String getFieldGuideUrl() {
    return mGuideUrl;
  }

  public Boolean getFieldIsEligibleToOnboard() {
    return mIsEligibleToOnboard;
  }

  public Boolean getFieldIsEnabled() {
    return mIsEnabled;
  }

  public String getFieldOnboardingUrl() {
    return mOnboardingUrl;
  }

  public Long getFieldPreparingDuration() {
    return mPreparingDuration;
  }

  public Long getFieldTimeBetweenAdBreaksSecs() {
    return mTimeBetweenAdBreaksSecs;
  }

  public Long getFieldViewerCountThreshold() {
    return mViewerCountThreshold;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<LiveVideoAdBreakConfig> {

    LiveVideoAdBreakConfig lastResponse = null;
    @Override
    public LiveVideoAdBreakConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "default_ad_break_duration",
      "failure_reason_polling_interval",
      "first_break_eligible_secs",
      "guide_url",
      "is_eligible_to_onboard",
      "is_enabled",
      "onboarding_url",
      "preparing_duration",
      "time_between_ad_breaks_secs",
      "viewer_count_threshold",
      "id",
    };

    @Override
    public LiveVideoAdBreakConfig parseResponse(String response) throws APIException {
      return LiveVideoAdBreakConfig.parseResponse(response, getContext(), this).head();
    }

    @Override
    public LiveVideoAdBreakConfig execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LiveVideoAdBreakConfig execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<LiveVideoAdBreakConfig> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LiveVideoAdBreakConfig> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, LiveVideoAdBreakConfig>() {
           public LiveVideoAdBreakConfig apply(String result) {
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

    public APIRequestGet requestDefaultAdBreakDurationField () {
      return this.requestDefaultAdBreakDurationField(true);
    }
    public APIRequestGet requestDefaultAdBreakDurationField (boolean value) {
      this.requestField("default_ad_break_duration", value);
      return this;
    }
    public APIRequestGet requestFailureReasonPollingIntervalField () {
      return this.requestFailureReasonPollingIntervalField(true);
    }
    public APIRequestGet requestFailureReasonPollingIntervalField (boolean value) {
      this.requestField("failure_reason_polling_interval", value);
      return this;
    }
    public APIRequestGet requestFirstBreakEligibleSecsField () {
      return this.requestFirstBreakEligibleSecsField(true);
    }
    public APIRequestGet requestFirstBreakEligibleSecsField (boolean value) {
      this.requestField("first_break_eligible_secs", value);
      return this;
    }
    public APIRequestGet requestGuideUrlField () {
      return this.requestGuideUrlField(true);
    }
    public APIRequestGet requestGuideUrlField (boolean value) {
      this.requestField("guide_url", value);
      return this;
    }
    public APIRequestGet requestIsEligibleToOnboardField () {
      return this.requestIsEligibleToOnboardField(true);
    }
    public APIRequestGet requestIsEligibleToOnboardField (boolean value) {
      this.requestField("is_eligible_to_onboard", value);
      return this;
    }
    public APIRequestGet requestIsEnabledField () {
      return this.requestIsEnabledField(true);
    }
    public APIRequestGet requestIsEnabledField (boolean value) {
      this.requestField("is_enabled", value);
      return this;
    }
    public APIRequestGet requestOnboardingUrlField () {
      return this.requestOnboardingUrlField(true);
    }
    public APIRequestGet requestOnboardingUrlField (boolean value) {
      this.requestField("onboarding_url", value);
      return this;
    }
    public APIRequestGet requestPreparingDurationField () {
      return this.requestPreparingDurationField(true);
    }
    public APIRequestGet requestPreparingDurationField (boolean value) {
      this.requestField("preparing_duration", value);
      return this;
    }
    public APIRequestGet requestTimeBetweenAdBreaksSecsField () {
      return this.requestTimeBetweenAdBreaksSecsField(true);
    }
    public APIRequestGet requestTimeBetweenAdBreaksSecsField (boolean value) {
      this.requestField("time_between_ad_breaks_secs", value);
      return this;
    }
    public APIRequestGet requestViewerCountThresholdField () {
      return this.requestViewerCountThresholdField(true);
    }
    public APIRequestGet requestViewerCountThresholdField (boolean value) {
      this.requestField("viewer_count_threshold", value);
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

  public LiveVideoAdBreakConfig copyFrom(LiveVideoAdBreakConfig instance) {
    this.mDefaultAdBreakDuration = instance.mDefaultAdBreakDuration;
    this.mFailureReasonPollingInterval = instance.mFailureReasonPollingInterval;
    this.mFirstBreakEligibleSecs = instance.mFirstBreakEligibleSecs;
    this.mGuideUrl = instance.mGuideUrl;
    this.mIsEligibleToOnboard = instance.mIsEligibleToOnboard;
    this.mIsEnabled = instance.mIsEnabled;
    this.mOnboardingUrl = instance.mOnboardingUrl;
    this.mPreparingDuration = instance.mPreparingDuration;
    this.mTimeBetweenAdBreaksSecs = instance.mTimeBetweenAdBreaksSecs;
    this.mViewerCountThreshold = instance.mViewerCountThreshold;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LiveVideoAdBreakConfig> getParser() {
    return new APIRequest.ResponseParser<LiveVideoAdBreakConfig>() {
      public APINodeList<LiveVideoAdBreakConfig> parseResponse(String response, APIContext context, APIRequest<LiveVideoAdBreakConfig> request) throws MalformedResponseException {
        return LiveVideoAdBreakConfig.parseResponse(response, context, request);
      }
    };
  }
}
