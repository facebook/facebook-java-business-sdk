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


public class AdCreativeLinkDataCallToActionValue extends APINode {
  @SerializedName("application")
  private String mApplication = null;
  @SerializedName("app_link")
  private String mAppLink = null;
  @SerializedName("link_caption")
  private String mLinkCaption = null;
  @SerializedName("lead_gen_form_id")
  private String mLeadGenFormId = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("link_description")
  private String mLinkDescription = null;
  @SerializedName("link_title")
  private String mLinkTitle = null;
  @SerializedName("page")
  private String mPage = null;
  @SerializedName("product_link")
  private String mProductLink = null;
  protected static Gson gson = null;

  public AdCreativeLinkDataCallToActionValue() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeLinkDataCallToActionValue loadJSON(String json, APIContext context) {
    AdCreativeLinkDataCallToActionValue adCreativeLinkDataCallToActionValue = getGson().fromJson(json, AdCreativeLinkDataCallToActionValue.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataCallToActionValue.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeLinkDataCallToActionValue.mContext = context;
    adCreativeLinkDataCallToActionValue.rawValue = json;
    return adCreativeLinkDataCallToActionValue;
  }

  public static APINodeList<AdCreativeLinkDataCallToActionValue> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdCreativeLinkDataCallToActionValue> adCreativeLinkDataCallToActionValues = new APINodeList<AdCreativeLinkDataCallToActionValue>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adCreativeLinkDataCallToActionValues.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeLinkDataCallToActionValues;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adCreativeLinkDataCallToActionValues.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataCallToActionValues.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            adCreativeLinkDataCallToActionValues.add(loadJSON(obj.toString(), context));
          }
          return adCreativeLinkDataCallToActionValues;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataCallToActionValues.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativeLinkDataCallToActionValues;
        } else {
          // Fifth, check if it's pure JsonObject
          adCreativeLinkDataCallToActionValues.add(loadJSON(json, context));
          return adCreativeLinkDataCallToActionValues;
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


  public String getFieldApplication() {
    return mApplication;
  }

  public AdCreativeLinkDataCallToActionValue setFieldApplication(String value) {
    this.mApplication = value;
    return this;
  }

  public String getFieldAppLink() {
    return mAppLink;
  }

  public AdCreativeLinkDataCallToActionValue setFieldAppLink(String value) {
    this.mAppLink = value;
    return this;
  }

  public String getFieldLinkCaption() {
    return mLinkCaption;
  }

  public AdCreativeLinkDataCallToActionValue setFieldLinkCaption(String value) {
    this.mLinkCaption = value;
    return this;
  }

  public String getFieldLeadGenFormId() {
    return mLeadGenFormId;
  }

  public AdCreativeLinkDataCallToActionValue setFieldLeadGenFormId(String value) {
    this.mLeadGenFormId = value;
    return this;
  }

  public String getFieldLink() {
    return mLink;
  }

  public AdCreativeLinkDataCallToActionValue setFieldLink(String value) {
    this.mLink = value;
    return this;
  }

  public String getFieldLinkDescription() {
    return mLinkDescription;
  }

  public AdCreativeLinkDataCallToActionValue setFieldLinkDescription(String value) {
    this.mLinkDescription = value;
    return this;
  }

  public String getFieldLinkTitle() {
    return mLinkTitle;
  }

  public AdCreativeLinkDataCallToActionValue setFieldLinkTitle(String value) {
    this.mLinkTitle = value;
    return this;
  }

  public String getFieldPage() {
    return mPage;
  }

  public AdCreativeLinkDataCallToActionValue setFieldPage(String value) {
    this.mPage = value;
    return this;
  }

  public String getFieldProductLink() {
    return mProductLink;
  }

  public AdCreativeLinkDataCallToActionValue setFieldProductLink(String value) {
    this.mProductLink = value;
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

  public AdCreativeLinkDataCallToActionValue copyFrom(AdCreativeLinkDataCallToActionValue instance) {
    this.mApplication = instance.mApplication;
    this.mAppLink = instance.mAppLink;
    this.mLinkCaption = instance.mLinkCaption;
    this.mLeadGenFormId = instance.mLeadGenFormId;
    this.mLink = instance.mLink;
    this.mLinkDescription = instance.mLinkDescription;
    this.mLinkTitle = instance.mLinkTitle;
    this.mPage = instance.mPage;
    this.mProductLink = instance.mProductLink;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}