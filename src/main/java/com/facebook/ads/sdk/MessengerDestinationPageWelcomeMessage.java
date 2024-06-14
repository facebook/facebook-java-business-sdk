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
public class MessengerDestinationPageWelcomeMessage extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("page_welcome_message_body")
  private String mPageWelcomeMessageBody = null;
  @SerializedName("page_welcome_message_type")
  private String mPageWelcomeMessageType = null;
  @SerializedName("template_name")
  private String mTemplateName = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_last_used")
  private String mTimeLastUsed = null;
  protected static Gson gson = null;

  public MessengerDestinationPageWelcomeMessage() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static MessengerDestinationPageWelcomeMessage loadJSON(String json, APIContext context, String header) {
    MessengerDestinationPageWelcomeMessage messengerDestinationPageWelcomeMessage = getGson().fromJson(json, MessengerDestinationPageWelcomeMessage.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(messengerDestinationPageWelcomeMessage.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    messengerDestinationPageWelcomeMessage.context = context;
    messengerDestinationPageWelcomeMessage.rawValue = json;
    messengerDestinationPageWelcomeMessage.header = header;
    return messengerDestinationPageWelcomeMessage;
  }

  public static APINodeList<MessengerDestinationPageWelcomeMessage> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MessengerDestinationPageWelcomeMessage> messengerDestinationPageWelcomeMessages = new APINodeList<MessengerDestinationPageWelcomeMessage>(request, json, header);
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
          messengerDestinationPageWelcomeMessages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return messengerDestinationPageWelcomeMessages;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                messengerDestinationPageWelcomeMessages.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            messengerDestinationPageWelcomeMessages.setPaging(previous, next);
            if (context.hasAppSecret()) {
              messengerDestinationPageWelcomeMessages.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              messengerDestinationPageWelcomeMessages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  messengerDestinationPageWelcomeMessages.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              messengerDestinationPageWelcomeMessages.add(loadJSON(obj.toString(), context, header));
            }
          }
          return messengerDestinationPageWelcomeMessages;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              messengerDestinationPageWelcomeMessages.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return messengerDestinationPageWelcomeMessages;
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
              messengerDestinationPageWelcomeMessages.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return messengerDestinationPageWelcomeMessages;
          }

          // Sixth, check if it's pure JsonObject
          messengerDestinationPageWelcomeMessages.clear();
          messengerDestinationPageWelcomeMessages.add(loadJSON(json, context, header));
          return messengerDestinationPageWelcomeMessages;
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


  public String getFieldId() {
    return mId;
  }

  public MessengerDestinationPageWelcomeMessage setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldPageWelcomeMessageBody() {
    return mPageWelcomeMessageBody;
  }

  public MessengerDestinationPageWelcomeMessage setFieldPageWelcomeMessageBody(String value) {
    this.mPageWelcomeMessageBody = value;
    return this;
  }

  public String getFieldPageWelcomeMessageType() {
    return mPageWelcomeMessageType;
  }

  public MessengerDestinationPageWelcomeMessage setFieldPageWelcomeMessageType(String value) {
    this.mPageWelcomeMessageType = value;
    return this;
  }

  public String getFieldTemplateName() {
    return mTemplateName;
  }

  public MessengerDestinationPageWelcomeMessage setFieldTemplateName(String value) {
    this.mTemplateName = value;
    return this;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public MessengerDestinationPageWelcomeMessage setFieldTimeCreated(String value) {
    this.mTimeCreated = value;
    return this;
  }

  public String getFieldTimeLastUsed() {
    return mTimeLastUsed;
  }

  public MessengerDestinationPageWelcomeMessage setFieldTimeLastUsed(String value) {
    this.mTimeLastUsed = value;
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

  public MessengerDestinationPageWelcomeMessage copyFrom(MessengerDestinationPageWelcomeMessage instance) {
    this.mId = instance.mId;
    this.mPageWelcomeMessageBody = instance.mPageWelcomeMessageBody;
    this.mPageWelcomeMessageType = instance.mPageWelcomeMessageType;
    this.mTemplateName = instance.mTemplateName;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeLastUsed = instance.mTimeLastUsed;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MessengerDestinationPageWelcomeMessage> getParser() {
    return new APIRequest.ResponseParser<MessengerDestinationPageWelcomeMessage>() {
      public APINodeList<MessengerDestinationPageWelcomeMessage> parseResponse(String response, APIContext context, APIRequest<MessengerDestinationPageWelcomeMessage> request, String header) throws MalformedResponseException {
        return MessengerDestinationPageWelcomeMessage.parseResponse(response, context, request, header);
      }
    };
  }
}
