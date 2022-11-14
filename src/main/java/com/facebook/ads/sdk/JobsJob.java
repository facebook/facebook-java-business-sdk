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
public class JobsJob extends APINode {
  @SerializedName("address")
  private Object mAddress = null;
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("custom_label_0")
  private String mCustomLabel0 = null;
  @SerializedName("custom_label_1")
  private String mCustomLabel1 = null;
  @SerializedName("custom_label_2")
  private String mCustomLabel2 = null;
  @SerializedName("custom_label_3")
  private String mCustomLabel3 = null;
  @SerializedName("custom_label_4")
  private String mCustomLabel4 = null;
  @SerializedName("custom_label_5")
  private String mCustomLabel5 = null;
  @SerializedName("custom_label_6")
  private String mCustomLabel6 = null;
  @SerializedName("custom_number_0")
  private Long mCustomNumber0 = null;
  @SerializedName("custom_number_1")
  private Long mCustomNumber1 = null;
  @SerializedName("custom_number_2")
  private Long mCustomNumber2 = null;
  @SerializedName("custom_number_3")
  private Long mCustomNumber3 = null;
  @SerializedName("custom_number_4")
  private Long mCustomNumber4 = null;
  @SerializedName("custom_number_5")
  private Long mCustomNumber5 = null;
  @SerializedName("custom_number_6")
  private Long mCustomNumber6 = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_fetch_status")
  private EnumImageFetchStatus mImageFetchStatus = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("jobs_job_id")
  private String mJobsJobId = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("unit_price")
  private Object mUnitPrice = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  JobsJob() {
  }

  public JobsJob(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public JobsJob(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public JobsJob fetch() throws APIException{
    JobsJob newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static JobsJob fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<JobsJob> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static JobsJob fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<JobsJob> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<JobsJob> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<JobsJob>)(
      new APIRequest<JobsJob>(context, "", "/", "GET", JobsJob.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<JobsJob>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", JobsJob.getParser())
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
  public static JobsJob loadJSON(String json, APIContext context, String header) {
    JobsJob jobsJob = getGson().fromJson(json, JobsJob.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(jobsJob.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    jobsJob.context = context;
    jobsJob.rawValue = json;
    jobsJob.header = header;
    return jobsJob;
  }

  public static APINodeList<JobsJob> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<JobsJob> jobsJobs = new APINodeList<JobsJob>(request, json, header);
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
          jobsJobs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return jobsJobs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                jobsJobs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            jobsJobs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              jobsJobs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              jobsJobs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  jobsJobs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              jobsJobs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return jobsJobs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              jobsJobs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return jobsJobs;
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
              jobsJobs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return jobsJobs;
          }

          // Sixth, check if it's pure JsonObject
          jobsJobs.clear();
          jobsJobs.add(loadJSON(json, context, header));
          return jobsJobs;
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

  public APIRequestGetAugmentedRealitiesMetadata getAugmentedRealitiesMetadata() {
    return new APIRequestGetAugmentedRealitiesMetadata(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetChannelsToIntegrityStatus getChannelsToIntegrityStatus() {
    return new APIRequestGetChannelsToIntegrityStatus(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideosMetadata getVideosMetadata() {
    return new APIRequestGetVideosMetadata(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Object getFieldAddress() {
    return mAddress;
  }

  public CatalogItemAppLinks getFieldApplinks() {
    return mApplinks;
  }

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public String getFieldCustomLabel0() {
    return mCustomLabel0;
  }

  public String getFieldCustomLabel1() {
    return mCustomLabel1;
  }

  public String getFieldCustomLabel2() {
    return mCustomLabel2;
  }

  public String getFieldCustomLabel3() {
    return mCustomLabel3;
  }

  public String getFieldCustomLabel4() {
    return mCustomLabel4;
  }

  public String getFieldCustomLabel5() {
    return mCustomLabel5;
  }

  public String getFieldCustomLabel6() {
    return mCustomLabel6;
  }

  public Long getFieldCustomNumber0() {
    return mCustomNumber0;
  }

  public Long getFieldCustomNumber1() {
    return mCustomNumber1;
  }

  public Long getFieldCustomNumber2() {
    return mCustomNumber2;
  }

  public Long getFieldCustomNumber3() {
    return mCustomNumber3;
  }

  public Long getFieldCustomNumber4() {
    return mCustomNumber4;
  }

  public Long getFieldCustomNumber5() {
    return mCustomNumber5;
  }

  public Long getFieldCustomNumber6() {
    return mCustomNumber6;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumImageFetchStatus getFieldImageFetchStatus() {
    return mImageFetchStatus;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public String getFieldJobsJobId() {
    return mJobsJobId;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public Object getFieldUnitPrice() {
    return mUnitPrice;
  }

  public String getFieldUrl() {
    return mUrl;
  }



  public static class APIRequestGetAugmentedRealitiesMetadata extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAugmentedRealitiesMetadata.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAugmentedRealitiesMetadata(String nodeId, APIContext context) {
      super(context, nodeId, "/augmented_realities_metadata", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAugmentedRealitiesMetadata requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAugmentedRealitiesMetadata requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetChannelsToIntegrityStatus extends APIRequest<CatalogItemChannelsToIntegrityStatus> {

    APINodeList<CatalogItemChannelsToIntegrityStatus> lastResponse = null;
    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "channels",
      "rejection_information",
    };

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> parseResponse(String response, String header) throws APIException {
      return CatalogItemChannelsToIntegrityStatus.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CatalogItemChannelsToIntegrityStatus>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CatalogItemChannelsToIntegrityStatus>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CatalogItemChannelsToIntegrityStatus>>() {
           public APINodeList<CatalogItemChannelsToIntegrityStatus> apply(ResponseWrapper result) {
             try {
               return APIRequestGetChannelsToIntegrityStatus.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetChannelsToIntegrityStatus(String nodeId, APIContext context) {
      super(context, nodeId, "/channels_to_integrity_status", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetChannelsToIntegrityStatus requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetChannelsToIntegrityStatus requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetChannelsToIntegrityStatus requestChannelsField () {
      return this.requestChannelsField(true);
    }
    public APIRequestGetChannelsToIntegrityStatus requestChannelsField (boolean value) {
      this.requestField("channels", value);
      return this;
    }
    public APIRequestGetChannelsToIntegrityStatus requestRejectionInformationField () {
      return this.requestRejectionInformationField(true);
    }
    public APIRequestGetChannelsToIntegrityStatus requestRejectionInformationField (boolean value) {
      this.requestField("rejection_information", value);
      return this;
    }
  }

  public static class APIRequestGetVideosMetadata extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(ResponseWrapper result) {
             try {
               return APIRequestGetVideosMetadata.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVideosMetadata(String nodeId, APIContext context) {
      super(context, nodeId, "/videos_metadata", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideosMetadata setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideosMetadata requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideosMetadata requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideosMetadata requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<JobsJob> {

    JobsJob lastResponse = null;
    @Override
    public JobsJob getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "address",
      "applinks",
      "category_specific_fields",
      "custom_label_0",
      "custom_label_1",
      "custom_label_2",
      "custom_label_3",
      "custom_label_4",
      "custom_label_5",
      "custom_label_6",
      "custom_number_0",
      "custom_number_1",
      "custom_number_2",
      "custom_number_3",
      "custom_number_4",
      "custom_number_5",
      "custom_number_6",
      "id",
      "image_fetch_status",
      "images",
      "jobs_job_id",
      "sanitized_images",
      "unit_price",
      "url",
    };

    @Override
    public JobsJob parseResponse(String response, String header) throws APIException {
      return JobsJob.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public JobsJob execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public JobsJob execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<JobsJob> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<JobsJob> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, JobsJob>() {
           public JobsJob apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
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

    public APIRequestGet requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGet requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGet requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGet requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGet requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGet requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGet requestCustomLabel0Field () {
      return this.requestCustomLabel0Field(true);
    }
    public APIRequestGet requestCustomLabel0Field (boolean value) {
      this.requestField("custom_label_0", value);
      return this;
    }
    public APIRequestGet requestCustomLabel1Field () {
      return this.requestCustomLabel1Field(true);
    }
    public APIRequestGet requestCustomLabel1Field (boolean value) {
      this.requestField("custom_label_1", value);
      return this;
    }
    public APIRequestGet requestCustomLabel2Field () {
      return this.requestCustomLabel2Field(true);
    }
    public APIRequestGet requestCustomLabel2Field (boolean value) {
      this.requestField("custom_label_2", value);
      return this;
    }
    public APIRequestGet requestCustomLabel3Field () {
      return this.requestCustomLabel3Field(true);
    }
    public APIRequestGet requestCustomLabel3Field (boolean value) {
      this.requestField("custom_label_3", value);
      return this;
    }
    public APIRequestGet requestCustomLabel4Field () {
      return this.requestCustomLabel4Field(true);
    }
    public APIRequestGet requestCustomLabel4Field (boolean value) {
      this.requestField("custom_label_4", value);
      return this;
    }
    public APIRequestGet requestCustomLabel5Field () {
      return this.requestCustomLabel5Field(true);
    }
    public APIRequestGet requestCustomLabel5Field (boolean value) {
      this.requestField("custom_label_5", value);
      return this;
    }
    public APIRequestGet requestCustomLabel6Field () {
      return this.requestCustomLabel6Field(true);
    }
    public APIRequestGet requestCustomLabel6Field (boolean value) {
      this.requestField("custom_label_6", value);
      return this;
    }
    public APIRequestGet requestCustomNumber0Field () {
      return this.requestCustomNumber0Field(true);
    }
    public APIRequestGet requestCustomNumber0Field (boolean value) {
      this.requestField("custom_number_0", value);
      return this;
    }
    public APIRequestGet requestCustomNumber1Field () {
      return this.requestCustomNumber1Field(true);
    }
    public APIRequestGet requestCustomNumber1Field (boolean value) {
      this.requestField("custom_number_1", value);
      return this;
    }
    public APIRequestGet requestCustomNumber2Field () {
      return this.requestCustomNumber2Field(true);
    }
    public APIRequestGet requestCustomNumber2Field (boolean value) {
      this.requestField("custom_number_2", value);
      return this;
    }
    public APIRequestGet requestCustomNumber3Field () {
      return this.requestCustomNumber3Field(true);
    }
    public APIRequestGet requestCustomNumber3Field (boolean value) {
      this.requestField("custom_number_3", value);
      return this;
    }
    public APIRequestGet requestCustomNumber4Field () {
      return this.requestCustomNumber4Field(true);
    }
    public APIRequestGet requestCustomNumber4Field (boolean value) {
      this.requestField("custom_number_4", value);
      return this;
    }
    public APIRequestGet requestCustomNumber5Field () {
      return this.requestCustomNumber5Field(true);
    }
    public APIRequestGet requestCustomNumber5Field (boolean value) {
      this.requestField("custom_number_5", value);
      return this;
    }
    public APIRequestGet requestCustomNumber6Field () {
      return this.requestCustomNumber6Field(true);
    }
    public APIRequestGet requestCustomNumber6Field (boolean value) {
      this.requestField("custom_number_6", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGet requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGet requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGet requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGet requestJobsJobIdField () {
      return this.requestJobsJobIdField(true);
    }
    public APIRequestGet requestJobsJobIdField (boolean value) {
      this.requestField("jobs_job_id", value);
      return this;
    }
    public APIRequestGet requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGet requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGet requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGet requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
  }

  public static enum EnumImageFetchStatus {
      @SerializedName("DIRECT_UPLOAD")
      VALUE_DIRECT_UPLOAD("DIRECT_UPLOAD"),
      @SerializedName("FETCHED")
      VALUE_FETCHED("FETCHED"),
      @SerializedName("FETCH_FAILED")
      VALUE_FETCH_FAILED("FETCH_FAILED"),
      @SerializedName("NO_STATUS")
      VALUE_NO_STATUS("NO_STATUS"),
      @SerializedName("OUTDATED")
      VALUE_OUTDATED("OUTDATED"),
      @SerializedName("PARTIAL_FETCH")
      VALUE_PARTIAL_FETCH("PARTIAL_FETCH"),
      ;

      private String value;

      private EnumImageFetchStatus(String value) {
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

  public JobsJob copyFrom(JobsJob instance) {
    this.mAddress = instance.mAddress;
    this.mApplinks = instance.mApplinks;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mCustomLabel0 = instance.mCustomLabel0;
    this.mCustomLabel1 = instance.mCustomLabel1;
    this.mCustomLabel2 = instance.mCustomLabel2;
    this.mCustomLabel3 = instance.mCustomLabel3;
    this.mCustomLabel4 = instance.mCustomLabel4;
    this.mCustomLabel5 = instance.mCustomLabel5;
    this.mCustomLabel6 = instance.mCustomLabel6;
    this.mCustomNumber0 = instance.mCustomNumber0;
    this.mCustomNumber1 = instance.mCustomNumber1;
    this.mCustomNumber2 = instance.mCustomNumber2;
    this.mCustomNumber3 = instance.mCustomNumber3;
    this.mCustomNumber4 = instance.mCustomNumber4;
    this.mCustomNumber5 = instance.mCustomNumber5;
    this.mCustomNumber6 = instance.mCustomNumber6;
    this.mId = instance.mId;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImages = instance.mImages;
    this.mJobsJobId = instance.mJobsJobId;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mUnitPrice = instance.mUnitPrice;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<JobsJob> getParser() {
    return new APIRequest.ResponseParser<JobsJob>() {
      public APINodeList<JobsJob> parseResponse(String response, APIContext context, APIRequest<JobsJob> request, String header) throws MalformedResponseException {
        return JobsJob.parseResponse(response, context, request, header);
      }
    };
  }
}
