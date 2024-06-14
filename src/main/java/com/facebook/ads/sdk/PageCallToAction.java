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
public class PageCallToAction extends APINode {
  @SerializedName("android_app")
  private Application mAndroidApp = null;
  @SerializedName("android_deeplink")
  private String mAndroidDeeplink = null;
  @SerializedName("android_destination_type")
  private String mAndroidDestinationType = null;
  @SerializedName("android_package_name")
  private String mAndroidPackageName = null;
  @SerializedName("android_url")
  private String mAndroidUrl = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("email_address")
  private String mEmailAddress = null;
  @SerializedName("from")
  private Page mFrom = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("intl_number_with_plus")
  private String mIntlNumberWithPlus = null;
  @SerializedName("iphone_app")
  private Application mIphoneApp = null;
  @SerializedName("iphone_deeplink")
  private String mIphoneDeeplink = null;
  @SerializedName("iphone_destination_type")
  private String mIphoneDestinationType = null;
  @SerializedName("iphone_url")
  private String mIphoneUrl = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("type")
  private String mType = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("web_destination_type")
  private String mWebDestinationType = null;
  @SerializedName("web_url")
  private String mWebUrl = null;
  protected static Gson gson = null;

  PageCallToAction() {
  }

  public PageCallToAction(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PageCallToAction(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PageCallToAction fetch() throws APIException{
    PageCallToAction newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PageCallToAction fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PageCallToAction> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PageCallToAction fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PageCallToAction> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PageCallToAction> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PageCallToAction>)(
      new APIRequest<PageCallToAction>(context, "", "/", "GET", PageCallToAction.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PageCallToAction>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PageCallToAction.getParser())
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
  public static PageCallToAction loadJSON(String json, APIContext context, String header) {
    PageCallToAction pageCallToAction = getGson().fromJson(json, PageCallToAction.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageCallToAction.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    pageCallToAction.context = context;
    pageCallToAction.rawValue = json;
    pageCallToAction.header = header;
    return pageCallToAction;
  }

  public static APINodeList<PageCallToAction> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PageCallToAction> pageCallToActions = new APINodeList<PageCallToAction>(request, json, header);
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
          pageCallToActions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return pageCallToActions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageCallToActions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageCallToActions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageCallToActions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageCallToActions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  pageCallToActions.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageCallToActions.add(loadJSON(obj.toString(), context, header));
            }
          }
          return pageCallToActions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageCallToActions.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return pageCallToActions;
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
              pageCallToActions.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageCallToActions;
          }

          // Sixth, check if it's pure JsonObject
          pageCallToActions.clear();
          pageCallToActions.add(loadJSON(json, context, header));
          return pageCallToActions;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public Application getFieldAndroidApp() {
    if (mAndroidApp != null) {
      mAndroidApp.context = getContext();
    }
    return mAndroidApp;
  }

  public String getFieldAndroidDeeplink() {
    return mAndroidDeeplink;
  }

  public String getFieldAndroidDestinationType() {
    return mAndroidDestinationType;
  }

  public String getFieldAndroidPackageName() {
    return mAndroidPackageName;
  }

  public String getFieldAndroidUrl() {
    return mAndroidUrl;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldEmailAddress() {
    return mEmailAddress;
  }

  public Page getFieldFrom() {
    if (mFrom != null) {
      mFrom.context = getContext();
    }
    return mFrom;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIntlNumberWithPlus() {
    return mIntlNumberWithPlus;
  }

  public Application getFieldIphoneApp() {
    if (mIphoneApp != null) {
      mIphoneApp.context = getContext();
    }
    return mIphoneApp;
  }

  public String getFieldIphoneDeeplink() {
    return mIphoneDeeplink;
  }

  public String getFieldIphoneDestinationType() {
    return mIphoneDestinationType;
  }

  public String getFieldIphoneUrl() {
    return mIphoneUrl;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public String getFieldType() {
    return mType;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public String getFieldWebDestinationType() {
    return mWebDestinationType;
  }

  public String getFieldWebUrl() {
    return mWebUrl;
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

  public static class APIRequestGet extends APIRequest<PageCallToAction> {

    PageCallToAction lastResponse = null;
    @Override
    public PageCallToAction getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "android_app",
      "android_deeplink",
      "android_destination_type",
      "android_package_name",
      "android_url",
      "created_time",
      "email_address",
      "from",
      "id",
      "intl_number_with_plus",
      "iphone_app",
      "iphone_deeplink",
      "iphone_destination_type",
      "iphone_url",
      "status",
      "type",
      "updated_time",
      "web_destination_type",
      "web_url",
    };

    @Override
    public PageCallToAction parseResponse(String response, String header) throws APIException {
      return PageCallToAction.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PageCallToAction execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageCallToAction execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PageCallToAction> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageCallToAction> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PageCallToAction>() {
           public PageCallToAction apply(ResponseWrapper result) {
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

    public APIRequestGet requestAndroidAppField () {
      return this.requestAndroidAppField(true);
    }
    public APIRequestGet requestAndroidAppField (boolean value) {
      this.requestField("android_app", value);
      return this;
    }
    public APIRequestGet requestAndroidDeeplinkField () {
      return this.requestAndroidDeeplinkField(true);
    }
    public APIRequestGet requestAndroidDeeplinkField (boolean value) {
      this.requestField("android_deeplink", value);
      return this;
    }
    public APIRequestGet requestAndroidDestinationTypeField () {
      return this.requestAndroidDestinationTypeField(true);
    }
    public APIRequestGet requestAndroidDestinationTypeField (boolean value) {
      this.requestField("android_destination_type", value);
      return this;
    }
    public APIRequestGet requestAndroidPackageNameField () {
      return this.requestAndroidPackageNameField(true);
    }
    public APIRequestGet requestAndroidPackageNameField (boolean value) {
      this.requestField("android_package_name", value);
      return this;
    }
    public APIRequestGet requestAndroidUrlField () {
      return this.requestAndroidUrlField(true);
    }
    public APIRequestGet requestAndroidUrlField (boolean value) {
      this.requestField("android_url", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestEmailAddressField () {
      return this.requestEmailAddressField(true);
    }
    public APIRequestGet requestEmailAddressField (boolean value) {
      this.requestField("email_address", value);
      return this;
    }
    public APIRequestGet requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGet requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIntlNumberWithPlusField () {
      return this.requestIntlNumberWithPlusField(true);
    }
    public APIRequestGet requestIntlNumberWithPlusField (boolean value) {
      this.requestField("intl_number_with_plus", value);
      return this;
    }
    public APIRequestGet requestIphoneAppField () {
      return this.requestIphoneAppField(true);
    }
    public APIRequestGet requestIphoneAppField (boolean value) {
      this.requestField("iphone_app", value);
      return this;
    }
    public APIRequestGet requestIphoneDeeplinkField () {
      return this.requestIphoneDeeplinkField(true);
    }
    public APIRequestGet requestIphoneDeeplinkField (boolean value) {
      this.requestField("iphone_deeplink", value);
      return this;
    }
    public APIRequestGet requestIphoneDestinationTypeField () {
      return this.requestIphoneDestinationTypeField(true);
    }
    public APIRequestGet requestIphoneDestinationTypeField (boolean value) {
      this.requestField("iphone_destination_type", value);
      return this;
    }
    public APIRequestGet requestIphoneUrlField () {
      return this.requestIphoneUrlField(true);
    }
    public APIRequestGet requestIphoneUrlField (boolean value) {
      this.requestField("iphone_url", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestWebDestinationTypeField () {
      return this.requestWebDestinationTypeField(true);
    }
    public APIRequestGet requestWebDestinationTypeField (boolean value) {
      this.requestField("web_destination_type", value);
      return this;
    }
    public APIRequestGet requestWebUrlField () {
      return this.requestWebUrlField(true);
    }
    public APIRequestGet requestWebUrlField (boolean value) {
      this.requestField("web_url", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<PageCallToAction> {

    PageCallToAction lastResponse = null;
    @Override
    public PageCallToAction getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "android_app_id",
      "android_destination_type",
      "android_package_name",
      "android_url",
      "email_address",
      "intl_number_with_plus",
      "iphone_app_id",
      "iphone_destination_type",
      "iphone_url",
      "type",
      "web_destination_type",
      "web_url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PageCallToAction parseResponse(String response, String header) throws APIException {
      return PageCallToAction.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PageCallToAction execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageCallToAction execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PageCallToAction> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageCallToAction> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PageCallToAction>() {
           public PageCallToAction apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAndroidAppId (Long androidAppId) {
      this.setParam("android_app_id", androidAppId);
      return this;
    }
    public APIRequestUpdate setAndroidAppId (String androidAppId) {
      this.setParam("android_app_id", androidAppId);
      return this;
    }

    public APIRequestUpdate setAndroidDestinationType (PageCallToAction.EnumAndroidDestinationType androidDestinationType) {
      this.setParam("android_destination_type", androidDestinationType);
      return this;
    }
    public APIRequestUpdate setAndroidDestinationType (String androidDestinationType) {
      this.setParam("android_destination_type", androidDestinationType);
      return this;
    }

    public APIRequestUpdate setAndroidPackageName (String androidPackageName) {
      this.setParam("android_package_name", androidPackageName);
      return this;
    }

    public APIRequestUpdate setAndroidUrl (String androidUrl) {
      this.setParam("android_url", androidUrl);
      return this;
    }

    public APIRequestUpdate setEmailAddress (String emailAddress) {
      this.setParam("email_address", emailAddress);
      return this;
    }

    public APIRequestUpdate setIntlNumberWithPlus (String intlNumberWithPlus) {
      this.setParam("intl_number_with_plus", intlNumberWithPlus);
      return this;
    }

    public APIRequestUpdate setIphoneAppId (Long iphoneAppId) {
      this.setParam("iphone_app_id", iphoneAppId);
      return this;
    }
    public APIRequestUpdate setIphoneAppId (String iphoneAppId) {
      this.setParam("iphone_app_id", iphoneAppId);
      return this;
    }

    public APIRequestUpdate setIphoneDestinationType (PageCallToAction.EnumIphoneDestinationType iphoneDestinationType) {
      this.setParam("iphone_destination_type", iphoneDestinationType);
      return this;
    }
    public APIRequestUpdate setIphoneDestinationType (String iphoneDestinationType) {
      this.setParam("iphone_destination_type", iphoneDestinationType);
      return this;
    }

    public APIRequestUpdate setIphoneUrl (String iphoneUrl) {
      this.setParam("iphone_url", iphoneUrl);
      return this;
    }

    public APIRequestUpdate setType (PageCallToAction.EnumType type) {
      this.setParam("type", type);
      return this;
    }
    public APIRequestUpdate setType (String type) {
      this.setParam("type", type);
      return this;
    }

    public APIRequestUpdate setWebDestinationType (PageCallToAction.EnumWebDestinationType webDestinationType) {
      this.setParam("web_destination_type", webDestinationType);
      return this;
    }
    public APIRequestUpdate setWebDestinationType (String webDestinationType) {
      this.setParam("web_destination_type", webDestinationType);
      return this;
    }

    public APIRequestUpdate setWebUrl (String webUrl) {
      this.setParam("web_url", webUrl);
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

  public static enum EnumAndroidDestinationType {
      @SerializedName("APP_DEEPLINK")
      VALUE_APP_DEEPLINK("APP_DEEPLINK"),
      @SerializedName("BECOME_A_VOLUNTEER")
      VALUE_BECOME_A_VOLUNTEER("BECOME_A_VOLUNTEER"),
      @SerializedName("EMAIL")
      VALUE_EMAIL("EMAIL"),
      @SerializedName("FACEBOOK_APP")
      VALUE_FACEBOOK_APP("FACEBOOK_APP"),
      @SerializedName("FOLLOW")
      VALUE_FOLLOW("FOLLOW"),
      @SerializedName("MARKETPLACE_INVENTORY_PAGE")
      VALUE_MARKETPLACE_INVENTORY_PAGE("MARKETPLACE_INVENTORY_PAGE"),
      @SerializedName("MENU_ON_FACEBOOK")
      VALUE_MENU_ON_FACEBOOK("MENU_ON_FACEBOOK"),
      @SerializedName("MESSENGER")
      VALUE_MESSENGER("MESSENGER"),
      @SerializedName("MINI_SHOP")
      VALUE_MINI_SHOP("MINI_SHOP"),
      @SerializedName("MOBILE_CENTER")
      VALUE_MOBILE_CENTER("MOBILE_CENTER"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("PHONE_CALL")
      VALUE_PHONE_CALL("PHONE_CALL"),
      @SerializedName("SHOP_ON_FACEBOOK")
      VALUE_SHOP_ON_FACEBOOK("SHOP_ON_FACEBOOK"),
      @SerializedName("WEBSITE")
      VALUE_WEBSITE("WEBSITE"),
      ;

      private String value;

      private EnumAndroidDestinationType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumIphoneDestinationType {
      @SerializedName("APP_DEEPLINK")
      VALUE_APP_DEEPLINK("APP_DEEPLINK"),
      @SerializedName("BECOME_A_VOLUNTEER")
      VALUE_BECOME_A_VOLUNTEER("BECOME_A_VOLUNTEER"),
      @SerializedName("EMAIL")
      VALUE_EMAIL("EMAIL"),
      @SerializedName("FACEBOOK_APP")
      VALUE_FACEBOOK_APP("FACEBOOK_APP"),
      @SerializedName("FOLLOW")
      VALUE_FOLLOW("FOLLOW"),
      @SerializedName("MARKETPLACE_INVENTORY_PAGE")
      VALUE_MARKETPLACE_INVENTORY_PAGE("MARKETPLACE_INVENTORY_PAGE"),
      @SerializedName("MENU_ON_FACEBOOK")
      VALUE_MENU_ON_FACEBOOK("MENU_ON_FACEBOOK"),
      @SerializedName("MESSENGER")
      VALUE_MESSENGER("MESSENGER"),
      @SerializedName("MINI_SHOP")
      VALUE_MINI_SHOP("MINI_SHOP"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("PHONE_CALL")
      VALUE_PHONE_CALL("PHONE_CALL"),
      @SerializedName("SHOP_ON_FACEBOOK")
      VALUE_SHOP_ON_FACEBOOK("SHOP_ON_FACEBOOK"),
      @SerializedName("WEBSITE")
      VALUE_WEBSITE("WEBSITE"),
      ;

      private String value;

      private EnumIphoneDestinationType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("BECOME_A_VOLUNTEER")
      VALUE_BECOME_A_VOLUNTEER("BECOME_A_VOLUNTEER"),
      @SerializedName("BOOK_APPOINTMENT")
      VALUE_BOOK_APPOINTMENT("BOOK_APPOINTMENT"),
      @SerializedName("BOOK_NOW")
      VALUE_BOOK_NOW("BOOK_NOW"),
      @SerializedName("BUY_TICKETS")
      VALUE_BUY_TICKETS("BUY_TICKETS"),
      @SerializedName("CALL_NOW")
      VALUE_CALL_NOW("CALL_NOW"),
      @SerializedName("CHARITY_DONATE")
      VALUE_CHARITY_DONATE("CHARITY_DONATE"),
      @SerializedName("CHECK_IN")
      VALUE_CHECK_IN("CHECK_IN"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("DONATE_NOW")
      VALUE_DONATE_NOW("DONATE_NOW"),
      @SerializedName("EMAIL")
      VALUE_EMAIL("EMAIL"),
      @SerializedName("FOLLOW_PAGE")
      VALUE_FOLLOW_PAGE("FOLLOW_PAGE"),
      @SerializedName("GET_DIRECTIONS")
      VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
      @SerializedName("GET_OFFER")
      VALUE_GET_OFFER("GET_OFFER"),
      @SerializedName("GET_OFFER_VIEW")
      VALUE_GET_OFFER_VIEW("GET_OFFER_VIEW"),
      @SerializedName("INTERESTED")
      VALUE_INTERESTED("INTERESTED"),
      @SerializedName("LEARN_MORE")
      VALUE_LEARN_MORE("LEARN_MORE"),
      @SerializedName("LISTEN")
      VALUE_LISTEN("LISTEN"),
      @SerializedName("LOCAL_DEV_PLATFORM")
      VALUE_LOCAL_DEV_PLATFORM("LOCAL_DEV_PLATFORM"),
      @SerializedName("MESSAGE")
      VALUE_MESSAGE("MESSAGE"),
      @SerializedName("MOBILE_CENTER")
      VALUE_MOBILE_CENTER("MOBILE_CENTER"),
      @SerializedName("OPEN_APP")
      VALUE_OPEN_APP("OPEN_APP"),
      @SerializedName("ORDER_FOOD")
      VALUE_ORDER_FOOD("ORDER_FOOD"),
      @SerializedName("PLAY_MUSIC")
      VALUE_PLAY_MUSIC("PLAY_MUSIC"),
      @SerializedName("PLAY_NOW")
      VALUE_PLAY_NOW("PLAY_NOW"),
      @SerializedName("PURCHASE_GIFT_CARDS")
      VALUE_PURCHASE_GIFT_CARDS("PURCHASE_GIFT_CARDS"),
      @SerializedName("REQUEST_APPOINTMENT")
      VALUE_REQUEST_APPOINTMENT("REQUEST_APPOINTMENT"),
      @SerializedName("REQUEST_QUOTE")
      VALUE_REQUEST_QUOTE("REQUEST_QUOTE"),
      @SerializedName("SHOP_NOW")
      VALUE_SHOP_NOW("SHOP_NOW"),
      @SerializedName("SHOP_ON_FACEBOOK")
      VALUE_SHOP_ON_FACEBOOK("SHOP_ON_FACEBOOK"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("VIEW_INVENTORY")
      VALUE_VIEW_INVENTORY("VIEW_INVENTORY"),
      @SerializedName("VIEW_MENU")
      VALUE_VIEW_MENU("VIEW_MENU"),
      @SerializedName("VIEW_SHOP")
      VALUE_VIEW_SHOP("VIEW_SHOP"),
      @SerializedName("VISIT_GROUP")
      VALUE_VISIT_GROUP("VISIT_GROUP"),
      @SerializedName("WATCH_NOW")
      VALUE_WATCH_NOW("WATCH_NOW"),
      @SerializedName("WOODHENGE_SUPPORT")
      VALUE_WOODHENGE_SUPPORT("WOODHENGE_SUPPORT"),
      ;

      private String value;

      private EnumType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumWebDestinationType {
      @SerializedName("BECOME_A_VOLUNTEER")
      VALUE_BECOME_A_VOLUNTEER("BECOME_A_VOLUNTEER"),
      @SerializedName("BECOME_SUPPORTER")
      VALUE_BECOME_SUPPORTER("BECOME_SUPPORTER"),
      @SerializedName("EMAIL")
      VALUE_EMAIL("EMAIL"),
      @SerializedName("FOLLOW")
      VALUE_FOLLOW("FOLLOW"),
      @SerializedName("MESSENGER")
      VALUE_MESSENGER("MESSENGER"),
      @SerializedName("MOBILE_CENTER")
      VALUE_MOBILE_CENTER("MOBILE_CENTER"),
      @SerializedName("NONE")
      VALUE_NONE("NONE"),
      @SerializedName("SHOP_ON_FACEBOOK")
      VALUE_SHOP_ON_FACEBOOK("SHOP_ON_FACEBOOK"),
      @SerializedName("WEBSITE")
      VALUE_WEBSITE("WEBSITE"),
      ;

      private String value;

      private EnumWebDestinationType(String value) {
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

  public PageCallToAction copyFrom(PageCallToAction instance) {
    this.mAndroidApp = instance.mAndroidApp;
    this.mAndroidDeeplink = instance.mAndroidDeeplink;
    this.mAndroidDestinationType = instance.mAndroidDestinationType;
    this.mAndroidPackageName = instance.mAndroidPackageName;
    this.mAndroidUrl = instance.mAndroidUrl;
    this.mCreatedTime = instance.mCreatedTime;
    this.mEmailAddress = instance.mEmailAddress;
    this.mFrom = instance.mFrom;
    this.mId = instance.mId;
    this.mIntlNumberWithPlus = instance.mIntlNumberWithPlus;
    this.mIphoneApp = instance.mIphoneApp;
    this.mIphoneDeeplink = instance.mIphoneDeeplink;
    this.mIphoneDestinationType = instance.mIphoneDestinationType;
    this.mIphoneUrl = instance.mIphoneUrl;
    this.mStatus = instance.mStatus;
    this.mType = instance.mType;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mWebDestinationType = instance.mWebDestinationType;
    this.mWebUrl = instance.mWebUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageCallToAction> getParser() {
    return new APIRequest.ResponseParser<PageCallToAction>() {
      public APINodeList<PageCallToAction> parseResponse(String response, APIContext context, APIRequest<PageCallToAction> request, String header) throws MalformedResponseException {
        return PageCallToAction.parseResponse(response, context, request, header);
      }
    };
  }
}
