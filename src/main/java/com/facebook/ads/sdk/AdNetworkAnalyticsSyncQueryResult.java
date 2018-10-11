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
public class AdNetworkAnalyticsSyncQueryResult extends APINode {
  @SerializedName("query_id")
  private String mQueryId = null;
  @SerializedName("results")
  private List<Object> mResults = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdNetworkAnalyticsSyncQueryResult() {
  }

  public AdNetworkAnalyticsSyncQueryResult(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdNetworkAnalyticsSyncQueryResult(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdNetworkAnalyticsSyncQueryResult fetch() throws APIException{
    AdNetworkAnalyticsSyncQueryResult newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdNetworkAnalyticsSyncQueryResult fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdNetworkAnalyticsSyncQueryResult> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdNetworkAnalyticsSyncQueryResult fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdNetworkAnalyticsSyncQueryResult> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdNetworkAnalyticsSyncQueryResult> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdNetworkAnalyticsSyncQueryResult>)(
      new APIRequest<AdNetworkAnalyticsSyncQueryResult>(context, "", "/", "GET", AdNetworkAnalyticsSyncQueryResult.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdNetworkAnalyticsSyncQueryResult>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdNetworkAnalyticsSyncQueryResult.getParser())
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
  public static AdNetworkAnalyticsSyncQueryResult loadJSON(String json, APIContext context) {
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
      };
    }
    adNetworkAnalyticsSyncQueryResult.context = context;
    adNetworkAnalyticsSyncQueryResult.rawValue = json;
    return adNetworkAnalyticsSyncQueryResult;
  }

  public static APINodeList<AdNetworkAnalyticsSyncQueryResult> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdNetworkAnalyticsSyncQueryResult> adNetworkAnalyticsSyncQueryResults = new APINodeList<AdNetworkAnalyticsSyncQueryResult>(request, json);
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
          adNetworkAnalyticsSyncQueryResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              adNetworkAnalyticsSyncQueryResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adNetworkAnalyticsSyncQueryResults.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adNetworkAnalyticsSyncQueryResults.add(loadJSON(obj.toString(), context));
            }
          }
          return adNetworkAnalyticsSyncQueryResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adNetworkAnalyticsSyncQueryResults.add(loadJSON(entry.getValue().toString(), context));
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
              adNetworkAnalyticsSyncQueryResults.add(loadJSON(value.toString(), context));
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
          adNetworkAnalyticsSyncQueryResults.add(loadJSON(json, context));
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldQueryId() {
    return mQueryId;
  }

  public List<Object> getFieldResults() {
    return mResults;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdNetworkAnalyticsSyncQueryResult> {

    AdNetworkAnalyticsSyncQueryResult lastResponse = null;
    @Override
    public AdNetworkAnalyticsSyncQueryResult getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "query_id",
      "results",
      "id",
    };

    @Override
    public AdNetworkAnalyticsSyncQueryResult parseResponse(String response) throws APIException {
      return AdNetworkAnalyticsSyncQueryResult.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdNetworkAnalyticsSyncQueryResult execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdNetworkAnalyticsSyncQueryResult execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdNetworkAnalyticsSyncQueryResult> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdNetworkAnalyticsSyncQueryResult> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdNetworkAnalyticsSyncQueryResult>() {
           public AdNetworkAnalyticsSyncQueryResult apply(String result) {
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

    public APIRequestGet requestQueryIdField () {
      return this.requestQueryIdField(true);
    }
    public APIRequestGet requestQueryIdField (boolean value) {
      this.requestField("query_id", value);
      return this;
    }
    public APIRequestGet requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGet requestResultsField (boolean value) {
      this.requestField("results", value);
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

  public static enum EnumAggregationPeriod {
      @SerializedName("HOUR")
      VALUE_HOUR("HOUR"),
      @SerializedName("DAY")
      VALUE_DAY("DAY"),
      @SerializedName("TOTAL")
      VALUE_TOTAL("TOTAL"),
      NULL(null);

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
      @SerializedName("AGE")
      VALUE_AGE("AGE"),
      @SerializedName("APP")
      VALUE_APP("APP"),
      @SerializedName("COUNTRY")
      VALUE_COUNTRY("COUNTRY"),
      @SerializedName("DELIVERY_METHOD")
      VALUE_DELIVERY_METHOD("DELIVERY_METHOD"),
      @SerializedName("DISPLAY_FORMAT")
      VALUE_DISPLAY_FORMAT("DISPLAY_FORMAT"),
      @SerializedName("DEAL")
      VALUE_DEAL("DEAL"),
      @SerializedName("DEAL_AD")
      VALUE_DEAL_AD("DEAL_AD"),
      @SerializedName("DEAL_PAGE")
      VALUE_DEAL_PAGE("DEAL_PAGE"),
      @SerializedName("GENDER")
      VALUE_GENDER("GENDER"),
      @SerializedName("PLACEMENT")
      VALUE_PLACEMENT("PLACEMENT"),
      @SerializedName("PLATFORM")
      VALUE_PLATFORM("PLATFORM"),
      @SerializedName("PROPERTY")
      VALUE_PROPERTY("PROPERTY"),
      @SerializedName("CLICKED_VIEW_TAG")
      VALUE_CLICKED_VIEW_TAG("CLICKED_VIEW_TAG"),
      NULL(null);

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
      @SerializedName("FB_AD_NETWORK_BIDDING_REQUEST")
      VALUE_FB_AD_NETWORK_BIDDING_REQUEST("FB_AD_NETWORK_BIDDING_REQUEST"),
      @SerializedName("FB_AD_NETWORK_BIDDING_RESPONSE")
      VALUE_FB_AD_NETWORK_BIDDING_RESPONSE("FB_AD_NETWORK_BIDDING_RESPONSE"),
      @SerializedName("FB_AD_NETWORK_BIDDING_BID_RATE")
      VALUE_FB_AD_NETWORK_BIDDING_BID_RATE("FB_AD_NETWORK_BIDDING_BID_RATE"),
      @SerializedName("FB_AD_NETWORK_BIDDING_WIN_RATE")
      VALUE_FB_AD_NETWORK_BIDDING_WIN_RATE("FB_AD_NETWORK_BIDDING_WIN_RATE"),
      @SerializedName("FB_AD_NETWORK_REQUEST")
      VALUE_FB_AD_NETWORK_REQUEST("FB_AD_NETWORK_REQUEST"),
      @SerializedName("FB_AD_NETWORK_FILLED_REQUEST")
      VALUE_FB_AD_NETWORK_FILLED_REQUEST("FB_AD_NETWORK_FILLED_REQUEST"),
      @SerializedName("FB_AD_NETWORK_FILL_RATE")
      VALUE_FB_AD_NETWORK_FILL_RATE("FB_AD_NETWORK_FILL_RATE"),
      @SerializedName("FB_AD_NETWORK_IMP")
      VALUE_FB_AD_NETWORK_IMP("FB_AD_NETWORK_IMP"),
      @SerializedName("FB_AD_NETWORK_SHOW_RATE")
      VALUE_FB_AD_NETWORK_SHOW_RATE("FB_AD_NETWORK_SHOW_RATE"),
      @SerializedName("FB_AD_NETWORK_CLICK")
      VALUE_FB_AD_NETWORK_CLICK("FB_AD_NETWORK_CLICK"),
      @SerializedName("FB_AD_NETWORK_CTR")
      VALUE_FB_AD_NETWORK_CTR("FB_AD_NETWORK_CTR"),
      @SerializedName("FB_AD_NETWORK_BIDDING_REVENUE")
      VALUE_FB_AD_NETWORK_BIDDING_REVENUE("FB_AD_NETWORK_BIDDING_REVENUE"),
      @SerializedName("FB_AD_NETWORK_REVENUE")
      VALUE_FB_AD_NETWORK_REVENUE("FB_AD_NETWORK_REVENUE"),
      @SerializedName("FB_AD_NETWORK_CPM")
      VALUE_FB_AD_NETWORK_CPM("FB_AD_NETWORK_CPM"),
      @SerializedName("FB_AD_NETWORK_VIDEO_GUARANTEE_REVENUE")
      VALUE_FB_AD_NETWORK_VIDEO_GUARANTEE_REVENUE("FB_AD_NETWORK_VIDEO_GUARANTEE_REVENUE"),
      @SerializedName("FB_AD_NETWORK_VIDEO_VIEW")
      VALUE_FB_AD_NETWORK_VIDEO_VIEW("FB_AD_NETWORK_VIDEO_VIEW"),
      @SerializedName("FB_AD_NETWORK_VIDEO_VIEW_RATE")
      VALUE_FB_AD_NETWORK_VIDEO_VIEW_RATE("FB_AD_NETWORK_VIDEO_VIEW_RATE"),
      @SerializedName("FB_AD_NETWORK_VIDEO_MRC")
      VALUE_FB_AD_NETWORK_VIDEO_MRC("FB_AD_NETWORK_VIDEO_MRC"),
      @SerializedName("FB_AD_NETWORK_VIDEO_MRC_RATE")
      VALUE_FB_AD_NETWORK_VIDEO_MRC_RATE("FB_AD_NETWORK_VIDEO_MRC_RATE"),
      @SerializedName("FB_AD_NETWORK_WIN_RATE")
      VALUE_FB_AD_NETWORK_WIN_RATE("FB_AD_NETWORK_WIN_RATE"),
      @SerializedName("FB_AD_NETWORK_DIRECT_TOTAL_REVENUE")
      VALUE_FB_AD_NETWORK_DIRECT_TOTAL_REVENUE("FB_AD_NETWORK_DIRECT_TOTAL_REVENUE"),
      @SerializedName("FB_AD_NETWORK_DIRECT_PUBLISHER_BILL")
      VALUE_FB_AD_NETWORK_DIRECT_PUBLISHER_BILL("FB_AD_NETWORK_DIRECT_PUBLISHER_BILL"),
      @SerializedName("FB_AD_NETWORK_FAST_CLICK_RATE")
      VALUE_FB_AD_NETWORK_FAST_CLICK_RATE("FB_AD_NETWORK_FAST_CLICK_RATE"),
      @SerializedName("FB_AD_NETWORK_FAST_RETURN_RATE")
      VALUE_FB_AD_NETWORK_FAST_RETURN_RATE("FB_AD_NETWORK_FAST_RETURN_RATE"),
      @SerializedName("FB_AD_NETWORK_CLICK_VALUE_SCORE")
      VALUE_FB_AD_NETWORK_CLICK_VALUE_SCORE("FB_AD_NETWORK_CLICK_VALUE_SCORE"),
      @SerializedName("FB_AD_NETWORK_FAST_CLICK_NUMERATOR")
      VALUE_FB_AD_NETWORK_FAST_CLICK_NUMERATOR("FB_AD_NETWORK_FAST_CLICK_NUMERATOR"),
      @SerializedName("FB_AD_NETWORK_FAST_CLICK_DENOMINATOR")
      VALUE_FB_AD_NETWORK_FAST_CLICK_DENOMINATOR("FB_AD_NETWORK_FAST_CLICK_DENOMINATOR"),
      @SerializedName("FB_AD_NETWORK_FAST_RETURN_NUMERATOR")
      VALUE_FB_AD_NETWORK_FAST_RETURN_NUMERATOR("FB_AD_NETWORK_FAST_RETURN_NUMERATOR"),
      @SerializedName("FB_AD_NETWORK_FAST_RETURN_DENOMINATOR")
      VALUE_FB_AD_NETWORK_FAST_RETURN_DENOMINATOR("FB_AD_NETWORK_FAST_RETURN_DENOMINATOR"),
      @SerializedName("FB_AD_NETWORK_CLICK_VALUE_SCORE_NUMERATOR")
      VALUE_FB_AD_NETWORK_CLICK_VALUE_SCORE_NUMERATOR("FB_AD_NETWORK_CLICK_VALUE_SCORE_NUMERATOR"),
      @SerializedName("FB_AD_NETWORK_CLICK_VALUE_SCORE_DENOMINATOR")
      VALUE_FB_AD_NETWORK_CLICK_VALUE_SCORE_DENOMINATOR("FB_AD_NETWORK_CLICK_VALUE_SCORE_DENOMINATOR"),
      NULL(null);

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
      @SerializedName("TIME")
      VALUE_TIME("TIME"),
      @SerializedName("VALUE")
      VALUE_VALUE("VALUE"),
      @SerializedName("METRIC")
      VALUE_METRIC("METRIC"),
      NULL(null);

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
      NULL(null);

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
    this.mQueryId = instance.mQueryId;
    this.mResults = instance.mResults;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdNetworkAnalyticsSyncQueryResult> getParser() {
    return new APIRequest.ResponseParser<AdNetworkAnalyticsSyncQueryResult>() {
      public APINodeList<AdNetworkAnalyticsSyncQueryResult> parseResponse(String response, APIContext context, APIRequest<AdNetworkAnalyticsSyncQueryResult> request) throws MalformedResponseException {
        return AdNetworkAnalyticsSyncQueryResult.parseResponse(response, context, request);
      }
    };
  }
}
