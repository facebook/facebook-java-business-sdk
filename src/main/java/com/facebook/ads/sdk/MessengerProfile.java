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
public class MessengerProfile extends APINode {
  @SerializedName("account_linking_url")
  private String mAccountLinkingUrl = null;
  @SerializedName("get_started")
  private Object mGetStarted = null;
  @SerializedName("greeting")
  private List<Object> mGreeting = null;
  @SerializedName("home_url")
  private Object mHomeUrl = null;
  @SerializedName("payment_settings")
  private Object mPaymentSettings = null;
  @SerializedName("persistent_menu")
  private List<Object> mPersistentMenu = null;
  @SerializedName("target_audience")
  private Object mTargetAudience = null;
  @SerializedName("whitelisted_domains")
  private List<String> mWhitelistedDomains = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  MessengerProfile() {
  }

  public MessengerProfile(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public MessengerProfile(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public MessengerProfile fetch() throws APIException{
    MessengerProfile newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static MessengerProfile fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<MessengerProfile> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static MessengerProfile fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<MessengerProfile> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<MessengerProfile> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<MessengerProfile>)(
      new APIRequest<MessengerProfile>(context, "", "/", "GET", MessengerProfile.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<MessengerProfile>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", MessengerProfile.getParser())
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
  public static MessengerProfile loadJSON(String json, APIContext context) {
    MessengerProfile messengerProfile = getGson().fromJson(json, MessengerProfile.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(messengerProfile.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    messengerProfile.context = context;
    messengerProfile.rawValue = json;
    return messengerProfile;
  }

  public static APINodeList<MessengerProfile> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<MessengerProfile> messengerProfiles = new APINodeList<MessengerProfile>(request, json);
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
          messengerProfiles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return messengerProfiles;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                messengerProfiles.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            messengerProfiles.setPaging(previous, next);
            if (context.hasAppSecret()) {
              messengerProfiles.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              messengerProfiles.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  messengerProfiles.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              messengerProfiles.add(loadJSON(obj.toString(), context));
            }
          }
          return messengerProfiles;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              messengerProfiles.add(loadJSON(entry.getValue().toString(), context));
          }
          return messengerProfiles;
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
              messengerProfiles.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return messengerProfiles;
          }

          // Sixth, check if it's pure JsonObject
          messengerProfiles.clear();
          messengerProfiles.add(loadJSON(json, context));
          return messengerProfiles;
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


  public String getFieldAccountLinkingUrl() {
    return mAccountLinkingUrl;
  }

  public Object getFieldGetStarted() {
    return mGetStarted;
  }

  public List<Object> getFieldGreeting() {
    return mGreeting;
  }

  public Object getFieldHomeUrl() {
    return mHomeUrl;
  }

  public Object getFieldPaymentSettings() {
    return mPaymentSettings;
  }

  public List<Object> getFieldPersistentMenu() {
    return mPersistentMenu;
  }

  public Object getFieldTargetAudience() {
    return mTargetAudience;
  }

  public List<String> getFieldWhitelistedDomains() {
    return mWhitelistedDomains;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<MessengerProfile> {

    MessengerProfile lastResponse = null;
    @Override
    public MessengerProfile getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_linking_url",
      "get_started",
      "greeting",
      "home_url",
      "payment_settings",
      "persistent_menu",
      "target_audience",
      "whitelisted_domains",
      "id",
    };

    @Override
    public MessengerProfile parseResponse(String response) throws APIException {
      return MessengerProfile.parseResponse(response, getContext(), this).head();
    }

    @Override
    public MessengerProfile execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public MessengerProfile execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<MessengerProfile> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<MessengerProfile> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, MessengerProfile>() {
           public MessengerProfile apply(String result) {
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

    public APIRequestGet requestAccountLinkingUrlField () {
      return this.requestAccountLinkingUrlField(true);
    }
    public APIRequestGet requestAccountLinkingUrlField (boolean value) {
      this.requestField("account_linking_url", value);
      return this;
    }
    public APIRequestGet requestGetStartedField () {
      return this.requestGetStartedField(true);
    }
    public APIRequestGet requestGetStartedField (boolean value) {
      this.requestField("get_started", value);
      return this;
    }
    public APIRequestGet requestGreetingField () {
      return this.requestGreetingField(true);
    }
    public APIRequestGet requestGreetingField (boolean value) {
      this.requestField("greeting", value);
      return this;
    }
    public APIRequestGet requestHomeUrlField () {
      return this.requestHomeUrlField(true);
    }
    public APIRequestGet requestHomeUrlField (boolean value) {
      this.requestField("home_url", value);
      return this;
    }
    public APIRequestGet requestPaymentSettingsField () {
      return this.requestPaymentSettingsField(true);
    }
    public APIRequestGet requestPaymentSettingsField (boolean value) {
      this.requestField("payment_settings", value);
      return this;
    }
    public APIRequestGet requestPersistentMenuField () {
      return this.requestPersistentMenuField(true);
    }
    public APIRequestGet requestPersistentMenuField (boolean value) {
      this.requestField("persistent_menu", value);
      return this;
    }
    public APIRequestGet requestTargetAudienceField () {
      return this.requestTargetAudienceField(true);
    }
    public APIRequestGet requestTargetAudienceField (boolean value) {
      this.requestField("target_audience", value);
      return this;
    }
    public APIRequestGet requestWhitelistedDomainsField () {
      return this.requestWhitelistedDomainsField(true);
    }
    public APIRequestGet requestWhitelistedDomainsField (boolean value) {
      this.requestField("whitelisted_domains", value);
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

  public MessengerProfile copyFrom(MessengerProfile instance) {
    this.mAccountLinkingUrl = instance.mAccountLinkingUrl;
    this.mGetStarted = instance.mGetStarted;
    this.mGreeting = instance.mGreeting;
    this.mHomeUrl = instance.mHomeUrl;
    this.mPaymentSettings = instance.mPaymentSettings;
    this.mPersistentMenu = instance.mPersistentMenu;
    this.mTargetAudience = instance.mTargetAudience;
    this.mWhitelistedDomains = instance.mWhitelistedDomains;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<MessengerProfile> getParser() {
    return new APIRequest.ResponseParser<MessengerProfile>() {
      public APINodeList<MessengerProfile> parseResponse(String response, APIContext context, APIRequest<MessengerProfile> request) throws MalformedResponseException {
        return MessengerProfile.parseResponse(response, context, request);
      }
    };
  }
}
