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
public class WhatsAppBusinessAccount extends APINode {
  @SerializedName("account_review_status")
  private String mAccountReviewStatus = null;
  @SerializedName("analytics")
  private Object mAnalytics = null;
  @SerializedName("auth_international_rate_eligibility")
  private Object mAuthInternationalRateEligibility = null;
  @SerializedName("business_verification_status")
  private String mBusinessVerificationStatus = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("creation_time")
  private Long mCreationTime = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("health_status")
  private WhatsAppBusinessHealthStatusForMessageSend mHealthStatus = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_enabled_for_insights")
  private Boolean mIsEnabledForInsights = null;
  @SerializedName("linked_commerce_account")
  private CommerceMerchantSettings mLinkedCommerceAccount = null;
  @SerializedName("message_template_namespace")
  private String mMessageTemplateNamespace = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("on_behalf_of_business_info")
  private Object mOnBehalfOfBusinessInfo = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("owner_business_info")
  private Object mOwnerBusinessInfo = null;
  @SerializedName("ownership_type")
  private String mOwnershipType = null;
  @SerializedName("primary_business_location")
  private String mPrimaryBusinessLocation = null;
  @SerializedName("primary_funding_id")
  private String mPrimaryFundingId = null;
  @SerializedName("purchase_order_number")
  private String mPurchaseOrderNumber = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("timezone_id")
  private String mTimezoneId = null;
  protected static Gson gson = null;

  WhatsAppBusinessAccount() {
  }

  public WhatsAppBusinessAccount(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public WhatsAppBusinessAccount(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public WhatsAppBusinessAccount fetch() throws APIException{
    WhatsAppBusinessAccount newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static WhatsAppBusinessAccount fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<WhatsAppBusinessAccount> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static WhatsAppBusinessAccount fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<WhatsAppBusinessAccount> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<WhatsAppBusinessAccount> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<WhatsAppBusinessAccount>)(
      new APIRequest<WhatsAppBusinessAccount>(context, "", "/", "GET", WhatsAppBusinessAccount.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<WhatsAppBusinessAccount>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", WhatsAppBusinessAccount.getParser())
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
  public static WhatsAppBusinessAccount loadJSON(String json, APIContext context, String header) {
    WhatsAppBusinessAccount whatsAppBusinessAccount = getGson().fromJson(json, WhatsAppBusinessAccount.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(whatsAppBusinessAccount.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    whatsAppBusinessAccount.context = context;
    whatsAppBusinessAccount.rawValue = json;
    whatsAppBusinessAccount.header = header;
    return whatsAppBusinessAccount;
  }

  public static APINodeList<WhatsAppBusinessAccount> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<WhatsAppBusinessAccount> whatsAppBusinessAccounts = new APINodeList<WhatsAppBusinessAccount>(request, json, header);
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
          whatsAppBusinessAccounts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return whatsAppBusinessAccounts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                whatsAppBusinessAccounts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            whatsAppBusinessAccounts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              whatsAppBusinessAccounts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              whatsAppBusinessAccounts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  whatsAppBusinessAccounts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              whatsAppBusinessAccounts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return whatsAppBusinessAccounts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              whatsAppBusinessAccounts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return whatsAppBusinessAccounts;
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
              whatsAppBusinessAccounts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return whatsAppBusinessAccounts;
          }

          // Sixth, check if it's pure JsonObject
          whatsAppBusinessAccounts.clear();
          whatsAppBusinessAccounts.add(loadJSON(json, context, header));
          return whatsAppBusinessAccounts;
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

  public APIRequestDeleteAssignedUsers deleteAssignedUsers() {
    return new APIRequestDeleteAssignedUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAssignedUsers getAssignedUsers() {
    return new APIRequestGetAssignedUsers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAssignedUser createAssignedUser() {
    return new APIRequestCreateAssignedUser(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAudiences getAudiences() {
    return new APIRequestGetAudiences(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetConversationAnalytics getConversationAnalytics() {
    return new APIRequestGetConversationAnalytics(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDccConfig getDccConfig() {
    return new APIRequestGetDccConfig(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetFlows getFlows() {
    return new APIRequestGetFlows(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateFlow createFlow() {
    return new APIRequestCreateFlow(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMessageCampaigns getMessageCampaigns() {
    return new APIRequestGetMessageCampaigns(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMessageTemplatePreviews getMessageTemplatePreviews() {
    return new APIRequestGetMessageTemplatePreviews(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteMessageTemplates deleteMessageTemplates() {
    return new APIRequestDeleteMessageTemplates(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMessageTemplates getMessageTemplates() {
    return new APIRequestGetMessageTemplates(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMessageTemplate createMessageTemplate() {
    return new APIRequestCreateMessageTemplate(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMigrateMessageTemplate createMigrateMessageTemplate() {
    return new APIRequestCreateMigrateMessageTemplate(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPhoneNumbers getPhoneNumbers() {
    return new APIRequestGetPhoneNumbers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreatePhoneNumber createPhoneNumber() {
    return new APIRequestCreatePhoneNumber(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteProductCatalogs deleteProductCatalogs() {
    return new APIRequestDeleteProductCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetProductCatalogs getProductCatalogs() {
    return new APIRequestGetProductCatalogs(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateProductCatalog createProductCatalog() {
    return new APIRequestCreateProductCatalog(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSchedules getSchedules() {
    return new APIRequestGetSchedules(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSetOboMobilityIntent createSetOboMobilityIntent() {
    return new APIRequestCreateSetOboMobilityIntent(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSolutions getSolutions() {
    return new APIRequestGetSolutions(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteSubscribedApps deleteSubscribedApps() {
    return new APIRequestDeleteSubscribedApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetSubscribedApps getSubscribedApps() {
    return new APIRequestGetSubscribedApps(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSubscribedApp createSubscribedApp() {
    return new APIRequestCreateSubscribedApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTemplateAnalytics getTemplateAnalytics() {
    return new APIRequestGetTemplateAnalytics(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTemplatePerformanceMetrics getTemplatePerformanceMetrics() {
    return new APIRequestGetTemplatePerformanceMetrics(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUpsertMessageTemplate createUpsertMessageTemplate() {
    return new APIRequestCreateUpsertMessageTemplate(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountReviewStatus() {
    return mAccountReviewStatus;
  }

  public Object getFieldAnalytics() {
    return mAnalytics;
  }

  public Object getFieldAuthInternationalRateEligibility() {
    return mAuthInternationalRateEligibility;
  }

  public String getFieldBusinessVerificationStatus() {
    return mBusinessVerificationStatus;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public Long getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public WhatsAppBusinessHealthStatusForMessageSend getFieldHealthStatus() {
    return mHealthStatus;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsEnabledForInsights() {
    return mIsEnabledForInsights;
  }

  public CommerceMerchantSettings getFieldLinkedCommerceAccount() {
    if (mLinkedCommerceAccount != null) {
      mLinkedCommerceAccount.context = getContext();
    }
    return mLinkedCommerceAccount;
  }

  public String getFieldMessageTemplateNamespace() {
    return mMessageTemplateNamespace;
  }

  public String getFieldName() {
    return mName;
  }

  public Object getFieldOnBehalfOfBusinessInfo() {
    return mOnBehalfOfBusinessInfo;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public Object getFieldOwnerBusinessInfo() {
    return mOwnerBusinessInfo;
  }

  public String getFieldOwnershipType() {
    return mOwnershipType;
  }

  public String getFieldPrimaryBusinessLocation() {
    return mPrimaryBusinessLocation;
  }

  public String getFieldPrimaryFundingId() {
    return mPrimaryFundingId;
  }

  public String getFieldPurchaseOrderNumber() {
    return mPurchaseOrderNumber;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldTimezoneId() {
    return mTimezoneId;
  }



  public static class APIRequestDeleteAssignedUsers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
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
               return APIRequestDeleteAssignedUsers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteAssignedUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_users", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAssignedUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAssignedUsers setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestDeleteAssignedUsers setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestDeleteAssignedUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAssignedUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAssignedUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAssignedUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAssignedUsers extends APIRequest<AssignedUser> {

    APINodeList<AssignedUser> lastResponse = null;
    @Override
    public APINodeList<AssignedUser> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
    };

    public static final String[] FIELDS = {
      "business",
      "id",
      "name",
      "user_type",
    };

    @Override
    public APINodeList<AssignedUser> parseResponse(String response, String header) throws APIException {
      return AssignedUser.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AssignedUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AssignedUser> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AssignedUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AssignedUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AssignedUser>>() {
           public APINodeList<AssignedUser> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAssignedUsers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAssignedUsers(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_users", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAssignedUsers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssignedUsers setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestGetAssignedUsers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAssignedUsers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAssignedUsers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAssignedUsers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAssignedUsers requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetAssignedUsers requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetAssignedUsers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAssignedUsers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAssignedUsers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAssignedUsers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAssignedUsers requestUserTypeField () {
      return this.requestUserTypeField(true);
    }
    public APIRequestGetAssignedUsers requestUserTypeField (boolean value) {
      this.requestField("user_type", value);
      return this;
    }
  }

  public static class APIRequestCreateAssignedUser extends APIRequest<WhatsAppBusinessAccount> {

    WhatsAppBusinessAccount lastResponse = null;
    @Override
    public WhatsAppBusinessAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tasks",
      "user",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public WhatsAppBusinessAccount parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessAccount.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WhatsAppBusinessAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WhatsAppBusinessAccount execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WhatsAppBusinessAccount>() {
           public WhatsAppBusinessAccount apply(ResponseWrapper result) {
             try {
               return APIRequestCreateAssignedUser.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAssignedUser(String nodeId, APIContext context) {
      super(context, nodeId, "/assigned_users", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAssignedUser setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAssignedUser setTasks (List<WhatsAppBusinessAccount.EnumTasks> tasks) {
      this.setParam("tasks", tasks);
      return this;
    }
    public APIRequestCreateAssignedUser setTasks (String tasks) {
      this.setParam("tasks", tasks);
      return this;
    }

    public APIRequestCreateAssignedUser setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestCreateAssignedUser setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateAssignedUser requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAssignedUser requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAssignedUser requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAssignedUser requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetAudiences extends APIRequest<APINode> {

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
               return APIRequestGetAudiences.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAudiences(String nodeId, APIContext context) {
      super(context, nodeId, "/audiences", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAudiences setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAudiences setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAudiences requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAudiences requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAudiences requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAudiences requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAudiences requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAudiences requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetConversationAnalytics extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "conversation_categories",
      "conversation_directions",
      "conversation_types",
      "country_codes",
      "dimensions",
      "end",
      "granularity",
      "metric_types",
      "phone_numbers",
      "start",
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
               return APIRequestGetConversationAnalytics.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetConversationAnalytics(String nodeId, APIContext context) {
      super(context, nodeId, "/conversation_analytics", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetConversationAnalytics setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetConversationAnalytics setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetConversationAnalytics setConversationCategories (List<EnumConversationCategories> conversationCategories) {
      this.setParam("conversation_categories", conversationCategories);
      return this;
    }
    public APIRequestGetConversationAnalytics setConversationCategories (String conversationCategories) {
      this.setParam("conversation_categories", conversationCategories);
      return this;
    }

    public APIRequestGetConversationAnalytics setConversationDirections (List<EnumConversationDirections> conversationDirections) {
      this.setParam("conversation_directions", conversationDirections);
      return this;
    }
    public APIRequestGetConversationAnalytics setConversationDirections (String conversationDirections) {
      this.setParam("conversation_directions", conversationDirections);
      return this;
    }

    public APIRequestGetConversationAnalytics setConversationTypes (List<EnumConversationTypes> conversationTypes) {
      this.setParam("conversation_types", conversationTypes);
      return this;
    }
    public APIRequestGetConversationAnalytics setConversationTypes (String conversationTypes) {
      this.setParam("conversation_types", conversationTypes);
      return this;
    }

    public APIRequestGetConversationAnalytics setCountryCodes (List<String> countryCodes) {
      this.setParam("country_codes", countryCodes);
      return this;
    }
    public APIRequestGetConversationAnalytics setCountryCodes (String countryCodes) {
      this.setParam("country_codes", countryCodes);
      return this;
    }

    public APIRequestGetConversationAnalytics setDimensions (List<EnumDimensions> dimensions) {
      this.setParam("dimensions", dimensions);
      return this;
    }
    public APIRequestGetConversationAnalytics setDimensions (String dimensions) {
      this.setParam("dimensions", dimensions);
      return this;
    }

    public APIRequestGetConversationAnalytics setEnd (Long end) {
      this.setParam("end", end);
      return this;
    }
    public APIRequestGetConversationAnalytics setEnd (String end) {
      this.setParam("end", end);
      return this;
    }

    public APIRequestGetConversationAnalytics setGranularity (EnumGranularity granularity) {
      this.setParam("granularity", granularity);
      return this;
    }
    public APIRequestGetConversationAnalytics setGranularity (String granularity) {
      this.setParam("granularity", granularity);
      return this;
    }

    public APIRequestGetConversationAnalytics setMetricTypes (List<EnumMetricTypes> metricTypes) {
      this.setParam("metric_types", metricTypes);
      return this;
    }
    public APIRequestGetConversationAnalytics setMetricTypes (String metricTypes) {
      this.setParam("metric_types", metricTypes);
      return this;
    }

    public APIRequestGetConversationAnalytics setPhoneNumbers (List<String> phoneNumbers) {
      this.setParam("phone_numbers", phoneNumbers);
      return this;
    }
    public APIRequestGetConversationAnalytics setPhoneNumbers (String phoneNumbers) {
      this.setParam("phone_numbers", phoneNumbers);
      return this;
    }

    public APIRequestGetConversationAnalytics setStart (Long start) {
      this.setParam("start", start);
      return this;
    }
    public APIRequestGetConversationAnalytics setStart (String start) {
      this.setParam("start", start);
      return this;
    }

    public APIRequestGetConversationAnalytics requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetConversationAnalytics requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversationAnalytics requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetConversationAnalytics requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetConversationAnalytics requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetConversationAnalytics requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetDccConfig extends APIRequest<APINode> {

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
               return APIRequestGetDccConfig.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetDccConfig(String nodeId, APIContext context) {
      super(context, nodeId, "/dcc_config", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDccConfig setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDccConfig setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDccConfig requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDccConfig requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDccConfig requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDccConfig requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDccConfig requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDccConfig requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetFlows extends APIRequest<APINode> {

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
               return APIRequestGetFlows.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetFlows(String nodeId, APIContext context) {
      super(context, nodeId, "/flows", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetFlows setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetFlows setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetFlows requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetFlows requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFlows requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetFlows requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetFlows requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetFlows requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateFlow extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "categories",
      "clone_flow_id",
      "endpoint_uri",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateFlow.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateFlow(String nodeId, APIContext context) {
      super(context, nodeId, "/flows", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateFlow setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateFlow setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateFlow setCategories (List<EnumCategories> categories) {
      this.setParam("categories", categories);
      return this;
    }
    public APIRequestCreateFlow setCategories (String categories) {
      this.setParam("categories", categories);
      return this;
    }

    public APIRequestCreateFlow setCloneFlowId (String cloneFlowId) {
      this.setParam("clone_flow_id", cloneFlowId);
      return this;
    }

    public APIRequestCreateFlow setEndpointUri (String endpointUri) {
      this.setParam("endpoint_uri", endpointUri);
      return this;
    }

    public APIRequestCreateFlow setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateFlow requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateFlow requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFlow requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateFlow requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateFlow requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateFlow requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMessageCampaigns extends APIRequest<APINode> {

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
               return APIRequestGetMessageCampaigns.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetMessageCampaigns(String nodeId, APIContext context) {
      super(context, nodeId, "/message_campaigns", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMessageCampaigns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMessageCampaigns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMessageCampaigns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMessageCampaigns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessageCampaigns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMessageCampaigns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessageCampaigns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMessageCampaigns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMessageTemplatePreviews extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "add_security_recommendation",
      "button_types",
      "category",
      "code_expiration_minutes",
      "languages",
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
               return APIRequestGetMessageTemplatePreviews.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetMessageTemplatePreviews(String nodeId, APIContext context) {
      super(context, nodeId, "/message_template_previews", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMessageTemplatePreviews setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMessageTemplatePreviews setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMessageTemplatePreviews setAddSecurityRecommendation (Boolean addSecurityRecommendation) {
      this.setParam("add_security_recommendation", addSecurityRecommendation);
      return this;
    }
    public APIRequestGetMessageTemplatePreviews setAddSecurityRecommendation (String addSecurityRecommendation) {
      this.setParam("add_security_recommendation", addSecurityRecommendation);
      return this;
    }

    public APIRequestGetMessageTemplatePreviews setButtonTypes (List<EnumButtonTypes> buttonTypes) {
      this.setParam("button_types", buttonTypes);
      return this;
    }
    public APIRequestGetMessageTemplatePreviews setButtonTypes (String buttonTypes) {
      this.setParam("button_types", buttonTypes);
      return this;
    }

    public APIRequestGetMessageTemplatePreviews setCategory (EnumCategory category) {
      this.setParam("category", category);
      return this;
    }
    public APIRequestGetMessageTemplatePreviews setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestGetMessageTemplatePreviews setCodeExpirationMinutes (Long codeExpirationMinutes) {
      this.setParam("code_expiration_minutes", codeExpirationMinutes);
      return this;
    }
    public APIRequestGetMessageTemplatePreviews setCodeExpirationMinutes (String codeExpirationMinutes) {
      this.setParam("code_expiration_minutes", codeExpirationMinutes);
      return this;
    }

    public APIRequestGetMessageTemplatePreviews setLanguages (List<String> languages) {
      this.setParam("languages", languages);
      return this;
    }
    public APIRequestGetMessageTemplatePreviews setLanguages (String languages) {
      this.setParam("languages", languages);
      return this;
    }

    public APIRequestGetMessageTemplatePreviews requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMessageTemplatePreviews requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessageTemplatePreviews requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMessageTemplatePreviews requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessageTemplatePreviews requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMessageTemplatePreviews requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteMessageTemplates extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "hsm_id",
      "name",
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
               return APIRequestDeleteMessageTemplates.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteMessageTemplates(String nodeId, APIContext context) {
      super(context, nodeId, "/message_templates", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteMessageTemplates setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteMessageTemplates setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteMessageTemplates setHsmId (String hsmId) {
      this.setParam("hsm_id", hsmId);
      return this;
    }

    public APIRequestDeleteMessageTemplates setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestDeleteMessageTemplates requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteMessageTemplates requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMessageTemplates requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteMessageTemplates requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteMessageTemplates requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteMessageTemplates requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetMessageTemplates extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "category",
      "content",
      "language",
      "name",
      "name_or_content",
      "quality_score",
      "status",
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
               return APIRequestGetMessageTemplates.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetMessageTemplates(String nodeId, APIContext context) {
      super(context, nodeId, "/message_templates", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMessageTemplates setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMessageTemplates setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMessageTemplates setCategory (List<WhatsAppBusinessAccount.EnumCategory> category) {
      this.setParam("category", category);
      return this;
    }
    public APIRequestGetMessageTemplates setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestGetMessageTemplates setContent (String content) {
      this.setParam("content", content);
      return this;
    }

    public APIRequestGetMessageTemplates setLanguage (List<String> language) {
      this.setParam("language", language);
      return this;
    }
    public APIRequestGetMessageTemplates setLanguage (String language) {
      this.setParam("language", language);
      return this;
    }

    public APIRequestGetMessageTemplates setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestGetMessageTemplates setNameOrContent (String nameOrContent) {
      this.setParam("name_or_content", nameOrContent);
      return this;
    }

    public APIRequestGetMessageTemplates setQualityScore (List<EnumQualityScore> qualityScore) {
      this.setParam("quality_score", qualityScore);
      return this;
    }
    public APIRequestGetMessageTemplates setQualityScore (String qualityScore) {
      this.setParam("quality_score", qualityScore);
      return this;
    }

    public APIRequestGetMessageTemplates setStatus (List<EnumStatus> status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestGetMessageTemplates setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestGetMessageTemplates requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMessageTemplates requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessageTemplates requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMessageTemplates requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMessageTemplates requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMessageTemplates requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMessageTemplate extends APIRequest<WhatsAppBusinessAccount> {

    WhatsAppBusinessAccount lastResponse = null;
    @Override
    public WhatsAppBusinessAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "allow_category_change",
      "category",
      "components",
      "cta_url_link_tracking_opted_out",
      "display_format",
      "language",
      "library_template_button_inputs",
      "library_template_name",
      "message_send_ttl_seconds",
      "name",
      "sub_category",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public WhatsAppBusinessAccount parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessAccount.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WhatsAppBusinessAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WhatsAppBusinessAccount execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WhatsAppBusinessAccount>() {
           public WhatsAppBusinessAccount apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMessageTemplate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMessageTemplate(String nodeId, APIContext context) {
      super(context, nodeId, "/message_templates", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMessageTemplate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMessageTemplate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMessageTemplate setAllowCategoryChange (Boolean allowCategoryChange) {
      this.setParam("allow_category_change", allowCategoryChange);
      return this;
    }
    public APIRequestCreateMessageTemplate setAllowCategoryChange (String allowCategoryChange) {
      this.setParam("allow_category_change", allowCategoryChange);
      return this;
    }

    public APIRequestCreateMessageTemplate setCategory (WhatsAppBusinessAccount.EnumCategory category) {
      this.setParam("category", category);
      return this;
    }
    public APIRequestCreateMessageTemplate setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestCreateMessageTemplate setComponents (List<Map<String, String>> components) {
      this.setParam("components", components);
      return this;
    }
    public APIRequestCreateMessageTemplate setComponents (String components) {
      this.setParam("components", components);
      return this;
    }

    public APIRequestCreateMessageTemplate setCtaUrlLinkTrackingOptedOut (Boolean ctaUrlLinkTrackingOptedOut) {
      this.setParam("cta_url_link_tracking_opted_out", ctaUrlLinkTrackingOptedOut);
      return this;
    }
    public APIRequestCreateMessageTemplate setCtaUrlLinkTrackingOptedOut (String ctaUrlLinkTrackingOptedOut) {
      this.setParam("cta_url_link_tracking_opted_out", ctaUrlLinkTrackingOptedOut);
      return this;
    }

    public APIRequestCreateMessageTemplate setDisplayFormat (WhatsAppBusinessAccount.EnumDisplayFormat displayFormat) {
      this.setParam("display_format", displayFormat);
      return this;
    }
    public APIRequestCreateMessageTemplate setDisplayFormat (String displayFormat) {
      this.setParam("display_format", displayFormat);
      return this;
    }

    public APIRequestCreateMessageTemplate setLanguage (String language) {
      this.setParam("language", language);
      return this;
    }

    public APIRequestCreateMessageTemplate setLibraryTemplateButtonInputs (List<Map<String, String>> libraryTemplateButtonInputs) {
      this.setParam("library_template_button_inputs", libraryTemplateButtonInputs);
      return this;
    }
    public APIRequestCreateMessageTemplate setLibraryTemplateButtonInputs (String libraryTemplateButtonInputs) {
      this.setParam("library_template_button_inputs", libraryTemplateButtonInputs);
      return this;
    }

    public APIRequestCreateMessageTemplate setLibraryTemplateName (String libraryTemplateName) {
      this.setParam("library_template_name", libraryTemplateName);
      return this;
    }

    public APIRequestCreateMessageTemplate setMessageSendTtlSeconds (Long messageSendTtlSeconds) {
      this.setParam("message_send_ttl_seconds", messageSendTtlSeconds);
      return this;
    }
    public APIRequestCreateMessageTemplate setMessageSendTtlSeconds (String messageSendTtlSeconds) {
      this.setParam("message_send_ttl_seconds", messageSendTtlSeconds);
      return this;
    }

    public APIRequestCreateMessageTemplate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateMessageTemplate setSubCategory (WhatsAppBusinessAccount.EnumSubCategory subCategory) {
      this.setParam("sub_category", subCategory);
      return this;
    }
    public APIRequestCreateMessageTemplate setSubCategory (String subCategory) {
      this.setParam("sub_category", subCategory);
      return this;
    }

    public APIRequestCreateMessageTemplate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMessageTemplate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessageTemplate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMessageTemplate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMessageTemplate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMessageTemplate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateMigrateMessageTemplate extends APIRequest<WhatsAppBusinessAccount> {

    WhatsAppBusinessAccount lastResponse = null;
    @Override
    public WhatsAppBusinessAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "page_number",
      "source_waba_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public WhatsAppBusinessAccount parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessAccount.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WhatsAppBusinessAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WhatsAppBusinessAccount execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WhatsAppBusinessAccount>() {
           public WhatsAppBusinessAccount apply(ResponseWrapper result) {
             try {
               return APIRequestCreateMigrateMessageTemplate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateMigrateMessageTemplate(String nodeId, APIContext context) {
      super(context, nodeId, "/migrate_message_templates", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateMigrateMessageTemplate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateMigrateMessageTemplate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateMigrateMessageTemplate setPageNumber (Long pageNumber) {
      this.setParam("page_number", pageNumber);
      return this;
    }
    public APIRequestCreateMigrateMessageTemplate setPageNumber (String pageNumber) {
      this.setParam("page_number", pageNumber);
      return this;
    }

    public APIRequestCreateMigrateMessageTemplate setSourceWabaId (String sourceWabaId) {
      this.setParam("source_waba_id", sourceWabaId);
      return this;
    }

    public APIRequestCreateMigrateMessageTemplate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateMigrateMessageTemplate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMigrateMessageTemplate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateMigrateMessageTemplate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateMigrateMessageTemplate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateMigrateMessageTemplate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPhoneNumbers extends APIRequest<APINode> {

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
               return APIRequestGetPhoneNumbers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPhoneNumbers(String nodeId, APIContext context) {
      super(context, nodeId, "/phone_numbers", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPhoneNumbers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPhoneNumbers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPhoneNumbers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPhoneNumbers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPhoneNumbers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPhoneNumbers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPhoneNumbers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPhoneNumbers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreatePhoneNumber extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "cc",
      "migrate_phone_number",
      "phone_number",
      "preverified_id",
      "verified_name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreatePhoneNumber.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreatePhoneNumber(String nodeId, APIContext context) {
      super(context, nodeId, "/phone_numbers", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreatePhoneNumber setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreatePhoneNumber setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreatePhoneNumber setCc (String cc) {
      this.setParam("cc", cc);
      return this;
    }

    public APIRequestCreatePhoneNumber setMigratePhoneNumber (Boolean migratePhoneNumber) {
      this.setParam("migrate_phone_number", migratePhoneNumber);
      return this;
    }
    public APIRequestCreatePhoneNumber setMigratePhoneNumber (String migratePhoneNumber) {
      this.setParam("migrate_phone_number", migratePhoneNumber);
      return this;
    }

    public APIRequestCreatePhoneNumber setPhoneNumber (String phoneNumber) {
      this.setParam("phone_number", phoneNumber);
      return this;
    }

    public APIRequestCreatePhoneNumber setPreverifiedId (String preverifiedId) {
      this.setParam("preverified_id", preverifiedId);
      return this;
    }

    public APIRequestCreatePhoneNumber setVerifiedName (String verifiedName) {
      this.setParam("verified_name", verifiedName);
      return this;
    }

    public APIRequestCreatePhoneNumber requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreatePhoneNumber requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoneNumber requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreatePhoneNumber requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreatePhoneNumber requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreatePhoneNumber requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteProductCatalogs extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_id",
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
               return APIRequestDeleteProductCatalogs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/product_catalogs", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteProductCatalogs setCatalogId (String catalogId) {
      this.setParam("catalog_id", catalogId);
      return this;
    }

    public APIRequestDeleteProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteProductCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetProductCatalogs extends APIRequest<ProductCatalog> {

    APINodeList<ProductCatalog> lastResponse = null;
    @Override
    public APINodeList<ProductCatalog> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_to_collaborative_ads_share_settings",
      "agency_collaborative_ads_share_settings",
      "business",
      "catalog_store",
      "commerce_merchant_settings",
      "creator_user",
      "da_display_settings",
      "default_image_url",
      "fallback_image_url",
      "feed_count",
      "id",
      "is_catalog_segment",
      "is_local_catalog",
      "name",
      "owner_business",
      "product_count",
      "store_catalog_settings",
      "user_access_expire_time",
      "vertical",
    };

    @Override
    public APINodeList<ProductCatalog> parseResponse(String response, String header) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductCatalog> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductCatalog> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductCatalog>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductCatalog>>() {
           public APINodeList<ProductCatalog> apply(ResponseWrapper result) {
             try {
               return APIRequestGetProductCatalogs.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetProductCatalogs(String nodeId, APIContext context) {
      super(context, nodeId, "/product_catalogs", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetProductCatalogs setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetProductCatalogs requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetProductCatalogs requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetProductCatalogs requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetProductCatalogs requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetProductCatalogs requestAdAccountToCollaborativeAdsShareSettingsField () {
      return this.requestAdAccountToCollaborativeAdsShareSettingsField(true);
    }
    public APIRequestGetProductCatalogs requestAdAccountToCollaborativeAdsShareSettingsField (boolean value) {
      this.requestField("ad_account_to_collaborative_ads_share_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestAgencyCollaborativeAdsShareSettingsField () {
      return this.requestAgencyCollaborativeAdsShareSettingsField(true);
    }
    public APIRequestGetProductCatalogs requestAgencyCollaborativeAdsShareSettingsField (boolean value) {
      this.requestField("agency_collaborative_ads_share_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetProductCatalogs requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestCatalogStoreField () {
      return this.requestCatalogStoreField(true);
    }
    public APIRequestGetProductCatalogs requestCatalogStoreField (boolean value) {
      this.requestField("catalog_store", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestCommerceMerchantSettingsField () {
      return this.requestCommerceMerchantSettingsField(true);
    }
    public APIRequestGetProductCatalogs requestCommerceMerchantSettingsField (boolean value) {
      this.requestField("commerce_merchant_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestCreatorUserField () {
      return this.requestCreatorUserField(true);
    }
    public APIRequestGetProductCatalogs requestCreatorUserField (boolean value) {
      this.requestField("creator_user", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestDaDisplaySettingsField () {
      return this.requestDaDisplaySettingsField(true);
    }
    public APIRequestGetProductCatalogs requestDaDisplaySettingsField (boolean value) {
      this.requestField("da_display_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestDefaultImageUrlField () {
      return this.requestDefaultImageUrlField(true);
    }
    public APIRequestGetProductCatalogs requestDefaultImageUrlField (boolean value) {
      this.requestField("default_image_url", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestFallbackImageUrlField () {
      return this.requestFallbackImageUrlField(true);
    }
    public APIRequestGetProductCatalogs requestFallbackImageUrlField (boolean value) {
      this.requestField("fallback_image_url", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestFeedCountField () {
      return this.requestFeedCountField(true);
    }
    public APIRequestGetProductCatalogs requestFeedCountField (boolean value) {
      this.requestField("feed_count", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetProductCatalogs requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestIsCatalogSegmentField () {
      return this.requestIsCatalogSegmentField(true);
    }
    public APIRequestGetProductCatalogs requestIsCatalogSegmentField (boolean value) {
      this.requestField("is_catalog_segment", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestIsLocalCatalogField () {
      return this.requestIsLocalCatalogField(true);
    }
    public APIRequestGetProductCatalogs requestIsLocalCatalogField (boolean value) {
      this.requestField("is_local_catalog", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetProductCatalogs requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGetProductCatalogs requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestProductCountField () {
      return this.requestProductCountField(true);
    }
    public APIRequestGetProductCatalogs requestProductCountField (boolean value) {
      this.requestField("product_count", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestStoreCatalogSettingsField () {
      return this.requestStoreCatalogSettingsField(true);
    }
    public APIRequestGetProductCatalogs requestStoreCatalogSettingsField (boolean value) {
      this.requestField("store_catalog_settings", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetProductCatalogs requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetProductCatalogs requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetProductCatalogs requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
  }

  public static class APIRequestCreateProductCatalog extends APIRequest<ProductCatalog> {

    ProductCatalog lastResponse = null;
    @Override
    public ProductCatalog getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "catalog_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ProductCatalog parseResponse(String response, String header) throws APIException {
      return ProductCatalog.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ProductCatalog execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProductCatalog execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ProductCatalog> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProductCatalog> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ProductCatalog>() {
           public ProductCatalog apply(ResponseWrapper result) {
             try {
               return APIRequestCreateProductCatalog.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateProductCatalog(String nodeId, APIContext context) {
      super(context, nodeId, "/product_catalogs", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateProductCatalog setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateProductCatalog setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateProductCatalog setCatalogId (String catalogId) {
      this.setParam("catalog_id", catalogId);
      return this;
    }

    public APIRequestCreateProductCatalog requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateProductCatalog requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductCatalog requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateProductCatalog requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateProductCatalog requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateProductCatalog requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSchedules extends APIRequest<APINode> {

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
               return APIRequestGetSchedules.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSchedules(String nodeId, APIContext context) {
      super(context, nodeId, "/schedules", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSchedules setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSchedules setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSchedules requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSchedules requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSchedules requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSchedules requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSchedules requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSchedules requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSetOboMobilityIntent extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "solution_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestCreateSetOboMobilityIntent.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSetOboMobilityIntent(String nodeId, APIContext context) {
      super(context, nodeId, "/set_obo_mobility_intent", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSetOboMobilityIntent setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSetOboMobilityIntent setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSetOboMobilityIntent setSolutionId (String solutionId) {
      this.setParam("solution_id", solutionId);
      return this;
    }

    public APIRequestCreateSetOboMobilityIntent requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSetOboMobilityIntent requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSetOboMobilityIntent requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSetOboMobilityIntent requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSetOboMobilityIntent requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSetOboMobilityIntent requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSolutions extends APIRequest<APINode> {

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
               return APIRequestGetSolutions.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSolutions(String nodeId, APIContext context) {
      super(context, nodeId, "/solutions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSolutions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSolutions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSolutions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSolutions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSolutions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSolutions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSolutions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSolutions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteSubscribedApps extends APIRequest<APINode> {

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
               return APIRequestDeleteSubscribedApps.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestDeleteSubscribedApps(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_apps", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteSubscribedApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteSubscribedApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteSubscribedApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteSubscribedApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteSubscribedApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetSubscribedApps extends APIRequest<APINode> {

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
               return APIRequestGetSubscribedApps.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetSubscribedApps(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_apps", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetSubscribedApps setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetSubscribedApps setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetSubscribedApps requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetSubscribedApps requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubscribedApps requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetSubscribedApps requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetSubscribedApps requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetSubscribedApps requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateSubscribedApp extends APIRequest<WhatsAppBusinessAccount> {

    WhatsAppBusinessAccount lastResponse = null;
    @Override
    public WhatsAppBusinessAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "override_callback_uri",
      "verify_token",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public WhatsAppBusinessAccount parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessAccount.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WhatsAppBusinessAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WhatsAppBusinessAccount execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WhatsAppBusinessAccount>() {
           public WhatsAppBusinessAccount apply(ResponseWrapper result) {
             try {
               return APIRequestCreateSubscribedApp.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateSubscribedApp(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_apps", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateSubscribedApp setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateSubscribedApp setOverrideCallbackUri (String overrideCallbackUri) {
      this.setParam("override_callback_uri", overrideCallbackUri);
      return this;
    }

    public APIRequestCreateSubscribedApp setVerifyToken (String verifyToken) {
      this.setParam("verify_token", verifyToken);
      return this;
    }

    public APIRequestCreateSubscribedApp requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateSubscribedApp requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateSubscribedApp requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateSubscribedApp requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetTemplateAnalytics extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "end",
      "granularity",
      "metric_types",
      "start",
      "template_ids",
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
               return APIRequestGetTemplateAnalytics.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTemplateAnalytics(String nodeId, APIContext context) {
      super(context, nodeId, "/template_analytics", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTemplateAnalytics setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTemplateAnalytics setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTemplateAnalytics setEnd (String end) {
      this.setParam("end", end);
      return this;
    }

    public APIRequestGetTemplateAnalytics setGranularity (EnumGranularity granularity) {
      this.setParam("granularity", granularity);
      return this;
    }
    public APIRequestGetTemplateAnalytics setGranularity (String granularity) {
      this.setParam("granularity", granularity);
      return this;
    }

    public APIRequestGetTemplateAnalytics setMetricTypes (List<EnumMetricTypes> metricTypes) {
      this.setParam("metric_types", metricTypes);
      return this;
    }
    public APIRequestGetTemplateAnalytics setMetricTypes (String metricTypes) {
      this.setParam("metric_types", metricTypes);
      return this;
    }

    public APIRequestGetTemplateAnalytics setStart (String start) {
      this.setParam("start", start);
      return this;
    }

    public APIRequestGetTemplateAnalytics setTemplateIds (List<String> templateIds) {
      this.setParam("template_ids", templateIds);
      return this;
    }
    public APIRequestGetTemplateAnalytics setTemplateIds (String templateIds) {
      this.setParam("template_ids", templateIds);
      return this;
    }

    public APIRequestGetTemplateAnalytics requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTemplateAnalytics requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTemplateAnalytics requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTemplateAnalytics requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTemplateAnalytics requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTemplateAnalytics requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetTemplatePerformanceMetrics extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "template_id",
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
               return APIRequestGetTemplatePerformanceMetrics.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetTemplatePerformanceMetrics(String nodeId, APIContext context) {
      super(context, nodeId, "/template_performance_metrics", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTemplatePerformanceMetrics setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTemplatePerformanceMetrics setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTemplatePerformanceMetrics setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestGetTemplatePerformanceMetrics setTemplateId (String templateId) {
      this.setParam("template_id", templateId);
      return this;
    }

    public APIRequestGetTemplatePerformanceMetrics requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTemplatePerformanceMetrics requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTemplatePerformanceMetrics requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTemplatePerformanceMetrics requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTemplatePerformanceMetrics requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTemplatePerformanceMetrics requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateUpsertMessageTemplate extends APIRequest<WhatsAppBusinessAccount> {

    WhatsAppBusinessAccount lastResponse = null;
    @Override
    public WhatsAppBusinessAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "category",
      "components",
      "languages",
      "message_send_ttl_seconds",
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public WhatsAppBusinessAccount parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessAccount.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WhatsAppBusinessAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WhatsAppBusinessAccount execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WhatsAppBusinessAccount>() {
           public WhatsAppBusinessAccount apply(ResponseWrapper result) {
             try {
               return APIRequestCreateUpsertMessageTemplate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateUpsertMessageTemplate(String nodeId, APIContext context) {
      super(context, nodeId, "/upsert_message_templates", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUpsertMessageTemplate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUpsertMessageTemplate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUpsertMessageTemplate setCategory (WhatsAppBusinessAccount.EnumCategory category) {
      this.setParam("category", category);
      return this;
    }
    public APIRequestCreateUpsertMessageTemplate setCategory (String category) {
      this.setParam("category", category);
      return this;
    }

    public APIRequestCreateUpsertMessageTemplate setComponents (List<Map<String, String>> components) {
      this.setParam("components", components);
      return this;
    }
    public APIRequestCreateUpsertMessageTemplate setComponents (String components) {
      this.setParam("components", components);
      return this;
    }

    public APIRequestCreateUpsertMessageTemplate setLanguages (List<String> languages) {
      this.setParam("languages", languages);
      return this;
    }
    public APIRequestCreateUpsertMessageTemplate setLanguages (String languages) {
      this.setParam("languages", languages);
      return this;
    }

    public APIRequestCreateUpsertMessageTemplate setMessageSendTtlSeconds (Long messageSendTtlSeconds) {
      this.setParam("message_send_ttl_seconds", messageSendTtlSeconds);
      return this;
    }
    public APIRequestCreateUpsertMessageTemplate setMessageSendTtlSeconds (String messageSendTtlSeconds) {
      this.setParam("message_send_ttl_seconds", messageSendTtlSeconds);
      return this;
    }

    public APIRequestCreateUpsertMessageTemplate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateUpsertMessageTemplate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUpsertMessageTemplate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpsertMessageTemplate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUpsertMessageTemplate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUpsertMessageTemplate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUpsertMessageTemplate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<WhatsAppBusinessAccount> {

    WhatsAppBusinessAccount lastResponse = null;
    @Override
    public WhatsAppBusinessAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_review_status",
      "analytics",
      "auth_international_rate_eligibility",
      "business_verification_status",
      "country",
      "creation_time",
      "currency",
      "health_status",
      "id",
      "is_enabled_for_insights",
      "linked_commerce_account",
      "message_template_namespace",
      "name",
      "on_behalf_of_business_info",
      "owner_business",
      "owner_business_info",
      "ownership_type",
      "primary_business_location",
      "primary_funding_id",
      "purchase_order_number",
      "status",
      "timezone_id",
    };

    @Override
    public WhatsAppBusinessAccount parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessAccount.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WhatsAppBusinessAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WhatsAppBusinessAccount execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WhatsAppBusinessAccount>() {
           public WhatsAppBusinessAccount apply(ResponseWrapper result) {
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

    public APIRequestGet requestAccountReviewStatusField () {
      return this.requestAccountReviewStatusField(true);
    }
    public APIRequestGet requestAccountReviewStatusField (boolean value) {
      this.requestField("account_review_status", value);
      return this;
    }
    public APIRequestGet requestAnalyticsField () {
      return this.requestAnalyticsField(true);
    }
    public APIRequestGet requestAnalyticsField (boolean value) {
      this.requestField("analytics", value);
      return this;
    }
    public APIRequestGet requestAuthInternationalRateEligibilityField () {
      return this.requestAuthInternationalRateEligibilityField(true);
    }
    public APIRequestGet requestAuthInternationalRateEligibilityField (boolean value) {
      this.requestField("auth_international_rate_eligibility", value);
      return this;
    }
    public APIRequestGet requestBusinessVerificationStatusField () {
      return this.requestBusinessVerificationStatusField(true);
    }
    public APIRequestGet requestBusinessVerificationStatusField (boolean value) {
      this.requestField("business_verification_status", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestHealthStatusField () {
      return this.requestHealthStatusField(true);
    }
    public APIRequestGet requestHealthStatusField (boolean value) {
      this.requestField("health_status", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsEnabledForInsightsField () {
      return this.requestIsEnabledForInsightsField(true);
    }
    public APIRequestGet requestIsEnabledForInsightsField (boolean value) {
      this.requestField("is_enabled_for_insights", value);
      return this;
    }
    public APIRequestGet requestLinkedCommerceAccountField () {
      return this.requestLinkedCommerceAccountField(true);
    }
    public APIRequestGet requestLinkedCommerceAccountField (boolean value) {
      this.requestField("linked_commerce_account", value);
      return this;
    }
    public APIRequestGet requestMessageTemplateNamespaceField () {
      return this.requestMessageTemplateNamespaceField(true);
    }
    public APIRequestGet requestMessageTemplateNamespaceField (boolean value) {
      this.requestField("message_template_namespace", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOnBehalfOfBusinessInfoField () {
      return this.requestOnBehalfOfBusinessInfoField(true);
    }
    public APIRequestGet requestOnBehalfOfBusinessInfoField (boolean value) {
      this.requestField("on_behalf_of_business_info", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessInfoField () {
      return this.requestOwnerBusinessInfoField(true);
    }
    public APIRequestGet requestOwnerBusinessInfoField (boolean value) {
      this.requestField("owner_business_info", value);
      return this;
    }
    public APIRequestGet requestOwnershipTypeField () {
      return this.requestOwnershipTypeField(true);
    }
    public APIRequestGet requestOwnershipTypeField (boolean value) {
      this.requestField("ownership_type", value);
      return this;
    }
    public APIRequestGet requestPrimaryBusinessLocationField () {
      return this.requestPrimaryBusinessLocationField(true);
    }
    public APIRequestGet requestPrimaryBusinessLocationField (boolean value) {
      this.requestField("primary_business_location", value);
      return this;
    }
    public APIRequestGet requestPrimaryFundingIdField () {
      return this.requestPrimaryFundingIdField(true);
    }
    public APIRequestGet requestPrimaryFundingIdField (boolean value) {
      this.requestField("primary_funding_id", value);
      return this;
    }
    public APIRequestGet requestPurchaseOrderNumberField () {
      return this.requestPurchaseOrderNumberField(true);
    }
    public APIRequestGet requestPurchaseOrderNumberField (boolean value) {
      this.requestField("purchase_order_number", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGet requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<WhatsAppBusinessAccount> {

    WhatsAppBusinessAccount lastResponse = null;
    @Override
    public WhatsAppBusinessAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_enabled_for_insights",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public WhatsAppBusinessAccount parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessAccount.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WhatsAppBusinessAccount execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WhatsAppBusinessAccount execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WhatsAppBusinessAccount> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WhatsAppBusinessAccount>() {
           public WhatsAppBusinessAccount apply(ResponseWrapper result) {
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


    public APIRequestUpdate setIsEnabledForInsights (Boolean isEnabledForInsights) {
      this.setParam("is_enabled_for_insights", isEnabledForInsights);
      return this;
    }
    public APIRequestUpdate setIsEnabledForInsights (String isEnabledForInsights) {
      this.setParam("is_enabled_for_insights", isEnabledForInsights);
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

  public static enum EnumTasks {
      @SerializedName("DEVELOP")
      VALUE_DEVELOP("DEVELOP"),
      @SerializedName("MANAGE")
      VALUE_MANAGE("MANAGE"),
      @SerializedName("MANAGE_EXTENSIONS")
      VALUE_MANAGE_EXTENSIONS("MANAGE_EXTENSIONS"),
      @SerializedName("MANAGE_PHONE")
      VALUE_MANAGE_PHONE("MANAGE_PHONE"),
      @SerializedName("MANAGE_PHONE_ASSETS")
      VALUE_MANAGE_PHONE_ASSETS("MANAGE_PHONE_ASSETS"),
      @SerializedName("MANAGE_TEMPLATES")
      VALUE_MANAGE_TEMPLATES("MANAGE_TEMPLATES"),
      @SerializedName("MESSAGING")
      VALUE_MESSAGING("MESSAGING"),
      @SerializedName("VIEW_COST")
      VALUE_VIEW_COST("VIEW_COST"),
      @SerializedName("VIEW_PHONE_ASSETS")
      VALUE_VIEW_PHONE_ASSETS("VIEW_PHONE_ASSETS"),
      @SerializedName("VIEW_TEMPLATES")
      VALUE_VIEW_TEMPLATES("VIEW_TEMPLATES"),
      ;

      private String value;

      private EnumTasks(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCategory {
      @SerializedName("AUTHENTICATION")
      VALUE_AUTHENTICATION("AUTHENTICATION"),
      @SerializedName("MARKETING")
      VALUE_MARKETING("MARKETING"),
      @SerializedName("UTILITY")
      VALUE_UTILITY("UTILITY"),
      ;

      private String value;

      private EnumCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDisplayFormat {
      @SerializedName("ORDER_DETAILS")
      VALUE_ORDER_DETAILS("ORDER_DETAILS"),
      ;

      private String value;

      private EnumDisplayFormat(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSubCategory {
      @SerializedName("ORDER_DETAILS")
      VALUE_ORDER_DETAILS("ORDER_DETAILS"),
      @SerializedName("ORDER_STATUS")
      VALUE_ORDER_STATUS("ORDER_STATUS"),
      ;

      private String value;

      private EnumSubCategory(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumConversationCategories {
      @SerializedName("AUTHENTICATION")
      VALUE_AUTHENTICATION("AUTHENTICATION"),
      @SerializedName("AUTHENTICATION_INTERNATIONAL")
      VALUE_AUTHENTICATION_INTERNATIONAL("AUTHENTICATION_INTERNATIONAL"),
      @SerializedName("MARKETING")
      VALUE_MARKETING("MARKETING"),
      @SerializedName("MARKETING_OPTIMIZED_DELIVERY")
      VALUE_MARKETING_OPTIMIZED_DELIVERY("MARKETING_OPTIMIZED_DELIVERY"),
      @SerializedName("SERVICE")
      VALUE_SERVICE("SERVICE"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      @SerializedName("UTILITY")
      VALUE_UTILITY("UTILITY"),
      @SerializedName("UTILITY_FIXED_TEMPLATE")
      VALUE_UTILITY_FIXED_TEMPLATE("UTILITY_FIXED_TEMPLATE"),
      ;

      private String value;

      private EnumConversationCategories(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumConversationDirections {
      @SerializedName("BUSINESS_INITIATED")
      VALUE_BUSINESS_INITIATED("BUSINESS_INITIATED"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      @SerializedName("USER_INITIATED")
      VALUE_USER_INITIATED("USER_INITIATED"),
      ;

      private String value;

      private EnumConversationDirections(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumConversationTypes {
      @SerializedName("FREE_ENTRY_POINT")
      VALUE_FREE_ENTRY_POINT("FREE_ENTRY_POINT"),
      @SerializedName("FREE_TIER")
      VALUE_FREE_TIER("FREE_TIER"),
      @SerializedName("REGULAR")
      VALUE_REGULAR("REGULAR"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumConversationTypes(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDimensions {
      @SerializedName("CONVERSATION_CATEGORY")
      VALUE_CONVERSATION_CATEGORY("CONVERSATION_CATEGORY"),
      @SerializedName("CONVERSATION_DIRECTION")
      VALUE_CONVERSATION_DIRECTION("CONVERSATION_DIRECTION"),
      @SerializedName("CONVERSATION_TYPE")
      VALUE_CONVERSATION_TYPE("CONVERSATION_TYPE"),
      @SerializedName("COUNTRY")
      VALUE_COUNTRY("COUNTRY"),
      @SerializedName("PHONE")
      VALUE_PHONE("PHONE"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumDimensions(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumGranularity {
      @SerializedName("DAILY")
      VALUE_DAILY("DAILY"),
      @SerializedName("HALF_HOUR")
      VALUE_HALF_HOUR("HALF_HOUR"),
      @SerializedName("MONTHLY")
      VALUE_MONTHLY("MONTHLY"),
      ;

      private String value;

      private EnumGranularity(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMetricTypes {
      @SerializedName("CONVERSATION")
      VALUE_CONVERSATION("CONVERSATION"),
      @SerializedName("COST")
      VALUE_COST("COST"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      ;

      private String value;

      private EnumMetricTypes(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCategories {
      @SerializedName("APPOINTMENT_BOOKING")
      VALUE_APPOINTMENT_BOOKING("APPOINTMENT_BOOKING"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("CUSTOMER_SUPPORT")
      VALUE_CUSTOMER_SUPPORT("CUSTOMER_SUPPORT"),
      @SerializedName("LEAD_GENERATION")
      VALUE_LEAD_GENERATION("LEAD_GENERATION"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("SIGN_IN")
      VALUE_SIGN_IN("SIGN_IN"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("SURVEY")
      VALUE_SURVEY("SURVEY"),
      ;

      private String value;

      private EnumCategories(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumButtonTypes {
      @SerializedName("OTP")
      VALUE_OTP("OTP"),
      ;

      private String value;

      private EnumButtonTypes(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumQualityScore {
      @SerializedName("GREEN")
      VALUE_GREEN("GREEN"),
      @SerializedName("RED")
      VALUE_RED("RED"),
      @SerializedName("UNKNOWN")
      VALUE_UNKNOWN("UNKNOWN"),
      @SerializedName("YELLOW")
      VALUE_YELLOW("YELLOW"),
      ;

      private String value;

      private EnumQualityScore(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("APPROVED")
      VALUE_APPROVED("APPROVED"),
      @SerializedName("ARCHIVED")
      VALUE_ARCHIVED("ARCHIVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("DISABLED")
      VALUE_DISABLED("DISABLED"),
      @SerializedName("IN_APPEAL")
      VALUE_IN_APPEAL("IN_APPEAL"),
      @SerializedName("LIMIT_EXCEEDED")
      VALUE_LIMIT_EXCEEDED("LIMIT_EXCEEDED"),
      @SerializedName("PAUSED")
      VALUE_PAUSED("PAUSED"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("PENDING_DELETION")
      VALUE_PENDING_DELETION("PENDING_DELETION"),
      @SerializedName("REJECTED")
      VALUE_REJECTED("REJECTED"),
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

  public WhatsAppBusinessAccount copyFrom(WhatsAppBusinessAccount instance) {
    this.mAccountReviewStatus = instance.mAccountReviewStatus;
    this.mAnalytics = instance.mAnalytics;
    this.mAuthInternationalRateEligibility = instance.mAuthInternationalRateEligibility;
    this.mBusinessVerificationStatus = instance.mBusinessVerificationStatus;
    this.mCountry = instance.mCountry;
    this.mCreationTime = instance.mCreationTime;
    this.mCurrency = instance.mCurrency;
    this.mHealthStatus = instance.mHealthStatus;
    this.mId = instance.mId;
    this.mIsEnabledForInsights = instance.mIsEnabledForInsights;
    this.mLinkedCommerceAccount = instance.mLinkedCommerceAccount;
    this.mMessageTemplateNamespace = instance.mMessageTemplateNamespace;
    this.mName = instance.mName;
    this.mOnBehalfOfBusinessInfo = instance.mOnBehalfOfBusinessInfo;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mOwnerBusinessInfo = instance.mOwnerBusinessInfo;
    this.mOwnershipType = instance.mOwnershipType;
    this.mPrimaryBusinessLocation = instance.mPrimaryBusinessLocation;
    this.mPrimaryFundingId = instance.mPrimaryFundingId;
    this.mPurchaseOrderNumber = instance.mPurchaseOrderNumber;
    this.mStatus = instance.mStatus;
    this.mTimezoneId = instance.mTimezoneId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<WhatsAppBusinessAccount> getParser() {
    return new APIRequest.ResponseParser<WhatsAppBusinessAccount>() {
      public APINodeList<WhatsAppBusinessAccount> parseResponse(String response, APIContext context, APIRequest<WhatsAppBusinessAccount> request, String header) throws MalformedResponseException {
        return WhatsAppBusinessAccount.parseResponse(response, context, request, header);
      }
    };
  }
}
