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
public class ReachFrequencyActivity extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("campaign_active")
  private Boolean mCampaignActive = null;
  @SerializedName("campaign_started")
  private Boolean mCampaignStarted = null;
  @SerializedName("creative_uploaded")
  private Boolean mCreativeUploaded = null;
  @SerializedName("delivered_budget")
  private Long mDeliveredBudget = null;
  @SerializedName("delivered_daily_grp")
  private List<Double> mDeliveredDailyGrp = null;
  @SerializedName("delivered_daily_impression")
  private List<Double> mDeliveredDailyImpression = null;
  @SerializedName("delivered_impression")
  private Long mDeliveredImpression = null;
  @SerializedName("delivered_reach")
  private Long mDeliveredReach = null;
  @SerializedName("delivered_total_impression")
  private Long mDeliveredTotalImpression = null;
  @SerializedName("io_approved")
  private Boolean mIoApproved = null;
  @SerializedName("sf_link")
  private String mSfLink = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ReachFrequencyActivity() {
  }

  public ReachFrequencyActivity(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ReachFrequencyActivity(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ReachFrequencyActivity fetch() throws APIException{
    ReachFrequencyActivity newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ReachFrequencyActivity fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ReachFrequencyActivity> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ReachFrequencyActivity fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ReachFrequencyActivity> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ReachFrequencyActivity> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ReachFrequencyActivity>)(
      new APIRequest<ReachFrequencyActivity>(context, "", "/", "GET", ReachFrequencyActivity.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ReachFrequencyActivity>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ReachFrequencyActivity.getParser())
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
  public static ReachFrequencyActivity loadJSON(String json, APIContext context) {
    ReachFrequencyActivity reachFrequencyActivity = getGson().fromJson(json, ReachFrequencyActivity.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(reachFrequencyActivity.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    reachFrequencyActivity.context = context;
    reachFrequencyActivity.rawValue = json;
    return reachFrequencyActivity;
  }

  public static APINodeList<ReachFrequencyActivity> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ReachFrequencyActivity> reachFrequencyActivitys = new APINodeList<ReachFrequencyActivity>(request, json);
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
          reachFrequencyActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return reachFrequencyActivitys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                reachFrequencyActivitys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            reachFrequencyActivitys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              reachFrequencyActivitys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              reachFrequencyActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  reachFrequencyActivitys.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              reachFrequencyActivitys.add(loadJSON(obj.toString(), context));
            }
          }
          return reachFrequencyActivitys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              reachFrequencyActivitys.add(loadJSON(entry.getValue().toString(), context));
          }
          return reachFrequencyActivitys;
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
              reachFrequencyActivitys.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return reachFrequencyActivitys;
          }

          // Sixth, check if it's pure JsonObject
          reachFrequencyActivitys.clear();
          reachFrequencyActivitys.add(loadJSON(json, context));
          return reachFrequencyActivitys;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public Boolean getFieldCampaignActive() {
    return mCampaignActive;
  }

  public Boolean getFieldCampaignStarted() {
    return mCampaignStarted;
  }

  public Boolean getFieldCreativeUploaded() {
    return mCreativeUploaded;
  }

  public Long getFieldDeliveredBudget() {
    return mDeliveredBudget;
  }

  public List<Double> getFieldDeliveredDailyGrp() {
    return mDeliveredDailyGrp;
  }

  public List<Double> getFieldDeliveredDailyImpression() {
    return mDeliveredDailyImpression;
  }

  public Long getFieldDeliveredImpression() {
    return mDeliveredImpression;
  }

  public Long getFieldDeliveredReach() {
    return mDeliveredReach;
  }

  public Long getFieldDeliveredTotalImpression() {
    return mDeliveredTotalImpression;
  }

  public Boolean getFieldIoApproved() {
    return mIoApproved;
  }

  public String getFieldSfLink() {
    return mSfLink;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ReachFrequencyActivity> {

    ReachFrequencyActivity lastResponse = null;
    @Override
    public ReachFrequencyActivity getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "campaign_active",
      "campaign_started",
      "creative_uploaded",
      "delivered_budget",
      "delivered_daily_grp",
      "delivered_daily_impression",
      "delivered_impression",
      "delivered_reach",
      "delivered_total_impression",
      "io_approved",
      "sf_link",
      "id",
    };

    @Override
    public ReachFrequencyActivity parseResponse(String response) throws APIException {
      return ReachFrequencyActivity.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ReachFrequencyActivity execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ReachFrequencyActivity execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ReachFrequencyActivity> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ReachFrequencyActivity> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ReachFrequencyActivity>() {
           public ReachFrequencyActivity apply(String result) {
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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestCampaignActiveField () {
      return this.requestCampaignActiveField(true);
    }
    public APIRequestGet requestCampaignActiveField (boolean value) {
      this.requestField("campaign_active", value);
      return this;
    }
    public APIRequestGet requestCampaignStartedField () {
      return this.requestCampaignStartedField(true);
    }
    public APIRequestGet requestCampaignStartedField (boolean value) {
      this.requestField("campaign_started", value);
      return this;
    }
    public APIRequestGet requestCreativeUploadedField () {
      return this.requestCreativeUploadedField(true);
    }
    public APIRequestGet requestCreativeUploadedField (boolean value) {
      this.requestField("creative_uploaded", value);
      return this;
    }
    public APIRequestGet requestDeliveredBudgetField () {
      return this.requestDeliveredBudgetField(true);
    }
    public APIRequestGet requestDeliveredBudgetField (boolean value) {
      this.requestField("delivered_budget", value);
      return this;
    }
    public APIRequestGet requestDeliveredDailyGrpField () {
      return this.requestDeliveredDailyGrpField(true);
    }
    public APIRequestGet requestDeliveredDailyGrpField (boolean value) {
      this.requestField("delivered_daily_grp", value);
      return this;
    }
    public APIRequestGet requestDeliveredDailyImpressionField () {
      return this.requestDeliveredDailyImpressionField(true);
    }
    public APIRequestGet requestDeliveredDailyImpressionField (boolean value) {
      this.requestField("delivered_daily_impression", value);
      return this;
    }
    public APIRequestGet requestDeliveredImpressionField () {
      return this.requestDeliveredImpressionField(true);
    }
    public APIRequestGet requestDeliveredImpressionField (boolean value) {
      this.requestField("delivered_impression", value);
      return this;
    }
    public APIRequestGet requestDeliveredReachField () {
      return this.requestDeliveredReachField(true);
    }
    public APIRequestGet requestDeliveredReachField (boolean value) {
      this.requestField("delivered_reach", value);
      return this;
    }
    public APIRequestGet requestDeliveredTotalImpressionField () {
      return this.requestDeliveredTotalImpressionField(true);
    }
    public APIRequestGet requestDeliveredTotalImpressionField (boolean value) {
      this.requestField("delivered_total_impression", value);
      return this;
    }
    public APIRequestGet requestIoApprovedField () {
      return this.requestIoApprovedField(true);
    }
    public APIRequestGet requestIoApprovedField (boolean value) {
      this.requestField("io_approved", value);
      return this;
    }
    public APIRequestGet requestSfLinkField () {
      return this.requestSfLinkField(true);
    }
    public APIRequestGet requestSfLinkField (boolean value) {
      this.requestField("sf_link", value);
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

  public ReachFrequencyActivity copyFrom(ReachFrequencyActivity instance) {
    this.mAccountId = instance.mAccountId;
    this.mCampaignActive = instance.mCampaignActive;
    this.mCampaignStarted = instance.mCampaignStarted;
    this.mCreativeUploaded = instance.mCreativeUploaded;
    this.mDeliveredBudget = instance.mDeliveredBudget;
    this.mDeliveredDailyGrp = instance.mDeliveredDailyGrp;
    this.mDeliveredDailyImpression = instance.mDeliveredDailyImpression;
    this.mDeliveredImpression = instance.mDeliveredImpression;
    this.mDeliveredReach = instance.mDeliveredReach;
    this.mDeliveredTotalImpression = instance.mDeliveredTotalImpression;
    this.mIoApproved = instance.mIoApproved;
    this.mSfLink = instance.mSfLink;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ReachFrequencyActivity> getParser() {
    return new APIRequest.ResponseParser<ReachFrequencyActivity>() {
      public APINodeList<ReachFrequencyActivity> parseResponse(String response, APIContext context, APIRequest<ReachFrequencyActivity> request) throws MalformedResponseException {
        return ReachFrequencyActivity.parseResponse(response, context, request);
      }
    };
  }
}
