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
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdAssetFeedSpec extends APINode {
  @SerializedName("ad_formats")
  private List<String> mAdFormats = null;
  @SerializedName("bodies")
  private List<AdAssetFeedSpecBody> mBodies = null;
  @SerializedName("call_to_action_types")
  private List<EnumCallToActionTypes> mCallToActionTypes = null;
  @SerializedName("captions")
  private List<AdAssetFeedSpecCaption> mCaptions = null;
  @SerializedName("descriptions")
  private List<AdAssetFeedSpecDescription> mDescriptions = null;
  @SerializedName("groups")
  private List<AdAssetFeedSpecGroupRule> mGroups = null;
  @SerializedName("images")
  private List<AdAssetFeedSpecImage> mImages = null;
  @SerializedName("link_urls")
  private List<AdAssetFeedSpecLinkURL> mLinkUrls = null;
  @SerializedName("optimization_type")
  private String mOptimizationType = null;
  @SerializedName("target_rules")
  private List<AdAssetFeedSpecTargetRule> mTargetRules = null;
  @SerializedName("titles")
  private List<AdAssetFeedSpecTitle> mTitles = null;
  @SerializedName("videos")
  private List<AdAssetFeedSpecVideo> mVideos = null;
  protected static Gson gson = null;

  public AdAssetFeedSpec() {
  }

  public String getId() {
    return null;
  }
  public static AdAssetFeedSpec loadJSON(String json, APIContext context) {
    AdAssetFeedSpec adAssetFeedSpec = getGson().fromJson(json, AdAssetFeedSpec.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAssetFeedSpec.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAssetFeedSpec.context = context;
    adAssetFeedSpec.rawValue = json;
    return adAssetFeedSpec;
  }

  public static APINodeList<AdAssetFeedSpec> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAssetFeedSpec> adAssetFeedSpecs = new APINodeList<AdAssetFeedSpec>(request, json);
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
          adAssetFeedSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAssetFeedSpecs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adAssetFeedSpecs.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAssetFeedSpecs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAssetFeedSpecs.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAssetFeedSpecs.add(loadJSON(obj.toString(), context));
            }
          }
          return adAssetFeedSpecs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAssetFeedSpecs.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAssetFeedSpecs;
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
              adAssetFeedSpecs.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAssetFeedSpecs;
          }

          // Sixth, check if it's pure JsonObject
          adAssetFeedSpecs.clear();
          adAssetFeedSpecs.add(loadJSON(json, context));
          return adAssetFeedSpecs;
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


  public List<String> getFieldAdFormats() {
    return mAdFormats;
  }

  public AdAssetFeedSpec setFieldAdFormats(List<String> value) {
    this.mAdFormats = value;
    return this;
  }

  public List<AdAssetFeedSpecBody> getFieldBodies() {
    return mBodies;
  }

  public AdAssetFeedSpec setFieldBodies(List<AdAssetFeedSpecBody> value) {
    this.mBodies = value;
    return this;
  }

  public AdAssetFeedSpec setFieldBodies(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecBody>>(){}.getType();
    this.mBodies = AdAssetFeedSpecBody.getGson().fromJson(value, type);
    return this;
  }
  public List<EnumCallToActionTypes> getFieldCallToActionTypes() {
    return mCallToActionTypes;
  }

  public AdAssetFeedSpec setFieldCallToActionTypes(List<EnumCallToActionTypes> value) {
    this.mCallToActionTypes = value;
    return this;
  }

  public List<AdAssetFeedSpecCaption> getFieldCaptions() {
    return mCaptions;
  }

  public AdAssetFeedSpec setFieldCaptions(List<AdAssetFeedSpecCaption> value) {
    this.mCaptions = value;
    return this;
  }

  public AdAssetFeedSpec setFieldCaptions(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecCaption>>(){}.getType();
    this.mCaptions = AdAssetFeedSpecCaption.getGson().fromJson(value, type);
    return this;
  }
  public List<AdAssetFeedSpecDescription> getFieldDescriptions() {
    return mDescriptions;
  }

  public AdAssetFeedSpec setFieldDescriptions(List<AdAssetFeedSpecDescription> value) {
    this.mDescriptions = value;
    return this;
  }

  public AdAssetFeedSpec setFieldDescriptions(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecDescription>>(){}.getType();
    this.mDescriptions = AdAssetFeedSpecDescription.getGson().fromJson(value, type);
    return this;
  }
  public List<AdAssetFeedSpecGroupRule> getFieldGroups() {
    return mGroups;
  }

  public AdAssetFeedSpec setFieldGroups(List<AdAssetFeedSpecGroupRule> value) {
    this.mGroups = value;
    return this;
  }

  public AdAssetFeedSpec setFieldGroups(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecGroupRule>>(){}.getType();
    this.mGroups = AdAssetFeedSpecGroupRule.getGson().fromJson(value, type);
    return this;
  }
  public List<AdAssetFeedSpecImage> getFieldImages() {
    return mImages;
  }

  public AdAssetFeedSpec setFieldImages(List<AdAssetFeedSpecImage> value) {
    this.mImages = value;
    return this;
  }

  public AdAssetFeedSpec setFieldImages(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecImage>>(){}.getType();
    this.mImages = AdAssetFeedSpecImage.getGson().fromJson(value, type);
    return this;
  }
  public List<AdAssetFeedSpecLinkURL> getFieldLinkUrls() {
    return mLinkUrls;
  }

  public AdAssetFeedSpec setFieldLinkUrls(List<AdAssetFeedSpecLinkURL> value) {
    this.mLinkUrls = value;
    return this;
  }

  public AdAssetFeedSpec setFieldLinkUrls(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecLinkURL>>(){}.getType();
    this.mLinkUrls = AdAssetFeedSpecLinkURL.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldOptimizationType() {
    return mOptimizationType;
  }

  public AdAssetFeedSpec setFieldOptimizationType(String value) {
    this.mOptimizationType = value;
    return this;
  }

  public List<AdAssetFeedSpecTargetRule> getFieldTargetRules() {
    return mTargetRules;
  }

  public AdAssetFeedSpec setFieldTargetRules(List<AdAssetFeedSpecTargetRule> value) {
    this.mTargetRules = value;
    return this;
  }

  public AdAssetFeedSpec setFieldTargetRules(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecTargetRule>>(){}.getType();
    this.mTargetRules = AdAssetFeedSpecTargetRule.getGson().fromJson(value, type);
    return this;
  }
  public List<AdAssetFeedSpecTitle> getFieldTitles() {
    return mTitles;
  }

  public AdAssetFeedSpec setFieldTitles(List<AdAssetFeedSpecTitle> value) {
    this.mTitles = value;
    return this;
  }

  public AdAssetFeedSpec setFieldTitles(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecTitle>>(){}.getType();
    this.mTitles = AdAssetFeedSpecTitle.getGson().fromJson(value, type);
    return this;
  }
  public List<AdAssetFeedSpecVideo> getFieldVideos() {
    return mVideos;
  }

  public AdAssetFeedSpec setFieldVideos(List<AdAssetFeedSpecVideo> value) {
    this.mVideos = value;
    return this;
  }

  public AdAssetFeedSpec setFieldVideos(String value) {
    Type type = new TypeToken<List<AdAssetFeedSpecVideo>>(){}.getType();
    this.mVideos = AdAssetFeedSpecVideo.getGson().fromJson(value, type);
    return this;
  }


  public static enum EnumCallToActionTypes {
      @SerializedName("OPEN_LINK")
      VALUE_OPEN_LINK("OPEN_LINK"),
      @SerializedName("LIKE_PAGE")
      VALUE_LIKE_PAGE("LIKE_PAGE"),
      @SerializedName("SHOP_NOW")
      VALUE_SHOP_NOW("SHOP_NOW"),
      @SerializedName("PLAY_GAME")
      VALUE_PLAY_GAME("PLAY_GAME"),
      @SerializedName("INSTALL_APP")
      VALUE_INSTALL_APP("INSTALL_APP"),
      @SerializedName("USE_APP")
      VALUE_USE_APP("USE_APP"),
      @SerializedName("INSTALL_MOBILE_APP")
      VALUE_INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
      @SerializedName("USE_MOBILE_APP")
      VALUE_USE_MOBILE_APP("USE_MOBILE_APP"),
      @SerializedName("BOOK_TRAVEL")
      VALUE_BOOK_TRAVEL("BOOK_TRAVEL"),
      @SerializedName("LISTEN_MUSIC")
      VALUE_LISTEN_MUSIC("LISTEN_MUSIC"),
      @SerializedName("LEARN_MORE")
      VALUE_LEARN_MORE("LEARN_MORE"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("DOWNLOAD")
      VALUE_DOWNLOAD("DOWNLOAD"),
      @SerializedName("WATCH_MORE")
      VALUE_WATCH_MORE("WATCH_MORE"),
      @SerializedName("NO_BUTTON")
      VALUE_NO_BUTTON("NO_BUTTON"),
      @SerializedName("CALL_NOW")
      VALUE_CALL_NOW("CALL_NOW"),
      @SerializedName("APPLY_NOW")
      VALUE_APPLY_NOW("APPLY_NOW"),
      @SerializedName("BUY_NOW")
      VALUE_BUY_NOW("BUY_NOW"),
      @SerializedName("GET_OFFER")
      VALUE_GET_OFFER("GET_OFFER"),
      @SerializedName("GET_OFFER_VIEW")
      VALUE_GET_OFFER_VIEW("GET_OFFER_VIEW"),
      @SerializedName("GET_DIRECTIONS")
      VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
      @SerializedName("MESSAGE_PAGE")
      VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
      @SerializedName("MESSAGE_USER")
      VALUE_MESSAGE_USER("MESSAGE_USER"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("SELL_NOW")
      VALUE_SELL_NOW("SELL_NOW"),
      @SerializedName("DONATE_NOW")
      VALUE_DONATE_NOW("DONATE_NOW"),
      @SerializedName("GET_QUOTE")
      VALUE_GET_QUOTE("GET_QUOTE"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("START_ORDER")
      VALUE_START_ORDER("START_ORDER"),
      @SerializedName("RECORD_NOW")
      VALUE_RECORD_NOW("RECORD_NOW"),
      @SerializedName("VOTE_NOW")
      VALUE_VOTE_NOW("VOTE_NOW"),
      @SerializedName("REGISTER_NOW")
      VALUE_REGISTER_NOW("REGISTER_NOW"),
      @SerializedName("REQUEST_TIME")
      VALUE_REQUEST_TIME("REQUEST_TIME"),
      @SerializedName("SEE_MENU")
      VALUE_SEE_MENU("SEE_MENU"),
      @SerializedName("EMAIL_NOW")
      VALUE_EMAIL_NOW("EMAIL_NOW"),
      @SerializedName("GET_SHOWTIMES")
      VALUE_GET_SHOWTIMES("GET_SHOWTIMES"),
      @SerializedName("TRY_IT")
      VALUE_TRY_IT("TRY_IT"),
      @SerializedName("LISTEN_NOW")
      VALUE_LISTEN_NOW("LISTEN_NOW"),
      @SerializedName("OPEN_MOVIES")
      VALUE_OPEN_MOVIES("OPEN_MOVIES"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumCallToActionTypes(String value) {
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

  public AdAssetFeedSpec copyFrom(AdAssetFeedSpec instance) {
    this.mAdFormats = instance.mAdFormats;
    this.mBodies = instance.mBodies;
    this.mCallToActionTypes = instance.mCallToActionTypes;
    this.mCaptions = instance.mCaptions;
    this.mDescriptions = instance.mDescriptions;
    this.mGroups = instance.mGroups;
    this.mImages = instance.mImages;
    this.mLinkUrls = instance.mLinkUrls;
    this.mOptimizationType = instance.mOptimizationType;
    this.mTargetRules = instance.mTargetRules;
    this.mTitles = instance.mTitles;
    this.mVideos = instance.mVideos;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAssetFeedSpec> getParser() {
    return new APIRequest.ResponseParser<AdAssetFeedSpec>() {
      public APINodeList<AdAssetFeedSpec> parseResponse(String response, APIContext context, APIRequest<AdAssetFeedSpec> request) throws MalformedResponseException {
        return AdAssetFeedSpec.parseResponse(response, context, request);
      }
    };
  }
}
