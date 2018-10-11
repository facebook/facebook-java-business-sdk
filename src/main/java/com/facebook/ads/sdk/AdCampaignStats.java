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
public class AdCampaignStats extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("actions")
  private Object mActions = null;
  @SerializedName("adgroup_id")
  private String mAdgroupId = null;
  @SerializedName("campaign_id")
  private String mCampaignId = null;
  @SerializedName("campaign_ids")
  private List<String> mCampaignIds = null;
  @SerializedName("clicks")
  private Long mClicks = null;
  @SerializedName("end_time")
  private Object mEndTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("impressions")
  private String mImpressions = null;
  @SerializedName("inline_actions")
  private Map<String, String> mInlineActions = null;
  @SerializedName("io_number")
  private Long mIoNumber = null;
  @SerializedName("is_completed")
  private Boolean mIsCompleted = null;
  @SerializedName("line_number")
  private Long mLineNumber = null;
  @SerializedName("newsfeed_position")
  private Object mNewsfeedPosition = null;
  @SerializedName("social_clicks")
  private Long mSocialClicks = null;
  @SerializedName("social_impressions")
  private String mSocialImpressions = null;
  @SerializedName("social_spent")
  private Long mSocialSpent = null;
  @SerializedName("social_unique_clicks")
  private Long mSocialUniqueClicks = null;
  @SerializedName("social_unique_impressions")
  private String mSocialUniqueImpressions = null;
  @SerializedName("spent")
  private Long mSpent = null;
  @SerializedName("start_time")
  private Object mStartTime = null;
  @SerializedName("topline_id")
  private String mToplineId = null;
  @SerializedName("unique_clicks")
  private Long mUniqueClicks = null;
  @SerializedName("unique_impressions")
  private String mUniqueImpressions = null;
  protected static Gson gson = null;

  AdCampaignStats() {
  }

  public AdCampaignStats(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCampaignStats(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCampaignStats fetch() throws APIException{
    AdCampaignStats newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCampaignStats fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCampaignStats> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCampaignStats fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCampaignStats> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCampaignStats> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCampaignStats>)(
      new APIRequest<AdCampaignStats>(context, "", "/", "GET", AdCampaignStats.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCampaignStats>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCampaignStats.getParser())
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
  public static AdCampaignStats loadJSON(String json, APIContext context) {
    AdCampaignStats adCampaignStats = getGson().fromJson(json, AdCampaignStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCampaignStats.context = context;
    adCampaignStats.rawValue = json;
    return adCampaignStats;
  }

  public static APINodeList<AdCampaignStats> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCampaignStats> adCampaignStatss = new APINodeList<AdCampaignStats>(request, json);
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
          adCampaignStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCampaignStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCampaignStatss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignStatss.add(loadJSON(obj.toString(), context));
            }
          }
          return adCampaignStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignStatss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCampaignStatss;
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
              adCampaignStatss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignStatss;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignStatss.clear();
          adCampaignStatss.add(loadJSON(json, context));
          return adCampaignStatss;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public Object getFieldActions() {
    return mActions;
  }

  public String getFieldAdgroupId() {
    return mAdgroupId;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public List<String> getFieldCampaignIds() {
    return mCampaignIds;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public Object getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldImpressions() {
    return mImpressions;
  }

  public Map<String, String> getFieldInlineActions() {
    return mInlineActions;
  }

  public Long getFieldIoNumber() {
    return mIoNumber;
  }

  public Boolean getFieldIsCompleted() {
    return mIsCompleted;
  }

  public Long getFieldLineNumber() {
    return mLineNumber;
  }

  public Object getFieldNewsfeedPosition() {
    return mNewsfeedPosition;
  }

  public Long getFieldSocialClicks() {
    return mSocialClicks;
  }

  public String getFieldSocialImpressions() {
    return mSocialImpressions;
  }

  public Long getFieldSocialSpent() {
    return mSocialSpent;
  }

  public Long getFieldSocialUniqueClicks() {
    return mSocialUniqueClicks;
  }

  public String getFieldSocialUniqueImpressions() {
    return mSocialUniqueImpressions;
  }

  public Long getFieldSpent() {
    return mSpent;
  }

  public Object getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldToplineId() {
    return mToplineId;
  }

  public Long getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public String getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }



  public static class APIRequestGet extends APIRequest<AdCampaignStats> {

    AdCampaignStats lastResponse = null;
    @Override
    public AdCampaignStats getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "actions",
      "adgroup_id",
      "campaign_id",
      "campaign_ids",
      "clicks",
      "end_time",
      "id",
      "impressions",
      "inline_actions",
      "io_number",
      "is_completed",
      "line_number",
      "newsfeed_position",
      "social_clicks",
      "social_impressions",
      "social_spent",
      "social_unique_clicks",
      "social_unique_impressions",
      "spent",
      "start_time",
      "topline_id",
      "unique_clicks",
      "unique_impressions",
    };

    @Override
    public AdCampaignStats parseResponse(String response) throws APIException {
      return AdCampaignStats.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCampaignStats execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCampaignStats execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCampaignStats> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCampaignStats> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCampaignStats>() {
           public AdCampaignStats apply(String result) {
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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGet requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGet requestAdgroupIdField () {
      return this.requestAdgroupIdField(true);
    }
    public APIRequestGet requestAdgroupIdField (boolean value) {
      this.requestField("adgroup_id", value);
      return this;
    }
    public APIRequestGet requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGet requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGet requestCampaignIdsField () {
      return this.requestCampaignIdsField(true);
    }
    public APIRequestGet requestCampaignIdsField (boolean value) {
      this.requestField("campaign_ids", value);
      return this;
    }
    public APIRequestGet requestClicksField () {
      return this.requestClicksField(true);
    }
    public APIRequestGet requestClicksField (boolean value) {
      this.requestField("clicks", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGet requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGet requestInlineActionsField () {
      return this.requestInlineActionsField(true);
    }
    public APIRequestGet requestInlineActionsField (boolean value) {
      this.requestField("inline_actions", value);
      return this;
    }
    public APIRequestGet requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGet requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGet requestIsCompletedField () {
      return this.requestIsCompletedField(true);
    }
    public APIRequestGet requestIsCompletedField (boolean value) {
      this.requestField("is_completed", value);
      return this;
    }
    public APIRequestGet requestLineNumberField () {
      return this.requestLineNumberField(true);
    }
    public APIRequestGet requestLineNumberField (boolean value) {
      this.requestField("line_number", value);
      return this;
    }
    public APIRequestGet requestNewsfeedPositionField () {
      return this.requestNewsfeedPositionField(true);
    }
    public APIRequestGet requestNewsfeedPositionField (boolean value) {
      this.requestField("newsfeed_position", value);
      return this;
    }
    public APIRequestGet requestSocialClicksField () {
      return this.requestSocialClicksField(true);
    }
    public APIRequestGet requestSocialClicksField (boolean value) {
      this.requestField("social_clicks", value);
      return this;
    }
    public APIRequestGet requestSocialImpressionsField () {
      return this.requestSocialImpressionsField(true);
    }
    public APIRequestGet requestSocialImpressionsField (boolean value) {
      this.requestField("social_impressions", value);
      return this;
    }
    public APIRequestGet requestSocialSpentField () {
      return this.requestSocialSpentField(true);
    }
    public APIRequestGet requestSocialSpentField (boolean value) {
      this.requestField("social_spent", value);
      return this;
    }
    public APIRequestGet requestSocialUniqueClicksField () {
      return this.requestSocialUniqueClicksField(true);
    }
    public APIRequestGet requestSocialUniqueClicksField (boolean value) {
      this.requestField("social_unique_clicks", value);
      return this;
    }
    public APIRequestGet requestSocialUniqueImpressionsField () {
      return this.requestSocialUniqueImpressionsField(true);
    }
    public APIRequestGet requestSocialUniqueImpressionsField (boolean value) {
      this.requestField("social_unique_impressions", value);
      return this;
    }
    public APIRequestGet requestSpentField () {
      return this.requestSpentField(true);
    }
    public APIRequestGet requestSpentField (boolean value) {
      this.requestField("spent", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestToplineIdField () {
      return this.requestToplineIdField(true);
    }
    public APIRequestGet requestToplineIdField (boolean value) {
      this.requestField("topline_id", value);
      return this;
    }
    public APIRequestGet requestUniqueClicksField () {
      return this.requestUniqueClicksField(true);
    }
    public APIRequestGet requestUniqueClicksField (boolean value) {
      this.requestField("unique_clicks", value);
      return this;
    }
    public APIRequestGet requestUniqueImpressionsField () {
      return this.requestUniqueImpressionsField(true);
    }
    public APIRequestGet requestUniqueImpressionsField (boolean value) {
      this.requestField("unique_impressions", value);
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

  public AdCampaignStats copyFrom(AdCampaignStats instance) {
    this.mAccountId = instance.mAccountId;
    this.mActions = instance.mActions;
    this.mAdgroupId = instance.mAdgroupId;
    this.mCampaignId = instance.mCampaignId;
    this.mCampaignIds = instance.mCampaignIds;
    this.mClicks = instance.mClicks;
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mImpressions = instance.mImpressions;
    this.mInlineActions = instance.mInlineActions;
    this.mIoNumber = instance.mIoNumber;
    this.mIsCompleted = instance.mIsCompleted;
    this.mLineNumber = instance.mLineNumber;
    this.mNewsfeedPosition = instance.mNewsfeedPosition;
    this.mSocialClicks = instance.mSocialClicks;
    this.mSocialImpressions = instance.mSocialImpressions;
    this.mSocialSpent = instance.mSocialSpent;
    this.mSocialUniqueClicks = instance.mSocialUniqueClicks;
    this.mSocialUniqueImpressions = instance.mSocialUniqueImpressions;
    this.mSpent = instance.mSpent;
    this.mStartTime = instance.mStartTime;
    this.mToplineId = instance.mToplineId;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mUniqueImpressions = instance.mUniqueImpressions;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignStats> getParser() {
    return new APIRequest.ResponseParser<AdCampaignStats>() {
      public APINodeList<AdCampaignStats> parseResponse(String response, APIContext context, APIRequest<AdCampaignStats> request) throws MalformedResponseException {
        return AdCampaignStats.parseResponse(response, context, request);
      }
    };
  }
}
