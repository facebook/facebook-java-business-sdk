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
public class CallAdsPhoneData extends APINode {
  @SerializedName("call_ads_phone_data_use_case")
  private String mCallAdsPhoneDataUseCase = null;
  @SerializedName("callback_variant")
  private String mCallbackVariant = null;
  @SerializedName("destination_website_url")
  private String mDestinationWebsiteUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("phone_number")
  private String mPhoneNumber = null;
  protected static Gson gson = null;

  CallAdsPhoneData() {
  }

  public CallAdsPhoneData(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CallAdsPhoneData(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CallAdsPhoneData fetch() throws APIException{
    CallAdsPhoneData newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CallAdsPhoneData fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CallAdsPhoneData> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CallAdsPhoneData fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CallAdsPhoneData> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CallAdsPhoneData> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CallAdsPhoneData>)(
      new APIRequest<CallAdsPhoneData>(context, "", "/", "GET", CallAdsPhoneData.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CallAdsPhoneData>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CallAdsPhoneData.getParser())
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
  public static CallAdsPhoneData loadJSON(String json, APIContext context, String header) {
    CallAdsPhoneData callAdsPhoneData = getGson().fromJson(json, CallAdsPhoneData.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(callAdsPhoneData.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    callAdsPhoneData.context = context;
    callAdsPhoneData.rawValue = json;
    callAdsPhoneData.header = header;
    return callAdsPhoneData;
  }

  public static APINodeList<CallAdsPhoneData> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CallAdsPhoneData> callAdsPhoneDatas = new APINodeList<CallAdsPhoneData>(request, json, header);
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
          callAdsPhoneDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return callAdsPhoneDatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                callAdsPhoneDatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            callAdsPhoneDatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              callAdsPhoneDatas.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              callAdsPhoneDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  callAdsPhoneDatas.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              callAdsPhoneDatas.add(loadJSON(obj.toString(), context, header));
            }
          }
          return callAdsPhoneDatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              callAdsPhoneDatas.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return callAdsPhoneDatas;
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
              callAdsPhoneDatas.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return callAdsPhoneDatas;
          }

          // Sixth, check if it's pure JsonObject
          callAdsPhoneDatas.clear();
          callAdsPhoneDatas.add(loadJSON(json, context, header));
          return callAdsPhoneDatas;
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


  public String getFieldCallAdsPhoneDataUseCase() {
    return mCallAdsPhoneDataUseCase;
  }

  public String getFieldCallbackVariant() {
    return mCallbackVariant;
  }

  public String getFieldDestinationWebsiteUrl() {
    return mDestinationWebsiteUrl;
  }

  public String getFieldId() {
    return mId;
  }

  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public String getFieldPhoneNumber() {
    return mPhoneNumber;
  }



  public static class APIRequestGet extends APIRequest<CallAdsPhoneData> {

    CallAdsPhoneData lastResponse = null;
    @Override
    public CallAdsPhoneData getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "call_ads_phone_data_use_case",
      "callback_variant",
      "destination_website_url",
      "id",
      "page",
      "phone_number",
    };

    @Override
    public CallAdsPhoneData parseResponse(String response, String header) throws APIException {
      return CallAdsPhoneData.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CallAdsPhoneData execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CallAdsPhoneData execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CallAdsPhoneData> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CallAdsPhoneData> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CallAdsPhoneData>() {
           public CallAdsPhoneData apply(ResponseWrapper result) {
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

    public APIRequestGet requestCallAdsPhoneDataUseCaseField () {
      return this.requestCallAdsPhoneDataUseCaseField(true);
    }
    public APIRequestGet requestCallAdsPhoneDataUseCaseField (boolean value) {
      this.requestField("call_ads_phone_data_use_case", value);
      return this;
    }
    public APIRequestGet requestCallbackVariantField () {
      return this.requestCallbackVariantField(true);
    }
    public APIRequestGet requestCallbackVariantField (boolean value) {
      this.requestField("callback_variant", value);
      return this;
    }
    public APIRequestGet requestDestinationWebsiteUrlField () {
      return this.requestDestinationWebsiteUrlField(true);
    }
    public APIRequestGet requestDestinationWebsiteUrlField (boolean value) {
      this.requestField("destination_website_url", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestPhoneNumberField () {
      return this.requestPhoneNumberField(true);
    }
    public APIRequestGet requestPhoneNumberField (boolean value) {
      this.requestField("phone_number", value);
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

  public CallAdsPhoneData copyFrom(CallAdsPhoneData instance) {
    this.mCallAdsPhoneDataUseCase = instance.mCallAdsPhoneDataUseCase;
    this.mCallbackVariant = instance.mCallbackVariant;
    this.mDestinationWebsiteUrl = instance.mDestinationWebsiteUrl;
    this.mId = instance.mId;
    this.mPage = instance.mPage;
    this.mPhoneNumber = instance.mPhoneNumber;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CallAdsPhoneData> getParser() {
    return new APIRequest.ResponseParser<CallAdsPhoneData>() {
      public APINodeList<CallAdsPhoneData> parseResponse(String response, APIContext context, APIRequest<CallAdsPhoneData> request, String header) throws MalformedResponseException {
        return CallAdsPhoneData.parseResponse(response, context, request, header);
      }
    };
  }
}
