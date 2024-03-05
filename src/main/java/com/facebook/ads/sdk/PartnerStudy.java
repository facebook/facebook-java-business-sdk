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
public class PartnerStudy extends APINode {
  @SerializedName("additional_info")
  private String mAdditionalInfo = null;
  @SerializedName("brand")
  private String mBrand = null;
  @SerializedName("client_name")
  private String mClientName = null;
  @SerializedName("emails")
  private String mEmails = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("input_ids")
  private List<String> mInputIds = null;
  @SerializedName("is_export")
  private Boolean mIsExport = null;
  @SerializedName("lift_study")
  private AdStudy mLiftStudy = null;
  @SerializedName("location")
  private String mLocation = null;
  @SerializedName("match_file_ds")
  private String mMatchFileDs = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("partner_defined_id")
  private String mPartnerDefinedId = null;
  @SerializedName("partner_household_graph_dataset_id")
  private String mPartnerHouseholdGraphDatasetId = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("study_end_date")
  private String mStudyEndDate = null;
  @SerializedName("study_start_date")
  private String mStudyStartDate = null;
  @SerializedName("study_type")
  private String mStudyType = null;
  @SerializedName("submit_date")
  private String mSubmitDate = null;
  protected static Gson gson = null;

  PartnerStudy() {
  }

  public PartnerStudy(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PartnerStudy(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PartnerStudy fetch() throws APIException{
    PartnerStudy newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PartnerStudy fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PartnerStudy> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PartnerStudy fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PartnerStudy> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PartnerStudy> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PartnerStudy>)(
      new APIRequest<PartnerStudy>(context, "", "/", "GET", PartnerStudy.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PartnerStudy>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PartnerStudy.getParser())
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
  public static PartnerStudy loadJSON(String json, APIContext context, String header) {
    PartnerStudy partnerStudy = getGson().fromJson(json, PartnerStudy.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(partnerStudy.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    partnerStudy.context = context;
    partnerStudy.rawValue = json;
    partnerStudy.header = header;
    return partnerStudy;
  }

  public static APINodeList<PartnerStudy> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PartnerStudy> partnerStudys = new APINodeList<PartnerStudy>(request, json, header);
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
          partnerStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return partnerStudys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                partnerStudys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            partnerStudys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              partnerStudys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              partnerStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  partnerStudys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              partnerStudys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return partnerStudys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              partnerStudys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return partnerStudys;
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
              partnerStudys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return partnerStudys;
          }

          // Sixth, check if it's pure JsonObject
          partnerStudys.clear();
          partnerStudys.add(loadJSON(json, context, header));
          return partnerStudys;
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


  public String getFieldAdditionalInfo() {
    return mAdditionalInfo;
  }

  public String getFieldBrand() {
    return mBrand;
  }

  public String getFieldClientName() {
    return mClientName;
  }

  public String getFieldEmails() {
    return mEmails;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldInputIds() {
    return mInputIds;
  }

  public Boolean getFieldIsExport() {
    return mIsExport;
  }

  public AdStudy getFieldLiftStudy() {
    if (mLiftStudy != null) {
      mLiftStudy.context = getContext();
    }
    return mLiftStudy;
  }

  public String getFieldLocation() {
    return mLocation;
  }

  public String getFieldMatchFileDs() {
    return mMatchFileDs;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPartnerDefinedId() {
    return mPartnerDefinedId;
  }

  public String getFieldPartnerHouseholdGraphDatasetId() {
    return mPartnerHouseholdGraphDatasetId;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldStudyEndDate() {
    return mStudyEndDate;
  }

  public String getFieldStudyStartDate() {
    return mStudyStartDate;
  }

  public String getFieldStudyType() {
    return mStudyType;
  }

  public String getFieldSubmitDate() {
    return mSubmitDate;
  }



  public static class APIRequestGet extends APIRequest<PartnerStudy> {

    PartnerStudy lastResponse = null;
    @Override
    public PartnerStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "additional_info",
      "brand",
      "client_name",
      "emails",
      "id",
      "input_ids",
      "is_export",
      "lift_study",
      "location",
      "match_file_ds",
      "name",
      "partner_defined_id",
      "partner_household_graph_dataset_id",
      "status",
      "study_end_date",
      "study_start_date",
      "study_type",
      "submit_date",
    };

    @Override
    public PartnerStudy parseResponse(String response, String header) throws APIException {
      return PartnerStudy.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PartnerStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PartnerStudy execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PartnerStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PartnerStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PartnerStudy>() {
           public PartnerStudy apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdditionalInfoField () {
      return this.requestAdditionalInfoField(true);
    }
    public APIRequestGet requestAdditionalInfoField (boolean value) {
      this.requestField("additional_info", value);
      return this;
    }
    public APIRequestGet requestBrandField () {
      return this.requestBrandField(true);
    }
    public APIRequestGet requestBrandField (boolean value) {
      this.requestField("brand", value);
      return this;
    }
    public APIRequestGet requestClientNameField () {
      return this.requestClientNameField(true);
    }
    public APIRequestGet requestClientNameField (boolean value) {
      this.requestField("client_name", value);
      return this;
    }
    public APIRequestGet requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGet requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInputIdsField () {
      return this.requestInputIdsField(true);
    }
    public APIRequestGet requestInputIdsField (boolean value) {
      this.requestField("input_ids", value);
      return this;
    }
    public APIRequestGet requestIsExportField () {
      return this.requestIsExportField(true);
    }
    public APIRequestGet requestIsExportField (boolean value) {
      this.requestField("is_export", value);
      return this;
    }
    public APIRequestGet requestLiftStudyField () {
      return this.requestLiftStudyField(true);
    }
    public APIRequestGet requestLiftStudyField (boolean value) {
      this.requestField("lift_study", value);
      return this;
    }
    public APIRequestGet requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGet requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGet requestMatchFileDsField () {
      return this.requestMatchFileDsField(true);
    }
    public APIRequestGet requestMatchFileDsField (boolean value) {
      this.requestField("match_file_ds", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPartnerDefinedIdField () {
      return this.requestPartnerDefinedIdField(true);
    }
    public APIRequestGet requestPartnerDefinedIdField (boolean value) {
      this.requestField("partner_defined_id", value);
      return this;
    }
    public APIRequestGet requestPartnerHouseholdGraphDatasetIdField () {
      return this.requestPartnerHouseholdGraphDatasetIdField(true);
    }
    public APIRequestGet requestPartnerHouseholdGraphDatasetIdField (boolean value) {
      this.requestField("partner_household_graph_dataset_id", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestStudyEndDateField () {
      return this.requestStudyEndDateField(true);
    }
    public APIRequestGet requestStudyEndDateField (boolean value) {
      this.requestField("study_end_date", value);
      return this;
    }
    public APIRequestGet requestStudyStartDateField () {
      return this.requestStudyStartDateField(true);
    }
    public APIRequestGet requestStudyStartDateField (boolean value) {
      this.requestField("study_start_date", value);
      return this;
    }
    public APIRequestGet requestStudyTypeField () {
      return this.requestStudyTypeField(true);
    }
    public APIRequestGet requestStudyTypeField (boolean value) {
      this.requestField("study_type", value);
      return this;
    }
    public APIRequestGet requestSubmitDateField () {
      return this.requestSubmitDateField(true);
    }
    public APIRequestGet requestSubmitDateField (boolean value) {
      this.requestField("submit_date", value);
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

  public PartnerStudy copyFrom(PartnerStudy instance) {
    this.mAdditionalInfo = instance.mAdditionalInfo;
    this.mBrand = instance.mBrand;
    this.mClientName = instance.mClientName;
    this.mEmails = instance.mEmails;
    this.mId = instance.mId;
    this.mInputIds = instance.mInputIds;
    this.mIsExport = instance.mIsExport;
    this.mLiftStudy = instance.mLiftStudy;
    this.mLocation = instance.mLocation;
    this.mMatchFileDs = instance.mMatchFileDs;
    this.mName = instance.mName;
    this.mPartnerDefinedId = instance.mPartnerDefinedId;
    this.mPartnerHouseholdGraphDatasetId = instance.mPartnerHouseholdGraphDatasetId;
    this.mStatus = instance.mStatus;
    this.mStudyEndDate = instance.mStudyEndDate;
    this.mStudyStartDate = instance.mStudyStartDate;
    this.mStudyType = instance.mStudyType;
    this.mSubmitDate = instance.mSubmitDate;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PartnerStudy> getParser() {
    return new APIRequest.ResponseParser<PartnerStudy>() {
      public APINodeList<PartnerStudy> parseResponse(String response, APIContext context, APIRequest<PartnerStudy> request, String header) throws MalformedResponseException {
        return PartnerStudy.parseResponse(response, context, request, header);
      }
    };
  }
}
