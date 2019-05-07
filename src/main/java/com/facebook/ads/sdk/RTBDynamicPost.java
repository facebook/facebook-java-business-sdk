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
public class RTBDynamicPost extends APINode {
  @SerializedName("child_attachments")
  private List<DynamicPostChildAttachment> mChildAttachments = null;
  @SerializedName("created")
  private String mCreated = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image_url")
  private String mImageUrl = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("message")
  private String mMessage = null;
  @SerializedName("owner_id")
  private String mOwnerId = null;
  @SerializedName("place_id")
  private String mPlaceId = null;
  @SerializedName("product_id")
  private String mProductId = null;
  @SerializedName("title")
  private String mTitle = null;
  protected static Gson gson = null;

  RTBDynamicPost() {
  }

  public RTBDynamicPost(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public RTBDynamicPost(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public RTBDynamicPost fetch() throws APIException{
    RTBDynamicPost newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static RTBDynamicPost fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<RTBDynamicPost> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static RTBDynamicPost fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<RTBDynamicPost> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<RTBDynamicPost> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<RTBDynamicPost>)(
      new APIRequest<RTBDynamicPost>(context, "", "/", "GET", RTBDynamicPost.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<RTBDynamicPost>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", RTBDynamicPost.getParser())
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
  public static RTBDynamicPost loadJSON(String json, APIContext context, String header) {
    RTBDynamicPost rtbDynamicPost = getGson().fromJson(json, RTBDynamicPost.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(rtbDynamicPost.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    rtbDynamicPost.context = context;
    rtbDynamicPost.rawValue = json;
    rtbDynamicPost.header = header;
    return rtbDynamicPost;
  }

  public static APINodeList<RTBDynamicPost> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<RTBDynamicPost> rtbDynamicPosts = new APINodeList<RTBDynamicPost>(request, json, header);
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
          rtbDynamicPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return rtbDynamicPosts;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                rtbDynamicPosts.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            rtbDynamicPosts.setPaging(previous, next);
            if (context.hasAppSecret()) {
              rtbDynamicPosts.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              rtbDynamicPosts.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  rtbDynamicPosts.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              rtbDynamicPosts.add(loadJSON(obj.toString(), context, header));
            }
          }
          return rtbDynamicPosts;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              rtbDynamicPosts.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return rtbDynamicPosts;
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
              rtbDynamicPosts.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return rtbDynamicPosts;
          }

          // Sixth, check if it's pure JsonObject
          rtbDynamicPosts.clear();
          rtbDynamicPosts.add(loadJSON(json, context, header));
          return rtbDynamicPosts;
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

  public APIRequestGetInstagramComments getInstagramComments() {
    return new APIRequestGetInstagramComments(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public List<DynamicPostChildAttachment> getFieldChildAttachments() {
    return mChildAttachments;
  }

  public String getFieldCreated() {
    return mCreated;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldImageUrl() {
    return mImageUrl;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldMessage() {
    return mMessage;
  }

  public String getFieldOwnerId() {
    return mOwnerId;
  }

  public String getFieldPlaceId() {
    return mPlaceId;
  }

  public String getFieldProductId() {
    return mProductId;
  }

  public String getFieldTitle() {
    return mTitle;
  }



  public static class APIRequestGetInstagramComments extends APIRequest<InstagramComment> {

    APINodeList<InstagramComment> lastResponse = null;
    @Override
    public APINodeList<InstagramComment> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "comment_type",
      "created_at",
      "id",
      "instagram_comment_id",
      "instagram_user",
      "mentioned_instagram_users",
      "message",
    };

    @Override
    public APINodeList<InstagramComment> parseResponse(String response, String header) throws APIException {
      return InstagramComment.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<InstagramComment> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<InstagramComment> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<InstagramComment>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<InstagramComment>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<InstagramComment>>() {
           public APINodeList<InstagramComment> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInstagramComments.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInstagramComments(String nodeId, APIContext context) {
      super(context, nodeId, "/instagram_comments", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInstagramComments setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInstagramComments setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInstagramComments requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInstagramComments requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramComments requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInstagramComments requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInstagramComments requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInstagramComments requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInstagramComments requestCommentTypeField () {
      return this.requestCommentTypeField(true);
    }
    public APIRequestGetInstagramComments requestCommentTypeField (boolean value) {
      this.requestField("comment_type", value);
      return this;
    }
    public APIRequestGetInstagramComments requestCreatedAtField () {
      return this.requestCreatedAtField(true);
    }
    public APIRequestGetInstagramComments requestCreatedAtField (boolean value) {
      this.requestField("created_at", value);
      return this;
    }
    public APIRequestGetInstagramComments requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetInstagramComments requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetInstagramComments requestInstagramCommentIdField () {
      return this.requestInstagramCommentIdField(true);
    }
    public APIRequestGetInstagramComments requestInstagramCommentIdField (boolean value) {
      this.requestField("instagram_comment_id", value);
      return this;
    }
    public APIRequestGetInstagramComments requestInstagramUserField () {
      return this.requestInstagramUserField(true);
    }
    public APIRequestGetInstagramComments requestInstagramUserField (boolean value) {
      this.requestField("instagram_user", value);
      return this;
    }
    public APIRequestGetInstagramComments requestMentionedInstagramUsersField () {
      return this.requestMentionedInstagramUsersField(true);
    }
    public APIRequestGetInstagramComments requestMentionedInstagramUsersField (boolean value) {
      this.requestField("mentioned_instagram_users", value);
      return this;
    }
    public APIRequestGetInstagramComments requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGetInstagramComments requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<RTBDynamicPost> {

    RTBDynamicPost lastResponse = null;
    @Override
    public RTBDynamicPost getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "child_attachments",
      "created",
      "description",
      "id",
      "image_url",
      "link",
      "message",
      "owner_id",
      "place_id",
      "product_id",
      "title",
    };

    @Override
    public RTBDynamicPost parseResponse(String response, String header) throws APIException {
      return RTBDynamicPost.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public RTBDynamicPost execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public RTBDynamicPost execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<RTBDynamicPost> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<RTBDynamicPost> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, RTBDynamicPost>() {
           public RTBDynamicPost apply(ResponseWrapper result) {
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

    public APIRequestGet requestChildAttachmentsField () {
      return this.requestChildAttachmentsField(true);
    }
    public APIRequestGet requestChildAttachmentsField (boolean value) {
      this.requestField("child_attachments", value);
      return this;
    }
    public APIRequestGet requestCreatedField () {
      return this.requestCreatedField(true);
    }
    public APIRequestGet requestCreatedField (boolean value) {
      this.requestField("created", value);
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
    public APIRequestGet requestImageUrlField () {
      return this.requestImageUrlField(true);
    }
    public APIRequestGet requestImageUrlField (boolean value) {
      this.requestField("image_url", value);
      return this;
    }
    public APIRequestGet requestLinkField () {
      return this.requestLinkField(true);
    }
    public APIRequestGet requestLinkField (boolean value) {
      this.requestField("link", value);
      return this;
    }
    public APIRequestGet requestMessageField () {
      return this.requestMessageField(true);
    }
    public APIRequestGet requestMessageField (boolean value) {
      this.requestField("message", value);
      return this;
    }
    public APIRequestGet requestOwnerIdField () {
      return this.requestOwnerIdField(true);
    }
    public APIRequestGet requestOwnerIdField (boolean value) {
      this.requestField("owner_id", value);
      return this;
    }
    public APIRequestGet requestPlaceIdField () {
      return this.requestPlaceIdField(true);
    }
    public APIRequestGet requestPlaceIdField (boolean value) {
      this.requestField("place_id", value);
      return this;
    }
    public APIRequestGet requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGet requestProductIdField (boolean value) {
      this.requestField("product_id", value);
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

  public RTBDynamicPost copyFrom(RTBDynamicPost instance) {
    this.mChildAttachments = instance.mChildAttachments;
    this.mCreated = instance.mCreated;
    this.mDescription = instance.mDescription;
    this.mId = instance.mId;
    this.mImageUrl = instance.mImageUrl;
    this.mLink = instance.mLink;
    this.mMessage = instance.mMessage;
    this.mOwnerId = instance.mOwnerId;
    this.mPlaceId = instance.mPlaceId;
    this.mProductId = instance.mProductId;
    this.mTitle = instance.mTitle;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<RTBDynamicPost> getParser() {
    return new APIRequest.ResponseParser<RTBDynamicPost>() {
      public APINodeList<RTBDynamicPost> parseResponse(String response, APIContext context, APIRequest<RTBDynamicPost> request, String header) throws MalformedResponseException {
        return RTBDynamicPost.parseResponse(response, context, request, header);
      }
    };
  }
}
