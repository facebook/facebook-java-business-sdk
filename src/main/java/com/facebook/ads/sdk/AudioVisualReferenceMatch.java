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
public class AudioVisualReferenceMatch extends APINode {
  @SerializedName("audio_conflicting_segments")
  private List<Object> mAudioConflictingSegments = null;
  @SerializedName("audio_current_conflict_resolved_segments")
  private List<Object> mAudioCurrentConflictResolvedSegments = null;
  @SerializedName("audio_segment_resolution_history")
  private List<Object> mAudioSegmentResolutionHistory = null;
  @SerializedName("conflict_type")
  private String mConflictType = null;
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
  @SerializedName("is_disputable")
  private Boolean mIsDisputable = null;
  @SerializedName("match_state")
  private String mMatchState = null;
  @SerializedName("matched_overlap_percentage")
  private Double mMatchedOverlapPercentage = null;
  @SerializedName("matched_owner_match_duration_in_sec")
  private Double mMatchedOwnerMatchDurationInSec = null;
  @SerializedName("matched_reference_owner")
  private Profile mMatchedReferenceOwner = null;
  @SerializedName("modification_history")
  private List<Object> mModificationHistory = null;
  @SerializedName("num_matches_on_matched_side")
  private Long mNumMatchesOnMatchedSide = null;
  @SerializedName("num_matches_on_ref_side")
  private Long mNumMatchesOnRefSide = null;
  @SerializedName("ref_owner_match_duration_in_sec")
  private Double mRefOwnerMatchDurationInSec = null;
  @SerializedName("reference_overlap_percentage")
  private Double mReferenceOverlapPercentage = null;
  @SerializedName("reference_owner")
  private Profile mReferenceOwner = null;
  @SerializedName("rejection_form_data_entries_with_translations")
  private List<Object> mRejectionFormDataEntriesWithTranslations = null;
  @SerializedName("resolution_details")
  private String mResolutionDetails = null;
  @SerializedName("resolution_reason")
  private String mResolutionReason = null;
  @SerializedName("update_time")
  private String mUpdateTime = null;
  @SerializedName("views_on_matched_side")
  private Long mViewsOnMatchedSide = null;
  @SerializedName("visual_conflicting_segments")
  private List<Object> mVisualConflictingSegments = null;
  @SerializedName("visual_current_conflict_resolved_segments")
  private List<Object> mVisualCurrentConflictResolvedSegments = null;
  @SerializedName("visual_segment_resolution_history")
  private List<Object> mVisualSegmentResolutionHistory = null;
  protected static Gson gson = null;

  public AudioVisualReferenceMatch() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AudioVisualReferenceMatch loadJSON(String json, APIContext context, String header) {
    AudioVisualReferenceMatch audioVisualReferenceMatch = getGson().fromJson(json, AudioVisualReferenceMatch.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(audioVisualReferenceMatch.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    audioVisualReferenceMatch.context = context;
    audioVisualReferenceMatch.rawValue = json;
    audioVisualReferenceMatch.header = header;
    return audioVisualReferenceMatch;
  }

  public static APINodeList<AudioVisualReferenceMatch> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AudioVisualReferenceMatch> audioVisualReferenceMatchs = new APINodeList<AudioVisualReferenceMatch>(request, json, header);
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
          audioVisualReferenceMatchs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return audioVisualReferenceMatchs;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                audioVisualReferenceMatchs.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            audioVisualReferenceMatchs.setPaging(previous, next);
            if (context.hasAppSecret()) {
              audioVisualReferenceMatchs.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              audioVisualReferenceMatchs.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  audioVisualReferenceMatchs.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              audioVisualReferenceMatchs.add(loadJSON(obj.toString(), context, header));
            }
          }
          return audioVisualReferenceMatchs;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              audioVisualReferenceMatchs.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return audioVisualReferenceMatchs;
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
              audioVisualReferenceMatchs.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return audioVisualReferenceMatchs;
          }

          // Sixth, check if it's pure JsonObject
          audioVisualReferenceMatchs.clear();
          audioVisualReferenceMatchs.add(loadJSON(json, context, header));
          return audioVisualReferenceMatchs;
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


  public List<Object> getFieldAudioConflictingSegments() {
    return mAudioConflictingSegments;
  }

  public AudioVisualReferenceMatch setFieldAudioConflictingSegments(List<Object> value) {
    this.mAudioConflictingSegments = value;
    return this;
  }

  public List<Object> getFieldAudioCurrentConflictResolvedSegments() {
    return mAudioCurrentConflictResolvedSegments;
  }

  public AudioVisualReferenceMatch setFieldAudioCurrentConflictResolvedSegments(List<Object> value) {
    this.mAudioCurrentConflictResolvedSegments = value;
    return this;
  }

  public List<Object> getFieldAudioSegmentResolutionHistory() {
    return mAudioSegmentResolutionHistory;
  }

  public AudioVisualReferenceMatch setFieldAudioSegmentResolutionHistory(List<Object> value) {
    this.mAudioSegmentResolutionHistory = value;
    return this;
  }

  public String getFieldConflictType() {
    return mConflictType;
  }

  public AudioVisualReferenceMatch setFieldConflictType(String value) {
    this.mConflictType = value;
    return this;
  }

  public List<String> getFieldConflictingCountries() {
    return mConflictingCountries;
  }

  public AudioVisualReferenceMatch setFieldConflictingCountries(List<String> value) {
    this.mConflictingCountries = value;
    return this;
  }

  public List<Map<String, List<Object>>> getFieldCountryResolutionHistory() {
    return mCountryResolutionHistory;
  }

  public AudioVisualReferenceMatch setFieldCountryResolutionHistory(List<Map<String, List<Object>>> value) {
    this.mCountryResolutionHistory = value;
    return this;
  }

  public String getFieldCreationTime() {
    return mCreationTime;
  }

  public AudioVisualReferenceMatch setFieldCreationTime(String value) {
    this.mCreationTime = value;
    return this;
  }

  public List<Map<String, Object>> getFieldCurrentConflictResolvedCountries() {
    return mCurrentConflictResolvedCountries;
  }

  public AudioVisualReferenceMatch setFieldCurrentConflictResolvedCountries(List<Map<String, Object>> value) {
    this.mCurrentConflictResolvedCountries = value;
    return this;
  }

  public String getFieldDisplayedMatchState() {
    return mDisplayedMatchState;
  }

  public AudioVisualReferenceMatch setFieldDisplayedMatchState(String value) {
    this.mDisplayedMatchState = value;
    return this;
  }

  public List<Object> getFieldDisputeFormDataEntriesWithTranslations() {
    return mDisputeFormDataEntriesWithTranslations;
  }

  public AudioVisualReferenceMatch setFieldDisputeFormDataEntriesWithTranslations(List<Object> value) {
    this.mDisputeFormDataEntriesWithTranslations = value;
    return this;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public AudioVisualReferenceMatch setFieldExpirationTime(String value) {
    this.mExpirationTime = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AudioVisualReferenceMatch setFieldId(String value) {
    this.mId = value;
    return this;
  }

  public Boolean getFieldIsDisputable() {
    return mIsDisputable;
  }

  public AudioVisualReferenceMatch setFieldIsDisputable(Boolean value) {
    this.mIsDisputable = value;
    return this;
  }

  public String getFieldMatchState() {
    return mMatchState;
  }

  public AudioVisualReferenceMatch setFieldMatchState(String value) {
    this.mMatchState = value;
    return this;
  }

  public Double getFieldMatchedOverlapPercentage() {
    return mMatchedOverlapPercentage;
  }

  public AudioVisualReferenceMatch setFieldMatchedOverlapPercentage(Double value) {
    this.mMatchedOverlapPercentage = value;
    return this;
  }

  public Double getFieldMatchedOwnerMatchDurationInSec() {
    return mMatchedOwnerMatchDurationInSec;
  }

  public AudioVisualReferenceMatch setFieldMatchedOwnerMatchDurationInSec(Double value) {
    this.mMatchedOwnerMatchDurationInSec = value;
    return this;
  }

  public Profile getFieldMatchedReferenceOwner() {
    if (mMatchedReferenceOwner != null) {
      mMatchedReferenceOwner.context = getContext();
    }
    return mMatchedReferenceOwner;
  }

  public AudioVisualReferenceMatch setFieldMatchedReferenceOwner(Profile value) {
    this.mMatchedReferenceOwner = value;
    return this;
  }

  public AudioVisualReferenceMatch setFieldMatchedReferenceOwner(String value) {
    Type type = new TypeToken<Profile>(){}.getType();
    this.mMatchedReferenceOwner = Profile.getGson().fromJson(value, type);
    return this;
  }
  public List<Object> getFieldModificationHistory() {
    return mModificationHistory;
  }

  public AudioVisualReferenceMatch setFieldModificationHistory(List<Object> value) {
    this.mModificationHistory = value;
    return this;
  }

  public Long getFieldNumMatchesOnMatchedSide() {
    return mNumMatchesOnMatchedSide;
  }

  public AudioVisualReferenceMatch setFieldNumMatchesOnMatchedSide(Long value) {
    this.mNumMatchesOnMatchedSide = value;
    return this;
  }

  public Long getFieldNumMatchesOnRefSide() {
    return mNumMatchesOnRefSide;
  }

  public AudioVisualReferenceMatch setFieldNumMatchesOnRefSide(Long value) {
    this.mNumMatchesOnRefSide = value;
    return this;
  }

  public Double getFieldRefOwnerMatchDurationInSec() {
    return mRefOwnerMatchDurationInSec;
  }

  public AudioVisualReferenceMatch setFieldRefOwnerMatchDurationInSec(Double value) {
    this.mRefOwnerMatchDurationInSec = value;
    return this;
  }

  public Double getFieldReferenceOverlapPercentage() {
    return mReferenceOverlapPercentage;
  }

  public AudioVisualReferenceMatch setFieldReferenceOverlapPercentage(Double value) {
    this.mReferenceOverlapPercentage = value;
    return this;
  }

  public Profile getFieldReferenceOwner() {
    if (mReferenceOwner != null) {
      mReferenceOwner.context = getContext();
    }
    return mReferenceOwner;
  }

  public AudioVisualReferenceMatch setFieldReferenceOwner(Profile value) {
    this.mReferenceOwner = value;
    return this;
  }

  public AudioVisualReferenceMatch setFieldReferenceOwner(String value) {
    Type type = new TypeToken<Profile>(){}.getType();
    this.mReferenceOwner = Profile.getGson().fromJson(value, type);
    return this;
  }
  public List<Object> getFieldRejectionFormDataEntriesWithTranslations() {
    return mRejectionFormDataEntriesWithTranslations;
  }

  public AudioVisualReferenceMatch setFieldRejectionFormDataEntriesWithTranslations(List<Object> value) {
    this.mRejectionFormDataEntriesWithTranslations = value;
    return this;
  }

  public String getFieldResolutionDetails() {
    return mResolutionDetails;
  }

  public AudioVisualReferenceMatch setFieldResolutionDetails(String value) {
    this.mResolutionDetails = value;
    return this;
  }

  public String getFieldResolutionReason() {
    return mResolutionReason;
  }

  public AudioVisualReferenceMatch setFieldResolutionReason(String value) {
    this.mResolutionReason = value;
    return this;
  }

  public String getFieldUpdateTime() {
    return mUpdateTime;
  }

  public AudioVisualReferenceMatch setFieldUpdateTime(String value) {
    this.mUpdateTime = value;
    return this;
  }

  public Long getFieldViewsOnMatchedSide() {
    return mViewsOnMatchedSide;
  }

  public AudioVisualReferenceMatch setFieldViewsOnMatchedSide(Long value) {
    this.mViewsOnMatchedSide = value;
    return this;
  }

  public List<Object> getFieldVisualConflictingSegments() {
    return mVisualConflictingSegments;
  }

  public AudioVisualReferenceMatch setFieldVisualConflictingSegments(List<Object> value) {
    this.mVisualConflictingSegments = value;
    return this;
  }

  public List<Object> getFieldVisualCurrentConflictResolvedSegments() {
    return mVisualCurrentConflictResolvedSegments;
  }

  public AudioVisualReferenceMatch setFieldVisualCurrentConflictResolvedSegments(List<Object> value) {
    this.mVisualCurrentConflictResolvedSegments = value;
    return this;
  }

  public List<Object> getFieldVisualSegmentResolutionHistory() {
    return mVisualSegmentResolutionHistory;
  }

  public AudioVisualReferenceMatch setFieldVisualSegmentResolutionHistory(List<Object> value) {
    this.mVisualSegmentResolutionHistory = value;
    return this;
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

  public AudioVisualReferenceMatch copyFrom(AudioVisualReferenceMatch instance) {
    this.mAudioConflictingSegments = instance.mAudioConflictingSegments;
    this.mAudioCurrentConflictResolvedSegments = instance.mAudioCurrentConflictResolvedSegments;
    this.mAudioSegmentResolutionHistory = instance.mAudioSegmentResolutionHistory;
    this.mConflictType = instance.mConflictType;
    this.mConflictingCountries = instance.mConflictingCountries;
    this.mCountryResolutionHistory = instance.mCountryResolutionHistory;
    this.mCreationTime = instance.mCreationTime;
    this.mCurrentConflictResolvedCountries = instance.mCurrentConflictResolvedCountries;
    this.mDisplayedMatchState = instance.mDisplayedMatchState;
    this.mDisputeFormDataEntriesWithTranslations = instance.mDisputeFormDataEntriesWithTranslations;
    this.mExpirationTime = instance.mExpirationTime;
    this.mId = instance.mId;
    this.mIsDisputable = instance.mIsDisputable;
    this.mMatchState = instance.mMatchState;
    this.mMatchedOverlapPercentage = instance.mMatchedOverlapPercentage;
    this.mMatchedOwnerMatchDurationInSec = instance.mMatchedOwnerMatchDurationInSec;
    this.mMatchedReferenceOwner = instance.mMatchedReferenceOwner;
    this.mModificationHistory = instance.mModificationHistory;
    this.mNumMatchesOnMatchedSide = instance.mNumMatchesOnMatchedSide;
    this.mNumMatchesOnRefSide = instance.mNumMatchesOnRefSide;
    this.mRefOwnerMatchDurationInSec = instance.mRefOwnerMatchDurationInSec;
    this.mReferenceOverlapPercentage = instance.mReferenceOverlapPercentage;
    this.mReferenceOwner = instance.mReferenceOwner;
    this.mRejectionFormDataEntriesWithTranslations = instance.mRejectionFormDataEntriesWithTranslations;
    this.mResolutionDetails = instance.mResolutionDetails;
    this.mResolutionReason = instance.mResolutionReason;
    this.mUpdateTime = instance.mUpdateTime;
    this.mViewsOnMatchedSide = instance.mViewsOnMatchedSide;
    this.mVisualConflictingSegments = instance.mVisualConflictingSegments;
    this.mVisualCurrentConflictResolvedSegments = instance.mVisualCurrentConflictResolvedSegments;
    this.mVisualSegmentResolutionHistory = instance.mVisualSegmentResolutionHistory;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AudioVisualReferenceMatch> getParser() {
    return new APIRequest.ResponseParser<AudioVisualReferenceMatch>() {
      public APINodeList<AudioVisualReferenceMatch> parseResponse(String response, APIContext context, APIRequest<AudioVisualReferenceMatch> request, String header) throws MalformedResponseException {
        return AudioVisualReferenceMatch.parseResponse(response, context, request, header);
      }
    };
  }
}
