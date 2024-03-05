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
public class ImageCopyright extends APINode {
  @SerializedName("artist")
  private String mArtist = null;
  @SerializedName("copyright_monitoring_status")
  private String mCopyrightMonitoringStatus = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("creator")
  private String mCreator = null;
  @SerializedName("custom_id")
  private String mCustomId = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("filename")
  private String mFilename = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("image")
  private Photo mImage = null;
  @SerializedName("matches_count")
  private Long mMatchesCount = null;
  @SerializedName("original_content_creation_date")
  private String mOriginalContentCreationDate = null;
  @SerializedName("ownership_countries")
  private VideoCopyrightGeoGate mOwnershipCountries = null;
  @SerializedName("tags")
  private List<String> mTags = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  protected static Gson gson = null;

  ImageCopyright() {
  }

  public ImageCopyright(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ImageCopyright(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ImageCopyright fetch() throws APIException{
    ImageCopyright newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ImageCopyright fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ImageCopyright> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ImageCopyright fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ImageCopyright> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ImageCopyright> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ImageCopyright>)(
      new APIRequest<ImageCopyright>(context, "", "/", "GET", ImageCopyright.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ImageCopyright>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ImageCopyright.getParser())
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
  public static ImageCopyright loadJSON(String json, APIContext context, String header) {
    ImageCopyright imageCopyright = getGson().fromJson(json, ImageCopyright.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(imageCopyright.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    imageCopyright.context = context;
    imageCopyright.rawValue = json;
    imageCopyright.header = header;
    return imageCopyright;
  }

  public static APINodeList<ImageCopyright> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ImageCopyright> imageCopyrights = new APINodeList<ImageCopyright>(request, json, header);
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
          imageCopyrights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return imageCopyrights;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                imageCopyrights.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            imageCopyrights.setPaging(previous, next);
            if (context.hasAppSecret()) {
              imageCopyrights.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              imageCopyrights.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  imageCopyrights.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              imageCopyrights.add(loadJSON(obj.toString(), context, header));
            }
          }
          return imageCopyrights;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              imageCopyrights.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return imageCopyrights;
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
              imageCopyrights.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return imageCopyrights;
          }

          // Sixth, check if it's pure JsonObject
          imageCopyrights.clear();
          imageCopyrights.add(loadJSON(json, context, header));
          return imageCopyrights;
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

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldArtist() {
    return mArtist;
  }

  public String getFieldCopyrightMonitoringStatus() {
    return mCopyrightMonitoringStatus;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public String getFieldCreator() {
    return mCreator;
  }

  public String getFieldCustomId() {
    return mCustomId;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public String getFieldFilename() {
    return mFilename;
  }

  public String getFieldId() {
    return mId;
  }

  public Photo getFieldImage() {
    if (mImage != null) {
      mImage.context = getContext();
    }
    return mImage;
  }

  public Long getFieldMatchesCount() {
    return mMatchesCount;
  }

  public String getFieldOriginalContentCreationDate() {
    return mOriginalContentCreationDate;
  }

  public VideoCopyrightGeoGate getFieldOwnershipCountries() {
    return mOwnershipCountries;
  }

  public List<String> getFieldTags() {
    return mTags;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldUpdateTime() {
    return mUpdateTime;
  }



  public static class APIRequestGet extends APIRequest<ImageCopyright> {

    ImageCopyright lastResponse = null;
    @Override
    public ImageCopyright getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "artist",
      "copyright_monitoring_status",
      "creation_time",
      "creator",
      "custom_id",
      "description",
      "filename",
      "id",
      "image",
      "matches_count",
      "original_content_creation_date",
      "ownership_countries",
      "tags",
      "title",
      "update_time",
    };

    @Override
    public ImageCopyright parseResponse(String response, String header) throws APIException {
      return ImageCopyright.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ImageCopyright execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ImageCopyright execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ImageCopyright> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ImageCopyright> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ImageCopyright>() {
           public ImageCopyright apply(ResponseWrapper result) {
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

    public APIRequestGet requestArtistField () {
      return this.requestArtistField(true);
    }
    public APIRequestGet requestArtistField (boolean value) {
      this.requestField("artist", value);
      return this;
    }
    public APIRequestGet requestCopyrightMonitoringStatusField () {
      return this.requestCopyrightMonitoringStatusField(true);
    }
    public APIRequestGet requestCopyrightMonitoringStatusField (boolean value) {
      this.requestField("copyright_monitoring_status", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCreatorField () {
      return this.requestCreatorField(true);
    }
    public APIRequestGet requestCreatorField (boolean value) {
      this.requestField("creator", value);
      return this;
    }
    public APIRequestGet requestCustomIdField () {
      return this.requestCustomIdField(true);
    }
    public APIRequestGet requestCustomIdField (boolean value) {
      this.requestField("custom_id", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestFilenameField () {
      return this.requestFilenameField(true);
    }
    public APIRequestGet requestFilenameField (boolean value) {
      this.requestField("filename", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestImageField () {
      return this.requestImageField(true);
    }
    public APIRequestGet requestImageField (boolean value) {
      this.requestField("image", value);
      return this;
    }
    public APIRequestGet requestMatchesCountField () {
      return this.requestMatchesCountField(true);
    }
    public APIRequestGet requestMatchesCountField (boolean value) {
      this.requestField("matches_count", value);
      return this;
    }
    public APIRequestGet requestOriginalContentCreationDateField () {
      return this.requestOriginalContentCreationDateField(true);
    }
    public APIRequestGet requestOriginalContentCreationDateField (boolean value) {
      this.requestField("original_content_creation_date", value);
      return this;
    }
    public APIRequestGet requestOwnershipCountriesField () {
      return this.requestOwnershipCountriesField(true);
    }
    public APIRequestGet requestOwnershipCountriesField (boolean value) {
      this.requestField("ownership_countries", value);
      return this;
    }
    public APIRequestGet requestTagsField () {
      return this.requestTagsField(true);
    }
    public APIRequestGet requestTagsField (boolean value) {
      this.requestField("tags", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestUpdateTimeField () {
      return this.requestUpdateTimeField(true);
    }
    public APIRequestGet requestUpdateTimeField (boolean value) {
      this.requestField("update_time", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<ImageCopyright> {

    ImageCopyright lastResponse = null;
    @Override
    public ImageCopyright getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "artist",
      "creator",
      "custom_id",
      "description",
      "geo_ownership",
      "original_content_creation_date",
      "title",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public ImageCopyright parseResponse(String response, String header) throws APIException {
      return ImageCopyright.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ImageCopyright execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ImageCopyright execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ImageCopyright> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ImageCopyright> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ImageCopyright>() {
           public ImageCopyright apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         },
         MoreExecutors.directExecutor()
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


    public APIRequestUpdate setArtist (String artist) {
      this.setParam("artist", artist);
      return this;
    }

    public APIRequestUpdate setCreator (String creator) {
      this.setParam("creator", creator);
      return this;
    }

    public APIRequestUpdate setCustomId (String customId) {
      this.setParam("custom_id", customId);
      return this;
    }

    public APIRequestUpdate setDescription (String description) {
      this.setParam("description", description);
      return this;
    }

    public APIRequestUpdate setGeoOwnership (List<ImageCopyright.EnumGeoOwnership> geoOwnership) {
      this.setParam("geo_ownership", geoOwnership);
      return this;
    }
    public APIRequestUpdate setGeoOwnership (String geoOwnership) {
      this.setParam("geo_ownership", geoOwnership);
      return this;
    }

    public APIRequestUpdate setOriginalContentCreationDate (Long originalContentCreationDate) {
      this.setParam("original_content_creation_date", originalContentCreationDate);
      return this;
    }
    public APIRequestUpdate setOriginalContentCreationDate (String originalContentCreationDate) {
      this.setParam("original_content_creation_date", originalContentCreationDate);
      return this;
    }

    public APIRequestUpdate setTitle (String title) {
      this.setParam("title", title);
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

  public static enum EnumGeoOwnership {
      @SerializedName("AD")
      VALUE_AD("AD"),
      @SerializedName("AE")
      VALUE_AE("AE"),
      @SerializedName("AF")
      VALUE_AF("AF"),
      @SerializedName("AG")
      VALUE_AG("AG"),
      @SerializedName("AI")
      VALUE_AI("AI"),
      @SerializedName("AL")
      VALUE_AL("AL"),
      @SerializedName("AM")
      VALUE_AM("AM"),
      @SerializedName("AN")
      VALUE_AN("AN"),
      @SerializedName("AO")
      VALUE_AO("AO"),
      @SerializedName("AQ")
      VALUE_AQ("AQ"),
      @SerializedName("AR")
      VALUE_AR("AR"),
      @SerializedName("AS")
      VALUE_AS("AS"),
      @SerializedName("AT")
      VALUE_AT("AT"),
      @SerializedName("AU")
      VALUE_AU("AU"),
      @SerializedName("AW")
      VALUE_AW("AW"),
      @SerializedName("AX")
      VALUE_AX("AX"),
      @SerializedName("AZ")
      VALUE_AZ("AZ"),
      @SerializedName("BA")
      VALUE_BA("BA"),
      @SerializedName("BB")
      VALUE_BB("BB"),
      @SerializedName("BD")
      VALUE_BD("BD"),
      @SerializedName("BE")
      VALUE_BE("BE"),
      @SerializedName("BF")
      VALUE_BF("BF"),
      @SerializedName("BG")
      VALUE_BG("BG"),
      @SerializedName("BH")
      VALUE_BH("BH"),
      @SerializedName("BI")
      VALUE_BI("BI"),
      @SerializedName("BJ")
      VALUE_BJ("BJ"),
      @SerializedName("BL")
      VALUE_BL("BL"),
      @SerializedName("BM")
      VALUE_BM("BM"),
      @SerializedName("BN")
      VALUE_BN("BN"),
      @SerializedName("BO")
      VALUE_BO("BO"),
      @SerializedName("BQ")
      VALUE_BQ("BQ"),
      @SerializedName("BR")
      VALUE_BR("BR"),
      @SerializedName("BS")
      VALUE_BS("BS"),
      @SerializedName("BT")
      VALUE_BT("BT"),
      @SerializedName("BV")
      VALUE_BV("BV"),
      @SerializedName("BW")
      VALUE_BW("BW"),
      @SerializedName("BY")
      VALUE_BY("BY"),
      @SerializedName("BZ")
      VALUE_BZ("BZ"),
      @SerializedName("CA")
      VALUE_CA("CA"),
      @SerializedName("CC")
      VALUE_CC("CC"),
      @SerializedName("CD")
      VALUE_CD("CD"),
      @SerializedName("CF")
      VALUE_CF("CF"),
      @SerializedName("CG")
      VALUE_CG("CG"),
      @SerializedName("CH")
      VALUE_CH("CH"),
      @SerializedName("CI")
      VALUE_CI("CI"),
      @SerializedName("CK")
      VALUE_CK("CK"),
      @SerializedName("CL")
      VALUE_CL("CL"),
      @SerializedName("CM")
      VALUE_CM("CM"),
      @SerializedName("CN")
      VALUE_CN("CN"),
      @SerializedName("CO")
      VALUE_CO("CO"),
      @SerializedName("CR")
      VALUE_CR("CR"),
      @SerializedName("CU")
      VALUE_CU("CU"),
      @SerializedName("CV")
      VALUE_CV("CV"),
      @SerializedName("CW")
      VALUE_CW("CW"),
      @SerializedName("CX")
      VALUE_CX("CX"),
      @SerializedName("CY")
      VALUE_CY("CY"),
      @SerializedName("CZ")
      VALUE_CZ("CZ"),
      @SerializedName("DE")
      VALUE_DE("DE"),
      @SerializedName("DJ")
      VALUE_DJ("DJ"),
      @SerializedName("DK")
      VALUE_DK("DK"),
      @SerializedName("DM")
      VALUE_DM("DM"),
      @SerializedName("DO")
      VALUE_DO("DO"),
      @SerializedName("DZ")
      VALUE_DZ("DZ"),
      @SerializedName("EC")
      VALUE_EC("EC"),
      @SerializedName("EE")
      VALUE_EE("EE"),
      @SerializedName("EG")
      VALUE_EG("EG"),
      @SerializedName("EH")
      VALUE_EH("EH"),
      @SerializedName("ER")
      VALUE_ER("ER"),
      @SerializedName("ES")
      VALUE_ES("ES"),
      @SerializedName("ET")
      VALUE_ET("ET"),
      @SerializedName("FI")
      VALUE_FI("FI"),
      @SerializedName("FJ")
      VALUE_FJ("FJ"),
      @SerializedName("FK")
      VALUE_FK("FK"),
      @SerializedName("FM")
      VALUE_FM("FM"),
      @SerializedName("FO")
      VALUE_FO("FO"),
      @SerializedName("FR")
      VALUE_FR("FR"),
      @SerializedName("GA")
      VALUE_GA("GA"),
      @SerializedName("GB")
      VALUE_GB("GB"),
      @SerializedName("GD")
      VALUE_GD("GD"),
      @SerializedName("GE")
      VALUE_GE("GE"),
      @SerializedName("GF")
      VALUE_GF("GF"),
      @SerializedName("GG")
      VALUE_GG("GG"),
      @SerializedName("GH")
      VALUE_GH("GH"),
      @SerializedName("GI")
      VALUE_GI("GI"),
      @SerializedName("GL")
      VALUE_GL("GL"),
      @SerializedName("GM")
      VALUE_GM("GM"),
      @SerializedName("GN")
      VALUE_GN("GN"),
      @SerializedName("GP")
      VALUE_GP("GP"),
      @SerializedName("GQ")
      VALUE_GQ("GQ"),
      @SerializedName("GR")
      VALUE_GR("GR"),
      @SerializedName("GS")
      VALUE_GS("GS"),
      @SerializedName("GT")
      VALUE_GT("GT"),
      @SerializedName("GU")
      VALUE_GU("GU"),
      @SerializedName("GW")
      VALUE_GW("GW"),
      @SerializedName("GY")
      VALUE_GY("GY"),
      @SerializedName("HK")
      VALUE_HK("HK"),
      @SerializedName("HM")
      VALUE_HM("HM"),
      @SerializedName("HN")
      VALUE_HN("HN"),
      @SerializedName("HR")
      VALUE_HR("HR"),
      @SerializedName("HT")
      VALUE_HT("HT"),
      @SerializedName("HU")
      VALUE_HU("HU"),
      @SerializedName("ID")
      VALUE_ID("ID"),
      @SerializedName("IE")
      VALUE_IE("IE"),
      @SerializedName("IL")
      VALUE_IL("IL"),
      @SerializedName("IM")
      VALUE_IM("IM"),
      @SerializedName("IN")
      VALUE_IN("IN"),
      @SerializedName("IO")
      VALUE_IO("IO"),
      @SerializedName("IQ")
      VALUE_IQ("IQ"),
      @SerializedName("IR")
      VALUE_IR("IR"),
      @SerializedName("IS")
      VALUE_IS("IS"),
      @SerializedName("IT")
      VALUE_IT("IT"),
      @SerializedName("JE")
      VALUE_JE("JE"),
      @SerializedName("JM")
      VALUE_JM("JM"),
      @SerializedName("JO")
      VALUE_JO("JO"),
      @SerializedName("JP")
      VALUE_JP("JP"),
      @SerializedName("KE")
      VALUE_KE("KE"),
      @SerializedName("KG")
      VALUE_KG("KG"),
      @SerializedName("KH")
      VALUE_KH("KH"),
      @SerializedName("KI")
      VALUE_KI("KI"),
      @SerializedName("KM")
      VALUE_KM("KM"),
      @SerializedName("KN")
      VALUE_KN("KN"),
      @SerializedName("KP")
      VALUE_KP("KP"),
      @SerializedName("KR")
      VALUE_KR("KR"),
      @SerializedName("KW")
      VALUE_KW("KW"),
      @SerializedName("KY")
      VALUE_KY("KY"),
      @SerializedName("KZ")
      VALUE_KZ("KZ"),
      @SerializedName("LA")
      VALUE_LA("LA"),
      @SerializedName("LB")
      VALUE_LB("LB"),
      @SerializedName("LC")
      VALUE_LC("LC"),
      @SerializedName("LI")
      VALUE_LI("LI"),
      @SerializedName("LK")
      VALUE_LK("LK"),
      @SerializedName("LR")
      VALUE_LR("LR"),
      @SerializedName("LS")
      VALUE_LS("LS"),
      @SerializedName("LT")
      VALUE_LT("LT"),
      @SerializedName("LU")
      VALUE_LU("LU"),
      @SerializedName("LV")
      VALUE_LV("LV"),
      @SerializedName("LY")
      VALUE_LY("LY"),
      @SerializedName("MA")
      VALUE_MA("MA"),
      @SerializedName("MC")
      VALUE_MC("MC"),
      @SerializedName("MD")
      VALUE_MD("MD"),
      @SerializedName("ME")
      VALUE_ME("ME"),
      @SerializedName("MF")
      VALUE_MF("MF"),
      @SerializedName("MG")
      VALUE_MG("MG"),
      @SerializedName("MH")
      VALUE_MH("MH"),
      @SerializedName("MK")
      VALUE_MK("MK"),
      @SerializedName("ML")
      VALUE_ML("ML"),
      @SerializedName("MM")
      VALUE_MM("MM"),
      @SerializedName("MN")
      VALUE_MN("MN"),
      @SerializedName("MO")
      VALUE_MO("MO"),
      @SerializedName("MP")
      VALUE_MP("MP"),
      @SerializedName("MQ")
      VALUE_MQ("MQ"),
      @SerializedName("MR")
      VALUE_MR("MR"),
      @SerializedName("MS")
      VALUE_MS("MS"),
      @SerializedName("MT")
      VALUE_MT("MT"),
      @SerializedName("MU")
      VALUE_MU("MU"),
      @SerializedName("MV")
      VALUE_MV("MV"),
      @SerializedName("MW")
      VALUE_MW("MW"),
      @SerializedName("MX")
      VALUE_MX("MX"),
      @SerializedName("MY")
      VALUE_MY("MY"),
      @SerializedName("MZ")
      VALUE_MZ("MZ"),
      @SerializedName("NA")
      VALUE_NA("NA"),
      @SerializedName("NC")
      VALUE_NC("NC"),
      @SerializedName("NE")
      VALUE_NE("NE"),
      @SerializedName("NF")
      VALUE_NF("NF"),
      @SerializedName("NG")
      VALUE_NG("NG"),
      @SerializedName("NI")
      VALUE_NI("NI"),
      @SerializedName("NL")
      VALUE_NL("NL"),
      @SerializedName("NO")
      VALUE_NO("NO"),
      @SerializedName("NP")
      VALUE_NP("NP"),
      @SerializedName("NR")
      VALUE_NR("NR"),
      @SerializedName("NU")
      VALUE_NU("NU"),
      @SerializedName("NZ")
      VALUE_NZ("NZ"),
      @SerializedName("OM")
      VALUE_OM("OM"),
      @SerializedName("PA")
      VALUE_PA("PA"),
      @SerializedName("PE")
      VALUE_PE("PE"),
      @SerializedName("PF")
      VALUE_PF("PF"),
      @SerializedName("PG")
      VALUE_PG("PG"),
      @SerializedName("PH")
      VALUE_PH("PH"),
      @SerializedName("PK")
      VALUE_PK("PK"),
      @SerializedName("PL")
      VALUE_PL("PL"),
      @SerializedName("PM")
      VALUE_PM("PM"),
      @SerializedName("PN")
      VALUE_PN("PN"),
      @SerializedName("PR")
      VALUE_PR("PR"),
      @SerializedName("PS")
      VALUE_PS("PS"),
      @SerializedName("PT")
      VALUE_PT("PT"),
      @SerializedName("PW")
      VALUE_PW("PW"),
      @SerializedName("PY")
      VALUE_PY("PY"),
      @SerializedName("QA")
      VALUE_QA("QA"),
      @SerializedName("RE")
      VALUE_RE("RE"),
      @SerializedName("RO")
      VALUE_RO("RO"),
      @SerializedName("RS")
      VALUE_RS("RS"),
      @SerializedName("RU")
      VALUE_RU("RU"),
      @SerializedName("RW")
      VALUE_RW("RW"),
      @SerializedName("SA")
      VALUE_SA("SA"),
      @SerializedName("SB")
      VALUE_SB("SB"),
      @SerializedName("SC")
      VALUE_SC("SC"),
      @SerializedName("SD")
      VALUE_SD("SD"),
      @SerializedName("SE")
      VALUE_SE("SE"),
      @SerializedName("SG")
      VALUE_SG("SG"),
      @SerializedName("SH")
      VALUE_SH("SH"),
      @SerializedName("SI")
      VALUE_SI("SI"),
      @SerializedName("SJ")
      VALUE_SJ("SJ"),
      @SerializedName("SK")
      VALUE_SK("SK"),
      @SerializedName("SL")
      VALUE_SL("SL"),
      @SerializedName("SM")
      VALUE_SM("SM"),
      @SerializedName("SN")
      VALUE_SN("SN"),
      @SerializedName("SO")
      VALUE_SO("SO"),
      @SerializedName("SR")
      VALUE_SR("SR"),
      @SerializedName("SS")
      VALUE_SS("SS"),
      @SerializedName("ST")
      VALUE_ST("ST"),
      @SerializedName("SV")
      VALUE_SV("SV"),
      @SerializedName("SX")
      VALUE_SX("SX"),
      @SerializedName("SY")
      VALUE_SY("SY"),
      @SerializedName("SZ")
      VALUE_SZ("SZ"),
      @SerializedName("TC")
      VALUE_TC("TC"),
      @SerializedName("TD")
      VALUE_TD("TD"),
      @SerializedName("TF")
      VALUE_TF("TF"),
      @SerializedName("TG")
      VALUE_TG("TG"),
      @SerializedName("TH")
      VALUE_TH("TH"),
      @SerializedName("TJ")
      VALUE_TJ("TJ"),
      @SerializedName("TK")
      VALUE_TK("TK"),
      @SerializedName("TL")
      VALUE_TL("TL"),
      @SerializedName("TM")
      VALUE_TM("TM"),
      @SerializedName("TN")
      VALUE_TN("TN"),
      @SerializedName("TO")
      VALUE_TO("TO"),
      @SerializedName("TP")
      VALUE_TP("TP"),
      @SerializedName("TR")
      VALUE_TR("TR"),
      @SerializedName("TT")
      VALUE_TT("TT"),
      @SerializedName("TV")
      VALUE_TV("TV"),
      @SerializedName("TW")
      VALUE_TW("TW"),
      @SerializedName("TZ")
      VALUE_TZ("TZ"),
      @SerializedName("UA")
      VALUE_UA("UA"),
      @SerializedName("UG")
      VALUE_UG("UG"),
      @SerializedName("UM")
      VALUE_UM("UM"),
      @SerializedName("US")
      VALUE_US("US"),
      @SerializedName("UY")
      VALUE_UY("UY"),
      @SerializedName("UZ")
      VALUE_UZ("UZ"),
      @SerializedName("VA")
      VALUE_VA("VA"),
      @SerializedName("VC")
      VALUE_VC("VC"),
      @SerializedName("VE")
      VALUE_VE("VE"),
      @SerializedName("VG")
      VALUE_VG("VG"),
      @SerializedName("VI")
      VALUE_VI("VI"),
      @SerializedName("VN")
      VALUE_VN("VN"),
      @SerializedName("VU")
      VALUE_VU("VU"),
      @SerializedName("WF")
      VALUE_WF("WF"),
      @SerializedName("WS")
      VALUE_WS("WS"),
      @SerializedName("XK")
      VALUE_XK("XK"),
      @SerializedName("YE")
      VALUE_YE("YE"),
      @SerializedName("YT")
      VALUE_YT("YT"),
      @SerializedName("ZA")
      VALUE_ZA("ZA"),
      @SerializedName("ZM")
      VALUE_ZM("ZM"),
      @SerializedName("ZW")
      VALUE_ZW("ZW"),
      ;

      private String value;

      private EnumGeoOwnership(String value) {
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

  public ImageCopyright copyFrom(ImageCopyright instance) {
    this.mArtist = instance.mArtist;
    this.mCopyrightMonitoringStatus = instance.mCopyrightMonitoringStatus;
    this.mCreationTime = instance.mCreationTime;
    this.mCreator = instance.mCreator;
    this.mCustomId = instance.mCustomId;
    this.mDescription = instance.mDescription;
    this.mFilename = instance.mFilename;
    this.mId = instance.mId;
    this.mImage = instance.mImage;
    this.mMatchesCount = instance.mMatchesCount;
    this.mOriginalContentCreationDate = instance.mOriginalContentCreationDate;
    this.mOwnershipCountries = instance.mOwnershipCountries;
    this.mTags = instance.mTags;
    this.mTitle = instance.mTitle;
    this.mUpdateTime = instance.mUpdateTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ImageCopyright> getParser() {
    return new APIRequest.ResponseParser<ImageCopyright>() {
      public APINodeList<ImageCopyright> parseResponse(String response, APIContext context, APIRequest<ImageCopyright> request, String header) throws MalformedResponseException {
        return ImageCopyright.parseResponse(response, context, request, header);
      }
    };
  }
}
