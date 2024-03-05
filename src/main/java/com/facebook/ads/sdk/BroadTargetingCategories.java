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
public class BroadTargetingCategories extends APINode {
  @SerializedName("category_description")
  private String mCategoryDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("parent_category")
  private String mParentCategory = null;
  @SerializedName("path")
  private List<String> mPath = null;
  @SerializedName("size_lower_bound")
  private Long mSizeLowerBound = null;
  @SerializedName("size_upper_bound")
  private Long mSizeUpperBound = null;
  @SerializedName("source")
  private String mSource = null;
  @SerializedName("type")
  private Long mType = null;
  @SerializedName("type_name")
  private String mTypeName = null;
  @SerializedName("untranslated_name")
  private String mUntranslatedName = null;
  @SerializedName("untranslated_parent_name")
  private String mUntranslatedParentName = null;
  protected static Gson gson = null;

  public BroadTargetingCategories() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static BroadTargetingCategories loadJSON(String json, APIContext context, String header) {
    BroadTargetingCategories broadTargetingCategories = getGson().fromJson(json, BroadTargetingCategories.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(broadTargetingCategories.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    broadTargetingCategories.context = context;
    broadTargetingCategories.rawValue = json;
    broadTargetingCategories.header = header;
    return broadTargetingCategories;
  }

  public static APINodeList<BroadTargetingCategories> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BroadTargetingCategories> broadTargetingCategoriess = new APINodeList<BroadTargetingCategories>(request, json, header);
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
          broadTargetingCategoriess.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return broadTargetingCategoriess;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                broadTargetingCategoriess.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            broadTargetingCategoriess.setPaging(previous, next);
            if (context.hasAppSecret()) {
              broadTargetingCategoriess.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              broadTargetingCategoriess.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  broadTargetingCategoriess.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              broadTargetingCategoriess.add(loadJSON(obj.toString(), context, header));
            }
          }
          return broadTargetingCategoriess;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              broadTargetingCategoriess.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return broadTargetingCategoriess;
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
              broadTargetingCategoriess.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return broadTargetingCategoriess;
          }

          // Sixth, check if it's pure JsonObject
          broadTargetingCategoriess.clear();
          broadTargetingCategoriess.add(loadJSON(json, context, header));
          return broadTargetingCategoriess;
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


  public String getFieldCategoryDescription() {
    return mCategoryDescription;
  }

  public BroadTargetingCategories setFieldCategoryDescription(String value) {
    this.mCategoryDescription = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public BroadTargetingCategories setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public BroadTargetingCategories setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldParentCategory() {
    return mParentCategory;
  }

  public BroadTargetingCategories setFieldParentCategory(String value) {
    this.mParentCategory = value;
    return this;
  }

  public List<String> getFieldPath() {
    return mPath;
  }

  public BroadTargetingCategories setFieldPath(List<String> value) {
    this.mPath = value;
    return this;
  }

  public Long getFieldSizeLowerBound() {
    return mSizeLowerBound;
  }

  public BroadTargetingCategories setFieldSizeLowerBound(Long value) {
    this.mSizeLowerBound = value;
    return this;
  }

  public Long getFieldSizeUpperBound() {
    return mSizeUpperBound;
  }

  public BroadTargetingCategories setFieldSizeUpperBound(Long value) {
    this.mSizeUpperBound = value;
    return this;
  }

  public String getFieldSource() {
    return mSource;
  }

  public BroadTargetingCategories setFieldSource(String value) {
    this.mSource = value;
    return this;
  }

  public Long getFieldType() {
    return mType;
  }

  public BroadTargetingCategories setFieldType(Long value) {
    this.mType = value;
    return this;
  }

  public String getFieldTypeName() {
    return mTypeName;
  }

  public BroadTargetingCategories setFieldTypeName(String value) {
    this.mTypeName = value;
    return this;
  }

  public String getFieldUntranslatedName() {
    return mUntranslatedName;
  }

  public BroadTargetingCategories setFieldUntranslatedName(String value) {
    this.mUntranslatedName = value;
    return this;
  }

  public String getFieldUntranslatedParentName() {
    return mUntranslatedParentName;
  }

  public BroadTargetingCategories setFieldUntranslatedParentName(String value) {
    this.mUntranslatedParentName = value;
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

  public BroadTargetingCategories copyFrom(BroadTargetingCategories instance) {
    this.mCategoryDescription = instance.mCategoryDescription;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mParentCategory = instance.mParentCategory;
    this.mPath = instance.mPath;
    this.mSizeLowerBound = instance.mSizeLowerBound;
    this.mSizeUpperBound = instance.mSizeUpperBound;
    this.mSource = instance.mSource;
    this.mType = instance.mType;
    this.mTypeName = instance.mTypeName;
    this.mUntranslatedName = instance.mUntranslatedName;
    this.mUntranslatedParentName = instance.mUntranslatedParentName;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BroadTargetingCategories> getParser() {
    return new APIRequest.ResponseParser<BroadTargetingCategories>() {
      public APINodeList<BroadTargetingCategories> parseResponse(String response, APIContext context, APIRequest<BroadTargetingCategories> request, String header) throws MalformedResponseException {
        return BroadTargetingCategories.parseResponse(response, context, request, header);
      }
    };
  }
}
