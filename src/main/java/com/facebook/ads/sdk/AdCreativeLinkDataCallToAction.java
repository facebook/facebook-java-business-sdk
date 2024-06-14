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
public class AdCreativeLinkDataCallToAction extends APINode {
  @SerializedName("type")
  private EnumType mType = null;
  @SerializedName("value")
  private AdCreativeLinkDataCallToActionValue mValue = null;
  protected static Gson gson = null;

  public AdCreativeLinkDataCallToAction() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeLinkDataCallToAction loadJSON(String json, APIContext context, String header) {
    AdCreativeLinkDataCallToAction adCreativeLinkDataCallToAction = getGson().fromJson(json, AdCreativeLinkDataCallToAction.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataCallToAction.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeLinkDataCallToAction.context = context;
    adCreativeLinkDataCallToAction.rawValue = json;
    adCreativeLinkDataCallToAction.header = header;
    return adCreativeLinkDataCallToAction;
  }

  public static APINodeList<AdCreativeLinkDataCallToAction> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataCallToAction> adCreativeLinkDataCallToActions = new APINodeList<AdCreativeLinkDataCallToAction>(request, json, header);
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
          adCreativeLinkDataCallToActions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeLinkDataCallToActions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDataCallToActions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDataCallToActions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDataCallToActions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataCallToActions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeLinkDataCallToActions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataCallToActions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeLinkDataCallToActions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataCallToActions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeLinkDataCallToActions;
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
              adCreativeLinkDataCallToActions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDataCallToActions;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDataCallToActions.clear();
          adCreativeLinkDataCallToActions.add(loadJSON(json, context, header));
          return adCreativeLinkDataCallToActions;
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


  public EnumType getFieldType() {
    return mType;
  }

  public AdCreativeLinkDataCallToAction setFieldType(EnumType value) {
    this.mType = value;
    return this;
  }

  public AdCreativeLinkDataCallToActionValue getFieldValue() {
    return mValue;
  }

  public AdCreativeLinkDataCallToAction setFieldValue(AdCreativeLinkDataCallToActionValue value) {
    this.mValue = value;
    return this;
  }

  public AdCreativeLinkDataCallToAction setFieldValue(String value) {
    Type type = new TypeToken<AdCreativeLinkDataCallToActionValue>(){}.getType();
    this.mValue = AdCreativeLinkDataCallToActionValue.getGson().fromJson(value, type);
    return this;
  }


  public static enum EnumType {
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("APPLY_NOW")
      VALUE_APPLY_NOW("APPLY_NOW"),
      @SerializedName("ASK_ABOUT_SERVICES")
      VALUE_ASK_ABOUT_SERVICES("ASK_ABOUT_SERVICES"),
      @SerializedName("ASK_FOR_MORE_INFO")
      VALUE_ASK_FOR_MORE_INFO("ASK_FOR_MORE_INFO"),
      @SerializedName("AUDIO_CALL")
      VALUE_AUDIO_CALL("AUDIO_CALL"),
      @SerializedName("BOOK_A_CONSULTATION")
      VALUE_BOOK_A_CONSULTATION("BOOK_A_CONSULTATION"),
      @SerializedName("BOOK_NOW")
      VALUE_BOOK_NOW("BOOK_NOW"),
      @SerializedName("BOOK_TRAVEL")
      VALUE_BOOK_TRAVEL("BOOK_TRAVEL"),
      @SerializedName("BUY")
      VALUE_BUY("BUY"),
      @SerializedName("BUY_NOW")
      VALUE_BUY_NOW("BUY_NOW"),
      @SerializedName("BUY_TICKETS")
      VALUE_BUY_TICKETS("BUY_TICKETS"),
      @SerializedName("BUY_VIA_MESSAGE")
      VALUE_BUY_VIA_MESSAGE("BUY_VIA_MESSAGE"),
      @SerializedName("CALL")
      VALUE_CALL("CALL"),
      @SerializedName("CALL_ME")
      VALUE_CALL_ME("CALL_ME"),
      @SerializedName("CALL_NOW")
      VALUE_CALL_NOW("CALL_NOW"),
      @SerializedName("CHAT_WITH_US")
      VALUE_CHAT_WITH_US("CHAT_WITH_US"),
      @SerializedName("CONFIRM")
      VALUE_CONFIRM("CONFIRM"),
      @SerializedName("CONTACT")
      VALUE_CONTACT("CONTACT"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("DONATE_NOW")
      VALUE_DONATE_NOW("DONATE_NOW"),
      @SerializedName("DOWNLOAD")
      VALUE_DOWNLOAD("DOWNLOAD"),
      @SerializedName("EVENT_RSVP")
      VALUE_EVENT_RSVP("EVENT_RSVP"),
      @SerializedName("FIND_A_GROUP")
      VALUE_FIND_A_GROUP("FIND_A_GROUP"),
      @SerializedName("FIND_YOUR_GROUPS")
      VALUE_FIND_YOUR_GROUPS("FIND_YOUR_GROUPS"),
      @SerializedName("FOLLOW_NEWS_STORYLINE")
      VALUE_FOLLOW_NEWS_STORYLINE("FOLLOW_NEWS_STORYLINE"),
      @SerializedName("FOLLOW_PAGE")
      VALUE_FOLLOW_PAGE("FOLLOW_PAGE"),
      @SerializedName("FOLLOW_USER")
      VALUE_FOLLOW_USER("FOLLOW_USER"),
      @SerializedName("GET_A_QUOTE")
      VALUE_GET_A_QUOTE("GET_A_QUOTE"),
      @SerializedName("GET_DIRECTIONS")
      VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
      @SerializedName("GET_OFFER")
      VALUE_GET_OFFER("GET_OFFER"),
      @SerializedName("GET_OFFER_VIEW")
      VALUE_GET_OFFER_VIEW("GET_OFFER_VIEW"),
      @SerializedName("GET_PROMOTIONS")
      VALUE_GET_PROMOTIONS("GET_PROMOTIONS"),
      @SerializedName("GET_QUOTE")
      VALUE_GET_QUOTE("GET_QUOTE"),
      @SerializedName("GET_SHOWTIMES")
      VALUE_GET_SHOWTIMES("GET_SHOWTIMES"),
      @SerializedName("GET_STARTED")
      VALUE_GET_STARTED("GET_STARTED"),
      @SerializedName("INQUIRE_NOW")
      VALUE_INQUIRE_NOW("INQUIRE_NOW"),
      @SerializedName("INSTALL_APP")
      VALUE_INSTALL_APP("INSTALL_APP"),
      @SerializedName("INSTALL_MOBILE_APP")
      VALUE_INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
      @SerializedName("JOIN_CHANNEL")
      VALUE_JOIN_CHANNEL("JOIN_CHANNEL"),
      @SerializedName("LEARN_MORE")
      VALUE_LEARN_MORE("LEARN_MORE"),
      @SerializedName("LIKE_PAGE")
      VALUE_LIKE_PAGE("LIKE_PAGE"),
      @SerializedName("LISTEN_MUSIC")
      VALUE_LISTEN_MUSIC("LISTEN_MUSIC"),
      @SerializedName("LISTEN_NOW")
      VALUE_LISTEN_NOW("LISTEN_NOW"),
      @SerializedName("MAKE_AN_APPOINTMENT")
      VALUE_MAKE_AN_APPOINTMENT("MAKE_AN_APPOINTMENT"),
      @SerializedName("MESSAGE_PAGE")
      VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
      @SerializedName("MOBILE_DOWNLOAD")
      VALUE_MOBILE_DOWNLOAD("MOBILE_DOWNLOAD"),
      @SerializedName("NO_BUTTON")
      VALUE_NO_BUTTON("NO_BUTTON"),
      @SerializedName("OPEN_INSTANT_APP")
      VALUE_OPEN_INSTANT_APP("OPEN_INSTANT_APP"),
      @SerializedName("OPEN_LINK")
      VALUE_OPEN_LINK("OPEN_LINK"),
      @SerializedName("ORDER_NOW")
      VALUE_ORDER_NOW("ORDER_NOW"),
      @SerializedName("PAY_TO_ACCESS")
      VALUE_PAY_TO_ACCESS("PAY_TO_ACCESS"),
      @SerializedName("PLAY_GAME")
      VALUE_PLAY_GAME("PLAY_GAME"),
      @SerializedName("PLAY_GAME_ON_FACEBOOK")
      VALUE_PLAY_GAME_ON_FACEBOOK("PLAY_GAME_ON_FACEBOOK"),
      @SerializedName("PURCHASE_GIFT_CARDS")
      VALUE_PURCHASE_GIFT_CARDS("PURCHASE_GIFT_CARDS"),
      @SerializedName("RAISE_MONEY")
      VALUE_RAISE_MONEY("RAISE_MONEY"),
      @SerializedName("RECORD_NOW")
      VALUE_RECORD_NOW("RECORD_NOW"),
      @SerializedName("REFER_FRIENDS")
      VALUE_REFER_FRIENDS("REFER_FRIENDS"),
      @SerializedName("REQUEST_TIME")
      VALUE_REQUEST_TIME("REQUEST_TIME"),
      @SerializedName("SAY_THANKS")
      VALUE_SAY_THANKS("SAY_THANKS"),
      @SerializedName("SEE_MORE")
      VALUE_SEE_MORE("SEE_MORE"),
      @SerializedName("SELL_NOW")
      VALUE_SELL_NOW("SELL_NOW"),
      @SerializedName("SEND_A_GIFT")
      VALUE_SEND_A_GIFT("SEND_A_GIFT"),
      @SerializedName("SEND_GIFT_MONEY")
      VALUE_SEND_GIFT_MONEY("SEND_GIFT_MONEY"),
      @SerializedName("SEND_UPDATES")
      VALUE_SEND_UPDATES("SEND_UPDATES"),
      @SerializedName("SHARE")
      VALUE_SHARE("SHARE"),
      @SerializedName("SHOP_NOW")
      VALUE_SHOP_NOW("SHOP_NOW"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("SOTTO_SUBSCRIBE")
      VALUE_SOTTO_SUBSCRIBE("SOTTO_SUBSCRIBE"),
      @SerializedName("START_ORDER")
      VALUE_START_ORDER("START_ORDER"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("SWIPE_UP_PRODUCT")
      VALUE_SWIPE_UP_PRODUCT("SWIPE_UP_PRODUCT"),
      @SerializedName("SWIPE_UP_SHOP")
      VALUE_SWIPE_UP_SHOP("SWIPE_UP_SHOP"),
      @SerializedName("UPDATE_APP")
      VALUE_UPDATE_APP("UPDATE_APP"),
      @SerializedName("USE_APP")
      VALUE_USE_APP("USE_APP"),
      @SerializedName("USE_MOBILE_APP")
      VALUE_USE_MOBILE_APP("USE_MOBILE_APP"),
      @SerializedName("VIDEO_ANNOTATION")
      VALUE_VIDEO_ANNOTATION("VIDEO_ANNOTATION"),
      @SerializedName("VIDEO_CALL")
      VALUE_VIDEO_CALL("VIDEO_CALL"),
      @SerializedName("VIEW_PRODUCT")
      VALUE_VIEW_PRODUCT("VIEW_PRODUCT"),
      @SerializedName("VISIT_PAGES_FEED")
      VALUE_VISIT_PAGES_FEED("VISIT_PAGES_FEED"),
      @SerializedName("WATCH_MORE")
      VALUE_WATCH_MORE("WATCH_MORE"),
      @SerializedName("WATCH_VIDEO")
      VALUE_WATCH_VIDEO("WATCH_VIDEO"),
      @SerializedName("WHATSAPP_MESSAGE")
      VALUE_WHATSAPP_MESSAGE("WHATSAPP_MESSAGE"),
      @SerializedName("WOODHENGE_SUPPORT")
      VALUE_WOODHENGE_SUPPORT("WOODHENGE_SUPPORT"),
      ;

      private String value;

      private EnumType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
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

  public AdCreativeLinkDataCallToAction copyFrom(AdCreativeLinkDataCallToAction instance) {
    this.mType = instance.mType;
    this.mValue = instance.mValue;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataCallToAction> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataCallToAction>() {
      public APINodeList<AdCreativeLinkDataCallToAction> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataCallToAction> request, String header) throws MalformedResponseException {
        return AdCreativeLinkDataCallToAction.parseResponse(response, context, request, header);
      }
    };
  }
}
