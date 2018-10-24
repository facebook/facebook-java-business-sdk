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
  @SerializedName("name")
  private String mName = null;
  @SerializedName("observation_end_time")
  private String mObservationEndTime = null;
  @SerializedName("results_first_available_date")
  private String mResultsFirstAvailableDate = null;
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
  public static AdStudy loadJSON(String json, APIContext context) {
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
      };
    }
    adStudy.context = context;
    adStudy.rawValue = json;
    return adStudy;
  }

  public static APINodeList<AdStudy> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdStudy> adStudys = new APINodeList<AdStudy>(request, json);
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
          adStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
              adStudys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adStudys.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adStudys.add(loadJSON(obj.toString(), context));
            }
          }
          return adStudys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adStudys.add(loadJSON(entry.getValue().toString(), context));
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
              adStudys.add(loadJSON(value.toString(), context));
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
          adStudys.add(loadJSON(json, context));
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

  public APIRequestCreateCustomAudience createCustomAudience() {
    return new APIRequestCreateCustomAudience(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetHealthCheckErrors getHealthCheckErrors() {
    return new APIRequestGetHealthCheckErrors(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetObjectives getObjectives() {
    return new APIRequestGetObjectives(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateObjective createObjective() {
    return new APIRequestCreateObjective(this.getPrefixedId().toString(), context);
  }

  public APIRequestDeleteUserPermissions deleteUserPermissions() {
    return new APIRequestDeleteUserPermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetUserPermissions getUserPermissions() {
    return new APIRequestGetUserPermissions(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateUserPermission createUserPermission() {
    return new APIRequestCreateUserPermission(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetViewers getViewers() {
    return new APIRequestGetViewers(this.getPrefixedId().toString(), context);
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

  public String getFieldName() {
    return mName;
  }

  public String getFieldObservationEndTime() {
    return mObservationEndTime;
  }

  public String getFieldResultsFirstAvailableDate() {
    return mResultsFirstAvailableDate;
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
    public APINodeList<AdStudyCell> parseResponse(String response) throws APIException {
      return AdStudyCell.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdStudyCell> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudyCell> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudyCell>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudyCell>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdStudyCell>>() {
           public APINodeList<AdStudyCell> apply(String result) {
             try {
               return APIRequestGetCells.this.parseResponse(result);
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

  public static class APIRequestCreateCustomAudience extends APIRequest<AdStudy> {

    AdStudy lastResponse = null;
    @Override
    public AdStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "cell_id",
      "objective_id",
      "account_id",
      "audience_name",
      "audience_type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudy parseResponse(String response) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudy>() {
           public AdStudy apply(String result) {
             try {
               return APIRequestCreateCustomAudience.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCustomAudience(String nodeId, APIContext context) {
      super(context, nodeId, "/customaudiences", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCustomAudience setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCustomAudience setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateCustomAudience setCellId (String cellId) {
      this.setParam("cell_id", cellId);
      return this;
    }

    public APIRequestCreateCustomAudience setObjectiveId (String objectiveId) {
      this.setParam("objective_id", objectiveId);
      return this;
    }

    public APIRequestCreateCustomAudience setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestCreateCustomAudience setAudienceName (String audienceName) {
      this.setParam("audience_name", audienceName);
      return this;
    }

    public APIRequestCreateCustomAudience setAudienceType (AdStudy.EnumAudienceType audienceType) {
      this.setParam("audience_type", audienceType);
      return this;
    }
    public APIRequestCreateCustomAudience setAudienceType (String audienceType) {
      this.setParam("audience_type", audienceType);
      return this;
    }

    public APIRequestCreateCustomAudience requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCustomAudience requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCustomAudience requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCustomAudience requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCustomAudience requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCustomAudience requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetHealthCheckErrors extends APIRequest<AdsTALHealthCheckError> {

    APINodeList<AdsTALHealthCheckError> lastResponse = null;
    @Override
    public APINodeList<AdsTALHealthCheckError> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "error_code",
      "target_id",
      "id",
    };

    @Override
    public APINodeList<AdsTALHealthCheckError> parseResponse(String response) throws APIException {
      return AdsTALHealthCheckError.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsTALHealthCheckError> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsTALHealthCheckError> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsTALHealthCheckError>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsTALHealthCheckError>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdsTALHealthCheckError>>() {
           public APINodeList<AdsTALHealthCheckError> apply(String result) {
             try {
               return APIRequestGetHealthCheckErrors.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetHealthCheckErrors(String nodeId, APIContext context) {
      super(context, nodeId, "/health_check_errors", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetHealthCheckErrors setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetHealthCheckErrors setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetHealthCheckErrors requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetHealthCheckErrors requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHealthCheckErrors requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetHealthCheckErrors requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetHealthCheckErrors requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetHealthCheckErrors requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetHealthCheckErrors requestErrorCodeField () {
      return this.requestErrorCodeField(true);
    }
    public APIRequestGetHealthCheckErrors requestErrorCodeField (boolean value) {
      this.requestField("error_code", value);
      return this;
    }
    public APIRequestGetHealthCheckErrors requestTargetIdField () {
      return this.requestTargetIdField(true);
    }
    public APIRequestGetHealthCheckErrors requestTargetIdField (boolean value) {
      this.requestField("target_id", value);
      return this;
    }
    public APIRequestGetHealthCheckErrors requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetHealthCheckErrors requestIdField (boolean value) {
      this.requestField("id", value);
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
      "custom_attributes",
      "id",
      "is_primary",
      "last_updated_results",
      "name",
      "results",
      "type",
    };

    @Override
    public APINodeList<AdStudyObjective> parseResponse(String response) throws APIException {
      return AdStudyObjective.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdStudyObjective> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudyObjective> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudyObjective>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudyObjective>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdStudyObjective>>() {
           public APINodeList<AdStudyObjective> apply(String result) {
             try {
               return APIRequestGetObjectives.this.parseResponse(result);
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

    public APIRequestGetObjectives requestCustomAttributesField () {
      return this.requestCustomAttributesField(true);
    }
    public APIRequestGetObjectives requestCustomAttributesField (boolean value) {
      this.requestField("custom_attributes", value);
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

  public static class APIRequestCreateObjective extends APIRequest<AdStudyObjective> {

    AdStudyObjective lastResponse = null;
    @Override
    public AdStudyObjective getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "is_primary",
      "name",
      "type",
      "adspixels",
      "customconversions",
      "applications",
      "offsitepixels",
      "offline_conversion_data_sets",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudyObjective parseResponse(String response) throws APIException {
      return AdStudyObjective.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudyObjective execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudyObjective execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudyObjective> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudyObjective> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudyObjective>() {
           public AdStudyObjective apply(String result) {
             try {
               return APIRequestCreateObjective.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateObjective(String nodeId, APIContext context) {
      super(context, nodeId, "/objectives", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateObjective setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateObjective setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateObjective setIsPrimary (Boolean isPrimary) {
      this.setParam("is_primary", isPrimary);
      return this;
    }
    public APIRequestCreateObjective setIsPrimary (String isPrimary) {
      this.setParam("is_primary", isPrimary);
      return this;
    }

    public APIRequestCreateObjective setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestCreateObjective setType (AdStudyObjective.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestCreateObjective setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestCreateObjective setAdspixels (List<Object> adspixels) {
      this.setParam("adspixels", adspixels);
      return this;
    }
    public APIRequestCreateObjective setAdspixels (String adspixels) {
      this.setParam("adspixels", adspixels);
      return this;
    }

    public APIRequestCreateObjective setCustomconversions (List<Object> customconversions) {
      this.setParam("customconversions", customconversions);
      return this;
    }
    public APIRequestCreateObjective setCustomconversions (String customconversions) {
      this.setParam("customconversions", customconversions);
      return this;
    }

    public APIRequestCreateObjective setApplications (List<Object> applications) {
      this.setParam("applications", applications);
      return this;
    }
    public APIRequestCreateObjective setApplications (String applications) {
      this.setParam("applications", applications);
      return this;
    }

    public APIRequestCreateObjective setOffsitepixels (List<Object> offsitepixels) {
      this.setParam("offsitepixels", offsitepixels);
      return this;
    }
    public APIRequestCreateObjective setOffsitepixels (String offsitepixels) {
      this.setParam("offsitepixels", offsitepixels);
      return this;
    }

    public APIRequestCreateObjective setOfflineConversionDataSets (List<Object> offlineConversionDataSets) {
      this.setParam("offline_conversion_data_sets", offlineConversionDataSets);
      return this;
    }
    public APIRequestCreateObjective setOfflineConversionDataSets (String offlineConversionDataSets) {
      this.setParam("offline_conversion_data_sets", offlineConversionDataSets);
      return this;
    }

    public APIRequestCreateObjective requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateObjective requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateObjective requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateObjective requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateObjective requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateObjective requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestDeleteUserPermissions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
      "email",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteUserPermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteUserPermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteUserPermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteUserPermissions setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestDeleteUserPermissions setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestDeleteUserPermissions setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestDeleteUserPermissions setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestDeleteUserPermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteUserPermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteUserPermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteUserPermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetUserPermissions extends APIRequest<AdStudyAdsAssetUserPermissions> {

    APINodeList<AdStudyAdsAssetUserPermissions> lastResponse = null;
    @Override
    public APINodeList<AdStudyAdsAssetUserPermissions> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "business_persona",
      "created_by",
      "created_time",
      "email",
      "role",
      "status",
      "updated_by",
      "updated_time",
      "user",
      "id",
    };

    @Override
    public APINodeList<AdStudyAdsAssetUserPermissions> parseResponse(String response) throws APIException {
      return AdStudyAdsAssetUserPermissions.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdStudyAdsAssetUserPermissions> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdStudyAdsAssetUserPermissions> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdStudyAdsAssetUserPermissions>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdStudyAdsAssetUserPermissions>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<AdStudyAdsAssetUserPermissions>>() {
           public APINodeList<AdStudyAdsAssetUserPermissions> apply(String result) {
             try {
               return APIRequestGetUserPermissions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetUserPermissions(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetUserPermissions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetUserPermissions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetUserPermissions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetUserPermissions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUserPermissions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetUserPermissions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetUserPermissions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetUserPermissions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetUserPermissions requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGetUserPermissions requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGetUserPermissions requestBusinessPersonaField () {
      return this.requestBusinessPersonaField(true);
    }
    public APIRequestGetUserPermissions requestBusinessPersonaField (boolean value) {
      this.requestField("business_persona", value);
      return this;
    }
    public APIRequestGetUserPermissions requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGetUserPermissions requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGetUserPermissions requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetUserPermissions requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetUserPermissions requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetUserPermissions requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetUserPermissions requestRoleField () {
      return this.requestRoleField(true);
    }
    public APIRequestGetUserPermissions requestRoleField (boolean value) {
      this.requestField("role", value);
      return this;
    }
    public APIRequestGetUserPermissions requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetUserPermissions requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetUserPermissions requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGetUserPermissions requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGetUserPermissions requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetUserPermissions requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetUserPermissions requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGetUserPermissions requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
    public APIRequestGetUserPermissions requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetUserPermissions requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static class APIRequestCreateUserPermission extends APIRequest<AdStudy> {

    AdStudy lastResponse = null;
    @Override
    public AdStudy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user",
      "email",
      "role",
      "business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudy parseResponse(String response) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudy>() {
           public AdStudy apply(String result) {
             try {
               return APIRequestCreateUserPermission.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateUserPermission(String nodeId, APIContext context) {
      super(context, nodeId, "/userpermissions", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateUserPermission setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateUserPermission setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateUserPermission setUser (Long user) {
      this.setParam("user", user);
      return this;
    }
    public APIRequestCreateUserPermission setUser (String user) {
      this.setParam("user", user);
      return this;
    }

    public APIRequestCreateUserPermission setEmail (String email) {
      this.setParam("email", email);
      return this;
    }

    public APIRequestCreateUserPermission setRole (AdStudy.EnumRole role) {
      this.setParam("role", role);
      return this;
    }
    public APIRequestCreateUserPermission setRole (String role) {
      this.setParam("role", role);
      return this;
    }

    public APIRequestCreateUserPermission setBusiness (String business) {
      this.setParam("business", business);
      return this;
    }

    public APIRequestCreateUserPermission requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateUserPermission requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateUserPermission requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateUserPermission requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetViewers extends APIRequest<User> {

    APINodeList<User> lastResponse = null;
    @Override
    public APINodeList<User> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "about",
      "address",
      "admin_notes",
      "age_range",
      "bio",
      "birthday",
      "can_review_measurement_request",
      "context",
      "cover",
      "currency",
      "devices",
      "education",
      "email",
      "employee_number",
      "favorite_athletes",
      "favorite_teams",
      "first_name",
      "gender",
      "hometown",
      "id",
      "inspirational_people",
      "install_type",
      "installed",
      "interested_in",
      "is_famedeeplinkinguser",
      "is_shared_login",
      "is_verified",
      "labels",
      "languages",
      "last_name",
      "link",
      "local_news_megaphone_dismiss_status",
      "local_news_subscription_status",
      "locale",
      "location",
      "meeting_for",
      "middle_name",
      "name",
      "name_format",
      "payment_pricepoints",
      "political",
      "profile_pic",
      "public_key",
      "quotes",
      "relationship_status",
      "religion",
      "security_settings",
      "shared_login_upgrade_required_by",
      "short_name",
      "significant_other",
      "sports",
      "test_group",
      "third_party_id",
      "timezone",
      "token_for_business",
      "updated_time",
      "username",
      "verified",
      "video_upload_limits",
      "viewer_can_send_gift",
      "website",
      "work",
    };

    @Override
    public APINodeList<User> parseResponse(String response) throws APIException {
      return User.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<User> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<User> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<User>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<User>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<User>>() {
           public APINodeList<User> apply(String result) {
             try {
               return APIRequestGetViewers.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetViewers(String nodeId, APIContext context) {
      super(context, nodeId, "/viewers", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetViewers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetViewers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetViewers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetViewers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetViewers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetViewers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetViewers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetViewers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetViewers requestAboutField () {
      return this.requestAboutField(true);
    }
    public APIRequestGetViewers requestAboutField (boolean value) {
      this.requestField("about", value);
      return this;
    }
    public APIRequestGetViewers requestAddressField () {
      return this.requestAddressField(true);
    }
    public APIRequestGetViewers requestAddressField (boolean value) {
      this.requestField("address", value);
      return this;
    }
    public APIRequestGetViewers requestAdminNotesField () {
      return this.requestAdminNotesField(true);
    }
    public APIRequestGetViewers requestAdminNotesField (boolean value) {
      this.requestField("admin_notes", value);
      return this;
    }
    public APIRequestGetViewers requestAgeRangeField () {
      return this.requestAgeRangeField(true);
    }
    public APIRequestGetViewers requestAgeRangeField (boolean value) {
      this.requestField("age_range", value);
      return this;
    }
    public APIRequestGetViewers requestBioField () {
      return this.requestBioField(true);
    }
    public APIRequestGetViewers requestBioField (boolean value) {
      this.requestField("bio", value);
      return this;
    }
    public APIRequestGetViewers requestBirthdayField () {
      return this.requestBirthdayField(true);
    }
    public APIRequestGetViewers requestBirthdayField (boolean value) {
      this.requestField("birthday", value);
      return this;
    }
    public APIRequestGetViewers requestCanReviewMeasurementRequestField () {
      return this.requestCanReviewMeasurementRequestField(true);
    }
    public APIRequestGetViewers requestCanReviewMeasurementRequestField (boolean value) {
      this.requestField("can_review_measurement_request", value);
      return this;
    }
    public APIRequestGetViewers requestContextField () {
      return this.requestContextField(true);
    }
    public APIRequestGetViewers requestContextField (boolean value) {
      this.requestField("context", value);
      return this;
    }
    public APIRequestGetViewers requestCoverField () {
      return this.requestCoverField(true);
    }
    public APIRequestGetViewers requestCoverField (boolean value) {
      this.requestField("cover", value);
      return this;
    }
    public APIRequestGetViewers requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGetViewers requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGetViewers requestDevicesField () {
      return this.requestDevicesField(true);
    }
    public APIRequestGetViewers requestDevicesField (boolean value) {
      this.requestField("devices", value);
      return this;
    }
    public APIRequestGetViewers requestEducationField () {
      return this.requestEducationField(true);
    }
    public APIRequestGetViewers requestEducationField (boolean value) {
      this.requestField("education", value);
      return this;
    }
    public APIRequestGetViewers requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGetViewers requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGetViewers requestEmployeeNumberField () {
      return this.requestEmployeeNumberField(true);
    }
    public APIRequestGetViewers requestEmployeeNumberField (boolean value) {
      this.requestField("employee_number", value);
      return this;
    }
    public APIRequestGetViewers requestFavoriteAthletesField () {
      return this.requestFavoriteAthletesField(true);
    }
    public APIRequestGetViewers requestFavoriteAthletesField (boolean value) {
      this.requestField("favorite_athletes", value);
      return this;
    }
    public APIRequestGetViewers requestFavoriteTeamsField () {
      return this.requestFavoriteTeamsField(true);
    }
    public APIRequestGetViewers requestFavoriteTeamsField (boolean value) {
      this.requestField("favorite_teams", value);
      return this;
    }
    public APIRequestGetViewers requestFirstNameField () {
      return this.requestFirstNameField(true);
    }
    public APIRequestGetViewers requestFirstNameField (boolean value) {
      this.requestField("first_name", value);
      return this;
    }
    public APIRequestGetViewers requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetViewers requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetViewers requestHometownField () {
      return this.requestHometownField(true);
    }
    public APIRequestGetViewers requestHometownField (boolean value) {
      this.requestField("hometown", value);
      return this;
    }
    public APIRequestGetViewers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetViewers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetViewers requestInspirationalPeopleField () {
      return this.requestInspirationalPeopleField(true);
    }
    public APIRequestGetViewers requestInspirationalPeopleField (boolean value) {
      this.requestField("inspirational_people", value);
      return this;
    }
    public APIRequestGetViewers requestInstallTypeField () {
      return this.requestInstallTypeField(true);
    }
    public APIRequestGetViewers requestInstallTypeField (boolean value) {
      this.requestField("install_type", value);
      return this;
    }
    public APIRequestGetViewers requestInstalledField () {
      return this.requestInstalledField(true);
    }
    public APIRequestGetViewers requestInstalledField (boolean value) {
      this.requestField("installed", value);
      return this;
    }
    public APIRequestGetViewers requestInterestedInField () {
      return this.requestInterestedInField(true);
    }
    public APIRequestGetViewers requestInterestedInField (boolean value) {
      this.requestField("interested_in", value);
      return this;
    }
    public APIRequestGetViewers requestIsFamedeeplinkinguserField () {
      return this.requestIsFamedeeplinkinguserField(true);
    }
    public APIRequestGetViewers requestIsFamedeeplinkinguserField (boolean value) {
      this.requestField("is_famedeeplinkinguser", value);
      return this;
    }
    public APIRequestGetViewers requestIsSharedLoginField () {
      return this.requestIsSharedLoginField(true);
    }
    public APIRequestGetViewers requestIsSharedLoginField (boolean value) {
      this.requestField("is_shared_login", value);
      return this;
    }
    public APIRequestGetViewers requestIsVerifiedField () {
      return this.requestIsVerifiedField(true);
    }
    public APIRequestGetViewers requestIsVerifiedField (boolean value) {
      this.requestField("is_verified", value);
      return this;
    }
    public APIRequestGetViewers requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGetViewers requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGetViewers requestLanguagesField () {
      return this.requestLanguagesField(true);
    }
    public APIRequestGetViewers requestLanguagesField (boolean value) {
      this.requestField("languages", value);
      return this;
    }
    public APIRequestGetViewers requestLastNameField () {
      return this.requestLastNameField(true);
    }
    public APIRequestGetViewers requestLastNameField (boolean value) {
      this.requestField("last_name", value);
      return this;
    }
    public APIRequestGetViewers requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGetViewers requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGetViewers requestLocalNewsMegaphoneDismissStatusField () {
      return this.requestLocalNewsMegaphoneDismissStatusField(true);
    }
    public APIRequestGetViewers requestLocalNewsMegaphoneDismissStatusField (boolean value) {
      this.requestField("local_news_megaphone_dismiss_status", value);
      return this;
    }
    public APIRequestGetViewers requestLocalNewsSubscriptionStatusField () {
      return this.requestLocalNewsSubscriptionStatusField(true);
    }
    public APIRequestGetViewers requestLocalNewsSubscriptionStatusField (boolean value) {
      this.requestField("local_news_subscription_status", value);
      return this;
    }
    public APIRequestGetViewers requestLocaleField () {
      return this.requestLocaleField(true);
    }
    public APIRequestGetViewers requestLocaleField (boolean value) {
      this.requestField("locale", value);
      return this;
    }
    public APIRequestGetViewers requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetViewers requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetViewers requestMeetingForField () {
      return this.requestMeetingForField(true);
    }
    public APIRequestGetViewers requestMeetingForField (boolean value) {
      this.requestField("meeting_for", value);
      return this;
    }
    public APIRequestGetViewers requestMiddleNameField () {
      return this.requestMiddleNameField(true);
    }
    public APIRequestGetViewers requestMiddleNameField (boolean value) {
      this.requestField("middle_name", value);
      return this;
    }
    public APIRequestGetViewers requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetViewers requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetViewers requestNameFormatField () {
      return this.requestNameFormatField(true);
    }
    public APIRequestGetViewers requestNameFormatField (boolean value) {
      this.requestField("name_format", value);
      return this;
    }
    public APIRequestGetViewers requestPaymentPricepointsField () {
      return this.requestPaymentPricepointsField(true);
    }
    public APIRequestGetViewers requestPaymentPricepointsField (boolean value) {
      this.requestField("payment_pricepoints", value);
      return this;
    }
    public APIRequestGetViewers requestPoliticalField () {
      return this.requestPoliticalField(true);
    }
    public APIRequestGetViewers requestPoliticalField (boolean value) {
      this.requestField("political", value);
      return this;
    }
    public APIRequestGetViewers requestProfilePicField () {
      return this.requestProfilePicField(true);
    }
    public APIRequestGetViewers requestProfilePicField (boolean value) {
      this.requestField("profile_pic", value);
      return this;
    }
    public APIRequestGetViewers requestPublicKeyField () {
      return this.requestPublicKeyField(true);
    }
    public APIRequestGetViewers requestPublicKeyField (boolean value) {
      this.requestField("public_key", value);
      return this;
    }
    public APIRequestGetViewers requestQuotesField () {
      return this.requestQuotesField(true);
    }
    public APIRequestGetViewers requestQuotesField (boolean value) {
      this.requestField("quotes", value);
      return this;
    }
    public APIRequestGetViewers requestRelationshipStatusField () {
      return this.requestRelationshipStatusField(true);
    }
    public APIRequestGetViewers requestRelationshipStatusField (boolean value) {
      this.requestField("relationship_status", value);
      return this;
    }
    public APIRequestGetViewers requestReligionField () {
      return this.requestReligionField(true);
    }
    public APIRequestGetViewers requestReligionField (boolean value) {
      this.requestField("religion", value);
      return this;
    }
    public APIRequestGetViewers requestSecuritySettingsField () {
      return this.requestSecuritySettingsField(true);
    }
    public APIRequestGetViewers requestSecuritySettingsField (boolean value) {
      this.requestField("security_settings", value);
      return this;
    }
    public APIRequestGetViewers requestSharedLoginUpgradeRequiredByField () {
      return this.requestSharedLoginUpgradeRequiredByField(true);
    }
    public APIRequestGetViewers requestSharedLoginUpgradeRequiredByField (boolean value) {
      this.requestField("shared_login_upgrade_required_by", value);
      return this;
    }
    public APIRequestGetViewers requestShortNameField () {
      return this.requestShortNameField(true);
    }
    public APIRequestGetViewers requestShortNameField (boolean value) {
      this.requestField("short_name", value);
      return this;
    }
    public APIRequestGetViewers requestSignificantOtherField () {
      return this.requestSignificantOtherField(true);
    }
    public APIRequestGetViewers requestSignificantOtherField (boolean value) {
      this.requestField("significant_other", value);
      return this;
    }
    public APIRequestGetViewers requestSportsField () {
      return this.requestSportsField(true);
    }
    public APIRequestGetViewers requestSportsField (boolean value) {
      this.requestField("sports", value);
      return this;
    }
    public APIRequestGetViewers requestTestGroupField () {
      return this.requestTestGroupField(true);
    }
    public APIRequestGetViewers requestTestGroupField (boolean value) {
      this.requestField("test_group", value);
      return this;
    }
    public APIRequestGetViewers requestThirdPartyIdField () {
      return this.requestThirdPartyIdField(true);
    }
    public APIRequestGetViewers requestThirdPartyIdField (boolean value) {
      this.requestField("third_party_id", value);
      return this;
    }
    public APIRequestGetViewers requestTimezoneField () {
      return this.requestTimezoneField(true);
    }
    public APIRequestGetViewers requestTimezoneField (boolean value) {
      this.requestField("timezone", value);
      return this;
    }
    public APIRequestGetViewers requestTokenForBusinessField () {
      return this.requestTokenForBusinessField(true);
    }
    public APIRequestGetViewers requestTokenForBusinessField (boolean value) {
      this.requestField("token_for_business", value);
      return this;
    }
    public APIRequestGetViewers requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetViewers requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetViewers requestUsernameField () {
      return this.requestUsernameField(true);
    }
    public APIRequestGetViewers requestUsernameField (boolean value) {
      this.requestField("username", value);
      return this;
    }
    public APIRequestGetViewers requestVerifiedField () {
      return this.requestVerifiedField(true);
    }
    public APIRequestGetViewers requestVerifiedField (boolean value) {
      this.requestField("verified", value);
      return this;
    }
    public APIRequestGetViewers requestVideoUploadLimitsField () {
      return this.requestVideoUploadLimitsField(true);
    }
    public APIRequestGetViewers requestVideoUploadLimitsField (boolean value) {
      this.requestField("video_upload_limits", value);
      return this;
    }
    public APIRequestGetViewers requestViewerCanSendGiftField () {
      return this.requestViewerCanSendGiftField(true);
    }
    public APIRequestGetViewers requestViewerCanSendGiftField (boolean value) {
      this.requestField("viewer_can_send_gift", value);
      return this;
    }
    public APIRequestGetViewers requestWebsiteField () {
      return this.requestWebsiteField(true);
    }
    public APIRequestGetViewers requestWebsiteField (boolean value) {
      this.requestField("website", value);
      return this;
    }
    public APIRequestGetViewers requestWorkField () {
      return this.requestWorkField(true);
    }
    public APIRequestGetViewers requestWorkField (boolean value) {
      this.requestField("work", value);
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
      "cooldown_start_time",
      "created_by",
      "created_time",
      "description",
      "end_time",
      "id",
      "name",
      "observation_end_time",
      "results_first_available_date",
      "start_time",
      "type",
      "updated_by",
      "updated_time",
    };

    @Override
    public AdStudy parseResponse(String response) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudy>() {
           public AdStudy apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
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
      "objectives",
      "end_time",
      "description",
      "name",
      "start_time",
      "viewers",
      "cooldown_start_time",
      "observation_end_time",
      "confidence_level",
      "client_business",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdStudy parseResponse(String response) throws APIException {
      return AdStudy.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdStudy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdStudy execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdStudy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdStudy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdStudy>() {
           public AdStudy apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
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

    public APIRequestUpdate setObjectives (List<Object> objectives) {
      this.setParam("objectives", objectives);
      return this;
    }
    public APIRequestUpdate setObjectives (String objectives) {
      this.setParam("objectives", objectives);
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

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

    public APIRequestUpdate setViewers (List<Long> viewers) {
      this.setParam("viewers", viewers);
      return this;
    }
    public APIRequestUpdate setViewers (String viewers) {
      this.setParam("viewers", viewers);
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

    public APIRequestUpdate setObservationEndTime (Long observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
      return this;
    }
    public APIRequestUpdate setObservationEndTime (String observationEndTime) {
      this.setParam("observation_end_time", observationEndTime);
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

    public APIRequestUpdate setClientBusiness (String clientBusiness) {
      this.setParam("client_business", clientBusiness);
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

  public static enum EnumAudienceType {
      @SerializedName("MOST_RESPONSIVE")
      VALUE_MOST_RESPONSIVE("MOST_RESPONSIVE"),
      @SerializedName("NOT_MOST_RESPONSIVE")
      VALUE_NOT_MOST_RESPONSIVE("NOT_MOST_RESPONSIVE"),
      NULL(null);

      private String value;

      private EnumAudienceType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRole {
      @SerializedName("ADMIN")
      VALUE_ADMIN("ADMIN"),
      @SerializedName("ANALYST")
      VALUE_ANALYST("ANALYST"),
      NULL(null);

      private String value;

      private EnumRole(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("LIFT")
      VALUE_LIFT("LIFT"),
      @SerializedName("SPLIT_TEST")
      VALUE_SPLIT_TEST("SPLIT_TEST"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

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
    this.mCooldownStartTime = instance.mCooldownStartTime;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mObservationEndTime = instance.mObservationEndTime;
    this.mResultsFirstAvailableDate = instance.mResultsFirstAvailableDate;
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
      public APINodeList<AdStudy> parseResponse(String response, APIContext context, APIRequest<AdStudy> request) throws MalformedResponseException {
        return AdStudy.parseResponse(response, context, request);
      }
    };
  }
}
