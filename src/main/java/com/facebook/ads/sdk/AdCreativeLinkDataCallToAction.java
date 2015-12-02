/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class AdCreativeLinkDataCallToAction extends APINode {
  @SerializedName("type")
  private EnumType mType = null;
  @SerializedName("value")
  private Object mValue = null;
  protected static Gson gson = null;

  public AdCreativeLinkDataCallToAction() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeLinkDataCallToAction loadJSON(String json, APIContext context) {
    AdCreativeLinkDataCallToAction adCreativeLinkDataCallToAction = getGson().fromJson(json, AdCreativeLinkDataCallToAction.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataCallToAction.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeLinkDataCallToAction.mContext = context;
    adCreativeLinkDataCallToAction.rawValue = json;
    return adCreativeLinkDataCallToAction;
  }

  public static APINodeList<AdCreativeLinkDataCallToAction> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdCreativeLinkDataCallToAction> adCreativeLinkDataCallToActions = new APINodeList<AdCreativeLinkDataCallToAction>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adCreativeLinkDataCallToActions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeLinkDataCallToActions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adCreativeLinkDataCallToActions.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataCallToActions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adCreativeLinkDataCallToActions.add(loadJSON(obj.toString(), context));
          }
          return adCreativeLinkDataCallToActions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataCallToActions.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativeLinkDataCallToActions;
        } else {
          // Fifth, check if it's pure JsonObject
          adCreativeLinkDataCallToActions.add(loadJSON(json, context));
          return adCreativeLinkDataCallToActions;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
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

  public Object getFieldValue() {
    return mValue;
  }

  public AdCreativeLinkDataCallToAction setFieldValue(Object value) {
    this.mValue = value;
    return this;
  }



  public static enum EnumType {
    @SerializedName("OPEN_LINK")
    VALUE_OPEN_LINK("OPEN_LINK"),
    @SerializedName("LIKE_PAGE")
    VALUE_LIKE_PAGE("LIKE_PAGE"),
    @SerializedName("SHOP_NOW")
    VALUE_SHOP_NOW("SHOP_NOW"),
    @SerializedName("PLAY_GAME")
    VALUE_PLAY_GAME("PLAY_GAME"),
    @SerializedName("INSTALL_APP")
    VALUE_INSTALL_APP("INSTALL_APP"),
    @SerializedName("USE_APP")
    VALUE_USE_APP("USE_APP"),
    @SerializedName("INSTALL_MOBILE_APP")
    VALUE_INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
    @SerializedName("USE_MOBILE_APP")
    VALUE_USE_MOBILE_APP("USE_MOBILE_APP"),
    @SerializedName("BOOK_TRAVEL")
    VALUE_BOOK_TRAVEL("BOOK_TRAVEL"),
    @SerializedName("LISTEN_MUSIC")
    VALUE_LISTEN_MUSIC("LISTEN_MUSIC"),
    @SerializedName("WATCH_VIDEO")
    VALUE_WATCH_VIDEO("WATCH_VIDEO"),
    @SerializedName("LEARN_MORE")
    VALUE_LEARN_MORE("LEARN_MORE"),
    @SerializedName("SIGN_UP")
    VALUE_SIGN_UP("SIGN_UP"),
    @SerializedName("DOWNLOAD")
    VALUE_DOWNLOAD("DOWNLOAD"),
    @SerializedName("WATCH_MORE")
    VALUE_WATCH_MORE("WATCH_MORE"),
    @SerializedName("NO_BUTTON")
    VALUE_NO_BUTTON("NO_BUTTON"),
    @SerializedName("CALL_NOW")
    VALUE_CALL_NOW("CALL_NOW"),
    @SerializedName("BUY_NOW")
    VALUE_BUY_NOW("BUY_NOW"),
    @SerializedName("GET_OFFER")
    VALUE_GET_OFFER("GET_OFFER"),
    @SerializedName("GET_DIRECTIONS")
    VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
    @SerializedName("MESSAGE_PAGE")
    VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
    @SerializedName("SUBSCRIBE")
    VALUE_SUBSCRIBE("SUBSCRIBE"),
    @SerializedName("DONATE_NOW")
    VALUE_DONATE_NOW("DONATE_NOW"),
    @SerializedName("GET_QUOTE")
    VALUE_GET_QUOTE("GET_QUOTE"),
    @SerializedName("CONTACT_US")
    VALUE_CONTACT_US("CONTACT_US"),
    @SerializedName("RECORD_NOW")
    VALUE_RECORD_NOW("RECORD_NOW"),
    @SerializedName("OPEN_MOVIES")
    VALUE_OPEN_MOVIES("OPEN_MOVIES"),
    NULL(null);

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
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}