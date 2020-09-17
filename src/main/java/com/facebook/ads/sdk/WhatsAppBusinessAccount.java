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
public class WhatsAppBusinessAccount extends APINode {
  @SerializedName("analytics")
  private Object mAnalytics = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("message_template_namespace")
  private String mMessageTemplateNamespace = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("on_behalf_of_business_info")
  private Object mOnBehalfOfBusinessInfo = null;
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

  public APIRequestDeleteMessageTemplates deleteMessageTemplates() {
    return new APIRequestDeleteMessageTemplates(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetMessageTemplates getMessageTemplates() {
    return new APIRequestGetMessageTemplates(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateMessageTemplate createMessageTemplate() {
    return new APIRequestCreateMessageTemplate(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPhoneNumbers getPhoneNumbers() {
    return new APIRequestGetPhoneNumbers(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateSubscribedApp createSubscribedApp() {
    return new APIRequestCreateSubscribedApp(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Object getFieldAnalytics() {
    return mAnalytics;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldId() {
    return mId;
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
         }
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
         }
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
         }
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

  public static class APIRequestDeleteMessageTemplates extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
         }
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
         }
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
      "category",
      "components",
      "language",
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
               return APIRequestCreateMessageTemplate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestCreateMessageTemplate setLanguage (String language) {
      this.setParam("language", language);
      return this;
    }

    public APIRequestCreateMessageTemplate setName (String name) {
      this.setParam("name", name);
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
         }
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

  public static class APIRequestCreateSubscribedApp extends APIRequest<WhatsAppBusinessAccount> {

    WhatsAppBusinessAccount lastResponse = null;
    @Override
    public WhatsAppBusinessAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
         }
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

  public static class APIRequestGet extends APIRequest<WhatsAppBusinessAccount> {

    WhatsAppBusinessAccount lastResponse = null;
    @Override
    public WhatsAppBusinessAccount getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "analytics",
      "currency",
      "id",
      "message_template_namespace",
      "name",
      "on_behalf_of_business_info",
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

    public APIRequestGet requestAnalyticsField () {
      return this.requestAnalyticsField(true);
    }
    public APIRequestGet requestAnalyticsField (boolean value) {
      this.requestField("analytics", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
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

  public static enum EnumTasks {
      @SerializedName("DEVELOP")
      VALUE_DEVELOP("DEVELOP"),
      @SerializedName("MANAGE")
      VALUE_MANAGE("MANAGE"),
      @SerializedName("MANAGE_PHONE")
      VALUE_MANAGE_PHONE("MANAGE_PHONE"),
      @SerializedName("MANAGE_TEMPLATES")
      VALUE_MANAGE_TEMPLATES("MANAGE_TEMPLATES"),
      @SerializedName("VIEW_COST")
      VALUE_VIEW_COST("VIEW_COST"),
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
      @SerializedName("ACCOUNT_UPDATE")
      VALUE_ACCOUNT_UPDATE("ACCOUNT_UPDATE"),
      @SerializedName("ALERT_UPDATE")
      VALUE_ALERT_UPDATE("ALERT_UPDATE"),
      @SerializedName("APPOINTMENT_UPDATE")
      VALUE_APPOINTMENT_UPDATE("APPOINTMENT_UPDATE"),
      @SerializedName("AUTO_REPLY")
      VALUE_AUTO_REPLY("AUTO_REPLY"),
      @SerializedName("ISSUE_RESOLUTION")
      VALUE_ISSUE_RESOLUTION("ISSUE_RESOLUTION"),
      @SerializedName("PAYMENT_UPDATE")
      VALUE_PAYMENT_UPDATE("PAYMENT_UPDATE"),
      @SerializedName("PERSONAL_FINANCE_UPDATE")
      VALUE_PERSONAL_FINANCE_UPDATE("PERSONAL_FINANCE_UPDATE"),
      @SerializedName("RESERVATION_UPDATE")
      VALUE_RESERVATION_UPDATE("RESERVATION_UPDATE"),
      @SerializedName("SHIPPING_UPDATE")
      VALUE_SHIPPING_UPDATE("SHIPPING_UPDATE"),
      @SerializedName("TICKET_UPDATE")
      VALUE_TICKET_UPDATE("TICKET_UPDATE"),
      @SerializedName("TRANSPORTATION_UPDATE")
      VALUE_TRANSPORTATION_UPDATE("TRANSPORTATION_UPDATE"),
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

  public static enum EnumStatus {
      @SerializedName("APPROVED")
      VALUE_APPROVED("APPROVED"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      @SerializedName("DISABLED")
      VALUE_DISABLED("DISABLED"),
      @SerializedName("IN_APPEAL")
      VALUE_IN_APPEAL("IN_APPEAL"),
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
    this.mAnalytics = instance.mAnalytics;
    this.mCurrency = instance.mCurrency;
    this.mId = instance.mId;
    this.mMessageTemplateNamespace = instance.mMessageTemplateNamespace;
    this.mName = instance.mName;
    this.mOnBehalfOfBusinessInfo = instance.mOnBehalfOfBusinessInfo;
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
