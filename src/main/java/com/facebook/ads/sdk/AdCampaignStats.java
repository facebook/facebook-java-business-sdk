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

  public AdCampaignStats() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdCampaignStats loadJSON(String json, APIContext context, String header) {
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
      }
    }
    adCampaignStats.context = context;
    adCampaignStats.rawValue = json;
    adCampaignStats.header = header;
    return adCampaignStats;
  }

  public static APINodeList<AdCampaignStats> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCampaignStats> adCampaignStatss = new APINodeList<AdCampaignStats>(request, json, header);
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
          adCampaignStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
              adCampaignStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCampaignStatss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignStatss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCampaignStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignStatss.add(loadJSON(entry.getValue().toString(), context, header));
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
              adCampaignStatss.add(loadJSON(value.toString(), context, header));
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
          adCampaignStatss.add(loadJSON(json, context, header));
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public AdCampaignStats setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public Object getFieldActions() {
    return mActions;
  }

  public AdCampaignStats setFieldActions(Object value) {
    this.mActions = value;
    return this;
  }

  public String getFieldAdgroupId() {
    return mAdgroupId;
  }

  public AdCampaignStats setFieldAdgroupId(String value) {
    this.mAdgroupId = value;
    return this;
  }

  public String getFieldCampaignId() {
    return mCampaignId;
  }

  public AdCampaignStats setFieldCampaignId(String value) {
    this.mCampaignId = value;
    return this;
  }

  public List<String> getFieldCampaignIds() {
    return mCampaignIds;
  }

  public AdCampaignStats setFieldCampaignIds(List<String> value) {
    this.mCampaignIds = value;
    return this;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public AdCampaignStats setFieldClicks(Long value) {
    this.mClicks = value;
    return this;
  }

  public Object getFieldEndTime() {
    return mEndTime;
  }

  public AdCampaignStats setFieldEndTime(Object value) {
    this.mEndTime = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdCampaignStats setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldImpressions() {
    return mImpressions;
  }

  public AdCampaignStats setFieldImpressions(String value) {
    this.mImpressions = value;
    return this;
  }

  public Map<String, String> getFieldInlineActions() {
    return mInlineActions;
  }

  public AdCampaignStats setFieldInlineActions(Map<String, String> value) {
    this.mInlineActions = value;
    return this;
  }

  public Long getFieldIoNumber() {
    return mIoNumber;
  }

  public AdCampaignStats setFieldIoNumber(Long value) {
    this.mIoNumber = value;
    return this;
  }

  public Boolean getFieldIsCompleted() {
    return mIsCompleted;
  }

  public AdCampaignStats setFieldIsCompleted(Boolean value) {
    this.mIsCompleted = value;
    return this;
  }

  public Long getFieldLineNumber() {
    return mLineNumber;
  }

  public AdCampaignStats setFieldLineNumber(Long value) {
    this.mLineNumber = value;
    return this;
  }

  public Object getFieldNewsfeedPosition() {
    return mNewsfeedPosition;
  }

  public AdCampaignStats setFieldNewsfeedPosition(Object value) {
    this.mNewsfeedPosition = value;
    return this;
  }

  public Long getFieldSocialClicks() {
    return mSocialClicks;
  }

  public AdCampaignStats setFieldSocialClicks(Long value) {
    this.mSocialClicks = value;
    return this;
  }

  public String getFieldSocialImpressions() {
    return mSocialImpressions;
  }

  public AdCampaignStats setFieldSocialImpressions(String value) {
    this.mSocialImpressions = value;
    return this;
  }

  public Long getFieldSocialSpent() {
    return mSocialSpent;
  }

  public AdCampaignStats setFieldSocialSpent(Long value) {
    this.mSocialSpent = value;
    return this;
  }

  public Long getFieldSocialUniqueClicks() {
    return mSocialUniqueClicks;
  }

  public AdCampaignStats setFieldSocialUniqueClicks(Long value) {
    this.mSocialUniqueClicks = value;
    return this;
  }

  public String getFieldSocialUniqueImpressions() {
    return mSocialUniqueImpressions;
  }

  public AdCampaignStats setFieldSocialUniqueImpressions(String value) {
    this.mSocialUniqueImpressions = value;
    return this;
  }

  public Long getFieldSpent() {
    return mSpent;
  }

  public AdCampaignStats setFieldSpent(Long value) {
    this.mSpent = value;
    return this;
  }

  public Object getFieldStartTime() {
    return mStartTime;
  }

  public AdCampaignStats setFieldStartTime(Object value) {
    this.mStartTime = value;
    return this;
  }

  public String getFieldToplineId() {
    return mToplineId;
  }

  public AdCampaignStats setFieldToplineId(String value) {
    this.mToplineId = value;
    return this;
  }

  public Long getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public AdCampaignStats setFieldUniqueClicks(Long value) {
    this.mUniqueClicks = value;
    return this;
  }

  public String getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }

  public AdCampaignStats setFieldUniqueImpressions(String value) {
    this.mUniqueImpressions = value;
    return this;
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
      public APINodeList<AdCampaignStats> parseResponse(String response, APIContext context, APIRequest<AdCampaignStats> request, String header) throws MalformedResponseException {
        return AdCampaignStats.parseResponse(response, context, request, header);
      }
    };
  }
}
