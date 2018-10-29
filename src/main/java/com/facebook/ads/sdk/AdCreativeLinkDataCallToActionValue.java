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
public class AdCreativeLinkDataCallToActionValue extends APINode {
  @SerializedName("app_destination")
  private String mAppDestination = null;
  @SerializedName("app_link")
  private String mAppLink = null;
  @SerializedName("application")
  private String mApplication = null;
  @SerializedName("event_id")
  private String mEventId = null;
  @SerializedName("lead_gen_form_id")
  private String mLeadGenFormId = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("link_caption")
  private String mLinkCaption = null;
  @SerializedName("link_format")
  private String mLinkFormat = null;
  @SerializedName("page")
  private String mPage = null;
  @SerializedName("product_link")
  private String mProductLink = null;
  @SerializedName("whatsapp_number")
  private String mWhatsappNumber = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public AdCreativeLinkDataCallToActionValue() {
  }

  public AdCreativeLinkDataCallToActionValue(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreativeLinkDataCallToActionValue(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCreativeLinkDataCallToActionValue fetch() throws APIException{
    AdCreativeLinkDataCallToActionValue newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCreativeLinkDataCallToActionValue fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreativeLinkDataCallToActionValue> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreativeLinkDataCallToActionValue fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreativeLinkDataCallToActionValue> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreativeLinkDataCallToActionValue> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreativeLinkDataCallToActionValue>)(
      new APIRequest<AdCreativeLinkDataCallToActionValue>(context, "", "/", "GET", AdCreativeLinkDataCallToActionValue.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreativeLinkDataCallToActionValue>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreativeLinkDataCallToActionValue.getParser())
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
  public static AdCreativeLinkDataCallToActionValue loadJSON(String json, APIContext context) {
    AdCreativeLinkDataCallToActionValue adCreativeLinkDataCallToActionValue = getGson().fromJson(json, AdCreativeLinkDataCallToActionValue.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataCallToActionValue.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeLinkDataCallToActionValue.context = context;
    adCreativeLinkDataCallToActionValue.rawValue = json;
    return adCreativeLinkDataCallToActionValue;
  }

  public static APINodeList<AdCreativeLinkDataCallToActionValue> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataCallToActionValue> adCreativeLinkDataCallToActionValues = new APINodeList<AdCreativeLinkDataCallToActionValue>(request, json);
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
          adCreativeLinkDataCallToActionValues.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeLinkDataCallToActionValues;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDataCallToActionValues.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDataCallToActionValues.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDataCallToActionValues.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataCallToActionValues.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativeLinkDataCallToActionValues.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataCallToActionValues.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativeLinkDataCallToActionValues;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataCallToActionValues.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativeLinkDataCallToActionValues;
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
              adCreativeLinkDataCallToActionValues.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDataCallToActionValues;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDataCallToActionValues.clear();
          adCreativeLinkDataCallToActionValues.add(loadJSON(json, context));
          return adCreativeLinkDataCallToActionValues;
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


  public String getFieldAppDestination() {
    return mAppDestination;
  }

  public String getFieldAppLink() {
    return mAppLink;
  }

  public String getFieldApplication() {
    return mApplication;
  }

  public String getFieldEventId() {
    return mEventId;
  }

  public String getFieldLeadGenFormId() {
    return mLeadGenFormId;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldLinkCaption() {
    return mLinkCaption;
  }

  public String getFieldLinkFormat() {
    return mLinkFormat;
  }

  public String getFieldPage() {
    return mPage;
  }

  public String getFieldProductLink() {
    return mProductLink;
  }

  public String getFieldWhatsappNumber() {
    return mWhatsappNumber;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCreativeLinkDataCallToActionValue> {

    AdCreativeLinkDataCallToActionValue lastResponse = null;
    @Override
    public AdCreativeLinkDataCallToActionValue getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "app_destination",
      "app_link",
      "application",
      "event_id",
      "lead_gen_form_id",
      "link",
      "link_caption",
      "link_format",
      "page",
      "product_link",
      "whatsapp_number",
      "id",
    };

    @Override
    public AdCreativeLinkDataCallToActionValue parseResponse(String response) throws APIException {
      return AdCreativeLinkDataCallToActionValue.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreativeLinkDataCallToActionValue execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreativeLinkDataCallToActionValue execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreativeLinkDataCallToActionValue> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreativeLinkDataCallToActionValue> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreativeLinkDataCallToActionValue>() {
           public AdCreativeLinkDataCallToActionValue apply(String result) {
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

    public APIRequestGet requestAppDestinationField () {
      return this.requestAppDestinationField(true);
    }
    public APIRequestGet requestAppDestinationField (boolean value) {
      this.requestField("app_destination", value);
      return this;
    }
    public APIRequestGet requestAppLinkField () {
      return this.requestAppLinkField(true);
    }
    public APIRequestGet requestAppLinkField (boolean value) {
      this.requestField("app_link", value);
      return this;
    }
    public APIRequestGet requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGet requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGet requestEventIdField () {
      return this.requestEventIdField(true);
    }
    public APIRequestGet requestEventIdField (boolean value) {
      this.requestField("event_id", value);
      return this;
    }
    public APIRequestGet requestLeadGenFormIdField () {
      return this.requestLeadGenFormIdField(true);
    }
    public APIRequestGet requestLeadGenFormIdField (boolean value) {
      this.requestField("lead_gen_form_id", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestLinkCaptionField () {
      return this.requestLinkCaptionField(true);
    }
    public APIRequestGet requestLinkCaptionField (boolean value) {
      this.requestField("link_caption", value);
      return this;
    }
    public APIRequestGet requestLinkFormatField () {
      return this.requestLinkFormatField(true);
    }
    public APIRequestGet requestLinkFormatField (boolean value) {
      this.requestField("link_format", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestProductLinkField () {
      return this.requestProductLinkField(true);
    }
    public APIRequestGet requestProductLinkField (boolean value) {
      this.requestField("product_link", value);
      return this;
    }
    public APIRequestGet requestWhatsappNumberField () {
      return this.requestWhatsappNumberField(true);
    }
    public APIRequestGet requestWhatsappNumberField (boolean value) {
      this.requestField("whatsapp_number", value);
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

  public AdCreativeLinkDataCallToActionValue copyFrom(AdCreativeLinkDataCallToActionValue instance) {
    this.mAppDestination = instance.mAppDestination;
    this.mAppLink = instance.mAppLink;
    this.mApplication = instance.mApplication;
    this.mEventId = instance.mEventId;
    this.mLeadGenFormId = instance.mLeadGenFormId;
    this.mLink = instance.mLink;
    this.mLinkCaption = instance.mLinkCaption;
    this.mLinkFormat = instance.mLinkFormat;
    this.mPage = instance.mPage;
    this.mProductLink = instance.mProductLink;
    this.mWhatsappNumber = instance.mWhatsappNumber;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataCallToActionValue> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataCallToActionValue>() {
      public APINodeList<AdCreativeLinkDataCallToActionValue> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataCallToActionValue> request) throws MalformedResponseException {
        return AdCreativeLinkDataCallToActionValue.parseResponse(response, context, request);
      }
    };
  }
}
