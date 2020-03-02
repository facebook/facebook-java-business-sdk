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

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
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
public class NativeOfferDiscount extends APINode {
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("override")
  private String mOverride = null;
  @SerializedName("text")
  private String mText = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("value1")
  private Double mValue1 = null;
  @SerializedName("value2")
  private Double mValue2 = null;
  protected static Gson gson = null;

  public NativeOfferDiscount() {
  }

  public String getId() {
    return null;
  }
  public static NativeOfferDiscount loadJSON(String json, APIContext context, String header) {
    NativeOfferDiscount nativeOfferDiscount = getGson().fromJson(json, NativeOfferDiscount.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(nativeOfferDiscount.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    nativeOfferDiscount.context = context;
    nativeOfferDiscount.rawValue = json;
    nativeOfferDiscount.header = header;
    return nativeOfferDiscount;
  }

  public static APINodeList<NativeOfferDiscount> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<NativeOfferDiscount> nativeOfferDiscounts = new APINodeList<NativeOfferDiscount>(request, json, header);
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
          nativeOfferDiscounts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return nativeOfferDiscounts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                nativeOfferDiscounts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            nativeOfferDiscounts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              nativeOfferDiscounts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              nativeOfferDiscounts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  nativeOfferDiscounts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              nativeOfferDiscounts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return nativeOfferDiscounts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              nativeOfferDiscounts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return nativeOfferDiscounts;
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
              nativeOfferDiscounts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return nativeOfferDiscounts;
          }

          // Sixth, check if it's pure JsonObject
          nativeOfferDiscounts.clear();
          nativeOfferDiscounts.add(loadJSON(json, context, header));
          return nativeOfferDiscounts;
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


  public String getFieldCurrency() {
    return mCurrency;
  }

  public NativeOfferDiscount setFieldCurrency(String value) {
    this.mCurrency = value;
    return this;
  }

  public String getFieldOverride() {
    return mOverride;
  }

  public NativeOfferDiscount setFieldOverride(String value) {
    this.mOverride = value;
    return this;
  }

  public String getFieldText() {
    return mText;
  }

  public NativeOfferDiscount setFieldText(String value) {
    this.mText = value;
    return this;
  }

  public String getFieldType() {
    return mType;
  }

  public NativeOfferDiscount setFieldType(String value) {
    this.mType = value;
    return this;
  }

  public Double getFieldValue1() {
    return mValue1;
  }

  public NativeOfferDiscount setFieldValue1(Double value) {
    this.mValue1 = value;
    return this;
  }

  public Double getFieldValue2() {
    return mValue2;
  }

  public NativeOfferDiscount setFieldValue2(Double value) {
    this.mValue2 = value;
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

  public NativeOfferDiscount copyFrom(NativeOfferDiscount instance) {
    this.mCurrency = instance.mCurrency;
    this.mOverride = instance.mOverride;
    this.mText = instance.mText;
    this.mType = instance.mType;
    this.mValue1 = instance.mValue1;
    this.mValue2 = instance.mValue2;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<NativeOfferDiscount> getParser() {
    return new APIRequest.ResponseParser<NativeOfferDiscount>() {
      public APINodeList<NativeOfferDiscount> parseResponse(String response, APIContext context, APIRequest<NativeOfferDiscount> request, String header) throws MalformedResponseException {
        return NativeOfferDiscount.parseResponse(response, context, request, header);
      }
    };
  }
}
