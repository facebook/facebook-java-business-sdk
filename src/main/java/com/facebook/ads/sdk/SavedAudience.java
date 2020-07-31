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
public class SavedAudience extends APINode {
  @SerializedName("account")
  private AdAccount mAccount = null;
  @SerializedName("approximate_count")
  private Long mApproximateCount = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("extra_info")
  private String mExtraInfo = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("permission_for_actions")
  private AudiencePermissionForActions mPermissionForActions = null;
  @SerializedName("run_status")
  private String mRunStatus = null;
  @SerializedName("sentence_lines")
  private JsonArray mSentenceLines = null;
  @SerializedName("targeting")
  private Targeting mTargeting = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_updated")
  private String mTimeUpdated = null;
  protected static Gson gson = null;

  SavedAudience() {
  }

  public SavedAudience(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public SavedAudience(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public SavedAudience fetch() throws APIException{
    SavedAudience newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static SavedAudience fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<SavedAudience> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static SavedAudience fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<SavedAudience> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<SavedAudience> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<SavedAudience>)(
      new APIRequest<SavedAudience>(context, "", "/", "GET", SavedAudience.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<SavedAudience>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", SavedAudience.getParser())
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
  public static SavedAudience loadJSON(String json, APIContext context, String header) {
    SavedAudience savedAudience = getGson().fromJson(json, SavedAudience.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(savedAudience.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    savedAudience.context = context;
    savedAudience.rawValue = json;
    savedAudience.header = header;
    return savedAudience;
  }

  public static APINodeList<SavedAudience> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<SavedAudience> savedAudiences = new APINodeList<SavedAudience>(request, json, header);
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
          savedAudiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return savedAudiences;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                savedAudiences.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            savedAudiences.setPaging(previous, next);
            if (context.hasAppSecret()) {
              savedAudiences.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              savedAudiences.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  savedAudiences.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              savedAudiences.add(loadJSON(obj.toString(), context, header));
            }
          }
          return savedAudiences;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              savedAudiences.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return savedAudiences;
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
              savedAudiences.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return savedAudiences;
          }

          // Sixth, check if it's pure JsonObject
          savedAudiences.clear();
          savedAudiences.add(loadJSON(json, context, header));
          return savedAudiences;
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


  public AdAccount getFieldAccount() {
    if (mAccount != null) {
      mAccount.context = getContext();
    }
    return mAccount;
  }

  public Long getFieldApproximateCount() {
    return mApproximateCount;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldExtraInfo() {
    return mExtraInfo;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldName() {
    return mName;
  }

  public AudiencePermissionForActions getFieldPermissionForActions() {
    return mPermissionForActions;
  }

  public String getFieldRunStatus() {
    return mRunStatus;
  }

  public JsonArray getFieldSentenceLines() {
    return mSentenceLines;
  }

  public Targeting getFieldTargeting() {
    return mTargeting;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldTimeUpdated() {
    return mTimeUpdated;
  }



  public static class APIRequestGet extends APIRequest<SavedAudience> {

    SavedAudience lastResponse = null;
    @Override
    public SavedAudience getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account",
      "approximate_count",
      "description",
      "extra_info",
      "id",
      "name",
      "permission_for_actions",
      "run_status",
      "sentence_lines",
      "targeting",
      "time_created",
      "time_updated",
    };

    @Override
    public SavedAudience parseResponse(String response, String header) throws APIException {
      return SavedAudience.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public SavedAudience execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SavedAudience execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<SavedAudience> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SavedAudience> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, SavedAudience>() {
           public SavedAudience apply(ResponseWrapper result) {
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

    public APIRequestGet requestAccountField () {
      return this.requestAccountField(true);
    }
    public APIRequestGet requestAccountField (boolean value) {
      this.requestField("account", value);
      return this;
    }
    public APIRequestGet requestApproximateCountField () {
      return this.requestApproximateCountField(true);
    }
    public APIRequestGet requestApproximateCountField (boolean value) {
      this.requestField("approximate_count", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestExtraInfoField () {
      return this.requestExtraInfoField(true);
    }
    public APIRequestGet requestExtraInfoField (boolean value) {
      this.requestField("extra_info", value);
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
    public APIRequestGet requestPermissionForActionsField () {
      return this.requestPermissionForActionsField(true);
    }
    public APIRequestGet requestPermissionForActionsField (boolean value) {
      this.requestField("permission_for_actions", value);
      return this;
    }
    public APIRequestGet requestRunStatusField () {
      return this.requestRunStatusField(true);
    }
    public APIRequestGet requestRunStatusField (boolean value) {
      this.requestField("run_status", value);
      return this;
    }
    public APIRequestGet requestSentenceLinesField () {
      return this.requestSentenceLinesField(true);
    }
    public APIRequestGet requestSentenceLinesField (boolean value) {
      this.requestField("sentence_lines", value);
      return this;
    }
    public APIRequestGet requestTargetingField () {
      return this.requestTargetingField(true);
    }
    public APIRequestGet requestTargetingField (boolean value) {
      this.requestField("targeting", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeUpdatedField () {
      return this.requestTimeUpdatedField(true);
    }
    public APIRequestGet requestTimeUpdatedField (boolean value) {
      this.requestField("time_updated", value);
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

  public SavedAudience copyFrom(SavedAudience instance) {
    this.mAccount = instance.mAccount;
    this.mApproximateCount = instance.mApproximateCount;
    this.mDescription = instance.mDescription;
    this.mExtraInfo = instance.mExtraInfo;
    this.mId = instance.mId;
    this.mName = instance.mName;
    this.mPermissionForActions = instance.mPermissionForActions;
    this.mRunStatus = instance.mRunStatus;
    this.mSentenceLines = instance.mSentenceLines;
    this.mTargeting = instance.mTargeting;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeUpdated = instance.mTimeUpdated;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<SavedAudience> getParser() {
    return new APIRequest.ResponseParser<SavedAudience>() {
      public APINodeList<SavedAudience> parseResponse(String response, APIContext context, APIRequest<SavedAudience> request, String header) throws MalformedResponseException {
        return SavedAudience.parseResponse(response, context, request, header);
      }
    };
  }
}
