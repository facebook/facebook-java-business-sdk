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
public class AudioRelease extends APINode {
  @SerializedName("album_title")
  private String mAlbumTitle = null;
  @SerializedName("asset_availability_status")
  private List<Map<Long, Object>> mAssetAvailabilityStatus = null;
  @SerializedName("audio_availability_status")
  private String mAudioAvailabilityStatus = null;
  @SerializedName("audio_release_image_uri")
  private String mAudioReleaseImageUri = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("displayed_artist")
  private String mDisplayedArtist = null;
  @SerializedName("ean")
  private String mEan = null;
  @SerializedName("genre")
  private String mGenre = null;
  @SerializedName("grid")
  private String mGrid = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("isrc")
  private String mIsrc = null;
  @SerializedName("label_name")
  private String mLabelName = null;
  @SerializedName("original_release_date")
  private String mOriginalReleaseDate = null;
  @SerializedName("parental_warning_type")
  private String mParentalWarningType = null;
  @SerializedName("proprietary_id")
  private String mProprietaryId = null;
  @SerializedName("upc")
  private String mUpc = null;
  protected static Gson gson = null;

  AudioRelease() {
  }

  public AudioRelease(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AudioRelease(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AudioRelease fetch() throws APIException{
    AudioRelease newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AudioRelease fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AudioRelease> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AudioRelease fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AudioRelease> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AudioRelease> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AudioRelease>)(
      new APIRequest<AudioRelease>(context, "", "/", "GET", AudioRelease.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AudioRelease>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AudioRelease.getParser())
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
  public static AudioRelease loadJSON(String json, APIContext context, String header) {
    AudioRelease audioRelease = getGson().fromJson(json, AudioRelease.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(audioRelease.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    audioRelease.context = context;
    audioRelease.rawValue = json;
    audioRelease.header = header;
    return audioRelease;
  }

  public static APINodeList<AudioRelease> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AudioRelease> audioReleases = new APINodeList<AudioRelease>(request, json, header);
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
          audioReleases.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return audioReleases;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                audioReleases.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            audioReleases.setPaging(previous, next);
            if (context.hasAppSecret()) {
              audioReleases.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              audioReleases.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  audioReleases.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              audioReleases.add(loadJSON(obj.toString(), context, header));
            }
          }
          return audioReleases;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              audioReleases.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return audioReleases;
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
              audioReleases.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return audioReleases;
          }

          // Sixth, check if it's pure JsonObject
          audioReleases.clear();
          audioReleases.add(loadJSON(json, context, header));
          return audioReleases;
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


  public String getFieldAlbumTitle() {
    return mAlbumTitle;
  }

  public List<Map<Long, Object>> getFieldAssetAvailabilityStatus() {
    return mAssetAvailabilityStatus;
  }

  public String getFieldAudioAvailabilityStatus() {
    return mAudioAvailabilityStatus;
  }

  public String getFieldAudioReleaseImageUri() {
    return mAudioReleaseImageUri;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldDisplayedArtist() {
    return mDisplayedArtist;
  }

  public String getFieldEan() {
    return mEan;
  }

  public String getFieldGenre() {
    return mGenre;
  }

  public String getFieldGrid() {
    return mGrid;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldIsrc() {
    return mIsrc;
  }

  public String getFieldLabelName() {
    return mLabelName;
  }

  public String getFieldOriginalReleaseDate() {
    return mOriginalReleaseDate;
  }

  public String getFieldParentalWarningType() {
    return mParentalWarningType;
  }

  public String getFieldProprietaryId() {
    return mProprietaryId;
  }

  public String getFieldUpc() {
    return mUpc;
  }



  public static class APIRequestGet extends APIRequest<AudioRelease> {

    AudioRelease lastResponse = null;
    @Override
    public AudioRelease getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "album_title",
      "asset_availability_status",
      "audio_availability_status",
      "audio_release_image_uri",
      "created_time",
      "displayed_artist",
      "ean",
      "genre",
      "grid",
      "id",
      "isrc",
      "label_name",
      "original_release_date",
      "parental_warning_type",
      "proprietary_id",
      "upc",
    };

    @Override
    public AudioRelease parseResponse(String response, String header) throws APIException {
      return AudioRelease.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AudioRelease execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AudioRelease execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AudioRelease> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AudioRelease> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AudioRelease>() {
           public AudioRelease apply(ResponseWrapper result) {
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

    public APIRequestGet requestAlbumTitleField () {
      return this.requestAlbumTitleField(true);
    }
    public APIRequestGet requestAlbumTitleField (boolean value) {
      this.requestField("album_title", value);
      return this;
    }
    public APIRequestGet requestAssetAvailabilityStatusField () {
      return this.requestAssetAvailabilityStatusField(true);
    }
    public APIRequestGet requestAssetAvailabilityStatusField (boolean value) {
      this.requestField("asset_availability_status", value);
      return this;
    }
    public APIRequestGet requestAudioAvailabilityStatusField () {
      return this.requestAudioAvailabilityStatusField(true);
    }
    public APIRequestGet requestAudioAvailabilityStatusField (boolean value) {
      this.requestField("audio_availability_status", value);
      return this;
    }
    public APIRequestGet requestAudioReleaseImageUriField () {
      return this.requestAudioReleaseImageUriField(true);
    }
    public APIRequestGet requestAudioReleaseImageUriField (boolean value) {
      this.requestField("audio_release_image_uri", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestDisplayedArtistField () {
      return this.requestDisplayedArtistField(true);
    }
    public APIRequestGet requestDisplayedArtistField (boolean value) {
      this.requestField("displayed_artist", value);
      return this;
    }
    public APIRequestGet requestEanField () {
      return this.requestEanField(true);
    }
    public APIRequestGet requestEanField (boolean value) {
      this.requestField("ean", value);
      return this;
    }
    public APIRequestGet requestGenreField () {
      return this.requestGenreField(true);
    }
    public APIRequestGet requestGenreField (boolean value) {
      this.requestField("genre", value);
      return this;
    }
    public APIRequestGet requestGridField () {
      return this.requestGridField(true);
    }
    public APIRequestGet requestGridField (boolean value) {
      this.requestField("grid", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsrcField () {
      return this.requestIsrcField(true);
    }
    public APIRequestGet requestIsrcField (boolean value) {
      this.requestField("isrc", value);
      return this;
    }
    public APIRequestGet requestLabelNameField () {
      return this.requestLabelNameField(true);
    }
    public APIRequestGet requestLabelNameField (boolean value) {
      this.requestField("label_name", value);
      return this;
    }
    public APIRequestGet requestOriginalReleaseDateField () {
      return this.requestOriginalReleaseDateField(true);
    }
    public APIRequestGet requestOriginalReleaseDateField (boolean value) {
      this.requestField("original_release_date", value);
      return this;
    }
    public APIRequestGet requestParentalWarningTypeField () {
      return this.requestParentalWarningTypeField(true);
    }
    public APIRequestGet requestParentalWarningTypeField (boolean value) {
      this.requestField("parental_warning_type", value);
      return this;
    }
    public APIRequestGet requestProprietaryIdField () {
      return this.requestProprietaryIdField(true);
    }
    public APIRequestGet requestProprietaryIdField (boolean value) {
      this.requestField("proprietary_id", value);
      return this;
    }
    public APIRequestGet requestUpcField () {
      return this.requestUpcField(true);
    }
    public APIRequestGet requestUpcField (boolean value) {
      this.requestField("upc", value);
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

  public AudioRelease copyFrom(AudioRelease instance) {
    this.mAlbumTitle = instance.mAlbumTitle;
    this.mAssetAvailabilityStatus = instance.mAssetAvailabilityStatus;
    this.mAudioAvailabilityStatus = instance.mAudioAvailabilityStatus;
    this.mAudioReleaseImageUri = instance.mAudioReleaseImageUri;
    this.mCreatedTime = instance.mCreatedTime;
    this.mDisplayedArtist = instance.mDisplayedArtist;
    this.mEan = instance.mEan;
    this.mGenre = instance.mGenre;
    this.mGrid = instance.mGrid;
    this.mId = instance.mId;
    this.mIsrc = instance.mIsrc;
    this.mLabelName = instance.mLabelName;
    this.mOriginalReleaseDate = instance.mOriginalReleaseDate;
    this.mParentalWarningType = instance.mParentalWarningType;
    this.mProprietaryId = instance.mProprietaryId;
    this.mUpc = instance.mUpc;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AudioRelease> getParser() {
    return new APIRequest.ResponseParser<AudioRelease>() {
      public APINodeList<AudioRelease> parseResponse(String response, APIContext context, APIRequest<AudioRelease> request, String header) throws MalformedResponseException {
        return AudioRelease.parseResponse(response, context, request, header);
      }
    };
  }
}
