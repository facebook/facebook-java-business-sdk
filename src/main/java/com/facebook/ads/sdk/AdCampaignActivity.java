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
public class AdCampaignActivity extends APINode {
  @SerializedName("auto_create_lookalike_new")
  private Boolean mAutoCreateLookalikeNew = null;
  @SerializedName("auto_create_lookalike_old")
  private Boolean mAutoCreateLookalikeOld = null;
  @SerializedName("bid_adjustments_spec_new")
  private String mBidAdjustmentsSpecNew = null;
  @SerializedName("bid_adjustments_spec_old")
  private String mBidAdjustmentsSpecOld = null;
  @SerializedName("bid_amount_new")
  private Long mBidAmountNew = null;
  @SerializedName("bid_amount_old")
  private Long mBidAmountOld = null;
  @SerializedName("bid_constraints_new")
  private Object mBidConstraintsNew = null;
  @SerializedName("bid_constraints_old")
  private Object mBidConstraintsOld = null;
  @SerializedName("bid_info_new")
  private Map<String, Long> mBidInfoNew = null;
  @SerializedName("bid_info_old")
  private Map<String, Long> mBidInfoOld = null;
  @SerializedName("bid_strategy_new")
  private EnumBidStrategyNew mBidStrategyNew = null;
  @SerializedName("bid_strategy_old")
  private EnumBidStrategyOld mBidStrategyOld = null;
  @SerializedName("bid_type_new")
  private String mBidTypeNew = null;
  @SerializedName("bid_type_old")
  private String mBidTypeOld = null;
  @SerializedName("billing_event_new")
  private EnumBillingEventNew mBillingEventNew = null;
  @SerializedName("billing_event_old")
  private EnumBillingEventOld mBillingEventOld = null;
  @SerializedName("budget_limit_new")
  private Object mBudgetLimitNew = null;
  @SerializedName("budget_limit_old")
  private Object mBudgetLimitOld = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("daily_impressions_new")
  private Long mDailyImpressionsNew = null;
  @SerializedName("daily_impressions_old")
  private Long mDailyImpressionsOld = null;
  @SerializedName("dco_mode_new")
  private String mDcoModeNew = null;
  @SerializedName("dco_mode_old")
  private String mDcoModeOld = null;
  @SerializedName("delivery_behavior_new")
  private String mDeliveryBehaviorNew = null;
  @SerializedName("delivery_behavior_old")
  private String mDeliveryBehaviorOld = null;
  @SerializedName("destination_type_new")
  private String mDestinationTypeNew = null;
  @SerializedName("destination_type_old")
  private String mDestinationTypeOld = null;
  @SerializedName("event_time")
  private String mEventTime = null;
  @SerializedName("event_type")
  private String mEventType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("invoicing_limit_new")
  private Long mInvoicingLimitNew = null;
  @SerializedName("invoicing_limit_old")
  private Long mInvoicingLimitOld = null;
  @SerializedName("min_spend_target_new")
  private Object mMinSpendTargetNew = null;
  @SerializedName("min_spend_target_old")
  private Object mMinSpendTargetOld = null;
  @SerializedName("name_new")
  private String mNameNew = null;
  @SerializedName("name_old")
  private String mNameOld = null;
  @SerializedName("optimization_goal_new")
  private EnumOptimizationGoalNew mOptimizationGoalNew = null;
  @SerializedName("optimization_goal_old")
  private EnumOptimizationGoalOld mOptimizationGoalOld = null;
  @SerializedName("pacing_type_new")
  private Long mPacingTypeNew = null;
  @SerializedName("pacing_type_old")
  private Long mPacingTypeOld = null;
  @SerializedName("run_status_new")
  private String mRunStatusNew = null;
  @SerializedName("run_status_old")
  private String mRunStatusOld = null;
  @SerializedName("schedule_new")
  private List<Object> mScheduleNew = null;
  @SerializedName("schedule_old")
  private List<Object> mScheduleOld = null;
  @SerializedName("spend_cap_new")
  private Object mSpendCapNew = null;
  @SerializedName("spend_cap_old")
  private Object mSpendCapOld = null;
  @SerializedName("start_time_new")
  private String mStartTimeNew = null;
  @SerializedName("start_time_old")
  private String mStartTimeOld = null;
  @SerializedName("stop_time_new")
  private String mStopTimeNew = null;
  @SerializedName("stop_time_old")
  private String mStopTimeOld = null;
  @SerializedName("targeting_expansion_new")
  private Object mTargetingExpansionNew = null;
  @SerializedName("targeting_expansion_old")
  private Object mTargetingExpansionOld = null;
  @SerializedName("updated_time_new")
  private String mUpdatedTimeNew = null;
  @SerializedName("updated_time_old")
  private String mUpdatedTimeOld = null;
  protected static Gson gson = null;

  AdCampaignActivity() {
  }

  public AdCampaignActivity(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCampaignActivity(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCampaignActivity fetch() throws APIException{
    AdCampaignActivity newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCampaignActivity fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCampaignActivity> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCampaignActivity fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCampaignActivity> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCampaignActivity> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCampaignActivity>)(
      new APIRequest<AdCampaignActivity>(context, "", "/", "GET", AdCampaignActivity.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCampaignActivity>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCampaignActivity.getParser())
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
  public static AdCampaignActivity loadJSON(String json, APIContext context, String header) {
    AdCampaignActivity adCampaignActivity = getGson().fromJson(json, AdCampaignActivity.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignActivity.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCampaignActivity.context = context;
    adCampaignActivity.rawValue = json;
    adCampaignActivity.header = header;
    return adCampaignActivity;
  }

  public static APINodeList<AdCampaignActivity> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCampaignActivity> adCampaignActivitys = new APINodeList<AdCampaignActivity>(request, json, header);
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
          adCampaignActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCampaignActivitys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignActivitys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignActivitys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignActivitys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCampaignActivitys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignActivitys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCampaignActivitys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignActivitys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCampaignActivitys;
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
              adCampaignActivitys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignActivitys;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignActivitys.clear();
          adCampaignActivitys.add(loadJSON(json, context, header));
          return adCampaignActivitys;
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


  public Boolean getFieldAutoCreateLookalikeNew() {
    return mAutoCreateLookalikeNew;
  }

  public Boolean getFieldAutoCreateLookalikeOld() {
    return mAutoCreateLookalikeOld;
  }

  public String getFieldBidAdjustmentsSpecNew() {
    return mBidAdjustmentsSpecNew;
  }

  public String getFieldBidAdjustmentsSpecOld() {
    return mBidAdjustmentsSpecOld;
  }

  public Long getFieldBidAmountNew() {
    return mBidAmountNew;
  }

  public Long getFieldBidAmountOld() {
    return mBidAmountOld;
  }

  public Object getFieldBidConstraintsNew() {
    return mBidConstraintsNew;
  }

  public Object getFieldBidConstraintsOld() {
    return mBidConstraintsOld;
  }

  public Map<String, Long> getFieldBidInfoNew() {
    return mBidInfoNew;
  }

  public Map<String, Long> getFieldBidInfoOld() {
    return mBidInfoOld;
  }

  public EnumBidStrategyNew getFieldBidStrategyNew() {
    return mBidStrategyNew;
  }

  public EnumBidStrategyOld getFieldBidStrategyOld() {
    return mBidStrategyOld;
  }

  public String getFieldBidTypeNew() {
    return mBidTypeNew;
  }

  public String getFieldBidTypeOld() {
    return mBidTypeOld;
  }

  public EnumBillingEventNew getFieldBillingEventNew() {
    return mBillingEventNew;
  }

  public EnumBillingEventOld getFieldBillingEventOld() {
    return mBillingEventOld;
  }

  public Object getFieldBudgetLimitNew() {
    return mBudgetLimitNew;
  }

  public Object getFieldBudgetLimitOld() {
    return mBudgetLimitOld;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public Long getFieldDailyImpressionsNew() {
    return mDailyImpressionsNew;
  }

  public Long getFieldDailyImpressionsOld() {
    return mDailyImpressionsOld;
  }

  public String getFieldDcoModeNew() {
    return mDcoModeNew;
  }

  public String getFieldDcoModeOld() {
    return mDcoModeOld;
  }

  public String getFieldDeliveryBehaviorNew() {
    return mDeliveryBehaviorNew;
  }

  public String getFieldDeliveryBehaviorOld() {
    return mDeliveryBehaviorOld;
  }

  public String getFieldDestinationTypeNew() {
    return mDestinationTypeNew;
  }

  public String getFieldDestinationTypeOld() {
    return mDestinationTypeOld;
  }

  public String getFieldEventTime() {
    return mEventTime;
  }

  public String getFieldEventType() {
    return mEventType;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldInvoicingLimitNew() {
    return mInvoicingLimitNew;
  }

  public Long getFieldInvoicingLimitOld() {
    return mInvoicingLimitOld;
  }

  public Object getFieldMinSpendTargetNew() {
    return mMinSpendTargetNew;
  }

  public Object getFieldMinSpendTargetOld() {
    return mMinSpendTargetOld;
  }

  public String getFieldNameNew() {
    return mNameNew;
  }

  public String getFieldNameOld() {
    return mNameOld;
  }

  public EnumOptimizationGoalNew getFieldOptimizationGoalNew() {
    return mOptimizationGoalNew;
  }

  public EnumOptimizationGoalOld getFieldOptimizationGoalOld() {
    return mOptimizationGoalOld;
  }

  public Long getFieldPacingTypeNew() {
    return mPacingTypeNew;
  }

  public Long getFieldPacingTypeOld() {
    return mPacingTypeOld;
  }

  public String getFieldRunStatusNew() {
    return mRunStatusNew;
  }

  public String getFieldRunStatusOld() {
    return mRunStatusOld;
  }

  public List<Object> getFieldScheduleNew() {
    return mScheduleNew;
  }

  public List<Object> getFieldScheduleOld() {
    return mScheduleOld;
  }

  public Object getFieldSpendCapNew() {
    return mSpendCapNew;
  }

  public Object getFieldSpendCapOld() {
    return mSpendCapOld;
  }

  public String getFieldStartTimeNew() {
    return mStartTimeNew;
  }

  public String getFieldStartTimeOld() {
    return mStartTimeOld;
  }

  public String getFieldStopTimeNew() {
    return mStopTimeNew;
  }

  public String getFieldStopTimeOld() {
    return mStopTimeOld;
  }

  public Object getFieldTargetingExpansionNew() {
    return mTargetingExpansionNew;
  }

  public Object getFieldTargetingExpansionOld() {
    return mTargetingExpansionOld;
  }

  public String getFieldUpdatedTimeNew() {
    return mUpdatedTimeNew;
  }

  public String getFieldUpdatedTimeOld() {
    return mUpdatedTimeOld;
  }



  public static class APIRequestGet extends APIRequest<AdCampaignActivity> {

    AdCampaignActivity lastResponse = null;
    @Override
    public AdCampaignActivity getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "auto_create_lookalike_new",
      "auto_create_lookalike_old",
      "bid_adjustments_spec_new",
      "bid_adjustments_spec_old",
      "bid_amount_new",
      "bid_amount_old",
      "bid_constraints_new",
      "bid_constraints_old",
      "bid_info_new",
      "bid_info_old",
      "bid_strategy_new",
      "bid_strategy_old",
      "bid_type_new",
      "bid_type_old",
      "billing_event_new",
      "billing_event_old",
      "budget_limit_new",
      "budget_limit_old",
      "created_time",
      "daily_impressions_new",
      "daily_impressions_old",
      "dco_mode_new",
      "dco_mode_old",
      "delivery_behavior_new",
      "delivery_behavior_old",
      "destination_type_new",
      "destination_type_old",
      "event_time",
      "event_type",
      "id",
      "invoicing_limit_new",
      "invoicing_limit_old",
      "min_spend_target_new",
      "min_spend_target_old",
      "name_new",
      "name_old",
      "optimization_goal_new",
      "optimization_goal_old",
      "pacing_type_new",
      "pacing_type_old",
      "run_status_new",
      "run_status_old",
      "schedule_new",
      "schedule_old",
      "spend_cap_new",
      "spend_cap_old",
      "start_time_new",
      "start_time_old",
      "stop_time_new",
      "stop_time_old",
      "targeting_expansion_new",
      "targeting_expansion_old",
      "updated_time_new",
      "updated_time_old",
    };

    @Override
    public AdCampaignActivity parseResponse(String response, String header) throws APIException {
      return AdCampaignActivity.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdCampaignActivity execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCampaignActivity execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdCampaignActivity> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCampaignActivity> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdCampaignActivity>() {
           public AdCampaignActivity apply(ResponseWrapper result) {
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

    public APIRequestGet requestAutoCreateLookalikeNewField () {
      return this.requestAutoCreateLookalikeNewField(true);
    }
    public APIRequestGet requestAutoCreateLookalikeNewField (boolean value) {
      this.requestField("auto_create_lookalike_new", value);
      return this;
    }
    public APIRequestGet requestAutoCreateLookalikeOldField () {
      return this.requestAutoCreateLookalikeOldField(true);
    }
    public APIRequestGet requestAutoCreateLookalikeOldField (boolean value) {
      this.requestField("auto_create_lookalike_old", value);
      return this;
    }
    public APIRequestGet requestBidAdjustmentsSpecNewField () {
      return this.requestBidAdjustmentsSpecNewField(true);
    }
    public APIRequestGet requestBidAdjustmentsSpecNewField (boolean value) {
      this.requestField("bid_adjustments_spec_new", value);
      return this;
    }
    public APIRequestGet requestBidAdjustmentsSpecOldField () {
      return this.requestBidAdjustmentsSpecOldField(true);
    }
    public APIRequestGet requestBidAdjustmentsSpecOldField (boolean value) {
      this.requestField("bid_adjustments_spec_old", value);
      return this;
    }
    public APIRequestGet requestBidAmountNewField () {
      return this.requestBidAmountNewField(true);
    }
    public APIRequestGet requestBidAmountNewField (boolean value) {
      this.requestField("bid_amount_new", value);
      return this;
    }
    public APIRequestGet requestBidAmountOldField () {
      return this.requestBidAmountOldField(true);
    }
    public APIRequestGet requestBidAmountOldField (boolean value) {
      this.requestField("bid_amount_old", value);
      return this;
    }
    public APIRequestGet requestBidConstraintsNewField () {
      return this.requestBidConstraintsNewField(true);
    }
    public APIRequestGet requestBidConstraintsNewField (boolean value) {
      this.requestField("bid_constraints_new", value);
      return this;
    }
    public APIRequestGet requestBidConstraintsOldField () {
      return this.requestBidConstraintsOldField(true);
    }
    public APIRequestGet requestBidConstraintsOldField (boolean value) {
      this.requestField("bid_constraints_old", value);
      return this;
    }
    public APIRequestGet requestBidInfoNewField () {
      return this.requestBidInfoNewField(true);
    }
    public APIRequestGet requestBidInfoNewField (boolean value) {
      this.requestField("bid_info_new", value);
      return this;
    }
    public APIRequestGet requestBidInfoOldField () {
      return this.requestBidInfoOldField(true);
    }
    public APIRequestGet requestBidInfoOldField (boolean value) {
      this.requestField("bid_info_old", value);
      return this;
    }
    public APIRequestGet requestBidStrategyNewField () {
      return this.requestBidStrategyNewField(true);
    }
    public APIRequestGet requestBidStrategyNewField (boolean value) {
      this.requestField("bid_strategy_new", value);
      return this;
    }
    public APIRequestGet requestBidStrategyOldField () {
      return this.requestBidStrategyOldField(true);
    }
    public APIRequestGet requestBidStrategyOldField (boolean value) {
      this.requestField("bid_strategy_old", value);
      return this;
    }
    public APIRequestGet requestBidTypeNewField () {
      return this.requestBidTypeNewField(true);
    }
    public APIRequestGet requestBidTypeNewField (boolean value) {
      this.requestField("bid_type_new", value);
      return this;
    }
    public APIRequestGet requestBidTypeOldField () {
      return this.requestBidTypeOldField(true);
    }
    public APIRequestGet requestBidTypeOldField (boolean value) {
      this.requestField("bid_type_old", value);
      return this;
    }
    public APIRequestGet requestBillingEventNewField () {
      return this.requestBillingEventNewField(true);
    }
    public APIRequestGet requestBillingEventNewField (boolean value) {
      this.requestField("billing_event_new", value);
      return this;
    }
    public APIRequestGet requestBillingEventOldField () {
      return this.requestBillingEventOldField(true);
    }
    public APIRequestGet requestBillingEventOldField (boolean value) {
      this.requestField("billing_event_old", value);
      return this;
    }
    public APIRequestGet requestBudgetLimitNewField () {
      return this.requestBudgetLimitNewField(true);
    }
    public APIRequestGet requestBudgetLimitNewField (boolean value) {
      this.requestField("budget_limit_new", value);
      return this;
    }
    public APIRequestGet requestBudgetLimitOldField () {
      return this.requestBudgetLimitOldField(true);
    }
    public APIRequestGet requestBudgetLimitOldField (boolean value) {
      this.requestField("budget_limit_old", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestDailyImpressionsNewField () {
      return this.requestDailyImpressionsNewField(true);
    }
    public APIRequestGet requestDailyImpressionsNewField (boolean value) {
      this.requestField("daily_impressions_new", value);
      return this;
    }
    public APIRequestGet requestDailyImpressionsOldField () {
      return this.requestDailyImpressionsOldField(true);
    }
    public APIRequestGet requestDailyImpressionsOldField (boolean value) {
      this.requestField("daily_impressions_old", value);
      return this;
    }
    public APIRequestGet requestDcoModeNewField () {
      return this.requestDcoModeNewField(true);
    }
    public APIRequestGet requestDcoModeNewField (boolean value) {
      this.requestField("dco_mode_new", value);
      return this;
    }
    public APIRequestGet requestDcoModeOldField () {
      return this.requestDcoModeOldField(true);
    }
    public APIRequestGet requestDcoModeOldField (boolean value) {
      this.requestField("dco_mode_old", value);
      return this;
    }
    public APIRequestGet requestDeliveryBehaviorNewField () {
      return this.requestDeliveryBehaviorNewField(true);
    }
    public APIRequestGet requestDeliveryBehaviorNewField (boolean value) {
      this.requestField("delivery_behavior_new", value);
      return this;
    }
    public APIRequestGet requestDeliveryBehaviorOldField () {
      return this.requestDeliveryBehaviorOldField(true);
    }
    public APIRequestGet requestDeliveryBehaviorOldField (boolean value) {
      this.requestField("delivery_behavior_old", value);
      return this;
    }
    public APIRequestGet requestDestinationTypeNewField () {
      return this.requestDestinationTypeNewField(true);
    }
    public APIRequestGet requestDestinationTypeNewField (boolean value) {
      this.requestField("destination_type_new", value);
      return this;
    }
    public APIRequestGet requestDestinationTypeOldField () {
      return this.requestDestinationTypeOldField(true);
    }
    public APIRequestGet requestDestinationTypeOldField (boolean value) {
      this.requestField("destination_type_old", value);
      return this;
    }
    public APIRequestGet requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGet requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
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
    public APIRequestGet requestInvoicingLimitNewField () {
      return this.requestInvoicingLimitNewField(true);
    }
    public APIRequestGet requestInvoicingLimitNewField (boolean value) {
      this.requestField("invoicing_limit_new", value);
      return this;
    }
    public APIRequestGet requestInvoicingLimitOldField () {
      return this.requestInvoicingLimitOldField(true);
    }
    public APIRequestGet requestInvoicingLimitOldField (boolean value) {
      this.requestField("invoicing_limit_old", value);
      return this;
    }
    public APIRequestGet requestMinSpendTargetNewField () {
      return this.requestMinSpendTargetNewField(true);
    }
    public APIRequestGet requestMinSpendTargetNewField (boolean value) {
      this.requestField("min_spend_target_new", value);
      return this;
    }
    public APIRequestGet requestMinSpendTargetOldField () {
      return this.requestMinSpendTargetOldField(true);
    }
    public APIRequestGet requestMinSpendTargetOldField (boolean value) {
      this.requestField("min_spend_target_old", value);
      return this;
    }
    public APIRequestGet requestNameNewField () {
      return this.requestNameNewField(true);
    }
    public APIRequestGet requestNameNewField (boolean value) {
      this.requestField("name_new", value);
      return this;
    }
    public APIRequestGet requestNameOldField () {
      return this.requestNameOldField(true);
    }
    public APIRequestGet requestNameOldField (boolean value) {
      this.requestField("name_old", value);
      return this;
    }
    public APIRequestGet requestOptimizationGoalNewField () {
      return this.requestOptimizationGoalNewField(true);
    }
    public APIRequestGet requestOptimizationGoalNewField (boolean value) {
      this.requestField("optimization_goal_new", value);
      return this;
    }
    public APIRequestGet requestOptimizationGoalOldField () {
      return this.requestOptimizationGoalOldField(true);
    }
    public APIRequestGet requestOptimizationGoalOldField (boolean value) {
      this.requestField("optimization_goal_old", value);
      return this;
    }
    public APIRequestGet requestPacingTypeNewField () {
      return this.requestPacingTypeNewField(true);
    }
    public APIRequestGet requestPacingTypeNewField (boolean value) {
      this.requestField("pacing_type_new", value);
      return this;
    }
    public APIRequestGet requestPacingTypeOldField () {
      return this.requestPacingTypeOldField(true);
    }
    public APIRequestGet requestPacingTypeOldField (boolean value) {
      this.requestField("pacing_type_old", value);
      return this;
    }
    public APIRequestGet requestRunStatusNewField () {
      return this.requestRunStatusNewField(true);
    }
    public APIRequestGet requestRunStatusNewField (boolean value) {
      this.requestField("run_status_new", value);
      return this;
    }
    public APIRequestGet requestRunStatusOldField () {
      return this.requestRunStatusOldField(true);
    }
    public APIRequestGet requestRunStatusOldField (boolean value) {
      this.requestField("run_status_old", value);
      return this;
    }
    public APIRequestGet requestScheduleNewField () {
      return this.requestScheduleNewField(true);
    }
    public APIRequestGet requestScheduleNewField (boolean value) {
      this.requestField("schedule_new", value);
      return this;
    }
    public APIRequestGet requestScheduleOldField () {
      return this.requestScheduleOldField(true);
    }
    public APIRequestGet requestScheduleOldField (boolean value) {
      this.requestField("schedule_old", value);
      return this;
    }
    public APIRequestGet requestSpendCapNewField () {
      return this.requestSpendCapNewField(true);
    }
    public APIRequestGet requestSpendCapNewField (boolean value) {
      this.requestField("spend_cap_new", value);
      return this;
    }
    public APIRequestGet requestSpendCapOldField () {
      return this.requestSpendCapOldField(true);
    }
    public APIRequestGet requestSpendCapOldField (boolean value) {
      this.requestField("spend_cap_old", value);
      return this;
    }
    public APIRequestGet requestStartTimeNewField () {
      return this.requestStartTimeNewField(true);
    }
    public APIRequestGet requestStartTimeNewField (boolean value) {
      this.requestField("start_time_new", value);
      return this;
    }
    public APIRequestGet requestStartTimeOldField () {
      return this.requestStartTimeOldField(true);
    }
    public APIRequestGet requestStartTimeOldField (boolean value) {
      this.requestField("start_time_old", value);
      return this;
    }
    public APIRequestGet requestStopTimeNewField () {
      return this.requestStopTimeNewField(true);
    }
    public APIRequestGet requestStopTimeNewField (boolean value) {
      this.requestField("stop_time_new", value);
      return this;
    }
    public APIRequestGet requestStopTimeOldField () {
      return this.requestStopTimeOldField(true);
    }
    public APIRequestGet requestStopTimeOldField (boolean value) {
      this.requestField("stop_time_old", value);
      return this;
    }
    public APIRequestGet requestTargetingExpansionNewField () {
      return this.requestTargetingExpansionNewField(true);
    }
    public APIRequestGet requestTargetingExpansionNewField (boolean value) {
      this.requestField("targeting_expansion_new", value);
      return this;
    }
    public APIRequestGet requestTargetingExpansionOldField () {
      return this.requestTargetingExpansionOldField(true);
    }
    public APIRequestGet requestTargetingExpansionOldField (boolean value) {
      this.requestField("targeting_expansion_old", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeNewField () {
      return this.requestUpdatedTimeNewField(true);
    }
    public APIRequestGet requestUpdatedTimeNewField (boolean value) {
      this.requestField("updated_time_new", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeOldField () {
      return this.requestUpdatedTimeOldField(true);
    }
    public APIRequestGet requestUpdatedTimeOldField (boolean value) {
      this.requestField("updated_time_old", value);
      return this;
    }
  }

  public static enum EnumBidStrategyNew {
      @SerializedName("COST_CAP")
      VALUE_COST_CAP("COST_CAP"),
      @SerializedName("LOWEST_COST_WITHOUT_CAP")
      VALUE_LOWEST_COST_WITHOUT_CAP("LOWEST_COST_WITHOUT_CAP"),
      @SerializedName("LOWEST_COST_WITH_BID_CAP")
      VALUE_LOWEST_COST_WITH_BID_CAP("LOWEST_COST_WITH_BID_CAP"),
      @SerializedName("TARGET_COST")
      VALUE_TARGET_COST("TARGET_COST"),
      ;

      private String value;

      private EnumBidStrategyNew(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBidStrategyOld {
      @SerializedName("COST_CAP")
      VALUE_COST_CAP("COST_CAP"),
      @SerializedName("LOWEST_COST_WITHOUT_CAP")
      VALUE_LOWEST_COST_WITHOUT_CAP("LOWEST_COST_WITHOUT_CAP"),
      @SerializedName("LOWEST_COST_WITH_BID_CAP")
      VALUE_LOWEST_COST_WITH_BID_CAP("LOWEST_COST_WITH_BID_CAP"),
      @SerializedName("TARGET_COST")
      VALUE_TARGET_COST("TARGET_COST"),
      ;

      private String value;

      private EnumBidStrategyOld(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBillingEventNew {
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("CLICKS")
      VALUE_CLICKS("CLICKS"),
      @SerializedName("IMPRESSIONS")
      VALUE_IMPRESSIONS("IMPRESSIONS"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("THRUPLAY")
      VALUE_THRUPLAY("THRUPLAY"),
      ;

      private String value;

      private EnumBillingEventNew(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBillingEventOld {
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("CLICKS")
      VALUE_CLICKS("CLICKS"),
      @SerializedName("IMPRESSIONS")
      VALUE_IMPRESSIONS("IMPRESSIONS"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("THRUPLAY")
      VALUE_THRUPLAY("THRUPLAY"),
      ;

      private String value;

      private EnumBillingEventOld(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOptimizationGoalNew {
      @SerializedName("AD_RECALL_LIFT")
      VALUE_AD_RECALL_LIFT("AD_RECALL_LIFT"),
      @SerializedName("APP_DOWNLOADS")
      VALUE_APP_DOWNLOADS("APP_DOWNLOADS"),
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("CLICKS")
      VALUE_CLICKS("CLICKS"),
      @SerializedName("DERIVED_EVENTS")
      VALUE_DERIVED_EVENTS("DERIVED_EVENTS"),
      @SerializedName("ENGAGED_USERS")
      VALUE_ENGAGED_USERS("ENGAGED_USERS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("IMPRESSIONS")
      VALUE_IMPRESSIONS("IMPRESSIONS"),
      @SerializedName("LANDING_PAGE_VIEWS")
      VALUE_LANDING_PAGE_VIEWS("LANDING_PAGE_VIEWS"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("OFFSITE_CONVERSIONS")
      VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
      @SerializedName("PAGE_ENGAGEMENT")
      VALUE_PAGE_ENGAGEMENT("PAGE_ENGAGEMENT"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("QUALITY_LEAD")
      VALUE_QUALITY_LEAD("QUALITY_LEAD"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("REPLIES")
      VALUE_REPLIES("REPLIES"),
      @SerializedName("SOCIAL_IMPRESSIONS")
      VALUE_SOCIAL_IMPRESSIONS("SOCIAL_IMPRESSIONS"),
      @SerializedName("THRUPLAY")
      VALUE_THRUPLAY("THRUPLAY"),
      @SerializedName("TWO_SECOND_CONTINUOUS_VIDEO_VIEWS")
      VALUE_TWO_SECOND_CONTINUOUS_VIDEO_VIEWS("TWO_SECOND_CONTINUOUS_VIDEO_VIEWS"),
      @SerializedName("VALUE")
      VALUE_VALUE("VALUE"),
      @SerializedName("VISIT_INSTAGRAM_PROFILE")
      VALUE_VISIT_INSTAGRAM_PROFILE("VISIT_INSTAGRAM_PROFILE"),
      ;

      private String value;

      private EnumOptimizationGoalNew(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOptimizationGoalOld {
      @SerializedName("AD_RECALL_LIFT")
      VALUE_AD_RECALL_LIFT("AD_RECALL_LIFT"),
      @SerializedName("APP_DOWNLOADS")
      VALUE_APP_DOWNLOADS("APP_DOWNLOADS"),
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("CLICKS")
      VALUE_CLICKS("CLICKS"),
      @SerializedName("DERIVED_EVENTS")
      VALUE_DERIVED_EVENTS("DERIVED_EVENTS"),
      @SerializedName("ENGAGED_USERS")
      VALUE_ENGAGED_USERS("ENGAGED_USERS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("IMPRESSIONS")
      VALUE_IMPRESSIONS("IMPRESSIONS"),
      @SerializedName("LANDING_PAGE_VIEWS")
      VALUE_LANDING_PAGE_VIEWS("LANDING_PAGE_VIEWS"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("OFFSITE_CONVERSIONS")
      VALUE_OFFSITE_CONVERSIONS("OFFSITE_CONVERSIONS"),
      @SerializedName("PAGE_ENGAGEMENT")
      VALUE_PAGE_ENGAGEMENT("PAGE_ENGAGEMENT"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("QUALITY_LEAD")
      VALUE_QUALITY_LEAD("QUALITY_LEAD"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      @SerializedName("REPLIES")
      VALUE_REPLIES("REPLIES"),
      @SerializedName("SOCIAL_IMPRESSIONS")
      VALUE_SOCIAL_IMPRESSIONS("SOCIAL_IMPRESSIONS"),
      @SerializedName("THRUPLAY")
      VALUE_THRUPLAY("THRUPLAY"),
      @SerializedName("TWO_SECOND_CONTINUOUS_VIDEO_VIEWS")
      VALUE_TWO_SECOND_CONTINUOUS_VIDEO_VIEWS("TWO_SECOND_CONTINUOUS_VIDEO_VIEWS"),
      @SerializedName("VALUE")
      VALUE_VALUE("VALUE"),
      @SerializedName("VISIT_INSTAGRAM_PROFILE")
      VALUE_VISIT_INSTAGRAM_PROFILE("VISIT_INSTAGRAM_PROFILE"),
      ;

      private String value;

      private EnumOptimizationGoalOld(String value) {
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

  public AdCampaignActivity copyFrom(AdCampaignActivity instance) {
    this.mAutoCreateLookalikeNew = instance.mAutoCreateLookalikeNew;
    this.mAutoCreateLookalikeOld = instance.mAutoCreateLookalikeOld;
    this.mBidAdjustmentsSpecNew = instance.mBidAdjustmentsSpecNew;
    this.mBidAdjustmentsSpecOld = instance.mBidAdjustmentsSpecOld;
    this.mBidAmountNew = instance.mBidAmountNew;
    this.mBidAmountOld = instance.mBidAmountOld;
    this.mBidConstraintsNew = instance.mBidConstraintsNew;
    this.mBidConstraintsOld = instance.mBidConstraintsOld;
    this.mBidInfoNew = instance.mBidInfoNew;
    this.mBidInfoOld = instance.mBidInfoOld;
    this.mBidStrategyNew = instance.mBidStrategyNew;
    this.mBidStrategyOld = instance.mBidStrategyOld;
    this.mBidTypeNew = instance.mBidTypeNew;
    this.mBidTypeOld = instance.mBidTypeOld;
    this.mBillingEventNew = instance.mBillingEventNew;
    this.mBillingEventOld = instance.mBillingEventOld;
    this.mBudgetLimitNew = instance.mBudgetLimitNew;
    this.mBudgetLimitOld = instance.mBudgetLimitOld;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDailyImpressionsNew = instance.mDailyImpressionsNew;
    this.mDailyImpressionsOld = instance.mDailyImpressionsOld;
    this.mDcoModeNew = instance.mDcoModeNew;
    this.mDcoModeOld = instance.mDcoModeOld;
    this.mDeliveryBehaviorNew = instance.mDeliveryBehaviorNew;
    this.mDeliveryBehaviorOld = instance.mDeliveryBehaviorOld;
    this.mDestinationTypeNew = instance.mDestinationTypeNew;
    this.mDestinationTypeOld = instance.mDestinationTypeOld;
    this.mEventTime = instance.mEventTime;
    this.mEventType = instance.mEventType;
    this.mId = instance.mId;
    this.mInvoicingLimitNew = instance.mInvoicingLimitNew;
    this.mInvoicingLimitOld = instance.mInvoicingLimitOld;
    this.mMinSpendTargetNew = instance.mMinSpendTargetNew;
    this.mMinSpendTargetOld = instance.mMinSpendTargetOld;
    this.mNameNew = instance.mNameNew;
    this.mNameOld = instance.mNameOld;
    this.mOptimizationGoalNew = instance.mOptimizationGoalNew;
    this.mOptimizationGoalOld = instance.mOptimizationGoalOld;
    this.mPacingTypeNew = instance.mPacingTypeNew;
    this.mPacingTypeOld = instance.mPacingTypeOld;
    this.mRunStatusNew = instance.mRunStatusNew;
    this.mRunStatusOld = instance.mRunStatusOld;
    this.mScheduleNew = instance.mScheduleNew;
    this.mScheduleOld = instance.mScheduleOld;
    this.mSpendCapNew = instance.mSpendCapNew;
    this.mSpendCapOld = instance.mSpendCapOld;
    this.mStartTimeNew = instance.mStartTimeNew;
    this.mStartTimeOld = instance.mStartTimeOld;
    this.mStopTimeNew = instance.mStopTimeNew;
    this.mStopTimeOld = instance.mStopTimeOld;
    this.mTargetingExpansionNew = instance.mTargetingExpansionNew;
    this.mTargetingExpansionOld = instance.mTargetingExpansionOld;
    this.mUpdatedTimeNew = instance.mUpdatedTimeNew;
    this.mUpdatedTimeOld = instance.mUpdatedTimeOld;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignActivity> getParser() {
    return new APIRequest.ResponseParser<AdCampaignActivity>() {
      public APINodeList<AdCampaignActivity> parseResponse(String response, APIContext context, APIRequest<AdCampaignActivity> request, String header) throws MalformedResponseException {
        return AdCampaignActivity.parseResponse(response, context, request, header);
      }
    };
  }
}
