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
public class Referral extends APINode {
  @SerializedName("id")
  private String mId = null;
  @SerializedName("invite_limit")
  private Long mInviteLimit = null;
  @SerializedName("messenger_cta")
  private String mMessengerCta = null;
  @SerializedName("messenger_promotion_text")
  private String mMessengerPromotionText = null;
  @SerializedName("namespace")
  private String mNamespace = null;
  @SerializedName("need_promo_code")
  private Boolean mNeedPromoCode = null;
  @SerializedName("offer_origin")
  private String mOfferOrigin = null;
  @SerializedName("promotion_text")
  private String mPromotionText = null;
  @SerializedName("receiver_benefits_text")
  private String mReceiverBenefitsText = null;
  @SerializedName("referral_link_uri")
  private String mReferralLinkUri = null;
  @SerializedName("sender_benefits_text")
  private String mSenderBenefitsText = null;
  protected static Gson gson = null;

  Referral() {
  }

  public Referral(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public Referral(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public Referral fetch() throws APIException{
    Referral newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static Referral fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<Referral> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static Referral fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<Referral> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<Referral> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<Referral>)(
      new APIRequest<Referral>(context, "", "/", "GET", Referral.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<Referral>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", Referral.getParser())
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
  public static Referral loadJSON(String json, APIContext context, String header) {
    Referral referral = getGson().fromJson(json, Referral.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(referral.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    referral.context = context;
    referral.rawValue = json;
    referral.header = header;
    return referral;
  }

  public static APINodeList<Referral> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<Referral> referrals = new APINodeList<Referral>(request, json, header);
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
          referrals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return referrals;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                referrals.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            referrals.setPaging(previous, next);
            if (context.hasAppSecret()) {
              referrals.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              referrals.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  referrals.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              referrals.add(loadJSON(obj.toString(), context, header));
            }
          }
          return referrals;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              referrals.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return referrals;
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
              referrals.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return referrals;
          }

          // Sixth, check if it's pure JsonObject
          referrals.clear();
          referrals.add(loadJSON(json, context, header));
          return referrals;
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


  public String getFieldId() {
    return mId;
  }

  public Long getFieldInviteLimit() {
    return mInviteLimit;
  }

  public String getFieldMessengerCta() {
    return mMessengerCta;
  }

  public String getFieldMessengerPromotionText() {
    return mMessengerPromotionText;
  }

  public String getFieldNamespace() {
    return mNamespace;
  }

  public Boolean getFieldNeedPromoCode() {
    return mNeedPromoCode;
  }

  public String getFieldOfferOrigin() {
    return mOfferOrigin;
  }

  public String getFieldPromotionText() {
    return mPromotionText;
  }

  public String getFieldReceiverBenefitsText() {
    return mReceiverBenefitsText;
  }

  public String getFieldReferralLinkUri() {
    return mReferralLinkUri;
  }

  public String getFieldSenderBenefitsText() {
    return mSenderBenefitsText;
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
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
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

  public static class APIRequestGet extends APIRequest<Referral> {

    Referral lastResponse = null;
    @Override
    public Referral getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "id",
      "invite_limit",
      "messenger_cta",
      "messenger_promotion_text",
      "namespace",
      "need_promo_code",
      "offer_origin",
      "promotion_text",
      "receiver_benefits_text",
      "referral_link_uri",
      "sender_benefits_text",
    };

    @Override
    public Referral parseResponse(String response, String header) throws APIException {
      return Referral.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Referral execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Referral execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Referral> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Referral> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Referral>() {
           public Referral apply(ResponseWrapper result) {
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

    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestInviteLimitField () {
      return this.requestInviteLimitField(true);
    }
    public APIRequestGet requestInviteLimitField (boolean value) {
      this.requestField("invite_limit", value);
      return this;
    }
    public APIRequestGet requestMessengerCtaField () {
      return this.requestMessengerCtaField(true);
    }
    public APIRequestGet requestMessengerCtaField (boolean value) {
      this.requestField("messenger_cta", value);
      return this;
    }
    public APIRequestGet requestMessengerPromotionTextField () {
      return this.requestMessengerPromotionTextField(true);
    }
    public APIRequestGet requestMessengerPromotionTextField (boolean value) {
      this.requestField("messenger_promotion_text", value);
      return this;
    }
    public APIRequestGet requestNamespaceField () {
      return this.requestNamespaceField(true);
    }
    public APIRequestGet requestNamespaceField (boolean value) {
      this.requestField("namespace", value);
      return this;
    }
    public APIRequestGet requestNeedPromoCodeField () {
      return this.requestNeedPromoCodeField(true);
    }
    public APIRequestGet requestNeedPromoCodeField (boolean value) {
      this.requestField("need_promo_code", value);
      return this;
    }
    public APIRequestGet requestOfferOriginField () {
      return this.requestOfferOriginField(true);
    }
    public APIRequestGet requestOfferOriginField (boolean value) {
      this.requestField("offer_origin", value);
      return this;
    }
    public APIRequestGet requestPromotionTextField () {
      return this.requestPromotionTextField(true);
    }
    public APIRequestGet requestPromotionTextField (boolean value) {
      this.requestField("promotion_text", value);
      return this;
    }
    public APIRequestGet requestReceiverBenefitsTextField () {
      return this.requestReceiverBenefitsTextField(true);
    }
    public APIRequestGet requestReceiverBenefitsTextField (boolean value) {
      this.requestField("receiver_benefits_text", value);
      return this;
    }
    public APIRequestGet requestReferralLinkUriField () {
      return this.requestReferralLinkUriField(true);
    }
    public APIRequestGet requestReferralLinkUriField (boolean value) {
      this.requestField("referral_link_uri", value);
      return this;
    }
    public APIRequestGet requestSenderBenefitsTextField () {
      return this.requestSenderBenefitsTextField(true);
    }
    public APIRequestGet requestSenderBenefitsTextField (boolean value) {
      this.requestField("sender_benefits_text", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<Referral> {

    Referral lastResponse = null;
    @Override
    public Referral getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "invite_limit",
      "messenger_cta",
      "messenger_promotion_text",
      "namespace",
      "need_promo_code",
      "offer_origin",
      "promotion_text",
      "receiver_benefits_text",
      "referral_link_uri",
      "sender_benefits_text",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public Referral parseResponse(String response, String header) throws APIException {
      return Referral.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public Referral execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public Referral execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<Referral> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<Referral> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, Referral>() {
           public Referral apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
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


    public APIRequestUpdate setInviteLimit (Long inviteLimit) {
      this.setParam("invite_limit", inviteLimit);
      return this;
    }
    public APIRequestUpdate setInviteLimit (String inviteLimit) {
      this.setParam("invite_limit", inviteLimit);
      return this;
    }

    public APIRequestUpdate setMessengerCta (String messengerCta) {
      this.setParam("messenger_cta", messengerCta);
      return this;
    }

    public APIRequestUpdate setMessengerPromotionText (String messengerPromotionText) {
      this.setParam("messenger_promotion_text", messengerPromotionText);
      return this;
    }

    public APIRequestUpdate setNamespace (Long namespace) {
      this.setParam("namespace", namespace);
      return this;
    }
    public APIRequestUpdate setNamespace (String namespace) {
      this.setParam("namespace", namespace);
      return this;
    }

    public APIRequestUpdate setNeedPromoCode (Boolean needPromoCode) {
      this.setParam("need_promo_code", needPromoCode);
      return this;
    }
    public APIRequestUpdate setNeedPromoCode (String needPromoCode) {
      this.setParam("need_promo_code", needPromoCode);
      return this;
    }

    public APIRequestUpdate setOfferOrigin (String offerOrigin) {
      this.setParam("offer_origin", offerOrigin);
      return this;
    }

    public APIRequestUpdate setPromotionText (String promotionText) {
      this.setParam("promotion_text", promotionText);
      return this;
    }

    public APIRequestUpdate setReceiverBenefitsText (String receiverBenefitsText) {
      this.setParam("receiver_benefits_text", receiverBenefitsText);
      return this;
    }

    public APIRequestUpdate setReferralLinkUri (String referralLinkUri) {
      this.setParam("referral_link_uri", referralLinkUri);
      return this;
    }

    public APIRequestUpdate setSenderBenefitsText (String senderBenefitsText) {
      this.setParam("sender_benefits_text", senderBenefitsText);
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

  public Referral copyFrom(Referral instance) {
    this.mId = instance.mId;
    this.mInviteLimit = instance.mInviteLimit;
    this.mMessengerCta = instance.mMessengerCta;
    this.mMessengerPromotionText = instance.mMessengerPromotionText;
    this.mNamespace = instance.mNamespace;
    this.mNeedPromoCode = instance.mNeedPromoCode;
    this.mOfferOrigin = instance.mOfferOrigin;
    this.mPromotionText = instance.mPromotionText;
    this.mReceiverBenefitsText = instance.mReceiverBenefitsText;
    this.mReferralLinkUri = instance.mReferralLinkUri;
    this.mSenderBenefitsText = instance.mSenderBenefitsText;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<Referral> getParser() {
    return new APIRequest.ResponseParser<Referral>() {
      public APINodeList<Referral> parseResponse(String response, APIContext context, APIRequest<Referral> request, String header) throws MalformedResponseException {
        return Referral.parseResponse(response, context, request, header);
      }
    };
  }
}
