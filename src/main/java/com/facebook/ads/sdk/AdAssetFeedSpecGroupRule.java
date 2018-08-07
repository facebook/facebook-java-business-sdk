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
public class AdAssetFeedSpecGroupRule extends APINode {
  @SerializedName("body_label")
  private AdAssetFeedSpecAssetLabel mBodyLabel = null;
  @SerializedName("caption_label")
  private AdAssetFeedSpecAssetLabel mCaptionLabel = null;
  @SerializedName("description_label")
  private AdAssetFeedSpecAssetLabel mDescriptionLabel = null;
  @SerializedName("image_label")
  private AdAssetFeedSpecAssetLabel mImageLabel = null;
  @SerializedName("link_url_label")
  private AdAssetFeedSpecAssetLabel mLinkUrlLabel = null;
  @SerializedName("title_label")
  private AdAssetFeedSpecAssetLabel mTitleLabel = null;
  @SerializedName("video_label")
  private AdAssetFeedSpecAssetLabel mVideoLabel = null;
  protected static Gson gson = null;

  public AdAssetFeedSpecGroupRule() {
  }

  public String getId() {
    return null;
  }
  public static AdAssetFeedSpecGroupRule loadJSON(String json, APIContext context) {
    AdAssetFeedSpecGroupRule adAssetFeedSpecGroupRule = getGson().fromJson(json, AdAssetFeedSpecGroupRule.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAssetFeedSpecGroupRule.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAssetFeedSpecGroupRule.context = context;
    adAssetFeedSpecGroupRule.rawValue = json;
    return adAssetFeedSpecGroupRule;
  }

  public static APINodeList<AdAssetFeedSpecGroupRule> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAssetFeedSpecGroupRule> adAssetFeedSpecGroupRules = new APINodeList<AdAssetFeedSpecGroupRule>(request, json);
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
          adAssetFeedSpecGroupRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAssetFeedSpecGroupRules;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAssetFeedSpecGroupRules.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAssetFeedSpecGroupRules.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAssetFeedSpecGroupRules.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAssetFeedSpecGroupRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAssetFeedSpecGroupRules.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAssetFeedSpecGroupRules.add(loadJSON(obj.toString(), context));
            }
          }
          return adAssetFeedSpecGroupRules;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAssetFeedSpecGroupRules.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAssetFeedSpecGroupRules;
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
              adAssetFeedSpecGroupRules.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAssetFeedSpecGroupRules;
          }

          // Sixth, check if it's pure JsonObject
          adAssetFeedSpecGroupRules.clear();
          adAssetFeedSpecGroupRules.add(loadJSON(json, context));
          return adAssetFeedSpecGroupRules;
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


  public AdAssetFeedSpecAssetLabel getFieldBodyLabel() {
    return mBodyLabel;
  }

  public AdAssetFeedSpecGroupRule setFieldBodyLabel(AdAssetFeedSpecAssetLabel value) {
    this.mBodyLabel = value;
    return this;
  }

  public AdAssetFeedSpecGroupRule setFieldBodyLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mBodyLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldCaptionLabel() {
    return mCaptionLabel;
  }

  public AdAssetFeedSpecGroupRule setFieldCaptionLabel(AdAssetFeedSpecAssetLabel value) {
    this.mCaptionLabel = value;
    return this;
  }

  public AdAssetFeedSpecGroupRule setFieldCaptionLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mCaptionLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldDescriptionLabel() {
    return mDescriptionLabel;
  }

  public AdAssetFeedSpecGroupRule setFieldDescriptionLabel(AdAssetFeedSpecAssetLabel value) {
    this.mDescriptionLabel = value;
    return this;
  }

  public AdAssetFeedSpecGroupRule setFieldDescriptionLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mDescriptionLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldImageLabel() {
    return mImageLabel;
  }

  public AdAssetFeedSpecGroupRule setFieldImageLabel(AdAssetFeedSpecAssetLabel value) {
    this.mImageLabel = value;
    return this;
  }

  public AdAssetFeedSpecGroupRule setFieldImageLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mImageLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldLinkUrlLabel() {
    return mLinkUrlLabel;
  }

  public AdAssetFeedSpecGroupRule setFieldLinkUrlLabel(AdAssetFeedSpecAssetLabel value) {
    this.mLinkUrlLabel = value;
    return this;
  }

  public AdAssetFeedSpecGroupRule setFieldLinkUrlLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mLinkUrlLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldTitleLabel() {
    return mTitleLabel;
  }

  public AdAssetFeedSpecGroupRule setFieldTitleLabel(AdAssetFeedSpecAssetLabel value) {
    this.mTitleLabel = value;
    return this;
  }

  public AdAssetFeedSpecGroupRule setFieldTitleLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mTitleLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
    return this;
  }
  public AdAssetFeedSpecAssetLabel getFieldVideoLabel() {
    return mVideoLabel;
  }

  public AdAssetFeedSpecGroupRule setFieldVideoLabel(AdAssetFeedSpecAssetLabel value) {
    this.mVideoLabel = value;
    return this;
  }

  public AdAssetFeedSpecGroupRule setFieldVideoLabel(String value) {
    Type type = new TypeToken<AdAssetFeedSpecAssetLabel>(){}.getType();
    this.mVideoLabel = AdAssetFeedSpecAssetLabel.getGson().fromJson(value, type);
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

  public AdAssetFeedSpecGroupRule copyFrom(AdAssetFeedSpecGroupRule instance) {
    this.mBodyLabel = instance.mBodyLabel;
    this.mCaptionLabel = instance.mCaptionLabel;
    this.mDescriptionLabel = instance.mDescriptionLabel;
    this.mImageLabel = instance.mImageLabel;
    this.mLinkUrlLabel = instance.mLinkUrlLabel;
    this.mTitleLabel = instance.mTitleLabel;
    this.mVideoLabel = instance.mVideoLabel;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAssetFeedSpecGroupRule> getParser() {
    return new APIRequest.ResponseParser<AdAssetFeedSpecGroupRule>() {
      public APINodeList<AdAssetFeedSpecGroupRule> parseResponse(String response, APIContext context, APIRequest<AdAssetFeedSpecGroupRule> request) throws MalformedResponseException {
        return AdAssetFeedSpecGroupRule.parseResponse(response, context, request);
      }
    };
  }
}
