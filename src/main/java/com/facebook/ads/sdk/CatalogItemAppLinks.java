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
public class CatalogItemAppLinks extends APINode {
  @SerializedName("android")
  private List<AndroidAppLink> mAndroid = null;
  @SerializedName("ios")
  private List<IosAppLink> mIos = null;
  @SerializedName("ipad")
  private List<IosAppLink> mIpad = null;
  @SerializedName("iphone")
  private List<IosAppLink> mIphone = null;
  @SerializedName("web")
  private WebAppLink mWeb = null;
  @SerializedName("windows")
  private List<WindowsAppLink> mWindows = null;
  @SerializedName("windows_phone")
  private List<WindowsPhoneAppLink> mWindowsPhone = null;
  @SerializedName("windows_universal")
  private List<WindowsAppLink> mWindowsUniversal = null;
  protected static Gson gson = null;

  public CatalogItemAppLinks() {
  }

  public String getId() {
    return null;
  }
  public static CatalogItemAppLinks loadJSON(String json, APIContext context, String header) {
    CatalogItemAppLinks catalogItemAppLinks = getGson().fromJson(json, CatalogItemAppLinks.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(catalogItemAppLinks.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    catalogItemAppLinks.context = context;
    catalogItemAppLinks.rawValue = json;
    catalogItemAppLinks.header = header;
    return catalogItemAppLinks;
  }

  public static APINodeList<CatalogItemAppLinks> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CatalogItemAppLinks> catalogItemAppLinkss = new APINodeList<CatalogItemAppLinks>(request, json, header);
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
          catalogItemAppLinkss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return catalogItemAppLinkss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                catalogItemAppLinkss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            catalogItemAppLinkss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              catalogItemAppLinkss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              catalogItemAppLinkss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  catalogItemAppLinkss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              catalogItemAppLinkss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return catalogItemAppLinkss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              catalogItemAppLinkss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return catalogItemAppLinkss;
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
              catalogItemAppLinkss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return catalogItemAppLinkss;
          }

          // Sixth, check if it's pure JsonObject
          catalogItemAppLinkss.clear();
          catalogItemAppLinkss.add(loadJSON(json, context, header));
          return catalogItemAppLinkss;
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


  public List<AndroidAppLink> getFieldAndroid() {
    return mAndroid;
  }

  public CatalogItemAppLinks setFieldAndroid(List<AndroidAppLink> value) {
    this.mAndroid = value;
    return this;
  }

  public CatalogItemAppLinks setFieldAndroid(String value) {
    Type type = new TypeToken<List<AndroidAppLink>>(){}.getType();
    this.mAndroid = AndroidAppLink.getGson().fromJson(value, type);
    return this;
  }
  public List<IosAppLink> getFieldIos() {
    return mIos;
  }

  public CatalogItemAppLinks setFieldIos(List<IosAppLink> value) {
    this.mIos = value;
    return this;
  }

  public CatalogItemAppLinks setFieldIos(String value) {
    Type type = new TypeToken<List<IosAppLink>>(){}.getType();
    this.mIos = IosAppLink.getGson().fromJson(value, type);
    return this;
  }
  public List<IosAppLink> getFieldIpad() {
    return mIpad;
  }

  public CatalogItemAppLinks setFieldIpad(List<IosAppLink> value) {
    this.mIpad = value;
    return this;
  }

  public CatalogItemAppLinks setFieldIpad(String value) {
    Type type = new TypeToken<List<IosAppLink>>(){}.getType();
    this.mIpad = IosAppLink.getGson().fromJson(value, type);
    return this;
  }
  public List<IosAppLink> getFieldIphone() {
    return mIphone;
  }

  public CatalogItemAppLinks setFieldIphone(List<IosAppLink> value) {
    this.mIphone = value;
    return this;
  }

  public CatalogItemAppLinks setFieldIphone(String value) {
    Type type = new TypeToken<List<IosAppLink>>(){}.getType();
    this.mIphone = IosAppLink.getGson().fromJson(value, type);
    return this;
  }
  public WebAppLink getFieldWeb() {
    return mWeb;
  }

  public CatalogItemAppLinks setFieldWeb(WebAppLink value) {
    this.mWeb = value;
    return this;
  }

  public CatalogItemAppLinks setFieldWeb(String value) {
    Type type = new TypeToken<WebAppLink>(){}.getType();
    this.mWeb = WebAppLink.getGson().fromJson(value, type);
    return this;
  }
  public List<WindowsAppLink> getFieldWindows() {
    return mWindows;
  }

  public CatalogItemAppLinks setFieldWindows(List<WindowsAppLink> value) {
    this.mWindows = value;
    return this;
  }

  public CatalogItemAppLinks setFieldWindows(String value) {
    Type type = new TypeToken<List<WindowsAppLink>>(){}.getType();
    this.mWindows = WindowsAppLink.getGson().fromJson(value, type);
    return this;
  }
  public List<WindowsPhoneAppLink> getFieldWindowsPhone() {
    return mWindowsPhone;
  }

  public CatalogItemAppLinks setFieldWindowsPhone(List<WindowsPhoneAppLink> value) {
    this.mWindowsPhone = value;
    return this;
  }

  public CatalogItemAppLinks setFieldWindowsPhone(String value) {
    Type type = new TypeToken<List<WindowsPhoneAppLink>>(){}.getType();
    this.mWindowsPhone = WindowsPhoneAppLink.getGson().fromJson(value, type);
    return this;
  }
  public List<WindowsAppLink> getFieldWindowsUniversal() {
    return mWindowsUniversal;
  }

  public CatalogItemAppLinks setFieldWindowsUniversal(List<WindowsAppLink> value) {
    this.mWindowsUniversal = value;
    return this;
  }

  public CatalogItemAppLinks setFieldWindowsUniversal(String value) {
    Type type = new TypeToken<List<WindowsAppLink>>(){}.getType();
    this.mWindowsUniversal = WindowsAppLink.getGson().fromJson(value, type);
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

  public CatalogItemAppLinks copyFrom(CatalogItemAppLinks instance) {
    this.mAndroid = instance.mAndroid;
    this.mIos = instance.mIos;
    this.mIpad = instance.mIpad;
    this.mIphone = instance.mIphone;
    this.mWeb = instance.mWeb;
    this.mWindows = instance.mWindows;
    this.mWindowsPhone = instance.mWindowsPhone;
    this.mWindowsUniversal = instance.mWindowsUniversal;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CatalogItemAppLinks> getParser() {
    return new APIRequest.ResponseParser<CatalogItemAppLinks>() {
      public APINodeList<CatalogItemAppLinks> parseResponse(String response, APIContext context, APIRequest<CatalogItemAppLinks> request, String header) throws MalformedResponseException {
        return CatalogItemAppLinks.parseResponse(response, context, request, header);
      }
    };
  }
}
