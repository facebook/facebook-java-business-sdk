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
public class DirectDeal extends APINode {
  @SerializedName("adbreaks_enabled")
  private Boolean mAdbreaksEnabled = null;
  @SerializedName("adset")
  private AdSet mAdset = null;
  @SerializedName("advertiser")
  private Object mAdvertiser = null;
  @SerializedName("advertiser_lead_email")
  private String mAdvertiserLeadEmail = null;
  @SerializedName("advertiser_page")
  private String mAdvertiserPage = null;
  @SerializedName("cpe_amount")
  private Long mCpeAmount = null;
  @SerializedName("cpe_currency")
  private String mCpeCurrency = null;
  @SerializedName("end_time")
  private Long mEndTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("lifetime_budget_amount")
  private Long mLifetimeBudgetAmount = null;
  @SerializedName("lifetime_budget_currency")
  private String mLifetimeBudgetCurrency = null;
  @SerializedName("lifetime_impressions")
  private Long mLifetimeImpressions = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("pages")
  private List<String> mPages = null;
  @SerializedName("placements")
  private List<String> mPlacements = null;
  @SerializedName("priced_by")
  private String mPricedBy = null;
  @SerializedName("publisher_name")
  private String mPublisherName = null;
  @SerializedName("review_requirement")
  private String mReviewRequirement = null;
  @SerializedName("sales_lead_email")
  private String mSalesLeadEmail = null;
  @SerializedName("start_time")
  private Long mStartTime = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("targeting")
  private Targeting mTargeting = null;
  protected static Gson gson = null;

  DirectDeal() {
  }

  public DirectDeal(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public DirectDeal(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public DirectDeal fetch() throws APIException{
    DirectDeal newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static DirectDeal fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<DirectDeal> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static DirectDeal fetchById(String id, APIContext context) throws APIException {
    DirectDeal directDeal =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return directDeal;
  }

  public static ListenableFuture<DirectDeal> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<DirectDeal> directDeal =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return directDeal;
  }

  public static APINodeList<DirectDeal> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<DirectDeal>)(
      new APIRequest<DirectDeal>(context, "", "/", "GET", DirectDeal.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<DirectDeal>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<DirectDeal>> directDeal =
      new APIRequest(context, "", "/", "GET", DirectDeal.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return directDeal;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static DirectDeal loadJSON(String json, APIContext context) {
    DirectDeal directDeal = getGson().fromJson(json, DirectDeal.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(directDeal.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    directDeal.context = context;
    directDeal.rawValue = json;
    return directDeal;
  }

  public static APINodeList<DirectDeal> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<DirectDeal> directDeals = new APINodeList<DirectDeal>(request, json);
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
          directDeals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return directDeals;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                directDeals.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            directDeals.setPaging(previous, next);
            if (context.hasAppSecret()) {
              directDeals.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              directDeals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  directDeals.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              directDeals.add(loadJSON(obj.toString(), context));
            }
          }
          return directDeals;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              directDeals.add(loadJSON(entry.getValue().toString(), context));
          }
          return directDeals;
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
              directDeals.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return directDeals;
          }

          // Sixth, check if it's pure JsonObject
          directDeals.clear();
          directDeals.add(loadJSON(json, context));
          return directDeals;
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


  public Boolean getFieldAdbreaksEnabled() {
    return mAdbreaksEnabled;
  }

  public AdSet getFieldAdset() {
    if (mAdset != null) {
      mAdset.context = getContext();
    }
    return mAdset;
  }

  public Object getFieldAdvertiser() {
    return mAdvertiser;
  }

  public String getFieldAdvertiserLeadEmail() {
    return mAdvertiserLeadEmail;
  }

  public String getFieldAdvertiserPage() {
    return mAdvertiserPage;
  }

  public Long getFieldCpeAmount() {
    return mCpeAmount;
  }

  public String getFieldCpeCurrency() {
    return mCpeCurrency;
  }

  public Long getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldLifetimeBudgetAmount() {
    return mLifetimeBudgetAmount;
  }

  public String getFieldLifetimeBudgetCurrency() {
    return mLifetimeBudgetCurrency;
  }

  public Long getFieldLifetimeImpressions() {
    return mLifetimeImpressions;
  }

  public String getFieldName() {
    return mName;
  }

  public List<String> getFieldPages() {
    return mPages;
  }

  public List<String> getFieldPlacements() {
    return mPlacements;
  }

  public String getFieldPricedBy() {
    return mPricedBy;
  }

  public String getFieldPublisherName() {
    return mPublisherName;
  }

  public String getFieldReviewRequirement() {
    return mReviewRequirement;
  }

  public String getFieldSalesLeadEmail() {
    return mSalesLeadEmail;
  }

  public Long getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public Targeting getFieldTargeting() {
    return mTargeting;
  }



  public static class APIRequestGet extends APIRequest<DirectDeal> {

    DirectDeal lastResponse = null;
    @Override
    public DirectDeal getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "adbreaks_enabled",
      "adset",
      "advertiser",
      "advertiser_lead_email",
      "advertiser_page",
      "cpe_amount",
      "cpe_currency",
      "end_time",
      "id",
      "lifetime_budget_amount",
      "lifetime_budget_currency",
      "lifetime_impressions",
      "name",
      "pages",
      "placements",
      "priced_by",
      "publisher_name",
      "review_requirement",
      "sales_lead_email",
      "start_time",
      "status",
      "targeting",
    };

    @Override
    public DirectDeal parseResponse(String response) throws APIException {
      return DirectDeal.parseResponse(response, getContext(), this).head();
    }

    @Override
    public DirectDeal execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public DirectDeal execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<DirectDeal> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<DirectDeal> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, DirectDeal>() {
           public DirectDeal apply(String result) {
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

    public APIRequestGet requestAdbreaksEnabledField () {
      return this.requestAdbreaksEnabledField(true);
    }
    public APIRequestGet requestAdbreaksEnabledField (boolean value) {
      this.requestField("adbreaks_enabled", value);
      return this;
    }
    public APIRequestGet requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGet requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGet requestAdvertiserField () {
      return this.requestAdvertiserField(true);
    }
    public APIRequestGet requestAdvertiserField (boolean value) {
      this.requestField("advertiser", value);
      return this;
    }
    public APIRequestGet requestAdvertiserLeadEmailField () {
      return this.requestAdvertiserLeadEmailField(true);
    }
    public APIRequestGet requestAdvertiserLeadEmailField (boolean value) {
      this.requestField("advertiser_lead_email", value);
      return this;
    }
    public APIRequestGet requestAdvertiserPageField () {
      return this.requestAdvertiserPageField(true);
    }
    public APIRequestGet requestAdvertiserPageField (boolean value) {
      this.requestField("advertiser_page", value);
      return this;
    }
    public APIRequestGet requestCpeAmountField () {
      return this.requestCpeAmountField(true);
    }
    public APIRequestGet requestCpeAmountField (boolean value) {
      this.requestField("cpe_amount", value);
      return this;
    }
    public APIRequestGet requestCpeCurrencyField () {
      return this.requestCpeCurrencyField(true);
    }
    public APIRequestGet requestCpeCurrencyField (boolean value) {
      this.requestField("cpe_currency", value);
      return this;
    }
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLifetimeBudgetAmountField () {
      return this.requestLifetimeBudgetAmountField(true);
    }
    public APIRequestGet requestLifetimeBudgetAmountField (boolean value) {
      this.requestField("lifetime_budget_amount", value);
      return this;
    }
    public APIRequestGet requestLifetimeBudgetCurrencyField () {
      return this.requestLifetimeBudgetCurrencyField(true);
    }
    public APIRequestGet requestLifetimeBudgetCurrencyField (boolean value) {
      this.requestField("lifetime_budget_currency", value);
      return this;
    }
    public APIRequestGet requestLifetimeImpressionsField () {
      return this.requestLifetimeImpressionsField(true);
    }
    public APIRequestGet requestLifetimeImpressionsField (boolean value) {
      this.requestField("lifetime_impressions", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPagesField () {
      return this.requestPagesField(true);
    }
    public APIRequestGet requestPagesField (boolean value) {
      this.requestField("pages", value);
      return this;
    }
    public APIRequestGet requestPlacementsField () {
      return this.requestPlacementsField(true);
    }
    public APIRequestGet requestPlacementsField (boolean value) {
      this.requestField("placements", value);
      return this;
    }
    public APIRequestGet requestPricedByField () {
      return this.requestPricedByField(true);
    }
    public APIRequestGet requestPricedByField (boolean value) {
      this.requestField("priced_by", value);
      return this;
    }
    public APIRequestGet requestPublisherNameField () {
      return this.requestPublisherNameField(true);
    }
    public APIRequestGet requestPublisherNameField (boolean value) {
      this.requestField("publisher_name", value);
      return this;
    }
    public APIRequestGet requestReviewRequirementField () {
      return this.requestReviewRequirementField(true);
    }
    public APIRequestGet requestReviewRequirementField (boolean value) {
      this.requestField("review_requirement", value);
      return this;
    }
    public APIRequestGet requestSalesLeadEmailField () {
      return this.requestSalesLeadEmailField(true);
    }
    public APIRequestGet requestSalesLeadEmailField (boolean value) {
      this.requestField("sales_lead_email", value);
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
    public APIRequestGet requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGet requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
  }

  public static enum EnumStatus {
      @SerializedName("0")
      VALUE_0("0"),
      @SerializedName("1")
      VALUE_1("1"),
      @SerializedName("2")
      VALUE_2("2"),
      @SerializedName("3")
      VALUE_3("3"),
      @SerializedName("4")
      VALUE_4("4"),
      @SerializedName("5")
      VALUE_5("5"),
      @SerializedName("6")
      VALUE_6("6"),
      NULL(null);

      private String value;

      private EnumStatus(String value) {
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

  public DirectDeal copyFrom(DirectDeal instance) {
    this.mAdbreaksEnabled = instance.mAdbreaksEnabled;
    this.mAdset = instance.mAdset;
    this.mAdvertiser = instance.mAdvertiser;
    this.mAdvertiserLeadEmail = instance.mAdvertiserLeadEmail;
    this.mAdvertiserPage = instance.mAdvertiserPage;
    this.mCpeAmount = instance.mCpeAmount;
    this.mCpeCurrency = instance.mCpeCurrency;
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mLifetimeBudgetAmount = instance.mLifetimeBudgetAmount;
    this.mLifetimeBudgetCurrency = instance.mLifetimeBudgetCurrency;
    this.mLifetimeImpressions = instance.mLifetimeImpressions;
    this.mName = instance.mName;
    this.mPages = instance.mPages;
    this.mPlacements = instance.mPlacements;
    this.mPricedBy = instance.mPricedBy;
    this.mPublisherName = instance.mPublisherName;
    this.mReviewRequirement = instance.mReviewRequirement;
    this.mSalesLeadEmail = instance.mSalesLeadEmail;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mTargeting = instance.mTargeting;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<DirectDeal> getParser() {
    return new APIRequest.ResponseParser<DirectDeal>() {
      public APINodeList<DirectDeal> parseResponse(String response, APIContext context, APIRequest<DirectDeal> request) throws MalformedResponseException {
        return DirectDeal.parseResponse(response, context, request);
      }
    };
  }
}
