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
public class AdLabel extends APINode {
  @SerializedName("account")
  private AdAccount mAccount = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  protected static Gson gson = null;

  AdLabel() {
  }

  public AdLabel(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdLabel(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AdLabel fetch() throws APIException{
    AdLabel newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdLabel fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdLabel fetchById(String id, APIContext context) throws APIException {
    AdLabel adLabel =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adLabel;
  }

  public static APINodeList<AdLabel> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdLabel>)(
      new APIRequest<AdLabel>(context, "", "/", "GET", AdLabel.getParser())
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
  public static AdLabel loadJSON(String json, APIContext context) {
    AdLabel adLabel = getGson().fromJson(json, AdLabel.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adLabel.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adLabel.context = context;
    adLabel.rawValue = json;
    return adLabel;
  }

  public static APINodeList<AdLabel> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdLabel> adLabels = new APINodeList<AdLabel>(request, json);
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
          adLabels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adLabels;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adLabels.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adLabels.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adLabels.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adLabels.add(loadJSON(obj.toString(), context));
            }
          }
          return adLabels;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adLabels.add(loadJSON(entry.getValue().toString(), context));
          }
          return adLabels;
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
              adLabels.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adLabels;
          }

          // Sixth, check if it's pure JsonObject
          adLabels.clear();
          adLabels.add(loadJSON(json, context));
          return adLabels;
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

  public APIRequestGetAdCreatives getAdCreatives() {
    return new APIRequestGetAdCreatives(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAds getAds() {
    return new APIRequestGetAds(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetAdSets getAdSets() {
    return new APIRequestGetAdSets(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCampaigns getCampaigns() {
    return new APIRequestGetCampaigns(this.getPrefixedId().toString(), context);
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


  public AdAccount getFieldAccount() {
    if (mAccount != null) {
      mAccount.context = getContext();
    }
    return mAccount;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }



  public static class APIRequestGetAdCreatives extends APIRequest<AdCreative> {

    APINodeList<AdCreative> lastResponse = null;
    @Override
    public APINodeList<AdCreative> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
    public APINodeList<AdCreative> parseResponse(String response) throws APIException {
      return AdCreative.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdCreative> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdCreative> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdCreatives(String nodeId, APIContext context) {
      super(context, nodeId, "/adcreatives", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdCreatives setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdCreatives setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdCreatives requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdCreatives requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdCreatives requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdCreatives requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdCreatives requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdCreatives requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestActorIdField () {
      return this.requestActorIdField(true);
    }
    public APIRequestGetAdCreatives requestActorIdField (boolean value) {
      this.requestField("actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdCreatives requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField () {
      return this.requestApplinkTreatmentField(true);
    }
    public APIRequestGetAdCreatives requestApplinkTreatmentField (boolean value) {
      this.requestField("applink_treatment", value);
      return this;
    }
    public APIRequestGetAdCreatives requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetAdCreatives requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField () {
      return this.requestCallToActionTypeField(true);
    }
    public APIRequestGetAdCreatives requestCallToActionTypeField (boolean value) {
      this.requestField("call_to_action_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField () {
      return this.requestEffectiveInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveInstagramStoryIdField (boolean value) {
      this.requestField("effective_instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField () {
      return this.requestEffectiveObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestEffectiveObjectStoryIdField (boolean value) {
      this.requestField("effective_object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdCreatives requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGetAdCreatives requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGetAdCreatives requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
      return this;
    }
    public APIRequestGetAdCreatives requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGetAdCreatives requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField () {
      return this.requestInstagramActorIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramActorIdField (boolean value) {
      this.requestField("instagram_actor_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField () {
      return this.requestInstagramPermalinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestInstagramPermalinkUrlField (boolean value) {
      this.requestField("instagram_permalink_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestInstagramStoryIdField () {
      return this.requestInstagramStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestInstagramStoryIdField (boolean value) {
      this.requestField("instagram_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkOgIdField () {
      return this.requestLinkOgIdField(true);
    }
    public APIRequestGetAdCreatives requestLinkOgIdField (boolean value) {
      this.requestField("link_og_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGetAdCreatives requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdCreatives requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectIdField () {
      return this.requestObjectIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectIdField (boolean value) {
      this.requestField("object_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField () {
      return this.requestObjectStoryIdField(true);
    }
    public APIRequestGetAdCreatives requestObjectStoryIdField (boolean value) {
      this.requestField("object_story_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField () {
      return this.requestObjectStorySpecField(true);
    }
    public APIRequestGetAdCreatives requestObjectStorySpecField (boolean value) {
      this.requestField("object_story_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectTypeField () {
      return this.requestObjectTypeField(true);
    }
    public APIRequestGetAdCreatives requestObjectTypeField (boolean value) {
      this.requestField("object_type", value);
      return this;
    }
    public APIRequestGetAdCreatives requestObjectUrlField () {
      return this.requestObjectUrlField(true);
    }
    public APIRequestGetAdCreatives requestObjectUrlField (boolean value) {
      this.requestField("object_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField () {
      return this.requestPlatformCustomizationsField(true);
    }
    public APIRequestGetAdCreatives requestPlatformCustomizationsField (boolean value) {
      this.requestField("platform_customizations", value);
      return this;
    }
    public APIRequestGetAdCreatives requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGetAdCreatives requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGetAdCreatives requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdCreatives requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlField () {
      return this.requestTemplateUrlField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlField (boolean value) {
      this.requestField("template_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField () {
      return this.requestTemplateUrlSpecField(true);
    }
    public APIRequestGetAdCreatives requestTemplateUrlSpecField (boolean value) {
      this.requestField("template_url_spec", value);
      return this;
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField () {
      return this.requestThumbnailUrlField(true);
    }
    public APIRequestGetAdCreatives requestThumbnailUrlField (boolean value) {
      this.requestField("thumbnail_url", value);
      return this;
    }
    public APIRequestGetAdCreatives requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGetAdCreatives requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGetAdCreatives requestUrlTagsField () {
      return this.requestUrlTagsField(true);
    }
    public APIRequestGetAdCreatives requestUrlTagsField (boolean value) {
      this.requestField("url_tags", value);
      return this;
    }
    public APIRequestGetAdCreatives requestUsePageActorOverrideField () {
      return this.requestUsePageActorOverrideField(true);
    }
    public APIRequestGetAdCreatives requestUsePageActorOverrideField (boolean value) {
      this.requestField("use_page_actor_override", value);
      return this;
    }
    public APIRequestGetAdCreatives requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGetAdCreatives requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
      return this;
    }
  }

  public static class APIRequestGetAds extends APIRequest<Ad> {

    APINodeList<Ad> lastResponse = null;
    @Override
    public APINodeList<Ad> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "ad_review_feedback",
      "adlabels",
      "adset",
      "adset_id",
      "bid_amount",
      "bid_info",
      "bid_type",
      "campaign",
      "campaign_id",
      "configured_status",
      "conversion_specs",
      "created_time",
      "creative",
      "effective_status",
      "id",
      "last_updated_by_app_id",
      "name",
      "recommendations",
      "source_ad",
      "source_ad_id",
      "status",
      "tracking_specs",
      "updated_time",
    };

    @Override
    public APINodeList<Ad> parseResponse(String response) throws APIException {
      return Ad.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Ad> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Ad> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAds(String nodeId, APIContext context) {
      super(context, nodeId, "/ads", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAds setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAds setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAds requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAds requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAds requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAds requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAds requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAds requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAds requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAds requestAdReviewFeedbackField () {
      return this.requestAdReviewFeedbackField(true);
    }
    public APIRequestGetAds requestAdReviewFeedbackField (boolean value) {
      this.requestField("ad_review_feedback", value);
      return this;
    }
    public APIRequestGetAds requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAds requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAds requestAdsetField () {
      return this.requestAdsetField(true);
    }
    public APIRequestGetAds requestAdsetField (boolean value) {
      this.requestField("adset", value);
      return this;
    }
    public APIRequestGetAds requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetAds requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetAds requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAds requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAds requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAds requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAds requestBidTypeField () {
      return this.requestBidTypeField(true);
    }
    public APIRequestGetAds requestBidTypeField (boolean value) {
      this.requestField("bid_type", value);
      return this;
    }
    public APIRequestGetAds requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAds requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAds requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAds requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAds requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAds requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAds requestConversionSpecsField () {
      return this.requestConversionSpecsField(true);
    }
    public APIRequestGetAds requestConversionSpecsField (boolean value) {
      this.requestField("conversion_specs", value);
      return this;
    }
    public APIRequestGetAds requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAds requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAds requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGetAds requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGetAds requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAds requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAds requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAds requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField () {
      return this.requestLastUpdatedByAppIdField(true);
    }
    public APIRequestGetAds requestLastUpdatedByAppIdField (boolean value) {
      this.requestField("last_updated_by_app_id", value);
      return this;
    }
    public APIRequestGetAds requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAds requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAds requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAds requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAds requestSourceAdField () {
      return this.requestSourceAdField(true);
    }
    public APIRequestGetAds requestSourceAdField (boolean value) {
      this.requestField("source_ad", value);
      return this;
    }
    public APIRequestGetAds requestSourceAdIdField () {
      return this.requestSourceAdIdField(true);
    }
    public APIRequestGetAds requestSourceAdIdField (boolean value) {
      this.requestField("source_ad_id", value);
      return this;
    }
    public APIRequestGetAds requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAds requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAds requestTrackingSpecsField () {
      return this.requestTrackingSpecsField(true);
    }
    public APIRequestGetAds requestTrackingSpecsField (boolean value) {
      this.requestField("tracking_specs", value);
      return this;
    }
    public APIRequestGetAds requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAds requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestGetAdSets extends APIRequest<AdSet> {

    APINodeList<AdSet> lastResponse = null;
    @Override
    public APINodeList<AdSet> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "adset_schedule",
      "attribution_spec",
      "bid_amount",
      "bid_info",
      "billing_event",
      "budget_remaining",
      "campaign",
      "campaign_id",
      "configured_status",
      "created_time",
      "creative_sequence",
      "daily_budget",
      "effective_status",
      "end_time",
      "frequency_cap",
      "frequency_cap_reset_period",
      "frequency_control_specs",
      "id",
      "is_autobid",
      "is_average_price_pacing",
      "lifetime_budget",
      "lifetime_frequency_cap",
      "lifetime_imps",
      "name",
      "optimization_goal",
      "pacing_type",
      "promoted_object",
      "recommendations",
      "recurring_budget_semantics",
      "rf_prediction_id",
      "rtb_flag",
      "source_adset",
      "source_adset_id",
      "start_time",
      "status",
      "targeting",
      "time_based_ad_rotation_id_blocks",
      "time_based_ad_rotation_intervals",
      "updated_time",
      "use_new_app_click",
    };

    @Override
    public APINodeList<AdSet> parseResponse(String response) throws APIException {
      return AdSet.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdSet> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdSet> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetAdSets(String nodeId, APIContext context) {
      super(context, nodeId, "/adsets", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAdSets setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAdSets setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAdSets requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAdSets requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSets requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAdSets requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAdSets requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAdSets requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAdSets requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetAdSets requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetAdSets requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetAdSets requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetAdSets requestAdsetScheduleField () {
      return this.requestAdsetScheduleField(true);
    }
    public APIRequestGetAdSets requestAdsetScheduleField (boolean value) {
      this.requestField("adset_schedule", value);
      return this;
    }
    public APIRequestGetAdSets requestAttributionSpecField () {
      return this.requestAttributionSpecField(true);
    }
    public APIRequestGetAdSets requestAttributionSpecField (boolean value) {
      this.requestField("attribution_spec", value);
      return this;
    }
    public APIRequestGetAdSets requestBidAmountField () {
      return this.requestBidAmountField(true);
    }
    public APIRequestGetAdSets requestBidAmountField (boolean value) {
      this.requestField("bid_amount", value);
      return this;
    }
    public APIRequestGetAdSets requestBidInfoField () {
      return this.requestBidInfoField(true);
    }
    public APIRequestGetAdSets requestBidInfoField (boolean value) {
      this.requestField("bid_info", value);
      return this;
    }
    public APIRequestGetAdSets requestBillingEventField () {
      return this.requestBillingEventField(true);
    }
    public APIRequestGetAdSets requestBillingEventField (boolean value) {
      this.requestField("billing_event", value);
      return this;
    }
    public APIRequestGetAdSets requestBudgetRemainingField () {
      return this.requestBudgetRemainingField(true);
    }
    public APIRequestGetAdSets requestBudgetRemainingField (boolean value) {
      this.requestField("budget_remaining", value);
      return this;
    }
    public APIRequestGetAdSets requestCampaignField () {
      return this.requestCampaignField(true);
    }
    public APIRequestGetAdSets requestCampaignField (boolean value) {
      this.requestField("campaign", value);
      return this;
    }
    public APIRequestGetAdSets requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetAdSets requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetAdSets requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetAdSets requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetAdSets requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetAdSets requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetAdSets requestCreativeSequenceField () {
      return this.requestCreativeSequenceField(true);
    }
    public APIRequestGetAdSets requestCreativeSequenceField (boolean value) {
      this.requestField("creative_sequence", value);
      return this;
    }
    public APIRequestGetAdSets requestDailyBudgetField () {
      return this.requestDailyBudgetField(true);
    }
    public APIRequestGetAdSets requestDailyBudgetField (boolean value) {
      this.requestField("daily_budget", value);
      return this;
    }
    public APIRequestGetAdSets requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetAdSets requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetAdSets requestEndTimeField () {
      return this.requestEndTimeField(true);
    }
    public APIRequestGetAdSets requestEndTimeField (boolean value) {
      this.requestField("end_time", value);
      return this;
    }
    public APIRequestGetAdSets requestFrequencyCapField () {
      return this.requestFrequencyCapField(true);
    }
    public APIRequestGetAdSets requestFrequencyCapField (boolean value) {
      this.requestField("frequency_cap", value);
      return this;
    }
    public APIRequestGetAdSets requestFrequencyCapResetPeriodField () {
      return this.requestFrequencyCapResetPeriodField(true);
    }
    public APIRequestGetAdSets requestFrequencyCapResetPeriodField (boolean value) {
      this.requestField("frequency_cap_reset_period", value);
      return this;
    }
    public APIRequestGetAdSets requestFrequencyControlSpecsField () {
      return this.requestFrequencyControlSpecsField(true);
    }
    public APIRequestGetAdSets requestFrequencyControlSpecsField (boolean value) {
      this.requestField("frequency_control_specs", value);
      return this;
    }
    public APIRequestGetAdSets requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAdSets requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAdSets requestIsAutobidField () {
      return this.requestIsAutobidField(true);
    }
    public APIRequestGetAdSets requestIsAutobidField (boolean value) {
      this.requestField("is_autobid", value);
      return this;
    }
    public APIRequestGetAdSets requestIsAveragePricePacingField () {
      return this.requestIsAveragePricePacingField(true);
    }
    public APIRequestGetAdSets requestIsAveragePricePacingField (boolean value) {
      this.requestField("is_average_price_pacing", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeBudgetField () {
      return this.requestLifetimeBudgetField(true);
    }
    public APIRequestGetAdSets requestLifetimeBudgetField (boolean value) {
      this.requestField("lifetime_budget", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeFrequencyCapField () {
      return this.requestLifetimeFrequencyCapField(true);
    }
    public APIRequestGetAdSets requestLifetimeFrequencyCapField (boolean value) {
      this.requestField("lifetime_frequency_cap", value);
      return this;
    }
    public APIRequestGetAdSets requestLifetimeImpsField () {
      return this.requestLifetimeImpsField(true);
    }
    public APIRequestGetAdSets requestLifetimeImpsField (boolean value) {
      this.requestField("lifetime_imps", value);
      return this;
    }
    public APIRequestGetAdSets requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetAdSets requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetAdSets requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGetAdSets requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGetAdSets requestPacingTypeField () {
      return this.requestPacingTypeField(true);
    }
    public APIRequestGetAdSets requestPacingTypeField (boolean value) {
      this.requestField("pacing_type", value);
      return this;
    }
    public APIRequestGetAdSets requestPromotedObjectField () {
      return this.requestPromotedObjectField(true);
    }
    public APIRequestGetAdSets requestPromotedObjectField (boolean value) {
      this.requestField("promoted_object", value);
      return this;
    }
    public APIRequestGetAdSets requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetAdSets requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetAdSets requestRecurringBudgetSemanticsField () {
      return this.requestRecurringBudgetSemanticsField(true);
    }
    public APIRequestGetAdSets requestRecurringBudgetSemanticsField (boolean value) {
      this.requestField("recurring_budget_semantics", value);
      return this;
    }
    public APIRequestGetAdSets requestRfPredictionIdField () {
      return this.requestRfPredictionIdField(true);
    }
    public APIRequestGetAdSets requestRfPredictionIdField (boolean value) {
      this.requestField("rf_prediction_id", value);
      return this;
    }
    public APIRequestGetAdSets requestRtbFlagField () {
      return this.requestRtbFlagField(true);
    }
    public APIRequestGetAdSets requestRtbFlagField (boolean value) {
      this.requestField("rtb_flag", value);
      return this;
    }
    public APIRequestGetAdSets requestSourceAdsetField () {
      return this.requestSourceAdsetField(true);
    }
    public APIRequestGetAdSets requestSourceAdsetField (boolean value) {
      this.requestField("source_adset", value);
      return this;
    }
    public APIRequestGetAdSets requestSourceAdsetIdField () {
      return this.requestSourceAdsetIdField(true);
    }
    public APIRequestGetAdSets requestSourceAdsetIdField (boolean value) {
      this.requestField("source_adset_id", value);
      return this;
    }
    public APIRequestGetAdSets requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetAdSets requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetAdSets requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetAdSets requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetAdSets requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGetAdSets requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIdBlocksField () {
      return this.requestTimeBasedAdRotationIdBlocksField(true);
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIdBlocksField (boolean value) {
      this.requestField("time_based_ad_rotation_id_blocks", value);
      return this;
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIntervalsField () {
      return this.requestTimeBasedAdRotationIntervalsField(true);
    }
    public APIRequestGetAdSets requestTimeBasedAdRotationIntervalsField (boolean value) {
      this.requestField("time_based_ad_rotation_intervals", value);
      return this;
    }
    public APIRequestGetAdSets requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetAdSets requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetAdSets requestUseNewAppClickField () {
      return this.requestUseNewAppClickField(true);
    }
    public APIRequestGetAdSets requestUseNewAppClickField (boolean value) {
      this.requestField("use_new_app_click", value);
      return this;
    }
  }

  public static class APIRequestGetCampaigns extends APIRequest<Campaign> {

    APINodeList<Campaign> lastResponse = null;
    @Override
    public APINodeList<Campaign> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "adlabels",
      "brand_lift_studies",
      "budget_rebalance_flag",
      "buying_type",
      "can_create_brand_lift_study",
      "can_use_spend_cap",
      "configured_status",
      "created_time",
      "effective_status",
      "id",
      "name",
      "objective",
      "recommendations",
      "source_campaign",
      "source_campaign_id",
      "spend_cap",
      "start_time",
      "status",
      "stop_time",
      "updated_time",
    };

    @Override
    public APINodeList<Campaign> parseResponse(String response) throws APIException {
      return Campaign.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<Campaign> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<Campaign> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetCampaigns(String nodeId, APIContext context) {
      super(context, nodeId, "/campaigns", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCampaigns setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCampaigns setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCampaigns requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCampaigns requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaigns requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCampaigns requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCampaigns requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCampaigns requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetCampaigns requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetCampaigns requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetCampaigns requestAdlabelsField () {
      return this.requestAdlabelsField(true);
    }
    public APIRequestGetCampaigns requestAdlabelsField (boolean value) {
      this.requestField("adlabels", value);
      return this;
    }
    public APIRequestGetCampaigns requestBrandLiftStudiesField () {
      return this.requestBrandLiftStudiesField(true);
    }
    public APIRequestGetCampaigns requestBrandLiftStudiesField (boolean value) {
      this.requestField("brand_lift_studies", value);
      return this;
    }
    public APIRequestGetCampaigns requestBudgetRebalanceFlagField () {
      return this.requestBudgetRebalanceFlagField(true);
    }
    public APIRequestGetCampaigns requestBudgetRebalanceFlagField (boolean value) {
      this.requestField("budget_rebalance_flag", value);
      return this;
    }
    public APIRequestGetCampaigns requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetCampaigns requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGetCampaigns requestCanCreateBrandLiftStudyField () {
      return this.requestCanCreateBrandLiftStudyField(true);
    }
    public APIRequestGetCampaigns requestCanCreateBrandLiftStudyField (boolean value) {
      this.requestField("can_create_brand_lift_study", value);
      return this;
    }
    public APIRequestGetCampaigns requestCanUseSpendCapField () {
      return this.requestCanUseSpendCapField(true);
    }
    public APIRequestGetCampaigns requestCanUseSpendCapField (boolean value) {
      this.requestField("can_use_spend_cap", value);
      return this;
    }
    public APIRequestGetCampaigns requestConfiguredStatusField () {
      return this.requestConfiguredStatusField(true);
    }
    public APIRequestGetCampaigns requestConfiguredStatusField (boolean value) {
      this.requestField("configured_status", value);
      return this;
    }
    public APIRequestGetCampaigns requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetCampaigns requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetCampaigns requestEffectiveStatusField () {
      return this.requestEffectiveStatusField(true);
    }
    public APIRequestGetCampaigns requestEffectiveStatusField (boolean value) {
      this.requestField("effective_status", value);
      return this;
    }
    public APIRequestGetCampaigns requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetCampaigns requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetCampaigns requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetCampaigns requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetCampaigns requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGetCampaigns requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGetCampaigns requestRecommendationsField () {
      return this.requestRecommendationsField(true);
    }
    public APIRequestGetCampaigns requestRecommendationsField (boolean value) {
      this.requestField("recommendations", value);
      return this;
    }
    public APIRequestGetCampaigns requestSourceCampaignField () {
      return this.requestSourceCampaignField(true);
    }
    public APIRequestGetCampaigns requestSourceCampaignField (boolean value) {
      this.requestField("source_campaign", value);
      return this;
    }
    public APIRequestGetCampaigns requestSourceCampaignIdField () {
      return this.requestSourceCampaignIdField(true);
    }
    public APIRequestGetCampaigns requestSourceCampaignIdField (boolean value) {
      this.requestField("source_campaign_id", value);
      return this;
    }
    public APIRequestGetCampaigns requestSpendCapField () {
      return this.requestSpendCapField(true);
    }
    public APIRequestGetCampaigns requestSpendCapField (boolean value) {
      this.requestField("spend_cap", value);
      return this;
    }
    public APIRequestGetCampaigns requestStartTimeField () {
      return this.requestStartTimeField(true);
    }
    public APIRequestGetCampaigns requestStartTimeField (boolean value) {
      this.requestField("start_time", value);
      return this;
    }
    public APIRequestGetCampaigns requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGetCampaigns requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGetCampaigns requestStopTimeField () {
      return this.requestStopTimeField(true);
    }
    public APIRequestGetCampaigns requestStopTimeField (boolean value) {
      this.requestField("stop_time", value);
      return this;
    }
    public APIRequestGetCampaigns requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetCampaigns requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
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

  public static class APIRequestGet extends APIRequest<AdLabel> {

    AdLabel lastResponse = null;
    @Override
    public AdLabel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account",
      "created_time",
      "id",
      "name",
      "updated_time",
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

    public APIRequestGet requestAccountField () {
      return this.requestAccountField(true);
    }
    public APIRequestGet requestAccountField (boolean value) {
      this.requestField("account", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdLabel> {

    AdLabel lastResponse = null;
    @Override
    public AdLabel getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
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


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

  public static enum EnumExecutionOptions {
      @SerializedName("validate_only")
      VALUE_VALIDATE_ONLY("validate_only"),
      NULL(null);

      private String value;

      private EnumExecutionOptions(String value) {
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

  public AdLabel copyFrom(AdLabel instance) {
    this.mAccount = instance.mAccount;
    this.mCreatedTime = instance.mCreatedTime;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdLabel> getParser() {
    return new APIRequest.ResponseParser<AdLabel>() {
      public APINodeList<AdLabel> parseResponse(String response, APIContext context, APIRequest<AdLabel> request) throws MalformedResponseException {
        return AdLabel.parseResponse(response, context, request);
      }
    };
  }
}
