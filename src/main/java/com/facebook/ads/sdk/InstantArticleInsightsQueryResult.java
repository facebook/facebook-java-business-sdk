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
public class InstantArticleInsightsQueryResult extends APINode {
  @SerializedName("breakdowns")
  private Map<String, String> mBreakdowns = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("time")
  private String mTime = null;
  @SerializedName("value")
  private String mValue = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  InstantArticleInsightsQueryResult() {
  }

  public InstantArticleInsightsQueryResult(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public InstantArticleInsightsQueryResult(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public InstantArticleInsightsQueryResult fetch() throws APIException{
    InstantArticleInsightsQueryResult newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static InstantArticleInsightsQueryResult fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<InstantArticleInsightsQueryResult> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static InstantArticleInsightsQueryResult fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<InstantArticleInsightsQueryResult> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<InstantArticleInsightsQueryResult> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<InstantArticleInsightsQueryResult>)(
      new APIRequest<InstantArticleInsightsQueryResult>(context, "", "/", "GET", InstantArticleInsightsQueryResult.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<InstantArticleInsightsQueryResult>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", InstantArticleInsightsQueryResult.getParser())
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
  public static InstantArticleInsightsQueryResult loadJSON(String json, APIContext context) {
    InstantArticleInsightsQueryResult instantArticleInsightsQueryResult = getGson().fromJson(json, InstantArticleInsightsQueryResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instantArticleInsightsQueryResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    instantArticleInsightsQueryResult.context = context;
    instantArticleInsightsQueryResult.rawValue = json;
    return instantArticleInsightsQueryResult;
  }

  public static APINodeList<InstantArticleInsightsQueryResult> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<InstantArticleInsightsQueryResult> instantArticleInsightsQueryResults = new APINodeList<InstantArticleInsightsQueryResult>(request, json);
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
          instantArticleInsightsQueryResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return instantArticleInsightsQueryResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instantArticleInsightsQueryResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instantArticleInsightsQueryResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instantArticleInsightsQueryResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instantArticleInsightsQueryResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  instantArticleInsightsQueryResults.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              instantArticleInsightsQueryResults.add(loadJSON(obj.toString(), context));
            }
          }
          return instantArticleInsightsQueryResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instantArticleInsightsQueryResults.add(loadJSON(entry.getValue().toString(), context));
          }
          return instantArticleInsightsQueryResults;
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
              instantArticleInsightsQueryResults.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instantArticleInsightsQueryResults;
          }

          // Sixth, check if it's pure JsonObject
          instantArticleInsightsQueryResults.clear();
          instantArticleInsightsQueryResults.add(loadJSON(json, context));
          return instantArticleInsightsQueryResults;
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


  public Map<String, String> getFieldBreakdowns() {
    return mBreakdowns;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldTime() {
    return mTime;
  }

  public String getFieldValue() {
    return mValue;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<InstantArticleInsightsQueryResult> {

    InstantArticleInsightsQueryResult lastResponse = null;
    @Override
    public InstantArticleInsightsQueryResult getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "breakdowns",
      "name",
      "time",
      "value",
      "id",
    };

    @Override
    public InstantArticleInsightsQueryResult parseResponse(String response) throws APIException {
      return InstantArticleInsightsQueryResult.parseResponse(response, getContext(), this).head();
    }

    @Override
    public InstantArticleInsightsQueryResult execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstantArticleInsightsQueryResult execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<InstantArticleInsightsQueryResult> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstantArticleInsightsQueryResult> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, InstantArticleInsightsQueryResult>() {
           public InstantArticleInsightsQueryResult apply(String result) {
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

    public APIRequestGet requestBreakdownsField () {
      return this.requestBreakdownsField(true);
    }
    public APIRequestGet requestBreakdownsField (boolean value) {
      this.requestField("breakdowns", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestTimeField () {
      return this.requestTimeField(true);
    }
    public APIRequestGet requestTimeField (boolean value) {
      this.requestField("time", value);
      return this;
    }
    public APIRequestGet requestValueField () {
      return this.requestValueField(true);
    }
    public APIRequestGet requestValueField (boolean value) {
      this.requestField("value", value);
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

  public static enum EnumBreakdown {
      @SerializedName("no_breakdown")
      VALUE_NO_BREAKDOWN("no_breakdown"),
      @SerializedName("platform")
      VALUE_PLATFORM("platform"),
      @SerializedName("age")
      VALUE_AGE("age"),
      @SerializedName("region")
      VALUE_REGION("region"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("is_shared_by_ia_owner")
      VALUE_IS_SHARED_BY_IA_OWNER("is_shared_by_ia_owner"),
      @SerializedName("gender")
      VALUE_GENDER("gender"),
      @SerializedName("gender_and_age")
      VALUE_GENDER_AND_AGE("gender_and_age"),
      @SerializedName("is_organic")
      VALUE_IS_ORGANIC("is_organic"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumBreakdown(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPeriod {
      @SerializedName("day")
      VALUE_DAY("day"),
      @SerializedName("week")
      VALUE_WEEK("week"),
      @SerializedName("days_28")
      VALUE_DAYS_28("days_28"),
      @SerializedName("month")
      VALUE_MONTH("month"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumPeriod(String value) {
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

  public InstantArticleInsightsQueryResult copyFrom(InstantArticleInsightsQueryResult instance) {
    this.mBreakdowns = instance.mBreakdowns;
    this.mName = instance.mName;
    this.mTime = instance.mTime;
    this.mValue = instance.mValue;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstantArticleInsightsQueryResult> getParser() {
    return new APIRequest.ResponseParser<InstantArticleInsightsQueryResult>() {
      public APINodeList<InstantArticleInsightsQueryResult> parseResponse(String response, APIContext context, APIRequest<InstantArticleInsightsQueryResult> request) throws MalformedResponseException {
        return InstantArticleInsightsQueryResult.parseResponse(response, context, request);
      }
    };
  }
}
