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
public class AudienceInsightsStudySpec extends APINode {
  @SerializedName("audience_definition")
  private Object mAudienceDefinition = null;
  @SerializedName("author_info")
  private Object mAuthorInfo = null;
  @SerializedName("creation_time")
  private Long mCreationTime = null;
  @SerializedName("end_time")
  private Long mEndTime = null;
  @SerializedName("excluded_rules")
  private List<Object> mExcludedRules = null;
  @SerializedName("included_rules")
  private List<Object> mIncludedRules = null;
  @SerializedName("start_time")
  private Long mStartTime = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AudienceInsightsStudySpec() {
  }

  public AudienceInsightsStudySpec(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AudienceInsightsStudySpec(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AudienceInsightsStudySpec fetch() throws APIException{
    AudienceInsightsStudySpec newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AudienceInsightsStudySpec fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AudienceInsightsStudySpec> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AudienceInsightsStudySpec fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AudienceInsightsStudySpec> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AudienceInsightsStudySpec> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AudienceInsightsStudySpec>)(
      new APIRequest<AudienceInsightsStudySpec>(context, "", "/", "GET", AudienceInsightsStudySpec.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AudienceInsightsStudySpec>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AudienceInsightsStudySpec.getParser())
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
  public static AudienceInsightsStudySpec loadJSON(String json, APIContext context) {
    AudienceInsightsStudySpec audienceInsightsStudySpec = getGson().fromJson(json, AudienceInsightsStudySpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(audienceInsightsStudySpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    audienceInsightsStudySpec.context = context;
    audienceInsightsStudySpec.rawValue = json;
    return audienceInsightsStudySpec;
  }

  public static APINodeList<AudienceInsightsStudySpec> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AudienceInsightsStudySpec> audienceInsightsStudySpecs = new APINodeList<AudienceInsightsStudySpec>(request, json);
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
          audienceInsightsStudySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return audienceInsightsStudySpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                audienceInsightsStudySpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            audienceInsightsStudySpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              audienceInsightsStudySpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              audienceInsightsStudySpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  audienceInsightsStudySpecs.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              audienceInsightsStudySpecs.add(loadJSON(obj.toString(), context));
            }
          }
          return audienceInsightsStudySpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              audienceInsightsStudySpecs.add(loadJSON(entry.getValue().toString(), context));
          }
          return audienceInsightsStudySpecs;
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
              audienceInsightsStudySpecs.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return audienceInsightsStudySpecs;
          }

          // Sixth, check if it's pure JsonObject
          audienceInsightsStudySpecs.clear();
          audienceInsightsStudySpecs.add(loadJSON(json, context));
          return audienceInsightsStudySpecs;
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


  public Object getFieldAudienceDefinition() {
    return mAudienceDefinition;
  }

  public Object getFieldAuthorInfo() {
    return mAuthorInfo;
  }

  public Long getFieldCreationTime() {
    return mCreationTime;
  }

  public Long getFieldEndTime() {
    return mEndTime;
  }

  public List<Object> getFieldExcludedRules() {
    return mExcludedRules;
  }

  public List<Object> getFieldIncludedRules() {
    return mIncludedRules;
  }

  public Long getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AudienceInsightsStudySpec> {

    AudienceInsightsStudySpec lastResponse = null;
    @Override
    public AudienceInsightsStudySpec getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "audience_definition",
      "author_info",
      "creation_time",
      "end_time",
      "excluded_rules",
      "included_rules",
      "start_time",
      "status",
      "id",
    };

    @Override
    public AudienceInsightsStudySpec parseResponse(String response) throws APIException {
      return AudienceInsightsStudySpec.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AudienceInsightsStudySpec execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AudienceInsightsStudySpec execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AudienceInsightsStudySpec> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AudienceInsightsStudySpec> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AudienceInsightsStudySpec>() {
           public AudienceInsightsStudySpec apply(String result) {
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

    public APIRequestGet requestAudienceDefinitionField () {
      return this.requestAudienceDefinitionField(true);
    }
    public APIRequestGet requestAudienceDefinitionField (boolean value) {
      this.requestField("audience_definition", value);
      return this;
    }
    public APIRequestGet requestAuthorInfoField () {
      return this.requestAuthorInfoField(true);
    }
    public APIRequestGet requestAuthorInfoField (boolean value) {
      this.requestField("author_info", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestExcludedRulesField () {
      return this.requestExcludedRulesField(true);
    }
    public APIRequestGet requestExcludedRulesField (boolean value) {
      this.requestField("excluded_rules", value);
      return this;
    }
    public APIRequestGet requestIncludedRulesField () {
      return this.requestIncludedRulesField(true);
    }
    public APIRequestGet requestIncludedRulesField (boolean value) {
      this.requestField("included_rules", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
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

  public AudienceInsightsStudySpec copyFrom(AudienceInsightsStudySpec instance) {
    this.mAudienceDefinition = instance.mAudienceDefinition;
    this.mAuthorInfo = instance.mAuthorInfo;
    this.mCreationTime = instance.mCreationTime;
    this.mEndTime = instance.mEndTime;
    this.mExcludedRules = instance.mExcludedRules;
    this.mIncludedRules = instance.mIncludedRules;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AudienceInsightsStudySpec> getParser() {
    return new APIRequest.ResponseParser<AudienceInsightsStudySpec>() {
      public APINodeList<AudienceInsightsStudySpec> parseResponse(String response, APIContext context, APIRequest<AudienceInsightsStudySpec> request) throws MalformedResponseException {
        return AudienceInsightsStudySpec.parseResponse(response, context, request);
      }
    };
  }
}
