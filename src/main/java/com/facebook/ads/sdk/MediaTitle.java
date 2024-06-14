/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
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
import com.google.common.util.concurrent.MoreExecutors;
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
public class MediaTitle extends APINode {
  @SerializedName("applinks")
  private CatalogItemAppLinks mApplinks = null;
  @SerializedName("category_specific_fields")
  private CatalogSubVerticalList mCategorySpecificFields = null;
  @SerializedName("content_category")
  private String mContentCategory = null;
  @SerializedName("currency")
  private String mCurrency = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("fb_page_alias")
  private String mFbPageAlias = null;
  @SerializedName("fb_page_id")
  private Page mFbPageId = null;
  @SerializedName("genres")
  private List<String> mGenres = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_fetch_status")
  private EnumImageFetchStatus mImageFetchStatus = null;
  @SerializedName("images")
  private List<String> mImages = null;
  @SerializedName("kg_fb_id")
  private String mKgFbId = null;
  @SerializedName("media_title_id")
  private String mMediaTitleId = null;
  @SerializedName("price")
  private String mPrice = null;
  @SerializedName("sanitized_images")
  private List<String> mSanitizedImages = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("title_display_name")
  private String mTitleDisplayName = null;
  @SerializedName("unit_price")
  private Object mUnitPrice = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("visibility")
  private EnumVisibility mVisibility = null;
  @SerializedName("wiki_data_item")
  private String mWikiDataItem = null;
  protected static Gson gson = null;

  MediaTitle() {
  }

  public MediaTitle(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MediaTitle(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MediaTitle fetch() throws APIException{
    MediaTitle newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MediaTitle fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MediaTitle> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MediaTitle fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MediaTitle> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MediaTitle> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MediaTitle>)(
      new APIRequest<MediaTitle>(context, "", "/", "GET", MediaTitle.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MediaTitle>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MediaTitle.getParser())
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
  public static MediaTitle loadJSON(String json, APIContext context, String header) {
    MediaTitle mediaTitle = getGson().fromJson(json, MediaTitle.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(mediaTitle.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    mediaTitle.context = context;
    mediaTitle.rawValue = json;
    mediaTitle.header = header;
    return mediaTitle;
  }

  public static APINodeList<MediaTitle> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MediaTitle> mediaTitles = new APINodeList<MediaTitle>(request, json, header);
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
          mediaTitles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return mediaTitles;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                mediaTitles.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            mediaTitles.setPaging(previous, next);
            if (context.hasAppSecret()) {
              mediaTitles.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              mediaTitles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  mediaTitles.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              mediaTitles.add(loadJSON(obj.toString(), context, header));
            }
          }
          return mediaTitles;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mediaTitles.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return mediaTitles;
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
              mediaTitles.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return mediaTitles;
          }

          // Sixth, check if it's pure JsonObject
          mediaTitles.clear();
          mediaTitles.add(loadJSON(json, context, header));
          return mediaTitles;
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

  public APIRequestGetAugmentedRealitiesMetadata getAugmentedRealitiesMetadata() {
    return new APIRequestGetAugmentedRealitiesMetadata(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetChannelsToIntegrityStatus getChannelsToIntegrityStatus() {
    return new APIRequestGetChannelsToIntegrityStatus(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideosMetadata getVideosMetadata() {
    return new APIRequestGetVideosMetadata(this.getPrefixedId().toString(), context);
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


  public CatalogItemAppLinks getFieldApplinks() {
    return mApplinks;
  }

  public CatalogSubVerticalList getFieldCategorySpecificFields() {
    return mCategorySpecificFields;
  }

  public String getFieldContentCategory() {
    return mContentCategory;
  }

  public String getFieldCurrency() {
    return mCurrency;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldFbPageAlias() {
    return mFbPageAlias;
  }

  public Page getFieldFbPageId() {
    if (mFbPageId != null) {
      mFbPageId.context = getContext();
    }
    return mFbPageId;
  }

  public List<String> getFieldGenres() {
    return mGenres;
  }

  public String getFieldId() {
    return mId;
  }

  public EnumImageFetchStatus getFieldImageFetchStatus() {
    return mImageFetchStatus;
  }

  public List<String> getFieldImages() {
    return mImages;
  }

  public String getFieldKgFbId() {
    return mKgFbId;
  }

  public String getFieldMediaTitleId() {
    return mMediaTitleId;
  }

  public String getFieldPrice() {
    return mPrice;
  }

  public List<String> getFieldSanitizedImages() {
    return mSanitizedImages;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldTitleDisplayName() {
    return mTitleDisplayName;
  }

  public Object getFieldUnitPrice() {
    return mUnitPrice;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public EnumVisibility getFieldVisibility() {
    return mVisibility;
  }

  public String getFieldWikiDataItem() {
    return mWikiDataItem;
  }



  public static class APIRequestGetAugmentedRealitiesMetadata extends APIRequest<DynamicARMetadata> {

    APINodeList<DynamicARMetadata> lastResponse = null;
    @Override
    public APINodeList<DynamicARMetadata> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "anchor_point",
      "container_effect_enum",
      "effect_icon_url",
      "effect_id",
      "id",
      "platforms",
      "scale_factor",
      "shadow_texture_url",
      "source_url",
      "state",
      "tags",
      "variant_picker_url",
    };

    @Override
    public APINodeList<DynamicARMetadata> parseResponse(String response, String header) throws APIException {
      return DynamicARMetadata.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<DynamicARMetadata> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DynamicARMetadata> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DynamicARMetadata>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DynamicARMetadata>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<DynamicARMetadata>>() {
           public APINodeList<DynamicARMetadata> apply(ResponseWrapper result) {
             try {
               return APIRequestGetAugmentedRealitiesMetadata.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetAugmentedRealitiesMetadata(String nodeId, APIContext context) {
      super(context, nodeId, "/augmented_realities_metadata", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAugmentedRealitiesMetadata requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAugmentedRealitiesMetadata requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAugmentedRealitiesMetadata requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetAugmentedRealitiesMetadata requestAnchorPointField () {
      return this.requestAnchorPointField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestAnchorPointField (boolean value) {
      this.requestField("anchor_point", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestContainerEffectEnumField () {
      return this.requestContainerEffectEnumField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestContainerEffectEnumField (boolean value) {
      this.requestField("container_effect_enum", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestEffectIconUrlField () {
      return this.requestEffectIconUrlField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestEffectIconUrlField (boolean value) {
      this.requestField("effect_icon_url", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestEffectIdField () {
      return this.requestEffectIdField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestEffectIdField (boolean value) {
      this.requestField("effect_id", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestPlatformsField () {
      return this.requestPlatformsField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestPlatformsField (boolean value) {
      this.requestField("platforms", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestScaleFactorField () {
      return this.requestScaleFactorField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestScaleFactorField (boolean value) {
      this.requestField("scale_factor", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestShadowTextureUrlField () {
      return this.requestShadowTextureUrlField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestShadowTextureUrlField (boolean value) {
      this.requestField("shadow_texture_url", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestSourceUrlField () {
      return this.requestSourceUrlField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestSourceUrlField (boolean value) {
      this.requestField("source_url", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestStateField (boolean value) {
      this.requestField("state", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGetAugmentedRealitiesMetadata requestVariantPickerUrlField () {
      return this.requestVariantPickerUrlField(true);
    }
    public APIRequestGetAugmentedRealitiesMetadata requestVariantPickerUrlField (boolean value) {
      this.requestField("variant_picker_url", value);
      return this;
    }
  }

  public static class APIRequestGetChannelsToIntegrityStatus extends APIRequest<CatalogItemChannelsToIntegrityStatus> {

    APINodeList<CatalogItemChannelsToIntegrityStatus> lastResponse = null;
    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "channels",
      "rejection_information",
    };

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> parseResponse(String response, String header) throws APIException {
      return CatalogItemChannelsToIntegrityStatus.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CatalogItemChannelsToIntegrityStatus> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CatalogItemChannelsToIntegrityStatus>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CatalogItemChannelsToIntegrityStatus>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CatalogItemChannelsToIntegrityStatus>>() {
           public APINodeList<CatalogItemChannelsToIntegrityStatus> apply(ResponseWrapper result) {
             try {
               return APIRequestGetChannelsToIntegrityStatus.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetChannelsToIntegrityStatus(String nodeId, APIContext context) {
      super(context, nodeId, "/channels_to_integrity_status", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetChannelsToIntegrityStatus requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetChannelsToIntegrityStatus requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetChannelsToIntegrityStatus requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetChannelsToIntegrityStatus requestChannelsField () {
      return this.requestChannelsField(true);
    }
    public APIRequestGetChannelsToIntegrityStatus requestChannelsField (boolean value) {
      this.requestField("channels", value);
      return this;
    }
    public APIRequestGetChannelsToIntegrityStatus requestRejectionInformationField () {
      return this.requestRejectionInformationField(true);
    }
    public APIRequestGetChannelsToIntegrityStatus requestRejectionInformationField (boolean value) {
      this.requestField("rejection_information", value);
      return this;
    }
  }

  public static class APIRequestGetVideosMetadata extends APIRequest<DynamicVideoMetadata> {

    APINodeList<DynamicVideoMetadata> lastResponse = null;
    @Override
    public APINodeList<DynamicVideoMetadata> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "tags",
      "url",
      "video",
    };

    @Override
    public APINodeList<DynamicVideoMetadata> parseResponse(String response, String header) throws APIException {
      return DynamicVideoMetadata.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<DynamicVideoMetadata> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DynamicVideoMetadata> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DynamicVideoMetadata>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DynamicVideoMetadata>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<DynamicVideoMetadata>>() {
           public APINodeList<DynamicVideoMetadata> apply(ResponseWrapper result) {
             try {
               return APIRequestGetVideosMetadata.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetVideosMetadata(String nodeId, APIContext context) {
      super(context, nodeId, "/videos_metadata", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideosMetadata setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideosMetadata requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideosMetadata requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideosMetadata requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideosMetadata requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetVideosMetadata requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetVideosMetadata requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetVideosMetadata requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGetVideosMetadata requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGetVideosMetadata requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGetVideosMetadata requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGetVideosMetadata requestVideoField () {
      return this.requestVideoField(true);
    }
    public APIRequestGetVideosMetadata requestVideoField (boolean value) {
      this.requestField("video", value);
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
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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

  public static class APIRequestGet extends APIRequest<MediaTitle> {

    MediaTitle lastResponse = null;
    @Override
    public MediaTitle getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "applinks",
      "category_specific_fields",
      "content_category",
      "currency",
      "description",
      "fb_page_alias",
      "fb_page_id",
      "genres",
      "id",
      "image_fetch_status",
      "images",
      "kg_fb_id",
      "media_title_id",
      "price",
      "sanitized_images",
      "title",
      "title_display_name",
      "unit_price",
      "url",
      "visibility",
      "wiki_data_item",
    };

    @Override
    public MediaTitle parseResponse(String response, String header) throws APIException {
      return MediaTitle.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MediaTitle execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MediaTitle execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MediaTitle> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MediaTitle> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MediaTitle>() {
           public MediaTitle apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

    public APIRequestGet requestApplinksField () {
      return this.requestApplinksField(true);
    }
    public APIRequestGet requestApplinksField (boolean value) {
      this.requestField("applinks", value);
      return this;
    }
    public APIRequestGet requestCategorySpecificFieldsField () {
      return this.requestCategorySpecificFieldsField(true);
    }
    public APIRequestGet requestCategorySpecificFieldsField (boolean value) {
      this.requestField("category_specific_fields", value);
      return this;
    }
    public APIRequestGet requestContentCategoryField () {
      return this.requestContentCategoryField(true);
    }
    public APIRequestGet requestContentCategoryField (boolean value) {
      this.requestField("content_category", value);
      return this;
    }
    public APIRequestGet requestCurrencyField () {
      return this.requestCurrencyField(true);
    }
    public APIRequestGet requestCurrencyField (boolean value) {
      this.requestField("currency", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestFbPageAliasField () {
      return this.requestFbPageAliasField(true);
    }
    public APIRequestGet requestFbPageAliasField (boolean value) {
      this.requestField("fb_page_alias", value);
      return this;
    }
    public APIRequestGet requestFbPageIdField () {
      return this.requestFbPageIdField(true);
    }
    public APIRequestGet requestFbPageIdField (boolean value) {
      this.requestField("fb_page_id", value);
      return this;
    }
    public APIRequestGet requestGenresField () {
      return this.requestGenresField(true);
    }
    public APIRequestGet requestGenresField (boolean value) {
      this.requestField("genres", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImageFetchStatusField () {
      return this.requestImageFetchStatusField(true);
    }
    public APIRequestGet requestImageFetchStatusField (boolean value) {
      this.requestField("image_fetch_status", value);
      return this;
    }
    public APIRequestGet requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGet requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGet requestKgFbIdField () {
      return this.requestKgFbIdField(true);
    }
    public APIRequestGet requestKgFbIdField (boolean value) {
      this.requestField("kg_fb_id", value);
      return this;
    }
    public APIRequestGet requestMediaTitleIdField () {
      return this.requestMediaTitleIdField(true);
    }
    public APIRequestGet requestMediaTitleIdField (boolean value) {
      this.requestField("media_title_id", value);
      return this;
    }
    public APIRequestGet requestPriceField () {
      return this.requestPriceField(true);
    }
    public APIRequestGet requestPriceField (boolean value) {
      this.requestField("price", value);
      return this;
    }
    public APIRequestGet requestSanitizedImagesField () {
      return this.requestSanitizedImagesField(true);
    }
    public APIRequestGet requestSanitizedImagesField (boolean value) {
      this.requestField("sanitized_images", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestTitleDisplayNameField () {
      return this.requestTitleDisplayNameField(true);
    }
    public APIRequestGet requestTitleDisplayNameField (boolean value) {
      this.requestField("title_display_name", value);
      return this;
    }
    public APIRequestGet requestUnitPriceField () {
      return this.requestUnitPriceField(true);
    }
    public APIRequestGet requestUnitPriceField (boolean value) {
      this.requestField("unit_price", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestVisibilityField () {
      return this.requestVisibilityField(true);
    }
    public APIRequestGet requestVisibilityField (boolean value) {
      this.requestField("visibility", value);
      return this;
    }
    public APIRequestGet requestWikiDataItemField () {
      return this.requestWikiDataItemField(true);
    }
    public APIRequestGet requestWikiDataItemField (boolean value) {
      this.requestField("wiki_data_item", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<MediaTitle> {

    MediaTitle lastResponse = null;
    @Override
    public MediaTitle getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "applinks",
      "content_category",
      "currency",
      "description",
      "fb_page_id",
      "genres",
      "images",
      "kg_fb_id",
      "price",
      "title",
      "title_display_name",
      "url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public MediaTitle parseResponse(String response, String header) throws APIException {
      return MediaTitle.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MediaTitle execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MediaTitle execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MediaTitle> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MediaTitle> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MediaTitle>() {
           public MediaTitle apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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


    public APIRequestUpdate setApplinks (Object applinks) {
      this.setParam("applinks", applinks);
      return this;
    }
    public APIRequestUpdate setApplinks (String applinks) {
      this.setParam("applinks", applinks);
      return this;
    }

    public APIRequestUpdate setContentCategory (MediaTitle.EnumContentCategory contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }
    public APIRequestUpdate setContentCategory (String contentCategory) {
      this.setParam("content_category", contentCategory);
      return this;
    }

    public APIRequestUpdate setCurrency (String currency) {
      this.setParam("currency", currency);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setFbPageId (String fbPageId) {
      this.setParam("fb_page_id", fbPageId);
      return this;
    }

    public APIRequestUpdate setGenres (List<String> genres) {
      this.setParam("genres", genres);
      return this;
    }
    public APIRequestUpdate setGenres (String genres) {
      this.setParam("genres", genres);
      return this;
    }

    public APIRequestUpdate setImages (List<Object> images) {
      this.setParam("images", images);
      return this;
    }
    public APIRequestUpdate setImages (String images) {
      this.setParam("images", images);
      return this;
    }

    public APIRequestUpdate setKgFbId (String kgFbId) {
      this.setParam("kg_fb_id", kgFbId);
      return this;
    }

    public APIRequestUpdate setPrice (Long price) {
      this.setParam("price", price);
      return this;
    }
    public APIRequestUpdate setPrice (String price) {
      this.setParam("price", price);
      return this;
    }

    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
      return this;
    }

    public APIRequestUpdate setTitleDisplayName (String titleDisplayName) {
      this.setParam("title_display_name", titleDisplayName);
      return this;
    }

    public APIRequestUpdate setUrl (String url) {
      this.setParam("url", url);
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

  public static enum EnumImageFetchStatus {
      @SerializedName("DIRECT_UPLOAD")
      VALUE_DIRECT_UPLOAD("DIRECT_UPLOAD"),
      @SerializedName("FETCHED")
      VALUE_FETCHED("FETCHED"),
      @SerializedName("FETCH_FAILED")
      VALUE_FETCH_FAILED("FETCH_FAILED"),
      @SerializedName("NO_STATUS")
      VALUE_NO_STATUS("NO_STATUS"),
      @SerializedName("OUTDATED")
      VALUE_OUTDATED("OUTDATED"),
      @SerializedName("PARTIAL_FETCH")
      VALUE_PARTIAL_FETCH("PARTIAL_FETCH"),
      ;

      private String value;

      private EnumImageFetchStatus(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVisibility {
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      @SerializedName("STAGING")
      VALUE_STAGING("STAGING"),
      ;

      private String value;

      private EnumVisibility(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumContentCategory {
      @SerializedName("MOVIE")
      VALUE_MOVIE("MOVIE"),
      @SerializedName("MUSIC")
      VALUE_MUSIC("MUSIC"),
      @SerializedName("TV_SHOW")
      VALUE_TV_SHOW("TV_SHOW"),
      ;

      private String value;

      private EnumContentCategory(String value) {
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

  public MediaTitle copyFrom(MediaTitle instance) {
    this.mApplinks = instance.mApplinks;
    this.mCategorySpecificFields = instance.mCategorySpecificFields;
    this.mContentCategory = instance.mContentCategory;
    this.mCurrency = instance.mCurrency;
    this.mDescription = instance.mDescription;
    this.mFbPageAlias = instance.mFbPageAlias;
    this.mFbPageId = instance.mFbPageId;
    this.mGenres = instance.mGenres;
    this.mId = instance.mId;
    this.mImageFetchStatus = instance.mImageFetchStatus;
    this.mImages = instance.mImages;
    this.mKgFbId = instance.mKgFbId;
    this.mMediaTitleId = instance.mMediaTitleId;
    this.mPrice = instance.mPrice;
    this.mSanitizedImages = instance.mSanitizedImages;
    this.mTitle = instance.mTitle;
    this.mTitleDisplayName = instance.mTitleDisplayName;
    this.mUnitPrice = instance.mUnitPrice;
    this.mUrl = instance.mUrl;
    this.mVisibility = instance.mVisibility;
    this.mWikiDataItem = instance.mWikiDataItem;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MediaTitle> getParser() {
    return new APIRequest.ResponseParser<MediaTitle>() {
      public APINodeList<MediaTitle> parseResponse(String response, APIContext context, APIRequest<MediaTitle> request, String header) throws MalformedResponseException {
        return MediaTitle.parseResponse(response, context, request, header);
      }
    };
  }
}
