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
public class PageUserPermissions extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("business_persona")
  private String mBusinessPersona = null;
  @SerializedName("created_by")
  private Profile mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("email")
  private String mEmail = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("tasks")
  private List<String> mTasks = null;
  @SerializedName("updated_by")
  private Profile mUpdatedBy = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("user")
  private Profile mUser = null;
  protected static Gson gson = null;

  public PageUserPermissions() {
  }

  public String getId() {
    return null;
  }
  public static PageUserPermissions loadJSON(String json, APIContext context, String header) {
    PageUserPermissions pageUserPermissions = getGson().fromJson(json, PageUserPermissions.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageUserPermissions.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    pageUserPermissions.context = context;
    pageUserPermissions.rawValue = json;
    pageUserPermissions.header = header;
    return pageUserPermissions;
  }

  public static APINodeList<PageUserPermissions> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PageUserPermissions> pageUserPermissionss = new APINodeList<PageUserPermissions>(request, json, header);
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
          pageUserPermissionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return pageUserPermissionss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageUserPermissionss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageUserPermissionss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageUserPermissionss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageUserPermissionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  pageUserPermissionss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageUserPermissionss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return pageUserPermissionss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageUserPermissionss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return pageUserPermissionss;
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
              pageUserPermissionss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageUserPermissionss;
          }

          // Sixth, check if it's pure JsonObject
          pageUserPermissionss.clear();
          pageUserPermissionss.add(loadJSON(json, context, header));
          return pageUserPermissionss;
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


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public PageUserPermissions setFieldBusiness(Business value) {
    this.mBusiness = value;
    return this;
  }

  public PageUserPermissions setFieldBusiness(String value) {
    Type type = new TypeToken<Business>(){}.getType();
    this.mBusiness = Business.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldBusinessPersona() {
    return mBusinessPersona;
  }

  public PageUserPermissions setFieldBusinessPersona(String value) {
    this.mBusinessPersona = value;
    return this;
  }

  public Profile getFieldCreatedBy() {
    if (mCreatedBy != null) {
      mCreatedBy.context = getContext();
    }
    return mCreatedBy;
  }

  public PageUserPermissions setFieldCreatedBy(Profile value) {
    this.mCreatedBy = value;
    return this;
  }

  public PageUserPermissions setFieldCreatedBy(String value) {
    Type type = new TypeToken<Profile>(){}.getType();
    this.mCreatedBy = Profile.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public PageUserPermissions setFieldCreatedTime(String value) {
    this.mCreatedTime = value;
    return this;
  }

  public String getFieldEmail() {
    return mEmail;
  }

  public PageUserPermissions setFieldEmail(String value) {
    this.mEmail = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public PageUserPermissions setFieldStatus(String value) {
    this.mStatus = value;
    return this;
  }

  public List<String> getFieldTasks() {
    return mTasks;
  }

  public PageUserPermissions setFieldTasks(List<String> value) {
    this.mTasks = value;
    return this;
  }

  public Profile getFieldUpdatedBy() {
    if (mUpdatedBy != null) {
      mUpdatedBy.context = getContext();
    }
    return mUpdatedBy;
  }

  public PageUserPermissions setFieldUpdatedBy(Profile value) {
    this.mUpdatedBy = value;
    return this;
  }

  public PageUserPermissions setFieldUpdatedBy(String value) {
    Type type = new TypeToken<Profile>(){}.getType();
    this.mUpdatedBy = Profile.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public PageUserPermissions setFieldUpdatedTime(String value) {
    this.mUpdatedTime = value;
    return this;
  }

  public Profile getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }

  public PageUserPermissions setFieldUser(Profile value) {
    this.mUser = value;
    return this;
  }

  public PageUserPermissions setFieldUser(String value) {
    Type type = new TypeToken<Profile>(){}.getType();
    this.mUser = Profile.getGson().fromJson(value, type);
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

  public PageUserPermissions copyFrom(PageUserPermissions instance) {
    this.mBusiness = instance.mBusiness;
    this.mBusinessPersona = instance.mBusinessPersona;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mEmail = instance.mEmail;
    this.mStatus = instance.mStatus;
    this.mTasks = instance.mTasks;
    this.mUpdatedBy = instance.mUpdatedBy;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUser = instance.mUser;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageUserPermissions> getParser() {
    return new APIRequest.ResponseParser<PageUserPermissions>() {
      public APINodeList<PageUserPermissions> parseResponse(String response, APIContext context, APIRequest<PageUserPermissions> request, String header) throws MalformedResponseException {
        return PageUserPermissions.parseResponse(response, context, request, header);
      }
    };
  }
}
