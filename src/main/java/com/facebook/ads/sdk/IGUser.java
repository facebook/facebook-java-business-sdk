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
public class IGUser extends APINode {
  @SerializedName("biography")
  private String mBiography = null;
  @SerializedName("business_discovery")
  private IGUser mBusinessDiscovery = null;
  @SerializedName("followers_count")
  private Long mFollowersCount = null;
  @SerializedName("follows_count")
  private Long mFollowsCount = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_id")
  private Long mIgId = null;
  @SerializedName("media_count")
  private Long mMediaCount = null;
  @SerializedName("mentioned_comment")
  private IGComment mMentionedComment = null;
  @SerializedName("mentioned_media")
  private IGMedia mMentionedMedia = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("profile_picture_url")
  private String mProfilePictureUrl = null;
  @SerializedName("shopping_product_tag_eligibility")
  private Boolean mShoppingProductTagEligibility = null;
  @SerializedName("shopping_review_status")
  private String mShoppingReviewStatus = null;
  @SerializedName("username")
  private String mUsername = null;
  @SerializedName("website")
  private String mWebsite = null;
  protected static Gson gson = null;

  IGUser() {
  }

  public IGUser(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IGUser(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IGUser fetch() throws APIException{
    IGUser newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IGUser fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IGUser> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IGUser fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IGUser> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IGUser> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IGUser>)(
      new APIRequest<IGUser>(context, "", "/", "GET", IGUser.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IGUser>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IGUser.getParser())
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
  public static IGUser loadJSON(String json, APIContext context, String header) {
    IGUser igUser = getGson().fromJson(json, IGUser.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(igUser.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    igUser.context = context;
    igUser.rawValue = json;
    igUser.header = header;
    return igUser;
  }

  public static APINodeList<IGUser> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IGUser> igUsers = new APINodeList<IGUser>(request, json, header);
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
          igUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return igUsers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                igUsers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            igUsers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              igUsers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              igUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  igUsers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              igUsers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return igUsers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              igUsers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return igUsers;
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
              igUsers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return igUsers;
          }

          // Sixth, check if it's pure JsonObject
          igUsers.clear();
          igUsers.add(loadJSON(json, context, header));
          return igUsers;
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

  public APIRequestGetAvailableCatalogs getAvailableCatalogs() {
    return new APIRequestGetAvailableCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCatalogProductSearch getCatalogProductSearch() {
    return new APIRequestGetCatalogProductSearch(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetContentPublishingLimit getContentPublishingLimit() {
    return new APIRequestGetContentPublishingLimit(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLiveMedia getLiveMedia() {
    return new APIRequestGetLiveMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMedia getMedia() {
    return new APIRequestGetMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMedia createMedia() {
    return new APIRequestCreateMedia(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMediaPublish createMediaPublish() {
    return new APIRequestCreateMediaPublish(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMention createMention() {
    return new APIRequestCreateMention(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetNotificationMessageTokens getNotificationMessageTokens() {
    return new APIRequestGetNotificationMessageTokens(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductAppeal getProductAppeal() {
    return new APIRequestGetProductAppeal(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductAppeal createProductAppeal() {
    return new APIRequestCreateProductAppeal(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetRecentlySearchedHashtags getRecentlySearchedHashtags() {
    return new APIRequestGetRecentlySearchedHashtags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetStories getStories() {
    return new APIRequestGetStories(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTags getTags() {
    return new APIRequestGetTags(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldBiography() {
    return mBiography;
  }

  public IGUser getFieldBusinessDiscovery() {
    if (mBusinessDiscovery != null) {
      mBusinessDiscovery.context = getContext();
    }
    return mBusinessDiscovery;
  }

  public Long getFieldFollowersCount() {
    return mFollowersCount;
  }

  public Long getFieldFollowsCount() {
    return mFollowsCount;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldIgId() {
    return mIgId;
  }

  public Long getFieldMediaCount() {
    return mMediaCount;
  }

  public IGComment getFieldMentionedComment() {
    if (mMentionedComment != null) {
      mMentionedComment.context = getContext();
    }
    return mMentionedComment;
  }

  public IGMedia getFieldMentionedMedia() {
    if (mMentionedMedia != null) {
      mMentionedMedia.context = getContext();
    }
    return mMentionedMedia;
  }

  public String getFieldName() {
    return mName;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public String getFieldProfilePictureUrl() {
    return mProfilePictureUrl;
  }

  public Boolean getFieldShoppingProductTagEligibility() {
    return mShoppingProductTagEligibility;
  }

  public String getFieldShoppingReviewStatus() {
    return mShoppingReviewStatus;
  }

  public String getFieldUsername() {
    return mUsername;
  }

  public String getFieldWebsite() {
    return mWebsite;
  }



  public static class APIRequestGetAvailableCatalogs extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestGetAvailableCatalogs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAvailableCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/available_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAvailableCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAvailableCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAvailableCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAvailableCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAvailableCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCatalogProductSearch extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_id",
      "q",
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
               return APIRequestGetCatalogProductSearch.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCatalogProductSearch(String nodeId, APIContext context) {
      super(context, nodeId, "/catalog_product_search", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCatalogProductSearch setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCatalogProductSearch setCatalogId (String catalogId) {
      this.setParam("catalog_id", catalogId);
      return this;
    }

    public APIRequestGetCatalogProductSearch setQ (String q) {
      this.setParam("q", q);
      return this;
    }

    public APIRequestGetCatalogProductSearch requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCatalogProductSearch requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCatalogProductSearch requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCatalogProductSearch requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetContentPublishingLimit extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
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
               return APIRequestGetContentPublishingLimit.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetContentPublishingLimit(String nodeId, APIContext context) {
      super(context, nodeId, "/content_publishing_limit", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetContentPublishingLimit setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetContentPublishingLimit setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetContentPublishingLimit requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetContentPublishingLimit requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetContentPublishingLimit requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetContentPublishingLimit requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInsights extends APIRequest<InstagramInsightsResult> {

    APINodeList<InstagramInsightsResult> lastResponse = null;
    @Override
    public APINodeList<InstagramInsightsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdown",
      "metric",
      "metric_type",
      "period",
      "since",
      "timeframe",
      "until",
    };

    public static final String[] FIELDS = {
      "description",
      "id",
      "name",
      "period",
      "title",
      "total_value",
      "values",
    };

    @Override
    public APINodeList<InstagramInsightsResult> parseResponse(String response, String header) throws APIException {
      return InstagramInsightsResult.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstagramInsightsResult> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstagramInsightsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InstagramInsightsResult>>() {
           public APINodeList<InstagramInsightsResult> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestGetInsights setBreakdown (List<InstagramInsightsResult.EnumBreakdown> breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }
    public APIRequestGetInsights setBreakdown (String breakdown) {
      this.setParam("breakdown", breakdown);
      return this;
    }

    public APIRequestGetInsights setMetric (List<InstagramInsightsResult.EnumMetric> metric) {
      this.setParam("metric", metric);
      return this;
    }
    public APIRequestGetInsights setMetric (String metric) {
      this.setParam("metric", metric);
      return this;
    }

    public APIRequestGetInsights setMetricType (InstagramInsightsResult.EnumMetricType metricType) {
      this.setParam("metric_type", metricType);
      return this;
    }
    public APIRequestGetInsights setMetricType (String metricType) {
      this.setParam("metric_type", metricType);
      return this;
    }

    public APIRequestGetInsights setPeriod (List<InstagramInsightsResult.EnumPeriod> period) {
      this.setParam("period", period);
      return this;
    }
    public APIRequestGetInsights setPeriod (String period) {
      this.setParam("period", period);
      return this;
    }

    public APIRequestGetInsights setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetInsights setTimeframe (InstagramInsightsResult.EnumTimeframe timeframe) {
      this.setParam("timeframe", timeframe);
      return this;
    }
    public APIRequestGetInsights setTimeframe (String timeframe) {
      this.setParam("timeframe", timeframe);
      return this;
    }

    public APIRequestGetInsights setUntil (String until) {
      this.setParam("until", until);
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
    public APIRequestGetInsights requestTotalValueField () {
      return this.requestTotalValueField(true);
    }
    public APIRequestGetInsights requestTotalValueField (boolean value) {
      this.requestField("total_value", value);
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

  public static class APIRequestGetLiveMedia extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "caption",
      "comments_count",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLiveMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetLiveMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/live_media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLiveMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLiveMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLiveMedia setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetLiveMedia setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetLiveMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLiveMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLiveMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLiveMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLiveMedia requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetLiveMedia requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetLiveMedia requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetLiveMedia requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLiveMedia requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetLiveMedia requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetLiveMedia requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetLiveMedia requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetLiveMedia requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetLiveMedia requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetLiveMedia requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetLiveMedia requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetLiveMedia requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetLiveMedia requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetLiveMedia requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetLiveMedia requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetLiveMedia requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetLiveMedia requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetLiveMedia requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetLiveMedia requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetLiveMedia requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetLiveMedia requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetLiveMedia requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetLiveMedia requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetLiveMedia requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetLiveMedia requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetLiveMedia requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetLiveMedia requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetLiveMedia requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetMedia extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "since",
      "until",
    };

    public static final String[] FIELDS = {
      "caption",
      "comments_count",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/media", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMedia setSince (String since) {
      this.setParam("since", since);
      return this;
    }

    public APIRequestGetMedia setUntil (String until) {
      this.setParam("until", until);
      return this;
    }

    public APIRequestGetMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMedia requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetMedia requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetMedia requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetMedia requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetMedia requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetMedia requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetMedia requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetMedia requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetMedia requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetMedia requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetMedia requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetMedia requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetMedia requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetMedia requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetMedia requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetMedia requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetMedia requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetMedia requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetMedia requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetMedia requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetMedia requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetMedia requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetMedia requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetMedia requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetMedia requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetMedia requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetMedia requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetMedia requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetMedia requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetMedia requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetMedia requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetMedia requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestCreateMedia extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "caption",
      "children",
      "cover_url",
      "image_url",
      "is_carousel_item",
      "location_id",
      "media_type",
      "product_tags",
      "share_to_feed",
      "thumb_offset",
      "user_tags",
      "video_url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGMedia parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMedia>() {
           public IGMedia apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMedia.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMedia(String nodeId, APIContext context) {
      super(context, nodeId, "/media", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMedia setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMedia setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMedia setCaption (String caption) {
      this.setParam("caption", caption);
      return this;
    }

    public APIRequestCreateMedia setChildren (List<String> children) {
      this.setParam("children", children);
      return this;
    }
    public APIRequestCreateMedia setChildren (String children) {
      this.setParam("children", children);
      return this;
    }

    public APIRequestCreateMedia setCoverUrl (String coverUrl) {
      this.setParam("cover_url", coverUrl);
      return this;
    }

    public APIRequestCreateMedia setImageUrl (String imageUrl) {
      this.setParam("image_url", imageUrl);
      return this;
    }

    public APIRequestCreateMedia setIsCarouselItem (Boolean isCarouselItem) {
      this.setParam("is_carousel_item", isCarouselItem);
      return this;
    }
    public APIRequestCreateMedia setIsCarouselItem (String isCarouselItem) {
      this.setParam("is_carousel_item", isCarouselItem);
      return this;
    }

    public APIRequestCreateMedia setLocationId (String locationId) {
      this.setParam("location_id", locationId);
      return this;
    }

    public APIRequestCreateMedia setMediaType (String mediaType) {
      this.setParam("media_type", mediaType);
      return this;
    }

    public APIRequestCreateMedia setProductTags (List<Map<String, String>> productTags) {
      this.setParam("product_tags", productTags);
      return this;
    }
    public APIRequestCreateMedia setProductTags (String productTags) {
      this.setParam("product_tags", productTags);
      return this;
    }

    public APIRequestCreateMedia setShareToFeed (Boolean shareToFeed) {
      this.setParam("share_to_feed", shareToFeed);
      return this;
    }
    public APIRequestCreateMedia setShareToFeed (String shareToFeed) {
      this.setParam("share_to_feed", shareToFeed);
      return this;
    }

    public APIRequestCreateMedia setThumbOffset (String thumbOffset) {
      this.setParam("thumb_offset", thumbOffset);
      return this;
    }

    public APIRequestCreateMedia setUserTags (List<Map<String, String>> userTags) {
      this.setParam("user_tags", userTags);
      return this;
    }
    public APIRequestCreateMedia setUserTags (String userTags) {
      this.setParam("user_tags", userTags);
      return this;
    }

    public APIRequestCreateMedia setVideoUrl (String videoUrl) {
      this.setParam("video_url", videoUrl);
      return this;
    }

    public APIRequestCreateMedia requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMedia requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMedia requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMedia requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMedia requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMedia requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMediaPublish extends APIRequest<IGMedia> {

    IGMedia lastResponse = null;
    @Override
    public IGMedia getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "creation_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public IGMedia parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGMedia execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGMedia execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGMedia> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGMedia> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGMedia>() {
           public IGMedia apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMediaPublish.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMediaPublish(String nodeId, APIContext context) {
      super(context, nodeId, "/media_publish", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMediaPublish setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMediaPublish setCreationId (Long creationId) {
      this.setParam("creation_id", creationId);
      return this;
    }
    public APIRequestCreateMediaPublish setCreationId (String creationId) {
      this.setParam("creation_id", creationId);
      return this;
    }

    public APIRequestCreateMediaPublish requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMediaPublish requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMediaPublish requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMediaPublish requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMention extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "comment_id",
      "media_id",
      "message",
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
               return APIRequestCreateMention.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateMention(String nodeId, APIContext context) {
      super(context, nodeId, "/mentions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMention setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMention setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMention setCommentId (String commentId) {
      this.setParam("comment_id", commentId);
      return this;
    }

    public APIRequestCreateMention setMediaId (String mediaId) {
      this.setParam("media_id", mediaId);
      return this;
    }

    public APIRequestCreateMention setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateMention requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMention requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMention requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMention requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMention requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMention requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetNotificationMessageTokens extends APIRequest<UserPageOneTimeOptInTokenSettings> {

    APINodeList<UserPageOneTimeOptInTokenSettings> lastResponse = null;
    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_timestamp",
      "next_eligible_time",
      "notification_messages_frequency",
      "notification_messages_reoptin",
      "notification_messages_timezone",
      "notification_messages_token",
      "recipient_id",
      "token_expiry_timestamp",
      "topic_title",
      "user_token_status",
      "id",
    };

    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> parseResponse(String response, String header) throws APIException {
      return UserPageOneTimeOptInTokenSettings.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<UserPageOneTimeOptInTokenSettings> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<UserPageOneTimeOptInTokenSettings>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<UserPageOneTimeOptInTokenSettings>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<UserPageOneTimeOptInTokenSettings>>() {
           public APINodeList<UserPageOneTimeOptInTokenSettings> apply(ResponseWrapper result) {
             try {
               return APIRequestGetNotificationMessageTokens.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetNotificationMessageTokens(String nodeId, APIContext context) {
      super(context, nodeId, "/notification_message_tokens", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetNotificationMessageTokens setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetNotificationMessageTokens requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetNotificationMessageTokens requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetNotificationMessageTokens requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetNotificationMessageTokens requestCreationTimestampField () {
      return this.requestCreationTimestampField(true);
    }
    public APIRequestGetNotificationMessageTokens requestCreationTimestampField (boolean value) {
      this.requestField("creation_timestamp", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNextEligibleTimeField () {
      return this.requestNextEligibleTimeField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNextEligibleTimeField (boolean value) {
      this.requestField("next_eligible_time", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesFrequencyField () {
      return this.requestNotificationMessagesFrequencyField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesFrequencyField (boolean value) {
      this.requestField("notification_messages_frequency", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesReoptinField () {
      return this.requestNotificationMessagesReoptinField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesReoptinField (boolean value) {
      this.requestField("notification_messages_reoptin", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTimezoneField () {
      return this.requestNotificationMessagesTimezoneField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTimezoneField (boolean value) {
      this.requestField("notification_messages_timezone", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTokenField () {
      return this.requestNotificationMessagesTokenField(true);
    }
    public APIRequestGetNotificationMessageTokens requestNotificationMessagesTokenField (boolean value) {
      this.requestField("notification_messages_token", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestRecipientIdField () {
      return this.requestRecipientIdField(true);
    }
    public APIRequestGetNotificationMessageTokens requestRecipientIdField (boolean value) {
      this.requestField("recipient_id", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestTokenExpiryTimestampField () {
      return this.requestTokenExpiryTimestampField(true);
    }
    public APIRequestGetNotificationMessageTokens requestTokenExpiryTimestampField (boolean value) {
      this.requestField("token_expiry_timestamp", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestTopicTitleField () {
      return this.requestTopicTitleField(true);
    }
    public APIRequestGetNotificationMessageTokens requestTopicTitleField (boolean value) {
      this.requestField("topic_title", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestUserTokenStatusField () {
      return this.requestUserTokenStatusField(true);
    }
    public APIRequestGetNotificationMessageTokens requestUserTokenStatusField (boolean value) {
      this.requestField("user_token_status", value);
      return this;
    }
    public APIRequestGetNotificationMessageTokens requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetNotificationMessageTokens requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetProductAppeal extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "product_id",
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
               return APIRequestGetProductAppeal.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetProductAppeal(String nodeId, APIContext context) {
      super(context, nodeId, "/product_appeal", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductAppeal setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductAppeal setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductAppeal setProductId (String productId) {
      this.setParam("product_id", productId);
      return this;
    }

    public APIRequestGetProductAppeal requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductAppeal requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductAppeal requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductAppeal requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductAppeal requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductAppeal requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateProductAppeal extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "appeal_reason",
      "product_id",
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
               return APIRequestCreateProductAppeal.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateProductAppeal(String nodeId, APIContext context) {
      super(context, nodeId, "/product_appeal", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductAppeal setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductAppeal setAppealReason (String appealReason) {
      this.setParam("appeal_reason", appealReason);
      return this;
    }

    public APIRequestCreateProductAppeal setProductId (String productId) {
      this.setParam("product_id", productId);
      return this;
    }

    public APIRequestCreateProductAppeal requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductAppeal requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductAppeal requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductAppeal requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetRecentlySearchedHashtags extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestGetRecentlySearchedHashtags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetRecentlySearchedHashtags(String nodeId, APIContext context) {
      super(context, nodeId, "/recently_searched_hashtags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetRecentlySearchedHashtags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetRecentlySearchedHashtags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetRecentlySearchedHashtags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetStories extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "caption",
      "comments_count",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetStories.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetStories(String nodeId, APIContext context) {
      super(context, nodeId, "/stories", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetStories setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetStories setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetStories requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetStories requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStories requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetStories requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStories requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetStories requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetStories requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetStories requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetStories requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetStories requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetStories requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetStories requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetStories requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetStories requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetStories requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetStories requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetStories requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetStories requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetStories requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetStories requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetStories requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetStories requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetStories requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetStories requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetStories requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetStories requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetStories requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetStories requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetStories requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetStories requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetStories requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetStories requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetStories requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetStories requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetStories requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetStories requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetStories requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetStories requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGetTags extends APIRequest<IGMedia> {

    APINodeList<IGMedia> lastResponse = null;
    @Override
    public APINodeList<IGMedia> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "caption",
      "comments_count",
      "id",
      "ig_id",
      "is_comment_enabled",
      "is_shared_to_feed",
      "like_count",
      "media_product_type",
      "media_type",
      "media_url",
      "owner",
      "permalink",
      "shortcode",
      "thumbnail_url",
      "timestamp",
      "username",
    };

    @Override
    public APINodeList<IGMedia> parseResponse(String response, String header) throws APIException {
      return IGMedia.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<IGMedia> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<IGMedia> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<IGMedia>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<IGMedia>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<IGMedia>>() {
           public APINodeList<IGMedia> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTags.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTags(String nodeId, APIContext context) {
      super(context, nodeId, "/tags", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTags setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTags setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTags requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTags requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTags requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTags requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTags requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTags requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTags requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGetTags requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGetTags requestCommentsCountField () {
      return this.requestCommentsCountField(true);
    }
    public APIRequestGetTags requestCommentsCountField (boolean value) {
      this.requestField("comments_count", value);
      return this;
    }
    public APIRequestGetTags requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTags requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTags requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGetTags requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGetTags requestIsCommentEnabledField () {
      return this.requestIsCommentEnabledField(true);
    }
    public APIRequestGetTags requestIsCommentEnabledField (boolean value) {
      this.requestField("is_comment_enabled", value);
      return this;
    }
    public APIRequestGetTags requestIsSharedToFeedField () {
      return this.requestIsSharedToFeedField(true);
    }
    public APIRequestGetTags requestIsSharedToFeedField (boolean value) {
      this.requestField("is_shared_to_feed", value);
      return this;
    }
    public APIRequestGetTags requestLikeCountField () {
      return this.requestLikeCountField(true);
    }
    public APIRequestGetTags requestLikeCountField (boolean value) {
      this.requestField("like_count", value);
      return this;
    }
    public APIRequestGetTags requestMediaProductTypeField () {
      return this.requestMediaProductTypeField(true);
    }
    public APIRequestGetTags requestMediaProductTypeField (boolean value) {
      this.requestField("media_product_type", value);
      return this;
    }
    public APIRequestGetTags requestMediaTypeField () {
      return this.requestMediaTypeField(true);
    }
    public APIRequestGetTags requestMediaTypeField (boolean value) {
      this.requestField("media_type", value);
      return this;
    }
    public APIRequestGetTags requestMediaUrlField () {
      return this.requestMediaUrlField(true);
    }
    public APIRequestGetTags requestMediaUrlField (boolean value) {
      this.requestField("media_url", value);
      return this;
    }
    public APIRequestGetTags requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetTags requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetTags requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGetTags requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
    public APIRequestGetTags requestShortcodeField () {
      return this.requestShortcodeField(true);
    }
    public APIRequestGetTags requestShortcodeField (boolean value) {
      this.requestField("shortcode", value);
      return this;
    }
    public APIRequestGetTags requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetTags requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetTags requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGetTags requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGetTags requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetTags requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<IGUser> {

    IGUser lastResponse = null;
    @Override
    public IGUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adgroup_id",
    };

    public static final String[] FIELDS = {
      "biography",
      "business_discovery",
      "followers_count",
      "follows_count",
      "id",
      "ig_id",
      "media_count",
      "mentioned_comment",
      "mentioned_media",
      "name",
      "owner_business",
      "profile_picture_url",
      "shopping_product_tag_eligibility",
      "shopping_review_status",
      "username",
      "website",
    };

    @Override
    public IGUser parseResponse(String response, String header) throws APIException {
      return IGUser.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IGUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IGUser execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IGUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IGUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IGUser>() {
           public IGUser apply(ResponseWrapper result) {
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


    public APIRequestGet setAdgroupId (String adgroupId) {
      this.setParam("adgroup_id", adgroupId);
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

    public APIRequestGet requestBiographyField () {
      return this.requestBiographyField(true);
    }
    public APIRequestGet requestBiographyField (boolean value) {
      this.requestField("biography", value);
      return this;
    }
    public APIRequestGet requestBusinessDiscoveryField () {
      return this.requestBusinessDiscoveryField(true);
    }
    public APIRequestGet requestBusinessDiscoveryField (boolean value) {
      this.requestField("business_discovery", value);
      return this;
    }
    public APIRequestGet requestFollowersCountField () {
      return this.requestFollowersCountField(true);
    }
    public APIRequestGet requestFollowersCountField (boolean value) {
      this.requestField("followers_count", value);
      return this;
    }
    public APIRequestGet requestFollowsCountField () {
      return this.requestFollowsCountField(true);
    }
    public APIRequestGet requestFollowsCountField (boolean value) {
      this.requestField("follows_count", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIgIdField () {
      return this.requestIgIdField(true);
    }
    public APIRequestGet requestIgIdField (boolean value) {
      this.requestField("ig_id", value);
      return this;
    }
    public APIRequestGet requestMediaCountField () {
      return this.requestMediaCountField(true);
    }
    public APIRequestGet requestMediaCountField (boolean value) {
      this.requestField("media_count", value);
      return this;
    }
    public APIRequestGet requestMentionedCommentField () {
      return this.requestMentionedCommentField(true);
    }
    public APIRequestGet requestMentionedCommentField (boolean value) {
      this.requestField("mentioned_comment", value);
      return this;
    }
    public APIRequestGet requestMentionedMediaField () {
      return this.requestMentionedMediaField(true);
    }
    public APIRequestGet requestMentionedMediaField (boolean value) {
      this.requestField("mentioned_media", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestProfilePictureUrlField () {
      return this.requestProfilePictureUrlField(true);
    }
    public APIRequestGet requestProfilePictureUrlField (boolean value) {
      this.requestField("profile_picture_url", value);
      return this;
    }
    public APIRequestGet requestShoppingProductTagEligibilityField () {
      return this.requestShoppingProductTagEligibilityField(true);
    }
    public APIRequestGet requestShoppingProductTagEligibilityField (boolean value) {
      this.requestField("shopping_product_tag_eligibility", value);
      return this;
    }
    public APIRequestGet requestShoppingReviewStatusField () {
      return this.requestShoppingReviewStatusField(true);
    }
    public APIRequestGet requestShoppingReviewStatusField (boolean value) {
      this.requestField("shopping_review_status", value);
      return this;
    }
    public APIRequestGet requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGet requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGet requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGet requestWebsiteField (boolean value) {
      this.requestField("website", value);
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

  public IGUser copyFrom(IGUser instance) {
    this.mBiography = instance.mBiography;
    this.mBusinessDiscovery = instance.mBusinessDiscovery;
    this.mFollowersCount = instance.mFollowersCount;
    this.mFollowsCount = instance.mFollowsCount;
    this.mId = instance.mId;
    this.mIgId = instance.mIgId;
    this.mMediaCount = instance.mMediaCount;
    this.mMentionedComment = instance.mMentionedComment;
    this.mMentionedMedia = instance.mMentionedMedia;
    this.mName = instance.mName;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mProfilePictureUrl = instance.mProfilePictureUrl;
    this.mShoppingProductTagEligibility = instance.mShoppingProductTagEligibility;
    this.mShoppingReviewStatus = instance.mShoppingReviewStatus;
    this.mUsername = instance.mUsername;
    this.mWebsite = instance.mWebsite;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IGUser> getParser() {
    return new APIRequest.ResponseParser<IGUser>() {
      public APINodeList<IGUser> parseResponse(String response, APIContext context, APIRequest<IGUser> request, String header) throws MalformedResponseException {
        return IGUser.parseResponse(response, context, request, header);
      }
    };
  }
}
