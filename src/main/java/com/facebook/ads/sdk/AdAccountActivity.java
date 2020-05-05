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
public class AdAccountActivity extends APINode {
  @SerializedName("created_by")
  private Profile mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("credit_new")
  private Object mCreditNew = null;
  @SerializedName("credit_old")
  private Object mCreditOld = null;
  @SerializedName("currency_new")
  private String mCurrencyNew = null;
  @SerializedName("currency_old")
  private String mCurrencyOld = null;
  @SerializedName("daily_spend_limit_new")
  private Object mDailySpendLimitNew = null;
  @SerializedName("daily_spend_limit_old")
  private Object mDailySpendLimitOld = null;
  @SerializedName("event_time")
  private String mEventTime = null;
  @SerializedName("event_type")
  private String mEventType = null;
  @SerializedName("funding_id_new")
  private String mFundingIdNew = null;
  @SerializedName("funding_id_old")
  private String mFundingIdOld = null;
  @SerializedName("grace_period_time_new")
  private Long mGracePeriodTimeNew = null;
  @SerializedName("grace_period_time_old")
  private Long mGracePeriodTimeOld = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("manager_id_new")
  private Profile mManagerIdNew = null;
  @SerializedName("manager_id_old")
  private Profile mManagerIdOld = null;
  @SerializedName("name_new")
  private String mNameNew = null;
  @SerializedName("name_old")
  private String mNameOld = null;
  @SerializedName("spend_cap_new")
  private Object mSpendCapNew = null;
  @SerializedName("spend_cap_old")
  private Object mSpendCapOld = null;
  @SerializedName("status_new")
  private String mStatusNew = null;
  @SerializedName("status_old")
  private String mStatusOld = null;
  @SerializedName("terms_new")
  private Long mTermsNew = null;
  @SerializedName("terms_old")
  private Long mTermsOld = null;
  @SerializedName("tier_new")
  private String mTierNew = null;
  @SerializedName("tier_old")
  private String mTierOld = null;
  @SerializedName("time_updated_new")
  private String mTimeUpdatedNew = null;
  @SerializedName("time_updated_old")
  private String mTimeUpdatedOld = null;
  protected static Gson gson = null;

  AdAccountActivity() {
  }

  public AdAccountActivity(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountActivity(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAccountActivity fetch() throws APIException{
    AdAccountActivity newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountActivity fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountActivity> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountActivity fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAccountActivity> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAccountActivity> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountActivity>)(
      new APIRequest<AdAccountActivity>(context, "", "/", "GET", AdAccountActivity.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountActivity>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAccountActivity.getParser())
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
  public static AdAccountActivity loadJSON(String json, APIContext context, String header) {
    AdAccountActivity adAccountActivity = getGson().fromJson(json, AdAccountActivity.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountActivity.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adAccountActivity.context = context;
    adAccountActivity.rawValue = json;
    adAccountActivity.header = header;
    return adAccountActivity;
  }

  public static APINodeList<AdAccountActivity> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountActivity> adAccountActivitys = new APINodeList<AdAccountActivity>(request, json, header);
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
          adAccountActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountActivitys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountActivitys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountActivitys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountActivitys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adAccountActivitys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountActivitys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountActivitys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountActivitys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountActivitys;
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
              adAccountActivitys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountActivitys;
          }

          // Sixth, check if it's pure JsonObject
          adAccountActivitys.clear();
          adAccountActivitys.add(loadJSON(json, context, header));
          return adAccountActivitys;
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


  public Profile getFieldCreatedBy() {
    if (mCreatedBy != null) {
      mCreatedBy.context = getContext();
    }
    return mCreatedBy;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public Object getFieldCreditNew() {
    return mCreditNew;
  }

  public Object getFieldCreditOld() {
    return mCreditOld;
  }

  public String getFieldCurrencyNew() {
    return mCurrencyNew;
  }

  public String getFieldCurrencyOld() {
    return mCurrencyOld;
  }

  public Object getFieldDailySpendLimitNew() {
    return mDailySpendLimitNew;
  }

  public Object getFieldDailySpendLimitOld() {
    return mDailySpendLimitOld;
  }

  public String getFieldEventTime() {
    return mEventTime;
  }

  public String getFieldEventType() {
    return mEventType;
  }

  public String getFieldFundingIdNew() {
    return mFundingIdNew;
  }

  public String getFieldFundingIdOld() {
    return mFundingIdOld;
  }

  public Long getFieldGracePeriodTimeNew() {
    return mGracePeriodTimeNew;
  }

  public Long getFieldGracePeriodTimeOld() {
    return mGracePeriodTimeOld;
  }

  public String getFieldId() {
    return mId;
  }

  public Profile getFieldManagerIdNew() {
    if (mManagerIdNew != null) {
      mManagerIdNew.context = getContext();
    }
    return mManagerIdNew;
  }

  public Profile getFieldManagerIdOld() {
    if (mManagerIdOld != null) {
      mManagerIdOld.context = getContext();
    }
    return mManagerIdOld;
  }

  public String getFieldNameNew() {
    return mNameNew;
  }

  public String getFieldNameOld() {
    return mNameOld;
  }

  public Object getFieldSpendCapNew() {
    return mSpendCapNew;
  }

  public Object getFieldSpendCapOld() {
    return mSpendCapOld;
  }

  public String getFieldStatusNew() {
    return mStatusNew;
  }

  public String getFieldStatusOld() {
    return mStatusOld;
  }

  public Long getFieldTermsNew() {
    return mTermsNew;
  }

  public Long getFieldTermsOld() {
    return mTermsOld;
  }

  public String getFieldTierNew() {
    return mTierNew;
  }

  public String getFieldTierOld() {
    return mTierOld;
  }

  public String getFieldTimeUpdatedNew() {
    return mTimeUpdatedNew;
  }

  public String getFieldTimeUpdatedOld() {
    return mTimeUpdatedOld;
  }



  public static class APIRequestGet extends APIRequest<AdAccountActivity> {

    AdAccountActivity lastResponse = null;
    @Override
    public AdAccountActivity getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "created_by",
      "created_time",
      "credit_new",
      "credit_old",
      "currency_new",
      "currency_old",
      "daily_spend_limit_new",
      "daily_spend_limit_old",
      "event_time",
      "event_type",
      "funding_id_new",
      "funding_id_old",
      "grace_period_time_new",
      "grace_period_time_old",
      "id",
      "manager_id_new",
      "manager_id_old",
      "name_new",
      "name_old",
      "spend_cap_new",
      "spend_cap_old",
      "status_new",
      "status_old",
      "terms_new",
      "terms_old",
      "tier_new",
      "tier_old",
      "time_updated_new",
      "time_updated_old",
    };

    @Override
    public AdAccountActivity parseResponse(String response, String header) throws APIException {
      return AdAccountActivity.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdAccountActivity execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountActivity execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdAccountActivity> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountActivity> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdAccountActivity>() {
           public AdAccountActivity apply(ResponseWrapper result) {
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

    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreditNewField () {
      return this.requestCreditNewField(true);
    }
    public APIRequestGet requestCreditNewField (boolean value) {
      this.requestField("credit_new", value);
      return this;
    }
    public APIRequestGet requestCreditOldField () {
      return this.requestCreditOldField(true);
    }
    public APIRequestGet requestCreditOldField (boolean value) {
      this.requestField("credit_old", value);
      return this;
    }
    public APIRequestGet requestCurrencyNewField () {
      return this.requestCurrencyNewField(true);
    }
    public APIRequestGet requestCurrencyNewField (boolean value) {
      this.requestField("currency_new", value);
      return this;
    }
    public APIRequestGet requestCurrencyOldField () {
      return this.requestCurrencyOldField(true);
    }
    public APIRequestGet requestCurrencyOldField (boolean value) {
      this.requestField("currency_old", value);
      return this;
    }
    public APIRequestGet requestDailySpendLimitNewField () {
      return this.requestDailySpendLimitNewField(true);
    }
    public APIRequestGet requestDailySpendLimitNewField (boolean value) {
      this.requestField("daily_spend_limit_new", value);
      return this;
    }
    public APIRequestGet requestDailySpendLimitOldField () {
      return this.requestDailySpendLimitOldField(true);
    }
    public APIRequestGet requestDailySpendLimitOldField (boolean value) {
      this.requestField("daily_spend_limit_old", value);
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
    public APIRequestGet requestFundingIdNewField () {
      return this.requestFundingIdNewField(true);
    }
    public APIRequestGet requestFundingIdNewField (boolean value) {
      this.requestField("funding_id_new", value);
      return this;
    }
    public APIRequestGet requestFundingIdOldField () {
      return this.requestFundingIdOldField(true);
    }
    public APIRequestGet requestFundingIdOldField (boolean value) {
      this.requestField("funding_id_old", value);
      return this;
    }
    public APIRequestGet requestGracePeriodTimeNewField () {
      return this.requestGracePeriodTimeNewField(true);
    }
    public APIRequestGet requestGracePeriodTimeNewField (boolean value) {
      this.requestField("grace_period_time_new", value);
      return this;
    }
    public APIRequestGet requestGracePeriodTimeOldField () {
      return this.requestGracePeriodTimeOldField(true);
    }
    public APIRequestGet requestGracePeriodTimeOldField (boolean value) {
      this.requestField("grace_period_time_old", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestManagerIdNewField () {
      return this.requestManagerIdNewField(true);
    }
    public APIRequestGet requestManagerIdNewField (boolean value) {
      this.requestField("manager_id_new", value);
      return this;
    }
    public APIRequestGet requestManagerIdOldField () {
      return this.requestManagerIdOldField(true);
    }
    public APIRequestGet requestManagerIdOldField (boolean value) {
      this.requestField("manager_id_old", value);
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
    public APIRequestGet requestStatusNewField () {
      return this.requestStatusNewField(true);
    }
    public APIRequestGet requestStatusNewField (boolean value) {
      this.requestField("status_new", value);
      return this;
    }
    public APIRequestGet requestStatusOldField () {
      return this.requestStatusOldField(true);
    }
    public APIRequestGet requestStatusOldField (boolean value) {
      this.requestField("status_old", value);
      return this;
    }
    public APIRequestGet requestTermsNewField () {
      return this.requestTermsNewField(true);
    }
    public APIRequestGet requestTermsNewField (boolean value) {
      this.requestField("terms_new", value);
      return this;
    }
    public APIRequestGet requestTermsOldField () {
      return this.requestTermsOldField(true);
    }
    public APIRequestGet requestTermsOldField (boolean value) {
      this.requestField("terms_old", value);
      return this;
    }
    public APIRequestGet requestTierNewField () {
      return this.requestTierNewField(true);
    }
    public APIRequestGet requestTierNewField (boolean value) {
      this.requestField("tier_new", value);
      return this;
    }
    public APIRequestGet requestTierOldField () {
      return this.requestTierOldField(true);
    }
    public APIRequestGet requestTierOldField (boolean value) {
      this.requestField("tier_old", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedNewField () {
      return this.requestTimeUpdatedNewField(true);
    }
    public APIRequestGet requestTimeUpdatedNewField (boolean value) {
      this.requestField("time_updated_new", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedOldField () {
      return this.requestTimeUpdatedOldField(true);
    }
    public APIRequestGet requestTimeUpdatedOldField (boolean value) {
      this.requestField("time_updated_old", value);
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

  public AdAccountActivity copyFrom(AdAccountActivity instance) {
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreditNew = instance.mCreditNew;
    this.mCreditOld = instance.mCreditOld;
    this.mCurrencyNew = instance.mCurrencyNew;
    this.mCurrencyOld = instance.mCurrencyOld;
    this.mDailySpendLimitNew = instance.mDailySpendLimitNew;
    this.mDailySpendLimitOld = instance.mDailySpendLimitOld;
    this.mEventTime = instance.mEventTime;
    this.mEventType = instance.mEventType;
    this.mFundingIdNew = instance.mFundingIdNew;
    this.mFundingIdOld = instance.mFundingIdOld;
    this.mGracePeriodTimeNew = instance.mGracePeriodTimeNew;
    this.mGracePeriodTimeOld = instance.mGracePeriodTimeOld;
    this.mId = instance.mId;
    this.mManagerIdNew = instance.mManagerIdNew;
    this.mManagerIdOld = instance.mManagerIdOld;
    this.mNameNew = instance.mNameNew;
    this.mNameOld = instance.mNameOld;
    this.mSpendCapNew = instance.mSpendCapNew;
    this.mSpendCapOld = instance.mSpendCapOld;
    this.mStatusNew = instance.mStatusNew;
    this.mStatusOld = instance.mStatusOld;
    this.mTermsNew = instance.mTermsNew;
    this.mTermsOld = instance.mTermsOld;
    this.mTierNew = instance.mTierNew;
    this.mTierOld = instance.mTierOld;
    this.mTimeUpdatedNew = instance.mTimeUpdatedNew;
    this.mTimeUpdatedOld = instance.mTimeUpdatedOld;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountActivity> getParser() {
    return new APIRequest.ResponseParser<AdAccountActivity>() {
      public APINodeList<AdAccountActivity> parseResponse(String response, APIContext context, APIRequest<AdAccountActivity> request, String header) throws MalformedResponseException {
        return AdAccountActivity.parseResponse(response, context, request, header);
      }
    };
  }
}
