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
public class ProductSetAppsAndSoftware extends APINode {
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public ProductSetAppsAndSoftware() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static ProductSetAppsAndSoftware loadJSON(String json, APIContext context, String header) {
    ProductSetAppsAndSoftware productSetAppsAndSoftware = getGson().fromJson(json, ProductSetAppsAndSoftware.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(productSetAppsAndSoftware.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    productSetAppsAndSoftware.context = context;
    productSetAppsAndSoftware.rawValue = json;
    productSetAppsAndSoftware.header = header;
    return productSetAppsAndSoftware;
  }

  public static APINodeList<ProductSetAppsAndSoftware> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ProductSetAppsAndSoftware> productSetAppsAndSoftwares = new APINodeList<ProductSetAppsAndSoftware>(request, json, header);
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
          productSetAppsAndSoftwares.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return productSetAppsAndSoftwares;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                productSetAppsAndSoftwares.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            productSetAppsAndSoftwares.setPaging(previous, next);
            if (context.hasAppSecret()) {
              productSetAppsAndSoftwares.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              productSetAppsAndSoftwares.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  productSetAppsAndSoftwares.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              productSetAppsAndSoftwares.add(loadJSON(obj.toString(), context, header));
            }
          }
          return productSetAppsAndSoftwares;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              productSetAppsAndSoftwares.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return productSetAppsAndSoftwares;
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
              productSetAppsAndSoftwares.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return productSetAppsAndSoftwares;
          }

          // Sixth, check if it's pure JsonObject
          productSetAppsAndSoftwares.clear();
          productSetAppsAndSoftwares.add(loadJSON(json, context, header));
          return productSetAppsAndSoftwares;
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

  public ProductSetAppsAndSoftware setFieldId(String value) {
    this.mId = value;
    return this;
  }



  public static class APIRequestGenget extends APIRequest<ProductSetAppsAndSoftwareGet> {

    APINodeList<ProductSetAppsAndSoftwareGet> lastResponse = null;
    @Override
    public APINodeList<ProductSetAppsAndSoftwareGet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "after",
      "before",
      "display_format",
      "limit",
      "summary",
    };

    public static final String[] FIELDS = {
      "data",
      "paging",
      "summary",
    };

    @Override
    public APINodeList<ProductSetAppsAndSoftwareGet> parseResponse(String response, String header) throws APIException {
      return ProductSetAppsAndSoftwareGet.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<ProductSetAppsAndSoftwareGet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<ProductSetAppsAndSoftwareGet> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<ProductSetAppsAndSoftwareGet>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<ProductSetAppsAndSoftwareGet>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<ProductSetAppsAndSoftwareGet>>() {
           public APINodeList<ProductSetAppsAndSoftwareGet> apply(ResponseWrapper result) {
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
      super(context, nodeId, "/apps_and_software", "GET", Arrays.asList(PARAMS));
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


    public APIRequestGenget setAfter (String after) {
      this.setParam("after", after);
      return this;
    }

    public APIRequestGenget setBefore (String before) {
      this.setParam("before", before);
      return this;
    }

    public APIRequestGenget setDisplayFormat (ProductSetAppsAndSoftwareGet.EnumDisplayFormat displayFormat) {
      this.setParam("display_format", displayFormat);
      return this;
    }
    public APIRequestGenget setDisplayFormat (String displayFormat) {
      this.setParam("display_format", displayFormat);
      return this;
    }

    public APIRequestGenget setLimit (Long limit) {
      this.setParam("limit", limit);
      return this;
    }
    public APIRequestGenget setLimit (String limit) {
      this.setParam("limit", limit);
      return this;
    }

    public APIRequestGenget setSummary (Boolean summary) {
      this.setParam("summary", summary);
      return this;
    }
    public APIRequestGenget setSummary (String summary) {
      this.setParam("summary", summary);
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
    public APIRequestGenget requestPagingField () {
      return this.requestPagingField(true);
    }
    public APIRequestGenget requestPagingField (boolean value) {
      this.requestField("paging", value);
      return this;
    }
    public APIRequestGenget requestSummaryField () {
      return this.requestSummaryField(true);
    }
    public APIRequestGenget requestSummaryField (boolean value) {
      this.requestField("summary", value);
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

  public ProductSetAppsAndSoftware copyFrom(ProductSetAppsAndSoftware instance) {
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProductSetAppsAndSoftware> getParser() {
    return new APIRequest.ResponseParser<ProductSetAppsAndSoftware>() {
      public APINodeList<ProductSetAppsAndSoftware> parseResponse(String response, APIContext context, APIRequest<ProductSetAppsAndSoftware> request, String header) throws MalformedResponseException {
        return ProductSetAppsAndSoftware.parseResponse(response, context, request, header);
      }
    };
  }
}
