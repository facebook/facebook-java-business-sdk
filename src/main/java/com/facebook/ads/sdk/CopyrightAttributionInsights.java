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
public class CopyrightAttributionInsights extends APINode {
  @SerializedName("l7_attribution_page_view")
  private Long mL7AttributionPageView = null;
  @SerializedName("l7_attribution_page_view_delta")
  private Double mL7AttributionPageViewDelta = null;
  @SerializedName("l7_attribution_video_view")
  private Long mL7AttributionVideoView = null;
  @SerializedName("l7_attribution_video_view_delta")
  private Double mL7AttributionVideoViewDelta = null;
  @SerializedName("metrics_ending_date")
  private String mMetricsEndingDate = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  CopyrightAttributionInsights() {
  }

  public CopyrightAttributionInsights(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CopyrightAttributionInsights(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CopyrightAttributionInsights fetch() throws APIException{
    CopyrightAttributionInsights newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CopyrightAttributionInsights fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CopyrightAttributionInsights> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CopyrightAttributionInsights fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CopyrightAttributionInsights> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CopyrightAttributionInsights> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CopyrightAttributionInsights>)(
      new APIRequest<CopyrightAttributionInsights>(context, "", "/", "GET", CopyrightAttributionInsights.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CopyrightAttributionInsights>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CopyrightAttributionInsights.getParser())
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
  public static CopyrightAttributionInsights loadJSON(String json, APIContext context) {
    CopyrightAttributionInsights copyrightAttributionInsights = getGson().fromJson(json, CopyrightAttributionInsights.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(copyrightAttributionInsights.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    copyrightAttributionInsights.context = context;
    copyrightAttributionInsights.rawValue = json;
    return copyrightAttributionInsights;
  }

  public static APINodeList<CopyrightAttributionInsights> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<CopyrightAttributionInsights> copyrightAttributionInsightss = new APINodeList<CopyrightAttributionInsights>(request, json);
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
          copyrightAttributionInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return copyrightAttributionInsightss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                copyrightAttributionInsightss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            copyrightAttributionInsightss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              copyrightAttributionInsightss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              copyrightAttributionInsightss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  copyrightAttributionInsightss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              copyrightAttributionInsightss.add(loadJSON(obj.toString(), context));
            }
          }
          return copyrightAttributionInsightss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              copyrightAttributionInsightss.add(loadJSON(entry.getValue().toString(), context));
          }
          return copyrightAttributionInsightss;
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
              copyrightAttributionInsightss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return copyrightAttributionInsightss;
          }

          // Sixth, check if it's pure JsonObject
          copyrightAttributionInsightss.clear();
          copyrightAttributionInsightss.add(loadJSON(json, context));
          return copyrightAttributionInsightss;
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


  public Long getFieldL7AttributionPageView() {
    return mL7AttributionPageView;
  }

  public Double getFieldL7AttributionPageViewDelta() {
    return mL7AttributionPageViewDelta;
  }

  public Long getFieldL7AttributionVideoView() {
    return mL7AttributionVideoView;
  }

  public Double getFieldL7AttributionVideoViewDelta() {
    return mL7AttributionVideoViewDelta;
  }

  public String getFieldMetricsEndingDate() {
    return mMetricsEndingDate;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<CopyrightAttributionInsights> {

    CopyrightAttributionInsights lastResponse = null;
    @Override
    public CopyrightAttributionInsights getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "l7_attribution_page_view",
      "l7_attribution_page_view_delta",
      "l7_attribution_video_view",
      "l7_attribution_video_view_delta",
      "metrics_ending_date",
      "id",
    };

    @Override
    public CopyrightAttributionInsights parseResponse(String response) throws APIException {
      return CopyrightAttributionInsights.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CopyrightAttributionInsights execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CopyrightAttributionInsights execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CopyrightAttributionInsights> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CopyrightAttributionInsights> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CopyrightAttributionInsights>() {
           public CopyrightAttributionInsights apply(String result) {
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

    public APIRequestGet requestL7AttributionPageViewField () {
      return this.requestL7AttributionPageViewField(true);
    }
    public APIRequestGet requestL7AttributionPageViewField (boolean value) {
      this.requestField("l7_attribution_page_view", value);
      return this;
    }
    public APIRequestGet requestL7AttributionPageViewDeltaField () {
      return this.requestL7AttributionPageViewDeltaField(true);
    }
    public APIRequestGet requestL7AttributionPageViewDeltaField (boolean value) {
      this.requestField("l7_attribution_page_view_delta", value);
      return this;
    }
    public APIRequestGet requestL7AttributionVideoViewField () {
      return this.requestL7AttributionVideoViewField(true);
    }
    public APIRequestGet requestL7AttributionVideoViewField (boolean value) {
      this.requestField("l7_attribution_video_view", value);
      return this;
    }
    public APIRequestGet requestL7AttributionVideoViewDeltaField () {
      return this.requestL7AttributionVideoViewDeltaField(true);
    }
    public APIRequestGet requestL7AttributionVideoViewDeltaField (boolean value) {
      this.requestField("l7_attribution_video_view_delta", value);
      return this;
    }
    public APIRequestGet requestMetricsEndingDateField () {
      return this.requestMetricsEndingDateField(true);
    }
    public APIRequestGet requestMetricsEndingDateField (boolean value) {
      this.requestField("metrics_ending_date", value);
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

  public CopyrightAttributionInsights copyFrom(CopyrightAttributionInsights instance) {
    this.mL7AttributionPageView = instance.mL7AttributionPageView;
    this.mL7AttributionPageViewDelta = instance.mL7AttributionPageViewDelta;
    this.mL7AttributionVideoView = instance.mL7AttributionVideoView;
    this.mL7AttributionVideoViewDelta = instance.mL7AttributionVideoViewDelta;
    this.mMetricsEndingDate = instance.mMetricsEndingDate;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CopyrightAttributionInsights> getParser() {
    return new APIRequest.ResponseParser<CopyrightAttributionInsights>() {
      public APINodeList<CopyrightAttributionInsights> parseResponse(String response, APIContext context, APIRequest<CopyrightAttributionInsights> request) throws MalformedResponseException {
        return CopyrightAttributionInsights.parseResponse(response, context, request);
      }
    };
  }
}
