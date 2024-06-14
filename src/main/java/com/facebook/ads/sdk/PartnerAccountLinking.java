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
public class PartnerAccountLinking extends APINode {
  @SerializedName("adaccount")
  private AdAccount mAdaccount = null;
  @SerializedName("app")
  private Application mApp = null;
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("externalidentifier")
  private String mExternalidentifier = null;
  @SerializedName("externalidentifieruri")
  private String mExternalidentifieruri = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("partnername")
  private String mPartnername = null;
  @SerializedName("pixel")
  private String mPixel = null;
  protected static Gson gson = null;

  PartnerAccountLinking() {
  }

  public PartnerAccountLinking(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PartnerAccountLinking(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PartnerAccountLinking fetch() throws APIException{
    PartnerAccountLinking newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PartnerAccountLinking fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PartnerAccountLinking> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PartnerAccountLinking fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PartnerAccountLinking> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PartnerAccountLinking> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PartnerAccountLinking>)(
      new APIRequest<PartnerAccountLinking>(context, "", "/", "GET", PartnerAccountLinking.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PartnerAccountLinking>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PartnerAccountLinking.getParser())
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
  public static PartnerAccountLinking loadJSON(String json, APIContext context, String header) {
    PartnerAccountLinking partnerAccountLinking = getGson().fromJson(json, PartnerAccountLinking.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(partnerAccountLinking.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    partnerAccountLinking.context = context;
    partnerAccountLinking.rawValue = json;
    partnerAccountLinking.header = header;
    return partnerAccountLinking;
  }

  public static APINodeList<PartnerAccountLinking> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PartnerAccountLinking> partnerAccountLinkings = new APINodeList<PartnerAccountLinking>(request, json, header);
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
          partnerAccountLinkings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return partnerAccountLinkings;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                partnerAccountLinkings.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            partnerAccountLinkings.setPaging(previous, next);
            if (context.hasAppSecret()) {
              partnerAccountLinkings.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              partnerAccountLinkings.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  partnerAccountLinkings.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              partnerAccountLinkings.add(loadJSON(obj.toString(), context, header));
            }
          }
          return partnerAccountLinkings;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              partnerAccountLinkings.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return partnerAccountLinkings;
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
              partnerAccountLinkings.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return partnerAccountLinkings;
          }

          // Sixth, check if it's pure JsonObject
          partnerAccountLinkings.clear();
          partnerAccountLinkings.add(loadJSON(json, context, header));
          return partnerAccountLinkings;
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


  public AdAccount getFieldAdaccount() {
    if (mAdaccount != null) {
      mAdaccount.context = getContext();
    }
    return mAdaccount;
  }

  public Application getFieldApp() {
    if (mApp != null) {
      mApp.context = getContext();
    }
    return mApp;
  }

  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public String getFieldExternalidentifier() {
    return mExternalidentifier;
  }

  public String getFieldExternalidentifieruri() {
    return mExternalidentifieruri;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldPartnername() {
    return mPartnername;
  }

  public String getFieldPixel() {
    return mPixel;
  }



  public static class APIRequestGet extends APIRequest<PartnerAccountLinking> {

    PartnerAccountLinking lastResponse = null;
    @Override
    public PartnerAccountLinking getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "adaccount",
      "app",
      "business",
      "externalidentifier",
      "externalidentifieruri",
      "id",
      "partnername",
      "pixel",
    };

    @Override
    public PartnerAccountLinking parseResponse(String response, String header) throws APIException {
      return PartnerAccountLinking.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PartnerAccountLinking execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PartnerAccountLinking execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PartnerAccountLinking> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PartnerAccountLinking> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PartnerAccountLinking>() {
           public PartnerAccountLinking apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdaccountField () {
      return this.requestAdaccountField(true);
    }
    public APIRequestGet requestAdaccountField (boolean value) {
      this.requestField("adaccount", value);
      return this;
    }
    public APIRequestGet requestAppField () {
      return this.requestAppField(true);
    }
    public APIRequestGet requestAppField (boolean value) {
      this.requestField("app", value);
      return this;
    }
    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestExternalidentifierField () {
      return this.requestExternalidentifierField(true);
    }
    public APIRequestGet requestExternalidentifierField (boolean value) {
      this.requestField("externalidentifier", value);
      return this;
    }
    public APIRequestGet requestExternalidentifieruriField () {
      return this.requestExternalidentifieruriField(true);
    }
    public APIRequestGet requestExternalidentifieruriField (boolean value) {
      this.requestField("externalidentifieruri", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPartnernameField () {
      return this.requestPartnernameField(true);
    }
    public APIRequestGet requestPartnernameField (boolean value) {
      this.requestField("partnername", value);
      return this;
    }
    public APIRequestGet requestPixelField () {
      return this.requestPixelField(true);
    }
    public APIRequestGet requestPixelField (boolean value) {
      this.requestField("pixel", value);
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

  public PartnerAccountLinking copyFrom(PartnerAccountLinking instance) {
    this.mAdaccount = instance.mAdaccount;
    this.mApp = instance.mApp;
    this.mBusiness = instance.mBusiness;
    this.mExternalidentifier = instance.mExternalidentifier;
    this.mExternalidentifieruri = instance.mExternalidentifieruri;
    this.mId = instance.mId;
    this.mPartnername = instance.mPartnername;
    this.mPixel = instance.mPixel;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PartnerAccountLinking> getParser() {
    return new APIRequest.ResponseParser<PartnerAccountLinking>() {
      public APINodeList<PartnerAccountLinking> parseResponse(String response, APIContext context, APIRequest<PartnerAccountLinking> request, String header) throws MalformedResponseException {
        return PartnerAccountLinking.parseResponse(response, context, request, header);
      }
    };
  }
}
