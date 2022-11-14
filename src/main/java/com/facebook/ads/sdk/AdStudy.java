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
public class AdStudy extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("canceled_time")
  private String mCanceledTime = null;
  @SerializedName("client_business")
  private Business mClientBusiness = null;
  @SerializedName("cooldown_start_time")
  private String mCooldownStartTime = null;
  @SerializedName("created_by")
  private User mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("measurement_contact")
  private User mMeasurementContact = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("observation_end_time")
  private String mObservationEndTime = null;
  @SerializedName("results_first_available_date")
  private String mResultsFirstAvailableDate = null;
  @SerializedName("sales_contact")
  private User mSalesContact = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("updated_by")
  private User mUpdatedBy = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  AdStudy() {
  }

  public AdStudy(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdStudy(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdStudy fetch() throws APIException{
    AdStudy newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdStudy fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdStudy> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdStudy fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdStudy> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdStudy> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdStudy>)(
      new APIRequest<AdStudy>(context, "", "/", "GET", AdStudy.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdStudy>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdStudy.getParser())
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
  public static AdStudy loadJSON(String json, APIContext context, String header) {
    AdStudy adStudy = getGson().fromJson(json, AdStudy.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adStudy.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adStudy.context = context;
    adStudy.rawValue = json;
    adStudy.header = header;
    return adStudy;
  }

  public static APINodeList<AdStudy> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdStudy> adStudys = new APINodeList<AdStudy>(request, json, header);
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
          adStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adStudys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adStudys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adStudys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adStudys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adStudys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adStudys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adStudys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adStudys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adStudys;
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
              adStudys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adStudys;
          }

          // Sixth, check if it's pure JsonObject
          adStudys.clear();
          adStudys.add(loadJSON(json, context, header));
          return adStudys;
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

  public APIRequestGetCells getCells() {
    return new APIRequestGetCells(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateCheckPoint createCheckPoint() {
    return new APIRequestCreateCheckPoint(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetInstances getInstances() {
    return new APIRequestGetInstances(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateInstance createInstance() {
    return new APIRequestCreateInstance(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetObjectives getObjectives() {
    return new APIRequestGetObjectives(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldCanceledTime() {
    return mCanceledTime;
  }

  public Business getFieldClientBusiness() {
    if (mClientBusiness != null) {
      mClientBusiness.context = getContext();
    }
    return mClientBusiness;
  }

  public String getFieldCooldownStartTime() {
    return mCooldownStartTime;
  }

  public User getFieldCreatedBy() {
    if (mCreatedBy != null) {
      mCreatedBy.context = getContext();
    }
    return mCreatedBy;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEndTime() {
    return mEndTime;
  }

  public String getFieldId() {
    return mId;
  }

  public User getFieldMeasurementContact() {
    if (mMeasurementContact != null) {
      mMeasurementContact.context = getContext();
    }
    return mMeasurementContact;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldObservationEndTime() {
    return mObservationEndTime;
  }

  public String getFieldResultsFirstAvailableDate() {
    return mResultsFirstAvailableDate;
  }

  public User getFieldSalesContact() {
    if (mSalesContact != null) {
      mSalesContact.context = getContext();
    }
    return mSalesContact;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public String getFieldType() {
    return mType;
  }

  public User getFieldUpdatedBy() {
    if (mUpdatedBy != null) {
      mUpdatedBy.context = getContext();
    }
    return mUpdatedBy;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestGetCells extends APIRequest<AdStudyCell> {

    APINodeList<AdStudyCell> lastResponse = null;
    @Override
    public APINodeList<AdStudyCell> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_entities_count",
      "control_percentage",
      "id",
      "name",
      "treatment_percentage",
    };

    @Override
    public APINodeList<AdStudyCell> parseResponse(String response, String header) throws APIException {
      return AdStudyCell.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdStudyCell> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudyCell> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudyCell>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudyCell>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdStudyCell>>() {
           public APINodeList<AdStudyCell> apply(ResponseWrapper result) {
             try {
               return APIRequestGetCells.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCells(String nodeId, APIContext context) {
      super(context, nodeId, "/cells", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCells setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCells setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCells requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCells requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCells requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCells requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCells requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCells requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCells requestAdEntitiesCountField () {
      return this.requestAdEntitiesCountField(true);
    }
    public APIRequestGetCells requestAdEntitiesCountField (boolean value) {
      this.requestField("ad_entities_count", value);
      return this;
    }
    public APIRequestGetCells requestControlPercentageField () {
      return this.requestControlPercentageField(true);
    }
    public APIRequestGetCells requestControlPercentageField (boolean value) {
      this.requestField("control_percentage", value);
      return this;
    }
    public APIRequestGetCells requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCells requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCells requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCells requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCells requestTreatmentPercentageField () {
      return this.requestTreatmentPercentageField(true);
    }
    public APIRequestGetCells requestTreatmentPercentageField (boolean value) {
      this.requestField("treatment_percentage", value);
      return this;
    }
  }

  public static class APIRequestCreateCheckPoint extends APIRequest<AdStudy> {

    AdStudy lastResponse = null;
    @Override
    public AdStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "checkpoint_data",
      "checkpoint_name",
      "component",
      "instance_id",
      "run_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudy parseResponse(String response, String header) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdStudy>() {
           public AdStudy apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCheckPoint.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCheckPoint(String nodeId, APIContext context) {
      super(context, nodeId, "/checkpoint", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCheckPoint setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCheckPoint setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCheckPoint setCheckpointData (String checkpointData) {
      this.setParam("checkpoint_data", checkpointData);
      return this;
    }

    public APIRequestCreateCheckPoint setCheckpointName (String checkpointName) {
      this.setParam("checkpoint_name", checkpointName);
      return this;
    }

    public APIRequestCreateCheckPoint setComponent (String component) {
      this.setParam("component", component);
      return this;
    }

    public APIRequestCreateCheckPoint setInstanceId (String instanceId) {
      this.setParam("instance_id", instanceId);
      return this;
    }

    public APIRequestCreateCheckPoint setRunId (String runId) {
      this.setParam("run_id", runId);
      return this;
    }

    public APIRequestCreateCheckPoint requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCheckPoint requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCheckPoint requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCheckPoint requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCheckPoint requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCheckPoint requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetInstances extends APIRequest<PrivateLiftStudyInstance> {

    APINodeList<PrivateLiftStudyInstance> lastResponse = null;
    @Override
    public APINodeList<PrivateLiftStudyInstance> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "breakdown_key",
      "created_time",
      "feature_list",
      "id",
      "latest_status_update_time",
      "run_id",
      "server_ips",
      "status",
      "tier",
    };

    @Override
    public APINodeList<PrivateLiftStudyInstance> parseResponse(String response, String header) throws APIException {
      return PrivateLiftStudyInstance.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<PrivateLiftStudyInstance> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<PrivateLiftStudyInstance> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<PrivateLiftStudyInstance>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<PrivateLiftStudyInstance>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<PrivateLiftStudyInstance>>() {
           public APINodeList<PrivateLiftStudyInstance> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInstances.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInstances(String nodeId, APIContext context) {
      super(context, nodeId, "/instances", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInstances setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInstances setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInstances requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInstances requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstances requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInstances requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstances requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInstances requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInstances requestBreakdownKeyField () {
      return this.requestBreakdownKeyField(true);
    }
    public APIRequestGetInstances requestBreakdownKeyField (boolean value) {
      this.requestField("breakdown_key", value);
      return this;
    }
    public APIRequestGetInstances requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetInstances requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetInstances requestFeatureListField () {
      return this.requestFeatureListField(true);
    }
    public APIRequestGetInstances requestFeatureListField (boolean value) {
      this.requestField("feature_list", value);
      return this;
    }
    public APIRequestGetInstances requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInstances requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInstances requestLatestStatusUpdateTimeField () {
      return this.requestLatestStatusUpdateTimeField(true);
    }
    public APIRequestGetInstances requestLatestStatusUpdateTimeField (boolean value) {
      this.requestField("latest_status_update_time", value);
      return this;
    }
    public APIRequestGetInstances requestRunIdField () {
      return this.requestRunIdField(true);
    }
    public APIRequestGetInstances requestRunIdField (boolean value) {
      this.requestField("run_id", value);
      return this;
    }
    public APIRequestGetInstances requestServerIpsField () {
      return this.requestServerIpsField(true);
    }
    public APIRequestGetInstances requestServerIpsField (boolean value) {
      this.requestField("server_ips", value);
      return this;
    }
    public APIRequestGetInstances requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetInstances requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetInstances requestTierField () {
      return this.requestTierField(true);
    }
    public APIRequestGetInstances requestTierField (boolean value) {
      this.requestField("tier", value);
      return this;
    }
  }

  public static class APIRequestCreateInstance extends APIRequest<PrivateLiftStudyInstance> {

    PrivateLiftStudyInstance lastResponse = null;
    @Override
    public PrivateLiftStudyInstance getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "breakdown_key",
      "run_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PrivateLiftStudyInstance parseResponse(String response, String header) throws APIException {
      return PrivateLiftStudyInstance.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PrivateLiftStudyInstance execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PrivateLiftStudyInstance execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PrivateLiftStudyInstance> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PrivateLiftStudyInstance> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PrivateLiftStudyInstance>() {
           public PrivateLiftStudyInstance apply(ResponseWrapper result) {
             try {
               return APIRequestCreateInstance.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateInstance(String nodeId, APIContext context) {
      super(context, nodeId, "/instances", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateInstance setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateInstance setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateInstance setBreakdownKey (Map<String, String> breakdownKey) {
      this.setParam("breakdown_key", breakdownKey);
      return this;
    }
    public APIRequestCreateInstance setBreakdownKey (String breakdownKey) {
      this.setParam("breakdown_key", breakdownKey);
      return this;
    }

    public APIRequestCreateInstance setRunId (String runId) {
      this.setParam("run_id", runId);
      return this;
    }

    public APIRequestCreateInstance requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateInstance requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInstance requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateInstance requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateInstance requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateInstance requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetObjectives extends APIRequest<AdStudyObjective> {

    APINodeList<AdStudyObjective> lastResponse = null;
    @Override
    public APINodeList<AdStudyObjective> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "is_primary",
      "last_updated_results",
      "name",
      "results",
      "type",
    };

    @Override
    public APINodeList<AdStudyObjective> parseResponse(String response, String header) throws APIException {
      return AdStudyObjective.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdStudyObjective> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudyObjective> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudyObjective>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudyObjective>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdStudyObjective>>() {
           public APINodeList<AdStudyObjective> apply(ResponseWrapper result) {
             try {
               return APIRequestGetObjectives.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetObjectives(String nodeId, APIContext context) {
      super(context, nodeId, "/objectives", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetObjectives setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetObjectives setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetObjectives requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetObjectives requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetObjectives requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetObjectives requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetObjectives requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetObjectives requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetObjectives requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetObjectives requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetObjectives requestIsPrimaryField () {
      return this.requestIsPrimaryField(true);
    }
    public APIRequestGetObjectives requestIsPrimaryField (boolean value) {
      this.requestField("is_primary", value);
      return this;
    }
    public APIRequestGetObjectives requestLastUpdatedResultsField () {
      return this.requestLastUpdatedResultsField(true);
    }
    public APIRequestGetObjectives requestLastUpdatedResultsField (boolean value) {
      this.requestField("last_updated_results", value);
      return this;
    }
    public APIRequestGetObjectives requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetObjectives requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetObjectives requestResultsField () {
      return this.requestResultsField(true);
    }
    public APIRequestGetObjectives requestResultsField (boolean value) {
      this.requestField("results", value);
      return this;
    }
    public APIRequestGetObjectives requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGetObjectives requestTypeField (boolean value) {
      this.requestField("type", value);
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
         }
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

  public static class APIRequestGet extends APIRequest<AdStudy> {

    AdStudy lastResponse = null;
    @Override
    public AdStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "canceled_time",
      "client_business",
      "cooldown_start_time",
      "created_by",
      "created_time",
      "description",
      "end_time",
      "id",
      "measurement_contact",
      "name",
      "observation_end_time",
      "results_first_available_date",
      "sales_contact",
      "start_time",
      "type",
      "updated_by",
      "updated_time",
    };

    @Override
    public AdStudy parseResponse(String response, String header) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdStudy>() {
           public AdStudy apply(ResponseWrapper result) {
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

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestCanceledTimeField () {
      return this.requestCanceledTimeField(true);
    }
    public APIRequestGet requestCanceledTimeField (boolean value) {
      this.requestField("canceled_time", value);
      return this;
    }
    public APIRequestGet requestClientBusinessField () {
      return this.requestClientBusinessField(true);
    }
    public APIRequestGet requestClientBusinessField (boolean value) {
      this.requestField("client_business", value);
      return this;
    }
    public APIRequestGet requestCooldownStartTimeField () {
      return this.requestCooldownStartTimeField(true);
    }
    public APIRequestGet requestCooldownStartTimeField (boolean value) {
      this.requestField("cooldown_start_time", value);
      return this;
    }
    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
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
    public APIRequestGet requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGet requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMeasurementContactField () {
      return this.requestMeasurementContactField(true);
    }
    public APIRequestGet requestMeasurementContactField (boolean value) {
      this.requestField("measurement_contact", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestObservationEndTimeField () {
      return this.requestObservationEndTimeField(true);
    }
    public APIRequestGet requestObservationEndTimeField (boolean value) {
      this.requestField("observation_end_time", value);
      return this;
    }
    public APIRequestGet requestResultsFirstAvailableDateField () {
      return this.requestResultsFirstAvailableDateField(true);
    }
    public APIRequestGet requestResultsFirstAvailableDateField (boolean value) {
      this.requestField("results_first_available_date", value);
      return this;
    }
    public APIRequestGet requestSalesContactField () {
      return this.requestSalesContactField(true);
    }
    public APIRequestGet requestSalesContactField (boolean value) {
      this.requestField("sales_contact", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGet requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGet requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdStudy> {

    AdStudy lastResponse = null;
    @Override
    public AdStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "cells",
      "client_business",
      "confidence_level",
      "cooldown_start_time",
      "description",
      "end_time",
      "name",
      "objectives",
      "observation_end_time",
      "start_time",
      "type",
      "viewers",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudy parseResponse(String response, String header) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdStudy>() {
           public AdStudy apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestUpdate setCells (List<Object> cells) {
      this.setParam("cells", cells);
      return this;
    }
    public APIRequestUpdate setCells (String cells) {
      this.setParam("cells", cells);
      return this;
    }

    public APIRequestUpdate setClientBusiness (String clientBusiness) {
      this.setParam("client_business", clientBusiness);
      return this;
    }

    public APIRequestUpdate setConfidenceLevel (Double confidenceLevel) {
      this.setParam("confidence_level", confidenceLevel);
      return this;
    }
    public APIRequestUpdate setConfidenceLevel (String confidenceLevel) {
      this.setParam("confidence_level", confidenceLevel);
      return this;
    }

    public APIRequestUpdate setCooldownStartTime (Long cooldownStartTime) {
      this.setParam("cooldown_start_time", cooldownStartTime);
      return this;
    }
    public APIRequestUpdate setCooldownStartTime (String cooldownStartTime) {
      this.setParam("cooldown_start_time", cooldownStartTime);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setEndTime (Long endTime) {
      this.setParam("end_time", endTime);
      return this;
    }
    public APIRequestUpdate setEndTime (String endTime) {
      this.setParam("end_time", endTime);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setObjectives (List<Object> objectives) {
      this.setParam("objectives", objectives);
      return this;
    }
    public APIRequestUpdate setObjectives (String objectives) {
      this.setParam("objectives", objectives);
      return this;
    }

    public APIRequestUpdate setObservationEndTime (Long observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
      return this;
    }
    public APIRequestUpdate setObservationEndTime (String observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
      return this;
    }

    public APIRequestUpdate setStartTime (Long startTime) {
      this.setParam("start_time", startTime);
      return this;
    }
    public APIRequestUpdate setStartTime (String startTime) {
      this.setParam("start_time", startTime);
      return this;
    }

    public APIRequestUpdate setType (AdStudy.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestUpdate setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestUpdate setViewers (List<Long> viewers) {
      this.setParam("viewers", viewers);
      return this;
    }
    public APIRequestUpdate setViewers (String viewers) {
      this.setParam("viewers", viewers);
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

  public static enum EnumType {
      @SerializedName("CONTINUOUS_LIFT_CONFIG")
      VALUE_CONTINUOUS_LIFT_CONFIG("CONTINUOUS_LIFT_CONFIG"),
      @SerializedName("GEO_LIFT")
      VALUE_GEO_LIFT("GEO_LIFT"),
      @SerializedName("LIFT")
      VALUE_LIFT("LIFT"),
      @SerializedName("SPLIT_TEST")
      VALUE_SPLIT_TEST("SPLIT_TEST"),
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

  public AdStudy copyFrom(AdStudy instance) {
    this.mBusiness = instance.mBusiness;
    this.mCanceledTime = instance.mCanceledTime;
    this.mClientBusiness = instance.mClientBusiness;
    this.mCooldownStartTime = instance.mCooldownStartTime;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mMeasurementContact = instance.mMeasurementContact;
    this.mName = instance.mName;
    this.mObservationEndTime = instance.mObservationEndTime;
    this.mResultsFirstAvailableDate = instance.mResultsFirstAvailableDate;
    this.mSalesContact = instance.mSalesContact;
    this.mStartTime = instance.mStartTime;
    this.mType = instance.mType;
    this.mUpdatedBy = instance.mUpdatedBy;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdStudy> getParser() {
    return new APIRequest.ResponseParser<AdStudy>() {
      public APINodeList<AdStudy> parseResponse(String response, APIContext context, APIRequest<AdStudy> request, String header) throws MalformedResponseException {
        return AdStudy.parseResponse(response, context, request, header);
      }
    };
  }
}
