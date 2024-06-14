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
public class AudioAsset extends APINode {
  @SerializedName("all_ddex_featured_artists")
  private String mAllDdexFeaturedArtists = null;
  @SerializedName("all_ddex_main_artists")
  private String mAllDdexMainArtists = null;
  @SerializedName("audio_cluster_id")
  private String mAudioClusterId = null;
  @SerializedName("cover_image_source")
  private String mCoverImageSource = null;
  @SerializedName("display_artist")
  private String mDisplayArtist = null;
  @SerializedName("download_hd_url")
  private String mDownloadHdUrl = null;
  @SerializedName("download_sd_url")
  private String mDownloadSdUrl = null;
  @SerializedName("duration_in_ms")
  private Long mDurationInMs = null;
  @SerializedName("freeform_genre")
  private String mFreeformGenre = null;
  @SerializedName("grid")
  private String mGrid = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_test")
  private Boolean mIsTest = null;
  @SerializedName("original_release_date")
  private String mOriginalReleaseDate = null;
  @SerializedName("owner")
  private Page mOwner = null;
  @SerializedName("parental_warning_type")
  private String mParentalWarningType = null;
  @SerializedName("subtitle")
  private String mSubtitle = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("title_with_featured_artists")
  private String mTitleWithFeaturedArtists = null;
  @SerializedName("upc")
  private String mUpc = null;
  protected static Gson gson = null;

  AudioAsset() {
  }

  public AudioAsset(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AudioAsset(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AudioAsset fetch() throws APIException{
    AudioAsset newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AudioAsset fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AudioAsset> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AudioAsset fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AudioAsset> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AudioAsset> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AudioAsset>)(
      new APIRequest<AudioAsset>(context, "", "/", "GET", AudioAsset.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AudioAsset>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AudioAsset.getParser())
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
  public static AudioAsset loadJSON(String json, APIContext context, String header) {
    AudioAsset audioAsset = getGson().fromJson(json, AudioAsset.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(audioAsset.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    audioAsset.context = context;
    audioAsset.rawValue = json;
    audioAsset.header = header;
    return audioAsset;
  }

  public static APINodeList<AudioAsset> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AudioAsset> audioAssets = new APINodeList<AudioAsset>(request, json, header);
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
          audioAssets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return audioAssets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                audioAssets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            audioAssets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              audioAssets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              audioAssets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  audioAssets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              audioAssets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return audioAssets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              audioAssets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return audioAssets;
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
              audioAssets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return audioAssets;
          }

          // Sixth, check if it's pure JsonObject
          audioAssets.clear();
          audioAssets.add(loadJSON(json, context, header));
          return audioAssets;
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


  public String getFieldAllDdexFeaturedArtists() {
    return mAllDdexFeaturedArtists;
  }

  public String getFieldAllDdexMainArtists() {
    return mAllDdexMainArtists;
  }

  public String getFieldAudioClusterId() {
    return mAudioClusterId;
  }

  public String getFieldCoverImageSource() {
    return mCoverImageSource;
  }

  public String getFieldDisplayArtist() {
    return mDisplayArtist;
  }

  public String getFieldDownloadHdUrl() {
    return mDownloadHdUrl;
  }

  public String getFieldDownloadSdUrl() {
    return mDownloadSdUrl;
  }

  public Long getFieldDurationInMs() {
    return mDurationInMs;
  }

  public String getFieldFreeformGenre() {
    return mFreeformGenre;
  }

  public String getFieldGrid() {
    return mGrid;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsTest() {
    return mIsTest;
  }

  public String getFieldOriginalReleaseDate() {
    return mOriginalReleaseDate;
  }

  public Page getFieldOwner() {
    if (mOwner != null) {
      mOwner.context = getContext();
    }
    return mOwner;
  }

  public String getFieldParentalWarningType() {
    return mParentalWarningType;
  }

  public String getFieldSubtitle() {
    return mSubtitle;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldTitleWithFeaturedArtists() {
    return mTitleWithFeaturedArtists;
  }

  public String getFieldUpc() {
    return mUpc;
  }



  public static class APIRequestGet extends APIRequest<AudioAsset> {

    AudioAsset lastResponse = null;
    @Override
    public AudioAsset getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "all_ddex_featured_artists",
      "all_ddex_main_artists",
      "audio_cluster_id",
      "cover_image_source",
      "display_artist",
      "download_hd_url",
      "download_sd_url",
      "duration_in_ms",
      "freeform_genre",
      "grid",
      "id",
      "is_test",
      "original_release_date",
      "owner",
      "parental_warning_type",
      "subtitle",
      "title",
      "title_with_featured_artists",
      "upc",
    };

    @Override
    public AudioAsset parseResponse(String response, String header) throws APIException {
      return AudioAsset.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AudioAsset execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AudioAsset execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AudioAsset> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AudioAsset> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AudioAsset>() {
           public AudioAsset apply(ResponseWrapper result) {
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

    public APIRequestGet requestAllDdexFeaturedArtistsField () {
      return this.requestAllDdexFeaturedArtistsField(true);
    }
    public APIRequestGet requestAllDdexFeaturedArtistsField (boolean value) {
      this.requestField("all_ddex_featured_artists", value);
      return this;
    }
    public APIRequestGet requestAllDdexMainArtistsField () {
      return this.requestAllDdexMainArtistsField(true);
    }
    public APIRequestGet requestAllDdexMainArtistsField (boolean value) {
      this.requestField("all_ddex_main_artists", value);
      return this;
    }
    public APIRequestGet requestAudioClusterIdField () {
      return this.requestAudioClusterIdField(true);
    }
    public APIRequestGet requestAudioClusterIdField (boolean value) {
      this.requestField("audio_cluster_id", value);
      return this;
    }
    public APIRequestGet requestCoverImageSourceField () {
      return this.requestCoverImageSourceField(true);
    }
    public APIRequestGet requestCoverImageSourceField (boolean value) {
      this.requestField("cover_image_source", value);
      return this;
    }
    public APIRequestGet requestDisplayArtistField () {
      return this.requestDisplayArtistField(true);
    }
    public APIRequestGet requestDisplayArtistField (boolean value) {
      this.requestField("display_artist", value);
      return this;
    }
    public APIRequestGet requestDownloadHdUrlField () {
      return this.requestDownloadHdUrlField(true);
    }
    public APIRequestGet requestDownloadHdUrlField (boolean value) {
      this.requestField("download_hd_url", value);
      return this;
    }
    public APIRequestGet requestDownloadSdUrlField () {
      return this.requestDownloadSdUrlField(true);
    }
    public APIRequestGet requestDownloadSdUrlField (boolean value) {
      this.requestField("download_sd_url", value);
      return this;
    }
    public APIRequestGet requestDurationInMsField () {
      return this.requestDurationInMsField(true);
    }
    public APIRequestGet requestDurationInMsField (boolean value) {
      this.requestField("duration_in_ms", value);
      return this;
    }
    public APIRequestGet requestFreeformGenreField () {
      return this.requestFreeformGenreField(true);
    }
    public APIRequestGet requestFreeformGenreField (boolean value) {
      this.requestField("freeform_genre", value);
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
    public APIRequestGet requestIsTestField () {
      return this.requestIsTestField(true);
    }
    public APIRequestGet requestIsTestField (boolean value) {
      this.requestField("is_test", value);
      return this;
    }
    public APIRequestGet requestOriginalReleaseDateField () {
      return this.requestOriginalReleaseDateField(true);
    }
    public APIRequestGet requestOriginalReleaseDateField (boolean value) {
      this.requestField("original_release_date", value);
      return this;
    }
    public APIRequestGet requestOwnerField () {
      return this.requestOwnerField(true);
    }
    public APIRequestGet requestOwnerField (boolean value) {
      this.requestField("owner", value);
      return this;
    }
    public APIRequestGet requestParentalWarningTypeField () {
      return this.requestParentalWarningTypeField(true);
    }
    public APIRequestGet requestParentalWarningTypeField (boolean value) {
      this.requestField("parental_warning_type", value);
      return this;
    }
    public APIRequestGet requestSubtitleField () {
      return this.requestSubtitleField(true);
    }
    public APIRequestGet requestSubtitleField (boolean value) {
      this.requestField("subtitle", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestTitleWithFeaturedArtistsField () {
      return this.requestTitleWithFeaturedArtistsField(true);
    }
    public APIRequestGet requestTitleWithFeaturedArtistsField (boolean value) {
      this.requestField("title_with_featured_artists", value);
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

  public AudioAsset copyFrom(AudioAsset instance) {
    this.mAllDdexFeaturedArtists = instance.mAllDdexFeaturedArtists;
    this.mAllDdexMainArtists = instance.mAllDdexMainArtists;
    this.mAudioClusterId = instance.mAudioClusterId;
    this.mCoverImageSource = instance.mCoverImageSource;
    this.mDisplayArtist = instance.mDisplayArtist;
    this.mDownloadHdUrl = instance.mDownloadHdUrl;
    this.mDownloadSdUrl = instance.mDownloadSdUrl;
    this.mDurationInMs = instance.mDurationInMs;
    this.mFreeformGenre = instance.mFreeformGenre;
    this.mGrid = instance.mGrid;
    this.mId = instance.mId;
    this.mIsTest = instance.mIsTest;
    this.mOriginalReleaseDate = instance.mOriginalReleaseDate;
    this.mOwner = instance.mOwner;
    this.mParentalWarningType = instance.mParentalWarningType;
    this.mSubtitle = instance.mSubtitle;
    this.mTitle = instance.mTitle;
    this.mTitleWithFeaturedArtists = instance.mTitleWithFeaturedArtists;
    this.mUpc = instance.mUpc;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AudioAsset> getParser() {
    return new APIRequest.ResponseParser<AudioAsset>() {
      public APINodeList<AudioAsset> parseResponse(String response, APIContext context, APIRequest<AudioAsset> request, String header) throws MalformedResponseException {
        return AudioAsset.parseResponse(response, context, request, header);
      }
    };
  }
}
