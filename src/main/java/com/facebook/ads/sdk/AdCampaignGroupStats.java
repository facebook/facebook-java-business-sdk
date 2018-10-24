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
public class AdCampaignGroupStats extends APINode {
  @SerializedName("actions")
  private Map<String, Long> mActions = null;
  @SerializedName("campaign_group_id")
  private String mCampaignGroupId = null;
  @SerializedName("clicks")
  private Long mClicks = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("impressions")
  private Long mImpressions = null;
  @SerializedName("inline_actions")
  private Map<String, Long> mInlineActions = null;
  @SerializedName("social_clicks")
  private Long mSocialClicks = null;
  @SerializedName("social_impressions")
  private Long mSocialImpressions = null;
  @SerializedName("social_spent")
  private Long mSocialSpent = null;
  @SerializedName("social_unique_clicks")
  private Long mSocialUniqueClicks = null;
  @SerializedName("social_unique_impressions")
  private Long mSocialUniqueImpressions = null;
  @SerializedName("spent")
  private Long mSpent = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("unique_clicks")
  private Long mUniqueClicks = null;
  @SerializedName("unique_impressions")
  private Long mUniqueImpressions = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdCampaignGroupStats() {
  }

  public AdCampaignGroupStats(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCampaignGroupStats(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCampaignGroupStats fetch() throws APIException{
    AdCampaignGroupStats newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCampaignGroupStats fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCampaignGroupStats> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCampaignGroupStats fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCampaignGroupStats> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCampaignGroupStats> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCampaignGroupStats>)(
      new APIRequest<AdCampaignGroupStats>(context, "", "/", "GET", AdCampaignGroupStats.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCampaignGroupStats>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCampaignGroupStats.getParser())
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
  public static AdCampaignGroupStats loadJSON(String json, APIContext context) {
    AdCampaignGroupStats adCampaignGroupStats = getGson().fromJson(json, AdCampaignGroupStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignGroupStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCampaignGroupStats.context = context;
    adCampaignGroupStats.rawValue = json;
    return adCampaignGroupStats;
  }

  public static APINodeList<AdCampaignGroupStats> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCampaignGroupStats> adCampaignGroupStatss = new APINodeList<AdCampaignGroupStats>(request, json);
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
          adCampaignGroupStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCampaignGroupStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignGroupStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignGroupStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignGroupStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignGroupStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCampaignGroupStatss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignGroupStatss.add(loadJSON(obj.toString(), context));
            }
          }
          return adCampaignGroupStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignGroupStatss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCampaignGroupStatss;
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
              adCampaignGroupStatss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignGroupStatss;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignGroupStatss.clear();
          adCampaignGroupStatss.add(loadJSON(json, context));
          return adCampaignGroupStatss;
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


  public Map<String, Long> getFieldActions() {
    return mActions;
  }

  public String getFieldCampaignGroupId() {
    return mCampaignGroupId;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public Long getFieldImpressions() {
    return mImpressions;
  }

  public Map<String, Long> getFieldInlineActions() {
    return mInlineActions;
  }

  public Long getFieldSocialClicks() {
    return mSocialClicks;
  }

  public Long getFieldSocialImpressions() {
    return mSocialImpressions;
  }

  public Long getFieldSocialSpent() {
    return mSocialSpent;
  }

  public Long getFieldSocialUniqueClicks() {
    return mSocialUniqueClicks;
  }

  public Long getFieldSocialUniqueImpressions() {
    return mSocialUniqueImpressions;
  }

  public Long getFieldSpent() {
    return mSpent;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public Long getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public Long getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCampaignGroupStats> {

    AdCampaignGroupStats lastResponse = null;
    @Override
    public AdCampaignGroupStats getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "actions",
      "campaign_group_id",
      "clicks",
      "end_time",
      "impressions",
      "inline_actions",
      "social_clicks",
      "social_impressions",
      "social_spent",
      "social_unique_clicks",
      "social_unique_impressions",
      "spent",
      "start_time",
      "unique_clicks",
      "unique_impressions",
      "id",
    };

    @Override
    public AdCampaignGroupStats parseResponse(String response) throws APIException {
      return AdCampaignGroupStats.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCampaignGroupStats execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCampaignGroupStats execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCampaignGroupStats> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCampaignGroupStats> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCampaignGroupStats>() {
           public AdCampaignGroupStats apply(String result) {
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

    public APIRequestGet requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGet requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGet requestCampaignGroupIdField () {
      return this.requestCampaignGroupIdField(true);
    }
    public APIRequestGet requestCampaignGroupIdField (boolean value) {
      this.requestField("campaign_group_id", value);
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

  public AdCampaignGroupStats copyFrom(AdCampaignGroupStats instance) {
    this.mActions = instance.mActions;
    this.mCampaignGroupId = instance.mCampaignGroupId;
    this.mClicks = instance.mClicks;
    this.mEndTime = instance.mEndTime;
    this.mImpressions = instance.mImpressions;
    this.mInlineActions = instance.mInlineActions;
    this.mSocialClicks = instance.mSocialClicks;
    this.mSocialImpressions = instance.mSocialImpressions;
    this.mSocialSpent = instance.mSocialSpent;
    this.mSocialUniqueClicks = instance.mSocialUniqueClicks;
    this.mSocialUniqueImpressions = instance.mSocialUniqueImpressions;
    this.mSpent = instance.mSpent;
    this.mStartTime = instance.mStartTime;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mUniqueImpressions = instance.mUniqueImpressions;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignGroupStats> getParser() {
    return new APIRequest.ResponseParser<AdCampaignGroupStats>() {
      public APINodeList<AdCampaignGroupStats> parseResponse(String response, APIContext context, APIRequest<AdCampaignGroupStats> request) throws MalformedResponseException {
        return AdCampaignGroupStats.parseResponse(response, context, request);
      }
    };
  }
}
