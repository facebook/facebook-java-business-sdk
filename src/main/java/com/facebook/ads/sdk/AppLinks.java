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
public class AppLinks extends APINode {
  @SerializedName("android")
  private List<AndroidAppLink> mAndroid = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("ios")
  private List<IosAppLink> mIos = null;
  @SerializedName("ipad")
  private List<IosAppLink> mIpad = null;
  @SerializedName("iphone")
  private List<IosAppLink> mIphone = null;
  @SerializedName("web")
  private WebAppLink mWeb = null;
  @SerializedName("windows")
  private List<WindowsAppLink> mWindows = null;
  @SerializedName("windows_phone")
  private List<WindowsPhoneAppLink> mWindowsPhone = null;
  @SerializedName("windows_universal")
  private List<WindowsAppLink> mWindowsUniversal = null;
  protected static Gson gson = null;

  AppLinks() {
  }

  public AppLinks(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AppLinks(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AppLinks fetch() throws APIException{
    AppLinks newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AppLinks fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AppLinks> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AppLinks fetchById(String id, APIContext context) throws APIException {
    AppLinks appLinks =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return appLinks;
  }

  public static ListenableFuture<AppLinks> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<AppLinks> appLinks =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return appLinks;
  }

  public static APINodeList<AppLinks> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AppLinks>)(
      new APIRequest<AppLinks>(context, "", "/", "GET", AppLinks.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AppLinks>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<AppLinks>> appLinks =
      new APIRequest(context, "", "/", "GET", AppLinks.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return appLinks;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AppLinks loadJSON(String json, APIContext context) {
    AppLinks appLinks = getGson().fromJson(json, AppLinks.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(appLinks.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    appLinks.context = context;
    appLinks.rawValue = json;
    return appLinks;
  }

  public static APINodeList<AppLinks> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AppLinks> appLinkss = new APINodeList<AppLinks>(request, json);
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
          appLinkss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return appLinkss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                appLinkss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            appLinkss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              appLinkss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              appLinkss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  appLinkss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              appLinkss.add(loadJSON(obj.toString(), context));
            }
          }
          return appLinkss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              appLinkss.add(loadJSON(entry.getValue().toString(), context));
          }
          return appLinkss;
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
              appLinkss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return appLinkss;
          }

          // Sixth, check if it's pure JsonObject
          appLinkss.clear();
          appLinkss.add(loadJSON(json, context));
          return appLinkss;
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


  public List<AndroidAppLink> getFieldAndroid() {
    return mAndroid;
  }

  public String getFieldId() {
    return mId;
  }

  public List<IosAppLink> getFieldIos() {
    return mIos;
  }

  public List<IosAppLink> getFieldIpad() {
    return mIpad;
  }

  public List<IosAppLink> getFieldIphone() {
    return mIphone;
  }

  public WebAppLink getFieldWeb() {
    return mWeb;
  }

  public List<WindowsAppLink> getFieldWindows() {
    return mWindows;
  }

  public List<WindowsPhoneAppLink> getFieldWindowsPhone() {
    return mWindowsPhone;
  }

  public List<WindowsAppLink> getFieldWindowsUniversal() {
    return mWindowsUniversal;
  }



  public static class APIRequestGet extends APIRequest<AppLinks> {

    AppLinks lastResponse = null;
    @Override
    public AppLinks getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "android",
      "id",
      "ios",
      "ipad",
      "iphone",
      "web",
      "windows",
      "windows_phone",
      "windows_universal",
    };

    @Override
    public AppLinks parseResponse(String response) throws APIException {
      return AppLinks.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AppLinks execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AppLinks execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AppLinks> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AppLinks> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AppLinks>() {
           public AppLinks apply(String result) {
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

    public APIRequestGet requestAndroidField () {
      return this.requestAndroidField(true);
    }
    public APIRequestGet requestAndroidField (boolean value) {
      this.requestField("android", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIosField () {
      return this.requestIosField(true);
    }
    public APIRequestGet requestIosField (boolean value) {
      this.requestField("ios", value);
      return this;
    }
    public APIRequestGet requestIpadField () {
      return this.requestIpadField(true);
    }
    public APIRequestGet requestIpadField (boolean value) {
      this.requestField("ipad", value);
      return this;
    }
    public APIRequestGet requestIphoneField () {
      return this.requestIphoneField(true);
    }
    public APIRequestGet requestIphoneField (boolean value) {
      this.requestField("iphone", value);
      return this;
    }
    public APIRequestGet requestWebField () {
      return this.requestWebField(true);
    }
    public APIRequestGet requestWebField (boolean value) {
      this.requestField("web", value);
      return this;
    }
    public APIRequestGet requestWindowsField () {
      return this.requestWindowsField(true);
    }
    public APIRequestGet requestWindowsField (boolean value) {
      this.requestField("windows", value);
      return this;
    }
    public APIRequestGet requestWindowsPhoneField () {
      return this.requestWindowsPhoneField(true);
    }
    public APIRequestGet requestWindowsPhoneField (boolean value) {
      this.requestField("windows_phone", value);
      return this;
    }
    public APIRequestGet requestWindowsUniversalField () {
      return this.requestWindowsUniversalField(true);
    }
    public APIRequestGet requestWindowsUniversalField (boolean value) {
      this.requestField("windows_universal", value);
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

  public AppLinks copyFrom(AppLinks instance) {
    this.mAndroid = instance.mAndroid;
    this.mId = instance.mId;
    this.mIos = instance.mIos;
    this.mIpad = instance.mIpad;
    this.mIphone = instance.mIphone;
    this.mWeb = instance.mWeb;
    this.mWindows = instance.mWindows;
    this.mWindowsPhone = instance.mWindowsPhone;
    this.mWindowsUniversal = instance.mWindowsUniversal;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AppLinks> getParser() {
    return new APIRequest.ResponseParser<AppLinks>() {
      public APINodeList<AppLinks> parseResponse(String response, APIContext context, APIRequest<AppLinks> request) throws MalformedResponseException {
        return AppLinks.parseResponse(response, context, request);
      }
    };
  }
}
