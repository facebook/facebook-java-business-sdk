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
public class ThirdPartyPartnerLiftRequest extends APINode {
  @SerializedName("ad_entities")
  private List<String> mAdEntities = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("holdout_size")
  private Double mHoldoutSize = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("modified_time")
  private String mModifiedTime = null;
  @SerializedName("owner_instance_id")
  private String mOwnerInstanceId = null;
  @SerializedName("region")
  private String mRegion = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("study_cells")
  private List<String> mStudyCells = null;
  @SerializedName("study_end_time")
  private String mStudyEndTime = null;
  @SerializedName("study_start_time")
  private String mStudyStartTime = null;
  protected static Gson gson = null;

  ThirdPartyPartnerLiftRequest() {
  }

  public ThirdPartyPartnerLiftRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ThirdPartyPartnerLiftRequest(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ThirdPartyPartnerLiftRequest fetch() throws APIException{
    ThirdPartyPartnerLiftRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ThirdPartyPartnerLiftRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ThirdPartyPartnerLiftRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ThirdPartyPartnerLiftRequest fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ThirdPartyPartnerLiftRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ThirdPartyPartnerLiftRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ThirdPartyPartnerLiftRequest>)(
      new APIRequest<ThirdPartyPartnerLiftRequest>(context, "", "/", "GET", ThirdPartyPartnerLiftRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ThirdPartyPartnerLiftRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ThirdPartyPartnerLiftRequest.getParser())
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
  public static ThirdPartyPartnerLiftRequest loadJSON(String json, APIContext context, String header) {
    ThirdPartyPartnerLiftRequest thirdPartyPartnerLiftRequest = getGson().fromJson(json, ThirdPartyPartnerLiftRequest.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(thirdPartyPartnerLiftRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    thirdPartyPartnerLiftRequest.context = context;
    thirdPartyPartnerLiftRequest.rawValue = json;
    thirdPartyPartnerLiftRequest.header = header;
    return thirdPartyPartnerLiftRequest;
  }

  public static APINodeList<ThirdPartyPartnerLiftRequest> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ThirdPartyPartnerLiftRequest> thirdPartyPartnerLiftRequests = new APINodeList<ThirdPartyPartnerLiftRequest>(request, json, header);
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
          thirdPartyPartnerLiftRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return thirdPartyPartnerLiftRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                thirdPartyPartnerLiftRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            thirdPartyPartnerLiftRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              thirdPartyPartnerLiftRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              thirdPartyPartnerLiftRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  thirdPartyPartnerLiftRequests.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              thirdPartyPartnerLiftRequests.add(loadJSON(obj.toString(), context, header));
            }
          }
          return thirdPartyPartnerLiftRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              thirdPartyPartnerLiftRequests.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return thirdPartyPartnerLiftRequests;
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
              thirdPartyPartnerLiftRequests.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return thirdPartyPartnerLiftRequests;
          }

          // Sixth, check if it's pure JsonObject
          thirdPartyPartnerLiftRequests.clear();
          thirdPartyPartnerLiftRequests.add(loadJSON(json, context, header));
          return thirdPartyPartnerLiftRequests;
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


  public List<String> getFieldAdEntities() {
    return mAdEntities;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Double getFieldHoldoutSize() {
    return mHoldoutSize;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldModifiedTime() {
    return mModifiedTime;
  }

  public String getFieldOwnerInstanceId() {
    return mOwnerInstanceId;
  }

  public String getFieldRegion() {
    return mRegion;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public List<String> getFieldStudyCells() {
    return mStudyCells;
  }

  public String getFieldStudyEndTime() {
    return mStudyEndTime;
  }

  public String getFieldStudyStartTime() {
    return mStudyStartTime;
  }



  public static class APIRequestGet extends APIRequest<ThirdPartyPartnerLiftRequest> {

    ThirdPartyPartnerLiftRequest lastResponse = null;
    @Override
    public ThirdPartyPartnerLiftRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_entities",
      "country",
      "created_time",
      "description",
      "holdout_size",
      "id",
      "modified_time",
      "owner_instance_id",
      "region",
      "status",
      "study_cells",
      "study_end_time",
      "study_start_time",
    };

    @Override
    public ThirdPartyPartnerLiftRequest parseResponse(String response, String header) throws APIException {
      return ThirdPartyPartnerLiftRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ThirdPartyPartnerLiftRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ThirdPartyPartnerLiftRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ThirdPartyPartnerLiftRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ThirdPartyPartnerLiftRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ThirdPartyPartnerLiftRequest>() {
           public ThirdPartyPartnerLiftRequest apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdEntitiesField () {
      return this.requestAdEntitiesField(true);
    }
    public APIRequestGet requestAdEntitiesField (boolean value) {
      this.requestField("ad_entities", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
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
    public APIRequestGet requestHoldoutSizeField () {
      return this.requestHoldoutSizeField(true);
    }
    public APIRequestGet requestHoldoutSizeField (boolean value) {
      this.requestField("holdout_size", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestModifiedTimeField () {
      return this.requestModifiedTimeField(true);
    }
    public APIRequestGet requestModifiedTimeField (boolean value) {
      this.requestField("modified_time", value);
      return this;
    }
    public APIRequestGet requestOwnerInstanceIdField () {
      return this.requestOwnerInstanceIdField(true);
    }
    public APIRequestGet requestOwnerInstanceIdField (boolean value) {
      this.requestField("owner_instance_id", value);
      return this;
    }
    public APIRequestGet requestRegionField () {
      return this.requestRegionField(true);
    }
    public APIRequestGet requestRegionField (boolean value) {
      this.requestField("region", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestStudyCellsField () {
      return this.requestStudyCellsField(true);
    }
    public APIRequestGet requestStudyCellsField (boolean value) {
      this.requestField("study_cells", value);
      return this;
    }
    public APIRequestGet requestStudyEndTimeField () {
      return this.requestStudyEndTimeField(true);
    }
    public APIRequestGet requestStudyEndTimeField (boolean value) {
      this.requestField("study_end_time", value);
      return this;
    }
    public APIRequestGet requestStudyStartTimeField () {
      return this.requestStudyStartTimeField(true);
    }
    public APIRequestGet requestStudyStartTimeField (boolean value) {
      this.requestField("study_start_time", value);
      return this;
    }
  }

  public static enum EnumStatus {
      @SerializedName("CREATED")
      VALUE_CREATED("CREATED"),
      @SerializedName("FAILURE")
      VALUE_FAILURE("FAILURE"),
      @SerializedName("IN_PROGRESS")
      VALUE_IN_PROGRESS("IN_PROGRESS"),
      @SerializedName("SCHEDULED")
      VALUE_SCHEDULED("SCHEDULED"),
      @SerializedName("SUCCESS")
      VALUE_SUCCESS("SUCCESS"),
      ;

      private String value;

      private EnumStatus(String value) {
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

  public ThirdPartyPartnerLiftRequest copyFrom(ThirdPartyPartnerLiftRequest instance) {
    this.mAdEntities = instance.mAdEntities;
    this.mCountry = instance.mCountry;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mHoldoutSize = instance.mHoldoutSize;
    this.mId = instance.mId;
    this.mModifiedTime = instance.mModifiedTime;
    this.mOwnerInstanceId = instance.mOwnerInstanceId;
    this.mRegion = instance.mRegion;
    this.mStatus = instance.mStatus;
    this.mStudyCells = instance.mStudyCells;
    this.mStudyEndTime = instance.mStudyEndTime;
    this.mStudyStartTime = instance.mStudyStartTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ThirdPartyPartnerLiftRequest> getParser() {
    return new APIRequest.ResponseParser<ThirdPartyPartnerLiftRequest>() {
      public APINodeList<ThirdPartyPartnerLiftRequest> parseResponse(String response, APIContext context, APIRequest<ThirdPartyPartnerLiftRequest> request, String header) throws MalformedResponseException {
        return ThirdPartyPartnerLiftRequest.parseResponse(response, context, request, header);
      }
    };
  }
}
