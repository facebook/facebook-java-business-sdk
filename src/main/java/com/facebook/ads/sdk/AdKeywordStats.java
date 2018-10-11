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
public class AdKeywordStats extends APINode {
  @SerializedName("actions")
  private List<AdsActionStats> mActions = null;
  @SerializedName("clicks")
  private Long mClicks = null;
  @SerializedName("cost_per_total_action")
  private Double mCostPerTotalAction = null;
  @SerializedName("cost_per_unique_click")
  private Double mCostPerUniqueClick = null;
  @SerializedName("cpc")
  private Double mCpc = null;
  @SerializedName("cpm")
  private Double mCpm = null;
  @SerializedName("cpp")
  private Double mCpp = null;
  @SerializedName("ctr")
  private Double mCtr = null;
  @SerializedName("frequency")
  private Double mFrequency = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("impressions")
  private Long mImpressions = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("reach")
  private Long mReach = null;
  @SerializedName("spend")
  private Double mSpend = null;
  @SerializedName("total_actions")
  private Long mTotalActions = null;
  @SerializedName("total_unique_actions")
  private Long mTotalUniqueActions = null;
  @SerializedName("unique_actions")
  private List<AdsActionStats> mUniqueActions = null;
  @SerializedName("unique_clicks")
  private Long mUniqueClicks = null;
  @SerializedName("unique_ctr")
  private Double mUniqueCtr = null;
  @SerializedName("unique_impressions")
  private Long mUniqueImpressions = null;
  protected static Gson gson = null;

  AdKeywordStats() {
  }

  public AdKeywordStats(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdKeywordStats(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdKeywordStats fetch() throws APIException{
    AdKeywordStats newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdKeywordStats fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdKeywordStats> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdKeywordStats fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdKeywordStats> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdKeywordStats> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdKeywordStats>)(
      new APIRequest<AdKeywordStats>(context, "", "/", "GET", AdKeywordStats.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdKeywordStats>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdKeywordStats.getParser())
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
  public static AdKeywordStats loadJSON(String json, APIContext context) {
    AdKeywordStats adKeywordStats = getGson().fromJson(json, AdKeywordStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adKeywordStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adKeywordStats.context = context;
    adKeywordStats.rawValue = json;
    return adKeywordStats;
  }

  public static APINodeList<AdKeywordStats> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdKeywordStats> adKeywordStatss = new APINodeList<AdKeywordStats>(request, json);
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
          adKeywordStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adKeywordStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adKeywordStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adKeywordStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adKeywordStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adKeywordStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adKeywordStatss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adKeywordStatss.add(loadJSON(obj.toString(), context));
            }
          }
          return adKeywordStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adKeywordStatss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adKeywordStatss;
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
              adKeywordStatss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adKeywordStatss;
          }

          // Sixth, check if it's pure JsonObject
          adKeywordStatss.clear();
          adKeywordStatss.add(loadJSON(json, context));
          return adKeywordStatss;
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


  public List<AdsActionStats> getFieldActions() {
    return mActions;
  }

  public Long getFieldClicks() {
    return mClicks;
  }

  public Double getFieldCostPerTotalAction() {
    return mCostPerTotalAction;
  }

  public Double getFieldCostPerUniqueClick() {
    return mCostPerUniqueClick;
  }

  public Double getFieldCpc() {
    return mCpc;
  }

  public Double getFieldCpm() {
    return mCpm;
  }

  public Double getFieldCpp() {
    return mCpp;
  }

  public Double getFieldCtr() {
    return mCtr;
  }

  public Double getFieldFrequency() {
    return mFrequency;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldImpressions() {
    return mImpressions;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldReach() {
    return mReach;
  }

  public Double getFieldSpend() {
    return mSpend;
  }

  public Long getFieldTotalActions() {
    return mTotalActions;
  }

  public Long getFieldTotalUniqueActions() {
    return mTotalUniqueActions;
  }

  public List<AdsActionStats> getFieldUniqueActions() {
    return mUniqueActions;
  }

  public Long getFieldUniqueClicks() {
    return mUniqueClicks;
  }

  public Double getFieldUniqueCtr() {
    return mUniqueCtr;
  }

  public Long getFieldUniqueImpressions() {
    return mUniqueImpressions;
  }



  public static class APIRequestGet extends APIRequest<AdKeywordStats> {

    AdKeywordStats lastResponse = null;
    @Override
    public AdKeywordStats getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "actions",
      "clicks",
      "cost_per_total_action",
      "cost_per_unique_click",
      "cpc",
      "cpm",
      "cpp",
      "ctr",
      "frequency",
      "id",
      "impressions",
      "name",
      "reach",
      "spend",
      "total_actions",
      "total_unique_actions",
      "unique_actions",
      "unique_clicks",
      "unique_ctr",
      "unique_impressions",
    };

    @Override
    public AdKeywordStats parseResponse(String response) throws APIException {
      return AdKeywordStats.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdKeywordStats execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdKeywordStats execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdKeywordStats> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdKeywordStats> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdKeywordStats>() {
           public AdKeywordStats apply(String result) {
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
    public APIRequestGet requestClicksField () {
      return this.requestClicksField(true);
    }
    public APIRequestGet requestClicksField (boolean value) {
      this.requestField("clicks", value);
      return this;
    }
    public APIRequestGet requestCostPerTotalActionField () {
      return this.requestCostPerTotalActionField(true);
    }
    public APIRequestGet requestCostPerTotalActionField (boolean value) {
      this.requestField("cost_per_total_action", value);
      return this;
    }
    public APIRequestGet requestCostPerUniqueClickField () {
      return this.requestCostPerUniqueClickField(true);
    }
    public APIRequestGet requestCostPerUniqueClickField (boolean value) {
      this.requestField("cost_per_unique_click", value);
      return this;
    }
    public APIRequestGet requestCpcField () {
      return this.requestCpcField(true);
    }
    public APIRequestGet requestCpcField (boolean value) {
      this.requestField("cpc", value);
      return this;
    }
    public APIRequestGet requestCpmField () {
      return this.requestCpmField(true);
    }
    public APIRequestGet requestCpmField (boolean value) {
      this.requestField("cpm", value);
      return this;
    }
    public APIRequestGet requestCppField () {
      return this.requestCppField(true);
    }
    public APIRequestGet requestCppField (boolean value) {
      this.requestField("cpp", value);
      return this;
    }
    public APIRequestGet requestCtrField () {
      return this.requestCtrField(true);
    }
    public APIRequestGet requestCtrField (boolean value) {
      this.requestField("ctr", value);
      return this;
    }
    public APIRequestGet requestFrequencyField () {
      return this.requestFrequencyField(true);
    }
    public APIRequestGet requestFrequencyField (boolean value) {
      this.requestField("frequency", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGet requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestReachField () {
      return this.requestReachField(true);
    }
    public APIRequestGet requestReachField (boolean value) {
      this.requestField("reach", value);
      return this;
    }
    public APIRequestGet requestSpendField () {
      return this.requestSpendField(true);
    }
    public APIRequestGet requestSpendField (boolean value) {
      this.requestField("spend", value);
      return this;
    }
    public APIRequestGet requestTotalActionsField () {
      return this.requestTotalActionsField(true);
    }
    public APIRequestGet requestTotalActionsField (boolean value) {
      this.requestField("total_actions", value);
      return this;
    }
    public APIRequestGet requestTotalUniqueActionsField () {
      return this.requestTotalUniqueActionsField(true);
    }
    public APIRequestGet requestTotalUniqueActionsField (boolean value) {
      this.requestField("total_unique_actions", value);
      return this;
    }
    public APIRequestGet requestUniqueActionsField () {
      return this.requestUniqueActionsField(true);
    }
    public APIRequestGet requestUniqueActionsField (boolean value) {
      this.requestField("unique_actions", value);
      return this;
    }
    public APIRequestGet requestUniqueClicksField () {
      return this.requestUniqueClicksField(true);
    }
    public APIRequestGet requestUniqueClicksField (boolean value) {
      this.requestField("unique_clicks", value);
      return this;
    }
    public APIRequestGet requestUniqueCtrField () {
      return this.requestUniqueCtrField(true);
    }
    public APIRequestGet requestUniqueCtrField (boolean value) {
      this.requestField("unique_ctr", value);
      return this;
    }
    public APIRequestGet requestUniqueImpressionsField () {
      return this.requestUniqueImpressionsField(true);
    }
    public APIRequestGet requestUniqueImpressionsField (boolean value) {
      this.requestField("unique_impressions", value);
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

  public AdKeywordStats copyFrom(AdKeywordStats instance) {
    this.mActions = instance.mActions;
    this.mClicks = instance.mClicks;
    this.mCostPerTotalAction = instance.mCostPerTotalAction;
    this.mCostPerUniqueClick = instance.mCostPerUniqueClick;
    this.mCpc = instance.mCpc;
    this.mCpm = instance.mCpm;
    this.mCpp = instance.mCpp;
    this.mCtr = instance.mCtr;
    this.mFrequency = instance.mFrequency;
    this.mId = instance.mId;
    this.mImpressions = instance.mImpressions;
    this.mName = instance.mName;
    this.mReach = instance.mReach;
    this.mSpend = instance.mSpend;
    this.mTotalActions = instance.mTotalActions;
    this.mTotalUniqueActions = instance.mTotalUniqueActions;
    this.mUniqueActions = instance.mUniqueActions;
    this.mUniqueClicks = instance.mUniqueClicks;
    this.mUniqueCtr = instance.mUniqueCtr;
    this.mUniqueImpressions = instance.mUniqueImpressions;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdKeywordStats> getParser() {
    return new APIRequest.ResponseParser<AdKeywordStats>() {
      public APINodeList<AdKeywordStats> parseResponse(String response, APIContext context, APIRequest<AdKeywordStats> request) throws MalformedResponseException {
        return AdKeywordStats.parseResponse(response, context, request);
      }
    };
  }
}
