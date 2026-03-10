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
public class CatalogGenericIngestionSessionErrors extends APINode {
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public CatalogGenericIngestionSessionErrors() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static CatalogGenericIngestionSessionErrors loadJSON(String json, APIContext context, String header) {
    CatalogGenericIngestionSessionErrors catalogGenericIngestionSessionErrors = getGson().fromJson(json, CatalogGenericIngestionSessionErrors.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(catalogGenericIngestionSessionErrors.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    catalogGenericIngestionSessionErrors.context = context;
    catalogGenericIngestionSessionErrors.rawValue = json;
    catalogGenericIngestionSessionErrors.header = header;
    return catalogGenericIngestionSessionErrors;
  }

  public static APINodeList<CatalogGenericIngestionSessionErrors> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CatalogGenericIngestionSessionErrors> catalogGenericIngestionSessionErrorss = new APINodeList<CatalogGenericIngestionSessionErrors>(request, json, header);
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
          catalogGenericIngestionSessionErrorss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return catalogGenericIngestionSessionErrorss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                catalogGenericIngestionSessionErrorss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            catalogGenericIngestionSessionErrorss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              catalogGenericIngestionSessionErrorss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              catalogGenericIngestionSessionErrorss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  catalogGenericIngestionSessionErrorss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              catalogGenericIngestionSessionErrorss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return catalogGenericIngestionSessionErrorss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              catalogGenericIngestionSessionErrorss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return catalogGenericIngestionSessionErrorss;
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
              catalogGenericIngestionSessionErrorss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return catalogGenericIngestionSessionErrorss;
          }

          // Sixth, check if it's pure JsonObject
          catalogGenericIngestionSessionErrorss.clear();
          catalogGenericIngestionSessionErrorss.add(loadJSON(json, context, header));
          return catalogGenericIngestionSessionErrorss;
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

  public APIRequestGenget genget() {
    return new APIRequestGenget(this.getId(), context);
  }


  public String getFieldId() {
    return mId;
  }

  public CatalogGenericIngestionSessionErrors setFieldId(String value) {
    this.mId = value;
    return this;
  }



  public static class APIRequestGenget extends APIRequest<CatalogGenericIngestionSessionErrorsGet> {

    APINodeList<CatalogGenericIngestionSessionErrorsGet> lastResponse = null;
    @Override
    public APINodeList<CatalogGenericIngestionSessionErrorsGet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "error_priority",
    };

    public static final String[] FIELDS = {
      "data",
    };

    @Override
    public APINodeList<CatalogGenericIngestionSessionErrorsGet> parseResponse(String response, String header) throws APIException {
      return CatalogGenericIngestionSessionErrorsGet.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CatalogGenericIngestionSessionErrorsGet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CatalogGenericIngestionSessionErrorsGet> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CatalogGenericIngestionSessionErrorsGet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CatalogGenericIngestionSessionErrorsGet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CatalogGenericIngestionSessionErrorsGet>>() {
           public APINodeList<CatalogGenericIngestionSessionErrorsGet> apply(ResponseWrapper result) {
             try {
               return APIRequestGenget.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGenget(String nodeId, APIContext context) {
      super(context, nodeId, "/errors", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGenget setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGenget setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGenget setErrorPriority (String errorPriority) {
      this.setParam("error_priority", errorPriority);
      return this;
    }

    public APIRequestGenget requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGenget requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGenget requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGenget requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGenget requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGenget requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGenget requestDataField () {
      return this.requestDataField(true);
    }
    public APIRequestGenget requestDataField (boolean value) {
      this.requestField("data", value);
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

  public CatalogGenericIngestionSessionErrors copyFrom(CatalogGenericIngestionSessionErrors instance) {
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CatalogGenericIngestionSessionErrors> getParser() {
    return new APIRequest.ResponseParser<CatalogGenericIngestionSessionErrors>() {
      public APINodeList<CatalogGenericIngestionSessionErrors> parseResponse(String response, APIContext context, APIRequest<CatalogGenericIngestionSessionErrors> request, String header) throws MalformedResponseException {
        return CatalogGenericIngestionSessionErrors.parseResponse(response, context, request, header);
      }
    };
  }
}
