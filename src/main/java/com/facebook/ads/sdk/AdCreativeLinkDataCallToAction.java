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
public class AdCreativeLinkDataCallToAction extends APINode {
  @SerializedName("type")
  private EnumType mType = null;
  @SerializedName("value")
  private AdCreativeLinkDataCallToActionValue mValue = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public AdCreativeLinkDataCallToAction() {
  }

  public AdCreativeLinkDataCallToAction(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreativeLinkDataCallToAction(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCreativeLinkDataCallToAction fetch() throws APIException{
    AdCreativeLinkDataCallToAction newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCreativeLinkDataCallToAction fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreativeLinkDataCallToAction> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreativeLinkDataCallToAction fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreativeLinkDataCallToAction> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreativeLinkDataCallToAction> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreativeLinkDataCallToAction>)(
      new APIRequest<AdCreativeLinkDataCallToAction>(context, "", "/", "GET", AdCreativeLinkDataCallToAction.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreativeLinkDataCallToAction>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreativeLinkDataCallToAction.getParser())
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
  public static AdCreativeLinkDataCallToAction loadJSON(String json, APIContext context) {
    AdCreativeLinkDataCallToAction adCreativeLinkDataCallToAction = getGson().fromJson(json, AdCreativeLinkDataCallToAction.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataCallToAction.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeLinkDataCallToAction.context = context;
    adCreativeLinkDataCallToAction.rawValue = json;
    return adCreativeLinkDataCallToAction;
  }

  public static APINodeList<AdCreativeLinkDataCallToAction> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataCallToAction> adCreativeLinkDataCallToActions = new APINodeList<AdCreativeLinkDataCallToAction>(request, json);
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
          adCreativeLinkDataCallToActions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeLinkDataCallToActions;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDataCallToActions.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDataCallToActions.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDataCallToActions.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataCallToActions.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativeLinkDataCallToActions.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataCallToActions.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativeLinkDataCallToActions;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataCallToActions.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativeLinkDataCallToActions;
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
              adCreativeLinkDataCallToActions.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDataCallToActions;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDataCallToActions.clear();
          adCreativeLinkDataCallToActions.add(loadJSON(json, context));
          return adCreativeLinkDataCallToActions;
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


  public EnumType getFieldType() {
    return mType;
  }

  public AdCreativeLinkDataCallToAction setFieldType(EnumType value) {
    this.mType = value;
    return this;
  }
    public AdCreativeLinkDataCallToAction setFieldValue(AdCreativeLinkDataCallToActionValue value) {
        this.mValue = value;
        return this;
    }

    public AdCreativeLinkDataCallToAction setFieldValue(String value) {
        Type type = new TypeToken<AdCreativeLinkDataCallToActionValue>(){}.getType();
        this.mValue = AdCreativeLinkDataCallToActionValue.getGson().fromJson(value, type);
        return this;
    }


    public AdCreativeLinkDataCallToActionValue getFieldValue() {
    if (mValue != null) {
      mValue.context = getContext();
    }
    return mValue;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCreativeLinkDataCallToAction> {

    AdCreativeLinkDataCallToAction lastResponse = null;
    @Override
    public AdCreativeLinkDataCallToAction getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "type",
      "value",
      "id",
    };

    @Override
    public AdCreativeLinkDataCallToAction parseResponse(String response) throws APIException {
      return AdCreativeLinkDataCallToAction.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreativeLinkDataCallToAction execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreativeLinkDataCallToAction execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreativeLinkDataCallToAction> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreativeLinkDataCallToAction> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreativeLinkDataCallToAction>() {
           public AdCreativeLinkDataCallToAction apply(String result) {
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

    public APIRequestGet requestTypeField () {
      return this.requestTypeField(true);
    }
    public APIRequestGet requestTypeField (boolean value) {
      this.requestField("type", value);
      return this;
    }
    public APIRequestGet requestValueField () {
      return this.requestValueField(true);
    }
    public APIRequestGet requestValueField (boolean value) {
      this.requestField("value", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }

  public static enum EnumType {
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
      @SerializedName("OPEN_MOVIES")
      VALUE_OPEN_MOVIES("OPEN_MOVIES"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumType(String value) {
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

  public AdCreativeLinkDataCallToAction copyFrom(AdCreativeLinkDataCallToAction instance) {
    this.mType = instance.mType;
    this.mValue = instance.mValue;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataCallToAction> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataCallToAction>() {
      public APINodeList<AdCreativeLinkDataCallToAction> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataCallToAction> request) throws MalformedResponseException {
        return AdCreativeLinkDataCallToAction.parseResponse(response, context, request);
      }
    };
  }
}
