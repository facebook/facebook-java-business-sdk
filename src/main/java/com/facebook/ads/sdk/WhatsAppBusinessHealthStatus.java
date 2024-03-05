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
public class WhatsAppBusinessHealthStatus extends APINode {
  @SerializedName("additional_info")
  private List<String> mAdditionalInfo = null;
  @SerializedName("can_send_message")
  private String mCanSendMessage = null;
  @SerializedName("entity_type")
  private String mEntityType = null;
  @SerializedName("errors")
  private List<Object> mErrors = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public WhatsAppBusinessHealthStatus() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static WhatsAppBusinessHealthStatus loadJSON(String json, APIContext context, String header) {
    WhatsAppBusinessHealthStatus whatsAppBusinessHealthStatus = getGson().fromJson(json, WhatsAppBusinessHealthStatus.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(whatsAppBusinessHealthStatus.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    whatsAppBusinessHealthStatus.context = context;
    whatsAppBusinessHealthStatus.rawValue = json;
    whatsAppBusinessHealthStatus.header = header;
    return whatsAppBusinessHealthStatus;
  }

  public static APINodeList<WhatsAppBusinessHealthStatus> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<WhatsAppBusinessHealthStatus> whatsAppBusinessHealthStatuss = new APINodeList<WhatsAppBusinessHealthStatus>(request, json, header);
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
          whatsAppBusinessHealthStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return whatsAppBusinessHealthStatuss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                whatsAppBusinessHealthStatuss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            whatsAppBusinessHealthStatuss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              whatsAppBusinessHealthStatuss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              whatsAppBusinessHealthStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  whatsAppBusinessHealthStatuss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              whatsAppBusinessHealthStatuss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return whatsAppBusinessHealthStatuss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              whatsAppBusinessHealthStatuss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return whatsAppBusinessHealthStatuss;
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
              whatsAppBusinessHealthStatuss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return whatsAppBusinessHealthStatuss;
          }

          // Sixth, check if it's pure JsonObject
          whatsAppBusinessHealthStatuss.clear();
          whatsAppBusinessHealthStatuss.add(loadJSON(json, context, header));
          return whatsAppBusinessHealthStatuss;
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


  public List<String> getFieldAdditionalInfo() {
    return mAdditionalInfo;
  }

  public WhatsAppBusinessHealthStatus setFieldAdditionalInfo(List<String> value) {
    this.mAdditionalInfo = value;
    return this;
  }

  public String getFieldCanSendMessage() {
    return mCanSendMessage;
  }

  public WhatsAppBusinessHealthStatus setFieldCanSendMessage(String value) {
    this.mCanSendMessage = value;
    return this;
  }

  public String getFieldEntityType() {
    return mEntityType;
  }

  public WhatsAppBusinessHealthStatus setFieldEntityType(String value) {
    this.mEntityType = value;
    return this;
  }

  public List<Object> getFieldErrors() {
    return mErrors;
  }

  public WhatsAppBusinessHealthStatus setFieldErrors(List<Object> value) {
    this.mErrors = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public WhatsAppBusinessHealthStatus setFieldId(String value) {
    this.mId = value;
    return this;
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

  public WhatsAppBusinessHealthStatus copyFrom(WhatsAppBusinessHealthStatus instance) {
    this.mAdditionalInfo = instance.mAdditionalInfo;
    this.mCanSendMessage = instance.mCanSendMessage;
    this.mEntityType = instance.mEntityType;
    this.mErrors = instance.mErrors;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<WhatsAppBusinessHealthStatus> getParser() {
    return new APIRequest.ResponseParser<WhatsAppBusinessHealthStatus>() {
      public APINodeList<WhatsAppBusinessHealthStatus> parseResponse(String response, APIContext context, APIRequest<WhatsAppBusinessHealthStatus> request, String header) throws MalformedResponseException {
        return WhatsAppBusinessHealthStatus.parseResponse(response, context, request, header);
      }
    };
  }
}
