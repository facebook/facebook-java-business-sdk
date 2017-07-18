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
public class AdCreative extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("actor_id")
  private String mActorId = null;
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("applink_treatment")
  private EnumApplinkTreatment mApplinkTreatment = null;
  @SerializedName("body")
  private String mBody = null;
  @SerializedName("call_to_action_type")
  private EnumCallToActionType mCallToActionType = null;
  @SerializedName("effective_instagram_story_id")
  private String mEffectiveInstagramStoryId = null;
  @SerializedName("effective_object_story_id")
  private String mEffectiveObjectStoryId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_crops")
  private AdsImageCrops mImageCrops = null;
  @SerializedName("image_hash")
  private String mImageHash = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("instagram_actor_id")
  private String mInstagramActorId = null;
  @SerializedName("instagram_permalink_url")
  private String mInstagramPermalinkUrl = null;
  @SerializedName("instagram_story_id")
  private String mInstagramStoryId = null;
  @SerializedName("link_og_id")
  private String mLinkOgId = null;
  @SerializedName("link_url")
  private String mLinkUrl = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("object_id")
  private String mObjectId = null;
  @SerializedName("object_story_id")
  private String mObjectStoryId = null;
  @SerializedName("object_story_spec")
  private AdCreativeObjectStorySpec mObjectStorySpec = null;
  @SerializedName("object_type")
  private EnumObjectType mObjectType = null;
  @SerializedName("object_url")
  private String mObjectUrl = null;
  @SerializedName("platform_customizations")
  private Object mPlatformCustomizations = null;
  @SerializedName("product_set_id")
  private String mProductSetId = null;
  @SerializedName("status")
  private EnumStatus mStatus = null;
  @SerializedName("template_url")
  private String mTemplateUrl = null;
  @SerializedName("template_url_spec")
  private Object mTemplateUrlSpec = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("url_tags")
  private String mUrlTags = null;
  @SerializedName("use_page_actor_override")
  private Boolean mUsePageActorOverride = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  @SerializedName("creative_id")
  private String mCreativeId = null;
  protected static Gson gson = null;

  public AdCreative() {
  }

  public AdCreative(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreative(String id, APIContext context) {
    this.mId = id;
    mCreativeId = mId.toString();
    this.context = context;
  }

  public AdCreative fetch() throws APIException{
    AdCreative newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    mCreativeId = mId.toString();
    return this;
  }

  public static AdCreative fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdCreative fetchById(String id, APIContext context) throws APIException {
    AdCreative adCreative =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adCreative;
  }

  public static APINodeList<AdCreative> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreative>)(
      new APIRequest<AdCreative>(context, "", "/", "GET", AdCreative.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdCreative loadJSON(String json, APIContext context) {
    AdCreative adCreative = getGson().fromJson(json, AdCreative.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreative.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreative.context = context;
    adCreative.rawValue = json;
    adCreative.mCreativeId = adCreative.mId;
    return adCreative;
  }

  public static APINodeList<AdCreative> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreative> adCreatives = new APINodeList<AdCreative>(request, json);
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
          adCreatives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreatives;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adCreatives.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreatives.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreatives.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreatives.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreatives;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreatives.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreatives;
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
              adCreatives.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreatives;
          }

          // Sixth, check if it's pure JsonObject
          adCreatives.clear();
          adCreatives.add(loadJSON(json, context));
          return adCreatives;
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

  public APIRequestDeleteAdLabels deleteAdLabels() {
    return new APIRequestDeleteAdLabels(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPreviews getPreviews() {
    return new APIRequestGetPreviews(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountId() {
    return mAccountId;
  }

  public AdCreative setFieldAccountId(String value) {
    this.mAccountId = value;
    return this;
  }

  public String getFieldActorId() {
    return mActorId;
  }

  public AdCreative setFieldActorId(String value) {
    this.mActorId = value;
    return this;
  }

  public List<AdLabel> getFieldAdlabels() {
    return mAdlabels;
  }

  public AdCreative setFieldAdlabels(List<AdLabel> value) {
    this.mAdlabels = value;
    return this;
  }

  public AdCreative setFieldAdlabels(String value) {
    Type type = new TypeToken<List<AdLabel>>(){}.getType();
    this.mAdlabels = AdLabel.getGson().fromJson(value, type);
    return this;
  }
  public EnumApplinkTreatment getFieldApplinkTreatment() {
    return mApplinkTreatment;
  }

  public AdCreative setFieldApplinkTreatment(EnumApplinkTreatment value) {
    this.mApplinkTreatment = value;
    return this;
  }

  public String getFieldBody() {
    return mBody;
  }

  public AdCreative setFieldBody(String value) {
    this.mBody = value;
    return this;
  }

  public EnumCallToActionType getFieldCallToActionType() {
    return mCallToActionType;
  }

  public AdCreative setFieldCallToActionType(EnumCallToActionType value) {
    this.mCallToActionType = value;
    return this;
  }

  public String getFieldEffectiveInstagramStoryId() {
    return mEffectiveInstagramStoryId;
  }

  public AdCreative setFieldEffectiveInstagramStoryId(String value) {
    this.mEffectiveInstagramStoryId = value;
    return this;
  }

  public String getFieldEffectiveObjectStoryId() {
    return mEffectiveObjectStoryId;
  }

  public AdCreative setFieldEffectiveObjectStoryId(String value) {
    this.mEffectiveObjectStoryId = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdCreative setFieldId(String value) {
    this.mId = value;
    this.mCreativeId = this.mId;
    return this;
  }

  public AdsImageCrops getFieldImageCrops() {
    return mImageCrops;
  }

  public AdCreative setFieldImageCrops(AdsImageCrops value) {
    this.mImageCrops = value;
    return this;
  }

  public AdCreative setFieldImageCrops(String value) {
    Type type = new TypeToken<AdsImageCrops>(){}.getType();
    this.mImageCrops = AdsImageCrops.getGson().fromJson(value, type);
    return this;
  }
  public String getFieldImageHash() {
    return mImageHash;
  }

  public AdCreative setFieldImageHash(String value) {
    this.mImageHash = value;
    return this;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public AdCreative setFieldImageUrl(String value) {
    this.mImageUrl = value;
    return this;
  }

  public String getFieldInstagramActorId() {
    return mInstagramActorId;
  }

  public AdCreative setFieldInstagramActorId(String value) {
    this.mInstagramActorId = value;
    return this;
  }

  public String getFieldInstagramPermalinkUrl() {
    return mInstagramPermalinkUrl;
  }

  public AdCreative setFieldInstagramPermalinkUrl(String value) {
    this.mInstagramPermalinkUrl = value;
    return this;
  }

  public String getFieldInstagramStoryId() {
    return mInstagramStoryId;
  }

  public AdCreative setFieldInstagramStoryId(String value) {
    this.mInstagramStoryId = value;
    return this;
  }

  public String getFieldLinkOgId() {
    return mLinkOgId;
  }

  public AdCreative setFieldLinkOgId(String value) {
    this.mLinkOgId = value;
    return this;
  }

  public String getFieldLinkUrl() {
    return mLinkUrl;
  }

  public AdCreative setFieldLinkUrl(String value) {
    this.mLinkUrl = value;
    return this;
  }

  public String getFieldName() {
    return mName;
  }

  public AdCreative setFieldName(String value) {
    this.mName = value;
    return this;
  }

  public String getFieldObjectId() {
    return mObjectId;
  }

  public AdCreative setFieldObjectId(String value) {
    this.mObjectId = value;
    return this;
  }

  public String getFieldObjectStoryId() {
    return mObjectStoryId;
  }

  public AdCreative setFieldObjectStoryId(String value) {
    this.mObjectStoryId = value;
    return this;
  }

  public AdCreativeObjectStorySpec getFieldObjectStorySpec() {
    return mObjectStorySpec;
  }

  public AdCreative setFieldObjectStorySpec(AdCreativeObjectStorySpec value) {
    this.mObjectStorySpec = value;
    return this;
  }

  public AdCreative setFieldObjectStorySpec(String value) {
    Type type = new TypeToken<AdCreativeObjectStorySpec>(){}.getType();
    this.mObjectStorySpec = AdCreativeObjectStorySpec.getGson().fromJson(value, type);
    return this;
  }
  public EnumObjectType getFieldObjectType() {
    return mObjectType;
  }

  public AdCreative setFieldObjectType(EnumObjectType value) {
    this.mObjectType = value;
    return this;
  }

  public String getFieldObjectUrl() {
    return mObjectUrl;
  }

  public AdCreative setFieldObjectUrl(String value) {
    this.mObjectUrl = value;
    return this;
  }

  public Object getFieldPlatformCustomizations() {
    return mPlatformCustomizations;
  }

  public AdCreative setFieldPlatformCustomizations(Object value) {
    this.mPlatformCustomizations = value;
    return this;
  }

  public String getFieldProductSetId() {
    return mProductSetId;
  }

  public AdCreative setFieldProductSetId(String value) {
    this.mProductSetId = value;
    return this;
  }

  public EnumStatus getFieldStatus() {
    return mStatus;
  }

  public AdCreative setFieldStatus(EnumStatus value) {
    this.mStatus = value;
    return this;
  }

  public String getFieldTemplateUrl() {
    return mTemplateUrl;
  }

  public AdCreative setFieldTemplateUrl(String value) {
    this.mTemplateUrl = value;
    return this;
  }

  public Object getFieldTemplateUrlSpec() {
    return mTemplateUrlSpec;
  }

  public AdCreative setFieldTemplateUrlSpec(Object value) {
    this.mTemplateUrlSpec = value;
    return this;
  }

  public String getFieldThumbnailUrl() {
    return mThumbnailUrl;
  }

  public AdCreative setFieldThumbnailUrl(String value) {
    this.mThumbnailUrl = value;
    return this;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public AdCreative setFieldTitle(String value) {
    this.mTitle = value;
    return this;
  }

  public String getFieldUrlTags() {
    return mUrlTags;
  }

  public AdCreative setFieldUrlTags(String value) {
    this.mUrlTags = value;
    return this;
  }

  public Boolean getFieldUsePageActorOverride() {
    return mUsePageActorOverride;
  }

  public AdCreative setFieldUsePageActorOverride(Boolean value) {
    this.mUsePageActorOverride = value;
    return this;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public AdCreative setFieldVideoId(String value) {
    this.mVideoId = value;
    return this;
  }



  public static class APIRequestDeleteAdLabels extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDeleteAdLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteAdLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAdLabels setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestDeleteAdLabels setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestDeleteAdLabels requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteAdLabels requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteAdLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteAdLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateAdLabel extends APIRequest<AdLabel> {

    AdLabel lastResponse = null;
    @Override
    public AdLabel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "adlabels",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdLabel parseResponse(String response) throws APIException {
      return AdLabel.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdLabel execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdLabel execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestCreateAdLabel(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAdLabel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdLabel setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestCreateAdLabel setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestCreateAdLabel requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAdLabel requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAdLabel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAdLabel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPreviews extends APIRequest<AdPreview> {

    APINodeList<AdPreview> lastResponse = null;
    @Override
    public APINodeList<AdPreview> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_format",
      "end_date",
      "height",
      "locale",
      "place_page_id",
      "post",
      "product_item_ids",
      "start_date",
      "width",
    };

    public static final String[] FIELDS = {
      "body",
    };

    @Override
    public APINodeList<AdPreview> parseResponse(String response) throws APIException {
      return AdPreview.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdPreview> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdPreview> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetPreviews(String nodeId, APIContext context) {
      super(context, nodeId, "/previews", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPreviews setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPreviews setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPreviews setAdFormat (AdPreview.EnumAdFormat adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }
    public APIRequestGetPreviews setAdFormat (String adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }

    public APIRequestGetPreviews setEndDate (String endDate) {
      this.setParam("end_date", endDate);
      return this;
    }

    public APIRequestGetPreviews setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }
    public APIRequestGetPreviews setHeight (String height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPreviews setLocale (String locale) {
      this.setParam("locale", locale);
      return this;
    }

    public APIRequestGetPreviews setPlacePageId (Long placePageId) {
      this.setParam("place_page_id", placePageId);
      return this;
    }
    public APIRequestGetPreviews setPlacePageId (String placePageId) {
      this.setParam("place_page_id", placePageId);
      return this;
    }

    public APIRequestGetPreviews setPost (Object post) {
      this.setParam("post", post);
      return this;
    }
    public APIRequestGetPreviews setPost (String post) {
      this.setParam("post", post);
      return this;
    }

    public APIRequestGetPreviews setProductItemIds (List<String> productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }
    public APIRequestGetPreviews setProductItemIds (String productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }

    public APIRequestGetPreviews setStartDate (String startDate) {
      this.setParam("start_date", startDate);
      return this;
    }

    public APIRequestGetPreviews setWidth (Long width) {
      this.setParam("width", width);
      return this;
    }
    public APIRequestGetPreviews setWidth (String width) {
      this.setParam("width", width);
      return this;
    }

    public APIRequestGetPreviews requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPreviews requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPreviews requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPreviews requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPreviews requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPreviews requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPreviews requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetPreviews requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "adlabels",
      "name",
      "status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestDelete setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestDelete setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestDelete setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestDelete setStatus (AdCreative.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestDelete setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<AdCreative> {

    AdCreative lastResponse = null;
    @Override
    public AdCreative getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "thumbnail_height",
      "thumbnail_width",
    };

    public static final String[] FIELDS = {
      "account_id",
      "actor_id",
      "adlabels",
      "applink_treatment",
      "body",
      "call_to_action_type",
      "effective_instagram_story_id",
      "effective_object_story_id",
      "id",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "instagram_story_id",
      "link_og_id",
      "link_url",
      "name",
      "object_id",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "object_url",
      "platform_customizations",
      "product_set_id",
      "status",
      "template_url",
      "template_url_spec",
      "thumbnail_url",
      "title",
      "url_tags",
      "use_page_actor_override",
      "video_id",
    };

    @Override
    public AdCreative parseResponse(String response) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreative execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreative execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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


    public APIRequestGet setThumbnailHeight (Long thumbnailHeight) {
      this.setParam("thumbnail_height", thumbnailHeight);
      return this;
    }
    public APIRequestGet setThumbnailHeight (String thumbnailHeight) {
      this.setParam("thumbnail_height", thumbnailHeight);
      return this;
    }

    public APIRequestGet setThumbnailWidth (Long thumbnailWidth) {
      this.setParam("thumbnail_width", thumbnailWidth);
      return this;
    }
    public APIRequestGet setThumbnailWidth (String thumbnailWidth) {
      this.setParam("thumbnail_width", thumbnailWidth);
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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGet requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGet requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGet requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGet requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGet requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }
    public APIRequestGet requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGet requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGet requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGet requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
      return this;
    }
    public APIRequestGet requestEffectiveInstagramStoryIdField () {
      return this.requestEffectiveInstagramStoryIdField(true);
    }
    public APIRequestGet requestEffectiveInstagramStoryIdField (boolean value) {
      this.requestField("effective_instagram_story_id", value);
      return this;
    }
    public APIRequestGet requestEffectiveObjectStoryIdField () {
      return this.requestEffectiveObjectStoryIdField(true);
    }
    public APIRequestGet requestEffectiveObjectStoryIdField (boolean value) {
      this.requestField("effective_object_story_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
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
    public APIRequestGet requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGet requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGet requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGet requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGet requestInstagramPermalinkUrlField () {
      return this.requestInstagramPermalinkUrlField(true);
    }
    public APIRequestGet requestInstagramPermalinkUrlField (boolean value) {
      this.requestField("instagram_permalink_url", value);
      return this;
    }
    public APIRequestGet requestInstagramStoryIdField () {
      return this.requestInstagramStoryIdField(true);
    }
    public APIRequestGet requestInstagramStoryIdField (boolean value) {
      this.requestField("instagram_story_id", value);
      return this;
    }
    public APIRequestGet requestLinkOgIdField () {
      return this.requestLinkOgIdField(true);
    }
    public APIRequestGet requestLinkOgIdField (boolean value) {
      this.requestField("link_og_id", value);
      return this;
    }
    public APIRequestGet requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGet requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGet requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGet requestObjectStoryIdField () {
      return this.requestObjectStoryIdField(true);
    }
    public APIRequestGet requestObjectStoryIdField (boolean value) {
      this.requestField("object_story_id", value);
      return this;
    }
    public APIRequestGet requestObjectStorySpecField () {
      return this.requestObjectStorySpecField(true);
    }
    public APIRequestGet requestObjectStorySpecField (boolean value) {
      this.requestField("object_story_spec", value);
      return this;
    }
    public APIRequestGet requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGet requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGet requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGet requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGet requestPlatformCustomizationsField () {
      return this.requestPlatformCustomizationsField(true);
    }
    public APIRequestGet requestPlatformCustomizationsField (boolean value) {
      this.requestField("platform_customizations", value);
      return this;
    }
    public APIRequestGet requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGet requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGet requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGet requestTemplateUrlSpecField () {
      return this.requestTemplateUrlSpecField(true);
    }
    public APIRequestGet requestTemplateUrlSpecField (boolean value) {
      this.requestField("template_url_spec", value);
      return this;
    }
    public APIRequestGet requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGet requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGet requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGet requestUsePageActorOverrideField () {
      return this.requestUsePageActorOverrideField(true);
    }
    public APIRequestGet requestUsePageActorOverrideField (boolean value) {
      this.requestField("use_page_actor_override", value);
      return this;
    }
    public APIRequestGet requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGet requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdCreative> {

    AdCreative lastResponse = null;
    @Override
    public AdCreative getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "adlabels",
      "name",
      "status",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdCreative parseResponse(String response) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreative execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreative execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestUpdate setAdlabels (List<Object> adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }
    public APIRequestUpdate setAdlabels (String adlabels) {
      this.setParam("adlabels", adlabels);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setStatus (AdCreative.EnumStatus status) {
      this.setParam("status", status);
      return this;
    }
    public APIRequestUpdate setStatus (String status) {
      this.setParam("status", status);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumApplinkTreatment {
      @SerializedName("deeplink_with_web_fallback")
      VALUE_DEEPLINK_WITH_WEB_FALLBACK("deeplink_with_web_fallback"),
      @SerializedName("deeplink_with_appstore_fallback")
      VALUE_DEEPLINK_WITH_APPSTORE_FALLBACK("deeplink_with_appstore_fallback"),
      @SerializedName("web_only")
      VALUE_WEB_ONLY("web_only"),
      NULL(null);

      private String value;

      private EnumApplinkTreatment(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCallToActionType {
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
      @SerializedName("OPEN_MOVIES")
      VALUE_OPEN_MOVIES("OPEN_MOVIES"),
      NULL(null);

      private String value;

      private EnumCallToActionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumObjectType {
      @SerializedName("APPLICATION")
      VALUE_APPLICATION("APPLICATION"),
      @SerializedName("DOMAIN")
      VALUE_DOMAIN("DOMAIN"),
      @SerializedName("EVENT")
      VALUE_EVENT("EVENT"),
      @SerializedName("OFFER")
      VALUE_OFFER("OFFER"),
      @SerializedName("PAGE")
      VALUE_PAGE("PAGE"),
      @SerializedName("PHOTO")
      VALUE_PHOTO("PHOTO"),
      @SerializedName("SHARE")
      VALUE_SHARE("SHARE"),
      @SerializedName("STATUS")
      VALUE_STATUS("STATUS"),
      @SerializedName("STORE_ITEM")
      VALUE_STORE_ITEM("STORE_ITEM"),
      @SerializedName("VIDEO")
      VALUE_VIDEO("VIDEO"),
      @SerializedName("INVALID")
      VALUE_INVALID("INVALID"),
      NULL(null);

      private String value;

      private EnumObjectType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumStatus {
      @SerializedName("ACTIVE")
      VALUE_ACTIVE("ACTIVE"),
      @SerializedName("DELETED")
      VALUE_DELETED("DELETED"),
      NULL(null);

      private String value;

      private EnumStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDynamicAdVoice {
      @SerializedName("DYNAMIC")
      VALUE_DYNAMIC("DYNAMIC"),
      @SerializedName("STORY_OWNER")
      VALUE_STORY_OWNER("STORY_OWNER"),
      NULL(null);

      private String value;

      private EnumDynamicAdVoice(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOperator {
      @SerializedName("ALL")
      VALUE_ALL("ALL"),
      @SerializedName("ANY")
      VALUE_ANY("ANY"),
      NULL(null);

      private String value;

      private EnumOperator(String value) {
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

  public AdCreative copyFrom(AdCreative instance) {
    this.mAccountId = instance.mAccountId;
    this.mActorId = instance.mActorId;
    this.mAdlabels = instance.mAdlabels;
    this.mApplinkTreatment = instance.mApplinkTreatment;
    this.mBody = instance.mBody;
    this.mCallToActionType = instance.mCallToActionType;
    this.mEffectiveInstagramStoryId = instance.mEffectiveInstagramStoryId;
    this.mEffectiveObjectStoryId = instance.mEffectiveObjectStoryId;
    this.mId = instance.mId;
    this.mImageCrops = instance.mImageCrops;
    this.mImageHash = instance.mImageHash;
    this.mImageUrl = instance.mImageUrl;
    this.mInstagramActorId = instance.mInstagramActorId;
    this.mInstagramPermalinkUrl = instance.mInstagramPermalinkUrl;
    this.mInstagramStoryId = instance.mInstagramStoryId;
    this.mLinkOgId = instance.mLinkOgId;
    this.mLinkUrl = instance.mLinkUrl;
    this.mName = instance.mName;
    this.mObjectId = instance.mObjectId;
    this.mObjectStoryId = instance.mObjectStoryId;
    this.mObjectStorySpec = instance.mObjectStorySpec;
    this.mObjectType = instance.mObjectType;
    this.mObjectUrl = instance.mObjectUrl;
    this.mPlatformCustomizations = instance.mPlatformCustomizations;
    this.mProductSetId = instance.mProductSetId;
    this.mStatus = instance.mStatus;
    this.mTemplateUrl = instance.mTemplateUrl;
    this.mTemplateUrlSpec = instance.mTemplateUrlSpec;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mTitle = instance.mTitle;
    this.mUrlTags = instance.mUrlTags;
    this.mUsePageActorOverride = instance.mUsePageActorOverride;
    this.mVideoId = instance.mVideoId;
    this.mCreativeId = this.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreative> getParser() {
    return new APIRequest.ResponseParser<AdCreative>() {
      public APINodeList<AdCreative> parseResponse(String response, APIContext context, APIRequest<AdCreative> request) throws MalformedResponseException {
        return AdCreative.parseResponse(response, context, request);
      }
    };
  }
}
