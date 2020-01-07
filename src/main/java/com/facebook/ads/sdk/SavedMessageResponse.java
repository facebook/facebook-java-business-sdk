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
public class SavedMessageResponse extends APINode {
  @SerializedName("category")
  private String mCategory = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image")
  private String mImage = null;
  @SerializedName("is_enabled")
  private Boolean mIsEnabled = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("title")
  private String mTitle = null;
  protected static Gson gson = null;

  SavedMessageResponse() {
  }

  public SavedMessageResponse(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public SavedMessageResponse(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public SavedMessageResponse fetch() throws APIException{
    SavedMessageResponse newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static SavedMessageResponse fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<SavedMessageResponse> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static SavedMessageResponse fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<SavedMessageResponse> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<SavedMessageResponse> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<SavedMessageResponse>)(
      new APIRequest<SavedMessageResponse>(context, "", "/", "GET", SavedMessageResponse.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<SavedMessageResponse>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", SavedMessageResponse.getParser())
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
  public static SavedMessageResponse loadJSON(String json, APIContext context, String header) {
    SavedMessageResponse savedMessageResponse = getGson().fromJson(json, SavedMessageResponse.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(savedMessageResponse.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    savedMessageResponse.context = context;
    savedMessageResponse.rawValue = json;
    savedMessageResponse.header = header;
    return savedMessageResponse;
  }

  public static APINodeList<SavedMessageResponse> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<SavedMessageResponse> savedMessageResponses = new APINodeList<SavedMessageResponse>(request, json, header);
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
          savedMessageResponses.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return savedMessageResponses;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                savedMessageResponses.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            savedMessageResponses.setPaging(previous, next);
            if (context.hasAppSecret()) {
              savedMessageResponses.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              savedMessageResponses.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  savedMessageResponses.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              savedMessageResponses.add(loadJSON(obj.toString(), context, header));
            }
          }
          return savedMessageResponses;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              savedMessageResponses.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return savedMessageResponses;
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
              savedMessageResponses.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return savedMessageResponses;
          }

          // Sixth, check if it's pure JsonObject
          savedMessageResponses.clear();
          savedMessageResponses.add(loadJSON(json, context, header));
          return savedMessageResponses;
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

  public APIRequestGetMacros getMacros() {
    return new APIRequestGetMacros(this.getPrefixedId().toString(), context);
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


  public String getFieldCategory() {
    return mCategory;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldImage() {
    return mImage;
  }

  public Boolean getFieldIsEnabled() {
    return mIsEnabled;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public String getFieldTitle() {
    return mTitle;
  }



  public static class APIRequestGetMacros extends APIRequest<SavedMessageResponseMacro> {

    APINodeList<SavedMessageResponseMacro> lastResponse = null;
    @Override
    public APINodeList<SavedMessageResponseMacro> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "length",
      "macro",
      "offset",
    };

    @Override
    public APINodeList<SavedMessageResponseMacro> parseResponse(String response, String header) throws APIException {
      return SavedMessageResponseMacro.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<SavedMessageResponseMacro> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<SavedMessageResponseMacro> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<SavedMessageResponseMacro>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<SavedMessageResponseMacro>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<SavedMessageResponseMacro>>() {
           public APINodeList<SavedMessageResponseMacro> apply(ResponseWrapper result) {
             try {
               return APIRequestGetMacros.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetMacros(String nodeId, APIContext context) {
      super(context, nodeId, "/macros", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetMacros setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetMacros setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetMacros requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetMacros requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMacros requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetMacros requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetMacros requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetMacros requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetMacros requestLengthField () {
      return this.requestLengthField(true);
    }
    public APIRequestGetMacros requestLengthField (boolean value) {
      this.requestField("length", value);
      return this;
    }
    public APIRequestGetMacros requestMacroField () {
      return this.requestMacroField(true);
    }
    public APIRequestGetMacros requestMacroField (boolean value) {
      this.requestField("macro", value);
      return this;
    }
    public APIRequestGetMacros requestOffsetField () {
      return this.requestOffsetField(true);
    }
    public APIRequestGetMacros requestOffsetField (boolean value) {
      this.requestField("offset", value);
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

  public static class APIRequestGet extends APIRequest<SavedMessageResponse> {

    SavedMessageResponse lastResponse = null;
    @Override
    public SavedMessageResponse getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "category",
      "id",
      "image",
      "is_enabled",
      "message",
      "title",
    };

    @Override
    public SavedMessageResponse parseResponse(String response, String header) throws APIException {
      return SavedMessageResponse.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public SavedMessageResponse execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SavedMessageResponse execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<SavedMessageResponse> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SavedMessageResponse> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, SavedMessageResponse>() {
           public SavedMessageResponse apply(ResponseWrapper result) {
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

    public APIRequestGet requestCategoryField () {
      return this.requestCategoryField(true);
    }
    public APIRequestGet requestCategoryField (boolean value) {
      this.requestField("category", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImageField () {
      return this.requestImageField(true);
    }
    public APIRequestGet requestImageField (boolean value) {
      this.requestField("image", value);
      return this;
    }
    public APIRequestGet requestIsEnabledField () {
      return this.requestIsEnabledField(true);
    }
    public APIRequestGet requestIsEnabledField (boolean value) {
      this.requestField("is_enabled", value);
      return this;
    }
    public APIRequestGet requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGet requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<SavedMessageResponse> {

    SavedMessageResponse lastResponse = null;
    @Override
    public SavedMessageResponse getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "image",
      "message",
      "remove_image",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public SavedMessageResponse parseResponse(String response, String header) throws APIException {
      return SavedMessageResponse.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public SavedMessageResponse execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SavedMessageResponse execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<SavedMessageResponse> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SavedMessageResponse> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, SavedMessageResponse>() {
           public SavedMessageResponse apply(ResponseWrapper result) {
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


    public APIRequestUpdate setImage (String image) {
      this.setParam("image", image);
      return this;
    }

    public APIRequestUpdate setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestUpdate setRemoveImage (Boolean removeImage) {
      this.setParam("remove_image", removeImage);
      return this;
    }
    public APIRequestUpdate setRemoveImage (String removeImage) {
      this.setParam("remove_image", removeImage);
      return this;
    }

    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
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

  public static enum EnumCategory {
      @SerializedName("APPOINTMENT_REMINDER")
      VALUE_APPOINTMENT_REMINDER("APPOINTMENT_REMINDER"),
      @SerializedName("AWAY_MESSAGE")
      VALUE_AWAY_MESSAGE("AWAY_MESSAGE"),
      @SerializedName("FOLLOW_UP")
      VALUE_FOLLOW_UP("FOLLOW_UP"),
      @SerializedName("INSTANT_REPLY")
      VALUE_INSTANT_REPLY("INSTANT_REPLY"),
      @SerializedName("JOB_APPLICATION")
      VALUE_JOB_APPLICATION("JOB_APPLICATION"),
      @SerializedName("MESSENGER_CODE")
      VALUE_MESSENGER_CODE("MESSENGER_CODE"),
      @SerializedName("REFERRAL")
      VALUE_REFERRAL("REFERRAL"),
      @SerializedName("SMART_REPLY_CONTACT")
      VALUE_SMART_REPLY_CONTACT("SMART_REPLY_CONTACT"),
      @SerializedName("SMART_REPLY_HOURS")
      VALUE_SMART_REPLY_HOURS("SMART_REPLY_HOURS"),
      @SerializedName("SMART_REPLY_LOCATION")
      VALUE_SMART_REPLY_LOCATION("SMART_REPLY_LOCATION"),
      @SerializedName("SMART_REPLY_NEGATIVE_FEEDBACK")
      VALUE_SMART_REPLY_NEGATIVE_FEEDBACK("SMART_REPLY_NEGATIVE_FEEDBACK"),
      @SerializedName("SMART_REPLY_POSITIVE_FEEDBACK")
      VALUE_SMART_REPLY_POSITIVE_FEEDBACK("SMART_REPLY_POSITIVE_FEEDBACK"),
      @SerializedName("STANDARD")
      VALUE_STANDARD("STANDARD"),
      @SerializedName("WELCOME_MESSAGE")
      VALUE_WELCOME_MESSAGE("WELCOME_MESSAGE"),
      ;

      private String value;

      private EnumCategory(String value) {
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

  public SavedMessageResponse copyFrom(SavedMessageResponse instance) {
    this.mCategory = instance.mCategory;
    this.mId = instance.mId;
    this.mImage = instance.mImage;
    this.mIsEnabled = instance.mIsEnabled;
    this.mMessage = instance.mMessage;
    this.mTitle = instance.mTitle;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<SavedMessageResponse> getParser() {
    return new APIRequest.ResponseParser<SavedMessageResponse>() {
      public APINodeList<SavedMessageResponse> parseResponse(String response, APIContext context, APIRequest<SavedMessageResponse> request, String header) throws MalformedResponseException {
        return SavedMessageResponse.parseResponse(response, context, request, header);
      }
    };
  }
}
