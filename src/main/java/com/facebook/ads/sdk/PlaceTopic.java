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
public class PlaceTopic extends APINode {
  @SerializedName("count")
  private Long mCount = null;
  @SerializedName("has_children")
  private Boolean mHasChildren = null;
  @SerializedName("icon_url")
  private String mIconUrl = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("parent_ids")
  private List<String> mParentIds = null;
  @SerializedName("plural_name")
  private String mPluralName = null;
  @SerializedName("top_subtopic_names")
  private List<String> mTopSubtopicNames = null;
  protected static Gson gson = null;

  PlaceTopic() {
  }

  public PlaceTopic(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PlaceTopic(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PlaceTopic fetch() throws APIException{
    PlaceTopic newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PlaceTopic fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PlaceTopic> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PlaceTopic fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PlaceTopic> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PlaceTopic> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PlaceTopic>)(
      new APIRequest<PlaceTopic>(context, "", "/", "GET", PlaceTopic.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PlaceTopic>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PlaceTopic.getParser())
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
  public static PlaceTopic loadJSON(String json, APIContext context, String header) {
    PlaceTopic placeTopic = getGson().fromJson(json, PlaceTopic.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(placeTopic.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    placeTopic.context = context;
    placeTopic.rawValue = json;
    placeTopic.header = header;
    return placeTopic;
  }

  public static APINodeList<PlaceTopic> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PlaceTopic> placeTopics = new APINodeList<PlaceTopic>(request, json, header);
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
          placeTopics.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return placeTopics;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                placeTopics.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            placeTopics.setPaging(previous, next);
            if (context.hasAppSecret()) {
              placeTopics.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              placeTopics.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  placeTopics.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              placeTopics.add(loadJSON(obj.toString(), context, header));
            }
          }
          return placeTopics;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              placeTopics.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return placeTopics;
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
              placeTopics.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return placeTopics;
          }

          // Sixth, check if it's pure JsonObject
          placeTopics.clear();
          placeTopics.add(loadJSON(json, context, header));
          return placeTopics;
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


  public Long getFieldCount() {
    return mCount;
  }

  public Boolean getFieldHasChildren() {
    return mHasChildren;
  }

  public String getFieldIconUrl() {
    return mIconUrl;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public List<String> getFieldParentIds() {
    return mParentIds;
  }

  public String getFieldPluralName() {
    return mPluralName;
  }

  public List<String> getFieldTopSubtopicNames() {
    return mTopSubtopicNames;
  }



  public static class APIRequestGet extends APIRequest<PlaceTopic> {

    PlaceTopic lastResponse = null;
    @Override
    public PlaceTopic getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "icon_size",
    };

    public static final String[] FIELDS = {
      "count",
      "has_children",
      "icon_url",
      "id",
      "name",
      "parent_ids",
      "plural_name",
      "top_subtopic_names",
    };

    @Override
    public PlaceTopic parseResponse(String response, String header) throws APIException {
      return PlaceTopic.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PlaceTopic execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PlaceTopic execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PlaceTopic> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PlaceTopic> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PlaceTopic>() {
           public PlaceTopic apply(ResponseWrapper result) {
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


    public APIRequestGet setIconSize (EnumIconSize iconSize) {
      this.setParam("icon_size", iconSize);
      return this;
    }
    public APIRequestGet setIconSize (String iconSize) {
      this.setParam("icon_size", iconSize);
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

    public APIRequestGet requestCountField () {
      return this.requestCountField(true);
    }
    public APIRequestGet requestCountField (boolean value) {
      this.requestField("count", value);
      return this;
    }
    public APIRequestGet requestHasChildrenField () {
      return this.requestHasChildrenField(true);
    }
    public APIRequestGet requestHasChildrenField (boolean value) {
      this.requestField("has_children", value);
      return this;
    }
    public APIRequestGet requestIconUrlField () {
      return this.requestIconUrlField(true);
    }
    public APIRequestGet requestIconUrlField (boolean value) {
      this.requestField("icon_url", value);
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
    public APIRequestGet requestParentIdsField () {
      return this.requestParentIdsField(true);
    }
    public APIRequestGet requestParentIdsField (boolean value) {
      this.requestField("parent_ids", value);
      return this;
    }
    public APIRequestGet requestPluralNameField () {
      return this.requestPluralNameField(true);
    }
    public APIRequestGet requestPluralNameField (boolean value) {
      this.requestField("plural_name", value);
      return this;
    }
    public APIRequestGet requestTopSubtopicNamesField () {
      return this.requestTopSubtopicNamesField(true);
    }
    public APIRequestGet requestTopSubtopicNamesField (boolean value) {
      this.requestField("top_subtopic_names", value);
      return this;
    }
  }

  public static enum EnumIconSize {
      @SerializedName("24")
      VALUE_24("24"),
      @SerializedName("36")
      VALUE_36("36"),
      @SerializedName("48")
      VALUE_48("48"),
      @SerializedName("72")
      VALUE_72("72"),
      ;

      private String value;

      private EnumIconSize(String value) {
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

  public PlaceTopic copyFrom(PlaceTopic instance) {
    this.mCount = instance.mCount;
    this.mHasChildren = instance.mHasChildren;
    this.mIconUrl = instance.mIconUrl;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mParentIds = instance.mParentIds;
    this.mPluralName = instance.mPluralName;
    this.mTopSubtopicNames = instance.mTopSubtopicNames;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PlaceTopic> getParser() {
    return new APIRequest.ResponseParser<PlaceTopic>() {
      public APINodeList<PlaceTopic> parseResponse(String response, APIContext context, APIRequest<PlaceTopic> request, String header) throws MalformedResponseException {
        return PlaceTopic.parseResponse(response, context, request, header);
      }
    };
  }
}
