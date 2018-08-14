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
public class PageSavedFilter extends APINode {
  @SerializedName("display_name")
  private String mDisplayName = null;
  @SerializedName("filters")
  private List<Object> mFilters = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("section")
  private String mSection = null;
  @SerializedName("time_created")
  private Long mTimeCreated = null;
  @SerializedName("time_updated")
  private Long mTimeUpdated = null;
  protected static Gson gson = null;

  PageSavedFilter() {
  }

  public PageSavedFilter(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PageSavedFilter(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public PageSavedFilter fetch() throws APIException{
    PageSavedFilter newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PageSavedFilter fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PageSavedFilter> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PageSavedFilter fetchById(String id, APIContext context) throws APIException {
    PageSavedFilter pageSavedFilter =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return pageSavedFilter;
  }

  public static ListenableFuture<PageSavedFilter> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<PageSavedFilter> pageSavedFilter =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return pageSavedFilter;
  }

  public static APINodeList<PageSavedFilter> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PageSavedFilter>)(
      new APIRequest<PageSavedFilter>(context, "", "/", "GET", PageSavedFilter.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PageSavedFilter>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<PageSavedFilter>> pageSavedFilter =
      new APIRequest(context, "", "/", "GET", PageSavedFilter.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return pageSavedFilter;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static PageSavedFilter loadJSON(String json, APIContext context) {
    PageSavedFilter pageSavedFilter = getGson().fromJson(json, PageSavedFilter.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageSavedFilter.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    pageSavedFilter.context = context;
    pageSavedFilter.rawValue = json;
    return pageSavedFilter;
  }

  public static APINodeList<PageSavedFilter> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<PageSavedFilter> pageSavedFilters = new APINodeList<PageSavedFilter>(request, json);
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
          pageSavedFilters.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return pageSavedFilters;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageSavedFilters.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageSavedFilters.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageSavedFilters.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageSavedFilters.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  pageSavedFilters.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageSavedFilters.add(loadJSON(obj.toString(), context));
            }
          }
          return pageSavedFilters;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageSavedFilters.add(loadJSON(entry.getValue().toString(), context));
          }
          return pageSavedFilters;
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
              pageSavedFilters.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageSavedFilters;
          }

          // Sixth, check if it's pure JsonObject
          pageSavedFilters.clear();
          pageSavedFilters.add(loadJSON(json, context));
          return pageSavedFilters;
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


  public String getFieldDisplayName() {
    return mDisplayName;
  }

  public List<Object> getFieldFilters() {
    return mFilters;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public String getFieldSection() {
    return mSection;
  }

  public Long getFieldTimeCreated() {
    return mTimeCreated;
  }

  public Long getFieldTimeUpdated() {
    return mTimeUpdated;
  }



  public static class APIRequestGet extends APIRequest<PageSavedFilter> {

    PageSavedFilter lastResponse = null;
    @Override
    public PageSavedFilter getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "display_name",
      "filters",
      "id",
      "page_id",
      "section",
      "time_created",
      "time_updated",
    };

    @Override
    public PageSavedFilter parseResponse(String response) throws APIException {
      return PageSavedFilter.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PageSavedFilter execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageSavedFilter execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PageSavedFilter> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageSavedFilter> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PageSavedFilter>() {
           public PageSavedFilter apply(String result) {
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

    public APIRequestGet requestDisplayNameField () {
      return this.requestDisplayNameField(true);
    }
    public APIRequestGet requestDisplayNameField (boolean value) {
      this.requestField("display_name", value);
      return this;
    }
    public APIRequestGet requestFiltersField () {
      return this.requestFiltersField(true);
    }
    public APIRequestGet requestFiltersField (boolean value) {
      this.requestField("filters", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPageIdField () {
      return this.requestPageIdField(true);
    }
    public APIRequestGet requestPageIdField (boolean value) {
      this.requestField("page_id", value);
      return this;
    }
    public APIRequestGet requestSectionField () {
      return this.requestSectionField(true);
    }
    public APIRequestGet requestSectionField (boolean value) {
      this.requestField("section", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGet requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
  }

  public static enum EnumSection {
      @SerializedName("AUDIENCE_ALERTS")
      VALUE_AUDIENCE_ALERTS("AUDIENCE_ALERTS"),
      @SerializedName("CAMPAIGN_CENTER")
      VALUE_CAMPAIGN_CENTER("CAMPAIGN_CENTER"),
      @SerializedName("CHEX_PENDING_ORDERS")
      VALUE_CHEX_PENDING_ORDERS("CHEX_PENDING_ORDERS"),
      @SerializedName("CHEX_COMPLETED_ORDERS")
      VALUE_CHEX_COMPLETED_ORDERS("CHEX_COMPLETED_ORDERS"),
      @SerializedName("COMMERCE_PLATFORM_SETTINGS")
      VALUE_COMMERCE_PLATFORM_SETTINGS("COMMERCE_PLATFORM_SETTINGS"),
      @SerializedName("COMMERCE_PRODUCTS")
      VALUE_COMMERCE_PRODUCTS("COMMERCE_PRODUCTS"),
      @SerializedName("COMMERCE_COLLECTIONS")
      VALUE_COMMERCE_COLLECTIONS("COMMERCE_COLLECTIONS"),
      @SerializedName("COMMERCE_PENDING_ORDERS")
      VALUE_COMMERCE_PENDING_ORDERS("COMMERCE_PENDING_ORDERS"),
      @SerializedName("COMMERCE_PAST_ORDERS")
      VALUE_COMMERCE_PAST_ORDERS("COMMERCE_PAST_ORDERS"),
      @SerializedName("COMMERCE_DISCOUNT_CODES")
      VALUE_COMMERCE_DISCOUNT_CODES("COMMERCE_DISCOUNT_CODES"),
      @SerializedName("COMMERCE_MERCHANT_SETTINGS")
      VALUE_COMMERCE_MERCHANT_SETTINGS("COMMERCE_MERCHANT_SETTINGS"),
      @SerializedName("COMMERCE_SHOP_LINK")
      VALUE_COMMERCE_SHOP_LINK("COMMERCE_SHOP_LINK"),
      @SerializedName("DONATIONS_SETTINGS")
      VALUE_DONATIONS_SETTINGS("DONATIONS_SETTINGS"),
      @SerializedName("DRAFTS")
      VALUE_DRAFTS("DRAFTS"),
      @SerializedName("REWARD_PROGRAM")
      VALUE_REWARD_PROGRAM("REWARD_PROGRAM"),
      @SerializedName("EXPIRED_POSTS")
      VALUE_EXPIRED_POSTS("EXPIRED_POSTS"),
      @SerializedName("EXPIRING_POSTS")
      VALUE_EXPIRING_POSTS("EXPIRING_POSTS"),
      @SerializedName("INSTANT_ARTICLES")
      VALUE_INSTANT_ARTICLES("INSTANT_ARTICLES"),
      @SerializedName("INSTANT_ARTICLES_DEVELOPMENT")
      VALUE_INSTANT_ARTICLES_DEVELOPMENT("INSTANT_ARTICLES_DEVELOPMENT"),
      @SerializedName("INSTANT_ARTICLES_MONETIZATION")
      VALUE_INSTANT_ARTICLES_MONETIZATION("INSTANT_ARTICLES_MONETIZATION"),
      @SerializedName("INSTANT_ARTICLES_SAMPLE")
      VALUE_INSTANT_ARTICLES_SAMPLE("INSTANT_ARTICLES_SAMPLE"),
      @SerializedName("INSTANT_ARTICLES_SETTINGS")
      VALUE_INSTANT_ARTICLES_SETTINGS("INSTANT_ARTICLES_SETTINGS"),
      @SerializedName("INSTANT_ARTICLES_SIGN_UP")
      VALUE_INSTANT_ARTICLES_SIGN_UP("INSTANT_ARTICLES_SIGN_UP"),
      @SerializedName("INSTANT_ARTICLES_CTA_MANAGEMENT")
      VALUE_INSTANT_ARTICLES_CTA_MANAGEMENT("INSTANT_ARTICLES_CTA_MANAGEMENT"),
      @SerializedName("INSTANT_ARTICLES_TRAFFIC_LIFT")
      VALUE_INSTANT_ARTICLES_TRAFFIC_LIFT("INSTANT_ARTICLES_TRAFFIC_LIFT"),
      @SerializedName("INVOICES_ACTIVE")
      VALUE_INVOICES_ACTIVE("INVOICES_ACTIVE"),
      @SerializedName("INVOICES_HISTORY")
      VALUE_INVOICES_HISTORY("INVOICES_HISTORY"),
      @SerializedName("LEAD_ADS_DRAFT_FORMS")
      VALUE_LEAD_ADS_DRAFT_FORMS("LEAD_ADS_DRAFT_FORMS"),
      @SerializedName("LEAD_ADS_FORMS")
      VALUE_LEAD_ADS_FORMS("LEAD_ADS_FORMS"),
      @SerializedName("LEAD_ADS_CRM_SETUP")
      VALUE_LEAD_ADS_CRM_SETUP("LEAD_ADS_CRM_SETUP"),
      @SerializedName("LEAD_ADS_CUSTOM_CRM_SETUP")
      VALUE_LEAD_ADS_CUSTOM_CRM_SETUP("LEAD_ADS_CUSTOM_CRM_SETUP"),
      @SerializedName("PUBLISHED_POSTS")
      VALUE_PUBLISHED_POSTS("PUBLISHED_POSTS"),
      @SerializedName("SCHEDULED_POSTS")
      VALUE_SCHEDULED_POSTS("SCHEDULED_POSTS"),
      @SerializedName("ADS_POSTS")
      VALUE_ADS_POSTS("ADS_POSTS"),
      @SerializedName("VIDEOS")
      VALUE_VIDEOS("VIDEOS"),
      @SerializedName("JOB_POSTS")
      VALUE_JOB_POSTS("JOB_POSTS"),
      @SerializedName("NEW_MATCHES")
      VALUE_NEW_MATCHES("NEW_MATCHES"),
      @SerializedName("VIDEOS_COPYRIGHT")
      VALUE_VIDEOS_COPYRIGHT("VIDEOS_COPYRIGHT"),
      @SerializedName("REPORTED")
      VALUE_REPORTED("REPORTED"),
      @SerializedName("PLAYLISTS")
      VALUE_PLAYLISTS("PLAYLISTS"),
      @SerializedName("PLAYLIST_DETAILS")
      VALUE_PLAYLIST_DETAILS("PLAYLIST_DETAILS"),
      @SerializedName("POSTS_CONFIG")
      VALUE_POSTS_CONFIG("POSTS_CONFIG"),
      @SerializedName("SEASONS")
      VALUE_SEASONS("SEASONS"),
      @SerializedName("SEASON_DETAILS")
      VALUE_SEASON_DETAILS("SEASON_DETAILS"),
      @SerializedName("TAKEDOWNS")
      VALUE_TAKEDOWNS("TAKEDOWNS"),
      @SerializedName("UNSENT_REPORTS")
      VALUE_UNSENT_REPORTS("UNSENT_REPORTS"),
      @SerializedName("ALLOWED")
      VALUE_ALLOWED("ALLOWED"),
      @SerializedName("TRACKED")
      VALUE_TRACKED("TRACKED"),
      @SerializedName("BLOCKED")
      VALUE_BLOCKED("BLOCKED"),
      @SerializedName("CLAIMED")
      VALUE_CLAIMED("CLAIMED"),
      @SerializedName("MANUAL_REVIEW")
      VALUE_MANUAL_REVIEW("MANUAL_REVIEW"),
      @SerializedName("MATCH_RULES")
      VALUE_MATCH_RULES("MATCH_RULES"),
      @SerializedName("DISPUTES")
      VALUE_DISPUTES("DISPUTES"),
      @SerializedName("ACTIVE_FUNDRAISERS")
      VALUE_ACTIVE_FUNDRAISERS("ACTIVE_FUNDRAISERS"),
      @SerializedName("DRAFT_FUNDRAISERS")
      VALUE_DRAFT_FUNDRAISERS("DRAFT_FUNDRAISERS"),
      @SerializedName("READY_FUNDRAISERS")
      VALUE_READY_FUNDRAISERS("READY_FUNDRAISERS"),
      @SerializedName("ENDED_FUNDRAISERS")
      VALUE_ENDED_FUNDRAISERS("ENDED_FUNDRAISERS"),
      @SerializedName("ADS_CANVAS")
      VALUE_ADS_CANVAS("ADS_CANVAS"),
      @SerializedName("REFERENCE_FILES")
      VALUE_REFERENCE_FILES("REFERENCE_FILES"),
      @SerializedName("ALL_REFERENCE_FILES")
      VALUE_ALL_REFERENCE_FILES("ALL_REFERENCE_FILES"),
      @SerializedName("REFERENCE_CONFLICTS")
      VALUE_REFERENCE_CONFLICTS("REFERENCE_CONFLICTS"),
      @SerializedName("REFERENCE_POSSIBLE_CONFLICTS")
      VALUE_REFERENCE_POSSIBLE_CONFLICTS("REFERENCE_POSSIBLE_CONFLICTS"),
      @SerializedName("REFERENCE_RESOLUTIONS")
      VALUE_REFERENCE_RESOLUTIONS("REFERENCE_RESOLUTIONS"),
      @SerializedName("SOUND_RECORDINGS")
      VALUE_SOUND_RECORDINGS("SOUND_RECORDINGS"),
      @SerializedName("PREMIUM_MUSIC_VIDEOS")
      VALUE_PREMIUM_MUSIC_VIDEOS("PREMIUM_MUSIC_VIDEOS"),
      @SerializedName("LIVE_BROADCASTS")
      VALUE_LIVE_BROADCASTS("LIVE_BROADCASTS"),
      @SerializedName("CROSSPOSTED_VIDEOS")
      VALUE_CROSSPOSTED_VIDEOS("CROSSPOSTED_VIDEOS"),
      @SerializedName("PUBLISHED_PROFILE_PICTURE_FRAMES")
      VALUE_PUBLISHED_PROFILE_PICTURE_FRAMES("PUBLISHED_PROFILE_PICTURE_FRAMES"),
      @SerializedName("PENDING_PROFILE_PICTURE_FRAMES")
      VALUE_PENDING_PROFILE_PICTURE_FRAMES("PENDING_PROFILE_PICTURE_FRAMES"),
      @SerializedName("TAROT_COMPOSER")
      VALUE_TAROT_COMPOSER("TAROT_COMPOSER"),
      @SerializedName("DRAFT_EDITIONS")
      VALUE_DRAFT_EDITIONS("DRAFT_EDITIONS"),
      @SerializedName("PUBLISHED_EDITIONS")
      VALUE_PUBLISHED_EDITIONS("PUBLISHED_EDITIONS"),
      @SerializedName("PUBLISHED_EVENTS")
      VALUE_PUBLISHED_EVENTS("PUBLISHED_EVENTS"),
      @SerializedName("DRAFT_EVENTS")
      VALUE_DRAFT_EVENTS("DRAFT_EVENTS"),
      @SerializedName("SCHEDULED_EVENTS")
      VALUE_SCHEDULED_EVENTS("SCHEDULED_EVENTS"),
      @SerializedName("ARCHIVED_EVENTS")
      VALUE_ARCHIVED_EVENTS("ARCHIVED_EVENTS"),
      @SerializedName("TOURS")
      VALUE_TOURS("TOURS"),
      @SerializedName("POLLS_COMPOSER")
      VALUE_POLLS_COMPOSER("POLLS_COMPOSER"),
      @SerializedName("BRAND_ASSET_LIBRARY")
      VALUE_BRAND_ASSET_LIBRARY("BRAND_ASSET_LIBRARY"),
      @SerializedName("JOB_APPLICATIONS")
      VALUE_JOB_APPLICATIONS("JOB_APPLICATIONS"),
      @SerializedName("SUBSCRIPTIONS")
      VALUE_SUBSCRIPTIONS("SUBSCRIPTIONS"),
      @SerializedName("NEWS_SUBSCRIPTIONS_PUBLISHER_TOOLS")
      VALUE_NEWS_SUBSCRIPTIONS_PUBLISHER_TOOLS("NEWS_SUBSCRIPTIONS_PUBLISHER_TOOLS"),
      @SerializedName("NEWS_SUBSCRIPTIONS_PUBLISHER_ASSET_MANAGEMENT")
      VALUE_NEWS_SUBSCRIPTIONS_PUBLISHER_ASSET_MANAGEMENT("NEWS_SUBSCRIPTIONS_PUBLISHER_ASSET_MANAGEMENT"),
      @SerializedName("NEWS_SUBSCRIPTIONS_PUBLISHER_OFFER_MANAGEMENT")
      VALUE_NEWS_SUBSCRIPTIONS_PUBLISHER_OFFER_MANAGEMENT("NEWS_SUBSCRIPTIONS_PUBLISHER_OFFER_MANAGEMENT"),
      @SerializedName("QR_CODE")
      VALUE_QR_CODE("QR_CODE"),
      @SerializedName("ORGANIC_PIXEL")
      VALUE_ORGANIC_PIXEL("ORGANIC_PIXEL"),
      @SerializedName("CREDIBILITY_INDICATORS")
      VALUE_CREDIBILITY_INDICATORS("CREDIBILITY_INDICATORS"),
      @SerializedName("ATTRIBUTIONS")
      VALUE_ATTRIBUTIONS("ATTRIBUTIONS"),
      @SerializedName("BROADCASTED_MESSAGES")
      VALUE_BROADCASTED_MESSAGES("BROADCASTED_MESSAGES"),
      @SerializedName("BRANDED_CONTENT")
      VALUE_BRANDED_CONTENT("BRANDED_CONTENT"),
      @SerializedName("BRANDED_CONTENT_CREATOR")
      VALUE_BRANDED_CONTENT_CREATOR("BRANDED_CONTENT_CREATOR"),
      @SerializedName("SOUNDS_COLLECTION")
      VALUE_SOUNDS_COLLECTION("SOUNDS_COLLECTION"),
      @SerializedName("CONTENT_TESTS")
      VALUE_CONTENT_TESTS("CONTENT_TESTS"),
      @SerializedName("GEM_PRODUCER_DASHBOARD")
      VALUE_GEM_PRODUCER_DASHBOARD("GEM_PRODUCER_DASHBOARD"),
      @SerializedName("MONETIZED_VIDEOS")
      VALUE_MONETIZED_VIDEOS("MONETIZED_VIDEOS"),
      @SerializedName("AUDIO_RELEASES")
      VALUE_AUDIO_RELEASES("AUDIO_RELEASES"),
      @SerializedName("NEWS_STORYLINES")
      VALUE_NEWS_STORYLINES("NEWS_STORYLINES"),
      @SerializedName("REGISTRATIONS")
      VALUE_REGISTRATIONS("REGISTRATIONS"),
      @SerializedName("IA_REGIWALL_SETTINGS")
      VALUE_IA_REGIWALL_SETTINGS("IA_REGIWALL_SETTINGS"),
      NULL(null);

      private String value;

      private EnumSection(String value) {
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

  public PageSavedFilter copyFrom(PageSavedFilter instance) {
    this.mDisplayName = instance.mDisplayName;
    this.mFilters = instance.mFilters;
    this.mId = instance.mId;
    this.mPageId = instance.mPageId;
    this.mSection = instance.mSection;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageSavedFilter> getParser() {
    return new APIRequest.ResponseParser<PageSavedFilter>() {
      public APINodeList<PageSavedFilter> parseResponse(String response, APIContext context, APIRequest<PageSavedFilter> request) throws MalformedResponseException {
        return PageSavedFilter.parseResponse(response, context, request);
      }
    };
  }
}
