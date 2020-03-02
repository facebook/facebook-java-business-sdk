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
public class PageChangeProposal extends APINode {
  @SerializedName("acceptance_status")
  private String mAcceptanceStatus = null;
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("current_value")
  private String mCurrentValue = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("proposed_value")
  private String mProposedValue = null;
  @SerializedName("upcoming_change_info")
  private PageUpcomingChange mUpcomingChangeInfo = null;
  protected static Gson gson = null;

  PageChangeProposal() {
  }

  public PageChangeProposal(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PageChangeProposal(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public PageChangeProposal fetch() throws APIException{
    PageChangeProposal newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PageChangeProposal fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PageChangeProposal> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PageChangeProposal fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<PageChangeProposal> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<PageChangeProposal> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PageChangeProposal>)(
      new APIRequest<PageChangeProposal>(context, "", "/", "GET", PageChangeProposal.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PageChangeProposal>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", PageChangeProposal.getParser())
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
  public static PageChangeProposal loadJSON(String json, APIContext context, String header) {
    PageChangeProposal pageChangeProposal = getGson().fromJson(json, PageChangeProposal.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageChangeProposal.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    pageChangeProposal.context = context;
    pageChangeProposal.rawValue = json;
    pageChangeProposal.header = header;
    return pageChangeProposal;
  }

  public static APINodeList<PageChangeProposal> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<PageChangeProposal> pageChangeProposals = new APINodeList<PageChangeProposal>(request, json, header);
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
          pageChangeProposals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return pageChangeProposals;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageChangeProposals.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageChangeProposals.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageChangeProposals.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageChangeProposals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  pageChangeProposals.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageChangeProposals.add(loadJSON(obj.toString(), context, header));
            }
          }
          return pageChangeProposals;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageChangeProposals.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return pageChangeProposals;
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
              pageChangeProposals.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageChangeProposals;
          }

          // Sixth, check if it's pure JsonObject
          pageChangeProposals.clear();
          pageChangeProposals.add(loadJSON(json, context, header));
          return pageChangeProposals;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAcceptanceStatus() {
    return mAcceptanceStatus;
  }

  public String getFieldCategory() {
    return mCategory;
  }

  public String getFieldCurrentValue() {
    return mCurrentValue;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldProposedValue() {
    return mProposedValue;
  }

  public PageUpcomingChange getFieldUpcomingChangeInfo() {
    if (mUpcomingChangeInfo != null) {
      mUpcomingChangeInfo.context = getContext();
    }
    return mUpcomingChangeInfo;
  }



  public static class APIRequestGet extends APIRequest<PageChangeProposal> {

    PageChangeProposal lastResponse = null;
    @Override
    public PageChangeProposal getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "acceptance_status",
      "category",
      "current_value",
      "id",
      "proposed_value",
      "upcoming_change_info",
    };

    @Override
    public PageChangeProposal parseResponse(String response, String header) throws APIException {
      return PageChangeProposal.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PageChangeProposal execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageChangeProposal execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PageChangeProposal> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageChangeProposal> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PageChangeProposal>() {
           public PageChangeProposal apply(ResponseWrapper result) {
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

    public APIRequestGet requestAcceptanceStatusField () {
      return this.requestAcceptanceStatusField(true);
    }
    public APIRequestGet requestAcceptanceStatusField (boolean value) {
      this.requestField("acceptance_status", value);
      return this;
    }
    public APIRequestGet requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGet requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGet requestCurrentValueField () {
      return this.requestCurrentValueField(true);
    }
    public APIRequestGet requestCurrentValueField (boolean value) {
      this.requestField("current_value", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestProposedValueField () {
      return this.requestProposedValueField(true);
    }
    public APIRequestGet requestProposedValueField (boolean value) {
      this.requestField("proposed_value", value);
      return this;
    }
    public APIRequestGet requestUpcomingChangeInfoField () {
      return this.requestUpcomingChangeInfoField(true);
    }
    public APIRequestGet requestUpcomingChangeInfoField (boolean value) {
      this.requestField("upcoming_change_info", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<PageChangeProposal> {

    PageChangeProposal lastResponse = null;
    @Override
    public PageChangeProposal getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "accept",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PageChangeProposal parseResponse(String response, String header) throws APIException {
      return PageChangeProposal.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public PageChangeProposal execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageChangeProposal execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<PageChangeProposal> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageChangeProposal> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, PageChangeProposal>() {
           public PageChangeProposal apply(ResponseWrapper result) {
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


    public APIRequestUpdate setAccept (Boolean accept) {
      this.setParam("accept", accept);
      return this;
    }
    public APIRequestUpdate setAccept (String accept) {
      this.setParam("accept", accept);
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

  public PageChangeProposal copyFrom(PageChangeProposal instance) {
    this.mAcceptanceStatus = instance.mAcceptanceStatus;
    this.mCategory = instance.mCategory;
    this.mCurrentValue = instance.mCurrentValue;
    this.mId = instance.mId;
    this.mProposedValue = instance.mProposedValue;
    this.mUpcomingChangeInfo = instance.mUpcomingChangeInfo;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageChangeProposal> getParser() {
    return new APIRequest.ResponseParser<PageChangeProposal>() {
      public APINodeList<PageChangeProposal> parseResponse(String response, APIContext context, APIRequest<PageChangeProposal> request, String header) throws MalformedResponseException {
        return PageChangeProposal.parseResponse(response, context, request, header);
      }
    };
  }
}
