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
public class CopyrightOwnershipTransfer extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("receiving_rights_holder")
  private Profile mReceivingRightsHolder = null;
  @SerializedName("sending_rights_holder")
  private Profile mSendingRightsHolder = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("transfer_territories")
  private List<String> mTransferTerritories = null;
  @SerializedName("transfer_time")
  private String mTransferTime = null;
  protected static Gson gson = null;

  CopyrightOwnershipTransfer() {
  }

  public CopyrightOwnershipTransfer(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CopyrightOwnershipTransfer(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CopyrightOwnershipTransfer fetch() throws APIException{
    CopyrightOwnershipTransfer newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CopyrightOwnershipTransfer fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CopyrightOwnershipTransfer> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CopyrightOwnershipTransfer fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CopyrightOwnershipTransfer> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CopyrightOwnershipTransfer> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CopyrightOwnershipTransfer>)(
      new APIRequest<CopyrightOwnershipTransfer>(context, "", "/", "GET", CopyrightOwnershipTransfer.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CopyrightOwnershipTransfer>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CopyrightOwnershipTransfer.getParser())
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
  public static CopyrightOwnershipTransfer loadJSON(String json, APIContext context, String header) {
    CopyrightOwnershipTransfer copyrightOwnershipTransfer = getGson().fromJson(json, CopyrightOwnershipTransfer.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(copyrightOwnershipTransfer.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    copyrightOwnershipTransfer.context = context;
    copyrightOwnershipTransfer.rawValue = json;
    copyrightOwnershipTransfer.header = header;
    return copyrightOwnershipTransfer;
  }

  public static APINodeList<CopyrightOwnershipTransfer> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CopyrightOwnershipTransfer> copyrightOwnershipTransfers = new APINodeList<CopyrightOwnershipTransfer>(request, json, header);
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
          copyrightOwnershipTransfers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return copyrightOwnershipTransfers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                copyrightOwnershipTransfers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            copyrightOwnershipTransfers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              copyrightOwnershipTransfers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              copyrightOwnershipTransfers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  copyrightOwnershipTransfers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              copyrightOwnershipTransfers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return copyrightOwnershipTransfers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              copyrightOwnershipTransfers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return copyrightOwnershipTransfers;
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
              copyrightOwnershipTransfers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return copyrightOwnershipTransfers;
          }

          // Sixth, check if it's pure JsonObject
          copyrightOwnershipTransfers.clear();
          copyrightOwnershipTransfers.add(loadJSON(json, context, header));
          return copyrightOwnershipTransfers;
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


  public String getFieldId() {
    return mId;
  }

  public Profile getFieldReceivingRightsHolder() {
    if (mReceivingRightsHolder != null) {
      mReceivingRightsHolder.context = getContext();
    }
    return mReceivingRightsHolder;
  }

  public Profile getFieldSendingRightsHolder() {
    if (mSendingRightsHolder != null) {
      mSendingRightsHolder.context = getContext();
    }
    return mSendingRightsHolder;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public List<String> getFieldTransferTerritories() {
    return mTransferTerritories;
  }

  public String getFieldTransferTime() {
    return mTransferTime;
  }



  public static class APIRequestGet extends APIRequest<CopyrightOwnershipTransfer> {

    CopyrightOwnershipTransfer lastResponse = null;
    @Override
    public CopyrightOwnershipTransfer getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "receiving_rights_holder",
      "sending_rights_holder",
      "status",
      "transfer_territories",
      "transfer_time",
    };

    @Override
    public CopyrightOwnershipTransfer parseResponse(String response, String header) throws APIException {
      return CopyrightOwnershipTransfer.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CopyrightOwnershipTransfer execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CopyrightOwnershipTransfer execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CopyrightOwnershipTransfer> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CopyrightOwnershipTransfer> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CopyrightOwnershipTransfer>() {
           public CopyrightOwnershipTransfer apply(ResponseWrapper result) {
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestReceivingRightsHolderField () {
      return this.requestReceivingRightsHolderField(true);
    }
    public APIRequestGet requestReceivingRightsHolderField (boolean value) {
      this.requestField("receiving_rights_holder", value);
      return this;
    }
    public APIRequestGet requestSendingRightsHolderField () {
      return this.requestSendingRightsHolderField(true);
    }
    public APIRequestGet requestSendingRightsHolderField (boolean value) {
      this.requestField("sending_rights_holder", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTransferTerritoriesField () {
      return this.requestTransferTerritoriesField(true);
    }
    public APIRequestGet requestTransferTerritoriesField (boolean value) {
      this.requestField("transfer_territories", value);
      return this;
    }
    public APIRequestGet requestTransferTimeField () {
      return this.requestTransferTimeField(true);
    }
    public APIRequestGet requestTransferTimeField (boolean value) {
      this.requestField("transfer_time", value);
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

  public CopyrightOwnershipTransfer copyFrom(CopyrightOwnershipTransfer instance) {
    this.mId = instance.mId;
    this.mReceivingRightsHolder = instance.mReceivingRightsHolder;
    this.mSendingRightsHolder = instance.mSendingRightsHolder;
    this.mStatus = instance.mStatus;
    this.mTransferTerritories = instance.mTransferTerritories;
    this.mTransferTime = instance.mTransferTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CopyrightOwnershipTransfer> getParser() {
    return new APIRequest.ResponseParser<CopyrightOwnershipTransfer>() {
      public APINodeList<CopyrightOwnershipTransfer> parseResponse(String response, APIContext context, APIRequest<CopyrightOwnershipTransfer> request, String header) throws MalformedResponseException {
        return CopyrightOwnershipTransfer.parseResponse(response, context, request, header);
      }
    };
  }
}
