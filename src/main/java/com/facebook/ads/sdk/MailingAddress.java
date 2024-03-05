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
public class MailingAddress extends APINode {
  @SerializedName("city")
  private String mCity = null;
  @SerializedName("city_page")
  private Page mCityPage = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("postal_code")
  private String mPostalCode = null;
  @SerializedName("region")
  private String mRegion = null;
  @SerializedName("street1")
  private String mStreet1 = null;
  @SerializedName("street2")
  private String mStreet2 = null;
  protected static Gson gson = null;

  MailingAddress() {
  }

  public MailingAddress(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MailingAddress(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MailingAddress fetch() throws APIException{
    MailingAddress newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MailingAddress fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MailingAddress> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MailingAddress fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MailingAddress> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MailingAddress> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MailingAddress>)(
      new APIRequest<MailingAddress>(context, "", "/", "GET", MailingAddress.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MailingAddress>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MailingAddress.getParser())
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
  public static MailingAddress loadJSON(String json, APIContext context, String header) {
    MailingAddress mailingAddress = getGson().fromJson(json, MailingAddress.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(mailingAddress.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    mailingAddress.context = context;
    mailingAddress.rawValue = json;
    mailingAddress.header = header;
    return mailingAddress;
  }

  public static APINodeList<MailingAddress> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MailingAddress> mailingAddresss = new APINodeList<MailingAddress>(request, json, header);
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
          mailingAddresss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return mailingAddresss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                mailingAddresss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            mailingAddresss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              mailingAddresss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              mailingAddresss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  mailingAddresss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              mailingAddresss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return mailingAddresss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mailingAddresss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return mailingAddresss;
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
              mailingAddresss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return mailingAddresss;
          }

          // Sixth, check if it's pure JsonObject
          mailingAddresss.clear();
          mailingAddresss.add(loadJSON(json, context, header));
          return mailingAddresss;
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


  public String getFieldCity() {
    return mCity;
  }

  public Page getFieldCityPage() {
    if (mCityPage != null) {
      mCityPage.context = getContext();
    }
    return mCityPage;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldPostalCode() {
    return mPostalCode;
  }

  public String getFieldRegion() {
    return mRegion;
  }

  public String getFieldStreet1() {
    return mStreet1;
  }

  public String getFieldStreet2() {
    return mStreet2;
  }



  public static class APIRequestGet extends APIRequest<MailingAddress> {

    MailingAddress lastResponse = null;
    @Override
    public MailingAddress getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "city",
      "city_page",
      "country",
      "id",
      "postal_code",
      "region",
      "street1",
      "street2",
    };

    @Override
    public MailingAddress parseResponse(String response, String header) throws APIException {
      return MailingAddress.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MailingAddress execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MailingAddress execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MailingAddress> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MailingAddress> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MailingAddress>() {
           public MailingAddress apply(ResponseWrapper result) {
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

    public APIRequestGet requestCityField () {
      return this.requestCityField(true);
    }
    public APIRequestGet requestCityField (boolean value) {
      this.requestField("city", value);
      return this;
    }
    public APIRequestGet requestCityPageField () {
      return this.requestCityPageField(true);
    }
    public APIRequestGet requestCityPageField (boolean value) {
      this.requestField("city_page", value);
      return this;
    }
    public APIRequestGet requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGet requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPostalCodeField () {
      return this.requestPostalCodeField(true);
    }
    public APIRequestGet requestPostalCodeField (boolean value) {
      this.requestField("postal_code", value);
      return this;
    }
    public APIRequestGet requestRegionField () {
      return this.requestRegionField(true);
    }
    public APIRequestGet requestRegionField (boolean value) {
      this.requestField("region", value);
      return this;
    }
    public APIRequestGet requestStreet1Field () {
      return this.requestStreet1Field(true);
    }
    public APIRequestGet requestStreet1Field (boolean value) {
      this.requestField("street1", value);
      return this;
    }
    public APIRequestGet requestStreet2Field () {
      return this.requestStreet2Field(true);
    }
    public APIRequestGet requestStreet2Field (boolean value) {
      this.requestField("street2", value);
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

  public MailingAddress copyFrom(MailingAddress instance) {
    this.mCity = instance.mCity;
    this.mCityPage = instance.mCityPage;
    this.mCountry = instance.mCountry;
    this.mId = instance.mId;
    this.mPostalCode = instance.mPostalCode;
    this.mRegion = instance.mRegion;
    this.mStreet1 = instance.mStreet1;
    this.mStreet2 = instance.mStreet2;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MailingAddress> getParser() {
    return new APIRequest.ResponseParser<MailingAddress>() {
      public APINodeList<MailingAddress> parseResponse(String response, APIContext context, APIRequest<MailingAddress> request, String header) throws MalformedResponseException {
        return MailingAddress.parseResponse(response, context, request, header);
      }
    };
  }
}
