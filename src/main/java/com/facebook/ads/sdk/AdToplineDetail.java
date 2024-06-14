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
public class AdToplineDetail extends APINode {
  @SerializedName("active_status")
  private Long mActiveStatus = null;
  @SerializedName("ad_account_id")
  private String mAdAccountId = null;
  @SerializedName("flight_end_date")
  private String mFlightEndDate = null;
  @SerializedName("flight_start_date")
  private String mFlightStartDate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("io_number")
  private Long mIoNumber = null;
  @SerializedName("line_number")
  private Long mLineNumber = null;
  @SerializedName("price")
  private Double mPrice = null;
  @SerializedName("quantity")
  private Double mQuantity = null;
  @SerializedName("sf_detail_line_id")
  private String mSfDetailLineId = null;
  @SerializedName("subline_id")
  private String mSublineId = null;
  @SerializedName("targets")
  private String mTargets = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_updated")
  private String mTimeUpdated = null;
  protected static Gson gson = null;

  AdToplineDetail() {
  }

  public AdToplineDetail(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdToplineDetail(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdToplineDetail fetch() throws APIException{
    AdToplineDetail newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdToplineDetail fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdToplineDetail> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdToplineDetail fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdToplineDetail> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdToplineDetail> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdToplineDetail>)(
      new APIRequest<AdToplineDetail>(context, "", "/", "GET", AdToplineDetail.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdToplineDetail>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdToplineDetail.getParser())
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
  public static AdToplineDetail loadJSON(String json, APIContext context, String header) {
    AdToplineDetail adToplineDetail = getGson().fromJson(json, AdToplineDetail.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adToplineDetail.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adToplineDetail.context = context;
    adToplineDetail.rawValue = json;
    adToplineDetail.header = header;
    return adToplineDetail;
  }

  public static APINodeList<AdToplineDetail> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdToplineDetail> adToplineDetails = new APINodeList<AdToplineDetail>(request, json, header);
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
          adToplineDetails.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adToplineDetails;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adToplineDetails.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adToplineDetails.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adToplineDetails.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adToplineDetails.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adToplineDetails.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adToplineDetails.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adToplineDetails;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adToplineDetails.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adToplineDetails;
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
              adToplineDetails.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adToplineDetails;
          }

          // Sixth, check if it's pure JsonObject
          adToplineDetails.clear();
          adToplineDetails.add(loadJSON(json, context, header));
          return adToplineDetails;
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


  public Long getFieldActiveStatus() {
    return mActiveStatus;
  }

  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public String getFieldFlightEndDate() {
    return mFlightEndDate;
  }

  public String getFieldFlightStartDate() {
    return mFlightStartDate;
  }

  public String getFieldId() {
    return mId;
  }

  public Long getFieldIoNumber() {
    return mIoNumber;
  }

  public Long getFieldLineNumber() {
    return mLineNumber;
  }

  public Double getFieldPrice() {
    return mPrice;
  }

  public Double getFieldQuantity() {
    return mQuantity;
  }

  public String getFieldSfDetailLineId() {
    return mSfDetailLineId;
  }

  public String getFieldSublineId() {
    return mSublineId;
  }

  public String getFieldTargets() {
    return mTargets;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldTimeUpdated() {
    return mTimeUpdated;
  }



  public static class APIRequestGet extends APIRequest<AdToplineDetail> {

    AdToplineDetail lastResponse = null;
    @Override
    public AdToplineDetail getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "active_status",
      "ad_account_id",
      "flight_end_date",
      "flight_start_date",
      "id",
      "io_number",
      "line_number",
      "price",
      "quantity",
      "sf_detail_line_id",
      "subline_id",
      "targets",
      "time_created",
      "time_updated",
    };

    @Override
    public AdToplineDetail parseResponse(String response, String header) throws APIException {
      return AdToplineDetail.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdToplineDetail execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdToplineDetail execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdToplineDetail> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdToplineDetail> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdToplineDetail>() {
           public AdToplineDetail apply(ResponseWrapper result) {
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

    public APIRequestGet requestActiveStatusField () {
      return this.requestActiveStatusField(true);
    }
    public APIRequestGet requestActiveStatusField (boolean value) {
      this.requestField("active_status", value);
      return this;
    }
    public APIRequestGet requestAdAccountIdField () {
      return this.requestAdAccountIdField(true);
    }
    public APIRequestGet requestAdAccountIdField (boolean value) {
      this.requestField("ad_account_id", value);
      return this;
    }
    public APIRequestGet requestFlightEndDateField () {
      return this.requestFlightEndDateField(true);
    }
    public APIRequestGet requestFlightEndDateField (boolean value) {
      this.requestField("flight_end_date", value);
      return this;
    }
    public APIRequestGet requestFlightStartDateField () {
      return this.requestFlightStartDateField(true);
    }
    public APIRequestGet requestFlightStartDateField (boolean value) {
      this.requestField("flight_start_date", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIoNumberField () {
      return this.requestIoNumberField(true);
    }
    public APIRequestGet requestIoNumberField (boolean value) {
      this.requestField("io_number", value);
      return this;
    }
    public APIRequestGet requestLineNumberField () {
      return this.requestLineNumberField(true);
    }
    public APIRequestGet requestLineNumberField (boolean value) {
      this.requestField("line_number", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestQuantityField () {
      return this.requestQuantityField(true);
    }
    public APIRequestGet requestQuantityField (boolean value) {
      this.requestField("quantity", value);
      return this;
    }
    public APIRequestGet requestSfDetailLineIdField () {
      return this.requestSfDetailLineIdField(true);
    }
    public APIRequestGet requestSfDetailLineIdField (boolean value) {
      this.requestField("sf_detail_line_id", value);
      return this;
    }
    public APIRequestGet requestSublineIdField () {
      return this.requestSublineIdField(true);
    }
    public APIRequestGet requestSublineIdField (boolean value) {
      this.requestField("subline_id", value);
      return this;
    }
    public APIRequestGet requestTargetsField () {
      return this.requestTargetsField(true);
    }
    public APIRequestGet requestTargetsField (boolean value) {
      this.requestField("targets", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGet requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
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

  public AdToplineDetail copyFrom(AdToplineDetail instance) {
    this.mActiveStatus = instance.mActiveStatus;
    this.mAdAccountId = instance.mAdAccountId;
    this.mFlightEndDate = instance.mFlightEndDate;
    this.mFlightStartDate = instance.mFlightStartDate;
    this.mId = instance.mId;
    this.mIoNumber = instance.mIoNumber;
    this.mLineNumber = instance.mLineNumber;
    this.mPrice = instance.mPrice;
    this.mQuantity = instance.mQuantity;
    this.mSfDetailLineId = instance.mSfDetailLineId;
    this.mSublineId = instance.mSublineId;
    this.mTargets = instance.mTargets;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdToplineDetail> getParser() {
    return new APIRequest.ResponseParser<AdToplineDetail>() {
      public APINodeList<AdToplineDetail> parseResponse(String response, APIContext context, APIRequest<AdToplineDetail> request, String header) throws MalformedResponseException {
        return AdToplineDetail.parseResponse(response, context, request, header);
      }
    };
  }
}
