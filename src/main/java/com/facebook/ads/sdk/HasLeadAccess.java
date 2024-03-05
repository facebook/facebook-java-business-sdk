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
public class HasLeadAccess extends APINode {
  @SerializedName("app_has_leads_permission")
  private Boolean mAppHasLeadsPermission = null;
  @SerializedName("can_access_lead")
  private Boolean mCanAccessLead = null;
  @SerializedName("enabled_lead_access_manager")
  private Boolean mEnabledLeadAccessManager = null;
  @SerializedName("failure_reason")
  private String mFailureReason = null;
  @SerializedName("failure_resolution")
  private String mFailureResolution = null;
  @SerializedName("is_page_admin")
  private Boolean mIsPageAdmin = null;
  @SerializedName("page_id")
  private String mPageId = null;
  @SerializedName("user_has_leads_permission")
  private Boolean mUserHasLeadsPermission = null;
  @SerializedName("user_id")
  private String mUserId = null;
  protected static Gson gson = null;

  public HasLeadAccess() {
  }

  public String getId() {
    return null;
  }
  public static HasLeadAccess loadJSON(String json, APIContext context, String header) {
    HasLeadAccess hasLeadAccess = getGson().fromJson(json, HasLeadAccess.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(hasLeadAccess.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    hasLeadAccess.context = context;
    hasLeadAccess.rawValue = json;
    hasLeadAccess.header = header;
    return hasLeadAccess;
  }

  public static APINodeList<HasLeadAccess> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<HasLeadAccess> hasLeadAccesss = new APINodeList<HasLeadAccess>(request, json, header);
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
          hasLeadAccesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return hasLeadAccesss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                hasLeadAccesss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            hasLeadAccesss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              hasLeadAccesss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              hasLeadAccesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  hasLeadAccesss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              hasLeadAccesss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return hasLeadAccesss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              hasLeadAccesss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return hasLeadAccesss;
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
              hasLeadAccesss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return hasLeadAccesss;
          }

          // Sixth, check if it's pure JsonObject
          hasLeadAccesss.clear();
          hasLeadAccesss.add(loadJSON(json, context, header));
          return hasLeadAccesss;
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


  public Boolean getFieldAppHasLeadsPermission() {
    return mAppHasLeadsPermission;
  }

  public HasLeadAccess setFieldAppHasLeadsPermission(Boolean value) {
    this.mAppHasLeadsPermission = value;
    return this;
  }

  public Boolean getFieldCanAccessLead() {
    return mCanAccessLead;
  }

  public HasLeadAccess setFieldCanAccessLead(Boolean value) {
    this.mCanAccessLead = value;
    return this;
  }

  public Boolean getFieldEnabledLeadAccessManager() {
    return mEnabledLeadAccessManager;
  }

  public HasLeadAccess setFieldEnabledLeadAccessManager(Boolean value) {
    this.mEnabledLeadAccessManager = value;
    return this;
  }

  public String getFieldFailureReason() {
    return mFailureReason;
  }

  public HasLeadAccess setFieldFailureReason(String value) {
    this.mFailureReason = value;
    return this;
  }

  public String getFieldFailureResolution() {
    return mFailureResolution;
  }

  public HasLeadAccess setFieldFailureResolution(String value) {
    this.mFailureResolution = value;
    return this;
  }

  public Boolean getFieldIsPageAdmin() {
    return mIsPageAdmin;
  }

  public HasLeadAccess setFieldIsPageAdmin(Boolean value) {
    this.mIsPageAdmin = value;
    return this;
  }

  public String getFieldPageId() {
    return mPageId;
  }

  public HasLeadAccess setFieldPageId(String value) {
    this.mPageId = value;
    return this;
  }

  public Boolean getFieldUserHasLeadsPermission() {
    return mUserHasLeadsPermission;
  }

  public HasLeadAccess setFieldUserHasLeadsPermission(Boolean value) {
    this.mUserHasLeadsPermission = value;
    return this;
  }

  public String getFieldUserId() {
    return mUserId;
  }

  public HasLeadAccess setFieldUserId(String value) {
    this.mUserId = value;
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

  public HasLeadAccess copyFrom(HasLeadAccess instance) {
    this.mAppHasLeadsPermission = instance.mAppHasLeadsPermission;
    this.mCanAccessLead = instance.mCanAccessLead;
    this.mEnabledLeadAccessManager = instance.mEnabledLeadAccessManager;
    this.mFailureReason = instance.mFailureReason;
    this.mFailureResolution = instance.mFailureResolution;
    this.mIsPageAdmin = instance.mIsPageAdmin;
    this.mPageId = instance.mPageId;
    this.mUserHasLeadsPermission = instance.mUserHasLeadsPermission;
    this.mUserId = instance.mUserId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<HasLeadAccess> getParser() {
    return new APIRequest.ResponseParser<HasLeadAccess>() {
      public APINodeList<HasLeadAccess> parseResponse(String response, APIContext context, APIRequest<HasLeadAccess> request, String header) throws MalformedResponseException {
        return HasLeadAccess.parseResponse(response, context, request, header);
      }
    };
  }
}
