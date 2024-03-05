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
public class Tab extends APINode {
  @SerializedName("application")
  private Application mApplication = null;
  @SerializedName("custom_image_url")
  private String mCustomImageUrl = null;
  @SerializedName("custom_name")
  private String mCustomName = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("is_non_connection_landing_tab")
  private Boolean mIsNonConnectionLandingTab = null;
  @SerializedName("is_permanent")
  private Boolean mIsPermanent = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("position")
  private Long mPosition = null;
  protected static Gson gson = null;

  public Tab() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static Tab loadJSON(String json, APIContext context, String header) {
    Tab tab = getGson().fromJson(json, Tab.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(tab.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    tab.context = context;
    tab.rawValue = json;
    tab.header = header;
    return tab;
  }

  public static APINodeList<Tab> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Tab> tabs = new APINodeList<Tab>(request, json, header);
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
          tabs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return tabs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                tabs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            tabs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              tabs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              tabs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  tabs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              tabs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return tabs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              tabs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return tabs;
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
              tabs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return tabs;
          }

          // Sixth, check if it's pure JsonObject
          tabs.clear();
          tabs.add(loadJSON(json, context, header));
          return tabs;
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


  public Application getFieldApplication() {
    if (mApplication != null) {
      mApplication.context = getContext();
    }
    return mApplication;
  }

  public Tab setFieldApplication(Application value) {
    this.mApplication = value;
    return this;
  }

  public Tab setFieldApplication(String value) {
    Type type = new TypeToken<Application>(){}.getType();
    this.mApplication = Application.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCustomImageUrl() {
    return mCustomImageUrl;
  }

  public Tab setFieldCustomImageUrl(String value) {
    this.mCustomImageUrl = value;
    return this;
  }

  public String getFieldCustomName() {
    return mCustomName;
  }

  public Tab setFieldCustomName(String value) {
    this.mCustomName = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public Tab setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public Tab setFieldImageUrl(String value) {
    this.mImageUrl = value;
    return this;
  }

  public Boolean getFieldIsNonConnectionLandingTab() {
    return mIsNonConnectionLandingTab;
  }

  public Tab setFieldIsNonConnectionLandingTab(Boolean value) {
    this.mIsNonConnectionLandingTab = value;
    return this;
  }

  public Boolean getFieldIsPermanent() {
    return mIsPermanent;
  }

  public Tab setFieldIsPermanent(Boolean value) {
    this.mIsPermanent = value;
    return this;
  }

  public String getFieldLink() {
    return mLink;
  }

  public Tab setFieldLink(String value) {
    this.mLink = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public Tab setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public Long getFieldPosition() {
    return mPosition;
  }

  public Tab setFieldPosition(Long value) {
    this.mPosition = value;
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

  public Tab copyFrom(Tab instance) {
    this.mApplication = instance.mApplication;
    this.mCustomImageUrl = instance.mCustomImageUrl;
    this.mCustomName = instance.mCustomName;
    this.mId = instance.mId;
    this.mImageUrl = instance.mImageUrl;
    this.mIsNonConnectionLandingTab = instance.mIsNonConnectionLandingTab;
    this.mIsPermanent = instance.mIsPermanent;
    this.mLink = instance.mLink;
    this.mName = instance.mName;
    this.mPosition = instance.mPosition;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Tab> getParser() {
    return new APIRequest.ResponseParser<Tab>() {
      public APINodeList<Tab> parseResponse(String response, APIContext context, APIRequest<Tab> request, String header) throws MalformedResponseException {
        return Tab.parseResponse(response, context, request, header);
      }
    };
  }
}
