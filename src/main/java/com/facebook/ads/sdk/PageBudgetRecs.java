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
public class PageBudgetRecs extends APINode {
  @SerializedName("amount_offset")
  private Long mAmountOffset = null;
  @SerializedName("budget_delta")
  private Long mBudgetDelta = null;
  @SerializedName("campaign_length")
  private Long mCampaignLength = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("display_amount")
  private String mDisplayAmount = null;
  @SerializedName("reach")
  private Long mReach = null;
  @SerializedName("reach_interval")
  private Object mReachInterval = null;
  @SerializedName("value")
  private Long mValue = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  PageBudgetRecs() {
  }

  public PageBudgetRecs(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PageBudgetRecs(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PageBudgetRecs fetch() throws APIException{
    PageBudgetRecs newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PageBudgetRecs fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PageBudgetRecs> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PageBudgetRecs fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PageBudgetRecs> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PageBudgetRecs> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PageBudgetRecs>)(
      new APIRequest<PageBudgetRecs>(context, "", "/", "GET", PageBudgetRecs.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PageBudgetRecs>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PageBudgetRecs.getParser())
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
  public static PageBudgetRecs loadJSON(String json, APIContext context) {
    PageBudgetRecs pageBudgetRecs = getGson().fromJson(json, PageBudgetRecs.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageBudgetRecs.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    pageBudgetRecs.context = context;
    pageBudgetRecs.rawValue = json;
    return pageBudgetRecs;
  }

  public static APINodeList<PageBudgetRecs> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<PageBudgetRecs> pageBudgetRecss = new APINodeList<PageBudgetRecs>(request, json);
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
          pageBudgetRecss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return pageBudgetRecss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageBudgetRecss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageBudgetRecss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageBudgetRecss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageBudgetRecss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  pageBudgetRecss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageBudgetRecss.add(loadJSON(obj.toString(), context));
            }
          }
          return pageBudgetRecss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageBudgetRecss.add(loadJSON(entry.getValue().toString(), context));
          }
          return pageBudgetRecss;
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
              pageBudgetRecss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageBudgetRecss;
          }

          // Sixth, check if it's pure JsonObject
          pageBudgetRecss.clear();
          pageBudgetRecss.add(loadJSON(json, context));
          return pageBudgetRecss;
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


  public Long getFieldAmountOffset() {
    return mAmountOffset;
  }

  public Long getFieldBudgetDelta() {
    return mBudgetDelta;
  }

  public Long getFieldCampaignLength() {
    return mCampaignLength;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDisplayAmount() {
    return mDisplayAmount;
  }

  public Long getFieldReach() {
    return mReach;
  }

  public Object getFieldReachInterval() {
    return mReachInterval;
  }

  public Long getFieldValue() {
    return mValue;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<PageBudgetRecs> {

    PageBudgetRecs lastResponse = null;
    @Override
    public PageBudgetRecs getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "amount_offset",
      "budget_delta",
      "campaign_length",
      "currency",
      "display_amount",
      "reach",
      "reach_interval",
      "value",
      "id",
    };

    @Override
    public PageBudgetRecs parseResponse(String response) throws APIException {
      return PageBudgetRecs.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PageBudgetRecs execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageBudgetRecs execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PageBudgetRecs> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageBudgetRecs> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PageBudgetRecs>() {
           public PageBudgetRecs apply(String result) {
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

    public APIRequestGet requestAmountOffsetField () {
      return this.requestAmountOffsetField(true);
    }
    public APIRequestGet requestAmountOffsetField (boolean value) {
      this.requestField("amount_offset", value);
      return this;
    }
    public APIRequestGet requestBudgetDeltaField () {
      return this.requestBudgetDeltaField(true);
    }
    public APIRequestGet requestBudgetDeltaField (boolean value) {
      this.requestField("budget_delta", value);
      return this;
    }
    public APIRequestGet requestCampaignLengthField () {
      return this.requestCampaignLengthField(true);
    }
    public APIRequestGet requestCampaignLengthField (boolean value) {
      this.requestField("campaign_length", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDisplayAmountField () {
      return this.requestDisplayAmountField(true);
    }
    public APIRequestGet requestDisplayAmountField (boolean value) {
      this.requestField("display_amount", value);
      return this;
    }
    public APIRequestGet requestReachField () {
      return this.requestReachField(true);
    }
    public APIRequestGet requestReachField (boolean value) {
      this.requestField("reach", value);
      return this;
    }
    public APIRequestGet requestReachIntervalField () {
      return this.requestReachIntervalField(true);
    }
    public APIRequestGet requestReachIntervalField (boolean value) {
      this.requestField("reach_interval", value);
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

  public PageBudgetRecs copyFrom(PageBudgetRecs instance) {
    this.mAmountOffset = instance.mAmountOffset;
    this.mBudgetDelta = instance.mBudgetDelta;
    this.mCampaignLength = instance.mCampaignLength;
    this.mCurrency = instance.mCurrency;
    this.mDisplayAmount = instance.mDisplayAmount;
    this.mReach = instance.mReach;
    this.mReachInterval = instance.mReachInterval;
    this.mValue = instance.mValue;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageBudgetRecs> getParser() {
    return new APIRequest.ResponseParser<PageBudgetRecs>() {
      public APINodeList<PageBudgetRecs> parseResponse(String response, APIContext context, APIRequest<PageBudgetRecs> request) throws MalformedResponseException {
        return PageBudgetRecs.parseResponse(response, context, request);
      }
    };
  }
}
