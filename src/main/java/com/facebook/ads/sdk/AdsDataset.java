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
public class AdsDataset extends APINode {
  @SerializedName("can_proxy")
  private Boolean mCanProxy = null;
  @SerializedName("collection_rate")
  private Double mCollectionRate = null;
  @SerializedName("config")
  private String mConfig = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("dataset_id")
  private String mDatasetId = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("duplicate_entries")
  private Long mDuplicateEntries = null;
  @SerializedName("enable_auto_assign_to_accounts")
  private Boolean mEnableAutoAssignToAccounts = null;
  @SerializedName("enable_automatic_events")
  private Boolean mEnableAutomaticEvents = null;
  @SerializedName("enable_automatic_matching")
  private Boolean mEnableAutomaticMatching = null;
  @SerializedName("enable_real_time_event_log")
  private Boolean mEnableRealTimeEventLog = null;
  @SerializedName("event_stats")
  private String mEventStats = null;
  @SerializedName("event_time_max")
  private Long mEventTimeMax = null;
  @SerializedName("event_time_min")
  private Long mEventTimeMin = null;
  @SerializedName("first_party_cookie_status")
  private String mFirstPartyCookieStatus = null;
  @SerializedName("has_bapi_domains")
  private Boolean mHasBapiDomains = null;
  @SerializedName("has_catalog_microdata_activity")
  private Boolean mHasCatalogMicrodataActivity = null;
  @SerializedName("has_ofa_redacted_keys")
  private Boolean mHasOfaRedactedKeys = null;
  @SerializedName("has_sent_pii")
  private Boolean mHasSentPii = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_consolidated_container")
  private Boolean mIsConsolidatedContainer = null;
  @SerializedName("is_created_by_business")
  private Boolean mIsCreatedByBusiness = null;
  @SerializedName("is_crm")
  private Boolean mIsCrm = null;
  @SerializedName("is_eligible_for_sharing_to_ad_account")
  private Boolean mIsEligibleForSharingToAdAccount = null;
  @SerializedName("is_eligible_for_sharing_to_business")
  private Boolean mIsEligibleForSharingToBusiness = null;
  @SerializedName("is_eligible_for_value_optimization")
  private Boolean mIsEligibleForValueOptimization = null;
  @SerializedName("is_mta_use")
  private Boolean mIsMtaUse = null;
  @SerializedName("is_restricted_use")
  private Boolean mIsRestrictedUse = null;
  @SerializedName("is_unavailable")
  private Boolean mIsUnavailable = null;
  @SerializedName("last_fired_time")
  private String mLastFiredTime = null;
  @SerializedName("last_upload_app")
  private String mLastUploadApp = null;
  @SerializedName("last_upload_app_changed_time")
  private Long mLastUploadAppChangedTime = null;
  @SerializedName("last_upload_time")
  private Long mLastUploadTime = null;
  @SerializedName("late_upload_reminder_eligibility")
  private Boolean mLateUploadReminderEligibility = null;
  @SerializedName("match_rate_approx")
  private Long mMatchRateApprox = null;
  @SerializedName("matched_entries")
  private Long mMatchedEntries = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("no_ads_tracked_for_weekly_uploaded_events_reminder_eligibility")
  private Boolean mNoAdsTrackedForWeeklyUploadedEventsReminderEligibility = null;
  @SerializedName("num_active_ad_set_tracked")
  private Long mNumActiveAdSetTracked = null;
  @SerializedName("num_recent_offline_conversions_uploaded")
  private Long mNumRecentOfflineConversionsUploaded = null;
  @SerializedName("num_uploads")
  private Long mNumUploads = null;
  @SerializedName("owner_ad_account")
  private AdAccount mOwnerAdAccount = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("percentage_of_late_uploads_in_external_suboptimal_window")
  private Long mPercentageOfLateUploadsInExternalSuboptimalWindow = null;
  @SerializedName("permissions")
  private OfflineConversionDataSetPermissions mPermissions = null;
  @SerializedName("server_last_fired_time")
  private String mServerLastFiredTime = null;
  @SerializedName("show_automatic_events")
  private Boolean mShowAutomaticEvents = null;
  @SerializedName("upload_rate")
  private Double mUploadRate = null;
  @SerializedName("upload_reminder_eligibility")
  private Boolean mUploadReminderEligibility = null;
  @SerializedName("usage")
  private OfflineConversionDataSetUsage mUsage = null;
  @SerializedName("valid_entries")
  private Long mValidEntries = null;
  protected static Gson gson = null;

  public AdsDataset() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdsDataset loadJSON(String json, APIContext context, String header) {
    AdsDataset adsDataset = getGson().fromJson(json, AdsDataset.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsDataset.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsDataset.context = context;
    adsDataset.rawValue = json;
    adsDataset.header = header;
    return adsDataset;
  }

  public static APINodeList<AdsDataset> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsDataset> adsDatasets = new APINodeList<AdsDataset>(request, json, header);
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
          adsDatasets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsDatasets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsDatasets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsDatasets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsDatasets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsDatasets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsDatasets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsDatasets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsDatasets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsDatasets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsDatasets;
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
              adsDatasets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsDatasets;
          }

          // Sixth, check if it's pure JsonObject
          adsDatasets.clear();
          adsDatasets.add(loadJSON(json, context, header));
          return adsDatasets;
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


  public Boolean getFieldCanProxy() {
    return mCanProxy;
  }

  public AdsDataset setFieldCanProxy(Boolean value) {
    this.mCanProxy = value;
    return this;
  }

  public Double getFieldCollectionRate() {
    return mCollectionRate;
  }

  public AdsDataset setFieldCollectionRate(Double value) {
    this.mCollectionRate = value;
    return this;
  }

  public String getFieldConfig() {
    return mConfig;
  }

  public AdsDataset setFieldConfig(String value) {
    this.mConfig = value;
    return this;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public AdsDataset setFieldCreationTime(String value) {
    this.mCreationTime = value;
    return this;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public AdsDataset setFieldCreator(User value) {
    this.mCreator = value;
    return this;
  }

  public AdsDataset setFieldCreator(String value) {
    Type type = new TypeToken<User>(){}.getType();
    this.mCreator = User.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldDatasetId() {
    return mDatasetId;
  }

  public AdsDataset setFieldDatasetId(String value) {
    this.mDatasetId = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public AdsDataset setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public Long getFieldDuplicateEntries() {
    return mDuplicateEntries;
  }

  public AdsDataset setFieldDuplicateEntries(Long value) {
    this.mDuplicateEntries = value;
    return this;
  }

  public Boolean getFieldEnableAutoAssignToAccounts() {
    return mEnableAutoAssignToAccounts;
  }

  public AdsDataset setFieldEnableAutoAssignToAccounts(Boolean value) {
    this.mEnableAutoAssignToAccounts = value;
    return this;
  }

  public Boolean getFieldEnableAutomaticEvents() {
    return mEnableAutomaticEvents;
  }

  public AdsDataset setFieldEnableAutomaticEvents(Boolean value) {
    this.mEnableAutomaticEvents = value;
    return this;
  }

  public Boolean getFieldEnableAutomaticMatching() {
    return mEnableAutomaticMatching;
  }

  public AdsDataset setFieldEnableAutomaticMatching(Boolean value) {
    this.mEnableAutomaticMatching = value;
    return this;
  }

  public Boolean getFieldEnableRealTimeEventLog() {
    return mEnableRealTimeEventLog;
  }

  public AdsDataset setFieldEnableRealTimeEventLog(Boolean value) {
    this.mEnableRealTimeEventLog = value;
    return this;
  }

  public String getFieldEventStats() {
    return mEventStats;
  }

  public AdsDataset setFieldEventStats(String value) {
    this.mEventStats = value;
    return this;
  }

  public Long getFieldEventTimeMax() {
    return mEventTimeMax;
  }

  public AdsDataset setFieldEventTimeMax(Long value) {
    this.mEventTimeMax = value;
    return this;
  }

  public Long getFieldEventTimeMin() {
    return mEventTimeMin;
  }

  public AdsDataset setFieldEventTimeMin(Long value) {
    this.mEventTimeMin = value;
    return this;
  }

  public String getFieldFirstPartyCookieStatus() {
    return mFirstPartyCookieStatus;
  }

  public AdsDataset setFieldFirstPartyCookieStatus(String value) {
    this.mFirstPartyCookieStatus = value;
    return this;
  }

  public Boolean getFieldHasBapiDomains() {
    return mHasBapiDomains;
  }

  public AdsDataset setFieldHasBapiDomains(Boolean value) {
    this.mHasBapiDomains = value;
    return this;
  }

  public Boolean getFieldHasCatalogMicrodataActivity() {
    return mHasCatalogMicrodataActivity;
  }

  public AdsDataset setFieldHasCatalogMicrodataActivity(Boolean value) {
    this.mHasCatalogMicrodataActivity = value;
    return this;
  }

  public Boolean getFieldHasOfaRedactedKeys() {
    return mHasOfaRedactedKeys;
  }

  public AdsDataset setFieldHasOfaRedactedKeys(Boolean value) {
    this.mHasOfaRedactedKeys = value;
    return this;
  }

  public Boolean getFieldHasSentPii() {
    return mHasSentPii;
  }

  public AdsDataset setFieldHasSentPii(Boolean value) {
    this.mHasSentPii = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdsDataset setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Boolean getFieldIsConsolidatedContainer() {
    return mIsConsolidatedContainer;
  }

  public AdsDataset setFieldIsConsolidatedContainer(Boolean value) {
    this.mIsConsolidatedContainer = value;
    return this;
  }

  public Boolean getFieldIsCreatedByBusiness() {
    return mIsCreatedByBusiness;
  }

  public AdsDataset setFieldIsCreatedByBusiness(Boolean value) {
    this.mIsCreatedByBusiness = value;
    return this;
  }

  public Boolean getFieldIsCrm() {
    return mIsCrm;
  }

  public AdsDataset setFieldIsCrm(Boolean value) {
    this.mIsCrm = value;
    return this;
  }

  public Boolean getFieldIsEligibleForSharingToAdAccount() {
    return mIsEligibleForSharingToAdAccount;
  }

  public AdsDataset setFieldIsEligibleForSharingToAdAccount(Boolean value) {
    this.mIsEligibleForSharingToAdAccount = value;
    return this;
  }

  public Boolean getFieldIsEligibleForSharingToBusiness() {
    return mIsEligibleForSharingToBusiness;
  }

  public AdsDataset setFieldIsEligibleForSharingToBusiness(Boolean value) {
    this.mIsEligibleForSharingToBusiness = value;
    return this;
  }

  public Boolean getFieldIsEligibleForValueOptimization() {
    return mIsEligibleForValueOptimization;
  }

  public AdsDataset setFieldIsEligibleForValueOptimization(Boolean value) {
    this.mIsEligibleForValueOptimization = value;
    return this;
  }

  public Boolean getFieldIsMtaUse() {
    return mIsMtaUse;
  }

  public AdsDataset setFieldIsMtaUse(Boolean value) {
    this.mIsMtaUse = value;
    return this;
  }

  public Boolean getFieldIsRestrictedUse() {
    return mIsRestrictedUse;
  }

  public AdsDataset setFieldIsRestrictedUse(Boolean value) {
    this.mIsRestrictedUse = value;
    return this;
  }

  public Boolean getFieldIsUnavailable() {
    return mIsUnavailable;
  }

  public AdsDataset setFieldIsUnavailable(Boolean value) {
    this.mIsUnavailable = value;
    return this;
  }

  public String getFieldLastFiredTime() {
    return mLastFiredTime;
  }

  public AdsDataset setFieldLastFiredTime(String value) {
    this.mLastFiredTime = value;
    return this;
  }

  public String getFieldLastUploadApp() {
    return mLastUploadApp;
  }

  public AdsDataset setFieldLastUploadApp(String value) {
    this.mLastUploadApp = value;
    return this;
  }

  public Long getFieldLastUploadAppChangedTime() {
    return mLastUploadAppChangedTime;
  }

  public AdsDataset setFieldLastUploadAppChangedTime(Long value) {
    this.mLastUploadAppChangedTime = value;
    return this;
  }

  public Long getFieldLastUploadTime() {
    return mLastUploadTime;
  }

  public AdsDataset setFieldLastUploadTime(Long value) {
    this.mLastUploadTime = value;
    return this;
  }

  public Boolean getFieldLateUploadReminderEligibility() {
    return mLateUploadReminderEligibility;
  }

  public AdsDataset setFieldLateUploadReminderEligibility(Boolean value) {
    this.mLateUploadReminderEligibility = value;
    return this;
  }

  public Long getFieldMatchRateApprox() {
    return mMatchRateApprox;
  }

  public AdsDataset setFieldMatchRateApprox(Long value) {
    this.mMatchRateApprox = value;
    return this;
  }

  public Long getFieldMatchedEntries() {
    return mMatchedEntries;
  }

  public AdsDataset setFieldMatchedEntries(Long value) {
    this.mMatchedEntries = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdsDataset setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Boolean getFieldNoAdsTrackedForWeeklyUploadedEventsReminderEligibility() {
    return mNoAdsTrackedForWeeklyUploadedEventsReminderEligibility;
  }

  public AdsDataset setFieldNoAdsTrackedForWeeklyUploadedEventsReminderEligibility(Boolean value) {
    this.mNoAdsTrackedForWeeklyUploadedEventsReminderEligibility = value;
    return this;
  }

  public Long getFieldNumActiveAdSetTracked() {
    return mNumActiveAdSetTracked;
  }

  public AdsDataset setFieldNumActiveAdSetTracked(Long value) {
    this.mNumActiveAdSetTracked = value;
    return this;
  }

  public Long getFieldNumRecentOfflineConversionsUploaded() {
    return mNumRecentOfflineConversionsUploaded;
  }

  public AdsDataset setFieldNumRecentOfflineConversionsUploaded(Long value) {
    this.mNumRecentOfflineConversionsUploaded = value;
    return this;
  }

  public Long getFieldNumUploads() {
    return mNumUploads;
  }

  public AdsDataset setFieldNumUploads(Long value) {
    this.mNumUploads = value;
    return this;
  }

  public AdAccount getFieldOwnerAdAccount() {
    if (mOwnerAdAccount != null) {
      mOwnerAdAccount.context = getContext();
    }
    return mOwnerAdAccount;
  }

  public AdsDataset setFieldOwnerAdAccount(AdAccount value) {
    this.mOwnerAdAccount = value;
    return this;
  }

  public AdsDataset setFieldOwnerAdAccount(String value) {
    Type type = new TypeToken<AdAccount>(){}.getType();
    this.mOwnerAdAccount = AdAccount.getGson().fromJson(value, type);
    return this;
  }
  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public AdsDataset setFieldOwnerBusiness(Business value) {
    this.mOwnerBusiness = value;
    return this;
  }

  public AdsDataset setFieldOwnerBusiness(String value) {
    Type type = new TypeToken<Business>(){}.getType();
    this.mOwnerBusiness = Business.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldPercentageOfLateUploadsInExternalSuboptimalWindow() {
    return mPercentageOfLateUploadsInExternalSuboptimalWindow;
  }

  public AdsDataset setFieldPercentageOfLateUploadsInExternalSuboptimalWindow(Long value) {
    this.mPercentageOfLateUploadsInExternalSuboptimalWindow = value;
    return this;
  }

  public OfflineConversionDataSetPermissions getFieldPermissions() {
    return mPermissions;
  }

  public AdsDataset setFieldPermissions(OfflineConversionDataSetPermissions value) {
    this.mPermissions = value;
    return this;
  }

  public AdsDataset setFieldPermissions(String value) {
    Type type = new TypeToken<OfflineConversionDataSetPermissions>(){}.getType();
    this.mPermissions = OfflineConversionDataSetPermissions.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldServerLastFiredTime() {
    return mServerLastFiredTime;
  }

  public AdsDataset setFieldServerLastFiredTime(String value) {
    this.mServerLastFiredTime = value;
    return this;
  }

  public Boolean getFieldShowAutomaticEvents() {
    return mShowAutomaticEvents;
  }

  public AdsDataset setFieldShowAutomaticEvents(Boolean value) {
    this.mShowAutomaticEvents = value;
    return this;
  }

  public Double getFieldUploadRate() {
    return mUploadRate;
  }

  public AdsDataset setFieldUploadRate(Double value) {
    this.mUploadRate = value;
    return this;
  }

  public Boolean getFieldUploadReminderEligibility() {
    return mUploadReminderEligibility;
  }

  public AdsDataset setFieldUploadReminderEligibility(Boolean value) {
    this.mUploadReminderEligibility = value;
    return this;
  }

  public OfflineConversionDataSetUsage getFieldUsage() {
    return mUsage;
  }

  public AdsDataset setFieldUsage(OfflineConversionDataSetUsage value) {
    this.mUsage = value;
    return this;
  }

  public AdsDataset setFieldUsage(String value) {
    Type type = new TypeToken<OfflineConversionDataSetUsage>(){}.getType();
    this.mUsage = OfflineConversionDataSetUsage.getGson().fromJson(value, type);
    return this;
  }
  public Long getFieldValidEntries() {
    return mValidEntries;
  }

  public AdsDataset setFieldValidEntries(Long value) {
    this.mValidEntries = value;
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

  public AdsDataset copyFrom(AdsDataset instance) {
    this.mCanProxy = instance.mCanProxy;
    this.mCollectionRate = instance.mCollectionRate;
    this.mConfig = instance.mConfig;
    this.mCreationTime = instance.mCreationTime;
    this.mCreator = instance.mCreator;
    this.mDatasetId = instance.mDatasetId;
    this.mDescription = instance.mDescription;
    this.mDuplicateEntries = instance.mDuplicateEntries;
    this.mEnableAutoAssignToAccounts = instance.mEnableAutoAssignToAccounts;
    this.mEnableAutomaticEvents = instance.mEnableAutomaticEvents;
    this.mEnableAutomaticMatching = instance.mEnableAutomaticMatching;
    this.mEnableRealTimeEventLog = instance.mEnableRealTimeEventLog;
    this.mEventStats = instance.mEventStats;
    this.mEventTimeMax = instance.mEventTimeMax;
    this.mEventTimeMin = instance.mEventTimeMin;
    this.mFirstPartyCookieStatus = instance.mFirstPartyCookieStatus;
    this.mHasBapiDomains = instance.mHasBapiDomains;
    this.mHasCatalogMicrodataActivity = instance.mHasCatalogMicrodataActivity;
    this.mHasOfaRedactedKeys = instance.mHasOfaRedactedKeys;
    this.mHasSentPii = instance.mHasSentPii;
    this.mId = instance.mId;
    this.mIsConsolidatedContainer = instance.mIsConsolidatedContainer;
    this.mIsCreatedByBusiness = instance.mIsCreatedByBusiness;
    this.mIsCrm = instance.mIsCrm;
    this.mIsEligibleForSharingToAdAccount = instance.mIsEligibleForSharingToAdAccount;
    this.mIsEligibleForSharingToBusiness = instance.mIsEligibleForSharingToBusiness;
    this.mIsEligibleForValueOptimization = instance.mIsEligibleForValueOptimization;
    this.mIsMtaUse = instance.mIsMtaUse;
    this.mIsRestrictedUse = instance.mIsRestrictedUse;
    this.mIsUnavailable = instance.mIsUnavailable;
    this.mLastFiredTime = instance.mLastFiredTime;
    this.mLastUploadApp = instance.mLastUploadApp;
    this.mLastUploadAppChangedTime = instance.mLastUploadAppChangedTime;
    this.mLastUploadTime = instance.mLastUploadTime;
    this.mLateUploadReminderEligibility = instance.mLateUploadReminderEligibility;
    this.mMatchRateApprox = instance.mMatchRateApprox;
    this.mMatchedEntries = instance.mMatchedEntries;
    this.mName = instance.mName;
    this.mNoAdsTrackedForWeeklyUploadedEventsReminderEligibility = instance.mNoAdsTrackedForWeeklyUploadedEventsReminderEligibility;
    this.mNumActiveAdSetTracked = instance.mNumActiveAdSetTracked;
    this.mNumRecentOfflineConversionsUploaded = instance.mNumRecentOfflineConversionsUploaded;
    this.mNumUploads = instance.mNumUploads;
    this.mOwnerAdAccount = instance.mOwnerAdAccount;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mPercentageOfLateUploadsInExternalSuboptimalWindow = instance.mPercentageOfLateUploadsInExternalSuboptimalWindow;
    this.mPermissions = instance.mPermissions;
    this.mServerLastFiredTime = instance.mServerLastFiredTime;
    this.mShowAutomaticEvents = instance.mShowAutomaticEvents;
    this.mUploadRate = instance.mUploadRate;
    this.mUploadReminderEligibility = instance.mUploadReminderEligibility;
    this.mUsage = instance.mUsage;
    this.mValidEntries = instance.mValidEntries;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsDataset> getParser() {
    return new APIRequest.ResponseParser<AdsDataset>() {
      public APINodeList<AdsDataset> parseResponse(String response, APIContext context, APIRequest<AdsDataset> request, String header) throws MalformedResponseException {
        return AdsDataset.parseResponse(response, context, request, header);
      }
    };
  }
}
