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
public class Canvas extends APINode {
  @SerializedName("background_color")
  private String mBackgroundColor = null;
  @SerializedName("body_elements")
  private List<Object> mBodyElements = null;
  @SerializedName("business_id")
  private String mBusinessId = null;
  @SerializedName("canvas_link")
  private String mCanvasLink = null;
  @SerializedName("collection_hero_image")
  private Photo mCollectionHeroImage = null;
  @SerializedName("collection_hero_video")
  private AdVideo mCollectionHeroVideo = null;
  @SerializedName("collection_thumbnails")
  private List<CanvasCollectionThumbnail> mCollectionThumbnails = null;
  @SerializedName("dynamic_setting")
  private CanvasDynamicSetting mDynamicSetting = null;
  @SerializedName("element_payload")
  private String mElementPayload = null;
  @SerializedName("elements")
  private List<RichMediaElement> mElements = null;
  @SerializedName("fb_body_elements")
  private List<Object> mFbBodyElements = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_hidden")
  private Boolean mIsHidden = null;
  @SerializedName("is_published")
  private Boolean mIsPublished = null;
  @SerializedName("last_editor")
  private User mLastEditor = null;
  @SerializedName("linked_documents")
  private List<Canvas> mLinkedDocuments = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner")
  private Page mOwner = null;
  @SerializedName("property_list")
  private List<String> mPropertyList = null;
  @SerializedName("source_template")
  private CanvasTemplate mSourceTemplate = null;
  @SerializedName("store_url")
  private String mStoreUrl = null;
  @SerializedName("style_list")
  private List<String> mStyleList = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("ui_property_list")
  private List<String> mUiPropertyList = null;
  @SerializedName("unused_body_elements")
  private List<Object> mUnusedBodyElements = null;
  @SerializedName("update_time")
  private Long mUpdateTime = null;
  @SerializedName("use_retailer_item_ids")
  private Boolean mUseRetailerItemIds = null;
  protected static Gson gson = null;

  Canvas() {
  }

  public Canvas(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Canvas(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Canvas fetch() throws APIException{
    Canvas newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Canvas fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Canvas> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Canvas fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Canvas> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Canvas> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Canvas>)(
      new APIRequest<Canvas>(context, "", "/", "GET", Canvas.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Canvas>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Canvas.getParser())
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
  public static Canvas loadJSON(String json, APIContext context, String header) {
    Canvas canvas = getGson().fromJson(json, Canvas.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(canvas.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    canvas.context = context;
    canvas.rawValue = json;
    canvas.header = header;
    return canvas;
  }

  public static APINodeList<Canvas> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Canvas> canvass = new APINodeList<Canvas>(request, json, header);
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
          canvass.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return canvass;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                canvass.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            canvass.setPaging(previous, next);
            if (context.hasAppSecret()) {
              canvass.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              canvass.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  canvass.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              canvass.add(loadJSON(obj.toString(), context, header));
            }
          }
          return canvass;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              canvass.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return canvass;
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
              canvass.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return canvass;
          }

          // Sixth, check if it's pure JsonObject
          canvass.clear();
          canvass.add(loadJSON(json, context, header));
          return canvass;
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

  public APIRequestGetPreview getPreview() {
    return new APIRequestGetPreview(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPreviews getPreviews() {
    return new APIRequestGetPreviews(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldBackgroundColor() {
    return mBackgroundColor;
  }

  public List<Object> getFieldBodyElements() {
    return mBodyElements;
  }

  public String getFieldBusinessId() {
    return mBusinessId;
  }

  public String getFieldCanvasLink() {
    return mCanvasLink;
  }

  public Photo getFieldCollectionHeroImage() {
    if (mCollectionHeroImage != null) {
      mCollectionHeroImage.context = getContext();
    }
    return mCollectionHeroImage;
  }

  public AdVideo getFieldCollectionHeroVideo() {
    if (mCollectionHeroVideo != null) {
      mCollectionHeroVideo.context = getContext();
    }
    return mCollectionHeroVideo;
  }

  public List<CanvasCollectionThumbnail> getFieldCollectionThumbnails() {
    return mCollectionThumbnails;
  }

  public CanvasDynamicSetting getFieldDynamicSetting() {
    if (mDynamicSetting != null) {
      mDynamicSetting.context = getContext();
    }
    return mDynamicSetting;
  }

  public String getFieldElementPayload() {
    return mElementPayload;
  }

  public List<RichMediaElement> getFieldElements() {
    return mElements;
  }

  public List<Object> getFieldFbBodyElements() {
    return mFbBodyElements;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsHidden() {
    return mIsHidden;
  }

  public Boolean getFieldIsPublished() {
    return mIsPublished;
  }

  public User getFieldLastEditor() {
    if (mLastEditor != null) {
      mLastEditor.context = getContext();
    }
    return mLastEditor;
  }

  public List<Canvas> getFieldLinkedDocuments() {
    return mLinkedDocuments;
  }

  public String getFieldName() {
    return mName;
  }

  public Page getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public List<String> getFieldPropertyList() {
    return mPropertyList;
  }

  public CanvasTemplate getFieldSourceTemplate() {
    if (mSourceTemplate != null) {
      mSourceTemplate.context = getContext();
    }
    return mSourceTemplate;
  }

  public String getFieldStoreUrl() {
    return mStoreUrl;
  }

  public List<String> getFieldStyleList() {
    return mStyleList;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public List<String> getFieldUiPropertyList() {
    return mUiPropertyList;
  }

  public List<Object> getFieldUnusedBodyElements() {
    return mUnusedBodyElements;
  }

  public Long getFieldUpdateTime() {
    return mUpdateTime;
  }

  public Boolean getFieldUseRetailerItemIds() {
    return mUseRetailerItemIds;
  }



  public static class APIRequestGetPreview extends APIRequest<CanvasPreview> {

    APINodeList<CanvasPreview> lastResponse = null;
    @Override
    public APINodeList<CanvasPreview> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "body",
    };

    @Override
    public APINodeList<CanvasPreview> parseResponse(String response, String header) throws APIException {
      return CanvasPreview.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<CanvasPreview> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<CanvasPreview> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<CanvasPreview>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<CanvasPreview>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<CanvasPreview>>() {
           public APINodeList<CanvasPreview> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPreview.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPreview(String nodeId, APIContext context) {
      super(context, nodeId, "/preview", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPreview setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPreview setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPreview requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPreview requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPreview requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPreview requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPreview requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPreview requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPreview requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGetPreview requestBodyField (boolean value) {
      this.requestField("body", value);
      return this;
    }
  }

  public static class APIRequestGetPreviews extends APIRequest<TextWithEntities> {

    APINodeList<TextWithEntities> lastResponse = null;
    @Override
    public APINodeList<TextWithEntities> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "user_ids",
    };

    public static final String[] FIELDS = {
      "text",
    };

    @Override
    public APINodeList<TextWithEntities> parseResponse(String response, String header) throws APIException {
      return TextWithEntities.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<TextWithEntities> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<TextWithEntities> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<TextWithEntities>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<TextWithEntities>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<TextWithEntities>>() {
           public APINodeList<TextWithEntities> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPreviews.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

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


    public APIRequestGetPreviews setUserIds (List<Long> userIds) {
      this.setParam("user_ids", userIds);
      return this;
    }
    public APIRequestGetPreviews setUserIds (String userIds) {
      this.setParam("user_ids", userIds);
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

    public APIRequestGetPreviews requestTextField () {
      return this.requestTextField(true);
    }
    public APIRequestGetPreviews requestTextField (boolean value) {
      this.requestField("text", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<Canvas> {

    Canvas lastResponse = null;
    @Override
    public Canvas getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "background_color",
      "body_elements",
      "business_id",
      "canvas_link",
      "collection_hero_image",
      "collection_hero_video",
      "collection_thumbnails",
      "dynamic_setting",
      "element_payload",
      "elements",
      "fb_body_elements",
      "id",
      "is_hidden",
      "is_published",
      "last_editor",
      "linked_documents",
      "name",
      "owner",
      "property_list",
      "source_template",
      "store_url",
      "style_list",
      "tags",
      "ui_property_list",
      "unused_body_elements",
      "update_time",
      "use_retailer_item_ids",
    };

    @Override
    public Canvas parseResponse(String response, String header) throws APIException {
      return Canvas.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Canvas execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Canvas execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Canvas> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Canvas> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Canvas>() {
           public Canvas apply(ResponseWrapper result) {
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

    public APIRequestGet requestBackgroundColorField () {
      return this.requestBackgroundColorField(true);
    }
    public APIRequestGet requestBackgroundColorField (boolean value) {
      this.requestField("background_color", value);
      return this;
    }
    public APIRequestGet requestBodyElementsField () {
      return this.requestBodyElementsField(true);
    }
    public APIRequestGet requestBodyElementsField (boolean value) {
      this.requestField("body_elements", value);
      return this;
    }
    public APIRequestGet requestBusinessIdField () {
      return this.requestBusinessIdField(true);
    }
    public APIRequestGet requestBusinessIdField (boolean value) {
      this.requestField("business_id", value);
      return this;
    }
    public APIRequestGet requestCanvasLinkField () {
      return this.requestCanvasLinkField(true);
    }
    public APIRequestGet requestCanvasLinkField (boolean value) {
      this.requestField("canvas_link", value);
      return this;
    }
    public APIRequestGet requestCollectionHeroImageField () {
      return this.requestCollectionHeroImageField(true);
    }
    public APIRequestGet requestCollectionHeroImageField (boolean value) {
      this.requestField("collection_hero_image", value);
      return this;
    }
    public APIRequestGet requestCollectionHeroVideoField () {
      return this.requestCollectionHeroVideoField(true);
    }
    public APIRequestGet requestCollectionHeroVideoField (boolean value) {
      this.requestField("collection_hero_video", value);
      return this;
    }
    public APIRequestGet requestCollectionThumbnailsField () {
      return this.requestCollectionThumbnailsField(true);
    }
    public APIRequestGet requestCollectionThumbnailsField (boolean value) {
      this.requestField("collection_thumbnails", value);
      return this;
    }
    public APIRequestGet requestDynamicSettingField () {
      return this.requestDynamicSettingField(true);
    }
    public APIRequestGet requestDynamicSettingField (boolean value) {
      this.requestField("dynamic_setting", value);
      return this;
    }
    public APIRequestGet requestElementPayloadField () {
      return this.requestElementPayloadField(true);
    }
    public APIRequestGet requestElementPayloadField (boolean value) {
      this.requestField("element_payload", value);
      return this;
    }
    public APIRequestGet requestElementsField () {
      return this.requestElementsField(true);
    }
    public APIRequestGet requestElementsField (boolean value) {
      this.requestField("elements", value);
      return this;
    }
    public APIRequestGet requestFbBodyElementsField () {
      return this.requestFbBodyElementsField(true);
    }
    public APIRequestGet requestFbBodyElementsField (boolean value) {
      this.requestField("fb_body_elements", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsHiddenField () {
      return this.requestIsHiddenField(true);
    }
    public APIRequestGet requestIsHiddenField (boolean value) {
      this.requestField("is_hidden", value);
      return this;
    }
    public APIRequestGet requestIsPublishedField () {
      return this.requestIsPublishedField(true);
    }
    public APIRequestGet requestIsPublishedField (boolean value) {
      this.requestField("is_published", value);
      return this;
    }
    public APIRequestGet requestLastEditorField () {
      return this.requestLastEditorField(true);
    }
    public APIRequestGet requestLastEditorField (boolean value) {
      this.requestField("last_editor", value);
      return this;
    }
    public APIRequestGet requestLinkedDocumentsField () {
      return this.requestLinkedDocumentsField(true);
    }
    public APIRequestGet requestLinkedDocumentsField (boolean value) {
      this.requestField("linked_documents", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestPropertyListField () {
      return this.requestPropertyListField(true);
    }
    public APIRequestGet requestPropertyListField (boolean value) {
      this.requestField("property_list", value);
      return this;
    }
    public APIRequestGet requestSourceTemplateField () {
      return this.requestSourceTemplateField(true);
    }
    public APIRequestGet requestSourceTemplateField (boolean value) {
      this.requestField("source_template", value);
      return this;
    }
    public APIRequestGet requestStoreUrlField () {
      return this.requestStoreUrlField(true);
    }
    public APIRequestGet requestStoreUrlField (boolean value) {
      this.requestField("store_url", value);
      return this;
    }
    public APIRequestGet requestStyleListField () {
      return this.requestStyleListField(true);
    }
    public APIRequestGet requestStyleListField (boolean value) {
      this.requestField("style_list", value);
      return this;
    }
    public APIRequestGet requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGet requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGet requestUiPropertyListField () {
      return this.requestUiPropertyListField(true);
    }
    public APIRequestGet requestUiPropertyListField (boolean value) {
      this.requestField("ui_property_list", value);
      return this;
    }
    public APIRequestGet requestUnusedBodyElementsField () {
      return this.requestUnusedBodyElementsField(true);
    }
    public APIRequestGet requestUnusedBodyElementsField (boolean value) {
      this.requestField("unused_body_elements", value);
      return this;
    }
    public APIRequestGet requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGet requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
    public APIRequestGet requestUseRetailerItemIdsField () {
      return this.requestUseRetailerItemIdsField(true);
    }
    public APIRequestGet requestUseRetailerItemIdsField (boolean value) {
      this.requestField("use_retailer_item_ids", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Canvas> {

    Canvas lastResponse = null;
    @Override
    public Canvas getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "background_color",
      "body_element_ids",
      "enable_swipe_to_open",
      "is_hidden",
      "is_published",
      "name",
      "source_template_id",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Canvas parseResponse(String response, String header) throws APIException {
      return Canvas.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Canvas execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Canvas execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Canvas> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Canvas> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Canvas>() {
           public Canvas apply(ResponseWrapper result) {
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


    public APIRequestUpdate setBackgroundColor (String backgroundColor) {
      this.setParam("background_color", backgroundColor);
      return this;
    }

    public APIRequestUpdate setBodyElementIds (List<String> bodyElementIds) {
      this.setParam("body_element_ids", bodyElementIds);
      return this;
    }
    public APIRequestUpdate setBodyElementIds (String bodyElementIds) {
      this.setParam("body_element_ids", bodyElementIds);
      return this;
    }

    public APIRequestUpdate setEnableSwipeToOpen (Boolean enableSwipeToOpen) {
      this.setParam("enable_swipe_to_open", enableSwipeToOpen);
      return this;
    }
    public APIRequestUpdate setEnableSwipeToOpen (String enableSwipeToOpen) {
      this.setParam("enable_swipe_to_open", enableSwipeToOpen);
      return this;
    }

    public APIRequestUpdate setIsHidden (Boolean isHidden) {
      this.setParam("is_hidden", isHidden);
      return this;
    }
    public APIRequestUpdate setIsHidden (String isHidden) {
      this.setParam("is_hidden", isHidden);
      return this;
    }

    public APIRequestUpdate setIsPublished (Boolean isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }
    public APIRequestUpdate setIsPublished (String isPublished) {
      this.setParam("is_published", isPublished);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setSourceTemplateId (String sourceTemplateId) {
      this.setParam("source_template_id", sourceTemplateId);
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

  public Canvas copyFrom(Canvas instance) {
    this.mBackgroundColor = instance.mBackgroundColor;
    this.mBodyElements = instance.mBodyElements;
    this.mBusinessId = instance.mBusinessId;
    this.mCanvasLink = instance.mCanvasLink;
    this.mCollectionHeroImage = instance.mCollectionHeroImage;
    this.mCollectionHeroVideo = instance.mCollectionHeroVideo;
    this.mCollectionThumbnails = instance.mCollectionThumbnails;
    this.mDynamicSetting = instance.mDynamicSetting;
    this.mElementPayload = instance.mElementPayload;
    this.mElements = instance.mElements;
    this.mFbBodyElements = instance.mFbBodyElements;
    this.mId = instance.mId;
    this.mIsHidden = instance.mIsHidden;
    this.mIsPublished = instance.mIsPublished;
    this.mLastEditor = instance.mLastEditor;
    this.mLinkedDocuments = instance.mLinkedDocuments;
    this.mName = instance.mName;
    this.mOwner = instance.mOwner;
    this.mPropertyList = instance.mPropertyList;
    this.mSourceTemplate = instance.mSourceTemplate;
    this.mStoreUrl = instance.mStoreUrl;
    this.mStyleList = instance.mStyleList;
    this.mTags = instance.mTags;
    this.mUiPropertyList = instance.mUiPropertyList;
    this.mUnusedBodyElements = instance.mUnusedBodyElements;
    this.mUpdateTime = instance.mUpdateTime;
    this.mUseRetailerItemIds = instance.mUseRetailerItemIds;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Canvas> getParser() {
    return new APIRequest.ResponseParser<Canvas>() {
      public APINodeList<Canvas> parseResponse(String response, APIContext context, APIRequest<Canvas> request, String header) throws MalformedResponseException {
        return Canvas.parseResponse(response, context, request, header);
      }
    };
  }
}
