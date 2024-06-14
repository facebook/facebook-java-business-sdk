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
public class AdsReportBuilderMMMReportScheduler extends APINode {
  @SerializedName("ad_account_ids")
  private List<String> mAdAccountIds = null;
  @SerializedName("filtering")
  private List<Object> mFiltering = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("report_name")
  private String mReportName = null;
  @SerializedName("schedule_frequency")
  private String mScheduleFrequency = null;
  protected static Gson gson = null;

  AdsReportBuilderMMMReportScheduler() {
  }

  public AdsReportBuilderMMMReportScheduler(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsReportBuilderMMMReportScheduler(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsReportBuilderMMMReportScheduler fetch() throws APIException{
    AdsReportBuilderMMMReportScheduler newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsReportBuilderMMMReportScheduler fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsReportBuilderMMMReportScheduler> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsReportBuilderMMMReportScheduler fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsReportBuilderMMMReportScheduler> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsReportBuilderMMMReportScheduler> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsReportBuilderMMMReportScheduler>)(
      new APIRequest<AdsReportBuilderMMMReportScheduler>(context, "", "/", "GET", AdsReportBuilderMMMReportScheduler.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsReportBuilderMMMReportScheduler>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsReportBuilderMMMReportScheduler.getParser())
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
  public static AdsReportBuilderMMMReportScheduler loadJSON(String json, APIContext context, String header) {
    AdsReportBuilderMMMReportScheduler adsReportBuilderMMMReportScheduler = getGson().fromJson(json, AdsReportBuilderMMMReportScheduler.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsReportBuilderMMMReportScheduler.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adsReportBuilderMMMReportScheduler.context = context;
    adsReportBuilderMMMReportScheduler.rawValue = json;
    adsReportBuilderMMMReportScheduler.header = header;
    return adsReportBuilderMMMReportScheduler;
  }

  public static APINodeList<AdsReportBuilderMMMReportScheduler> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsReportBuilderMMMReportScheduler> adsReportBuilderMMMReportSchedulers = new APINodeList<AdsReportBuilderMMMReportScheduler>(request, json, header);
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
          adsReportBuilderMMMReportSchedulers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsReportBuilderMMMReportSchedulers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsReportBuilderMMMReportSchedulers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsReportBuilderMMMReportSchedulers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsReportBuilderMMMReportSchedulers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsReportBuilderMMMReportSchedulers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adsReportBuilderMMMReportSchedulers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsReportBuilderMMMReportSchedulers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsReportBuilderMMMReportSchedulers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsReportBuilderMMMReportSchedulers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsReportBuilderMMMReportSchedulers;
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
              adsReportBuilderMMMReportSchedulers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsReportBuilderMMMReportSchedulers;
          }

          // Sixth, check if it's pure JsonObject
          adsReportBuilderMMMReportSchedulers.clear();
          adsReportBuilderMMMReportSchedulers.add(loadJSON(json, context, header));
          return adsReportBuilderMMMReportSchedulers;
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


  public List<String> getFieldAdAccountIds() {
    return mAdAccountIds;
  }

  public List<Object> getFieldFiltering() {
    return mFiltering;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldReportName() {
    return mReportName;
  }

  public String getFieldScheduleFrequency() {
    return mScheduleFrequency;
  }



  public static class APIRequestGet extends APIRequest<AdsReportBuilderMMMReportScheduler> {

    AdsReportBuilderMMMReportScheduler lastResponse = null;
    @Override
    public AdsReportBuilderMMMReportScheduler getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_ids",
      "filtering",
      "id",
      "report_name",
      "schedule_frequency",
    };

    @Override
    public AdsReportBuilderMMMReportScheduler parseResponse(String response, String header) throws APIException {
      return AdsReportBuilderMMMReportScheduler.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdsReportBuilderMMMReportScheduler execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsReportBuilderMMMReportScheduler execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdsReportBuilderMMMReportScheduler> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsReportBuilderMMMReportScheduler> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdsReportBuilderMMMReportScheduler>() {
           public AdsReportBuilderMMMReportScheduler apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdAccountIdsField () {
      return this.requestAdAccountIdsField(true);
    }
    public APIRequestGet requestAdAccountIdsField (boolean value) {
      this.requestField("ad_account_ids", value);
      return this;
    }
    public APIRequestGet requestFilteringField () {
      return this.requestFilteringField(true);
    }
    public APIRequestGet requestFilteringField (boolean value) {
      this.requestField("filtering", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestReportNameField () {
      return this.requestReportNameField(true);
    }
    public APIRequestGet requestReportNameField (boolean value) {
      this.requestField("report_name", value);
      return this;
    }
    public APIRequestGet requestScheduleFrequencyField () {
      return this.requestScheduleFrequencyField(true);
    }
    public APIRequestGet requestScheduleFrequencyField (boolean value) {
      this.requestField("schedule_frequency", value);
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

  public AdsReportBuilderMMMReportScheduler copyFrom(AdsReportBuilderMMMReportScheduler instance) {
    this.mAdAccountIds = instance.mAdAccountIds;
    this.mFiltering = instance.mFiltering;
    this.mId = instance.mId;
    this.mReportName = instance.mReportName;
    this.mScheduleFrequency = instance.mScheduleFrequency;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsReportBuilderMMMReportScheduler> getParser() {
    return new APIRequest.ResponseParser<AdsReportBuilderMMMReportScheduler>() {
      public APINodeList<AdsReportBuilderMMMReportScheduler> parseResponse(String response, APIContext context, APIRequest<AdsReportBuilderMMMReportScheduler> request, String header) throws MalformedResponseException {
        return AdsReportBuilderMMMReportScheduler.parseResponse(response, context, request, header);
      }
    };
  }
}
