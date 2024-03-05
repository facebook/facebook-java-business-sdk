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
public class OmegaCustomerTrx extends APINode {
  @SerializedName("ad_account_ids")
  private List<String> mAdAccountIds = null;
  @SerializedName("advertiser_name")
  private String mAdvertiserName = null;
  @SerializedName("amount")
  private String mAmount = null;
  @SerializedName("amount_due")
  private CurrencyAmount mAmountDue = null;
  @SerializedName("billed_amount_details")
  private Object mBilledAmountDetails = null;
  @SerializedName("billing_period")
  private String mBillingPeriod = null;
  @SerializedName("cdn_download_uri")
  private String mCdnDownloadUri = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("download_uri")
  private String mDownloadUri = null;
  @SerializedName("due_date")
  private String mDueDate = null;
  @SerializedName("entity")
  private String mEntity = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("invoice_date")
  private String mInvoiceDate = null;
  @SerializedName("invoice_id")
  private String mInvoiceId = null;
  @SerializedName("invoice_type")
  private String mInvoiceType = null;
  @SerializedName("liability_type")
  private String mLiabilityType = null;
  @SerializedName("payment_status")
  private String mPaymentStatus = null;
  @SerializedName("payment_term")
  private String mPaymentTerm = null;
  @SerializedName("type")
  private String mType = null;
  protected static Gson gson = null;

  OmegaCustomerTrx() {
  }

  public OmegaCustomerTrx(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public OmegaCustomerTrx(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public OmegaCustomerTrx fetch() throws APIException{
    OmegaCustomerTrx newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static OmegaCustomerTrx fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<OmegaCustomerTrx> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static OmegaCustomerTrx fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<OmegaCustomerTrx> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<OmegaCustomerTrx> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<OmegaCustomerTrx>)(
      new APIRequest<OmegaCustomerTrx>(context, "", "/", "GET", OmegaCustomerTrx.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<OmegaCustomerTrx>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", OmegaCustomerTrx.getParser())
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
  public static OmegaCustomerTrx loadJSON(String json, APIContext context, String header) {
    OmegaCustomerTrx omegaCustomerTrx = getGson().fromJson(json, OmegaCustomerTrx.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(omegaCustomerTrx.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    omegaCustomerTrx.context = context;
    omegaCustomerTrx.rawValue = json;
    omegaCustomerTrx.header = header;
    return omegaCustomerTrx;
  }

  public static APINodeList<OmegaCustomerTrx> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<OmegaCustomerTrx> omegaCustomerTrxs = new APINodeList<OmegaCustomerTrx>(request, json, header);
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
          omegaCustomerTrxs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return omegaCustomerTrxs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                omegaCustomerTrxs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            omegaCustomerTrxs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              omegaCustomerTrxs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              omegaCustomerTrxs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  omegaCustomerTrxs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              omegaCustomerTrxs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return omegaCustomerTrxs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              omegaCustomerTrxs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return omegaCustomerTrxs;
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
              omegaCustomerTrxs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return omegaCustomerTrxs;
          }

          // Sixth, check if it's pure JsonObject
          omegaCustomerTrxs.clear();
          omegaCustomerTrxs.add(loadJSON(json, context, header));
          return omegaCustomerTrxs;
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

  public APIRequestGetCampaigns getCampaigns() {
    return new APIRequestGetCampaigns(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public List<String> getFieldAdAccountIds() {
    return mAdAccountIds;
  }

  public String getFieldAdvertiserName() {
    return mAdvertiserName;
  }

  public String getFieldAmount() {
    return mAmount;
  }

  public CurrencyAmount getFieldAmountDue() {
    return mAmountDue;
  }

  public Object getFieldBilledAmountDetails() {
    return mBilledAmountDetails;
  }

  public String getFieldBillingPeriod() {
    return mBillingPeriod;
  }

  public String getFieldCdnDownloadUri() {
    return mCdnDownloadUri;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDownloadUri() {
    return mDownloadUri;
  }

  public String getFieldDueDate() {
    return mDueDate;
  }

  public String getFieldEntity() {
    return mEntity;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInvoiceDate() {
    return mInvoiceDate;
  }

  public String getFieldInvoiceId() {
    return mInvoiceId;
  }

  public String getFieldInvoiceType() {
    return mInvoiceType;
  }

  public String getFieldLiabilityType() {
    return mLiabilityType;
  }

  public String getFieldPaymentStatus() {
    return mPaymentStatus;
  }

  public String getFieldPaymentTerm() {
    return mPaymentTerm;
  }

  public String getFieldType() {
    return mType;
  }



  public static class APIRequestGetCampaigns extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCampaigns.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetCampaigns(String nodeId, APIContext context) {
      super(context, nodeId, "/campaigns", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCampaigns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCampaigns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCampaigns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCampaigns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaigns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCampaigns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaigns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCampaigns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<OmegaCustomerTrx> {

    OmegaCustomerTrx lastResponse = null;
    @Override
    public OmegaCustomerTrx getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_ids",
      "advertiser_name",
      "amount",
      "amount_due",
      "billed_amount_details",
      "billing_period",
      "cdn_download_uri",
      "currency",
      "download_uri",
      "due_date",
      "entity",
      "id",
      "invoice_date",
      "invoice_id",
      "invoice_type",
      "liability_type",
      "payment_status",
      "payment_term",
      "type",
    };

    @Override
    public OmegaCustomerTrx parseResponse(String response, String header) throws APIException {
      return OmegaCustomerTrx.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OmegaCustomerTrx execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OmegaCustomerTrx execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OmegaCustomerTrx> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OmegaCustomerTrx> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OmegaCustomerTrx>() {
           public OmegaCustomerTrx apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdAccountIdsField () {
      return this.requestAdAccountIdsField(true);
    }
    public APIRequestGet requestAdAccountIdsField (boolean value) {
      this.requestField("ad_account_ids", value);
      return this;
    }
    public APIRequestGet requestAdvertiserNameField () {
      return this.requestAdvertiserNameField(true);
    }
    public APIRequestGet requestAdvertiserNameField (boolean value) {
      this.requestField("advertiser_name", value);
      return this;
    }
    public APIRequestGet requestAmountField () {
      return this.requestAmountField(true);
    }
    public APIRequestGet requestAmountField (boolean value) {
      this.requestField("amount", value);
      return this;
    }
    public APIRequestGet requestAmountDueField () {
      return this.requestAmountDueField(true);
    }
    public APIRequestGet requestAmountDueField (boolean value) {
      this.requestField("amount_due", value);
      return this;
    }
    public APIRequestGet requestBilledAmountDetailsField () {
      return this.requestBilledAmountDetailsField(true);
    }
    public APIRequestGet requestBilledAmountDetailsField (boolean value) {
      this.requestField("billed_amount_details", value);
      return this;
    }
    public APIRequestGet requestBillingPeriodField () {
      return this.requestBillingPeriodField(true);
    }
    public APIRequestGet requestBillingPeriodField (boolean value) {
      this.requestField("billing_period", value);
      return this;
    }
    public APIRequestGet requestCdnDownloadUriField () {
      return this.requestCdnDownloadUriField(true);
    }
    public APIRequestGet requestCdnDownloadUriField (boolean value) {
      this.requestField("cdn_download_uri", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDownloadUriField () {
      return this.requestDownloadUriField(true);
    }
    public APIRequestGet requestDownloadUriField (boolean value) {
      this.requestField("download_uri", value);
      return this;
    }
    public APIRequestGet requestDueDateField () {
      return this.requestDueDateField(true);
    }
    public APIRequestGet requestDueDateField (boolean value) {
      this.requestField("due_date", value);
      return this;
    }
    public APIRequestGet requestEntityField () {
      return this.requestEntityField(true);
    }
    public APIRequestGet requestEntityField (boolean value) {
      this.requestField("entity", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInvoiceDateField () {
      return this.requestInvoiceDateField(true);
    }
    public APIRequestGet requestInvoiceDateField (boolean value) {
      this.requestField("invoice_date", value);
      return this;
    }
    public APIRequestGet requestInvoiceIdField () {
      return this.requestInvoiceIdField(true);
    }
    public APIRequestGet requestInvoiceIdField (boolean value) {
      this.requestField("invoice_id", value);
      return this;
    }
    public APIRequestGet requestInvoiceTypeField () {
      return this.requestInvoiceTypeField(true);
    }
    public APIRequestGet requestInvoiceTypeField (boolean value) {
      this.requestField("invoice_type", value);
      return this;
    }
    public APIRequestGet requestLiabilityTypeField () {
      return this.requestLiabilityTypeField(true);
    }
    public APIRequestGet requestLiabilityTypeField (boolean value) {
      this.requestField("liability_type", value);
      return this;
    }
    public APIRequestGet requestPaymentStatusField () {
      return this.requestPaymentStatusField(true);
    }
    public APIRequestGet requestPaymentStatusField (boolean value) {
      this.requestField("payment_status", value);
      return this;
    }
    public APIRequestGet requestPaymentTermField () {
      return this.requestPaymentTermField(true);
    }
    public APIRequestGet requestPaymentTermField (boolean value) {
      this.requestField("payment_term", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static enum EnumType {
      @SerializedName("CM")
      VALUE_CM("CM"),
      @SerializedName("DM")
      VALUE_DM("DM"),
      @SerializedName("INV")
      VALUE_INV("INV"),
      @SerializedName("PRO_FORMA")
      VALUE_PRO_FORMA("PRO_FORMA"),
      ;

      private String value;

      private EnumType(String value) {
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

  public OmegaCustomerTrx copyFrom(OmegaCustomerTrx instance) {
    this.mAdAccountIds = instance.mAdAccountIds;
    this.mAdvertiserName = instance.mAdvertiserName;
    this.mAmount = instance.mAmount;
    this.mAmountDue = instance.mAmountDue;
    this.mBilledAmountDetails = instance.mBilledAmountDetails;
    this.mBillingPeriod = instance.mBillingPeriod;
    this.mCdnDownloadUri = instance.mCdnDownloadUri;
    this.mCurrency = instance.mCurrency;
    this.mDownloadUri = instance.mDownloadUri;
    this.mDueDate = instance.mDueDate;
    this.mEntity = instance.mEntity;
    this.mId = instance.mId;
    this.mInvoiceDate = instance.mInvoiceDate;
    this.mInvoiceId = instance.mInvoiceId;
    this.mInvoiceType = instance.mInvoiceType;
    this.mLiabilityType = instance.mLiabilityType;
    this.mPaymentStatus = instance.mPaymentStatus;
    this.mPaymentTerm = instance.mPaymentTerm;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<OmegaCustomerTrx> getParser() {
    return new APIRequest.ResponseParser<OmegaCustomerTrx>() {
      public APINodeList<OmegaCustomerTrx> parseResponse(String response, APIContext context, APIRequest<OmegaCustomerTrx> request, String header) throws MalformedResponseException {
        return OmegaCustomerTrx.parseResponse(response, context, request, header);
      }
    };
  }
}
