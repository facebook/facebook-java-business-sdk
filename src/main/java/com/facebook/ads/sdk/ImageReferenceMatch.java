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
public class ImageReferenceMatch extends APINode {
  @SerializedName("conflicting_countries")
  private List<String> mConflictingCountries = null;
  @SerializedName("country_resolution_history")
  private List<Map<String, List<Object>>> mCountryResolutionHistory = null;
  @SerializedName("creation_time")
  private String mCreationTime = null;
  @SerializedName("current_conflict_resolved_countries")
  private List<Map<String, Object>> mCurrentConflictResolvedCountries = null;
  @SerializedName("displayed_match_state")
  private String mDisplayedMatchState = null;
  @SerializedName("dispute_form_data_entries_with_translations")
  private List<Object> mDisputeFormDataEntriesWithTranslations = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("match_state")
  private String mMatchState = null;
  @SerializedName("matched_reference_copyright")
  private ImageCopyright mMatchedReferenceCopyright = null;
  @SerializedName("matched_reference_owner")
  private Profile mMatchedReferenceOwner = null;
  @SerializedName("modification_history")
  private List<Object> mModificationHistory = null;
  @SerializedName("reference_copyright")
  private ImageCopyright mReferenceCopyright = null;
  @SerializedName("reference_owner")
  private Profile mReferenceOwner = null;
  @SerializedName("rejection_form_data_entries_with_translations")
  private List<Object> mRejectionFormDataEntriesWithTranslations = null;
  @SerializedName("resolution_reason")
  private String mResolutionReason = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  protected static Gson gson = null;

  ImageReferenceMatch() {
  }

  public ImageReferenceMatch(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ImageReferenceMatch(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ImageReferenceMatch fetch() throws APIException{
    ImageReferenceMatch newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ImageReferenceMatch fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ImageReferenceMatch> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ImageReferenceMatch fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ImageReferenceMatch> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ImageReferenceMatch> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ImageReferenceMatch>)(
      new APIRequest<ImageReferenceMatch>(context, "", "/", "GET", ImageReferenceMatch.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ImageReferenceMatch>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ImageReferenceMatch.getParser())
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
  public static ImageReferenceMatch loadJSON(String json, APIContext context, String header) {
    ImageReferenceMatch imageReferenceMatch = getGson().fromJson(json, ImageReferenceMatch.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(imageReferenceMatch.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    imageReferenceMatch.context = context;
    imageReferenceMatch.rawValue = json;
    imageReferenceMatch.header = header;
    return imageReferenceMatch;
  }

  public static APINodeList<ImageReferenceMatch> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ImageReferenceMatch> imageReferenceMatchs = new APINodeList<ImageReferenceMatch>(request, json, header);
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
          imageReferenceMatchs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return imageReferenceMatchs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                imageReferenceMatchs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            imageReferenceMatchs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              imageReferenceMatchs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              imageReferenceMatchs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  imageReferenceMatchs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              imageReferenceMatchs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return imageReferenceMatchs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              imageReferenceMatchs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return imageReferenceMatchs;
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
              imageReferenceMatchs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return imageReferenceMatchs;
          }

          // Sixth, check if it's pure JsonObject
          imageReferenceMatchs.clear();
          imageReferenceMatchs.add(loadJSON(json, context, header));
          return imageReferenceMatchs;
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


  public List<String> getFieldConflictingCountries() {
    return mConflictingCountries;
  }

  public List<Map<String, List<Object>>> getFieldCountryResolutionHistory() {
    return mCountryResolutionHistory;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public List<Map<String, Object>> getFieldCurrentConflictResolvedCountries() {
    return mCurrentConflictResolvedCountries;
  }

  public String getFieldDisplayedMatchState() {
    return mDisplayedMatchState;
  }

  public List<Object> getFieldDisputeFormDataEntriesWithTranslations() {
    return mDisputeFormDataEntriesWithTranslations;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldMatchState() {
    return mMatchState;
  }

  public ImageCopyright getFieldMatchedReferenceCopyright() {
    if (mMatchedReferenceCopyright != null) {
      mMatchedReferenceCopyright.context = getContext();
    }
    return mMatchedReferenceCopyright;
  }

  public Profile getFieldMatchedReferenceOwner() {
    if (mMatchedReferenceOwner != null) {
      mMatchedReferenceOwner.context = getContext();
    }
    return mMatchedReferenceOwner;
  }

  public List<Object> getFieldModificationHistory() {
    return mModificationHistory;
  }

  public ImageCopyright getFieldReferenceCopyright() {
    if (mReferenceCopyright != null) {
      mReferenceCopyright.context = getContext();
    }
    return mReferenceCopyright;
  }

  public Profile getFieldReferenceOwner() {
    if (mReferenceOwner != null) {
      mReferenceOwner.context = getContext();
    }
    return mReferenceOwner;
  }

  public List<Object> getFieldRejectionFormDataEntriesWithTranslations() {
    return mRejectionFormDataEntriesWithTranslations;
  }

  public String getFieldResolutionReason() {
    return mResolutionReason;
  }

  public String getFieldUpdateTime() {
    return mUpdateTime;
  }



  public static class APIRequestGet extends APIRequest<ImageReferenceMatch> {

    ImageReferenceMatch lastResponse = null;
    @Override
    public ImageReferenceMatch getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "conflicting_countries",
      "country_resolution_history",
      "creation_time",
      "current_conflict_resolved_countries",
      "displayed_match_state",
      "dispute_form_data_entries_with_translations",
      "expiration_time",
      "id",
      "match_state",
      "matched_reference_copyright",
      "matched_reference_owner",
      "modification_history",
      "reference_copyright",
      "reference_owner",
      "rejection_form_data_entries_with_translations",
      "resolution_reason",
      "update_time",
    };

    @Override
    public ImageReferenceMatch parseResponse(String response, String header) throws APIException {
      return ImageReferenceMatch.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public ImageReferenceMatch execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ImageReferenceMatch execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<ImageReferenceMatch> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ImageReferenceMatch> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, ImageReferenceMatch>() {
           public ImageReferenceMatch apply(ResponseWrapper result) {
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

    public APIRequestGet requestConflictingCountriesField () {
      return this.requestConflictingCountriesField(true);
    }
    public APIRequestGet requestConflictingCountriesField (boolean value) {
      this.requestField("conflicting_countries", value);
      return this;
    }
    public APIRequestGet requestCountryResolutionHistoryField () {
      return this.requestCountryResolutionHistoryField(true);
    }
    public APIRequestGet requestCountryResolutionHistoryField (boolean value) {
      this.requestField("country_resolution_history", value);
      return this;
    }
    public APIRequestGet requestCreationTimeField () {
      return this.requestCreationTimeField(true);
    }
    public APIRequestGet requestCreationTimeField (boolean value) {
      this.requestField("creation_time", value);
      return this;
    }
    public APIRequestGet requestCurrentConflictResolvedCountriesField () {
      return this.requestCurrentConflictResolvedCountriesField(true);
    }
    public APIRequestGet requestCurrentConflictResolvedCountriesField (boolean value) {
      this.requestField("current_conflict_resolved_countries", value);
      return this;
    }
    public APIRequestGet requestDisplayedMatchStateField () {
      return this.requestDisplayedMatchStateField(true);
    }
    public APIRequestGet requestDisplayedMatchStateField (boolean value) {
      this.requestField("displayed_match_state", value);
      return this;
    }
    public APIRequestGet requestDisputeFormDataEntriesWithTranslationsField () {
      return this.requestDisputeFormDataEntriesWithTranslationsField(true);
    }
    public APIRequestGet requestDisputeFormDataEntriesWithTranslationsField (boolean value) {
      this.requestField("dispute_form_data_entries_with_translations", value);
      return this;
    }
    public APIRequestGet requestExpirationTimeField () {
      return this.requestExpirationTimeField(true);
    }
    public APIRequestGet requestExpirationTimeField (boolean value) {
      this.requestField("expiration_time", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestMatchStateField () {
      return this.requestMatchStateField(true);
    }
    public APIRequestGet requestMatchStateField (boolean value) {
      this.requestField("match_state", value);
      return this;
    }
    public APIRequestGet requestMatchedReferenceCopyrightField () {
      return this.requestMatchedReferenceCopyrightField(true);
    }
    public APIRequestGet requestMatchedReferenceCopyrightField (boolean value) {
      this.requestField("matched_reference_copyright", value);
      return this;
    }
    public APIRequestGet requestMatchedReferenceOwnerField () {
      return this.requestMatchedReferenceOwnerField(true);
    }
    public APIRequestGet requestMatchedReferenceOwnerField (boolean value) {
      this.requestField("matched_reference_owner", value);
      return this;
    }
    public APIRequestGet requestModificationHistoryField () {
      return this.requestModificationHistoryField(true);
    }
    public APIRequestGet requestModificationHistoryField (boolean value) {
      this.requestField("modification_history", value);
      return this;
    }
    public APIRequestGet requestReferenceCopyrightField () {
      return this.requestReferenceCopyrightField(true);
    }
    public APIRequestGet requestReferenceCopyrightField (boolean value) {
      this.requestField("reference_copyright", value);
      return this;
    }
    public APIRequestGet requestReferenceOwnerField () {
      return this.requestReferenceOwnerField(true);
    }
    public APIRequestGet requestReferenceOwnerField (boolean value) {
      this.requestField("reference_owner", value);
      return this;
    }
    public APIRequestGet requestRejectionFormDataEntriesWithTranslationsField () {
      return this.requestRejectionFormDataEntriesWithTranslationsField(true);
    }
    public APIRequestGet requestRejectionFormDataEntriesWithTranslationsField (boolean value) {
      this.requestField("rejection_form_data_entries_with_translations", value);
      return this;
    }
    public APIRequestGet requestResolutionReasonField () {
      return this.requestResolutionReasonField(true);
    }
    public APIRequestGet requestResolutionReasonField (boolean value) {
      this.requestField("resolution_reason", value);
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

  public ImageReferenceMatch copyFrom(ImageReferenceMatch instance) {
    this.mConflictingCountries = instance.mConflictingCountries;
    this.mCountryResolutionHistory = instance.mCountryResolutionHistory;
    this.mCreationTime = instance.mCreationTime;
    this.mCurrentConflictResolvedCountries = instance.mCurrentConflictResolvedCountries;
    this.mDisplayedMatchState = instance.mDisplayedMatchState;
    this.mDisputeFormDataEntriesWithTranslations = instance.mDisputeFormDataEntriesWithTranslations;
    this.mExpirationTime = instance.mExpirationTime;
    this.mId = instance.mId;
    this.mMatchState = instance.mMatchState;
    this.mMatchedReferenceCopyright = instance.mMatchedReferenceCopyright;
    this.mMatchedReferenceOwner = instance.mMatchedReferenceOwner;
    this.mModificationHistory = instance.mModificationHistory;
    this.mReferenceCopyright = instance.mReferenceCopyright;
    this.mReferenceOwner = instance.mReferenceOwner;
    this.mRejectionFormDataEntriesWithTranslations = instance.mRejectionFormDataEntriesWithTranslations;
    this.mResolutionReason = instance.mResolutionReason;
    this.mUpdateTime = instance.mUpdateTime;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ImageReferenceMatch> getParser() {
    return new APIRequest.ResponseParser<ImageReferenceMatch>() {
      public APINodeList<ImageReferenceMatch> parseResponse(String response, APIContext context, APIRequest<ImageReferenceMatch> request, String header) throws MalformedResponseException {
        return ImageReferenceMatch.parseResponse(response, context, request, header);
      }
    };
  }
}
