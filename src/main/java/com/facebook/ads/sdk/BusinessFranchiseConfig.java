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
public class BusinessFranchiseConfig extends APINode {
  @SerializedName("active_partner_count")
  private Long mActivePartnerCount = null;
  @SerializedName("agency_business")
  private Business mAgencyBusiness = null;
  @SerializedName("agency_business_asset_group")
  private BusinessAssetGroup mAgencyBusinessAssetGroup = null;
  @SerializedName("brand_name")
  private String mBrandName = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("business_vertical")
  private String mBusinessVertical = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("partner_count")
  private Long mPartnerCount = null;
  @SerializedName("pending_agency_business")
  private String mPendingAgencyBusiness = null;
  @SerializedName("program_count")
  private Long mProgramCount = null;
  @SerializedName("shared_business_asset_group")
  private BusinessAssetGroup mSharedBusinessAssetGroup = null;
  @SerializedName("shared_creative_folder_count")
  private Long mSharedCreativeFolderCount = null;
  @SerializedName("shared_custom_audience_count")
  private Long mSharedCustomAudienceCount = null;
  protected static Gson gson = null;

  BusinessFranchiseConfig() {
  }

  public BusinessFranchiseConfig(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public BusinessFranchiseConfig(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public BusinessFranchiseConfig fetch() throws APIException{
    BusinessFranchiseConfig newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static BusinessFranchiseConfig fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<BusinessFranchiseConfig> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static BusinessFranchiseConfig fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<BusinessFranchiseConfig> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<BusinessFranchiseConfig> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<BusinessFranchiseConfig>)(
      new APIRequest<BusinessFranchiseConfig>(context, "", "/", "GET", BusinessFranchiseConfig.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<BusinessFranchiseConfig>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", BusinessFranchiseConfig.getParser())
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
  public static BusinessFranchiseConfig loadJSON(String json, APIContext context, String header) {
    BusinessFranchiseConfig businessFranchiseConfig = getGson().fromJson(json, BusinessFranchiseConfig.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessFranchiseConfig.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessFranchiseConfig.context = context;
    businessFranchiseConfig.rawValue = json;
    businessFranchiseConfig.header = header;
    return businessFranchiseConfig;
  }

  public static APINodeList<BusinessFranchiseConfig> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessFranchiseConfig> businessFranchiseConfigs = new APINodeList<BusinessFranchiseConfig>(request, json, header);
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
          businessFranchiseConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessFranchiseConfigs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessFranchiseConfigs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessFranchiseConfigs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessFranchiseConfigs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessFranchiseConfigs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  businessFranchiseConfigs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessFranchiseConfigs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessFranchiseConfigs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessFranchiseConfigs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessFranchiseConfigs;
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
              businessFranchiseConfigs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessFranchiseConfigs;
          }

          // Sixth, check if it's pure JsonObject
          businessFranchiseConfigs.clear();
          businessFranchiseConfigs.add(loadJSON(json, context, header));
          return businessFranchiseConfigs;
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


  public Long getFieldActivePartnerCount() {
    return mActivePartnerCount;
  }

  public Business getFieldAgencyBusiness() {
    if (mAgencyBusiness != null) {
      mAgencyBusiness.context = getContext();
    }
    return mAgencyBusiness;
  }

  public BusinessAssetGroup getFieldAgencyBusinessAssetGroup() {
    if (mAgencyBusinessAssetGroup != null) {
      mAgencyBusinessAssetGroup.context = getContext();
    }
    return mAgencyBusinessAssetGroup;
  }

  public String getFieldBrandName() {
    return mBrandName;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldBusinessVertical() {
    return mBusinessVertical;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldPartnerCount() {
    return mPartnerCount;
  }

  public String getFieldPendingAgencyBusiness() {
    return mPendingAgencyBusiness;
  }

  public Long getFieldProgramCount() {
    return mProgramCount;
  }

  public BusinessAssetGroup getFieldSharedBusinessAssetGroup() {
    if (mSharedBusinessAssetGroup != null) {
      mSharedBusinessAssetGroup.context = getContext();
    }
    return mSharedBusinessAssetGroup;
  }

  public Long getFieldSharedCreativeFolderCount() {
    return mSharedCreativeFolderCount;
  }

  public Long getFieldSharedCustomAudienceCount() {
    return mSharedCustomAudienceCount;
  }



  public static class APIRequestGet extends APIRequest<BusinessFranchiseConfig> {

    BusinessFranchiseConfig lastResponse = null;
    @Override
    public BusinessFranchiseConfig getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "active_partner_count",
      "agency_business",
      "agency_business_asset_group",
      "brand_name",
      "business",
      "business_vertical",
      "id",
      "partner_count",
      "pending_agency_business",
      "program_count",
      "shared_business_asset_group",
      "shared_creative_folder_count",
      "shared_custom_audience_count",
    };

    @Override
    public BusinessFranchiseConfig parseResponse(String response, String header) throws APIException {
      return BusinessFranchiseConfig.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public BusinessFranchiseConfig execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public BusinessFranchiseConfig execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<BusinessFranchiseConfig> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<BusinessFranchiseConfig> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, BusinessFranchiseConfig>() {
           public BusinessFranchiseConfig apply(ResponseWrapper result) {
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

    public APIRequestGet requestActivePartnerCountField () {
      return this.requestActivePartnerCountField(true);
    }
    public APIRequestGet requestActivePartnerCountField (boolean value) {
      this.requestField("active_partner_count", value);
      return this;
    }
    public APIRequestGet requestAgencyBusinessField () {
      return this.requestAgencyBusinessField(true);
    }
    public APIRequestGet requestAgencyBusinessField (boolean value) {
      this.requestField("agency_business", value);
      return this;
    }
    public APIRequestGet requestAgencyBusinessAssetGroupField () {
      return this.requestAgencyBusinessAssetGroupField(true);
    }
    public APIRequestGet requestAgencyBusinessAssetGroupField (boolean value) {
      this.requestField("agency_business_asset_group", value);
      return this;
    }
    public APIRequestGet requestBrandNameField () {
      return this.requestBrandNameField(true);
    }
    public APIRequestGet requestBrandNameField (boolean value) {
      this.requestField("brand_name", value);
      return this;
    }
    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestBusinessVerticalField () {
      return this.requestBusinessVerticalField(true);
    }
    public APIRequestGet requestBusinessVerticalField (boolean value) {
      this.requestField("business_vertical", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPartnerCountField () {
      return this.requestPartnerCountField(true);
    }
    public APIRequestGet requestPartnerCountField (boolean value) {
      this.requestField("partner_count", value);
      return this;
    }
    public APIRequestGet requestPendingAgencyBusinessField () {
      return this.requestPendingAgencyBusinessField(true);
    }
    public APIRequestGet requestPendingAgencyBusinessField (boolean value) {
      this.requestField("pending_agency_business", value);
      return this;
    }
    public APIRequestGet requestProgramCountField () {
      return this.requestProgramCountField(true);
    }
    public APIRequestGet requestProgramCountField (boolean value) {
      this.requestField("program_count", value);
      return this;
    }
    public APIRequestGet requestSharedBusinessAssetGroupField () {
      return this.requestSharedBusinessAssetGroupField(true);
    }
    public APIRequestGet requestSharedBusinessAssetGroupField (boolean value) {
      this.requestField("shared_business_asset_group", value);
      return this;
    }
    public APIRequestGet requestSharedCreativeFolderCountField () {
      return this.requestSharedCreativeFolderCountField(true);
    }
    public APIRequestGet requestSharedCreativeFolderCountField (boolean value) {
      this.requestField("shared_creative_folder_count", value);
      return this;
    }
    public APIRequestGet requestSharedCustomAudienceCountField () {
      return this.requestSharedCustomAudienceCountField(true);
    }
    public APIRequestGet requestSharedCustomAudienceCountField (boolean value) {
      this.requestField("shared_custom_audience_count", value);
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

  public BusinessFranchiseConfig copyFrom(BusinessFranchiseConfig instance) {
    this.mActivePartnerCount = instance.mActivePartnerCount;
    this.mAgencyBusiness = instance.mAgencyBusiness;
    this.mAgencyBusinessAssetGroup = instance.mAgencyBusinessAssetGroup;
    this.mBrandName = instance.mBrandName;
    this.mBusiness = instance.mBusiness;
    this.mBusinessVertical = instance.mBusinessVertical;
    this.mId = instance.mId;
    this.mPartnerCount = instance.mPartnerCount;
    this.mPendingAgencyBusiness = instance.mPendingAgencyBusiness;
    this.mProgramCount = instance.mProgramCount;
    this.mSharedBusinessAssetGroup = instance.mSharedBusinessAssetGroup;
    this.mSharedCreativeFolderCount = instance.mSharedCreativeFolderCount;
    this.mSharedCustomAudienceCount = instance.mSharedCustomAudienceCount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessFranchiseConfig> getParser() {
    return new APIRequest.ResponseParser<BusinessFranchiseConfig>() {
      public APINodeList<BusinessFranchiseConfig> parseResponse(String response, APIContext context, APIRequest<BusinessFranchiseConfig> request, String header) throws MalformedResponseException {
        return BusinessFranchiseConfig.parseResponse(response, context, request, header);
      }
    };
  }
}
