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
public class CanvasTemplate extends APINode {
  @SerializedName("channels")
  private List<Map<String, List<Map<String, String>>>> mChannels = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("document")
  private Canvas mDocument = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_multi_tab_supportable")
  private Boolean mIsMultiTabSupportable = null;
  @SerializedName("is_new")
  private Boolean mIsNew = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("objectives")
  private List<Map<Object, Object>> mObjectives = null;
  @SerializedName("owner_id")
  private User mOwnerId = null;
  @SerializedName("required_capabilities")
  private List<String> mRequiredCapabilities = null;
  @SerializedName("snapshot_photo")
  private Photo mSnapshotPhoto = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("sub_verticals")
  private List<String> mSubVerticals = null;
  @SerializedName("verticals")
  private List<Map<String, String>> mVerticals = null;
  protected static Gson gson = null;

  CanvasTemplate() {
  }

  public CanvasTemplate(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CanvasTemplate(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CanvasTemplate fetch() throws APIException{
    CanvasTemplate newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CanvasTemplate fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CanvasTemplate> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CanvasTemplate fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CanvasTemplate> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CanvasTemplate> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CanvasTemplate>)(
      new APIRequest<CanvasTemplate>(context, "", "/", "GET", CanvasTemplate.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CanvasTemplate>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CanvasTemplate.getParser())
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
  public static CanvasTemplate loadJSON(String json, APIContext context, String header) {
    CanvasTemplate canvasTemplate = getGson().fromJson(json, CanvasTemplate.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(canvasTemplate.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    canvasTemplate.context = context;
    canvasTemplate.rawValue = json;
    canvasTemplate.header = header;
    return canvasTemplate;
  }

  public static APINodeList<CanvasTemplate> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CanvasTemplate> canvasTemplates = new APINodeList<CanvasTemplate>(request, json, header);
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
          canvasTemplates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return canvasTemplates;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                canvasTemplates.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            canvasTemplates.setPaging(previous, next);
            if (context.hasAppSecret()) {
              canvasTemplates.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              canvasTemplates.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  canvasTemplates.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              canvasTemplates.add(loadJSON(obj.toString(), context, header));
            }
          }
          return canvasTemplates;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              canvasTemplates.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return canvasTemplates;
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
              canvasTemplates.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return canvasTemplates;
          }

          // Sixth, check if it's pure JsonObject
          canvasTemplates.clear();
          canvasTemplates.add(loadJSON(json, context, header));
          return canvasTemplates;
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


  public List<Map<String, List<Map<String, String>>>> getFieldChannels() {
    return mChannels;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public Canvas getFieldDocument() {
    if (mDocument != null) {
      mDocument.context = getContext();
    }
    return mDocument;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsMultiTabSupportable() {
    return mIsMultiTabSupportable;
  }

  public Boolean getFieldIsNew() {
    return mIsNew;
  }

  public String getFieldName() {
    return mName;
  }

  public List<Map<Object, Object>> getFieldObjectives() {
    return mObjectives;
  }

  public User getFieldOwnerId() {
    if (mOwnerId != null) {
      mOwnerId.context = getContext();
    }
    return mOwnerId;
  }

  public List<String> getFieldRequiredCapabilities() {
    return mRequiredCapabilities;
  }

  public Photo getFieldSnapshotPhoto() {
    if (mSnapshotPhoto != null) {
      mSnapshotPhoto.context = getContext();
    }
    return mSnapshotPhoto;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public List<String> getFieldSubVerticals() {
    return mSubVerticals;
  }

  public List<Map<String, String>> getFieldVerticals() {
    return mVerticals;
  }



  public static class APIRequestGet extends APIRequest<CanvasTemplate> {

    CanvasTemplate lastResponse = null;
    @Override
    public CanvasTemplate getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "channels",
      "description",
      "document",
      "id",
      "is_multi_tab_supportable",
      "is_new",
      "name",
      "objectives",
      "owner_id",
      "required_capabilities",
      "snapshot_photo",
      "status",
      "sub_verticals",
      "verticals",
    };

    @Override
    public CanvasTemplate parseResponse(String response, String header) throws APIException {
      return CanvasTemplate.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public CanvasTemplate execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CanvasTemplate execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<CanvasTemplate> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CanvasTemplate> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, CanvasTemplate>() {
           public CanvasTemplate apply(ResponseWrapper result) {
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

    public APIRequestGet requestChannelsField () {
      return this.requestChannelsField(true);
    }
    public APIRequestGet requestChannelsField (boolean value) {
      this.requestField("channels", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestDocumentField () {
      return this.requestDocumentField(true);
    }
    public APIRequestGet requestDocumentField (boolean value) {
      this.requestField("document", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsMultiTabSupportableField () {
      return this.requestIsMultiTabSupportableField(true);
    }
    public APIRequestGet requestIsMultiTabSupportableField (boolean value) {
      this.requestField("is_multi_tab_supportable", value);
      return this;
    }
    public APIRequestGet requestIsNewField () {
      return this.requestIsNewField(true);
    }
    public APIRequestGet requestIsNewField (boolean value) {
      this.requestField("is_new", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestObjectivesField () {
      return this.requestObjectivesField(true);
    }
    public APIRequestGet requestObjectivesField (boolean value) {
      this.requestField("objectives", value);
      return this;
    }
    public APIRequestGet requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGet requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
      return this;
    }
    public APIRequestGet requestRequiredCapabilitiesField () {
      return this.requestRequiredCapabilitiesField(true);
    }
    public APIRequestGet requestRequiredCapabilitiesField (boolean value) {
      this.requestField("required_capabilities", value);
      return this;
    }
    public APIRequestGet requestSnapshotPhotoField () {
      return this.requestSnapshotPhotoField(true);
    }
    public APIRequestGet requestSnapshotPhotoField (boolean value) {
      this.requestField("snapshot_photo", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestSubVerticalsField () {
      return this.requestSubVerticalsField(true);
    }
    public APIRequestGet requestSubVerticalsField (boolean value) {
      this.requestField("sub_verticals", value);
      return this;
    }
    public APIRequestGet requestVerticalsField () {
      return this.requestVerticalsField(true);
    }
    public APIRequestGet requestVerticalsField (boolean value) {
      this.requestField("verticals", value);
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

  public CanvasTemplate copyFrom(CanvasTemplate instance) {
    this.mChannels = instance.mChannels;
    this.mDescription = instance.mDescription;
    this.mDocument = instance.mDocument;
    this.mId = instance.mId;
    this.mIsMultiTabSupportable = instance.mIsMultiTabSupportable;
    this.mIsNew = instance.mIsNew;
    this.mName = instance.mName;
    this.mObjectives = instance.mObjectives;
    this.mOwnerId = instance.mOwnerId;
    this.mRequiredCapabilities = instance.mRequiredCapabilities;
    this.mSnapshotPhoto = instance.mSnapshotPhoto;
    this.mStatus = instance.mStatus;
    this.mSubVerticals = instance.mSubVerticals;
    this.mVerticals = instance.mVerticals;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CanvasTemplate> getParser() {
    return new APIRequest.ResponseParser<CanvasTemplate>() {
      public APINodeList<CanvasTemplate> parseResponse(String response, APIContext context, APIRequest<CanvasTemplate> request, String header) throws MalformedResponseException {
        return CanvasTemplate.parseResponse(response, context, request, header);
      }
    };
  }
}
