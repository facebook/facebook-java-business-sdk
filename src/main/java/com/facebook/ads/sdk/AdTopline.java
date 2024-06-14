/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
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
import com.google.common.util.concurrent.MoreExecutors;
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
public class AdTopline extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("client_approval_date")
  private String mClientApprovalDate = null;
  @SerializedName("created_by")
  private String mCreatedBy = null;
  @SerializedName("created_date")
  private String mCreatedDate = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("flight_end_date")
  private String mFlightEndDate = null;
  @SerializedName("flight_start_date")
  private String mFlightStartDate = null;
  @SerializedName("func_cap_amount")
  private String mFuncCapAmount = null;
  @SerializedName("func_cap_amount_with_offset")
  private String mFuncCapAmountWithOffset = null;
  @SerializedName("func_line_amount")
  private String mFuncLineAmount = null;
  @SerializedName("func_line_amount_with_offset")
  private String mFuncLineAmountWithOffset = null;
  @SerializedName("func_price")
  private String mFuncPrice = null;
  @SerializedName("func_price_with_offset")
  private String mFuncPriceWithOffset = null;
  @SerializedName("gender")
  private String mGender = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("impressions")
  private Long mImpressions = null;
  @SerializedName("io_number")
  private Long mIoNumber = null;
  @SerializedName("is_bonus_line")
  private Long mIsBonusLine = null;
  @SerializedName("keywords")
  private String mKeywords = null;
  @SerializedName("last_updated_by")
  private String mLastUpdatedBy = null;
  @SerializedName("last_updated_date")
  private String mLastUpdatedDate = null;
  @SerializedName("line_number")
  private Long mLineNumber = null;
  @SerializedName("line_position")
  private Long mLinePosition = null;
  @SerializedName("line_type")
  private String mLineType = null;
  @SerializedName("location")
  private String mLocation = null;
  @SerializedName("max_age")
  private String mMaxAge = null;
  @SerializedName("max_budget")
  private String mMaxBudget = null;
  @SerializedName("min_age")
  private String mMinAge = null;
  @SerializedName("price_per_trp")
  private String mPricePerTrp = null;
  @SerializedName("product_type")
  private String mProductType = null;
  @SerializedName("rev_assurance_approval_date")
  private String mRevAssuranceApprovalDate = null;
  @SerializedName("targets")
  private String mTargets = null;
  @SerializedName("trp_updated_time")
  private Long mTrpUpdatedTime = null;
  @SerializedName("trp_value")
  private String mTrpValue = null;
  @SerializedName("uom")
  private String mUom = null;
  protected static Gson gson = null;

  AdTopline() {
  }

  public AdTopline(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdTopline(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdTopline fetch() throws APIException{
    AdTopline newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdTopline fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdTopline> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdTopline fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdTopline> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdTopline> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdTopline>)(
      new APIRequest<AdTopline>(context, "", "/", "GET", AdTopline.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdTopline>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdTopline.getParser())
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
  public static AdTopline loadJSON(String json, APIContext context, String header) {
    AdTopline adTopline = getGson().fromJson(json, AdTopline.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adTopline.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adTopline.context = context;
    adTopline.rawValue = json;
    adTopline.header = header;
    return adTopline;
  }

  public static APINodeList<AdTopline> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdTopline> adToplines = new APINodeList<AdTopline>(request, json, header);
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
          adToplines.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adToplines;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adToplines.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adToplines.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adToplines.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adToplines.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adToplines.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adToplines.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adToplines;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adToplines.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adToplines;
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
              adToplines.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adToplines;
          }

          // Sixth, check if it's pure JsonObject
          adToplines.clear();
          adToplines.add(loadJSON(json, context, header));
          return adToplines;
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

  public String getFieldClientApprovalDate() {
    return mClientApprovalDate;
  }

  public String getFieldCreatedBy() {
    return mCreatedBy;
  }

  public String getFieldCreatedDate() {
    return mCreatedDate;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldFlightEndDate() {
    return mFlightEndDate;
  }

  public String getFieldFlightStartDate() {
    return mFlightStartDate;
  }

  public String getFieldFuncCapAmount() {
    return mFuncCapAmount;
  }

  public String getFieldFuncCapAmountWithOffset() {
    return mFuncCapAmountWithOffset;
  }

  public String getFieldFuncLineAmount() {
    return mFuncLineAmount;
  }

  public String getFieldFuncLineAmountWithOffset() {
    return mFuncLineAmountWithOffset;
  }

  public String getFieldFuncPrice() {
    return mFuncPrice;
  }

  public String getFieldFuncPriceWithOffset() {
    return mFuncPriceWithOffset;
  }

  public String getFieldGender() {
    return mGender;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldImpressions() {
    return mImpressions;
  }

  public Long getFieldIoNumber() {
    return mIoNumber;
  }

  public Long getFieldIsBonusLine() {
    return mIsBonusLine;
  }

  public String getFieldKeywords() {
    return mKeywords;
  }

  public String getFieldLastUpdatedBy() {
    return mLastUpdatedBy;
  }

  public String getFieldLastUpdatedDate() {
    return mLastUpdatedDate;
  }

  public Long getFieldLineNumber() {
    return mLineNumber;
  }

  public Long getFieldLinePosition() {
    return mLinePosition;
  }

  public String getFieldLineType() {
    return mLineType;
  }

  public String getFieldLocation() {
    return mLocation;
  }

  public String getFieldMaxAge() {
    return mMaxAge;
  }

  public String getFieldMaxBudget() {
    return mMaxBudget;
  }

  public String getFieldMinAge() {
    return mMinAge;
  }

  public String getFieldPricePerTrp() {
    return mPricePerTrp;
  }

  public String getFieldProductType() {
    return mProductType;
  }

  public String getFieldRevAssuranceApprovalDate() {
    return mRevAssuranceApprovalDate;
  }

  public String getFieldTargets() {
    return mTargets;
  }

  public Long getFieldTrpUpdatedTime() {
    return mTrpUpdatedTime;
  }

  public String getFieldTrpValue() {
    return mTrpValue;
  }

  public String getFieldUom() {
    return mUom;
  }



  public static class APIRequestGet extends APIRequest<AdTopline> {

    AdTopline lastResponse = null;
    @Override
    public AdTopline getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "client_approval_date",
      "created_by",
      "created_date",
      "description",
      "flight_end_date",
      "flight_start_date",
      "func_cap_amount",
      "func_cap_amount_with_offset",
      "func_line_amount",
      "func_line_amount_with_offset",
      "func_price",
      "func_price_with_offset",
      "gender",
      "id",
      "impressions",
      "io_number",
      "is_bonus_line",
      "keywords",
      "last_updated_by",
      "last_updated_date",
      "line_number",
      "line_position",
      "line_type",
      "location",
      "max_age",
      "max_budget",
      "min_age",
      "price_per_trp",
      "product_type",
      "rev_assurance_approval_date",
      "targets",
      "trp_updated_time",
      "trp_value",
      "uom",
    };

    @Override
    public AdTopline parseResponse(String response, String header) throws APIException {
      return AdTopline.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdTopline execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdTopline execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdTopline> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdTopline> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdTopline>() {
           public AdTopline apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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
    public APIRequestGet requestClientApprovalDateField () {
      return this.requestClientApprovalDateField(true);
    }
    public APIRequestGet requestClientApprovalDateField (boolean value) {
      this.requestField("client_approval_date", value);
      return this;
    }
    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestCreatedDateField () {
      return this.requestCreatedDateField(true);
    }
    public APIRequestGet requestCreatedDateField (boolean value) {
      this.requestField("created_date", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestFlightEndDateField () {
      return this.requestFlightEndDateField(true);
    }
    public APIRequestGet requestFlightEndDateField (boolean value) {
      this.requestField("flight_end_date", value);
      return this;
    }
    public APIRequestGet requestFlightStartDateField () {
      return this.requestFlightStartDateField(true);
    }
    public APIRequestGet requestFlightStartDateField (boolean value) {
      this.requestField("flight_start_date", value);
      return this;
    }
    public APIRequestGet requestFuncCapAmountField () {
      return this.requestFuncCapAmountField(true);
    }
    public APIRequestGet requestFuncCapAmountField (boolean value) {
      this.requestField("func_cap_amount", value);
      return this;
    }
    public APIRequestGet requestFuncCapAmountWithOffsetField () {
      return this.requestFuncCapAmountWithOffsetField(true);
    }
    public APIRequestGet requestFuncCapAmountWithOffsetField (boolean value) {
      this.requestField("func_cap_amount_with_offset", value);
      return this;
    }
    public APIRequestGet requestFuncLineAmountField () {
      return this.requestFuncLineAmountField(true);
    }
    public APIRequestGet requestFuncLineAmountField (boolean value) {
      this.requestField("func_line_amount", value);
      return this;
    }
    public APIRequestGet requestFuncLineAmountWithOffsetField () {
      return this.requestFuncLineAmountWithOffsetField(true);
    }
    public APIRequestGet requestFuncLineAmountWithOffsetField (boolean value) {
      this.requestField("func_line_amount_with_offset", value);
      return this;
    }
    public APIRequestGet requestFuncPriceField () {
      return this.requestFuncPriceField(true);
    }
    public APIRequestGet requestFuncPriceField (boolean value) {
      this.requestField("func_price", value);
      return this;
    }
    public APIRequestGet requestFuncPriceWithOffsetField () {
      return this.requestFuncPriceWithOffsetField(true);
    }
    public APIRequestGet requestFuncPriceWithOffsetField (boolean value) {
      this.requestField("func_price_with_offset", value);
      return this;
    }
    public APIRequestGet requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGet requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGet requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGet requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGet requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGet requestIsBonusLineField () {
      return this.requestIsBonusLineField(true);
    }
    public APIRequestGet requestIsBonusLineField (boolean value) {
      this.requestField("is_bonus_line", value);
      return this;
    }
    public APIRequestGet requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGet requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedByField () {
      return this.requestLastUpdatedByField(true);
    }
    public APIRequestGet requestLastUpdatedByField (boolean value) {
      this.requestField("last_updated_by", value);
      return this;
    }
    public APIRequestGet requestLastUpdatedDateField () {
      return this.requestLastUpdatedDateField(true);
    }
    public APIRequestGet requestLastUpdatedDateField (boolean value) {
      this.requestField("last_updated_date", value);
      return this;
    }
    public APIRequestGet requestLineNumberField () {
      return this.requestLineNumberField(true);
    }
    public APIRequestGet requestLineNumberField (boolean value) {
      this.requestField("line_number", value);
      return this;
    }
    public APIRequestGet requestLinePositionField () {
      return this.requestLinePositionField(true);
    }
    public APIRequestGet requestLinePositionField (boolean value) {
      this.requestField("line_position", value);
      return this;
    }
    public APIRequestGet requestLineTypeField () {
      return this.requestLineTypeField(true);
    }
    public APIRequestGet requestLineTypeField (boolean value) {
      this.requestField("line_type", value);
      return this;
    }
    public APIRequestGet requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGet requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGet requestMaxAgeField () {
      return this.requestMaxAgeField(true);
    }
    public APIRequestGet requestMaxAgeField (boolean value) {
      this.requestField("max_age", value);
      return this;
    }
    public APIRequestGet requestMaxBudgetField () {
      return this.requestMaxBudgetField(true);
    }
    public APIRequestGet requestMaxBudgetField (boolean value) {
      this.requestField("max_budget", value);
      return this;
    }
    public APIRequestGet requestMinAgeField () {
      return this.requestMinAgeField(true);
    }
    public APIRequestGet requestMinAgeField (boolean value) {
      this.requestField("min_age", value);
      return this;
    }
    public APIRequestGet requestPricePerTrpField () {
      return this.requestPricePerTrpField(true);
    }
    public APIRequestGet requestPricePerTrpField (boolean value) {
      this.requestField("price_per_trp", value);
      return this;
    }
    public APIRequestGet requestProductTypeField () {
      return this.requestProductTypeField(true);
    }
    public APIRequestGet requestProductTypeField (boolean value) {
      this.requestField("product_type", value);
      return this;
    }
    public APIRequestGet requestRevAssuranceApprovalDateField () {
      return this.requestRevAssuranceApprovalDateField(true);
    }
    public APIRequestGet requestRevAssuranceApprovalDateField (boolean value) {
      this.requestField("rev_assurance_approval_date", value);
      return this;
    }
    public APIRequestGet requestTargetsField () {
      return this.requestTargetsField(true);
    }
    public APIRequestGet requestTargetsField (boolean value) {
      this.requestField("targets", value);
      return this;
    }
    public APIRequestGet requestTrpUpdatedTimeField () {
      return this.requestTrpUpdatedTimeField(true);
    }
    public APIRequestGet requestTrpUpdatedTimeField (boolean value) {
      this.requestField("trp_updated_time", value);
      return this;
    }
    public APIRequestGet requestTrpValueField () {
      return this.requestTrpValueField(true);
    }
    public APIRequestGet requestTrpValueField (boolean value) {
      this.requestField("trp_value", value);
      return this;
    }
    public APIRequestGet requestUomField () {
      return this.requestUomField(true);
    }
    public APIRequestGet requestUomField (boolean value) {
      this.requestField("uom", value);
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

  public AdTopline copyFrom(AdTopline instance) {
    this.mAccountId = instance.mAccountId;
    this.mClientApprovalDate = instance.mClientApprovalDate;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedDate = instance.mCreatedDate;
    this.mDescription = instance.mDescription;
    this.mFlightEndDate = instance.mFlightEndDate;
    this.mFlightStartDate = instance.mFlightStartDate;
    this.mFuncCapAmount = instance.mFuncCapAmount;
    this.mFuncCapAmountWithOffset = instance.mFuncCapAmountWithOffset;
    this.mFuncLineAmount = instance.mFuncLineAmount;
    this.mFuncLineAmountWithOffset = instance.mFuncLineAmountWithOffset;
    this.mFuncPrice = instance.mFuncPrice;
    this.mFuncPriceWithOffset = instance.mFuncPriceWithOffset;
    this.mGender = instance.mGender;
    this.mId = instance.mId;
    this.mImpressions = instance.mImpressions;
    this.mIoNumber = instance.mIoNumber;
    this.mIsBonusLine = instance.mIsBonusLine;
    this.mKeywords = instance.mKeywords;
    this.mLastUpdatedBy = instance.mLastUpdatedBy;
    this.mLastUpdatedDate = instance.mLastUpdatedDate;
    this.mLineNumber = instance.mLineNumber;
    this.mLinePosition = instance.mLinePosition;
    this.mLineType = instance.mLineType;
    this.mLocation = instance.mLocation;
    this.mMaxAge = instance.mMaxAge;
    this.mMaxBudget = instance.mMaxBudget;
    this.mMinAge = instance.mMinAge;
    this.mPricePerTrp = instance.mPricePerTrp;
    this.mProductType = instance.mProductType;
    this.mRevAssuranceApprovalDate = instance.mRevAssuranceApprovalDate;
    this.mTargets = instance.mTargets;
    this.mTrpUpdatedTime = instance.mTrpUpdatedTime;
    this.mTrpValue = instance.mTrpValue;
    this.mUom = instance.mUom;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdTopline> getParser() {
    return new APIRequest.ResponseParser<AdTopline>() {
      public APINodeList<AdTopline> parseResponse(String response, APIContext context, APIRequest<AdTopline> request, String header) throws MalformedResponseException {
        return AdTopline.parseResponse(response, context, request, header);
      }
    };
  }
}
