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
public class SignalsIWLExtractor extends APINode {
  @SerializedName("domain_uri")
  private String mDomainUri = null;
  @SerializedName("event_type")
  private String mEventType = null;
  @SerializedName("extractor_config")
  private Object mExtractorConfig = null;
  @SerializedName("extractor_type")
  private String mExtractorType = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  SignalsIWLExtractor() {
  }

  public SignalsIWLExtractor(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public SignalsIWLExtractor(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public SignalsIWLExtractor fetch() throws APIException{
    SignalsIWLExtractor newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static SignalsIWLExtractor fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<SignalsIWLExtractor> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static SignalsIWLExtractor fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<SignalsIWLExtractor> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<SignalsIWLExtractor> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<SignalsIWLExtractor>)(
      new APIRequest<SignalsIWLExtractor>(context, "", "/", "GET", SignalsIWLExtractor.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<SignalsIWLExtractor>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", SignalsIWLExtractor.getParser())
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
  public static SignalsIWLExtractor loadJSON(String json, APIContext context) {
    SignalsIWLExtractor signalsIWLExtractor = getGson().fromJson(json, SignalsIWLExtractor.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(signalsIWLExtractor.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    signalsIWLExtractor.context = context;
    signalsIWLExtractor.rawValue = json;
    return signalsIWLExtractor;
  }

  public static APINodeList<SignalsIWLExtractor> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<SignalsIWLExtractor> signalsIWLExtractors = new APINodeList<SignalsIWLExtractor>(request, json);
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
          signalsIWLExtractors.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return signalsIWLExtractors;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                signalsIWLExtractors.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            signalsIWLExtractors.setPaging(previous, next);
            if (context.hasAppSecret()) {
              signalsIWLExtractors.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              signalsIWLExtractors.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
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
                  signalsIWLExtractors.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              signalsIWLExtractors.add(loadJSON(obj.toString(), context));
            }
          }
          return signalsIWLExtractors;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              signalsIWLExtractors.add(loadJSON(entry.getValue().toString(), context));
          }
          return signalsIWLExtractors;
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
              signalsIWLExtractors.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return signalsIWLExtractors;
          }

          // Sixth, check if it's pure JsonObject
          signalsIWLExtractors.clear();
          signalsIWLExtractors.add(loadJSON(json, context));
          return signalsIWLExtractors;
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

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldDomainUri() {
    return mDomainUri;
  }

  public String getFieldEventType() {
    return mEventType;
  }

  public Object getFieldExtractorConfig() {
    return mExtractorConfig;
  }

  public String getFieldExtractorType() {
    return mExtractorType;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response) throws APIException {
      return APINode.parseResponse(response, getContext(), this).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, APINode>() {
           public APINode apply(String result) {
             try {
               return APIRequestDelete.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<SignalsIWLExtractor> {

    SignalsIWLExtractor lastResponse = null;
    @Override
    public SignalsIWLExtractor getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "domain_uri",
      "event_type",
      "extractor_config",
      "extractor_type",
      "id",
    };

    @Override
    public SignalsIWLExtractor parseResponse(String response) throws APIException {
      return SignalsIWLExtractor.parseResponse(response, getContext(), this).head();
    }

    @Override
    public SignalsIWLExtractor execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SignalsIWLExtractor execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<SignalsIWLExtractor> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SignalsIWLExtractor> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, SignalsIWLExtractor>() {
           public SignalsIWLExtractor apply(String result) {
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

    public APIRequestGet requestDomainUriField () {
      return this.requestDomainUriField(true);
    }
    public APIRequestGet requestDomainUriField (boolean value) {
      this.requestField("domain_uri", value);
      return this;
    }
    public APIRequestGet requestEventTypeField () {
      return this.requestEventTypeField(true);
    }
    public APIRequestGet requestEventTypeField (boolean value) {
      this.requestField("event_type", value);
      return this;
    }
    public APIRequestGet requestExtractorConfigField () {
      return this.requestExtractorConfigField(true);
    }
    public APIRequestGet requestExtractorConfigField (boolean value) {
      this.requestField("extractor_config", value);
      return this;
    }
    public APIRequestGet requestExtractorTypeField () {
      return this.requestExtractorTypeField(true);
    }
    public APIRequestGet requestExtractorTypeField (boolean value) {
      this.requestField("extractor_type", value);
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

  public static class APIRequestUpdate extends APIRequest<SignalsIWLExtractor> {

    SignalsIWLExtractor lastResponse = null;
    @Override
    public SignalsIWLExtractor getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "domain_uri",
      "event_type",
      "extractor_config",
      "extractor_type",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public SignalsIWLExtractor parseResponse(String response) throws APIException {
      return SignalsIWLExtractor.parseResponse(response, getContext(), this).head();
    }

    @Override
    public SignalsIWLExtractor execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public SignalsIWLExtractor execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<SignalsIWLExtractor> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<SignalsIWLExtractor> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, SignalsIWLExtractor>() {
           public SignalsIWLExtractor apply(String result) {
             try {
               return APIRequestUpdate.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
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


    public APIRequestUpdate setDomainUri (Object domainUri) {
      this.setParam("domain_uri", domainUri);
      return this;
    }
    public APIRequestUpdate setDomainUri (String domainUri) {
      this.setParam("domain_uri", domainUri);
      return this;
    }

    public APIRequestUpdate setEventType (SignalsIWLExtractor.EnumEventType eventType) {
      this.setParam("event_type", eventType);
      return this;
    }
    public APIRequestUpdate setEventType (String eventType) {
      this.setParam("event_type", eventType);
      return this;
    }

    public APIRequestUpdate setExtractorConfig (Map<String, String> extractorConfig) {
      this.setParam("extractor_config", extractorConfig);
      return this;
    }
    public APIRequestUpdate setExtractorConfig (String extractorConfig) {
      this.setParam("extractor_config", extractorConfig);
      return this;
    }

    public APIRequestUpdate setExtractorType (SignalsIWLExtractor.EnumExtractorType extractorType) {
      this.setParam("extractor_type", extractorType);
      return this;
    }
    public APIRequestUpdate setExtractorType (String extractorType) {
      this.setParam("extractor_type", extractorType);
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

  public static enum EnumEventType {
      @SerializedName("AddPaymentInfo")
      VALUE_ADDPAYMENTINFO("AddPaymentInfo"),
      @SerializedName("AddToCart")
      VALUE_ADDTOCART("AddToCart"),
      @SerializedName("AddToWishlist")
      VALUE_ADDTOWISHLIST("AddToWishlist"),
      @SerializedName("CompleteRegistration")
      VALUE_COMPLETEREGISTRATION("CompleteRegistration"),
      @SerializedName("Contact")
      VALUE_CONTACT("Contact"),
      @SerializedName("CustomizeProduct")
      VALUE_CUSTOMIZEPRODUCT("CustomizeProduct"),
      @SerializedName("Donate")
      VALUE_DONATE("Donate"),
      @SerializedName("FindLocation")
      VALUE_FINDLOCATION("FindLocation"),
      @SerializedName("InitiateCheckout")
      VALUE_INITIATECHECKOUT("InitiateCheckout"),
      @SerializedName("Lead")
      VALUE_LEAD("Lead"),
      @SerializedName("Other")
      VALUE_OTHER("Other"),
      @SerializedName("Purchase")
      VALUE_PURCHASE("Purchase"),
      @SerializedName("Schedule")
      VALUE_SCHEDULE("Schedule"),
      @SerializedName("Search")
      VALUE_SEARCH("Search"),
      @SerializedName("StartTrial")
      VALUE_STARTTRIAL("StartTrial"),
      @SerializedName("SubmitApplication")
      VALUE_SUBMITAPPLICATION("SubmitApplication"),
      @SerializedName("Subscribe")
      VALUE_SUBSCRIBE("Subscribe"),
      @SerializedName("ViewContent")
      VALUE_VIEWCONTENT("ViewContent"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumEventType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumExtractorType {
      @SerializedName("CONSTANT_VALUE")
      VALUE_CONSTANT_VALUE("CONSTANT_VALUE"),
      @SerializedName("CSS")
      VALUE_CSS("CSS"),
      @SerializedName("GLOBAL_VARIABLE")
      VALUE_GLOBAL_VARIABLE("GLOBAL_VARIABLE"),
      @SerializedName("GTM")
      VALUE_GTM("GTM"),
      @SerializedName("JSON_LD")
      VALUE_JSON_LD("JSON_LD"),
      @SerializedName("META_TAG")
      VALUE_META_TAG("META_TAG"),
      @SerializedName("OPEN_GRAPH")
      VALUE_OPEN_GRAPH("OPEN_GRAPH"),
      @SerializedName("RDFA")
      VALUE_RDFA("RDFA"),
      @SerializedName("SCHEMA_DOT_ORG")
      VALUE_SCHEMA_DOT_ORG("SCHEMA_DOT_ORG"),
      @SerializedName("URI")
      VALUE_URI("URI"),
      NULL(com.facebook.ads.sdk.Consts.NULL_FOR_SWAGGER);

      private String value;

      private EnumExtractorType(String value) {
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

  public SignalsIWLExtractor copyFrom(SignalsIWLExtractor instance) {
    this.mDomainUri = instance.mDomainUri;
    this.mEventType = instance.mEventType;
    this.mExtractorConfig = instance.mExtractorConfig;
    this.mExtractorType = instance.mExtractorType;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<SignalsIWLExtractor> getParser() {
    return new APIRequest.ResponseParser<SignalsIWLExtractor>() {
      public APINodeList<SignalsIWLExtractor> parseResponse(String response, APIContext context, APIRequest<SignalsIWLExtractor> request) throws MalformedResponseException {
        return SignalsIWLExtractor.parseResponse(response, context, request);
      }
    };
  }
}
