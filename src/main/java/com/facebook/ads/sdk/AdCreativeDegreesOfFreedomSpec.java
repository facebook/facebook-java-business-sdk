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
public class AdCreativeDegreesOfFreedomSpec extends APINode {
  @SerializedName("ad_handle_type")
  private String mAdHandleType = null;
  @SerializedName("creative_features_spec")
  private AdCreativeFeaturesSpec mCreativeFeaturesSpec = null;
  @SerializedName("degrees_of_freedom_type")
  private String mDegreesOfFreedomType = null;
  @SerializedName("image_transformation_types")
  private List<String> mImageTransformationTypes = null;
  @SerializedName("multi_media_transformation_type")
  private String mMultiMediaTransformationType = null;
  @SerializedName("stories_transformation_types")
  private List<String> mStoriesTransformationTypes = null;
  @SerializedName("text_transformation_types")
  private List<String> mTextTransformationTypes = null;
  @SerializedName("video_transformation_types")
  private List<String> mVideoTransformationTypes = null;
  protected static Gson gson = null;

  public AdCreativeDegreesOfFreedomSpec() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeDegreesOfFreedomSpec loadJSON(String json, APIContext context, String header) {
    AdCreativeDegreesOfFreedomSpec adCreativeDegreesOfFreedomSpec = getGson().fromJson(json, AdCreativeDegreesOfFreedomSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeDegreesOfFreedomSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    adCreativeDegreesOfFreedomSpec.context = context;
    adCreativeDegreesOfFreedomSpec.rawValue = json;
    adCreativeDegreesOfFreedomSpec.header = header;
    return adCreativeDegreesOfFreedomSpec;
  }

  public static APINodeList<AdCreativeDegreesOfFreedomSpec> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdCreativeDegreesOfFreedomSpec> adCreativeDegreesOfFreedomSpecs = new APINodeList<AdCreativeDegreesOfFreedomSpec>(request, json, header);
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
          adCreativeDegreesOfFreedomSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adCreativeDegreesOfFreedomSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeDegreesOfFreedomSpecs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeDegreesOfFreedomSpecs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeDegreesOfFreedomSpecs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeDegreesOfFreedomSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adCreativeDegreesOfFreedomSpecs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeDegreesOfFreedomSpecs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adCreativeDegreesOfFreedomSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeDegreesOfFreedomSpecs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adCreativeDegreesOfFreedomSpecs;
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
              adCreativeDegreesOfFreedomSpecs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeDegreesOfFreedomSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeDegreesOfFreedomSpecs.clear();
          adCreativeDegreesOfFreedomSpecs.add(loadJSON(json, context, header));
          return adCreativeDegreesOfFreedomSpecs;
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


  public String getFieldAdHandleType() {
    return mAdHandleType;
  }

  public AdCreativeDegreesOfFreedomSpec setFieldAdHandleType(String value) {
    this.mAdHandleType = value;
    return this;
  }

  public AdCreativeFeaturesSpec getFieldCreativeFeaturesSpec() {
    return mCreativeFeaturesSpec;
  }

  public AdCreativeDegreesOfFreedomSpec setFieldCreativeFeaturesSpec(AdCreativeFeaturesSpec value) {
    this.mCreativeFeaturesSpec = value;
    return this;
  }

  public AdCreativeDegreesOfFreedomSpec setFieldCreativeFeaturesSpec(String value) {
    Type type = new TypeToken<AdCreativeFeaturesSpec>(){}.getType();
    this.mCreativeFeaturesSpec = AdCreativeFeaturesSpec.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldDegreesOfFreedomType() {
    return mDegreesOfFreedomType;
  }

  public AdCreativeDegreesOfFreedomSpec setFieldDegreesOfFreedomType(String value) {
    this.mDegreesOfFreedomType = value;
    return this;
  }

  public List<String> getFieldImageTransformationTypes() {
    return mImageTransformationTypes;
  }

  public AdCreativeDegreesOfFreedomSpec setFieldImageTransformationTypes(List<String> value) {
    this.mImageTransformationTypes = value;
    return this;
  }

  public String getFieldMultiMediaTransformationType() {
    return mMultiMediaTransformationType;
  }

  public AdCreativeDegreesOfFreedomSpec setFieldMultiMediaTransformationType(String value) {
    this.mMultiMediaTransformationType = value;
    return this;
  }

  public List<String> getFieldStoriesTransformationTypes() {
    return mStoriesTransformationTypes;
  }

  public AdCreativeDegreesOfFreedomSpec setFieldStoriesTransformationTypes(List<String> value) {
    this.mStoriesTransformationTypes = value;
    return this;
  }

  public List<String> getFieldTextTransformationTypes() {
    return mTextTransformationTypes;
  }

  public AdCreativeDegreesOfFreedomSpec setFieldTextTransformationTypes(List<String> value) {
    this.mTextTransformationTypes = value;
    return this;
  }

  public List<String> getFieldVideoTransformationTypes() {
    return mVideoTransformationTypes;
  }

  public AdCreativeDegreesOfFreedomSpec setFieldVideoTransformationTypes(List<String> value) {
    this.mVideoTransformationTypes = value;
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

  public AdCreativeDegreesOfFreedomSpec copyFrom(AdCreativeDegreesOfFreedomSpec instance) {
    this.mAdHandleType = instance.mAdHandleType;
    this.mCreativeFeaturesSpec = instance.mCreativeFeaturesSpec;
    this.mDegreesOfFreedomType = instance.mDegreesOfFreedomType;
    this.mImageTransformationTypes = instance.mImageTransformationTypes;
    this.mMultiMediaTransformationType = instance.mMultiMediaTransformationType;
    this.mStoriesTransformationTypes = instance.mStoriesTransformationTypes;
    this.mTextTransformationTypes = instance.mTextTransformationTypes;
    this.mVideoTransformationTypes = instance.mVideoTransformationTypes;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeDegreesOfFreedomSpec> getParser() {
    return new APIRequest.ResponseParser<AdCreativeDegreesOfFreedomSpec>() {
      public APINodeList<AdCreativeDegreesOfFreedomSpec> parseResponse(String response, APIContext context, APIRequest<AdCreativeDegreesOfFreedomSpec> request, String header) throws MalformedResponseException {
        return AdCreativeDegreesOfFreedomSpec.parseResponse(response, context, request, header);
      }
    };
  }
}
