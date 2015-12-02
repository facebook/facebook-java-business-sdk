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


public class AdCreative extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("actor_id")
  private String mActorId = null;
  @SerializedName("actor_image_hash")
  private String mActorImageHash = null;
  @SerializedName("actor_image_url")
  private String mActorImageUrl = null;
  @SerializedName("actor_name")
  private String mActorName = null;
  @SerializedName("adlabels")
  private List<AdLabel> mAdlabels = null;
  @SerializedName("body")
  private String mBody = null;
  @SerializedName("call_to_action_type")
  private EnumCallToActionType mCallToActionType = null;
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
  @SerializedName("link_og_id")
  private String mLinkOgId = null;
  @SerializedName("link_url")
  private String mLinkUrl = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("object_id")
  private String mObjectId = null;
  @SerializedName("object_url")
  private String mObjectUrl = null;
  @SerializedName("object_story_id")
  private String mObjectStoryId = null;
  @SerializedName("object_story_spec")
  private AdCreativeObjectStorySpec mObjectStorySpec = null;
  @SerializedName("object_type")
  private EnumObjectType mObjectType = null;
  @SerializedName("product_set_id")
  private String mProductSetId = null;
  @SerializedName("run_status")
  private EnumRunStatus mRunStatus = null;
  @SerializedName("template_url")
  private String mTemplateUrl = null;
  @SerializedName("thumbnail_url")
  private String mThumbnailUrl = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("url_tags")
  private String mUrlTags = null;
  @SerializedName("applink_treatment")
  private EnumApplinkTreatment mApplinkTreatment = null;
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
    this.mContext = context;
  }

  public AdCreative fetch() throws APIException{
    AdCreative newInstance = fetchById(this.getPrefixedId().toString(), this.mContext);
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
      .call();
    return adCreative;
  }

  private String getPrefixedId() {
    return mId.toString();
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
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreative.mContext = context;
    adCreative.rawValue = json;
    adCreative.mCreativeId = adCreative.mId.toString();
    return adCreative;
  }

  public static APINodeList<AdCreative> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AdCreative> adCreatives = new APINodeList<AdCreative>(request);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
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
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            adCreatives.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
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
            adCreatives.add(loadJSON(obj.toString(), context));
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
          // Fifth, check if it's pure JsonObject
          adCreatives.add(loadJSON(json, context));
          return adCreatives;
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

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestGetPreviews getPreviews() {
    return new APIRequestGetPreviews(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestCreateAdLabel createAdLabel() {
    return new APIRequestCreateAdLabel(this.getPrefixedId().toString(), mContext);
  }

  public APIRequestDeleteAdLabels deleteAdLabels() {
    return new APIRequestDeleteAdLabels(this.getPrefixedId().toString(), mContext);
  }


  public String getFieldId() {
    return mId;
  }

  public AdCreative setFieldId(String value) {
    this.mId = value;
    this.mCreativeId = this.mId.toString();
    return this;
  }

  public String getFieldActorId() {
    return mActorId;
  }

  public AdCreative setFieldActorId(String value) {
    this.mActorId = value;
    return this;
  }

  public String getFieldActorImageHash() {
    return mActorImageHash;
  }

  public AdCreative setFieldActorImageHash(String value) {
    this.mActorImageHash = value;
    return this;
  }

  public String getFieldActorImageUrl() {
    return mActorImageUrl;
  }

  public AdCreative setFieldActorImageUrl(String value) {
    this.mActorImageUrl = value;
    return this;
  }

  public String getFieldActorName() {
    return mActorName;
  }

  public AdCreative setFieldActorName(String value) {
    this.mActorName = value;
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

  public String getFieldObjectUrl() {
    return mObjectUrl;
  }

  public AdCreative setFieldObjectUrl(String value) {
    this.mObjectUrl = value;
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

  public String getFieldProductSetId() {
    return mProductSetId;
  }

  public AdCreative setFieldProductSetId(String value) {
    this.mProductSetId = value;
    return this;
  }

  public EnumRunStatus getFieldRunStatus() {
    return mRunStatus;
  }

  public AdCreative setFieldRunStatus(EnumRunStatus value) {
    this.mRunStatus = value;
    return this;
  }

  public String getFieldTemplateUrl() {
    return mTemplateUrl;
  }

  public AdCreative setFieldTemplateUrl(String value) {
    this.mTemplateUrl = value;
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

  public EnumApplinkTreatment getFieldApplinkTreatment() {
    return mApplinkTreatment;
  }

  public AdCreative setFieldApplinkTreatment(EnumApplinkTreatment value) {
    this.mApplinkTreatment = value;
    return this;
  }



  public static class APIRequestGet extends APIRequest<AdCreative> {

    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "actor_id",
      "actor_image_hash",
      "actor_image_url",
      "actor_name",
      "adlabels",
      "body",
      "call_to_action_type",
      "image_crops",
      "image_hash",
      "image_url",
      "instagram_actor_id",
      "instagram_permalink_url",
      "link_og_id",
      "link_url",
      "name",
      "object_id",
      "object_url",
      "object_story_id",
      "object_story_spec",
      "object_type",
      "product_set_id",
      "run_status",
      "template_url",
      "thumbnail_url",
      "title",
      "url_tags",
      "applink_treatment",
    };

    @Override
    public AdCreative call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public AdCreative call(Map<String, Object> extraParams) throws APIException {
      return AdCreative.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

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

    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGet requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGet requestActorImageHashField () {
      return this.requestActorImageHashField(true);
    }
    public APIRequestGet requestActorImageHashField (boolean value) {
      this.requestField("actor_image_hash", value);
      return this;
    }
    public APIRequestGet requestActorImageUrlField () {
      return this.requestActorImageUrlField(true);
    }
    public APIRequestGet requestActorImageUrlField (boolean value) {
      this.requestField("actor_image_url", value);
      return this;
    }
    public APIRequestGet requestActorNameField () {
      return this.requestActorNameField(true);
    }
    public APIRequestGet requestActorNameField (boolean value) {
      this.requestField("actor_name", value);
      return this;
    }
    public APIRequestGet requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGet requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
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
    public APIRequestGet requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGet requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
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
    public APIRequestGet requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGet requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGet requestRunStatusField () {
      return this.requestRunStatusField(true);
    }
    public APIRequestGet requestRunStatusField (boolean value) {
      this.requestField("run_status", value);
      return this;
    }
    public APIRequestGet requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGet requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
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
    public APIRequestGet requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGet requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }

  }

  public static class APIRequestUpdate extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
      "account_id",
      "name",
      "run_status",
      "adlabels",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestUpdate setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestUpdate setRunStatus (Long runStatus) {
      this.setParam("run_status", runStatus);
      return this;
    }

    public APIRequestUpdate setRunStatus (String runStatus) {
      this.setParam("run_status", runStatus);
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

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
      "account_id",
      "name",
      "run_status",
      "adlabels",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete setId (String id) {
      this.setParam("id", id);
      return this;
    }


    public APIRequestDelete setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }


    public APIRequestDelete setName (String name) {
      this.setParam("name", name);
      return this;
    }


    public APIRequestDelete setRunStatus (Long runStatus) {
      this.setParam("run_status", runStatus);
      return this;
    }

    public APIRequestDelete setRunStatus (String runStatus) {
      this.setParam("run_status", runStatus);
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

    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestGetPreviews extends APIRequest<AdPreview> {

    public static final String[] PARAMS = {
      "ad_format",
      "post",
      "height",
      "width",
      "product_item_ids",
      "locale",
    };

    public static final String[] FIELDS = {
      "body",
    };

    @Override
    public APINodeList<AdPreview> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdPreview> call(Map<String, Object> extraParams) throws APIException {
      return AdPreview.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestGetPreviews(String nodeId, APIContext context) {
      super(context, nodeId, "/previews", "GET", Arrays.asList(PARAMS));
    }

    public APIRequestGetPreviews setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestGetPreviews setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPreviews setAdFormat (EnumAdFormat adFormat) {
      this.setParam("ad_format", adFormat);
      return this;
    }

    public APIRequestGetPreviews setAdFormat (String adFormat) {
      this.setParam("ad_format", adFormat);
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

    public APIRequestGetPreviews setHeight (Long height) {
      this.setParam("height", height);
      return this;
    }

    public APIRequestGetPreviews setHeight (String height) {
      this.setParam("height", height);
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

    public APIRequestGetPreviews setProductItemIds (List<String> productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }

    public APIRequestGetPreviews setProductItemIds (String productItemIds) {
      this.setParam("product_item_ids", productItemIds);
      return this;
    }

    public APIRequestGetPreviews setLocale (String locale) {
      this.setParam("locale", locale);
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

    public APIRequestGetPreviews requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestGetPreviews requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

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

  public static class APIRequestCreateAdLabel extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
      "adlabels",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINode call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this).head();
    }

    public APIRequestCreateAdLabel(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "POST", Arrays.asList(PARAMS));
    }

    public APIRequestCreateAdLabel setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestCreateAdLabel setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAdLabel setId (String id) {
      this.setParam("id", id);
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

    public APIRequestCreateAdLabel requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestCreateAdLabel requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestCreateAdLabel requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static class APIRequestDeleteAdLabels extends APIRequest<APINode> {

    public static final String[] PARAMS = {
      "id",
      "adlabels",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> call() throws APIException {
      return call(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> call(Map<String, Object> extraParams) throws APIException {
      return APINode.parseResponse(callInternal(extraParams), getContext(), this);
    }

    public APIRequestDeleteAdLabels(String nodeId, APIContext context) {
      super(context, nodeId, "/adlabels", "DELETE", Arrays.asList(PARAMS));
    }

    public APIRequestDeleteAdLabels setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    public APIRequestDeleteAdLabels setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteAdLabels setId (String id) {
      this.setParam("id", id);
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

    public APIRequestDeleteAdLabels requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    public APIRequestDeleteAdLabels requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    public APIRequestDeleteAdLabels requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }


  }

  public static enum EnumAdFormat {
    @SerializedName("RIGHT_COLUMN_STANDARD")
    VALUE_RIGHT_COLUMN_STANDARD("RIGHT_COLUMN_STANDARD"),
    @SerializedName("DESKTOP_FEED_STANDARD")
    VALUE_DESKTOP_FEED_STANDARD("DESKTOP_FEED_STANDARD"),
    @SerializedName("MOBILE_FEED_STANDARD")
    VALUE_MOBILE_FEED_STANDARD("MOBILE_FEED_STANDARD"),
    @SerializedName("MOBILE_FEED_BASIC")
    VALUE_MOBILE_FEED_BASIC("MOBILE_FEED_BASIC"),
    @SerializedName("MOBILE_INTERSTITIAL")
    VALUE_MOBILE_INTERSTITIAL("MOBILE_INTERSTITIAL"),
    @SerializedName("MOBILE_BANNER")
    VALUE_MOBILE_BANNER("MOBILE_BANNER"),
    @SerializedName("MOBILE_NATIVE")
    VALUE_MOBILE_NATIVE("MOBILE_NATIVE"),
    @SerializedName("INSTAGRAM_STANDARD")
    VALUE_INSTAGRAM_STANDARD("INSTAGRAM_STANDARD"),
    @SerializedName("LIVERAIL_VIDEO")
    VALUE_LIVERAIL_VIDEO("LIVERAIL_VIDEO"),
    NULL(null);

    private String value;

    private EnumAdFormat(String value) {
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
    @SerializedName("WATCH_VIDEO")
    VALUE_WATCH_VIDEO("WATCH_VIDEO"),
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
    @SerializedName("BUY_NOW")
    VALUE_BUY_NOW("BUY_NOW"),
    @SerializedName("GET_OFFER")
    VALUE_GET_OFFER("GET_OFFER"),
    @SerializedName("GET_DIRECTIONS")
    VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
    @SerializedName("MESSAGE_PAGE")
    VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
    @SerializedName("SUBSCRIBE")
    VALUE_SUBSCRIBE("SUBSCRIBE"),
    @SerializedName("DONATE_NOW")
    VALUE_DONATE_NOW("DONATE_NOW"),
    @SerializedName("GET_QUOTE")
    VALUE_GET_QUOTE("GET_QUOTE"),
    @SerializedName("CONTACT_US")
    VALUE_CONTACT_US("CONTACT_US"),
    @SerializedName("RECORD_NOW")
    VALUE_RECORD_NOW("RECORD_NOW"),
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
    @SerializedName("ACTION_SPEC")
    VALUE_ACTION_SPEC("ACTION_SPEC"),
    @SerializedName("INSTAGRAM_MEDIA")
    VALUE_INSTAGRAM_MEDIA("INSTAGRAM_MEDIA"),
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
  public static enum EnumRunStatus {
    @SerializedName("ACTIVE")
    VALUE_ACTIVE("ACTIVE"),
    @SerializedName("DELETED")
    VALUE_DELETED("DELETED"),
    NULL(null);

    private String value;

    private EnumRunStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
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
    this.mId = instance.mId;
    this.mActorId = instance.mActorId;
    this.mActorImageHash = instance.mActorImageHash;
    this.mActorImageUrl = instance.mActorImageUrl;
    this.mActorName = instance.mActorName;
    this.mAdlabels = instance.mAdlabels;
    this.mBody = instance.mBody;
    this.mCallToActionType = instance.mCallToActionType;
    this.mImageCrops = instance.mImageCrops;
    this.mImageHash = instance.mImageHash;
    this.mImageUrl = instance.mImageUrl;
    this.mInstagramActorId = instance.mInstagramActorId;
    this.mInstagramPermalinkUrl = instance.mInstagramPermalinkUrl;
    this.mLinkOgId = instance.mLinkOgId;
    this.mLinkUrl = instance.mLinkUrl;
    this.mName = instance.mName;
    this.mObjectId = instance.mObjectId;
    this.mObjectUrl = instance.mObjectUrl;
    this.mObjectStoryId = instance.mObjectStoryId;
    this.mObjectStorySpec = instance.mObjectStorySpec;
    this.mObjectType = instance.mObjectType;
    this.mProductSetId = instance.mProductSetId;
    this.mRunStatus = instance.mRunStatus;
    this.mTemplateUrl = instance.mTemplateUrl;
    this.mThumbnailUrl = instance.mThumbnailUrl;
    this.mTitle = instance.mTitle;
    this.mUrlTags = instance.mUrlTags;
    this.mApplinkTreatment = instance.mApplinkTreatment;
    this.mCreativeId = this.mId;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }
}