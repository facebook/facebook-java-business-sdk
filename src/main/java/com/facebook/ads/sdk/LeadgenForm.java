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
public class LeadgenForm extends APINode {
  @SerializedName("allow_organic_lead")
  private Boolean mAllowOrganicLead = null;
  @SerializedName("block_display_for_non_targeted_viewer")
  private Boolean mBlockDisplayForNonTargetedViewer = null;
  @SerializedName("context_card")
  private LeadGenContextCard mContextCard = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("expired_leads_count")
  private Long mExpiredLeadsCount = null;
  @SerializedName("follow_up_action_text")
  private String mFollowUpActionText = null;
  @SerializedName("follow_up_action_url")
  private String mFollowUpActionUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_optimized_for_quality")
  private Boolean mIsOptimizedForQuality = null;
  @SerializedName("leads_count")
  private Long mLeadsCount = null;
  @SerializedName("legal_content")
  private LeadGenLegalContent mLegalContent = null;
  @SerializedName("locale")
  private String mLocale = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("organic_leads_count")
  private Long mOrganicLeadsCount = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("privacy_policy_url")
  private String mPrivacyPolicyUrl = null;
  @SerializedName("question_page_custom_headline")
  private String mQuestionPageCustomHeadline = null;
  @SerializedName("questions")
  private List<LeadGenQuestion> mQuestions = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("thank_you_page")
  private LeadGenThankYouPage mThankYouPage = null;
  @SerializedName("tracking_parameters")
  private List<KeyValue> mTrackingParameters = null;
  protected static Gson gson = null;

  LeadgenForm() {
  }

  public LeadgenForm(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LeadgenForm(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LeadgenForm fetch() throws APIException{
    LeadgenForm newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LeadgenForm fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LeadgenForm> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LeadgenForm fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LeadgenForm> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LeadgenForm> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LeadgenForm>)(
      new APIRequest<LeadgenForm>(context, "", "/", "GET", LeadgenForm.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LeadgenForm>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LeadgenForm.getParser())
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
  public static LeadgenForm loadJSON(String json, APIContext context, String header) {
    LeadgenForm leadgenForm = getGson().fromJson(json, LeadgenForm.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(leadgenForm.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    leadgenForm.context = context;
    leadgenForm.rawValue = json;
    leadgenForm.header = header;
    return leadgenForm;
  }

  public static APINodeList<LeadgenForm> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LeadgenForm> leadgenForms = new APINodeList<LeadgenForm>(request, json, header);
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
          leadgenForms.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return leadgenForms;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                leadgenForms.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            leadgenForms.setPaging(previous, next);
            if (context.hasAppSecret()) {
              leadgenForms.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leadgenForms.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  leadgenForms.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              leadgenForms.add(loadJSON(obj.toString(), context, header));
            }
          }
          return leadgenForms;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leadgenForms.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return leadgenForms;
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
              leadgenForms.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return leadgenForms;
          }

          // Sixth, check if it's pure JsonObject
          leadgenForms.clear();
          leadgenForms.add(loadJSON(json, context, header));
          return leadgenForms;
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

  public APIRequestGetLeads getLeads() {
    return new APIRequestGetLeads(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTestLeads getTestLeads() {
    return new APIRequestGetTestLeads(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateTestLead createTestLead() {
    return new APIRequestCreateTestLead(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Boolean getFieldAllowOrganicLead() {
    return mAllowOrganicLead;
  }

  public Boolean getFieldBlockDisplayForNonTargetedViewer() {
    return mBlockDisplayForNonTargetedViewer;
  }

  public LeadGenContextCard getFieldContextCard() {
    return mContextCard;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public Long getFieldExpiredLeadsCount() {
    return mExpiredLeadsCount;
  }

  public String getFieldFollowUpActionText() {
    return mFollowUpActionText;
  }

  public String getFieldFollowUpActionUrl() {
    return mFollowUpActionUrl;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsOptimizedForQuality() {
    return mIsOptimizedForQuality;
  }

  public Long getFieldLeadsCount() {
    return mLeadsCount;
  }

  public LeadGenLegalContent getFieldLegalContent() {
    return mLegalContent;
  }

  public String getFieldLocale() {
    return mLocale;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldOrganicLeadsCount() {
    return mOrganicLeadsCount;
  }

  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public String getFieldPrivacyPolicyUrl() {
    return mPrivacyPolicyUrl;
  }

  public String getFieldQuestionPageCustomHeadline() {
    return mQuestionPageCustomHeadline;
  }

  public List<LeadGenQuestion> getFieldQuestions() {
    return mQuestions;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public LeadGenThankYouPage getFieldThankYouPage() {
    return mThankYouPage;
  }

  public List<KeyValue> getFieldTrackingParameters() {
    return mTrackingParameters;
  }



  public static class APIRequestGetLeads extends APIRequest<Lead> {

    APINodeList<Lead> lastResponse = null;
    @Override
    public APINodeList<Lead> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_id",
      "ad_name",
      "adset_id",
      "adset_name",
      "campaign_id",
      "campaign_name",
      "created_time",
      "custom_disclaimer_responses",
      "field_data",
      "form_id",
      "home_listing",
      "id",
      "is_organic",
      "partner_name",
      "platform",
      "post",
      "post_submission_check_result",
      "retailer_item_id",
      "vehicle",
    };

    @Override
    public APINodeList<Lead> parseResponse(String response, String header) throws APIException {
      return Lead.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Lead> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Lead> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Lead>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Lead>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Lead>>() {
           public APINodeList<Lead> apply(ResponseWrapper result) {
             try {
               return APIRequestGetLeads.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetLeads(String nodeId, APIContext context) {
      super(context, nodeId, "/leads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLeads setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLeads setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLeads requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLeads requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeads requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLeads requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLeads requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLeads requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetLeads requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGetLeads requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGetLeads requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGetLeads requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGetLeads requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetLeads requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetLeads requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGetLeads requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGetLeads requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetLeads requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetLeads requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGetLeads requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGetLeads requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetLeads requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetLeads requestCustomDisclaimerResponsesField () {
      return this.requestCustomDisclaimerResponsesField(true);
    }
    public APIRequestGetLeads requestCustomDisclaimerResponsesField (boolean value) {
      this.requestField("custom_disclaimer_responses", value);
      return this;
    }
    public APIRequestGetLeads requestFieldDataField () {
      return this.requestFieldDataField(true);
    }
    public APIRequestGetLeads requestFieldDataField (boolean value) {
      this.requestField("field_data", value);
      return this;
    }
    public APIRequestGetLeads requestFormIdField () {
      return this.requestFormIdField(true);
    }
    public APIRequestGetLeads requestFormIdField (boolean value) {
      this.requestField("form_id", value);
      return this;
    }
    public APIRequestGetLeads requestHomeListingField () {
      return this.requestHomeListingField(true);
    }
    public APIRequestGetLeads requestHomeListingField (boolean value) {
      this.requestField("home_listing", value);
      return this;
    }
    public APIRequestGetLeads requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetLeads requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetLeads requestIsOrganicField () {
      return this.requestIsOrganicField(true);
    }
    public APIRequestGetLeads requestIsOrganicField (boolean value) {
      this.requestField("is_organic", value);
      return this;
    }
    public APIRequestGetLeads requestPartnerNameField () {
      return this.requestPartnerNameField(true);
    }
    public APIRequestGetLeads requestPartnerNameField (boolean value) {
      this.requestField("partner_name", value);
      return this;
    }
    public APIRequestGetLeads requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGetLeads requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGetLeads requestPostField () {
      return this.requestPostField(true);
    }
    public APIRequestGetLeads requestPostField (boolean value) {
      this.requestField("post", value);
      return this;
    }
    public APIRequestGetLeads requestPostSubmissionCheckResultField () {
      return this.requestPostSubmissionCheckResultField(true);
    }
    public APIRequestGetLeads requestPostSubmissionCheckResultField (boolean value) {
      this.requestField("post_submission_check_result", value);
      return this;
    }
    public APIRequestGetLeads requestRetailerItemIdField () {
      return this.requestRetailerItemIdField(true);
    }
    public APIRequestGetLeads requestRetailerItemIdField (boolean value) {
      this.requestField("retailer_item_id", value);
      return this;
    }
    public APIRequestGetLeads requestVehicleField () {
      return this.requestVehicleField(true);
    }
    public APIRequestGetLeads requestVehicleField (boolean value) {
      this.requestField("vehicle", value);
      return this;
    }
  }

  public static class APIRequestGetTestLeads extends APIRequest<Lead> {

    APINodeList<Lead> lastResponse = null;
    @Override
    public APINodeList<Lead> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_id",
      "ad_name",
      "adset_id",
      "adset_name",
      "campaign_id",
      "campaign_name",
      "created_time",
      "custom_disclaimer_responses",
      "field_data",
      "form_id",
      "home_listing",
      "id",
      "is_organic",
      "partner_name",
      "platform",
      "post",
      "post_submission_check_result",
      "retailer_item_id",
      "vehicle",
    };

    @Override
    public APINodeList<Lead> parseResponse(String response, String header) throws APIException {
      return Lead.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Lead> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Lead> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Lead>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Lead>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Lead>>() {
           public APINodeList<Lead> apply(ResponseWrapper result) {
             try {
               return APIRequestGetTestLeads.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTestLeads(String nodeId, APIContext context) {
      super(context, nodeId, "/test_leads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTestLeads setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTestLeads setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTestLeads requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTestLeads requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTestLeads requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTestLeads requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTestLeads requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTestLeads requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetTestLeads requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGetTestLeads requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGetTestLeads requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGetTestLeads requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGetTestLeads requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetTestLeads requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetTestLeads requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGetTestLeads requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGetTestLeads requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetTestLeads requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetTestLeads requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGetTestLeads requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGetTestLeads requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetTestLeads requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetTestLeads requestCustomDisclaimerResponsesField () {
      return this.requestCustomDisclaimerResponsesField(true);
    }
    public APIRequestGetTestLeads requestCustomDisclaimerResponsesField (boolean value) {
      this.requestField("custom_disclaimer_responses", value);
      return this;
    }
    public APIRequestGetTestLeads requestFieldDataField () {
      return this.requestFieldDataField(true);
    }
    public APIRequestGetTestLeads requestFieldDataField (boolean value) {
      this.requestField("field_data", value);
      return this;
    }
    public APIRequestGetTestLeads requestFormIdField () {
      return this.requestFormIdField(true);
    }
    public APIRequestGetTestLeads requestFormIdField (boolean value) {
      this.requestField("form_id", value);
      return this;
    }
    public APIRequestGetTestLeads requestHomeListingField () {
      return this.requestHomeListingField(true);
    }
    public APIRequestGetTestLeads requestHomeListingField (boolean value) {
      this.requestField("home_listing", value);
      return this;
    }
    public APIRequestGetTestLeads requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetTestLeads requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetTestLeads requestIsOrganicField () {
      return this.requestIsOrganicField(true);
    }
    public APIRequestGetTestLeads requestIsOrganicField (boolean value) {
      this.requestField("is_organic", value);
      return this;
    }
    public APIRequestGetTestLeads requestPartnerNameField () {
      return this.requestPartnerNameField(true);
    }
    public APIRequestGetTestLeads requestPartnerNameField (boolean value) {
      this.requestField("partner_name", value);
      return this;
    }
    public APIRequestGetTestLeads requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGetTestLeads requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGetTestLeads requestPostField () {
      return this.requestPostField(true);
    }
    public APIRequestGetTestLeads requestPostField (boolean value) {
      this.requestField("post", value);
      return this;
    }
    public APIRequestGetTestLeads requestPostSubmissionCheckResultField () {
      return this.requestPostSubmissionCheckResultField(true);
    }
    public APIRequestGetTestLeads requestPostSubmissionCheckResultField (boolean value) {
      this.requestField("post_submission_check_result", value);
      return this;
    }
    public APIRequestGetTestLeads requestRetailerItemIdField () {
      return this.requestRetailerItemIdField(true);
    }
    public APIRequestGetTestLeads requestRetailerItemIdField (boolean value) {
      this.requestField("retailer_item_id", value);
      return this;
    }
    public APIRequestGetTestLeads requestVehicleField () {
      return this.requestVehicleField(true);
    }
    public APIRequestGetTestLeads requestVehicleField (boolean value) {
      this.requestField("vehicle", value);
      return this;
    }
  }

  public static class APIRequestCreateTestLead extends APIRequest<Lead> {

    Lead lastResponse = null;
    @Override
    public Lead getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "custom_disclaimer_responses",
      "field_data",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Lead parseResponse(String response, String header) throws APIException {
      return Lead.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Lead execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Lead execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Lead> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Lead> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Lead>() {
           public Lead apply(ResponseWrapper result) {
             try {
               return APIRequestCreateTestLead.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateTestLead(String nodeId, APIContext context) {
      super(context, nodeId, "/test_leads", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateTestLead setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateTestLead setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateTestLead setCustomDisclaimerResponses (List<Object> customDisclaimerResponses) {
      this.setParam("custom_disclaimer_responses", customDisclaimerResponses);
      return this;
    }
    public APIRequestCreateTestLead setCustomDisclaimerResponses (String customDisclaimerResponses) {
      this.setParam("custom_disclaimer_responses", customDisclaimerResponses);
      return this;
    }

    public APIRequestCreateTestLead setFieldData (List<Object> fieldData) {
      this.setParam("field_data", fieldData);
      return this;
    }
    public APIRequestCreateTestLead setFieldData (String fieldData) {
      this.setParam("field_data", fieldData);
      return this;
    }

    public APIRequestCreateTestLead requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateTestLead requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTestLead requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateTestLead requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTestLead requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateTestLead requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<LeadgenForm> {

    LeadgenForm lastResponse = null;
    @Override
    public LeadgenForm getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "allow_organic_lead",
      "block_display_for_non_targeted_viewer",
      "context_card",
      "created_time",
      "creator",
      "expired_leads_count",
      "follow_up_action_text",
      "follow_up_action_url",
      "id",
      "is_optimized_for_quality",
      "leads_count",
      "legal_content",
      "locale",
      "name",
      "organic_leads_count",
      "page",
      "page_id",
      "privacy_policy_url",
      "question_page_custom_headline",
      "questions",
      "status",
      "thank_you_page",
      "tracking_parameters",
    };

    @Override
    public LeadgenForm parseResponse(String response, String header) throws APIException {
      return LeadgenForm.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LeadgenForm execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LeadgenForm execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LeadgenForm> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LeadgenForm> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LeadgenForm>() {
           public LeadgenForm apply(ResponseWrapper result) {
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

    public APIRequestGet requestAllowOrganicLeadField () {
      return this.requestAllowOrganicLeadField(true);
    }
    public APIRequestGet requestAllowOrganicLeadField (boolean value) {
      this.requestField("allow_organic_lead", value);
      return this;
    }
    public APIRequestGet requestBlockDisplayForNonTargetedViewerField () {
      return this.requestBlockDisplayForNonTargetedViewerField(true);
    }
    public APIRequestGet requestBlockDisplayForNonTargetedViewerField (boolean value) {
      this.requestField("block_display_for_non_targeted_viewer", value);
      return this;
    }
    public APIRequestGet requestContextCardField () {
      return this.requestContextCardField(true);
    }
    public APIRequestGet requestContextCardField (boolean value) {
      this.requestField("context_card", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestExpiredLeadsCountField () {
      return this.requestExpiredLeadsCountField(true);
    }
    public APIRequestGet requestExpiredLeadsCountField (boolean value) {
      this.requestField("expired_leads_count", value);
      return this;
    }
    public APIRequestGet requestFollowUpActionTextField () {
      return this.requestFollowUpActionTextField(true);
    }
    public APIRequestGet requestFollowUpActionTextField (boolean value) {
      this.requestField("follow_up_action_text", value);
      return this;
    }
    public APIRequestGet requestFollowUpActionUrlField () {
      return this.requestFollowUpActionUrlField(true);
    }
    public APIRequestGet requestFollowUpActionUrlField (boolean value) {
      this.requestField("follow_up_action_url", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsOptimizedForQualityField () {
      return this.requestIsOptimizedForQualityField(true);
    }
    public APIRequestGet requestIsOptimizedForQualityField (boolean value) {
      this.requestField("is_optimized_for_quality", value);
      return this;
    }
    public APIRequestGet requestLeadsCountField () {
      return this.requestLeadsCountField(true);
    }
    public APIRequestGet requestLeadsCountField (boolean value) {
      this.requestField("leads_count", value);
      return this;
    }
    public APIRequestGet requestLegalContentField () {
      return this.requestLegalContentField(true);
    }
    public APIRequestGet requestLegalContentField (boolean value) {
      this.requestField("legal_content", value);
      return this;
    }
    public APIRequestGet requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGet requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOrganicLeadsCountField () {
      return this.requestOrganicLeadsCountField(true);
    }
    public APIRequestGet requestOrganicLeadsCountField (boolean value) {
      this.requestField("organic_leads_count", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestPageIdField () {
      return this.requestPageIdField(true);
    }
    public APIRequestGet requestPageIdField (boolean value) {
      this.requestField("page_id", value);
      return this;
    }
    public APIRequestGet requestPrivacyPolicyUrlField () {
      return this.requestPrivacyPolicyUrlField(true);
    }
    public APIRequestGet requestPrivacyPolicyUrlField (boolean value) {
      this.requestField("privacy_policy_url", value);
      return this;
    }
    public APIRequestGet requestQuestionPageCustomHeadlineField () {
      return this.requestQuestionPageCustomHeadlineField(true);
    }
    public APIRequestGet requestQuestionPageCustomHeadlineField (boolean value) {
      this.requestField("question_page_custom_headline", value);
      return this;
    }
    public APIRequestGet requestQuestionsField () {
      return this.requestQuestionsField(true);
    }
    public APIRequestGet requestQuestionsField (boolean value) {
      this.requestField("questions", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestThankYouPageField () {
      return this.requestThankYouPageField(true);
    }
    public APIRequestGet requestThankYouPageField (boolean value) {
      this.requestField("thank_you_page", value);
      return this;
    }
    public APIRequestGet requestTrackingParametersField () {
      return this.requestTrackingParametersField(true);
    }
    public APIRequestGet requestTrackingParametersField (boolean value) {
      this.requestField("tracking_parameters", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<LeadgenForm> {

    LeadgenForm lastResponse = null;
    @Override
    public LeadgenForm getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LeadgenForm parseResponse(String response, String header) throws APIException {
      return LeadgenForm.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LeadgenForm execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LeadgenForm execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LeadgenForm> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LeadgenForm> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LeadgenForm>() {
           public LeadgenForm apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setStatus (LeadgenForm.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      ;

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLocale {
      @SerializedName("AR_AR")
      VALUE_AR_AR("AR_AR"),
      @SerializedName("CS_CZ")
      VALUE_CS_CZ("CS_CZ"),
      @SerializedName("DA_DK")
      VALUE_DA_DK("DA_DK"),
      @SerializedName("DE_DE")
      VALUE_DE_DE("DE_DE"),
      @SerializedName("EL_GR")
      VALUE_EL_GR("EL_GR"),
      @SerializedName("EN_GB")
      VALUE_EN_GB("EN_GB"),
      @SerializedName("EN_US")
      VALUE_EN_US("EN_US"),
      @SerializedName("ES_ES")
      VALUE_ES_ES("ES_ES"),
      @SerializedName("ES_LA")
      VALUE_ES_LA("ES_LA"),
      @SerializedName("FI_FI")
      VALUE_FI_FI("FI_FI"),
      @SerializedName("FR_FR")
      VALUE_FR_FR("FR_FR"),
      @SerializedName("HE_IL")
      VALUE_HE_IL("HE_IL"),
      @SerializedName("HI_IN")
      VALUE_HI_IN("HI_IN"),
      @SerializedName("HU_HU")
      VALUE_HU_HU("HU_HU"),
      @SerializedName("ID_ID")
      VALUE_ID_ID("ID_ID"),
      @SerializedName("IT_IT")
      VALUE_IT_IT("IT_IT"),
      @SerializedName("JA_JP")
      VALUE_JA_JP("JA_JP"),
      @SerializedName("KO_KR")
      VALUE_KO_KR("KO_KR"),
      @SerializedName("NB_NO")
      VALUE_NB_NO("NB_NO"),
      @SerializedName("NL_NL")
      VALUE_NL_NL("NL_NL"),
      @SerializedName("PL_PL")
      VALUE_PL_PL("PL_PL"),
      @SerializedName("PT_BR")
      VALUE_PT_BR("PT_BR"),
      @SerializedName("PT_PT")
      VALUE_PT_PT("PT_PT"),
      @SerializedName("RO_RO")
      VALUE_RO_RO("RO_RO"),
      @SerializedName("RU_RU")
      VALUE_RU_RU("RU_RU"),
      @SerializedName("SV_SE")
      VALUE_SV_SE("SV_SE"),
      @SerializedName("TH_TH")
      VALUE_TH_TH("TH_TH"),
      @SerializedName("TR_TR")
      VALUE_TR_TR("TR_TR"),
      @SerializedName("VI_VN")
      VALUE_VI_VN("VI_VN"),
      @SerializedName("ZH_CN")
      VALUE_ZH_CN("ZH_CN"),
      @SerializedName("ZH_HK")
      VALUE_ZH_HK("ZH_HK"),
      @SerializedName("ZH_TW")
      VALUE_ZH_TW("ZH_TW"),
      ;

      private String value;

      private EnumLocale(String value) {
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

  public LeadgenForm copyFrom(LeadgenForm instance) {
    this.mAllowOrganicLead = instance.mAllowOrganicLead;
    this.mBlockDisplayForNonTargetedViewer = instance.mBlockDisplayForNonTargetedViewer;
    this.mContextCard = instance.mContextCard;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreator = instance.mCreator;
    this.mExpiredLeadsCount = instance.mExpiredLeadsCount;
    this.mFollowUpActionText = instance.mFollowUpActionText;
    this.mFollowUpActionUrl = instance.mFollowUpActionUrl;
    this.mId = instance.mId;
    this.mIsOptimizedForQuality = instance.mIsOptimizedForQuality;
    this.mLeadsCount = instance.mLeadsCount;
    this.mLegalContent = instance.mLegalContent;
    this.mLocale = instance.mLocale;
    this.mName = instance.mName;
    this.mOrganicLeadsCount = instance.mOrganicLeadsCount;
    this.mPage = instance.mPage;
    this.mPageId = instance.mPageId;
    this.mPrivacyPolicyUrl = instance.mPrivacyPolicyUrl;
    this.mQuestionPageCustomHeadline = instance.mQuestionPageCustomHeadline;
    this.mQuestions = instance.mQuestions;
    this.mStatus = instance.mStatus;
    this.mThankYouPage = instance.mThankYouPage;
    this.mTrackingParameters = instance.mTrackingParameters;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LeadgenForm> getParser() {
    return new APIRequest.ResponseParser<LeadgenForm>() {
      public APINodeList<LeadgenForm> parseResponse(String response, APIContext context, APIRequest<LeadgenForm> request, String header) throws MalformedResponseException {
        return LeadgenForm.parseResponse(response, context, request, header);
      }
    };
  }
}
