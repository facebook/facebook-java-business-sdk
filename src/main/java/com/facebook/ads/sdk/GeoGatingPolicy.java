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
public class GeoGatingPolicy extends APINode {
  @SerializedName("after_schedule")
  private String mAfterSchedule = null;
  @SerializedName("exclude_country")
  private List<String> mExcludeCountry = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("include_country")
  private List<String> mIncludeCountry = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("valid_from")
  private String mValidFrom = null;
  @SerializedName("valid_until")
  private String mValidUntil = null;
  protected static Gson gson = null;

  GeoGatingPolicy() {
  }

  public GeoGatingPolicy(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public GeoGatingPolicy(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public GeoGatingPolicy fetch() throws APIException{
    GeoGatingPolicy newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static GeoGatingPolicy fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<GeoGatingPolicy> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static GeoGatingPolicy fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<GeoGatingPolicy> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<GeoGatingPolicy> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<GeoGatingPolicy>)(
      new APIRequest<GeoGatingPolicy>(context, "", "/", "GET", GeoGatingPolicy.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<GeoGatingPolicy>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", GeoGatingPolicy.getParser())
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
  public static GeoGatingPolicy loadJSON(String json, APIContext context, String header) {
    GeoGatingPolicy geoGatingPolicy = getGson().fromJson(json, GeoGatingPolicy.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(geoGatingPolicy.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    geoGatingPolicy.context = context;
    geoGatingPolicy.rawValue = json;
    geoGatingPolicy.header = header;
    return geoGatingPolicy;
  }

  public static APINodeList<GeoGatingPolicy> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<GeoGatingPolicy> geoGatingPolicys = new APINodeList<GeoGatingPolicy>(request, json, header);
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
          geoGatingPolicys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return geoGatingPolicys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                geoGatingPolicys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            geoGatingPolicys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              geoGatingPolicys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              geoGatingPolicys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  geoGatingPolicys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              geoGatingPolicys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return geoGatingPolicys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              geoGatingPolicys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return geoGatingPolicys;
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
              geoGatingPolicys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return geoGatingPolicys;
          }

          // Sixth, check if it's pure JsonObject
          geoGatingPolicys.clear();
          geoGatingPolicys.add(loadJSON(json, context, header));
          return geoGatingPolicys;
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


  public String getFieldAfterSchedule() {
    return mAfterSchedule;
  }

  public List<String> getFieldExcludeCountry() {
    return mExcludeCountry;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldIncludeCountry() {
    return mIncludeCountry;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldValidFrom() {
    return mValidFrom;
  }

  public String getFieldValidUntil() {
    return mValidUntil;
  }



  public static class APIRequestGet extends APIRequest<GeoGatingPolicy> {

    GeoGatingPolicy lastResponse = null;
    @Override
    public GeoGatingPolicy getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "after_schedule",
      "exclude_country",
      "id",
      "include_country",
      "name",
      "valid_from",
      "valid_until",
    };

    @Override
    public GeoGatingPolicy parseResponse(String response, String header) throws APIException {
      return GeoGatingPolicy.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public GeoGatingPolicy execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public GeoGatingPolicy execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<GeoGatingPolicy> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<GeoGatingPolicy> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, GeoGatingPolicy>() {
           public GeoGatingPolicy apply(ResponseWrapper result) {
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

    public APIRequestGet requestAfterScheduleField () {
      return this.requestAfterScheduleField(true);
    }
    public APIRequestGet requestAfterScheduleField (boolean value) {
      this.requestField("after_schedule", value);
      return this;
    }
    public APIRequestGet requestExcludeCountryField () {
      return this.requestExcludeCountryField(true);
    }
    public APIRequestGet requestExcludeCountryField (boolean value) {
      this.requestField("exclude_country", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIncludeCountryField () {
      return this.requestIncludeCountryField(true);
    }
    public APIRequestGet requestIncludeCountryField (boolean value) {
      this.requestField("include_country", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestValidFromField () {
      return this.requestValidFromField(true);
    }
    public APIRequestGet requestValidFromField (boolean value) {
      this.requestField("valid_from", value);
      return this;
    }
    public APIRequestGet requestValidUntilField () {
      return this.requestValidUntilField(true);
    }
    public APIRequestGet requestValidUntilField (boolean value) {
      this.requestField("valid_until", value);
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

  public GeoGatingPolicy copyFrom(GeoGatingPolicy instance) {
    this.mAfterSchedule = instance.mAfterSchedule;
    this.mExcludeCountry = instance.mExcludeCountry;
    this.mId = instance.mId;
    this.mIncludeCountry = instance.mIncludeCountry;
    this.mName = instance.mName;
    this.mValidFrom = instance.mValidFrom;
    this.mValidUntil = instance.mValidUntil;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<GeoGatingPolicy> getParser() {
    return new APIRequest.ResponseParser<GeoGatingPolicy>() {
      public APINodeList<GeoGatingPolicy> parseResponse(String response, APIContext context, APIRequest<GeoGatingPolicy> request, String header) throws MalformedResponseException {
        return GeoGatingPolicy.parseResponse(response, context, request, header);
      }
    };
  }
}
