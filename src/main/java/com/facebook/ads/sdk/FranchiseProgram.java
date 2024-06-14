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
public class FranchiseProgram extends APINode {
  @SerializedName("business_asset_group")
  private BusinessAssetGroup mBusinessAssetGroup = null;
  @SerializedName("creator_business")
  private Business mCreatorBusiness = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("end_date")
  private String mEndDate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("program_access_type")
  private String mProgramAccessType = null;
  @SerializedName("program_approval_type")
  private String mProgramApprovalType = null;
  @SerializedName("program_image_link")
  private String mProgramImageLink = null;
  @SerializedName("program_url")
  private String mProgramUrl = null;
  @SerializedName("shared_custom_audience")
  private CustomAudience mSharedCustomAudience = null;
  @SerializedName("start_date")
  private String mStartDate = null;
  protected static Gson gson = null;

  FranchiseProgram() {
  }

  public FranchiseProgram(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public FranchiseProgram(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public FranchiseProgram fetch() throws APIException{
    FranchiseProgram newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static FranchiseProgram fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<FranchiseProgram> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static FranchiseProgram fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<FranchiseProgram> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<FranchiseProgram> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<FranchiseProgram>)(
      new APIRequest<FranchiseProgram>(context, "", "/", "GET", FranchiseProgram.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<FranchiseProgram>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", FranchiseProgram.getParser())
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
  public static FranchiseProgram loadJSON(String json, APIContext context, String header) {
    FranchiseProgram franchiseProgram = getGson().fromJson(json, FranchiseProgram.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(franchiseProgram.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    franchiseProgram.context = context;
    franchiseProgram.rawValue = json;
    franchiseProgram.header = header;
    return franchiseProgram;
  }

  public static APINodeList<FranchiseProgram> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<FranchiseProgram> franchisePrograms = new APINodeList<FranchiseProgram>(request, json, header);
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
          franchisePrograms.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return franchisePrograms;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                franchisePrograms.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            franchisePrograms.setPaging(previous, next);
            if (context.hasAppSecret()) {
              franchisePrograms.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              franchisePrograms.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  franchisePrograms.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              franchisePrograms.add(loadJSON(obj.toString(), context, header));
            }
          }
          return franchisePrograms;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              franchisePrograms.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return franchisePrograms;
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
              franchisePrograms.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return franchisePrograms;
          }

          // Sixth, check if it's pure JsonObject
          franchisePrograms.clear();
          franchisePrograms.add(loadJSON(json, context, header));
          return franchisePrograms;
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


  public BusinessAssetGroup getFieldBusinessAssetGroup() {
    if (mBusinessAssetGroup != null) {
      mBusinessAssetGroup.context = getContext();
    }
    return mBusinessAssetGroup;
  }

  public Business getFieldCreatorBusiness() {
    if (mCreatorBusiness != null) {
      mCreatorBusiness.context = getContext();
    }
    return mCreatorBusiness;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEndDate() {
    return mEndDate;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldProgramAccessType() {
    return mProgramAccessType;
  }

  public String getFieldProgramApprovalType() {
    return mProgramApprovalType;
  }

  public String getFieldProgramImageLink() {
    return mProgramImageLink;
  }

  public String getFieldProgramUrl() {
    return mProgramUrl;
  }

  public CustomAudience getFieldSharedCustomAudience() {
    if (mSharedCustomAudience != null) {
      mSharedCustomAudience.context = getContext();
    }
    return mSharedCustomAudience;
  }

  public String getFieldStartDate() {
    return mStartDate;
  }



  public static class APIRequestGet extends APIRequest<FranchiseProgram> {

    FranchiseProgram lastResponse = null;
    @Override
    public FranchiseProgram getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business_asset_group",
      "creator_business",
      "description",
      "end_date",
      "id",
      "name",
      "program_access_type",
      "program_approval_type",
      "program_image_link",
      "program_url",
      "shared_custom_audience",
      "start_date",
    };

    @Override
    public FranchiseProgram parseResponse(String response, String header) throws APIException {
      return FranchiseProgram.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public FranchiseProgram execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public FranchiseProgram execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<FranchiseProgram> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<FranchiseProgram> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, FranchiseProgram>() {
           public FranchiseProgram apply(ResponseWrapper result) {
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

    public APIRequestGet requestBusinessAssetGroupField () {
      return this.requestBusinessAssetGroupField(true);
    }
    public APIRequestGet requestBusinessAssetGroupField (boolean value) {
      this.requestField("business_asset_group", value);
      return this;
    }
    public APIRequestGet requestCreatorBusinessField () {
      return this.requestCreatorBusinessField(true);
    }
    public APIRequestGet requestCreatorBusinessField (boolean value) {
      this.requestField("creator_business", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
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
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestProgramAccessTypeField () {
      return this.requestProgramAccessTypeField(true);
    }
    public APIRequestGet requestProgramAccessTypeField (boolean value) {
      this.requestField("program_access_type", value);
      return this;
    }
    public APIRequestGet requestProgramApprovalTypeField () {
      return this.requestProgramApprovalTypeField(true);
    }
    public APIRequestGet requestProgramApprovalTypeField (boolean value) {
      this.requestField("program_approval_type", value);
      return this;
    }
    public APIRequestGet requestProgramImageLinkField () {
      return this.requestProgramImageLinkField(true);
    }
    public APIRequestGet requestProgramImageLinkField (boolean value) {
      this.requestField("program_image_link", value);
      return this;
    }
    public APIRequestGet requestProgramUrlField () {
      return this.requestProgramUrlField(true);
    }
    public APIRequestGet requestProgramUrlField (boolean value) {
      this.requestField("program_url", value);
      return this;
    }
    public APIRequestGet requestSharedCustomAudienceField () {
      return this.requestSharedCustomAudienceField(true);
    }
    public APIRequestGet requestSharedCustomAudienceField (boolean value) {
      this.requestField("shared_custom_audience", value);
      return this;
    }
    public APIRequestGet requestStartDateField () {
      return this.requestStartDateField(true);
    }
    public APIRequestGet requestStartDateField (boolean value) {
      this.requestField("start_date", value);
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

  public FranchiseProgram copyFrom(FranchiseProgram instance) {
    this.mBusinessAssetGroup = instance.mBusinessAssetGroup;
    this.mCreatorBusiness = instance.mCreatorBusiness;
    this.mDescription = instance.mDescription;
    this.mEndDate = instance.mEndDate;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mProgramAccessType = instance.mProgramAccessType;
    this.mProgramApprovalType = instance.mProgramApprovalType;
    this.mProgramImageLink = instance.mProgramImageLink;
    this.mProgramUrl = instance.mProgramUrl;
    this.mSharedCustomAudience = instance.mSharedCustomAudience;
    this.mStartDate = instance.mStartDate;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<FranchiseProgram> getParser() {
    return new APIRequest.ResponseParser<FranchiseProgram>() {
      public APINodeList<FranchiseProgram> parseResponse(String response, APIContext context, APIRequest<FranchiseProgram> request, String header) throws MalformedResponseException {
        return FranchiseProgram.parseResponse(response, context, request, header);
      }
    };
  }
}
