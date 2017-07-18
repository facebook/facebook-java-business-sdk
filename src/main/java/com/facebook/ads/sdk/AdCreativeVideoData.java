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
public class AdCreativeVideoData extends APINode {
  @SerializedName("additional_image_index")
  private Long mAdditionalImageIndex = null;
  @SerializedName("branded_content_sponsor_page_id")
  private String mBrandedContentSponsorPageId = null;
  @SerializedName("branded_content_sponsor_relationship")
  private String mBrandedContentSponsorRelationship = null;
  @SerializedName("call_to_action")
  private AdCreativeLinkDataCallToAction mCallToAction = null;
  @SerializedName("image_hash")
  private String mImageHash = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("link_description")
  private String mLinkDescription = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("offer_id")
  private String mOfferId = null;
  @SerializedName("page_welcome_message")
  private String mPageWelcomeMessage = null;
  @SerializedName("retailer_item_ids")
  private List<String> mRetailerItemIds = null;
  @SerializedName("targeting")
  private Targeting mTargeting = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  protected static Gson gson = null;

  public AdCreativeVideoData() {
  }

  public String getId() {
    return null;
  }
  public static AdCreativeVideoData loadJSON(String json, APIContext context) {
    AdCreativeVideoData adCreativeVideoData = getGson().fromJson(json, AdCreativeVideoData.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeVideoData.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeVideoData.context = context;
    adCreativeVideoData.rawValue = json;
    return adCreativeVideoData;
  }

  public static APINodeList<AdCreativeVideoData> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeVideoData> adCreativeVideoDatas = new APINodeList<AdCreativeVideoData>(request, json);
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
          adCreativeVideoDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeVideoDatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adCreativeVideoDatas.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeVideoDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativeVideoDatas.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeVideoDatas.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativeVideoDatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeVideoDatas.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativeVideoDatas;
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
              adCreativeVideoDatas.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeVideoDatas;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeVideoDatas.clear();
          adCreativeVideoDatas.add(loadJSON(json, context));
          return adCreativeVideoDatas;
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


  public Long getFieldAdditionalImageIndex() {
    return mAdditionalImageIndex;
  }

  public AdCreativeVideoData setFieldAdditionalImageIndex(Long value) {
    this.mAdditionalImageIndex = value;
    return this;
  }

  public String getFieldBrandedContentSponsorPageId() {
    return mBrandedContentSponsorPageId;
  }

  public AdCreativeVideoData setFieldBrandedContentSponsorPageId(String value) {
    this.mBrandedContentSponsorPageId = value;
    return this;
  }

  public String getFieldBrandedContentSponsorRelationship() {
    return mBrandedContentSponsorRelationship;
  }

  public AdCreativeVideoData setFieldBrandedContentSponsorRelationship(String value) {
    this.mBrandedContentSponsorRelationship = value;
    return this;
  }

  public AdCreativeLinkDataCallToAction getFieldCallToAction() {
    return mCallToAction;
  }

  public AdCreativeVideoData setFieldCallToAction(AdCreativeLinkDataCallToAction value) {
    this.mCallToAction = value;
    return this;
  }

  public AdCreativeVideoData setFieldCallToAction(String value) {
    Type type = new TypeToken<AdCreativeLinkDataCallToAction>(){}.getType();
    this.mCallToAction = AdCreativeLinkDataCallToAction.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldImageHash() {
    return mImageHash;
  }

  public AdCreativeVideoData setFieldImageHash(String value) {
    this.mImageHash = value;
    return this;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public AdCreativeVideoData setFieldImageUrl(String value) {
    this.mImageUrl = value;
    return this;
  }

  public String getFieldLinkDescription() {
    return mLinkDescription;
  }

  public AdCreativeVideoData setFieldLinkDescription(String value) {
    this.mLinkDescription = value;
    return this;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public AdCreativeVideoData setFieldMessage(String value) {
    this.mMessage = value;
    return this;
  }

  public String getFieldOfferId() {
    return mOfferId;
  }

  public AdCreativeVideoData setFieldOfferId(String value) {
    this.mOfferId = value;
    return this;
  }

  public String getFieldPageWelcomeMessage() {
    return mPageWelcomeMessage;
  }

  public AdCreativeVideoData setFieldPageWelcomeMessage(String value) {
    this.mPageWelcomeMessage = value;
    return this;
  }

  public List<String> getFieldRetailerItemIds() {
    return mRetailerItemIds;
  }

  public AdCreativeVideoData setFieldRetailerItemIds(List<String> value) {
    this.mRetailerItemIds = value;
    return this;
  }

  public Targeting getFieldTargeting() {
    return mTargeting;
  }

  public AdCreativeVideoData setFieldTargeting(Targeting value) {
    this.mTargeting = value;
    return this;
  }

  public AdCreativeVideoData setFieldTargeting(String value) {
    Type type = new TypeToken<Targeting>(){}.getType();
    this.mTargeting = Targeting.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldTitle() {
    return mTitle;
  }

  public AdCreativeVideoData setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public AdCreativeVideoData setFieldVideoId(String value) {
    this.mVideoId = value;
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

  public AdCreativeVideoData copyFrom(AdCreativeVideoData instance) {
    this.mAdditionalImageIndex = instance.mAdditionalImageIndex;
    this.mBrandedContentSponsorPageId = instance.mBrandedContentSponsorPageId;
    this.mBrandedContentSponsorRelationship = instance.mBrandedContentSponsorRelationship;
    this.mCallToAction = instance.mCallToAction;
    this.mImageHash = instance.mImageHash;
    this.mImageUrl = instance.mImageUrl;
    this.mLinkDescription = instance.mLinkDescription;
    this.mMessage = instance.mMessage;
    this.mOfferId = instance.mOfferId;
    this.mPageWelcomeMessage = instance.mPageWelcomeMessage;
    this.mRetailerItemIds = instance.mRetailerItemIds;
    this.mTargeting = instance.mTargeting;
    this.mTitle = instance.mTitle;
    this.mVideoId = instance.mVideoId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeVideoData> getParser() {
    return new APIRequest.ResponseParser<AdCreativeVideoData>() {
      public APINodeList<AdCreativeVideoData> parseResponse(String response, APIContext context, APIRequest<AdCreativeVideoData> request) throws MalformedResponseException {
        return AdCreativeVideoData.parseResponse(response, context, request);
      }
    };
  }
}
