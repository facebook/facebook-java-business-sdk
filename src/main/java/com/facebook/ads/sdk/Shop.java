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
public class Shop extends APINode {
  @SerializedName("commerce_merchant_settings")
  private CommerceMerchantSettings mCommerceMerchantSettings = null;
  @SerializedName("fb_sales_channel")
  private Object mFbSalesChannel = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ig_sales_channel")
  private Object mIgSalesChannel = null;
  @SerializedName("is_onsite_enabled")
  private Boolean mIsOnsiteEnabled = null;
  @SerializedName("shop_status")
  private String mShopStatus = null;
  @SerializedName("workspace")
  private Object mWorkspace = null;
  protected static Gson gson = null;

  Shop() {
  }

  public Shop(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Shop(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Shop fetch() throws APIException{
    Shop newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Shop fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Shop> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Shop fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Shop> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Shop> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Shop>)(
      new APIRequest<Shop>(context, "", "/", "GET", Shop.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Shop>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Shop.getParser())
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
  public static Shop loadJSON(String json, APIContext context, String header) {
    Shop shop = getGson().fromJson(json, Shop.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(shop.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    shop.context = context;
    shop.rawValue = json;
    shop.header = header;
    return shop;
  }

  public static APINodeList<Shop> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Shop> shops = new APINodeList<Shop>(request, json, header);
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
          shops.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return shops;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                shops.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            shops.setPaging(previous, next);
            if (context.hasAppSecret()) {
              shops.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              shops.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  shops.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              shops.add(loadJSON(obj.toString(), context, header));
            }
          }
          return shops;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              shops.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return shops;
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
              shops.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return shops;
          }

          // Sixth, check if it's pure JsonObject
          shops.clear();
          shops.add(loadJSON(json, context, header));
          return shops;
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


  public CommerceMerchantSettings getFieldCommerceMerchantSettings() {
    if (mCommerceMerchantSettings != null) {
      mCommerceMerchantSettings.context = getContext();
    }
    return mCommerceMerchantSettings;
  }

  public Object getFieldFbSalesChannel() {
    return mFbSalesChannel;
  }

  public String getFieldId() {
    return mId;
  }

  public Object getFieldIgSalesChannel() {
    return mIgSalesChannel;
  }

  public Boolean getFieldIsOnsiteEnabled() {
    return mIsOnsiteEnabled;
  }

  public String getFieldShopStatus() {
    return mShopStatus;
  }

  public Object getFieldWorkspace() {
    return mWorkspace;
  }



  public static class APIRequestGet extends APIRequest<Shop> {

    Shop lastResponse = null;
    @Override
    public Shop getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "commerce_merchant_settings",
      "fb_sales_channel",
      "id",
      "ig_sales_channel",
      "is_onsite_enabled",
      "shop_status",
      "workspace",
    };

    @Override
    public Shop parseResponse(String response, String header) throws APIException {
      return Shop.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Shop execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Shop execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Shop> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Shop> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Shop>() {
           public Shop apply(ResponseWrapper result) {
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

    public APIRequestGet requestCommerceMerchantSettingsField () {
      return this.requestCommerceMerchantSettingsField(true);
    }
    public APIRequestGet requestCommerceMerchantSettingsField (boolean value) {
      this.requestField("commerce_merchant_settings", value);
      return this;
    }
    public APIRequestGet requestFbSalesChannelField () {
      return this.requestFbSalesChannelField(true);
    }
    public APIRequestGet requestFbSalesChannelField (boolean value) {
      this.requestField("fb_sales_channel", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIgSalesChannelField () {
      return this.requestIgSalesChannelField(true);
    }
    public APIRequestGet requestIgSalesChannelField (boolean value) {
      this.requestField("ig_sales_channel", value);
      return this;
    }
    public APIRequestGet requestIsOnsiteEnabledField () {
      return this.requestIsOnsiteEnabledField(true);
    }
    public APIRequestGet requestIsOnsiteEnabledField (boolean value) {
      this.requestField("is_onsite_enabled", value);
      return this;
    }
    public APIRequestGet requestShopStatusField () {
      return this.requestShopStatusField(true);
    }
    public APIRequestGet requestShopStatusField (boolean value) {
      this.requestField("shop_status", value);
      return this;
    }
    public APIRequestGet requestWorkspaceField () {
      return this.requestWorkspaceField(true);
    }
    public APIRequestGet requestWorkspaceField (boolean value) {
      this.requestField("workspace", value);
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

  public Shop copyFrom(Shop instance) {
    this.mCommerceMerchantSettings = instance.mCommerceMerchantSettings;
    this.mFbSalesChannel = instance.mFbSalesChannel;
    this.mId = instance.mId;
    this.mIgSalesChannel = instance.mIgSalesChannel;
    this.mIsOnsiteEnabled = instance.mIsOnsiteEnabled;
    this.mShopStatus = instance.mShopStatus;
    this.mWorkspace = instance.mWorkspace;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Shop> getParser() {
    return new APIRequest.ResponseParser<Shop>() {
      public APINodeList<Shop> parseResponse(String response, APIContext context, APIRequest<Shop> request, String header) throws MalformedResponseException {
        return Shop.parseResponse(response, context, request, header);
      }
    };
  }
}
