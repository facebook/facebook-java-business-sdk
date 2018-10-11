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
public class AdCreativeVideoData extends APINode {
  @SerializedName("additional_image_index")
  private Long mAdditionalImageIndex = null;
  @SerializedName("branded_content_shared_to_sponsor_status")
  private String mBrandedContentSharedToSponsorStatus = null;
  @SerializedName("branded_content_sponsor_page_id")
  private String mBrandedContentSponsorPageId = null;
  @SerializedName("branded_content_sponsor_relationship")
  private String mBrandedContentSponsorRelationship = null;
  @SerializedName("call_to_action")
  private AdCreativeLinkDataCallToAction mCallToAction = null;
  @SerializedName("collection_thumbnails")
  private List<AdCreativeCollectionThumbnailInfo> mCollectionThumbnails = null;
  @SerializedName("custom_overlay_spec")
  private List<AdCreativeVideoDataCustomOverlaySpec> mCustomOverlaySpec = null;
  @SerializedName("description")
  private String mDescription = null;
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
  @SerializedName("post_click_configuration")
  private AdCreativePostClickConfiguration mPostClickConfiguration = null;
  @SerializedName("retailer_item_ids")
  private List<String> mRetailerItemIds = null;
  @SerializedName("targeting")
  private Targeting mTargeting = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdCreativeVideoData() {
  }

  public AdCreativeVideoData(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreativeVideoData(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCreativeVideoData fetch() throws APIException{
    AdCreativeVideoData newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCreativeVideoData fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreativeVideoData> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreativeVideoData fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreativeVideoData> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreativeVideoData> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreativeVideoData>)(
      new APIRequest<AdCreativeVideoData>(context, "", "/", "GET", AdCreativeVideoData.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreativeVideoData>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreativeVideoData.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
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
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeVideoDatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeVideoDatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeVideoDatas.setAppSecret(context.getAppSecretProof());
            }
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Long getFieldAdditionalImageIndex() {
    return mAdditionalImageIndex;
  }

  public String getFieldBrandedContentSharedToSponsorStatus() {
    return mBrandedContentSharedToSponsorStatus;
  }

  public String getFieldBrandedContentSponsorPageId() {
    return mBrandedContentSponsorPageId;
  }

  public String getFieldBrandedContentSponsorRelationship() {
    return mBrandedContentSponsorRelationship;
  }

  public AdCreativeLinkDataCallToAction getFieldCallToAction() {
    if (mCallToAction != null) {
      mCallToAction.context = getContext();
    }
    return mCallToAction;
  }

  public List<AdCreativeCollectionThumbnailInfo> getFieldCollectionThumbnails() {
    return mCollectionThumbnails;
  }

  public List<AdCreativeVideoDataCustomOverlaySpec> getFieldCustomOverlaySpec() {
    return mCustomOverlaySpec;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldImageHash() {
    return mImageHash;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public String getFieldLinkDescription() {
    return mLinkDescription;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public String getFieldOfferId() {
    return mOfferId;
  }

  public String getFieldPageWelcomeMessage() {
    return mPageWelcomeMessage;
  }

  public AdCreativePostClickConfiguration getFieldPostClickConfiguration() {
    if (mPostClickConfiguration != null) {
      mPostClickConfiguration.context = getContext();
    }
    return mPostClickConfiguration;
  }

  public List<String> getFieldRetailerItemIds() {
    return mRetailerItemIds;
  }

  public Targeting getFieldTargeting() {
    if (mTargeting != null) {
      mTargeting.context = getContext();
    }
    return mTargeting;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCreativeVideoData> {

    AdCreativeVideoData lastResponse = null;
    @Override
    public AdCreativeVideoData getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "additional_image_index",
      "branded_content_shared_to_sponsor_status",
      "branded_content_sponsor_page_id",
      "branded_content_sponsor_relationship",
      "call_to_action",
      "collection_thumbnails",
      "custom_overlay_spec",
      "description",
      "image_hash",
      "image_url",
      "link_description",
      "message",
      "offer_id",
      "page_welcome_message",
      "post_click_configuration",
      "retailer_item_ids",
      "targeting",
      "title",
      "video_id",
      "id",
    };

    @Override
    public AdCreativeVideoData parseResponse(String response) throws APIException {
      return AdCreativeVideoData.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreativeVideoData execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreativeVideoData execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreativeVideoData> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreativeVideoData> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreativeVideoData>() {
           public AdCreativeVideoData apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAdditionalImageIndexField () {
      return this.requestAdditionalImageIndexField(true);
    }
    public APIRequestGet requestAdditionalImageIndexField (boolean value) {
      this.requestField("additional_image_index", value);
      return this;
    }
    public APIRequestGet requestBrandedContentSharedToSponsorStatusField () {
      return this.requestBrandedContentSharedToSponsorStatusField(true);
    }
    public APIRequestGet requestBrandedContentSharedToSponsorStatusField (boolean value) {
      this.requestField("branded_content_shared_to_sponsor_status", value);
      return this;
    }
    public APIRequestGet requestBrandedContentSponsorPageIdField () {
      return this.requestBrandedContentSponsorPageIdField(true);
    }
    public APIRequestGet requestBrandedContentSponsorPageIdField (boolean value) {
      this.requestField("branded_content_sponsor_page_id", value);
      return this;
    }
    public APIRequestGet requestBrandedContentSponsorRelationshipField () {
      return this.requestBrandedContentSponsorRelationshipField(true);
    }
    public APIRequestGet requestBrandedContentSponsorRelationshipField (boolean value) {
      this.requestField("branded_content_sponsor_relationship", value);
      return this;
    }
    public APIRequestGet requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGet requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGet requestCollectionThumbnailsField () {
      return this.requestCollectionThumbnailsField(true);
    }
    public APIRequestGet requestCollectionThumbnailsField (boolean value) {
      this.requestField("collection_thumbnails", value);
      return this;
    }
    public APIRequestGet requestCustomOverlaySpecField () {
      return this.requestCustomOverlaySpecField(true);
    }
    public APIRequestGet requestCustomOverlaySpecField (boolean value) {
      this.requestField("custom_overlay_spec", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGet requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGet requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGet requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGet requestLinkDescriptionField () {
      return this.requestLinkDescriptionField(true);
    }
    public APIRequestGet requestLinkDescriptionField (boolean value) {
      this.requestField("link_description", value);
      return this;
    }
    public APIRequestGet requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGet requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGet requestOfferIdField () {
      return this.requestOfferIdField(true);
    }
    public APIRequestGet requestOfferIdField (boolean value) {
      this.requestField("offer_id", value);
      return this;
    }
    public APIRequestGet requestPageWelcomeMessageField () {
      return this.requestPageWelcomeMessageField(true);
    }
    public APIRequestGet requestPageWelcomeMessageField (boolean value) {
      this.requestField("page_welcome_message", value);
      return this;
    }
    public APIRequestGet requestPostClickConfigurationField () {
      return this.requestPostClickConfigurationField(true);
    }
    public APIRequestGet requestPostClickConfigurationField (boolean value) {
      this.requestField("post_click_configuration", value);
      return this;
    }
    public APIRequestGet requestRetailerItemIdsField () {
      return this.requestRetailerItemIdsField(true);
    }
    public APIRequestGet requestRetailerItemIdsField (boolean value) {
      this.requestField("retailer_item_ids", value);
      return this;
    }
    public APIRequestGet requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGet requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGet requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
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

  public AdCreativeVideoData copyFrom(AdCreativeVideoData instance) {
    this.mAdditionalImageIndex = instance.mAdditionalImageIndex;
    this.mBrandedContentSharedToSponsorStatus = instance.mBrandedContentSharedToSponsorStatus;
    this.mBrandedContentSponsorPageId = instance.mBrandedContentSponsorPageId;
    this.mBrandedContentSponsorRelationship = instance.mBrandedContentSponsorRelationship;
    this.mCallToAction = instance.mCallToAction;
    this.mCollectionThumbnails = instance.mCollectionThumbnails;
    this.mCustomOverlaySpec = instance.mCustomOverlaySpec;
    this.mDescription = instance.mDescription;
    this.mImageHash = instance.mImageHash;
    this.mImageUrl = instance.mImageUrl;
    this.mLinkDescription = instance.mLinkDescription;
    this.mMessage = instance.mMessage;
    this.mOfferId = instance.mOfferId;
    this.mPageWelcomeMessage = instance.mPageWelcomeMessage;
    this.mPostClickConfiguration = instance.mPostClickConfiguration;
    this.mRetailerItemIds = instance.mRetailerItemIds;
    this.mTargeting = instance.mTargeting;
    this.mTitle = instance.mTitle;
    this.mVideoId = instance.mVideoId;
    this.mId = instance.mId;
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
