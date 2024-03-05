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
public class BusinessAssetSharingAgreement extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("initiator")
  private Business mInitiator = null;
  @SerializedName("recipient")
  private Business mRecipient = null;
  @SerializedName("relationship_type")
  private List<String> mRelationshipType = null;
  @SerializedName("request_status")
  private String mRequestStatus = null;
  @SerializedName("request_type")
  private String mRequestType = null;
  protected static Gson gson = null;

  BusinessAssetSharingAgreement() {
  }

  public BusinessAssetSharingAgreement(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessAssetSharingAgreement(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BusinessAssetSharingAgreement fetch() throws APIException{
    BusinessAssetSharingAgreement newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessAssetSharingAgreement fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessAssetSharingAgreement> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessAssetSharingAgreement fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BusinessAssetSharingAgreement> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BusinessAssetSharingAgreement> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessAssetSharingAgreement>)(
      new APIRequest<BusinessAssetSharingAgreement>(context, "", "/", "GET", BusinessAssetSharingAgreement.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessAssetSharingAgreement>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BusinessAssetSharingAgreement.getParser())
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
  public static BusinessAssetSharingAgreement loadJSON(String json, APIContext context, String header) {
    BusinessAssetSharingAgreement businessAssetSharingAgreement = getGson().fromJson(json, BusinessAssetSharingAgreement.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessAssetSharingAgreement.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessAssetSharingAgreement.context = context;
    businessAssetSharingAgreement.rawValue = json;
    businessAssetSharingAgreement.header = header;
    return businessAssetSharingAgreement;
  }

  public static APINodeList<BusinessAssetSharingAgreement> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessAssetSharingAgreement> businessAssetSharingAgreements = new APINodeList<BusinessAssetSharingAgreement>(request, json, header);
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
          businessAssetSharingAgreements.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessAssetSharingAgreements;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessAssetSharingAgreements.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessAssetSharingAgreements.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessAssetSharingAgreements.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessAssetSharingAgreements.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessAssetSharingAgreements.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessAssetSharingAgreements.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessAssetSharingAgreements;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessAssetSharingAgreements.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessAssetSharingAgreements;
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
              businessAssetSharingAgreements.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessAssetSharingAgreements;
          }

          // Sixth, check if it's pure JsonObject
          businessAssetSharingAgreements.clear();
          businessAssetSharingAgreements.add(loadJSON(json, context, header));
          return businessAssetSharingAgreements;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldId() {
    return mId;
  }

  public Business getFieldInitiator() {
    if (mInitiator != null) {
      mInitiator.context = getContext();
    }
    return mInitiator;
  }

  public Business getFieldRecipient() {
    if (mRecipient != null) {
      mRecipient.context = getContext();
    }
    return mRecipient;
  }

  public List<String> getFieldRelationshipType() {
    return mRelationshipType;
  }

  public String getFieldRequestStatus() {
    return mRequestStatus;
  }

  public String getFieldRequestType() {
    return mRequestType;
  }



  public static class APIRequestGet extends APIRequest<BusinessAssetSharingAgreement> {

    BusinessAssetSharingAgreement lastResponse = null;
    @Override
    public BusinessAssetSharingAgreement getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "initiator",
      "recipient",
      "relationship_type",
      "request_status",
      "request_type",
    };

    @Override
    public BusinessAssetSharingAgreement parseResponse(String response, String header) throws APIException {
      return BusinessAssetSharingAgreement.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessAssetSharingAgreement execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessAssetSharingAgreement execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessAssetSharingAgreement> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessAssetSharingAgreement> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessAssetSharingAgreement>() {
           public BusinessAssetSharingAgreement apply(ResponseWrapper result) {
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInitiatorField () {
      return this.requestInitiatorField(true);
    }
    public APIRequestGet requestInitiatorField (boolean value) {
      this.requestField("initiator", value);
      return this;
    }
    public APIRequestGet requestRecipientField () {
      return this.requestRecipientField(true);
    }
    public APIRequestGet requestRecipientField (boolean value) {
      this.requestField("recipient", value);
      return this;
    }
    public APIRequestGet requestRelationshipTypeField () {
      return this.requestRelationshipTypeField(true);
    }
    public APIRequestGet requestRelationshipTypeField (boolean value) {
      this.requestField("relationship_type", value);
      return this;
    }
    public APIRequestGet requestRequestStatusField () {
      return this.requestRequestStatusField(true);
    }
    public APIRequestGet requestRequestStatusField (boolean value) {
      this.requestField("request_status", value);
      return this;
    }
    public APIRequestGet requestRequestTypeField () {
      return this.requestRequestTypeField(true);
    }
    public APIRequestGet requestRequestTypeField (boolean value) {
      this.requestField("request_type", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<BusinessAssetSharingAgreement> {

    BusinessAssetSharingAgreement lastResponse = null;
    @Override
    public BusinessAssetSharingAgreement getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "request_response",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public BusinessAssetSharingAgreement parseResponse(String response, String header) throws APIException {
      return BusinessAssetSharingAgreement.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessAssetSharingAgreement execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessAssetSharingAgreement execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessAssetSharingAgreement> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessAssetSharingAgreement> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessAssetSharingAgreement>() {
           public BusinessAssetSharingAgreement apply(ResponseWrapper result) {
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


    public APIRequestUpdate setRequestResponse (String requestResponse) {
      this.setParam("request_response", requestResponse);
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

  public static enum EnumRequestStatus {
      @SerializedName("APPROVE")
      VALUE_APPROVE("APPROVE"),
      @SerializedName("DECLINE")
      VALUE_DECLINE("DECLINE"),
      @SerializedName("EXPIRED")
      VALUE_EXPIRED("EXPIRED"),
      @SerializedName("IN_PROGRESS")
      VALUE_IN_PROGRESS("IN_PROGRESS"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("PENDING_EMAIL_VERIFICATION")
      VALUE_PENDING_EMAIL_VERIFICATION("PENDING_EMAIL_VERIFICATION"),
      @SerializedName("PENDING_INTEGRITY_REVIEW")
      VALUE_PENDING_INTEGRITY_REVIEW("PENDING_INTEGRITY_REVIEW"),
      ;

      private String value;

      private EnumRequestStatus(String value) {
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

  public BusinessAssetSharingAgreement copyFrom(BusinessAssetSharingAgreement instance) {
    this.mId = instance.mId;
    this.mInitiator = instance.mInitiator;
    this.mRecipient = instance.mRecipient;
    this.mRelationshipType = instance.mRelationshipType;
    this.mRequestStatus = instance.mRequestStatus;
    this.mRequestType = instance.mRequestType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessAssetSharingAgreement> getParser() {
    return new APIRequest.ResponseParser<BusinessAssetSharingAgreement>() {
      public APINodeList<BusinessAssetSharingAgreement> parseResponse(String response, APIContext context, APIRequest<BusinessAssetSharingAgreement> request, String header) throws MalformedResponseException {
        return BusinessAssetSharingAgreement.parseResponse(response, context, request, header);
      }
    };
  }
}
