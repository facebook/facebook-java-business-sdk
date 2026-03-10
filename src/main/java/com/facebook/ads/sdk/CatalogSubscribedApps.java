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
public class CatalogSubscribedApps extends APINode {
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public CatalogSubscribedApps() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static CatalogSubscribedApps loadJSON(String json, APIContext context, String header) {
    CatalogSubscribedApps catalogSubscribedApps = getGson().fromJson(json, CatalogSubscribedApps.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(catalogSubscribedApps.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    catalogSubscribedApps.context = context;
    catalogSubscribedApps.rawValue = json;
    catalogSubscribedApps.header = header;
    return catalogSubscribedApps;
  }

  public static APINodeList<CatalogSubscribedApps> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CatalogSubscribedApps> catalogSubscribedAppss = new APINodeList<CatalogSubscribedApps>(request, json, header);
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
          catalogSubscribedAppss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return catalogSubscribedAppss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                catalogSubscribedAppss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            catalogSubscribedAppss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              catalogSubscribedAppss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              catalogSubscribedAppss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  catalogSubscribedAppss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              catalogSubscribedAppss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return catalogSubscribedAppss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              catalogSubscribedAppss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return catalogSubscribedAppss;
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
              catalogSubscribedAppss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return catalogSubscribedAppss;
          }

          // Sixth, check if it's pure JsonObject
          catalogSubscribedAppss.clear();
          catalogSubscribedAppss.add(loadJSON(json, context, header));
          return catalogSubscribedAppss;
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

  public APIRequestGendelete gendelete() {
    return new APIRequestGendelete(this.getId(), context);
  }


  public String getFieldId() {
    return mId;
  }

  public CatalogSubscribedApps setFieldId(String value) {
    this.mId = value;
    return this;
  }



  public static class APIRequestGendelete extends APIRequest<CatalogSubscribedAppsDelete> {

    APINodeList<CatalogSubscribedAppsDelete> lastResponse = null;
    @Override
    public APINodeList<CatalogSubscribedAppsDelete> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<CatalogSubscribedAppsDelete> parseResponse(String response, String header) throws APIException {
      return CatalogSubscribedAppsDelete.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CatalogSubscribedAppsDelete> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CatalogSubscribedAppsDelete> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CatalogSubscribedAppsDelete>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CatalogSubscribedAppsDelete>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CatalogSubscribedAppsDelete>>() {
           public APINodeList<CatalogSubscribedAppsDelete> apply(ResponseWrapper result) {
             try {
               return APIRequestGendelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGendelete(String nodeId, APIContext context) {
      super(context, nodeId, "/subscribed_apps", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGendelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGendelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGendelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGendelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGendelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGendelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGendelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGendelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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

  public CatalogSubscribedApps copyFrom(CatalogSubscribedApps instance) {
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CatalogSubscribedApps> getParser() {
    return new APIRequest.ResponseParser<CatalogSubscribedApps>() {
      public APINodeList<CatalogSubscribedApps> parseResponse(String response, APIContext context, APIRequest<CatalogSubscribedApps> request, String header) throws MalformedResponseException {
        return CatalogSubscribedApps.parseResponse(response, context, request, header);
      }
    };
  }
}
