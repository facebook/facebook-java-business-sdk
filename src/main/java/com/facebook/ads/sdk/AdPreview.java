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
public class AdPreview extends APINode {
  @SerializedName("body")
  private String mBody = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdPreview() {
  }

  public AdPreview(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdPreview(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdPreview fetch() throws APIException{
    AdPreview newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdPreview fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdPreview> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdPreview fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdPreview> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdPreview> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdPreview>)(
      new APIRequest<AdPreview>(context, "", "/", "GET", AdPreview.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdPreview>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdPreview.getParser())
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
  public static AdPreview loadJSON(String json, APIContext context) {
    AdPreview adPreview = getGson().fromJson(json, AdPreview.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adPreview.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adPreview.context = context;
    adPreview.rawValue = json;
    return adPreview;
  }

  public static APINodeList<AdPreview> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdPreview> adPreviews = new APINodeList<AdPreview>(request, json);
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
          adPreviews.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adPreviews;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adPreviews.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adPreviews.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adPreviews.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adPreviews.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adPreviews.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adPreviews.add(loadJSON(obj.toString(), context));
            }
          }
          return adPreviews;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adPreviews.add(loadJSON(entry.getValue().toString(), context));
          }
          return adPreviews;
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
              adPreviews.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adPreviews;
          }

          // Sixth, check if it's pure JsonObject
          adPreviews.clear();
          adPreviews.add(loadJSON(json, context));
          return adPreviews;
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


  public String getFieldBody() {
    return mBody;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdPreview> {

    AdPreview lastResponse = null;
    @Override
    public AdPreview getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "body",
      "id",
    };

    @Override
    public AdPreview parseResponse(String response) throws APIException {
      return AdPreview.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdPreview execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdPreview execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdPreview> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdPreview> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdPreview>() {
           public AdPreview apply(String result) {
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

    public APIRequestGet requestBodyField () {
      return this.requestBodyField(true);
    }
    public APIRequestGet requestBodyField (boolean value) {
      this.requestField("body", value);
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

  public static enum EnumAdFormat {
      @SerializedName("RIGHT_COLUMN_STANDARD")
      VALUE_RIGHT_COLUMN_STANDARD("RIGHT_COLUMN_STANDARD"),
      @SerializedName("DESKTOP_FEED_STANDARD")
      VALUE_DESKTOP_FEED_STANDARD("DESKTOP_FEED_STANDARD"),
      @SerializedName("MOBILE_FEED_STANDARD")
      VALUE_MOBILE_FEED_STANDARD("MOBILE_FEED_STANDARD"),
      @SerializedName("MOBILE_FEED_BASIC")
      VALUE_MOBILE_FEED_BASIC("MOBILE_FEED_BASIC"),
      @SerializedName("MOBILE_INTERSTITIAL")
      VALUE_MOBILE_INTERSTITIAL("MOBILE_INTERSTITIAL"),
      @SerializedName("MOBILE_BANNER")
      VALUE_MOBILE_BANNER("MOBILE_BANNER"),
      @SerializedName("MOBILE_MEDIUM_RECTANGLE")
      VALUE_MOBILE_MEDIUM_RECTANGLE("MOBILE_MEDIUM_RECTANGLE"),
      @SerializedName("MOBILE_FULLWIDTH")
      VALUE_MOBILE_FULLWIDTH("MOBILE_FULLWIDTH"),
      @SerializedName("MOBILE_NATIVE")
      VALUE_MOBILE_NATIVE("MOBILE_NATIVE"),
      @SerializedName("INSTAGRAM_STANDARD")
      VALUE_INSTAGRAM_STANDARD("INSTAGRAM_STANDARD"),
      @SerializedName("INSTAGRAM_STORY")
      VALUE_INSTAGRAM_STORY("INSTAGRAM_STORY"),
      @SerializedName("AUDIENCE_NETWORK_INSTREAM_VIDEO")
      VALUE_AUDIENCE_NETWORK_INSTREAM_VIDEO("AUDIENCE_NETWORK_INSTREAM_VIDEO"),
      @SerializedName("AUDIENCE_NETWORK_OUTSTREAM_VIDEO")
      VALUE_AUDIENCE_NETWORK_OUTSTREAM_VIDEO("AUDIENCE_NETWORK_OUTSTREAM_VIDEO"),
      @SerializedName("AUDIENCE_NETWORK_INSTREAM_VIDEO_MOBILE")
      VALUE_AUDIENCE_NETWORK_INSTREAM_VIDEO_MOBILE("AUDIENCE_NETWORK_INSTREAM_VIDEO_MOBILE"),
      @SerializedName("AUDIENCE_NETWORK_REWARDED_VIDEO")
      VALUE_AUDIENCE_NETWORK_REWARDED_VIDEO("AUDIENCE_NETWORK_REWARDED_VIDEO"),
      @SerializedName("INSTANT_ARTICLE_STANDARD")
      VALUE_INSTANT_ARTICLE_STANDARD("INSTANT_ARTICLE_STANDARD"),
      @SerializedName("INSTREAM_VIDEO_DESKTOP")
      VALUE_INSTREAM_VIDEO_DESKTOP("INSTREAM_VIDEO_DESKTOP"),
      @SerializedName("INSTREAM_VIDEO_MOBILE")
      VALUE_INSTREAM_VIDEO_MOBILE("INSTREAM_VIDEO_MOBILE"),
      @SerializedName("MESSENGER_MOBILE_INBOX_MEDIA")
      VALUE_MESSENGER_MOBILE_INBOX_MEDIA("MESSENGER_MOBILE_INBOX_MEDIA"),
      @SerializedName("SUGGESTED_VIDEO_DESKTOP")
      VALUE_SUGGESTED_VIDEO_DESKTOP("SUGGESTED_VIDEO_DESKTOP"),
      @SerializedName("SUGGESTED_VIDEO_MOBILE")
      VALUE_SUGGESTED_VIDEO_MOBILE("SUGGESTED_VIDEO_MOBILE"),
      @SerializedName("MARKETPLACE_MOBILE")
      VALUE_MARKETPLACE_MOBILE("MARKETPLACE_MOBILE"),
      @SerializedName("FACEBOOK_STORY_MOBILE")
      VALUE_FACEBOOK_STORY_MOBILE("FACEBOOK_STORY_MOBILE"),
      @SerializedName("WATCH_FEED_MOBILE")
      VALUE_WATCH_FEED_MOBILE("WATCH_FEED_MOBILE"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumAdFormat(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumRenderType {
      @SerializedName("FALLBACK")
      VALUE_FALLBACK("FALLBACK"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumRenderType(String value) {
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

  public AdPreview copyFrom(AdPreview instance) {
    this.mBody = instance.mBody;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdPreview> getParser() {
    return new APIRequest.ResponseParser<AdPreview>() {
      public APINodeList<AdPreview> parseResponse(String response, APIContext context, APIRequest<AdPreview> request) throws MalformedResponseException {
        return AdPreview.parseResponse(response, context, request);
      }
    };
  }
}
