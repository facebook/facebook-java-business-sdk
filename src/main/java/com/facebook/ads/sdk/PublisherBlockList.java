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
public class PublisherBlockList extends APINode {
  @SerializedName("app_publishers")
  private List<AppPublisher> mAppPublishers = null;
  @SerializedName("business_owner_id")
  private String mBusinessOwnerId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_auto_blocking_on")
  private Boolean mIsAutoBlockingOn = null;
  @SerializedName("is_eligible_at_campaign_level")
  private Boolean mIsEligibleAtCampaignLevel = null;
  @SerializedName("last_update_time")
  private String mLastUpdateTime = null;
  @SerializedName("last_update_user")
  private String mLastUpdateUser = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("owner_ad_account_id")
  private String mOwnerAdAccountId = null;
  @SerializedName("web_publishers")
  private List<WebPublisher> mWebPublishers = null;
  protected static Gson gson = null;

  PublisherBlockList() {
  }

  public PublisherBlockList(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PublisherBlockList(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PublisherBlockList fetch() throws APIException{
    PublisherBlockList newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PublisherBlockList fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PublisherBlockList> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PublisherBlockList fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PublisherBlockList> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PublisherBlockList> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PublisherBlockList>)(
      new APIRequest<PublisherBlockList>(context, "", "/", "GET", PublisherBlockList.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PublisherBlockList>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PublisherBlockList.getParser())
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
  public static PublisherBlockList loadJSON(String json, APIContext context, String header) {
    PublisherBlockList publisherBlockList = getGson().fromJson(json, PublisherBlockList.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(publisherBlockList.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    publisherBlockList.context = context;
    publisherBlockList.rawValue = json;
    publisherBlockList.header = header;
    return publisherBlockList;
  }

  public static APINodeList<PublisherBlockList> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PublisherBlockList> publisherBlockLists = new APINodeList<PublisherBlockList>(request, json, header);
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
          publisherBlockLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return publisherBlockLists;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                publisherBlockLists.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            publisherBlockLists.setPaging(previous, next);
            if (context.hasAppSecret()) {
              publisherBlockLists.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              publisherBlockLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  publisherBlockLists.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              publisherBlockLists.add(loadJSON(obj.toString(), context, header));
            }
          }
          return publisherBlockLists;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              publisherBlockLists.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return publisherBlockLists;
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
              publisherBlockLists.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return publisherBlockLists;
          }

          // Sixth, check if it's pure JsonObject
          publisherBlockLists.clear();
          publisherBlockLists.add(loadJSON(json, context, header));
          return publisherBlockLists;
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

  public APIRequestCreateAppendPublisherUrl createAppendPublisherUrl() {
    return new APIRequestCreateAppendPublisherUrl(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetPagedWebPublishers getPagedWebPublishers() {
    return new APIRequestGetPagedWebPublishers(this.getPrefixedId().toString(), context);
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


  public List<AppPublisher> getFieldAppPublishers() {
    return mAppPublishers;
  }

  public String getFieldBusinessOwnerId() {
    return mBusinessOwnerId;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsAutoBlockingOn() {
    return mIsAutoBlockingOn;
  }

  public Boolean getFieldIsEligibleAtCampaignLevel() {
    return mIsEligibleAtCampaignLevel;
  }

  public String getFieldLastUpdateTime() {
    return mLastUpdateTime;
  }

  public String getFieldLastUpdateUser() {
    return mLastUpdateUser;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldOwnerAdAccountId() {
    return mOwnerAdAccountId;
  }

  public List<WebPublisher> getFieldWebPublishers() {
    return mWebPublishers;
  }



  public static class APIRequestCreateAppendPublisherUrl extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "publisher_urls",
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
               return APIRequestCreateAppendPublisherUrl.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestCreateAppendPublisherUrl(String nodeId, APIContext context) {
      super(context, nodeId, "/append_publisher_urls", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateAppendPublisherUrl setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateAppendPublisherUrl setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateAppendPublisherUrl setPublisherUrls (List<String> publisherUrls) {
      this.setParam("publisher_urls", publisherUrls);
      return this;
    }
    public APIRequestCreateAppendPublisherUrl setPublisherUrls (String publisherUrls) {
      this.setParam("publisher_urls", publisherUrls);
      return this;
    }

    public APIRequestCreateAppendPublisherUrl requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateAppendPublisherUrl requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAppendPublisherUrl requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateAppendPublisherUrl requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateAppendPublisherUrl requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateAppendPublisherUrl requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetPagedWebPublishers extends APIRequest<WebPublisher> {

    APINodeList<WebPublisher> lastResponse = null;
    @Override
    public APINodeList<WebPublisher> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "draft_id",
    };

    public static final String[] FIELDS = {
      "domain_url",
      "id",
      "publisher_name",
    };

    @Override
    public APINodeList<WebPublisher> parseResponse(String response, String header) throws APIException {
      return WebPublisher.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<WebPublisher> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<WebPublisher> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<WebPublisher>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<WebPublisher>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<WebPublisher>>() {
           public APINodeList<WebPublisher> apply(ResponseWrapper result) {
             try {
               return APIRequestGetPagedWebPublishers.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
      );
    };

    public APIRequestGetPagedWebPublishers(String nodeId, APIContext context) {
      super(context, nodeId, "/paged_web_publishers", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetPagedWebPublishers setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetPagedWebPublishers setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetPagedWebPublishers setDraftId (String draftId) {
      this.setParam("draft_id", draftId);
      return this;
    }

    public APIRequestGetPagedWebPublishers requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetPagedWebPublishers requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPagedWebPublishers requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetPagedWebPublishers requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetPagedWebPublishers requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetPagedWebPublishers requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetPagedWebPublishers requestDomainUrlField () {
      return this.requestDomainUrlField(true);
    }
    public APIRequestGetPagedWebPublishers requestDomainUrlField (boolean value) {
      this.requestField("domain_url", value);
      return this;
    }
    public APIRequestGetPagedWebPublishers requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetPagedWebPublishers requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetPagedWebPublishers requestPublisherNameField () {
      return this.requestPublisherNameField(true);
    }
    public APIRequestGetPagedWebPublishers requestPublisherNameField (boolean value) {
      this.requestField("publisher_name", value);
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

  public static class APIRequestGet extends APIRequest<PublisherBlockList> {

    PublisherBlockList lastResponse = null;
    @Override
    public PublisherBlockList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "account_id",
      "business_id",
      "draft_id",
    };

    public static final String[] FIELDS = {
      "app_publishers",
      "business_owner_id",
      "id",
      "is_auto_blocking_on",
      "is_eligible_at_campaign_level",
      "last_update_time",
      "last_update_user",
      "name",
      "owner_ad_account_id",
      "web_publishers",
    };

    @Override
    public PublisherBlockList parseResponse(String response, String header) throws APIException {
      return PublisherBlockList.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PublisherBlockList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PublisherBlockList execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PublisherBlockList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PublisherBlockList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PublisherBlockList>() {
           public PublisherBlockList apply(ResponseWrapper result) {
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


    public APIRequestGet setAccountId (Long accountId) {
      this.setParam("account_id", accountId);
      return this;
    }
    public APIRequestGet setAccountId (String accountId) {
      this.setParam("account_id", accountId);
      return this;
    }

    public APIRequestGet setBusinessId (String businessId) {
      this.setParam("business_id", businessId);
      return this;
    }

    public APIRequestGet setDraftId (String draftId) {
      this.setParam("draft_id", draftId);
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

    public APIRequestGet requestAppPublishersField () {
      return this.requestAppPublishersField(true);
    }
    public APIRequestGet requestAppPublishersField (boolean value) {
      this.requestField("app_publishers", value);
      return this;
    }
    public APIRequestGet requestBusinessOwnerIdField () {
      return this.requestBusinessOwnerIdField(true);
    }
    public APIRequestGet requestBusinessOwnerIdField (boolean value) {
      this.requestField("business_owner_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsAutoBlockingOnField () {
      return this.requestIsAutoBlockingOnField(true);
    }
    public APIRequestGet requestIsAutoBlockingOnField (boolean value) {
      this.requestField("is_auto_blocking_on", value);
      return this;
    }
    public APIRequestGet requestIsEligibleAtCampaignLevelField () {
      return this.requestIsEligibleAtCampaignLevelField(true);
    }
    public APIRequestGet requestIsEligibleAtCampaignLevelField (boolean value) {
      this.requestField("is_eligible_at_campaign_level", value);
      return this;
    }
    public APIRequestGet requestLastUpdateTimeField () {
      return this.requestLastUpdateTimeField(true);
    }
    public APIRequestGet requestLastUpdateTimeField (boolean value) {
      this.requestField("last_update_time", value);
      return this;
    }
    public APIRequestGet requestLastUpdateUserField () {
      return this.requestLastUpdateUserField(true);
    }
    public APIRequestGet requestLastUpdateUserField (boolean value) {
      this.requestField("last_update_user", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestOwnerAdAccountIdField () {
      return this.requestOwnerAdAccountIdField(true);
    }
    public APIRequestGet requestOwnerAdAccountIdField (boolean value) {
      this.requestField("owner_ad_account_id", value);
      return this;
    }
    public APIRequestGet requestWebPublishersField () {
      return this.requestWebPublishersField(true);
    }
    public APIRequestGet requestWebPublishersField (boolean value) {
      this.requestField("web_publishers", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<PublisherBlockList> {

    PublisherBlockList lastResponse = null;
    @Override
    public PublisherBlockList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "spec",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PublisherBlockList parseResponse(String response, String header) throws APIException {
      return PublisherBlockList.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PublisherBlockList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PublisherBlockList execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PublisherBlockList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PublisherBlockList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PublisherBlockList>() {
           public PublisherBlockList apply(ResponseWrapper result) {
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


    public APIRequestUpdate setSpec (Object spec) {
      this.setParam("spec", spec);
      return this;
    }
    public APIRequestUpdate setSpec (String spec) {
      this.setParam("spec", spec);
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

  public PublisherBlockList copyFrom(PublisherBlockList instance) {
    this.mAppPublishers = instance.mAppPublishers;
    this.mBusinessOwnerId = instance.mBusinessOwnerId;
    this.mId = instance.mId;
    this.mIsAutoBlockingOn = instance.mIsAutoBlockingOn;
    this.mIsEligibleAtCampaignLevel = instance.mIsEligibleAtCampaignLevel;
    this.mLastUpdateTime = instance.mLastUpdateTime;
    this.mLastUpdateUser = instance.mLastUpdateUser;
    this.mName = instance.mName;
    this.mOwnerAdAccountId = instance.mOwnerAdAccountId;
    this.mWebPublishers = instance.mWebPublishers;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PublisherBlockList> getParser() {
    return new APIRequest.ResponseParser<PublisherBlockList>() {
      public APINodeList<PublisherBlockList> parseResponse(String response, APIContext context, APIRequest<PublisherBlockList> request, String header) throws MalformedResponseException {
        return PublisherBlockList.parseResponse(response, context, request, header);
      }
    };
  }
}
