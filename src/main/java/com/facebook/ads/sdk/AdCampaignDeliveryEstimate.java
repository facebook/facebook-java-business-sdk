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
public class AdCampaignDeliveryEstimate extends APINode {
  @SerializedName("bid_estimate")
  private Object mBidEstimate = null;
  @SerializedName("daily_outcomes_curve")
  private List<OutcomePredictionPoint> mDailyOutcomesCurve = null;
  @SerializedName("estimate_dau")
  private Long mEstimateDau = null;
  @SerializedName("estimate_mau")
  private Long mEstimateMau = null;
  @SerializedName("estimate_ready")
  private Boolean mEstimateReady = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdCampaignDeliveryEstimate() {
  }

  public AdCampaignDeliveryEstimate(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCampaignDeliveryEstimate(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCampaignDeliveryEstimate fetch() throws APIException{
    AdCampaignDeliveryEstimate newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCampaignDeliveryEstimate fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCampaignDeliveryEstimate> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCampaignDeliveryEstimate fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCampaignDeliveryEstimate> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCampaignDeliveryEstimate> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCampaignDeliveryEstimate>)(
      new APIRequest<AdCampaignDeliveryEstimate>(context, "", "/", "GET", AdCampaignDeliveryEstimate.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCampaignDeliveryEstimate>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCampaignDeliveryEstimate.getParser())
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
  public static AdCampaignDeliveryEstimate loadJSON(String json, APIContext context) {
    AdCampaignDeliveryEstimate adCampaignDeliveryEstimate = getGson().fromJson(json, AdCampaignDeliveryEstimate.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignDeliveryEstimate.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCampaignDeliveryEstimate.context = context;
    adCampaignDeliveryEstimate.rawValue = json;
    return adCampaignDeliveryEstimate;
  }

  public static APINodeList<AdCampaignDeliveryEstimate> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCampaignDeliveryEstimate> adCampaignDeliveryEstimates = new APINodeList<AdCampaignDeliveryEstimate>(request, json);
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
          adCampaignDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCampaignDeliveryEstimates;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignDeliveryEstimates.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignDeliveryEstimates.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignDeliveryEstimates.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignDeliveryEstimates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCampaignDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignDeliveryEstimates.add(loadJSON(obj.toString(), context));
            }
          }
          return adCampaignDeliveryEstimates;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignDeliveryEstimates.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCampaignDeliveryEstimates;
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
              adCampaignDeliveryEstimates.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignDeliveryEstimates;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignDeliveryEstimates.clear();
          adCampaignDeliveryEstimates.add(loadJSON(json, context));
          return adCampaignDeliveryEstimates;
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


  public Object getFieldBidEstimate() {
    return mBidEstimate;
  }

  public List<OutcomePredictionPoint> getFieldDailyOutcomesCurve() {
    return mDailyOutcomesCurve;
  }

  public Long getFieldEstimateDau() {
    return mEstimateDau;
  }

  public Long getFieldEstimateMau() {
    return mEstimateMau;
  }

  public Boolean getFieldEstimateReady() {
    return mEstimateReady;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCampaignDeliveryEstimate> {

    AdCampaignDeliveryEstimate lastResponse = null;
    @Override
    public AdCampaignDeliveryEstimate getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "bid_estimate",
      "daily_outcomes_curve",
      "estimate_dau",
      "estimate_mau",
      "estimate_ready",
      "id",
    };

    @Override
    public AdCampaignDeliveryEstimate parseResponse(String response) throws APIException {
      return AdCampaignDeliveryEstimate.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCampaignDeliveryEstimate execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCampaignDeliveryEstimate execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCampaignDeliveryEstimate> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCampaignDeliveryEstimate> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCampaignDeliveryEstimate>() {
           public AdCampaignDeliveryEstimate apply(String result) {
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

    public APIRequestGet requestBidEstimateField () {
      return this.requestBidEstimateField(true);
    }
    public APIRequestGet requestBidEstimateField (boolean value) {
      this.requestField("bid_estimate", value);
      return this;
    }
    public APIRequestGet requestDailyOutcomesCurveField () {
      return this.requestDailyOutcomesCurveField(true);
    }
    public APIRequestGet requestDailyOutcomesCurveField (boolean value) {
      this.requestField("daily_outcomes_curve", value);
      return this;
    }
    public APIRequestGet requestEstimateDauField () {
      return this.requestEstimateDauField(true);
    }
    public APIRequestGet requestEstimateDauField (boolean value) {
      this.requestField("estimate_dau", value);
      return this;
    }
    public APIRequestGet requestEstimateMauField () {
      return this.requestEstimateMauField(true);
    }
    public APIRequestGet requestEstimateMauField (boolean value) {
      this.requestField("estimate_mau", value);
      return this;
    }
    public APIRequestGet requestEstimateReadyField () {
      return this.requestEstimateReadyField(true);
    }
    public APIRequestGet requestEstimateReadyField (boolean value) {
      this.requestField("estimate_ready", value);
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

  public static enum EnumOptimizationGoal {
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("AD_RECALL_LIFT")
      VALUE_AD_RECALL_LIFT("AD_RECALL_LIFT"),
      @SerializedName("CLICKS")
      VALUE_CLICKS("CLICKS"),
      @SerializedName("ENGAGED_USERS")
      VALUE_ENGAGED_USERS("ENGAGED_USERS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("IMPRESSIONS")
      VALUE_IMPRESSIONS("IMPRESSIONS"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("OFFSITE_CONVERSIONS")
      VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
      @SerializedName("PAGE_ENGAGEMENT")
      VALUE_PAGE_ENGAGEMENT("PAGE_ENGAGEMENT"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("SOCIAL_IMPRESSIONS")
      VALUE_SOCIAL_IMPRESSIONS("SOCIAL_IMPRESSIONS"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      @SerializedName("APP_DOWNLOADS")
      VALUE_APP_DOWNLOADS("APP_DOWNLOADS"),
      @SerializedName("LANDING_PAGE_VIEWS")
      VALUE_LANDING_PAGE_VIEWS("LANDING_PAGE_VIEWS"),
      @SerializedName("VALUE")
      VALUE_VALUE("VALUE"),
      @SerializedName("REPLIES")
      VALUE_REPLIES("REPLIES"),
      @SerializedName("DERIVED_EVENTS")
      VALUE_DERIVED_EVENTS("DERIVED_EVENTS"),
      NULL(null);

      private String value;

      private EnumOptimizationGoal(String value) {
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

  public AdCampaignDeliveryEstimate copyFrom(AdCampaignDeliveryEstimate instance) {
    this.mBidEstimate = instance.mBidEstimate;
    this.mDailyOutcomesCurve = instance.mDailyOutcomesCurve;
    this.mEstimateDau = instance.mEstimateDau;
    this.mEstimateMau = instance.mEstimateMau;
    this.mEstimateReady = instance.mEstimateReady;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignDeliveryEstimate> getParser() {
    return new APIRequest.ResponseParser<AdCampaignDeliveryEstimate>() {
      public APINodeList<AdCampaignDeliveryEstimate> parseResponse(String response, APIContext context, APIRequest<AdCampaignDeliveryEstimate> request) throws MalformedResponseException {
        return AdCampaignDeliveryEstimate.parseResponse(response, context, request);
      }
    };
  }
}
