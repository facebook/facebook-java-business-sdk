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
public class OffsiteSignalContainerBusinessObject extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_eligible_for_sharing_to_ad_account")
  private Boolean mIsEligibleForSharingToAdAccount = null;
  @SerializedName("is_eligible_for_sharing_to_business")
  private Boolean mIsEligibleForSharingToBusiness = null;
  @SerializedName("is_unavailable")
  private Boolean mIsUnavailable = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("primary_container_id")
  private String mPrimaryContainerId = null;
  protected static Gson gson = null;

  OffsiteSignalContainerBusinessObject() {
  }

  public OffsiteSignalContainerBusinessObject(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public OffsiteSignalContainerBusinessObject(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public OffsiteSignalContainerBusinessObject fetch() throws APIException{
    OffsiteSignalContainerBusinessObject newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static OffsiteSignalContainerBusinessObject fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<OffsiteSignalContainerBusinessObject> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static OffsiteSignalContainerBusinessObject fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<OffsiteSignalContainerBusinessObject> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<OffsiteSignalContainerBusinessObject> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<OffsiteSignalContainerBusinessObject>)(
      new APIRequest<OffsiteSignalContainerBusinessObject>(context, "", "/", "GET", OffsiteSignalContainerBusinessObject.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<OffsiteSignalContainerBusinessObject>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", OffsiteSignalContainerBusinessObject.getParser())
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
  public static OffsiteSignalContainerBusinessObject loadJSON(String json, APIContext context, String header) {
    OffsiteSignalContainerBusinessObject offsiteSignalContainerBusinessObject = getGson().fromJson(json, OffsiteSignalContainerBusinessObject.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(offsiteSignalContainerBusinessObject.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    offsiteSignalContainerBusinessObject.context = context;
    offsiteSignalContainerBusinessObject.rawValue = json;
    offsiteSignalContainerBusinessObject.header = header;
    return offsiteSignalContainerBusinessObject;
  }

  public static APINodeList<OffsiteSignalContainerBusinessObject> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<OffsiteSignalContainerBusinessObject> offsiteSignalContainerBusinessObjects = new APINodeList<OffsiteSignalContainerBusinessObject>(request, json, header);
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
          offsiteSignalContainerBusinessObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return offsiteSignalContainerBusinessObjects;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                offsiteSignalContainerBusinessObjects.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            offsiteSignalContainerBusinessObjects.setPaging(previous, next);
            if (context.hasAppSecret()) {
              offsiteSignalContainerBusinessObjects.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              offsiteSignalContainerBusinessObjects.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  offsiteSignalContainerBusinessObjects.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              offsiteSignalContainerBusinessObjects.add(loadJSON(obj.toString(), context, header));
            }
          }
          return offsiteSignalContainerBusinessObjects;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              offsiteSignalContainerBusinessObjects.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return offsiteSignalContainerBusinessObjects;
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
              offsiteSignalContainerBusinessObjects.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return offsiteSignalContainerBusinessObjects;
          }

          // Sixth, check if it's pure JsonObject
          offsiteSignalContainerBusinessObjects.clear();
          offsiteSignalContainerBusinessObjects.add(loadJSON(json, context, header));
          return offsiteSignalContainerBusinessObjects;
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

  public APIRequestGetLinkedApplication getLinkedApplication() {
    return new APIRequestGetLinkedApplication(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLinkedPage getLinkedPage() {
    return new APIRequestGetLinkedPage(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsEligibleForSharingToAdAccount() {
    return mIsEligibleForSharingToAdAccount;
  }

  public Boolean getFieldIsEligibleForSharingToBusiness() {
    return mIsEligibleForSharingToBusiness;
  }

  public Boolean getFieldIsUnavailable() {
    return mIsUnavailable;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPrimaryContainerId() {
    return mPrimaryContainerId;
  }



  public static class APIRequestGetLinkedApplication extends APIRequest<AdsDataset> {

    APINodeList<AdsDataset> lastResponse = null;
    @Override
    public APINodeList<AdsDataset> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "can_proxy",
      "collection_rate",
      "config",
      "creation_time",
      "creator",
      "dataset_id",
      "description",
      "duplicate_entries",
      "enable_auto_assign_to_accounts",
      "enable_automatic_events",
      "enable_automatic_matching",
      "enable_real_time_event_log",
      "event_stats",
      "event_time_max",
      "event_time_min",
      "first_party_cookie_status",
      "has_bapi_domains",
      "has_catalog_microdata_activity",
      "has_ofa_redacted_keys",
      "has_sent_pii",
      "id",
      "is_consolidated_container",
      "is_created_by_business",
      "is_crm",
      "is_eligible_for_sharing_to_ad_account",
      "is_eligible_for_sharing_to_business",
      "is_eligible_for_value_optimization",
      "is_mta_use",
      "is_restricted_use",
      "is_unavailable",
      "last_fired_time",
      "last_upload_app",
      "last_upload_app_changed_time",
      "last_upload_time",
      "late_upload_reminder_eligibility",
      "match_rate_approx",
      "matched_entries",
      "name",
      "no_ads_tracked_for_weekly_uploaded_events_reminder_eligibility",
      "num_active_ad_set_tracked",
      "num_recent_offline_conversions_uploaded",
      "num_uploads",
      "owner_ad_account",
      "owner_business",
      "percentage_of_late_uploads_in_external_suboptimal_window",
      "permissions",
      "server_last_fired_time",
      "show_automatic_events",
      "upload_rate",
      "upload_reminder_eligibility",
      "usage",
      "valid_entries",
    };

    @Override
    public APINodeList<AdsDataset> parseResponse(String response, String header) throws APIException {
      return AdsDataset.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsDataset> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsDataset> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsDataset>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsDataset>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsDataset>>() {
           public APINodeList<AdsDataset> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLinkedApplication.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetLinkedApplication(String nodeId, APIContext context) {
      super(context, nodeId, "/linked_application", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLinkedApplication setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLinkedApplication setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLinkedApplication requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLinkedApplication requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLinkedApplication requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLinkedApplication requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLinkedApplication requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLinkedApplication requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLinkedApplication requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGetLinkedApplication requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestCollectionRateField () {
      return this.requestCollectionRateField(true);
    }
    public APIRequestGetLinkedApplication requestCollectionRateField (boolean value) {
      this.requestField("collection_rate", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestConfigField () {
      return this.requestConfigField(true);
    }
    public APIRequestGetLinkedApplication requestConfigField (boolean value) {
      this.requestField("config", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGetLinkedApplication requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGetLinkedApplication requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestDatasetIdField () {
      return this.requestDatasetIdField(true);
    }
    public APIRequestGetLinkedApplication requestDatasetIdField (boolean value) {
      this.requestField("dataset_id", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetLinkedApplication requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestDuplicateEntriesField () {
      return this.requestDuplicateEntriesField(true);
    }
    public APIRequestGetLinkedApplication requestDuplicateEntriesField (boolean value) {
      this.requestField("duplicate_entries", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestEnableAutoAssignToAccountsField () {
      return this.requestEnableAutoAssignToAccountsField(true);
    }
    public APIRequestGetLinkedApplication requestEnableAutoAssignToAccountsField (boolean value) {
      this.requestField("enable_auto_assign_to_accounts", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestEnableAutomaticEventsField () {
      return this.requestEnableAutomaticEventsField(true);
    }
    public APIRequestGetLinkedApplication requestEnableAutomaticEventsField (boolean value) {
      this.requestField("enable_automatic_events", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGetLinkedApplication requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestEnableRealTimeEventLogField () {
      return this.requestEnableRealTimeEventLogField(true);
    }
    public APIRequestGetLinkedApplication requestEnableRealTimeEventLogField (boolean value) {
      this.requestField("enable_real_time_event_log", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestEventStatsField () {
      return this.requestEventStatsField(true);
    }
    public APIRequestGetLinkedApplication requestEventStatsField (boolean value) {
      this.requestField("event_stats", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestEventTimeMaxField () {
      return this.requestEventTimeMaxField(true);
    }
    public APIRequestGetLinkedApplication requestEventTimeMaxField (boolean value) {
      this.requestField("event_time_max", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestEventTimeMinField () {
      return this.requestEventTimeMinField(true);
    }
    public APIRequestGetLinkedApplication requestEventTimeMinField (boolean value) {
      this.requestField("event_time_min", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGetLinkedApplication requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestHasBapiDomainsField () {
      return this.requestHasBapiDomainsField(true);
    }
    public APIRequestGetLinkedApplication requestHasBapiDomainsField (boolean value) {
      this.requestField("has_bapi_domains", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestHasCatalogMicrodataActivityField () {
      return this.requestHasCatalogMicrodataActivityField(true);
    }
    public APIRequestGetLinkedApplication requestHasCatalogMicrodataActivityField (boolean value) {
      this.requestField("has_catalog_microdata_activity", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestHasOfaRedactedKeysField () {
      return this.requestHasOfaRedactedKeysField(true);
    }
    public APIRequestGetLinkedApplication requestHasOfaRedactedKeysField (boolean value) {
      this.requestField("has_ofa_redacted_keys", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestHasSentPiiField () {
      return this.requestHasSentPiiField(true);
    }
    public APIRequestGetLinkedApplication requestHasSentPiiField (boolean value) {
      this.requestField("has_sent_pii", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLinkedApplication requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIsConsolidatedContainerField () {
      return this.requestIsConsolidatedContainerField(true);
    }
    public APIRequestGetLinkedApplication requestIsConsolidatedContainerField (boolean value) {
      this.requestField("is_consolidated_container", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGetLinkedApplication requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIsCrmField () {
      return this.requestIsCrmField(true);
    }
    public APIRequestGetLinkedApplication requestIsCrmField (boolean value) {
      this.requestField("is_crm", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIsEligibleForSharingToAdAccountField () {
      return this.requestIsEligibleForSharingToAdAccountField(true);
    }
    public APIRequestGetLinkedApplication requestIsEligibleForSharingToAdAccountField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_ad_account", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIsEligibleForSharingToBusinessField () {
      return this.requestIsEligibleForSharingToBusinessField(true);
    }
    public APIRequestGetLinkedApplication requestIsEligibleForSharingToBusinessField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_business", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIsEligibleForValueOptimizationField () {
      return this.requestIsEligibleForValueOptimizationField(true);
    }
    public APIRequestGetLinkedApplication requestIsEligibleForValueOptimizationField (boolean value) {
      this.requestField("is_eligible_for_value_optimization", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIsMtaUseField () {
      return this.requestIsMtaUseField(true);
    }
    public APIRequestGetLinkedApplication requestIsMtaUseField (boolean value) {
      this.requestField("is_mta_use", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIsRestrictedUseField () {
      return this.requestIsRestrictedUseField(true);
    }
    public APIRequestGetLinkedApplication requestIsRestrictedUseField (boolean value) {
      this.requestField("is_restricted_use", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGetLinkedApplication requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGetLinkedApplication requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestLastUploadAppField () {
      return this.requestLastUploadAppField(true);
    }
    public APIRequestGetLinkedApplication requestLastUploadAppField (boolean value) {
      this.requestField("last_upload_app", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestLastUploadAppChangedTimeField () {
      return this.requestLastUploadAppChangedTimeField(true);
    }
    public APIRequestGetLinkedApplication requestLastUploadAppChangedTimeField (boolean value) {
      this.requestField("last_upload_app_changed_time", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestLastUploadTimeField () {
      return this.requestLastUploadTimeField(true);
    }
    public APIRequestGetLinkedApplication requestLastUploadTimeField (boolean value) {
      this.requestField("last_upload_time", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestLateUploadReminderEligibilityField () {
      return this.requestLateUploadReminderEligibilityField(true);
    }
    public APIRequestGetLinkedApplication requestLateUploadReminderEligibilityField (boolean value) {
      this.requestField("late_upload_reminder_eligibility", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestMatchRateApproxField () {
      return this.requestMatchRateApproxField(true);
    }
    public APIRequestGetLinkedApplication requestMatchRateApproxField (boolean value) {
      this.requestField("match_rate_approx", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestMatchedEntriesField () {
      return this.requestMatchedEntriesField(true);
    }
    public APIRequestGetLinkedApplication requestMatchedEntriesField (boolean value) {
      this.requestField("matched_entries", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetLinkedApplication requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestNoAdsTrackedForWeeklyUploadedEventsReminderEligibilityField () {
      return this.requestNoAdsTrackedForWeeklyUploadedEventsReminderEligibilityField(true);
    }
    public APIRequestGetLinkedApplication requestNoAdsTrackedForWeeklyUploadedEventsReminderEligibilityField (boolean value) {
      this.requestField("no_ads_tracked_for_weekly_uploaded_events_reminder_eligibility", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestNumActiveAdSetTrackedField () {
      return this.requestNumActiveAdSetTrackedField(true);
    }
    public APIRequestGetLinkedApplication requestNumActiveAdSetTrackedField (boolean value) {
      this.requestField("num_active_ad_set_tracked", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestNumRecentOfflineConversionsUploadedField () {
      return this.requestNumRecentOfflineConversionsUploadedField(true);
    }
    public APIRequestGetLinkedApplication requestNumRecentOfflineConversionsUploadedField (boolean value) {
      this.requestField("num_recent_offline_conversions_uploaded", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestNumUploadsField () {
      return this.requestNumUploadsField(true);
    }
    public APIRequestGetLinkedApplication requestNumUploadsField (boolean value) {
      this.requestField("num_uploads", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGetLinkedApplication requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetLinkedApplication requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestPercentageOfLateUploadsInExternalSuboptimalWindowField () {
      return this.requestPercentageOfLateUploadsInExternalSuboptimalWindowField(true);
    }
    public APIRequestGetLinkedApplication requestPercentageOfLateUploadsInExternalSuboptimalWindowField (boolean value) {
      this.requestField("percentage_of_late_uploads_in_external_suboptimal_window", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestPermissionsField () {
      return this.requestPermissionsField(true);
    }
    public APIRequestGetLinkedApplication requestPermissionsField (boolean value) {
      this.requestField("permissions", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestServerLastFiredTimeField () {
      return this.requestServerLastFiredTimeField(true);
    }
    public APIRequestGetLinkedApplication requestServerLastFiredTimeField (boolean value) {
      this.requestField("server_last_fired_time", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestShowAutomaticEventsField () {
      return this.requestShowAutomaticEventsField(true);
    }
    public APIRequestGetLinkedApplication requestShowAutomaticEventsField (boolean value) {
      this.requestField("show_automatic_events", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestUploadRateField () {
      return this.requestUploadRateField(true);
    }
    public APIRequestGetLinkedApplication requestUploadRateField (boolean value) {
      this.requestField("upload_rate", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestUploadReminderEligibilityField () {
      return this.requestUploadReminderEligibilityField(true);
    }
    public APIRequestGetLinkedApplication requestUploadReminderEligibilityField (boolean value) {
      this.requestField("upload_reminder_eligibility", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestUsageField () {
      return this.requestUsageField(true);
    }
    public APIRequestGetLinkedApplication requestUsageField (boolean value) {
      this.requestField("usage", value);
      return this;
    }
    public APIRequestGetLinkedApplication requestValidEntriesField () {
      return this.requestValidEntriesField(true);
    }
    public APIRequestGetLinkedApplication requestValidEntriesField (boolean value) {
      this.requestField("valid_entries", value);
      return this;
    }
  }

  public static class APIRequestGetLinkedPage extends APIRequest<Page> {

    APINodeList<Page> lastResponse = null;
    @Override
    public APINodeList<Page> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "access_token",
      "ad_campaign",
      "affiliation",
      "app_id",
      "artists_we_like",
      "attire",
      "available_promo_offer_ids",
      "awards",
      "band_interests",
      "band_members",
      "best_page",
      "bio",
      "birthday",
      "booking_agent",
      "breaking_news_usage",
      "built",
      "business",
      "can_checkin",
      "can_post",
      "category",
      "category_list",
      "checkins",
      "company_overview",
      "connected_instagram_account",
      "connected_page_backed_instagram_account",
      "contact_address",
      "copyright_whitelisted_ig_partners",
      "country_page_likes",
      "cover",
      "culinary_team",
      "current_location",
      "delivery_and_pickup_option_info",
      "description",
      "description_html",
      "differently_open_offerings",
      "directed_by",
      "display_subtext",
      "displayed_message_response_time",
      "does_viewer_have_page_permission_link_ig",
      "emails",
      "engagement",
      "fan_count",
      "featured_video",
      "features",
      "followers_count",
      "food_styles",
      "founded",
      "general_info",
      "general_manager",
      "genre",
      "global_brand_page_name",
      "global_brand_root_id",
      "has_added_app",
      "has_lead_access",
      "has_transitioned_to_new_page_experience",
      "has_whatsapp_business_number",
      "has_whatsapp_number",
      "hometown",
      "hours",
      "id",
      "impressum",
      "influences",
      "instagram_business_account",
      "is_always_open",
      "is_calling_eligible",
      "is_chain",
      "is_community_page",
      "is_eligible_for_branded_content",
      "is_eligible_for_disable_connect_ig_btn_for_non_page_admin_am_web",
      "is_messenger_bot_get_started_enabled",
      "is_messenger_platform_bot",
      "is_owned",
      "is_permanently_closed",
      "is_published",
      "is_unclaimed",
      "is_verified",
      "is_webhooks_subscribed",
      "keywords",
      "leadgen_tos_acceptance_time",
      "leadgen_tos_accepted",
      "leadgen_tos_accepting_user",
      "link",
      "location",
      "members",
      "merchant_id",
      "merchant_review_status",
      "messaging_feature_status",
      "messenger_ads_default_icebreakers",
      "messenger_ads_default_quick_replies",
      "messenger_ads_quick_replies_type",
      "mini_shop_storefront",
      "mission",
      "mpg",
      "name",
      "name_with_location_descriptor",
      "network",
      "new_like_count",
      "offer_eligible",
      "overall_star_rating",
      "owner_business",
      "page_token",
      "parent_page",
      "parking",
      "payment_options",
      "personal_info",
      "personal_interests",
      "pharma_safety_info",
      "phone",
      "pickup_options",
      "place_type",
      "plot_outline",
      "preferred_audience",
      "press_contact",
      "price_range",
      "privacy_info_url",
      "produced_by",
      "products",
      "promotion_eligible",
      "promotion_ineligible_reason",
      "public_transit",
      "rating_count",
      "recipient",
      "record_label",
      "release_date",
      "restaurant_services",
      "restaurant_specialties",
      "schedule",
      "screenplay_by",
      "season",
      "single_line_address",
      "starring",
      "start_info",
      "store_code",
      "store_location_descriptor",
      "store_number",
      "studio",
      "supports_donate_button_in_live_video",
      "talking_about_count",
      "temporary_status",
      "unread_message_count",
      "unread_notif_count",
      "unseen_message_count",
      "user_access_expire_time",
      "username",
      "verification_status",
      "voip_info",
      "website",
      "were_here_count",
      "whatsapp_number",
      "written_by",
    };

    @Override
    public APINodeList<Page> parseResponse(String response, String header) throws APIException {
      return Page.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Page> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Page> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Page>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Page>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Page>>() {
           public APINodeList<Page> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLinkedPage.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetLinkedPage(String nodeId, APIContext context) {
      super(context, nodeId, "/linked_page", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLinkedPage setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLinkedPage setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLinkedPage requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLinkedPage requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLinkedPage requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLinkedPage requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLinkedPage requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLinkedPage requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLinkedPage requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetLinkedPage requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetLinkedPage requestAccessTokenField () {
      return this.requestAccessTokenField(true);
    }
    public APIRequestGetLinkedPage requestAccessTokenField (boolean value) {
      this.requestField("access_token", value);
      return this;
    }
    public APIRequestGetLinkedPage requestAdCampaignField () {
      return this.requestAdCampaignField(true);
    }
    public APIRequestGetLinkedPage requestAdCampaignField (boolean value) {
      this.requestField("ad_campaign", value);
      return this;
    }
    public APIRequestGetLinkedPage requestAffiliationField () {
      return this.requestAffiliationField(true);
    }
    public APIRequestGetLinkedPage requestAffiliationField (boolean value) {
      this.requestField("affiliation", value);
      return this;
    }
    public APIRequestGetLinkedPage requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGetLinkedPage requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGetLinkedPage requestArtistsWeLikeField () {
      return this.requestArtistsWeLikeField(true);
    }
    public APIRequestGetLinkedPage requestArtistsWeLikeField (boolean value) {
      this.requestField("artists_we_like", value);
      return this;
    }
    public APIRequestGetLinkedPage requestAttireField () {
      return this.requestAttireField(true);
    }
    public APIRequestGetLinkedPage requestAttireField (boolean value) {
      this.requestField("attire", value);
      return this;
    }
    public APIRequestGetLinkedPage requestAvailablePromoOfferIdsField () {
      return this.requestAvailablePromoOfferIdsField(true);
    }
    public APIRequestGetLinkedPage requestAvailablePromoOfferIdsField (boolean value) {
      this.requestField("available_promo_offer_ids", value);
      return this;
    }
    public APIRequestGetLinkedPage requestAwardsField () {
      return this.requestAwardsField(true);
    }
    public APIRequestGetLinkedPage requestAwardsField (boolean value) {
      this.requestField("awards", value);
      return this;
    }
    public APIRequestGetLinkedPage requestBandInterestsField () {
      return this.requestBandInterestsField(true);
    }
    public APIRequestGetLinkedPage requestBandInterestsField (boolean value) {
      this.requestField("band_interests", value);
      return this;
    }
    public APIRequestGetLinkedPage requestBandMembersField () {
      return this.requestBandMembersField(true);
    }
    public APIRequestGetLinkedPage requestBandMembersField (boolean value) {
      this.requestField("band_members", value);
      return this;
    }
    public APIRequestGetLinkedPage requestBestPageField () {
      return this.requestBestPageField(true);
    }
    public APIRequestGetLinkedPage requestBestPageField (boolean value) {
      this.requestField("best_page", value);
      return this;
    }
    public APIRequestGetLinkedPage requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetLinkedPage requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetLinkedPage requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetLinkedPage requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetLinkedPage requestBookingAgentField () {
      return this.requestBookingAgentField(true);
    }
    public APIRequestGetLinkedPage requestBookingAgentField (boolean value) {
      this.requestField("booking_agent", value);
      return this;
    }
    public APIRequestGetLinkedPage requestBreakingNewsUsageField () {
      return this.requestBreakingNewsUsageField(true);
    }
    public APIRequestGetLinkedPage requestBreakingNewsUsageField (boolean value) {
      this.requestField("breaking_news_usage", value);
      return this;
    }
    public APIRequestGetLinkedPage requestBuiltField () {
      return this.requestBuiltField(true);
    }
    public APIRequestGetLinkedPage requestBuiltField (boolean value) {
      this.requestField("built", value);
      return this;
    }
    public APIRequestGetLinkedPage requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetLinkedPage requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCanCheckinField () {
      return this.requestCanCheckinField(true);
    }
    public APIRequestGetLinkedPage requestCanCheckinField (boolean value) {
      this.requestField("can_checkin", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCanPostField () {
      return this.requestCanPostField(true);
    }
    public APIRequestGetLinkedPage requestCanPostField (boolean value) {
      this.requestField("can_post", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGetLinkedPage requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCategoryListField () {
      return this.requestCategoryListField(true);
    }
    public APIRequestGetLinkedPage requestCategoryListField (boolean value) {
      this.requestField("category_list", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCheckinsField () {
      return this.requestCheckinsField(true);
    }
    public APIRequestGetLinkedPage requestCheckinsField (boolean value) {
      this.requestField("checkins", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCompanyOverviewField () {
      return this.requestCompanyOverviewField(true);
    }
    public APIRequestGetLinkedPage requestCompanyOverviewField (boolean value) {
      this.requestField("company_overview", value);
      return this;
    }
    public APIRequestGetLinkedPage requestConnectedInstagramAccountField () {
      return this.requestConnectedInstagramAccountField(true);
    }
    public APIRequestGetLinkedPage requestConnectedInstagramAccountField (boolean value) {
      this.requestField("connected_instagram_account", value);
      return this;
    }
    public APIRequestGetLinkedPage requestConnectedPageBackedInstagramAccountField () {
      return this.requestConnectedPageBackedInstagramAccountField(true);
    }
    public APIRequestGetLinkedPage requestConnectedPageBackedInstagramAccountField (boolean value) {
      this.requestField("connected_page_backed_instagram_account", value);
      return this;
    }
    public APIRequestGetLinkedPage requestContactAddressField () {
      return this.requestContactAddressField(true);
    }
    public APIRequestGetLinkedPage requestContactAddressField (boolean value) {
      this.requestField("contact_address", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCopyrightWhitelistedIgPartnersField () {
      return this.requestCopyrightWhitelistedIgPartnersField(true);
    }
    public APIRequestGetLinkedPage requestCopyrightWhitelistedIgPartnersField (boolean value) {
      this.requestField("copyright_whitelisted_ig_partners", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCountryPageLikesField () {
      return this.requestCountryPageLikesField(true);
    }
    public APIRequestGetLinkedPage requestCountryPageLikesField (boolean value) {
      this.requestField("country_page_likes", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetLinkedPage requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCulinaryTeamField () {
      return this.requestCulinaryTeamField(true);
    }
    public APIRequestGetLinkedPage requestCulinaryTeamField (boolean value) {
      this.requestField("culinary_team", value);
      return this;
    }
    public APIRequestGetLinkedPage requestCurrentLocationField () {
      return this.requestCurrentLocationField(true);
    }
    public APIRequestGetLinkedPage requestCurrentLocationField (boolean value) {
      this.requestField("current_location", value);
      return this;
    }
    public APIRequestGetLinkedPage requestDeliveryAndPickupOptionInfoField () {
      return this.requestDeliveryAndPickupOptionInfoField(true);
    }
    public APIRequestGetLinkedPage requestDeliveryAndPickupOptionInfoField (boolean value) {
      this.requestField("delivery_and_pickup_option_info", value);
      return this;
    }
    public APIRequestGetLinkedPage requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetLinkedPage requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetLinkedPage requestDescriptionHtmlField () {
      return this.requestDescriptionHtmlField(true);
    }
    public APIRequestGetLinkedPage requestDescriptionHtmlField (boolean value) {
      this.requestField("description_html", value);
      return this;
    }
    public APIRequestGetLinkedPage requestDifferentlyOpenOfferingsField () {
      return this.requestDifferentlyOpenOfferingsField(true);
    }
    public APIRequestGetLinkedPage requestDifferentlyOpenOfferingsField (boolean value) {
      this.requestField("differently_open_offerings", value);
      return this;
    }
    public APIRequestGetLinkedPage requestDirectedByField () {
      return this.requestDirectedByField(true);
    }
    public APIRequestGetLinkedPage requestDirectedByField (boolean value) {
      this.requestField("directed_by", value);
      return this;
    }
    public APIRequestGetLinkedPage requestDisplaySubtextField () {
      return this.requestDisplaySubtextField(true);
    }
    public APIRequestGetLinkedPage requestDisplaySubtextField (boolean value) {
      this.requestField("display_subtext", value);
      return this;
    }
    public APIRequestGetLinkedPage requestDisplayedMessageResponseTimeField () {
      return this.requestDisplayedMessageResponseTimeField(true);
    }
    public APIRequestGetLinkedPage requestDisplayedMessageResponseTimeField (boolean value) {
      this.requestField("displayed_message_response_time", value);
      return this;
    }
    public APIRequestGetLinkedPage requestDoesViewerHavePagePermissionLinkIgField () {
      return this.requestDoesViewerHavePagePermissionLinkIgField(true);
    }
    public APIRequestGetLinkedPage requestDoesViewerHavePagePermissionLinkIgField (boolean value) {
      this.requestField("does_viewer_have_page_permission_link_ig", value);
      return this;
    }
    public APIRequestGetLinkedPage requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGetLinkedPage requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGetLinkedPage requestEngagementField () {
      return this.requestEngagementField(true);
    }
    public APIRequestGetLinkedPage requestEngagementField (boolean value) {
      this.requestField("engagement", value);
      return this;
    }
    public APIRequestGetLinkedPage requestFanCountField () {
      return this.requestFanCountField(true);
    }
    public APIRequestGetLinkedPage requestFanCountField (boolean value) {
      this.requestField("fan_count", value);
      return this;
    }
    public APIRequestGetLinkedPage requestFeaturedVideoField () {
      return this.requestFeaturedVideoField(true);
    }
    public APIRequestGetLinkedPage requestFeaturedVideoField (boolean value) {
      this.requestField("featured_video", value);
      return this;
    }
    public APIRequestGetLinkedPage requestFeaturesField () {
      return this.requestFeaturesField(true);
    }
    public APIRequestGetLinkedPage requestFeaturesField (boolean value) {
      this.requestField("features", value);
      return this;
    }
    public APIRequestGetLinkedPage requestFollowersCountField () {
      return this.requestFollowersCountField(true);
    }
    public APIRequestGetLinkedPage requestFollowersCountField (boolean value) {
      this.requestField("followers_count", value);
      return this;
    }
    public APIRequestGetLinkedPage requestFoodStylesField () {
      return this.requestFoodStylesField(true);
    }
    public APIRequestGetLinkedPage requestFoodStylesField (boolean value) {
      this.requestField("food_styles", value);
      return this;
    }
    public APIRequestGetLinkedPage requestFoundedField () {
      return this.requestFoundedField(true);
    }
    public APIRequestGetLinkedPage requestFoundedField (boolean value) {
      this.requestField("founded", value);
      return this;
    }
    public APIRequestGetLinkedPage requestGeneralInfoField () {
      return this.requestGeneralInfoField(true);
    }
    public APIRequestGetLinkedPage requestGeneralInfoField (boolean value) {
      this.requestField("general_info", value);
      return this;
    }
    public APIRequestGetLinkedPage requestGeneralManagerField () {
      return this.requestGeneralManagerField(true);
    }
    public APIRequestGetLinkedPage requestGeneralManagerField (boolean value) {
      this.requestField("general_manager", value);
      return this;
    }
    public APIRequestGetLinkedPage requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGetLinkedPage requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGetLinkedPage requestGlobalBrandPageNameField () {
      return this.requestGlobalBrandPageNameField(true);
    }
    public APIRequestGetLinkedPage requestGlobalBrandPageNameField (boolean value) {
      this.requestField("global_brand_page_name", value);
      return this;
    }
    public APIRequestGetLinkedPage requestGlobalBrandRootIdField () {
      return this.requestGlobalBrandRootIdField(true);
    }
    public APIRequestGetLinkedPage requestGlobalBrandRootIdField (boolean value) {
      this.requestField("global_brand_root_id", value);
      return this;
    }
    public APIRequestGetLinkedPage requestHasAddedAppField () {
      return this.requestHasAddedAppField(true);
    }
    public APIRequestGetLinkedPage requestHasAddedAppField (boolean value) {
      this.requestField("has_added_app", value);
      return this;
    }
    public APIRequestGetLinkedPage requestHasLeadAccessField () {
      return this.requestHasLeadAccessField(true);
    }
    public APIRequestGetLinkedPage requestHasLeadAccessField (boolean value) {
      this.requestField("has_lead_access", value);
      return this;
    }
    public APIRequestGetLinkedPage requestHasTransitionedToNewPageExperienceField () {
      return this.requestHasTransitionedToNewPageExperienceField(true);
    }
    public APIRequestGetLinkedPage requestHasTransitionedToNewPageExperienceField (boolean value) {
      this.requestField("has_transitioned_to_new_page_experience", value);
      return this;
    }
    public APIRequestGetLinkedPage requestHasWhatsappBusinessNumberField () {
      return this.requestHasWhatsappBusinessNumberField(true);
    }
    public APIRequestGetLinkedPage requestHasWhatsappBusinessNumberField (boolean value) {
      this.requestField("has_whatsapp_business_number", value);
      return this;
    }
    public APIRequestGetLinkedPage requestHasWhatsappNumberField () {
      return this.requestHasWhatsappNumberField(true);
    }
    public APIRequestGetLinkedPage requestHasWhatsappNumberField (boolean value) {
      this.requestField("has_whatsapp_number", value);
      return this;
    }
    public APIRequestGetLinkedPage requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetLinkedPage requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetLinkedPage requestHoursField () {
      return this.requestHoursField(true);
    }
    public APIRequestGetLinkedPage requestHoursField (boolean value) {
      this.requestField("hours", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLinkedPage requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLinkedPage requestImpressumField () {
      return this.requestImpressumField(true);
    }
    public APIRequestGetLinkedPage requestImpressumField (boolean value) {
      this.requestField("impressum", value);
      return this;
    }
    public APIRequestGetLinkedPage requestInfluencesField () {
      return this.requestInfluencesField(true);
    }
    public APIRequestGetLinkedPage requestInfluencesField (boolean value) {
      this.requestField("influences", value);
      return this;
    }
    public APIRequestGetLinkedPage requestInstagramBusinessAccountField () {
      return this.requestInstagramBusinessAccountField(true);
    }
    public APIRequestGetLinkedPage requestInstagramBusinessAccountField (boolean value) {
      this.requestField("instagram_business_account", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsAlwaysOpenField () {
      return this.requestIsAlwaysOpenField(true);
    }
    public APIRequestGetLinkedPage requestIsAlwaysOpenField (boolean value) {
      this.requestField("is_always_open", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsCallingEligibleField () {
      return this.requestIsCallingEligibleField(true);
    }
    public APIRequestGetLinkedPage requestIsCallingEligibleField (boolean value) {
      this.requestField("is_calling_eligible", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsChainField () {
      return this.requestIsChainField(true);
    }
    public APIRequestGetLinkedPage requestIsChainField (boolean value) {
      this.requestField("is_chain", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsCommunityPageField () {
      return this.requestIsCommunityPageField(true);
    }
    public APIRequestGetLinkedPage requestIsCommunityPageField (boolean value) {
      this.requestField("is_community_page", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsEligibleForBrandedContentField () {
      return this.requestIsEligibleForBrandedContentField(true);
    }
    public APIRequestGetLinkedPage requestIsEligibleForBrandedContentField (boolean value) {
      this.requestField("is_eligible_for_branded_content", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsEligibleForDisableConnectIgBtnForNonPageAdminAmWebField () {
      return this.requestIsEligibleForDisableConnectIgBtnForNonPageAdminAmWebField(true);
    }
    public APIRequestGetLinkedPage requestIsEligibleForDisableConnectIgBtnForNonPageAdminAmWebField (boolean value) {
      this.requestField("is_eligible_for_disable_connect_ig_btn_for_non_page_admin_am_web", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsMessengerBotGetStartedEnabledField () {
      return this.requestIsMessengerBotGetStartedEnabledField(true);
    }
    public APIRequestGetLinkedPage requestIsMessengerBotGetStartedEnabledField (boolean value) {
      this.requestField("is_messenger_bot_get_started_enabled", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsMessengerPlatformBotField () {
      return this.requestIsMessengerPlatformBotField(true);
    }
    public APIRequestGetLinkedPage requestIsMessengerPlatformBotField (boolean value) {
      this.requestField("is_messenger_platform_bot", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsOwnedField () {
      return this.requestIsOwnedField(true);
    }
    public APIRequestGetLinkedPage requestIsOwnedField (boolean value) {
      this.requestField("is_owned", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsPermanentlyClosedField () {
      return this.requestIsPermanentlyClosedField(true);
    }
    public APIRequestGetLinkedPage requestIsPermanentlyClosedField (boolean value) {
      this.requestField("is_permanently_closed", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGetLinkedPage requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsUnclaimedField () {
      return this.requestIsUnclaimedField(true);
    }
    public APIRequestGetLinkedPage requestIsUnclaimedField (boolean value) {
      this.requestField("is_unclaimed", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetLinkedPage requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetLinkedPage requestIsWebhooksSubscribedField () {
      return this.requestIsWebhooksSubscribedField(true);
    }
    public APIRequestGetLinkedPage requestIsWebhooksSubscribedField (boolean value) {
      this.requestField("is_webhooks_subscribed", value);
      return this;
    }
    public APIRequestGetLinkedPage requestKeywordsField () {
      return this.requestKeywordsField(true);
    }
    public APIRequestGetLinkedPage requestKeywordsField (boolean value) {
      this.requestField("keywords", value);
      return this;
    }
    public APIRequestGetLinkedPage requestLeadgenTosAcceptanceTimeField () {
      return this.requestLeadgenTosAcceptanceTimeField(true);
    }
    public APIRequestGetLinkedPage requestLeadgenTosAcceptanceTimeField (boolean value) {
      this.requestField("leadgen_tos_acceptance_time", value);
      return this;
    }
    public APIRequestGetLinkedPage requestLeadgenTosAcceptedField () {
      return this.requestLeadgenTosAcceptedField(true);
    }
    public APIRequestGetLinkedPage requestLeadgenTosAcceptedField (boolean value) {
      this.requestField("leadgen_tos_accepted", value);
      return this;
    }
    public APIRequestGetLinkedPage requestLeadgenTosAcceptingUserField () {
      return this.requestLeadgenTosAcceptingUserField(true);
    }
    public APIRequestGetLinkedPage requestLeadgenTosAcceptingUserField (boolean value) {
      this.requestField("leadgen_tos_accepting_user", value);
      return this;
    }
    public APIRequestGetLinkedPage requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetLinkedPage requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetLinkedPage requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetLinkedPage requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMembersField () {
      return this.requestMembersField(true);
    }
    public APIRequestGetLinkedPage requestMembersField (boolean value) {
      this.requestField("members", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMerchantIdField () {
      return this.requestMerchantIdField(true);
    }
    public APIRequestGetLinkedPage requestMerchantIdField (boolean value) {
      this.requestField("merchant_id", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMerchantReviewStatusField () {
      return this.requestMerchantReviewStatusField(true);
    }
    public APIRequestGetLinkedPage requestMerchantReviewStatusField (boolean value) {
      this.requestField("merchant_review_status", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMessagingFeatureStatusField () {
      return this.requestMessagingFeatureStatusField(true);
    }
    public APIRequestGetLinkedPage requestMessagingFeatureStatusField (boolean value) {
      this.requestField("messaging_feature_status", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMessengerAdsDefaultIcebreakersField () {
      return this.requestMessengerAdsDefaultIcebreakersField(true);
    }
    public APIRequestGetLinkedPage requestMessengerAdsDefaultIcebreakersField (boolean value) {
      this.requestField("messenger_ads_default_icebreakers", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMessengerAdsDefaultQuickRepliesField () {
      return this.requestMessengerAdsDefaultQuickRepliesField(true);
    }
    public APIRequestGetLinkedPage requestMessengerAdsDefaultQuickRepliesField (boolean value) {
      this.requestField("messenger_ads_default_quick_replies", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMessengerAdsQuickRepliesTypeField () {
      return this.requestMessengerAdsQuickRepliesTypeField(true);
    }
    public APIRequestGetLinkedPage requestMessengerAdsQuickRepliesTypeField (boolean value) {
      this.requestField("messenger_ads_quick_replies_type", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMiniShopStorefrontField () {
      return this.requestMiniShopStorefrontField(true);
    }
    public APIRequestGetLinkedPage requestMiniShopStorefrontField (boolean value) {
      this.requestField("mini_shop_storefront", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMissionField () {
      return this.requestMissionField(true);
    }
    public APIRequestGetLinkedPage requestMissionField (boolean value) {
      this.requestField("mission", value);
      return this;
    }
    public APIRequestGetLinkedPage requestMpgField () {
      return this.requestMpgField(true);
    }
    public APIRequestGetLinkedPage requestMpgField (boolean value) {
      this.requestField("mpg", value);
      return this;
    }
    public APIRequestGetLinkedPage requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetLinkedPage requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetLinkedPage requestNameWithLocationDescriptorField () {
      return this.requestNameWithLocationDescriptorField(true);
    }
    public APIRequestGetLinkedPage requestNameWithLocationDescriptorField (boolean value) {
      this.requestField("name_with_location_descriptor", value);
      return this;
    }
    public APIRequestGetLinkedPage requestNetworkField () {
      return this.requestNetworkField(true);
    }
    public APIRequestGetLinkedPage requestNetworkField (boolean value) {
      this.requestField("network", value);
      return this;
    }
    public APIRequestGetLinkedPage requestNewLikeCountField () {
      return this.requestNewLikeCountField(true);
    }
    public APIRequestGetLinkedPage requestNewLikeCountField (boolean value) {
      this.requestField("new_like_count", value);
      return this;
    }
    public APIRequestGetLinkedPage requestOfferEligibleField () {
      return this.requestOfferEligibleField(true);
    }
    public APIRequestGetLinkedPage requestOfferEligibleField (boolean value) {
      this.requestField("offer_eligible", value);
      return this;
    }
    public APIRequestGetLinkedPage requestOverallStarRatingField () {
      return this.requestOverallStarRatingField(true);
    }
    public APIRequestGetLinkedPage requestOverallStarRatingField (boolean value) {
      this.requestField("overall_star_rating", value);
      return this;
    }
    public APIRequestGetLinkedPage requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetLinkedPage requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPageTokenField () {
      return this.requestPageTokenField(true);
    }
    public APIRequestGetLinkedPage requestPageTokenField (boolean value) {
      this.requestField("page_token", value);
      return this;
    }
    public APIRequestGetLinkedPage requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGetLinkedPage requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
    public APIRequestGetLinkedPage requestParkingField () {
      return this.requestParkingField(true);
    }
    public APIRequestGetLinkedPage requestParkingField (boolean value) {
      this.requestField("parking", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPaymentOptionsField () {
      return this.requestPaymentOptionsField(true);
    }
    public APIRequestGetLinkedPage requestPaymentOptionsField (boolean value) {
      this.requestField("payment_options", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPersonalInfoField () {
      return this.requestPersonalInfoField(true);
    }
    public APIRequestGetLinkedPage requestPersonalInfoField (boolean value) {
      this.requestField("personal_info", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPersonalInterestsField () {
      return this.requestPersonalInterestsField(true);
    }
    public APIRequestGetLinkedPage requestPersonalInterestsField (boolean value) {
      this.requestField("personal_interests", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPharmaSafetyInfoField () {
      return this.requestPharmaSafetyInfoField(true);
    }
    public APIRequestGetLinkedPage requestPharmaSafetyInfoField (boolean value) {
      this.requestField("pharma_safety_info", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPhoneField () {
      return this.requestPhoneField(true);
    }
    public APIRequestGetLinkedPage requestPhoneField (boolean value) {
      this.requestField("phone", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPickupOptionsField () {
      return this.requestPickupOptionsField(true);
    }
    public APIRequestGetLinkedPage requestPickupOptionsField (boolean value) {
      this.requestField("pickup_options", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPlaceTypeField () {
      return this.requestPlaceTypeField(true);
    }
    public APIRequestGetLinkedPage requestPlaceTypeField (boolean value) {
      this.requestField("place_type", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPlotOutlineField () {
      return this.requestPlotOutlineField(true);
    }
    public APIRequestGetLinkedPage requestPlotOutlineField (boolean value) {
      this.requestField("plot_outline", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPreferredAudienceField () {
      return this.requestPreferredAudienceField(true);
    }
    public APIRequestGetLinkedPage requestPreferredAudienceField (boolean value) {
      this.requestField("preferred_audience", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPressContactField () {
      return this.requestPressContactField(true);
    }
    public APIRequestGetLinkedPage requestPressContactField (boolean value) {
      this.requestField("press_contact", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPriceRangeField () {
      return this.requestPriceRangeField(true);
    }
    public APIRequestGetLinkedPage requestPriceRangeField (boolean value) {
      this.requestField("price_range", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPrivacyInfoUrlField () {
      return this.requestPrivacyInfoUrlField(true);
    }
    public APIRequestGetLinkedPage requestPrivacyInfoUrlField (boolean value) {
      this.requestField("privacy_info_url", value);
      return this;
    }
    public APIRequestGetLinkedPage requestProducedByField () {
      return this.requestProducedByField(true);
    }
    public APIRequestGetLinkedPage requestProducedByField (boolean value) {
      this.requestField("produced_by", value);
      return this;
    }
    public APIRequestGetLinkedPage requestProductsField () {
      return this.requestProductsField(true);
    }
    public APIRequestGetLinkedPage requestProductsField (boolean value) {
      this.requestField("products", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPromotionEligibleField () {
      return this.requestPromotionEligibleField(true);
    }
    public APIRequestGetLinkedPage requestPromotionEligibleField (boolean value) {
      this.requestField("promotion_eligible", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPromotionIneligibleReasonField () {
      return this.requestPromotionIneligibleReasonField(true);
    }
    public APIRequestGetLinkedPage requestPromotionIneligibleReasonField (boolean value) {
      this.requestField("promotion_ineligible_reason", value);
      return this;
    }
    public APIRequestGetLinkedPage requestPublicTransitField () {
      return this.requestPublicTransitField(true);
    }
    public APIRequestGetLinkedPage requestPublicTransitField (boolean value) {
      this.requestField("public_transit", value);
      return this;
    }
    public APIRequestGetLinkedPage requestRatingCountField () {
      return this.requestRatingCountField(true);
    }
    public APIRequestGetLinkedPage requestRatingCountField (boolean value) {
      this.requestField("rating_count", value);
      return this;
    }
    public APIRequestGetLinkedPage requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGetLinkedPage requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGetLinkedPage requestRecordLabelField () {
      return this.requestRecordLabelField(true);
    }
    public APIRequestGetLinkedPage requestRecordLabelField (boolean value) {
      this.requestField("record_label", value);
      return this;
    }
    public APIRequestGetLinkedPage requestReleaseDateField () {
      return this.requestReleaseDateField(true);
    }
    public APIRequestGetLinkedPage requestReleaseDateField (boolean value) {
      this.requestField("release_date", value);
      return this;
    }
    public APIRequestGetLinkedPage requestRestaurantServicesField () {
      return this.requestRestaurantServicesField(true);
    }
    public APIRequestGetLinkedPage requestRestaurantServicesField (boolean value) {
      this.requestField("restaurant_services", value);
      return this;
    }
    public APIRequestGetLinkedPage requestRestaurantSpecialtiesField () {
      return this.requestRestaurantSpecialtiesField(true);
    }
    public APIRequestGetLinkedPage requestRestaurantSpecialtiesField (boolean value) {
      this.requestField("restaurant_specialties", value);
      return this;
    }
    public APIRequestGetLinkedPage requestScheduleField () {
      return this.requestScheduleField(true);
    }
    public APIRequestGetLinkedPage requestScheduleField (boolean value) {
      this.requestField("schedule", value);
      return this;
    }
    public APIRequestGetLinkedPage requestScreenplayByField () {
      return this.requestScreenplayByField(true);
    }
    public APIRequestGetLinkedPage requestScreenplayByField (boolean value) {
      this.requestField("screenplay_by", value);
      return this;
    }
    public APIRequestGetLinkedPage requestSeasonField () {
      return this.requestSeasonField(true);
    }
    public APIRequestGetLinkedPage requestSeasonField (boolean value) {
      this.requestField("season", value);
      return this;
    }
    public APIRequestGetLinkedPage requestSingleLineAddressField () {
      return this.requestSingleLineAddressField(true);
    }
    public APIRequestGetLinkedPage requestSingleLineAddressField (boolean value) {
      this.requestField("single_line_address", value);
      return this;
    }
    public APIRequestGetLinkedPage requestStarringField () {
      return this.requestStarringField(true);
    }
    public APIRequestGetLinkedPage requestStarringField (boolean value) {
      this.requestField("starring", value);
      return this;
    }
    public APIRequestGetLinkedPage requestStartInfoField () {
      return this.requestStartInfoField(true);
    }
    public APIRequestGetLinkedPage requestStartInfoField (boolean value) {
      this.requestField("start_info", value);
      return this;
    }
    public APIRequestGetLinkedPage requestStoreCodeField () {
      return this.requestStoreCodeField(true);
    }
    public APIRequestGetLinkedPage requestStoreCodeField (boolean value) {
      this.requestField("store_code", value);
      return this;
    }
    public APIRequestGetLinkedPage requestStoreLocationDescriptorField () {
      return this.requestStoreLocationDescriptorField(true);
    }
    public APIRequestGetLinkedPage requestStoreLocationDescriptorField (boolean value) {
      this.requestField("store_location_descriptor", value);
      return this;
    }
    public APIRequestGetLinkedPage requestStoreNumberField () {
      return this.requestStoreNumberField(true);
    }
    public APIRequestGetLinkedPage requestStoreNumberField (boolean value) {
      this.requestField("store_number", value);
      return this;
    }
    public APIRequestGetLinkedPage requestStudioField () {
      return this.requestStudioField(true);
    }
    public APIRequestGetLinkedPage requestStudioField (boolean value) {
      this.requestField("studio", value);
      return this;
    }
    public APIRequestGetLinkedPage requestSupportsDonateButtonInLiveVideoField () {
      return this.requestSupportsDonateButtonInLiveVideoField(true);
    }
    public APIRequestGetLinkedPage requestSupportsDonateButtonInLiveVideoField (boolean value) {
      this.requestField("supports_donate_button_in_live_video", value);
      return this;
    }
    public APIRequestGetLinkedPage requestTalkingAboutCountField () {
      return this.requestTalkingAboutCountField(true);
    }
    public APIRequestGetLinkedPage requestTalkingAboutCountField (boolean value) {
      this.requestField("talking_about_count", value);
      return this;
    }
    public APIRequestGetLinkedPage requestTemporaryStatusField () {
      return this.requestTemporaryStatusField(true);
    }
    public APIRequestGetLinkedPage requestTemporaryStatusField (boolean value) {
      this.requestField("temporary_status", value);
      return this;
    }
    public APIRequestGetLinkedPage requestUnreadMessageCountField () {
      return this.requestUnreadMessageCountField(true);
    }
    public APIRequestGetLinkedPage requestUnreadMessageCountField (boolean value) {
      this.requestField("unread_message_count", value);
      return this;
    }
    public APIRequestGetLinkedPage requestUnreadNotifCountField () {
      return this.requestUnreadNotifCountField(true);
    }
    public APIRequestGetLinkedPage requestUnreadNotifCountField (boolean value) {
      this.requestField("unread_notif_count", value);
      return this;
    }
    public APIRequestGetLinkedPage requestUnseenMessageCountField () {
      return this.requestUnseenMessageCountField(true);
    }
    public APIRequestGetLinkedPage requestUnseenMessageCountField (boolean value) {
      this.requestField("unseen_message_count", value);
      return this;
    }
    public APIRequestGetLinkedPage requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetLinkedPage requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetLinkedPage requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetLinkedPage requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetLinkedPage requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetLinkedPage requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetLinkedPage requestVoipInfoField () {
      return this.requestVoipInfoField(true);
    }
    public APIRequestGetLinkedPage requestVoipInfoField (boolean value) {
      this.requestField("voip_info", value);
      return this;
    }
    public APIRequestGetLinkedPage requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetLinkedPage requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetLinkedPage requestWereHereCountField () {
      return this.requestWereHereCountField(true);
    }
    public APIRequestGetLinkedPage requestWereHereCountField (boolean value) {
      this.requestField("were_here_count", value);
      return this;
    }
    public APIRequestGetLinkedPage requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGetLinkedPage requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
      return this;
    }
    public APIRequestGetLinkedPage requestWrittenByField () {
      return this.requestWrittenByField(true);
    }
    public APIRequestGetLinkedPage requestWrittenByField (boolean value) {
      this.requestField("written_by", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<OffsiteSignalContainerBusinessObject> {

    OffsiteSignalContainerBusinessObject lastResponse = null;
    @Override
    public OffsiteSignalContainerBusinessObject getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "id",
      "is_eligible_for_sharing_to_ad_account",
      "is_eligible_for_sharing_to_business",
      "is_unavailable",
      "name",
      "primary_container_id",
    };

    @Override
    public OffsiteSignalContainerBusinessObject parseResponse(String response, String header) throws APIException {
      return OffsiteSignalContainerBusinessObject.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public OffsiteSignalContainerBusinessObject execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public OffsiteSignalContainerBusinessObject execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<OffsiteSignalContainerBusinessObject> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<OffsiteSignalContainerBusinessObject> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, OffsiteSignalContainerBusinessObject>() {
           public OffsiteSignalContainerBusinessObject apply(ResponseWrapper result) {
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

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsEligibleForSharingToAdAccountField () {
      return this.requestIsEligibleForSharingToAdAccountField(true);
    }
    public APIRequestGet requestIsEligibleForSharingToAdAccountField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_ad_account", value);
      return this;
    }
    public APIRequestGet requestIsEligibleForSharingToBusinessField () {
      return this.requestIsEligibleForSharingToBusinessField(true);
    }
    public APIRequestGet requestIsEligibleForSharingToBusinessField (boolean value) {
      this.requestField("is_eligible_for_sharing_to_business", value);
      return this;
    }
    public APIRequestGet requestIsUnavailableField () {
      return this.requestIsUnavailableField(true);
    }
    public APIRequestGet requestIsUnavailableField (boolean value) {
      this.requestField("is_unavailable", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPrimaryContainerIdField () {
      return this.requestPrimaryContainerIdField(true);
    }
    public APIRequestGet requestPrimaryContainerIdField (boolean value) {
      this.requestField("primary_container_id", value);
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

  public OffsiteSignalContainerBusinessObject copyFrom(OffsiteSignalContainerBusinessObject instance) {
    this.mBusiness = instance.mBusiness;
    this.mId = instance.mId;
    this.mIsEligibleForSharingToAdAccount = instance.mIsEligibleForSharingToAdAccount;
    this.mIsEligibleForSharingToBusiness = instance.mIsEligibleForSharingToBusiness;
    this.mIsUnavailable = instance.mIsUnavailable;
    this.mName = instance.mName;
    this.mPrimaryContainerId = instance.mPrimaryContainerId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<OffsiteSignalContainerBusinessObject> getParser() {
    return new APIRequest.ResponseParser<OffsiteSignalContainerBusinessObject>() {
      public APINodeList<OffsiteSignalContainerBusinessObject> parseResponse(String response, APIContext context, APIRequest<OffsiteSignalContainerBusinessObject> request, String header) throws MalformedResponseException {
        return OffsiteSignalContainerBusinessObject.parseResponse(response, context, request, header);
      }
    };
  }
}
