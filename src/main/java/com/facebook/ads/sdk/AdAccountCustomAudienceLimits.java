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
public class AdAccountCustomAudienceLimits extends APINode {
  @SerializedName("audience_update_quota_in_total")
  private Long mAudienceUpdateQuotaInTotal = null;
  @SerializedName("audience_update_quota_left")
  private Double mAudienceUpdateQuotaLeft = null;
  @SerializedName("has_hit_audience_update_limit")
  private Boolean mHasHitAudienceUpdateLimit = null;
  @SerializedName("next_audience_update_available_time")
  private String mNextAudienceUpdateAvailableTime = null;
  @SerializedName("rate_limit_reset_time")
  private String mRateLimitResetTime = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdAccountCustomAudienceLimits() {
  }

  public AdAccountCustomAudienceLimits(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountCustomAudienceLimits(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAccountCustomAudienceLimits fetch() throws APIException{
    AdAccountCustomAudienceLimits newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountCustomAudienceLimits fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountCustomAudienceLimits> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountCustomAudienceLimits fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAccountCustomAudienceLimits> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAccountCustomAudienceLimits> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountCustomAudienceLimits>)(
      new APIRequest<AdAccountCustomAudienceLimits>(context, "", "/", "GET", AdAccountCustomAudienceLimits.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountCustomAudienceLimits>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAccountCustomAudienceLimits.getParser())
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
  public static AdAccountCustomAudienceLimits loadJSON(String json, APIContext context) {
    AdAccountCustomAudienceLimits adAccountCustomAudienceLimits = getGson().fromJson(json, AdAccountCustomAudienceLimits.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountCustomAudienceLimits.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccountCustomAudienceLimits.context = context;
    adAccountCustomAudienceLimits.rawValue = json;
    return adAccountCustomAudienceLimits;
  }

  public static APINodeList<AdAccountCustomAudienceLimits> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAccountCustomAudienceLimits> adAccountCustomAudienceLimitss = new APINodeList<AdAccountCustomAudienceLimits>(request, json);
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
          adAccountCustomAudienceLimitss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAccountCustomAudienceLimitss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountCustomAudienceLimitss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountCustomAudienceLimitss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountCustomAudienceLimitss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountCustomAudienceLimitss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAccountCustomAudienceLimitss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountCustomAudienceLimitss.add(loadJSON(obj.toString(), context));
            }
          }
          return adAccountCustomAudienceLimitss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountCustomAudienceLimitss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAccountCustomAudienceLimitss;
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
              adAccountCustomAudienceLimitss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountCustomAudienceLimitss;
          }

          // Sixth, check if it's pure JsonObject
          adAccountCustomAudienceLimitss.clear();
          adAccountCustomAudienceLimitss.add(loadJSON(json, context));
          return adAccountCustomAudienceLimitss;
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


  public Long getFieldAudienceUpdateQuotaInTotal() {
    return mAudienceUpdateQuotaInTotal;
  }

  public Double getFieldAudienceUpdateQuotaLeft() {
    return mAudienceUpdateQuotaLeft;
  }

  public Boolean getFieldHasHitAudienceUpdateLimit() {
    return mHasHitAudienceUpdateLimit;
  }

  public String getFieldNextAudienceUpdateAvailableTime() {
    return mNextAudienceUpdateAvailableTime;
  }

  public String getFieldRateLimitResetTime() {
    return mRateLimitResetTime;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdAccountCustomAudienceLimits> {

    AdAccountCustomAudienceLimits lastResponse = null;
    @Override
    public AdAccountCustomAudienceLimits getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "audience_update_quota_in_total",
      "audience_update_quota_left",
      "has_hit_audience_update_limit",
      "next_audience_update_available_time",
      "rate_limit_reset_time",
      "id",
    };

    @Override
    public AdAccountCustomAudienceLimits parseResponse(String response) throws APIException {
      return AdAccountCustomAudienceLimits.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountCustomAudienceLimits execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountCustomAudienceLimits execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountCustomAudienceLimits> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountCustomAudienceLimits> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountCustomAudienceLimits>() {
           public AdAccountCustomAudienceLimits apply(String result) {
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

    public APIRequestGet requestAudienceUpdateQuotaInTotalField () {
      return this.requestAudienceUpdateQuotaInTotalField(true);
    }
    public APIRequestGet requestAudienceUpdateQuotaInTotalField (boolean value) {
      this.requestField("audience_update_quota_in_total", value);
      return this;
    }
    public APIRequestGet requestAudienceUpdateQuotaLeftField () {
      return this.requestAudienceUpdateQuotaLeftField(true);
    }
    public APIRequestGet requestAudienceUpdateQuotaLeftField (boolean value) {
      this.requestField("audience_update_quota_left", value);
      return this;
    }
    public APIRequestGet requestHasHitAudienceUpdateLimitField () {
      return this.requestHasHitAudienceUpdateLimitField(true);
    }
    public APIRequestGet requestHasHitAudienceUpdateLimitField (boolean value) {
      this.requestField("has_hit_audience_update_limit", value);
      return this;
    }
    public APIRequestGet requestNextAudienceUpdateAvailableTimeField () {
      return this.requestNextAudienceUpdateAvailableTimeField(true);
    }
    public APIRequestGet requestNextAudienceUpdateAvailableTimeField (boolean value) {
      this.requestField("next_audience_update_available_time", value);
      return this;
    }
    public APIRequestGet requestRateLimitResetTimeField () {
      return this.requestRateLimitResetTimeField(true);
    }
    public APIRequestGet requestRateLimitResetTimeField (boolean value) {
      this.requestField("rate_limit_reset_time", value);
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

  public AdAccountCustomAudienceLimits copyFrom(AdAccountCustomAudienceLimits instance) {
    this.mAudienceUpdateQuotaInTotal = instance.mAudienceUpdateQuotaInTotal;
    this.mAudienceUpdateQuotaLeft = instance.mAudienceUpdateQuotaLeft;
    this.mHasHitAudienceUpdateLimit = instance.mHasHitAudienceUpdateLimit;
    this.mNextAudienceUpdateAvailableTime = instance.mNextAudienceUpdateAvailableTime;
    this.mRateLimitResetTime = instance.mRateLimitResetTime;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountCustomAudienceLimits> getParser() {
    return new APIRequest.ResponseParser<AdAccountCustomAudienceLimits>() {
      public APINodeList<AdAccountCustomAudienceLimits> parseResponse(String response, APIContext context, APIRequest<AdAccountCustomAudienceLimits> request) throws MalformedResponseException {
        return AdAccountCustomAudienceLimits.parseResponse(response, context, request);
      }
    };
  }
}
