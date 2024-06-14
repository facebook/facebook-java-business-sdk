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
public class AdsReportBuilderExportCore extends APINode {
  @SerializedName("async_percent_completion")
  private Long mAsyncPercentCompletion = null;
  @SerializedName("async_report_url")
  private String mAsyncReportUrl = null;
  @SerializedName("async_status")
  private String mAsyncStatus = null;
  @SerializedName("client_creation_value")
  private String mClientCreationValue = null;
  @SerializedName("expiry_time")
  private String mExpiryTime = null;
  @SerializedName("export_download_time")
  private String mExportDownloadTime = null;
  @SerializedName("export_format")
  private String mExportFormat = null;
  @SerializedName("export_name")
  private String mExportName = null;
  @SerializedName("export_type")
  private String mExportType = null;
  @SerializedName("has_seen")
  private Boolean mHasSeen = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_sharing")
  private Boolean mIsSharing = null;
  @SerializedName("link_sharing_expiration_time")
  private String mLinkSharingExpirationTime = null;
  @SerializedName("link_sharing_uri")
  private String mLinkSharingUri = null;
  @SerializedName("time_completed")
  private String mTimeCompleted = null;
  @SerializedName("time_start")
  private String mTimeStart = null;
  protected static Gson gson = null;

  AdsReportBuilderExportCore() {
  }

  public AdsReportBuilderExportCore(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsReportBuilderExportCore(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsReportBuilderExportCore fetch() throws APIException{
    AdsReportBuilderExportCore newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsReportBuilderExportCore fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsReportBuilderExportCore> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsReportBuilderExportCore fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsReportBuilderExportCore> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsReportBuilderExportCore> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsReportBuilderExportCore>)(
      new APIRequest<AdsReportBuilderExportCore>(context, "", "/", "GET", AdsReportBuilderExportCore.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsReportBuilderExportCore>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsReportBuilderExportCore.getParser())
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
  public static AdsReportBuilderExportCore loadJSON(String json, APIContext context, String header) {
    AdsReportBuilderExportCore adsReportBuilderExportCore = getGson().fromJson(json, AdsReportBuilderExportCore.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsReportBuilderExportCore.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsReportBuilderExportCore.context = context;
    adsReportBuilderExportCore.rawValue = json;
    adsReportBuilderExportCore.header = header;
    return adsReportBuilderExportCore;
  }

  public static APINodeList<AdsReportBuilderExportCore> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsReportBuilderExportCore> adsReportBuilderExportCores = new APINodeList<AdsReportBuilderExportCore>(request, json, header);
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
          adsReportBuilderExportCores.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsReportBuilderExportCores;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsReportBuilderExportCores.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsReportBuilderExportCores.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsReportBuilderExportCores.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsReportBuilderExportCores.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsReportBuilderExportCores.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsReportBuilderExportCores.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsReportBuilderExportCores;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsReportBuilderExportCores.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsReportBuilderExportCores;
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
              adsReportBuilderExportCores.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsReportBuilderExportCores;
          }

          // Sixth, check if it's pure JsonObject
          adsReportBuilderExportCores.clear();
          adsReportBuilderExportCores.add(loadJSON(json, context, header));
          return adsReportBuilderExportCores;
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


  public Long getFieldAsyncPercentCompletion() {
    return mAsyncPercentCompletion;
  }

  public String getFieldAsyncReportUrl() {
    return mAsyncReportUrl;
  }

  public String getFieldAsyncStatus() {
    return mAsyncStatus;
  }

  public String getFieldClientCreationValue() {
    return mClientCreationValue;
  }

  public String getFieldExpiryTime() {
    return mExpiryTime;
  }

  public String getFieldExportDownloadTime() {
    return mExportDownloadTime;
  }

  public String getFieldExportFormat() {
    return mExportFormat;
  }

  public String getFieldExportName() {
    return mExportName;
  }

  public String getFieldExportType() {
    return mExportType;
  }

  public Boolean getFieldHasSeen() {
    return mHasSeen;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsSharing() {
    return mIsSharing;
  }

  public String getFieldLinkSharingExpirationTime() {
    return mLinkSharingExpirationTime;
  }

  public String getFieldLinkSharingUri() {
    return mLinkSharingUri;
  }

  public String getFieldTimeCompleted() {
    return mTimeCompleted;
  }

  public String getFieldTimeStart() {
    return mTimeStart;
  }



  public static class APIRequestGet extends APIRequest<AdsReportBuilderExportCore> {

    AdsReportBuilderExportCore lastResponse = null;
    @Override
    public AdsReportBuilderExportCore getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "async_percent_completion",
      "async_report_url",
      "async_status",
      "client_creation_value",
      "expiry_time",
      "export_download_time",
      "export_format",
      "export_name",
      "export_type",
      "has_seen",
      "id",
      "is_sharing",
      "link_sharing_expiration_time",
      "link_sharing_uri",
      "time_completed",
      "time_start",
    };

    @Override
    public AdsReportBuilderExportCore parseResponse(String response, String header) throws APIException {
      return AdsReportBuilderExportCore.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsReportBuilderExportCore execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsReportBuilderExportCore execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsReportBuilderExportCore> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsReportBuilderExportCore> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsReportBuilderExportCore>() {
           public AdsReportBuilderExportCore apply(ResponseWrapper result) {
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

    public APIRequestGet requestAsyncPercentCompletionField () {
      return this.requestAsyncPercentCompletionField(true);
    }
    public APIRequestGet requestAsyncPercentCompletionField (boolean value) {
      this.requestField("async_percent_completion", value);
      return this;
    }
    public APIRequestGet requestAsyncReportUrlField () {
      return this.requestAsyncReportUrlField(true);
    }
    public APIRequestGet requestAsyncReportUrlField (boolean value) {
      this.requestField("async_report_url", value);
      return this;
    }
    public APIRequestGet requestAsyncStatusField () {
      return this.requestAsyncStatusField(true);
    }
    public APIRequestGet requestAsyncStatusField (boolean value) {
      this.requestField("async_status", value);
      return this;
    }
    public APIRequestGet requestClientCreationValueField () {
      return this.requestClientCreationValueField(true);
    }
    public APIRequestGet requestClientCreationValueField (boolean value) {
      this.requestField("client_creation_value", value);
      return this;
    }
    public APIRequestGet requestExpiryTimeField () {
      return this.requestExpiryTimeField(true);
    }
    public APIRequestGet requestExpiryTimeField (boolean value) {
      this.requestField("expiry_time", value);
      return this;
    }
    public APIRequestGet requestExportDownloadTimeField () {
      return this.requestExportDownloadTimeField(true);
    }
    public APIRequestGet requestExportDownloadTimeField (boolean value) {
      this.requestField("export_download_time", value);
      return this;
    }
    public APIRequestGet requestExportFormatField () {
      return this.requestExportFormatField(true);
    }
    public APIRequestGet requestExportFormatField (boolean value) {
      this.requestField("export_format", value);
      return this;
    }
    public APIRequestGet requestExportNameField () {
      return this.requestExportNameField(true);
    }
    public APIRequestGet requestExportNameField (boolean value) {
      this.requestField("export_name", value);
      return this;
    }
    public APIRequestGet requestExportTypeField () {
      return this.requestExportTypeField(true);
    }
    public APIRequestGet requestExportTypeField (boolean value) {
      this.requestField("export_type", value);
      return this;
    }
    public APIRequestGet requestHasSeenField () {
      return this.requestHasSeenField(true);
    }
    public APIRequestGet requestHasSeenField (boolean value) {
      this.requestField("has_seen", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsSharingField () {
      return this.requestIsSharingField(true);
    }
    public APIRequestGet requestIsSharingField (boolean value) {
      this.requestField("is_sharing", value);
      return this;
    }
    public APIRequestGet requestLinkSharingExpirationTimeField () {
      return this.requestLinkSharingExpirationTimeField(true);
    }
    public APIRequestGet requestLinkSharingExpirationTimeField (boolean value) {
      this.requestField("link_sharing_expiration_time", value);
      return this;
    }
    public APIRequestGet requestLinkSharingUriField () {
      return this.requestLinkSharingUriField(true);
    }
    public APIRequestGet requestLinkSharingUriField (boolean value) {
      this.requestField("link_sharing_uri", value);
      return this;
    }
    public APIRequestGet requestTimeCompletedField () {
      return this.requestTimeCompletedField(true);
    }
    public APIRequestGet requestTimeCompletedField (boolean value) {
      this.requestField("time_completed", value);
      return this;
    }
    public APIRequestGet requestTimeStartField () {
      return this.requestTimeStartField(true);
    }
    public APIRequestGet requestTimeStartField (boolean value) {
      this.requestField("time_start", value);
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

  public AdsReportBuilderExportCore copyFrom(AdsReportBuilderExportCore instance) {
    this.mAsyncPercentCompletion = instance.mAsyncPercentCompletion;
    this.mAsyncReportUrl = instance.mAsyncReportUrl;
    this.mAsyncStatus = instance.mAsyncStatus;
    this.mClientCreationValue = instance.mClientCreationValue;
    this.mExpiryTime = instance.mExpiryTime;
    this.mExportDownloadTime = instance.mExportDownloadTime;
    this.mExportFormat = instance.mExportFormat;
    this.mExportName = instance.mExportName;
    this.mExportType = instance.mExportType;
    this.mHasSeen = instance.mHasSeen;
    this.mId = instance.mId;
    this.mIsSharing = instance.mIsSharing;
    this.mLinkSharingExpirationTime = instance.mLinkSharingExpirationTime;
    this.mLinkSharingUri = instance.mLinkSharingUri;
    this.mTimeCompleted = instance.mTimeCompleted;
    this.mTimeStart = instance.mTimeStart;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsReportBuilderExportCore> getParser() {
    return new APIRequest.ResponseParser<AdsReportBuilderExportCore>() {
      public APINodeList<AdsReportBuilderExportCore> parseResponse(String response, APIContext context, APIRequest<AdsReportBuilderExportCore> request, String header) throws MalformedResponseException {
        return AdsReportBuilderExportCore.parseResponse(response, context, request, header);
      }
    };
  }
}
