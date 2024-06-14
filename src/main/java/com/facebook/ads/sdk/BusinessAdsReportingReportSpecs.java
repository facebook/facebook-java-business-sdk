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
public class BusinessAdsReportingReportSpecs extends APINode {
  @SerializedName("action_report_time")
  private String mActionReportTime = null;
  @SerializedName("ad_account_id")
  private String mAdAccountId = null;
  @SerializedName("ad_account_ids")
  private List<String> mAdAccountIds = null;
  @SerializedName("ad_accounts")
  private List<Object> mAdAccounts = null;
  @SerializedName("attribution_windows")
  private List<String> mAttributionWindows = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("business_asset_group")
  private BusinessAssetGroup mBusinessAssetGroup = null;
  @SerializedName("comparison_date_interval")
  private Object mComparisonDateInterval = null;
  @SerializedName("creation_source")
  private String mCreationSource = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("date_preset")
  private String mDatePreset = null;
  @SerializedName("default_attribution_windows")
  private List<String> mDefaultAttributionWindows = null;
  @SerializedName("filtering")
  private List<Object> mFiltering = null;
  @SerializedName("formatting")
  private List<Map<String, List<Object>>> mFormatting = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_access_by")
  private Profile mLastAccessBy = null;
  @SerializedName("last_access_time")
  private String mLastAccessTime = null;
  @SerializedName("last_report_snapshot_id")
  private String mLastReportSnapshotId = null;
  @SerializedName("last_report_snapshot_time")
  private String mLastReportSnapshotTime = null;
  @SerializedName("last_shared_report_expiration")
  private String mLastSharedReportExpiration = null;
  @SerializedName("limit")
  private Long mLimit = null;
  @SerializedName("locked_dimensions")
  private Long mLockedDimensions = null;
  @SerializedName("report_name")
  private String mReportName = null;
  @SerializedName("report_snapshot_async_percent_completion")
  private Long mReportSnapshotAsyncPercentCompletion = null;
  @SerializedName("report_snapshot_async_status")
  private String mReportSnapshotAsyncStatus = null;
  @SerializedName("schedule_frequency")
  private String mScheduleFrequency = null;
  @SerializedName("scope")
  private String mScope = null;
  @SerializedName("show_deprecate_aw_banner")
  private Boolean mShowDeprecateAwBanner = null;
  @SerializedName("sorting")
  private List<Object> mSorting = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("subscribers")
  private List<String> mSubscribers = null;
  @SerializedName("update_by")
  private Profile mUpdateBy = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  @SerializedName("user")
  private Profile mUser = null;
  @SerializedName("user_dimensions")
  private List<String> mUserDimensions = null;
  @SerializedName("user_metrics")
  private List<String> mUserMetrics = null;
  @SerializedName("view_type")
  private String mViewType = null;
  protected static Gson gson = null;

  public BusinessAdsReportingReportSpecs() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static BusinessAdsReportingReportSpecs loadJSON(String json, APIContext context, String header) {
    BusinessAdsReportingReportSpecs businessAdsReportingReportSpecs = getGson().fromJson(json, BusinessAdsReportingReportSpecs.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessAdsReportingReportSpecs.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessAdsReportingReportSpecs.context = context;
    businessAdsReportingReportSpecs.rawValue = json;
    businessAdsReportingReportSpecs.header = header;
    return businessAdsReportingReportSpecs;
  }

  public static APINodeList<BusinessAdsReportingReportSpecs> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessAdsReportingReportSpecs> businessAdsReportingReportSpecss = new APINodeList<BusinessAdsReportingReportSpecs>(request, json, header);
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
          businessAdsReportingReportSpecss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessAdsReportingReportSpecss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessAdsReportingReportSpecss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessAdsReportingReportSpecss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessAdsReportingReportSpecss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessAdsReportingReportSpecss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessAdsReportingReportSpecss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessAdsReportingReportSpecss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessAdsReportingReportSpecss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessAdsReportingReportSpecss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessAdsReportingReportSpecss;
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
              businessAdsReportingReportSpecss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessAdsReportingReportSpecss;
          }

          // Sixth, check if it's pure JsonObject
          businessAdsReportingReportSpecss.clear();
          businessAdsReportingReportSpecss.add(loadJSON(json, context, header));
          return businessAdsReportingReportSpecss;
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


  public String getFieldActionReportTime() {
    return mActionReportTime;
  }

  public BusinessAdsReportingReportSpecs setFieldActionReportTime(String value) {
    this.mActionReportTime = value;
    return this;
  }

  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public BusinessAdsReportingReportSpecs setFieldAdAccountId(String value) {
    this.mAdAccountId = value;
    return this;
  }

  public List<String> getFieldAdAccountIds() {
    return mAdAccountIds;
  }

  public BusinessAdsReportingReportSpecs setFieldAdAccountIds(List<String> value) {
    this.mAdAccountIds = value;
    return this;
  }

  public List<Object> getFieldAdAccounts() {
    return mAdAccounts;
  }

  public BusinessAdsReportingReportSpecs setFieldAdAccounts(List<Object> value) {
    this.mAdAccounts = value;
    return this;
  }

  public List<String> getFieldAttributionWindows() {
    return mAttributionWindows;
  }

  public BusinessAdsReportingReportSpecs setFieldAttributionWindows(List<String> value) {
    this.mAttributionWindows = value;
    return this;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public BusinessAdsReportingReportSpecs setFieldBusiness(Business value) {
    this.mBusiness = value;
    return this;
  }

  public BusinessAdsReportingReportSpecs setFieldBusiness(String value) {
    Type type = new TypeToken<Business>(){}.getType();
    this.mBusiness = Business.getGson().fromJson(value, type);
    return this;
  }
  public BusinessAssetGroup getFieldBusinessAssetGroup() {
    if (mBusinessAssetGroup != null) {
      mBusinessAssetGroup.context = getContext();
    }
    return mBusinessAssetGroup;
  }

  public BusinessAdsReportingReportSpecs setFieldBusinessAssetGroup(BusinessAssetGroup value) {
    this.mBusinessAssetGroup = value;
    return this;
  }

  public BusinessAdsReportingReportSpecs setFieldBusinessAssetGroup(String value) {
    Type type = new TypeToken<BusinessAssetGroup>(){}.getType();
    this.mBusinessAssetGroup = BusinessAssetGroup.getGson().fromJson(value, type);
    return this;
  }
  public Object getFieldComparisonDateInterval() {
    return mComparisonDateInterval;
  }

  public BusinessAdsReportingReportSpecs setFieldComparisonDateInterval(Object value) {
    this.mComparisonDateInterval = value;
    return this;
  }

  public String getFieldCreationSource() {
    return mCreationSource;
  }

  public BusinessAdsReportingReportSpecs setFieldCreationSource(String value) {
    this.mCreationSource = value;
    return this;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public BusinessAdsReportingReportSpecs setFieldCreationTime(String value) {
    this.mCreationTime = value;
    return this;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public BusinessAdsReportingReportSpecs setFieldCurrency(String value) {
    this.mCurrency = value;
    return this;
  }

  public String getFieldDatePreset() {
    return mDatePreset;
  }

  public BusinessAdsReportingReportSpecs setFieldDatePreset(String value) {
    this.mDatePreset = value;
    return this;
  }

  public List<String> getFieldDefaultAttributionWindows() {
    return mDefaultAttributionWindows;
  }

  public BusinessAdsReportingReportSpecs setFieldDefaultAttributionWindows(List<String> value) {
    this.mDefaultAttributionWindows = value;
    return this;
  }

  public List<Object> getFieldFiltering() {
    return mFiltering;
  }

  public BusinessAdsReportingReportSpecs setFieldFiltering(List<Object> value) {
    this.mFiltering = value;
    return this;
  }

  public List<Map<String, List<Object>>> getFieldFormatting() {
    return mFormatting;
  }

  public BusinessAdsReportingReportSpecs setFieldFormatting(List<Map<String, List<Object>>> value) {
    this.mFormatting = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public BusinessAdsReportingReportSpecs setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Profile getFieldLastAccessBy() {
    if (mLastAccessBy != null) {
      mLastAccessBy.context = getContext();
    }
    return mLastAccessBy;
  }

  public BusinessAdsReportingReportSpecs setFieldLastAccessBy(Profile value) {
    this.mLastAccessBy = value;
    return this;
  }

  public BusinessAdsReportingReportSpecs setFieldLastAccessBy(String value) {
    Type type = new TypeToken<Profile>(){}.getType();
    this.mLastAccessBy = Profile.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldLastAccessTime() {
    return mLastAccessTime;
  }

  public BusinessAdsReportingReportSpecs setFieldLastAccessTime(String value) {
    this.mLastAccessTime = value;
    return this;
  }

  public String getFieldLastReportSnapshotId() {
    return mLastReportSnapshotId;
  }

  public BusinessAdsReportingReportSpecs setFieldLastReportSnapshotId(String value) {
    this.mLastReportSnapshotId = value;
    return this;
  }

  public String getFieldLastReportSnapshotTime() {
    return mLastReportSnapshotTime;
  }

  public BusinessAdsReportingReportSpecs setFieldLastReportSnapshotTime(String value) {
    this.mLastReportSnapshotTime = value;
    return this;
  }

  public String getFieldLastSharedReportExpiration() {
    return mLastSharedReportExpiration;
  }

  public BusinessAdsReportingReportSpecs setFieldLastSharedReportExpiration(String value) {
    this.mLastSharedReportExpiration = value;
    return this;
  }

  public Long getFieldLimit() {
    return mLimit;
  }

  public BusinessAdsReportingReportSpecs setFieldLimit(Long value) {
    this.mLimit = value;
    return this;
  }

  public Long getFieldLockedDimensions() {
    return mLockedDimensions;
  }

  public BusinessAdsReportingReportSpecs setFieldLockedDimensions(Long value) {
    this.mLockedDimensions = value;
    return this;
  }

  public String getFieldReportName() {
    return mReportName;
  }

  public BusinessAdsReportingReportSpecs setFieldReportName(String value) {
    this.mReportName = value;
    return this;
  }

  public Long getFieldReportSnapshotAsyncPercentCompletion() {
    return mReportSnapshotAsyncPercentCompletion;
  }

  public BusinessAdsReportingReportSpecs setFieldReportSnapshotAsyncPercentCompletion(Long value) {
    this.mReportSnapshotAsyncPercentCompletion = value;
    return this;
  }

  public String getFieldReportSnapshotAsyncStatus() {
    return mReportSnapshotAsyncStatus;
  }

  public BusinessAdsReportingReportSpecs setFieldReportSnapshotAsyncStatus(String value) {
    this.mReportSnapshotAsyncStatus = value;
    return this;
  }

  public String getFieldScheduleFrequency() {
    return mScheduleFrequency;
  }

  public BusinessAdsReportingReportSpecs setFieldScheduleFrequency(String value) {
    this.mScheduleFrequency = value;
    return this;
  }

  public String getFieldScope() {
    return mScope;
  }

  public BusinessAdsReportingReportSpecs setFieldScope(String value) {
    this.mScope = value;
    return this;
  }

  public Boolean getFieldShowDeprecateAwBanner() {
    return mShowDeprecateAwBanner;
  }

  public BusinessAdsReportingReportSpecs setFieldShowDeprecateAwBanner(Boolean value) {
    this.mShowDeprecateAwBanner = value;
    return this;
  }

  public List<Object> getFieldSorting() {
    return mSorting;
  }

  public BusinessAdsReportingReportSpecs setFieldSorting(List<Object> value) {
    this.mSorting = value;
    return this;
  }

  public String getFieldStartDate() {
    return mStartDate;
  }

  public BusinessAdsReportingReportSpecs setFieldStartDate(String value) {
    this.mStartDate = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public BusinessAdsReportingReportSpecs setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public List<String> getFieldSubscribers() {
    return mSubscribers;
  }

  public BusinessAdsReportingReportSpecs setFieldSubscribers(List<String> value) {
    this.mSubscribers = value;
    return this;
  }

  public Profile getFieldUpdateBy() {
    if (mUpdateBy != null) {
      mUpdateBy.context = getContext();
    }
    return mUpdateBy;
  }

  public BusinessAdsReportingReportSpecs setFieldUpdateBy(Profile value) {
    this.mUpdateBy = value;
    return this;
  }

  public BusinessAdsReportingReportSpecs setFieldUpdateBy(String value) {
    Type type = new TypeToken<Profile>(){}.getType();
    this.mUpdateBy = Profile.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldUpdateTime() {
    return mUpdateTime;
  }

  public BusinessAdsReportingReportSpecs setFieldUpdateTime(String value) {
    this.mUpdateTime = value;
    return this;
  }

  public Profile getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }

  public BusinessAdsReportingReportSpecs setFieldUser(Profile value) {
    this.mUser = value;
    return this;
  }

  public BusinessAdsReportingReportSpecs setFieldUser(String value) {
    Type type = new TypeToken<Profile>(){}.getType();
    this.mUser = Profile.getGson().fromJson(value, type);
    return this;
  }
  public List<String> getFieldUserDimensions() {
    return mUserDimensions;
  }

  public BusinessAdsReportingReportSpecs setFieldUserDimensions(List<String> value) {
    this.mUserDimensions = value;
    return this;
  }

  public List<String> getFieldUserMetrics() {
    return mUserMetrics;
  }

  public BusinessAdsReportingReportSpecs setFieldUserMetrics(List<String> value) {
    this.mUserMetrics = value;
    return this;
  }

  public String getFieldViewType() {
    return mViewType;
  }

  public BusinessAdsReportingReportSpecs setFieldViewType(String value) {
    this.mViewType = value;
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

  public BusinessAdsReportingReportSpecs copyFrom(BusinessAdsReportingReportSpecs instance) {
    this.mActionReportTime = instance.mActionReportTime;
    this.mAdAccountId = instance.mAdAccountId;
    this.mAdAccountIds = instance.mAdAccountIds;
    this.mAdAccounts = instance.mAdAccounts;
    this.mAttributionWindows = instance.mAttributionWindows;
    this.mBusiness = instance.mBusiness;
    this.mBusinessAssetGroup = instance.mBusinessAssetGroup;
    this.mComparisonDateInterval = instance.mComparisonDateInterval;
    this.mCreationSource = instance.mCreationSource;
    this.mCreationTime = instance.mCreationTime;
    this.mCurrency = instance.mCurrency;
    this.mDatePreset = instance.mDatePreset;
    this.mDefaultAttributionWindows = instance.mDefaultAttributionWindows;
    this.mFiltering = instance.mFiltering;
    this.mFormatting = instance.mFormatting;
    this.mId = instance.mId;
    this.mLastAccessBy = instance.mLastAccessBy;
    this.mLastAccessTime = instance.mLastAccessTime;
    this.mLastReportSnapshotId = instance.mLastReportSnapshotId;
    this.mLastReportSnapshotTime = instance.mLastReportSnapshotTime;
    this.mLastSharedReportExpiration = instance.mLastSharedReportExpiration;
    this.mLimit = instance.mLimit;
    this.mLockedDimensions = instance.mLockedDimensions;
    this.mReportName = instance.mReportName;
    this.mReportSnapshotAsyncPercentCompletion = instance.mReportSnapshotAsyncPercentCompletion;
    this.mReportSnapshotAsyncStatus = instance.mReportSnapshotAsyncStatus;
    this.mScheduleFrequency = instance.mScheduleFrequency;
    this.mScope = instance.mScope;
    this.mShowDeprecateAwBanner = instance.mShowDeprecateAwBanner;
    this.mSorting = instance.mSorting;
    this.mStartDate = instance.mStartDate;
    this.mStatus = instance.mStatus;
    this.mSubscribers = instance.mSubscribers;
    this.mUpdateBy = instance.mUpdateBy;
    this.mUpdateTime = instance.mUpdateTime;
    this.mUser = instance.mUser;
    this.mUserDimensions = instance.mUserDimensions;
    this.mUserMetrics = instance.mUserMetrics;
    this.mViewType = instance.mViewType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessAdsReportingReportSpecs> getParser() {
    return new APIRequest.ResponseParser<BusinessAdsReportingReportSpecs>() {
      public APINodeList<BusinessAdsReportingReportSpecs> parseResponse(String response, APIContext context, APIRequest<BusinessAdsReportingReportSpecs> request, String header) throws MalformedResponseException {
        return BusinessAdsReportingReportSpecs.parseResponse(response, context, request, header);
      }
    };
  }
}
