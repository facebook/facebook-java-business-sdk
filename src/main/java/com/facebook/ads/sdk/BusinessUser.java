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
public class BusinessUser extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("email")
  private String mEmail = null;
  @SerializedName("finance_permission")
  private String mFinancePermission = null;
  @SerializedName("first_name")
  private String mFirstName = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ip_permission")
  private String mIpPermission = null;
  @SerializedName("last_name")
  private String mLastName = null;
  @SerializedName("marked_for_removal")
  private Boolean mMarkedForRemoval = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("pending_email")
  private String mPendingEmail = null;
  @SerializedName("role")
  private String mRole = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("two_fac_status")
  private String mTwoFacStatus = null;
  protected static Gson gson = null;

  BusinessUser() {
  }

  public BusinessUser(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessUser(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public BusinessUser fetch() throws APIException{
    BusinessUser newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessUser fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessUser> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessUser fetchById(String id, APIContext context) throws APIException {
    BusinessUser businessUser =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return businessUser;
  }

  public static ListenableFuture<BusinessUser> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<BusinessUser> businessUser =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return businessUser;
  }

  public static APINodeList<BusinessUser> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessUser>)(
      new APIRequest<BusinessUser>(context, "", "/", "GET", BusinessUser.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessUser>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<BusinessUser>> businessUser =
      new APIRequest(context, "", "/", "GET", BusinessUser.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return businessUser;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static BusinessUser loadJSON(String json, APIContext context) {
    BusinessUser businessUser = getGson().fromJson(json, BusinessUser.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessUser.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    businessUser.context = context;
    businessUser.rawValue = json;
    return businessUser;
  }

  public static APINodeList<BusinessUser> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<BusinessUser> businessUsers = new APINodeList<BusinessUser>(request, json);
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
          businessUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return businessUsers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessUsers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessUsers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessUsers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessUsers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  businessUsers.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessUsers.add(loadJSON(obj.toString(), context));
            }
          }
          return businessUsers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessUsers.add(loadJSON(entry.getValue().toString(), context));
          }
          return businessUsers;
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
              businessUsers.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessUsers;
          }

          // Sixth, check if it's pure JsonObject
          businessUsers.clear();
          businessUsers.add(loadJSON(json, context));
          return businessUsers;
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


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldEmail() {
    return mEmail;
  }

  public String getFieldFinancePermission() {
    return mFinancePermission;
  }

  public String getFieldFirstName() {
    return mFirstName;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIpPermission() {
    return mIpPermission;
  }

  public String getFieldLastName() {
    return mLastName;
  }

  public Boolean getFieldMarkedForRemoval() {
    return mMarkedForRemoval;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPendingEmail() {
    return mPendingEmail;
  }

  public String getFieldRole() {
    return mRole;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldTwoFacStatus() {
    return mTwoFacStatus;
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

  public static class APIRequestGet extends APIRequest<BusinessUser> {

    BusinessUser lastResponse = null;
    @Override
    public BusinessUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "email",
      "finance_permission",
      "first_name",
      "id",
      "ip_permission",
      "last_name",
      "marked_for_removal",
      "name",
      "pending_email",
      "role",
      "title",
      "two_fac_status",
    };

    @Override
    public BusinessUser parseResponse(String response) throws APIException {
      return BusinessUser.parseResponse(response, getContext(), this).head();
    }

    @Override
    public BusinessUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessUser execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<BusinessUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, BusinessUser>() {
           public BusinessUser apply(String result) {
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

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGet requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGet requestFinancePermissionField () {
      return this.requestFinancePermissionField(true);
    }
    public APIRequestGet requestFinancePermissionField (boolean value) {
      this.requestField("finance_permission", value);
      return this;
    }
    public APIRequestGet requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGet requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIpPermissionField () {
      return this.requestIpPermissionField(true);
    }
    public APIRequestGet requestIpPermissionField (boolean value) {
      this.requestField("ip_permission", value);
      return this;
    }
    public APIRequestGet requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGet requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGet requestMarkedForRemovalField () {
      return this.requestMarkedForRemovalField(true);
    }
    public APIRequestGet requestMarkedForRemovalField (boolean value) {
      this.requestField("marked_for_removal", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPendingEmailField () {
      return this.requestPendingEmailField(true);
    }
    public APIRequestGet requestPendingEmailField (boolean value) {
      this.requestField("pending_email", value);
      return this;
    }
    public APIRequestGet requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGet requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestTwoFacStatusField () {
      return this.requestTwoFacStatusField(true);
    }
    public APIRequestGet requestTwoFacStatusField (boolean value) {
      this.requestField("two_fac_status", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<BusinessUser> {

    BusinessUser lastResponse = null;
    @Override
    public BusinessUser getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "clear_pending_email",
      "email",
      "first_name",
      "last_name",
      "pending_email",
      "role",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BusinessUser parseResponse(String response) throws APIException {
      return BusinessUser.parseResponse(response, getContext(), this).head();
    }

    @Override
    public BusinessUser execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessUser execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<BusinessUser> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessUser> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, BusinessUser>() {
           public BusinessUser apply(String result) {
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


    public APIRequestUpdate setClearPendingEmail (Boolean clearPendingEmail) {
      this.setParam("clear_pending_email", clearPendingEmail);
      return this;
    }
    public APIRequestUpdate setClearPendingEmail (String clearPendingEmail) {
      this.setParam("clear_pending_email", clearPendingEmail);
      return this;
    }

    public APIRequestUpdate setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestUpdate setFirstName (String firstName) {
      this.setParam("first_name", firstName);
      return this;
    }

    public APIRequestUpdate setLastName (String lastName) {
      this.setParam("last_name", lastName);
      return this;
    }

    public APIRequestUpdate setPendingEmail (String pendingEmail) {
      this.setParam("pending_email", pendingEmail);
      return this;
    }

    public APIRequestUpdate setRole (BusinessUser.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestUpdate setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
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

  public static enum EnumRole {
      @SerializedName("FINANCE_EDITOR")
      VALUE_FINANCE_EDITOR("FINANCE_EDITOR"),
      @SerializedName("FINANCE_ANALYST")
      VALUE_FINANCE_ANALYST("FINANCE_ANALYST"),
      @SerializedName("ADS_RIGHTS_REVIEWER")
      VALUE_ADS_RIGHTS_REVIEWER("ADS_RIGHTS_REVIEWER"),
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("EMPLOYEE")
      VALUE_EMPLOYEE("EMPLOYEE"),
      @SerializedName("FB_EMPLOYEE_SALES_REP")
      VALUE_FB_EMPLOYEE_SALES_REP("FB_EMPLOYEE_SALES_REP"),
      NULL(null);

      private String value;

      private EnumRole(String value) {
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

  public BusinessUser copyFrom(BusinessUser instance) {
    this.mBusiness = instance.mBusiness;
    this.mEmail = instance.mEmail;
    this.mFinancePermission = instance.mFinancePermission;
    this.mFirstName = instance.mFirstName;
    this.mId = instance.mId;
    this.mIpPermission = instance.mIpPermission;
    this.mLastName = instance.mLastName;
    this.mMarkedForRemoval = instance.mMarkedForRemoval;
    this.mName = instance.mName;
    this.mPendingEmail = instance.mPendingEmail;
    this.mRole = instance.mRole;
    this.mTitle = instance.mTitle;
    this.mTwoFacStatus = instance.mTwoFacStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessUser> getParser() {
    return new APIRequest.ResponseParser<BusinessUser>() {
      public APINodeList<BusinessUser> parseResponse(String response, APIContext context, APIRequest<BusinessUser> request) throws MalformedResponseException {
        return BusinessUser.parseResponse(response, context, request);
      }
    };
  }
}
