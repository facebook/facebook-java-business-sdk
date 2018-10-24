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
public class CanvasAdSettings extends APINode {
  @SerializedName("is_canvas_collection_eligible")
  private Boolean mIsCanvasCollectionEligible = null;
  @SerializedName("lead_form_created_time")
  private Object mLeadFormCreatedTime = null;
  @SerializedName("lead_form_name")
  private String mLeadFormName = null;
  @SerializedName("lead_gen_form_id")
  private String mLeadGenFormId = null;
  @SerializedName("leads_count")
  private Long mLeadsCount = null;
  @SerializedName("product_set_id")
  private String mProductSetId = null;
  @SerializedName("use_retailer_item_ids")
  private Boolean mUseRetailerItemIds = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  CanvasAdSettings() {
  }

  public CanvasAdSettings(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public CanvasAdSettings(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public CanvasAdSettings fetch() throws APIException{
    CanvasAdSettings newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static CanvasAdSettings fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<CanvasAdSettings> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static CanvasAdSettings fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<CanvasAdSettings> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<CanvasAdSettings> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<CanvasAdSettings>)(
      new APIRequest<CanvasAdSettings>(context, "", "/", "GET", CanvasAdSettings.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<CanvasAdSettings>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", CanvasAdSettings.getParser())
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
  public static CanvasAdSettings loadJSON(String json, APIContext context) {
    CanvasAdSettings canvasAdSettings = getGson().fromJson(json, CanvasAdSettings.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(canvasAdSettings.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    canvasAdSettings.context = context;
    canvasAdSettings.rawValue = json;
    return canvasAdSettings;
  }

  public static APINodeList<CanvasAdSettings> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<CanvasAdSettings> canvasAdSettingss = new APINodeList<CanvasAdSettings>(request, json);
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
          canvasAdSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return canvasAdSettingss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                canvasAdSettingss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            canvasAdSettingss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              canvasAdSettingss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              canvasAdSettingss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  canvasAdSettingss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              canvasAdSettingss.add(loadJSON(obj.toString(), context));
            }
          }
          return canvasAdSettingss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              canvasAdSettingss.add(loadJSON(entry.getValue().toString(), context));
          }
          return canvasAdSettingss;
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
              canvasAdSettingss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return canvasAdSettingss;
          }

          // Sixth, check if it's pure JsonObject
          canvasAdSettingss.clear();
          canvasAdSettingss.add(loadJSON(json, context));
          return canvasAdSettingss;
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


  public Boolean getFieldIsCanvasCollectionEligible() {
    return mIsCanvasCollectionEligible;
  }

  public Object getFieldLeadFormCreatedTime() {
    return mLeadFormCreatedTime;
  }

  public String getFieldLeadFormName() {
    return mLeadFormName;
  }

  public String getFieldLeadGenFormId() {
    return mLeadGenFormId;
  }

  public Long getFieldLeadsCount() {
    return mLeadsCount;
  }

  public String getFieldProductSetId() {
    return mProductSetId;
  }

  public Boolean getFieldUseRetailerItemIds() {
    return mUseRetailerItemIds;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<CanvasAdSettings> {

    CanvasAdSettings lastResponse = null;
    @Override
    public CanvasAdSettings getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "is_canvas_collection_eligible",
      "lead_form_created_time",
      "lead_form_name",
      "lead_gen_form_id",
      "leads_count",
      "product_set_id",
      "use_retailer_item_ids",
      "id",
    };

    @Override
    public CanvasAdSettings parseResponse(String response) throws APIException {
      return CanvasAdSettings.parseResponse(response, getContext(), this).head();
    }

    @Override
    public CanvasAdSettings execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public CanvasAdSettings execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<CanvasAdSettings> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<CanvasAdSettings> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, CanvasAdSettings>() {
           public CanvasAdSettings apply(String result) {
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

    public APIRequestGet requestIsCanvasCollectionEligibleField () {
      return this.requestIsCanvasCollectionEligibleField(true);
    }
    public APIRequestGet requestIsCanvasCollectionEligibleField (boolean value) {
      this.requestField("is_canvas_collection_eligible", value);
      return this;
    }
    public APIRequestGet requestLeadFormCreatedTimeField () {
      return this.requestLeadFormCreatedTimeField(true);
    }
    public APIRequestGet requestLeadFormCreatedTimeField (boolean value) {
      this.requestField("lead_form_created_time", value);
      return this;
    }
    public APIRequestGet requestLeadFormNameField () {
      return this.requestLeadFormNameField(true);
    }
    public APIRequestGet requestLeadFormNameField (boolean value) {
      this.requestField("lead_form_name", value);
      return this;
    }
    public APIRequestGet requestLeadGenFormIdField () {
      return this.requestLeadGenFormIdField(true);
    }
    public APIRequestGet requestLeadGenFormIdField (boolean value) {
      this.requestField("lead_gen_form_id", value);
      return this;
    }
    public APIRequestGet requestLeadsCountField () {
      return this.requestLeadsCountField(true);
    }
    public APIRequestGet requestLeadsCountField (boolean value) {
      this.requestField("leads_count", value);
      return this;
    }
    public APIRequestGet requestProductSetIdField () {
      return this.requestProductSetIdField(true);
    }
    public APIRequestGet requestProductSetIdField (boolean value) {
      this.requestField("product_set_id", value);
      return this;
    }
    public APIRequestGet requestUseRetailerItemIdsField () {
      return this.requestUseRetailerItemIdsField(true);
    }
    public APIRequestGet requestUseRetailerItemIdsField (boolean value) {
      this.requestField("use_retailer_item_ids", value);
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

  public CanvasAdSettings copyFrom(CanvasAdSettings instance) {
    this.mIsCanvasCollectionEligible = instance.mIsCanvasCollectionEligible;
    this.mLeadFormCreatedTime = instance.mLeadFormCreatedTime;
    this.mLeadFormName = instance.mLeadFormName;
    this.mLeadGenFormId = instance.mLeadGenFormId;
    this.mLeadsCount = instance.mLeadsCount;
    this.mProductSetId = instance.mProductSetId;
    this.mUseRetailerItemIds = instance.mUseRetailerItemIds;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CanvasAdSettings> getParser() {
    return new APIRequest.ResponseParser<CanvasAdSettings>() {
      public APINodeList<CanvasAdSettings> parseResponse(String response, APIContext context, APIRequest<CanvasAdSettings> request) throws MalformedResponseException {
        return CanvasAdSettings.parseResponse(response, context, request);
      }
    };
  }
}
