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
public class ReachFrequencyCurveUpperConfidenceRange extends APINode {
  @SerializedName("impression_upper")
  private List<Long> mImpressionUpper = null;
  @SerializedName("num_points")
  private Long mNumPoints = null;
  @SerializedName("reach")
  private List<Long> mReach = null;
  @SerializedName("reach_upper")
  private List<Long> mReachUpper = null;
  @SerializedName("uniq_video_views_2s_upper")
  private List<Long> mUniqVideoViews2sUpper = null;
  @SerializedName("video_views_2s_upper")
  private List<Long> mVideoViews2sUpper = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ReachFrequencyCurveUpperConfidenceRange() {
  }

  public ReachFrequencyCurveUpperConfidenceRange(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ReachFrequencyCurveUpperConfidenceRange(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ReachFrequencyCurveUpperConfidenceRange fetch() throws APIException{
    ReachFrequencyCurveUpperConfidenceRange newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ReachFrequencyCurveUpperConfidenceRange fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ReachFrequencyCurveUpperConfidenceRange> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ReachFrequencyCurveUpperConfidenceRange fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ReachFrequencyCurveUpperConfidenceRange> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ReachFrequencyCurveUpperConfidenceRange> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ReachFrequencyCurveUpperConfidenceRange>)(
      new APIRequest<ReachFrequencyCurveUpperConfidenceRange>(context, "", "/", "GET", ReachFrequencyCurveUpperConfidenceRange.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ReachFrequencyCurveUpperConfidenceRange>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ReachFrequencyCurveUpperConfidenceRange.getParser())
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
  public static ReachFrequencyCurveUpperConfidenceRange loadJSON(String json, APIContext context) {
    ReachFrequencyCurveUpperConfidenceRange reachFrequencyCurveUpperConfidenceRange = getGson().fromJson(json, ReachFrequencyCurveUpperConfidenceRange.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(reachFrequencyCurveUpperConfidenceRange.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    reachFrequencyCurveUpperConfidenceRange.context = context;
    reachFrequencyCurveUpperConfidenceRange.rawValue = json;
    return reachFrequencyCurveUpperConfidenceRange;
  }

  public static APINodeList<ReachFrequencyCurveUpperConfidenceRange> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ReachFrequencyCurveUpperConfidenceRange> reachFrequencyCurveUpperConfidenceRanges = new APINodeList<ReachFrequencyCurveUpperConfidenceRange>(request, json);
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
          reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return reachFrequencyCurveUpperConfidenceRanges;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                reachFrequencyCurveUpperConfidenceRanges.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            reachFrequencyCurveUpperConfidenceRanges.setPaging(previous, next);
            if (context.hasAppSecret()) {
              reachFrequencyCurveUpperConfidenceRanges.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(obj.toString(), context));
            }
          }
          return reachFrequencyCurveUpperConfidenceRanges;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(entry.getValue().toString(), context));
          }
          return reachFrequencyCurveUpperConfidenceRanges;
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
              reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return reachFrequencyCurveUpperConfidenceRanges;
          }

          // Sixth, check if it's pure JsonObject
          reachFrequencyCurveUpperConfidenceRanges.clear();
          reachFrequencyCurveUpperConfidenceRanges.add(loadJSON(json, context));
          return reachFrequencyCurveUpperConfidenceRanges;
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


  public List<Long> getFieldImpressionUpper() {
    return mImpressionUpper;
  }

  public Long getFieldNumPoints() {
    return mNumPoints;
  }

  public List<Long> getFieldReach() {
    return mReach;
  }

  public List<Long> getFieldReachUpper() {
    return mReachUpper;
  }

  public List<Long> getFieldUniqVideoViews2sUpper() {
    return mUniqVideoViews2sUpper;
  }

  public List<Long> getFieldVideoViews2sUpper() {
    return mVideoViews2sUpper;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ReachFrequencyCurveUpperConfidenceRange> {

    ReachFrequencyCurveUpperConfidenceRange lastResponse = null;
    @Override
    public ReachFrequencyCurveUpperConfidenceRange getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "impression_upper",
      "num_points",
      "reach",
      "reach_upper",
      "uniq_video_views_2s_upper",
      "video_views_2s_upper",
      "id",
    };

    @Override
    public ReachFrequencyCurveUpperConfidenceRange parseResponse(String response) throws APIException {
      return ReachFrequencyCurveUpperConfidenceRange.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ReachFrequencyCurveUpperConfidenceRange execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ReachFrequencyCurveUpperConfidenceRange execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ReachFrequencyCurveUpperConfidenceRange> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ReachFrequencyCurveUpperConfidenceRange> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ReachFrequencyCurveUpperConfidenceRange>() {
           public ReachFrequencyCurveUpperConfidenceRange apply(String result) {
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

    public APIRequestGet requestImpressionUpperField () {
      return this.requestImpressionUpperField(true);
    }
    public APIRequestGet requestImpressionUpperField (boolean value) {
      this.requestField("impression_upper", value);
      return this;
    }
    public APIRequestGet requestNumPointsField () {
      return this.requestNumPointsField(true);
    }
    public APIRequestGet requestNumPointsField (boolean value) {
      this.requestField("num_points", value);
      return this;
    }
    public APIRequestGet requestReachField () {
      return this.requestReachField(true);
    }
    public APIRequestGet requestReachField (boolean value) {
      this.requestField("reach", value);
      return this;
    }
    public APIRequestGet requestReachUpperField () {
      return this.requestReachUpperField(true);
    }
    public APIRequestGet requestReachUpperField (boolean value) {
      this.requestField("reach_upper", value);
      return this;
    }
    public APIRequestGet requestUniqVideoViews2sUpperField () {
      return this.requestUniqVideoViews2sUpperField(true);
    }
    public APIRequestGet requestUniqVideoViews2sUpperField (boolean value) {
      this.requestField("uniq_video_views_2s_upper", value);
      return this;
    }
    public APIRequestGet requestVideoViews2sUpperField () {
      return this.requestVideoViews2sUpperField(true);
    }
    public APIRequestGet requestVideoViews2sUpperField (boolean value) {
      this.requestField("video_views_2s_upper", value);
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

  public ReachFrequencyCurveUpperConfidenceRange copyFrom(ReachFrequencyCurveUpperConfidenceRange instance) {
    this.mImpressionUpper = instance.mImpressionUpper;
    this.mNumPoints = instance.mNumPoints;
    this.mReach = instance.mReach;
    this.mReachUpper = instance.mReachUpper;
    this.mUniqVideoViews2sUpper = instance.mUniqVideoViews2sUpper;
    this.mVideoViews2sUpper = instance.mVideoViews2sUpper;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReachFrequencyCurveUpperConfidenceRange> getParser() {
    return new APIRequest.ResponseParser<ReachFrequencyCurveUpperConfidenceRange>() {
      public APINodeList<ReachFrequencyCurveUpperConfidenceRange> parseResponse(String response, APIContext context, APIRequest<ReachFrequencyCurveUpperConfidenceRange> request) throws MalformedResponseException {
        return ReachFrequencyCurveUpperConfidenceRange.parseResponse(response, context, request);
      }
    };
  }
}
