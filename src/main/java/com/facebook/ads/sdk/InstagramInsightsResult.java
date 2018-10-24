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
public class InstagramInsightsResult extends APINode {
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("period")
  private String mPeriod = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("values")
  private List<InstagramInsightsValue> mValues = null;
  protected static Gson gson = null;

  InstagramInsightsResult() {
  }

  public InstagramInsightsResult(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public InstagramInsightsResult(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public InstagramInsightsResult fetch() throws APIException{
    InstagramInsightsResult newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static InstagramInsightsResult fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<InstagramInsightsResult> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static InstagramInsightsResult fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<InstagramInsightsResult> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<InstagramInsightsResult> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<InstagramInsightsResult>)(
      new APIRequest<InstagramInsightsResult>(context, "", "/", "GET", InstagramInsightsResult.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<InstagramInsightsResult>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", InstagramInsightsResult.getParser())
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
  public static InstagramInsightsResult loadJSON(String json, APIContext context) {
    InstagramInsightsResult instagramInsightsResult = getGson().fromJson(json, InstagramInsightsResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(instagramInsightsResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    instagramInsightsResult.context = context;
    instagramInsightsResult.rawValue = json;
    return instagramInsightsResult;
  }

  public static APINodeList<InstagramInsightsResult> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<InstagramInsightsResult> instagramInsightsResults = new APINodeList<InstagramInsightsResult>(request, json);
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
          instagramInsightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return instagramInsightsResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                instagramInsightsResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            instagramInsightsResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              instagramInsightsResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              instagramInsightsResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  instagramInsightsResults.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              instagramInsightsResults.add(loadJSON(obj.toString(), context));
            }
          }
          return instagramInsightsResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              instagramInsightsResults.add(loadJSON(entry.getValue().toString(), context));
          }
          return instagramInsightsResults;
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
              instagramInsightsResults.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return instagramInsightsResults;
          }

          // Sixth, check if it's pure JsonObject
          instagramInsightsResults.clear();
          instagramInsightsResults.add(loadJSON(json, context));
          return instagramInsightsResults;
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


  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPeriod() {
    return mPeriod;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public List<InstagramInsightsValue> getFieldValues() {
    return mValues;
  }



  public static class APIRequestGet extends APIRequest<InstagramInsightsResult> {

    InstagramInsightsResult lastResponse = null;
    @Override
    public InstagramInsightsResult getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "description",
      "id",
      "name",
      "period",
      "title",
      "values",
    };

    @Override
    public InstagramInsightsResult parseResponse(String response) throws APIException {
      return InstagramInsightsResult.parseResponse(response, getContext(), this).head();
    }

    @Override
    public InstagramInsightsResult execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public InstagramInsightsResult execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<InstagramInsightsResult> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<InstagramInsightsResult> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, InstagramInsightsResult>() {
           public InstagramInsightsResult apply(String result) {
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

    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPeriodField () {
      return this.requestPeriodField(true);
    }
    public APIRequestGet requestPeriodField (boolean value) {
      this.requestField("period", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestValuesField () {
      return this.requestValuesField(true);
    }
    public APIRequestGet requestValuesField (boolean value) {
      this.requestField("values", value);
      return this;
    }
  }

  public static enum EnumMetric {
      @SerializedName("impressions")
      VALUE_IMPRESSIONS("impressions"),
      @SerializedName("reach")
      VALUE_REACH("reach"),
      @SerializedName("carousel_album_impressions")
      VALUE_CAROUSEL_ALBUM_IMPRESSIONS("carousel_album_impressions"),
      @SerializedName("carousel_album_reach")
      VALUE_CAROUSEL_ALBUM_REACH("carousel_album_reach"),
      @SerializedName("carousel_album_engagement")
      VALUE_CAROUSEL_ALBUM_ENGAGEMENT("carousel_album_engagement"),
      @SerializedName("carousel_album_saved")
      VALUE_CAROUSEL_ALBUM_SAVED("carousel_album_saved"),
      @SerializedName("carousel_album_video_views")
      VALUE_CAROUSEL_ALBUM_VIDEO_VIEWS("carousel_album_video_views"),
      @SerializedName("taps_forward")
      VALUE_TAPS_FORWARD("taps_forward"),
      @SerializedName("taps_back")
      VALUE_TAPS_BACK("taps_back"),
      @SerializedName("exits")
      VALUE_EXITS("exits"),
      @SerializedName("replies")
      VALUE_REPLIES("replies"),
      @SerializedName("engagement")
      VALUE_ENGAGEMENT("engagement"),
      @SerializedName("saved")
      VALUE_SAVED("saved"),
      @SerializedName("video_views")
      VALUE_VIDEO_VIEWS("video_views"),
      NULL(null);

      private String value;

      private EnumMetric(String value) {
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
      NULL(null);

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

  public InstagramInsightsResult copyFrom(InstagramInsightsResult instance) {
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPeriod = instance.mPeriod;
    this.mTitle = instance.mTitle;
    this.mValues = instance.mValues;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<InstagramInsightsResult> getParser() {
    return new APIRequest.ResponseParser<InstagramInsightsResult>() {
      public APINodeList<InstagramInsightsResult> parseResponse(String response, APIContext context, APIRequest<InstagramInsightsResult> request) throws MalformedResponseException {
        return InstagramInsightsResult.parseResponse(response, context, request);
      }
    };
  }
}
