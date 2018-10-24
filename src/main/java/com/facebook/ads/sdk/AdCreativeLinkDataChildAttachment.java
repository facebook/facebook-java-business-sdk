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
public class AdCreativeLinkDataChildAttachment extends APINode {
  @SerializedName("call_to_action")
  private AdCreativeLinkDataCallToAction mCallToAction = null;
  @SerializedName("caption")
  private String mCaption = null;
  @SerializedName("description")
  private String mDescription = null;
  @SerializedName("image_crops")
  private AdsImageCrops mImageCrops = null;
  @SerializedName("image_hash")
  private String mImageHash = null;
  @SerializedName("link")
  private String mLink = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("picture")
  private String mPicture = null;
  @SerializedName("place_data")
  private AdCreativePlaceData mPlaceData = null;
  @SerializedName("referral_id")
  private String mReferralId = null;
  @SerializedName("static_card")
  private Boolean mStaticCard = null;
  @SerializedName("video_id")
  private String mVideoId = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdCreativeLinkDataChildAttachment() {
  }

  public AdCreativeLinkDataChildAttachment(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdCreativeLinkDataChildAttachment(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdCreativeLinkDataChildAttachment fetch() throws APIException{
    AdCreativeLinkDataChildAttachment newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdCreativeLinkDataChildAttachment fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdCreativeLinkDataChildAttachment> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdCreativeLinkDataChildAttachment fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdCreativeLinkDataChildAttachment> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdCreativeLinkDataChildAttachment> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdCreativeLinkDataChildAttachment>)(
      new APIRequest<AdCreativeLinkDataChildAttachment>(context, "", "/", "GET", AdCreativeLinkDataChildAttachment.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdCreativeLinkDataChildAttachment>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdCreativeLinkDataChildAttachment.getParser())
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
  public static AdCreativeLinkDataChildAttachment loadJSON(String json, APIContext context) {
    AdCreativeLinkDataChildAttachment adCreativeLinkDataChildAttachment = getGson().fromJson(json, AdCreativeLinkDataChildAttachment.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adCreativeLinkDataChildAttachment.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adCreativeLinkDataChildAttachment.context = context;
    adCreativeLinkDataChildAttachment.rawValue = json;
    return adCreativeLinkDataChildAttachment;
  }

  public static APINodeList<AdCreativeLinkDataChildAttachment> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdCreativeLinkDataChildAttachment> adCreativeLinkDataChildAttachments = new APINodeList<AdCreativeLinkDataChildAttachment>(request, json);
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
          adCreativeLinkDataChildAttachments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adCreativeLinkDataChildAttachments;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adCreativeLinkDataChildAttachments.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adCreativeLinkDataChildAttachments.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adCreativeLinkDataChildAttachments.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adCreativeLinkDataChildAttachments.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adCreativeLinkDataChildAttachments.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adCreativeLinkDataChildAttachments.add(loadJSON(obj.toString(), context));
            }
          }
          return adCreativeLinkDataChildAttachments;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adCreativeLinkDataChildAttachments.add(loadJSON(entry.getValue().toString(), context));
          }
          return adCreativeLinkDataChildAttachments;
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
              adCreativeLinkDataChildAttachments.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adCreativeLinkDataChildAttachments;
          }

          // Sixth, check if it's pure JsonObject
          adCreativeLinkDataChildAttachments.clear();
          adCreativeLinkDataChildAttachments.add(loadJSON(json, context));
          return adCreativeLinkDataChildAttachments;
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


  public AdCreativeLinkDataCallToAction getFieldCallToAction() {
    if (mCallToAction != null) {
      mCallToAction.context = getContext();
    }
    return mCallToAction;
  }

  public String getFieldCaption() {
    return mCaption;
  }

  public String getFieldDescription() {
    return mDescription;
  }

  public AdsImageCrops getFieldImageCrops() {
    if (mImageCrops != null) {
      mImageCrops.context = getContext();
    }
    return mImageCrops;
  }

  public String getFieldImageHash() {
    return mImageHash;
  }

  public String getFieldLink() {
    return mLink;
  }

  public String getFieldName() {
    return mName;
  }

  public String getFieldPicture() {
    return mPicture;
  }

  public AdCreativePlaceData getFieldPlaceData() {
    if (mPlaceData != null) {
      mPlaceData.context = getContext();
    }
    return mPlaceData;
  }

  public String getFieldReferralId() {
    return mReferralId;
  }

  public Boolean getFieldStaticCard() {
    return mStaticCard;
  }

  public String getFieldVideoId() {
    return mVideoId;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdCreativeLinkDataChildAttachment> {

    AdCreativeLinkDataChildAttachment lastResponse = null;
    @Override
    public AdCreativeLinkDataChildAttachment getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "call_to_action",
      "caption",
      "description",
      "image_crops",
      "image_hash",
      "link",
      "name",
      "picture",
      "place_data",
      "referral_id",
      "static_card",
      "video_id",
      "id",
    };

    @Override
    public AdCreativeLinkDataChildAttachment parseResponse(String response) throws APIException {
      return AdCreativeLinkDataChildAttachment.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdCreativeLinkDataChildAttachment execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdCreativeLinkDataChildAttachment execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdCreativeLinkDataChildAttachment> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdCreativeLinkDataChildAttachment> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdCreativeLinkDataChildAttachment>() {
           public AdCreativeLinkDataChildAttachment apply(String result) {
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

    public APIRequestGet requestCallToActionField () {
      return this.requestCallToActionField(true);
    }
    public APIRequestGet requestCallToActionField (boolean value) {
      this.requestField("call_to_action", value);
      return this;
    }
    public APIRequestGet requestCaptionField () {
      return this.requestCaptionField(true);
    }
    public APIRequestGet requestCaptionField (boolean value) {
      this.requestField("caption", value);
      return this;
    }
    public APIRequestGet requestDescriptionField () {
      return this.requestDescriptionField(true);
    }
    public APIRequestGet requestDescriptionField (boolean value) {
      this.requestField("description", value);
      return this;
    }
    public APIRequestGet requestImageCropsField () {
      return this.requestImageCropsField(true);
    }
    public APIRequestGet requestImageCropsField (boolean value) {
      this.requestField("image_crops", value);
      return this;
    }
    public APIRequestGet requestImageHashField () {
      return this.requestImageHashField(true);
    }
    public APIRequestGet requestImageHashField (boolean value) {
      this.requestField("image_hash", value);
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
    public APIRequestGet requestPictureField () {
      return this.requestPictureField(true);
    }
    public APIRequestGet requestPictureField (boolean value) {
      this.requestField("picture", value);
      return this;
    }
    public APIRequestGet requestPlaceDataField () {
      return this.requestPlaceDataField(true);
    }
    public APIRequestGet requestPlaceDataField (boolean value) {
      this.requestField("place_data", value);
      return this;
    }
    public APIRequestGet requestReferralIdField () {
      return this.requestReferralIdField(true);
    }
    public APIRequestGet requestReferralIdField (boolean value) {
      this.requestField("referral_id", value);
      return this;
    }
    public APIRequestGet requestStaticCardField () {
      return this.requestStaticCardField(true);
    }
    public APIRequestGet requestStaticCardField (boolean value) {
      this.requestField("static_card", value);
      return this;
    }
    public APIRequestGet requestVideoIdField () {
      return this.requestVideoIdField(true);
    }
    public APIRequestGet requestVideoIdField (boolean value) {
      this.requestField("video_id", value);
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

  public AdCreativeLinkDataChildAttachment copyFrom(AdCreativeLinkDataChildAttachment instance) {
    this.mCallToAction = instance.mCallToAction;
    this.mCaption = instance.mCaption;
    this.mDescription = instance.mDescription;
    this.mImageCrops = instance.mImageCrops;
    this.mImageHash = instance.mImageHash;
    this.mLink = instance.mLink;
    this.mName = instance.mName;
    this.mPicture = instance.mPicture;
    this.mPlaceData = instance.mPlaceData;
    this.mReferralId = instance.mReferralId;
    this.mStaticCard = instance.mStaticCard;
    this.mVideoId = instance.mVideoId;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdCreativeLinkDataChildAttachment> getParser() {
    return new APIRequest.ResponseParser<AdCreativeLinkDataChildAttachment>() {
      public APINodeList<AdCreativeLinkDataChildAttachment> parseResponse(String response, APIContext context, APIRequest<AdCreativeLinkDataChildAttachment> request) throws MalformedResponseException {
        return AdCreativeLinkDataChildAttachment.parseResponse(response, context, request);
      }
    };
  }
}
