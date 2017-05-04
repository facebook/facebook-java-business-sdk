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
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdPlacePageSet extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("location_types")
  private List<String> mLocationTypes = null;
  @SerializedName("name")
  private String mName = null;
  @SerializedName("pages_count")
  private Long mPagesCount = null;
  @SerializedName("parent_page")
  private Object mParentPage = null;
  protected static Gson gson = null;

  AdPlacePageSet() {
  }

  public AdPlacePageSet(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdPlacePageSet(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AdPlacePageSet fetch() throws APIException{
    AdPlacePageSet newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdPlacePageSet fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdPlacePageSet fetchById(String id, APIContext context) throws APIException {
    AdPlacePageSet adPlacePageSet =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adPlacePageSet;
  }

  public static APINodeList<AdPlacePageSet> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdPlacePageSet>)(
      new APIRequest<AdPlacePageSet>(context, "", "/", "GET", AdPlacePageSet.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdPlacePageSet loadJSON(String json, APIContext context) {
    AdPlacePageSet adPlacePageSet = getGson().fromJson(json, AdPlacePageSet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adPlacePageSet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adPlacePageSet.context = context;
    adPlacePageSet.rawValue = json;
    return adPlacePageSet;
  }

  public static APINodeList<AdPlacePageSet> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdPlacePageSet> adPlacePageSets = new APINodeList<AdPlacePageSet>(request, json);
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
          adPlacePageSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adPlacePageSets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adPlacePageSets.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adPlacePageSets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  adPlacePageSets.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adPlacePageSets.add(loadJSON(obj.toString(), context));
            }
          }
          return adPlacePageSets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adPlacePageSets.add(loadJSON(entry.getValue().toString(), context));
          }
          return adPlacePageSets;
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
              adPlacePageSets.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adPlacePageSets;
          }

          // Sixth, check if it's pure JsonObject
          adPlacePageSets.clear();
          adPlacePageSets.add(loadJSON(json, context));
          return adPlacePageSets;
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


  public String getFieldAccountId() {
    return mAccountId;
  }

  public String getFieldId() {
    return mId;
  }

  public List<String> getFieldLocationTypes() {
    return mLocationTypes;
  }

  public String getFieldName() {
    return mName;
  }

  public Long getFieldPagesCount() {
    return mPagesCount;
  }

  public Object getFieldParentPage() {
    return mParentPage;
  }



  public static class APIRequestGet extends APIRequest<AdPlacePageSet> {

    AdPlacePageSet lastResponse = null;
    @Override
    public AdPlacePageSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "id",
      "location_types",
      "name",
      "pages_count",
      "parent_page",
    };

    @Override
    public AdPlacePageSet parseResponse(String response) throws APIException {
      return AdPlacePageSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdPlacePageSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdPlacePageSet execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestLocationTypesField () {
      return this.requestLocationTypesField(true);
    }
    public APIRequestGet requestLocationTypesField (boolean value) {
      this.requestField("location_types", value);
      return this;
    }
    public APIRequestGet requestNameField () {
      return this.requestNameField(true);
    }
    public APIRequestGet requestNameField (boolean value) {
      this.requestField("name", value);
      return this;
    }
    public APIRequestGet requestPagesCountField () {
      return this.requestPagesCountField(true);
    }
    public APIRequestGet requestPagesCountField (boolean value) {
      this.requestField("pages_count", value);
      return this;
    }
    public APIRequestGet requestParentPageField () {
      return this.requestParentPageField(true);
    }
    public APIRequestGet requestParentPageField (boolean value) {
      this.requestField("parent_page", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdPlacePageSet> {

    AdPlacePageSet lastResponse = null;
    @Override
    public AdPlacePageSet getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "name",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdPlacePageSet parseResponse(String response) throws APIException {
      return AdPlacePageSet.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdPlacePageSet execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdPlacePageSet execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

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


    public APIRequestUpdate setName (String name) {
      this.setParam("name", name);
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

  public static enum EnumLocationTypes {
      @SerializedName("recent")
      VALUE_RECENT("recent"),
      @SerializedName("home")
      VALUE_HOME("home"),
      NULL(null);

      private String value;

      private EnumLocationTypes(String value) {
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

  public AdPlacePageSet copyFrom(AdPlacePageSet instance) {
    this.mAccountId = instance.mAccountId;
    this.mId = instance.mId;
    this.mLocationTypes = instance.mLocationTypes;
    this.mName = instance.mName;
    this.mPagesCount = instance.mPagesCount;
    this.mParentPage = instance.mParentPage;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdPlacePageSet> getParser() {
    return new APIRequest.ResponseParser<AdPlacePageSet>() {
      public APINodeList<AdPlacePageSet> parseResponse(String response, APIContext context, APIRequest<AdPlacePageSet> request) throws MalformedResponseException {
        return AdPlacePageSet.parseResponse(response, context, request);
      }
    };
  }
}
