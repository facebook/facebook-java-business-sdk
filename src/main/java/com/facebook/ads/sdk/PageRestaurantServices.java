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
public class PageRestaurantServices extends APINode {
  @SerializedName("catering")
  private Boolean mCatering = null;
  @SerializedName("delivery")
  private Boolean mDelivery = null;
  @SerializedName("groups")
  private Boolean mGroups = null;
  @SerializedName("kids")
  private Boolean mKids = null;
  @SerializedName("outdoor")
  private Boolean mOutdoor = null;
  @SerializedName("pickup")
  private Boolean mPickup = null;
  @SerializedName("reserve")
  private Boolean mReserve = null;
  @SerializedName("takeout")
  private Boolean mTakeout = null;
  @SerializedName("waiter")
  private Boolean mWaiter = null;
  @SerializedName("walkins")
  private Boolean mWalkins = null;
  protected static Gson gson = null;

  public PageRestaurantServices() {
  }

  public String getId() {
    return null;
  }
  public static PageRestaurantServices loadJSON(String json, APIContext context, String header) {
    PageRestaurantServices pageRestaurantServices = getGson().fromJson(json, PageRestaurantServices.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageRestaurantServices.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    pageRestaurantServices.context = context;
    pageRestaurantServices.rawValue = json;
    pageRestaurantServices.header = header;
    return pageRestaurantServices;
  }

  public static APINodeList<PageRestaurantServices> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PageRestaurantServices> pageRestaurantServicess = new APINodeList<PageRestaurantServices>(request, json, header);
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
          pageRestaurantServicess.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return pageRestaurantServicess;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageRestaurantServicess.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageRestaurantServicess.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageRestaurantServicess.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageRestaurantServicess.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  pageRestaurantServicess.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageRestaurantServicess.add(loadJSON(obj.toString(), context, header));
            }
          }
          return pageRestaurantServicess;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageRestaurantServicess.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return pageRestaurantServicess;
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
              pageRestaurantServicess.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageRestaurantServicess;
          }

          // Sixth, check if it's pure JsonObject
          pageRestaurantServicess.clear();
          pageRestaurantServicess.add(loadJSON(json, context, header));
          return pageRestaurantServicess;
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


  public Boolean getFieldCatering() {
    return mCatering;
  }

  public PageRestaurantServices setFieldCatering(Boolean value) {
    this.mCatering = value;
    return this;
  }

  public Boolean getFieldDelivery() {
    return mDelivery;
  }

  public PageRestaurantServices setFieldDelivery(Boolean value) {
    this.mDelivery = value;
    return this;
  }

  public Boolean getFieldGroups() {
    return mGroups;
  }

  public PageRestaurantServices setFieldGroups(Boolean value) {
    this.mGroups = value;
    return this;
  }

  public Boolean getFieldKids() {
    return mKids;
  }

  public PageRestaurantServices setFieldKids(Boolean value) {
    this.mKids = value;
    return this;
  }

  public Boolean getFieldOutdoor() {
    return mOutdoor;
  }

  public PageRestaurantServices setFieldOutdoor(Boolean value) {
    this.mOutdoor = value;
    return this;
  }

  public Boolean getFieldPickup() {
    return mPickup;
  }

  public PageRestaurantServices setFieldPickup(Boolean value) {
    this.mPickup = value;
    return this;
  }

  public Boolean getFieldReserve() {
    return mReserve;
  }

  public PageRestaurantServices setFieldReserve(Boolean value) {
    this.mReserve = value;
    return this;
  }

  public Boolean getFieldTakeout() {
    return mTakeout;
  }

  public PageRestaurantServices setFieldTakeout(Boolean value) {
    this.mTakeout = value;
    return this;
  }

  public Boolean getFieldWaiter() {
    return mWaiter;
  }

  public PageRestaurantServices setFieldWaiter(Boolean value) {
    this.mWaiter = value;
    return this;
  }

  public Boolean getFieldWalkins() {
    return mWalkins;
  }

  public PageRestaurantServices setFieldWalkins(Boolean value) {
    this.mWalkins = value;
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

  public PageRestaurantServices copyFrom(PageRestaurantServices instance) {
    this.mCatering = instance.mCatering;
    this.mDelivery = instance.mDelivery;
    this.mGroups = instance.mGroups;
    this.mKids = instance.mKids;
    this.mOutdoor = instance.mOutdoor;
    this.mPickup = instance.mPickup;
    this.mReserve = instance.mReserve;
    this.mTakeout = instance.mTakeout;
    this.mWaiter = instance.mWaiter;
    this.mWalkins = instance.mWalkins;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageRestaurantServices> getParser() {
    return new APIRequest.ResponseParser<PageRestaurantServices>() {
      public APINodeList<PageRestaurantServices> parseResponse(String response, APIContext context, APIRequest<PageRestaurantServices> request, String header) throws MalformedResponseException {
        return PageRestaurantServices.parseResponse(response, context, request, header);
      }
    };
  }
}
