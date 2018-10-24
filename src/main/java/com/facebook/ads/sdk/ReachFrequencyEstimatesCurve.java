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
public class ReachFrequencyEstimatesCurve extends APINode {
  @SerializedName("budget")
  private List<Long> mBudget = null;
  @SerializedName("click")
  private List<Long> mClick = null;
  @SerializedName("conversion")
  private List<Long> mConversion = null;
  @SerializedName("impression")
  private List<Long> mImpression = null;
  @SerializedName("interpolated_reach")
  private Double mInterpolatedReach = null;
  @SerializedName("num_points")
  private Long mNumPoints = null;
  @SerializedName("raw_impression")
  private List<Long> mRawImpression = null;
  @SerializedName("raw_reach")
  private List<Long> mRawReach = null;
  @SerializedName("reach")
  private List<Long> mReach = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ReachFrequencyEstimatesCurve() {
  }

  public ReachFrequencyEstimatesCurve(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ReachFrequencyEstimatesCurve(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ReachFrequencyEstimatesCurve fetch() throws APIException{
    ReachFrequencyEstimatesCurve newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ReachFrequencyEstimatesCurve fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ReachFrequencyEstimatesCurve> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ReachFrequencyEstimatesCurve fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ReachFrequencyEstimatesCurve> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ReachFrequencyEstimatesCurve> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ReachFrequencyEstimatesCurve>)(
      new APIRequest<ReachFrequencyEstimatesCurve>(context, "", "/", "GET", ReachFrequencyEstimatesCurve.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ReachFrequencyEstimatesCurve>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ReachFrequencyEstimatesCurve.getParser())
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
  public static ReachFrequencyEstimatesCurve loadJSON(String json, APIContext context) {
    ReachFrequencyEstimatesCurve reachFrequencyEstimatesCurve = getGson().fromJson(json, ReachFrequencyEstimatesCurve.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(reachFrequencyEstimatesCurve.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    reachFrequencyEstimatesCurve.context = context;
    reachFrequencyEstimatesCurve.rawValue = json;
    return reachFrequencyEstimatesCurve;
  }

  public static APINodeList<ReachFrequencyEstimatesCurve> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ReachFrequencyEstimatesCurve> reachFrequencyEstimatesCurves = new APINodeList<ReachFrequencyEstimatesCurve>(request, json);
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
          reachFrequencyEstimatesCurves.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return reachFrequencyEstimatesCurves;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                reachFrequencyEstimatesCurves.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            reachFrequencyEstimatesCurves.setPaging(previous, next);
            if (context.hasAppSecret()) {
              reachFrequencyEstimatesCurves.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              reachFrequencyEstimatesCurves.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  reachFrequencyEstimatesCurves.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              reachFrequencyEstimatesCurves.add(loadJSON(obj.toString(), context));
            }
          }
          return reachFrequencyEstimatesCurves;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              reachFrequencyEstimatesCurves.add(loadJSON(entry.getValue().toString(), context));
          }
          return reachFrequencyEstimatesCurves;
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
              reachFrequencyEstimatesCurves.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return reachFrequencyEstimatesCurves;
          }

          // Sixth, check if it's pure JsonObject
          reachFrequencyEstimatesCurves.clear();
          reachFrequencyEstimatesCurves.add(loadJSON(json, context));
          return reachFrequencyEstimatesCurves;
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


  public List<Long> getFieldBudget() {
    return mBudget;
  }

  public List<Long> getFieldClick() {
    return mClick;
  }

  public List<Long> getFieldConversion() {
    return mConversion;
  }

  public List<Long> getFieldImpression() {
    return mImpression;
  }

  public Double getFieldInterpolatedReach() {
    return mInterpolatedReach;
  }

  public Long getFieldNumPoints() {
    return mNumPoints;
  }

  public List<Long> getFieldRawImpression() {
    return mRawImpression;
  }

  public List<Long> getFieldRawReach() {
    return mRawReach;
  }

  public List<Long> getFieldReach() {
    return mReach;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ReachFrequencyEstimatesCurve> {

    ReachFrequencyEstimatesCurve lastResponse = null;
    @Override
    public ReachFrequencyEstimatesCurve getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "budget",
      "click",
      "conversion",
      "impression",
      "interpolated_reach",
      "num_points",
      "raw_impression",
      "raw_reach",
      "reach",
      "id",
    };

    @Override
    public ReachFrequencyEstimatesCurve parseResponse(String response) throws APIException {
      return ReachFrequencyEstimatesCurve.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ReachFrequencyEstimatesCurve execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ReachFrequencyEstimatesCurve execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ReachFrequencyEstimatesCurve> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ReachFrequencyEstimatesCurve> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ReachFrequencyEstimatesCurve>() {
           public ReachFrequencyEstimatesCurve apply(String result) {
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

    public APIRequestGet requestBudgetField () {
      return this.requestBudgetField(true);
    }
    public APIRequestGet requestBudgetField (boolean value) {
      this.requestField("budget", value);
      return this;
    }
    public APIRequestGet requestClickField () {
      return this.requestClickField(true);
    }
    public APIRequestGet requestClickField (boolean value) {
      this.requestField("click", value);
      return this;
    }
    public APIRequestGet requestConversionField () {
      return this.requestConversionField(true);
    }
    public APIRequestGet requestConversionField (boolean value) {
      this.requestField("conversion", value);
      return this;
    }
    public APIRequestGet requestImpressionField () {
      return this.requestImpressionField(true);
    }
    public APIRequestGet requestImpressionField (boolean value) {
      this.requestField("impression", value);
      return this;
    }
    public APIRequestGet requestInterpolatedReachField () {
      return this.requestInterpolatedReachField(true);
    }
    public APIRequestGet requestInterpolatedReachField (boolean value) {
      this.requestField("interpolated_reach", value);
      return this;
    }
    public APIRequestGet requestNumPointsField () {
      return this.requestNumPointsField(true);
    }
    public APIRequestGet requestNumPointsField (boolean value) {
      this.requestField("num_points", value);
      return this;
    }
    public APIRequestGet requestRawImpressionField () {
      return this.requestRawImpressionField(true);
    }
    public APIRequestGet requestRawImpressionField (boolean value) {
      this.requestField("raw_impression", value);
      return this;
    }
    public APIRequestGet requestRawReachField () {
      return this.requestRawReachField(true);
    }
    public APIRequestGet requestRawReachField (boolean value) {
      this.requestField("raw_reach", value);
      return this;
    }
    public APIRequestGet requestReachField () {
      return this.requestReachField(true);
    }
    public APIRequestGet requestReachField (boolean value) {
      this.requestField("reach", value);
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

  public ReachFrequencyEstimatesCurve copyFrom(ReachFrequencyEstimatesCurve instance) {
    this.mBudget = instance.mBudget;
    this.mClick = instance.mClick;
    this.mConversion = instance.mConversion;
    this.mImpression = instance.mImpression;
    this.mInterpolatedReach = instance.mInterpolatedReach;
    this.mNumPoints = instance.mNumPoints;
    this.mRawImpression = instance.mRawImpression;
    this.mRawReach = instance.mRawReach;
    this.mReach = instance.mReach;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReachFrequencyEstimatesCurve> getParser() {
    return new APIRequest.ResponseParser<ReachFrequencyEstimatesCurve>() {
      public APINodeList<ReachFrequencyEstimatesCurve> parseResponse(String response, APIContext context, APIRequest<ReachFrequencyEstimatesCurve> request) throws MalformedResponseException {
        return ReachFrequencyEstimatesCurve.parseResponse(response, context, request);
      }
    };
  }
}
