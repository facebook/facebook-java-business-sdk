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
public class ALMEvent extends APINode {
  @SerializedName("ad_account_ids")
  private List<String> mAdAccountIds = null;
  @SerializedName("campaign_ids")
  private List<String> mCampaignIds = null;
  @SerializedName("channel")
  private String mChannel = null;
  @SerializedName("event")
  private String mEvent = null;
  @SerializedName("event_time")
  private String mEventTime = null;
  @SerializedName("guidance")
  private String mGuidance = null;
  @SerializedName("guidance_detail")
  private String mGuidanceDetail = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("parent_advertiser_ids")
  private List<String> mParentAdvertiserIds = null;
  @SerializedName("reseller_business_id")
  private String mResellerBusinessId = null;
  @SerializedName("sub_channel")
  private String mSubChannel = null;
  @SerializedName("user_id")
  private String mUserId = null;
  protected static Gson gson = null;

  ALMEvent() {
  }

  public ALMEvent(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ALMEvent(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ALMEvent fetch() throws APIException{
    ALMEvent newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ALMEvent fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ALMEvent> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ALMEvent fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ALMEvent> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ALMEvent> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ALMEvent>)(
      new APIRequest<ALMEvent>(context, "", "/", "GET", ALMEvent.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ALMEvent>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ALMEvent.getParser())
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
  public static ALMEvent loadJSON(String json, APIContext context, String header) {
    ALMEvent almEvent = getGson().fromJson(json, ALMEvent.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(almEvent.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    almEvent.context = context;
    almEvent.rawValue = json;
    almEvent.header = header;
    return almEvent;
  }

  public static APINodeList<ALMEvent> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ALMEvent> almEvents = new APINodeList<ALMEvent>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          almEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return almEvents;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                almEvents.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            almEvents.setPaging(previous, next);
            if (context.hasAppSecret()) {
              almEvents.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              almEvents.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  almEvents.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              almEvents.add(loadJSON(obj.toString(), context, header));
            }
          }
          return almEvents;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              almEvents.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return almEvents;
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
              almEvents.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return almEvents;
          }

          // Sixth, check if it's pure JsonObject
          almEvents.clear();
          almEvents.add(loadJSON(json, context, header));
          return almEvents;
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


  public List<String> getFieldAdAccountIds() {
    return mAdAccountIds;
  }

  public List<String> getFieldCampaignIds() {
    return mCampaignIds;
  }

  public String getFieldChannel() {
    return mChannel;
  }

  public String getFieldEvent() {
    return mEvent;
  }

  public String getFieldEventTime() {
    return mEventTime;
  }

  public String getFieldGuidance() {
    return mGuidance;
  }

  public String getFieldGuidanceDetail() {
    return mGuidanceDetail;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldParentAdvertiserIds() {
    return mParentAdvertiserIds;
  }

  public String getFieldResellerBusinessId() {
    return mResellerBusinessId;
  }

  public String getFieldSubChannel() {
    return mSubChannel;
  }

  public String getFieldUserId() {
    return mUserId;
  }



  public static class APIRequestGet extends APIRequest<ALMEvent> {

    ALMEvent lastResponse = null;
    @Override
    public ALMEvent getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_ids",
      "campaign_ids",
      "channel",
      "event",
      "event_time",
      "guidance",
      "guidance_detail",
      "id",
      "parent_advertiser_ids",
      "reseller_business_id",
      "sub_channel",
      "user_id",
    };

    @Override
    public ALMEvent parseResponse(String response, String header) throws APIException {
      return ALMEvent.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ALMEvent execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ALMEvent execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ALMEvent> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ALMEvent> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ALMEvent>() {
           public ALMEvent apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdAccountIdsField () {
      return this.requestAdAccountIdsField(true);
    }
    public APIRequestGet requestAdAccountIdsField (boolean value) {
      this.requestField("ad_account_ids", value);
      return this;
    }
    public APIRequestGet requestCampaignIdsField () {
      return this.requestCampaignIdsField(true);
    }
    public APIRequestGet requestCampaignIdsField (boolean value) {
      this.requestField("campaign_ids", value);
      return this;
    }
    public APIRequestGet requestChannelField () {
      return this.requestChannelField(true);
    }
    public APIRequestGet requestChannelField (boolean value) {
      this.requestField("channel", value);
      return this;
    }
    public APIRequestGet requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGet requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGet requestEventTimeField () {
      return this.requestEventTimeField(true);
    }
    public APIRequestGet requestEventTimeField (boolean value) {
      this.requestField("event_time", value);
      return this;
    }
    public APIRequestGet requestGuidanceField () {
      return this.requestGuidanceField(true);
    }
    public APIRequestGet requestGuidanceField (boolean value) {
      this.requestField("guidance", value);
      return this;
    }
    public APIRequestGet requestGuidanceDetailField () {
      return this.requestGuidanceDetailField(true);
    }
    public APIRequestGet requestGuidanceDetailField (boolean value) {
      this.requestField("guidance_detail", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestParentAdvertiserIdsField () {
      return this.requestParentAdvertiserIdsField(true);
    }
    public APIRequestGet requestParentAdvertiserIdsField (boolean value) {
      this.requestField("parent_advertiser_ids", value);
      return this;
    }
    public APIRequestGet requestResellerBusinessIdField () {
      return this.requestResellerBusinessIdField(true);
    }
    public APIRequestGet requestResellerBusinessIdField (boolean value) {
      this.requestField("reseller_business_id", value);
      return this;
    }
    public APIRequestGet requestSubChannelField () {
      return this.requestSubChannelField(true);
    }
    public APIRequestGet requestSubChannelField (boolean value) {
      this.requestField("sub_channel", value);
      return this;
    }
    public APIRequestGet requestUserIdField () {
      return this.requestUserIdField(true);
    }
    public APIRequestGet requestUserIdField (boolean value) {
      this.requestField("user_id", value);
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

  public ALMEvent copyFrom(ALMEvent instance) {
    this.mAdAccountIds = instance.mAdAccountIds;
    this.mCampaignIds = instance.mCampaignIds;
    this.mChannel = instance.mChannel;
    this.mEvent = instance.mEvent;
    this.mEventTime = instance.mEventTime;
    this.mGuidance = instance.mGuidance;
    this.mGuidanceDetail = instance.mGuidanceDetail;
    this.mId = instance.mId;
    this.mParentAdvertiserIds = instance.mParentAdvertiserIds;
    this.mResellerBusinessId = instance.mResellerBusinessId;
    this.mSubChannel = instance.mSubChannel;
    this.mUserId = instance.mUserId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ALMEvent> getParser() {
    return new APIRequest.ResponseParser<ALMEvent>() {
      public APINodeList<ALMEvent> parseResponse(String response, APIContext context, APIRequest<ALMEvent> request, String header) throws MalformedResponseException {
        return ALMEvent.parseResponse(response, context, request, header);
      }
    };
  }
}
