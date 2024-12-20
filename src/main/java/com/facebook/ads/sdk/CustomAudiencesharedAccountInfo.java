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
public class CustomAudiencesharedAccountInfo extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("account_name")
  private String mAccountName = null;
  @SerializedName("business_id")
  private String mBusinessId = null;
  @SerializedName("business_name")
  private String mBusinessName = null;
  @SerializedName("sharing_status")
  private String mSharingStatus = null;
  protected static Gson gson = null;

  public CustomAudiencesharedAccountInfo() {
  }

  public String getId() {
    return null;
  }
  public static CustomAudiencesharedAccountInfo loadJSON(String json, APIContext context, String header) {
    CustomAudiencesharedAccountInfo customAudiencesharedAccountInfo = getGson().fromJson(json, CustomAudiencesharedAccountInfo.class);
    if (context.isDebug()) {
      JsonElement o1 = JsonParser.parseString(json);
      JsonElement o2 = JsonParser.parseString(customAudiencesharedAccountInfo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    customAudiencesharedAccountInfo.context = context;
    customAudiencesharedAccountInfo.rawValue = json;
    customAudiencesharedAccountInfo.header = header;
    return customAudiencesharedAccountInfo;
  }

  public static APINodeList<CustomAudiencesharedAccountInfo> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CustomAudiencesharedAccountInfo> customAudiencesharedAccountInfos = new APINodeList<CustomAudiencesharedAccountInfo>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    Exception exception = null;
    try{
      JsonElement result = JsonParser.parseString(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          customAudiencesharedAccountInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return customAudiencesharedAccountInfos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                customAudiencesharedAccountInfos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            customAudiencesharedAccountInfos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              customAudiencesharedAccountInfos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customAudiencesharedAccountInfos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  customAudiencesharedAccountInfos.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              customAudiencesharedAccountInfos.add(loadJSON(obj.toString(), context, header));
            }
          }
          return customAudiencesharedAccountInfos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customAudiencesharedAccountInfos.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return customAudiencesharedAccountInfos;
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
              customAudiencesharedAccountInfos.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return customAudiencesharedAccountInfos;
          }

          // Sixth, check if it's pure JsonObject
          customAudiencesharedAccountInfos.clear();
          customAudiencesharedAccountInfos.add(loadJSON(json, context, header));
          return customAudiencesharedAccountInfos;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public CustomAudiencesharedAccountInfo setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public String getFieldAccountName() {
    return mAccountName;
  }

  public CustomAudiencesharedAccountInfo setFieldAccountName(String value) {
    this.mAccountName = value;
    return this;
  }

  public String getFieldBusinessId() {
    return mBusinessId;
  }

  public CustomAudiencesharedAccountInfo setFieldBusinessId(String value) {
    this.mBusinessId = value;
    return this;
  }

  public String getFieldBusinessName() {
    return mBusinessName;
  }

  public CustomAudiencesharedAccountInfo setFieldBusinessName(String value) {
    this.mBusinessName = value;
    return this;
  }

  public String getFieldSharingStatus() {
    return mSharingStatus;
  }

  public CustomAudiencesharedAccountInfo setFieldSharingStatus(String value) {
    this.mSharingStatus = value;
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

  public CustomAudiencesharedAccountInfo copyFrom(CustomAudiencesharedAccountInfo instance) {
    this.mAccountId = instance.mAccountId;
    this.mAccountName = instance.mAccountName;
    this.mBusinessId = instance.mBusinessId;
    this.mBusinessName = instance.mBusinessName;
    this.mSharingStatus = instance.mSharingStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomAudiencesharedAccountInfo> getParser() {
    return new APIRequest.ResponseParser<CustomAudiencesharedAccountInfo>() {
      public APINodeList<CustomAudiencesharedAccountInfo> parseResponse(String response, APIContext context, APIRequest<CustomAudiencesharedAccountInfo> request, String header) throws MalformedResponseException {
        return CustomAudiencesharedAccountInfo.parseResponse(response, context, request, header);
      }
    };
  }
}
