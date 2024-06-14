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
public class MediaCopyrightAttribution extends APINode {
  @SerializedName("attribution_ig_target_id")
  private String mAttributionIgTargetId = null;
  @SerializedName("attribution_target_email_address")
  private String mAttributionTargetEmailAddress = null;
  @SerializedName("attribution_target_id")
  private String mAttributionTargetId = null;
  @SerializedName("attribution_target_name")
  private String mAttributionTargetName = null;
  @SerializedName("attribution_type")
  private String mAttributionType = null;
  @SerializedName("attribution_uri")
  private String mAttributionUri = null;
  @SerializedName("copyright_count")
  private Long mCopyrightCount = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("creator")
  private Profile mCreator = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_enabled")
  private Boolean mIsEnabled = null;
  @SerializedName("link_title")
  private String mLinkTitle = null;
  @SerializedName("match_count")
  private Long mMatchCount = null;
  @SerializedName("owner")
  private Page mOwner = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("title")
  private String mTitle = null;
  protected static Gson gson = null;

  MediaCopyrightAttribution() {
  }

  public MediaCopyrightAttribution(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MediaCopyrightAttribution(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MediaCopyrightAttribution fetch() throws APIException{
    MediaCopyrightAttribution newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MediaCopyrightAttribution fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MediaCopyrightAttribution> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MediaCopyrightAttribution fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MediaCopyrightAttribution> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MediaCopyrightAttribution> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MediaCopyrightAttribution>)(
      new APIRequest<MediaCopyrightAttribution>(context, "", "/", "GET", MediaCopyrightAttribution.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MediaCopyrightAttribution>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MediaCopyrightAttribution.getParser())
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
  public static MediaCopyrightAttribution loadJSON(String json, APIContext context, String header) {
    MediaCopyrightAttribution mediaCopyrightAttribution = getGson().fromJson(json, MediaCopyrightAttribution.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(mediaCopyrightAttribution.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    mediaCopyrightAttribution.context = context;
    mediaCopyrightAttribution.rawValue = json;
    mediaCopyrightAttribution.header = header;
    return mediaCopyrightAttribution;
  }

  public static APINodeList<MediaCopyrightAttribution> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MediaCopyrightAttribution> mediaCopyrightAttributions = new APINodeList<MediaCopyrightAttribution>(request, json, header);
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
          mediaCopyrightAttributions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return mediaCopyrightAttributions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                mediaCopyrightAttributions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            mediaCopyrightAttributions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              mediaCopyrightAttributions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              mediaCopyrightAttributions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  mediaCopyrightAttributions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              mediaCopyrightAttributions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return mediaCopyrightAttributions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              mediaCopyrightAttributions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return mediaCopyrightAttributions;
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
              mediaCopyrightAttributions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return mediaCopyrightAttributions;
          }

          // Sixth, check if it's pure JsonObject
          mediaCopyrightAttributions.clear();
          mediaCopyrightAttributions.add(loadJSON(json, context, header));
          return mediaCopyrightAttributions;
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


  public String getFieldAttributionIgTargetId() {
    return mAttributionIgTargetId;
  }

  public String getFieldAttributionTargetEmailAddress() {
    return mAttributionTargetEmailAddress;
  }

  public String getFieldAttributionTargetId() {
    return mAttributionTargetId;
  }

  public String getFieldAttributionTargetName() {
    return mAttributionTargetName;
  }

  public String getFieldAttributionType() {
    return mAttributionType;
  }

  public String getFieldAttributionUri() {
    return mAttributionUri;
  }

  public Long getFieldCopyrightCount() {
    return mCopyrightCount;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public Profile getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsEnabled() {
    return mIsEnabled;
  }

  public String getFieldLinkTitle() {
    return mLinkTitle;
  }

  public Long getFieldMatchCount() {
    return mMatchCount;
  }

  public Page getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldTitle() {
    return mTitle;
  }



  public static class APIRequestGet extends APIRequest<MediaCopyrightAttribution> {

    MediaCopyrightAttribution lastResponse = null;
    @Override
    public MediaCopyrightAttribution getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "attribution_ig_target_id",
      "attribution_target_email_address",
      "attribution_target_id",
      "attribution_target_name",
      "attribution_type",
      "attribution_uri",
      "copyright_count",
      "creation_time",
      "creator",
      "id",
      "is_enabled",
      "link_title",
      "match_count",
      "owner",
      "status",
      "title",
    };

    @Override
    public MediaCopyrightAttribution parseResponse(String response, String header) throws APIException {
      return MediaCopyrightAttribution.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MediaCopyrightAttribution execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MediaCopyrightAttribution execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MediaCopyrightAttribution> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MediaCopyrightAttribution> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MediaCopyrightAttribution>() {
           public MediaCopyrightAttribution apply(ResponseWrapper result) {
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

    public APIRequestGet requestAttributionIgTargetIdField () {
      return this.requestAttributionIgTargetIdField(true);
    }
    public APIRequestGet requestAttributionIgTargetIdField (boolean value) {
      this.requestField("attribution_ig_target_id", value);
      return this;
    }
    public APIRequestGet requestAttributionTargetEmailAddressField () {
      return this.requestAttributionTargetEmailAddressField(true);
    }
    public APIRequestGet requestAttributionTargetEmailAddressField (boolean value) {
      this.requestField("attribution_target_email_address", value);
      return this;
    }
    public APIRequestGet requestAttributionTargetIdField () {
      return this.requestAttributionTargetIdField(true);
    }
    public APIRequestGet requestAttributionTargetIdField (boolean value) {
      this.requestField("attribution_target_id", value);
      return this;
    }
    public APIRequestGet requestAttributionTargetNameField () {
      return this.requestAttributionTargetNameField(true);
    }
    public APIRequestGet requestAttributionTargetNameField (boolean value) {
      this.requestField("attribution_target_name", value);
      return this;
    }
    public APIRequestGet requestAttributionTypeField () {
      return this.requestAttributionTypeField(true);
    }
    public APIRequestGet requestAttributionTypeField (boolean value) {
      this.requestField("attribution_type", value);
      return this;
    }
    public APIRequestGet requestAttributionUriField () {
      return this.requestAttributionUriField(true);
    }
    public APIRequestGet requestAttributionUriField (boolean value) {
      this.requestField("attribution_uri", value);
      return this;
    }
    public APIRequestGet requestCopyrightCountField () {
      return this.requestCopyrightCountField(true);
    }
    public APIRequestGet requestCopyrightCountField (boolean value) {
      this.requestField("copyright_count", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsEnabledField () {
      return this.requestIsEnabledField(true);
    }
    public APIRequestGet requestIsEnabledField (boolean value) {
      this.requestField("is_enabled", value);
      return this;
    }
    public APIRequestGet requestLinkTitleField () {
      return this.requestLinkTitleField(true);
    }
    public APIRequestGet requestLinkTitleField (boolean value) {
      this.requestField("link_title", value);
      return this;
    }
    public APIRequestGet requestMatchCountField () {
      return this.requestMatchCountField(true);
    }
    public APIRequestGet requestMatchCountField (boolean value) {
      this.requestField("match_count", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
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

  public MediaCopyrightAttribution copyFrom(MediaCopyrightAttribution instance) {
    this.mAttributionIgTargetId = instance.mAttributionIgTargetId;
    this.mAttributionTargetEmailAddress = instance.mAttributionTargetEmailAddress;
    this.mAttributionTargetId = instance.mAttributionTargetId;
    this.mAttributionTargetName = instance.mAttributionTargetName;
    this.mAttributionType = instance.mAttributionType;
    this.mAttributionUri = instance.mAttributionUri;
    this.mCopyrightCount = instance.mCopyrightCount;
    this.mCreationTime = instance.mCreationTime;
    this.mCreator = instance.mCreator;
    this.mId = instance.mId;
    this.mIsEnabled = instance.mIsEnabled;
    this.mLinkTitle = instance.mLinkTitle;
    this.mMatchCount = instance.mMatchCount;
    this.mOwner = instance.mOwner;
    this.mStatus = instance.mStatus;
    this.mTitle = instance.mTitle;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MediaCopyrightAttribution> getParser() {
    return new APIRequest.ResponseParser<MediaCopyrightAttribution>() {
      public APINodeList<MediaCopyrightAttribution> parseResponse(String response, APIContext context, APIRequest<MediaCopyrightAttribution> request, String header) throws MalformedResponseException {
        return MediaCopyrightAttribution.parseResponse(response, context, request, header);
      }
    };
  }
}
