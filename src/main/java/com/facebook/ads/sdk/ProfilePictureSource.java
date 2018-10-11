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
public class ProfilePictureSource extends APINode {
  @SerializedName("bottom")
  private Long mBottom = null;
  @SerializedName("cache_key")
  private String mCacheKey = null;
  @SerializedName("height")
  private Long mHeight = null;
  @SerializedName("is_silhouette")
  private Boolean mIsSilhouette = null;
  @SerializedName("left")
  private Long mLeft = null;
  @SerializedName("right")
  private Long mRight = null;
  @SerializedName("top")
  private Long mTop = null;
  @SerializedName("uri")
  private String mUri = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("width")
  private Long mWidth = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ProfilePictureSource() {
  }

  public ProfilePictureSource(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ProfilePictureSource(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ProfilePictureSource fetch() throws APIException{
    ProfilePictureSource newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ProfilePictureSource fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ProfilePictureSource> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ProfilePictureSource fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ProfilePictureSource> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ProfilePictureSource> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ProfilePictureSource>)(
      new APIRequest<ProfilePictureSource>(context, "", "/", "GET", ProfilePictureSource.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ProfilePictureSource>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ProfilePictureSource.getParser())
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
  public static ProfilePictureSource loadJSON(String json, APIContext context) {
    ProfilePictureSource profilePictureSource = getGson().fromJson(json, ProfilePictureSource.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(profilePictureSource.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    profilePictureSource.context = context;
    profilePictureSource.rawValue = json;
    return profilePictureSource;
  }

  public static APINodeList<ProfilePictureSource> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ProfilePictureSource> profilePictureSources = new APINodeList<ProfilePictureSource>(request, json);
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
          profilePictureSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return profilePictureSources;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                profilePictureSources.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            profilePictureSources.setPaging(previous, next);
            if (context.hasAppSecret()) {
              profilePictureSources.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              profilePictureSources.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  profilePictureSources.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              profilePictureSources.add(loadJSON(obj.toString(), context));
            }
          }
          return profilePictureSources;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              profilePictureSources.add(loadJSON(entry.getValue().toString(), context));
          }
          return profilePictureSources;
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
              profilePictureSources.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return profilePictureSources;
          }

          // Sixth, check if it's pure JsonObject
          profilePictureSources.clear();
          profilePictureSources.add(loadJSON(json, context));
          return profilePictureSources;
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


  public Long getFieldBottom() {
    return mBottom;
  }

  public String getFieldCacheKey() {
    return mCacheKey;
  }

  public Long getFieldHeight() {
    return mHeight;
  }

  public Boolean getFieldIsSilhouette() {
    return mIsSilhouette;
  }

  public Long getFieldLeft() {
    return mLeft;
  }

  public Long getFieldRight() {
    return mRight;
  }

  public Long getFieldTop() {
    return mTop;
  }

  public String getFieldUri() {
    return mUri;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public Long getFieldWidth() {
    return mWidth;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ProfilePictureSource> {

    ProfilePictureSource lastResponse = null;
    @Override
    public ProfilePictureSource getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "bottom",
      "cache_key",
      "height",
      "is_silhouette",
      "left",
      "right",
      "top",
      "uri",
      "url",
      "width",
      "id",
    };

    @Override
    public ProfilePictureSource parseResponse(String response) throws APIException {
      return ProfilePictureSource.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ProfilePictureSource execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ProfilePictureSource execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ProfilePictureSource> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ProfilePictureSource> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ProfilePictureSource>() {
           public ProfilePictureSource apply(String result) {
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

    public APIRequestGet requestBottomField () {
      return this.requestBottomField(true);
    }
    public APIRequestGet requestBottomField (boolean value) {
      this.requestField("bottom", value);
      return this;
    }
    public APIRequestGet requestCacheKeyField () {
      return this.requestCacheKeyField(true);
    }
    public APIRequestGet requestCacheKeyField (boolean value) {
      this.requestField("cache_key", value);
      return this;
    }
    public APIRequestGet requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGet requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGet requestIsSilhouetteField () {
      return this.requestIsSilhouetteField(true);
    }
    public APIRequestGet requestIsSilhouetteField (boolean value) {
      this.requestField("is_silhouette", value);
      return this;
    }
    public APIRequestGet requestLeftField () {
      return this.requestLeftField(true);
    }
    public APIRequestGet requestLeftField (boolean value) {
      this.requestField("left", value);
      return this;
    }
    public APIRequestGet requestRightField () {
      return this.requestRightField(true);
    }
    public APIRequestGet requestRightField (boolean value) {
      this.requestField("right", value);
      return this;
    }
    public APIRequestGet requestTopField () {
      return this.requestTopField(true);
    }
    public APIRequestGet requestTopField (boolean value) {
      this.requestField("top", value);
      return this;
    }
    public APIRequestGet requestUriField () {
      return this.requestUriField(true);
    }
    public APIRequestGet requestUriField (boolean value) {
      this.requestField("uri", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGet requestWidthField (boolean value) {
      this.requestField("width", value);
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
      @SerializedName("thumbnail")
      VALUE_THUMBNAIL("thumbnail"),
      @SerializedName("small")
      VALUE_SMALL("small"),
      @SerializedName("album")
      VALUE_ALBUM("album"),
      NULL(null);

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

  public ProfilePictureSource copyFrom(ProfilePictureSource instance) {
    this.mBottom = instance.mBottom;
    this.mCacheKey = instance.mCacheKey;
    this.mHeight = instance.mHeight;
    this.mIsSilhouette = instance.mIsSilhouette;
    this.mLeft = instance.mLeft;
    this.mRight = instance.mRight;
    this.mTop = instance.mTop;
    this.mUri = instance.mUri;
    this.mUrl = instance.mUrl;
    this.mWidth = instance.mWidth;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ProfilePictureSource> getParser() {
    return new APIRequest.ResponseParser<ProfilePictureSource>() {
      public APINodeList<ProfilePictureSource> parseResponse(String response, APIContext context, APIRequest<ProfilePictureSource> request) throws MalformedResponseException {
        return ProfilePictureSource.parseResponse(response, context, request);
      }
    };
  }
}
