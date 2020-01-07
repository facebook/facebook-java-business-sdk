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
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PageSavedFilter> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
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
    return
      new APIRequest(context, "", "/", "GET", PageSavedFilter.getParser())
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
  public static PageSavedFilter loadJSON(String json, APIContext context, String header) {
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
    pageSavedFilter.header = header;
    return pageSavedFilter;
  }

  public static APINodeList<PageSavedFilter> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PageSavedFilter> pageSavedFilters = new APINodeList<PageSavedFilter>(request, json, header);
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
          pageSavedFilters.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
              pageSavedFilters.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  pageSavedFilters.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageSavedFilters.add(loadJSON(obj.toString(), context, header));
            }
          }
          return pageSavedFilters;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageSavedFilters.add(loadJSON(entry.getValue().toString(), context, header));
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
              pageSavedFilters.add(loadJSON(value.toString(), context, header));
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
          pageSavedFilters.add(loadJSON(json, context, header));
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
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
    public PageSavedFilter parseResponse(String response, String header) throws APIException {
      return PageSavedFilter.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PageSavedFilter execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageSavedFilter execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PageSavedFilter> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageSavedFilter> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PageSavedFilter>() {
           public PageSavedFilter apply(ResponseWrapper result) {
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
      @SerializedName("ACTIVE_FUNDRAISERS")
      VALUE_ACTIVE_FUNDRAISERS("ACTIVE_FUNDRAISERS"),
      @SerializedName("ADS_CANVAS")
      VALUE_ADS_CANVAS("ADS_CANVAS"),
      @SerializedName("ADS_POSTS")
      VALUE_ADS_POSTS("ADS_POSTS"),
      @SerializedName("ALLOWED")
      VALUE_ALLOWED("ALLOWED"),
      @SerializedName("ALL_REFERENCE_FILES")
      VALUE_ALL_REFERENCE_FILES("ALL_REFERENCE_FILES"),
      @SerializedName("ARCHIVED_EVENTS")
      VALUE_ARCHIVED_EVENTS("ARCHIVED_EVENTS"),
      @SerializedName("ATTRIBUTIONS")
      VALUE_ATTRIBUTIONS("ATTRIBUTIONS"),
      @SerializedName("AUDIO_RELEASES")
      VALUE_AUDIO_RELEASES("AUDIO_RELEASES"),
      @SerializedName("BLOCKED")
      VALUE_BLOCKED("BLOCKED"),
      @SerializedName("BRANDED_CONTENT")
      VALUE_BRANDED_CONTENT("BRANDED_CONTENT"),
      @SerializedName("BRANDED_CONTENT_CREATOR")
      VALUE_BRANDED_CONTENT_CREATOR("BRANDED_CONTENT_CREATOR"),
      @SerializedName("BRANDED_CONTENT_SUSPECTED")
      VALUE_BRANDED_CONTENT_SUSPECTED("BRANDED_CONTENT_SUSPECTED"),
      @SerializedName("CANDIDATE_VIDEOS")
      VALUE_CANDIDATE_VIDEOS("CANDIDATE_VIDEOS"),
      @SerializedName("CHEX_COMPLETED_ORDERS")
      VALUE_CHEX_COMPLETED_ORDERS("CHEX_COMPLETED_ORDERS"),
      @SerializedName("CHEX_PENDING_ORDERS")
      VALUE_CHEX_PENDING_ORDERS("CHEX_PENDING_ORDERS"),
      @SerializedName("CLAIMED")
      VALUE_CLAIMED("CLAIMED"),
      @SerializedName("COMMERCE_COLLECTIONS")
      VALUE_COMMERCE_COLLECTIONS("COMMERCE_COLLECTIONS"),
      @SerializedName("COMMERCE_MERCHANT_SETTINGS")
      VALUE_COMMERCE_MERCHANT_SETTINGS("COMMERCE_MERCHANT_SETTINGS"),
      @SerializedName("COMMERCE_PAST_ORDERS")
      VALUE_COMMERCE_PAST_ORDERS("COMMERCE_PAST_ORDERS"),
      @SerializedName("COMMERCE_PENDING_ORDERS")
      VALUE_COMMERCE_PENDING_ORDERS("COMMERCE_PENDING_ORDERS"),
      @SerializedName("COMMERCE_PLATFORM_SETTINGS")
      VALUE_COMMERCE_PLATFORM_SETTINGS("COMMERCE_PLATFORM_SETTINGS"),
      @SerializedName("COMMERCE_PRODUCTS")
      VALUE_COMMERCE_PRODUCTS("COMMERCE_PRODUCTS"),
      @SerializedName("COMMERCE_SHOP_LINK")
      VALUE_COMMERCE_SHOP_LINK("COMMERCE_SHOP_LINK"),
      @SerializedName("CONTENT_TESTS")
      VALUE_CONTENT_TESTS("CONTENT_TESTS"),
      @SerializedName("CREATOR_STUDIO")
      VALUE_CREATOR_STUDIO("CREATOR_STUDIO"),
      @SerializedName("CREATOR_STUDIO_ALL_MATCHES")
      VALUE_CREATOR_STUDIO_ALL_MATCHES("CREATOR_STUDIO_ALL_MATCHES"),
      @SerializedName("CREATOR_STUDIO_ALL_REFERENCE_FILES")
      VALUE_CREATOR_STUDIO_ALL_REFERENCE_FILES("CREATOR_STUDIO_ALL_REFERENCE_FILES"),
      @SerializedName("CREATOR_STUDIO_BLOCKED")
      VALUE_CREATOR_STUDIO_BLOCKED("CREATOR_STUDIO_BLOCKED"),
      @SerializedName("CREATOR_STUDIO_COLLECT_AD_EARNINGS")
      VALUE_CREATOR_STUDIO_COLLECT_AD_EARNINGS("CREATOR_STUDIO_COLLECT_AD_EARNINGS"),
      @SerializedName("CREATOR_STUDIO_DISPUTES")
      VALUE_CREATOR_STUDIO_DISPUTES("CREATOR_STUDIO_DISPUTES"),
      @SerializedName("CREATOR_STUDIO_PUBLISHED_ALL_REFERENCE_FILES")
      VALUE_CREATOR_STUDIO_PUBLISHED_ALL_REFERENCE_FILES("CREATOR_STUDIO_PUBLISHED_ALL_REFERENCE_FILES"),
      @SerializedName("CREATOR_STUDIO_PUBLISHED_BLOCKED")
      VALUE_CREATOR_STUDIO_PUBLISHED_BLOCKED("CREATOR_STUDIO_PUBLISHED_BLOCKED"),
      @SerializedName("CREATOR_STUDIO_PUBLISHED_DISPUTES")
      VALUE_CREATOR_STUDIO_PUBLISHED_DISPUTES("CREATOR_STUDIO_PUBLISHED_DISPUTES"),
      @SerializedName("CREATOR_STUDIO_PUBLISHED_MANUAL_REVIEW")
      VALUE_CREATOR_STUDIO_PUBLISHED_MANUAL_REVIEW("CREATOR_STUDIO_PUBLISHED_MANUAL_REVIEW"),
      @SerializedName("CREATOR_STUDIO_PUBLISHED_TRACKED")
      VALUE_CREATOR_STUDIO_PUBLISHED_TRACKED("CREATOR_STUDIO_PUBLISHED_TRACKED"),
      @SerializedName("CREATOR_STUDIO_REFERENCE_CONFLICTS")
      VALUE_CREATOR_STUDIO_REFERENCE_CONFLICTS("CREATOR_STUDIO_REFERENCE_CONFLICTS"),
      @SerializedName("CREATOR_STUDIO_REFERENCE_POSSIBLE_CONFLICTS")
      VALUE_CREATOR_STUDIO_REFERENCE_POSSIBLE_CONFLICTS("CREATOR_STUDIO_REFERENCE_POSSIBLE_CONFLICTS"),
      @SerializedName("CREATOR_STUDIO_REFERENCE_RESOLUTIONS")
      VALUE_CREATOR_STUDIO_REFERENCE_RESOLUTIONS("CREATOR_STUDIO_REFERENCE_RESOLUTIONS"),
      @SerializedName("CREATOR_STUDIO_TAKEDOWNS")
      VALUE_CREATOR_STUDIO_TAKEDOWNS("CREATOR_STUDIO_TAKEDOWNS"),
      @SerializedName("CREATOR_STUDIO_TAKEDOWN_REQUESTS")
      VALUE_CREATOR_STUDIO_TAKEDOWN_REQUESTS("CREATOR_STUDIO_TAKEDOWN_REQUESTS"),
      @SerializedName("CREATOR_STUDIO_TRACKED")
      VALUE_CREATOR_STUDIO_TRACKED("CREATOR_STUDIO_TRACKED"),
      @SerializedName("CROSSPOSTED_VIDEOS")
      VALUE_CROSSPOSTED_VIDEOS("CROSSPOSTED_VIDEOS"),
      @SerializedName("DISPUTES")
      VALUE_DISPUTES("DISPUTES"),
      @SerializedName("DONATIONS_SETTINGS")
      VALUE_DONATIONS_SETTINGS("DONATIONS_SETTINGS"),
      @SerializedName("DRAFTS")
      VALUE_DRAFTS("DRAFTS"),
      @SerializedName("DRAFT_EVENTS")
      VALUE_DRAFT_EVENTS("DRAFT_EVENTS"),
      @SerializedName("DRAFT_FUNDRAISERS")
      VALUE_DRAFT_FUNDRAISERS("DRAFT_FUNDRAISERS"),
      @SerializedName("ENDED_FUNDRAISERS")
      VALUE_ENDED_FUNDRAISERS("ENDED_FUNDRAISERS"),
      @SerializedName("EXPIRED_POSTS")
      VALUE_EXPIRED_POSTS("EXPIRED_POSTS"),
      @SerializedName("EXPIRING_POSTS")
      VALUE_EXPIRING_POSTS("EXPIRING_POSTS"),
      @SerializedName("GEM_PRODUCER_DASHBOARD")
      VALUE_GEM_PRODUCER_DASHBOARD("GEM_PRODUCER_DASHBOARD"),
      @SerializedName("IA_REGIWALL_SETTINGS")
      VALUE_IA_REGIWALL_SETTINGS("IA_REGIWALL_SETTINGS"),
      @SerializedName("INSTANT_ARTICLES")
      VALUE_INSTANT_ARTICLES("INSTANT_ARTICLES"),
      @SerializedName("INSTANT_ARTICLES_CTA_MANAGEMENT")
      VALUE_INSTANT_ARTICLES_CTA_MANAGEMENT("INSTANT_ARTICLES_CTA_MANAGEMENT"),
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
      @SerializedName("INSTANT_ARTICLES_TRAFFIC_LIFT")
      VALUE_INSTANT_ARTICLES_TRAFFIC_LIFT("INSTANT_ARTICLES_TRAFFIC_LIFT"),
      @SerializedName("INVOICES_ACTIVE")
      VALUE_INVOICES_ACTIVE("INVOICES_ACTIVE"),
      @SerializedName("INVOICES_HISTORY")
      VALUE_INVOICES_HISTORY("INVOICES_HISTORY"),
      @SerializedName("JOB_APPLICATIONS")
      VALUE_JOB_APPLICATIONS("JOB_APPLICATIONS"),
      @SerializedName("JOB_POSTS")
      VALUE_JOB_POSTS("JOB_POSTS"),
      @SerializedName("LEAD_ADS_CRM_SETUP")
      VALUE_LEAD_ADS_CRM_SETUP("LEAD_ADS_CRM_SETUP"),
      @SerializedName("LEAD_ADS_CUSTOM_CRM_SETUP")
      VALUE_LEAD_ADS_CUSTOM_CRM_SETUP("LEAD_ADS_CUSTOM_CRM_SETUP"),
      @SerializedName("LEAD_ADS_DRAFT_FORMS")
      VALUE_LEAD_ADS_DRAFT_FORMS("LEAD_ADS_DRAFT_FORMS"),
      @SerializedName("LEAD_ADS_FORMS")
      VALUE_LEAD_ADS_FORMS("LEAD_ADS_FORMS"),
      @SerializedName("LIVE_BROADCASTS")
      VALUE_LIVE_BROADCASTS("LIVE_BROADCASTS"),
      @SerializedName("MANUAL_CLAIMS")
      VALUE_MANUAL_CLAIMS("MANUAL_CLAIMS"),
      @SerializedName("MANUAL_CLAIM_FACEBOOK_VIDEOS")
      VALUE_MANUAL_CLAIM_FACEBOOK_VIDEOS("MANUAL_CLAIM_FACEBOOK_VIDEOS"),
      @SerializedName("MANUAL_CLAIM_INSTAGRAM_VIDEOS")
      VALUE_MANUAL_CLAIM_INSTAGRAM_VIDEOS("MANUAL_CLAIM_INSTAGRAM_VIDEOS"),
      @SerializedName("MANUAL_REVIEW")
      VALUE_MANUAL_REVIEW("MANUAL_REVIEW"),
      @SerializedName("MATCH_RULES")
      VALUE_MATCH_RULES("MATCH_RULES"),
      @SerializedName("MONETIZED_VIDEOS")
      VALUE_MONETIZED_VIDEOS("MONETIZED_VIDEOS"),
      @SerializedName("NEWS_SUBSCRIPTIONS")
      VALUE_NEWS_SUBSCRIPTIONS("NEWS_SUBSCRIPTIONS"),
      @SerializedName("NEWS_SUBSCRIPTIONS_PUBLISHER_INSIGHTS")
      VALUE_NEWS_SUBSCRIPTIONS_PUBLISHER_INSIGHTS("NEWS_SUBSCRIPTIONS_PUBLISHER_INSIGHTS"),
      @SerializedName("NEWS_SUBSCRIPTIONS_PUBLISHER_TEST_USERS")
      VALUE_NEWS_SUBSCRIPTIONS_PUBLISHER_TEST_USERS("NEWS_SUBSCRIPTIONS_PUBLISHER_TEST_USERS"),
      @SerializedName("NEW_MATCHES")
      VALUE_NEW_MATCHES("NEW_MATCHES"),
      @SerializedName("PENDING_PROFILE_PICTURE_FRAMES")
      VALUE_PENDING_PROFILE_PICTURE_FRAMES("PENDING_PROFILE_PICTURE_FRAMES"),
      @SerializedName("PLAYLISTS")
      VALUE_PLAYLISTS("PLAYLISTS"),
      @SerializedName("PLAYLIST_DETAILS")
      VALUE_PLAYLIST_DETAILS("PLAYLIST_DETAILS"),
      @SerializedName("POLLS_COMPOSER")
      VALUE_POLLS_COMPOSER("POLLS_COMPOSER"),
      @SerializedName("POSTS_CONFIG")
      VALUE_POSTS_CONFIG("POSTS_CONFIG"),
      @SerializedName("POST_IDEAS")
      VALUE_POST_IDEAS("POST_IDEAS"),
      @SerializedName("PREMIUM_MUSIC_VIDEOS")
      VALUE_PREMIUM_MUSIC_VIDEOS("PREMIUM_MUSIC_VIDEOS"),
      @SerializedName("PUBLISHED_EVENTS")
      VALUE_PUBLISHED_EVENTS("PUBLISHED_EVENTS"),
      @SerializedName("PUBLISHED_POSTS")
      VALUE_PUBLISHED_POSTS("PUBLISHED_POSTS"),
      @SerializedName("PUBLISHED_PROFILE_PICTURE_FRAMES")
      VALUE_PUBLISHED_PROFILE_PICTURE_FRAMES("PUBLISHED_PROFILE_PICTURE_FRAMES"),
      @SerializedName("QR_CODE")
      VALUE_QR_CODE("QR_CODE"),
      @SerializedName("READY_FUNDRAISERS")
      VALUE_READY_FUNDRAISERS("READY_FUNDRAISERS"),
      @SerializedName("REFERENCE_CONFLICTS")
      VALUE_REFERENCE_CONFLICTS("REFERENCE_CONFLICTS"),
      @SerializedName("REFERENCE_FILES")
      VALUE_REFERENCE_FILES("REFERENCE_FILES"),
      @SerializedName("REFERENCE_POSSIBLE_CONFLICTS")
      VALUE_REFERENCE_POSSIBLE_CONFLICTS("REFERENCE_POSSIBLE_CONFLICTS"),
      @SerializedName("REFERENCE_RESOLUTIONS")
      VALUE_REFERENCE_RESOLUTIONS("REFERENCE_RESOLUTIONS"),
      @SerializedName("REGISTRATIONS")
      VALUE_REGISTRATIONS("REGISTRATIONS"),
      @SerializedName("REPORTED")
      VALUE_REPORTED("REPORTED"),
      @SerializedName("REWARD_PROGRAM")
      VALUE_REWARD_PROGRAM("REWARD_PROGRAM"),
      @SerializedName("REWARD_PROGRAM_COLLATERAL_MANAGEMENT")
      VALUE_REWARD_PROGRAM_COLLATERAL_MANAGEMENT("REWARD_PROGRAM_COLLATERAL_MANAGEMENT"),
      @SerializedName("REWARD_PROGRAM_TRANSACTION_HISTORY")
      VALUE_REWARD_PROGRAM_TRANSACTION_HISTORY("REWARD_PROGRAM_TRANSACTION_HISTORY"),
      @SerializedName("SCHEDULED_EVENTS")
      VALUE_SCHEDULED_EVENTS("SCHEDULED_EVENTS"),
      @SerializedName("SCHEDULED_POSTS")
      VALUE_SCHEDULED_POSTS("SCHEDULED_POSTS"),
      @SerializedName("SEASONS")
      VALUE_SEASONS("SEASONS"),
      @SerializedName("SEASON_DETAILS")
      VALUE_SEASON_DETAILS("SEASON_DETAILS"),
      @SerializedName("SOUNDS_COLLECTION")
      VALUE_SOUNDS_COLLECTION("SOUNDS_COLLECTION"),
      @SerializedName("SOUND_RECORDINGS")
      VALUE_SOUND_RECORDINGS("SOUND_RECORDINGS"),
      @SerializedName("STORY_ARCHIVE")
      VALUE_STORY_ARCHIVE("STORY_ARCHIVE"),
      @SerializedName("STREAMER_DASHBOARD")
      VALUE_STREAMER_DASHBOARD("STREAMER_DASHBOARD"),
      @SerializedName("TAKEDOWNS")
      VALUE_TAKEDOWNS("TAKEDOWNS"),
      @SerializedName("TOURS")
      VALUE_TOURS("TOURS"),
      @SerializedName("TRACKED")
      VALUE_TRACKED("TRACKED"),
      @SerializedName("UNSENT_REPORTS")
      VALUE_UNSENT_REPORTS("UNSENT_REPORTS"),
      @SerializedName("VIDEOS")
      VALUE_VIDEOS("VIDEOS"),
      @SerializedName("VIDEOS_COPYRIGHT")
      VALUE_VIDEOS_COPYRIGHT("VIDEOS_COPYRIGHT"),
      ;

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
      public APINodeList<PageSavedFilter> parseResponse(String response, APIContext context, APIRequest<PageSavedFilter> request, String header) throws MalformedResponseException {
        return PageSavedFilter.parseResponse(response, context, request, header);
      }
    };
  }
}
