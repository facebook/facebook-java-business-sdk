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
public class AdRuleFilters extends APINode {
  @SerializedName("field")
  private String mField = null;
  @SerializedName("operator")
  private EnumOperator mOperator = null;
  @SerializedName("value")
  private Object mValue = null;
  protected static Gson gson = null;

  public AdRuleFilters() {
  }

  public String getId() {
    return null;
  }
  public static AdRuleFilters loadJSON(String json, APIContext context, String header) {
    AdRuleFilters adRuleFilters = getGson().fromJson(json, AdRuleFilters.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adRuleFilters.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adRuleFilters.context = context;
    adRuleFilters.rawValue = json;
    adRuleFilters.header = header;
    return adRuleFilters;
  }

  public static APINodeList<AdRuleFilters> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdRuleFilters> adRuleFilterss = new APINodeList<AdRuleFilters>(request, json, header);
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
          adRuleFilterss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adRuleFilterss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adRuleFilterss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adRuleFilterss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adRuleFilterss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adRuleFilterss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adRuleFilterss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adRuleFilterss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adRuleFilterss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adRuleFilterss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adRuleFilterss;
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
              adRuleFilterss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adRuleFilterss;
          }

          // Sixth, check if it's pure JsonObject
          adRuleFilterss.clear();
          adRuleFilterss.add(loadJSON(json, context, header));
          return adRuleFilterss;
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


  public String getFieldField() {
    return mField;
  }

  public AdRuleFilters setFieldField(String value) {
    this.mField = value;
    return this;
  }

  public EnumOperator getFieldOperator() {
    return mOperator;
  }

  public AdRuleFilters setFieldOperator(EnumOperator value) {
    this.mOperator = value;
    return this;
  }

  public Object getFieldValue() {
    return mValue;
  }

  public AdRuleFilters setFieldValue(Object value) {
    this.mValue = value;
    return this;
  }



  public static enum EnumOperator {
      @SerializedName("ALL")
      VALUE_ALL("ALL"),
      @SerializedName("ANY")
      VALUE_ANY("ANY"),
      @SerializedName("CONTAIN")
      VALUE_CONTAIN("CONTAIN"),
      @SerializedName("EQUAL")
      VALUE_EQUAL("EQUAL"),
      @SerializedName("GREATER_THAN")
      VALUE_GREATER_THAN("GREATER_THAN"),
      @SerializedName("IN")
      VALUE_IN("IN"),
      @SerializedName("IN_RANGE")
      VALUE_IN_RANGE("IN_RANGE"),
      @SerializedName("LESS_THAN")
      VALUE_LESS_THAN("LESS_THAN"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("NOT_CONTAIN")
      VALUE_NOT_CONTAIN("NOT_CONTAIN"),
      @SerializedName("NOT_EQUAL")
      VALUE_NOT_EQUAL("NOT_EQUAL"),
      @SerializedName("NOT_IN")
      VALUE_NOT_IN("NOT_IN"),
      @SerializedName("NOT_IN_RANGE")
      VALUE_NOT_IN_RANGE("NOT_IN_RANGE"),
      ;

      private String value;

      private EnumOperator(String value) {
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

  public AdRuleFilters copyFrom(AdRuleFilters instance) {
    this.mField = instance.mField;
    this.mOperator = instance.mOperator;
    this.mValue = instance.mValue;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdRuleFilters> getParser() {
    return new APIRequest.ResponseParser<AdRuleFilters>() {
      public APINodeList<AdRuleFilters> parseResponse(String response, APIContext context, APIRequest<AdRuleFilters> request, String header) throws MalformedResponseException {
        return AdRuleFilters.parseResponse(response, context, request, header);
      }
    };
  }
}
