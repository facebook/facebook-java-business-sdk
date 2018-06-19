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
public class VideoList extends APINode {
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_modified")
  private String mLastModified = null;
  @SerializedName("owner")
  private Object mOwner = null;
  @SerializedName("season_number")
  private Long mSeasonNumber = null;
  @SerializedName("thumbnail")
  private String mThumbnail = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("videos_count")
  private Long mVideosCount = null;
  protected static Gson gson = null;

  VideoList() {
  }

  public VideoList(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public VideoList(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public VideoList fetch() throws APIException{
    VideoList newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static VideoList fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<VideoList> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static VideoList fetchById(String id, APIContext context) throws APIException {
    VideoList videoList =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return videoList;
  }

  public static ListenableFuture<VideoList> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<VideoList> videoList =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return videoList;
  }

  public static APINodeList<VideoList> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<VideoList>)(
      new APIRequest<VideoList>(context, "", "/", "GET", VideoList.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<VideoList>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<VideoList>> videoList =
      new APIRequest(context, "", "/", "GET", VideoList.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return videoList;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static VideoList loadJSON(String json, APIContext context) {
    VideoList videoList = getGson().fromJson(json, VideoList.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoList.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    videoList.context = context;
    videoList.rawValue = json;
    return videoList;
  }

  public static APINodeList<VideoList> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<VideoList> videoLists = new APINodeList<VideoList>(request, json);
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
          videoLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return videoLists;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoLists.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoLists.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoLists.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  videoLists.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoLists.add(loadJSON(obj.toString(), context));
            }
          }
          return videoLists;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoLists.add(loadJSON(entry.getValue().toString(), context));
          }
          return videoLists;
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
              videoLists.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoLists;
          }

          // Sixth, check if it's pure JsonObject
          videoLists.clear();
          videoLists.add(loadJSON(json, context));
          return videoLists;
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

  public APIRequestDeleteVideos deleteVideos() {
    return new APIRequestDeleteVideos(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateVideo createVideo() {
    return new APIRequestCreateVideo(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldLastModified() {
    return mLastModified;
  }

  public Object getFieldOwner() {
    return mOwner;
  }

  public Long getFieldSeasonNumber() {
    return mSeasonNumber;
  }

  public String getFieldThumbnail() {
    return mThumbnail;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public Long getFieldVideosCount() {
    return mVideosCount;
  }



  public static class APIRequestDeleteVideos extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "video_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINodeList<APINode> parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<APINode> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<APINode> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINodeList<APINode>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<APINode>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINodeList<APINode>>() {
           public APINodeList<APINode> apply(String result) {
             try {
               return APIRequestDeleteVideos.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteVideos(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteVideos setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteVideos setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteVideos setVideoIds (List<String> videoIds) {
      this.setParam("video_ids", videoIds);
      return this;
    }
    public APIRequestDeleteVideos setVideoIds (String videoIds) {
      this.setParam("video_ids", videoIds);
      return this;
    }

    public APIRequestDeleteVideos requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteVideos requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteVideos requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteVideos requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteVideos requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteVideos requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateVideo extends APIRequest<VideoList> {

    VideoList lastResponse = null;
    @Override
    public VideoList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "video_ids",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public VideoList parseResponse(String response) throws APIException {
      return VideoList.parseResponse(response, getContext(), this).head();
    }

    @Override
    public VideoList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoList execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<VideoList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, VideoList>() {
           public VideoList apply(String result) {
             try {
               return APIRequestCreateVideo.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateVideo(String nodeId, APIContext context) {
      super(context, nodeId, "/videos", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateVideo setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateVideo setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateVideo setVideoIds (List<String> videoIds) {
      this.setParam("video_ids", videoIds);
      return this;
    }
    public APIRequestCreateVideo setVideoIds (String videoIds) {
      this.setParam("video_ids", videoIds);
      return this;
    }

    public APIRequestCreateVideo requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateVideo requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateVideo requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateVideo requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<VideoList> {

    VideoList lastResponse = null;
    @Override
    public VideoList getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "creation_time",
      "description",
      "id",
      "last_modified",
      "owner",
      "season_number",
      "thumbnail",
      "title",
      "videos_count",
    };

    @Override
    public VideoList parseResponse(String response) throws APIException {
      return VideoList.parseResponse(response, getContext(), this).head();
    }

    @Override
    public VideoList execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoList execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<VideoList> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoList> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, VideoList>() {
           public VideoList apply(String result) {
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

    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLastModifiedField () {
      return this.requestLastModifiedField(true);
    }
    public APIRequestGet requestLastModifiedField (boolean value) {
      this.requestField("last_modified", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestSeasonNumberField () {
      return this.requestSeasonNumberField(true);
    }
    public APIRequestGet requestSeasonNumberField (boolean value) {
      this.requestField("season_number", value);
      return this;
    }
    public APIRequestGet requestThumbnailField () {
      return this.requestThumbnailField(true);
    }
    public APIRequestGet requestThumbnailField (boolean value) {
      this.requestField("thumbnail", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestVideosCountField () {
      return this.requestVideosCountField(true);
    }
    public APIRequestGet requestVideosCountField (boolean value) {
      this.requestField("videos_count", value);
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

  public VideoList copyFrom(VideoList instance) {
    this.mCreationTime = instance.mCreationTime;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mLastModified = instance.mLastModified;
    this.mOwner = instance.mOwner;
    this.mSeasonNumber = instance.mSeasonNumber;
    this.mThumbnail = instance.mThumbnail;
    this.mTitle = instance.mTitle;
    this.mVideosCount = instance.mVideosCount;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoList> getParser() {
    return new APIRequest.ResponseParser<VideoList>() {
      public APINodeList<VideoList> parseResponse(String response, APIContext context, APIRequest<VideoList> request) throws MalformedResponseException {
        return VideoList.parseResponse(response, context, request);
      }
    };
  }
}
