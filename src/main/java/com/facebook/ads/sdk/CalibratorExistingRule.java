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
public class CalibratorExistingRule extends APINode {
  @SerializedName("7d_volume")
  private Long m7dVolume = null;
  @SerializedName("creation_source")
  private String mCreationSource = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("creator")
  private String mCreator = null;
  @SerializedName("event_type")
  private String mEventType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("rule")
  private String mRule = null;
  @SerializedName("rule_type")
  private String mRuleType = null;
  @SerializedName("sample_urls")
  private List<String> mSampleUrls = null;
  @SerializedName("status")
  private String mStatus = null;
  protected static Gson gson = null;

  CalibratorExistingRule() {
  }

  public CalibratorExistingRule(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CalibratorExistingRule(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CalibratorExistingRule fetch() throws APIException{
    CalibratorExistingRule newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CalibratorExistingRule fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CalibratorExistingRule> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CalibratorExistingRule fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CalibratorExistingRule> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CalibratorExistingRule> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CalibratorExistingRule>)(
      new APIRequest<CalibratorExistingRule>(context, "", "/", "GET", CalibratorExistingRule.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CalibratorExistingRule>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CalibratorExistingRule.getParser())
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
  public static CalibratorExistingRule loadJSON(String json, APIContext context) {
    CalibratorExistingRule calibratorExistingRule = getGson().fromJson(json, CalibratorExistingRule.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(calibratorExistingRule.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    calibratorExistingRule.context = context;
    calibratorExistingRule.rawValue = json;
    return calibratorExistingRule;
  }

  public static APINodeList<CalibratorExistingRule> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<CalibratorExistingRule> calibratorExistingRules = new APINodeList<CalibratorExistingRule>(request, json);
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
          calibratorExistingRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return calibratorExistingRules;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                calibratorExistingRules.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            calibratorExistingRules.setPaging(previous, next);
            if (context.hasAppSecret()) {
              calibratorExistingRules.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              calibratorExistingRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  calibratorExistingRules.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              calibratorExistingRules.add(loadJSON(obj.toString(), context));
            }
          }
          return calibratorExistingRules;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              calibratorExistingRules.add(loadJSON(entry.getValue().toString(), context));
          }
          return calibratorExistingRules;
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
              calibratorExistingRules.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return calibratorExistingRules;
          }

          // Sixth, check if it's pure JsonObject
          calibratorExistingRules.clear();
          calibratorExistingRules.add(loadJSON(json, context));
          return calibratorExistingRules;
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

  public APIRequestGetActivities getActivities() {
    return new APIRequestGetActivities(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Long getField7dVolume() {
    return m7dVolume;
  }

  public String getFieldCreationSource() {
    return mCreationSource;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldCreator() {
    return mCreator;
  }

  public String getFieldEventType() {
    return mEventType;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldRule() {
    return mRule;
  }

  public String getFieldRuleType() {
    return mRuleType;
  }

  public List<String> getFieldSampleUrls() {
    return mSampleUrls;
  }

  public String getFieldStatus() {
    return mStatus;
  }



  public static class APIRequestGetActivities extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "start_time",
      "end_time",
      "event_type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetActivities.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetActivities(String nodeId, APIContext context) {
      super(context, nodeId, "/activities", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetActivities setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetActivities setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetActivities setStartTime (Object startTime) {
      this.setParam("start_time", startTime);
      return this;
    }
    public APIRequestGetActivities setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestGetActivities setEndTime (Object endTime) {
      this.setParam("end_time", endTime);
      return this;
    }
    public APIRequestGetActivities setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestGetActivities setEventType (EnumEventType eventType) {
      this.setParam("event_type", eventType);
      return this;
    }
    public APIRequestGetActivities setEventType (String eventType) {
      this.setParam("event_type", eventType);
      return this;
    }

    public APIRequestGetActivities requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetActivities requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetActivities requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetActivities requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetActivities requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetActivities requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<CalibratorExistingRule> {

    CalibratorExistingRule lastResponse = null;
    @Override
    public CalibratorExistingRule getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "7d_volume",
      "creation_source",
      "creation_time",
      "creator",
      "event_type",
      "id",
      "rule",
      "rule_type",
      "sample_urls",
      "status",
    };

    @Override
    public CalibratorExistingRule parseResponse(String response) throws APIException {
      return CalibratorExistingRule.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CalibratorExistingRule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CalibratorExistingRule execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CalibratorExistingRule> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CalibratorExistingRule> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CalibratorExistingRule>() {
           public CalibratorExistingRule apply(String result) {
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

    public APIRequestGet request7dVolumeField () {
      return this.request7dVolumeField(true);
    }
    public APIRequestGet request7dVolumeField (boolean value) {
      this.requestField("7d_volume", value);
      return this;
    }
    public APIRequestGet requestCreationSourceField () {
      return this.requestCreationSourceField(true);
    }
    public APIRequestGet requestCreationSourceField (boolean value) {
      this.requestField("creation_source", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGet requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestRuleField () {
      return this.requestRuleField(true);
    }
    public APIRequestGet requestRuleField (boolean value) {
      this.requestField("rule", value);
      return this;
    }
    public APIRequestGet requestRuleTypeField () {
      return this.requestRuleTypeField(true);
    }
    public APIRequestGet requestRuleTypeField (boolean value) {
      this.requestField("rule_type", value);
      return this;
    }
    public APIRequestGet requestSampleUrlsField () {
      return this.requestSampleUrlsField(true);
    }
    public APIRequestGet requestSampleUrlsField (boolean value) {
      this.requestField("sample_urls", value);
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

  public static enum EnumEventType {
      @SerializedName("RULE_CREATE")
      VALUE_RULE_CREATE("RULE_CREATE"),
      @SerializedName("RULE_EVENT_REMAPPING")
      VALUE_RULE_EVENT_REMAPPING("RULE_EVENT_REMAPPING"),
      @SerializedName("RULE_STATUS_UPDATE")
      VALUE_RULE_STATUS_UPDATE("RULE_STATUS_UPDATE"),
      NULL(null);

      private String value;

      private EnumEventType(String value) {
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

  public CalibratorExistingRule copyFrom(CalibratorExistingRule instance) {
    this.m7dVolume = instance.m7dVolume;
    this.mCreationSource = instance.mCreationSource;
    this.mCreationTime = instance.mCreationTime;
    this.mCreator = instance.mCreator;
    this.mEventType = instance.mEventType;
    this.mId = instance.mId;
    this.mRule = instance.mRule;
    this.mRuleType = instance.mRuleType;
    this.mSampleUrls = instance.mSampleUrls;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CalibratorExistingRule> getParser() {
    return new APIRequest.ResponseParser<CalibratorExistingRule>() {
      public APINodeList<CalibratorExistingRule> parseResponse(String response, APIContext context, APIRequest<CalibratorExistingRule> request) throws MalformedResponseException {
        return CalibratorExistingRule.parseResponse(response, context, request);
      }
    };
  }
}
