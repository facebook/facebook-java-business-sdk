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
public class MessengerDestinationPageWelcomeMessage extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("page_welcome_message_body")
  private String mPageWelcomeMessageBody = null;
  @SerializedName("page_welcome_message_type")
  private String mPageWelcomeMessageType = null;
  @SerializedName("template_name")
  private String mTemplateName = null;
  @SerializedName("time_created")
  private String mTimeCreated = null;
  @SerializedName("time_last_used")
  private String mTimeLastUsed = null;
  protected static Gson gson = null;

  MessengerDestinationPageWelcomeMessage() {
  }

  public MessengerDestinationPageWelcomeMessage(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MessengerDestinationPageWelcomeMessage(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MessengerDestinationPageWelcomeMessage fetch() throws APIException{
    MessengerDestinationPageWelcomeMessage newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MessengerDestinationPageWelcomeMessage fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MessengerDestinationPageWelcomeMessage> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MessengerDestinationPageWelcomeMessage fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MessengerDestinationPageWelcomeMessage> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MessengerDestinationPageWelcomeMessage> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MessengerDestinationPageWelcomeMessage>)(
      new APIRequest<MessengerDestinationPageWelcomeMessage>(context, "", "/", "GET", MessengerDestinationPageWelcomeMessage.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MessengerDestinationPageWelcomeMessage>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MessengerDestinationPageWelcomeMessage.getParser())
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
  public static MessengerDestinationPageWelcomeMessage loadJSON(String json, APIContext context, String header) {
    MessengerDestinationPageWelcomeMessage messengerDestinationPageWelcomeMessage = getGson().fromJson(json, MessengerDestinationPageWelcomeMessage.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(messengerDestinationPageWelcomeMessage.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    messengerDestinationPageWelcomeMessage.context = context;
    messengerDestinationPageWelcomeMessage.rawValue = json;
    messengerDestinationPageWelcomeMessage.header = header;
    return messengerDestinationPageWelcomeMessage;
  }

  public static APINodeList<MessengerDestinationPageWelcomeMessage> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<MessengerDestinationPageWelcomeMessage> messengerDestinationPageWelcomeMessages = new APINodeList<MessengerDestinationPageWelcomeMessage>(request, json, header);
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
          messengerDestinationPageWelcomeMessages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return messengerDestinationPageWelcomeMessages;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                messengerDestinationPageWelcomeMessages.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            messengerDestinationPageWelcomeMessages.setPaging(previous, next);
            if (context.hasAppSecret()) {
              messengerDestinationPageWelcomeMessages.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              messengerDestinationPageWelcomeMessages.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  messengerDestinationPageWelcomeMessages.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              messengerDestinationPageWelcomeMessages.add(loadJSON(obj.toString(), context, header));
            }
          }
          return messengerDestinationPageWelcomeMessages;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              messengerDestinationPageWelcomeMessages.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return messengerDestinationPageWelcomeMessages;
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
              messengerDestinationPageWelcomeMessages.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return messengerDestinationPageWelcomeMessages;
          }

          // Sixth, check if it's pure JsonObject
          messengerDestinationPageWelcomeMessages.clear();
          messengerDestinationPageWelcomeMessages.add(loadJSON(json, context, header));
          return messengerDestinationPageWelcomeMessages;
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


  public String getFieldId() {
    return mId;
  }

  public String getFieldPageWelcomeMessageBody() {
    return mPageWelcomeMessageBody;
  }

  public String getFieldPageWelcomeMessageType() {
    return mPageWelcomeMessageType;
  }

  public String getFieldTemplateName() {
    return mTemplateName;
  }

  public String getFieldTimeCreated() {
    return mTimeCreated;
  }

  public String getFieldTimeLastUsed() {
    return mTimeLastUsed;
  }



  public static class APIRequestGet extends APIRequest<MessengerDestinationPageWelcomeMessage> {

    MessengerDestinationPageWelcomeMessage lastResponse = null;
    @Override
    public MessengerDestinationPageWelcomeMessage getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "page_welcome_message_body",
      "page_welcome_message_type",
      "template_name",
      "time_created",
      "time_last_used",
    };

    @Override
    public MessengerDestinationPageWelcomeMessage parseResponse(String response, String header) throws APIException {
      return MessengerDestinationPageWelcomeMessage.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public MessengerDestinationPageWelcomeMessage execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MessengerDestinationPageWelcomeMessage execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<MessengerDestinationPageWelcomeMessage> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MessengerDestinationPageWelcomeMessage> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, MessengerDestinationPageWelcomeMessage>() {
           public MessengerDestinationPageWelcomeMessage apply(ResponseWrapper result) {
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestPageWelcomeMessageBodyField () {
      return this.requestPageWelcomeMessageBodyField(true);
    }
    public APIRequestGet requestPageWelcomeMessageBodyField (boolean value) {
      this.requestField("page_welcome_message_body", value);
      return this;
    }
    public APIRequestGet requestPageWelcomeMessageTypeField () {
      return this.requestPageWelcomeMessageTypeField(true);
    }
    public APIRequestGet requestPageWelcomeMessageTypeField (boolean value) {
      this.requestField("page_welcome_message_type", value);
      return this;
    }
    public APIRequestGet requestTemplateNameField () {
      return this.requestTemplateNameField(true);
    }
    public APIRequestGet requestTemplateNameField (boolean value) {
      this.requestField("template_name", value);
      return this;
    }
    public APIRequestGet requestTimeCreatedField () {
      return this.requestTimeCreatedField(true);
    }
    public APIRequestGet requestTimeCreatedField (boolean value) {
      this.requestField("time_created", value);
      return this;
    }
    public APIRequestGet requestTimeLastUsedField () {
      return this.requestTimeLastUsedField(true);
    }
    public APIRequestGet requestTimeLastUsedField (boolean value) {
      this.requestField("time_last_used", value);
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

  public MessengerDestinationPageWelcomeMessage copyFrom(MessengerDestinationPageWelcomeMessage instance) {
    this.mId = instance.mId;
    this.mPageWelcomeMessageBody = instance.mPageWelcomeMessageBody;
    this.mPageWelcomeMessageType = instance.mPageWelcomeMessageType;
    this.mTemplateName = instance.mTemplateName;
    this.mTimeCreated = instance.mTimeCreated;
    this.mTimeLastUsed = instance.mTimeLastUsed;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MessengerDestinationPageWelcomeMessage> getParser() {
    return new APIRequest.ResponseParser<MessengerDestinationPageWelcomeMessage>() {
      public APINodeList<MessengerDestinationPageWelcomeMessage> parseResponse(String response, APIContext context, APIRequest<MessengerDestinationPageWelcomeMessage> request, String header) throws MalformedResponseException {
        return MessengerDestinationPageWelcomeMessage.parseResponse(response, context, request, header);
      }
    };
  }
}
