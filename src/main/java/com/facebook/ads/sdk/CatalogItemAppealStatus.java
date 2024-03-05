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
public class CatalogItemAppealStatus extends APINode {
  @SerializedName("handle")
  private String mHandle = null;
  @SerializedName("item_id")
  private Long mItemId = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("use_cases")
  private List<Object> mUseCases = null;
  protected static Gson gson = null;

  public CatalogItemAppealStatus() {
  }

  public String getId() {
    return null;
  }
  public static CatalogItemAppealStatus loadJSON(String json, APIContext context, String header) {
    CatalogItemAppealStatus catalogItemAppealStatus = getGson().fromJson(json, CatalogItemAppealStatus.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(catalogItemAppealStatus.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    catalogItemAppealStatus.context = context;
    catalogItemAppealStatus.rawValue = json;
    catalogItemAppealStatus.header = header;
    return catalogItemAppealStatus;
  }

  public static APINodeList<CatalogItemAppealStatus> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CatalogItemAppealStatus> catalogItemAppealStatuss = new APINodeList<CatalogItemAppealStatus>(request, json, header);
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
          catalogItemAppealStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return catalogItemAppealStatuss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                catalogItemAppealStatuss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            catalogItemAppealStatuss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              catalogItemAppealStatuss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              catalogItemAppealStatuss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  catalogItemAppealStatuss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              catalogItemAppealStatuss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return catalogItemAppealStatuss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              catalogItemAppealStatuss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return catalogItemAppealStatuss;
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
              catalogItemAppealStatuss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return catalogItemAppealStatuss;
          }

          // Sixth, check if it's pure JsonObject
          catalogItemAppealStatuss.clear();
          catalogItemAppealStatuss.add(loadJSON(json, context, header));
          return catalogItemAppealStatuss;
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


  public String getFieldHandle() {
    return mHandle;
  }

  public CatalogItemAppealStatus setFieldHandle(String value) {
    this.mHandle = value;
    return this;
  }

  public Long getFieldItemId() {
    return mItemId;
  }

  public CatalogItemAppealStatus setFieldItemId(Long value) {
    this.mItemId = value;
    return this;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public CatalogItemAppealStatus setFieldStatus(EnumStatus value) {
    this.mStatus = value;
    return this;
  }

  public List<Object> getFieldUseCases() {
    return mUseCases;
  }

  public CatalogItemAppealStatus setFieldUseCases(List<Object> value) {
    this.mUseCases = value;
    return this;
  }



  public static enum EnumStatus {
      @SerializedName("This item cannot be appealed as it is either approved or already has an appeal")
      VALUE_THIS_ITEM_CANNOT_BE_APPEALED_AS_IT_IS_EITHER_APPROVED_OR_ALREADY_HAS_AN_APPEAL("This item cannot be appealed as it is either approved or already has an appeal"),
      @SerializedName("This item is not rejected for any of channels")
      VALUE_THIS_ITEM_IS_NOT_REJECTED_FOR_ANY_OF_CHANNELS("This item is not rejected for any of channels"),
      @SerializedName("We've encountered unexpected error while processing this request. Please try again later !")
      VALUE_WE_VE_ENCOUNTERED_UNEXPECTED_ERROR_WHILE_PROCESSING_THIS_REQUEST_PLEASE_TRY_AGAIN_LATER_("We've encountered unexpected error while processing this request. Please try again later !"),
      @SerializedName("You've reached the maximum number of item requests you can make this week. You'll be able to request item reviews again within the next 7 days.")
      VALUE_YOU_VE_REACHED_THE_MAXIMUM_NUMBER_OF_ITEM_REQUESTS_YOU_CAN_MAKE_THIS_WEEK_YOU_LL_BE_ABLE_TO_REQUEST_ITEM_REVIEWS_AGAIN_WITHIN_THE_NEXT_7_DAYS_("You've reached the maximum number of item requests you can make this week. You'll be able to request item reviews again within the next 7 days."),
      @SerializedName("Your request was received. See information below to learn more.")
      VALUE_YOUR_REQUEST_WAS_RECEIVED_SEE_INFORMATION_BELOW_TO_LEARN_MORE_("Your request was received. See information below to learn more."),
      ;

      private String value;

      private EnumStatus(String value) {
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

  public CatalogItemAppealStatus copyFrom(CatalogItemAppealStatus instance) {
    this.mHandle = instance.mHandle;
    this.mItemId = instance.mItemId;
    this.mStatus = instance.mStatus;
    this.mUseCases = instance.mUseCases;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CatalogItemAppealStatus> getParser() {
    return new APIRequest.ResponseParser<CatalogItemAppealStatus>() {
      public APINodeList<CatalogItemAppealStatus> parseResponse(String response, APIContext context, APIRequest<CatalogItemAppealStatus> request, String header) throws MalformedResponseException {
        return CatalogItemAppealStatus.parseResponse(response, context, request, header);
      }
    };
  }
}
