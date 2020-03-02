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
public class IterativeSplitTestConfig extends APINode {
  @SerializedName("budget")
  private Long mBudget = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("guidance")
  private Object mGuidance = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("iterative_split_test_original_variant_id")
  private String mIterativeSplitTestOriginalVariantId = null;
  @SerializedName("iterative_split_test_variant_to_split_mapping")
  private Map<String, Long> mIterativeSplitTestVariantToSplitMapping = null;
  @SerializedName("results_window")
  private Object mResultsWindow = null;
  @SerializedName("splits")
  private List<Long> mSplits = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  protected static Gson gson = null;

  IterativeSplitTestConfig() {
  }

  public IterativeSplitTestConfig(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public IterativeSplitTestConfig(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public IterativeSplitTestConfig fetch() throws APIException{
    IterativeSplitTestConfig newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static IterativeSplitTestConfig fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<IterativeSplitTestConfig> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static IterativeSplitTestConfig fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<IterativeSplitTestConfig> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<IterativeSplitTestConfig> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<IterativeSplitTestConfig>)(
      new APIRequest<IterativeSplitTestConfig>(context, "", "/", "GET", IterativeSplitTestConfig.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<IterativeSplitTestConfig>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", IterativeSplitTestConfig.getParser())
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
  public static IterativeSplitTestConfig loadJSON(String json, APIContext context, String header) {
    IterativeSplitTestConfig iterativeSplitTestConfig = getGson().fromJson(json, IterativeSplitTestConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(iterativeSplitTestConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    iterativeSplitTestConfig.context = context;
    iterativeSplitTestConfig.rawValue = json;
    iterativeSplitTestConfig.header = header;
    return iterativeSplitTestConfig;
  }

  public static APINodeList<IterativeSplitTestConfig> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<IterativeSplitTestConfig> iterativeSplitTestConfigs = new APINodeList<IterativeSplitTestConfig>(request, json, header);
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
          iterativeSplitTestConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return iterativeSplitTestConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                iterativeSplitTestConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            iterativeSplitTestConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              iterativeSplitTestConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              iterativeSplitTestConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  iterativeSplitTestConfigs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              iterativeSplitTestConfigs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return iterativeSplitTestConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              iterativeSplitTestConfigs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return iterativeSplitTestConfigs;
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
              iterativeSplitTestConfigs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return iterativeSplitTestConfigs;
          }

          // Sixth, check if it's pure JsonObject
          iterativeSplitTestConfigs.clear();
          iterativeSplitTestConfigs.add(loadJSON(json, context, header));
          return iterativeSplitTestConfigs;
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


  public Long getFieldBudget() {
    return mBudget;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public Object getFieldGuidance() {
    return mGuidance;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIterativeSplitTestOriginalVariantId() {
    return mIterativeSplitTestOriginalVariantId;
  }

  public Map<String, Long> getFieldIterativeSplitTestVariantToSplitMapping() {
    return mIterativeSplitTestVariantToSplitMapping;
  }

  public Object getFieldResultsWindow() {
    return mResultsWindow;
  }

  public List<Long> getFieldSplits() {
    return mSplits;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }



  public static class APIRequestGet extends APIRequest<IterativeSplitTestConfig> {

    IterativeSplitTestConfig lastResponse = null;
    @Override
    public IterativeSplitTestConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "budget",
      "end_time",
      "guidance",
      "id",
      "iterative_split_test_original_variant_id",
      "iterative_split_test_variant_to_split_mapping",
      "results_window",
      "splits",
      "start_time",
    };

    @Override
    public IterativeSplitTestConfig parseResponse(String response, String header) throws APIException {
      return IterativeSplitTestConfig.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public IterativeSplitTestConfig execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public IterativeSplitTestConfig execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<IterativeSplitTestConfig> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<IterativeSplitTestConfig> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, IterativeSplitTestConfig>() {
           public IterativeSplitTestConfig apply(ResponseWrapper result) {
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

    public APIRequestGet requestBudgetField () {
      return this.requestBudgetField(true);
    }
    public APIRequestGet requestBudgetField (boolean value) {
      this.requestField("budget", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestGuidanceField () {
      return this.requestGuidanceField(true);
    }
    public APIRequestGet requestGuidanceField (boolean value) {
      this.requestField("guidance", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIterativeSplitTestOriginalVariantIdField () {
      return this.requestIterativeSplitTestOriginalVariantIdField(true);
    }
    public APIRequestGet requestIterativeSplitTestOriginalVariantIdField (boolean value) {
      this.requestField("iterative_split_test_original_variant_id", value);
      return this;
    }
    public APIRequestGet requestIterativeSplitTestVariantToSplitMappingField () {
      return this.requestIterativeSplitTestVariantToSplitMappingField(true);
    }
    public APIRequestGet requestIterativeSplitTestVariantToSplitMappingField (boolean value) {
      this.requestField("iterative_split_test_variant_to_split_mapping", value);
      return this;
    }
    public APIRequestGet requestResultsWindowField () {
      return this.requestResultsWindowField(true);
    }
    public APIRequestGet requestResultsWindowField (boolean value) {
      this.requestField("results_window", value);
      return this;
    }
    public APIRequestGet requestSplitsField () {
      return this.requestSplitsField(true);
    }
    public APIRequestGet requestSplitsField (boolean value) {
      this.requestField("splits", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
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

  public IterativeSplitTestConfig copyFrom(IterativeSplitTestConfig instance) {
    this.mBudget = instance.mBudget;
    this.mEndTime = instance.mEndTime;
    this.mGuidance = instance.mGuidance;
    this.mId = instance.mId;
    this.mIterativeSplitTestOriginalVariantId = instance.mIterativeSplitTestOriginalVariantId;
    this.mIterativeSplitTestVariantToSplitMapping = instance.mIterativeSplitTestVariantToSplitMapping;
    this.mResultsWindow = instance.mResultsWindow;
    this.mSplits = instance.mSplits;
    this.mStartTime = instance.mStartTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<IterativeSplitTestConfig> getParser() {
    return new APIRequest.ResponseParser<IterativeSplitTestConfig>() {
      public APINodeList<IterativeSplitTestConfig> parseResponse(String response, APIContext context, APIRequest<IterativeSplitTestConfig> request, String header) throws MalformedResponseException {
        return IterativeSplitTestConfig.parseResponse(response, context, request, header);
      }
    };
  }
}
