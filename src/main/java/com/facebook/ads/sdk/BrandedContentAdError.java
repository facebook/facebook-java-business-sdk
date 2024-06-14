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
public class BrandedContentAdError extends APINode {
  @SerializedName("blame_field_spec")
  private List<String> mBlameFieldSpec = null;
  @SerializedName("error_code")
  private Long mErrorCode = null;
  @SerializedName("error_description")
  private String mErrorDescription = null;
  @SerializedName("error_message")
  private String mErrorMessage = null;
  @SerializedName("error_placement")
  private String mErrorPlacement = null;
  @SerializedName("error_severity")
  private String mErrorSeverity = null;
  @SerializedName("help_center_id")
  private Long mHelpCenterId = null;
  protected static Gson gson = null;

  public BrandedContentAdError() {
  }

  public String getId() {
    return null;
  }
  public static BrandedContentAdError loadJSON(String json, APIContext context, String header) {
    BrandedContentAdError brandedContentAdError = getGson().fromJson(json, BrandedContentAdError.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(brandedContentAdError.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    brandedContentAdError.context = context;
    brandedContentAdError.rawValue = json;
    brandedContentAdError.header = header;
    return brandedContentAdError;
  }

  public static APINodeList<BrandedContentAdError> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BrandedContentAdError> brandedContentAdErrors = new APINodeList<BrandedContentAdError>(request, json, header);
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
          brandedContentAdErrors.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return brandedContentAdErrors;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                brandedContentAdErrors.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            brandedContentAdErrors.setPaging(previous, next);
            if (context.hasAppSecret()) {
              brandedContentAdErrors.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              brandedContentAdErrors.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  brandedContentAdErrors.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              brandedContentAdErrors.add(loadJSON(obj.toString(), context, header));
            }
          }
          return brandedContentAdErrors;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              brandedContentAdErrors.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return brandedContentAdErrors;
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
              brandedContentAdErrors.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return brandedContentAdErrors;
          }

          // Sixth, check if it's pure JsonObject
          brandedContentAdErrors.clear();
          brandedContentAdErrors.add(loadJSON(json, context, header));
          return brandedContentAdErrors;
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


  public List<String> getFieldBlameFieldSpec() {
    return mBlameFieldSpec;
  }

  public BrandedContentAdError setFieldBlameFieldSpec(List<String> value) {
    this.mBlameFieldSpec = value;
    return this;
  }

  public Long getFieldErrorCode() {
    return mErrorCode;
  }

  public BrandedContentAdError setFieldErrorCode(Long value) {
    this.mErrorCode = value;
    return this;
  }

  public String getFieldErrorDescription() {
    return mErrorDescription;
  }

  public BrandedContentAdError setFieldErrorDescription(String value) {
    this.mErrorDescription = value;
    return this;
  }

  public String getFieldErrorMessage() {
    return mErrorMessage;
  }

  public BrandedContentAdError setFieldErrorMessage(String value) {
    this.mErrorMessage = value;
    return this;
  }

  public String getFieldErrorPlacement() {
    return mErrorPlacement;
  }

  public BrandedContentAdError setFieldErrorPlacement(String value) {
    this.mErrorPlacement = value;
    return this;
  }

  public String getFieldErrorSeverity() {
    return mErrorSeverity;
  }

  public BrandedContentAdError setFieldErrorSeverity(String value) {
    this.mErrorSeverity = value;
    return this;
  }

  public Long getFieldHelpCenterId() {
    return mHelpCenterId;
  }

  public BrandedContentAdError setFieldHelpCenterId(Long value) {
    this.mHelpCenterId = value;
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

  public BrandedContentAdError copyFrom(BrandedContentAdError instance) {
    this.mBlameFieldSpec = instance.mBlameFieldSpec;
    this.mErrorCode = instance.mErrorCode;
    this.mErrorDescription = instance.mErrorDescription;
    this.mErrorMessage = instance.mErrorMessage;
    this.mErrorPlacement = instance.mErrorPlacement;
    this.mErrorSeverity = instance.mErrorSeverity;
    this.mHelpCenterId = instance.mHelpCenterId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BrandedContentAdError> getParser() {
    return new APIRequest.ResponseParser<BrandedContentAdError>() {
      public APINodeList<BrandedContentAdError> parseResponse(String response, APIContext context, APIRequest<BrandedContentAdError> request, String header) throws MalformedResponseException {
        return BrandedContentAdError.parseResponse(response, context, request, header);
      }
    };
  }
}
