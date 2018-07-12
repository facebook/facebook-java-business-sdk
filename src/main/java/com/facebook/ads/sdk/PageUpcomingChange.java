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
public class PageUpcomingChange extends APINode {
  @SerializedName("change_type")
  private String mChangeType = null;
  @SerializedName("effective_time")
  private String mEffectiveTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("proposal")
  private PageChangeProposal mProposal = null;
  @SerializedName("timer_status")
  private String mTimerStatus = null;
  protected static Gson gson = null;

  PageUpcomingChange() {
  }

  public PageUpcomingChange(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public PageUpcomingChange(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public PageUpcomingChange fetch() throws APIException{
    PageUpcomingChange newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static PageUpcomingChange fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<PageUpcomingChange> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static PageUpcomingChange fetchById(String id, APIContext context) throws APIException {
    PageUpcomingChange pageUpcomingChange =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return pageUpcomingChange;
  }

  public static ListenableFuture<PageUpcomingChange> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<PageUpcomingChange> pageUpcomingChange =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return pageUpcomingChange;
  }

  public static APINodeList<PageUpcomingChange> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<PageUpcomingChange>)(
      new APIRequest<PageUpcomingChange>(context, "", "/", "GET", PageUpcomingChange.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<PageUpcomingChange>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<PageUpcomingChange>> pageUpcomingChange =
      new APIRequest(context, "", "/", "GET", PageUpcomingChange.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return pageUpcomingChange;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static PageUpcomingChange loadJSON(String json, APIContext context) {
    PageUpcomingChange pageUpcomingChange = getGson().fromJson(json, PageUpcomingChange.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(pageUpcomingChange.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    pageUpcomingChange.context = context;
    pageUpcomingChange.rawValue = json;
    return pageUpcomingChange;
  }

  public static APINodeList<PageUpcomingChange> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<PageUpcomingChange> pageUpcomingChanges = new APINodeList<PageUpcomingChange>(request, json);
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
          pageUpcomingChanges.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return pageUpcomingChanges;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                pageUpcomingChanges.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            pageUpcomingChanges.setPaging(previous, next);
            if (context.hasAppSecret()) {
              pageUpcomingChanges.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              pageUpcomingChanges.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  pageUpcomingChanges.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              pageUpcomingChanges.add(loadJSON(obj.toString(), context));
            }
          }
          return pageUpcomingChanges;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              pageUpcomingChanges.add(loadJSON(entry.getValue().toString(), context));
          }
          return pageUpcomingChanges;
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
              pageUpcomingChanges.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return pageUpcomingChanges;
          }

          // Sixth, check if it's pure JsonObject
          pageUpcomingChanges.clear();
          pageUpcomingChanges.add(loadJSON(json, context));
          return pageUpcomingChanges;
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


  public String getFieldChangeType() {
    return mChangeType;
  }

  public String getFieldEffectiveTime() {
    return mEffectiveTime;
  }

  public String getFieldId() {
    return mId;
  }

  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public PageChangeProposal getFieldProposal() {
    if (mProposal != null) {
      mProposal.context = getContext();
    }
    return mProposal;
  }

  public String getFieldTimerStatus() {
    return mTimerStatus;
  }



  public static class APIRequestGet extends APIRequest<PageUpcomingChange> {

    PageUpcomingChange lastResponse = null;
    @Override
    public PageUpcomingChange getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "change_type",
      "effective_time",
      "id",
      "page",
      "proposal",
      "timer_status",
    };

    @Override
    public PageUpcomingChange parseResponse(String response) throws APIException {
      return PageUpcomingChange.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PageUpcomingChange execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageUpcomingChange execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PageUpcomingChange> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageUpcomingChange> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PageUpcomingChange>() {
           public PageUpcomingChange apply(String result) {
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

    public APIRequestGet requestChangeTypeField () {
      return this.requestChangeTypeField(true);
    }
    public APIRequestGet requestChangeTypeField (boolean value) {
      this.requestField("change_type", value);
      return this;
    }
    public APIRequestGet requestEffectiveTimeField () {
      return this.requestEffectiveTimeField(true);
    }
    public APIRequestGet requestEffectiveTimeField (boolean value) {
      this.requestField("effective_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestProposalField () {
      return this.requestProposalField(true);
    }
    public APIRequestGet requestProposalField (boolean value) {
      this.requestField("proposal", value);
      return this;
    }
    public APIRequestGet requestTimerStatusField () {
      return this.requestTimerStatusField(true);
    }
    public APIRequestGet requestTimerStatusField (boolean value) {
      this.requestField("timer_status", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<PageUpcomingChange> {

    PageUpcomingChange lastResponse = null;
    @Override
    public PageUpcomingChange getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "accept",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public PageUpcomingChange parseResponse(String response) throws APIException {
      return PageUpcomingChange.parseResponse(response, getContext(), this).head();
    }

    @Override
    public PageUpcomingChange execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public PageUpcomingChange execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<PageUpcomingChange> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<PageUpcomingChange> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, PageUpcomingChange>() {
           public PageUpcomingChange apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
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

  public PageUpcomingChange copyFrom(PageUpcomingChange instance) {
    this.mChangeType = instance.mChangeType;
    this.mEffectiveTime = instance.mEffectiveTime;
    this.mId = instance.mId;
    this.mPage = instance.mPage;
    this.mProposal = instance.mProposal;
    this.mTimerStatus = instance.mTimerStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<PageUpcomingChange> getParser() {
    return new APIRequest.ResponseParser<PageUpcomingChange>() {
      public APINodeList<PageUpcomingChange> parseResponse(String response, APIContext context, APIRequest<PageUpcomingChange> request) throws MalformedResponseException {
        return PageUpcomingChange.parseResponse(response, context, request);
      }
    };
  }
}
