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
public class JobOpening extends APINode {
  @SerializedName("address")
  private String mAddress = null;
  @SerializedName("application_callback_url")
  private String mApplicationCallbackUrl = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("errors")
  private List<String> mErrors = null;
  @SerializedName("external_company_facebook_url")
  private String mExternalCompanyFacebookUrl = null;
  @SerializedName("external_company_full_address")
  private String mExternalCompanyFullAddress = null;
  @SerializedName("external_company_id")
  private String mExternalCompanyId = null;
  @SerializedName("external_company_name")
  private String mExternalCompanyName = null;
  @SerializedName("external_id")
  private String mExternalId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("job_status")
  private EnumJobStatus mJobStatus = null;
  @SerializedName("latitude")
  private Double mLatitude = null;
  @SerializedName("longitude")
  private Double mLongitude = null;
  @SerializedName("offsite_application_url")
  private String mOffsiteApplicationUrl = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("photo")
  private Photo mPhoto = null;
  @SerializedName("platform_review_status")
  private EnumPlatformReviewStatus mPlatformReviewStatus = null;
  @SerializedName("post")
  private Post mPost = null;
  @SerializedName("remote_type")
  private String mRemoteType = null;
  @SerializedName("review_rejection_reasons")
  private List<EnumReviewRejectionReasons> mReviewRejectionReasons = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("type")
  private EnumType mType = null;
  protected static Gson gson = null;

  JobOpening() {
  }

  public JobOpening(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public JobOpening(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public JobOpening fetch() throws APIException{
    JobOpening newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static JobOpening fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<JobOpening> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static JobOpening fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<JobOpening> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<JobOpening> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<JobOpening>)(
      new APIRequest<JobOpening>(context, "", "/", "GET", JobOpening.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<JobOpening>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", JobOpening.getParser())
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
  public static JobOpening loadJSON(String json, APIContext context, String header) {
    JobOpening jobOpening = getGson().fromJson(json, JobOpening.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(jobOpening.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    jobOpening.context = context;
    jobOpening.rawValue = json;
    jobOpening.header = header;
    return jobOpening;
  }

  public static APINodeList<JobOpening> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<JobOpening> jobOpenings = new APINodeList<JobOpening>(request, json, header);
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
          jobOpenings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return jobOpenings;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                jobOpenings.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            jobOpenings.setPaging(previous, next);
            if (context.hasAppSecret()) {
              jobOpenings.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              jobOpenings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  jobOpenings.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              jobOpenings.add(loadJSON(obj.toString(), context, header));
            }
          }
          return jobOpenings;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              jobOpenings.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return jobOpenings;
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
              jobOpenings.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return jobOpenings;
          }

          // Sixth, check if it's pure JsonObject
          jobOpenings.clear();
          jobOpenings.add(loadJSON(json, context, header));
          return jobOpenings;
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


  public String getFieldAddress() {
    return mAddress;
  }

  public String getFieldApplicationCallbackUrl() {
    return mApplicationCallbackUrl;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public List<String> getFieldErrors() {
    return mErrors;
  }

  public String getFieldExternalCompanyFacebookUrl() {
    return mExternalCompanyFacebookUrl;
  }

  public String getFieldExternalCompanyFullAddress() {
    return mExternalCompanyFullAddress;
  }

  public String getFieldExternalCompanyId() {
    return mExternalCompanyId;
  }

  public String getFieldExternalCompanyName() {
    return mExternalCompanyName;
  }

  public String getFieldExternalId() {
    return mExternalId;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumJobStatus getFieldJobStatus() {
    return mJobStatus;
  }

  public Double getFieldLatitude() {
    return mLatitude;
  }

  public Double getFieldLongitude() {
    return mLongitude;
  }

  public String getFieldOffsiteApplicationUrl() {
    return mOffsiteApplicationUrl;
  }

  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public Photo getFieldPhoto() {
    if (mPhoto != null) {
      mPhoto.context = getContext();
    }
    return mPhoto;
  }

  public EnumPlatformReviewStatus getFieldPlatformReviewStatus() {
    return mPlatformReviewStatus;
  }

  public Post getFieldPost() {
    if (mPost != null) {
      mPost.context = getContext();
    }
    return mPost;
  }

  public String getFieldRemoteType() {
    return mRemoteType;
  }

  public List<EnumReviewRejectionReasons> getFieldReviewRejectionReasons() {
    return mReviewRejectionReasons;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public EnumType getFieldType() {
    return mType;
  }



  public static class APIRequestGet extends APIRequest<JobOpening> {

    JobOpening lastResponse = null;
    @Override
    public JobOpening getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "address",
      "application_callback_url",
      "created_time",
      "description",
      "errors",
      "external_company_facebook_url",
      "external_company_full_address",
      "external_company_id",
      "external_company_name",
      "external_id",
      "id",
      "job_status",
      "latitude",
      "longitude",
      "offsite_application_url",
      "page",
      "photo",
      "platform_review_status",
      "post",
      "remote_type",
      "review_rejection_reasons",
      "title",
      "type",
    };

    @Override
    public JobOpening parseResponse(String response, String header) throws APIException {
      return JobOpening.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public JobOpening execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public JobOpening execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<JobOpening> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<JobOpening> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, JobOpening>() {
           public JobOpening apply(ResponseWrapper result) {
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

    public APIRequestGet requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGet requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGet requestApplicationCallbackUrlField () {
      return this.requestApplicationCallbackUrlField(true);
    }
    public APIRequestGet requestApplicationCallbackUrlField (boolean value) {
      this.requestField("application_callback_url", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestErrorsField () {
      return this.requestErrorsField(true);
    }
    public APIRequestGet requestErrorsField (boolean value) {
      this.requestField("errors", value);
      return this;
    }
    public APIRequestGet requestExternalCompanyFacebookUrlField () {
      return this.requestExternalCompanyFacebookUrlField(true);
    }
    public APIRequestGet requestExternalCompanyFacebookUrlField (boolean value) {
      this.requestField("external_company_facebook_url", value);
      return this;
    }
    public APIRequestGet requestExternalCompanyFullAddressField () {
      return this.requestExternalCompanyFullAddressField(true);
    }
    public APIRequestGet requestExternalCompanyFullAddressField (boolean value) {
      this.requestField("external_company_full_address", value);
      return this;
    }
    public APIRequestGet requestExternalCompanyIdField () {
      return this.requestExternalCompanyIdField(true);
    }
    public APIRequestGet requestExternalCompanyIdField (boolean value) {
      this.requestField("external_company_id", value);
      return this;
    }
    public APIRequestGet requestExternalCompanyNameField () {
      return this.requestExternalCompanyNameField(true);
    }
    public APIRequestGet requestExternalCompanyNameField (boolean value) {
      this.requestField("external_company_name", value);
      return this;
    }
    public APIRequestGet requestExternalIdField () {
      return this.requestExternalIdField(true);
    }
    public APIRequestGet requestExternalIdField (boolean value) {
      this.requestField("external_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestJobStatusField () {
      return this.requestJobStatusField(true);
    }
    public APIRequestGet requestJobStatusField (boolean value) {
      this.requestField("job_status", value);
      return this;
    }
    public APIRequestGet requestLatitudeField () {
      return this.requestLatitudeField(true);
    }
    public APIRequestGet requestLatitudeField (boolean value) {
      this.requestField("latitude", value);
      return this;
    }
    public APIRequestGet requestLongitudeField () {
      return this.requestLongitudeField(true);
    }
    public APIRequestGet requestLongitudeField (boolean value) {
      this.requestField("longitude", value);
      return this;
    }
    public APIRequestGet requestOffsiteApplicationUrlField () {
      return this.requestOffsiteApplicationUrlField(true);
    }
    public APIRequestGet requestOffsiteApplicationUrlField (boolean value) {
      this.requestField("offsite_application_url", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestPhotoField () {
      return this.requestPhotoField(true);
    }
    public APIRequestGet requestPhotoField (boolean value) {
      this.requestField("photo", value);
      return this;
    }
    public APIRequestGet requestPlatformReviewStatusField () {
      return this.requestPlatformReviewStatusField(true);
    }
    public APIRequestGet requestPlatformReviewStatusField (boolean value) {
      this.requestField("platform_review_status", value);
      return this;
    }
    public APIRequestGet requestPostField () {
      return this.requestPostField(true);
    }
    public APIRequestGet requestPostField (boolean value) {
      this.requestField("post", value);
      return this;
    }
    public APIRequestGet requestRemoteTypeField () {
      return this.requestRemoteTypeField(true);
    }
    public APIRequestGet requestRemoteTypeField (boolean value) {
      this.requestField("remote_type", value);
      return this;
    }
    public APIRequestGet requestReviewRejectionReasonsField () {
      return this.requestReviewRejectionReasonsField(true);
    }
    public APIRequestGet requestReviewRejectionReasonsField (boolean value) {
      this.requestField("review_rejection_reasons", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
  }

  public static enum EnumJobStatus {
      @SerializedName("CLOSED")
      VALUE_CLOSED("CLOSED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("OPEN")
      VALUE_OPEN("OPEN"),
      @SerializedName("PROVISIONAL")
      VALUE_PROVISIONAL("PROVISIONAL"),
      ;

      private String value;

      private EnumJobStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPlatformReviewStatus {
      @SerializedName("APPROVED")
      VALUE_APPROVED("APPROVED"),
      @SerializedName("PENDING")
      VALUE_PENDING("PENDING"),
      @SerializedName("REJECTED")
      VALUE_REJECTED("REJECTED"),
      ;

      private String value;

      private EnumPlatformReviewStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumReviewRejectionReasons {
      @SerializedName("ADULT_CONTENT")
      VALUE_ADULT_CONTENT("ADULT_CONTENT"),
      @SerializedName("DISCRIMINATION")
      VALUE_DISCRIMINATION("DISCRIMINATION"),
      @SerializedName("DRUGS")
      VALUE_DRUGS("DRUGS"),
      @SerializedName("GENERIC_DEFAULT")
      VALUE_GENERIC_DEFAULT("GENERIC_DEFAULT"),
      @SerializedName("ILLEGAL")
      VALUE_ILLEGAL("ILLEGAL"),
      @SerializedName("IMPERSONATION")
      VALUE_IMPERSONATION("IMPERSONATION"),
      @SerializedName("MISLEADING")
      VALUE_MISLEADING("MISLEADING"),
      @SerializedName("MULTILEVEL_MARKETING")
      VALUE_MULTILEVEL_MARKETING("MULTILEVEL_MARKETING"),
      @SerializedName("PERSONAL_INFO")
      VALUE_PERSONAL_INFO("PERSONAL_INFO"),
      @SerializedName("SEXUAL")
      VALUE_SEXUAL("SEXUAL"),
      ;

      private String value;

      private EnumReviewRejectionReasons(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("CONTRACT")
      VALUE_CONTRACT("CONTRACT"),
      @SerializedName("FULL_TIME")
      VALUE_FULL_TIME("FULL_TIME"),
      @SerializedName("INTERNSHIP")
      VALUE_INTERNSHIP("INTERNSHIP"),
      @SerializedName("PART_TIME")
      VALUE_PART_TIME("PART_TIME"),
      @SerializedName("VOLUNTEER")
      VALUE_VOLUNTEER("VOLUNTEER"),
      ;

      private String value;

      private EnumType(String value) {
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

  public JobOpening copyFrom(JobOpening instance) {
    this.mAddress = instance.mAddress;
    this.mApplicationCallbackUrl = instance.mApplicationCallbackUrl;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mErrors = instance.mErrors;
    this.mExternalCompanyFacebookUrl = instance.mExternalCompanyFacebookUrl;
    this.mExternalCompanyFullAddress = instance.mExternalCompanyFullAddress;
    this.mExternalCompanyId = instance.mExternalCompanyId;
    this.mExternalCompanyName = instance.mExternalCompanyName;
    this.mExternalId = instance.mExternalId;
    this.mId = instance.mId;
    this.mJobStatus = instance.mJobStatus;
    this.mLatitude = instance.mLatitude;
    this.mLongitude = instance.mLongitude;
    this.mOffsiteApplicationUrl = instance.mOffsiteApplicationUrl;
    this.mPage = instance.mPage;
    this.mPhoto = instance.mPhoto;
    this.mPlatformReviewStatus = instance.mPlatformReviewStatus;
    this.mPost = instance.mPost;
    this.mRemoteType = instance.mRemoteType;
    this.mReviewRejectionReasons = instance.mReviewRejectionReasons;
    this.mTitle = instance.mTitle;
    this.mType = instance.mType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<JobOpening> getParser() {
    return new APIRequest.ResponseParser<JobOpening>() {
      public APINodeList<JobOpening> parseResponse(String response, APIContext context, APIRequest<JobOpening> request, String header) throws MalformedResponseException {
        return JobOpening.parseResponse(response, context, request, header);
      }
    };
  }
}
