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
public class ThirdPartyPartnerViewabilityRequest extends APINode {
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("hour")
  private String mHour = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("metric")
  private EnumMetric mMetric = null;
  @SerializedName("modified_time")
  private String mModifiedTime = null;
  @SerializedName("owner_instance_id")
  private String mOwnerInstanceId = null;
  @SerializedName("platform")
  private EnumPlatform mPlatform = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("total_file_count")
  private Long mTotalFileCount = null;
  protected static Gson gson = null;

  ThirdPartyPartnerViewabilityRequest() {
  }

  public ThirdPartyPartnerViewabilityRequest(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ThirdPartyPartnerViewabilityRequest(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ThirdPartyPartnerViewabilityRequest fetch() throws APIException{
    ThirdPartyPartnerViewabilityRequest newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ThirdPartyPartnerViewabilityRequest fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ThirdPartyPartnerViewabilityRequest> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ThirdPartyPartnerViewabilityRequest fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ThirdPartyPartnerViewabilityRequest> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ThirdPartyPartnerViewabilityRequest> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ThirdPartyPartnerViewabilityRequest>)(
      new APIRequest<ThirdPartyPartnerViewabilityRequest>(context, "", "/", "GET", ThirdPartyPartnerViewabilityRequest.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ThirdPartyPartnerViewabilityRequest>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ThirdPartyPartnerViewabilityRequest.getParser())
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
  public static ThirdPartyPartnerViewabilityRequest loadJSON(String json, APIContext context, String header) {
    ThirdPartyPartnerViewabilityRequest thirdPartyPartnerViewabilityRequest = getGson().fromJson(json, ThirdPartyPartnerViewabilityRequest.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(thirdPartyPartnerViewabilityRequest.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    thirdPartyPartnerViewabilityRequest.context = context;
    thirdPartyPartnerViewabilityRequest.rawValue = json;
    thirdPartyPartnerViewabilityRequest.header = header;
    return thirdPartyPartnerViewabilityRequest;
  }

  public static APINodeList<ThirdPartyPartnerViewabilityRequest> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ThirdPartyPartnerViewabilityRequest> thirdPartyPartnerViewabilityRequests = new APINodeList<ThirdPartyPartnerViewabilityRequest>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          thirdPartyPartnerViewabilityRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return thirdPartyPartnerViewabilityRequests;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                thirdPartyPartnerViewabilityRequests.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            thirdPartyPartnerViewabilityRequests.setPaging(previous, next);
            if (context.hasAppSecret()) {
              thirdPartyPartnerViewabilityRequests.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              thirdPartyPartnerViewabilityRequests.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  thirdPartyPartnerViewabilityRequests.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              thirdPartyPartnerViewabilityRequests.add(loadJSON(obj.toString(), context, header));
            }
          }
          return thirdPartyPartnerViewabilityRequests;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              thirdPartyPartnerViewabilityRequests.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return thirdPartyPartnerViewabilityRequests;
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
              thirdPartyPartnerViewabilityRequests.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return thirdPartyPartnerViewabilityRequests;
          }

          // Sixth, check if it's pure JsonObject
          thirdPartyPartnerViewabilityRequests.clear();
          thirdPartyPartnerViewabilityRequests.add(loadJSON(json, context, header));
          return thirdPartyPartnerViewabilityRequests;
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


  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldHour() {
    return mHour;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumMetric getFieldMetric() {
    return mMetric;
  }

  public String getFieldModifiedTime() {
    return mModifiedTime;
  }

  public String getFieldOwnerInstanceId() {
    return mOwnerInstanceId;
  }

  public EnumPlatform getFieldPlatform() {
    return mPlatform;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public Long getFieldTotalFileCount() {
    return mTotalFileCount;
  }



  public static class APIRequestGet extends APIRequest<ThirdPartyPartnerViewabilityRequest> {

    ThirdPartyPartnerViewabilityRequest lastResponse = null;
    @Override
    public ThirdPartyPartnerViewabilityRequest getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "created_time",
      "description",
      "hour",
      "id",
      "metric",
      "modified_time",
      "owner_instance_id",
      "platform",
      "status",
      "total_file_count",
    };

    @Override
    public ThirdPartyPartnerViewabilityRequest parseResponse(String response, String header) throws APIException {
      return ThirdPartyPartnerViewabilityRequest.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ThirdPartyPartnerViewabilityRequest execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ThirdPartyPartnerViewabilityRequest execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ThirdPartyPartnerViewabilityRequest> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ThirdPartyPartnerViewabilityRequest> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ThirdPartyPartnerViewabilityRequest>() {
           public ThirdPartyPartnerViewabilityRequest apply(ResponseWrapper result) {
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
    public APIRequestGet requestHourField () {
      return this.requestHourField(true);
    }
    public APIRequestGet requestHourField (boolean value) {
      this.requestField("hour", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMetricField () {
      return this.requestMetricField(true);
    }
    public APIRequestGet requestMetricField (boolean value) {
      this.requestField("metric", value);
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
    public APIRequestGet requestPlatformField () {
      return this.requestPlatformField(true);
    }
    public APIRequestGet requestPlatformField (boolean value) {
      this.requestField("platform", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTotalFileCountField () {
      return this.requestTotalFileCountField(true);
    }
    public APIRequestGet requestTotalFileCountField (boolean value) {
      this.requestField("total_file_count", value);
      return this;
    }
  }

  public static enum EnumMetric {
      @SerializedName("DISPLAY_EVENT")
      VALUE_DISPLAY_EVENT("DISPLAY_EVENT"),
      @SerializedName("IMPRESSION")
      VALUE_IMPRESSION("IMPRESSION"),
      @SerializedName("VIDEO_EVENT")
      VALUE_VIDEO_EVENT("VIDEO_EVENT"),
      ;

      private String value;

      private EnumMetric(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumPlatform {
      @SerializedName("AUDIENCE_NETWORK")
      VALUE_AUDIENCE_NETWORK("AUDIENCE_NETWORK"),
      @SerializedName("FACEBOOK")
      VALUE_FACEBOOK("FACEBOOK"),
      @SerializedName("INSTAGRAM")
      VALUE_INSTAGRAM("INSTAGRAM"),
      ;

      private String value;

      private EnumPlatform(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
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

  public ThirdPartyPartnerViewabilityRequest copyFrom(ThirdPartyPartnerViewabilityRequest instance) {
    this.mCreatedTime = instance.mCreatedTime;
    this.mDescription = instance.mDescription;
    this.mHour = instance.mHour;
    this.mId = instance.mId;
    this.mMetric = instance.mMetric;
    this.mModifiedTime = instance.mModifiedTime;
    this.mOwnerInstanceId = instance.mOwnerInstanceId;
    this.mPlatform = instance.mPlatform;
    this.mStatus = instance.mStatus;
    this.mTotalFileCount = instance.mTotalFileCount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ThirdPartyPartnerViewabilityRequest> getParser() {
    return new APIRequest.ResponseParser<ThirdPartyPartnerViewabilityRequest>() {
      public APINodeList<ThirdPartyPartnerViewabilityRequest> parseResponse(String response, APIContext context, APIRequest<ThirdPartyPartnerViewabilityRequest> request, String header) throws MalformedResponseException {
        return ThirdPartyPartnerViewabilityRequest.parseResponse(response, context, request, header);
      }
    };
  }
}
