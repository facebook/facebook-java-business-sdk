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
public class ChatPlugin extends APINode {
  @SerializedName("alignment")
  private String mAlignment = null;
  @SerializedName("desktop_bottom_spacing")
  private String mDesktopBottomSpacing = null;
  @SerializedName("desktop_side_spacing")
  private String mDesktopSideSpacing = null;
  @SerializedName("entry_point_icon")
  private String mEntryPointIcon = null;
  @SerializedName("entry_point_label")
  private String mEntryPointLabel = null;
  @SerializedName("greeting_dialog_display")
  private String mGreetingDialogDisplay = null;
  @SerializedName("guest_chat_mode")
  private String mGuestChatMode = null;
  @SerializedName("mobile_bottom_spacing")
  private String mMobileBottomSpacing = null;
  @SerializedName("mobile_chat_display")
  private String mMobileChatDisplay = null;
  @SerializedName("mobile_side_spacing")
  private String mMobileSideSpacing = null;
  @SerializedName("theme_color")
  private String mThemeColor = null;
  @SerializedName("welcome_screen_greeting")
  private String mWelcomeScreenGreeting = null;
  protected static Gson gson = null;

  public ChatPlugin() {
  }

  public String getId() {
    return null;
  }
  public static ChatPlugin loadJSON(String json, APIContext context, String header) {
    ChatPlugin chatPlugin = getGson().fromJson(json, ChatPlugin.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(chatPlugin.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    chatPlugin.context = context;
    chatPlugin.rawValue = json;
    chatPlugin.header = header;
    return chatPlugin;
  }

  public static APINodeList<ChatPlugin> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ChatPlugin> chatPlugins = new APINodeList<ChatPlugin>(request, json, header);
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
          chatPlugins.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return chatPlugins;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                chatPlugins.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            chatPlugins.setPaging(previous, next);
            if (context.hasAppSecret()) {
              chatPlugins.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              chatPlugins.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  chatPlugins.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              chatPlugins.add(loadJSON(obj.toString(), context, header));
            }
          }
          return chatPlugins;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              chatPlugins.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return chatPlugins;
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
              chatPlugins.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return chatPlugins;
          }

          // Sixth, check if it's pure JsonObject
          chatPlugins.clear();
          chatPlugins.add(loadJSON(json, context, header));
          return chatPlugins;
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


  public String getFieldAlignment() {
    return mAlignment;
  }

  public ChatPlugin setFieldAlignment(String value) {
    this.mAlignment = value;
    return this;
  }

  public String getFieldDesktopBottomSpacing() {
    return mDesktopBottomSpacing;
  }

  public ChatPlugin setFieldDesktopBottomSpacing(String value) {
    this.mDesktopBottomSpacing = value;
    return this;
  }

  public String getFieldDesktopSideSpacing() {
    return mDesktopSideSpacing;
  }

  public ChatPlugin setFieldDesktopSideSpacing(String value) {
    this.mDesktopSideSpacing = value;
    return this;
  }

  public String getFieldEntryPointIcon() {
    return mEntryPointIcon;
  }

  public ChatPlugin setFieldEntryPointIcon(String value) {
    this.mEntryPointIcon = value;
    return this;
  }

  public String getFieldEntryPointLabel() {
    return mEntryPointLabel;
  }

  public ChatPlugin setFieldEntryPointLabel(String value) {
    this.mEntryPointLabel = value;
    return this;
  }

  public String getFieldGreetingDialogDisplay() {
    return mGreetingDialogDisplay;
  }

  public ChatPlugin setFieldGreetingDialogDisplay(String value) {
    this.mGreetingDialogDisplay = value;
    return this;
  }

  public String getFieldGuestChatMode() {
    return mGuestChatMode;
  }

  public ChatPlugin setFieldGuestChatMode(String value) {
    this.mGuestChatMode = value;
    return this;
  }

  public String getFieldMobileBottomSpacing() {
    return mMobileBottomSpacing;
  }

  public ChatPlugin setFieldMobileBottomSpacing(String value) {
    this.mMobileBottomSpacing = value;
    return this;
  }

  public String getFieldMobileChatDisplay() {
    return mMobileChatDisplay;
  }

  public ChatPlugin setFieldMobileChatDisplay(String value) {
    this.mMobileChatDisplay = value;
    return this;
  }

  public String getFieldMobileSideSpacing() {
    return mMobileSideSpacing;
  }

  public ChatPlugin setFieldMobileSideSpacing(String value) {
    this.mMobileSideSpacing = value;
    return this;
  }

  public String getFieldThemeColor() {
    return mThemeColor;
  }

  public ChatPlugin setFieldThemeColor(String value) {
    this.mThemeColor = value;
    return this;
  }

  public String getFieldWelcomeScreenGreeting() {
    return mWelcomeScreenGreeting;
  }

  public ChatPlugin setFieldWelcomeScreenGreeting(String value) {
    this.mWelcomeScreenGreeting = value;
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

  public ChatPlugin copyFrom(ChatPlugin instance) {
    this.mAlignment = instance.mAlignment;
    this.mDesktopBottomSpacing = instance.mDesktopBottomSpacing;
    this.mDesktopSideSpacing = instance.mDesktopSideSpacing;
    this.mEntryPointIcon = instance.mEntryPointIcon;
    this.mEntryPointLabel = instance.mEntryPointLabel;
    this.mGreetingDialogDisplay = instance.mGreetingDialogDisplay;
    this.mGuestChatMode = instance.mGuestChatMode;
    this.mMobileBottomSpacing = instance.mMobileBottomSpacing;
    this.mMobileChatDisplay = instance.mMobileChatDisplay;
    this.mMobileSideSpacing = instance.mMobileSideSpacing;
    this.mThemeColor = instance.mThemeColor;
    this.mWelcomeScreenGreeting = instance.mWelcomeScreenGreeting;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ChatPlugin> getParser() {
    return new APIRequest.ResponseParser<ChatPlugin>() {
      public APINodeList<ChatPlugin> parseResponse(String response, APIContext context, APIRequest<ChatPlugin> request, String header) throws MalformedResponseException {
        return ChatPlugin.parseResponse(response, context, request, header);
      }
    };
  }
}
