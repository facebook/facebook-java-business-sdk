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
public class ManagementSiteLink extends APINode {
  @SerializedName("ad_account_id")
  private String mAdAccountId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("link_domain")
  private String mLinkDomain = null;
  @SerializedName("link_hash")
  private String mLinkHash = null;
  @SerializedName("link_image_hash")
  private String mLinkImageHash = null;
  @SerializedName("link_image_url")
  private String mLinkImageUrl = null;
  @SerializedName("link_title")
  private String mLinkTitle = null;
  @SerializedName("link_type")
  private String mLinkType = null;
  @SerializedName("link_url")
  private String mLinkUrl = null;
  protected static Gson gson = null;

  ManagementSiteLink() {
  }

  public ManagementSiteLink(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ManagementSiteLink(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ManagementSiteLink fetch() throws APIException{
    ManagementSiteLink newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ManagementSiteLink fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ManagementSiteLink> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ManagementSiteLink fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ManagementSiteLink> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ManagementSiteLink> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ManagementSiteLink>)(
      new APIRequest<ManagementSiteLink>(context, "", "/", "GET", ManagementSiteLink.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ManagementSiteLink>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ManagementSiteLink.getParser())
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
  public static ManagementSiteLink loadJSON(String json, APIContext context, String header) {
    ManagementSiteLink managementSiteLink = getGson().fromJson(json, ManagementSiteLink.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(managementSiteLink.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    managementSiteLink.context = context;
    managementSiteLink.rawValue = json;
    managementSiteLink.header = header;
    return managementSiteLink;
  }

  public static APINodeList<ManagementSiteLink> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ManagementSiteLink> managementSiteLinks = new APINodeList<ManagementSiteLink>(request, json, header);
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
          managementSiteLinks.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return managementSiteLinks;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                managementSiteLinks.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            managementSiteLinks.setPaging(previous, next);
            if (context.hasAppSecret()) {
              managementSiteLinks.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              managementSiteLinks.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  managementSiteLinks.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              managementSiteLinks.add(loadJSON(obj.toString(), context, header));
            }
          }
          return managementSiteLinks;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              managementSiteLinks.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return managementSiteLinks;
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
              managementSiteLinks.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return managementSiteLinks;
          }

          // Sixth, check if it's pure JsonObject
          managementSiteLinks.clear();
          managementSiteLinks.add(loadJSON(json, context, header));
          return managementSiteLinks;
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


  public String getFieldAdAccountId() {
    return mAdAccountId;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLinkDomain() {
    return mLinkDomain;
  }

  public String getFieldLinkHash() {
    return mLinkHash;
  }

  public String getFieldLinkImageHash() {
    return mLinkImageHash;
  }

  public String getFieldLinkImageUrl() {
    return mLinkImageUrl;
  }

  public String getFieldLinkTitle() {
    return mLinkTitle;
  }

  public String getFieldLinkType() {
    return mLinkType;
  }

  public String getFieldLinkUrl() {
    return mLinkUrl;
  }



  public static class APIRequestGet extends APIRequest<ManagementSiteLink> {

    ManagementSiteLink lastResponse = null;
    @Override
    public ManagementSiteLink getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "ad_account_id",
      "id",
      "link_domain",
      "link_hash",
      "link_image_hash",
      "link_image_url",
      "link_title",
      "link_type",
      "link_url",
    };

    @Override
    public ManagementSiteLink parseResponse(String response, String header) throws APIException {
      return ManagementSiteLink.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ManagementSiteLink execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ManagementSiteLink execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ManagementSiteLink> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ManagementSiteLink> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ManagementSiteLink>() {
           public ManagementSiteLink apply(ResponseWrapper result) {
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

    public APIRequestGet requestAdAccountIdField () {
      return this.requestAdAccountIdField(true);
    }
    public APIRequestGet requestAdAccountIdField (boolean value) {
      this.requestField("ad_account_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLinkDomainField () {
      return this.requestLinkDomainField(true);
    }
    public APIRequestGet requestLinkDomainField (boolean value) {
      this.requestField("link_domain", value);
      return this;
    }
    public APIRequestGet requestLinkHashField () {
      return this.requestLinkHashField(true);
    }
    public APIRequestGet requestLinkHashField (boolean value) {
      this.requestField("link_hash", value);
      return this;
    }
    public APIRequestGet requestLinkImageHashField () {
      return this.requestLinkImageHashField(true);
    }
    public APIRequestGet requestLinkImageHashField (boolean value) {
      this.requestField("link_image_hash", value);
      return this;
    }
    public APIRequestGet requestLinkImageUrlField () {
      return this.requestLinkImageUrlField(true);
    }
    public APIRequestGet requestLinkImageUrlField (boolean value) {
      this.requestField("link_image_url", value);
      return this;
    }
    public APIRequestGet requestLinkTitleField () {
      return this.requestLinkTitleField(true);
    }
    public APIRequestGet requestLinkTitleField (boolean value) {
      this.requestField("link_title", value);
      return this;
    }
    public APIRequestGet requestLinkTypeField () {
      return this.requestLinkTypeField(true);
    }
    public APIRequestGet requestLinkTypeField (boolean value) {
      this.requestField("link_type", value);
      return this;
    }
    public APIRequestGet requestLinkUrlField () {
      return this.requestLinkUrlField(true);
    }
    public APIRequestGet requestLinkUrlField (boolean value) {
      this.requestField("link_url", value);
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

  public ManagementSiteLink copyFrom(ManagementSiteLink instance) {
    this.mAdAccountId = instance.mAdAccountId;
    this.mId = instance.mId;
    this.mLinkDomain = instance.mLinkDomain;
    this.mLinkHash = instance.mLinkHash;
    this.mLinkImageHash = instance.mLinkImageHash;
    this.mLinkImageUrl = instance.mLinkImageUrl;
    this.mLinkTitle = instance.mLinkTitle;
    this.mLinkType = instance.mLinkType;
    this.mLinkUrl = instance.mLinkUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ManagementSiteLink> getParser() {
    return new APIRequest.ResponseParser<ManagementSiteLink>() {
      public APINodeList<ManagementSiteLink> parseResponse(String response, APIContext context, APIRequest<ManagementSiteLink> request, String header) throws MalformedResponseException {
        return ManagementSiteLink.parseResponse(response, context, request, header);
      }
    };
  }
}
