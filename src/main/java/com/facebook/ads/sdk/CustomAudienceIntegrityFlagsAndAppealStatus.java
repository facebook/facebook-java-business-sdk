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
public class CustomAudienceIntegrityFlagsAndAppealStatus extends APINode {
  @SerializedName("closeout_time")
  private Long mCloseoutTime = null;
  @SerializedName("flagged_fields")
  private List<String> mFlaggedFields = null;
  @SerializedName("latest_appeal_requestor")
  private String mLatestAppealRequestor = null;
  @SerializedName("latest_appeal_time")
  private Long mLatestAppealTime = null;
  @SerializedName("restriction_status")
  private String mRestrictionStatus = null;
  protected static Gson gson = null;

  public CustomAudienceIntegrityFlagsAndAppealStatus() {
  }

  public String getId() {
    return null;
  }
  public static CustomAudienceIntegrityFlagsAndAppealStatus loadJSON(String json, APIContext context, String header) {
    CustomAudienceIntegrityFlagsAndAppealStatus customAudienceIntegrityFlagsAndAppealStatus = getGson().fromJson(json, CustomAudienceIntegrityFlagsAndAppealStatus.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(customAudienceIntegrityFlagsAndAppealStatus.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    customAudienceIntegrityFlagsAndAppealStatus.context = context;
    customAudienceIntegrityFlagsAndAppealStatus.rawValue = json;
    customAudienceIntegrityFlagsAndAppealStatus.header = header;
    return customAudienceIntegrityFlagsAndAppealStatus;
  }

  public static APINodeList<CustomAudienceIntegrityFlagsAndAppealStatus> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CustomAudienceIntegrityFlagsAndAppealStatus> customAudienceIntegrityFlagsAndAppealStatuss = new APINodeList<CustomAudienceIntegrityFlagsAndAppealStatus>(request, json, header);
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
          customAudienceIntegrityFlagsAndAppealStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return customAudienceIntegrityFlagsAndAppealStatuss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                customAudienceIntegrityFlagsAndAppealStatuss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            customAudienceIntegrityFlagsAndAppealStatuss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              customAudienceIntegrityFlagsAndAppealStatuss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              customAudienceIntegrityFlagsAndAppealStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  customAudienceIntegrityFlagsAndAppealStatuss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              customAudienceIntegrityFlagsAndAppealStatuss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return customAudienceIntegrityFlagsAndAppealStatuss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              customAudienceIntegrityFlagsAndAppealStatuss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return customAudienceIntegrityFlagsAndAppealStatuss;
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
              customAudienceIntegrityFlagsAndAppealStatuss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return customAudienceIntegrityFlagsAndAppealStatuss;
          }

          // Sixth, check if it's pure JsonObject
          customAudienceIntegrityFlagsAndAppealStatuss.clear();
          customAudienceIntegrityFlagsAndAppealStatuss.add(loadJSON(json, context, header));
          return customAudienceIntegrityFlagsAndAppealStatuss;
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


  public Long getFieldCloseoutTime() {
    return mCloseoutTime;
  }

  public CustomAudienceIntegrityFlagsAndAppealStatus setFieldCloseoutTime(Long value) {
    this.mCloseoutTime = value;
    return this;
  }

  public List<String> getFieldFlaggedFields() {
    return mFlaggedFields;
  }

  public CustomAudienceIntegrityFlagsAndAppealStatus setFieldFlaggedFields(List<String> value) {
    this.mFlaggedFields = value;
    return this;
  }

  public String getFieldLatestAppealRequestor() {
    return mLatestAppealRequestor;
  }

  public CustomAudienceIntegrityFlagsAndAppealStatus setFieldLatestAppealRequestor(String value) {
    this.mLatestAppealRequestor = value;
    return this;
  }

  public Long getFieldLatestAppealTime() {
    return mLatestAppealTime;
  }

  public CustomAudienceIntegrityFlagsAndAppealStatus setFieldLatestAppealTime(Long value) {
    this.mLatestAppealTime = value;
    return this;
  }

  public String getFieldRestrictionStatus() {
    return mRestrictionStatus;
  }

  public CustomAudienceIntegrityFlagsAndAppealStatus setFieldRestrictionStatus(String value) {
    this.mRestrictionStatus = value;
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

  public CustomAudienceIntegrityFlagsAndAppealStatus copyFrom(CustomAudienceIntegrityFlagsAndAppealStatus instance) {
    this.mCloseoutTime = instance.mCloseoutTime;
    this.mFlaggedFields = instance.mFlaggedFields;
    this.mLatestAppealRequestor = instance.mLatestAppealRequestor;
    this.mLatestAppealTime = instance.mLatestAppealTime;
    this.mRestrictionStatus = instance.mRestrictionStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CustomAudienceIntegrityFlagsAndAppealStatus> getParser() {
    return new APIRequest.ResponseParser<CustomAudienceIntegrityFlagsAndAppealStatus>() {
      public APINodeList<CustomAudienceIntegrityFlagsAndAppealStatus> parseResponse(String response, APIContext context, APIRequest<CustomAudienceIntegrityFlagsAndAppealStatus> request, String header) throws MalformedResponseException {
        return CustomAudienceIntegrityFlagsAndAppealStatus.parseResponse(response, context, request, header);
      }
    };
  }
}
