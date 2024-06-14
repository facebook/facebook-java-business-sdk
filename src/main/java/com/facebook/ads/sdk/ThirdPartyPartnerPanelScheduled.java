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
public class ThirdPartyPartnerPanelScheduled extends APINode {
  @SerializedName("adentities_ids")
  private List<String> mAdentitiesIds = null;
  @SerializedName("cadence")
  private String mCadence = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("end_time")
  private String mEndTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("modified_time")
  private String mModifiedTime = null;
  @SerializedName("owner_instance_id")
  private String mOwnerInstanceId = null;
  @SerializedName("owner_panel_id")
  private String mOwnerPanelId = null;
  @SerializedName("owner_panel_name")
  private String mOwnerPanelName = null;
  @SerializedName("start_time")
  private String mStartTime = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("study_type")
  private EnumStudyType mStudyType = null;
  protected static Gson gson = null;

  ThirdPartyPartnerPanelScheduled() {
  }

  public ThirdPartyPartnerPanelScheduled(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ThirdPartyPartnerPanelScheduled(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ThirdPartyPartnerPanelScheduled fetch() throws APIException{
    ThirdPartyPartnerPanelScheduled newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ThirdPartyPartnerPanelScheduled fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ThirdPartyPartnerPanelScheduled> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ThirdPartyPartnerPanelScheduled fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ThirdPartyPartnerPanelScheduled> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ThirdPartyPartnerPanelScheduled> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ThirdPartyPartnerPanelScheduled>)(
      new APIRequest<ThirdPartyPartnerPanelScheduled>(context, "", "/", "GET", ThirdPartyPartnerPanelScheduled.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ThirdPartyPartnerPanelScheduled>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ThirdPartyPartnerPanelScheduled.getParser())
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
  public static ThirdPartyPartnerPanelScheduled loadJSON(String json, APIContext context, String header) {
    ThirdPartyPartnerPanelScheduled thirdPartyPartnerPanelScheduled = getGson().fromJson(json, ThirdPartyPartnerPanelScheduled.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(thirdPartyPartnerPanelScheduled.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    thirdPartyPartnerPanelScheduled.context = context;
    thirdPartyPartnerPanelScheduled.rawValue = json;
    thirdPartyPartnerPanelScheduled.header = header;
    return thirdPartyPartnerPanelScheduled;
  }

  public static APINodeList<ThirdPartyPartnerPanelScheduled> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ThirdPartyPartnerPanelScheduled> thirdPartyPartnerPanelScheduleds = new APINodeList<ThirdPartyPartnerPanelScheduled>(request, json, header);
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
          thirdPartyPartnerPanelScheduleds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return thirdPartyPartnerPanelScheduleds;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                thirdPartyPartnerPanelScheduleds.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            thirdPartyPartnerPanelScheduleds.setPaging(previous, next);
            if (context.hasAppSecret()) {
              thirdPartyPartnerPanelScheduleds.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              thirdPartyPartnerPanelScheduleds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  thirdPartyPartnerPanelScheduleds.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              thirdPartyPartnerPanelScheduleds.add(loadJSON(obj.toString(), context, header));
            }
          }
          return thirdPartyPartnerPanelScheduleds;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              thirdPartyPartnerPanelScheduleds.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return thirdPartyPartnerPanelScheduleds;
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
              thirdPartyPartnerPanelScheduleds.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return thirdPartyPartnerPanelScheduleds;
          }

          // Sixth, check if it's pure JsonObject
          thirdPartyPartnerPanelScheduleds.clear();
          thirdPartyPartnerPanelScheduleds.add(loadJSON(json, context, header));
          return thirdPartyPartnerPanelScheduleds;
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


  public List<String> getFieldAdentitiesIds() {
    return mAdentitiesIds;
  }

  public String getFieldCadence() {
    return mCadence;
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

  public String getFieldEndTime() {
    return mEndTime;
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

  public String getFieldOwnerPanelId() {
    return mOwnerPanelId;
  }

  public String getFieldOwnerPanelName() {
    return mOwnerPanelName;
  }

  public String getFieldStartTime() {
    return mStartTime;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public EnumStudyType getFieldStudyType() {
    return mStudyType;
  }



  public static class APIRequestGet extends APIRequest<ThirdPartyPartnerPanelScheduled> {

    ThirdPartyPartnerPanelScheduled lastResponse = null;
    @Override
    public ThirdPartyPartnerPanelScheduled getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "adentities_ids",
      "cadence",
      "country",
      "created_time",
      "description",
      "end_time",
      "id",
      "modified_time",
      "owner_instance_id",
      "owner_panel_id",
      "owner_panel_name",
      "start_time",
      "status",
      "study_type",
    };

    @Override
    public ThirdPartyPartnerPanelScheduled parseResponse(String response, String header) throws APIException {
      return ThirdPartyPartnerPanelScheduled.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ThirdPartyPartnerPanelScheduled execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ThirdPartyPartnerPanelScheduled execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ThirdPartyPartnerPanelScheduled> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ThirdPartyPartnerPanelScheduled> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ThirdPartyPartnerPanelScheduled>() {
           public ThirdPartyPartnerPanelScheduled apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdentitiesIdsField () {
      return this.requestAdentitiesIdsField(true);
    }
    public APIRequestGet requestAdentitiesIdsField (boolean value) {
      this.requestField("adentities_ids", value);
      return this;
    }
    public APIRequestGet requestCadenceField () {
      return this.requestCadenceField(true);
    }
    public APIRequestGet requestCadenceField (boolean value) {
      this.requestField("cadence", value);
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
    public APIRequestGet requestOwnerPanelIdField () {
      return this.requestOwnerPanelIdField(true);
    }
    public APIRequestGet requestOwnerPanelIdField (boolean value) {
      this.requestField("owner_panel_id", value);
      return this;
    }
    public APIRequestGet requestOwnerPanelNameField () {
      return this.requestOwnerPanelNameField(true);
    }
    public APIRequestGet requestOwnerPanelNameField (boolean value) {
      this.requestField("owner_panel_name", value);
      return this;
    }
    public APIRequestGet requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGet requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestStudyTypeField () {
      return this.requestStudyTypeField(true);
    }
    public APIRequestGet requestStudyTypeField (boolean value) {
      this.requestField("study_type", value);
      return this;
    }
  }

  public static enum EnumStatus {
      @SerializedName("CANCELLED")
      VALUE_CANCELLED("CANCELLED"),
      @SerializedName("CREATED")
      VALUE_CREATED("CREATED"),
      @SerializedName("FINISHED")
      VALUE_FINISHED("FINISHED"),
      @SerializedName("ONGOING")
      VALUE_ONGOING("ONGOING"),
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

  public static enum EnumStudyType {
      @SerializedName("BRAND_LIFT")
      VALUE_BRAND_LIFT("BRAND_LIFT"),
      @SerializedName("PANEL_SALES_ATTRIBUTION")
      VALUE_PANEL_SALES_ATTRIBUTION("PANEL_SALES_ATTRIBUTION"),
      @SerializedName("REACH")
      VALUE_REACH("REACH"),
      ;

      private String value;

      private EnumStudyType(String value) {
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

  public ThirdPartyPartnerPanelScheduled copyFrom(ThirdPartyPartnerPanelScheduled instance) {
    this.mAdentitiesIds = instance.mAdentitiesIds;
    this.mCadence = instance.mCadence;
    this.mCountry = instance.mCountry;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mEndTime = instance.mEndTime;
    this.mId = instance.mId;
    this.mModifiedTime = instance.mModifiedTime;
    this.mOwnerInstanceId = instance.mOwnerInstanceId;
    this.mOwnerPanelId = instance.mOwnerPanelId;
    this.mOwnerPanelName = instance.mOwnerPanelName;
    this.mStartTime = instance.mStartTime;
    this.mStatus = instance.mStatus;
    this.mStudyType = instance.mStudyType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ThirdPartyPartnerPanelScheduled> getParser() {
    return new APIRequest.ResponseParser<ThirdPartyPartnerPanelScheduled>() {
      public APINodeList<ThirdPartyPartnerPanelScheduled> parseResponse(String response, APIContext context, APIRequest<ThirdPartyPartnerPanelScheduled> request, String header) throws MalformedResponseException {
        return ThirdPartyPartnerPanelScheduled.parseResponse(response, context, request, header);
      }
    };
  }
}
