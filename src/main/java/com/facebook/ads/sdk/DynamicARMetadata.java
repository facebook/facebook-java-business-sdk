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
public class DynamicARMetadata extends APINode {
  @SerializedName("anchor_point")
  private List<Double> mAnchorPoint = null;
  @SerializedName("container_effect_enum")
  private Long mContainerEffectEnum = null;
  @SerializedName("effect_icon_url")
  private String mEffectIconUrl = null;
  @SerializedName("effect_id")
  private String mEffectId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("platforms")
  private List<String> mPlatforms = null;
  @SerializedName("scale_factor")
  private List<Double> mScaleFactor = null;
  @SerializedName("shadow_texture_url")
  private String mShadowTextureUrl = null;
  @SerializedName("source_url")
  private String mSourceUrl = null;
  @SerializedName("state")
  private String mState = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("variant_picker_url")
  private String mVariantPickerUrl = null;
  protected static Gson gson = null;

  DynamicARMetadata() {
  }

  public DynamicARMetadata(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public DynamicARMetadata(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public DynamicARMetadata fetch() throws APIException{
    DynamicARMetadata newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static DynamicARMetadata fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<DynamicARMetadata> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static DynamicARMetadata fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<DynamicARMetadata> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<DynamicARMetadata> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<DynamicARMetadata>)(
      new APIRequest<DynamicARMetadata>(context, "", "/", "GET", DynamicARMetadata.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<DynamicARMetadata>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", DynamicARMetadata.getParser())
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
  public static DynamicARMetadata loadJSON(String json, APIContext context, String header) {
    DynamicARMetadata dynamicARMetadata = getGson().fromJson(json, DynamicARMetadata.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(dynamicARMetadata.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    dynamicARMetadata.context = context;
    dynamicARMetadata.rawValue = json;
    dynamicARMetadata.header = header;
    return dynamicARMetadata;
  }

  public static APINodeList<DynamicARMetadata> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<DynamicARMetadata> dynamicARMetadatas = new APINodeList<DynamicARMetadata>(request, json, header);
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
          dynamicARMetadatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return dynamicARMetadatas;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                dynamicARMetadatas.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            dynamicARMetadatas.setPaging(previous, next);
            if (context.hasAppSecret()) {
              dynamicARMetadatas.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              dynamicARMetadatas.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  dynamicARMetadatas.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              dynamicARMetadatas.add(loadJSON(obj.toString(), context, header));
            }
          }
          return dynamicARMetadatas;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              dynamicARMetadatas.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return dynamicARMetadatas;
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
              dynamicARMetadatas.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return dynamicARMetadatas;
          }

          // Sixth, check if it's pure JsonObject
          dynamicARMetadatas.clear();
          dynamicARMetadatas.add(loadJSON(json, context, header));
          return dynamicARMetadatas;
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


  public List<Double> getFieldAnchorPoint() {
    return mAnchorPoint;
  }

  public Long getFieldContainerEffectEnum() {
    return mContainerEffectEnum;
  }

  public String getFieldEffectIconUrl() {
    return mEffectIconUrl;
  }

  public String getFieldEffectId() {
    return mEffectId;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldPlatforms() {
    return mPlatforms;
  }

  public List<Double> getFieldScaleFactor() {
    return mScaleFactor;
  }

  public String getFieldShadowTextureUrl() {
    return mShadowTextureUrl;
  }

  public String getFieldSourceUrl() {
    return mSourceUrl;
  }

  public String getFieldState() {
    return mState;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public String getFieldVariantPickerUrl() {
    return mVariantPickerUrl;
  }



  public static class APIRequestGet extends APIRequest<DynamicARMetadata> {

    DynamicARMetadata lastResponse = null;
    @Override
    public DynamicARMetadata getLastResponse() {
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
    public DynamicARMetadata parseResponse(String response, String header) throws APIException {
      return DynamicARMetadata.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public DynamicARMetadata execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public DynamicARMetadata execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<DynamicARMetadata> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<DynamicARMetadata> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, DynamicARMetadata>() {
           public DynamicARMetadata apply(ResponseWrapper result) {
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

    public APIRequestGet requestAnchorPointField () {
      return this.requestAnchorPointField(true);
    }
    public APIRequestGet requestAnchorPointField (boolean value) {
      this.requestField("anchor_point", value);
      return this;
    }
    public APIRequestGet requestContainerEffectEnumField () {
      return this.requestContainerEffectEnumField(true);
    }
    public APIRequestGet requestContainerEffectEnumField (boolean value) {
      this.requestField("container_effect_enum", value);
      return this;
    }
    public APIRequestGet requestEffectIconUrlField () {
      return this.requestEffectIconUrlField(true);
    }
    public APIRequestGet requestEffectIconUrlField (boolean value) {
      this.requestField("effect_icon_url", value);
      return this;
    }
    public APIRequestGet requestEffectIdField () {
      return this.requestEffectIdField(true);
    }
    public APIRequestGet requestEffectIdField (boolean value) {
      this.requestField("effect_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPlatformsField () {
      return this.requestPlatformsField(true);
    }
    public APIRequestGet requestPlatformsField (boolean value) {
      this.requestField("platforms", value);
      return this;
    }
    public APIRequestGet requestScaleFactorField () {
      return this.requestScaleFactorField(true);
    }
    public APIRequestGet requestScaleFactorField (boolean value) {
      this.requestField("scale_factor", value);
      return this;
    }
    public APIRequestGet requestShadowTextureUrlField () {
      return this.requestShadowTextureUrlField(true);
    }
    public APIRequestGet requestShadowTextureUrlField (boolean value) {
      this.requestField("shadow_texture_url", value);
      return this;
    }
    public APIRequestGet requestSourceUrlField () {
      return this.requestSourceUrlField(true);
    }
    public APIRequestGet requestSourceUrlField (boolean value) {
      this.requestField("source_url", value);
      return this;
    }
    public APIRequestGet requestStateField () {
      return this.requestStateField(true);
    }
    public APIRequestGet requestStateField (boolean value) {
      this.requestField("state", value);
      return this;
    }
    public APIRequestGet requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGet requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGet requestVariantPickerUrlField () {
      return this.requestVariantPickerUrlField(true);
    }
    public APIRequestGet requestVariantPickerUrlField (boolean value) {
      this.requestField("variant_picker_url", value);
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

  public DynamicARMetadata copyFrom(DynamicARMetadata instance) {
    this.mAnchorPoint = instance.mAnchorPoint;
    this.mContainerEffectEnum = instance.mContainerEffectEnum;
    this.mEffectIconUrl = instance.mEffectIconUrl;
    this.mEffectId = instance.mEffectId;
    this.mId = instance.mId;
    this.mPlatforms = instance.mPlatforms;
    this.mScaleFactor = instance.mScaleFactor;
    this.mShadowTextureUrl = instance.mShadowTextureUrl;
    this.mSourceUrl = instance.mSourceUrl;
    this.mState = instance.mState;
    this.mTags = instance.mTags;
    this.mVariantPickerUrl = instance.mVariantPickerUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<DynamicARMetadata> getParser() {
    return new APIRequest.ResponseParser<DynamicARMetadata>() {
      public APINodeList<DynamicARMetadata> parseResponse(String response, APIContext context, APIRequest<DynamicARMetadata> request, String header) throws MalformedResponseException {
        return DynamicARMetadata.parseResponse(response, context, request, header);
      }
    };
  }
}
