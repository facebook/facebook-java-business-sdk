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
public class AdNetworkAnalyticsSyncQueryResult extends APINode {
  @SerializedName("omitted_results")
  private List<Object> mOmittedResults = null;
  @SerializedName("query_id")
  private String mQueryId = null;
  @SerializedName("results")
  private List<Object> mResults = null;
  protected static Gson gson = null;

  public AdNetworkAnalyticsSyncQueryResult() {
  }

  public String getId() {
    return null;
  }
  public static AdNetworkAnalyticsSyncQueryResult loadJSON(String json, APIContext context, String header) {
    AdNetworkAnalyticsSyncQueryResult adNetworkAnalyticsSyncQueryResult = getGson().fromJson(json, AdNetworkAnalyticsSyncQueryResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adNetworkAnalyticsSyncQueryResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adNetworkAnalyticsSyncQueryResult.context = context;
    adNetworkAnalyticsSyncQueryResult.rawValue = json;
    adNetworkAnalyticsSyncQueryResult.header = header;
    return adNetworkAnalyticsSyncQueryResult;
  }

  public static APINodeList<AdNetworkAnalyticsSyncQueryResult> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdNetworkAnalyticsSyncQueryResult> adNetworkAnalyticsSyncQueryResults = new APINodeList<AdNetworkAnalyticsSyncQueryResult>(request, json, header);
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
          adNetworkAnalyticsSyncQueryResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adNetworkAnalyticsSyncQueryResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adNetworkAnalyticsSyncQueryResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adNetworkAnalyticsSyncQueryResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adNetworkAnalyticsSyncQueryResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adNetworkAnalyticsSyncQueryResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adNetworkAnalyticsSyncQueryResults.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adNetworkAnalyticsSyncQueryResults.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adNetworkAnalyticsSyncQueryResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adNetworkAnalyticsSyncQueryResults.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adNetworkAnalyticsSyncQueryResults;
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
              adNetworkAnalyticsSyncQueryResults.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adNetworkAnalyticsSyncQueryResults;
          }

          // Sixth, check if it's pure JsonObject
          adNetworkAnalyticsSyncQueryResults.clear();
          adNetworkAnalyticsSyncQueryResults.add(loadJSON(json, context, header));
          return adNetworkAnalyticsSyncQueryResults;
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


  public List<Object> getFieldOmittedResults() {
    return mOmittedResults;
  }

  public AdNetworkAnalyticsSyncQueryResult setFieldOmittedResults(List<Object> value) {
    this.mOmittedResults = value;
    return this;
  }

  public String getFieldQueryId() {
    return mQueryId;
  }

  public AdNetworkAnalyticsSyncQueryResult setFieldQueryId(String value) {
    this.mQueryId = value;
    return this;
  }

  public List<Object> getFieldResults() {
    return mResults;
  }

  public AdNetworkAnalyticsSyncQueryResult setFieldResults(List<Object> value) {
    this.mResults = value;
    return this;
  }



  public static enum EnumAggregationPeriod {
      @SerializedName("DAY")
      VALUE_DAY("DAY"),
      @SerializedName("TOTAL")
      VALUE_TOTAL("TOTAL"),
      ;

      private String value;

      private EnumAggregationPeriod(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBreakdowns {
      @SerializedName("AD_SERVER_CAMPAIGN_ID")
      VALUE_AD_SERVER_CAMPAIGN_ID("AD_SERVER_CAMPAIGN_ID"),
      @SerializedName("AD_SPACE")
      VALUE_AD_SPACE("AD_SPACE"),
      @SerializedName("AGE")
      VALUE_AGE("AGE"),
      @SerializedName("APP")
      VALUE_APP("APP"),
      @SerializedName("CLICKED_VIEW_TAG")
      VALUE_CLICKED_VIEW_TAG("CLICKED_VIEW_TAG"),
      @SerializedName("COUNTRY")
      VALUE_COUNTRY("COUNTRY"),
      @SerializedName("DEAL")
      VALUE_DEAL("DEAL"),
      @SerializedName("DEAL_AD")
      VALUE_DEAL_AD("DEAL_AD"),
      @SerializedName("DEAL_PAGE")
      VALUE_DEAL_PAGE("DEAL_PAGE"),
      @SerializedName("DELIVERY_METHOD")
      VALUE_DELIVERY_METHOD("DELIVERY_METHOD"),
      @SerializedName("DISPLAY_FORMAT")
      VALUE_DISPLAY_FORMAT("DISPLAY_FORMAT"),
      @SerializedName("FAIL_REASON")
      VALUE_FAIL_REASON("FAIL_REASON"),
      @SerializedName("GENDER")
      VALUE_GENDER("GENDER"),
      @SerializedName("INSTANT_ARTICLE_ID")
      VALUE_INSTANT_ARTICLE_ID("INSTANT_ARTICLE_ID"),
      @SerializedName("INSTANT_ARTICLE_PAGE_ID")
      VALUE_INSTANT_ARTICLE_PAGE_ID("INSTANT_ARTICLE_PAGE_ID"),
      @SerializedName("IS_DEAL_BACKFILL")
      VALUE_IS_DEAL_BACKFILL("IS_DEAL_BACKFILL"),
      @SerializedName("PLACEMENT")
      VALUE_PLACEMENT("PLACEMENT"),
      @SerializedName("PLACEMENT_NAME")
      VALUE_PLACEMENT_NAME("PLACEMENT_NAME"),
      @SerializedName("PLATFORM")
      VALUE_PLATFORM("PLATFORM"),
      @SerializedName("PROPERTY")
      VALUE_PROPERTY("PROPERTY"),
      @SerializedName("SDK_VERSION")
      VALUE_SDK_VERSION("SDK_VERSION"),
      ;

      private String value;

      private EnumBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMetrics {
      @SerializedName("FB_AD_NETWORK_BIDDING_BID_RATE")
      VALUE_FB_AD_NETWORK_BIDDING_BID_RATE("FB_AD_NETWORK_BIDDING_BID_RATE"),
      @SerializedName("FB_AD_NETWORK_BIDDING_REQUEST")
      VALUE_FB_AD_NETWORK_BIDDING_REQUEST("FB_AD_NETWORK_BIDDING_REQUEST"),
      @SerializedName("FB_AD_NETWORK_BIDDING_RESPONSE")
      VALUE_FB_AD_NETWORK_BIDDING_RESPONSE("FB_AD_NETWORK_BIDDING_RESPONSE"),
      @SerializedName("FB_AD_NETWORK_BIDDING_REVENUE")
      VALUE_FB_AD_NETWORK_BIDDING_REVENUE("FB_AD_NETWORK_BIDDING_REVENUE"),
      @SerializedName("FB_AD_NETWORK_BIDDING_WIN_RATE")
      VALUE_FB_AD_NETWORK_BIDDING_WIN_RATE("FB_AD_NETWORK_BIDDING_WIN_RATE"),
      @SerializedName("FB_AD_NETWORK_CLICK")
      VALUE_FB_AD_NETWORK_CLICK("FB_AD_NETWORK_CLICK"),
      @SerializedName("FB_AD_NETWORK_CPM")
      VALUE_FB_AD_NETWORK_CPM("FB_AD_NETWORK_CPM"),
      @SerializedName("FB_AD_NETWORK_CTR")
      VALUE_FB_AD_NETWORK_CTR("FB_AD_NETWORK_CTR"),
      @SerializedName("FB_AD_NETWORK_FILLED_REQUEST")
      VALUE_FB_AD_NETWORK_FILLED_REQUEST("FB_AD_NETWORK_FILLED_REQUEST"),
      @SerializedName("FB_AD_NETWORK_FILL_RATE")
      VALUE_FB_AD_NETWORK_FILL_RATE("FB_AD_NETWORK_FILL_RATE"),
      @SerializedName("FB_AD_NETWORK_IMP")
      VALUE_FB_AD_NETWORK_IMP("FB_AD_NETWORK_IMP"),
      @SerializedName("FB_AD_NETWORK_IMPRESSION_RATE")
      VALUE_FB_AD_NETWORK_IMPRESSION_RATE("FB_AD_NETWORK_IMPRESSION_RATE"),
      @SerializedName("FB_AD_NETWORK_REQUEST")
      VALUE_FB_AD_NETWORK_REQUEST("FB_AD_NETWORK_REQUEST"),
      @SerializedName("FB_AD_NETWORK_REVENUE")
      VALUE_FB_AD_NETWORK_REVENUE("FB_AD_NETWORK_REVENUE"),
      @SerializedName("FB_AD_NETWORK_SHOW_RATE")
      VALUE_FB_AD_NETWORK_SHOW_RATE("FB_AD_NETWORK_SHOW_RATE"),
      @SerializedName("FB_AD_NETWORK_VIDEO_GUARANTEE_REVENUE")
      VALUE_FB_AD_NETWORK_VIDEO_GUARANTEE_REVENUE("FB_AD_NETWORK_VIDEO_GUARANTEE_REVENUE"),
      @SerializedName("FB_AD_NETWORK_VIDEO_MRC")
      VALUE_FB_AD_NETWORK_VIDEO_MRC("FB_AD_NETWORK_VIDEO_MRC"),
      @SerializedName("FB_AD_NETWORK_VIDEO_MRC_RATE")
      VALUE_FB_AD_NETWORK_VIDEO_MRC_RATE("FB_AD_NETWORK_VIDEO_MRC_RATE"),
      @SerializedName("FB_AD_NETWORK_VIDEO_VIEW")
      VALUE_FB_AD_NETWORK_VIDEO_VIEW("FB_AD_NETWORK_VIDEO_VIEW"),
      @SerializedName("FB_AD_NETWORK_VIDEO_VIEW_RATE")
      VALUE_FB_AD_NETWORK_VIDEO_VIEW_RATE("FB_AD_NETWORK_VIDEO_VIEW_RATE"),
      ;

      private String value;

      private EnumMetrics(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOrderingColumn {
      @SerializedName("METRIC")
      VALUE_METRIC("METRIC"),
      @SerializedName("TIME")
      VALUE_TIME("TIME"),
      @SerializedName("VALUE")
      VALUE_VALUE("VALUE"),
      ;

      private String value;

      private EnumOrderingColumn(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOrderingType {
      @SerializedName("ASCENDING")
      VALUE_ASCENDING("ASCENDING"),
      @SerializedName("DESCENDING")
      VALUE_DESCENDING("DESCENDING"),
      ;

      private String value;

      private EnumOrderingType(String value) {
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

  public AdNetworkAnalyticsSyncQueryResult copyFrom(AdNetworkAnalyticsSyncQueryResult instance) {
    this.mOmittedResults = instance.mOmittedResults;
    this.mQueryId = instance.mQueryId;
    this.mResults = instance.mResults;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdNetworkAnalyticsSyncQueryResult> getParser() {
    return new APIRequest.ResponseParser<AdNetworkAnalyticsSyncQueryResult>() {
      public APINodeList<AdNetworkAnalyticsSyncQueryResult> parseResponse(String response, APIContext context, APIRequest<AdNetworkAnalyticsSyncQueryResult> request, String header) throws MalformedResponseException {
        return AdNetworkAnalyticsSyncQueryResult.parseResponse(response, context, request, header);
      }
    };
  }
}
