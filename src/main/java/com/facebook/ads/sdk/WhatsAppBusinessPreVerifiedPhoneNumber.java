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
public class WhatsAppBusinessPreVerifiedPhoneNumber extends APINode {
  @SerializedName("code_verification_status")
  private String mCodeVerificationStatus = null;
  @SerializedName("code_verification_time")
  private String mCodeVerificationTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("owner_business")
  private Business mOwnerBusiness = null;
  @SerializedName("phone_number")
  private String mPhoneNumber = null;
  @SerializedName("verification_expiry_time")
  private String mVerificationExpiryTime = null;
  protected static Gson gson = null;

  WhatsAppBusinessPreVerifiedPhoneNumber() {
  }

  public WhatsAppBusinessPreVerifiedPhoneNumber(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public WhatsAppBusinessPreVerifiedPhoneNumber(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public WhatsAppBusinessPreVerifiedPhoneNumber fetch() throws APIException{
    WhatsAppBusinessPreVerifiedPhoneNumber newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static WhatsAppBusinessPreVerifiedPhoneNumber fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<WhatsAppBusinessPreVerifiedPhoneNumber> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static WhatsAppBusinessPreVerifiedPhoneNumber fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<WhatsAppBusinessPreVerifiedPhoneNumber> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber>)(
      new APIRequest<WhatsAppBusinessPreVerifiedPhoneNumber>(context, "", "/", "GET", WhatsAppBusinessPreVerifiedPhoneNumber.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", WhatsAppBusinessPreVerifiedPhoneNumber.getParser())
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
  public static WhatsAppBusinessPreVerifiedPhoneNumber loadJSON(String json, APIContext context, String header) {
    WhatsAppBusinessPreVerifiedPhoneNumber whatsAppBusinessPreVerifiedPhoneNumber = getGson().fromJson(json, WhatsAppBusinessPreVerifiedPhoneNumber.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(whatsAppBusinessPreVerifiedPhoneNumber.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    whatsAppBusinessPreVerifiedPhoneNumber.context = context;
    whatsAppBusinessPreVerifiedPhoneNumber.rawValue = json;
    whatsAppBusinessPreVerifiedPhoneNumber.header = header;
    return whatsAppBusinessPreVerifiedPhoneNumber;
  }

  public static APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> whatsAppBusinessPreVerifiedPhoneNumbers = new APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber>(request, json, header);
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
          whatsAppBusinessPreVerifiedPhoneNumbers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return whatsAppBusinessPreVerifiedPhoneNumbers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                whatsAppBusinessPreVerifiedPhoneNumbers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            whatsAppBusinessPreVerifiedPhoneNumbers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              whatsAppBusinessPreVerifiedPhoneNumbers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              whatsAppBusinessPreVerifiedPhoneNumbers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  whatsAppBusinessPreVerifiedPhoneNumbers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              whatsAppBusinessPreVerifiedPhoneNumbers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return whatsAppBusinessPreVerifiedPhoneNumbers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              whatsAppBusinessPreVerifiedPhoneNumbers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return whatsAppBusinessPreVerifiedPhoneNumbers;
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
              whatsAppBusinessPreVerifiedPhoneNumbers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return whatsAppBusinessPreVerifiedPhoneNumbers;
          }

          // Sixth, check if it's pure JsonObject
          whatsAppBusinessPreVerifiedPhoneNumbers.clear();
          whatsAppBusinessPreVerifiedPhoneNumbers.add(loadJSON(json, context, header));
          return whatsAppBusinessPreVerifiedPhoneNumbers;
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

  public APIRequestGetPartners getPartners() {
    return new APIRequestGetPartners(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateRequestCode createRequestCode() {
    return new APIRequestCreateRequestCode(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVerifyCode createVerifyCode() {
    return new APIRequestCreateVerifyCode(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldCodeVerificationStatus() {
    return mCodeVerificationStatus;
  }

  public String getFieldCodeVerificationTime() {
    return mCodeVerificationTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Business getFieldOwnerBusiness() {
    if (mOwnerBusiness != null) {
      mOwnerBusiness.context = getContext();
    }
    return mOwnerBusiness;
  }

  public String getFieldPhoneNumber() {
    return mPhoneNumber;
  }

  public String getFieldVerificationExpiryTime() {
    return mVerificationExpiryTime;
  }



  public static class APIRequestGetPartners extends APIRequest<Business> {

    APINodeList<Business> lastResponse = null;
    @Override
    public APINodeList<Business> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "block_offline_analytics",
      "collaborative_ads_managed_partner_business_info",
      "collaborative_ads_managed_partner_eligibility",
      "collaborative_ads_partner_premium_options",
      "created_by",
      "created_time",
      "extended_updated_time",
      "id",
      "is_hidden",
      "link",
      "name",
      "primary_page",
      "profile_picture_uri",
      "timezone_id",
      "two_factor_type",
      "updated_by",
      "updated_time",
      "user_access_expire_time",
      "verification_status",
      "vertical",
      "vertical_id",
    };

    @Override
    public APINodeList<Business> parseResponse(String response, String header) throws APIException {
      return Business.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<Business> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Business> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<Business>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<Business>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<Business>>() {
           public APINodeList<Business> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPartners.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPartners(String nodeId, APIContext context) {
      super(context, nodeId, "/partners", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPartners setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPartners setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPartners requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPartners requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartners requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPartners requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPartners requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPartners requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPartners requestBlockOfflineAnalyticsField () {
      return this.requestBlockOfflineAnalyticsField(true);
    }
    public APIRequestGetPartners requestBlockOfflineAnalyticsField (boolean value) {
      this.requestField("block_offline_analytics", value);
      return this;
    }
    public APIRequestGetPartners requestCollaborativeAdsManagedPartnerBusinessInfoField () {
      return this.requestCollaborativeAdsManagedPartnerBusinessInfoField(true);
    }
    public APIRequestGetPartners requestCollaborativeAdsManagedPartnerBusinessInfoField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_business_info", value);
      return this;
    }
    public APIRequestGetPartners requestCollaborativeAdsManagedPartnerEligibilityField () {
      return this.requestCollaborativeAdsManagedPartnerEligibilityField(true);
    }
    public APIRequestGetPartners requestCollaborativeAdsManagedPartnerEligibilityField (boolean value) {
      this.requestField("collaborative_ads_managed_partner_eligibility", value);
      return this;
    }
    public APIRequestGetPartners requestCollaborativeAdsPartnerPremiumOptionsField () {
      return this.requestCollaborativeAdsPartnerPremiumOptionsField(true);
    }
    public APIRequestGetPartners requestCollaborativeAdsPartnerPremiumOptionsField (boolean value) {
      this.requestField("collaborative_ads_partner_premium_options", value);
      return this;
    }
    public APIRequestGetPartners requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetPartners requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetPartners requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetPartners requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetPartners requestExtendedUpdatedTimeField () {
      return this.requestExtendedUpdatedTimeField(true);
    }
    public APIRequestGetPartners requestExtendedUpdatedTimeField (boolean value) {
      this.requestField("extended_updated_time", value);
      return this;
    }
    public APIRequestGetPartners requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPartners requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPartners requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGetPartners requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGetPartners requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetPartners requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetPartners requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetPartners requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetPartners requestPrimaryPageField () {
      return this.requestPrimaryPageField(true);
    }
    public APIRequestGetPartners requestPrimaryPageField (boolean value) {
      this.requestField("primary_page", value);
      return this;
    }
    public APIRequestGetPartners requestProfilePictureUriField () {
      return this.requestProfilePictureUriField(true);
    }
    public APIRequestGetPartners requestProfilePictureUriField (boolean value) {
      this.requestField("profile_picture_uri", value);
      return this;
    }
    public APIRequestGetPartners requestTimezoneIdField () {
      return this.requestTimezoneIdField(true);
    }
    public APIRequestGetPartners requestTimezoneIdField (boolean value) {
      this.requestField("timezone_id", value);
      return this;
    }
    public APIRequestGetPartners requestTwoFactorTypeField () {
      return this.requestTwoFactorTypeField(true);
    }
    public APIRequestGetPartners requestTwoFactorTypeField (boolean value) {
      this.requestField("two_factor_type", value);
      return this;
    }
    public APIRequestGetPartners requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetPartners requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetPartners requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetPartners requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetPartners requestUserAccessExpireTimeField () {
      return this.requestUserAccessExpireTimeField(true);
    }
    public APIRequestGetPartners requestUserAccessExpireTimeField (boolean value) {
      this.requestField("user_access_expire_time", value);
      return this;
    }
    public APIRequestGetPartners requestVerificationStatusField () {
      return this.requestVerificationStatusField(true);
    }
    public APIRequestGetPartners requestVerificationStatusField (boolean value) {
      this.requestField("verification_status", value);
      return this;
    }
    public APIRequestGetPartners requestVerticalField () {
      return this.requestVerticalField(true);
    }
    public APIRequestGetPartners requestVerticalField (boolean value) {
      this.requestField("vertical", value);
      return this;
    }
    public APIRequestGetPartners requestVerticalIdField () {
      return this.requestVerticalIdField(true);
    }
    public APIRequestGetPartners requestVerticalIdField (boolean value) {
      this.requestField("vertical_id", value);
      return this;
    }
  }

  public static class APIRequestCreateRequestCode extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "code_method",
      "language",
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
               return APIRequestCreateRequestCode.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateRequestCode(String nodeId, APIContext context) {
      super(context, nodeId, "/request_code", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateRequestCode setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateRequestCode setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateRequestCode setCodeMethod (EnumCodeMethod codeMethod) {
      this.setParam("code_method", codeMethod);
      return this;
    }
    public APIRequestCreateRequestCode setCodeMethod (String codeMethod) {
      this.setParam("code_method", codeMethod);
      return this;
    }

    public APIRequestCreateRequestCode setLanguage (String language) {
      this.setParam("language", language);
      return this;
    }

    public APIRequestCreateRequestCode requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateRequestCode requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateRequestCode requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateRequestCode requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateRequestCode requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateRequestCode requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateVerifyCode extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "code",
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
               return APIRequestCreateVerifyCode.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateVerifyCode(String nodeId, APIContext context) {
      super(context, nodeId, "/verify_code", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVerifyCode setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVerifyCode setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVerifyCode setCode (String code) {
      this.setParam("code", code);
      return this;
    }

    public APIRequestCreateVerifyCode requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVerifyCode requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVerifyCode requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVerifyCode requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVerifyCode requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVerifyCode requestField (String field, boolean value) {
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
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

  public static class APIRequestGet extends APIRequest<WhatsAppBusinessPreVerifiedPhoneNumber> {

    WhatsAppBusinessPreVerifiedPhoneNumber lastResponse = null;
    @Override
    public WhatsAppBusinessPreVerifiedPhoneNumber getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "code_verification_status",
      "code_verification_time",
      "id",
      "owner_business",
      "phone_number",
      "verification_expiry_time",
    };

    @Override
    public WhatsAppBusinessPreVerifiedPhoneNumber parseResponse(String response, String header) throws APIException {
      return WhatsAppBusinessPreVerifiedPhoneNumber.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public WhatsAppBusinessPreVerifiedPhoneNumber execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public WhatsAppBusinessPreVerifiedPhoneNumber execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<WhatsAppBusinessPreVerifiedPhoneNumber> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<WhatsAppBusinessPreVerifiedPhoneNumber> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, WhatsAppBusinessPreVerifiedPhoneNumber>() {
           public WhatsAppBusinessPreVerifiedPhoneNumber apply(ResponseWrapper result) {
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

    public APIRequestGet requestCodeVerificationStatusField () {
      return this.requestCodeVerificationStatusField(true);
    }
    public APIRequestGet requestCodeVerificationStatusField (boolean value) {
      this.requestField("code_verification_status", value);
      return this;
    }
    public APIRequestGet requestCodeVerificationTimeField () {
      return this.requestCodeVerificationTimeField(true);
    }
    public APIRequestGet requestCodeVerificationTimeField (boolean value) {
      this.requestField("code_verification_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestOwnerBusinessField () {
      return this.requestOwnerBusinessField(true);
    }
    public APIRequestGet requestOwnerBusinessField (boolean value) {
      this.requestField("owner_business", value);
      return this;
    }
    public APIRequestGet requestPhoneNumberField () {
      return this.requestPhoneNumberField(true);
    }
    public APIRequestGet requestPhoneNumberField (boolean value) {
      this.requestField("phone_number", value);
      return this;
    }
    public APIRequestGet requestVerificationExpiryTimeField () {
      return this.requestVerificationExpiryTimeField(true);
    }
    public APIRequestGet requestVerificationExpiryTimeField (boolean value) {
      this.requestField("verification_expiry_time", value);
      return this;
    }
  }

  public static enum EnumCodeVerificationStatus {
      @SerializedName("EXPIRED")
      VALUE_EXPIRED("EXPIRED"),
      @SerializedName("NOT_VERIFIED")
      VALUE_NOT_VERIFIED("NOT_VERIFIED"),
      @SerializedName("VERIFIED")
      VALUE_VERIFIED("VERIFIED"),
      ;

      private String value;

      private EnumCodeVerificationStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCodeMethod {
      @SerializedName("SMS")
      VALUE_SMS("SMS"),
      @SerializedName("VOICE")
      VALUE_VOICE("VOICE"),
      ;

      private String value;

      private EnumCodeMethod(String value) {
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

  public WhatsAppBusinessPreVerifiedPhoneNumber copyFrom(WhatsAppBusinessPreVerifiedPhoneNumber instance) {
    this.mCodeVerificationStatus = instance.mCodeVerificationStatus;
    this.mCodeVerificationTime = instance.mCodeVerificationTime;
    this.mId = instance.mId;
    this.mOwnerBusiness = instance.mOwnerBusiness;
    this.mPhoneNumber = instance.mPhoneNumber;
    this.mVerificationExpiryTime = instance.mVerificationExpiryTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<WhatsAppBusinessPreVerifiedPhoneNumber> getParser() {
    return new APIRequest.ResponseParser<WhatsAppBusinessPreVerifiedPhoneNumber>() {
      public APINodeList<WhatsAppBusinessPreVerifiedPhoneNumber> parseResponse(String response, APIContext context, APIRequest<WhatsAppBusinessPreVerifiedPhoneNumber> request, String header) throws MalformedResponseException {
        return WhatsAppBusinessPreVerifiedPhoneNumber.parseResponse(response, context, request, header);
      }
    };
  }
}
