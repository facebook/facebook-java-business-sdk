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
public class VideoCopyrightRule extends APINode {
  @SerializedName("condition_groups")
  private List<VideoCopyrightConditionGroup> mConditionGroups = null;
  @SerializedName("copyrights")
  private List<String> mCopyrights = null;
  @SerializedName("created_date")
  private String mCreatedDate = null;
  @SerializedName("creator")
  private User mCreator = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_in_migration")
  private Boolean mIsInMigration = null;
  @SerializedName("name")
  private String mName = null;
  protected static Gson gson = null;

  VideoCopyrightRule() {
  }

  public VideoCopyrightRule(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public VideoCopyrightRule(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public VideoCopyrightRule fetch() throws APIException{
    VideoCopyrightRule newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static VideoCopyrightRule fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<VideoCopyrightRule> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static VideoCopyrightRule fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<VideoCopyrightRule> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<VideoCopyrightRule> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<VideoCopyrightRule>)(
      new APIRequest<VideoCopyrightRule>(context, "", "/", "GET", VideoCopyrightRule.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<VideoCopyrightRule>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", VideoCopyrightRule.getParser())
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
  public static VideoCopyrightRule loadJSON(String json, APIContext context, String header) {
    VideoCopyrightRule videoCopyrightRule = getGson().fromJson(json, VideoCopyrightRule.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoCopyrightRule.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    videoCopyrightRule.context = context;
    videoCopyrightRule.rawValue = json;
    videoCopyrightRule.header = header;
    return videoCopyrightRule;
  }

  public static APINodeList<VideoCopyrightRule> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<VideoCopyrightRule> videoCopyrightRules = new APINodeList<VideoCopyrightRule>(request, json, header);
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
          videoCopyrightRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return videoCopyrightRules;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoCopyrightRules.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoCopyrightRules.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoCopyrightRules.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoCopyrightRules.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  videoCopyrightRules.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoCopyrightRules.add(loadJSON(obj.toString(), context, header));
            }
          }
          return videoCopyrightRules;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoCopyrightRules.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return videoCopyrightRules;
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
              videoCopyrightRules.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoCopyrightRules;
          }

          // Sixth, check if it's pure JsonObject
          videoCopyrightRules.clear();
          videoCopyrightRules.add(loadJSON(json, context, header));
          return videoCopyrightRules;
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


  public List<VideoCopyrightConditionGroup> getFieldConditionGroups() {
    return mConditionGroups;
  }

  public List<String> getFieldCopyrights() {
    return mCopyrights;
  }

  public String getFieldCreatedDate() {
    return mCreatedDate;
  }

  public User getFieldCreator() {
    if (mCreator != null) {
      mCreator.context = getContext();
    }
    return mCreator;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsInMigration() {
    return mIsInMigration;
  }

  public String getFieldName() {
    return mName;
  }



  public static class APIRequestGet extends APIRequest<VideoCopyrightRule> {

    VideoCopyrightRule lastResponse = null;
    @Override
    public VideoCopyrightRule getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "condition_groups",
      "copyrights",
      "created_date",
      "creator",
      "id",
      "is_in_migration",
      "name",
    };

    @Override
    public VideoCopyrightRule parseResponse(String response, String header) throws APIException {
      return VideoCopyrightRule.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VideoCopyrightRule execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoCopyrightRule execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VideoCopyrightRule> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoCopyrightRule> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VideoCopyrightRule>() {
           public VideoCopyrightRule apply(ResponseWrapper result) {
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

    public APIRequestGet requestConditionGroupsField () {
      return this.requestConditionGroupsField(true);
    }
    public APIRequestGet requestConditionGroupsField (boolean value) {
      this.requestField("condition_groups", value);
      return this;
    }
    public APIRequestGet requestCopyrightsField () {
      return this.requestCopyrightsField(true);
    }
    public APIRequestGet requestCopyrightsField (boolean value) {
      this.requestField("copyrights", value);
      return this;
    }
    public APIRequestGet requestCreatedDateField () {
      return this.requestCreatedDateField(true);
    }
    public APIRequestGet requestCreatedDateField (boolean value) {
      this.requestField("created_date", value);
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
    public APIRequestGet requestIsInMigrationField () {
      return this.requestIsInMigrationField(true);
    }
    public APIRequestGet requestIsInMigrationField (boolean value) {
      this.requestField("is_in_migration", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
  }

  public static enum EnumSource {
      @SerializedName("MATCH_SETTINGS_DIALOG")
      VALUE_MATCH_SETTINGS_DIALOG("MATCH_SETTINGS_DIALOG"),
      @SerializedName("RULES_SELECTOR")
      VALUE_RULES_SELECTOR("RULES_SELECTOR"),
      @SerializedName("RULES_TAB")
      VALUE_RULES_TAB("RULES_TAB"),
      ;

      private String value;

      private EnumSource(String value) {
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

  public VideoCopyrightRule copyFrom(VideoCopyrightRule instance) {
    this.mConditionGroups = instance.mConditionGroups;
    this.mCopyrights = instance.mCopyrights;
    this.mCreatedDate = instance.mCreatedDate;
    this.mCreator = instance.mCreator;
    this.mId = instance.mId;
    this.mIsInMigration = instance.mIsInMigration;
    this.mName = instance.mName;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoCopyrightRule> getParser() {
    return new APIRequest.ResponseParser<VideoCopyrightRule>() {
      public APINodeList<VideoCopyrightRule> parseResponse(String response, APIContext context, APIRequest<VideoCopyrightRule> request, String header) throws MalformedResponseException {
        return VideoCopyrightRule.parseResponse(response, context, request, header);
      }
    };
  }
}
