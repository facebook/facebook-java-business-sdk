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
public class ConversionActionQuery extends APINode {
  @SerializedName("action.type")
  private List<Object> mActionType = null;
  @SerializedName("application")
  private List<Object> mApplication = null;
  @SerializedName("conversion_id")
  private List<String> mConversionId = null;
  @SerializedName("creative")
  private List<Object> mCreative = null;
  @SerializedName("dataset")
  private List<String> mDataset = null;
  @SerializedName("event")
  private List<String> mEvent = null;
  @SerializedName("event.creator")
  private List<String> mEventCreator = null;
  @SerializedName("event_type")
  private List<String> mEventType = null;
  @SerializedName("fb_pixel")
  private List<String> mFbPixel = null;
  @SerializedName("fb_pixel_event")
  private List<String> mFbPixelEvent = null;
  @SerializedName("leadgen")
  private List<String> mLeadgen = null;
  @SerializedName("object")
  private List<String> mObject = null;
  @SerializedName("object.domain")
  private List<String> mObjectDomain = null;
  @SerializedName("offer")
  private List<String> mOffer = null;
  @SerializedName("offer.creator")
  private List<String> mOfferCreator = null;
  @SerializedName("offsite_pixel")
  private List<String> mOffsitePixel = null;
  @SerializedName("page")
  private List<String> mPage = null;
  @SerializedName("page.parent")
  private List<String> mPageParent = null;
  @SerializedName("post")
  private List<String> mPost = null;
  @SerializedName("post.object")
  private List<String> mPostObject = null;
  @SerializedName("post.object.wall")
  private List<String> mPostObjectWall = null;
  @SerializedName("post.wall")
  private List<String> mPostWall = null;
  @SerializedName("question")
  private List<String> mQuestion = null;
  @SerializedName("question.creator")
  private List<String> mQuestionCreator = null;
  @SerializedName("response")
  private List<String> mResponse = null;
  @SerializedName("subtype")
  private List<String> mSubtype = null;
  protected static Gson gson = null;

  public ConversionActionQuery() {
  }

  public String getId() {
    return null;
  }
  public static ConversionActionQuery loadJSON(String json, APIContext context, String header) {
    ConversionActionQuery conversionActionQuery = getGson().fromJson(json, ConversionActionQuery.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(conversionActionQuery.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    conversionActionQuery.context = context;
    conversionActionQuery.rawValue = json;
    conversionActionQuery.header = header;
    return conversionActionQuery;
  }

  public static APINodeList<ConversionActionQuery> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ConversionActionQuery> conversionActionQuerys = new APINodeList<ConversionActionQuery>(request, json, header);
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
          conversionActionQuerys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return conversionActionQuerys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                conversionActionQuerys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            conversionActionQuerys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              conversionActionQuerys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              conversionActionQuerys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  conversionActionQuerys.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              conversionActionQuerys.add(loadJSON(obj.toString(), context, header));
            }
          }
          return conversionActionQuerys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              conversionActionQuerys.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return conversionActionQuerys;
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
              conversionActionQuerys.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return conversionActionQuerys;
          }

          // Sixth, check if it's pure JsonObject
          conversionActionQuerys.clear();
          conversionActionQuerys.add(loadJSON(json, context, header));
          return conversionActionQuerys;
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


  public List<Object> getFieldActionType() {
    return mActionType;
  }

  public ConversionActionQuery setFieldActionType(List<Object> value) {
    this.mActionType = value;
    return this;
  }

  public List<Object> getFieldApplication() {
    return mApplication;
  }

  public ConversionActionQuery setFieldApplication(List<Object> value) {
    this.mApplication = value;
    return this;
  }

  public List<String> getFieldConversionId() {
    return mConversionId;
  }

  public ConversionActionQuery setFieldConversionId(List<String> value) {
    this.mConversionId = value;
    return this;
  }

  public List<Object> getFieldCreative() {
    return mCreative;
  }

  public ConversionActionQuery setFieldCreative(List<Object> value) {
    this.mCreative = value;
    return this;
  }

  public List<String> getFieldDataset() {
    return mDataset;
  }

  public ConversionActionQuery setFieldDataset(List<String> value) {
    this.mDataset = value;
    return this;
  }

  public List<String> getFieldEvent() {
    return mEvent;
  }

  public ConversionActionQuery setFieldEvent(List<String> value) {
    this.mEvent = value;
    return this;
  }

  public List<String> getFieldEventCreator() {
    return mEventCreator;
  }

  public ConversionActionQuery setFieldEventCreator(List<String> value) {
    this.mEventCreator = value;
    return this;
  }

  public List<String> getFieldEventType() {
    return mEventType;
  }

  public ConversionActionQuery setFieldEventType(List<String> value) {
    this.mEventType = value;
    return this;
  }

  public List<String> getFieldFbPixel() {
    return mFbPixel;
  }

  public ConversionActionQuery setFieldFbPixel(List<String> value) {
    this.mFbPixel = value;
    return this;
  }

  public List<String> getFieldFbPixelEvent() {
    return mFbPixelEvent;
  }

  public ConversionActionQuery setFieldFbPixelEvent(List<String> value) {
    this.mFbPixelEvent = value;
    return this;
  }

  public List<String> getFieldLeadgen() {
    return mLeadgen;
  }

  public ConversionActionQuery setFieldLeadgen(List<String> value) {
    this.mLeadgen = value;
    return this;
  }

  public List<String> getFieldObject() {
    return mObject;
  }

  public ConversionActionQuery setFieldObject(List<String> value) {
    this.mObject = value;
    return this;
  }

  public List<String> getFieldObjectDomain() {
    return mObjectDomain;
  }

  public ConversionActionQuery setFieldObjectDomain(List<String> value) {
    this.mObjectDomain = value;
    return this;
  }

  public List<String> getFieldOffer() {
    return mOffer;
  }

  public ConversionActionQuery setFieldOffer(List<String> value) {
    this.mOffer = value;
    return this;
  }

  public List<String> getFieldOfferCreator() {
    return mOfferCreator;
  }

  public ConversionActionQuery setFieldOfferCreator(List<String> value) {
    this.mOfferCreator = value;
    return this;
  }

  public List<String> getFieldOffsitePixel() {
    return mOffsitePixel;
  }

  public ConversionActionQuery setFieldOffsitePixel(List<String> value) {
    this.mOffsitePixel = value;
    return this;
  }

  public List<String> getFieldPage() {
    return mPage;
  }

  public ConversionActionQuery setFieldPage(List<String> value) {
    this.mPage = value;
    return this;
  }

  public List<String> getFieldPageParent() {
    return mPageParent;
  }

  public ConversionActionQuery setFieldPageParent(List<String> value) {
    this.mPageParent = value;
    return this;
  }

  public List<String> getFieldPost() {
    return mPost;
  }

  public ConversionActionQuery setFieldPost(List<String> value) {
    this.mPost = value;
    return this;
  }

  public List<String> getFieldPostObject() {
    return mPostObject;
  }

  public ConversionActionQuery setFieldPostObject(List<String> value) {
    this.mPostObject = value;
    return this;
  }

  public List<String> getFieldPostObjectWall() {
    return mPostObjectWall;
  }

  public ConversionActionQuery setFieldPostObjectWall(List<String> value) {
    this.mPostObjectWall = value;
    return this;
  }

  public List<String> getFieldPostWall() {
    return mPostWall;
  }

  public ConversionActionQuery setFieldPostWall(List<String> value) {
    this.mPostWall = value;
    return this;
  }

  public List<String> getFieldQuestion() {
    return mQuestion;
  }

  public ConversionActionQuery setFieldQuestion(List<String> value) {
    this.mQuestion = value;
    return this;
  }

  public List<String> getFieldQuestionCreator() {
    return mQuestionCreator;
  }

  public ConversionActionQuery setFieldQuestionCreator(List<String> value) {
    this.mQuestionCreator = value;
    return this;
  }

  public List<String> getFieldResponse() {
    return mResponse;
  }

  public ConversionActionQuery setFieldResponse(List<String> value) {
    this.mResponse = value;
    return this;
  }

  public List<String> getFieldSubtype() {
    return mSubtype;
  }

  public ConversionActionQuery setFieldSubtype(List<String> value) {
    this.mSubtype = value;
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

  public ConversionActionQuery copyFrom(ConversionActionQuery instance) {
    this.mActionType = instance.mActionType;
    this.mApplication = instance.mApplication;
    this.mConversionId = instance.mConversionId;
    this.mCreative = instance.mCreative;
    this.mDataset = instance.mDataset;
    this.mEvent = instance.mEvent;
    this.mEventCreator = instance.mEventCreator;
    this.mEventType = instance.mEventType;
    this.mFbPixel = instance.mFbPixel;
    this.mFbPixelEvent = instance.mFbPixelEvent;
    this.mLeadgen = instance.mLeadgen;
    this.mObject = instance.mObject;
    this.mObjectDomain = instance.mObjectDomain;
    this.mOffer = instance.mOffer;
    this.mOfferCreator = instance.mOfferCreator;
    this.mOffsitePixel = instance.mOffsitePixel;
    this.mPage = instance.mPage;
    this.mPageParent = instance.mPageParent;
    this.mPost = instance.mPost;
    this.mPostObject = instance.mPostObject;
    this.mPostObjectWall = instance.mPostObjectWall;
    this.mPostWall = instance.mPostWall;
    this.mQuestion = instance.mQuestion;
    this.mQuestionCreator = instance.mQuestionCreator;
    this.mResponse = instance.mResponse;
    this.mSubtype = instance.mSubtype;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ConversionActionQuery> getParser() {
    return new APIRequest.ResponseParser<ConversionActionQuery>() {
      public APINodeList<ConversionActionQuery> parseResponse(String response, APIContext context, APIRequest<ConversionActionQuery> request, String header) throws MalformedResponseException {
        return ConversionActionQuery.parseResponse(response, context, request, header);
      }
    };
  }
}
