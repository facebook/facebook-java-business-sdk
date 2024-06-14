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
public class InsightsResult extends APINode {
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("description_from_api_doc")
  private String mDescriptionFromApiDoc = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("period")
  private String mPeriod = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("values")
  private List<InsightsValue> mValues = null;
  protected static Gson gson = null;

  public InsightsResult() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static InsightsResult loadJSON(String json, APIContext context, String header) {
    InsightsResult insightsResult = getGson().fromJson(json, InsightsResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(insightsResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    insightsResult.context = context;
    insightsResult.rawValue = json;
    insightsResult.header = header;
    return insightsResult;
  }

  public static APINodeList<InsightsResult> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<InsightsResult> insightsResults = new APINodeList<InsightsResult>(request, json, header);
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
          insightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return insightsResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                insightsResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            insightsResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              insightsResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              insightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  insightsResults.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              insightsResults.add(loadJSON(obj.toString(), context, header));
            }
          }
          return insightsResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              insightsResults.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return insightsResults;
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
              insightsResults.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return insightsResults;
          }

          // Sixth, check if it's pure JsonObject
          insightsResults.clear();
          insightsResults.add(loadJSON(json, context, header));
          return insightsResults;
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


  public String getFieldDescription() {
    return mDescription;
  }

  public InsightsResult setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldDescriptionFromApiDoc() {
    return mDescriptionFromApiDoc;
  }

  public InsightsResult setFieldDescriptionFromApiDoc(String value) {
    this.mDescriptionFromApiDoc = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public InsightsResult setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public InsightsResult setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldPeriod() {
    return mPeriod;
  }

  public InsightsResult setFieldPeriod(String value) {
    this.mPeriod = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public InsightsResult setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public List<InsightsValue> getFieldValues() {
    return mValues;
  }

  public InsightsResult setFieldValues(List<InsightsValue> value) {
    this.mValues = value;
    return this;
  }

  public InsightsResult setFieldValues(String value) {
    Type type = new TypeToken<List<InsightsValue>>(){}.getType();
    this.mValues = InsightsValue.getGson().fromJson(value, type);
    return this;
  }


  public static enum EnumDatePreset {
      @SerializedName("data_maximum")
      VALUE_DATA_MAXIMUM("data_maximum"),
      @SerializedName("last_14d")
      VALUE_LAST_14D("last_14d"),
      @SerializedName("last_28d")
      VALUE_LAST_28D("last_28d"),
      @SerializedName("last_30d")
      VALUE_LAST_30D("last_30d"),
      @SerializedName("last_3d")
      VALUE_LAST_3D("last_3d"),
      @SerializedName("last_7d")
      VALUE_LAST_7D("last_7d"),
      @SerializedName("last_90d")
      VALUE_LAST_90D("last_90d"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("last_quarter")
      VALUE_LAST_QUARTER("last_quarter"),
      @SerializedName("last_week_mon_sun")
      VALUE_LAST_WEEK_MON_SUN("last_week_mon_sun"),
      @SerializedName("last_week_sun_sat")
      VALUE_LAST_WEEK_SUN_SAT("last_week_sun_sat"),
      @SerializedName("last_year")
      VALUE_LAST_YEAR("last_year"),
      @SerializedName("maximum")
      VALUE_MAXIMUM("maximum"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("this_quarter")
      VALUE_THIS_QUARTER("this_quarter"),
      @SerializedName("this_week_mon_today")
      VALUE_THIS_WEEK_MON_TODAY("this_week_mon_today"),
      @SerializedName("this_week_sun_today")
      VALUE_THIS_WEEK_SUN_TODAY("this_week_sun_today"),
      @SerializedName("this_year")
      VALUE_THIS_YEAR("this_year"),
      @SerializedName("today")
      VALUE_TODAY("today"),
      @SerializedName("yesterday")
      VALUE_YESTERDAY("yesterday"),
      ;

      private String value;

      private EnumDatePreset(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPeriod {
      @SerializedName("day")
      VALUE_DAY("day"),
      @SerializedName("days_28")
      VALUE_DAYS_28("days_28"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      @SerializedName("month")
      VALUE_MONTH("month"),
      @SerializedName("total_over_range")
      VALUE_TOTAL_OVER_RANGE("total_over_range"),
      @SerializedName("week")
      VALUE_WEEK("week"),
      ;

      private String value;

      private EnumPeriod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMetric {
      @SerializedName("blue_reels_play_count")
      VALUE_BLUE_REELS_PLAY_COUNT("blue_reels_play_count"),
      @SerializedName("creator_monetization_qualified_views")
      VALUE_CREATOR_MONETIZATION_QUALIFIED_VIEWS("creator_monetization_qualified_views"),
      @SerializedName("fb_media_matching_copyright_comment_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_COMMENT_COUNT("fb_media_matching_copyright_comment_count"),
      @SerializedName("fb_media_matching_copyright_daily_comment_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_COMMENT_COUNT("fb_media_matching_copyright_daily_comment_count"),
      @SerializedName("fb_media_matching_copyright_daily_like_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_LIKE_COUNT("fb_media_matching_copyright_daily_like_count"),
      @SerializedName("fb_media_matching_copyright_daily_post_impressions")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_IMPRESSIONS("fb_media_matching_copyright_daily_post_impressions"),
      @SerializedName("fb_media_matching_copyright_daily_post_impressions_by_age_bucket_and_gender")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_IMPRESSIONS_BY_AGE_BUCKET_AND_GENDER("fb_media_matching_copyright_daily_post_impressions_by_age_bucket_and_gender"),
      @SerializedName("fb_media_matching_copyright_daily_post_impressions_by_country")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_IMPRESSIONS_BY_COUNTRY("fb_media_matching_copyright_daily_post_impressions_by_country"),
      @SerializedName("fb_media_matching_copyright_daily_post_impressions_by_locale")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_IMPRESSIONS_BY_LOCALE("fb_media_matching_copyright_daily_post_impressions_by_locale"),
      @SerializedName("fb_media_matching_copyright_daily_post_impressions_by_matching_post_id")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_IMPRESSIONS_BY_MATCHING_POST_ID("fb_media_matching_copyright_daily_post_impressions_by_matching_post_id"),
      @SerializedName("fb_media_matching_copyright_daily_post_impressions_by_matching_post_owner_id")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_IMPRESSIONS_BY_MATCHING_POST_OWNER_ID("fb_media_matching_copyright_daily_post_impressions_by_matching_post_owner_id"),
      @SerializedName("fb_media_matching_copyright_daily_post_reactions_anger_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_REACTIONS_ANGER_COUNT("fb_media_matching_copyright_daily_post_reactions_anger_count"),
      @SerializedName("fb_media_matching_copyright_daily_post_reactions_haha_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_REACTIONS_HAHA_COUNT("fb_media_matching_copyright_daily_post_reactions_haha_count"),
      @SerializedName("fb_media_matching_copyright_daily_post_reactions_like_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_REACTIONS_LIKE_COUNT("fb_media_matching_copyright_daily_post_reactions_like_count"),
      @SerializedName("fb_media_matching_copyright_daily_post_reactions_love_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_REACTIONS_LOVE_COUNT("fb_media_matching_copyright_daily_post_reactions_love_count"),
      @SerializedName("fb_media_matching_copyright_daily_post_reactions_sorry_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_REACTIONS_SORRY_COUNT("fb_media_matching_copyright_daily_post_reactions_sorry_count"),
      @SerializedName("fb_media_matching_copyright_daily_post_reactions_wow_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_REACTIONS_WOW_COUNT("fb_media_matching_copyright_daily_post_reactions_wow_count"),
      @SerializedName("fb_media_matching_copyright_daily_post_share_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_DAILY_POST_SHARE_COUNT("fb_media_matching_copyright_daily_post_share_count"),
      @SerializedName("fb_media_matching_copyright_like_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_LIKE_COUNT("fb_media_matching_copyright_like_count"),
      @SerializedName("fb_media_matching_copyright_post_impressions")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_IMPRESSIONS("fb_media_matching_copyright_post_impressions"),
      @SerializedName("fb_media_matching_copyright_post_impressions_by_age_bucket_and_gender")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_IMPRESSIONS_BY_AGE_BUCKET_AND_GENDER("fb_media_matching_copyright_post_impressions_by_age_bucket_and_gender"),
      @SerializedName("fb_media_matching_copyright_post_impressions_by_country")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_IMPRESSIONS_BY_COUNTRY("fb_media_matching_copyright_post_impressions_by_country"),
      @SerializedName("fb_media_matching_copyright_post_impressions_by_locale")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_IMPRESSIONS_BY_LOCALE("fb_media_matching_copyright_post_impressions_by_locale"),
      @SerializedName("fb_media_matching_copyright_post_impressions_by_matching_post_id")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_IMPRESSIONS_BY_MATCHING_POST_ID("fb_media_matching_copyright_post_impressions_by_matching_post_id"),
      @SerializedName("fb_media_matching_copyright_post_impressions_by_matching_post_owner_id")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_IMPRESSIONS_BY_MATCHING_POST_OWNER_ID("fb_media_matching_copyright_post_impressions_by_matching_post_owner_id"),
      @SerializedName("fb_media_matching_copyright_post_reactions_anger_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_REACTIONS_ANGER_COUNT("fb_media_matching_copyright_post_reactions_anger_count"),
      @SerializedName("fb_media_matching_copyright_post_reactions_haha_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_REACTIONS_HAHA_COUNT("fb_media_matching_copyright_post_reactions_haha_count"),
      @SerializedName("fb_media_matching_copyright_post_reactions_like_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_REACTIONS_LIKE_COUNT("fb_media_matching_copyright_post_reactions_like_count"),
      @SerializedName("fb_media_matching_copyright_post_reactions_love_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_REACTIONS_LOVE_COUNT("fb_media_matching_copyright_post_reactions_love_count"),
      @SerializedName("fb_media_matching_copyright_post_reactions_sorry_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_REACTIONS_SORRY_COUNT("fb_media_matching_copyright_post_reactions_sorry_count"),
      @SerializedName("fb_media_matching_copyright_post_reactions_wow_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_REACTIONS_WOW_COUNT("fb_media_matching_copyright_post_reactions_wow_count"),
      @SerializedName("fb_media_matching_copyright_post_share_count")
      VALUE_FB_MEDIA_MATCHING_COPYRIGHT_POST_SHARE_COUNT("fb_media_matching_copyright_post_share_count"),
      @SerializedName("fb_reels_replay_count")
      VALUE_FB_REELS_REPLAY_COUNT("fb_reels_replay_count"),
      @SerializedName("fb_reels_total_plays")
      VALUE_FB_REELS_TOTAL_PLAYS("fb_reels_total_plays"),
      @SerializedName("has_total_video_views_by_publisher_platform_type")
      VALUE_HAS_TOTAL_VIDEO_VIEWS_BY_PUBLISHER_PLATFORM_TYPE("has_total_video_views_by_publisher_platform_type"),
      @SerializedName("post_impressions_unique")
      VALUE_POST_IMPRESSIONS_UNIQUE("post_impressions_unique"),
      @SerializedName("post_video_avg_time_watched")
      VALUE_POST_VIDEO_AVG_TIME_WATCHED("post_video_avg_time_watched"),
      @SerializedName("post_video_followers")
      VALUE_POST_VIDEO_FOLLOWERS("post_video_followers"),
      @SerializedName("post_video_likes_by_reaction_type")
      VALUE_POST_VIDEO_LIKES_BY_REACTION_TYPE("post_video_likes_by_reaction_type"),
      @SerializedName("post_video_retention_graph")
      VALUE_POST_VIDEO_RETENTION_GRAPH("post_video_retention_graph"),
      @SerializedName("post_video_social_actions")
      VALUE_POST_VIDEO_SOCIAL_ACTIONS("post_video_social_actions"),
      @SerializedName("post_video_view_time")
      VALUE_POST_VIDEO_VIEW_TIME("post_video_view_time"),
      @SerializedName("rights_manager_matching_copyright_matching_page_or_profile_view_count")
      VALUE_RIGHTS_MANAGER_MATCHING_COPYRIGHT_MATCHING_PAGE_OR_PROFILE_VIEW_COUNT("rights_manager_matching_copyright_matching_page_or_profile_view_count"),
      @SerializedName("rights_manager_matching_copyright_matching_video_view_count")
      VALUE_RIGHTS_MANAGER_MATCHING_COPYRIGHT_MATCHING_VIDEO_VIEW_COUNT("rights_manager_matching_copyright_matching_video_view_count"),
      @SerializedName("rights_manager_matching_copyright_video_view_count")
      VALUE_RIGHTS_MANAGER_MATCHING_COPYRIGHT_VIDEO_VIEW_COUNT("rights_manager_matching_copyright_video_view_count"),
      @SerializedName("rights_manager_matching_copyright_video_view_count_60s")
      VALUE_RIGHTS_MANAGER_MATCHING_COPYRIGHT_VIDEO_VIEW_COUNT_60S("rights_manager_matching_copyright_video_view_count_60s"),
      @SerializedName("rights_manager_matching_copyright_video_view_count_60s_by_age_bucket_and_gender")
      VALUE_RIGHTS_MANAGER_MATCHING_COPYRIGHT_VIDEO_VIEW_COUNT_60S_BY_AGE_BUCKET_AND_GENDER("rights_manager_matching_copyright_video_view_count_60s_by_age_bucket_and_gender"),
      @SerializedName("rights_manager_matching_copyright_video_view_count_60s_by_country_id")
      VALUE_RIGHTS_MANAGER_MATCHING_COPYRIGHT_VIDEO_VIEW_COUNT_60S_BY_COUNTRY_ID("rights_manager_matching_copyright_video_view_count_60s_by_country_id"),
      @SerializedName("rights_manager_matching_copyright_video_view_count_60s_by_locale")
      VALUE_RIGHTS_MANAGER_MATCHING_COPYRIGHT_VIDEO_VIEW_COUNT_60S_BY_LOCALE("rights_manager_matching_copyright_video_view_count_60s_by_locale"),
      @SerializedName("total_audio_only_product_listen_count")
      VALUE_TOTAL_AUDIO_ONLY_PRODUCT_LISTEN_COUNT("total_audio_only_product_listen_count"),
      @SerializedName("total_video_10s_views")
      VALUE_TOTAL_VIDEO_10S_VIEWS("total_video_10s_views"),
      @SerializedName("total_video_10s_views_auto_played")
      VALUE_TOTAL_VIDEO_10S_VIEWS_AUTO_PLAYED("total_video_10s_views_auto_played"),
      @SerializedName("total_video_10s_views_clicked_to_play")
      VALUE_TOTAL_VIDEO_10S_VIEWS_CLICKED_TO_PLAY("total_video_10s_views_clicked_to_play"),
      @SerializedName("total_video_10s_views_organic")
      VALUE_TOTAL_VIDEO_10S_VIEWS_ORGANIC("total_video_10s_views_organic"),
      @SerializedName("total_video_10s_views_paid")
      VALUE_TOTAL_VIDEO_10S_VIEWS_PAID("total_video_10s_views_paid"),
      @SerializedName("total_video_10s_views_sound_on")
      VALUE_TOTAL_VIDEO_10S_VIEWS_SOUND_ON("total_video_10s_views_sound_on"),
      @SerializedName("total_video_10s_views_unique")
      VALUE_TOTAL_VIDEO_10S_VIEWS_UNIQUE("total_video_10s_views_unique"),
      @SerializedName("total_video_15s_views")
      VALUE_TOTAL_VIDEO_15S_VIEWS("total_video_15s_views"),
      @SerializedName("total_video_30s_views")
      VALUE_TOTAL_VIDEO_30S_VIEWS("total_video_30s_views"),
      @SerializedName("total_video_30s_views_auto_played")
      VALUE_TOTAL_VIDEO_30S_VIEWS_AUTO_PLAYED("total_video_30s_views_auto_played"),
      @SerializedName("total_video_30s_views_clicked_to_play")
      VALUE_TOTAL_VIDEO_30S_VIEWS_CLICKED_TO_PLAY("total_video_30s_views_clicked_to_play"),
      @SerializedName("total_video_30s_views_organic")
      VALUE_TOTAL_VIDEO_30S_VIEWS_ORGANIC("total_video_30s_views_organic"),
      @SerializedName("total_video_30s_views_paid")
      VALUE_TOTAL_VIDEO_30S_VIEWS_PAID("total_video_30s_views_paid"),
      @SerializedName("total_video_30s_views_unique")
      VALUE_TOTAL_VIDEO_30S_VIEWS_UNIQUE("total_video_30s_views_unique"),
      @SerializedName("total_video_60s_excludes_shorter_views")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS("total_video_60s_excludes_shorter_views"),
      @SerializedName("total_video_60s_excludes_shorter_views_by_age_bucket_and_gender")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_BY_AGE_BUCKET_AND_GENDER("total_video_60s_excludes_shorter_views_by_age_bucket_and_gender"),
      @SerializedName("total_video_60s_excludes_shorter_views_by_distribution_source")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_BY_DISTRIBUTION_SOURCE("total_video_60s_excludes_shorter_views_by_distribution_source"),
      @SerializedName("total_video_60s_excludes_shorter_views_by_growth_accounting_bucket")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_BY_GROWTH_ACCOUNTING_BUCKET("total_video_60s_excludes_shorter_views_by_growth_accounting_bucket"),
      @SerializedName("total_video_60s_excludes_shorter_views_by_growth_accounting_bucket_and_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_BY_GROWTH_ACCOUNTING_BUCKET_AND_TIME_SINCE_CREATION_BUCKET("total_video_60s_excludes_shorter_views_by_growth_accounting_bucket_and_time_since_creation_bucket"),
      @SerializedName("total_video_60s_excludes_shorter_views_by_is_60s_returning_viewer")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_BY_IS_60S_RETURNING_VIEWER("total_video_60s_excludes_shorter_views_by_is_60s_returning_viewer"),
      @SerializedName("total_video_60s_excludes_shorter_views_by_is_60s_returning_viewer_and_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_BY_IS_60S_RETURNING_VIEWER_AND_TIME_SINCE_CREATION_BUCKET("total_video_60s_excludes_shorter_views_by_is_60s_returning_viewer_and_time_since_creation_bucket"),
      @SerializedName("total_video_60s_excludes_shorter_views_live")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_LIVE("total_video_60s_excludes_shorter_views_live"),
      @SerializedName("total_video_60s_excludes_shorter_views_unique")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_UNIQUE("total_video_60s_excludes_shorter_views_unique"),
      @SerializedName("total_video_60s_excludes_shorter_views_unique_by_age_bucket_and_gender")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_UNIQUE_BY_AGE_BUCKET_AND_GENDER("total_video_60s_excludes_shorter_views_unique_by_age_bucket_and_gender"),
      @SerializedName("total_video_60s_excludes_shorter_views_unique_by_growth_accounting_bucket")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_UNIQUE_BY_GROWTH_ACCOUNTING_BUCKET("total_video_60s_excludes_shorter_views_unique_by_growth_accounting_bucket"),
      @SerializedName("total_video_60s_excludes_shorter_views_unique_by_growth_accounting_bucket_and_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_UNIQUE_BY_GROWTH_ACCOUNTING_BUCKET_AND_TIME_SINCE_CREATION_BUCKET("total_video_60s_excludes_shorter_views_unique_by_growth_accounting_bucket_and_time_since_creation_bucket"),
      @SerializedName("total_video_60s_excludes_shorter_views_unique_by_is_60s_returning_viewer")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_UNIQUE_BY_IS_60S_RETURNING_VIEWER("total_video_60s_excludes_shorter_views_unique_by_is_60s_returning_viewer"),
      @SerializedName("total_video_60s_excludes_shorter_views_unique_by_is_60s_returning_viewer_and_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_60S_EXCLUDES_SHORTER_VIEWS_UNIQUE_BY_IS_60S_RETURNING_VIEWER_AND_TIME_SINCE_CREATION_BUCKET("total_video_60s_excludes_shorter_views_unique_by_is_60s_returning_viewer_and_time_since_creation_bucket"),
      @SerializedName("total_video_ad_break_ad_cpm")
      VALUE_TOTAL_VIDEO_AD_BREAK_AD_CPM("total_video_ad_break_ad_cpm"),
      @SerializedName("total_video_ad_break_ad_impressions")
      VALUE_TOTAL_VIDEO_AD_BREAK_AD_IMPRESSIONS("total_video_ad_break_ad_impressions"),
      @SerializedName("total_video_ad_break_earnings")
      VALUE_TOTAL_VIDEO_AD_BREAK_EARNINGS("total_video_ad_break_earnings"),
      @SerializedName("total_video_ad_break_earnings_with_subsidy")
      VALUE_TOTAL_VIDEO_AD_BREAK_EARNINGS_WITH_SUBSIDY("total_video_ad_break_earnings_with_subsidy"),
      @SerializedName("total_video_ad_impressions_by_monetization_type")
      VALUE_TOTAL_VIDEO_AD_IMPRESSIONS_BY_MONETIZATION_TYPE("total_video_ad_impressions_by_monetization_type"),
      @SerializedName("total_video_avg_time_watched")
      VALUE_TOTAL_VIDEO_AVG_TIME_WATCHED("total_video_avg_time_watched"),
      @SerializedName("total_video_avg_time_watched_by_distribution_source")
      VALUE_TOTAL_VIDEO_AVG_TIME_WATCHED_BY_DISTRIBUTION_SOURCE("total_video_avg_time_watched_by_distribution_source"),
      @SerializedName("total_video_avg_time_watched_by_is_60s_returning_viewer")
      VALUE_TOTAL_VIDEO_AVG_TIME_WATCHED_BY_IS_60S_RETURNING_VIEWER("total_video_avg_time_watched_by_is_60s_returning_viewer"),
      @SerializedName("total_video_avg_time_watched_by_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_AVG_TIME_WATCHED_BY_TIME_SINCE_CREATION_BUCKET("total_video_avg_time_watched_by_time_since_creation_bucket"),
      @SerializedName("total_video_avg_time_watched_followers")
      VALUE_TOTAL_VIDEO_AVG_TIME_WATCHED_FOLLOWERS("total_video_avg_time_watched_followers"),
      @SerializedName("total_video_avg_time_watched_live")
      VALUE_TOTAL_VIDEO_AVG_TIME_WATCHED_LIVE("total_video_avg_time_watched_live"),
      @SerializedName("total_video_comment_sentiment")
      VALUE_TOTAL_VIDEO_COMMENT_SENTIMENT("total_video_comment_sentiment"),
      @SerializedName("total_video_comment_sentiment_by_factors")
      VALUE_TOTAL_VIDEO_COMMENT_SENTIMENT_BY_FACTORS("total_video_comment_sentiment_by_factors"),
      @SerializedName("total_video_complete_views")
      VALUE_TOTAL_VIDEO_COMPLETE_VIEWS("total_video_complete_views"),
      @SerializedName("total_video_complete_views_auto_played")
      VALUE_TOTAL_VIDEO_COMPLETE_VIEWS_AUTO_PLAYED("total_video_complete_views_auto_played"),
      @SerializedName("total_video_complete_views_clicked_to_play")
      VALUE_TOTAL_VIDEO_COMPLETE_VIEWS_CLICKED_TO_PLAY("total_video_complete_views_clicked_to_play"),
      @SerializedName("total_video_complete_views_organic")
      VALUE_TOTAL_VIDEO_COMPLETE_VIEWS_ORGANIC("total_video_complete_views_organic"),
      @SerializedName("total_video_complete_views_organic_unique")
      VALUE_TOTAL_VIDEO_COMPLETE_VIEWS_ORGANIC_UNIQUE("total_video_complete_views_organic_unique"),
      @SerializedName("total_video_complete_views_paid")
      VALUE_TOTAL_VIDEO_COMPLETE_VIEWS_PAID("total_video_complete_views_paid"),
      @SerializedName("total_video_complete_views_paid_unique")
      VALUE_TOTAL_VIDEO_COMPLETE_VIEWS_PAID_UNIQUE("total_video_complete_views_paid_unique"),
      @SerializedName("total_video_complete_views_unique")
      VALUE_TOTAL_VIDEO_COMPLETE_VIEWS_UNIQUE("total_video_complete_views_unique"),
      @SerializedName("total_video_consumption_rate")
      VALUE_TOTAL_VIDEO_CONSUMPTION_RATE("total_video_consumption_rate"),
      @SerializedName("total_video_followers_unique")
      VALUE_TOTAL_VIDEO_FOLLOWERS_UNIQUE("total_video_followers_unique"),
      @SerializedName("total_video_growth_score")
      VALUE_TOTAL_VIDEO_GROWTH_SCORE("total_video_growth_score"),
      @SerializedName("total_video_growth_score_by_factors")
      VALUE_TOTAL_VIDEO_GROWTH_SCORE_BY_FACTORS("total_video_growth_score_by_factors"),
      @SerializedName("total_video_impressions")
      VALUE_TOTAL_VIDEO_IMPRESSIONS("total_video_impressions"),
      @SerializedName("total_video_impressions_fan")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_FAN("total_video_impressions_fan"),
      @SerializedName("total_video_impressions_fan_paid")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_FAN_PAID("total_video_impressions_fan_paid"),
      @SerializedName("total_video_impressions_fan_paid_unique")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_FAN_PAID_UNIQUE("total_video_impressions_fan_paid_unique"),
      @SerializedName("total_video_impressions_fan_unique")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_FAN_UNIQUE("total_video_impressions_fan_unique"),
      @SerializedName("total_video_impressions_organic")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_ORGANIC("total_video_impressions_organic"),
      @SerializedName("total_video_impressions_organic_unique")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_ORGANIC_UNIQUE("total_video_impressions_organic_unique"),
      @SerializedName("total_video_impressions_paid")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_PAID("total_video_impressions_paid"),
      @SerializedName("total_video_impressions_paid_unique")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_PAID_UNIQUE("total_video_impressions_paid_unique"),
      @SerializedName("total_video_impressions_unique")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_UNIQUE("total_video_impressions_unique"),
      @SerializedName("total_video_impressions_viral")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_VIRAL("total_video_impressions_viral"),
      @SerializedName("total_video_impressions_viral_unique")
      VALUE_TOTAL_VIDEO_IMPRESSIONS_VIRAL_UNIQUE("total_video_impressions_viral_unique"),
      @SerializedName("total_video_imps_count_unique_by_age_bucket")
      VALUE_TOTAL_VIDEO_IMPS_COUNT_UNIQUE_BY_AGE_BUCKET("total_video_imps_count_unique_by_age_bucket"),
      @SerializedName("total_video_imps_count_unique_by_age_bucket_and_gender")
      VALUE_TOTAL_VIDEO_IMPS_COUNT_UNIQUE_BY_AGE_BUCKET_AND_GENDER("total_video_imps_count_unique_by_age_bucket_and_gender"),
      @SerializedName("total_video_imps_count_unique_by_gender")
      VALUE_TOTAL_VIDEO_IMPS_COUNT_UNIQUE_BY_GENDER("total_video_imps_count_unique_by_gender"),
      @SerializedName("total_video_likes_by_reaction_type")
      VALUE_TOTAL_VIDEO_LIKES_BY_REACTION_TYPE("total_video_likes_by_reaction_type"),
      @SerializedName("total_video_negative_feedback")
      VALUE_TOTAL_VIDEO_NEGATIVE_FEEDBACK("total_video_negative_feedback"),
      @SerializedName("total_video_net_followers")
      VALUE_TOTAL_VIDEO_NET_FOLLOWERS("total_video_net_followers"),
      @SerializedName("total_video_net_followers_unique")
      VALUE_TOTAL_VIDEO_NET_FOLLOWERS_UNIQUE("total_video_net_followers_unique"),
      @SerializedName("total_video_net_followers_unique_by_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_NET_FOLLOWERS_UNIQUE_BY_TIME_SINCE_CREATION_BUCKET("total_video_net_followers_unique_by_time_since_creation_bucket"),
      @SerializedName("total_video_play_count")
      VALUE_TOTAL_VIDEO_PLAY_COUNT("total_video_play_count"),
      @SerializedName("total_video_play_count_by_is_60s_returning_viewer_and_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_PLAY_COUNT_BY_IS_60S_RETURNING_VIEWER_AND_TIME_SINCE_CREATION_BUCKET("total_video_play_count_by_is_60s_returning_viewer_and_time_since_creation_bucket"),
      @SerializedName("total_video_play_count_by_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_PLAY_COUNT_BY_TIME_SINCE_CREATION_BUCKET("total_video_play_count_by_time_since_creation_bucket"),
      @SerializedName("total_video_reactions_by_type_total")
      VALUE_TOTAL_VIDEO_REACTIONS_BY_TYPE_TOTAL("total_video_reactions_by_type_total"),
      @SerializedName("total_video_relative_retention_graph")
      VALUE_TOTAL_VIDEO_RELATIVE_RETENTION_GRAPH("total_video_relative_retention_graph"),
      @SerializedName("total_video_retention_graph")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH("total_video_retention_graph"),
      @SerializedName("total_video_retention_graph_15s")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_15S("total_video_retention_graph_15s"),
      @SerializedName("total_video_retention_graph_15s_followers")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_15S_FOLLOWERS("total_video_retention_graph_15s_followers"),
      @SerializedName("total_video_retention_graph_15s_newsfeed")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_15S_NEWSFEED("total_video_retention_graph_15s_newsfeed"),
      @SerializedName("total_video_retention_graph_15s_recommended")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_15S_RECOMMENDED("total_video_retention_graph_15s_recommended"),
      @SerializedName("total_video_retention_graph_15s_shares")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_15S_SHARES("total_video_retention_graph_15s_shares"),
      @SerializedName("total_video_retention_graph_15s_watch")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_15S_WATCH("total_video_retention_graph_15s_watch"),
      @SerializedName("total_video_retention_graph_autoplayed")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_AUTOPLAYED("total_video_retention_graph_autoplayed"),
      @SerializedName("total_video_retention_graph_clicked_to_play")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_CLICKED_TO_PLAY("total_video_retention_graph_clicked_to_play"),
      @SerializedName("total_video_retention_graph_gender_female")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_GENDER_FEMALE("total_video_retention_graph_gender_female"),
      @SerializedName("total_video_retention_graph_gender_male")
      VALUE_TOTAL_VIDEO_RETENTION_GRAPH_GENDER_MALE("total_video_retention_graph_gender_male"),
      @SerializedName("total_video_social_actions")
      VALUE_TOTAL_VIDEO_SOCIAL_ACTIONS("total_video_social_actions"),
      @SerializedName("total_video_social_actions_comment_by_distribution_type")
      VALUE_TOTAL_VIDEO_SOCIAL_ACTIONS_COMMENT_BY_DISTRIBUTION_TYPE("total_video_social_actions_comment_by_distribution_type"),
      @SerializedName("total_video_social_actions_count_unique")
      VALUE_TOTAL_VIDEO_SOCIAL_ACTIONS_COUNT_UNIQUE("total_video_social_actions_count_unique"),
      @SerializedName("total_video_social_actions_count_unique_by_age_bucket")
      VALUE_TOTAL_VIDEO_SOCIAL_ACTIONS_COUNT_UNIQUE_BY_AGE_BUCKET("total_video_social_actions_count_unique_by_age_bucket"),
      @SerializedName("total_video_social_actions_count_unique_by_age_bucket_and_gender")
      VALUE_TOTAL_VIDEO_SOCIAL_ACTIONS_COUNT_UNIQUE_BY_AGE_BUCKET_AND_GENDER("total_video_social_actions_count_unique_by_age_bucket_and_gender"),
      @SerializedName("total_video_social_actions_count_unique_by_gender")
      VALUE_TOTAL_VIDEO_SOCIAL_ACTIONS_COUNT_UNIQUE_BY_GENDER("total_video_social_actions_count_unique_by_gender"),
      @SerializedName("total_video_social_actions_reaction_by_distribution_type")
      VALUE_TOTAL_VIDEO_SOCIAL_ACTIONS_REACTION_BY_DISTRIBUTION_TYPE("total_video_social_actions_reaction_by_distribution_type"),
      @SerializedName("total_video_stories_by_action_type")
      VALUE_TOTAL_VIDEO_STORIES_BY_ACTION_TYPE("total_video_stories_by_action_type"),
      @SerializedName("total_video_unfollowers")
      VALUE_TOTAL_VIDEO_UNFOLLOWERS("total_video_unfollowers"),
      @SerializedName("total_video_unfollowers_unique")
      VALUE_TOTAL_VIDEO_UNFOLLOWERS_UNIQUE("total_video_unfollowers_unique"),
      @SerializedName("total_video_view_count_unique_by_age_bucket")
      VALUE_TOTAL_VIDEO_VIEW_COUNT_UNIQUE_BY_AGE_BUCKET("total_video_view_count_unique_by_age_bucket"),
      @SerializedName("total_video_view_count_unique_by_age_bucket_and_gender")
      VALUE_TOTAL_VIDEO_VIEW_COUNT_UNIQUE_BY_AGE_BUCKET_AND_GENDER("total_video_view_count_unique_by_age_bucket_and_gender"),
      @SerializedName("total_video_view_count_unique_by_gender")
      VALUE_TOTAL_VIDEO_VIEW_COUNT_UNIQUE_BY_GENDER("total_video_view_count_unique_by_gender"),
      @SerializedName("total_video_view_time_by_age_bucket_and_gender")
      VALUE_TOTAL_VIDEO_VIEW_TIME_BY_AGE_BUCKET_AND_GENDER("total_video_view_time_by_age_bucket_and_gender"),
      @SerializedName("total_video_view_time_by_country_id")
      VALUE_TOTAL_VIDEO_VIEW_TIME_BY_COUNTRY_ID("total_video_view_time_by_country_id"),
      @SerializedName("total_video_view_time_by_distribution_source")
      VALUE_TOTAL_VIDEO_VIEW_TIME_BY_DISTRIBUTION_SOURCE("total_video_view_time_by_distribution_source"),
      @SerializedName("total_video_view_time_by_distribution_type")
      VALUE_TOTAL_VIDEO_VIEW_TIME_BY_DISTRIBUTION_TYPE("total_video_view_time_by_distribution_type"),
      @SerializedName("total_video_view_time_by_is_60s_returning_viewer_and_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_VIEW_TIME_BY_IS_60S_RETURNING_VIEWER_AND_TIME_SINCE_CREATION_BUCKET("total_video_view_time_by_is_60s_returning_viewer_and_time_since_creation_bucket"),
      @SerializedName("total_video_view_time_by_region_id")
      VALUE_TOTAL_VIDEO_VIEW_TIME_BY_REGION_ID("total_video_view_time_by_region_id"),
      @SerializedName("total_video_view_time_by_time_since_creation_bucket")
      VALUE_TOTAL_VIDEO_VIEW_TIME_BY_TIME_SINCE_CREATION_BUCKET("total_video_view_time_by_time_since_creation_bucket"),
      @SerializedName("total_video_view_total_time")
      VALUE_TOTAL_VIDEO_VIEW_TOTAL_TIME("total_video_view_total_time"),
      @SerializedName("total_video_view_total_time_by_is_60s_returning_viewer")
      VALUE_TOTAL_VIDEO_VIEW_TOTAL_TIME_BY_IS_60S_RETURNING_VIEWER("total_video_view_total_time_by_is_60s_returning_viewer"),
      @SerializedName("total_video_view_total_time_by_paid_non_paid")
      VALUE_TOTAL_VIDEO_VIEW_TOTAL_TIME_BY_PAID_NON_PAID("total_video_view_total_time_by_paid_non_paid"),
      @SerializedName("total_video_view_total_time_live")
      VALUE_TOTAL_VIDEO_VIEW_TOTAL_TIME_LIVE("total_video_view_total_time_live"),
      @SerializedName("total_video_view_total_time_organic")
      VALUE_TOTAL_VIDEO_VIEW_TOTAL_TIME_ORGANIC("total_video_view_total_time_organic"),
      @SerializedName("total_video_view_total_time_paid")
      VALUE_TOTAL_VIDEO_VIEW_TOTAL_TIME_PAID("total_video_view_total_time_paid"),
      @SerializedName("total_video_view_total_time_vod")
      VALUE_TOTAL_VIDEO_VIEW_TOTAL_TIME_VOD("total_video_view_total_time_vod"),
      @SerializedName("total_video_views")
      VALUE_TOTAL_VIDEO_VIEWS("total_video_views"),
      @SerializedName("total_video_views_autoplayed")
      VALUE_TOTAL_VIDEO_VIEWS_AUTOPLAYED("total_video_views_autoplayed"),
      @SerializedName("total_video_views_by_age_bucket_and_gender")
      VALUE_TOTAL_VIDEO_VIEWS_BY_AGE_BUCKET_AND_GENDER("total_video_views_by_age_bucket_and_gender"),
      @SerializedName("total_video_views_by_country_id")
      VALUE_TOTAL_VIDEO_VIEWS_BY_COUNTRY_ID("total_video_views_by_country_id"),
      @SerializedName("total_video_views_by_distribution_type")
      VALUE_TOTAL_VIDEO_VIEWS_BY_DISTRIBUTION_TYPE("total_video_views_by_distribution_type"),
      @SerializedName("total_video_views_by_paid_non_paid")
      VALUE_TOTAL_VIDEO_VIEWS_BY_PAID_NON_PAID("total_video_views_by_paid_non_paid"),
      @SerializedName("total_video_views_by_region_id")
      VALUE_TOTAL_VIDEO_VIEWS_BY_REGION_ID("total_video_views_by_region_id"),
      @SerializedName("total_video_views_by_region_id_proper")
      VALUE_TOTAL_VIDEO_VIEWS_BY_REGION_ID_PROPER("total_video_views_by_region_id_proper"),
      @SerializedName("total_video_views_clicked_to_play")
      VALUE_TOTAL_VIDEO_VIEWS_CLICKED_TO_PLAY("total_video_views_clicked_to_play"),
      @SerializedName("total_video_views_gender_female")
      VALUE_TOTAL_VIDEO_VIEWS_GENDER_FEMALE("total_video_views_gender_female"),
      @SerializedName("total_video_views_gender_female_live")
      VALUE_TOTAL_VIDEO_VIEWS_GENDER_FEMALE_LIVE("total_video_views_gender_female_live"),
      @SerializedName("total_video_views_gender_male")
      VALUE_TOTAL_VIDEO_VIEWS_GENDER_MALE("total_video_views_gender_male"),
      @SerializedName("total_video_views_gender_male_live")
      VALUE_TOTAL_VIDEO_VIEWS_GENDER_MALE_LIVE("total_video_views_gender_male_live"),
      @SerializedName("total_video_views_live")
      VALUE_TOTAL_VIDEO_VIEWS_LIVE("total_video_views_live"),
      @SerializedName("total_video_views_live_autoplayed")
      VALUE_TOTAL_VIDEO_VIEWS_LIVE_AUTOPLAYED("total_video_views_live_autoplayed"),
      @SerializedName("total_video_views_live_clicked_to_play")
      VALUE_TOTAL_VIDEO_VIEWS_LIVE_CLICKED_TO_PLAY("total_video_views_live_clicked_to_play"),
      @SerializedName("total_video_views_organic")
      VALUE_TOTAL_VIDEO_VIEWS_ORGANIC("total_video_views_organic"),
      @SerializedName("total_video_views_organic_unique")
      VALUE_TOTAL_VIDEO_VIEWS_ORGANIC_UNIQUE("total_video_views_organic_unique"),
      @SerializedName("total_video_views_paid")
      VALUE_TOTAL_VIDEO_VIEWS_PAID("total_video_views_paid"),
      @SerializedName("total_video_views_paid_unique")
      VALUE_TOTAL_VIDEO_VIEWS_PAID_UNIQUE("total_video_views_paid_unique"),
      @SerializedName("total_video_views_sound_on")
      VALUE_TOTAL_VIDEO_VIEWS_SOUND_ON("total_video_views_sound_on"),
      @SerializedName("total_video_views_unique")
      VALUE_TOTAL_VIDEO_VIEWS_UNIQUE("total_video_views_unique"),
      @SerializedName("total_video_views_vod")
      VALUE_TOTAL_VIDEO_VIEWS_VOD("total_video_views_vod"),
      @SerializedName("video_asset_60s_video_view_total_count_by_is_monetizable")
      VALUE_VIDEO_ASSET_60S_VIDEO_VIEW_TOTAL_COUNT_BY_IS_MONETIZABLE("video_asset_60s_video_view_total_count_by_is_monetizable"),
      ;

      private String value;

      private EnumMetric(String value) {
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

  public InsightsResult copyFrom(InsightsResult instance) {
    this.mDescription = instance.mDescription;
    this.mDescriptionFromApiDoc = instance.mDescriptionFromApiDoc;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPeriod = instance.mPeriod;
    this.mTitle = instance.mTitle;
    this.mValues = instance.mValues;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InsightsResult> getParser() {
    return new APIRequest.ResponseParser<InsightsResult>() {
      public APINodeList<InsightsResult> parseResponse(String response, APIContext context, APIRequest<InsightsResult> request, String header) throws MalformedResponseException {
        return InsightsResult.parseResponse(response, context, request, header);
      }
    };
  }
}
