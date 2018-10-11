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
public class AdContract extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_mgr_fbid")
  private String mAccountMgrFbid = null;
  @SerializedName("account_mgr_name")
  private String mAccountMgrName = null;
  @SerializedName("adops_person_name")
  private String mAdopsPersonName = null;
  @SerializedName("advertiser_address_fbid")
  private String mAdvertiserAddressFbid = null;
  @SerializedName("advertiser_fbid")
  private String mAdvertiserFbid = null;
  @SerializedName("advertiser_name")
  private String mAdvertiserName = null;
  @SerializedName("agency_discount")
  private Double mAgencyDiscount = null;
  @SerializedName("agency_name")
  private String mAgencyName = null;
  @SerializedName("bill_to_address_fbid")
  private String mBillToAddressFbid = null;
  @SerializedName("bill_to_fbid")
  private String mBillToFbid = null;
  @SerializedName("campaign_name")
  private String mCampaignName = null;
  @SerializedName("created_by")
  private String mCreatedBy = null;
  @SerializedName("created_date")
  private Long mCreatedDate = null;
  @SerializedName("customer_io")
  private String mCustomerIo = null;
  @SerializedName("io_number")
  private Long mIoNumber = null;
  @SerializedName("io_terms")
  private String mIoTerms = null;
  @SerializedName("io_type")
  private String mIoType = null;
  @SerializedName("last_updated_by")
  private String mLastUpdatedBy = null;
  @SerializedName("last_updated_date")
  private Long mLastUpdatedDate = null;
  @SerializedName("max_end_date")
  private Long mMaxEndDate = null;
  @SerializedName("mdc_fbid")
  private String mMdcFbid = null;
  @SerializedName("media_plan_number")
  private String mMediaPlanNumber = null;
  @SerializedName("min_start_date")
  private Long mMinStartDate = null;
  @SerializedName("msa_contract")
  private String mMsaContract = null;
  @SerializedName("payment_terms")
  private String mPaymentTerms = null;
  @SerializedName("rev_hold_flag")
  private Boolean mRevHoldFlag = null;
  @SerializedName("rev_hold_released_by")
  private Long mRevHoldReleasedBy = null;
  @SerializedName("rev_hold_released_on")
  private Long mRevHoldReleasedOn = null;
  @SerializedName("salesrep_fbid")
  private String mSalesrepFbid = null;
  @SerializedName("salesrep_name")
  private String mSalesrepName = null;
  @SerializedName("sold_to_address_fbid")
  private String mSoldToAddressFbid = null;
  @SerializedName("sold_to_fbid")
  private String mSoldToFbid = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("subvertical")
  private String mSubvertical = null;
  @SerializedName("thirdparty_billed")
  private Long mThirdpartyBilled = null;
  @SerializedName("thirdparty_password")
  private String mThirdpartyPassword = null;
  @SerializedName("thirdparty_uid")
  private String mThirdpartyUid = null;
  @SerializedName("thirdparty_url")
  private String mThirdpartyUrl = null;
  @SerializedName("vat_country")
  private String mVatCountry = null;
  @SerializedName("version")
  private Long mVersion = null;
  @SerializedName("vertical")
  private String mVertical = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdContract() {
  }

  public AdContract(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdContract(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdContract fetch() throws APIException{
    AdContract newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdContract fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdContract> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdContract fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdContract> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdContract> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdContract>)(
      new APIRequest<AdContract>(context, "", "/", "GET", AdContract.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdContract>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdContract.getParser())
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
  public static AdContract loadJSON(String json, APIContext context) {
    AdContract adContract = getGson().fromJson(json, AdContract.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adContract.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adContract.context = context;
    adContract.rawValue = json;
    return adContract;
  }

  public static APINodeList<AdContract> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdContract> adContracts = new APINodeList<AdContract>(request, json);
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
          adContracts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adContracts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adContracts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adContracts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adContracts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adContracts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adContracts.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adContracts.add(loadJSON(obj.toString(), context));
            }
          }
          return adContracts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adContracts.add(loadJSON(entry.getValue().toString(), context));
          }
          return adContracts;
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
              adContracts.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adContracts;
          }

          // Sixth, check if it's pure JsonObject
          adContracts.clear();
          adContracts.add(loadJSON(json, context));
          return adContracts;
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

  public String getFieldAccountMgrFbid() {
    return mAccountMgrFbid;
  }

  public String getFieldAccountMgrName() {
    return mAccountMgrName;
  }

  public String getFieldAdopsPersonName() {
    return mAdopsPersonName;
  }

  public String getFieldAdvertiserAddressFbid() {
    return mAdvertiserAddressFbid;
  }

  public String getFieldAdvertiserFbid() {
    return mAdvertiserFbid;
  }

  public String getFieldAdvertiserName() {
    return mAdvertiserName;
  }

  public Double getFieldAgencyDiscount() {
    return mAgencyDiscount;
  }

  public String getFieldAgencyName() {
    return mAgencyName;
  }

  public String getFieldBillToAddressFbid() {
    return mBillToAddressFbid;
  }

  public String getFieldBillToFbid() {
    return mBillToFbid;
  }

  public String getFieldCampaignName() {
    return mCampaignName;
  }

  public String getFieldCreatedBy() {
    return mCreatedBy;
  }

  public Long getFieldCreatedDate() {
    return mCreatedDate;
  }

  public String getFieldCustomerIo() {
    return mCustomerIo;
  }

  public Long getFieldIoNumber() {
    return mIoNumber;
  }

  public String getFieldIoTerms() {
    return mIoTerms;
  }

  public String getFieldIoType() {
    return mIoType;
  }

  public String getFieldLastUpdatedBy() {
    return mLastUpdatedBy;
  }

  public Long getFieldLastUpdatedDate() {
    return mLastUpdatedDate;
  }

  public Long getFieldMaxEndDate() {
    return mMaxEndDate;
  }

  public String getFieldMdcFbid() {
    return mMdcFbid;
  }

  public String getFieldMediaPlanNumber() {
    return mMediaPlanNumber;
  }

  public Long getFieldMinStartDate() {
    return mMinStartDate;
  }

  public String getFieldMsaContract() {
    return mMsaContract;
  }

  public String getFieldPaymentTerms() {
    return mPaymentTerms;
  }

  public Boolean getFieldRevHoldFlag() {
    return mRevHoldFlag;
  }

  public Long getFieldRevHoldReleasedBy() {
    return mRevHoldReleasedBy;
  }

  public Long getFieldRevHoldReleasedOn() {
    return mRevHoldReleasedOn;
  }

  public String getFieldSalesrepFbid() {
    return mSalesrepFbid;
  }

  public String getFieldSalesrepName() {
    return mSalesrepName;
  }

  public String getFieldSoldToAddressFbid() {
    return mSoldToAddressFbid;
  }

  public String getFieldSoldToFbid() {
    return mSoldToFbid;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldSubvertical() {
    return mSubvertical;
  }

  public Long getFieldThirdpartyBilled() {
    return mThirdpartyBilled;
  }

  public String getFieldThirdpartyPassword() {
    return mThirdpartyPassword;
  }

  public String getFieldThirdpartyUid() {
    return mThirdpartyUid;
  }

  public String getFieldThirdpartyUrl() {
    return mThirdpartyUrl;
  }

  public String getFieldVatCountry() {
    return mVatCountry;
  }

  public Long getFieldVersion() {
    return mVersion;
  }

  public String getFieldVertical() {
    return mVertical;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdContract> {

    AdContract lastResponse = null;
    @Override
    public AdContract getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "account_mgr_fbid",
      "account_mgr_name",
      "adops_person_name",
      "advertiser_address_fbid",
      "advertiser_fbid",
      "advertiser_name",
      "agency_discount",
      "agency_name",
      "bill_to_address_fbid",
      "bill_to_fbid",
      "campaign_name",
      "created_by",
      "created_date",
      "customer_io",
      "io_number",
      "io_terms",
      "io_type",
      "last_updated_by",
      "last_updated_date",
      "max_end_date",
      "mdc_fbid",
      "media_plan_number",
      "min_start_date",
      "msa_contract",
      "payment_terms",
      "rev_hold_flag",
      "rev_hold_released_by",
      "rev_hold_released_on",
      "salesrep_fbid",
      "salesrep_name",
      "sold_to_address_fbid",
      "sold_to_fbid",
      "status",
      "subvertical",
      "thirdparty_billed",
      "thirdparty_password",
      "thirdparty_uid",
      "thirdparty_url",
      "vat_country",
      "version",
      "vertical",
      "id",
    };

    @Override
    public AdContract parseResponse(String response) throws APIException {
      return AdContract.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdContract execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdContract execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdContract> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdContract> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdContract>() {
           public AdContract apply(String result) {
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
    public APIRequestGet requestAccountMgrFbidField () {
      return this.requestAccountMgrFbidField(true);
    }
    public APIRequestGet requestAccountMgrFbidField (boolean value) {
      this.requestField("account_mgr_fbid", value);
      return this;
    }
    public APIRequestGet requestAccountMgrNameField () {
      return this.requestAccountMgrNameField(true);
    }
    public APIRequestGet requestAccountMgrNameField (boolean value) {
      this.requestField("account_mgr_name", value);
      return this;
    }
    public APIRequestGet requestAdopsPersonNameField () {
      return this.requestAdopsPersonNameField(true);
    }
    public APIRequestGet requestAdopsPersonNameField (boolean value) {
      this.requestField("adops_person_name", value);
      return this;
    }
    public APIRequestGet requestAdvertiserAddressFbidField () {
      return this.requestAdvertiserAddressFbidField(true);
    }
    public APIRequestGet requestAdvertiserAddressFbidField (boolean value) {
      this.requestField("advertiser_address_fbid", value);
      return this;
    }
    public APIRequestGet requestAdvertiserFbidField () {
      return this.requestAdvertiserFbidField(true);
    }
    public APIRequestGet requestAdvertiserFbidField (boolean value) {
      this.requestField("advertiser_fbid", value);
      return this;
    }
    public APIRequestGet requestAdvertiserNameField () {
      return this.requestAdvertiserNameField(true);
    }
    public APIRequestGet requestAdvertiserNameField (boolean value) {
      this.requestField("advertiser_name", value);
      return this;
    }
    public APIRequestGet requestAgencyDiscountField () {
      return this.requestAgencyDiscountField(true);
    }
    public APIRequestGet requestAgencyDiscountField (boolean value) {
      this.requestField("agency_discount", value);
      return this;
    }
    public APIRequestGet requestAgencyNameField () {
      return this.requestAgencyNameField(true);
    }
    public APIRequestGet requestAgencyNameField (boolean value) {
      this.requestField("agency_name", value);
      return this;
    }
    public APIRequestGet requestBillToAddressFbidField () {
      return this.requestBillToAddressFbidField(true);
    }
    public APIRequestGet requestBillToAddressFbidField (boolean value) {
      this.requestField("bill_to_address_fbid", value);
      return this;
    }
    public APIRequestGet requestBillToFbidField () {
      return this.requestBillToFbidField(true);
    }
    public APIRequestGet requestBillToFbidField (boolean value) {
      this.requestField("bill_to_fbid", value);
      return this;
    }
    public APIRequestGet requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGet requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
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
    public APIRequestGet requestCustomerIoField () {
      return this.requestCustomerIoField(true);
    }
    public APIRequestGet requestCustomerIoField (boolean value) {
      this.requestField("customer_io", value);
      return this;
    }
    public APIRequestGet requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGet requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGet requestIoTermsField () {
      return this.requestIoTermsField(true);
    }
    public APIRequestGet requestIoTermsField (boolean value) {
      this.requestField("io_terms", value);
      return this;
    }
    public APIRequestGet requestIoTypeField () {
      return this.requestIoTypeField(true);
    }
    public APIRequestGet requestIoTypeField (boolean value) {
      this.requestField("io_type", value);
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
    public APIRequestGet requestMaxEndDateField () {
      return this.requestMaxEndDateField(true);
    }
    public APIRequestGet requestMaxEndDateField (boolean value) {
      this.requestField("max_end_date", value);
      return this;
    }
    public APIRequestGet requestMdcFbidField () {
      return this.requestMdcFbidField(true);
    }
    public APIRequestGet requestMdcFbidField (boolean value) {
      this.requestField("mdc_fbid", value);
      return this;
    }
    public APIRequestGet requestMediaPlanNumberField () {
      return this.requestMediaPlanNumberField(true);
    }
    public APIRequestGet requestMediaPlanNumberField (boolean value) {
      this.requestField("media_plan_number", value);
      return this;
    }
    public APIRequestGet requestMinStartDateField () {
      return this.requestMinStartDateField(true);
    }
    public APIRequestGet requestMinStartDateField (boolean value) {
      this.requestField("min_start_date", value);
      return this;
    }
    public APIRequestGet requestMsaContractField () {
      return this.requestMsaContractField(true);
    }
    public APIRequestGet requestMsaContractField (boolean value) {
      this.requestField("msa_contract", value);
      return this;
    }
    public APIRequestGet requestPaymentTermsField () {
      return this.requestPaymentTermsField(true);
    }
    public APIRequestGet requestPaymentTermsField (boolean value) {
      this.requestField("payment_terms", value);
      return this;
    }
    public APIRequestGet requestRevHoldFlagField () {
      return this.requestRevHoldFlagField(true);
    }
    public APIRequestGet requestRevHoldFlagField (boolean value) {
      this.requestField("rev_hold_flag", value);
      return this;
    }
    public APIRequestGet requestRevHoldReleasedByField () {
      return this.requestRevHoldReleasedByField(true);
    }
    public APIRequestGet requestRevHoldReleasedByField (boolean value) {
      this.requestField("rev_hold_released_by", value);
      return this;
    }
    public APIRequestGet requestRevHoldReleasedOnField () {
      return this.requestRevHoldReleasedOnField(true);
    }
    public APIRequestGet requestRevHoldReleasedOnField (boolean value) {
      this.requestField("rev_hold_released_on", value);
      return this;
    }
    public APIRequestGet requestSalesrepFbidField () {
      return this.requestSalesrepFbidField(true);
    }
    public APIRequestGet requestSalesrepFbidField (boolean value) {
      this.requestField("salesrep_fbid", value);
      return this;
    }
    public APIRequestGet requestSalesrepNameField () {
      return this.requestSalesrepNameField(true);
    }
    public APIRequestGet requestSalesrepNameField (boolean value) {
      this.requestField("salesrep_name", value);
      return this;
    }
    public APIRequestGet requestSoldToAddressFbidField () {
      return this.requestSoldToAddressFbidField(true);
    }
    public APIRequestGet requestSoldToAddressFbidField (boolean value) {
      this.requestField("sold_to_address_fbid", value);
      return this;
    }
    public APIRequestGet requestSoldToFbidField () {
      return this.requestSoldToFbidField(true);
    }
    public APIRequestGet requestSoldToFbidField (boolean value) {
      this.requestField("sold_to_fbid", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestSubverticalField () {
      return this.requestSubverticalField(true);
    }
    public APIRequestGet requestSubverticalField (boolean value) {
      this.requestField("subvertical", value);
      return this;
    }
    public APIRequestGet requestThirdpartyBilledField () {
      return this.requestThirdpartyBilledField(true);
    }
    public APIRequestGet requestThirdpartyBilledField (boolean value) {
      this.requestField("thirdparty_billed", value);
      return this;
    }
    public APIRequestGet requestThirdpartyPasswordField () {
      return this.requestThirdpartyPasswordField(true);
    }
    public APIRequestGet requestThirdpartyPasswordField (boolean value) {
      this.requestField("thirdparty_password", value);
      return this;
    }
    public APIRequestGet requestThirdpartyUidField () {
      return this.requestThirdpartyUidField(true);
    }
    public APIRequestGet requestThirdpartyUidField (boolean value) {
      this.requestField("thirdparty_uid", value);
      return this;
    }
    public APIRequestGet requestThirdpartyUrlField () {
      return this.requestThirdpartyUrlField(true);
    }
    public APIRequestGet requestThirdpartyUrlField (boolean value) {
      this.requestField("thirdparty_url", value);
      return this;
    }
    public APIRequestGet requestVatCountryField () {
      return this.requestVatCountryField(true);
    }
    public APIRequestGet requestVatCountryField (boolean value) {
      this.requestField("vat_country", value);
      return this;
    }
    public APIRequestGet requestVersionField () {
      return this.requestVersionField(true);
    }
    public APIRequestGet requestVersionField (boolean value) {
      this.requestField("version", value);
      return this;
    }
    public APIRequestGet requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGet requestVerticalField (boolean value) {
      this.requestField("vertical", value);
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

  public AdContract copyFrom(AdContract instance) {
    this.mAccountId = instance.mAccountId;
    this.mAccountMgrFbid = instance.mAccountMgrFbid;
    this.mAccountMgrName = instance.mAccountMgrName;
    this.mAdopsPersonName = instance.mAdopsPersonName;
    this.mAdvertiserAddressFbid = instance.mAdvertiserAddressFbid;
    this.mAdvertiserFbid = instance.mAdvertiserFbid;
    this.mAdvertiserName = instance.mAdvertiserName;
    this.mAgencyDiscount = instance.mAgencyDiscount;
    this.mAgencyName = instance.mAgencyName;
    this.mBillToAddressFbid = instance.mBillToAddressFbid;
    this.mBillToFbid = instance.mBillToFbid;
    this.mCampaignName = instance.mCampaignName;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedDate = instance.mCreatedDate;
    this.mCustomerIo = instance.mCustomerIo;
    this.mIoNumber = instance.mIoNumber;
    this.mIoTerms = instance.mIoTerms;
    this.mIoType = instance.mIoType;
    this.mLastUpdatedBy = instance.mLastUpdatedBy;
    this.mLastUpdatedDate = instance.mLastUpdatedDate;
    this.mMaxEndDate = instance.mMaxEndDate;
    this.mMdcFbid = instance.mMdcFbid;
    this.mMediaPlanNumber = instance.mMediaPlanNumber;
    this.mMinStartDate = instance.mMinStartDate;
    this.mMsaContract = instance.mMsaContract;
    this.mPaymentTerms = instance.mPaymentTerms;
    this.mRevHoldFlag = instance.mRevHoldFlag;
    this.mRevHoldReleasedBy = instance.mRevHoldReleasedBy;
    this.mRevHoldReleasedOn = instance.mRevHoldReleasedOn;
    this.mSalesrepFbid = instance.mSalesrepFbid;
    this.mSalesrepName = instance.mSalesrepName;
    this.mSoldToAddressFbid = instance.mSoldToAddressFbid;
    this.mSoldToFbid = instance.mSoldToFbid;
    this.mStatus = instance.mStatus;
    this.mSubvertical = instance.mSubvertical;
    this.mThirdpartyBilled = instance.mThirdpartyBilled;
    this.mThirdpartyPassword = instance.mThirdpartyPassword;
    this.mThirdpartyUid = instance.mThirdpartyUid;
    this.mThirdpartyUrl = instance.mThirdpartyUrl;
    this.mVatCountry = instance.mVatCountry;
    this.mVersion = instance.mVersion;
    this.mVertical = instance.mVertical;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdContract> getParser() {
    return new APIRequest.ResponseParser<AdContract>() {
      public APINodeList<AdContract> parseResponse(String response, APIContext context, APIRequest<AdContract> request) throws MalformedResponseException {
        return AdContract.parseResponse(response, context, request);
      }
    };
  }
}
