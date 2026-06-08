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
public class CPASCollaborationRequest extends APINode {
  @SerializedName("ad_account_id")
  private String mAdAccountId = null;
  @SerializedName("ad_account_name")
  private String mAdAccountName = null;
  @SerializedName("brands")
  private List<String> mBrands = null;
  @SerializedName("catalog_segment")
  private ProductCatalog mCatalogSegment = null;
  @SerializedName("contact_email")
  private String mContactEmail = null;
  @SerializedName("contact_first_name")
  private String mContactFirstName = null;
  @SerializedName("contact_last_name")
  private String mContactLastName = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("phone_number")
  private String mPhoneNumber = null;
  @SerializedName("receiver_business")
  private Business mReceiverBusiness = null;
  @SerializedName("requester_agency_or_brand")
  private String mRequesterAgencyOrBrand = null;
  @SerializedName("seller_id")
  private String mSellerId = null;
  @SerializedName("sender_business")
  private Business mSenderBusiness = null;
  @SerializedName("sender_client_business")
  private Business mSenderClientBusiness = null;
  @SerializedName("shop_url")
  private String mShopUrl = null;
  @SerializedName("source")
  private String mSource = null;
  @SerializedName("status")
  private String mStatus = null;
  protected static Gson gson = null;

  CPASCollaborationRequest() {
  }

  public CPASCollaborationRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CPASCollaborationRequest(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CPASCollaborationRequest fetch() throws APIException{
    CPASCollaborationRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CPASCollaborationRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CPASCollaborationRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CPASCollaborationRequest fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CPASCollaborationRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CPASCollaborationRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CPASCollaborationRequest>)(
      new APIRequest<CPASCollaborationRequest>(context, "", "/", "GET", CPASCollaborationRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CPASCollaborationRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CPASCollaborationRequest.getParser())
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
  public static CPASCollaborationRequest loadJSON(String json, APIContext context, String header) {
    CPASCollaborationRequest cpasCollaborationRequest = getGson().fromJson(json, CPASCollaborationRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(cpasCollaborationRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    cpasCollaborationRequest.context = context;
    cpasCollaborationRequest.rawValue = json;
    cpasCollaborationRequest.header = header;
    return cpasCollaborationRequest;
  }

  public static APINodeList<CPASCollaborationRequest> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CPASCollaborationRequest> cpasCollaborationRequests = new APINodeList<CPASCollaborationRequest>(request, json, header);
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
          cpasCollaborationRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return cpasCollaborationRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                cpasCollaborationRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            cpasCollaborationRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              cpasCollaborationRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              cpasCollaborationRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  cpasCollaborationRequests.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              cpasCollaborationRequests.add(loadJSON(obj.toString(), context, header));
            }
          }
          return cpasCollaborationRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              cpasCollaborationRequests.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return cpasCollaborationRequests;
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
              cpasCollaborationRequests.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return cpasCollaborationRequests;
          }

          // Sixth, check if it's pure JsonObject
          cpasCollaborationRequests.clear();
          cpasCollaborationRequests.add(loadJSON(json, context, header));
          return cpasCollaborationRequests;
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


  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public String getFieldAdAccountName() {
    return mAdAccountName;
  }

  public List<String> getFieldBrands() {
    return mBrands;
  }

  public ProductCatalog getFieldCatalogSegment() {
    if (mCatalogSegment != null) {
      mCatalogSegment.context = getContext();
    }
    return mCatalogSegment;
  }

  public String getFieldContactEmail() {
    return mContactEmail;
  }

  public String getFieldContactFirstName() {
    return mContactFirstName;
  }

  public String getFieldContactLastName() {
    return mContactLastName;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldPhoneNumber() {
    return mPhoneNumber;
  }

  public Business getFieldReceiverBusiness() {
    if (mReceiverBusiness != null) {
      mReceiverBusiness.context = getContext();
    }
    return mReceiverBusiness;
  }

  public String getFieldRequesterAgencyOrBrand() {
    return mRequesterAgencyOrBrand;
  }

  public String getFieldSellerId() {
    return mSellerId;
  }

  public Business getFieldSenderBusiness() {
    if (mSenderBusiness != null) {
      mSenderBusiness.context = getContext();
    }
    return mSenderBusiness;
  }

  public Business getFieldSenderClientBusiness() {
    if (mSenderClientBusiness != null) {
      mSenderClientBusiness.context = getContext();
    }
    return mSenderClientBusiness;
  }

  public String getFieldShopUrl() {
    return mShopUrl;
  }

  public String getFieldSource() {
    return mSource;
  }

  public String getFieldStatus() {
    return mStatus;
  }



  public static class APIRequestGet extends APIRequest<CPASCollaborationRequest> {

    CPASCollaborationRequest lastResponse = null;
    @Override
    public CPASCollaborationRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_id",
      "ad_account_name",
      "brands",
      "catalog_segment",
      "contact_email",
      "contact_first_name",
      "contact_last_name",
      "creation_time",
      "id",
      "phone_number",
      "receiver_business",
      "requester_agency_or_brand",
      "seller_id",
      "sender_business",
      "sender_client_business",
      "shop_url",
      "source",
      "status",
    };

    @Override
    public CPASCollaborationRequest parseResponse(String response, String header) throws APIException {
      return CPASCollaborationRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CPASCollaborationRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CPASCollaborationRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CPASCollaborationRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CPASCollaborationRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CPASCollaborationRequest>() {
           public CPASCollaborationRequest apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdAccountIdField () {
      return this.requestAdAccountIdField(true);
    }
    public APIRequestGet requestAdAccountIdField (boolean value) {
      this.requestField("ad_account_id", value);
      return this;
    }
    public APIRequestGet requestAdAccountNameField () {
      return this.requestAdAccountNameField(true);
    }
    public APIRequestGet requestAdAccountNameField (boolean value) {
      this.requestField("ad_account_name", value);
      return this;
    }
    public APIRequestGet requestBrandsField () {
      return this.requestBrandsField(true);
    }
    public APIRequestGet requestBrandsField (boolean value) {
      this.requestField("brands", value);
      return this;
    }
    public APIRequestGet requestCatalogSegmentField () {
      return this.requestCatalogSegmentField(true);
    }
    public APIRequestGet requestCatalogSegmentField (boolean value) {
      this.requestField("catalog_segment", value);
      return this;
    }
    public APIRequestGet requestContactEmailField () {
      return this.requestContactEmailField(true);
    }
    public APIRequestGet requestContactEmailField (boolean value) {
      this.requestField("contact_email", value);
      return this;
    }
    public APIRequestGet requestContactFirstNameField () {
      return this.requestContactFirstNameField(true);
    }
    public APIRequestGet requestContactFirstNameField (boolean value) {
      this.requestField("contact_first_name", value);
      return this;
    }
    public APIRequestGet requestContactLastNameField () {
      return this.requestContactLastNameField(true);
    }
    public APIRequestGet requestContactLastNameField (boolean value) {
      this.requestField("contact_last_name", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPhoneNumberField () {
      return this.requestPhoneNumberField(true);
    }
    public APIRequestGet requestPhoneNumberField (boolean value) {
      this.requestField("phone_number", value);
      return this;
    }
    public APIRequestGet requestReceiverBusinessField () {
      return this.requestReceiverBusinessField(true);
    }
    public APIRequestGet requestReceiverBusinessField (boolean value) {
      this.requestField("receiver_business", value);
      return this;
    }
    public APIRequestGet requestRequesterAgencyOrBrandField () {
      return this.requestRequesterAgencyOrBrandField(true);
    }
    public APIRequestGet requestRequesterAgencyOrBrandField (boolean value) {
      this.requestField("requester_agency_or_brand", value);
      return this;
    }
    public APIRequestGet requestSellerIdField () {
      return this.requestSellerIdField(true);
    }
    public APIRequestGet requestSellerIdField (boolean value) {
      this.requestField("seller_id", value);
      return this;
    }
    public APIRequestGet requestSenderBusinessField () {
      return this.requestSenderBusinessField(true);
    }
    public APIRequestGet requestSenderBusinessField (boolean value) {
      this.requestField("sender_business", value);
      return this;
    }
    public APIRequestGet requestSenderClientBusinessField () {
      return this.requestSenderClientBusinessField(true);
    }
    public APIRequestGet requestSenderClientBusinessField (boolean value) {
      this.requestField("sender_client_business", value);
      return this;
    }
    public APIRequestGet requestShopUrlField () {
      return this.requestShopUrlField(true);
    }
    public APIRequestGet requestShopUrlField (boolean value) {
      this.requestField("shop_url", value);
      return this;
    }
    public APIRequestGet requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGet requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
  }

  public static enum EnumRequestRole {
      @SerializedName("RECEIVER")
      VALUE_RECEIVER("RECEIVER"),
      @SerializedName("SENDER")
      VALUE_SENDER("SENDER"),
      ;

      private String value;

      private EnumRequestRole(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSource {
      @SerializedName("EXTERNAL")
      VALUE_EXTERNAL("EXTERNAL"),
      @SerializedName("INTERNAL")
      VALUE_INTERNAL("INTERNAL"),
      @SerializedName("SELF_SERVE")
      VALUE_SELF_SERVE("SELF_SERVE"),
      ;

      private String value;

      private EnumSource(String value) {
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

  public CPASCollaborationRequest copyFrom(CPASCollaborationRequest instance) {
    this.mAdAccountId = instance.mAdAccountId;
    this.mAdAccountName = instance.mAdAccountName;
    this.mBrands = instance.mBrands;
    this.mCatalogSegment = instance.mCatalogSegment;
    this.mContactEmail = instance.mContactEmail;
    this.mContactFirstName = instance.mContactFirstName;
    this.mContactLastName = instance.mContactLastName;
    this.mCreationTime = instance.mCreationTime;
    this.mId = instance.mId;
    this.mPhoneNumber = instance.mPhoneNumber;
    this.mReceiverBusiness = instance.mReceiverBusiness;
    this.mRequesterAgencyOrBrand = instance.mRequesterAgencyOrBrand;
    this.mSellerId = instance.mSellerId;
    this.mSenderBusiness = instance.mSenderBusiness;
    this.mSenderClientBusiness = instance.mSenderClientBusiness;
    this.mShopUrl = instance.mShopUrl;
    this.mSource = instance.mSource;
    this.mStatus = instance.mStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CPASCollaborationRequest> getParser() {
    return new APIRequest.ResponseParser<CPASCollaborationRequest>() {
      public APINodeList<CPASCollaborationRequest> parseResponse(String response, APIContext context, APIRequest<CPASCollaborationRequest> request, String header) throws MalformedResponseException {
        return CPASCollaborationRequest.parseResponse(response, context, request, header);
      }
    };
  }
}
