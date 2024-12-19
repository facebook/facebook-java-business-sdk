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
public class FranchiseProgramMember extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("end_date")
  private String mEndDate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("join_date")
  private String mJoinDate = null;
  @SerializedName("member_ad_account")
  private AdAccount mMemberAdAccount = null;
  @SerializedName("member_user")
  private User mMemberUser = null;
  @SerializedName("membership_status")
  private String mMembershipStatus = null;
  @SerializedName("page")
  private Page mPage = null;
  protected static Gson gson = null;

  FranchiseProgramMember() {
  }

  public FranchiseProgramMember(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public FranchiseProgramMember(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public FranchiseProgramMember fetch() throws APIException{
    FranchiseProgramMember newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static FranchiseProgramMember fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<FranchiseProgramMember> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static FranchiseProgramMember fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<FranchiseProgramMember> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<FranchiseProgramMember> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<FranchiseProgramMember>)(
      new APIRequest<FranchiseProgramMember>(context, "", "/", "GET", FranchiseProgramMember.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<FranchiseProgramMember>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", FranchiseProgramMember.getParser())
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
  public static FranchiseProgramMember loadJSON(String json, APIContext context, String header) {
    FranchiseProgramMember franchiseProgramMember = getGson().fromJson(json, FranchiseProgramMember.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(franchiseProgramMember.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    franchiseProgramMember.context = context;
    franchiseProgramMember.rawValue = json;
    franchiseProgramMember.header = header;
    return franchiseProgramMember;
  }

  public static APINodeList<FranchiseProgramMember> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<FranchiseProgramMember> franchiseProgramMembers = new APINodeList<FranchiseProgramMember>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          franchiseProgramMembers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return franchiseProgramMembers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                franchiseProgramMembers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            franchiseProgramMembers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              franchiseProgramMembers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              franchiseProgramMembers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  franchiseProgramMembers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              franchiseProgramMembers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return franchiseProgramMembers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              franchiseProgramMembers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return franchiseProgramMembers;
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
              franchiseProgramMembers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return franchiseProgramMembers;
          }

          // Sixth, check if it's pure JsonObject
          franchiseProgramMembers.clear();
          franchiseProgramMembers.add(loadJSON(json, context, header));
          return franchiseProgramMembers;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldEndDate() {
    return mEndDate;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldJoinDate() {
    return mJoinDate;
  }

  public AdAccount getFieldMemberAdAccount() {
    if (mMemberAdAccount != null) {
      mMemberAdAccount.context = getContext();
    }
    return mMemberAdAccount;
  }

  public User getFieldMemberUser() {
    if (mMemberUser != null) {
      mMemberUser.context = getContext();
    }
    return mMemberUser;
  }

  public String getFieldMembershipStatus() {
    return mMembershipStatus;
  }

  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }



  public static class APIRequestGet extends APIRequest<FranchiseProgramMember> {

    FranchiseProgramMember lastResponse = null;
    @Override
    public FranchiseProgramMember getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "end_date",
      "id",
      "join_date",
      "member_ad_account",
      "member_user",
      "membership_status",
      "page",
    };

    @Override
    public FranchiseProgramMember parseResponse(String response, String header) throws APIException {
      return FranchiseProgramMember.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public FranchiseProgramMember execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public FranchiseProgramMember execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<FranchiseProgramMember> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<FranchiseProgramMember> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, FranchiseProgramMember>() {
           public FranchiseProgramMember apply(ResponseWrapper result) {
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
    public APIRequestGet requestEndDateField () {
      return this.requestEndDateField(true);
    }
    public APIRequestGet requestEndDateField (boolean value) {
      this.requestField("end_date", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestJoinDateField () {
      return this.requestJoinDateField(true);
    }
    public APIRequestGet requestJoinDateField (boolean value) {
      this.requestField("join_date", value);
      return this;
    }
    public APIRequestGet requestMemberAdAccountField () {
      return this.requestMemberAdAccountField(true);
    }
    public APIRequestGet requestMemberAdAccountField (boolean value) {
      this.requestField("member_ad_account", value);
      return this;
    }
    public APIRequestGet requestMemberUserField () {
      return this.requestMemberUserField(true);
    }
    public APIRequestGet requestMemberUserField (boolean value) {
      this.requestField("member_user", value);
      return this;
    }
    public APIRequestGet requestMembershipStatusField () {
      return this.requestMembershipStatusField(true);
    }
    public APIRequestGet requestMembershipStatusField (boolean value) {
      this.requestField("membership_status", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
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

  public FranchiseProgramMember copyFrom(FranchiseProgramMember instance) {
    this.mBusiness = instance.mBusiness;
    this.mEndDate = instance.mEndDate;
    this.mId = instance.mId;
    this.mJoinDate = instance.mJoinDate;
    this.mMemberAdAccount = instance.mMemberAdAccount;
    this.mMemberUser = instance.mMemberUser;
    this.mMembershipStatus = instance.mMembershipStatus;
    this.mPage = instance.mPage;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<FranchiseProgramMember> getParser() {
    return new APIRequest.ResponseParser<FranchiseProgramMember>() {
      public APINodeList<FranchiseProgramMember> parseResponse(String response, APIContext context, APIRequest<FranchiseProgramMember> request, String header) throws MalformedResponseException {
        return FranchiseProgramMember.parseResponse(response, context, request, header);
      }
    };
  }
}
