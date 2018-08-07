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
public class AdAccountCreationRequest extends APINode {
  @SerializedName("ad_accounts_info")
  private List<Object> mAdAccountsInfo = null;
  @SerializedName("additional_comment")
  private String mAdditionalComment = null;
  @SerializedName("address_in_chinese")
  private String mAddressInChinese = null;
  @SerializedName("address_in_english")
  private Object mAddressInEnglish = null;
  @SerializedName("advertiser_business")
  private Business mAdvertiserBusiness = null;
  @SerializedName("appeal_reason")
  private Object mAppealReason = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("business_registration_id")
  private String mBusinessRegistrationId = null;
  @SerializedName("chinese_legal_entity_name")
  private String mChineseLegalEntityName = null;
  @SerializedName("contact")
  private Object mContact = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("disapproval_reasons")
  private List<Object> mDisapprovalReasons = null;
  @SerializedName("english_legal_entity_name")
  private String mEnglishLegalEntityName = null;
  @SerializedName("extended_credit_id")
  private String mExtendedCreditId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_smb")
  private Boolean mIsSmb = null;
  @SerializedName("is_test")
  private Boolean mIsTest = null;
  @SerializedName("is_under_authorization")
  private Boolean mIsUnderAuthorization = null;
  @SerializedName("official_website_url")
  private String mOfficialWebsiteUrl = null;
  @SerializedName("planning_agency_business")
  private Business mPlanningAgencyBusiness = null;
  @SerializedName("planning_agency_business_id")
  private String mPlanningAgencyBusinessId = null;
  @SerializedName("promotable_app_ids")
  private List<String> mPromotableAppIds = null;
  @SerializedName("promotable_page_ids")
  private List<String> mPromotablePageIds = null;
  @SerializedName("promotable_urls")
  private List<String> mPromotableUrls = null;
  @SerializedName("request_change_reasons")
  private List<Object> mRequestChangeReasons = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("subvertical")
  private String mSubvertical = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("vertical")
  private String mVertical = null;
  protected static Gson gson = null;

  AdAccountCreationRequest() {
  }

  public AdAccountCreationRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountCreationRequest(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AdAccountCreationRequest fetch() throws APIException{
    AdAccountCreationRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountCreationRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountCreationRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountCreationRequest fetchById(String id, APIContext context) throws APIException {
    AdAccountCreationRequest adAccountCreationRequest =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adAccountCreationRequest;
  }

  public static ListenableFuture<AdAccountCreationRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<AdAccountCreationRequest> adAccountCreationRequest =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return adAccountCreationRequest;
  }

  public static APINodeList<AdAccountCreationRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountCreationRequest>)(
      new APIRequest<AdAccountCreationRequest>(context, "", "/", "GET", AdAccountCreationRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountCreationRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<AdAccountCreationRequest>> adAccountCreationRequest =
      new APIRequest(context, "", "/", "GET", AdAccountCreationRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return adAccountCreationRequest;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAccountCreationRequest loadJSON(String json, APIContext context) {
    AdAccountCreationRequest adAccountCreationRequest = getGson().fromJson(json, AdAccountCreationRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountCreationRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccountCreationRequest.context = context;
    adAccountCreationRequest.rawValue = json;
    return adAccountCreationRequest;
  }

  public static APINodeList<AdAccountCreationRequest> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAccountCreationRequest> adAccountCreationRequests = new APINodeList<AdAccountCreationRequest>(request, json);
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
          adAccountCreationRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAccountCreationRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountCreationRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountCreationRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountCreationRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountCreationRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAccountCreationRequests.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountCreationRequests.add(loadJSON(obj.toString(), context));
            }
          }
          return adAccountCreationRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountCreationRequests.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAccountCreationRequests;
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
              adAccountCreationRequests.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountCreationRequests;
          }

          // Sixth, check if it's pure JsonObject
          adAccountCreationRequests.clear();
          adAccountCreationRequests.add(loadJSON(json, context));
          return adAccountCreationRequests;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public List<Object> getFieldAdAccountsInfo() {
    return mAdAccountsInfo;
  }

  public String getFieldAdditionalComment() {
    return mAdditionalComment;
  }

  public String getFieldAddressInChinese() {
    return mAddressInChinese;
  }

  public Object getFieldAddressInEnglish() {
    return mAddressInEnglish;
  }

  public Business getFieldAdvertiserBusiness() {
    if (mAdvertiserBusiness != null) {
      mAdvertiserBusiness.context = getContext();
    }
    return mAdvertiserBusiness;
  }

  public Object getFieldAppealReason() {
    return mAppealReason;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldBusinessRegistrationId() {
    return mBusinessRegistrationId;
  }

  public String getFieldChineseLegalEntityName() {
    return mChineseLegalEntityName;
  }

  public Object getFieldContact() {
    return mContact;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public List<Object> getFieldDisapprovalReasons() {
    return mDisapprovalReasons;
  }

  public String getFieldEnglishLegalEntityName() {
    return mEnglishLegalEntityName;
  }

  public String getFieldExtendedCreditId() {
    return mExtendedCreditId;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsSmb() {
    return mIsSmb;
  }

  public Boolean getFieldIsTest() {
    return mIsTest;
  }

  public Boolean getFieldIsUnderAuthorization() {
    return mIsUnderAuthorization;
  }

  public String getFieldOfficialWebsiteUrl() {
    return mOfficialWebsiteUrl;
  }

  public Business getFieldPlanningAgencyBusiness() {
    if (mPlanningAgencyBusiness != null) {
      mPlanningAgencyBusiness.context = getContext();
    }
    return mPlanningAgencyBusiness;
  }

  public String getFieldPlanningAgencyBusinessId() {
    return mPlanningAgencyBusinessId;
  }

  public List<String> getFieldPromotableAppIds() {
    return mPromotableAppIds;
  }

  public List<String> getFieldPromotablePageIds() {
    return mPromotablePageIds;
  }

  public List<String> getFieldPromotableUrls() {
    return mPromotableUrls;
  }

  public List<Object> getFieldRequestChangeReasons() {
    return mRequestChangeReasons;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldSubvertical() {
    return mSubvertical;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldVertical() {
    return mVertical;
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

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

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

  public static class APIRequestGet extends APIRequest<AdAccountCreationRequest> {

    AdAccountCreationRequest lastResponse = null;
    @Override
    public AdAccountCreationRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_accounts_info",
      "additional_comment",
      "address_in_chinese",
      "address_in_english",
      "advertiser_business",
      "appeal_reason",
      "business",
      "business_registration_id",
      "chinese_legal_entity_name",
      "contact",
      "creator",
      "disapproval_reasons",
      "english_legal_entity_name",
      "extended_credit_id",
      "id",
      "is_smb",
      "is_test",
      "is_under_authorization",
      "official_website_url",
      "planning_agency_business",
      "planning_agency_business_id",
      "promotable_app_ids",
      "promotable_page_ids",
      "promotable_urls",
      "request_change_reasons",
      "status",
      "subvertical",
      "time_created",
      "vertical",
    };

    @Override
    public AdAccountCreationRequest parseResponse(String response) throws APIException {
      return AdAccountCreationRequest.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountCreationRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountCreationRequest execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountCreationRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountCreationRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountCreationRequest>() {
           public AdAccountCreationRequest apply(String result) {
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

    public APIRequestGet requestAdAccountsInfoField () {
      return this.requestAdAccountsInfoField(true);
    }
    public APIRequestGet requestAdAccountsInfoField (boolean value) {
      this.requestField("ad_accounts_info", value);
      return this;
    }
    public APIRequestGet requestAdditionalCommentField () {
      return this.requestAdditionalCommentField(true);
    }
    public APIRequestGet requestAdditionalCommentField (boolean value) {
      this.requestField("additional_comment", value);
      return this;
    }
    public APIRequestGet requestAddressInChineseField () {
      return this.requestAddressInChineseField(true);
    }
    public APIRequestGet requestAddressInChineseField (boolean value) {
      this.requestField("address_in_chinese", value);
      return this;
    }
    public APIRequestGet requestAddressInEnglishField () {
      return this.requestAddressInEnglishField(true);
    }
    public APIRequestGet requestAddressInEnglishField (boolean value) {
      this.requestField("address_in_english", value);
      return this;
    }
    public APIRequestGet requestAdvertiserBusinessField () {
      return this.requestAdvertiserBusinessField(true);
    }
    public APIRequestGet requestAdvertiserBusinessField (boolean value) {
      this.requestField("advertiser_business", value);
      return this;
    }
    public APIRequestGet requestAppealReasonField () {
      return this.requestAppealReasonField(true);
    }
    public APIRequestGet requestAppealReasonField (boolean value) {
      this.requestField("appeal_reason", value);
      return this;
    }
    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestBusinessRegistrationIdField () {
      return this.requestBusinessRegistrationIdField(true);
    }
    public APIRequestGet requestBusinessRegistrationIdField (boolean value) {
      this.requestField("business_registration_id", value);
      return this;
    }
    public APIRequestGet requestChineseLegalEntityNameField () {
      return this.requestChineseLegalEntityNameField(true);
    }
    public APIRequestGet requestChineseLegalEntityNameField (boolean value) {
      this.requestField("chinese_legal_entity_name", value);
      return this;
    }
    public APIRequestGet requestContactField () {
      return this.requestContactField(true);
    }
    public APIRequestGet requestContactField (boolean value) {
      this.requestField("contact", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestDisapprovalReasonsField () {
      return this.requestDisapprovalReasonsField(true);
    }
    public APIRequestGet requestDisapprovalReasonsField (boolean value) {
      this.requestField("disapproval_reasons", value);
      return this;
    }
    public APIRequestGet requestEnglishLegalEntityNameField () {
      return this.requestEnglishLegalEntityNameField(true);
    }
    public APIRequestGet requestEnglishLegalEntityNameField (boolean value) {
      this.requestField("english_legal_entity_name", value);
      return this;
    }
    public APIRequestGet requestExtendedCreditIdField () {
      return this.requestExtendedCreditIdField(true);
    }
    public APIRequestGet requestExtendedCreditIdField (boolean value) {
      this.requestField("extended_credit_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsSmbField () {
      return this.requestIsSmbField(true);
    }
    public APIRequestGet requestIsSmbField (boolean value) {
      this.requestField("is_smb", value);
      return this;
    }
    public APIRequestGet requestIsTestField () {
      return this.requestIsTestField(true);
    }
    public APIRequestGet requestIsTestField (boolean value) {
      this.requestField("is_test", value);
      return this;
    }
    public APIRequestGet requestIsUnderAuthorizationField () {
      return this.requestIsUnderAuthorizationField(true);
    }
    public APIRequestGet requestIsUnderAuthorizationField (boolean value) {
      this.requestField("is_under_authorization", value);
      return this;
    }
    public APIRequestGet requestOfficialWebsiteUrlField () {
      return this.requestOfficialWebsiteUrlField(true);
    }
    public APIRequestGet requestOfficialWebsiteUrlField (boolean value) {
      this.requestField("official_website_url", value);
      return this;
    }
    public APIRequestGet requestPlanningAgencyBusinessField () {
      return this.requestPlanningAgencyBusinessField(true);
    }
    public APIRequestGet requestPlanningAgencyBusinessField (boolean value) {
      this.requestField("planning_agency_business", value);
      return this;
    }
    public APIRequestGet requestPlanningAgencyBusinessIdField () {
      return this.requestPlanningAgencyBusinessIdField(true);
    }
    public APIRequestGet requestPlanningAgencyBusinessIdField (boolean value) {
      this.requestField("planning_agency_business_id", value);
      return this;
    }
    public APIRequestGet requestPromotableAppIdsField () {
      return this.requestPromotableAppIdsField(true);
    }
    public APIRequestGet requestPromotableAppIdsField (boolean value) {
      this.requestField("promotable_app_ids", value);
      return this;
    }
    public APIRequestGet requestPromotablePageIdsField () {
      return this.requestPromotablePageIdsField(true);
    }
    public APIRequestGet requestPromotablePageIdsField (boolean value) {
      this.requestField("promotable_page_ids", value);
      return this;
    }
    public APIRequestGet requestPromotableUrlsField () {
      return this.requestPromotableUrlsField(true);
    }
    public APIRequestGet requestPromotableUrlsField (boolean value) {
      this.requestField("promotable_urls", value);
      return this;
    }
    public APIRequestGet requestRequestChangeReasonsField () {
      return this.requestRequestChangeReasonsField(true);
    }
    public APIRequestGet requestRequestChangeReasonsField (boolean value) {
      this.requestField("request_change_reasons", value);
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
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGet requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdAccountCreationRequest> {

    AdAccountCreationRequest lastResponse = null;
    @Override
    public AdAccountCreationRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_accounts_info",
      "additional_comment",
      "address_in_chinese",
      "address_in_english",
      "advertiser_business_id",
      "business_registration",
      "business_registration_id",
      "chinese_legal_entity_name",
      "contact",
      "disapprove_appeal_comment",
      "english_legal_entity_name",
      "extended_credit_id",
      "is_smb",
      "official_website_url",
      "planning_agency_business_id",
      "promotable_app_ids",
      "promotable_page_ids",
      "promotable_page_urls",
      "promotable_urls",
      "subvertical",
      "vertical",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdAccountCreationRequest parseResponse(String response) throws APIException {
      return AdAccountCreationRequest.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountCreationRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountCreationRequest execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountCreationRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountCreationRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountCreationRequest>() {
           public AdAccountCreationRequest apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestUpdate setAdAccountsInfo (List<Object> adAccountsInfo) {
      this.setParam("ad_accounts_info", adAccountsInfo);
      return this;
    }
    public APIRequestUpdate setAdAccountsInfo (String adAccountsInfo) {
      this.setParam("ad_accounts_info", adAccountsInfo);
      return this;
    }

    public APIRequestUpdate setAdditionalComment (String additionalComment) {
      this.setParam("additional_comment", additionalComment);
      return this;
    }

    public APIRequestUpdate setAddressInChinese (String addressInChinese) {
      this.setParam("address_in_chinese", addressInChinese);
      return this;
    }

    public APIRequestUpdate setAddressInEnglish (Object addressInEnglish) {
      this.setParam("address_in_english", addressInEnglish);
      return this;
    }
    public APIRequestUpdate setAddressInEnglish (String addressInEnglish) {
      this.setParam("address_in_english", addressInEnglish);
      return this;
    }

    public APIRequestUpdate setAdvertiserBusinessId (String advertiserBusinessId) {
      this.setParam("advertiser_business_id", advertiserBusinessId);
      return this;
    }

    public APIRequestUpdate setBusinessRegistration (File businessRegistration) {
      this.setParam("business_registration", businessRegistration);
      return this;
    }
    public APIRequestUpdate setBusinessRegistration (String businessRegistration) {
      this.setParam("business_registration", businessRegistration);
      return this;
    }

    public APIRequestUpdate setBusinessRegistrationId (String businessRegistrationId) {
      this.setParam("business_registration_id", businessRegistrationId);
      return this;
    }

    public APIRequestUpdate setChineseLegalEntityName (String chineseLegalEntityName) {
      this.setParam("chinese_legal_entity_name", chineseLegalEntityName);
      return this;
    }

    public APIRequestUpdate setContact (Object contact) {
      this.setParam("contact", contact);
      return this;
    }
    public APIRequestUpdate setContact (String contact) {
      this.setParam("contact", contact);
      return this;
    }

    public APIRequestUpdate setDisapproveAppealComment (String disapproveAppealComment) {
      this.setParam("disapprove_appeal_comment", disapproveAppealComment);
      return this;
    }

    public APIRequestUpdate setEnglishLegalEntityName (String englishLegalEntityName) {
      this.setParam("english_legal_entity_name", englishLegalEntityName);
      return this;
    }

    public APIRequestUpdate setExtendedCreditId (String extendedCreditId) {
      this.setParam("extended_credit_id", extendedCreditId);
      return this;
    }

    public APIRequestUpdate setIsSmb (Boolean isSmb) {
      this.setParam("is_smb", isSmb);
      return this;
    }
    public APIRequestUpdate setIsSmb (String isSmb) {
      this.setParam("is_smb", isSmb);
      return this;
    }

    public APIRequestUpdate setOfficialWebsiteUrl (Object officialWebsiteUrl) {
      this.setParam("official_website_url", officialWebsiteUrl);
      return this;
    }
    public APIRequestUpdate setOfficialWebsiteUrl (String officialWebsiteUrl) {
      this.setParam("official_website_url", officialWebsiteUrl);
      return this;
    }

    public APIRequestUpdate setPlanningAgencyBusinessId (String planningAgencyBusinessId) {
      this.setParam("planning_agency_business_id", planningAgencyBusinessId);
      return this;
    }

    public APIRequestUpdate setPromotableAppIds (List<String> promotableAppIds) {
      this.setParam("promotable_app_ids", promotableAppIds);
      return this;
    }
    public APIRequestUpdate setPromotableAppIds (String promotableAppIds) {
      this.setParam("promotable_app_ids", promotableAppIds);
      return this;
    }

    public APIRequestUpdate setPromotablePageIds (List<String> promotablePageIds) {
      this.setParam("promotable_page_ids", promotablePageIds);
      return this;
    }
    public APIRequestUpdate setPromotablePageIds (String promotablePageIds) {
      this.setParam("promotable_page_ids", promotablePageIds);
      return this;
    }

    public APIRequestUpdate setPromotablePageUrls (List<Object> promotablePageUrls) {
      this.setParam("promotable_page_urls", promotablePageUrls);
      return this;
    }
    public APIRequestUpdate setPromotablePageUrls (String promotablePageUrls) {
      this.setParam("promotable_page_urls", promotablePageUrls);
      return this;
    }

    public APIRequestUpdate setPromotableUrls (List<Object> promotableUrls) {
      this.setParam("promotable_urls", promotableUrls);
      return this;
    }
    public APIRequestUpdate setPromotableUrls (String promotableUrls) {
      this.setParam("promotable_urls", promotableUrls);
      return this;
    }

    public APIRequestUpdate setSubvertical (AdAccountCreationRequest.EnumSubvertical subvertical) {
      this.setParam("subvertical", subvertical);
      return this;
    }
    public APIRequestUpdate setSubvertical (String subvertical) {
      this.setParam("subvertical", subvertical);
      return this;
    }

    public APIRequestUpdate setVertical (AdAccountCreationRequest.EnumVertical vertical) {
      this.setParam("vertical", vertical);
      return this;
    }
    public APIRequestUpdate setVertical (String vertical) {
      this.setParam("vertical", vertical);
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

  public static enum EnumSubvertical {
      @SerializedName("ACCOUNTING_AND_TAXES_AND_LEGAL")
      VALUE_ACCOUNTING_AND_TAXES_AND_LEGAL("ACCOUNTING_AND_TAXES_AND_LEGAL"),
      @SerializedName("AGRICULTURE_AND_FARMING")
      VALUE_AGRICULTURE_AND_FARMING("AGRICULTURE_AND_FARMING"),
      @SerializedName("ECOMMERCE_AGRICULTURE_AND_FARMING")
      VALUE_ECOMMERCE_AGRICULTURE_AND_FARMING("ECOMMERCE_AGRICULTURE_AND_FARMING"),
      @SerializedName("AIR")
      VALUE_AIR("AIR"),
      @SerializedName("AIR_FREIGHT_OR_PACKAGE")
      VALUE_AIR_FREIGHT_OR_PACKAGE("AIR_FREIGHT_OR_PACKAGE"),
      @SerializedName("APPAREL_AND_ACCESSORIES")
      VALUE_APPAREL_AND_ACCESSORIES("APPAREL_AND_ACCESSORIES"),
      @SerializedName("ARTS")
      VALUE_ARTS("ARTS"),
      @SerializedName("AUCTIONS")
      VALUE_AUCTIONS("AUCTIONS"),
      @SerializedName("AUTO_AGENCY")
      VALUE_AUTO_AGENCY("AUTO_AGENCY"),
      @SerializedName("AUTO_RENTAL")
      VALUE_AUTO_RENTAL("AUTO_RENTAL"),
      @SerializedName("AUTOMOTIVE_MANUFACTURER")
      VALUE_AUTOMOTIVE_MANUFACTURER("AUTOMOTIVE_MANUFACTURER"),
      @SerializedName("B2B")
      VALUE_B2B("B2B"),
      @SerializedName("B2B_MANUFACTURING")
      VALUE_B2B_MANUFACTURING("B2B_MANUFACTURING"),
      @SerializedName("BEAUTY_AND_PERSONAL_CARE")
      VALUE_BEAUTY_AND_PERSONAL_CARE("BEAUTY_AND_PERSONAL_CARE"),
      @SerializedName("BEER_AND_WINE_AND_LIQUOR")
      VALUE_BEER_AND_WINE_AND_LIQUOR("BEER_AND_WINE_AND_LIQUOR"),
      @SerializedName("BOOKSTORES")
      VALUE_BOOKSTORES("BOOKSTORES"),
      @SerializedName("BUS_AND_TAXI_AND_AUTO_RETAL")
      VALUE_BUS_AND_TAXI_AND_AUTO_RETAL("BUS_AND_TAXI_AND_AUTO_RETAL"),
      @SerializedName("BUSINESS_SUPPORT_SERVICES")
      VALUE_BUSINESS_SUPPORT_SERVICES("BUSINESS_SUPPORT_SERVICES"),
      @SerializedName("CABLE_AND_SATELLITE")
      VALUE_CABLE_AND_SATELLITE("CABLE_AND_SATELLITE"),
      @SerializedName("CAREER")
      VALUE_CAREER("CAREER"),
      @SerializedName("COMPUTING_AND_PERIPHERALS")
      VALUE_COMPUTING_AND_PERIPHERALS("COMPUTING_AND_PERIPHERALS"),
      @SerializedName("CONSOLE_DEVELOPER")
      VALUE_CONSOLE_DEVELOPER("CONSOLE_DEVELOPER"),
      @SerializedName("CONSOLE_DEVICE")
      VALUE_CONSOLE_DEVICE("CONSOLE_DEVICE"),
      @SerializedName("CONSTRUCTION_AND_MINING")
      VALUE_CONSTRUCTION_AND_MINING("CONSTRUCTION_AND_MINING"),
      @SerializedName("CONSULTING")
      VALUE_CONSULTING("CONSULTING"),
      @SerializedName("CONSUMER_ELECTRONICS")
      VALUE_CONSUMER_ELECTRONICS("CONSUMER_ELECTRONICS"),
      @SerializedName("CONSUMER_TECH")
      VALUE_CONSUMER_TECH("CONSUMER_TECH"),
      @SerializedName("CREDIT_AND_FINANCING_AND_MORTAGES")
      VALUE_CREDIT_AND_FINANCING_AND_MORTAGES("CREDIT_AND_FINANCING_AND_MORTAGES"),
      @SerializedName("CRUISES_AND_MARINE")
      VALUE_CRUISES_AND_MARINE("CRUISES_AND_MARINE"),
      @SerializedName("CVB_CONVENTION_AND_VISITORS_BUREAU")
      VALUE_CVB_CONVENTION_AND_VISITORS_BUREAU("CVB_CONVENTION_AND_VISITORS_BUREAU"),
      @SerializedName("DAILYDEALS")
      VALUE_DAILYDEALS("DAILYDEALS"),
      @SerializedName("DATING")
      VALUE_DATING("DATING"),
      @SerializedName("DEALERSHIP")
      VALUE_DEALERSHIP("DEALERSHIP"),
      @SerializedName("DEPARTMENT_STORE")
      VALUE_DEPARTMENT_STORE("DEPARTMENT_STORE"),
      @SerializedName("DESKTOP_SOFTWARE")
      VALUE_DESKTOP_SOFTWARE("DESKTOP_SOFTWARE"),
      @SerializedName("DIGITAL_ADVERTISING_AND_MARKETING_OR_UNTAGGED_AGENCIES")
      VALUE_DIGITAL_ADVERTISING_AND_MARKETING_OR_UNTAGGED_AGENCIES("DIGITAL_ADVERTISING_AND_MARKETING_OR_UNTAGGED_AGENCIES"),
      @SerializedName("ECATALOG")
      VALUE_ECATALOG("ECATALOG"),
      @SerializedName("ED_TECH")
      VALUE_ED_TECH("ED_TECH"),
      @SerializedName("EDUCATION_RESOURCES")
      VALUE_EDUCATION_RESOURCES("EDUCATION_RESOURCES"),
      @SerializedName("ELEARNING_AND_MASSIVE_ONLINE_OPEN_COURSES")
      VALUE_ELEARNING_AND_MASSIVE_ONLINE_OPEN_COURSES("ELEARNING_AND_MASSIVE_ONLINE_OPEN_COURSES"),
      @SerializedName("ENGINEERING_AND_DESIGN")
      VALUE_ENGINEERING_AND_DESIGN("ENGINEERING_AND_DESIGN"),
      @SerializedName("EVENTS")
      VALUE_EVENTS("EVENTS"),
      @SerializedName("FAMILY_AND_HEALTH")
      VALUE_FAMILY_AND_HEALTH("FAMILY_AND_HEALTH"),
      @SerializedName("FITNESS")
      VALUE_FITNESS("FITNESS"),
      @SerializedName("FOOD")
      VALUE_FOOD("FOOD"),
      @SerializedName("FOOTWEAR")
      VALUE_FOOTWEAR("FOOTWEAR"),
      @SerializedName("FOR_PROFIT_COLLEGES_AND_UNIVERSITIES")
      VALUE_FOR_PROFIT_COLLEGES_AND_UNIVERSITIES("FOR_PROFIT_COLLEGES_AND_UNIVERSITIES"),
      @SerializedName("GAMBLING")
      VALUE_GAMBLING("GAMBLING"),
      @SerializedName("GOVERNMENT")
      VALUE_GOVERNMENT("GOVERNMENT"),
      @SerializedName("GROCERY_AND_DRUG_AND_CONVENIENCE")
      VALUE_GROCERY_AND_DRUG_AND_CONVENIENCE("GROCERY_AND_DRUG_AND_CONVENIENCE"),
      @SerializedName("HIGHWAYS")
      VALUE_HIGHWAYS("HIGHWAYS"),
      @SerializedName("HOME_AND_OFFICE")
      VALUE_HOME_AND_OFFICE("HOME_AND_OFFICE"),
      @SerializedName("HOME_IMPROVEMENT")
      VALUE_HOME_IMPROVEMENT("HOME_IMPROVEMENT"),
      @SerializedName("HOME_SERVICE")
      VALUE_HOME_SERVICE("HOME_SERVICE"),
      @SerializedName("HOTEL_AND_ACCOMODATION")
      VALUE_HOTEL_AND_ACCOMODATION("HOTEL_AND_ACCOMODATION"),
      @SerializedName("HOUSEHOLD_GOODS")
      VALUE_HOUSEHOLD_GOODS("HOUSEHOLD_GOODS"),
      @SerializedName("INDUSTRIAL_AND_FARM_VEHICLE")
      VALUE_INDUSTRIAL_AND_FARM_VEHICLE("INDUSTRIAL_AND_FARM_VEHICLE"),
      @SerializedName("INSURANCE")
      VALUE_INSURANCE("INSURANCE"),
      @SerializedName("INVESTMENT_BANK_AND_BROKERAGE")
      VALUE_INVESTMENT_BANK_AND_BROKERAGE("INVESTMENT_BANK_AND_BROKERAGE"),
      @SerializedName("MEDIA")
      VALUE_MEDIA("MEDIA"),
      @SerializedName("MOBILE_AND_SOCIAL")
      VALUE_MOBILE_AND_SOCIAL("MOBILE_AND_SOCIAL"),
      @SerializedName("MOBILE_APPS")
      VALUE_MOBILE_APPS("MOBILE_APPS"),
      @SerializedName("MOTORCYCLES")
      VALUE_MOTORCYCLES("MOTORCYCLES"),
      @SerializedName("MOVIES")
      VALUE_MOVIES("MOVIES"),
      @SerializedName("MUSEUMS_AND_PARKS_AND_LIBRARIES")
      VALUE_MUSEUMS_AND_PARKS_AND_LIBRARIES("MUSEUMS_AND_PARKS_AND_LIBRARIES"),
      @SerializedName("MUSIC_AND_RADIO")
      VALUE_MUSIC_AND_RADIO("MUSIC_AND_RADIO"),
      @SerializedName("NON_PROFIT")
      VALUE_NON_PROFIT("NON_PROFIT"),
      @SerializedName("NOT_FOR_PROFIT_COLLEGES_AND_UNIVERSITIES")
      VALUE_NOT_FOR_PROFIT_COLLEGES_AND_UNIVERSITIES("NOT_FOR_PROFIT_COLLEGES_AND_UNIVERSITIES"),
      @SerializedName("OFFICE")
      VALUE_OFFICE("OFFICE"),
      @SerializedName("OIL_AND_GAS_AND_CONSUMABLE_FUEL")
      VALUE_OIL_AND_GAS_AND_CONSUMABLE_FUEL("OIL_AND_GAS_AND_CONSUMABLE_FUEL"),
      @SerializedName("ONLINE_OR_SOFTWARE")
      VALUE_ONLINE_OR_SOFTWARE("ONLINE_OR_SOFTWARE"),
      @SerializedName("PARTS_AND_SERVICE")
      VALUE_PARTS_AND_SERVICE("PARTS_AND_SERVICE"),
      @SerializedName("PET")
      VALUE_PET("PET"),
      @SerializedName("PET_RETAIL")
      VALUE_PET_RETAIL("PET_RETAIL"),
      @SerializedName("PHARMACEUTICAL_OR_HEALTH")
      VALUE_PHARMACEUTICAL_OR_HEALTH("PHARMACEUTICAL_OR_HEALTH"),
      @SerializedName("PHOTOGRAPHY_AND_FILMING_SERVICES")
      VALUE_PHOTOGRAPHY_AND_FILMING_SERVICES("PHOTOGRAPHY_AND_FILMING_SERVICES"),
      @SerializedName("POLITICAL")
      VALUE_POLITICAL("POLITICAL"),
      @SerializedName("PR")
      VALUE_PR("PR"),
      @SerializedName("PUBLISHING_INTERNET")
      VALUE_PUBLISHING_INTERNET("PUBLISHING_INTERNET"),
      @SerializedName("RAILROADS")
      VALUE_RAILROADS("RAILROADS"),
      @SerializedName("RECREATIONAL")
      VALUE_RECREATIONAL("RECREATIONAL"),
      @SerializedName("REAL_ESTATE")
      VALUE_REAL_ESTATE("REAL_ESTATE"),
      @SerializedName("REAL_MONEY_OR_SKILLED_GAMING")
      VALUE_REAL_MONEY_OR_SKILLED_GAMING("REAL_MONEY_OR_SKILLED_GAMING"),
      @SerializedName("RELIGIOUS")
      VALUE_RELIGIOUS("RELIGIOUS"),
      @SerializedName("RESTAURANT")
      VALUE_RESTAURANT("RESTAURANT"),
      @SerializedName("RETAIL_AND_CREDIT_UNION_AND_COMMERCIAL_BANK")
      VALUE_RETAIL_AND_CREDIT_UNION_AND_COMMERCIAL_BANK("RETAIL_AND_CREDIT_UNION_AND_COMMERCIAL_BANK"),
      @SerializedName("SCHOOL_AND_EARLY_CHILDREN_EDCATION")
      VALUE_SCHOOL_AND_EARLY_CHILDREN_EDCATION("SCHOOL_AND_EARLY_CHILDREN_EDCATION"),
      @SerializedName("SEASONAL_POLITICAL_SPENDERS")
      VALUE_SEASONAL_POLITICAL_SPENDERS("SEASONAL_POLITICAL_SPENDERS"),
      @SerializedName("SMB_AGENTS_AND_PROMOTERS")
      VALUE_SMB_AGENTS_AND_PROMOTERS("SMB_AGENTS_AND_PROMOTERS"),
      @SerializedName("SMB_ARTISTS_AND_PERFORMERS")
      VALUE_SMB_ARTISTS_AND_PERFORMERS("SMB_ARTISTS_AND_PERFORMERS"),
      @SerializedName("SMB_CANVAS")
      VALUE_SMB_CANVAS("SMB_CANVAS"),
      @SerializedName("SMB_CATALOG")
      VALUE_SMB_CATALOG("SMB_CATALOG"),
      @SerializedName("SMB_CONSUMER_MOBILE_DEVICE")
      VALUE_SMB_CONSUMER_MOBILE_DEVICE("SMB_CONSUMER_MOBILE_DEVICE"),
      @SerializedName("SMB_CROSS_PLATFORM")
      VALUE_SMB_CROSS_PLATFORM("SMB_CROSS_PLATFORM"),
      @SerializedName("SMB_ELECTRONICS_AND_APPLIANCES")
      VALUE_SMB_ELECTRONICS_AND_APPLIANCES("SMB_ELECTRONICS_AND_APPLIANCES"),
      @SerializedName("SMB_ENERGY")
      VALUE_SMB_ENERGY("SMB_ENERGY"),
      @SerializedName("SMB_GAME_AND_TOY")
      VALUE_SMB_GAME_AND_TOY("SMB_GAME_AND_TOY"),
      @SerializedName("SMB_INFORMATION")
      VALUE_SMB_INFORMATION("SMB_INFORMATION"),
      @SerializedName("SMB_NAVIGATION_AND_MEASUREMENT")
      VALUE_SMB_NAVIGATION_AND_MEASUREMENT("SMB_NAVIGATION_AND_MEASUREMENT"),
      @SerializedName("SMB_OPERATIONS_AND_OTHER")
      VALUE_SMB_OPERATIONS_AND_OTHER("SMB_OPERATIONS_AND_OTHER"),
      @SerializedName("SMB_OTHER")
      VALUE_SMB_OTHER("SMB_OTHER"),
      @SerializedName("SMB_PERSONAL_CARE")
      VALUE_SMB_PERSONAL_CARE("SMB_PERSONAL_CARE"),
      @SerializedName("SMB_RELIGIOUS")
      VALUE_SMB_RELIGIOUS("SMB_RELIGIOUS"),
      @SerializedName("SMB_RENTALS")
      VALUE_SMB_RENTALS("SMB_RENTALS"),
      @SerializedName("SMB_REPAIR_AND_MAINTENANCE")
      VALUE_SMB_REPAIR_AND_MAINTENANCE("SMB_REPAIR_AND_MAINTENANCE"),
      @SerializedName("OTHER_WIRELINE_SERVICES")
      VALUE_OTHER_WIRELINE_SERVICES("OTHER_WIRELINE_SERVICES"),
      @SerializedName("SOFTWARE")
      VALUE_SOFTWARE("SOFTWARE"),
      @SerializedName("SPORTING")
      VALUE_SPORTING("SPORTING"),
      @SerializedName("SPORTS")
      VALUE_SPORTS("SPORTS"),
      @SerializedName("STREAMING")
      VALUE_STREAMING("STREAMING"),
      @SerializedName("TELEVISION")
      VALUE_TELEVISION("TELEVISION"),
      @SerializedName("TOBACCO")
      VALUE_TOBACCO("TOBACCO"),
      @SerializedName("TOY_AND_HOBBY")
      VALUE_TOY_AND_HOBBY("TOY_AND_HOBBY"),
      @SerializedName("TRADE_SCHOOL")
      VALUE_TRADE_SCHOOL("TRADE_SCHOOL"),
      @SerializedName("TRANSPORTATION_EQUIPMENT")
      VALUE_TRANSPORTATION_EQUIPMENT("TRANSPORTATION_EQUIPMENT"),
      @SerializedName("TRAVAL_AGENCY")
      VALUE_TRAVAL_AGENCY("TRAVAL_AGENCY"),
      @SerializedName("TRUCK_AND_MOVING")
      VALUE_TRUCK_AND_MOVING("TRUCK_AND_MOVING"),
      @SerializedName("UTILITIES_AND_ENERGY_EQUIPMENT_AND_SERVICES")
      VALUE_UTILITIES_AND_ENERGY_EQUIPMENT_AND_SERVICES("UTILITIES_AND_ENERGY_EQUIPMENT_AND_SERVICES"),
      @SerializedName("WATER_AND_SOFT_DRINK_AND_BAVERAGE")
      VALUE_WATER_AND_SOFT_DRINK_AND_BAVERAGE("WATER_AND_SOFT_DRINK_AND_BAVERAGE"),
      @SerializedName("WIRELESS_SERVICES")
      VALUE_WIRELESS_SERVICES("WIRELESS_SERVICES"),
      NULL(null);

      private String value;

      private EnumSubvertical(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVertical {
      @SerializedName("ADVERTISING_AND_MARKETING")
      VALUE_ADVERTISING_AND_MARKETING("ADVERTISING_AND_MARKETING"),
      @SerializedName("AUTO_AGENCY")
      VALUE_AUTO_AGENCY("AUTO_AGENCY"),
      @SerializedName("AUTOMOTIVE")
      VALUE_AUTOMOTIVE("AUTOMOTIVE"),
      @SerializedName("CONSUMER_PACKAGED_GOODS")
      VALUE_CONSUMER_PACKAGED_GOODS("CONSUMER_PACKAGED_GOODS"),
      @SerializedName("CPG_AND_BEVERAGE")
      VALUE_CPG_AND_BEVERAGE("CPG_AND_BEVERAGE"),
      @SerializedName("ECOMMERCE")
      VALUE_ECOMMERCE("ECOMMERCE"),
      @SerializedName("EDUCATION")
      VALUE_EDUCATION("EDUCATION"),
      @SerializedName("ENERGY_AND_UTILITIES")
      VALUE_ENERGY_AND_UTILITIES("ENERGY_AND_UTILITIES"),
      @SerializedName("ENTERTAINMENT_AND_MEDIA")
      VALUE_ENTERTAINMENT_AND_MEDIA("ENTERTAINMENT_AND_MEDIA"),
      @SerializedName("FINANCIAL_SERVICES")
      VALUE_FINANCIAL_SERVICES("FINANCIAL_SERVICES"),
      @SerializedName("GAMING")
      VALUE_GAMING("GAMING"),
      @SerializedName("GOVERMENT_AND_POLITICS")
      VALUE_GOVERMENT_AND_POLITICS("GOVERMENT_AND_POLITICS"),
      @SerializedName("MOTORCYCLES")
      VALUE_MOTORCYCLES("MOTORCYCLES"),
      @SerializedName("ORGANIZATIONS_AND_ASSOCIATIONS")
      VALUE_ORGANIZATIONS_AND_ASSOCIATIONS("ORGANIZATIONS_AND_ASSOCIATIONS"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("PROFESSIONAL_SERVICES")
      VALUE_PROFESSIONAL_SERVICES("PROFESSIONAL_SERVICES"),
      @SerializedName("RETAIL")
      VALUE_RETAIL("RETAIL"),
      @SerializedName("TECHNOLOGY")
      VALUE_TECHNOLOGY("TECHNOLOGY"),
      @SerializedName("TELECOM")
      VALUE_TELECOM("TELECOM"),
      @SerializedName("TRAVEL")
      VALUE_TRAVEL("TRAVEL"),
      NULL(null);

      private String value;

      private EnumVertical(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("UNDER_REVIEW")
      VALUE_UNDER_REVIEW("UNDER_REVIEW"),
      @SerializedName("APPROVED")
      VALUE_APPROVED("APPROVED"),
      @SerializedName("DISAPPROVED")
      VALUE_DISAPPROVED("DISAPPROVED"),
      @SerializedName("REQUESTED_CHANGE")
      VALUE_REQUESTED_CHANGE("REQUESTED_CHANGE"),
      @SerializedName("CANCELLED")
      VALUE_CANCELLED("CANCELLED"),
      @SerializedName("AUTO_APPROVED")
      VALUE_AUTO_APPROVED("AUTO_APPROVED"),
      @SerializedName("AUTO_DISAPPROVED")
      VALUE_AUTO_DISAPPROVED("AUTO_DISAPPROVED"),
      @SerializedName("APPEAL_PENDING")
      VALUE_APPEAL_PENDING("APPEAL_PENDING"),
      @SerializedName("APPEAL_UNDER_REVIEW")
      VALUE_APPEAL_UNDER_REVIEW("APPEAL_UNDER_REVIEW"),
      @SerializedName("APPEAL_APPROVED")
      VALUE_APPEAL_APPROVED("APPEAL_APPROVED"),
      @SerializedName("APPEAL_DISAPPROVED")
      VALUE_APPEAL_DISAPPROVED("APPEAL_DISAPPROVED"),
      NULL(null);

      private String value;

      private EnumStatus(String value) {
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

  public AdAccountCreationRequest copyFrom(AdAccountCreationRequest instance) {
    this.mAdAccountsInfo = instance.mAdAccountsInfo;
    this.mAdditionalComment = instance.mAdditionalComment;
    this.mAddressInChinese = instance.mAddressInChinese;
    this.mAddressInEnglish = instance.mAddressInEnglish;
    this.mAdvertiserBusiness = instance.mAdvertiserBusiness;
    this.mAppealReason = instance.mAppealReason;
    this.mBusiness = instance.mBusiness;
    this.mBusinessRegistrationId = instance.mBusinessRegistrationId;
    this.mChineseLegalEntityName = instance.mChineseLegalEntityName;
    this.mContact = instance.mContact;
    this.mCreator = instance.mCreator;
    this.mDisapprovalReasons = instance.mDisapprovalReasons;
    this.mEnglishLegalEntityName = instance.mEnglishLegalEntityName;
    this.mExtendedCreditId = instance.mExtendedCreditId;
    this.mId = instance.mId;
    this.mIsSmb = instance.mIsSmb;
    this.mIsTest = instance.mIsTest;
    this.mIsUnderAuthorization = instance.mIsUnderAuthorization;
    this.mOfficialWebsiteUrl = instance.mOfficialWebsiteUrl;
    this.mPlanningAgencyBusiness = instance.mPlanningAgencyBusiness;
    this.mPlanningAgencyBusinessId = instance.mPlanningAgencyBusinessId;
    this.mPromotableAppIds = instance.mPromotableAppIds;
    this.mPromotablePageIds = instance.mPromotablePageIds;
    this.mPromotableUrls = instance.mPromotableUrls;
    this.mRequestChangeReasons = instance.mRequestChangeReasons;
    this.mStatus = instance.mStatus;
    this.mSubvertical = instance.mSubvertical;
    this.mTimeCreated = instance.mTimeCreated;
    this.mVertical = instance.mVertical;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountCreationRequest> getParser() {
    return new APIRequest.ResponseParser<AdAccountCreationRequest>() {
      public APINodeList<AdAccountCreationRequest> parseResponse(String response, APIContext context, APIRequest<AdAccountCreationRequest> request) throws MalformedResponseException {
        return AdAccountCreationRequest.parseResponse(response, context, request);
      }
    };
  }
}
