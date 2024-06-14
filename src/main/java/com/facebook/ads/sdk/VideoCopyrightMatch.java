/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
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
import com.google.common.util.concurrent.MoreExecutors;
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
public class VideoCopyrightMatch extends APINode {
  @SerializedName("created_date")
  private String mCreatedDate = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("last_modified_user")
  private User mLastModifiedUser = null;
  @SerializedName("match_data")
  private List<Object> mMatchData = null;
  @SerializedName("match_status")
  private String mMatchStatus = null;
  @SerializedName("notes")
  private String mNotes = null;
  @SerializedName("permalink")
  private String mPermalink = null;
  protected static Gson gson = null;

  VideoCopyrightMatch() {
  }

  public VideoCopyrightMatch(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public VideoCopyrightMatch(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public VideoCopyrightMatch fetch() throws APIException{
    VideoCopyrightMatch newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static VideoCopyrightMatch fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<VideoCopyrightMatch> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static VideoCopyrightMatch fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<VideoCopyrightMatch> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<VideoCopyrightMatch> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<VideoCopyrightMatch>)(
      new APIRequest<VideoCopyrightMatch>(context, "", "/", "GET", VideoCopyrightMatch.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<VideoCopyrightMatch>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", VideoCopyrightMatch.getParser())
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
  public static VideoCopyrightMatch loadJSON(String json, APIContext context, String header) {
    VideoCopyrightMatch videoCopyrightMatch = getGson().fromJson(json, VideoCopyrightMatch.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(videoCopyrightMatch.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    videoCopyrightMatch.context = context;
    videoCopyrightMatch.rawValue = json;
    videoCopyrightMatch.header = header;
    return videoCopyrightMatch;
  }

  public static APINodeList<VideoCopyrightMatch> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<VideoCopyrightMatch> videoCopyrightMatchs = new APINodeList<VideoCopyrightMatch>(request, json, header);
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
          videoCopyrightMatchs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return videoCopyrightMatchs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                videoCopyrightMatchs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            videoCopyrightMatchs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              videoCopyrightMatchs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              videoCopyrightMatchs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  videoCopyrightMatchs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              videoCopyrightMatchs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return videoCopyrightMatchs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              videoCopyrightMatchs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return videoCopyrightMatchs;
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
              videoCopyrightMatchs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return videoCopyrightMatchs;
          }

          // Sixth, check if it's pure JsonObject
          videoCopyrightMatchs.clear();
          videoCopyrightMatchs.add(loadJSON(json, context, header));
          return videoCopyrightMatchs;
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


  public String getFieldCreatedDate() {
    return mCreatedDate;
  }

  public String getFieldId() {
    return mId;
  }

  public User getFieldLastModifiedUser() {
    if (mLastModifiedUser != null) {
      mLastModifiedUser.context = getContext();
    }
    return mLastModifiedUser;
  }

  public List<Object> getFieldMatchData() {
    return mMatchData;
  }

  public String getFieldMatchStatus() {
    return mMatchStatus;
  }

  public String getFieldNotes() {
    return mNotes;
  }

  public String getFieldPermalink() {
    return mPermalink;
  }



  public static class APIRequestGet extends APIRequest<VideoCopyrightMatch> {

    VideoCopyrightMatch lastResponse = null;
    @Override
    public VideoCopyrightMatch getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "created_date",
      "id",
      "last_modified_user",
      "match_data",
      "match_status",
      "notes",
      "permalink",
    };

    @Override
    public VideoCopyrightMatch parseResponse(String response, String header) throws APIException {
      return VideoCopyrightMatch.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public VideoCopyrightMatch execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public VideoCopyrightMatch execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<VideoCopyrightMatch> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<VideoCopyrightMatch> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, VideoCopyrightMatch>() {
           public VideoCopyrightMatch apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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

    public APIRequestGet requestCreatedDateField () {
      return this.requestCreatedDateField(true);
    }
    public APIRequestGet requestCreatedDateField (boolean value) {
      this.requestField("created_date", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLastModifiedUserField () {
      return this.requestLastModifiedUserField(true);
    }
    public APIRequestGet requestLastModifiedUserField (boolean value) {
      this.requestField("last_modified_user", value);
      return this;
    }
    public APIRequestGet requestMatchDataField () {
      return this.requestMatchDataField(true);
    }
    public APIRequestGet requestMatchDataField (boolean value) {
      this.requestField("match_data", value);
      return this;
    }
    public APIRequestGet requestMatchStatusField () {
      return this.requestMatchStatusField(true);
    }
    public APIRequestGet requestMatchStatusField (boolean value) {
      this.requestField("match_status", value);
      return this;
    }
    public APIRequestGet requestNotesField () {
      return this.requestNotesField(true);
    }
    public APIRequestGet requestNotesField (boolean value) {
      this.requestField("notes", value);
      return this;
    }
    public APIRequestGet requestPermalinkField () {
      return this.requestPermalinkField(true);
    }
    public APIRequestGet requestPermalinkField (boolean value) {
      this.requestField("permalink", value);
      return this;
    }
  }

  public static enum EnumAction {
      @SerializedName("BLOCK")
      VALUE_BLOCK("BLOCK"),
      @SerializedName("CLAIM_AD_EARNINGS")
      VALUE_CLAIM_AD_EARNINGS("CLAIM_AD_EARNINGS"),
      @SerializedName("MANUAL_REVIEW")
      VALUE_MANUAL_REVIEW("MANUAL_REVIEW"),
      @SerializedName("MONITOR")
      VALUE_MONITOR("MONITOR"),
      @SerializedName("REQUEST_TAKEDOWN")
      VALUE_REQUEST_TAKEDOWN("REQUEST_TAKEDOWN"),
      ;

      private String value;

      private EnumAction(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumActionReason {
      @SerializedName("ARTICLE_17_PREFLAGGING")
      VALUE_ARTICLE_17_PREFLAGGING("ARTICLE_17_PREFLAGGING"),
      @SerializedName("ARTIST_OBJECTION")
      VALUE_ARTIST_OBJECTION("ARTIST_OBJECTION"),
      @SerializedName("OBJECTIONABLE_CONTENT")
      VALUE_OBJECTIONABLE_CONTENT("OBJECTIONABLE_CONTENT"),
      @SerializedName("PREMIUM_MUSIC_VIDEO")
      VALUE_PREMIUM_MUSIC_VIDEO("PREMIUM_MUSIC_VIDEO"),
      @SerializedName("PRERELEASE_CONTENT")
      VALUE_PRERELEASE_CONTENT("PRERELEASE_CONTENT"),
      @SerializedName("PRODUCT_PARAMETERS")
      VALUE_PRODUCT_PARAMETERS("PRODUCT_PARAMETERS"),
      @SerializedName("RESTRICTED_CONTENT")
      VALUE_RESTRICTED_CONTENT("RESTRICTED_CONTENT"),
      @SerializedName("UNAUTHORIZED_COMMERCIAL_USE")
      VALUE_UNAUTHORIZED_COMMERCIAL_USE("UNAUTHORIZED_COMMERCIAL_USE"),
      ;

      private String value;

      private EnumActionReason(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumMatchContentType {
      @SerializedName("AUDIO_ONLY")
      VALUE_AUDIO_ONLY("AUDIO_ONLY"),
      @SerializedName("VIDEO_AND_AUDIO")
      VALUE_VIDEO_AND_AUDIO("VIDEO_AND_AUDIO"),
      @SerializedName("VIDEO_ONLY")
      VALUE_VIDEO_ONLY("VIDEO_ONLY"),
      ;

      private String value;

      private EnumMatchContentType(String value) {
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

  public VideoCopyrightMatch copyFrom(VideoCopyrightMatch instance) {
    this.mCreatedDate = instance.mCreatedDate;
    this.mId = instance.mId;
    this.mLastModifiedUser = instance.mLastModifiedUser;
    this.mMatchData = instance.mMatchData;
    this.mMatchStatus = instance.mMatchStatus;
    this.mNotes = instance.mNotes;
    this.mPermalink = instance.mPermalink;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<VideoCopyrightMatch> getParser() {
    return new APIRequest.ResponseParser<VideoCopyrightMatch>() {
      public APINodeList<VideoCopyrightMatch> parseResponse(String response, APIContext context, APIRequest<VideoCopyrightMatch> request, String header) throws MalformedResponseException {
        return VideoCopyrightMatch.parseResponse(response, context, request, header);
      }
    };
  }
}
