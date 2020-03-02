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
public class NativeOffer extends APINode {
  @SerializedName("barcode_photo")
  private String mBarcodePhoto = null;
  @SerializedName("barcode_photo_uri")
  private String mBarcodePhotoUri = null;
  @SerializedName("barcode_type")
  private String mBarcodeType = null;
  @SerializedName("barcode_value")
  private String mBarcodeValue = null;
  @SerializedName("block_reshares")
  private Boolean mBlockReshares = null;
  @SerializedName("details")
  private String mDetails = null;
  @SerializedName("disable_location")
  private Boolean mDisableLocation = null;
  @SerializedName("discounts")
  private List<NativeOfferDiscount> mDiscounts = null;
  @SerializedName("expiration_time")
  private String mExpirationTime = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("instore_code")
  private String mInstoreCode = null;
  @SerializedName("location_type")
  private String mLocationType = null;
  @SerializedName("max_save_count")
  private Long mMaxSaveCount = null;
  @SerializedName("online_code")
  private String mOnlineCode = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("page_set_id")
  private String mPageSetId = null;
  @SerializedName("redemption_code")
  private String mRedemptionCode = null;
  @SerializedName("redemption_link")
  private String mRedemptionLink = null;
  @SerializedName("save_count")
  private Long mSaveCount = null;
  @SerializedName("terms")
  private String mTerms = null;
  @SerializedName("title")
  private String mTitle = null;
  @SerializedName("total_unique_codes")
  private String mTotalUniqueCodes = null;
  @SerializedName("unique_codes")
  private String mUniqueCodes = null;
  @SerializedName("unique_codes_file_code_type")
  private String mUniqueCodesFileCodeType = null;
  @SerializedName("unique_codes_file_name")
  private String mUniqueCodesFileName = null;
  @SerializedName("unique_codes_file_upload_status")
  private String mUniqueCodesFileUploadStatus = null;
  protected static Gson gson = null;

  NativeOffer() {
  }

  public NativeOffer(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public NativeOffer(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public NativeOffer fetch() throws APIException{
    NativeOffer newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static NativeOffer fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<NativeOffer> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static NativeOffer fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<NativeOffer> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<NativeOffer> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<NativeOffer>)(
      new APIRequest<NativeOffer>(context, "", "/", "GET", NativeOffer.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<NativeOffer>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", NativeOffer.getParser())
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
  public static NativeOffer loadJSON(String json, APIContext context, String header) {
    NativeOffer nativeOffer = getGson().fromJson(json, NativeOffer.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(nativeOffer.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    nativeOffer.context = context;
    nativeOffer.rawValue = json;
    nativeOffer.header = header;
    return nativeOffer;
  }

  public static APINodeList<NativeOffer> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<NativeOffer> nativeOffers = new APINodeList<NativeOffer>(request, json, header);
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
          nativeOffers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return nativeOffers;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                nativeOffers.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            nativeOffers.setPaging(previous, next);
            if (context.hasAppSecret()) {
              nativeOffers.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              nativeOffers.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  nativeOffers.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              nativeOffers.add(loadJSON(obj.toString(), context, header));
            }
          }
          return nativeOffers;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              nativeOffers.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return nativeOffers;
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
              nativeOffers.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return nativeOffers;
          }

          // Sixth, check if it's pure JsonObject
          nativeOffers.clear();
          nativeOffers.add(loadJSON(json, context, header));
          return nativeOffers;
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

  public APIRequestCreateCode createCode() {
    return new APIRequestCreateCode(this.getPrefixedId().toString(), context);
  }

  public APIRequestCreateNativeOfferView createNativeOfferView() {
    return new APIRequestCreateNativeOfferView(this.getPrefixedId().toString(), context);
  }

  public APIRequestGetViews getViews() {
    return new APIRequestGetViews(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldBarcodePhoto() {
    return mBarcodePhoto;
  }

  public String getFieldBarcodePhotoUri() {
    return mBarcodePhotoUri;
  }

  public String getFieldBarcodeType() {
    return mBarcodeType;
  }

  public String getFieldBarcodeValue() {
    return mBarcodeValue;
  }

  public Boolean getFieldBlockReshares() {
    return mBlockReshares;
  }

  public String getFieldDetails() {
    return mDetails;
  }

  public Boolean getFieldDisableLocation() {
    return mDisableLocation;
  }

  public List<NativeOfferDiscount> getFieldDiscounts() {
    return mDiscounts;
  }

  public String getFieldExpirationTime() {
    return mExpirationTime;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldInstoreCode() {
    return mInstoreCode;
  }

  public String getFieldLocationType() {
    return mLocationType;
  }

  public Long getFieldMaxSaveCount() {
    return mMaxSaveCount;
  }

  public String getFieldOnlineCode() {
    return mOnlineCode;
  }

  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public String getFieldPageSetId() {
    return mPageSetId;
  }

  public String getFieldRedemptionCode() {
    return mRedemptionCode;
  }

  public String getFieldRedemptionLink() {
    return mRedemptionLink;
  }

  public Long getFieldSaveCount() {
    return mSaveCount;
  }

  public String getFieldTerms() {
    return mTerms;
  }

  public String getFieldTitle() {
    return mTitle;
  }

  public String getFieldTotalUniqueCodes() {
    return mTotalUniqueCodes;
  }

  public String getFieldUniqueCodes() {
    return mUniqueCodes;
  }

  public String getFieldUniqueCodesFileCodeType() {
    return mUniqueCodesFileCodeType;
  }

  public String getFieldUniqueCodesFileName() {
    return mUniqueCodesFileName;
  }

  public String getFieldUniqueCodesFileUploadStatus() {
    return mUniqueCodesFileUploadStatus;
  }



  public static class APIRequestCreateCode extends APIRequest<NativeOffer> {

    NativeOffer lastResponse = null;
    @Override
    public NativeOffer getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "unique_codes_file_code_type",
      "file",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public NativeOffer parseResponse(String response, String header) throws APIException {
      return NativeOffer.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public NativeOffer execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NativeOffer execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<NativeOffer> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NativeOffer> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, NativeOffer>() {
           public NativeOffer apply(ResponseWrapper result) {
             try {
               return APIRequestCreateCode.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateCode(String nodeId, APIContext context) {
      super(context, nodeId, "/codes", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateCode setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateCode setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }

    public APIRequestCreateCode addUploadFile (String uploadName, File file) {
      this.setParam(uploadName, file);
      return this;
    }

    public APIRequestCreateCode setUseVideoEndpoint(boolean useVideoEndpoint) {
      this.useVideoEndpoint = useVideoEndpoint;
      return this;
    }

    public APIRequestCreateCode setUniqueCodesFileCodeType (NativeOffer.EnumUniqueCodesFileCodeType uniqueCodesFileCodeType) {
      this.setParam("unique_codes_file_code_type", uniqueCodesFileCodeType);
      return this;
    }
    public APIRequestCreateCode setUniqueCodesFileCodeType (String uniqueCodesFileCodeType) {
      this.setParam("unique_codes_file_code_type", uniqueCodesFileCodeType);
      return this;
    }

    public APIRequestCreateCode requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateCode requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCode requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateCode requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateCode requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateCode requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestCreateNativeOfferView extends APIRequest<NativeOffer> {

    NativeOffer lastResponse = null;
    @Override
    public NativeOffer getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "ad_account",
      "ad_image_hashes",
      "carousel_captions",
      "carousel_data",
      "carousel_links",
      "deeplinks",
      "image_crops",
      "message",
      "photos",
      "place_data",
      "published",
      "published_ads",
      "urls",
      "videos",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public NativeOffer parseResponse(String response, String header) throws APIException {
      return NativeOffer.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public NativeOffer execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NativeOffer execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<NativeOffer> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NativeOffer> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, NativeOffer>() {
           public NativeOffer apply(ResponseWrapper result) {
             try {
               return APIRequestCreateNativeOfferView.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestCreateNativeOfferView(String nodeId, APIContext context) {
      super(context, nodeId, "/nativeofferviews", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestCreateNativeOfferView setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestCreateNativeOfferView setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestCreateNativeOfferView setAdAccount (String adAccount) {
      this.setParam("ad_account", adAccount);
      return this;
    }

    public APIRequestCreateNativeOfferView setAdImageHashes (List<String> adImageHashes) {
      this.setParam("ad_image_hashes", adImageHashes);
      return this;
    }
    public APIRequestCreateNativeOfferView setAdImageHashes (String adImageHashes) {
      this.setParam("ad_image_hashes", adImageHashes);
      return this;
    }

    public APIRequestCreateNativeOfferView setCarouselCaptions (List<String> carouselCaptions) {
      this.setParam("carousel_captions", carouselCaptions);
      return this;
    }
    public APIRequestCreateNativeOfferView setCarouselCaptions (String carouselCaptions) {
      this.setParam("carousel_captions", carouselCaptions);
      return this;
    }

    public APIRequestCreateNativeOfferView setCarouselData (List<Object> carouselData) {
      this.setParam("carousel_data", carouselData);
      return this;
    }
    public APIRequestCreateNativeOfferView setCarouselData (String carouselData) {
      this.setParam("carousel_data", carouselData);
      return this;
    }

    public APIRequestCreateNativeOfferView setCarouselLinks (List<String> carouselLinks) {
      this.setParam("carousel_links", carouselLinks);
      return this;
    }
    public APIRequestCreateNativeOfferView setCarouselLinks (String carouselLinks) {
      this.setParam("carousel_links", carouselLinks);
      return this;
    }

    public APIRequestCreateNativeOfferView setDeeplinks (List<String> deeplinks) {
      this.setParam("deeplinks", deeplinks);
      return this;
    }
    public APIRequestCreateNativeOfferView setDeeplinks (String deeplinks) {
      this.setParam("deeplinks", deeplinks);
      return this;
    }

    public APIRequestCreateNativeOfferView setImageCrops (List<Map<String, String>> imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }
    public APIRequestCreateNativeOfferView setImageCrops (String imageCrops) {
      this.setParam("image_crops", imageCrops);
      return this;
    }

    public APIRequestCreateNativeOfferView setMessage (String message) {
      this.setParam("message", message);
      return this;
    }

    public APIRequestCreateNativeOfferView setPhotos (List<String> photos) {
      this.setParam("photos", photos);
      return this;
    }
    public APIRequestCreateNativeOfferView setPhotos (String photos) {
      this.setParam("photos", photos);
      return this;
    }

    public APIRequestCreateNativeOfferView setPlaceData (Object placeData) {
      this.setParam("place_data", placeData);
      return this;
    }
    public APIRequestCreateNativeOfferView setPlaceData (String placeData) {
      this.setParam("place_data", placeData);
      return this;
    }

    public APIRequestCreateNativeOfferView setPublished (Boolean published) {
      this.setParam("published", published);
      return this;
    }
    public APIRequestCreateNativeOfferView setPublished (String published) {
      this.setParam("published", published);
      return this;
    }

    public APIRequestCreateNativeOfferView setPublishedAds (Boolean publishedAds) {
      this.setParam("published_ads", publishedAds);
      return this;
    }
    public APIRequestCreateNativeOfferView setPublishedAds (String publishedAds) {
      this.setParam("published_ads", publishedAds);
      return this;
    }

    public APIRequestCreateNativeOfferView setUrls (List<String> urls) {
      this.setParam("urls", urls);
      return this;
    }
    public APIRequestCreateNativeOfferView setUrls (String urls) {
      this.setParam("urls", urls);
      return this;
    }

    public APIRequestCreateNativeOfferView setVideos (List<String> videos) {
      this.setParam("videos", videos);
      return this;
    }
    public APIRequestCreateNativeOfferView setVideos (String videos) {
      this.setParam("videos", videos);
      return this;
    }

    public APIRequestCreateNativeOfferView requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestCreateNativeOfferView requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateNativeOfferView requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestCreateNativeOfferView requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestCreateNativeOfferView requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestCreateNativeOfferView requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGetViews extends APIRequest<NativeOfferView> {

    APINodeList<NativeOfferView> lastResponse = null;
    @Override
    public APINodeList<NativeOfferView> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "offer",
      "save_count",
    };

    @Override
    public APINodeList<NativeOfferView> parseResponse(String response, String header) throws APIException {
      return NativeOfferView.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<NativeOfferView> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<NativeOfferView> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<NativeOfferView>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<NativeOfferView>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<NativeOfferView>>() {
           public APINodeList<NativeOfferView> apply(ResponseWrapper result) {
             try {
               return APIRequestGetViews.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetViews(String nodeId, APIContext context) {
      super(context, nodeId, "/views", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetViews setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetViews setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetViews requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetViews requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetViews requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetViews requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetViews requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetViews requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetViews requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGetViews requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGetViews requestOfferField () {
      return this.requestOfferField(true);
    }
    public APIRequestGetViews requestOfferField (boolean value) {
      this.requestField("offer", value);
      return this;
    }
    public APIRequestGetViews requestSaveCountField () {
      return this.requestSaveCountField(true);
    }
    public APIRequestGetViews requestSaveCountField (boolean value) {
      this.requestField("save_count", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<NativeOffer> {

    NativeOffer lastResponse = null;
    @Override
    public NativeOffer getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "barcode_photo",
      "barcode_photo_uri",
      "barcode_type",
      "barcode_value",
      "block_reshares",
      "details",
      "disable_location",
      "discounts",
      "expiration_time",
      "id",
      "instore_code",
      "location_type",
      "max_save_count",
      "online_code",
      "page",
      "page_set_id",
      "redemption_code",
      "redemption_link",
      "save_count",
      "terms",
      "title",
      "total_unique_codes",
      "unique_codes",
      "unique_codes_file_code_type",
      "unique_codes_file_name",
      "unique_codes_file_upload_status",
    };

    @Override
    public NativeOffer parseResponse(String response, String header) throws APIException {
      return NativeOffer.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public NativeOffer execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public NativeOffer execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<NativeOffer> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<NativeOffer> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, NativeOffer>() {
           public NativeOffer apply(ResponseWrapper result) {
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

    public APIRequestGet requestBarcodePhotoField () {
      return this.requestBarcodePhotoField(true);
    }
    public APIRequestGet requestBarcodePhotoField (boolean value) {
      this.requestField("barcode_photo", value);
      return this;
    }
    public APIRequestGet requestBarcodePhotoUriField () {
      return this.requestBarcodePhotoUriField(true);
    }
    public APIRequestGet requestBarcodePhotoUriField (boolean value) {
      this.requestField("barcode_photo_uri", value);
      return this;
    }
    public APIRequestGet requestBarcodeTypeField () {
      return this.requestBarcodeTypeField(true);
    }
    public APIRequestGet requestBarcodeTypeField (boolean value) {
      this.requestField("barcode_type", value);
      return this;
    }
    public APIRequestGet requestBarcodeValueField () {
      return this.requestBarcodeValueField(true);
    }
    public APIRequestGet requestBarcodeValueField (boolean value) {
      this.requestField("barcode_value", value);
      return this;
    }
    public APIRequestGet requestBlockResharesField () {
      return this.requestBlockResharesField(true);
    }
    public APIRequestGet requestBlockResharesField (boolean value) {
      this.requestField("block_reshares", value);
      return this;
    }
    public APIRequestGet requestDetailsField () {
      return this.requestDetailsField(true);
    }
    public APIRequestGet requestDetailsField (boolean value) {
      this.requestField("details", value);
      return this;
    }
    public APIRequestGet requestDisableLocationField () {
      return this.requestDisableLocationField(true);
    }
    public APIRequestGet requestDisableLocationField (boolean value) {
      this.requestField("disable_location", value);
      return this;
    }
    public APIRequestGet requestDiscountsField () {
      return this.requestDiscountsField(true);
    }
    public APIRequestGet requestDiscountsField (boolean value) {
      this.requestField("discounts", value);
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
    public APIRequestGet requestInstoreCodeField () {
      return this.requestInstoreCodeField(true);
    }
    public APIRequestGet requestInstoreCodeField (boolean value) {
      this.requestField("instore_code", value);
      return this;
    }
    public APIRequestGet requestLocationTypeField () {
      return this.requestLocationTypeField(true);
    }
    public APIRequestGet requestLocationTypeField (boolean value) {
      this.requestField("location_type", value);
      return this;
    }
    public APIRequestGet requestMaxSaveCountField () {
      return this.requestMaxSaveCountField(true);
    }
    public APIRequestGet requestMaxSaveCountField (boolean value) {
      this.requestField("max_save_count", value);
      return this;
    }
    public APIRequestGet requestOnlineCodeField () {
      return this.requestOnlineCodeField(true);
    }
    public APIRequestGet requestOnlineCodeField (boolean value) {
      this.requestField("online_code", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestPageSetIdField () {
      return this.requestPageSetIdField(true);
    }
    public APIRequestGet requestPageSetIdField (boolean value) {
      this.requestField("page_set_id", value);
      return this;
    }
    public APIRequestGet requestRedemptionCodeField () {
      return this.requestRedemptionCodeField(true);
    }
    public APIRequestGet requestRedemptionCodeField (boolean value) {
      this.requestField("redemption_code", value);
      return this;
    }
    public APIRequestGet requestRedemptionLinkField () {
      return this.requestRedemptionLinkField(true);
    }
    public APIRequestGet requestRedemptionLinkField (boolean value) {
      this.requestField("redemption_link", value);
      return this;
    }
    public APIRequestGet requestSaveCountField () {
      return this.requestSaveCountField(true);
    }
    public APIRequestGet requestSaveCountField (boolean value) {
      this.requestField("save_count", value);
      return this;
    }
    public APIRequestGet requestTermsField () {
      return this.requestTermsField(true);
    }
    public APIRequestGet requestTermsField (boolean value) {
      this.requestField("terms", value);
      return this;
    }
    public APIRequestGet requestTitleField () {
      return this.requestTitleField(true);
    }
    public APIRequestGet requestTitleField (boolean value) {
      this.requestField("title", value);
      return this;
    }
    public APIRequestGet requestTotalUniqueCodesField () {
      return this.requestTotalUniqueCodesField(true);
    }
    public APIRequestGet requestTotalUniqueCodesField (boolean value) {
      this.requestField("total_unique_codes", value);
      return this;
    }
    public APIRequestGet requestUniqueCodesField () {
      return this.requestUniqueCodesField(true);
    }
    public APIRequestGet requestUniqueCodesField (boolean value) {
      this.requestField("unique_codes", value);
      return this;
    }
    public APIRequestGet requestUniqueCodesFileCodeTypeField () {
      return this.requestUniqueCodesFileCodeTypeField(true);
    }
    public APIRequestGet requestUniqueCodesFileCodeTypeField (boolean value) {
      this.requestField("unique_codes_file_code_type", value);
      return this;
    }
    public APIRequestGet requestUniqueCodesFileNameField () {
      return this.requestUniqueCodesFileNameField(true);
    }
    public APIRequestGet requestUniqueCodesFileNameField (boolean value) {
      this.requestField("unique_codes_file_name", value);
      return this;
    }
    public APIRequestGet requestUniqueCodesFileUploadStatusField () {
      return this.requestUniqueCodesFileUploadStatusField(true);
    }
    public APIRequestGet requestUniqueCodesFileUploadStatusField (boolean value) {
      this.requestField("unique_codes_file_upload_status", value);
      return this;
    }
  }

  public static enum EnumUniqueCodesFileCodeType {
      @SerializedName("barcodes")
      VALUE_BARCODES("barcodes"),
      @SerializedName("discount_and_barcodes")
      VALUE_DISCOUNT_AND_BARCODES("discount_and_barcodes"),
      @SerializedName("discount_and_discount")
      VALUE_DISCOUNT_AND_DISCOUNT("discount_and_discount"),
      @SerializedName("discount_codes")
      VALUE_DISCOUNT_CODES("discount_codes"),
      @SerializedName("instore_barcodes")
      VALUE_INSTORE_BARCODES("instore_barcodes"),
      @SerializedName("instore_discount_codes")
      VALUE_INSTORE_DISCOUNT_CODES("instore_discount_codes"),
      @SerializedName("online_discount_codes")
      VALUE_ONLINE_DISCOUNT_CODES("online_discount_codes"),
      ;

      private String value;

      private EnumUniqueCodesFileCodeType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBarcodeType {
      @SerializedName("CODE128")
      VALUE_CODE128("CODE128"),
      @SerializedName("CODE128B")
      VALUE_CODE128B("CODE128B"),
      @SerializedName("CODE93")
      VALUE_CODE93("CODE93"),
      @SerializedName("DATABAR")
      VALUE_DATABAR("DATABAR"),
      @SerializedName("DATABAR_EXPANDED")
      VALUE_DATABAR_EXPANDED("DATABAR_EXPANDED"),
      @SerializedName("DATABAR_EXPANDED_STACKED")
      VALUE_DATABAR_EXPANDED_STACKED("DATABAR_EXPANDED_STACKED"),
      @SerializedName("DATABAR_LIMITED")
      VALUE_DATABAR_LIMITED("DATABAR_LIMITED"),
      @SerializedName("DATAMATRIX")
      VALUE_DATAMATRIX("DATAMATRIX"),
      @SerializedName("EAN")
      VALUE_EAN("EAN"),
      @SerializedName("PDF417")
      VALUE_PDF417("PDF417"),
      @SerializedName("QR")
      VALUE_QR("QR"),
      @SerializedName("UPC_A")
      VALUE_UPC_A("UPC_A"),
      @SerializedName("UPC_E")
      VALUE_UPC_E("UPC_E"),
      ;

      private String value;

      private EnumBarcodeType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLocationType {
      @SerializedName("both")
      VALUE_BOTH("both"),
      @SerializedName("offline")
      VALUE_OFFLINE("offline"),
      @SerializedName("online")
      VALUE_ONLINE("online"),
      ;

      private String value;

      private EnumLocationType(String value) {
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

  public NativeOffer copyFrom(NativeOffer instance) {
    this.mBarcodePhoto = instance.mBarcodePhoto;
    this.mBarcodePhotoUri = instance.mBarcodePhotoUri;
    this.mBarcodeType = instance.mBarcodeType;
    this.mBarcodeValue = instance.mBarcodeValue;
    this.mBlockReshares = instance.mBlockReshares;
    this.mDetails = instance.mDetails;
    this.mDisableLocation = instance.mDisableLocation;
    this.mDiscounts = instance.mDiscounts;
    this.mExpirationTime = instance.mExpirationTime;
    this.mId = instance.mId;
    this.mInstoreCode = instance.mInstoreCode;
    this.mLocationType = instance.mLocationType;
    this.mMaxSaveCount = instance.mMaxSaveCount;
    this.mOnlineCode = instance.mOnlineCode;
    this.mPage = instance.mPage;
    this.mPageSetId = instance.mPageSetId;
    this.mRedemptionCode = instance.mRedemptionCode;
    this.mRedemptionLink = instance.mRedemptionLink;
    this.mSaveCount = instance.mSaveCount;
    this.mTerms = instance.mTerms;
    this.mTitle = instance.mTitle;
    this.mTotalUniqueCodes = instance.mTotalUniqueCodes;
    this.mUniqueCodes = instance.mUniqueCodes;
    this.mUniqueCodesFileCodeType = instance.mUniqueCodesFileCodeType;
    this.mUniqueCodesFileName = instance.mUniqueCodesFileName;
    this.mUniqueCodesFileUploadStatus = instance.mUniqueCodesFileUploadStatus;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<NativeOffer> getParser() {
    return new APIRequest.ResponseParser<NativeOffer>() {
      public APINodeList<NativeOffer> parseResponse(String response, APIContext context, APIRequest<NativeOffer> request, String header) throws MalformedResponseException {
        return NativeOffer.parseResponse(response, context, request, header);
      }
    };
  }
}
