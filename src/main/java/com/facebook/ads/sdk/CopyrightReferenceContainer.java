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
public class CopyrightReferenceContainer extends APINode {
  @SerializedName("content_type")
  private String mContentType = null;
  @SerializedName("copyright_creation_time")
  private String mCopyrightCreationTime = null;
  @SerializedName("download_hd_url")
  private String mDownloadHdUrl = null;
  @SerializedName("duration_in_sec")
  private Double mDurationInSec = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("iswc")
  private String mIswc = null;
  @SerializedName("metadata")
  private Object mMetadata = null;
  @SerializedName("published_time")
  private String mPublishedTime = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("universal_content_id")
  private String mUniversalContentId = null;
  @SerializedName("writer_names")
  private List<String> mWriterNames = null;
  protected static Gson gson = null;

  public CopyrightReferenceContainer() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static CopyrightReferenceContainer loadJSON(String json, APIContext context, String header) {
    CopyrightReferenceContainer copyrightReferenceContainer = getGson().fromJson(json, CopyrightReferenceContainer.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(copyrightReferenceContainer.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    copyrightReferenceContainer.context = context;
    copyrightReferenceContainer.rawValue = json;
    copyrightReferenceContainer.header = header;
    return copyrightReferenceContainer;
  }

  public static APINodeList<CopyrightReferenceContainer> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CopyrightReferenceContainer> copyrightReferenceContainers = new APINodeList<CopyrightReferenceContainer>(request, json, header);
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
          copyrightReferenceContainers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return copyrightReferenceContainers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                copyrightReferenceContainers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            copyrightReferenceContainers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              copyrightReferenceContainers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              copyrightReferenceContainers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  copyrightReferenceContainers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              copyrightReferenceContainers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return copyrightReferenceContainers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              copyrightReferenceContainers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return copyrightReferenceContainers;
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
              copyrightReferenceContainers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return copyrightReferenceContainers;
          }

          // Sixth, check if it's pure JsonObject
          copyrightReferenceContainers.clear();
          copyrightReferenceContainers.add(loadJSON(json, context, header));
          return copyrightReferenceContainers;
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


  public String getFieldContentType() {
    return mContentType;
  }

  public CopyrightReferenceContainer setFieldContentType(String value) {
    this.mContentType = value;
    return this;
  }

  public String getFieldCopyrightCreationTime() {
    return mCopyrightCreationTime;
  }

  public CopyrightReferenceContainer setFieldCopyrightCreationTime(String value) {
    this.mCopyrightCreationTime = value;
    return this;
  }

  public String getFieldDownloadHdUrl() {
    return mDownloadHdUrl;
  }

  public CopyrightReferenceContainer setFieldDownloadHdUrl(String value) {
    this.mDownloadHdUrl = value;
    return this;
  }

  public Double getFieldDurationInSec() {
    return mDurationInSec;
  }

  public CopyrightReferenceContainer setFieldDurationInSec(Double value) {
    this.mDurationInSec = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public CopyrightReferenceContainer setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldIswc() {
    return mIswc;
  }

  public CopyrightReferenceContainer setFieldIswc(String value) {
    this.mIswc = value;
    return this;
  }

  public Object getFieldMetadata() {
    return mMetadata;
  }

  public CopyrightReferenceContainer setFieldMetadata(Object value) {
    this.mMetadata = value;
    return this;
  }

  public String getFieldPublishedTime() {
    return mPublishedTime;
  }

  public CopyrightReferenceContainer setFieldPublishedTime(String value) {
    this.mPublishedTime = value;
    return this;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }

  public CopyrightReferenceContainer setFieldThumbnailUrl(String value) {
    this.mThumbnailUrl = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public CopyrightReferenceContainer setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public String getFieldUniversalContentId() {
    return mUniversalContentId;
  }

  public CopyrightReferenceContainer setFieldUniversalContentId(String value) {
    this.mUniversalContentId = value;
    return this;
  }

  public List<String> getFieldWriterNames() {
    return mWriterNames;
  }

  public CopyrightReferenceContainer setFieldWriterNames(List<String> value) {
    this.mWriterNames = value;
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

  public CopyrightReferenceContainer copyFrom(CopyrightReferenceContainer instance) {
    this.mContentType = instance.mContentType;
    this.mCopyrightCreationTime = instance.mCopyrightCreationTime;
    this.mDownloadHdUrl = instance.mDownloadHdUrl;
    this.mDurationInSec = instance.mDurationInSec;
    this.mId = instance.mId;
    this.mIswc = instance.mIswc;
    this.mMetadata = instance.mMetadata;
    this.mPublishedTime = instance.mPublishedTime;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mTitle = instance.mTitle;
    this.mUniversalContentId = instance.mUniversalContentId;
    this.mWriterNames = instance.mWriterNames;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CopyrightReferenceContainer> getParser() {
    return new APIRequest.ResponseParser<CopyrightReferenceContainer>() {
      public APINodeList<CopyrightReferenceContainer> parseResponse(String response, APIContext context, APIRequest<CopyrightReferenceContainer> request, String header) throws MalformedResponseException {
        return CopyrightReferenceContainer.parseResponse(response, context, request, header);
      }
    };
  }
}
