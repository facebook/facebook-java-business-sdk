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
public class AdsPixel extends APINode {
  @SerializedName("automatic_matching_fields")
  private List<String> mAutomaticMatchingFields = null;
  @SerializedName("can_proxy")
  private Boolean mCanProxy = null;
  @SerializedName("code")
  private String mCode = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("data_use_setting")
  private String mDataUseSetting = null;
  @SerializedName("enable_automatic_matching")
  private Boolean mEnableAutomaticMatching = null;
  @SerializedName("first_party_cookie_status")
  private String mFirstPartyCookieStatus = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_created_by_business")
  private Boolean mIsCreatedByBusiness = null;
  @SerializedName("last_fired_time")
  private String mLastFiredTime = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner_ad_account")
  private AdAccount mOwnerAdAccount = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  protected static Gson gson = null;

  AdsPixel() {
  }

  public AdsPixel(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsPixel(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsPixel fetch() throws APIException{
    AdsPixel newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsPixel fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsPixel> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsPixel fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsPixel> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsPixel> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsPixel>)(
      new APIRequest<AdsPixel>(context, "", "/", "GET", AdsPixel.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsPixel>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsPixel.getParser())
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
  public static AdsPixel loadJSON(String json, APIContext context) {
    AdsPixel adsPixel = getGson().fromJson(json, AdsPixel.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsPixel.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsPixel.context = context;
    adsPixel.rawValue = json;
    return adsPixel;
  }

  public static APINodeList<AdsPixel> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdsPixel> adsPixels = new APINodeList<AdsPixel>(request, json);
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
          adsPixels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adsPixels;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsPixels.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsPixels.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsPixels.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsPixels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adsPixels.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsPixels.add(loadJSON(obj.toString(), context));
            }
          }
          return adsPixels;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsPixels.add(loadJSON(entry.getValue().toString(), context));
          }
          return adsPixels;
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
              adsPixels.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsPixels;
          }

          // Sixth, check if it's pure JsonObject
          adsPixels.clear();
          adsPixels.add(loadJSON(json, context));
          return adsPixels;
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

  public APIRequestCreateCreateServerToServerKey createCreateServerToServerKey() {
    return new APIRequestCreateCreateServerToServerKey(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDaChecks getDaChecks() {
    return new APIRequestGetDaChecks(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetExtractors getExtractors() {
    return new APIRequestGetExtractors(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateExtractor createExtractor() {
    return new APIRequestCreateExtractor(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPendingShareDAgencies getPendingShareDAgencies() {
    return new APIRequestGetPendingShareDAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateResetServerToServerKey createResetServerToServerKey() {
    return new APIRequestCreateResetServerToServerKey(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteShareDAccounts deleteShareDAccounts() {
    return new APIRequestDeleteShareDAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetShareDAccounts getShareDAccounts() {
    return new APIRequestGetShareDAccounts(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateShareDAccount createShareDAccount() {
    return new APIRequestCreateShareDAccount(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteShareDAgencies deleteShareDAgencies() {
    return new APIRequestDeleteShareDAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetShareDAgencies getShareDAgencies() {
    return new APIRequestGetShareDAgencies(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateShareDAgency createShareDAgency() {
    return new APIRequestCreateShareDAgency(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetStats getStats() {
    return new APIRequestGetStats(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public List<String> getFieldAutomaticMatchingFields() {
    return mAutomaticMatchingFields;
  }

  public Boolean getFieldCanProxy() {
    return mCanProxy;
  }

  public String getFieldCode() {
    return mCode;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public String getFieldDataUseSetting() {
    return mDataUseSetting;
  }

  public Boolean getFieldEnableAutomaticMatching() {
    return mEnableAutomaticMatching;
  }

  public String getFieldFirstPartyCookieStatus() {
    return mFirstPartyCookieStatus;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsCreatedByBusiness() {
    return mIsCreatedByBusiness;
  }

  public String getFieldLastFiredTime() {
    return mLastFiredTime;
  }

  public String getFieldName() {
    return mName;
  }

  public AdAccount getFieldOwnerAdAccount() {
    if (mOwnerAdAccount != null) {
      mOwnerAdAccount.context = getContext();
    }
    return mOwnerAdAccount;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }



  public static class APIRequestDeleteAssignedUsers extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteAssignedUsers.this.parseResponse(result);
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

    public APIRequestDeleteAssignedUsers setBusiness (String business) {
      this.setParam("business", business);
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
    public APINodeList<AssignedUser> parseResponse(String response) throws APIException {
      return AssignedUser.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AssignedUser> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AssignedUser> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AssignedUser>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AssignedUser>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AssignedUser>>() {
           public APINodeList<AssignedUser> apply(String result) {
             try {
               return APIRequestGetAssignedUsers.this.parseResponse(result);
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

  public static class APIRequestCreateAssignedUser extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
      "tasks",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixel>() {
           public AdsPixel apply(String result) {
             try {
               return APIRequestCreateAssignedUser.this.parseResponse(result);
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


    public APIRequestCreateAssignedUser setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestCreateAssignedUser setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateAssignedUser setTasks (List<AdsPixel.EnumTasks> tasks) {
      this.setParam("tasks", tasks);
      return this;
    }
    public APIRequestCreateAssignedUser setTasks (String tasks) {
      this.setParam("tasks", tasks);
      return this;
    }

    public APIRequestCreateAssignedUser setBusiness (String business) {
      this.setParam("business", business);
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

  public static class APIRequestGetAudiences extends APIRequest<CustomAudience> {

    APINodeList<CustomAudience> lastResponse = null;
    @Override
    public APINodeList<CustomAudience> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_account",
    };

    public static final String[] FIELDS = {
      "account_id",
      "approximate_count",
      "customer_file_source",
      "data_source",
      "data_source_types",
      "datafile_custom_audience_uploading_status",
      "delivery_status",
      "description",
      "excluded_custom_audiences",
      "expiry_time",
      "external_event_source",
      "household_audience",
      "id",
      "included_custom_audiences",
      "is_household",
      "is_snapshot",
      "is_value_based",
      "list_of_accounts",
      "lookalike_audience_ids",
      "lookalike_spec",
      "name",
      "operation_status",
      "opt_out_link",
      "permission_for_actions",
      "pixel_id",
      "retention_days",
      "rev_share_policy_id",
      "rule",
      "rule_aggregation",
      "rule_v2",
      "seed_audience",
      "sharing_status",
      "study_spec",
      "subtype",
      "time_content_updated",
      "time_created",
      "time_updated",
    };

    @Override
    public APINodeList<CustomAudience> parseResponse(String response) throws APIException {
      return CustomAudience.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<CustomAudience> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CustomAudience> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CustomAudience>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CustomAudience>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<CustomAudience>>() {
           public APINodeList<CustomAudience> apply(String result) {
             try {
               return APIRequestGetAudiences.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestGetAudiences setAdAccount (String adAccount) {
      this.setParam("ad_account", adAccount);
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

    public APIRequestGetAudiences requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAudiences requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAudiences requestApproximateCountField () {
      return this.requestApproximateCountField(true);
    }
    public APIRequestGetAudiences requestApproximateCountField (boolean value) {
      this.requestField("approximate_count", value);
      return this;
    }
    public APIRequestGetAudiences requestCustomerFileSourceField () {
      return this.requestCustomerFileSourceField(true);
    }
    public APIRequestGetAudiences requestCustomerFileSourceField (boolean value) {
      this.requestField("customer_file_source", value);
      return this;
    }
    public APIRequestGetAudiences requestDataSourceField () {
      return this.requestDataSourceField(true);
    }
    public APIRequestGetAudiences requestDataSourceField (boolean value) {
      this.requestField("data_source", value);
      return this;
    }
    public APIRequestGetAudiences requestDataSourceTypesField () {
      return this.requestDataSourceTypesField(true);
    }
    public APIRequestGetAudiences requestDataSourceTypesField (boolean value) {
      this.requestField("data_source_types", value);
      return this;
    }
    public APIRequestGetAudiences requestDatafileCustomAudienceUploadingStatusField () {
      return this.requestDatafileCustomAudienceUploadingStatusField(true);
    }
    public APIRequestGetAudiences requestDatafileCustomAudienceUploadingStatusField (boolean value) {
      this.requestField("datafile_custom_audience_uploading_status", value);
      return this;
    }
    public APIRequestGetAudiences requestDeliveryStatusField () {
      return this.requestDeliveryStatusField(true);
    }
    public APIRequestGetAudiences requestDeliveryStatusField (boolean value) {
      this.requestField("delivery_status", value);
      return this;
    }
    public APIRequestGetAudiences requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetAudiences requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetAudiences requestExcludedCustomAudiencesField () {
      return this.requestExcludedCustomAudiencesField(true);
    }
    public APIRequestGetAudiences requestExcludedCustomAudiencesField (boolean value) {
      this.requestField("excluded_custom_audiences", value);
      return this;
    }
    public APIRequestGetAudiences requestExpiryTimeField () {
      return this.requestExpiryTimeField(true);
    }
    public APIRequestGetAudiences requestExpiryTimeField (boolean value) {
      this.requestField("expiry_time", value);
      return this;
    }
    public APIRequestGetAudiences requestExternalEventSourceField () {
      return this.requestExternalEventSourceField(true);
    }
    public APIRequestGetAudiences requestExternalEventSourceField (boolean value) {
      this.requestField("external_event_source", value);
      return this;
    }
    public APIRequestGetAudiences requestHouseholdAudienceField () {
      return this.requestHouseholdAudienceField(true);
    }
    public APIRequestGetAudiences requestHouseholdAudienceField (boolean value) {
      this.requestField("household_audience", value);
      return this;
    }
    public APIRequestGetAudiences requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAudiences requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAudiences requestIncludedCustomAudiencesField () {
      return this.requestIncludedCustomAudiencesField(true);
    }
    public APIRequestGetAudiences requestIncludedCustomAudiencesField (boolean value) {
      this.requestField("included_custom_audiences", value);
      return this;
    }
    public APIRequestGetAudiences requestIsHouseholdField () {
      return this.requestIsHouseholdField(true);
    }
    public APIRequestGetAudiences requestIsHouseholdField (boolean value) {
      this.requestField("is_household", value);
      return this;
    }
    public APIRequestGetAudiences requestIsSnapshotField () {
      return this.requestIsSnapshotField(true);
    }
    public APIRequestGetAudiences requestIsSnapshotField (boolean value) {
      this.requestField("is_snapshot", value);
      return this;
    }
    public APIRequestGetAudiences requestIsValueBasedField () {
      return this.requestIsValueBasedField(true);
    }
    public APIRequestGetAudiences requestIsValueBasedField (boolean value) {
      this.requestField("is_value_based", value);
      return this;
    }
    public APIRequestGetAudiences requestListOfAccountsField () {
      return this.requestListOfAccountsField(true);
    }
    public APIRequestGetAudiences requestListOfAccountsField (boolean value) {
      this.requestField("list_of_accounts", value);
      return this;
    }
    public APIRequestGetAudiences requestLookalikeAudienceIdsField () {
      return this.requestLookalikeAudienceIdsField(true);
    }
    public APIRequestGetAudiences requestLookalikeAudienceIdsField (boolean value) {
      this.requestField("lookalike_audience_ids", value);
      return this;
    }
    public APIRequestGetAudiences requestLookalikeSpecField () {
      return this.requestLookalikeSpecField(true);
    }
    public APIRequestGetAudiences requestLookalikeSpecField (boolean value) {
      this.requestField("lookalike_spec", value);
      return this;
    }
    public APIRequestGetAudiences requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAudiences requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAudiences requestOperationStatusField () {
      return this.requestOperationStatusField(true);
    }
    public APIRequestGetAudiences requestOperationStatusField (boolean value) {
      this.requestField("operation_status", value);
      return this;
    }
    public APIRequestGetAudiences requestOptOutLinkField () {
      return this.requestOptOutLinkField(true);
    }
    public APIRequestGetAudiences requestOptOutLinkField (boolean value) {
      this.requestField("opt_out_link", value);
      return this;
    }
    public APIRequestGetAudiences requestPermissionForActionsField () {
      return this.requestPermissionForActionsField(true);
    }
    public APIRequestGetAudiences requestPermissionForActionsField (boolean value) {
      this.requestField("permission_for_actions", value);
      return this;
    }
    public APIRequestGetAudiences requestPixelIdField () {
      return this.requestPixelIdField(true);
    }
    public APIRequestGetAudiences requestPixelIdField (boolean value) {
      this.requestField("pixel_id", value);
      return this;
    }
    public APIRequestGetAudiences requestRetentionDaysField () {
      return this.requestRetentionDaysField(true);
    }
    public APIRequestGetAudiences requestRetentionDaysField (boolean value) {
      this.requestField("retention_days", value);
      return this;
    }
    public APIRequestGetAudiences requestRevSharePolicyIdField () {
      return this.requestRevSharePolicyIdField(true);
    }
    public APIRequestGetAudiences requestRevSharePolicyIdField (boolean value) {
      this.requestField("rev_share_policy_id", value);
      return this;
    }
    public APIRequestGetAudiences requestRuleField () {
      return this.requestRuleField(true);
    }
    public APIRequestGetAudiences requestRuleField (boolean value) {
      this.requestField("rule", value);
      return this;
    }
    public APIRequestGetAudiences requestRuleAggregationField () {
      return this.requestRuleAggregationField(true);
    }
    public APIRequestGetAudiences requestRuleAggregationField (boolean value) {
      this.requestField("rule_aggregation", value);
      return this;
    }
    public APIRequestGetAudiences requestRuleV2Field () {
      return this.requestRuleV2Field(true);
    }
    public APIRequestGetAudiences requestRuleV2Field (boolean value) {
      this.requestField("rule_v2", value);
      return this;
    }
    public APIRequestGetAudiences requestSeedAudienceField () {
      return this.requestSeedAudienceField(true);
    }
    public APIRequestGetAudiences requestSeedAudienceField (boolean value) {
      this.requestField("seed_audience", value);
      return this;
    }
    public APIRequestGetAudiences requestSharingStatusField () {
      return this.requestSharingStatusField(true);
    }
    public APIRequestGetAudiences requestSharingStatusField (boolean value) {
      this.requestField("sharing_status", value);
      return this;
    }
    public APIRequestGetAudiences requestStudySpecField () {
      return this.requestStudySpecField(true);
    }
    public APIRequestGetAudiences requestStudySpecField (boolean value) {
      this.requestField("study_spec", value);
      return this;
    }
    public APIRequestGetAudiences requestSubtypeField () {
      return this.requestSubtypeField(true);
    }
    public APIRequestGetAudiences requestSubtypeField (boolean value) {
      this.requestField("subtype", value);
      return this;
    }
    public APIRequestGetAudiences requestTimeContentUpdatedField () {
      return this.requestTimeContentUpdatedField(true);
    }
    public APIRequestGetAudiences requestTimeContentUpdatedField (boolean value) {
      this.requestField("time_content_updated", value);
      return this;
    }
    public APIRequestGetAudiences requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGetAudiences requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGetAudiences requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGetAudiences requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
      return this;
    }
  }

  public static class APIRequestCreateCreateServerToServerKey extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixel>() {
           public AdsPixel apply(String result) {
             try {
               return APIRequestCreateCreateServerToServerKey.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCreateServerToServerKey(String nodeId, APIContext context) {
      super(context, nodeId, "/create_server_to_server_keys", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCreateServerToServerKey setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCreateServerToServerKey setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCreateServerToServerKey requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCreateServerToServerKey requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCreateServerToServerKey requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCreateServerToServerKey requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCreateServerToServerKey requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCreateServerToServerKey requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetDaChecks extends APIRequest<DACheck> {

    APINodeList<DACheck> lastResponse = null;
    @Override
    public APINodeList<DACheck> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "checks",
    };

    public static final String[] FIELDS = {
      "action_uri",
      "description",
      "key",
      "result",
      "title",
      "user_message",
      "id",
    };

    @Override
    public APINodeList<DACheck> parseResponse(String response) throws APIException {
      return DACheck.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<DACheck> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DACheck> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DACheck>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DACheck>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<DACheck>>() {
           public APINodeList<DACheck> apply(String result) {
             try {
               return APIRequestGetDaChecks.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDaChecks(String nodeId, APIContext context) {
      super(context, nodeId, "/da_checks", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDaChecks setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDaChecks setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDaChecks setChecks (List<String> checks) {
      this.setParam("checks", checks);
      return this;
    }
    public APIRequestGetDaChecks setChecks (String checks) {
      this.setParam("checks", checks);
      return this;
    }

    public APIRequestGetDaChecks requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDaChecks requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDaChecks requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDaChecks requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDaChecks requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDaChecks requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetDaChecks requestActionUriField () {
      return this.requestActionUriField(true);
    }
    public APIRequestGetDaChecks requestActionUriField (boolean value) {
      this.requestField("action_uri", value);
      return this;
    }
    public APIRequestGetDaChecks requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGetDaChecks requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGetDaChecks requestKeyField () {
      return this.requestKeyField(true);
    }
    public APIRequestGetDaChecks requestKeyField (boolean value) {
      this.requestField("key", value);
      return this;
    }
    public APIRequestGetDaChecks requestResultField () {
      return this.requestResultField(true);
    }
    public APIRequestGetDaChecks requestResultField (boolean value) {
      this.requestField("result", value);
      return this;
    }
    public APIRequestGetDaChecks requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetDaChecks requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetDaChecks requestUserMessageField () {
      return this.requestUserMessageField(true);
    }
    public APIRequestGetDaChecks requestUserMessageField (boolean value) {
      this.requestField("user_message", value);
      return this;
    }
    public APIRequestGetDaChecks requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetDaChecks requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGetExtractors extends APIRequest<SignalsIWLExtractor> {

    APINodeList<SignalsIWLExtractor> lastResponse = null;
    @Override
    public APINodeList<SignalsIWLExtractor> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "current_domain",
    };

    public static final String[] FIELDS = {
      "domain_uri",
      "event_type",
      "extractor_config",
      "extractor_type",
      "id",
    };

    @Override
    public APINodeList<SignalsIWLExtractor> parseResponse(String response) throws APIException {
      return SignalsIWLExtractor.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<SignalsIWLExtractor> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<SignalsIWLExtractor> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<SignalsIWLExtractor>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<SignalsIWLExtractor>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<SignalsIWLExtractor>>() {
           public APINodeList<SignalsIWLExtractor> apply(String result) {
             try {
               return APIRequestGetExtractors.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetExtractors(String nodeId, APIContext context) {
      super(context, nodeId, "/extractors", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetExtractors setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetExtractors setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetExtractors setCurrentDomain (Object currentDomain) {
      this.setParam("current_domain", currentDomain);
      return this;
    }
    public APIRequestGetExtractors setCurrentDomain (String currentDomain) {
      this.setParam("current_domain", currentDomain);
      return this;
    }

    public APIRequestGetExtractors requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetExtractors requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtractors requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetExtractors requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetExtractors requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetExtractors requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetExtractors requestDomainUriField () {
      return this.requestDomainUriField(true);
    }
    public APIRequestGetExtractors requestDomainUriField (boolean value) {
      this.requestField("domain_uri", value);
      return this;
    }
    public APIRequestGetExtractors requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGetExtractors requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGetExtractors requestExtractorConfigField () {
      return this.requestExtractorConfigField(true);
    }
    public APIRequestGetExtractors requestExtractorConfigField (boolean value) {
      this.requestField("extractor_config", value);
      return this;
    }
    public APIRequestGetExtractors requestExtractorTypeField () {
      return this.requestExtractorTypeField(true);
    }
    public APIRequestGetExtractors requestExtractorTypeField (boolean value) {
      this.requestField("extractor_type", value);
      return this;
    }
    public APIRequestGetExtractors requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetExtractors requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateExtractor extends APIRequest<SignalsIWLExtractor> {

    SignalsIWLExtractor lastResponse = null;
    @Override
    public SignalsIWLExtractor getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "domain_uri",
      "event_type",
      "extractor_config",
      "extractor_type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public SignalsIWLExtractor parseResponse(String response) throws APIException {
      return SignalsIWLExtractor.parseResponse(response, getContext(), this).head();
    }

    @Override
    public SignalsIWLExtractor execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SignalsIWLExtractor execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<SignalsIWLExtractor> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SignalsIWLExtractor> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, SignalsIWLExtractor>() {
           public SignalsIWLExtractor apply(String result) {
             try {
               return APIRequestCreateExtractor.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateExtractor(String nodeId, APIContext context) {
      super(context, nodeId, "/extractors", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateExtractor setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateExtractor setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateExtractor setDomainUri (Object domainUri) {
      this.setParam("domain_uri", domainUri);
      return this;
    }
    public APIRequestCreateExtractor setDomainUri (String domainUri) {
      this.setParam("domain_uri", domainUri);
      return this;
    }

    public APIRequestCreateExtractor setEventType (SignalsIWLExtractor.EnumEventType eventType) {
      this.setParam("event_type", eventType);
      return this;
    }
    public APIRequestCreateExtractor setEventType (String eventType) {
      this.setParam("event_type", eventType);
      return this;
    }

    public APIRequestCreateExtractor setExtractorConfig (Map<String, String> extractorConfig) {
      this.setParam("extractor_config", extractorConfig);
      return this;
    }
    public APIRequestCreateExtractor setExtractorConfig (String extractorConfig) {
      this.setParam("extractor_config", extractorConfig);
      return this;
    }

    public APIRequestCreateExtractor setExtractorType (SignalsIWLExtractor.EnumExtractorType extractorType) {
      this.setParam("extractor_type", extractorType);
      return this;
    }
    public APIRequestCreateExtractor setExtractorType (String extractorType) {
      this.setParam("extractor_type", extractorType);
      return this;
    }

    public APIRequestCreateExtractor requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateExtractor requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExtractor requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateExtractor requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateExtractor requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateExtractor requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPendingShareDAgencies extends APIRequest<Business> {

    APINodeList<Business> lastResponse = null;
    @Override
    public APINodeList<Business> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "block_offline_analytics",
      "created_by",
      "created_time",
      "extended_updated_time",
      "id",
      "is_hidden",
      "is_instagram_enabled_in_fb_analytics",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
      "verification_status",
      "vertical",
      "vertical_id",
    };

    @Override
    public APINodeList<Business> parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Business> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Business>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Business>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Business>>() {
           public APINodeList<Business> apply(String result) {
             try {
               return APIRequestGetPendingShareDAgencies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetPendingShareDAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/pending_shared_agencies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPendingShareDAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPendingShareDAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPendingShareDAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPendingShareDAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingShareDAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPendingShareDAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPendingShareDAgencies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPendingShareDAgencies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPendingShareDAgencies requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetPendingShareDAgencies requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetPendingShareDAgencies requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPendingShareDAgencies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGetPendingShareDAgencies requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPendingShareDAgencies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetPendingShareDAgencies requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestIsInstagramEnabledInFbAnalyticsField () {
      return this.requestIsInstagramEnabledInFbAnalyticsField(true);
    }
    public APIRequestGetPendingShareDAgencies requestIsInstagramEnabledInFbAnalyticsField (boolean value) {
      this.requestField("is_instagram_enabled_in_fb_analytics", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetPendingShareDAgencies requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPendingShareDAgencies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetPendingShareDAgencies requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetPendingShareDAgencies requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetPendingShareDAgencies requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetPendingShareDAgencies requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetPendingShareDAgencies requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPendingShareDAgencies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetPendingShareDAgencies requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetPendingShareDAgencies requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGetPendingShareDAgencies requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGetPendingShareDAgencies requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
      return this;
    }
  }

  public static class APIRequestCreateResetServerToServerKey extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixel>() {
           public AdsPixel apply(String result) {
             try {
               return APIRequestCreateResetServerToServerKey.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateResetServerToServerKey(String nodeId, APIContext context) {
      super(context, nodeId, "/reset_server_to_server_key", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateResetServerToServerKey setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateResetServerToServerKey setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateResetServerToServerKey setType (AdsPixel.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestCreateResetServerToServerKey setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateResetServerToServerKey requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateResetServerToServerKey requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateResetServerToServerKey requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateResetServerToServerKey requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateResetServerToServerKey requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateResetServerToServerKey requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteShareDAccounts extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteShareDAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteShareDAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_accounts", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteShareDAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteShareDAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteShareDAccounts setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestDeleteShareDAccounts setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestDeleteShareDAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteShareDAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteShareDAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteShareDAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteShareDAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteShareDAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetShareDAccounts extends APIRequest<AdAccount> {

    APINodeList<AdAccount> lastResponse = null;
    @Override
    public APINodeList<AdAccount> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "business",
    };

    public static final String[] FIELDS = {
      "account_id",
      "account_status",
      "ad_account_creation_request",
      "ad_account_promotable_objects",
      "age",
      "agency_client_declaration",
      "amount_spent",
      "attribution_spec",
      "balance",
      "business",
      "business_city",
      "business_country_code",
      "business_name",
      "business_state",
      "business_street",
      "business_street2",
      "business_zip",
      "capabilities",
      "created_time",
      "currency",
      "daily_spend_limit",
      "direct_deals_tos_accepted",
      "disable_reason",
      "end_advertiser",
      "end_advertiser_name",
      "extended_credit_invoice_group",
      "failed_delivery_checks",
      "funding_source",
      "funding_source_details",
      "has_migrated_permissions",
      "has_page_authorized_adaccount",
      "id",
      "io_number",
      "is_attribution_spec_system_default",
      "is_direct_deals_enabled",
      "is_in_3ds_authorization_enabled_market",
      "is_in_middle_of_local_entity_migration",
      "is_notifications_enabled",
      "is_personal",
      "is_prepay_account",
      "is_tax_id_required",
      "line_numbers",
      "media_agency",
      "min_campaign_group_spend_cap",
      "min_daily_budget",
      "name",
      "offsite_pixels_tos_accepted",
      "owner",
      "partner",
      "rate_limit_reset_time",
      "rf_spec",
      "show_checkout_experience",
      "spend_cap",
      "tax_id",
      "tax_id_status",
      "tax_id_type",
      "timezone_id",
      "timezone_name",
      "timezone_offset_hours_utc",
      "tos_accepted",
      "user_role",
      "user_tos_accepted",
    };

    @Override
    public APINodeList<AdAccount> parseResponse(String response) throws APIException {
      return AdAccount.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdAccount> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdAccount> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdAccount>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdAccount>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdAccount>>() {
           public APINodeList<AdAccount> apply(String result) {
             try {
               return APIRequestGetShareDAccounts.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetShareDAccounts(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_accounts", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetShareDAccounts setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetShareDAccounts setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetShareDAccounts setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestGetShareDAccounts requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetShareDAccounts requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShareDAccounts requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetShareDAccounts requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShareDAccounts requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetShareDAccounts requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetShareDAccounts requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetShareDAccounts requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestAccountStatusField () {
      return this.requestAccountStatusField(true);
    }
    public APIRequestGetShareDAccounts requestAccountStatusField (boolean value) {
      this.requestField("account_status", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestAdAccountCreationRequestField () {
      return this.requestAdAccountCreationRequestField(true);
    }
    public APIRequestGetShareDAccounts requestAdAccountCreationRequestField (boolean value) {
      this.requestField("ad_account_creation_request", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestAdAccountPromotableObjectsField () {
      return this.requestAdAccountPromotableObjectsField(true);
    }
    public APIRequestGetShareDAccounts requestAdAccountPromotableObjectsField (boolean value) {
      this.requestField("ad_account_promotable_objects", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetShareDAccounts requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestAgencyClientDeclarationField () {
      return this.requestAgencyClientDeclarationField(true);
    }
    public APIRequestGetShareDAccounts requestAgencyClientDeclarationField (boolean value) {
      this.requestField("agency_client_declaration", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestAmountSpentField () {
      return this.requestAmountSpentField(true);
    }
    public APIRequestGetShareDAccounts requestAmountSpentField (boolean value) {
      this.requestField("amount_spent", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetShareDAccounts requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestBalanceField () {
      return this.requestBalanceField(true);
    }
    public APIRequestGetShareDAccounts requestBalanceField (boolean value) {
      this.requestField("balance", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetShareDAccounts requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestBusinessCityField () {
      return this.requestBusinessCityField(true);
    }
    public APIRequestGetShareDAccounts requestBusinessCityField (boolean value) {
      this.requestField("business_city", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestBusinessCountryCodeField () {
      return this.requestBusinessCountryCodeField(true);
    }
    public APIRequestGetShareDAccounts requestBusinessCountryCodeField (boolean value) {
      this.requestField("business_country_code", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestBusinessNameField () {
      return this.requestBusinessNameField(true);
    }
    public APIRequestGetShareDAccounts requestBusinessNameField (boolean value) {
      this.requestField("business_name", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestBusinessStateField () {
      return this.requestBusinessStateField(true);
    }
    public APIRequestGetShareDAccounts requestBusinessStateField (boolean value) {
      this.requestField("business_state", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestBusinessStreetField () {
      return this.requestBusinessStreetField(true);
    }
    public APIRequestGetShareDAccounts requestBusinessStreetField (boolean value) {
      this.requestField("business_street", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestBusinessStreet2Field () {
      return this.requestBusinessStreet2Field(true);
    }
    public APIRequestGetShareDAccounts requestBusinessStreet2Field (boolean value) {
      this.requestField("business_street2", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestBusinessZipField () {
      return this.requestBusinessZipField(true);
    }
    public APIRequestGetShareDAccounts requestBusinessZipField (boolean value) {
      this.requestField("business_zip", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestCapabilitiesField () {
      return this.requestCapabilitiesField(true);
    }
    public APIRequestGetShareDAccounts requestCapabilitiesField (boolean value) {
      this.requestField("capabilities", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetShareDAccounts requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetShareDAccounts requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestDailySpendLimitField () {
      return this.requestDailySpendLimitField(true);
    }
    public APIRequestGetShareDAccounts requestDailySpendLimitField (boolean value) {
      this.requestField("daily_spend_limit", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestDirectDealsTosAcceptedField () {
      return this.requestDirectDealsTosAcceptedField(true);
    }
    public APIRequestGetShareDAccounts requestDirectDealsTosAcceptedField (boolean value) {
      this.requestField("direct_deals_tos_accepted", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestDisableReasonField () {
      return this.requestDisableReasonField(true);
    }
    public APIRequestGetShareDAccounts requestDisableReasonField (boolean value) {
      this.requestField("disable_reason", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestEndAdvertiserField () {
      return this.requestEndAdvertiserField(true);
    }
    public APIRequestGetShareDAccounts requestEndAdvertiserField (boolean value) {
      this.requestField("end_advertiser", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestEndAdvertiserNameField () {
      return this.requestEndAdvertiserNameField(true);
    }
    public APIRequestGetShareDAccounts requestEndAdvertiserNameField (boolean value) {
      this.requestField("end_advertiser_name", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestExtendedCreditInvoiceGroupField () {
      return this.requestExtendedCreditInvoiceGroupField(true);
    }
    public APIRequestGetShareDAccounts requestExtendedCreditInvoiceGroupField (boolean value) {
      this.requestField("extended_credit_invoice_group", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestFailedDeliveryChecksField () {
      return this.requestFailedDeliveryChecksField(true);
    }
    public APIRequestGetShareDAccounts requestFailedDeliveryChecksField (boolean value) {
      this.requestField("failed_delivery_checks", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestFundingSourceField () {
      return this.requestFundingSourceField(true);
    }
    public APIRequestGetShareDAccounts requestFundingSourceField (boolean value) {
      this.requestField("funding_source", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestFundingSourceDetailsField () {
      return this.requestFundingSourceDetailsField(true);
    }
    public APIRequestGetShareDAccounts requestFundingSourceDetailsField (boolean value) {
      this.requestField("funding_source_details", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestHasMigratedPermissionsField () {
      return this.requestHasMigratedPermissionsField(true);
    }
    public APIRequestGetShareDAccounts requestHasMigratedPermissionsField (boolean value) {
      this.requestField("has_migrated_permissions", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestHasPageAuthorizedAdaccountField () {
      return this.requestHasPageAuthorizedAdaccountField(true);
    }
    public APIRequestGetShareDAccounts requestHasPageAuthorizedAdaccountField (boolean value) {
      this.requestField("has_page_authorized_adaccount", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetShareDAccounts requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGetShareDAccounts requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIsAttributionSpecSystemDefaultField () {
      return this.requestIsAttributionSpecSystemDefaultField(true);
    }
    public APIRequestGetShareDAccounts requestIsAttributionSpecSystemDefaultField (boolean value) {
      this.requestField("is_attribution_spec_system_default", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIsDirectDealsEnabledField () {
      return this.requestIsDirectDealsEnabledField(true);
    }
    public APIRequestGetShareDAccounts requestIsDirectDealsEnabledField (boolean value) {
      this.requestField("is_direct_deals_enabled", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIsIn3dsAuthorizationEnabledMarketField () {
      return this.requestIsIn3dsAuthorizationEnabledMarketField(true);
    }
    public APIRequestGetShareDAccounts requestIsIn3dsAuthorizationEnabledMarketField (boolean value) {
      this.requestField("is_in_3ds_authorization_enabled_market", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIsInMiddleOfLocalEntityMigrationField () {
      return this.requestIsInMiddleOfLocalEntityMigrationField(true);
    }
    public APIRequestGetShareDAccounts requestIsInMiddleOfLocalEntityMigrationField (boolean value) {
      this.requestField("is_in_middle_of_local_entity_migration", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIsNotificationsEnabledField () {
      return this.requestIsNotificationsEnabledField(true);
    }
    public APIRequestGetShareDAccounts requestIsNotificationsEnabledField (boolean value) {
      this.requestField("is_notifications_enabled", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIsPersonalField () {
      return this.requestIsPersonalField(true);
    }
    public APIRequestGetShareDAccounts requestIsPersonalField (boolean value) {
      this.requestField("is_personal", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIsPrepayAccountField () {
      return this.requestIsPrepayAccountField(true);
    }
    public APIRequestGetShareDAccounts requestIsPrepayAccountField (boolean value) {
      this.requestField("is_prepay_account", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestIsTaxIdRequiredField () {
      return this.requestIsTaxIdRequiredField(true);
    }
    public APIRequestGetShareDAccounts requestIsTaxIdRequiredField (boolean value) {
      this.requestField("is_tax_id_required", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestLineNumbersField () {
      return this.requestLineNumbersField(true);
    }
    public APIRequestGetShareDAccounts requestLineNumbersField (boolean value) {
      this.requestField("line_numbers", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestMediaAgencyField () {
      return this.requestMediaAgencyField(true);
    }
    public APIRequestGetShareDAccounts requestMediaAgencyField (boolean value) {
      this.requestField("media_agency", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestMinCampaignGroupSpendCapField () {
      return this.requestMinCampaignGroupSpendCapField(true);
    }
    public APIRequestGetShareDAccounts requestMinCampaignGroupSpendCapField (boolean value) {
      this.requestField("min_campaign_group_spend_cap", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestMinDailyBudgetField () {
      return this.requestMinDailyBudgetField(true);
    }
    public APIRequestGetShareDAccounts requestMinDailyBudgetField (boolean value) {
      this.requestField("min_daily_budget", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetShareDAccounts requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestOffsitePixelsTosAcceptedField () {
      return this.requestOffsitePixelsTosAcceptedField(true);
    }
    public APIRequestGetShareDAccounts requestOffsitePixelsTosAcceptedField (boolean value) {
      this.requestField("offsite_pixels_tos_accepted", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGetShareDAccounts requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestPartnerField () {
      return this.requestPartnerField(true);
    }
    public APIRequestGetShareDAccounts requestPartnerField (boolean value) {
      this.requestField("partner", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestRateLimitResetTimeField () {
      return this.requestRateLimitResetTimeField(true);
    }
    public APIRequestGetShareDAccounts requestRateLimitResetTimeField (boolean value) {
      this.requestField("rate_limit_reset_time", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestRfSpecField () {
      return this.requestRfSpecField(true);
    }
    public APIRequestGetShareDAccounts requestRfSpecField (boolean value) {
      this.requestField("rf_spec", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestShowCheckoutExperienceField () {
      return this.requestShowCheckoutExperienceField(true);
    }
    public APIRequestGetShareDAccounts requestShowCheckoutExperienceField (boolean value) {
      this.requestField("show_checkout_experience", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetShareDAccounts requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestTaxIdField () {
      return this.requestTaxIdField(true);
    }
    public APIRequestGetShareDAccounts requestTaxIdField (boolean value) {
      this.requestField("tax_id", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestTaxIdStatusField () {
      return this.requestTaxIdStatusField(true);
    }
    public APIRequestGetShareDAccounts requestTaxIdStatusField (boolean value) {
      this.requestField("tax_id_status", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestTaxIdTypeField () {
      return this.requestTaxIdTypeField(true);
    }
    public APIRequestGetShareDAccounts requestTaxIdTypeField (boolean value) {
      this.requestField("tax_id_type", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetShareDAccounts requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestTimezoneNameField () {
      return this.requestTimezoneNameField(true);
    }
    public APIRequestGetShareDAccounts requestTimezoneNameField (boolean value) {
      this.requestField("timezone_name", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestTimezoneOffsetHoursUtcField () {
      return this.requestTimezoneOffsetHoursUtcField(true);
    }
    public APIRequestGetShareDAccounts requestTimezoneOffsetHoursUtcField (boolean value) {
      this.requestField("timezone_offset_hours_utc", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestTosAcceptedField () {
      return this.requestTosAcceptedField(true);
    }
    public APIRequestGetShareDAccounts requestTosAcceptedField (boolean value) {
      this.requestField("tos_accepted", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestUserRoleField () {
      return this.requestUserRoleField(true);
    }
    public APIRequestGetShareDAccounts requestUserRoleField (boolean value) {
      this.requestField("user_role", value);
      return this;
    }
    public APIRequestGetShareDAccounts requestUserTosAcceptedField () {
      return this.requestUserTosAcceptedField(true);
    }
    public APIRequestGetShareDAccounts requestUserTosAcceptedField (boolean value) {
      this.requestField("user_tos_accepted", value);
      return this;
    }
  }

  public static class APIRequestCreateShareDAccount extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixel>() {
           public AdsPixel apply(String result) {
             try {
               return APIRequestCreateShareDAccount.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateShareDAccount(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_accounts", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateShareDAccount setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateShareDAccount setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateShareDAccount setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestCreateShareDAccount setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestCreateShareDAccount requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateShareDAccount requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateShareDAccount requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateShareDAccount requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateShareDAccount requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateShareDAccount requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteShareDAgencies extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "agency_id",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteShareDAgencies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteShareDAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_agencies", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteShareDAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteShareDAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteShareDAgencies setAgencyId (String agencyId) {
      this.setParam("agency_id", agencyId);
      return this;
    }

    public APIRequestDeleteShareDAgencies setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestDeleteShareDAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteShareDAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteShareDAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteShareDAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteShareDAgencies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteShareDAgencies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetShareDAgencies extends APIRequest<Business> {

    APINodeList<Business> lastResponse = null;
    @Override
    public APINodeList<Business> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "block_offline_analytics",
      "created_by",
      "created_time",
      "extended_updated_time",
      "id",
      "is_hidden",
      "is_instagram_enabled_in_fb_analytics",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
      "verification_status",
      "vertical",
      "vertical_id",
    };

    @Override
    public APINodeList<Business> parseResponse(String response) throws APIException {
      return Business.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Business> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Business>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Business>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<Business>>() {
           public APINodeList<Business> apply(String result) {
             try {
               return APIRequestGetShareDAgencies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetShareDAgencies(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_agencies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetShareDAgencies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetShareDAgencies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetShareDAgencies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetShareDAgencies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShareDAgencies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetShareDAgencies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetShareDAgencies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetShareDAgencies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetShareDAgencies requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetShareDAgencies requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetShareDAgencies requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetShareDAgencies requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGetShareDAgencies requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetShareDAgencies requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetShareDAgencies requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestIsInstagramEnabledInFbAnalyticsField () {
      return this.requestIsInstagramEnabledInFbAnalyticsField(true);
    }
    public APIRequestGetShareDAgencies requestIsInstagramEnabledInFbAnalyticsField (boolean value) {
      this.requestField("is_instagram_enabled_in_fb_analytics", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetShareDAgencies requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetShareDAgencies requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetShareDAgencies requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetShareDAgencies requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetShareDAgencies requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetShareDAgencies requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetShareDAgencies requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetShareDAgencies requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetShareDAgencies requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetShareDAgencies requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGetShareDAgencies requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGetShareDAgencies requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
      return this;
    }
  }

  public static class APIRequestCreateShareDAgency extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "agency_id",
      "business",
      "relationship_type",
      "other_relationship",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixel>() {
           public AdsPixel apply(String result) {
             try {
               return APIRequestCreateShareDAgency.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateShareDAgency(String nodeId, APIContext context) {
      super(context, nodeId, "/shared_agencies", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateShareDAgency setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateShareDAgency setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateShareDAgency setAgencyId (String agencyId) {
      this.setParam("agency_id", agencyId);
      return this;
    }

    public APIRequestCreateShareDAgency setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestCreateShareDAgency setRelationshipType (List<AdsPixel.EnumRelationshipType> relationshipType) {
      this.setParam("relationship_type", relationshipType);
      return this;
    }
    public APIRequestCreateShareDAgency setRelationshipType (String relationshipType) {
      this.setParam("relationship_type", relationshipType);
      return this;
    }

    public APIRequestCreateShareDAgency setOtherRelationship (String otherRelationship) {
      this.setParam("other_relationship", otherRelationship);
      return this;
    }

    public APIRequestCreateShareDAgency requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateShareDAgency requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateShareDAgency requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateShareDAgency requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateShareDAgency requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateShareDAgency requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetStats extends APIRequest<AdsPixelStatsResult> {

    APINodeList<AdsPixelStatsResult> lastResponse = null;
    @Override
    public APINodeList<AdsPixelStatsResult> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "start_time",
      "end_time",
      "aggregation",
      "event",
    };

    public static final String[] FIELDS = {
      "aggregation",
      "data",
      "start_time",
      "id",
    };

    @Override
    public APINodeList<AdsPixelStatsResult> parseResponse(String response) throws APIException {
      return AdsPixelStatsResult.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsPixelStatsResult> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsPixelStatsResult> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsPixelStatsResult>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsPixelStatsResult>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsPixelStatsResult>>() {
           public APINodeList<AdsPixelStatsResult> apply(String result) {
             try {
               return APIRequestGetStats.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetStats(String nodeId, APIContext context) {
      super(context, nodeId, "/stats", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetStats setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetStats setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetStats setStartTime (Object startTime) {
      this.setParam("start_time", startTime);
      return this;
    }
    public APIRequestGetStats setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestGetStats setEndTime (Object endTime) {
      this.setParam("end_time", endTime);
      return this;
    }
    public APIRequestGetStats setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestGetStats setAggregation (AdsPixelStatsResult.EnumAggregation aggregation) {
      this.setParam("aggregation", aggregation);
      return this;
    }
    public APIRequestGetStats setAggregation (String aggregation) {
      this.setParam("aggregation", aggregation);
      return this;
    }

    public APIRequestGetStats setEvent (String event) {
      this.setParam("event", event);
      return this;
    }

    public APIRequestGetStats requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetStats requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStats requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetStats requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetStats requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetStats requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetStats requestAggregationField () {
      return this.requestAggregationField(true);
    }
    public APIRequestGetStats requestAggregationField (boolean value) {
      this.requestField("aggregation", value);
      return this;
    }
    public APIRequestGetStats requestDataField () {
      return this.requestDataField(true);
    }
    public APIRequestGetStats requestDataField (boolean value) {
      this.requestField("data", value);
      return this;
    }
    public APIRequestGetStats requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetStats requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetStats requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetStats requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "automatic_matching_fields",
      "can_proxy",
      "code",
      "creation_time",
      "creator",
      "data_use_setting",
      "enable_automatic_matching",
      "first_party_cookie_status",
      "id",
      "is_created_by_business",
      "last_fired_time",
      "name",
      "owner_ad_account",
      "owner_business",
    };

    @Override
    public AdsPixel parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixel>() {
           public AdsPixel apply(String result) {
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

    public APIRequestGet requestAutomaticMatchingFieldsField () {
      return this.requestAutomaticMatchingFieldsField(true);
    }
    public APIRequestGet requestAutomaticMatchingFieldsField (boolean value) {
      this.requestField("automatic_matching_fields", value);
      return this;
    }
    public APIRequestGet requestCanProxyField () {
      return this.requestCanProxyField(true);
    }
    public APIRequestGet requestCanProxyField (boolean value) {
      this.requestField("can_proxy", value);
      return this;
    }
    public APIRequestGet requestCodeField () {
      return this.requestCodeField(true);
    }
    public APIRequestGet requestCodeField (boolean value) {
      this.requestField("code", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestDataUseSettingField () {
      return this.requestDataUseSettingField(true);
    }
    public APIRequestGet requestDataUseSettingField (boolean value) {
      this.requestField("data_use_setting", value);
      return this;
    }
    public APIRequestGet requestEnableAutomaticMatchingField () {
      return this.requestEnableAutomaticMatchingField(true);
    }
    public APIRequestGet requestEnableAutomaticMatchingField (boolean value) {
      this.requestField("enable_automatic_matching", value);
      return this;
    }
    public APIRequestGet requestFirstPartyCookieStatusField () {
      return this.requestFirstPartyCookieStatusField(true);
    }
    public APIRequestGet requestFirstPartyCookieStatusField (boolean value) {
      this.requestField("first_party_cookie_status", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsCreatedByBusinessField () {
      return this.requestIsCreatedByBusinessField(true);
    }
    public APIRequestGet requestIsCreatedByBusinessField (boolean value) {
      this.requestField("is_created_by_business", value);
      return this;
    }
    public APIRequestGet requestLastFiredTimeField () {
      return this.requestLastFiredTimeField(true);
    }
    public APIRequestGet requestLastFiredTimeField (boolean value) {
      this.requestField("last_fired_time", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOwnerAdAccountField () {
      return this.requestOwnerAdAccountField(true);
    }
    public APIRequestGet requestOwnerAdAccountField (boolean value) {
      this.requestField("owner_ad_account", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdsPixel> {

    AdsPixel lastResponse = null;
    @Override
    public AdsPixel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
      "enable_automatic_matching",
      "automatic_matching_fields",
      "first_party_cookie_status",
      "data_use_setting",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdsPixel parseResponse(String response) throws APIException {
      return AdsPixel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixel> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixel> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixel>() {
           public AdsPixel apply(String result) {
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


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setEnableAutomaticMatching (Boolean enableAutomaticMatching) {
      this.setParam("enable_automatic_matching", enableAutomaticMatching);
      return this;
    }
    public APIRequestUpdate setEnableAutomaticMatching (String enableAutomaticMatching) {
      this.setParam("enable_automatic_matching", enableAutomaticMatching);
      return this;
    }

    public APIRequestUpdate setAutomaticMatchingFields (List<AdsPixel.EnumAutomaticMatchingFields> automaticMatchingFields) {
      this.setParam("automatic_matching_fields", automaticMatchingFields);
      return this;
    }
    public APIRequestUpdate setAutomaticMatchingFields (String automaticMatchingFields) {
      this.setParam("automatic_matching_fields", automaticMatchingFields);
      return this;
    }

    public APIRequestUpdate setFirstPartyCookieStatus (AdsPixel.EnumFirstPartyCookieStatus firstPartyCookieStatus) {
      this.setParam("first_party_cookie_status", firstPartyCookieStatus);
      return this;
    }
    public APIRequestUpdate setFirstPartyCookieStatus (String firstPartyCookieStatus) {
      this.setParam("first_party_cookie_status", firstPartyCookieStatus);
      return this;
    }

    public APIRequestUpdate setDataUseSetting (AdsPixel.EnumDataUseSetting dataUseSetting) {
      this.setParam("data_use_setting", dataUseSetting);
      return this;
    }
    public APIRequestUpdate setDataUseSetting (String dataUseSetting) {
      this.setParam("data_use_setting", dataUseSetting);
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

  public static enum EnumSortBy {
      @SerializedName("LAST_FIRED_TIME")
      VALUE_LAST_FIRED_TIME("LAST_FIRED_TIME"),
      @SerializedName("NAME")
      VALUE_NAME("NAME"),
      NULL(null);

      private String value;

      private EnumSortBy(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumAutomaticMatchingFields {
      @SerializedName("em")
      VALUE_EM("em"),
      @SerializedName("fn")
      VALUE_FN("fn"),
      @SerializedName("ln")
      VALUE_LN("ln"),
      @SerializedName("ph")
      VALUE_PH("ph"),
      @SerializedName("ge")
      VALUE_GE("ge"),
      @SerializedName("zp")
      VALUE_ZP("zp"),
      @SerializedName("ct")
      VALUE_CT("ct"),
      @SerializedName("st")
      VALUE_ST("st"),
      NULL(null);

      private String value;

      private EnumAutomaticMatchingFields(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDataUseSetting {
      @SerializedName("EMPTY")
      VALUE_EMPTY("EMPTY"),
      @SerializedName("ADVERTISING_AND_ANALYTICS")
      VALUE_ADVERTISING_AND_ANALYTICS("ADVERTISING_AND_ANALYTICS"),
      @SerializedName("ANALYTICS_ONLY")
      VALUE_ANALYTICS_ONLY("ANALYTICS_ONLY"),
      NULL(null);

      private String value;

      private EnumDataUseSetting(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFirstPartyCookieStatus {
      @SerializedName("EMPTY")
      VALUE_EMPTY("EMPTY"),
      @SerializedName("FIRST_PARTY_COOKIE_ENABLED")
      VALUE_FIRST_PARTY_COOKIE_ENABLED("FIRST_PARTY_COOKIE_ENABLED"),
      @SerializedName("FIRST_PARTY_COOKIE_DISABLED")
      VALUE_FIRST_PARTY_COOKIE_DISABLED("FIRST_PARTY_COOKIE_DISABLED"),
      NULL(null);

      private String value;

      private EnumFirstPartyCookieStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTasks {
      @SerializedName("EDIT")
      VALUE_EDIT("EDIT"),
      @SerializedName("ANALYZE")
      VALUE_ANALYZE("ANALYZE"),
      NULL(null);

      private String value;

      private EnumTasks(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("PRIMARY")
      VALUE_PRIMARY("PRIMARY"),
      @SerializedName("SECONDARY")
      VALUE_SECONDARY("SECONDARY"),
      NULL(null);

      private String value;

      private EnumType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRelationshipType {
      @SerializedName("AD_MANAGER")
      VALUE_AD_MANAGER("AD_MANAGER"),
      @SerializedName("AUDIENCE_MANAGER")
      VALUE_AUDIENCE_MANAGER("AUDIENCE_MANAGER"),
      @SerializedName("AGENCY")
      VALUE_AGENCY("AGENCY"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      NULL(null);

      private String value;

      private EnumRelationshipType(String value) {
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

  public AdsPixel copyFrom(AdsPixel instance) {
    this.mAutomaticMatchingFields = instance.mAutomaticMatchingFields;
    this.mCanProxy = instance.mCanProxy;
    this.mCode = instance.mCode;
    this.mCreationTime = instance.mCreationTime;
    this.mCreator = instance.mCreator;
    this.mDataUseSetting = instance.mDataUseSetting;
    this.mEnableAutomaticMatching = instance.mEnableAutomaticMatching;
    this.mFirstPartyCookieStatus = instance.mFirstPartyCookieStatus;
    this.mId = instance.mId;
    this.mIsCreatedByBusiness = instance.mIsCreatedByBusiness;
    this.mLastFiredTime = instance.mLastFiredTime;
    this.mName = instance.mName;
    this.mOwnerAdAccount = instance.mOwnerAdAccount;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsPixel> getParser() {
    return new APIRequest.ResponseParser<AdsPixel>() {
      public APINodeList<AdsPixel> parseResponse(String response, APIContext context, APIRequest<AdsPixel> request) throws MalformedResponseException {
        return AdsPixel.parseResponse(response, context, request);
      }
    };
  }
}
