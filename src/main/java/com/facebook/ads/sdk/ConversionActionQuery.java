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
public class ConversionActionQuery extends APINode {
  @SerializedName("action.type")
  private List<Object> mActionType = null;
  @SerializedName("application")
  private List<Object> mApplication = null;
  @SerializedName("conversion_id")
  private List<String> mConversionId = null;
  @SerializedName("creative")
  private List<Object> mCreative = null;
  @SerializedName("dataset")
  private List<String> mDataset = null;
  @SerializedName("event")
  private List<String> mEvent = null;
  @SerializedName("event.creator")
  private List<String> mEventCreator = null;
  @SerializedName("event_type")
  private List<String> mEventType = null;
  @SerializedName("fb_pixel")
  private List<String> mFbPixel = null;
  @SerializedName("fb_pixel_event")
  private List<String> mFbPixelEvent = null;
  @SerializedName("leadgen")
  private List<String> mLeadgen = null;
  @SerializedName("object")
  private List<String> mObject = null;
  @SerializedName("object.domain")
  private List<String> mObjectDomain = null;
  @SerializedName("offer")
  private List<String> mOffer = null;
  @SerializedName("offer.creator")
  private List<String> mOfferCreator = null;
  @SerializedName("offsite_pixel")
  private List<String> mOffsitePixel = null;
  @SerializedName("page")
  private List<String> mPage = null;
  @SerializedName("page.parent")
  private List<String> mPageParent = null;
  @SerializedName("post")
  private List<String> mPost = null;
  @SerializedName("post.object")
  private List<String> mPostObject = null;
  @SerializedName("post.object.wall")
  private List<String> mPostObjectWall = null;
  @SerializedName("post.wall")
  private List<String> mPostWall = null;
  @SerializedName("question")
  private List<String> mQuestion = null;
  @SerializedName("question.creator")
  private List<String> mQuestionCreator = null;
  @SerializedName("response")
  private List<String> mResponse = null;
  @SerializedName("subtype")
  private List<String> mSubtype = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  ConversionActionQuery() {
  }

  public ConversionActionQuery(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public ConversionActionQuery(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public ConversionActionQuery fetch() throws APIException{
    ConversionActionQuery newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static ConversionActionQuery fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<ConversionActionQuery> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static ConversionActionQuery fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<ConversionActionQuery> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<ConversionActionQuery> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<ConversionActionQuery>)(
      new APIRequest<ConversionActionQuery>(context, "", "/", "GET", ConversionActionQuery.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<ConversionActionQuery>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", ConversionActionQuery.getParser())
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
  public static ConversionActionQuery loadJSON(String json, APIContext context) {
    ConversionActionQuery conversionActionQuery = getGson().fromJson(json, ConversionActionQuery.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(conversionActionQuery.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    conversionActionQuery.context = context;
    conversionActionQuery.rawValue = json;
    return conversionActionQuery;
  }

  public static APINodeList<ConversionActionQuery> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<ConversionActionQuery> conversionActionQuerys = new APINodeList<ConversionActionQuery>(request, json);
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
          conversionActionQuerys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return conversionActionQuerys;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                conversionActionQuerys.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            conversionActionQuerys.setPaging(previous, next);
            if (context.hasAppSecret()) {
              conversionActionQuerys.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              conversionActionQuerys.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  conversionActionQuerys.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              conversionActionQuerys.add(loadJSON(obj.toString(), context));
            }
          }
          return conversionActionQuerys;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              conversionActionQuerys.add(loadJSON(entry.getValue().toString(), context));
          }
          return conversionActionQuerys;
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
              conversionActionQuerys.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return conversionActionQuerys;
          }

          // Sixth, check if it's pure JsonObject
          conversionActionQuerys.clear();
          conversionActionQuerys.add(loadJSON(json, context));
          return conversionActionQuerys;
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


  public List<Object> getFieldActionType() {
    return mActionType;
  }

  public List<Object> getFieldApplication() {
    return mApplication;
  }

  public List<String> getFieldConversionId() {
    return mConversionId;
  }

  public List<Object> getFieldCreative() {
    return mCreative;
  }

  public List<String> getFieldDataset() {
    return mDataset;
  }

  public List<String> getFieldEvent() {
    return mEvent;
  }

  public List<String> getFieldEventCreator() {
    return mEventCreator;
  }

  public List<String> getFieldEventType() {
    return mEventType;
  }

  public List<String> getFieldFbPixel() {
    return mFbPixel;
  }

  public List<String> getFieldFbPixelEvent() {
    return mFbPixelEvent;
  }

  public List<String> getFieldLeadgen() {
    return mLeadgen;
  }

  public List<String> getFieldObject() {
    return mObject;
  }

  public List<String> getFieldObjectDomain() {
    return mObjectDomain;
  }

  public List<String> getFieldOffer() {
    return mOffer;
  }

  public List<String> getFieldOfferCreator() {
    return mOfferCreator;
  }

  public List<String> getFieldOffsitePixel() {
    return mOffsitePixel;
  }

  public List<String> getFieldPage() {
    return mPage;
  }

  public List<String> getFieldPageParent() {
    return mPageParent;
  }

  public List<String> getFieldPost() {
    return mPost;
  }

  public List<String> getFieldPostObject() {
    return mPostObject;
  }

  public List<String> getFieldPostObjectWall() {
    return mPostObjectWall;
  }

  public List<String> getFieldPostWall() {
    return mPostWall;
  }

  public List<String> getFieldQuestion() {
    return mQuestion;
  }

  public List<String> getFieldQuestionCreator() {
    return mQuestionCreator;
  }

  public List<String> getFieldResponse() {
    return mResponse;
  }

  public List<String> getFieldSubtype() {
    return mSubtype;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<ConversionActionQuery> {

    ConversionActionQuery lastResponse = null;
    @Override
    public ConversionActionQuery getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "action.type",
      "application",
      "conversion_id",
      "creative",
      "dataset",
      "event",
      "event.creator",
      "event_type",
      "fb_pixel",
      "fb_pixel_event",
      "leadgen",
      "object",
      "object.domain",
      "offer",
      "offer.creator",
      "offsite_pixel",
      "page",
      "page.parent",
      "post",
      "post.object",
      "post.object.wall",
      "post.wall",
      "question",
      "question.creator",
      "response",
      "subtype",
      "id",
    };

    @Override
    public ConversionActionQuery parseResponse(String response) throws APIException {
      return ConversionActionQuery.parseResponse(response, getContext(), this).head();
    }

    @Override
    public ConversionActionQuery execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public ConversionActionQuery execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<ConversionActionQuery> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<ConversionActionQuery> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, ConversionActionQuery>() {
           public ConversionActionQuery apply(String result) {
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

    public APIRequestGet requestActionTypeField () {
      return this.requestActionTypeField(true);
    }
    public APIRequestGet requestActionTypeField (boolean value) {
      this.requestField("action.type", value);
      return this;
    }
    public APIRequestGet requestApplicationField () {
      return this.requestApplicationField(true);
    }
    public APIRequestGet requestApplicationField (boolean value) {
      this.requestField("application", value);
      return this;
    }
    public APIRequestGet requestConversionIdField () {
      return this.requestConversionIdField(true);
    }
    public APIRequestGet requestConversionIdField (boolean value) {
      this.requestField("conversion_id", value);
      return this;
    }
    public APIRequestGet requestCreativeField () {
      return this.requestCreativeField(true);
    }
    public APIRequestGet requestCreativeField (boolean value) {
      this.requestField("creative", value);
      return this;
    }
    public APIRequestGet requestDatasetField () {
      return this.requestDatasetField(true);
    }
    public APIRequestGet requestDatasetField (boolean value) {
      this.requestField("dataset", value);
      return this;
    }
    public APIRequestGet requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGet requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGet requestEventCreatorField () {
      return this.requestEventCreatorField(true);
    }
    public APIRequestGet requestEventCreatorField (boolean value) {
      this.requestField("event.creator", value);
      return this;
    }
    public APIRequestGet requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGet requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGet requestFbPixelField () {
      return this.requestFbPixelField(true);
    }
    public APIRequestGet requestFbPixelField (boolean value) {
      this.requestField("fb_pixel", value);
      return this;
    }
    public APIRequestGet requestFbPixelEventField () {
      return this.requestFbPixelEventField(true);
    }
    public APIRequestGet requestFbPixelEventField (boolean value) {
      this.requestField("fb_pixel_event", value);
      return this;
    }
    public APIRequestGet requestLeadgenField () {
      return this.requestLeadgenField(true);
    }
    public APIRequestGet requestLeadgenField (boolean value) {
      this.requestField("leadgen", value);
      return this;
    }
    public APIRequestGet requestObjectField () {
      return this.requestObjectField(true);
    }
    public APIRequestGet requestObjectField (boolean value) {
      this.requestField("object", value);
      return this;
    }
    public APIRequestGet requestObjectDomainField () {
      return this.requestObjectDomainField(true);
    }
    public APIRequestGet requestObjectDomainField (boolean value) {
      this.requestField("object.domain", value);
      return this;
    }
    public APIRequestGet requestOfferField () {
      return this.requestOfferField(true);
    }
    public APIRequestGet requestOfferField (boolean value) {
      this.requestField("offer", value);
      return this;
    }
    public APIRequestGet requestOfferCreatorField () {
      return this.requestOfferCreatorField(true);
    }
    public APIRequestGet requestOfferCreatorField (boolean value) {
      this.requestField("offer.creator", value);
      return this;
    }
    public APIRequestGet requestOffsitePixelField () {
      return this.requestOffsitePixelField(true);
    }
    public APIRequestGet requestOffsitePixelField (boolean value) {
      this.requestField("offsite_pixel", value);
      return this;
    }
    public APIRequestGet requestPageField () {
      return this.requestPageField(true);
    }
    public APIRequestGet requestPageField (boolean value) {
      this.requestField("page", value);
      return this;
    }
    public APIRequestGet requestPageParentField () {
      return this.requestPageParentField(true);
    }
    public APIRequestGet requestPageParentField (boolean value) {
      this.requestField("page.parent", value);
      return this;
    }
    public APIRequestGet requestPostField () {
      return this.requestPostField(true);
    }
    public APIRequestGet requestPostField (boolean value) {
      this.requestField("post", value);
      return this;
    }
    public APIRequestGet requestPostObjectField () {
      return this.requestPostObjectField(true);
    }
    public APIRequestGet requestPostObjectField (boolean value) {
      this.requestField("post.object", value);
      return this;
    }
    public APIRequestGet requestPostObjectWallField () {
      return this.requestPostObjectWallField(true);
    }
    public APIRequestGet requestPostObjectWallField (boolean value) {
      this.requestField("post.object.wall", value);
      return this;
    }
    public APIRequestGet requestPostWallField () {
      return this.requestPostWallField(true);
    }
    public APIRequestGet requestPostWallField (boolean value) {
      this.requestField("post.wall", value);
      return this;
    }
    public APIRequestGet requestQuestionField () {
      return this.requestQuestionField(true);
    }
    public APIRequestGet requestQuestionField (boolean value) {
      this.requestField("question", value);
      return this;
    }
    public APIRequestGet requestQuestionCreatorField () {
      return this.requestQuestionCreatorField(true);
    }
    public APIRequestGet requestQuestionCreatorField (boolean value) {
      this.requestField("question.creator", value);
      return this;
    }
    public APIRequestGet requestResponseField () {
      return this.requestResponseField(true);
    }
    public APIRequestGet requestResponseField (boolean value) {
      this.requestField("response", value);
      return this;
    }
    public APIRequestGet requestSubtypeField () {
      return this.requestSubtypeField(true);
    }
    public APIRequestGet requestSubtypeField (boolean value) {
      this.requestField("subtype", value);
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

  public ConversionActionQuery copyFrom(ConversionActionQuery instance) {
    this.mActionType = instance.mActionType;
    this.mApplication = instance.mApplication;
    this.mConversionId = instance.mConversionId;
    this.mCreative = instance.mCreative;
    this.mDataset = instance.mDataset;
    this.mEvent = instance.mEvent;
    this.mEventCreator = instance.mEventCreator;
    this.mEventType = instance.mEventType;
    this.mFbPixel = instance.mFbPixel;
    this.mFbPixelEvent = instance.mFbPixelEvent;
    this.mLeadgen = instance.mLeadgen;
    this.mObject = instance.mObject;
    this.mObjectDomain = instance.mObjectDomain;
    this.mOffer = instance.mOffer;
    this.mOfferCreator = instance.mOfferCreator;
    this.mOffsitePixel = instance.mOffsitePixel;
    this.mPage = instance.mPage;
    this.mPageParent = instance.mPageParent;
    this.mPost = instance.mPost;
    this.mPostObject = instance.mPostObject;
    this.mPostObjectWall = instance.mPostObjectWall;
    this.mPostWall = instance.mPostWall;
    this.mQuestion = instance.mQuestion;
    this.mQuestionCreator = instance.mQuestionCreator;
    this.mResponse = instance.mResponse;
    this.mSubtype = instance.mSubtype;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ConversionActionQuery> getParser() {
    return new APIRequest.ResponseParser<ConversionActionQuery>() {
      public APINodeList<ConversionActionQuery> parseResponse(String response, APIContext context, APIRequest<ConversionActionQuery> request) throws MalformedResponseException {
        return ConversionActionQuery.parseResponse(response, context, request);
      }
    };
  }
}
