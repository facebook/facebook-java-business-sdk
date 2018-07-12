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
public class Photo extends APINode {
  @SerializedName("album")
  private Album mAlbum = null;
  @SerializedName("backdated_time")
  private String mBackdatedTime = null;
  @SerializedName("backdated_time_granularity")
  private String mBackdatedTimeGranularity = null;
  @SerializedName("can_backdate")
  private Boolean mCanBackdate = null;
  @SerializedName("can_delete")
  private Boolean mCanDelete = null;
  @SerializedName("can_tag")
  private Boolean mCanTag = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("event")
  private Event mEvent = null;
  @SerializedName("from")
  private Object mFrom = null;
  @SerializedName("height")
  private Long mHeight = null;
  @SerializedName("icon")
  private String mIcon = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("images")
  private List<Object> mImages = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("name_tags")
  private List<Object> mNameTags = null;
  @SerializedName("page_story_id")
  private String mPageStoryId = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("place")
  private Object mPlace = null;
  @SerializedName("position")
  private Long mPosition = null;
  @SerializedName("source")
  private String mSource = null;
  @SerializedName("target")
  private Profile mTarget = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("webp_images")
  private List<Object> mWebpImages = null;
  @SerializedName("width")
  private Long mWidth = null;
  protected static Gson gson = null;

  Photo() {
  }

  public Photo(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Photo(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public Photo fetch() throws APIException{
    Photo newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Photo fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Photo> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Photo fetchById(String id, APIContext context) throws APIException {
    Photo photo =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return photo;
  }

  public static ListenableFuture<Photo> fetchByIdAsync(String id, APIContext context) throws APIException {
    ListenableFuture<Photo> photo =
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
    return photo;
  }

  public static APINodeList<Photo> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Photo>)(
      new APIRequest<Photo>(context, "", "/", "GET", Photo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Photo>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    ListenableFuture<APINodeList<Photo>> photo =
      new APIRequest(context, "", "/", "GET", Photo.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
    return photo;
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static Photo loadJSON(String json, APIContext context) {
    Photo photo = getGson().fromJson(json, Photo.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(photo.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    photo.context = context;
    photo.rawValue = json;
    return photo;
  }

  public static APINodeList<Photo> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<Photo> photos = new APINodeList<Photo>(request, json);
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
          photos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return photos;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                photos.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            photos.setPaging(previous, next);
            if (context.hasAppSecret()) {
              photos.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              photos.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  photos.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              photos.add(loadJSON(obj.toString(), context));
            }
          }
          return photos;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              photos.add(loadJSON(entry.getValue().toString(), context));
          }
          return photos;
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
              photos.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return photos;
          }

          // Sixth, check if it's pure JsonObject
          photos.clear();
          photos.add(loadJSON(json, context));
          return photos;
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

  public APIRequestDeleteLikes deleteLikes() {
    return new APIRequestDeleteLikes(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateLike createLike() {
    return new APIRequestCreateLike(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateTag createTag() {
    return new APIRequestCreateTag(this.getPrefixedId().toString(), context);
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


  public Album getFieldAlbum() {
    if (mAlbum != null) {
      mAlbum.context = getContext();
    }
    return mAlbum;
  }

  public String getFieldBackdatedTime() {
    return mBackdatedTime;
  }

  public String getFieldBackdatedTimeGranularity() {
    return mBackdatedTimeGranularity;
  }

  public Boolean getFieldCanBackdate() {
    return mCanBackdate;
  }

  public Boolean getFieldCanDelete() {
    return mCanDelete;
  }

  public Boolean getFieldCanTag() {
    return mCanTag;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public Event getFieldEvent() {
    if (mEvent != null) {
      mEvent.context = getContext();
    }
    return mEvent;
  }

  public Object getFieldFrom() {
    return mFrom;
  }

  public Long getFieldHeight() {
    return mHeight;
  }

  public String getFieldIcon() {
    return mIcon;
  }

  public String getFieldId() {
    return mId;
  }

  public List<Object> getFieldImages() {
    return mImages;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldName() {
    return mName;
  }

  public List<Object> getFieldNameTags() {
    return mNameTags;
  }

  public String getFieldPageStoryId() {
    return mPageStoryId;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public Object getFieldPlace() {
    return mPlace;
  }

  public Long getFieldPosition() {
    return mPosition;
  }

  public String getFieldSource() {
    return mSource;
  }

  public Profile getFieldTarget() {
    if (mTarget != null) {
      mTarget.context = getContext();
    }
    return mTarget;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public List<Object> getFieldWebpImages() {
    return mWebpImages;
  }

  public Long getFieldWidth() {
    return mWidth;
  }



  public static class APIRequestDeleteLikes extends APIRequest<APINode> {

    APINodeList<APINode> lastResponse = null;
    @Override
    public APINodeList<APINode> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
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
               return APIRequestDeleteLikes.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDeleteLikes(String nodeId, APIContext context) {
      super(context, nodeId, "/likes", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDeleteLikes setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDeleteLikes setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDeleteLikes requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDeleteLikes requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteLikes requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDeleteLikes requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDeleteLikes requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDeleteLikes requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateLike extends APIRequest<APINode> {

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
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestCreateLike.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateLike(String nodeId, APIContext context) {
      super(context, nodeId, "/likes", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateLike setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateLike setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateLike requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateLike requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLike requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateLike requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateLike requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateLike requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateTag extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "tag_text",
      "tag_uid",
      "tags",
      "x",
      "y",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestCreateTag.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateTag(String nodeId, APIContext context) {
      super(context, nodeId, "/tags", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateTag setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateTag setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateTag setTagText (String tagText) {
      this.setParam("tag_text", tagText);
      return this;
    }

    public APIRequestCreateTag setTagUid (Long tagUid) {
      this.setParam("tag_uid", tagUid);
      return this;
    }
    public APIRequestCreateTag setTagUid (String tagUid) {
      this.setParam("tag_uid", tagUid);
      return this;
    }

    public APIRequestCreateTag setTags (List<Object> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestCreateTag setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestCreateTag setX (Double x) {
      this.setParam("x", x);
      return this;
    }
    public APIRequestCreateTag setX (String x) {
      this.setParam("x", x);
      return this;
    }

    public APIRequestCreateTag setY (Double y) {
      this.setParam("y", y);
      return this;
    }
    public APIRequestCreateTag setY (String y) {
      this.setParam("y", y);
      return this;
    }

    public APIRequestCreateTag requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateTag requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTag requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateTag requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateTag requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateTag requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
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
      "pid",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
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


    public APIRequestDelete setPid (String pid) {
      this.setParam("pid", pid);
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

  public static class APIRequestGet extends APIRequest<Photo> {

    Photo lastResponse = null;
    @Override
    public Photo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "album",
      "backdated_time",
      "backdated_time_granularity",
      "can_backdate",
      "can_delete",
      "can_tag",
      "created_time",
      "event",
      "from",
      "height",
      "icon",
      "id",
      "images",
      "link",
      "name",
      "name_tags",
      "page_story_id",
      "picture",
      "place",
      "position",
      "source",
      "target",
      "updated_time",
      "webp_images",
      "width",
    };

    @Override
    public Photo parseResponse(String response) throws APIException {
      return Photo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Photo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Photo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Photo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Photo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Photo>() {
           public Photo apply(String result) {
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

    public APIRequestGet requestAlbumField () {
      return this.requestAlbumField(true);
    }
    public APIRequestGet requestAlbumField (boolean value) {
      this.requestField("album", value);
      return this;
    }
    public APIRequestGet requestBackdatedTimeField () {
      return this.requestBackdatedTimeField(true);
    }
    public APIRequestGet requestBackdatedTimeField (boolean value) {
      this.requestField("backdated_time", value);
      return this;
    }
    public APIRequestGet requestBackdatedTimeGranularityField () {
      return this.requestBackdatedTimeGranularityField(true);
    }
    public APIRequestGet requestBackdatedTimeGranularityField (boolean value) {
      this.requestField("backdated_time_granularity", value);
      return this;
    }
    public APIRequestGet requestCanBackdateField () {
      return this.requestCanBackdateField(true);
    }
    public APIRequestGet requestCanBackdateField (boolean value) {
      this.requestField("can_backdate", value);
      return this;
    }
    public APIRequestGet requestCanDeleteField () {
      return this.requestCanDeleteField(true);
    }
    public APIRequestGet requestCanDeleteField (boolean value) {
      this.requestField("can_delete", value);
      return this;
    }
    public APIRequestGet requestCanTagField () {
      return this.requestCanTagField(true);
    }
    public APIRequestGet requestCanTagField (boolean value) {
      this.requestField("can_tag", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGet requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGet requestFromField () {
      return this.requestFromField(true);
    }
    public APIRequestGet requestFromField (boolean value) {
      this.requestField("from", value);
      return this;
    }
    public APIRequestGet requestHeightField () {
      return this.requestHeightField(true);
    }
    public APIRequestGet requestHeightField (boolean value) {
      this.requestField("height", value);
      return this;
    }
    public APIRequestGet requestIconField () {
      return this.requestIconField(true);
    }
    public APIRequestGet requestIconField (boolean value) {
      this.requestField("icon", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImagesField () {
      return this.requestImagesField(true);
    }
    public APIRequestGet requestImagesField (boolean value) {
      this.requestField("images", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestNameTagsField () {
      return this.requestNameTagsField(true);
    }
    public APIRequestGet requestNameTagsField (boolean value) {
      this.requestField("name_tags", value);
      return this;
    }
    public APIRequestGet requestPageStoryIdField () {
      return this.requestPageStoryIdField(true);
    }
    public APIRequestGet requestPageStoryIdField (boolean value) {
      this.requestField("page_story_id", value);
      return this;
    }
    public APIRequestGet requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGet requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGet requestPlaceField () {
      return this.requestPlaceField(true);
    }
    public APIRequestGet requestPlaceField (boolean value) {
      this.requestField("place", value);
      return this;
    }
    public APIRequestGet requestPositionField () {
      return this.requestPositionField(true);
    }
    public APIRequestGet requestPositionField (boolean value) {
      this.requestField("position", value);
      return this;
    }
    public APIRequestGet requestSourceField () {
      return this.requestSourceField(true);
    }
    public APIRequestGet requestSourceField (boolean value) {
      this.requestField("source", value);
      return this;
    }
    public APIRequestGet requestTargetField () {
      return this.requestTargetField(true);
    }
    public APIRequestGet requestTargetField (boolean value) {
      this.requestField("target", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestWebpImagesField () {
      return this.requestWebpImagesField(true);
    }
    public APIRequestGet requestWebpImagesField (boolean value) {
      this.requestField("webp_images", value);
      return this;
    }
    public APIRequestGet requestWidthField () {
      return this.requestWidthField(true);
    }
    public APIRequestGet requestWidthField (boolean value) {
      this.requestField("width", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Photo> {

    Photo lastResponse = null;
    @Override
    public Photo getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "android_key_hash",
      "asset3d_id",
      "backdated_time",
      "backdated_time_granularity",
      "checkin_entry_point",
      "composer_session_id",
      "direct_share_status",
      "ios_bundle_id",
      "is_checkin",
      "is_cropped",
      "is_explicit_location",
      "og_action_type_id",
      "og_icon_id",
      "og_object_id",
      "og_phrase",
      "og_set_profile_badge",
      "og_suggestion_mechanism",
      "place",
      "privacy",
      "prompt_id",
      "prompt_tracking_string",
      "proxied_app_id",
      "published",
      "referenced_sticker_id",
      "sponsor_id",
      "sponsor_relationship",
      "tags",
      "target",
      "target_post",
      "time_since_original_post",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Photo parseResponse(String response) throws APIException {
      return Photo.parseResponse(response, getContext(), this).head();
    }

    @Override
    public Photo execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Photo execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<Photo> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Photo> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, Photo>() {
           public Photo apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
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


    public APIRequestUpdate setAndroidKeyHash (String androidKeyHash) {
      this.setParam("android_key_hash", androidKeyHash);
      return this;
    }

    public APIRequestUpdate setAsset3dId (Long asset3dId) {
      this.setParam("asset3d_id", asset3dId);
      return this;
    }
    public APIRequestUpdate setAsset3dId (String asset3dId) {
      this.setParam("asset3d_id", asset3dId);
      return this;
    }

    public APIRequestUpdate setBackdatedTime (String backdatedTime) {
      this.setParam("backdated_time", backdatedTime);
      return this;
    }

    public APIRequestUpdate setBackdatedTimeGranularity (Photo.EnumBackdatedTimeGranularity backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }
    public APIRequestUpdate setBackdatedTimeGranularity (String backdatedTimeGranularity) {
      this.setParam("backdated_time_granularity", backdatedTimeGranularity);
      return this;
    }

    public APIRequestUpdate setCheckinEntryPoint (Photo.EnumCheckinEntryPoint checkinEntryPoint) {
      this.setParam("checkin_entry_point", checkinEntryPoint);
      return this;
    }
    public APIRequestUpdate setCheckinEntryPoint (String checkinEntryPoint) {
      this.setParam("checkin_entry_point", checkinEntryPoint);
      return this;
    }

    public APIRequestUpdate setComposerSessionId (String composerSessionId) {
      this.setParam("composer_session_id", composerSessionId);
      return this;
    }

    public APIRequestUpdate setDirectShareStatus (Long directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }
    public APIRequestUpdate setDirectShareStatus (String directShareStatus) {
      this.setParam("direct_share_status", directShareStatus);
      return this;
    }

    public APIRequestUpdate setIosBundleId (String iosBundleId) {
      this.setParam("ios_bundle_id", iosBundleId);
      return this;
    }

    public APIRequestUpdate setIsCheckin (Boolean isCheckin) {
      this.setParam("is_checkin", isCheckin);
      return this;
    }
    public APIRequestUpdate setIsCheckin (String isCheckin) {
      this.setParam("is_checkin", isCheckin);
      return this;
    }

    public APIRequestUpdate setIsCropped (Boolean isCropped) {
      this.setParam("is_cropped", isCropped);
      return this;
    }
    public APIRequestUpdate setIsCropped (String isCropped) {
      this.setParam("is_cropped", isCropped);
      return this;
    }

    public APIRequestUpdate setIsExplicitLocation (Boolean isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }
    public APIRequestUpdate setIsExplicitLocation (String isExplicitLocation) {
      this.setParam("is_explicit_location", isExplicitLocation);
      return this;
    }

    public APIRequestUpdate setOgActionTypeId (String ogActionTypeId) {
      this.setParam("og_action_type_id", ogActionTypeId);
      return this;
    }

    public APIRequestUpdate setOgIconId (String ogIconId) {
      this.setParam("og_icon_id", ogIconId);
      return this;
    }

    public APIRequestUpdate setOgObjectId (String ogObjectId) {
      this.setParam("og_object_id", ogObjectId);
      return this;
    }

    public APIRequestUpdate setOgPhrase (String ogPhrase) {
      this.setParam("og_phrase", ogPhrase);
      return this;
    }

    public APIRequestUpdate setOgSetProfileBadge (Boolean ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }
    public APIRequestUpdate setOgSetProfileBadge (String ogSetProfileBadge) {
      this.setParam("og_set_profile_badge", ogSetProfileBadge);
      return this;
    }

    public APIRequestUpdate setOgSuggestionMechanism (String ogSuggestionMechanism) {
      this.setParam("og_suggestion_mechanism", ogSuggestionMechanism);
      return this;
    }

    public APIRequestUpdate setPlace (Object place) {
      this.setParam("place", place);
      return this;
    }
    public APIRequestUpdate setPlace (String place) {
      this.setParam("place", place);
      return this;
    }

    public APIRequestUpdate setPrivacy (Object privacy) {
      this.setParam("privacy", privacy);
      return this;
    }
    public APIRequestUpdate setPrivacy (String privacy) {
      this.setParam("privacy", privacy);
      return this;
    }

    public APIRequestUpdate setPromptId (String promptId) {
      this.setParam("prompt_id", promptId);
      return this;
    }

    public APIRequestUpdate setPromptTrackingString (String promptTrackingString) {
      this.setParam("prompt_tracking_string", promptTrackingString);
      return this;
    }

    public APIRequestUpdate setProxiedAppId (String proxiedAppId) {
      this.setParam("proxied_app_id", proxiedAppId);
      return this;
    }

    public APIRequestUpdate setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestUpdate setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestUpdate setReferencedStickerId (String referencedStickerId) {
      this.setParam("referenced_sticker_id", referencedStickerId);
      return this;
    }

    public APIRequestUpdate setSponsorId (String sponsorId) {
      this.setParam("sponsor_id", sponsorId);
      return this;
    }

    public APIRequestUpdate setSponsorRelationship (Long sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }
    public APIRequestUpdate setSponsorRelationship (String sponsorRelationship) {
      this.setParam("sponsor_relationship", sponsorRelationship);
      return this;
    }

    public APIRequestUpdate setTags (List<Long> tags) {
      this.setParam("tags", tags);
      return this;
    }
    public APIRequestUpdate setTags (String tags) {
      this.setParam("tags", tags);
      return this;
    }

    public APIRequestUpdate setTarget (Object target) {
      this.setParam("target", target);
      return this;
    }
    public APIRequestUpdate setTarget (String target) {
      this.setParam("target", target);
      return this;
    }

    public APIRequestUpdate setTargetPost (String targetPost) {
      this.setParam("target_post", targetPost);
      return this;
    }

    public APIRequestUpdate setTimeSinceOriginalPost (Long timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
      return this;
    }
    public APIRequestUpdate setTimeSinceOriginalPost (String timeSinceOriginalPost) {
      this.setParam("time_since_original_post", timeSinceOriginalPost);
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

  public static enum EnumBackdatedTimeGranularity {
      @SerializedName("year")
      VALUE_YEAR("year"),
      @SerializedName("month")
      VALUE_MONTH("month"),
      @SerializedName("day")
      VALUE_DAY("day"),
      @SerializedName("hour")
      VALUE_HOUR("hour"),
      @SerializedName("min")
      VALUE_MIN("min"),
      @SerializedName("none")
      VALUE_NONE("none"),
      NULL(null);

      private String value;

      private EnumBackdatedTimeGranularity(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumType {
      @SerializedName("profile")
      VALUE_PROFILE("profile"),
      @SerializedName("tagged")
      VALUE_TAGGED("tagged"),
      @SerializedName("uploaded")
      VALUE_UPLOADED("uploaded"),
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

  public static enum EnumUnpublishedContentType {
      @SerializedName("SCHEDULED")
      VALUE_SCHEDULED("SCHEDULED"),
      @SerializedName("DRAFT")
      VALUE_DRAFT("DRAFT"),
      @SerializedName("ADS_POST")
      VALUE_ADS_POST("ADS_POST"),
      @SerializedName("INLINE_CREATED")
      VALUE_INLINE_CREATED("INLINE_CREATED"),
      @SerializedName("PUBLISHED")
      VALUE_PUBLISHED("PUBLISHED"),
      NULL(null);

      private String value;

      private EnumUnpublishedContentType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumCheckinEntryPoint {
      @SerializedName("BRANDING_CHECKIN")
      VALUE_BRANDING_CHECKIN("BRANDING_CHECKIN"),
      @SerializedName("BRANDING_STATUS")
      VALUE_BRANDING_STATUS("BRANDING_STATUS"),
      @SerializedName("BRANDING_PHOTO")
      VALUE_BRANDING_PHOTO("BRANDING_PHOTO"),
      @SerializedName("BRANDING_OTHER")
      VALUE_BRANDING_OTHER("BRANDING_OTHER"),
      NULL(null);

      private String value;

      private EnumCheckinEntryPoint(String value) {
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

  public Photo copyFrom(Photo instance) {
    this.mAlbum = instance.mAlbum;
    this.mBackdatedTime = instance.mBackdatedTime;
    this.mBackdatedTimeGranularity = instance.mBackdatedTimeGranularity;
    this.mCanBackdate = instance.mCanBackdate;
    this.mCanDelete = instance.mCanDelete;
    this.mCanTag = instance.mCanTag;
    this.mCreatedTime = instance.mCreatedTime;
    this.mEvent = instance.mEvent;
    this.mFrom = instance.mFrom;
    this.mHeight = instance.mHeight;
    this.mIcon = instance.mIcon;
    this.mId = instance.mId;
    this.mImages = instance.mImages;
    this.mLink = instance.mLink;
    this.mName = instance.mName;
    this.mNameTags = instance.mNameTags;
    this.mPageStoryId = instance.mPageStoryId;
    this.mPicture = instance.mPicture;
    this.mPlace = instance.mPlace;
    this.mPosition = instance.mPosition;
    this.mSource = instance.mSource;
    this.mTarget = instance.mTarget;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mWebpImages = instance.mWebpImages;
    this.mWidth = instance.mWidth;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Photo> getParser() {
    return new APIRequest.ResponseParser<Photo>() {
      public APINodeList<Photo> parseResponse(String response, APIContext context, APIRequest<Photo> request) throws MalformedResponseException {
        return Photo.parseResponse(response, context, request);
      }
    };
  }
}
