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
public class AdCreativePromotionMetadataSpec extends APINode {
  @SerializedName("end_date")
  private Long mEndDate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("promotion_source")
  private String mPromotionSource = null;
  @SerializedName("promotion_type")
  private String mPromotionType = null;
  @SerializedName("promotion_value")
  private Double mPromotionValue = null;
  @SerializedName("required_code")
  private String mRequiredCode = null;
  @SerializedName("start_date")
  private Long mStartDate = null;
  protected static Gson gson = null;

  public AdCreativePromotionMetadataSpec() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdCreativePromotionMetadataSpec loadJSON(String json, APIContext context, String header) {
    AdCreativePromotionMetadataSpec adCreativePromotionMetadataSpec = getGson().fromJson(json, AdCreativePromotionMetadataSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativePromotionMetadataSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativePromotionMetadataSpec.context = context;
    adCreativePromotionMetadataSpec.rawValue = json;
    adCreativePromotionMetadataSpec.header = header;
    return adCreativePromotionMetadataSpec;
  }

  public static APINodeList<AdCreativePromotionMetadataSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativePromotionMetadataSpec> adCreativePromotionMetadataSpecs = new APINodeList<AdCreativePromotionMetadataSpec>(request, json, header);
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
          adCreativePromotionMetadataSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativePromotionMetadataSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativePromotionMetadataSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativePromotionMetadataSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativePromotionMetadataSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativePromotionMetadataSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativePromotionMetadataSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativePromotionMetadataSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativePromotionMetadataSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativePromotionMetadataSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativePromotionMetadataSpecs;
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
              adCreativePromotionMetadataSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativePromotionMetadataSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativePromotionMetadataSpecs.clear();
          adCreativePromotionMetadataSpecs.add(loadJSON(json, context, header));
          return adCreativePromotionMetadataSpecs;
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


  public Long getFieldEndDate() {
    return mEndDate;
  }

  public AdCreativePromotionMetadataSpec setFieldEndDate(Long value) {
    this.mEndDate = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdCreativePromotionMetadataSpec setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldPromotionSource() {
    return mPromotionSource;
  }

  public AdCreativePromotionMetadataSpec setFieldPromotionSource(String value) {
    this.mPromotionSource = value;
    return this;
  }

  public String getFieldPromotionType() {
    return mPromotionType;
  }

  public AdCreativePromotionMetadataSpec setFieldPromotionType(String value) {
    this.mPromotionType = value;
    return this;
  }

  public Double getFieldPromotionValue() {
    return mPromotionValue;
  }

  public AdCreativePromotionMetadataSpec setFieldPromotionValue(Double value) {
    this.mPromotionValue = value;
    return this;
  }

  public String getFieldRequiredCode() {
    return mRequiredCode;
  }

  public AdCreativePromotionMetadataSpec setFieldRequiredCode(String value) {
    this.mRequiredCode = value;
    return this;
  }

  public Long getFieldStartDate() {
    return mStartDate;
  }

  public AdCreativePromotionMetadataSpec setFieldStartDate(Long value) {
    this.mStartDate = value;
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

  public AdCreativePromotionMetadataSpec copyFrom(AdCreativePromotionMetadataSpec instance) {
    this.mEndDate = instance.mEndDate;
    this.mId = instance.mId;
    this.mPromotionSource = instance.mPromotionSource;
    this.mPromotionType = instance.mPromotionType;
    this.mPromotionValue = instance.mPromotionValue;
    this.mRequiredCode = instance.mRequiredCode;
    this.mStartDate = instance.mStartDate;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativePromotionMetadataSpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativePromotionMetadataSpec>() {
      public APINodeList<AdCreativePromotionMetadataSpec> parseResponse(String response, APIContext context, APIRequest<AdCreativePromotionMetadataSpec> request, String header) throws MalformedResponseException {
        return AdCreativePromotionMetadataSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
