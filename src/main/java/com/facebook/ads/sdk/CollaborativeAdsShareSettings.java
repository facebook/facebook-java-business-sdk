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
public class CollaborativeAdsShareSettings extends APINode {
  @SerializedName("agency_business")
  private Business mAgencyBusiness = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("product_catalog_proxy_id")
  private String mProductCatalogProxyId = null;
  @SerializedName("utm_campaign")
  private String mUtmCampaign = null;
  @SerializedName("utm_medium")
  private String mUtmMedium = null;
  @SerializedName("utm_source")
  private String mUtmSource = null;
  protected static Gson gson = null;

  CollaborativeAdsShareSettings() {
  }

  public CollaborativeAdsShareSettings(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CollaborativeAdsShareSettings(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CollaborativeAdsShareSettings fetch() throws APIException{
    CollaborativeAdsShareSettings newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CollaborativeAdsShareSettings fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CollaborativeAdsShareSettings> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CollaborativeAdsShareSettings fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CollaborativeAdsShareSettings> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CollaborativeAdsShareSettings> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CollaborativeAdsShareSettings>)(
      new APIRequest<CollaborativeAdsShareSettings>(context, "", "/", "GET", CollaborativeAdsShareSettings.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CollaborativeAdsShareSettings>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CollaborativeAdsShareSettings.getParser())
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
  public static CollaborativeAdsShareSettings loadJSON(String json, APIContext context, String header) {
    CollaborativeAdsShareSettings collaborativeAdsShareSettings = getGson().fromJson(json, CollaborativeAdsShareSettings.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(collaborativeAdsShareSettings.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    collaborativeAdsShareSettings.context = context;
    collaborativeAdsShareSettings.rawValue = json;
    collaborativeAdsShareSettings.header = header;
    return collaborativeAdsShareSettings;
  }

  public static APINodeList<CollaborativeAdsShareSettings> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CollaborativeAdsShareSettings> collaborativeAdsShareSettingss = new APINodeList<CollaborativeAdsShareSettings>(request, json, header);
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
          collaborativeAdsShareSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return collaborativeAdsShareSettingss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                collaborativeAdsShareSettingss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            collaborativeAdsShareSettingss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              collaborativeAdsShareSettingss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              collaborativeAdsShareSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  collaborativeAdsShareSettingss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              collaborativeAdsShareSettingss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return collaborativeAdsShareSettingss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              collaborativeAdsShareSettingss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return collaborativeAdsShareSettingss;
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
              collaborativeAdsShareSettingss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return collaborativeAdsShareSettingss;
          }

          // Sixth, check if it's pure JsonObject
          collaborativeAdsShareSettingss.clear();
          collaborativeAdsShareSettingss.add(loadJSON(json, context, header));
          return collaborativeAdsShareSettingss;
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


  public Business getFieldAgencyBusiness() {
    if (mAgencyBusiness != null) {
      mAgencyBusiness.context = getContext();
    }
    return mAgencyBusiness;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldProductCatalogProxyId() {
    return mProductCatalogProxyId;
  }

  public String getFieldUtmCampaign() {
    return mUtmCampaign;
  }

  public String getFieldUtmMedium() {
    return mUtmMedium;
  }

  public String getFieldUtmSource() {
    return mUtmSource;
  }



  public static class APIRequestGet extends APIRequest<CollaborativeAdsShareSettings> {

    CollaborativeAdsShareSettings lastResponse = null;
    @Override
    public CollaborativeAdsShareSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "agency_business",
      "id",
      "product_catalog_proxy_id",
      "utm_campaign",
      "utm_medium",
      "utm_source",
    };

    @Override
    public CollaborativeAdsShareSettings parseResponse(String response, String header) throws APIException {
      return CollaborativeAdsShareSettings.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CollaborativeAdsShareSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CollaborativeAdsShareSettings execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CollaborativeAdsShareSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CollaborativeAdsShareSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CollaborativeAdsShareSettings>() {
           public CollaborativeAdsShareSettings apply(ResponseWrapper result) {
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

    public APIRequestGet requestAgencyBusinessField () {
      return this.requestAgencyBusinessField(true);
    }
    public APIRequestGet requestAgencyBusinessField (boolean value) {
      this.requestField("agency_business", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestProductCatalogProxyIdField () {
      return this.requestProductCatalogProxyIdField(true);
    }
    public APIRequestGet requestProductCatalogProxyIdField (boolean value) {
      this.requestField("product_catalog_proxy_id", value);
      return this;
    }
    public APIRequestGet requestUtmCampaignField () {
      return this.requestUtmCampaignField(true);
    }
    public APIRequestGet requestUtmCampaignField (boolean value) {
      this.requestField("utm_campaign", value);
      return this;
    }
    public APIRequestGet requestUtmMediumField () {
      return this.requestUtmMediumField(true);
    }
    public APIRequestGet requestUtmMediumField (boolean value) {
      this.requestField("utm_medium", value);
      return this;
    }
    public APIRequestGet requestUtmSourceField () {
      return this.requestUtmSourceField(true);
    }
    public APIRequestGet requestUtmSourceField (boolean value) {
      this.requestField("utm_source", value);
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

  public CollaborativeAdsShareSettings copyFrom(CollaborativeAdsShareSettings instance) {
    this.mAgencyBusiness = instance.mAgencyBusiness;
    this.mId = instance.mId;
    this.mProductCatalogProxyId = instance.mProductCatalogProxyId;
    this.mUtmCampaign = instance.mUtmCampaign;
    this.mUtmMedium = instance.mUtmMedium;
    this.mUtmSource = instance.mUtmSource;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CollaborativeAdsShareSettings> getParser() {
    return new APIRequest.ResponseParser<CollaborativeAdsShareSettings>() {
      public APINodeList<CollaborativeAdsShareSettings> parseResponse(String response, APIContext context, APIRequest<CollaborativeAdsShareSettings> request, String header) throws MalformedResponseException {
        return CollaborativeAdsShareSettings.parseResponse(response, context, request, header);
      }
    };
  }
}
