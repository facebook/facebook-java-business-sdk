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
public class AdCreativeLinkData extends APINode {
  @SerializedName("additional_image_index")
  private Long mAdditionalImageIndex = null;
  @SerializedName("app_link_spec")
  private AdCreativeLinkDataAppLinkSpec mAppLinkSpec = null;
  @SerializedName("attachment_style")
  private EnumAttachmentStyle mAttachmentStyle = null;
  @SerializedName("branded_content_shared_to_sponsor_status")
  private String mBrandedContentSharedToSponsorStatus = null;
  @SerializedName("branded_content_sponsor_page_id")
  private String mBrandedContentSponsorPageId = null;
  @SerializedName("branded_content_sponsor_relationship")
  private String mBrandedContentSponsorRelationship = null;
  @SerializedName("call_to_action")
  private AdCreativeLinkDataCallToAction mCallToAction = null;
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("child_attachments")
  private List<AdCreativeLinkDataChildAttachment> mChildAttachments = null;
  @SerializedName("collection_thumbnails")
  private List<AdCreativeCollectionThumbnailInfo> mCollectionThumbnails = null;
  @SerializedName("custom_overlay_spec")
  private AdCreativeLinkDataCustomOverlaySpec mCustomOverlaySpec = null;
  @SerializedName("customization_rules_spec")
  private List<AdCustomizationRuleSpec> mCustomizationRulesSpec = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("event_id")
  private String mEventId = null;
  @SerializedName("force_single_link")
  private Boolean mForceSingleLink = null;
  @SerializedName("format_option")
  private EnumFormatOption mFormatOption = null;
  @SerializedName("image_crops")
  private AdsImageCrops mImageCrops = null;
  @SerializedName("image_hash")
  private String mImageHash = null;
  @SerializedName("image_layer_specs")
  private List<AdCreativeLinkDataImageLayerSpec> mImageLayerSpecs = null;
  @SerializedName("image_overlay_spec")
  private AdCreativeLinkDataImageOverlaySpec mImageOverlaySpec = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("multi_share_end_card")
  private Boolean mMultiShareEndCard = null;
  @SerializedName("multi_share_optimized")
  private Boolean mMultiShareOptimized = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("offer_id")
  private String mOfferId = null;
  @SerializedName("page_welcome_message")
  private String mPageWelcomeMessage = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("post_click_configuration")
  private AdCreativePostClickConfiguration mPostClickConfiguration = null;
  @SerializedName("preferred_image_tags")
  private List<String> mPreferredImageTags = null;
  @SerializedName("retailer_item_ids")
  private List<String> mRetailerItemIds = null;
  @SerializedName("show_multiple_images")
  private Boolean mShowMultipleImages = null;
  @SerializedName("sponsorship_info")
  private AdCreativeLinkDataSponsorshipInfoSpec mSponsorshipInfo = null;
  @SerializedName("static_fallback_spec")
  private AdCreativeStaticFallbackSpec mStaticFallbackSpec = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdCreativeLinkData() {
  }

  public AdCreativeLinkData(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreativeLinkData(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCreativeLinkData fetch() throws APIException{
    AdCreativeLinkData newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCreativeLinkData fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreativeLinkData> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreativeLinkData fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreativeLinkData> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreativeLinkData> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreativeLinkData>)(
      new APIRequest<AdCreativeLinkData>(context, "", "/", "GET", AdCreativeLinkData.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreativeLinkData>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreativeLinkData.getParser())
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
  public static AdCreativeLinkData loadJSON(String json, APIContext context) {
    AdCreativeLinkData adCreativeLinkData = getGson().fromJson(json, AdCreativeLinkData.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkData.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeLinkData.context = context;
    adCreativeLinkData.rawValue = json;
    return adCreativeLinkData;
  }

  public static APINodeList<AdCreativeLinkData> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeLinkData> adCreativeLinkDatas = new APINodeList<AdCreativeLinkData>(request, json);
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
          adCreativeLinkDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeLinkDatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDatas.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativeLinkDatas.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDatas.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativeLinkDatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDatas.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativeLinkDatas;
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
              adCreativeLinkDatas.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDatas;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDatas.clear();
          adCreativeLinkDatas.add(loadJSON(json, context));
          return adCreativeLinkDatas;
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

  public AdCreativeLinkDataAppLinkSpec getFieldAppLinkSpec() {
    if (mAppLinkSpec != null) {
      mAppLinkSpec.context = getContext();
    }
    return mAppLinkSpec;
  }

  public EnumAttachmentStyle getFieldAttachmentStyle() {
    return mAttachmentStyle;
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

  public String getFieldCaption() {
    return mCaption;
  }

  public List<AdCreativeLinkDataChildAttachment> getFieldChildAttachments() {
    return mChildAttachments;
  }

  public List<AdCreativeCollectionThumbnailInfo> getFieldCollectionThumbnails() {
    return mCollectionThumbnails;
  }

  public AdCreativeLinkDataCustomOverlaySpec getFieldCustomOverlaySpec() {
    if (mCustomOverlaySpec != null) {
      mCustomOverlaySpec.context = getContext();
    }
    return mCustomOverlaySpec;
  }

  public List<AdCustomizationRuleSpec> getFieldCustomizationRulesSpec() {
    return mCustomizationRulesSpec;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldEventId() {
    return mEventId;
  }

  public Boolean getFieldForceSingleLink() {
    return mForceSingleLink;
  }

  public EnumFormatOption getFieldFormatOption() {
    return mFormatOption;
  }

  public AdsImageCrops getFieldImageCrops() {
    if (mImageCrops != null) {
      mImageCrops.context = getContext();
    }
    return mImageCrops;
  }

  public String getFieldImageHash() {
    return mImageHash;
  }

  public List<AdCreativeLinkDataImageLayerSpec> getFieldImageLayerSpecs() {
    return mImageLayerSpecs;
  }

  public AdCreativeLinkDataImageOverlaySpec getFieldImageOverlaySpec() {
    if (mImageOverlaySpec != null) {
      mImageOverlaySpec.context = getContext();
    }
    return mImageOverlaySpec;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public Boolean getFieldMultiShareEndCard() {
    return mMultiShareEndCard;
  }

  public Boolean getFieldMultiShareOptimized() {
    return mMultiShareOptimized;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldOfferId() {
    return mOfferId;
  }

  public String getFieldPageWelcomeMessage() {
    return mPageWelcomeMessage;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public AdCreativePostClickConfiguration getFieldPostClickConfiguration() {
    if (mPostClickConfiguration != null) {
      mPostClickConfiguration.context = getContext();
    }
    return mPostClickConfiguration;
  }

  public List<String> getFieldPreferredImageTags() {
    return mPreferredImageTags;
  }

  public List<String> getFieldRetailerItemIds() {
    return mRetailerItemIds;
  }

  public Boolean getFieldShowMultipleImages() {
    return mShowMultipleImages;
  }

  public AdCreativeLinkDataSponsorshipInfoSpec getFieldSponsorshipInfo() {
    if (mSponsorshipInfo != null) {
      mSponsorshipInfo.context = getContext();
    }
    return mSponsorshipInfo;
  }

  public AdCreativeStaticFallbackSpec getFieldStaticFallbackSpec() {
    if (mStaticFallbackSpec != null) {
      mStaticFallbackSpec.context = getContext();
    }
    return mStaticFallbackSpec;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCreativeLinkData> {

    AdCreativeLinkData lastResponse = null;
    @Override
    public AdCreativeLinkData getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "additional_image_index",
      "app_link_spec",
      "attachment_style",
      "branded_content_shared_to_sponsor_status",
      "branded_content_sponsor_page_id",
      "branded_content_sponsor_relationship",
      "call_to_action",
      "caption",
      "child_attachments",
      "collection_thumbnails",
      "custom_overlay_spec",
      "customization_rules_spec",
      "description",
      "event_id",
      "force_single_link",
      "format_option",
      "image_crops",
      "image_hash",
      "image_layer_specs",
      "image_overlay_spec",
      "link",
      "message",
      "multi_share_end_card",
      "multi_share_optimized",
      "name",
      "offer_id",
      "page_welcome_message",
      "picture",
      "post_click_configuration",
      "preferred_image_tags",
      "retailer_item_ids",
      "show_multiple_images",
      "sponsorship_info",
      "static_fallback_spec",
      "id",
    };

    @Override
    public AdCreativeLinkData parseResponse(String response) throws APIException {
      return AdCreativeLinkData.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreativeLinkData execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreativeLinkData execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreativeLinkData> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreativeLinkData> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreativeLinkData>() {
           public AdCreativeLinkData apply(String result) {
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
    public APIRequestGet requestAppLinkSpecField () {
      return this.requestAppLinkSpecField(true);
    }
    public APIRequestGet requestAppLinkSpecField (boolean value) {
      this.requestField("app_link_spec", value);
      return this;
    }
    public APIRequestGet requestAttachmentStyleField () {
      return this.requestAttachmentStyleField(true);
    }
    public APIRequestGet requestAttachmentStyleField (boolean value) {
      this.requestField("attachment_style", value);
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
    public APIRequestGet requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGet requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGet requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGet requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
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
    public APIRequestGet requestCustomizationRulesSpecField () {
      return this.requestCustomizationRulesSpecField(true);
    }
    public APIRequestGet requestCustomizationRulesSpecField (boolean value) {
      this.requestField("customization_rules_spec", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestEventIdField () {
      return this.requestEventIdField(true);
    }
    public APIRequestGet requestEventIdField (boolean value) {
      this.requestField("event_id", value);
      return this;
    }
    public APIRequestGet requestForceSingleLinkField () {
      return this.requestForceSingleLinkField(true);
    }
    public APIRequestGet requestForceSingleLinkField (boolean value) {
      this.requestField("force_single_link", value);
      return this;
    }
    public APIRequestGet requestFormatOptionField () {
      return this.requestFormatOptionField(true);
    }
    public APIRequestGet requestFormatOptionField (boolean value) {
      this.requestField("format_option", value);
      return this;
    }
    public APIRequestGet requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGet requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGet requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGet requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGet requestImageLayerSpecsField () {
      return this.requestImageLayerSpecsField(true);
    }
    public APIRequestGet requestImageLayerSpecsField (boolean value) {
      this.requestField("image_layer_specs", value);
      return this;
    }
    public APIRequestGet requestImageOverlaySpecField () {
      return this.requestImageOverlaySpecField(true);
    }
    public APIRequestGet requestImageOverlaySpecField (boolean value) {
      this.requestField("image_overlay_spec", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGet requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGet requestMultiShareEndCardField () {
      return this.requestMultiShareEndCardField(true);
    }
    public APIRequestGet requestMultiShareEndCardField (boolean value) {
      this.requestField("multi_share_end_card", value);
      return this;
    }
    public APIRequestGet requestMultiShareOptimizedField () {
      return this.requestMultiShareOptimizedField(true);
    }
    public APIRequestGet requestMultiShareOptimizedField (boolean value) {
      this.requestField("multi_share_optimized", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
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
    public APIRequestGet requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGet requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGet requestPostClickConfigurationField () {
      return this.requestPostClickConfigurationField(true);
    }
    public APIRequestGet requestPostClickConfigurationField (boolean value) {
      this.requestField("post_click_configuration", value);
      return this;
    }
    public APIRequestGet requestPreferredImageTagsField () {
      return this.requestPreferredImageTagsField(true);
    }
    public APIRequestGet requestPreferredImageTagsField (boolean value) {
      this.requestField("preferred_image_tags", value);
      return this;
    }
    public APIRequestGet requestRetailerItemIdsField () {
      return this.requestRetailerItemIdsField(true);
    }
    public APIRequestGet requestRetailerItemIdsField (boolean value) {
      this.requestField("retailer_item_ids", value);
      return this;
    }
    public APIRequestGet requestShowMultipleImagesField () {
      return this.requestShowMultipleImagesField(true);
    }
    public APIRequestGet requestShowMultipleImagesField (boolean value) {
      this.requestField("show_multiple_images", value);
      return this;
    }
    public APIRequestGet requestSponsorshipInfoField () {
      return this.requestSponsorshipInfoField(true);
    }
    public APIRequestGet requestSponsorshipInfoField (boolean value) {
      this.requestField("sponsorship_info", value);
      return this;
    }
    public APIRequestGet requestStaticFallbackSpecField () {
      return this.requestStaticFallbackSpecField(true);
    }
    public APIRequestGet requestStaticFallbackSpecField (boolean value) {
      this.requestField("static_fallback_spec", value);
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

  public static enum EnumAttachmentStyle {
      @SerializedName("link")
      VALUE_LINK("link"),
      @SerializedName("default")
      VALUE_DEFAULT("default"),
      NULL(null);

      private String value;

      private EnumAttachmentStyle(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumFormatOption {
      @SerializedName("carousel_images_multi_items")
      VALUE_CAROUSEL_IMAGES_MULTI_ITEMS("carousel_images_multi_items"),
      @SerializedName("carousel_images_single_item")
      VALUE_CAROUSEL_IMAGES_SINGLE_ITEM("carousel_images_single_item"),
      @SerializedName("carousel_slideshows")
      VALUE_CAROUSEL_SLIDESHOWS("carousel_slideshows"),
      @SerializedName("single_image")
      VALUE_SINGLE_IMAGE("single_image"),
      NULL(null);

      private String value;

      private EnumFormatOption(String value) {
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

  public AdCreativeLinkData copyFrom(AdCreativeLinkData instance) {
    this.mAdditionalImageIndex = instance.mAdditionalImageIndex;
    this.mAppLinkSpec = instance.mAppLinkSpec;
    this.mAttachmentStyle = instance.mAttachmentStyle;
    this.mBrandedContentSharedToSponsorStatus = instance.mBrandedContentSharedToSponsorStatus;
    this.mBrandedContentSponsorPageId = instance.mBrandedContentSponsorPageId;
    this.mBrandedContentSponsorRelationship = instance.mBrandedContentSponsorRelationship;
    this.mCallToAction = instance.mCallToAction;
    this.mCaption = instance.mCaption;
    this.mChildAttachments = instance.mChildAttachments;
    this.mCollectionThumbnails = instance.mCollectionThumbnails;
    this.mCustomOverlaySpec = instance.mCustomOverlaySpec;
    this.mCustomizationRulesSpec = instance.mCustomizationRulesSpec;
    this.mDescription = instance.mDescription;
    this.mEventId = instance.mEventId;
    this.mForceSingleLink = instance.mForceSingleLink;
    this.mFormatOption = instance.mFormatOption;
    this.mImageCrops = instance.mImageCrops;
    this.mImageHash = instance.mImageHash;
    this.mImageLayerSpecs = instance.mImageLayerSpecs;
    this.mImageOverlaySpec = instance.mImageOverlaySpec;
    this.mLink = instance.mLink;
    this.mMessage = instance.mMessage;
    this.mMultiShareEndCard = instance.mMultiShareEndCard;
    this.mMultiShareOptimized = instance.mMultiShareOptimized;
    this.mName = instance.mName;
    this.mOfferId = instance.mOfferId;
    this.mPageWelcomeMessage = instance.mPageWelcomeMessage;
    this.mPicture = instance.mPicture;
    this.mPostClickConfiguration = instance.mPostClickConfiguration;
    this.mPreferredImageTags = instance.mPreferredImageTags;
    this.mRetailerItemIds = instance.mRetailerItemIds;
    this.mShowMultipleImages = instance.mShowMultipleImages;
    this.mSponsorshipInfo = instance.mSponsorshipInfo;
    this.mStaticFallbackSpec = instance.mStaticFallbackSpec;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkData> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkData>() {
      public APINodeList<AdCreativeLinkData> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkData> request) throws MalformedResponseException {
        return AdCreativeLinkData.parseResponse(response, context, request);
      }
    };
  }
}
