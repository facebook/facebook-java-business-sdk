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
public class AdsActionStats extends APINode {
  @SerializedName("1d_click")
  private String m1dClick = null;
  @SerializedName("1d_view")
  private String m1dView = null;
  @SerializedName("28d_click")
  private String m28dClick = null;
  @SerializedName("28d_view")
  private String m28dView = null;
  @SerializedName("7d_click")
  private String m7dClick = null;
  @SerializedName("7d_view")
  private String m7dView = null;
  @SerializedName("action_canvas_component_id")
  private String mActionCanvasComponentId = null;
  @SerializedName("action_canvas_component_name")
  private String mActionCanvasComponentName = null;
  @SerializedName("action_carousel_card_id")
  private String mActionCarouselCardId = null;
  @SerializedName("action_carousel_card_name")
  private String mActionCarouselCardName = null;
  @SerializedName("action_destination")
  private String mActionDestination = null;
  @SerializedName("action_device")
  private String mActionDevice = null;
  @SerializedName("action_event_channel")
  private String mActionEventChannel = null;
  @SerializedName("action_link_click_destination")
  private String mActionLinkClickDestination = null;
  @SerializedName("action_location_code")
  private String mActionLocationCode = null;
  @SerializedName("action_reaction")
  private String mActionReaction = null;
  @SerializedName("action_target_id")
  private String mActionTargetId = null;
  @SerializedName("action_type")
  private String mActionType = null;
  @SerializedName("action_video_asset_id")
  private String mActionVideoAssetId = null;
  @SerializedName("action_video_sound")
  private String mActionVideoSound = null;
  @SerializedName("action_video_type")
  private String mActionVideoType = null;
  @SerializedName("inline")
  private String mInline = null;
  @SerializedName("value")
  private String mValue = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdsActionStats() {
  }

  public AdsActionStats(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsActionStats(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsActionStats fetch() throws APIException{
    AdsActionStats newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsActionStats fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsActionStats> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsActionStats fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsActionStats> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsActionStats> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsActionStats>)(
      new APIRequest<AdsActionStats>(context, "", "/", "GET", AdsActionStats.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsActionStats>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsActionStats.getParser())
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
  public static AdsActionStats loadJSON(String json, APIContext context) {
    AdsActionStats adsActionStats = getGson().fromJson(json, AdsActionStats.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsActionStats.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsActionStats.context = context;
    adsActionStats.rawValue = json;
    return adsActionStats;
  }

  public static APINodeList<AdsActionStats> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdsActionStats> adsActionStatss = new APINodeList<AdsActionStats>(request, json);
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
          adsActionStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adsActionStatss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsActionStatss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsActionStatss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsActionStatss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsActionStatss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adsActionStatss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsActionStatss.add(loadJSON(obj.toString(), context));
            }
          }
          return adsActionStatss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsActionStatss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adsActionStatss;
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
              adsActionStatss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsActionStatss;
          }

          // Sixth, check if it's pure JsonObject
          adsActionStatss.clear();
          adsActionStatss.add(loadJSON(json, context));
          return adsActionStatss;
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


  public String getField1dClick() {
    return m1dClick;
  }

  public String getField1dView() {
    return m1dView;
  }

  public String getField28dClick() {
    return m28dClick;
  }

  public String getField28dView() {
    return m28dView;
  }

  public String getField7dClick() {
    return m7dClick;
  }

  public String getField7dView() {
    return m7dView;
  }

  public String getFieldActionCanvasComponentId() {
    return mActionCanvasComponentId;
  }

  public String getFieldActionCanvasComponentName() {
    return mActionCanvasComponentName;
  }

  public String getFieldActionCarouselCardId() {
    return mActionCarouselCardId;
  }

  public String getFieldActionCarouselCardName() {
    return mActionCarouselCardName;
  }

  public String getFieldActionDestination() {
    return mActionDestination;
  }

  public String getFieldActionDevice() {
    return mActionDevice;
  }

  public String getFieldActionEventChannel() {
    return mActionEventChannel;
  }

  public String getFieldActionLinkClickDestination() {
    return mActionLinkClickDestination;
  }

  public String getFieldActionLocationCode() {
    return mActionLocationCode;
  }

  public String getFieldActionReaction() {
    return mActionReaction;
  }

  public String getFieldActionTargetId() {
    return mActionTargetId;
  }

  public String getFieldActionType() {
    return mActionType;
  }

  public String getFieldActionVideoAssetId() {
    return mActionVideoAssetId;
  }

  public String getFieldActionVideoSound() {
    return mActionVideoSound;
  }

  public String getFieldActionVideoType() {
    return mActionVideoType;
  }

  public String getFieldInline() {
    return mInline;
  }

  public String getFieldValue() {
    return mValue;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdsActionStats> {

    AdsActionStats lastResponse = null;
    @Override
    public AdsActionStats getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "1d_click",
      "1d_view",
      "28d_click",
      "28d_view",
      "7d_click",
      "7d_view",
      "action_canvas_component_id",
      "action_canvas_component_name",
      "action_carousel_card_id",
      "action_carousel_card_name",
      "action_destination",
      "action_device",
      "action_event_channel",
      "action_link_click_destination",
      "action_location_code",
      "action_reaction",
      "action_target_id",
      "action_type",
      "action_video_asset_id",
      "action_video_sound",
      "action_video_type",
      "inline",
      "value",
      "id",
    };

    @Override
    public AdsActionStats parseResponse(String response) throws APIException {
      return AdsActionStats.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsActionStats execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsActionStats execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsActionStats> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsActionStats> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsActionStats>() {
           public AdsActionStats apply(String result) {
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

    public APIRequestGet request1dClickField () {
      return this.request1dClickField(true);
    }
    public APIRequestGet request1dClickField (boolean value) {
      this.requestField("1d_click", value);
      return this;
    }
    public APIRequestGet request1dViewField () {
      return this.request1dViewField(true);
    }
    public APIRequestGet request1dViewField (boolean value) {
      this.requestField("1d_view", value);
      return this;
    }
    public APIRequestGet request28dClickField () {
      return this.request28dClickField(true);
    }
    public APIRequestGet request28dClickField (boolean value) {
      this.requestField("28d_click", value);
      return this;
    }
    public APIRequestGet request28dViewField () {
      return this.request28dViewField(true);
    }
    public APIRequestGet request28dViewField (boolean value) {
      this.requestField("28d_view", value);
      return this;
    }
    public APIRequestGet request7dClickField () {
      return this.request7dClickField(true);
    }
    public APIRequestGet request7dClickField (boolean value) {
      this.requestField("7d_click", value);
      return this;
    }
    public APIRequestGet request7dViewField () {
      return this.request7dViewField(true);
    }
    public APIRequestGet request7dViewField (boolean value) {
      this.requestField("7d_view", value);
      return this;
    }
    public APIRequestGet requestActionCanvasComponentIdField () {
      return this.requestActionCanvasComponentIdField(true);
    }
    public APIRequestGet requestActionCanvasComponentIdField (boolean value) {
      this.requestField("action_canvas_component_id", value);
      return this;
    }
    public APIRequestGet requestActionCanvasComponentNameField () {
      return this.requestActionCanvasComponentNameField(true);
    }
    public APIRequestGet requestActionCanvasComponentNameField (boolean value) {
      this.requestField("action_canvas_component_name", value);
      return this;
    }
    public APIRequestGet requestActionCarouselCardIdField () {
      return this.requestActionCarouselCardIdField(true);
    }
    public APIRequestGet requestActionCarouselCardIdField (boolean value) {
      this.requestField("action_carousel_card_id", value);
      return this;
    }
    public APIRequestGet requestActionCarouselCardNameField () {
      return this.requestActionCarouselCardNameField(true);
    }
    public APIRequestGet requestActionCarouselCardNameField (boolean value) {
      this.requestField("action_carousel_card_name", value);
      return this;
    }
    public APIRequestGet requestActionDestinationField () {
      return this.requestActionDestinationField(true);
    }
    public APIRequestGet requestActionDestinationField (boolean value) {
      this.requestField("action_destination", value);
      return this;
    }
    public APIRequestGet requestActionDeviceField () {
      return this.requestActionDeviceField(true);
    }
    public APIRequestGet requestActionDeviceField (boolean value) {
      this.requestField("action_device", value);
      return this;
    }
    public APIRequestGet requestActionEventChannelField () {
      return this.requestActionEventChannelField(true);
    }
    public APIRequestGet requestActionEventChannelField (boolean value) {
      this.requestField("action_event_channel", value);
      return this;
    }
    public APIRequestGet requestActionLinkClickDestinationField () {
      return this.requestActionLinkClickDestinationField(true);
    }
    public APIRequestGet requestActionLinkClickDestinationField (boolean value) {
      this.requestField("action_link_click_destination", value);
      return this;
    }
    public APIRequestGet requestActionLocationCodeField () {
      return this.requestActionLocationCodeField(true);
    }
    public APIRequestGet requestActionLocationCodeField (boolean value) {
      this.requestField("action_location_code", value);
      return this;
    }
    public APIRequestGet requestActionReactionField () {
      return this.requestActionReactionField(true);
    }
    public APIRequestGet requestActionReactionField (boolean value) {
      this.requestField("action_reaction", value);
      return this;
    }
    public APIRequestGet requestActionTargetIdField () {
      return this.requestActionTargetIdField(true);
    }
    public APIRequestGet requestActionTargetIdField (boolean value) {
      this.requestField("action_target_id", value);
      return this;
    }
    public APIRequestGet requestActionTypeField () {
      return this.requestActionTypeField(true);
    }
    public APIRequestGet requestActionTypeField (boolean value) {
      this.requestField("action_type", value);
      return this;
    }
    public APIRequestGet requestActionVideoAssetIdField () {
      return this.requestActionVideoAssetIdField(true);
    }
    public APIRequestGet requestActionVideoAssetIdField (boolean value) {
      this.requestField("action_video_asset_id", value);
      return this;
    }
    public APIRequestGet requestActionVideoSoundField () {
      return this.requestActionVideoSoundField(true);
    }
    public APIRequestGet requestActionVideoSoundField (boolean value) {
      this.requestField("action_video_sound", value);
      return this;
    }
    public APIRequestGet requestActionVideoTypeField () {
      return this.requestActionVideoTypeField(true);
    }
    public APIRequestGet requestActionVideoTypeField (boolean value) {
      this.requestField("action_video_type", value);
      return this;
    }
    public APIRequestGet requestInlineField () {
      return this.requestInlineField(true);
    }
    public APIRequestGet requestInlineField (boolean value) {
      this.requestField("inline", value);
      return this;
    }
    public APIRequestGet requestValueField () {
      return this.requestValueField(true);
    }
    public APIRequestGet requestValueField (boolean value) {
      this.requestField("value", value);
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

  public AdsActionStats copyFrom(AdsActionStats instance) {
    this.m1dClick = instance.m1dClick;
    this.m1dView = instance.m1dView;
    this.m28dClick = instance.m28dClick;
    this.m28dView = instance.m28dView;
    this.m7dClick = instance.m7dClick;
    this.m7dView = instance.m7dView;
    this.mActionCanvasComponentId = instance.mActionCanvasComponentId;
    this.mActionCanvasComponentName = instance.mActionCanvasComponentName;
    this.mActionCarouselCardId = instance.mActionCarouselCardId;
    this.mActionCarouselCardName = instance.mActionCarouselCardName;
    this.mActionDestination = instance.mActionDestination;
    this.mActionDevice = instance.mActionDevice;
    this.mActionEventChannel = instance.mActionEventChannel;
    this.mActionLinkClickDestination = instance.mActionLinkClickDestination;
    this.mActionLocationCode = instance.mActionLocationCode;
    this.mActionReaction = instance.mActionReaction;
    this.mActionTargetId = instance.mActionTargetId;
    this.mActionType = instance.mActionType;
    this.mActionVideoAssetId = instance.mActionVideoAssetId;
    this.mActionVideoSound = instance.mActionVideoSound;
    this.mActionVideoType = instance.mActionVideoType;
    this.mInline = instance.mInline;
    this.mValue = instance.mValue;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsActionStats> getParser() {
    return new APIRequest.ResponseParser<AdsActionStats>() {
      public APINodeList<AdsActionStats> parseResponse(String response, APIContext context, APIRequest<AdsActionStats> request) throws MalformedResponseException {
        return AdsActionStats.parseResponse(response, context, request);
      }
    };
  }
}
