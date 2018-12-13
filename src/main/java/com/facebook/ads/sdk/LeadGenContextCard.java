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
public class LeadGenContextCard extends APINode {
  @SerializedName("button_text")
  private String mButtonText = null;
  @SerializedName("canvas")
  private Canvas mCanvas = null;
  @SerializedName("canvas_jump_to_form_button_text")
  private String mCanvasJumpToFormButtonText = null;
  @SerializedName("content")
  private List<String> mContent = null;
  @SerializedName("cover_photo")
  private Photo mCoverPhoto = null;
  @SerializedName("format")
  private String mFormat = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("style")
  private String mStyle = null;
  @SerializedName("title")
  private String mTitle = null;
  protected static Gson gson = null;

  LeadGenContextCard() {
  }

  public LeadGenContextCard(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public LeadGenContextCard(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public LeadGenContextCard fetch() throws APIException{
    LeadGenContextCard newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static LeadGenContextCard fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<LeadGenContextCard> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static LeadGenContextCard fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<LeadGenContextCard> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<LeadGenContextCard> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<LeadGenContextCard>)(
      new APIRequest<LeadGenContextCard>(context, "", "/", "GET", LeadGenContextCard.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<LeadGenContextCard>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", LeadGenContextCard.getParser())
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
  public static LeadGenContextCard loadJSON(String json, APIContext context, String header) {
    LeadGenContextCard leadGenContextCard = getGson().fromJson(json, LeadGenContextCard.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(leadGenContextCard.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    leadGenContextCard.context = context;
    leadGenContextCard.rawValue = json;
    leadGenContextCard.header = header;
    return leadGenContextCard;
  }

  public static APINodeList<LeadGenContextCard> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<LeadGenContextCard> leadGenContextCards = new APINodeList<LeadGenContextCard>(request, json, header);
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
          leadGenContextCards.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return leadGenContextCards;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                leadGenContextCards.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            leadGenContextCards.setPaging(previous, next);
            if (context.hasAppSecret()) {
              leadGenContextCards.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              leadGenContextCards.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  leadGenContextCards.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              leadGenContextCards.add(loadJSON(obj.toString(), context, header));
            }
          }
          return leadGenContextCards;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              leadGenContextCards.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return leadGenContextCards;
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
              leadGenContextCards.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return leadGenContextCards;
          }

          // Sixth, check if it's pure JsonObject
          leadGenContextCards.clear();
          leadGenContextCards.add(loadJSON(json, context, header));
          return leadGenContextCards;
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


  public String getFieldButtonText() {
    return mButtonText;
  }

  public Canvas getFieldCanvas() {
    if (mCanvas != null) {
      mCanvas.context = getContext();
    }
    return mCanvas;
  }

  public String getFieldCanvasJumpToFormButtonText() {
    return mCanvasJumpToFormButtonText;
  }

  public List<String> getFieldContent() {
    return mContent;
  }

  public Photo getFieldCoverPhoto() {
    if (mCoverPhoto != null) {
      mCoverPhoto.context = getContext();
    }
    return mCoverPhoto;
  }

  public String getFieldFormat() {
    return mFormat;
  }

  public String getFieldId() {
    return mId;
  }

  public String getFieldStyle() {
    return mStyle;
  }

  public String getFieldTitle() {
    return mTitle;
  }



  public static class APIRequestGet extends APIRequest<LeadGenContextCard> {

    LeadGenContextCard lastResponse = null;
    @Override
    public LeadGenContextCard getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "button_text",
      "canvas",
      "canvas_jump_to_form_button_text",
      "content",
      "cover_photo",
      "format",
      "id",
      "style",
      "title",
    };

    @Override
    public LeadGenContextCard parseResponse(String response, String header) throws APIException {
      return LeadGenContextCard.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public LeadGenContextCard execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public LeadGenContextCard execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<LeadGenContextCard> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<LeadGenContextCard> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, LeadGenContextCard>() {
           public LeadGenContextCard apply(ResponseWrapper result) {
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

    public APIRequestGet requestButtonTextField () {
      return this.requestButtonTextField(true);
    }
    public APIRequestGet requestButtonTextField (boolean value) {
      this.requestField("button_text", value);
      return this;
    }
    public APIRequestGet requestCanvasField () {
      return this.requestCanvasField(true);
    }
    public APIRequestGet requestCanvasField (boolean value) {
      this.requestField("canvas", value);
      return this;
    }
    public APIRequestGet requestCanvasJumpToFormButtonTextField () {
      return this.requestCanvasJumpToFormButtonTextField(true);
    }
    public APIRequestGet requestCanvasJumpToFormButtonTextField (boolean value) {
      this.requestField("canvas_jump_to_form_button_text", value);
      return this;
    }
    public APIRequestGet requestContentField () {
      return this.requestContentField(true);
    }
    public APIRequestGet requestContentField (boolean value) {
      this.requestField("content", value);
      return this;
    }
    public APIRequestGet requestCoverPhotoField () {
      return this.requestCoverPhotoField(true);
    }
    public APIRequestGet requestCoverPhotoField (boolean value) {
      this.requestField("cover_photo", value);
      return this;
    }
    public APIRequestGet requestFormatField () {
      return this.requestFormatField(true);
    }
    public APIRequestGet requestFormatField (boolean value) {
      this.requestField("format", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestStyleField () {
      return this.requestStyleField(true);
    }
    public APIRequestGet requestStyleField (boolean value) {
      this.requestField("style", value);
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

  public LeadGenContextCard copyFrom(LeadGenContextCard instance) {
    this.mButtonText = instance.mButtonText;
    this.mCanvas = instance.mCanvas;
    this.mCanvasJumpToFormButtonText = instance.mCanvasJumpToFormButtonText;
    this.mContent = instance.mContent;
    this.mCoverPhoto = instance.mCoverPhoto;
    this.mFormat = instance.mFormat;
    this.mId = instance.mId;
    this.mStyle = instance.mStyle;
    this.mTitle = instance.mTitle;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<LeadGenContextCard> getParser() {
    return new APIRequest.ResponseParser<LeadGenContextCard>() {
      public APINodeList<LeadGenContextCard> parseResponse(String response, APIContext context, APIRequest<LeadGenContextCard> request, String header) throws MalformedResponseException {
        return LeadGenContextCard.parseResponse(response, context, request, header);
      }
    };
  }
}
