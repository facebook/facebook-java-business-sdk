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
public class AdAssetFeed extends APINode {
  @SerializedName("account")
  private AdAccount mAccount = null;
  @SerializedName("ad_formats")
  private List<String> mAdFormats = null;
  @SerializedName("additional_data")
  private Object mAdditionalData = null;
  @SerializedName("autotranslate")
  private List<String> mAutotranslate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("optimization_type")
  private String mOptimizationType = null;
  protected static Gson gson = null;

  AdAssetFeed() {
  }

  public AdAssetFeed(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAssetFeed(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAssetFeed fetch() throws APIException{
    AdAssetFeed newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAssetFeed fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAssetFeed> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAssetFeed fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAssetFeed> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAssetFeed> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAssetFeed>)(
      new APIRequest<AdAssetFeed>(context, "", "/", "GET", AdAssetFeed.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAssetFeed>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAssetFeed.getParser())
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
  public static AdAssetFeed loadJSON(String json, APIContext context) {
    AdAssetFeed adAssetFeed = getGson().fromJson(json, AdAssetFeed.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAssetFeed.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAssetFeed.context = context;
    adAssetFeed.rawValue = json;
    return adAssetFeed;
  }

  public static APINodeList<AdAssetFeed> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAssetFeed> adAssetFeeds = new APINodeList<AdAssetFeed>(request, json);
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
          adAssetFeeds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAssetFeeds;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAssetFeeds.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAssetFeeds.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAssetFeeds.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAssetFeeds.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adAssetFeeds.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAssetFeeds.add(loadJSON(obj.toString(), context));
            }
          }
          return adAssetFeeds;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAssetFeeds.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAssetFeeds;
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
              adAssetFeeds.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAssetFeeds;
          }

          // Sixth, check if it's pure JsonObject
          adAssetFeeds.clear();
          adAssetFeeds.add(loadJSON(json, context));
          return adAssetFeeds;
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

  public APIRequestGetAssetCustomizationRules getAssetCustomizationRules() {
    return new APIRequestGetAssetCustomizationRules(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetBodies getBodies() {
    return new APIRequestGetBodies(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCallToActionTypes getCallToActionTypes() {
    return new APIRequestGetCallToActionTypes(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetCaptions getCaptions() {
    return new APIRequestGetCaptions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetDescriptions getDescriptions() {
    return new APIRequestGetDescriptions(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetGroups getGroups() {
    return new APIRequestGetGroups(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetImages getImages() {
    return new APIRequestGetImages(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetLinkUrls getLinkUrls() {
    return new APIRequestGetLinkUrls(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetTitles getTitles() {
    return new APIRequestGetTitles(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetVideos getVideos() {
    return new APIRequestGetVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public AdAccount getFieldAccount() {
    if (mAccount != null) {
      mAccount.context = getContext();
    }
    return mAccount;
  }

  public List<String> getFieldAdFormats() {
    return mAdFormats;
  }

  public Object getFieldAdditionalData() {
    return mAdditionalData;
  }

  public List<String> getFieldAutotranslate() {
    return mAutotranslate;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldOptimizationType() {
    return mOptimizationType;
  }



  public static class APIRequestGetAssetCustomizationRules extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetAssetCustomizationRules.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetAssetCustomizationRules(String nodeId, APIContext context) {
      super(context, nodeId, "/asset_customization_rules", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetAssetCustomizationRules setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetAssetCustomizationRules setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetAssetCustomizationRules requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetAssetCustomizationRules requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssetCustomizationRules requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetAssetCustomizationRules requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetAssetCustomizationRules requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetAssetCustomizationRules requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetBodies extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetBodies.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetBodies(String nodeId, APIContext context) {
      super(context, nodeId, "/bodies", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetBodies setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetBodies setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetBodies requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetBodies requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBodies requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetBodies requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetBodies requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetBodies requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCallToActionTypes extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetCallToActionTypes.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCallToActionTypes(String nodeId, APIContext context) {
      super(context, nodeId, "/call_to_action_types", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCallToActionTypes setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCallToActionTypes setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCallToActionTypes requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCallToActionTypes requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCallToActionTypes requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCallToActionTypes requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCallToActionTypes requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCallToActionTypes requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetCaptions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetCaptions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetCaptions(String nodeId, APIContext context) {
      super(context, nodeId, "/captions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetCaptions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetCaptions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetCaptions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetCaptions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCaptions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetCaptions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetCaptions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetCaptions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetDescriptions extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetDescriptions.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetDescriptions(String nodeId, APIContext context) {
      super(context, nodeId, "/descriptions", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetDescriptions setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetDescriptions setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetDescriptions requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetDescriptions requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDescriptions requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetDescriptions requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetDescriptions requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetDescriptions requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetGroups extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetGroups.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetGroups(String nodeId, APIContext context) {
      super(context, nodeId, "/groups", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetGroups setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetGroups setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetGroups requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetGroups requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGroups requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetGroups requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetGroups requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetGroups requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetImages extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetImages.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetImages(String nodeId, APIContext context) {
      super(context, nodeId, "/images", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetImages setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetImages setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetImages requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetImages requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetImages requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetImages requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetImages requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetImages requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetLinkUrls extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetLinkUrls.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetLinkUrls(String nodeId, APIContext context) {
      super(context, nodeId, "/link_urls", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetLinkUrls setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetLinkUrls setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetLinkUrls requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetLinkUrls requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLinkUrls requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetLinkUrls requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetLinkUrls requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetLinkUrls requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetTitles extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetTitles.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetTitles(String nodeId, APIContext context) {
      super(context, nodeId, "/titles", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetTitles setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetTitles setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetTitles requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetTitles requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTitles requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetTitles requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetTitles requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetTitles requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetVideos extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestGetVideos.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetVideos(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetVideos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetVideos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetVideos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetVideos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetVideos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetVideos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetVideos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<AdAssetFeed> {

    AdAssetFeed lastResponse = null;
    @Override
    public AdAssetFeed getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account",
      "ad_formats",
      "additional_data",
      "autotranslate",
      "id",
      "optimization_type",
    };

    @Override
    public AdAssetFeed parseResponse(String response) throws APIException {
      return AdAssetFeed.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAssetFeed execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAssetFeed execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAssetFeed> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAssetFeed> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAssetFeed>() {
           public AdAssetFeed apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
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

    public APIRequestGet requestAccountField () {
      return this.requestAccountField(true);
    }
    public APIRequestGet requestAccountField (boolean value) {
      this.requestField("account", value);
      return this;
    }
    public APIRequestGet requestAdFormatsField () {
      return this.requestAdFormatsField(true);
    }
    public APIRequestGet requestAdFormatsField (boolean value) {
      this.requestField("ad_formats", value);
      return this;
    }
    public APIRequestGet requestAdditionalDataField () {
      return this.requestAdditionalDataField(true);
    }
    public APIRequestGet requestAdditionalDataField (boolean value) {
      this.requestField("additional_data", value);
      return this;
    }
    public APIRequestGet requestAutotranslateField () {
      return this.requestAutotranslateField(true);
    }
    public APIRequestGet requestAutotranslateField (boolean value) {
      this.requestField("autotranslate", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestOptimizationTypeField () {
      return this.requestOptimizationTypeField(true);
    }
    public APIRequestGet requestOptimizationTypeField (boolean value) {
      this.requestField("optimization_type", value);
      return this;
    }
  }

  public static enum EnumAdFormats {
      @SerializedName("AUTOMATIC_FORMAT")
      VALUE_AUTOMATIC_FORMAT("AUTOMATIC_FORMAT"),
      @SerializedName("CAROUSEL_IMAGE")
      VALUE_CAROUSEL_IMAGE("CAROUSEL_IMAGE"),
      @SerializedName("CAROUSEL_VIDEO")
      VALUE_CAROUSEL_VIDEO("CAROUSEL_VIDEO"),
      @SerializedName("SINGLE_IMAGE")
      VALUE_SINGLE_IMAGE("SINGLE_IMAGE"),
      @SerializedName("SINGLE_VIDEO")
      VALUE_SINGLE_VIDEO("SINGLE_VIDEO"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumAdFormats(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCallToActionTypes {
      @SerializedName("OPEN_LINK")
      VALUE_OPEN_LINK("OPEN_LINK"),
      @SerializedName("LIKE_PAGE")
      VALUE_LIKE_PAGE("LIKE_PAGE"),
      @SerializedName("SHOP_NOW")
      VALUE_SHOP_NOW("SHOP_NOW"),
      @SerializedName("PLAY_GAME")
      VALUE_PLAY_GAME("PLAY_GAME"),
      @SerializedName("INSTALL_APP")
      VALUE_INSTALL_APP("INSTALL_APP"),
      @SerializedName("USE_APP")
      VALUE_USE_APP("USE_APP"),
      @SerializedName("CALL")
      VALUE_CALL("CALL"),
      @SerializedName("CALL_ME")
      VALUE_CALL_ME("CALL_ME"),
      @SerializedName("INSTALL_MOBILE_APP")
      VALUE_INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
      @SerializedName("USE_MOBILE_APP")
      VALUE_USE_MOBILE_APP("USE_MOBILE_APP"),
      @SerializedName("MOBILE_DOWNLOAD")
      VALUE_MOBILE_DOWNLOAD("MOBILE_DOWNLOAD"),
      @SerializedName("BOOK_TRAVEL")
      VALUE_BOOK_TRAVEL("BOOK_TRAVEL"),
      @SerializedName("LISTEN_MUSIC")
      VALUE_LISTEN_MUSIC("LISTEN_MUSIC"),
      @SerializedName("WATCH_VIDEO")
      VALUE_WATCH_VIDEO("WATCH_VIDEO"),
      @SerializedName("LEARN_MORE")
      VALUE_LEARN_MORE("LEARN_MORE"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("DOWNLOAD")
      VALUE_DOWNLOAD("DOWNLOAD"),
      @SerializedName("WATCH_MORE")
      VALUE_WATCH_MORE("WATCH_MORE"),
      @SerializedName("NO_BUTTON")
      VALUE_NO_BUTTON("NO_BUTTON"),
      @SerializedName("VISIT_PAGES_FEED")
      VALUE_VISIT_PAGES_FEED("VISIT_PAGES_FEED"),
      @SerializedName("APPLY_NOW")
      VALUE_APPLY_NOW("APPLY_NOW"),
      @SerializedName("BUY_NOW")
      VALUE_BUY_NOW("BUY_NOW"),
      @SerializedName("GET_OFFER")
      VALUE_GET_OFFER("GET_OFFER"),
      @SerializedName("GET_OFFER_VIEW")
      VALUE_GET_OFFER_VIEW("GET_OFFER_VIEW"),
      @SerializedName("BUY_TICKETS")
      VALUE_BUY_TICKETS("BUY_TICKETS"),
      @SerializedName("UPDATE_APP")
      VALUE_UPDATE_APP("UPDATE_APP"),
      @SerializedName("GET_DIRECTIONS")
      VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
      @SerializedName("BUY")
      VALUE_BUY("BUY"),
      @SerializedName("MESSAGE_PAGE")
      VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("SAY_THANKS")
      VALUE_SAY_THANKS("SAY_THANKS"),
      @SerializedName("SELL_NOW")
      VALUE_SELL_NOW("SELL_NOW"),
      @SerializedName("SHARE")
      VALUE_SHARE("SHARE"),
      @SerializedName("DONATE_NOW")
      VALUE_DONATE_NOW("DONATE_NOW"),
      @SerializedName("GET_QUOTE")
      VALUE_GET_QUOTE("GET_QUOTE"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("ORDER_NOW")
      VALUE_ORDER_NOW("ORDER_NOW"),
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("VIDEO_ANNOTATION")
      VALUE_VIDEO_ANNOTATION("VIDEO_ANNOTATION"),
      @SerializedName("MOMENTS")
      VALUE_MOMENTS("MOMENTS"),
      @SerializedName("RECORD_NOW")
      VALUE_RECORD_NOW("RECORD_NOW"),
      @SerializedName("GET_SHOWTIMES")
      VALUE_GET_SHOWTIMES("GET_SHOWTIMES"),
      @SerializedName("LISTEN_NOW")
      VALUE_LISTEN_NOW("LISTEN_NOW"),
      @SerializedName("WOODHENGE_SUPPORT")
      VALUE_WOODHENGE_SUPPORT("WOODHENGE_SUPPORT"),
      @SerializedName("EVENT_RSVP")
      VALUE_EVENT_RSVP("EVENT_RSVP"),
      @SerializedName("WHATSAPP_MESSAGE")
      VALUE_WHATSAPP_MESSAGE("WHATSAPP_MESSAGE"),
      @SerializedName("FOLLOW_NEWS_STORYLINE")
      VALUE_FOLLOW_NEWS_STORYLINE("FOLLOW_NEWS_STORYLINE"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumCallToActionTypes(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumOptimizationType {
      @SerializedName("REGULAR")
      VALUE_REGULAR("REGULAR"),
      @SerializedName("LANGUAGE")
      VALUE_LANGUAGE("LANGUAGE"),
      @SerializedName("PLACEMENT")
      VALUE_PLACEMENT("PLACEMENT"),
      @SerializedName("VIDEO_BANDWIDTH")
      VALUE_VIDEO_BANDWIDTH("VIDEO_BANDWIDTH"),
      @SerializedName("BRAND")
      VALUE_BRAND("BRAND"),
      @SerializedName("ASSET_CUSTOMIZATION")
      VALUE_ASSET_CUSTOMIZATION("ASSET_CUSTOMIZATION"),
      @SerializedName("DCO_PARITY")
      VALUE_DCO_PARITY("DCO_PARITY"),
      @SerializedName("PREVIEW_DYNAMIC_RENDERING")
      VALUE_PREVIEW_DYNAMIC_RENDERING("PREVIEW_DYNAMIC_RENDERING"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumOptimizationType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCallToActionType {
      @SerializedName("OPEN_LINK")
      VALUE_OPEN_LINK("OPEN_LINK"),
      @SerializedName("LIKE_PAGE")
      VALUE_LIKE_PAGE("LIKE_PAGE"),
      @SerializedName("SHOP_NOW")
      VALUE_SHOP_NOW("SHOP_NOW"),
      @SerializedName("PLAY_GAME")
      VALUE_PLAY_GAME("PLAY_GAME"),
      @SerializedName("INSTALL_APP")
      VALUE_INSTALL_APP("INSTALL_APP"),
      @SerializedName("USE_APP")
      VALUE_USE_APP("USE_APP"),
      @SerializedName("CALL")
      VALUE_CALL("CALL"),
      @SerializedName("CALL_ME")
      VALUE_CALL_ME("CALL_ME"),
      @SerializedName("INSTALL_MOBILE_APP")
      VALUE_INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
      @SerializedName("USE_MOBILE_APP")
      VALUE_USE_MOBILE_APP("USE_MOBILE_APP"),
      @SerializedName("MOBILE_DOWNLOAD")
      VALUE_MOBILE_DOWNLOAD("MOBILE_DOWNLOAD"),
      @SerializedName("BOOK_TRAVEL")
      VALUE_BOOK_TRAVEL("BOOK_TRAVEL"),
      @SerializedName("LISTEN_MUSIC")
      VALUE_LISTEN_MUSIC("LISTEN_MUSIC"),
      @SerializedName("WATCH_VIDEO")
      VALUE_WATCH_VIDEO("WATCH_VIDEO"),
      @SerializedName("LEARN_MORE")
      VALUE_LEARN_MORE("LEARN_MORE"),
      @SerializedName("SIGN_UP")
      VALUE_SIGN_UP("SIGN_UP"),
      @SerializedName("DOWNLOAD")
      VALUE_DOWNLOAD("DOWNLOAD"),
      @SerializedName("WATCH_MORE")
      VALUE_WATCH_MORE("WATCH_MORE"),
      @SerializedName("NO_BUTTON")
      VALUE_NO_BUTTON("NO_BUTTON"),
      @SerializedName("VISIT_PAGES_FEED")
      VALUE_VISIT_PAGES_FEED("VISIT_PAGES_FEED"),
      @SerializedName("APPLY_NOW")
      VALUE_APPLY_NOW("APPLY_NOW"),
      @SerializedName("BUY_NOW")
      VALUE_BUY_NOW("BUY_NOW"),
      @SerializedName("GET_OFFER")
      VALUE_GET_OFFER("GET_OFFER"),
      @SerializedName("GET_OFFER_VIEW")
      VALUE_GET_OFFER_VIEW("GET_OFFER_VIEW"),
      @SerializedName("BUY_TICKETS")
      VALUE_BUY_TICKETS("BUY_TICKETS"),
      @SerializedName("UPDATE_APP")
      VALUE_UPDATE_APP("UPDATE_APP"),
      @SerializedName("GET_DIRECTIONS")
      VALUE_GET_DIRECTIONS("GET_DIRECTIONS"),
      @SerializedName("BUY")
      VALUE_BUY("BUY"),
      @SerializedName("MESSAGE_PAGE")
      VALUE_MESSAGE_PAGE("MESSAGE_PAGE"),
      @SerializedName("DONATE")
      VALUE_DONATE("DONATE"),
      @SerializedName("SUBSCRIBE")
      VALUE_SUBSCRIBE("SUBSCRIBE"),
      @SerializedName("SAY_THANKS")
      VALUE_SAY_THANKS("SAY_THANKS"),
      @SerializedName("SELL_NOW")
      VALUE_SELL_NOW("SELL_NOW"),
      @SerializedName("SHARE")
      VALUE_SHARE("SHARE"),
      @SerializedName("DONATE_NOW")
      VALUE_DONATE_NOW("DONATE_NOW"),
      @SerializedName("GET_QUOTE")
      VALUE_GET_QUOTE("GET_QUOTE"),
      @SerializedName("CONTACT_US")
      VALUE_CONTACT_US("CONTACT_US"),
      @SerializedName("ORDER_NOW")
      VALUE_ORDER_NOW("ORDER_NOW"),
      @SerializedName("ADD_TO_CART")
      VALUE_ADD_TO_CART("ADD_TO_CART"),
      @SerializedName("VIDEO_ANNOTATION")
      VALUE_VIDEO_ANNOTATION("VIDEO_ANNOTATION"),
      @SerializedName("MOMENTS")
      VALUE_MOMENTS("MOMENTS"),
      @SerializedName("RECORD_NOW")
      VALUE_RECORD_NOW("RECORD_NOW"),
      @SerializedName("GET_SHOWTIMES")
      VALUE_GET_SHOWTIMES("GET_SHOWTIMES"),
      @SerializedName("LISTEN_NOW")
      VALUE_LISTEN_NOW("LISTEN_NOW"),
      @SerializedName("WOODHENGE_SUPPORT")
      VALUE_WOODHENGE_SUPPORT("WOODHENGE_SUPPORT"),
      @SerializedName("EVENT_RSVP")
      VALUE_EVENT_RSVP("EVENT_RSVP"),
      @SerializedName("WHATSAPP_MESSAGE")
      VALUE_WHATSAPP_MESSAGE("WHATSAPP_MESSAGE"),
      @SerializedName("FOLLOW_NEWS_STORYLINE")
      VALUE_FOLLOW_NEWS_STORYLINE("FOLLOW_NEWS_STORYLINE"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumCallToActionType(String value) {
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

  public AdAssetFeed copyFrom(AdAssetFeed instance) {
    this.mAccount = instance.mAccount;
    this.mAdFormats = instance.mAdFormats;
    this.mAdditionalData = instance.mAdditionalData;
    this.mAutotranslate = instance.mAutotranslate;
    this.mId = instance.mId;
    this.mOptimizationType = instance.mOptimizationType;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAssetFeed> getParser() {
    return new APIRequest.ResponseParser<AdAssetFeed>() {
      public APINodeList<AdAssetFeed> parseResponse(String response, APIContext context, APIRequest<AdAssetFeed> request) throws MalformedResponseException {
        return AdAssetFeed.parseResponse(response, context, request);
      }
    };
  }
}
