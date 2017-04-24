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
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdCreativeLinkDataCallToActionValue extends APINode {
  @SerializedName("app_destination")
  private String mAppDestination = null;
  @SerializedName("app_link")
  private String mAppLink = null;
  @SerializedName("application")
  private String mApplication = null;
  @SerializedName("event_id")
  private String mEventId = null;
  @SerializedName("lead_gen_form_id")
  private String mLeadGenFormId = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("link_caption")
  private String mLinkCaption = null;
  @SerializedName("link_format")
  private String mLinkFormat = null;
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
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeLinkDataCallToActionValue.context = context;
    adCreativeLinkDataCallToActionValue.rawValue = json;
    return adCreativeLinkDataCallToActionValue;
  }

  public static APINodeList<AdCreativeLinkDataCallToActionValue> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataCallToActionValue> adCreativeLinkDataCallToActionValues = new APINodeList<AdCreativeLinkDataCallToActionValue>(request, json);
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
          adCreativeLinkDataCallToActionValues.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeLinkDataCallToActionValues;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adCreativeLinkDataCallToActionValues.setPaging(before, after);
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
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  adCreativeLinkDataCallToActionValues.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataCallToActionValues.add(loadJSON(obj.toString(), context));
            }
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
              adCreativeLinkDataCallToActionValues.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDataCallToActionValues;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDataCallToActionValues.clear();
          adCreativeLinkDataCallToActionValues.add(loadJSON(json, context));
          return adCreativeLinkDataCallToActionValues;
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


  public String getFieldAppDestination() {
    return mAppDestination;
  }

  public AdCreativeLinkDataCallToActionValue setFieldAppDestination(String value) {
    this.mAppDestination = value;
    return this;
  }

  public String getFieldAppLink() {
    return mAppLink;
  }

  public AdCreativeLinkDataCallToActionValue setFieldAppLink(String value) {
    this.mAppLink = value;
    return this;
  }

  public String getFieldApplication() {
    return mApplication;
  }

  public AdCreativeLinkDataCallToActionValue setFieldApplication(String value) {
    this.mApplication = value;
    return this;
  }

  public String getFieldEventId() {
    return mEventId;
  }

  public AdCreativeLinkDataCallToActionValue setFieldEventId(String value) {
    this.mEventId = value;
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

  public String getFieldLinkCaption() {
    return mLinkCaption;
  }

  public AdCreativeLinkDataCallToActionValue setFieldLinkCaption(String value) {
    this.mLinkCaption = value;
    return this;
  }

  public String getFieldLinkFormat() {
    return mLinkFormat;
  }

  public AdCreativeLinkDataCallToActionValue setFieldLinkFormat(String value) {
    this.mLinkFormat = value;
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
    this.mAppDestination = instance.mAppDestination;
    this.mAppLink = instance.mAppLink;
    this.mApplication = instance.mApplication;
    this.mEventId = instance.mEventId;
    this.mLeadGenFormId = instance.mLeadGenFormId;
    this.mLink = instance.mLink;
    this.mLinkCaption = instance.mLinkCaption;
    this.mLinkFormat = instance.mLinkFormat;
    this.mPage = instance.mPage;
    this.mProductLink = instance.mProductLink;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataCallToActionValue> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataCallToActionValue>() {
      public APINodeList<AdCreativeLinkDataCallToActionValue> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataCallToActionValue> request) throws MalformedResponseException {
        return AdCreativeLinkDataCallToActionValue.parseResponse(response, context, request);
      }
    };
  }
}
