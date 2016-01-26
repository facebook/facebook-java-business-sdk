/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class PartnerCategory extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("country")
  private String mCountry = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("details")
  private String mDetails = null;
  @SerializedName("source")
  private String mSource = null;
  @SerializedName("parent_category")
  private String mParentCategory = null;
  @SerializedName("targeting_type")
  private String mTargetingType = null;
  @SerializedName("is_private")
  private Boolean mIsPrivate = null;
  @SerializedName("approximate_count")
  private Long mApproximateCount = null;
  @SerializedName("status")
  private String mStatus = null;
  protected static Gson gson = null;

  public PartnerCategory() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static PartnerCategory loadJSON(String json, APIContext context) {
    PartnerCategory partnerCategory = getGson().fromJson(json, PartnerCategory.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(partnerCategory.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    partnerCategory.mContext = context;
    partnerCategory.rawValue = json;
    return partnerCategory;
  }

  public static APINodeList<PartnerCategory> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<PartnerCategory> partnerCategorys = new APINodeList<PartnerCategory>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          partnerCategorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return partnerCategorys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            partnerCategorys.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              partnerCategorys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            partnerCategorys.add(loadJSON(obj.toString(), context));
          }
          return partnerCategorys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              partnerCategorys.add(loadJSON(entry.getValue().toString(), context));
          }
          return partnerCategorys;
        } else {
          // Fifth, check if it's pure JsonObject
          partnerCategorys.add(loadJSON(json, context));
          return partnerCategorys;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public String getFieldId() {
    return mId;
  }

  public PartnerCategory setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public PartnerCategory setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldCountry() {
    return mCountry;
  }

  public PartnerCategory setFieldCountry(String value) {
    this.mCountry = value;
    return this;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public PartnerCategory setFieldDescription(String value) {
    this.mDescription = value;
    return this;
  }

  public String getFieldDetails() {
    return mDetails;
  }

  public PartnerCategory setFieldDetails(String value) {
    this.mDetails = value;
    return this;
  }

  public String getFieldSource() {
    return mSource;
  }

  public PartnerCategory setFieldSource(String value) {
    this.mSource = value;
    return this;
  }

  public String getFieldParentCategory() {
    return mParentCategory;
  }

  public PartnerCategory setFieldParentCategory(String value) {
    this.mParentCategory = value;
    return this;
  }

  public String getFieldTargetingType() {
    return mTargetingType;
  }

  public PartnerCategory setFieldTargetingType(String value) {
    this.mTargetingType = value;
    return this;
  }

  public Boolean getFieldIsPrivate() {
    return mIsPrivate;
  }

  public PartnerCategory setFieldIsPrivate(Boolean value) {
    this.mIsPrivate = value;
    return this;
  }

  public Long getFieldApproximateCount() {
    return mApproximateCount;
  }

  public PartnerCategory setFieldApproximateCount(Long value) {
    this.mApproximateCount = value;
    return this;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public PartnerCategory setFieldStatus(String value) {
    this.mStatus = value;
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

  public PartnerCategory copyFrom(PartnerCategory instance) {
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mCountry = instance.mCountry;
    this.mDescription = instance.mDescription;
    this.mDetails = instance.mDetails;
    this.mSource = instance.mSource;
    this.mParentCategory = instance.mParentCategory;
    this.mTargetingType = instance.mTargetingType;
    this.mIsPrivate = instance.mIsPrivate;
    this.mApproximateCount = instance.mApproximateCount;
    this.mStatus = instance.mStatus;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PartnerCategory> getParser() {
    return new APIRequest.ResponseParser<PartnerCategory>() {
      public APINodeList<PartnerCategory> parseResponse(String response, APIContext context, APIRequest<PartnerCategory> request) {
        return PartnerCategory.parseResponse(response, context, request);
      }
    };
  }
}