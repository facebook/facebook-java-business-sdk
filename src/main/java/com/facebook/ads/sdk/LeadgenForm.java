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
 * This class is auto-genereated.
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
  private Object mContextCard = null;
  @SerializedName("continued_flow_request_method")
  private String mContinuedFlowRequestMethod = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("creator_id")
  private Long mCreatorId = null;
  @SerializedName("cusomized_tcpa_content")
  private String mCusomizedTcpaContent = null;
  @SerializedName("expired_leads_count")
  private Long mExpiredLeadsCount = null;
  @SerializedName("follow_up_action_text")
  private String mFollowUpActionText = null;
  @SerializedName("follow_up_action_url")
  private String mFollowUpActionUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_continued_flow")
  private Boolean mIsContinuedFlow = null;
  @SerializedName("leadgen_export_csv_url")
  private String mLeadgenExportCsvUrl = null;
  @SerializedName("leads_count")
  private Long mLeadsCount = null;
  @SerializedName("legal_content")
  private Object mLegalContent = null;
  @SerializedName("locale")
  private String mLocale = null;
  @SerializedName("messenger_welcome_message")
  private String mMessengerWelcomeMessage = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("organic_leads_count")
  private Long mOrganicLeadsCount = null;
  @SerializedName("page")
  private Object mPage = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("privacy_policy_url")
  private String mPrivacyPolicyUrl = null;
  @SerializedName("qualifiers")
  private List<LeadGenQualifier> mQualifiers = null;
  @SerializedName("questions")
  private List<LeadGenQuestion> mQuestions = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("tcpa_compliance")
  private Boolean mTcpaCompliance = null;
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

  public static LeadgenForm fetchById(String id, APIContext context) throws APIException {
    LeadgenForm leadgenForm =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return leadgenForm;
  }

  public static APINodeList<LeadgenForm> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LeadgenForm>)(
      new APIRequest<LeadgenForm>(context, "", "/", "GET", LeadgenForm.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static LeadgenForm loadJSON(String json, APIContext context) {
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
      };
    }
    leadgenForm.context = context;
    leadgenForm.rawValue = json;
    return leadgenForm;
  }

  public static APINodeList<LeadgenForm> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<LeadgenForm> leadgenForms = new APINodeList<LeadgenForm>(request, json);
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
          leadgenForms.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return leadgenForms;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            leadgenForms.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leadgenForms.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  leadgenForms.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              leadgenForms.add(loadJSON(obj.toString(), context));
            }
          }
          return leadgenForms;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leadgenForms.add(loadJSON(entry.getValue().toString(), context));
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
              leadgenForms.add(loadJSON(value.toString(), context));
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
          leadgenForms.add(loadJSON(json, context));
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

  public APIRequestCreateTestLead createTestLead() {
    return new APIRequestCreateTestLead(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Boolean getFieldAllowOrganicLead() {
    return mAllowOrganicLead;
  }

  public Boolean getFieldBlockDisplayForNonTargetedViewer() {
    return mBlockDisplayForNonTargetedViewer;
  }

  public Object getFieldContextCard() {
    return mContextCard;
  }

  public String getFieldContinuedFlowRequestMethod() {
    return mContinuedFlowRequestMethod;
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

  public Long getFieldCreatorId() {
    return mCreatorId;
  }

  public String getFieldCusomizedTcpaContent() {
    return mCusomizedTcpaContent;
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

  public Boolean getFieldIsContinuedFlow() {
    return mIsContinuedFlow;
  }

  public String getFieldLeadgenExportCsvUrl() {
    return mLeadgenExportCsvUrl;
  }

  public Long getFieldLeadsCount() {
    return mLeadsCount;
  }

  public Object getFieldLegalContent() {
    return mLegalContent;
  }

  public String getFieldLocale() {
    return mLocale;
  }

  public String getFieldMessengerWelcomeMessage() {
    return mMessengerWelcomeMessage;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldOrganicLeadsCount() {
    return mOrganicLeadsCount;
  }

  public Object getFieldPage() {
    return mPage;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public String getFieldPrivacyPolicyUrl() {
    return mPrivacyPolicyUrl;
  }

  public List<LeadGenQualifier> getFieldQualifiers() {
    return mQualifiers;
  }

  public List<LeadGenQuestion> getFieldQuestions() {
    return mQuestions;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public Boolean getFieldTcpaCompliance() {
    return mTcpaCompliance;
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
      "id",
      "is_organic",
      "post",
      "retailer_item_id",
    };

    @Override
    public APINodeList<Lead> parseResponse(String response) throws APIException {
      return Lead.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Lead> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Lead> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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
    public APIRequestGetLeads requestPostField () {
      return this.requestPostField(true);
    }
    public APIRequestGetLeads requestPostField (boolean value) {
      this.requestField("post", value);
      return this;
    }
    public APIRequestGetLeads requestRetailerItemIdField () {
      return this.requestRetailerItemIdField(true);
    }
    public APIRequestGetLeads requestRetailerItemIdField (boolean value) {
      this.requestField("retailer_item_id", value);
      return this;
    }
  }

  public static class APIRequestCreateTestLead extends APIRequest<LeadgenForm> {

    LeadgenForm lastResponse = null;
    @Override
    public LeadgenForm getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "custom_disclaimer_responses",
      "field_data",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public LeadgenForm parseResponse(String response) throws APIException {
      return LeadgenForm.parseResponse(response, getContext(), this).head();
    }

    @Override
    public LeadgenForm execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LeadgenForm execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
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
      "continued_flow_request_method",
      "created_time",
      "creator",
      "creator_id",
      "cusomized_tcpa_content",
      "expired_leads_count",
      "follow_up_action_text",
      "follow_up_action_url",
      "id",
      "is_continued_flow",
      "leadgen_export_csv_url",
      "leads_count",
      "legal_content",
      "locale",
      "messenger_welcome_message",
      "name",
      "organic_leads_count",
      "page",
      "page_id",
      "privacy_policy_url",
      "qualifiers",
      "questions",
      "status",
      "tcpa_compliance",
    };

    @Override
    public LeadgenForm parseResponse(String response) throws APIException {
      return LeadgenForm.parseResponse(response, getContext(), this).head();
    }

    @Override
    public LeadgenForm execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LeadgenForm execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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
    public APIRequestGet requestContinuedFlowRequestMethodField () {
      return this.requestContinuedFlowRequestMethodField(true);
    }
    public APIRequestGet requestContinuedFlowRequestMethodField (boolean value) {
      this.requestField("continued_flow_request_method", value);
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
    public APIRequestGet requestCreatorIdField () {
      return this.requestCreatorIdField(true);
    }
    public APIRequestGet requestCreatorIdField (boolean value) {
      this.requestField("creator_id", value);
      return this;
    }
    public APIRequestGet requestCusomizedTcpaContentField () {
      return this.requestCusomizedTcpaContentField(true);
    }
    public APIRequestGet requestCusomizedTcpaContentField (boolean value) {
      this.requestField("cusomized_tcpa_content", value);
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
    public APIRequestGet requestIsContinuedFlowField () {
      return this.requestIsContinuedFlowField(true);
    }
    public APIRequestGet requestIsContinuedFlowField (boolean value) {
      this.requestField("is_continued_flow", value);
      return this;
    }
    public APIRequestGet requestLeadgenExportCsvUrlField () {
      return this.requestLeadgenExportCsvUrlField(true);
    }
    public APIRequestGet requestLeadgenExportCsvUrlField (boolean value) {
      this.requestField("leadgen_export_csv_url", value);
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
    public APIRequestGet requestMessengerWelcomeMessageField () {
      return this.requestMessengerWelcomeMessageField(true);
    }
    public APIRequestGet requestMessengerWelcomeMessageField (boolean value) {
      this.requestField("messenger_welcome_message", value);
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
    public APIRequestGet requestQualifiersField () {
      return this.requestQualifiersField(true);
    }
    public APIRequestGet requestQualifiersField (boolean value) {
      this.requestField("qualifiers", value);
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
    public APIRequestGet requestTcpaComplianceField () {
      return this.requestTcpaComplianceField(true);
    }
    public APIRequestGet requestTcpaComplianceField (boolean value) {
      this.requestField("tcpa_compliance", value);
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

  public LeadgenForm copyFrom(LeadgenForm instance) {
    this.mAllowOrganicLead = instance.mAllowOrganicLead;
    this.mBlockDisplayForNonTargetedViewer = instance.mBlockDisplayForNonTargetedViewer;
    this.mContextCard = instance.mContextCard;
    this.mContinuedFlowRequestMethod = instance.mContinuedFlowRequestMethod;
    this.mCreatedTime = instance.mCreatedTime;
    this.mCreator = instance.mCreator;
    this.mCreatorId = instance.mCreatorId;
    this.mCusomizedTcpaContent = instance.mCusomizedTcpaContent;
    this.mExpiredLeadsCount = instance.mExpiredLeadsCount;
    this.mFollowUpActionText = instance.mFollowUpActionText;
    this.mFollowUpActionUrl = instance.mFollowUpActionUrl;
    this.mId = instance.mId;
    this.mIsContinuedFlow = instance.mIsContinuedFlow;
    this.mLeadgenExportCsvUrl = instance.mLeadgenExportCsvUrl;
    this.mLeadsCount = instance.mLeadsCount;
    this.mLegalContent = instance.mLegalContent;
    this.mLocale = instance.mLocale;
    this.mMessengerWelcomeMessage = instance.mMessengerWelcomeMessage;
    this.mName = instance.mName;
    this.mOrganicLeadsCount = instance.mOrganicLeadsCount;
    this.mPage = instance.mPage;
    this.mPageId = instance.mPageId;
    this.mPrivacyPolicyUrl = instance.mPrivacyPolicyUrl;
    this.mQualifiers = instance.mQualifiers;
    this.mQuestions = instance.mQuestions;
    this.mStatus = instance.mStatus;
    this.mTcpaCompliance = instance.mTcpaCompliance;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LeadgenForm> getParser() {
    return new APIRequest.ResponseParser<LeadgenForm>() {
      public APINodeList<LeadgenForm> parseResponse(String response, APIContext context, APIRequest<LeadgenForm> request) throws MalformedResponseException {
        return LeadgenForm.parseResponse(response, context, request);
      }
    };
  }
}
