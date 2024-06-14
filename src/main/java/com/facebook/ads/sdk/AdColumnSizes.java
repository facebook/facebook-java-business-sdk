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
public class AdColumnSizes extends APINode {
  @SerializedName("admarket_account")
  private AdAccount mAdmarketAccount = null;
  @SerializedName("app_id")
  private String mAppId = null;
  @SerializedName("columns")
  private List<Map<String, String>> mColumns = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("owner")
  private User mOwner = null;
  @SerializedName("page")
  private String mPage = null;
  @SerializedName("report")
  private String mReport = null;
  @SerializedName("tab")
  private String mTab = null;
  @SerializedName("view")
  private String mView = null;
  protected static Gson gson = null;

  AdColumnSizes() {
  }

  public AdColumnSizes(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdColumnSizes(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdColumnSizes fetch() throws APIException{
    AdColumnSizes newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdColumnSizes fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdColumnSizes> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdColumnSizes fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdColumnSizes> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdColumnSizes> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdColumnSizes>)(
      new APIRequest<AdColumnSizes>(context, "", "/", "GET", AdColumnSizes.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdColumnSizes>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdColumnSizes.getParser())
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
  public static AdColumnSizes loadJSON(String json, APIContext context, String header) {
    AdColumnSizes adColumnSizes = getGson().fromJson(json, AdColumnSizes.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adColumnSizes.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adColumnSizes.context = context;
    adColumnSizes.rawValue = json;
    adColumnSizes.header = header;
    return adColumnSizes;
  }

  public static APINodeList<AdColumnSizes> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdColumnSizes> adColumnSizess = new APINodeList<AdColumnSizes>(request, json, header);
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
          adColumnSizess.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adColumnSizess;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adColumnSizess.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adColumnSizess.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adColumnSizess.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adColumnSizess.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adColumnSizess.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adColumnSizess.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adColumnSizess;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adColumnSizess.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adColumnSizess;
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
              adColumnSizess.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adColumnSizess;
          }

          // Sixth, check if it's pure JsonObject
          adColumnSizess.clear();
          adColumnSizess.add(loadJSON(json, context, header));
          return adColumnSizess;
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


  public AdAccount getFieldAdmarketAccount() {
    if (mAdmarketAccount != null) {
      mAdmarketAccount.context = getContext();
    }
    return mAdmarketAccount;
  }

  public String getFieldAppId() {
    return mAppId;
  }

  public List<Map<String, String>> getFieldColumns() {
    return mColumns;
  }

  public String getFieldId() {
    return mId;
  }

  public User getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public String getFieldPage() {
    return mPage;
  }

  public String getFieldReport() {
    return mReport;
  }

  public String getFieldTab() {
    return mTab;
  }

  public String getFieldView() {
    return mView;
  }



  public static class APIRequestGet extends APIRequest<AdColumnSizes> {

    AdColumnSizes lastResponse = null;
    @Override
    public AdColumnSizes getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "admarket_account",
      "app_id",
      "columns",
      "id",
      "owner",
      "page",
      "report",
      "tab",
      "view",
    };

    @Override
    public AdColumnSizes parseResponse(String response, String header) throws APIException {
      return AdColumnSizes.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdColumnSizes execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdColumnSizes execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdColumnSizes> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdColumnSizes> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdColumnSizes>() {
           public AdColumnSizes apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdmarketAccountField () {
      return this.requestAdmarketAccountField(true);
    }
    public APIRequestGet requestAdmarketAccountField (boolean value) {
      this.requestField("admarket_account", value);
      return this;
    }
    public APIRequestGet requestAppIdField () {
      return this.requestAppIdField(true);
    }
    public APIRequestGet requestAppIdField (boolean value) {
      this.requestField("app_id", value);
      return this;
    }
    public APIRequestGet requestColumnsField () {
      return this.requestColumnsField(true);
    }
    public APIRequestGet requestColumnsField (boolean value) {
      this.requestField("columns", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestReportField () {
      return this.requestReportField(true);
    }
    public APIRequestGet requestReportField (boolean value) {
      this.requestField("report", value);
      return this;
    }
    public APIRequestGet requestTabField () {
      return this.requestTabField(true);
    }
    public APIRequestGet requestTabField (boolean value) {
      this.requestField("tab", value);
      return this;
    }
    public APIRequestGet requestViewField () {
      return this.requestViewField(true);
    }
    public APIRequestGet requestViewField (boolean value) {
      this.requestField("view", value);
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

  public AdColumnSizes copyFrom(AdColumnSizes instance) {
    this.mAdmarketAccount = instance.mAdmarketAccount;
    this.mAppId = instance.mAppId;
    this.mColumns = instance.mColumns;
    this.mId = instance.mId;
    this.mOwner = instance.mOwner;
    this.mPage = instance.mPage;
    this.mReport = instance.mReport;
    this.mTab = instance.mTab;
    this.mView = instance.mView;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdColumnSizes> getParser() {
    return new APIRequest.ResponseParser<AdColumnSizes>() {
      public APINodeList<AdColumnSizes> parseResponse(String response, APIContext context, APIRequest<AdColumnSizes> request, String header) throws MalformedResponseException {
        return AdColumnSizes.parseResponse(response, context, request, header);
      }
    };
  }
}
