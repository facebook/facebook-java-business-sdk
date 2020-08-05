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
public class OracleTransaction extends APINode {
  @SerializedName("ad_account_ids")
  private List<String> mAdAccountIds = null;
  @SerializedName("amount")
  private String mAmount = null;
  @SerializedName("amount_due")
  private CurrencyAmount mAmountDue = null;
  @SerializedName("billed_amount_details")
  private BilledAmountDetails mBilledAmountDetails = null;
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

  OracleTransaction() {
  }

  public OracleTransaction(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public OracleTransaction(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public OracleTransaction fetch() throws APIException{
    OracleTransaction newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static OracleTransaction fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<OracleTransaction> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static OracleTransaction fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<OracleTransaction> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<OracleTransaction> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<OracleTransaction>)(
      new APIRequest<OracleTransaction>(context, "", "/", "GET", OracleTransaction.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<OracleTransaction>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", OracleTransaction.getParser())
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
  public static OracleTransaction loadJSON(String json, APIContext context, String header) {
    OracleTransaction oracleTransaction = getGson().fromJson(json, OracleTransaction.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(oracleTransaction.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    oracleTransaction.context = context;
    oracleTransaction.rawValue = json;
    oracleTransaction.header = header;
    return oracleTransaction;
  }

  public static APINodeList<OracleTransaction> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<OracleTransaction> oracleTransactions = new APINodeList<OracleTransaction>(request, json, header);
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
          oracleTransactions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return oracleTransactions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                oracleTransactions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            oracleTransactions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              oracleTransactions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              oracleTransactions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  oracleTransactions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              oracleTransactions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return oracleTransactions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              oracleTransactions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return oracleTransactions;
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
              oracleTransactions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return oracleTransactions;
          }

          // Sixth, check if it's pure JsonObject
          oracleTransactions.clear();
          oracleTransactions.add(loadJSON(json, context, header));
          return oracleTransactions;
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

  public String getFieldAmount() {
    return mAmount;
  }

  public CurrencyAmount getFieldAmountDue() {
    return mAmountDue;
  }

  public BilledAmountDetails getFieldBilledAmountDetails() {
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



  public static class APIRequestGetCampaigns extends APIRequest<InvoiceCampaign> {

    APINodeList<InvoiceCampaign> lastResponse = null;
    @Override
    public APINodeList<InvoiceCampaign> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_id",
      "billed_amount_details",
      "campaign_id",
      "campaign_name",
      "clicks",
      "conversions",
      "impressions",
      "tags",
    };

    @Override
    public APINodeList<InvoiceCampaign> parseResponse(String response, String header) throws APIException {
      return InvoiceCampaign.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InvoiceCampaign> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InvoiceCampaign> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InvoiceCampaign>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InvoiceCampaign>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InvoiceCampaign>>() {
           public APINodeList<InvoiceCampaign> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCampaigns.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGetCampaigns requestAdAccountIdField () {
      return this.requestAdAccountIdField(true);
    }
    public APIRequestGetCampaigns requestAdAccountIdField (boolean value) {
      this.requestField("ad_account_id", value);
      return this;
    }
    public APIRequestGetCampaigns requestBilledAmountDetailsField () {
      return this.requestBilledAmountDetailsField(true);
    }
    public APIRequestGetCampaigns requestBilledAmountDetailsField (boolean value) {
      this.requestField("billed_amount_details", value);
      return this;
    }
    public APIRequestGetCampaigns requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetCampaigns requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetCampaigns requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGetCampaigns requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGetCampaigns requestClicksField () {
      return this.requestClicksField(true);
    }
    public APIRequestGetCampaigns requestClicksField (boolean value) {
      this.requestField("clicks", value);
      return this;
    }
    public APIRequestGetCampaigns requestConversionsField () {
      return this.requestConversionsField(true);
    }
    public APIRequestGetCampaigns requestConversionsField (boolean value) {
      this.requestField("conversions", value);
      return this;
    }
    public APIRequestGetCampaigns requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGetCampaigns requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGetCampaigns requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetCampaigns requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<OracleTransaction> {

    OracleTransaction lastResponse = null;
    @Override
    public OracleTransaction getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_ids",
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
    public OracleTransaction parseResponse(String response, String header) throws APIException {
      return OracleTransaction.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OracleTransaction execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OracleTransaction execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OracleTransaction> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OracleTransaction> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OracleTransaction>() {
           public OracleTransaction apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdAccountIdsField () {
      return this.requestAdAccountIdsField(true);
    }
    public APIRequestGet requestAdAccountIdsField (boolean value) {
      this.requestField("ad_account_ids", value);
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
      @SerializedName("INV")
      VALUE_INV("INV"),
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

  public OracleTransaction copyFrom(OracleTransaction instance) {
    this.mAdAccountIds = instance.mAdAccountIds;
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

  public static APIRequest.ResponseParser<OracleTransaction> getParser() {
    return new APIRequest.ResponseParser<OracleTransaction>() {
      public APINodeList<OracleTransaction> parseResponse(String response, APIContext context, APIRequest<OracleTransaction> request, String header) throws MalformedResponseException {
        return OracleTransaction.parseResponse(response, context, request, header);
      }
    };
  }
}
