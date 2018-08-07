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
public class BusinessRoleRequest extends APINode {
  @SerializedName("created_by")
  private Object mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("email")
  private String mEmail = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("finance_role")
  private String mFinanceRole = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("invite_link")
  private String mInviteLink = null;
  @SerializedName("ip_role")
  private String mIpRole = null;
  @SerializedName("owner")
  private Business mOwner = null;
  @SerializedName("role")
  private String mRole = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("updated_by")
  private Object mUpdatedBy = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  BusinessRoleRequest() {
  }

  public BusinessRoleRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessRoleRequest(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public BusinessRoleRequest fetch() throws APIException{
    BusinessRoleRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessRoleRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessRoleRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessRoleRequest fetchById(String id, APIContext context) throws APIException {
    BusinessRoleRequest businessRoleRequest =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return businessRoleRequest;
  }

  public static ListenableFuture<BusinessRoleRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<BusinessRoleRequest> businessRoleRequest =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return businessRoleRequest;
  }

  public static APINodeList<BusinessRoleRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessRoleRequest>)(
      new APIRequest<BusinessRoleRequest>(context, "", "/", "GET", BusinessRoleRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessRoleRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<BusinessRoleRequest>> businessRoleRequest =
      new APIRequest(context, "", "/", "GET", BusinessRoleRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return businessRoleRequest;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static BusinessRoleRequest loadJSON(String json, APIContext context) {
    BusinessRoleRequest businessRoleRequest = getGson().fromJson(json, BusinessRoleRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessRoleRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    businessRoleRequest.context = context;
    businessRoleRequest.rawValue = json;
    return businessRoleRequest;
  }

  public static APINodeList<BusinessRoleRequest> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<BusinessRoleRequest> businessRoleRequests = new APINodeList<BusinessRoleRequest>(request, json);
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
          businessRoleRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return businessRoleRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessRoleRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessRoleRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessRoleRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessRoleRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  businessRoleRequests.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessRoleRequests.add(loadJSON(obj.toString(), context));
            }
          }
          return businessRoleRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessRoleRequests.add(loadJSON(entry.getValue().toString(), context));
          }
          return businessRoleRequests;
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
              businessRoleRequests.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessRoleRequests;
          }

          // Sixth, check if it's pure JsonObject
          businessRoleRequests.clear();
          businessRoleRequests.add(loadJSON(json, context));
          return businessRoleRequests;
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


  public Object getFieldCreatedBy() {
    return mCreatedBy;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldEmail() {
    return mEmail;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public String getFieldFinanceRole() {
    return mFinanceRole;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInviteLink() {
    return mInviteLink;
  }

  public String getFieldIpRole() {
    return mIpRole;
  }

  public Business getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public String getFieldRole() {
    return mRole;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public Object getFieldUpdatedBy() {
    return mUpdatedBy;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
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

  public static class APIRequestGet extends APIRequest<BusinessRoleRequest> {

    BusinessRoleRequest lastResponse = null;
    @Override
    public BusinessRoleRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "created_by",
      "created_time",
      "email",
      "expiration_time",
      "finance_role",
      "id",
      "invite_link",
      "ip_role",
      "owner",
      "role",
      "status",
      "updated_by",
      "updated_time",
    };

    @Override
    public BusinessRoleRequest parseResponse(String response) throws APIException {
      return BusinessRoleRequest.parseResponse(response, getContext(), this).head();
    }

    @Override
    public BusinessRoleRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessRoleRequest execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<BusinessRoleRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessRoleRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, BusinessRoleRequest>() {
           public BusinessRoleRequest apply(String result) {
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

    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGet requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGet requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGet requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGet requestFinanceRoleField () {
      return this.requestFinanceRoleField(true);
    }
    public APIRequestGet requestFinanceRoleField (boolean value) {
      this.requestField("finance_role", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInviteLinkField () {
      return this.requestInviteLinkField(true);
    }
    public APIRequestGet requestInviteLinkField (boolean value) {
      this.requestField("invite_link", value);
      return this;
    }
    public APIRequestGet requestIpRoleField () {
      return this.requestIpRoleField(true);
    }
    public APIRequestGet requestIpRoleField (boolean value) {
      this.requestField("ip_role", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGet requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGet requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<BusinessRoleRequest> {

    BusinessRoleRequest lastResponse = null;
    @Override
    public BusinessRoleRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "role",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BusinessRoleRequest parseResponse(String response) throws APIException {
      return BusinessRoleRequest.parseResponse(response, getContext(), this).head();
    }

    @Override
    public BusinessRoleRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessRoleRequest execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<BusinessRoleRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessRoleRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, BusinessRoleRequest>() {
           public BusinessRoleRequest apply(String result) {
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


    public APIRequestUpdate setRole (BusinessRoleRequest.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestUpdate setRole (String role) {
      this.setParam("role", role);
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

  public static enum EnumStatus {
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("ACCEPTED")
      VALUE_ACCEPTED("ACCEPTED"),
      @SerializedName("DECLINED")
      VALUE_DECLINED("DECLINED"),
      @SerializedName("EXPIRED")
      VALUE_EXPIRED("EXPIRED"),
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

  public BusinessRoleRequest copyFrom(BusinessRoleRequest instance) {
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mEmail = instance.mEmail;
    this.mExpirationTime = instance.mExpirationTime;
    this.mFinanceRole = instance.mFinanceRole;
    this.mId = instance.mId;
    this.mInviteLink = instance.mInviteLink;
    this.mIpRole = instance.mIpRole;
    this.mOwner = instance.mOwner;
    this.mRole = instance.mRole;
    this.mStatus = instance.mStatus;
    this.mUpdatedBy = instance.mUpdatedBy;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessRoleRequest> getParser() {
    return new APIRequest.ResponseParser<BusinessRoleRequest>() {
      public APINodeList<BusinessRoleRequest> parseResponse(String response, APIContext context, APIRequest<BusinessRoleRequest> request) throws MalformedResponseException {
        return BusinessRoleRequest.parseResponse(response, context, request);
      }
    };
  }
}
