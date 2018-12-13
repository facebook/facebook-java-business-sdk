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
public class CreativeDemocracyRun extends APINode {
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("end_date")
  private String mEndDate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("placement")
  private String mPlacement = null;
  @SerializedName("report_data")
  private List<List<Object>> mReportData = null;
  @SerializedName("report_files")
  private List<Object> mReportFiles = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  @SerializedName("status")
  private String mStatus = null;
  protected static Gson gson = null;

  CreativeDemocracyRun() {
  }

  public CreativeDemocracyRun(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CreativeDemocracyRun(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CreativeDemocracyRun fetch() throws APIException{
    CreativeDemocracyRun newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CreativeDemocracyRun fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CreativeDemocracyRun> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CreativeDemocracyRun fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CreativeDemocracyRun> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CreativeDemocracyRun> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CreativeDemocracyRun>)(
      new APIRequest<CreativeDemocracyRun>(context, "", "/", "GET", CreativeDemocracyRun.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CreativeDemocracyRun>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CreativeDemocracyRun.getParser())
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
  public static CreativeDemocracyRun loadJSON(String json, APIContext context, String header) {
    CreativeDemocracyRun creativeDemocracyRun = getGson().fromJson(json, CreativeDemocracyRun.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(creativeDemocracyRun.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    creativeDemocracyRun.context = context;
    creativeDemocracyRun.rawValue = json;
    creativeDemocracyRun.header = header;
    return creativeDemocracyRun;
  }

  public static APINodeList<CreativeDemocracyRun> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CreativeDemocracyRun> creativeDemocracyRuns = new APINodeList<CreativeDemocracyRun>(request, json, header);
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
          creativeDemocracyRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return creativeDemocracyRuns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                creativeDemocracyRuns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            creativeDemocracyRuns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              creativeDemocracyRuns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              creativeDemocracyRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  creativeDemocracyRuns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              creativeDemocracyRuns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return creativeDemocracyRuns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              creativeDemocracyRuns.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return creativeDemocracyRuns;
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
              creativeDemocracyRuns.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return creativeDemocracyRuns;
          }

          // Sixth, check if it's pure JsonObject
          creativeDemocracyRuns.clear();
          creativeDemocracyRuns.add(loadJSON(json, context, header));
          return creativeDemocracyRuns;
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

  public APIRequestGetCampaignId getCampaignId() {
    return new APIRequestGetCampaignId(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCreativeId getCreativeId() {
    return new APIRequestGetCreativeId(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEndDate() {
    return mEndDate;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPlacement() {
    return mPlacement;
  }

  public List<List<Object>> getFieldReportData() {
    return mReportData;
  }

  public List<Object> getFieldReportFiles() {
    return mReportFiles;
  }

  public String getFieldStartDate() {
    return mStartDate;
  }

  public String getFieldStatus() {
    return mStatus;
  }



  public static class APIRequestGetCampaignId extends APIRequest<Campaign> {

    APINodeList<Campaign> lastResponse = null;
    @Override
    public APINodeList<Campaign> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "bid_strategy",
      "boosted_object_id",
      "brand_lift_studies",
      "budget_rebalance_flag",
      "budget_remaining",
      "buying_type",
      "can_create_brand_lift_study",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "daily_budget",
      "effective_status",
      "id",
      "last_budget_toggling_time",
      "lifetime_budget",
      "metrics_metadata",
      "name",
      "objective",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "source_campaign",
      "source_campaign_id",
      "spend_cap",
      "start_time",
      "status",
      "stop_time",
      "topline_id",
      "updated_time",
    };

    @Override
    public APINodeList<Campaign> parseResponse(String response, String header) throws APIException {
      return Campaign.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Campaign> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Campaign> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Campaign>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Campaign>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Campaign>>() {
           public APINodeList<Campaign> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCampaignId.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCampaignId(String nodeId, APIContext context) {
      super(context, nodeId, "/campaign_id", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCampaignId setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCampaignId setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCampaignId requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCampaignId requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaignId requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCampaignId requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaignId requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCampaignId requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCampaignId requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCampaignId requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCampaignId requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCampaignId requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCampaignId requestBidStrategyField () {
      return this.requestBidStrategyField(true);
    }
    public APIRequestGetCampaignId requestBidStrategyField (boolean value) {
      this.requestField("bid_strategy", value);
      return this;
    }
    public APIRequestGetCampaignId requestBoostedObjectIdField () {
      return this.requestBoostedObjectIdField(true);
    }
    public APIRequestGetCampaignId requestBoostedObjectIdField (boolean value) {
      this.requestField("boosted_object_id", value);
      return this;
    }
    public APIRequestGetCampaignId requestBrandLiftStudiesField () {
      return this.requestBrandLiftStudiesField(true);
    }
    public APIRequestGetCampaignId requestBrandLiftStudiesField (boolean value) {
      this.requestField("brand_lift_studies", value);
      return this;
    }
    public APIRequestGetCampaignId requestBudgetRebalanceFlagField () {
      return this.requestBudgetRebalanceFlagField(true);
    }
    public APIRequestGetCampaignId requestBudgetRebalanceFlagField (boolean value) {
      this.requestField("budget_rebalance_flag", value);
      return this;
    }
    public APIRequestGetCampaignId requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetCampaignId requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetCampaignId requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetCampaignId requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGetCampaignId requestCanCreateBrandLiftStudyField () {
      return this.requestCanCreateBrandLiftStudyField(true);
    }
    public APIRequestGetCampaignId requestCanCreateBrandLiftStudyField (boolean value) {
      this.requestField("can_create_brand_lift_study", value);
      return this;
    }
    public APIRequestGetCampaignId requestCanUseSpendCapField () {
      return this.requestCanUseSpendCapField(true);
    }
    public APIRequestGetCampaignId requestCanUseSpendCapField (boolean value) {
      this.requestField("can_use_spend_cap", value);
      return this;
    }
    public APIRequestGetCampaignId requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetCampaignId requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetCampaignId requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetCampaignId requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetCampaignId requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetCampaignId requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetCampaignId requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetCampaignId requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetCampaignId requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCampaignId requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCampaignId requestLastBudgetTogglingTimeField () {
      return this.requestLastBudgetTogglingTimeField(true);
    }
    public APIRequestGetCampaignId requestLastBudgetTogglingTimeField (boolean value) {
      this.requestField("last_budget_toggling_time", value);
      return this;
    }
    public APIRequestGetCampaignId requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetCampaignId requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetCampaignId requestMetricsMetadataField () {
      return this.requestMetricsMetadataField(true);
    }
    public APIRequestGetCampaignId requestMetricsMetadataField (boolean value) {
      this.requestField("metrics_metadata", value);
      return this;
    }
    public APIRequestGetCampaignId requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCampaignId requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCampaignId requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGetCampaignId requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGetCampaignId requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetCampaignId requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetCampaignId requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetCampaignId requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGetCampaignId requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetCampaignId requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetCampaignId requestSourceCampaignField () {
      return this.requestSourceCampaignField(true);
    }
    public APIRequestGetCampaignId requestSourceCampaignField (boolean value) {
      this.requestField("source_campaign", value);
      return this;
    }
    public APIRequestGetCampaignId requestSourceCampaignIdField () {
      return this.requestSourceCampaignIdField(true);
    }
    public APIRequestGetCampaignId requestSourceCampaignIdField (boolean value) {
      this.requestField("source_campaign_id", value);
      return this;
    }
    public APIRequestGetCampaignId requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetCampaignId requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetCampaignId requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetCampaignId requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetCampaignId requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCampaignId requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCampaignId requestStopTimeField () {
      return this.requestStopTimeField(true);
    }
    public APIRequestGetCampaignId requestStopTimeField (boolean value) {
      this.requestField("stop_time", value);
      return this;
    }
    public APIRequestGetCampaignId requestToplineIdField () {
      return this.requestToplineIdField(true);
    }
    public APIRequestGetCampaignId requestToplineIdField (boolean value) {
      this.requestField("topline_id", value);
      return this;
    }
    public APIRequestGetCampaignId requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetCampaignId requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetCreativeId extends APIRequest<AdCreative> {

    APINodeList<AdCreative> lastResponse = null;
    @Override
    public APINodeList<AdCreative> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "actor_id",
      "adlabels",
      "applink_treatment",
      "asset_feed_spec",
      "authorization_category",
      "auto_update",
      "body",
      "branded_content_sponsor_page_id",
      "bundle_folder_id",
      "call_to_action_type",
      "categorization_criteria",
      "category_media_source",
      "destination_set_id",
      "dynamic_ad_voice",
      "effective_authorization_category",
      "effective_instagram_story_id",
      "effective_object_story_id",
      "enable_direct_install",
      "enable_launch_instant_app",
      "id",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "instagram_story_id",
      "link_deep_link_url",
      "link_og_id",
      "link_url",
      "messenger_sponsored_message",
      "name",
      "object_id",
      "object_store_url",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "object_url",
      "place_page_set_id",
      "platform_customizations",
      "playable_asset_id",
      "portrait_customizations",
      "product_set_id",
      "recommender_settings",
      "status",
      "template_url",
      "template_url_spec",
      "thumbnail_url",
      "title",
      "url_tags",
      "use_page_actor_override",
      "video_id",
    };

    @Override
    public APINodeList<AdCreative> parseResponse(String response, String header) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdCreative> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCreative> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdCreative>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdCreative>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdCreative>>() {
           public APINodeList<AdCreative> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCreativeId.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCreativeId(String nodeId, APIContext context) {
      super(context, nodeId, "/creative_id", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCreativeId setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCreativeId setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCreativeId requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCreativeId requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCreativeId requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCreativeId requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCreativeId requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCreativeId requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCreativeId requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCreativeId requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetCreativeId requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCreativeId requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCreativeId requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetCreativeId requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }
    public APIRequestGetCreativeId requestAssetFeedSpecField () {
      return this.requestAssetFeedSpecField(true);
    }
    public APIRequestGetCreativeId requestAssetFeedSpecField (boolean value) {
      this.requestField("asset_feed_spec", value);
      return this;
    }
    public APIRequestGetCreativeId requestAuthorizationCategoryField () {
      return this.requestAuthorizationCategoryField(true);
    }
    public APIRequestGetCreativeId requestAuthorizationCategoryField (boolean value) {
      this.requestField("authorization_category", value);
      return this;
    }
    public APIRequestGetCreativeId requestAutoUpdateField () {
      return this.requestAutoUpdateField(true);
    }
    public APIRequestGetCreativeId requestAutoUpdateField (boolean value) {
      this.requestField("auto_update", value);
      return this;
    }
    public APIRequestGetCreativeId requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetCreativeId requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetCreativeId requestBrandedContentSponsorPageIdField () {
      return this.requestBrandedContentSponsorPageIdField(true);
    }
    public APIRequestGetCreativeId requestBrandedContentSponsorPageIdField (boolean value) {
      this.requestField("branded_content_sponsor_page_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestBundleFolderIdField () {
      return this.requestBundleFolderIdField(true);
    }
    public APIRequestGetCreativeId requestBundleFolderIdField (boolean value) {
      this.requestField("bundle_folder_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGetCreativeId requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
      return this;
    }
    public APIRequestGetCreativeId requestCategorizationCriteriaField () {
      return this.requestCategorizationCriteriaField(true);
    }
    public APIRequestGetCreativeId requestCategorizationCriteriaField (boolean value) {
      this.requestField("categorization_criteria", value);
      return this;
    }
    public APIRequestGetCreativeId requestCategoryMediaSourceField () {
      return this.requestCategoryMediaSourceField(true);
    }
    public APIRequestGetCreativeId requestCategoryMediaSourceField (boolean value) {
      this.requestField("category_media_source", value);
      return this;
    }
    public APIRequestGetCreativeId requestDestinationSetIdField () {
      return this.requestDestinationSetIdField(true);
    }
    public APIRequestGetCreativeId requestDestinationSetIdField (boolean value) {
      this.requestField("destination_set_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestDynamicAdVoiceField () {
      return this.requestDynamicAdVoiceField(true);
    }
    public APIRequestGetCreativeId requestDynamicAdVoiceField (boolean value) {
      this.requestField("dynamic_ad_voice", value);
      return this;
    }
    public APIRequestGetCreativeId requestEffectiveAuthorizationCategoryField () {
      return this.requestEffectiveAuthorizationCategoryField(true);
    }
    public APIRequestGetCreativeId requestEffectiveAuthorizationCategoryField (boolean value) {
      this.requestField("effective_authorization_category", value);
      return this;
    }
    public APIRequestGetCreativeId requestEffectiveInstagramStoryIdField () {
      return this.requestEffectiveInstagramStoryIdField(true);
    }
    public APIRequestGetCreativeId requestEffectiveInstagramStoryIdField (boolean value) {
      this.requestField("effective_instagram_story_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestEffectiveObjectStoryIdField () {
      return this.requestEffectiveObjectStoryIdField(true);
    }
    public APIRequestGetCreativeId requestEffectiveObjectStoryIdField (boolean value) {
      this.requestField("effective_object_story_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestEnableDirectInstallField () {
      return this.requestEnableDirectInstallField(true);
    }
    public APIRequestGetCreativeId requestEnableDirectInstallField (boolean value) {
      this.requestField("enable_direct_install", value);
      return this;
    }
    public APIRequestGetCreativeId requestEnableLaunchInstantAppField () {
      return this.requestEnableLaunchInstantAppField(true);
    }
    public APIRequestGetCreativeId requestEnableLaunchInstantAppField (boolean value) {
      this.requestField("enable_launch_instant_app", value);
      return this;
    }
    public APIRequestGetCreativeId requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCreativeId requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCreativeId requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGetCreativeId requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGetCreativeId requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGetCreativeId requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGetCreativeId requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetCreativeId requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetCreativeId requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetCreativeId requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestInstagramPermalinkUrlField () {
      return this.requestInstagramPermalinkUrlField(true);
    }
    public APIRequestGetCreativeId requestInstagramPermalinkUrlField (boolean value) {
      this.requestField("instagram_permalink_url", value);
      return this;
    }
    public APIRequestGetCreativeId requestInstagramStoryIdField () {
      return this.requestInstagramStoryIdField(true);
    }
    public APIRequestGetCreativeId requestInstagramStoryIdField (boolean value) {
      this.requestField("instagram_story_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestLinkDeepLinkUrlField () {
      return this.requestLinkDeepLinkUrlField(true);
    }
    public APIRequestGetCreativeId requestLinkDeepLinkUrlField (boolean value) {
      this.requestField("link_deep_link_url", value);
      return this;
    }
    public APIRequestGetCreativeId requestLinkOgIdField () {
      return this.requestLinkOgIdField(true);
    }
    public APIRequestGetCreativeId requestLinkOgIdField (boolean value) {
      this.requestField("link_og_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGetCreativeId requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
      return this;
    }
    public APIRequestGetCreativeId requestMessengerSponsoredMessageField () {
      return this.requestMessengerSponsoredMessageField(true);
    }
    public APIRequestGetCreativeId requestMessengerSponsoredMessageField (boolean value) {
      this.requestField("messenger_sponsored_message", value);
      return this;
    }
    public APIRequestGetCreativeId requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCreativeId requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCreativeId requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetCreativeId requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestObjectStoreUrlField () {
      return this.requestObjectStoreUrlField(true);
    }
    public APIRequestGetCreativeId requestObjectStoreUrlField (boolean value) {
      this.requestField("object_store_url", value);
      return this;
    }
    public APIRequestGetCreativeId requestObjectStoryIdField () {
      return this.requestObjectStoryIdField(true);
    }
    public APIRequestGetCreativeId requestObjectStoryIdField (boolean value) {
      this.requestField("object_story_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestObjectStorySpecField () {
      return this.requestObjectStorySpecField(true);
    }
    public APIRequestGetCreativeId requestObjectStorySpecField (boolean value) {
      this.requestField("object_story_spec", value);
      return this;
    }
    public APIRequestGetCreativeId requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGetCreativeId requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGetCreativeId requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetCreativeId requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGetCreativeId requestPlacePageSetIdField () {
      return this.requestPlacePageSetIdField(true);
    }
    public APIRequestGetCreativeId requestPlacePageSetIdField (boolean value) {
      this.requestField("place_page_set_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestPlatformCustomizationsField () {
      return this.requestPlatformCustomizationsField(true);
    }
    public APIRequestGetCreativeId requestPlatformCustomizationsField (boolean value) {
      this.requestField("platform_customizations", value);
      return this;
    }
    public APIRequestGetCreativeId requestPlayableAssetIdField () {
      return this.requestPlayableAssetIdField(true);
    }
    public APIRequestGetCreativeId requestPlayableAssetIdField (boolean value) {
      this.requestField("playable_asset_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestPortraitCustomizationsField () {
      return this.requestPortraitCustomizationsField(true);
    }
    public APIRequestGetCreativeId requestPortraitCustomizationsField (boolean value) {
      this.requestField("portrait_customizations", value);
      return this;
    }
    public APIRequestGetCreativeId requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetCreativeId requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetCreativeId requestRecommenderSettingsField () {
      return this.requestRecommenderSettingsField(true);
    }
    public APIRequestGetCreativeId requestRecommenderSettingsField (boolean value) {
      this.requestField("recommender_settings", value);
      return this;
    }
    public APIRequestGetCreativeId requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCreativeId requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCreativeId requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetCreativeId requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGetCreativeId requestTemplateUrlSpecField () {
      return this.requestTemplateUrlSpecField(true);
    }
    public APIRequestGetCreativeId requestTemplateUrlSpecField (boolean value) {
      this.requestField("template_url_spec", value);
      return this;
    }
    public APIRequestGetCreativeId requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetCreativeId requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetCreativeId requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetCreativeId requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetCreativeId requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGetCreativeId requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGetCreativeId requestUsePageActorOverrideField () {
      return this.requestUsePageActorOverrideField(true);
    }
    public APIRequestGetCreativeId requestUsePageActorOverrideField (boolean value) {
      this.requestField("use_page_actor_override", value);
      return this;
    }
    public APIRequestGetCreativeId requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGetCreativeId requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<CreativeDemocracyRun> {

    CreativeDemocracyRun lastResponse = null;
    @Override
    public CreativeDemocracyRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "description",
      "end_date",
      "id",
      "name",
      "placement",
      "report_data",
      "report_files",
      "start_date",
      "status",
    };

    @Override
    public CreativeDemocracyRun parseResponse(String response, String header) throws APIException {
      return CreativeDemocracyRun.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CreativeDemocracyRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CreativeDemocracyRun execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CreativeDemocracyRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CreativeDemocracyRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CreativeDemocracyRun>() {
           public CreativeDemocracyRun apply(ResponseWrapper result) {
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

    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEndDateField () {
      return this.requestEndDateField(true);
    }
    public APIRequestGet requestEndDateField (boolean value) {
      this.requestField("end_date", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPlacementField () {
      return this.requestPlacementField(true);
    }
    public APIRequestGet requestPlacementField (boolean value) {
      this.requestField("placement", value);
      return this;
    }
    public APIRequestGet requestReportDataField () {
      return this.requestReportDataField(true);
    }
    public APIRequestGet requestReportDataField (boolean value) {
      this.requestField("report_data", value);
      return this;
    }
    public APIRequestGet requestReportFilesField () {
      return this.requestReportFilesField(true);
    }
    public APIRequestGet requestReportFilesField (boolean value) {
      this.requestField("report_files", value);
      return this;
    }
    public APIRequestGet requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGet requestStartDateField (boolean value) {
      this.requestField("start_date", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<CreativeDemocracyRun> {

    CreativeDemocracyRun lastResponse = null;
    @Override
    public CreativeDemocracyRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "description",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public CreativeDemocracyRun parseResponse(String response, String header) throws APIException {
      return CreativeDemocracyRun.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CreativeDemocracyRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CreativeDemocracyRun execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CreativeDemocracyRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CreativeDemocracyRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CreativeDemocracyRun>() {
           public CreativeDemocracyRun apply(ResponseWrapper result) {
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


    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

  public static enum EnumPlacement {
      @SerializedName("AUDIENCE_NETWORK_INSTREAM_VIDEO")
      VALUE_AUDIENCE_NETWORK_INSTREAM_VIDEO("AUDIENCE_NETWORK_INSTREAM_VIDEO"),
      @SerializedName("AUDIENCE_NETWORK_INSTREAM_VIDEO_MOBILE")
      VALUE_AUDIENCE_NETWORK_INSTREAM_VIDEO_MOBILE("AUDIENCE_NETWORK_INSTREAM_VIDEO_MOBILE"),
      @SerializedName("AUDIENCE_NETWORK_OUTSTREAM_VIDEO")
      VALUE_AUDIENCE_NETWORK_OUTSTREAM_VIDEO("AUDIENCE_NETWORK_OUTSTREAM_VIDEO"),
      @SerializedName("AUDIENCE_NETWORK_REWARDED_VIDEO")
      VALUE_AUDIENCE_NETWORK_REWARDED_VIDEO("AUDIENCE_NETWORK_REWARDED_VIDEO"),
      @SerializedName("DESKTOP_FEED_STANDARD")
      VALUE_DESKTOP_FEED_STANDARD("DESKTOP_FEED_STANDARD"),
      @SerializedName("FACEBOOK_STORY_MOBILE")
      VALUE_FACEBOOK_STORY_MOBILE("FACEBOOK_STORY_MOBILE"),
      @SerializedName("INSTAGRAM_STANDARD")
      VALUE_INSTAGRAM_STANDARD("INSTAGRAM_STANDARD"),
      @SerializedName("INSTAGRAM_STORY")
      VALUE_INSTAGRAM_STORY("INSTAGRAM_STORY"),
      @SerializedName("INSTANT_ARTICLE_STANDARD")
      VALUE_INSTANT_ARTICLE_STANDARD("INSTANT_ARTICLE_STANDARD"),
      @SerializedName("INSTREAM_VIDEO_DESKTOP")
      VALUE_INSTREAM_VIDEO_DESKTOP("INSTREAM_VIDEO_DESKTOP"),
      @SerializedName("INSTREAM_VIDEO_MOBILE")
      VALUE_INSTREAM_VIDEO_MOBILE("INSTREAM_VIDEO_MOBILE"),
      @SerializedName("MARKETPLACE_MOBILE")
      VALUE_MARKETPLACE_MOBILE("MARKETPLACE_MOBILE"),
      @SerializedName("MESSENGER_MOBILE_INBOX_MEDIA")
      VALUE_MESSENGER_MOBILE_INBOX_MEDIA("MESSENGER_MOBILE_INBOX_MEDIA"),
      @SerializedName("MOBILE_BANNER")
      VALUE_MOBILE_BANNER("MOBILE_BANNER"),
      @SerializedName("MOBILE_FEED_BASIC")
      VALUE_MOBILE_FEED_BASIC("MOBILE_FEED_BASIC"),
      @SerializedName("MOBILE_FEED_STANDARD")
      VALUE_MOBILE_FEED_STANDARD("MOBILE_FEED_STANDARD"),
      @SerializedName("MOBILE_FULLWIDTH")
      VALUE_MOBILE_FULLWIDTH("MOBILE_FULLWIDTH"),
      @SerializedName("MOBILE_INTERSTITIAL")
      VALUE_MOBILE_INTERSTITIAL("MOBILE_INTERSTITIAL"),
      @SerializedName("MOBILE_MEDIUM_RECTANGLE")
      VALUE_MOBILE_MEDIUM_RECTANGLE("MOBILE_MEDIUM_RECTANGLE"),
      @SerializedName("MOBILE_NATIVE")
      VALUE_MOBILE_NATIVE("MOBILE_NATIVE"),
      @SerializedName("RIGHT_COLUMN_STANDARD")
      VALUE_RIGHT_COLUMN_STANDARD("RIGHT_COLUMN_STANDARD"),
      @SerializedName("SUGGESTED_VIDEO_DESKTOP")
      VALUE_SUGGESTED_VIDEO_DESKTOP("SUGGESTED_VIDEO_DESKTOP"),
      @SerializedName("SUGGESTED_VIDEO_MOBILE")
      VALUE_SUGGESTED_VIDEO_MOBILE("SUGGESTED_VIDEO_MOBILE"),
      @SerializedName("WATCH_FEED_MOBILE")
      VALUE_WATCH_FEED_MOBILE("WATCH_FEED_MOBILE"),
      NULL(null);

      private String value;

      private EnumPlacement(String value) {
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

  public CreativeDemocracyRun copyFrom(CreativeDemocracyRun instance) {
    this.mDescription = instance.mDescription;
    this.mEndDate = instance.mEndDate;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPlacement = instance.mPlacement;
    this.mReportData = instance.mReportData;
    this.mReportFiles = instance.mReportFiles;
    this.mStartDate = instance.mStartDate;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CreativeDemocracyRun> getParser() {
    return new APIRequest.ResponseParser<CreativeDemocracyRun>() {
      public APINodeList<CreativeDemocracyRun> parseResponse(String response, APIContext context, APIRequest<CreativeDemocracyRun> request, String header) throws MalformedResponseException {
        return CreativeDemocracyRun.parseResponse(response, context, request, header);
      }
    };
  }
}
