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
  protected static Gson gson = null;

  public AdContract() {
  }

  public String getId() {
    return null;
  }
  public static AdContract loadJSON(String json, APIContext context, String header) {
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
      }
    }
    adContract.context = context;
    adContract.rawValue = json;
    adContract.header = header;
    return adContract;
  }

  public static APINodeList<AdContract> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdContract> adContracts = new APINodeList<AdContract>(request, json, header);
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
          adContracts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
              adContracts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adContracts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adContracts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adContracts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adContracts.add(loadJSON(entry.getValue().toString(), context, header));
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
              adContracts.add(loadJSON(value.toString(), context, header));
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
          adContracts.add(loadJSON(json, context, header));
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public AdContract setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public String getFieldAccountMgrFbid() {
    return mAccountMgrFbid;
  }

  public AdContract setFieldAccountMgrFbid(String value) {
    this.mAccountMgrFbid = value;
    return this;
  }

  public String getFieldAccountMgrName() {
    return mAccountMgrName;
  }

  public AdContract setFieldAccountMgrName(String value) {
    this.mAccountMgrName = value;
    return this;
  }

  public String getFieldAdopsPersonName() {
    return mAdopsPersonName;
  }

  public AdContract setFieldAdopsPersonName(String value) {
    this.mAdopsPersonName = value;
    return this;
  }

  public String getFieldAdvertiserAddressFbid() {
    return mAdvertiserAddressFbid;
  }

  public AdContract setFieldAdvertiserAddressFbid(String value) {
    this.mAdvertiserAddressFbid = value;
    return this;
  }

  public String getFieldAdvertiserFbid() {
    return mAdvertiserFbid;
  }

  public AdContract setFieldAdvertiserFbid(String value) {
    this.mAdvertiserFbid = value;
    return this;
  }

  public String getFieldAdvertiserName() {
    return mAdvertiserName;
  }

  public AdContract setFieldAdvertiserName(String value) {
    this.mAdvertiserName = value;
    return this;
  }

  public Double getFieldAgencyDiscount() {
    return mAgencyDiscount;
  }

  public AdContract setFieldAgencyDiscount(Double value) {
    this.mAgencyDiscount = value;
    return this;
  }

  public String getFieldAgencyName() {
    return mAgencyName;
  }

  public AdContract setFieldAgencyName(String value) {
    this.mAgencyName = value;
    return this;
  }

  public String getFieldBillToAddressFbid() {
    return mBillToAddressFbid;
  }

  public AdContract setFieldBillToAddressFbid(String value) {
    this.mBillToAddressFbid = value;
    return this;
  }

  public String getFieldBillToFbid() {
    return mBillToFbid;
  }

  public AdContract setFieldBillToFbid(String value) {
    this.mBillToFbid = value;
    return this;
  }

  public String getFieldCampaignName() {
    return mCampaignName;
  }

  public AdContract setFieldCampaignName(String value) {
    this.mCampaignName = value;
    return this;
  }

  public String getFieldCreatedBy() {
    return mCreatedBy;
  }

  public AdContract setFieldCreatedBy(String value) {
    this.mCreatedBy = value;
    return this;
  }

  public Long getFieldCreatedDate() {
    return mCreatedDate;
  }

  public AdContract setFieldCreatedDate(Long value) {
    this.mCreatedDate = value;
    return this;
  }

  public String getFieldCustomerIo() {
    return mCustomerIo;
  }

  public AdContract setFieldCustomerIo(String value) {
    this.mCustomerIo = value;
    return this;
  }

  public Long getFieldIoNumber() {
    return mIoNumber;
  }

  public AdContract setFieldIoNumber(Long value) {
    this.mIoNumber = value;
    return this;
  }

  public String getFieldIoTerms() {
    return mIoTerms;
  }

  public AdContract setFieldIoTerms(String value) {
    this.mIoTerms = value;
    return this;
  }

  public String getFieldIoType() {
    return mIoType;
  }

  public AdContract setFieldIoType(String value) {
    this.mIoType = value;
    return this;
  }

  public String getFieldLastUpdatedBy() {
    return mLastUpdatedBy;
  }

  public AdContract setFieldLastUpdatedBy(String value) {
    this.mLastUpdatedBy = value;
    return this;
  }

  public Long getFieldLastUpdatedDate() {
    return mLastUpdatedDate;
  }

  public AdContract setFieldLastUpdatedDate(Long value) {
    this.mLastUpdatedDate = value;
    return this;
  }

  public Long getFieldMaxEndDate() {
    return mMaxEndDate;
  }

  public AdContract setFieldMaxEndDate(Long value) {
    this.mMaxEndDate = value;
    return this;
  }

  public String getFieldMdcFbid() {
    return mMdcFbid;
  }

  public AdContract setFieldMdcFbid(String value) {
    this.mMdcFbid = value;
    return this;
  }

  public String getFieldMediaPlanNumber() {
    return mMediaPlanNumber;
  }

  public AdContract setFieldMediaPlanNumber(String value) {
    this.mMediaPlanNumber = value;
    return this;
  }

  public Long getFieldMinStartDate() {
    return mMinStartDate;
  }

  public AdContract setFieldMinStartDate(Long value) {
    this.mMinStartDate = value;
    return this;
  }

  public String getFieldMsaContract() {
    return mMsaContract;
  }

  public AdContract setFieldMsaContract(String value) {
    this.mMsaContract = value;
    return this;
  }

  public String getFieldPaymentTerms() {
    return mPaymentTerms;
  }

  public AdContract setFieldPaymentTerms(String value) {
    this.mPaymentTerms = value;
    return this;
  }

  public Boolean getFieldRevHoldFlag() {
    return mRevHoldFlag;
  }

  public AdContract setFieldRevHoldFlag(Boolean value) {
    this.mRevHoldFlag = value;
    return this;
  }

  public Long getFieldRevHoldReleasedBy() {
    return mRevHoldReleasedBy;
  }

  public AdContract setFieldRevHoldReleasedBy(Long value) {
    this.mRevHoldReleasedBy = value;
    return this;
  }

  public Long getFieldRevHoldReleasedOn() {
    return mRevHoldReleasedOn;
  }

  public AdContract setFieldRevHoldReleasedOn(Long value) {
    this.mRevHoldReleasedOn = value;
    return this;
  }

  public String getFieldSalesrepFbid() {
    return mSalesrepFbid;
  }

  public AdContract setFieldSalesrepFbid(String value) {
    this.mSalesrepFbid = value;
    return this;
  }

  public String getFieldSalesrepName() {
    return mSalesrepName;
  }

  public AdContract setFieldSalesrepName(String value) {
    this.mSalesrepName = value;
    return this;
  }

  public String getFieldSoldToAddressFbid() {
    return mSoldToAddressFbid;
  }

  public AdContract setFieldSoldToAddressFbid(String value) {
    this.mSoldToAddressFbid = value;
    return this;
  }

  public String getFieldSoldToFbid() {
    return mSoldToFbid;
  }

  public AdContract setFieldSoldToFbid(String value) {
    this.mSoldToFbid = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public AdContract setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public String getFieldSubvertical() {
    return mSubvertical;
  }

  public AdContract setFieldSubvertical(String value) {
    this.mSubvertical = value;
    return this;
  }

  public Long getFieldThirdpartyBilled() {
    return mThirdpartyBilled;
  }

  public AdContract setFieldThirdpartyBilled(Long value) {
    this.mThirdpartyBilled = value;
    return this;
  }

  public String getFieldThirdpartyUid() {
    return mThirdpartyUid;
  }

  public AdContract setFieldThirdpartyUid(String value) {
    this.mThirdpartyUid = value;
    return this;
  }

  public String getFieldThirdpartyUrl() {
    return mThirdpartyUrl;
  }

  public AdContract setFieldThirdpartyUrl(String value) {
    this.mThirdpartyUrl = value;
    return this;
  }

  public String getFieldVatCountry() {
    return mVatCountry;
  }

  public AdContract setFieldVatCountry(String value) {
    this.mVatCountry = value;
    return this;
  }

  public Long getFieldVersion() {
    return mVersion;
  }

  public AdContract setFieldVersion(Long value) {
    this.mVersion = value;
    return this;
  }

  public String getFieldVertical() {
    return mVertical;
  }

  public AdContract setFieldVertical(String value) {
    this.mVertical = value;
    return this;
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
    this.mThirdpartyUid = instance.mThirdpartyUid;
    this.mThirdpartyUrl = instance.mThirdpartyUrl;
    this.mVatCountry = instance.mVatCountry;
    this.mVersion = instance.mVersion;
    this.mVertical = instance.mVertical;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdContract> getParser() {
    return new APIRequest.ResponseParser<AdContract>() {
      public APINodeList<AdContract> parseResponse(String response, APIContext context, APIRequest<AdContract> request, String header) throws MalformedResponseException {
        return AdContract.parseResponse(response, context, request, header);
      }
    };
  }
}
