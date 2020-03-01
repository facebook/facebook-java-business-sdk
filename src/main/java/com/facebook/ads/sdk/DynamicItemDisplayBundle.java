/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
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
public class DynamicItemDisplayBundle extends APINode {
  @SerializedName("additional_urls")
  private Map<String, String> mAdditionalUrls = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("product_set")
  private ProductSet mProductSet = null;
  @SerializedName("text_tokens")
  private Map<String, String> mTextTokens = null;
  @SerializedName("url")
  private String mUrl = null;
  protected static Gson gson = null;

  DynamicItemDisplayBundle() {
  }

  public DynamicItemDisplayBundle(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public DynamicItemDisplayBundle(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public DynamicItemDisplayBundle fetch() throws APIException{
    DynamicItemDisplayBundle newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static DynamicItemDisplayBundle fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<DynamicItemDisplayBundle> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static DynamicItemDisplayBundle fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<DynamicItemDisplayBundle> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<DynamicItemDisplayBundle> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<DynamicItemDisplayBundle>)(
      new APIRequest<DynamicItemDisplayBundle>(context, "", "/", "GET", DynamicItemDisplayBundle.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<DynamicItemDisplayBundle>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", DynamicItemDisplayBundle.getParser())
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
  public static DynamicItemDisplayBundle loadJSON(String json, APIContext context, String header) {
    DynamicItemDisplayBundle dynamicItemDisplayBundle = getGson().fromJson(json, DynamicItemDisplayBundle.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(dynamicItemDisplayBundle.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    dynamicItemDisplayBundle.context = context;
    dynamicItemDisplayBundle.rawValue = json;
    dynamicItemDisplayBundle.header = header;
    return dynamicItemDisplayBundle;
  }

  public static APINodeList<DynamicItemDisplayBundle> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<DynamicItemDisplayBundle> dynamicItemDisplayBundles = new APINodeList<DynamicItemDisplayBundle>(request, json, header);
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
          dynamicItemDisplayBundles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return dynamicItemDisplayBundles;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                dynamicItemDisplayBundles.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            dynamicItemDisplayBundles.setPaging(previous, next);
            if (context.hasAppSecret()) {
              dynamicItemDisplayBundles.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              dynamicItemDisplayBundles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  dynamicItemDisplayBundles.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              dynamicItemDisplayBundles.add(loadJSON(obj.toString(), context, header));
            }
          }
          return dynamicItemDisplayBundles;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              dynamicItemDisplayBundles.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return dynamicItemDisplayBundles;
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
              dynamicItemDisplayBundles.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return dynamicItemDisplayBundles;
          }

          // Sixth, check if it's pure JsonObject
          dynamicItemDisplayBundles.clear();
          dynamicItemDisplayBundles.add(loadJSON(json, context, header));
          return dynamicItemDisplayBundles;
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

  public APIRequestGetBundleFolders getBundleFolders() {
    return new APIRequestGetBundleFolders(this.getPrefixedId().toString(), context);
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


  public Map<String, String> getFieldAdditionalUrls() {
    return mAdditionalUrls;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public ProductSet getFieldProductSet() {
    if (mProductSet != null) {
      mProductSet.context = getContext();
    }
    return mProductSet;
  }

  public Map<String, String> getFieldTextTokens() {
    return mTextTokens;
  }

  public String getFieldUrl() {
    return mUrl;
  }



  public static class APIRequestGetBundleFolders extends APIRequest<DynamicItemDisplayBundleFolder> {

    APINodeList<DynamicItemDisplayBundleFolder> lastResponse = null;
    @Override
    public APINodeList<DynamicItemDisplayBundleFolder> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "categorization_criteria",
      "id",
      "name",
      "product_catalog",
      "product_set",
      "valid_labels",
    };

    @Override
    public APINodeList<DynamicItemDisplayBundleFolder> parseResponse(String response, String header) throws APIException {
      return DynamicItemDisplayBundleFolder.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<DynamicItemDisplayBundleFolder> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<DynamicItemDisplayBundleFolder> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<DynamicItemDisplayBundleFolder>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<DynamicItemDisplayBundleFolder>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<DynamicItemDisplayBundleFolder>>() {
           public APINodeList<DynamicItemDisplayBundleFolder> apply(ResponseWrapper result) {
             try {
               return APIRequestGetBundleFolders.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBundleFolders(String nodeId, APIContext context) {
      super(context, nodeId, "/bundle_folders", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBundleFolders setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBundleFolders setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBundleFolders requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBundleFolders requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBundleFolders requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBundleFolders requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBundleFolders requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBundleFolders requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetBundleFolders requestCategorizationCriteriaField () {
      return this.requestCategorizationCriteriaField(true);
    }
    public APIRequestGetBundleFolders requestCategorizationCriteriaField (boolean value) {
      this.requestField("categorization_criteria", value);
      return this;
    }
    public APIRequestGetBundleFolders requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetBundleFolders requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetBundleFolders requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGetBundleFolders requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGetBundleFolders requestProductCatalogField () {
      return this.requestProductCatalogField(true);
    }
    public APIRequestGetBundleFolders requestProductCatalogField (boolean value) {
      this.requestField("product_catalog", value);
      return this;
    }
    public APIRequestGetBundleFolders requestProductSetField () {
      return this.requestProductSetField(true);
    }
    public APIRequestGetBundleFolders requestProductSetField (boolean value) {
      this.requestField("product_set", value);
      return this;
    }
    public APIRequestGetBundleFolders requestValidLabelsField () {
      return this.requestValidLabelsField(true);
    }
    public APIRequestGetBundleFolders requestValidLabelsField (boolean value) {
      this.requestField("valid_labels", value);
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
         }
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

  public static class APIRequestGet extends APIRequest<DynamicItemDisplayBundle> {

    DynamicItemDisplayBundle lastResponse = null;
    @Override
    public DynamicItemDisplayBundle getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "additional_urls",
      "description",
      "id",
      "name",
      "product_set",
      "text_tokens",
      "url",
    };

    @Override
    public DynamicItemDisplayBundle parseResponse(String response, String header) throws APIException {
      return DynamicItemDisplayBundle.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public DynamicItemDisplayBundle execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public DynamicItemDisplayBundle execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<DynamicItemDisplayBundle> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<DynamicItemDisplayBundle> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, DynamicItemDisplayBundle>() {
           public DynamicItemDisplayBundle apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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

    public APIRequestGet requestAdditionalUrlsField () {
      return this.requestAdditionalUrlsField(true);
    }
    public APIRequestGet requestAdditionalUrlsField (boolean value) {
      this.requestField("additional_urls", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
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
    public APIRequestGet requestProductSetField () {
      return this.requestProductSetField(true);
    }
    public APIRequestGet requestProductSetField (boolean value) {
      this.requestField("product_set", value);
      return this;
    }
    public APIRequestGet requestTextTokensField () {
      return this.requestTextTokensField(true);
    }
    public APIRequestGet requestTextTokensField (boolean value) {
      this.requestField("text_tokens", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<DynamicItemDisplayBundle> {

    DynamicItemDisplayBundle lastResponse = null;
    @Override
    public DynamicItemDisplayBundle getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "additional_urls",
      "description",
      "name",
      "text_tokens",
      "url",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public DynamicItemDisplayBundle parseResponse(String response, String header) throws APIException {
      return DynamicItemDisplayBundle.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public DynamicItemDisplayBundle execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public DynamicItemDisplayBundle execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<DynamicItemDisplayBundle> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<DynamicItemDisplayBundle> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, DynamicItemDisplayBundle>() {
           public DynamicItemDisplayBundle apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestUpdate setAdditionalUrls (Map<String, String> additionalUrls) {
      this.setParam("additional_urls", additionalUrls);
      return this;
    }
    public APIRequestUpdate setAdditionalUrls (String additionalUrls) {
      this.setParam("additional_urls", additionalUrls);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
      return this;
    }

    public APIRequestUpdate setTextTokens (Map<String, String> textTokens) {
      this.setParam("text_tokens", textTokens);
      return this;
    }
    public APIRequestUpdate setTextTokens (String textTokens) {
      this.setParam("text_tokens", textTokens);
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

  public DynamicItemDisplayBundle copyFrom(DynamicItemDisplayBundle instance) {
    this.mAdditionalUrls = instance.mAdditionalUrls;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mProductSet = instance.mProductSet;
    this.mTextTokens = instance.mTextTokens;
    this.mUrl = instance.mUrl;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<DynamicItemDisplayBundle> getParser() {
    return new APIRequest.ResponseParser<DynamicItemDisplayBundle>() {
      public APINodeList<DynamicItemDisplayBundle> parseResponse(String response, APIContext context, APIRequest<DynamicItemDisplayBundle> request, String header) throws MalformedResponseException {
        return DynamicItemDisplayBundle.parseResponse(response, context, request, header);
      }
    };
  }
}
