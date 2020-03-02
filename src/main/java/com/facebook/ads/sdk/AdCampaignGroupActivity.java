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
public class AdCampaignGroupActivity extends APINode {
  @SerializedName("budget_limit_new")
  private Object mBudgetLimitNew = null;
  @SerializedName("budget_limit_old")
  private Object mBudgetLimitOld = null;
  @SerializedName("buying_type_new")
  private String mBuyingTypeNew = null;
  @SerializedName("buying_type_old")
  private String mBuyingTypeOld = null;
  @SerializedName("event_time")
  private String mEventTime = null;
  @SerializedName("event_type")
  private String mEventType = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_autobid_new")
  private Boolean mIsAutobidNew = null;
  @SerializedName("is_autobid_old")
  private Boolean mIsAutobidOld = null;
  @SerializedName("is_average_price_pacing_new")
  private Boolean mIsAveragePricePacingNew = null;
  @SerializedName("is_average_price_pacing_old")
  private Boolean mIsAveragePricePacingOld = null;
  @SerializedName("name_new")
  private String mNameNew = null;
  @SerializedName("name_old")
  private String mNameOld = null;
  @SerializedName("objective_new")
  private EnumObjectiveNew mObjectiveNew = null;
  @SerializedName("objective_old")
  private EnumObjectiveOld mObjectiveOld = null;
  @SerializedName("pacing_type")
  private Long mPacingType = null;
  @SerializedName("run_status_new")
  private String mRunStatusNew = null;
  @SerializedName("run_status_old")
  private String mRunStatusOld = null;
  @SerializedName("spend_cap_new")
  private Long mSpendCapNew = null;
  @SerializedName("spend_cap_old")
  private Long mSpendCapOld = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_updated_new")
  private String mTimeUpdatedNew = null;
  @SerializedName("time_updated_old")
  private String mTimeUpdatedOld = null;
  protected static Gson gson = null;

  AdCampaignGroupActivity() {
  }

  public AdCampaignGroupActivity(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCampaignGroupActivity(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCampaignGroupActivity fetch() throws APIException{
    AdCampaignGroupActivity newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCampaignGroupActivity fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCampaignGroupActivity> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCampaignGroupActivity fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCampaignGroupActivity> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCampaignGroupActivity> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCampaignGroupActivity>)(
      new APIRequest<AdCampaignGroupActivity>(context, "", "/", "GET", AdCampaignGroupActivity.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCampaignGroupActivity>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCampaignGroupActivity.getParser())
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
  public static AdCampaignGroupActivity loadJSON(String json, APIContext context, String header) {
    AdCampaignGroupActivity adCampaignGroupActivity = getGson().fromJson(json, AdCampaignGroupActivity.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCampaignGroupActivity.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCampaignGroupActivity.context = context;
    adCampaignGroupActivity.rawValue = json;
    adCampaignGroupActivity.header = header;
    return adCampaignGroupActivity;
  }

  public static APINodeList<AdCampaignGroupActivity> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCampaignGroupActivity> adCampaignGroupActivitys = new APINodeList<AdCampaignGroupActivity>(request, json, header);
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
          adCampaignGroupActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCampaignGroupActivitys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCampaignGroupActivitys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCampaignGroupActivitys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCampaignGroupActivitys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCampaignGroupActivitys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCampaignGroupActivitys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCampaignGroupActivitys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCampaignGroupActivitys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCampaignGroupActivitys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCampaignGroupActivitys;
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
              adCampaignGroupActivitys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCampaignGroupActivitys;
          }

          // Sixth, check if it's pure JsonObject
          adCampaignGroupActivitys.clear();
          adCampaignGroupActivitys.add(loadJSON(json, context, header));
          return adCampaignGroupActivitys;
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


  public Object getFieldBudgetLimitNew() {
    return mBudgetLimitNew;
  }

  public Object getFieldBudgetLimitOld() {
    return mBudgetLimitOld;
  }

  public String getFieldBuyingTypeNew() {
    return mBuyingTypeNew;
  }

  public String getFieldBuyingTypeOld() {
    return mBuyingTypeOld;
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

  public Boolean getFieldIsAutobidNew() {
    return mIsAutobidNew;
  }

  public Boolean getFieldIsAutobidOld() {
    return mIsAutobidOld;
  }

  public Boolean getFieldIsAveragePricePacingNew() {
    return mIsAveragePricePacingNew;
  }

  public Boolean getFieldIsAveragePricePacingOld() {
    return mIsAveragePricePacingOld;
  }

  public String getFieldNameNew() {
    return mNameNew;
  }

  public String getFieldNameOld() {
    return mNameOld;
  }

  public EnumObjectiveNew getFieldObjectiveNew() {
    return mObjectiveNew;
  }

  public EnumObjectiveOld getFieldObjectiveOld() {
    return mObjectiveOld;
  }

  public Long getFieldPacingType() {
    return mPacingType;
  }

  public String getFieldRunStatusNew() {
    return mRunStatusNew;
  }

  public String getFieldRunStatusOld() {
    return mRunStatusOld;
  }

  public Long getFieldSpendCapNew() {
    return mSpendCapNew;
  }

  public Long getFieldSpendCapOld() {
    return mSpendCapOld;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldTimeUpdatedNew() {
    return mTimeUpdatedNew;
  }

  public String getFieldTimeUpdatedOld() {
    return mTimeUpdatedOld;
  }



  public static class APIRequestGet extends APIRequest<AdCampaignGroupActivity> {

    AdCampaignGroupActivity lastResponse = null;
    @Override
    public AdCampaignGroupActivity getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "budget_limit_new",
      "budget_limit_old",
      "buying_type_new",
      "buying_type_old",
      "event_time",
      "event_type",
      "id",
      "is_autobid_new",
      "is_autobid_old",
      "is_average_price_pacing_new",
      "is_average_price_pacing_old",
      "name_new",
      "name_old",
      "objective_new",
      "objective_old",
      "pacing_type",
      "run_status_new",
      "run_status_old",
      "spend_cap_new",
      "spend_cap_old",
      "time_created",
      "time_updated_new",
      "time_updated_old",
    };

    @Override
    public AdCampaignGroupActivity parseResponse(String response, String header) throws APIException {
      return AdCampaignGroupActivity.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdCampaignGroupActivity execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCampaignGroupActivity execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdCampaignGroupActivity> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCampaignGroupActivity> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdCampaignGroupActivity>() {
           public AdCampaignGroupActivity apply(ResponseWrapper result) {
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
    public APIRequestGet requestBuyingTypeNewField () {
      return this.requestBuyingTypeNewField(true);
    }
    public APIRequestGet requestBuyingTypeNewField (boolean value) {
      this.requestField("buying_type_new", value);
      return this;
    }
    public APIRequestGet requestBuyingTypeOldField () {
      return this.requestBuyingTypeOldField(true);
    }
    public APIRequestGet requestBuyingTypeOldField (boolean value) {
      this.requestField("buying_type_old", value);
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
    public APIRequestGet requestIsAutobidNewField () {
      return this.requestIsAutobidNewField(true);
    }
    public APIRequestGet requestIsAutobidNewField (boolean value) {
      this.requestField("is_autobid_new", value);
      return this;
    }
    public APIRequestGet requestIsAutobidOldField () {
      return this.requestIsAutobidOldField(true);
    }
    public APIRequestGet requestIsAutobidOldField (boolean value) {
      this.requestField("is_autobid_old", value);
      return this;
    }
    public APIRequestGet requestIsAveragePricePacingNewField () {
      return this.requestIsAveragePricePacingNewField(true);
    }
    public APIRequestGet requestIsAveragePricePacingNewField (boolean value) {
      this.requestField("is_average_price_pacing_new", value);
      return this;
    }
    public APIRequestGet requestIsAveragePricePacingOldField () {
      return this.requestIsAveragePricePacingOldField(true);
    }
    public APIRequestGet requestIsAveragePricePacingOldField (boolean value) {
      this.requestField("is_average_price_pacing_old", value);
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
    public APIRequestGet requestObjectiveNewField () {
      return this.requestObjectiveNewField(true);
    }
    public APIRequestGet requestObjectiveNewField (boolean value) {
      this.requestField("objective_new", value);
      return this;
    }
    public APIRequestGet requestObjectiveOldField () {
      return this.requestObjectiveOldField(true);
    }
    public APIRequestGet requestObjectiveOldField (boolean value) {
      this.requestField("objective_old", value);
      return this;
    }
    public APIRequestGet requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGet requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
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
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
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

  public static enum EnumObjectiveNew {
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("CANVAS_APP_ENGAGEMENT")
      VALUE_CANVAS_APP_ENGAGEMENT("CANVAS_APP_ENGAGEMENT"),
      @SerializedName("CANVAS_APP_INSTALLS")
      VALUE_CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("LOCAL_AWARENESS")
      VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
      @SerializedName("MESSAGES")
      VALUE_MESSAGES("MESSAGES"),
      @SerializedName("MOBILE_APP_ENGAGEMENT")
      VALUE_MOBILE_APP_ENGAGEMENT("MOBILE_APP_ENGAGEMENT"),
      @SerializedName("MOBILE_APP_INSTALLS")
      VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("PRODUCT_CATALOG_SALES")
      VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      @SerializedName("WEBSITE_CONVERSIONS")
      VALUE_WEBSITE_CONVERSIONS("WEBSITE_CONVERSIONS"),
      ;

      private String value;

      private EnumObjectiveNew(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumObjectiveOld {
      @SerializedName("APP_INSTALLS")
      VALUE_APP_INSTALLS("APP_INSTALLS"),
      @SerializedName("BRAND_AWARENESS")
      VALUE_BRAND_AWARENESS("BRAND_AWARENESS"),
      @SerializedName("CANVAS_APP_ENGAGEMENT")
      VALUE_CANVAS_APP_ENGAGEMENT("CANVAS_APP_ENGAGEMENT"),
      @SerializedName("CANVAS_APP_INSTALLS")
      VALUE_CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"),
      @SerializedName("EVENT_RESPONSES")
      VALUE_EVENT_RESPONSES("EVENT_RESPONSES"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("LINK_CLICKS")
      VALUE_LINK_CLICKS("LINK_CLICKS"),
      @SerializedName("LOCAL_AWARENESS")
      VALUE_LOCAL_AWARENESS("LOCAL_AWARENESS"),
      @SerializedName("MESSAGES")
      VALUE_MESSAGES("MESSAGES"),
      @SerializedName("MOBILE_APP_ENGAGEMENT")
      VALUE_MOBILE_APP_ENGAGEMENT("MOBILE_APP_ENGAGEMENT"),
      @SerializedName("MOBILE_APP_INSTALLS")
      VALUE_MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("OFFER_CLAIMS")
      VALUE_OFFER_CLAIMS("OFFER_CLAIMS"),
      @SerializedName("PAGE_LIKES")
      VALUE_PAGE_LIKES("PAGE_LIKES"),
      @SerializedName("POST_ENGAGEMENT")
      VALUE_POST_ENGAGEMENT("POST_ENGAGEMENT"),
      @SerializedName("PRODUCT_CATALOG_SALES")
      VALUE_PRODUCT_CATALOG_SALES("PRODUCT_CATALOG_SALES"),
      @SerializedName("VIDEO_VIEWS")
      VALUE_VIDEO_VIEWS("VIDEO_VIEWS"),
      @SerializedName("WEBSITE_CONVERSIONS")
      VALUE_WEBSITE_CONVERSIONS("WEBSITE_CONVERSIONS"),
      ;

      private String value;

      private EnumObjectiveOld(String value) {
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

  public AdCampaignGroupActivity copyFrom(AdCampaignGroupActivity instance) {
    this.mBudgetLimitNew = instance.mBudgetLimitNew;
    this.mBudgetLimitOld = instance.mBudgetLimitOld;
    this.mBuyingTypeNew = instance.mBuyingTypeNew;
    this.mBuyingTypeOld = instance.mBuyingTypeOld;
    this.mEventTime = instance.mEventTime;
    this.mEventType = instance.mEventType;
    this.mId = instance.mId;
    this.mIsAutobidNew = instance.mIsAutobidNew;
    this.mIsAutobidOld = instance.mIsAutobidOld;
    this.mIsAveragePricePacingNew = instance.mIsAveragePricePacingNew;
    this.mIsAveragePricePacingOld = instance.mIsAveragePricePacingOld;
    this.mNameNew = instance.mNameNew;
    this.mNameOld = instance.mNameOld;
    this.mObjectiveNew = instance.mObjectiveNew;
    this.mObjectiveOld = instance.mObjectiveOld;
    this.mPacingType = instance.mPacingType;
    this.mRunStatusNew = instance.mRunStatusNew;
    this.mRunStatusOld = instance.mRunStatusOld;
    this.mSpendCapNew = instance.mSpendCapNew;
    this.mSpendCapOld = instance.mSpendCapOld;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdatedNew = instance.mTimeUpdatedNew;
    this.mTimeUpdatedOld = instance.mTimeUpdatedOld;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCampaignGroupActivity> getParser() {
    return new APIRequest.ResponseParser<AdCampaignGroupActivity>() {
      public APINodeList<AdCampaignGroupActivity> parseResponse(String response, APIContext context, APIRequest<AdCampaignGroupActivity> request, String header) throws MalformedResponseException {
        return AdCampaignGroupActivity.parseResponse(response, context, request, header);
      }
    };
  }
}
