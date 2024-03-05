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
public class DeliveryWindow extends APINode {
  @SerializedName("ad")
  private Long mAd = null;
  @SerializedName("ae")
  private Long mAe = null;
  @SerializedName("af")
  private Long mAf = null;
  @SerializedName("ag")
  private Long mAg = null;
  @SerializedName("ai")
  private Long mAi = null;
  @SerializedName("al")
  private Long mAl = null;
  @SerializedName("all")
  private Long mAll = null;
  @SerializedName("am")
  private Long mAm = null;
  @SerializedName("an")
  private Long mAn = null;
  @SerializedName("ao")
  private Long mAo = null;
  @SerializedName("aq")
  private Long mAq = null;
  @SerializedName("ar")
  private Long mAr = null;
  @SerializedName("as")
  private Long mAs = null;
  @SerializedName("at")
  private Long mAt = null;
  @SerializedName("au")
  private Long mAu = null;
  @SerializedName("aw")
  private Long mAw = null;
  @SerializedName("ax")
  private Long mAx = null;
  @SerializedName("az")
  private Long mAz = null;
  @SerializedName("ba")
  private Long mBa = null;
  @SerializedName("bb")
  private Long mBb = null;
  @SerializedName("bd")
  private Long mBd = null;
  @SerializedName("be")
  private Long mBe = null;
  @SerializedName("bf")
  private Long mBf = null;
  @SerializedName("bg")
  private Long mBg = null;
  @SerializedName("bh")
  private Long mBh = null;
  @SerializedName("bi")
  private Long mBi = null;
  @SerializedName("bj")
  private Long mBj = null;
  @SerializedName("bl")
  private Long mBl = null;
  @SerializedName("bm")
  private Long mBm = null;
  @SerializedName("bn")
  private Long mBn = null;
  @SerializedName("bo")
  private Long mBo = null;
  @SerializedName("bq")
  private Long mBq = null;
  @SerializedName("br")
  private Long mBr = null;
  @SerializedName("bs")
  private Long mBs = null;
  @SerializedName("bt")
  private Long mBt = null;
  @SerializedName("bv")
  private Long mBv = null;
  @SerializedName("bw")
  private Long mBw = null;
  @SerializedName("by")
  private Long mBy = null;
  @SerializedName("bz")
  private Long mBz = null;
  @SerializedName("ca")
  private Long mCa = null;
  @SerializedName("cc")
  private Long mCc = null;
  @SerializedName("cd")
  private Long mCd = null;
  @SerializedName("cf")
  private Long mCf = null;
  @SerializedName("cg")
  private Long mCg = null;
  @SerializedName("ch")
  private Long mCh = null;
  @SerializedName("ci")
  private Long mCi = null;
  @SerializedName("ck")
  private Long mCk = null;
  @SerializedName("cl")
  private Long mCl = null;
  @SerializedName("cm")
  private Long mCm = null;
  @SerializedName("cn")
  private Long mCn = null;
  @SerializedName("co")
  private Long mCo = null;
  @SerializedName("cr")
  private Long mCr = null;
  @SerializedName("cu")
  private Long mCu = null;
  @SerializedName("cv")
  private Long mCv = null;
  @SerializedName("cw")
  private Long mCw = null;
  @SerializedName("cx")
  private Long mCx = null;
  @SerializedName("cy")
  private Long mCy = null;
  @SerializedName("cz")
  private Long mCz = null;
  @SerializedName("de")
  private Long mDe = null;
  @SerializedName("dj")
  private Long mDj = null;
  @SerializedName("dk")
  private Long mDk = null;
  @SerializedName("dm")
  private Long mDm = null;
  @SerializedName("do")
  private Long mDo = null;
  @SerializedName("dz")
  private Long mDz = null;
  @SerializedName("ec")
  private Long mEc = null;
  @SerializedName("ee")
  private Long mEe = null;
  @SerializedName("eg")
  private Long mEg = null;
  @SerializedName("eh")
  private Long mEh = null;
  @SerializedName("er")
  private Long mEr = null;
  @SerializedName("es")
  private Long mEs = null;
  @SerializedName("et")
  private Long mEt = null;
  @SerializedName("fi")
  private Long mFi = null;
  @SerializedName("fj")
  private Long mFj = null;
  @SerializedName("fk")
  private Long mFk = null;
  @SerializedName("fm")
  private Long mFm = null;
  @SerializedName("fo")
  private Long mFo = null;
  @SerializedName("fr")
  private Long mFr = null;
  @SerializedName("ga")
  private Long mGa = null;
  @SerializedName("gb")
  private Long mGb = null;
  @SerializedName("gd")
  private Long mGd = null;
  @SerializedName("ge")
  private Long mGe = null;
  @SerializedName("gf")
  private Long mGf = null;
  @SerializedName("gg")
  private Long mGg = null;
  @SerializedName("gh")
  private Long mGh = null;
  @SerializedName("gi")
  private Long mGi = null;
  @SerializedName("gl")
  private Long mGl = null;
  @SerializedName("gm")
  private Long mGm = null;
  @SerializedName("gn")
  private Long mGn = null;
  @SerializedName("gp")
  private Long mGp = null;
  @SerializedName("gq")
  private Long mGq = null;
  @SerializedName("gr")
  private Long mGr = null;
  @SerializedName("gs")
  private Long mGs = null;
  @SerializedName("gt")
  private Long mGt = null;
  @SerializedName("gu")
  private Long mGu = null;
  @SerializedName("gw")
  private Long mGw = null;
  @SerializedName("gy")
  private Long mGy = null;
  @SerializedName("hk")
  private Long mHk = null;
  @SerializedName("hm")
  private Long mHm = null;
  @SerializedName("hn")
  private Long mHn = null;
  @SerializedName("hr")
  private Long mHr = null;
  @SerializedName("ht")
  private Long mHt = null;
  @SerializedName("hu")
  private Long mHu = null;
  @SerializedName("id")
  private Long mId = null;
  @SerializedName("ie")
  private Long mIe = null;
  @SerializedName("il")
  private Long mIl = null;
  @SerializedName("im")
  private Long mIm = null;
  @SerializedName("in")
  private Long mIn = null;
  @SerializedName("io")
  private Long mIo = null;
  @SerializedName("iq")
  private Long mIq = null;
  @SerializedName("ir")
  private Long mIr = null;
  @SerializedName("is")
  private Long mIs = null;
  @SerializedName("it")
  private Long mIt = null;
  @SerializedName("je")
  private Long mJe = null;
  @SerializedName("jm")
  private Long mJm = null;
  @SerializedName("jo")
  private Long mJo = null;
  @SerializedName("jp")
  private Long mJp = null;
  @SerializedName("ke")
  private Long mKe = null;
  @SerializedName("kg")
  private Long mKg = null;
  @SerializedName("kh")
  private Long mKh = null;
  @SerializedName("ki")
  private Long mKi = null;
  @SerializedName("km")
  private Long mKm = null;
  @SerializedName("kn")
  private Long mKn = null;
  @SerializedName("kp")
  private Long mKp = null;
  @SerializedName("kr")
  private Long mKr = null;
  @SerializedName("kw")
  private Long mKw = null;
  @SerializedName("ky")
  private Long mKy = null;
  @SerializedName("kz")
  private Long mKz = null;
  @SerializedName("la")
  private Long mLa = null;
  @SerializedName("lb")
  private Long mLb = null;
  @SerializedName("lc")
  private Long mLc = null;
  @SerializedName("li")
  private Long mLi = null;
  @SerializedName("lk")
  private Long mLk = null;
  @SerializedName("lr")
  private Long mLr = null;
  @SerializedName("ls")
  private Long mLs = null;
  @SerializedName("lt")
  private Long mLt = null;
  @SerializedName("lu")
  private Long mLu = null;
  @SerializedName("lv")
  private Long mLv = null;
  @SerializedName("ly")
  private Long mLy = null;
  @SerializedName("ma")
  private Long mMa = null;
  @SerializedName("mc")
  private Long mMc = null;
  @SerializedName("md")
  private Long mMd = null;
  @SerializedName("me")
  private Long mMe = null;
  @SerializedName("mf")
  private Long mMf = null;
  @SerializedName("mg")
  private Long mMg = null;
  @SerializedName("mh")
  private Long mMh = null;
  @SerializedName("mk")
  private Long mMk = null;
  @SerializedName("ml")
  private Long mMl = null;
  @SerializedName("mm")
  private Long mMm = null;
  @SerializedName("mn")
  private Long mMn = null;
  @SerializedName("mo")
  private Long mMo = null;
  @SerializedName("mp")
  private Long mMp = null;
  @SerializedName("mq")
  private Long mMq = null;
  @SerializedName("mr")
  private Long mMr = null;
  @SerializedName("ms")
  private Long mMs = null;
  @SerializedName("mt")
  private Long mMt = null;
  @SerializedName("mu")
  private Long mMu = null;
  @SerializedName("mv")
  private Long mMv = null;
  @SerializedName("mw")
  private Long mMw = null;
  @SerializedName("mx")
  private Long mMx = null;
  @SerializedName("my")
  private Long mMy = null;
  @SerializedName("mz")
  private Long mMz = null;
  @SerializedName("na")
  private Long mNa = null;
  @SerializedName("nc")
  private Long mNc = null;
  @SerializedName("ne")
  private Long mNe = null;
  @SerializedName("nf")
  private Long mNf = null;
  @SerializedName("ng")
  private Long mNg = null;
  @SerializedName("ni")
  private Long mNi = null;
  @SerializedName("nl")
  private Long mNl = null;
  @SerializedName("no")
  private Long mNo = null;
  @SerializedName("np")
  private Long mNp = null;
  @SerializedName("nr")
  private Long mNr = null;
  @SerializedName("nu")
  private Long mNu = null;
  @SerializedName("nz")
  private Long mNz = null;
  @SerializedName("om")
  private Long mOm = null;
  @SerializedName("pa")
  private Long mPa = null;
  @SerializedName("pe")
  private Long mPe = null;
  @SerializedName("pf")
  private Long mPf = null;
  @SerializedName("pg")
  private Long mPg = null;
  @SerializedName("ph")
  private Long mPh = null;
  @SerializedName("pk")
  private Long mPk = null;
  @SerializedName("pl")
  private Long mPl = null;
  @SerializedName("pm")
  private Long mPm = null;
  @SerializedName("pn")
  private Long mPn = null;
  @SerializedName("pr")
  private Long mPr = null;
  @SerializedName("ps")
  private Long mPs = null;
  @SerializedName("pt")
  private Long mPt = null;
  @SerializedName("pw")
  private Long mPw = null;
  @SerializedName("py")
  private Long mPy = null;
  @SerializedName("qa")
  private Long mQa = null;
  @SerializedName("re")
  private Long mRe = null;
  @SerializedName("ro")
  private Long mRo = null;
  @SerializedName("rs")
  private Long mRs = null;
  @SerializedName("ru")
  private Long mRu = null;
  @SerializedName("rw")
  private Long mRw = null;
  @SerializedName("sa")
  private Long mSa = null;
  @SerializedName("sb")
  private Long mSb = null;
  @SerializedName("sc")
  private Long mSc = null;
  @SerializedName("sd")
  private Long mSd = null;
  @SerializedName("se")
  private Long mSe = null;
  @SerializedName("sg")
  private Long mSg = null;
  @SerializedName("sh")
  private Long mSh = null;
  @SerializedName("si")
  private Long mSi = null;
  @SerializedName("sj")
  private Long mSj = null;
  @SerializedName("sk")
  private Long mSk = null;
  @SerializedName("sl")
  private Long mSl = null;
  @SerializedName("sm")
  private Long mSm = null;
  @SerializedName("sn")
  private Long mSn = null;
  @SerializedName("so")
  private Long mSo = null;
  @SerializedName("sr")
  private Long mSr = null;
  @SerializedName("ss")
  private Long mSs = null;
  @SerializedName("st")
  private Long mSt = null;
  @SerializedName("sv")
  private Long mSv = null;
  @SerializedName("sx")
  private Long mSx = null;
  @SerializedName("sy")
  private Long mSy = null;
  @SerializedName("sz")
  private Long mSz = null;
  @SerializedName("tc")
  private Long mTc = null;
  @SerializedName("td")
  private Long mTd = null;
  @SerializedName("tf")
  private Long mTf = null;
  @SerializedName("tg")
  private Long mTg = null;
  @SerializedName("th")
  private Long mTh = null;
  @SerializedName("tj")
  private Long mTj = null;
  @SerializedName("tk")
  private Long mTk = null;
  @SerializedName("tl")
  private Long mTl = null;
  @SerializedName("tm")
  private Long mTm = null;
  @SerializedName("tn")
  private Long mTn = null;
  @SerializedName("to")
  private Long mTo = null;
  @SerializedName("tr")
  private Long mTr = null;
  @SerializedName("tt")
  private Long mTt = null;
  @SerializedName("tv")
  private Long mTv = null;
  @SerializedName("tw")
  private Long mTw = null;
  @SerializedName("tz")
  private Long mTz = null;
  @SerializedName("ua")
  private Long mUa = null;
  @SerializedName("ug")
  private Long mUg = null;
  @SerializedName("um")
  private Long mUm = null;
  @SerializedName("us")
  private Long mUs = null;
  @SerializedName("uy")
  private Long mUy = null;
  @SerializedName("uz")
  private Long mUz = null;
  @SerializedName("va")
  private Long mVa = null;
  @SerializedName("vc")
  private Long mVc = null;
  @SerializedName("ve")
  private Long mVe = null;
  @SerializedName("vg")
  private Long mVg = null;
  @SerializedName("vi")
  private Long mVi = null;
  @SerializedName("vn")
  private Long mVn = null;
  @SerializedName("vu")
  private Long mVu = null;
  @SerializedName("wf")
  private Long mWf = null;
  @SerializedName("ws")
  private Long mWs = null;
  @SerializedName("xk")
  private Long mXk = null;
  @SerializedName("ye")
  private Long mYe = null;
  @SerializedName("yt")
  private Long mYt = null;
  @SerializedName("za")
  private Long mZa = null;
  @SerializedName("zm")
  private Long mZm = null;
  @SerializedName("zw")
  private Long mZw = null;
  protected static Gson gson = null;

  public DeliveryWindow() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static DeliveryWindow loadJSON(String json, APIContext context, String header) {
    DeliveryWindow deliveryWindow = getGson().fromJson(json, DeliveryWindow.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(deliveryWindow.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    deliveryWindow.context = context;
    deliveryWindow.rawValue = json;
    deliveryWindow.header = header;
    return deliveryWindow;
  }

  public static APINodeList<DeliveryWindow> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<DeliveryWindow> deliveryWindows = new APINodeList<DeliveryWindow>(request, json, header);
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
          deliveryWindows.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return deliveryWindows;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                deliveryWindows.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            deliveryWindows.setPaging(previous, next);
            if (context.hasAppSecret()) {
              deliveryWindows.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              deliveryWindows.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  deliveryWindows.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              deliveryWindows.add(loadJSON(obj.toString(), context, header));
            }
          }
          return deliveryWindows;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              deliveryWindows.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return deliveryWindows;
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
              deliveryWindows.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return deliveryWindows;
          }

          // Sixth, check if it's pure JsonObject
          deliveryWindows.clear();
          deliveryWindows.add(loadJSON(json, context, header));
          return deliveryWindows;
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


  public Long getFieldAd() {
    return mAd;
  }

  public DeliveryWindow setFieldAd(Long value) {
    this.mAd = value;
    return this;
  }

  public Long getFieldAe() {
    return mAe;
  }

  public DeliveryWindow setFieldAe(Long value) {
    this.mAe = value;
    return this;
  }

  public Long getFieldAf() {
    return mAf;
  }

  public DeliveryWindow setFieldAf(Long value) {
    this.mAf = value;
    return this;
  }

  public Long getFieldAg() {
    return mAg;
  }

  public DeliveryWindow setFieldAg(Long value) {
    this.mAg = value;
    return this;
  }

  public Long getFieldAi() {
    return mAi;
  }

  public DeliveryWindow setFieldAi(Long value) {
    this.mAi = value;
    return this;
  }

  public Long getFieldAl() {
    return mAl;
  }

  public DeliveryWindow setFieldAl(Long value) {
    this.mAl = value;
    return this;
  }

  public Long getFieldAll() {
    return mAll;
  }

  public DeliveryWindow setFieldAll(Long value) {
    this.mAll = value;
    return this;
  }

  public Long getFieldAm() {
    return mAm;
  }

  public DeliveryWindow setFieldAm(Long value) {
    this.mAm = value;
    return this;
  }

  public Long getFieldAn() {
    return mAn;
  }

  public DeliveryWindow setFieldAn(Long value) {
    this.mAn = value;
    return this;
  }

  public Long getFieldAo() {
    return mAo;
  }

  public DeliveryWindow setFieldAo(Long value) {
    this.mAo = value;
    return this;
  }

  public Long getFieldAq() {
    return mAq;
  }

  public DeliveryWindow setFieldAq(Long value) {
    this.mAq = value;
    return this;
  }

  public Long getFieldAr() {
    return mAr;
  }

  public DeliveryWindow setFieldAr(Long value) {
    this.mAr = value;
    return this;
  }

  public Long getFieldAs() {
    return mAs;
  }

  public DeliveryWindow setFieldAs(Long value) {
    this.mAs = value;
    return this;
  }

  public Long getFieldAt() {
    return mAt;
  }

  public DeliveryWindow setFieldAt(Long value) {
    this.mAt = value;
    return this;
  }

  public Long getFieldAu() {
    return mAu;
  }

  public DeliveryWindow setFieldAu(Long value) {
    this.mAu = value;
    return this;
  }

  public Long getFieldAw() {
    return mAw;
  }

  public DeliveryWindow setFieldAw(Long value) {
    this.mAw = value;
    return this;
  }

  public Long getFieldAx() {
    return mAx;
  }

  public DeliveryWindow setFieldAx(Long value) {
    this.mAx = value;
    return this;
  }

  public Long getFieldAz() {
    return mAz;
  }

  public DeliveryWindow setFieldAz(Long value) {
    this.mAz = value;
    return this;
  }

  public Long getFieldBa() {
    return mBa;
  }

  public DeliveryWindow setFieldBa(Long value) {
    this.mBa = value;
    return this;
  }

  public Long getFieldBb() {
    return mBb;
  }

  public DeliveryWindow setFieldBb(Long value) {
    this.mBb = value;
    return this;
  }

  public Long getFieldBd() {
    return mBd;
  }

  public DeliveryWindow setFieldBd(Long value) {
    this.mBd = value;
    return this;
  }

  public Long getFieldBe() {
    return mBe;
  }

  public DeliveryWindow setFieldBe(Long value) {
    this.mBe = value;
    return this;
  }

  public Long getFieldBf() {
    return mBf;
  }

  public DeliveryWindow setFieldBf(Long value) {
    this.mBf = value;
    return this;
  }

  public Long getFieldBg() {
    return mBg;
  }

  public DeliveryWindow setFieldBg(Long value) {
    this.mBg = value;
    return this;
  }

  public Long getFieldBh() {
    return mBh;
  }

  public DeliveryWindow setFieldBh(Long value) {
    this.mBh = value;
    return this;
  }

  public Long getFieldBi() {
    return mBi;
  }

  public DeliveryWindow setFieldBi(Long value) {
    this.mBi = value;
    return this;
  }

  public Long getFieldBj() {
    return mBj;
  }

  public DeliveryWindow setFieldBj(Long value) {
    this.mBj = value;
    return this;
  }

  public Long getFieldBl() {
    return mBl;
  }

  public DeliveryWindow setFieldBl(Long value) {
    this.mBl = value;
    return this;
  }

  public Long getFieldBm() {
    return mBm;
  }

  public DeliveryWindow setFieldBm(Long value) {
    this.mBm = value;
    return this;
  }

  public Long getFieldBn() {
    return mBn;
  }

  public DeliveryWindow setFieldBn(Long value) {
    this.mBn = value;
    return this;
  }

  public Long getFieldBo() {
    return mBo;
  }

  public DeliveryWindow setFieldBo(Long value) {
    this.mBo = value;
    return this;
  }

  public Long getFieldBq() {
    return mBq;
  }

  public DeliveryWindow setFieldBq(Long value) {
    this.mBq = value;
    return this;
  }

  public Long getFieldBr() {
    return mBr;
  }

  public DeliveryWindow setFieldBr(Long value) {
    this.mBr = value;
    return this;
  }

  public Long getFieldBs() {
    return mBs;
  }

  public DeliveryWindow setFieldBs(Long value) {
    this.mBs = value;
    return this;
  }

  public Long getFieldBt() {
    return mBt;
  }

  public DeliveryWindow setFieldBt(Long value) {
    this.mBt = value;
    return this;
  }

  public Long getFieldBv() {
    return mBv;
  }

  public DeliveryWindow setFieldBv(Long value) {
    this.mBv = value;
    return this;
  }

  public Long getFieldBw() {
    return mBw;
  }

  public DeliveryWindow setFieldBw(Long value) {
    this.mBw = value;
    return this;
  }

  public Long getFieldBy() {
    return mBy;
  }

  public DeliveryWindow setFieldBy(Long value) {
    this.mBy = value;
    return this;
  }

  public Long getFieldBz() {
    return mBz;
  }

  public DeliveryWindow setFieldBz(Long value) {
    this.mBz = value;
    return this;
  }

  public Long getFieldCa() {
    return mCa;
  }

  public DeliveryWindow setFieldCa(Long value) {
    this.mCa = value;
    return this;
  }

  public Long getFieldCc() {
    return mCc;
  }

  public DeliveryWindow setFieldCc(Long value) {
    this.mCc = value;
    return this;
  }

  public Long getFieldCd() {
    return mCd;
  }

  public DeliveryWindow setFieldCd(Long value) {
    this.mCd = value;
    return this;
  }

  public Long getFieldCf() {
    return mCf;
  }

  public DeliveryWindow setFieldCf(Long value) {
    this.mCf = value;
    return this;
  }

  public Long getFieldCg() {
    return mCg;
  }

  public DeliveryWindow setFieldCg(Long value) {
    this.mCg = value;
    return this;
  }

  public Long getFieldCh() {
    return mCh;
  }

  public DeliveryWindow setFieldCh(Long value) {
    this.mCh = value;
    return this;
  }

  public Long getFieldCi() {
    return mCi;
  }

  public DeliveryWindow setFieldCi(Long value) {
    this.mCi = value;
    return this;
  }

  public Long getFieldCk() {
    return mCk;
  }

  public DeliveryWindow setFieldCk(Long value) {
    this.mCk = value;
    return this;
  }

  public Long getFieldCl() {
    return mCl;
  }

  public DeliveryWindow setFieldCl(Long value) {
    this.mCl = value;
    return this;
  }

  public Long getFieldCm() {
    return mCm;
  }

  public DeliveryWindow setFieldCm(Long value) {
    this.mCm = value;
    return this;
  }

  public Long getFieldCn() {
    return mCn;
  }

  public DeliveryWindow setFieldCn(Long value) {
    this.mCn = value;
    return this;
  }

  public Long getFieldCo() {
    return mCo;
  }

  public DeliveryWindow setFieldCo(Long value) {
    this.mCo = value;
    return this;
  }

  public Long getFieldCr() {
    return mCr;
  }

  public DeliveryWindow setFieldCr(Long value) {
    this.mCr = value;
    return this;
  }

  public Long getFieldCu() {
    return mCu;
  }

  public DeliveryWindow setFieldCu(Long value) {
    this.mCu = value;
    return this;
  }

  public Long getFieldCv() {
    return mCv;
  }

  public DeliveryWindow setFieldCv(Long value) {
    this.mCv = value;
    return this;
  }

  public Long getFieldCw() {
    return mCw;
  }

  public DeliveryWindow setFieldCw(Long value) {
    this.mCw = value;
    return this;
  }

  public Long getFieldCx() {
    return mCx;
  }

  public DeliveryWindow setFieldCx(Long value) {
    this.mCx = value;
    return this;
  }

  public Long getFieldCy() {
    return mCy;
  }

  public DeliveryWindow setFieldCy(Long value) {
    this.mCy = value;
    return this;
  }

  public Long getFieldCz() {
    return mCz;
  }

  public DeliveryWindow setFieldCz(Long value) {
    this.mCz = value;
    return this;
  }

  public Long getFieldDe() {
    return mDe;
  }

  public DeliveryWindow setFieldDe(Long value) {
    this.mDe = value;
    return this;
  }

  public Long getFieldDj() {
    return mDj;
  }

  public DeliveryWindow setFieldDj(Long value) {
    this.mDj = value;
    return this;
  }

  public Long getFieldDk() {
    return mDk;
  }

  public DeliveryWindow setFieldDk(Long value) {
    this.mDk = value;
    return this;
  }

  public Long getFieldDm() {
    return mDm;
  }

  public DeliveryWindow setFieldDm(Long value) {
    this.mDm = value;
    return this;
  }

  public Long getFieldDo() {
    return mDo;
  }

  public DeliveryWindow setFieldDo(Long value) {
    this.mDo = value;
    return this;
  }

  public Long getFieldDz() {
    return mDz;
  }

  public DeliveryWindow setFieldDz(Long value) {
    this.mDz = value;
    return this;
  }

  public Long getFieldEc() {
    return mEc;
  }

  public DeliveryWindow setFieldEc(Long value) {
    this.mEc = value;
    return this;
  }

  public Long getFieldEe() {
    return mEe;
  }

  public DeliveryWindow setFieldEe(Long value) {
    this.mEe = value;
    return this;
  }

  public Long getFieldEg() {
    return mEg;
  }

  public DeliveryWindow setFieldEg(Long value) {
    this.mEg = value;
    return this;
  }

  public Long getFieldEh() {
    return mEh;
  }

  public DeliveryWindow setFieldEh(Long value) {
    this.mEh = value;
    return this;
  }

  public Long getFieldEr() {
    return mEr;
  }

  public DeliveryWindow setFieldEr(Long value) {
    this.mEr = value;
    return this;
  }

  public Long getFieldEs() {
    return mEs;
  }

  public DeliveryWindow setFieldEs(Long value) {
    this.mEs = value;
    return this;
  }

  public Long getFieldEt() {
    return mEt;
  }

  public DeliveryWindow setFieldEt(Long value) {
    this.mEt = value;
    return this;
  }

  public Long getFieldFi() {
    return mFi;
  }

  public DeliveryWindow setFieldFi(Long value) {
    this.mFi = value;
    return this;
  }

  public Long getFieldFj() {
    return mFj;
  }

  public DeliveryWindow setFieldFj(Long value) {
    this.mFj = value;
    return this;
  }

  public Long getFieldFk() {
    return mFk;
  }

  public DeliveryWindow setFieldFk(Long value) {
    this.mFk = value;
    return this;
  }

  public Long getFieldFm() {
    return mFm;
  }

  public DeliveryWindow setFieldFm(Long value) {
    this.mFm = value;
    return this;
  }

  public Long getFieldFo() {
    return mFo;
  }

  public DeliveryWindow setFieldFo(Long value) {
    this.mFo = value;
    return this;
  }

  public Long getFieldFr() {
    return mFr;
  }

  public DeliveryWindow setFieldFr(Long value) {
    this.mFr = value;
    return this;
  }

  public Long getFieldGa() {
    return mGa;
  }

  public DeliveryWindow setFieldGa(Long value) {
    this.mGa = value;
    return this;
  }

  public Long getFieldGb() {
    return mGb;
  }

  public DeliveryWindow setFieldGb(Long value) {
    this.mGb = value;
    return this;
  }

  public Long getFieldGd() {
    return mGd;
  }

  public DeliveryWindow setFieldGd(Long value) {
    this.mGd = value;
    return this;
  }

  public Long getFieldGe() {
    return mGe;
  }

  public DeliveryWindow setFieldGe(Long value) {
    this.mGe = value;
    return this;
  }

  public Long getFieldGf() {
    return mGf;
  }

  public DeliveryWindow setFieldGf(Long value) {
    this.mGf = value;
    return this;
  }

  public Long getFieldGg() {
    return mGg;
  }

  public DeliveryWindow setFieldGg(Long value) {
    this.mGg = value;
    return this;
  }

  public Long getFieldGh() {
    return mGh;
  }

  public DeliveryWindow setFieldGh(Long value) {
    this.mGh = value;
    return this;
  }

  public Long getFieldGi() {
    return mGi;
  }

  public DeliveryWindow setFieldGi(Long value) {
    this.mGi = value;
    return this;
  }

  public Long getFieldGl() {
    return mGl;
  }

  public DeliveryWindow setFieldGl(Long value) {
    this.mGl = value;
    return this;
  }

  public Long getFieldGm() {
    return mGm;
  }

  public DeliveryWindow setFieldGm(Long value) {
    this.mGm = value;
    return this;
  }

  public Long getFieldGn() {
    return mGn;
  }

  public DeliveryWindow setFieldGn(Long value) {
    this.mGn = value;
    return this;
  }

  public Long getFieldGp() {
    return mGp;
  }

  public DeliveryWindow setFieldGp(Long value) {
    this.mGp = value;
    return this;
  }

  public Long getFieldGq() {
    return mGq;
  }

  public DeliveryWindow setFieldGq(Long value) {
    this.mGq = value;
    return this;
  }

  public Long getFieldGr() {
    return mGr;
  }

  public DeliveryWindow setFieldGr(Long value) {
    this.mGr = value;
    return this;
  }

  public Long getFieldGs() {
    return mGs;
  }

  public DeliveryWindow setFieldGs(Long value) {
    this.mGs = value;
    return this;
  }

  public Long getFieldGt() {
    return mGt;
  }

  public DeliveryWindow setFieldGt(Long value) {
    this.mGt = value;
    return this;
  }

  public Long getFieldGu() {
    return mGu;
  }

  public DeliveryWindow setFieldGu(Long value) {
    this.mGu = value;
    return this;
  }

  public Long getFieldGw() {
    return mGw;
  }

  public DeliveryWindow setFieldGw(Long value) {
    this.mGw = value;
    return this;
  }

  public Long getFieldGy() {
    return mGy;
  }

  public DeliveryWindow setFieldGy(Long value) {
    this.mGy = value;
    return this;
  }

  public Long getFieldHk() {
    return mHk;
  }

  public DeliveryWindow setFieldHk(Long value) {
    this.mHk = value;
    return this;
  }

  public Long getFieldHm() {
    return mHm;
  }

  public DeliveryWindow setFieldHm(Long value) {
    this.mHm = value;
    return this;
  }

  public Long getFieldHn() {
    return mHn;
  }

  public DeliveryWindow setFieldHn(Long value) {
    this.mHn = value;
    return this;
  }

  public Long getFieldHr() {
    return mHr;
  }

  public DeliveryWindow setFieldHr(Long value) {
    this.mHr = value;
    return this;
  }

  public Long getFieldHt() {
    return mHt;
  }

  public DeliveryWindow setFieldHt(Long value) {
    this.mHt = value;
    return this;
  }

  public Long getFieldHu() {
    return mHu;
  }

  public DeliveryWindow setFieldHu(Long value) {
    this.mHu = value;
    return this;
  }

  public Long getFieldId() {
    return mId;
  }

  public DeliveryWindow setFieldId(Long value) {
    this.mId = value;
    return this;
  }

  public Long getFieldIe() {
    return mIe;
  }

  public DeliveryWindow setFieldIe(Long value) {
    this.mIe = value;
    return this;
  }

  public Long getFieldIl() {
    return mIl;
  }

  public DeliveryWindow setFieldIl(Long value) {
    this.mIl = value;
    return this;
  }

  public Long getFieldIm() {
    return mIm;
  }

  public DeliveryWindow setFieldIm(Long value) {
    this.mIm = value;
    return this;
  }

  public Long getFieldIn() {
    return mIn;
  }

  public DeliveryWindow setFieldIn(Long value) {
    this.mIn = value;
    return this;
  }

  public Long getFieldIo() {
    return mIo;
  }

  public DeliveryWindow setFieldIo(Long value) {
    this.mIo = value;
    return this;
  }

  public Long getFieldIq() {
    return mIq;
  }

  public DeliveryWindow setFieldIq(Long value) {
    this.mIq = value;
    return this;
  }

  public Long getFieldIr() {
    return mIr;
  }

  public DeliveryWindow setFieldIr(Long value) {
    this.mIr = value;
    return this;
  }

  public Long getFieldIs() {
    return mIs;
  }

  public DeliveryWindow setFieldIs(Long value) {
    this.mIs = value;
    return this;
  }

  public Long getFieldIt() {
    return mIt;
  }

  public DeliveryWindow setFieldIt(Long value) {
    this.mIt = value;
    return this;
  }

  public Long getFieldJe() {
    return mJe;
  }

  public DeliveryWindow setFieldJe(Long value) {
    this.mJe = value;
    return this;
  }

  public Long getFieldJm() {
    return mJm;
  }

  public DeliveryWindow setFieldJm(Long value) {
    this.mJm = value;
    return this;
  }

  public Long getFieldJo() {
    return mJo;
  }

  public DeliveryWindow setFieldJo(Long value) {
    this.mJo = value;
    return this;
  }

  public Long getFieldJp() {
    return mJp;
  }

  public DeliveryWindow setFieldJp(Long value) {
    this.mJp = value;
    return this;
  }

  public Long getFieldKe() {
    return mKe;
  }

  public DeliveryWindow setFieldKe(Long value) {
    this.mKe = value;
    return this;
  }

  public Long getFieldKg() {
    return mKg;
  }

  public DeliveryWindow setFieldKg(Long value) {
    this.mKg = value;
    return this;
  }

  public Long getFieldKh() {
    return mKh;
  }

  public DeliveryWindow setFieldKh(Long value) {
    this.mKh = value;
    return this;
  }

  public Long getFieldKi() {
    return mKi;
  }

  public DeliveryWindow setFieldKi(Long value) {
    this.mKi = value;
    return this;
  }

  public Long getFieldKm() {
    return mKm;
  }

  public DeliveryWindow setFieldKm(Long value) {
    this.mKm = value;
    return this;
  }

  public Long getFieldKn() {
    return mKn;
  }

  public DeliveryWindow setFieldKn(Long value) {
    this.mKn = value;
    return this;
  }

  public Long getFieldKp() {
    return mKp;
  }

  public DeliveryWindow setFieldKp(Long value) {
    this.mKp = value;
    return this;
  }

  public Long getFieldKr() {
    return mKr;
  }

  public DeliveryWindow setFieldKr(Long value) {
    this.mKr = value;
    return this;
  }

  public Long getFieldKw() {
    return mKw;
  }

  public DeliveryWindow setFieldKw(Long value) {
    this.mKw = value;
    return this;
  }

  public Long getFieldKy() {
    return mKy;
  }

  public DeliveryWindow setFieldKy(Long value) {
    this.mKy = value;
    return this;
  }

  public Long getFieldKz() {
    return mKz;
  }

  public DeliveryWindow setFieldKz(Long value) {
    this.mKz = value;
    return this;
  }

  public Long getFieldLa() {
    return mLa;
  }

  public DeliveryWindow setFieldLa(Long value) {
    this.mLa = value;
    return this;
  }

  public Long getFieldLb() {
    return mLb;
  }

  public DeliveryWindow setFieldLb(Long value) {
    this.mLb = value;
    return this;
  }

  public Long getFieldLc() {
    return mLc;
  }

  public DeliveryWindow setFieldLc(Long value) {
    this.mLc = value;
    return this;
  }

  public Long getFieldLi() {
    return mLi;
  }

  public DeliveryWindow setFieldLi(Long value) {
    this.mLi = value;
    return this;
  }

  public Long getFieldLk() {
    return mLk;
  }

  public DeliveryWindow setFieldLk(Long value) {
    this.mLk = value;
    return this;
  }

  public Long getFieldLr() {
    return mLr;
  }

  public DeliveryWindow setFieldLr(Long value) {
    this.mLr = value;
    return this;
  }

  public Long getFieldLs() {
    return mLs;
  }

  public DeliveryWindow setFieldLs(Long value) {
    this.mLs = value;
    return this;
  }

  public Long getFieldLt() {
    return mLt;
  }

  public DeliveryWindow setFieldLt(Long value) {
    this.mLt = value;
    return this;
  }

  public Long getFieldLu() {
    return mLu;
  }

  public DeliveryWindow setFieldLu(Long value) {
    this.mLu = value;
    return this;
  }

  public Long getFieldLv() {
    return mLv;
  }

  public DeliveryWindow setFieldLv(Long value) {
    this.mLv = value;
    return this;
  }

  public Long getFieldLy() {
    return mLy;
  }

  public DeliveryWindow setFieldLy(Long value) {
    this.mLy = value;
    return this;
  }

  public Long getFieldMa() {
    return mMa;
  }

  public DeliveryWindow setFieldMa(Long value) {
    this.mMa = value;
    return this;
  }

  public Long getFieldMc() {
    return mMc;
  }

  public DeliveryWindow setFieldMc(Long value) {
    this.mMc = value;
    return this;
  }

  public Long getFieldMd() {
    return mMd;
  }

  public DeliveryWindow setFieldMd(Long value) {
    this.mMd = value;
    return this;
  }

  public Long getFieldMe() {
    return mMe;
  }

  public DeliveryWindow setFieldMe(Long value) {
    this.mMe = value;
    return this;
  }

  public Long getFieldMf() {
    return mMf;
  }

  public DeliveryWindow setFieldMf(Long value) {
    this.mMf = value;
    return this;
  }

  public Long getFieldMg() {
    return mMg;
  }

  public DeliveryWindow setFieldMg(Long value) {
    this.mMg = value;
    return this;
  }

  public Long getFieldMh() {
    return mMh;
  }

  public DeliveryWindow setFieldMh(Long value) {
    this.mMh = value;
    return this;
  }

  public Long getFieldMk() {
    return mMk;
  }

  public DeliveryWindow setFieldMk(Long value) {
    this.mMk = value;
    return this;
  }

  public Long getFieldMl() {
    return mMl;
  }

  public DeliveryWindow setFieldMl(Long value) {
    this.mMl = value;
    return this;
  }

  public Long getFieldMm() {
    return mMm;
  }

  public DeliveryWindow setFieldMm(Long value) {
    this.mMm = value;
    return this;
  }

  public Long getFieldMn() {
    return mMn;
  }

  public DeliveryWindow setFieldMn(Long value) {
    this.mMn = value;
    return this;
  }

  public Long getFieldMo() {
    return mMo;
  }

  public DeliveryWindow setFieldMo(Long value) {
    this.mMo = value;
    return this;
  }

  public Long getFieldMp() {
    return mMp;
  }

  public DeliveryWindow setFieldMp(Long value) {
    this.mMp = value;
    return this;
  }

  public Long getFieldMq() {
    return mMq;
  }

  public DeliveryWindow setFieldMq(Long value) {
    this.mMq = value;
    return this;
  }

  public Long getFieldMr() {
    return mMr;
  }

  public DeliveryWindow setFieldMr(Long value) {
    this.mMr = value;
    return this;
  }

  public Long getFieldMs() {
    return mMs;
  }

  public DeliveryWindow setFieldMs(Long value) {
    this.mMs = value;
    return this;
  }

  public Long getFieldMt() {
    return mMt;
  }

  public DeliveryWindow setFieldMt(Long value) {
    this.mMt = value;
    return this;
  }

  public Long getFieldMu() {
    return mMu;
  }

  public DeliveryWindow setFieldMu(Long value) {
    this.mMu = value;
    return this;
  }

  public Long getFieldMv() {
    return mMv;
  }

  public DeliveryWindow setFieldMv(Long value) {
    this.mMv = value;
    return this;
  }

  public Long getFieldMw() {
    return mMw;
  }

  public DeliveryWindow setFieldMw(Long value) {
    this.mMw = value;
    return this;
  }

  public Long getFieldMx() {
    return mMx;
  }

  public DeliveryWindow setFieldMx(Long value) {
    this.mMx = value;
    return this;
  }

  public Long getFieldMy() {
    return mMy;
  }

  public DeliveryWindow setFieldMy(Long value) {
    this.mMy = value;
    return this;
  }

  public Long getFieldMz() {
    return mMz;
  }

  public DeliveryWindow setFieldMz(Long value) {
    this.mMz = value;
    return this;
  }

  public Long getFieldNa() {
    return mNa;
  }

  public DeliveryWindow setFieldNa(Long value) {
    this.mNa = value;
    return this;
  }

  public Long getFieldNc() {
    return mNc;
  }

  public DeliveryWindow setFieldNc(Long value) {
    this.mNc = value;
    return this;
  }

  public Long getFieldNe() {
    return mNe;
  }

  public DeliveryWindow setFieldNe(Long value) {
    this.mNe = value;
    return this;
  }

  public Long getFieldNf() {
    return mNf;
  }

  public DeliveryWindow setFieldNf(Long value) {
    this.mNf = value;
    return this;
  }

  public Long getFieldNg() {
    return mNg;
  }

  public DeliveryWindow setFieldNg(Long value) {
    this.mNg = value;
    return this;
  }

  public Long getFieldNi() {
    return mNi;
  }

  public DeliveryWindow setFieldNi(Long value) {
    this.mNi = value;
    return this;
  }

  public Long getFieldNl() {
    return mNl;
  }

  public DeliveryWindow setFieldNl(Long value) {
    this.mNl = value;
    return this;
  }

  public Long getFieldNo() {
    return mNo;
  }

  public DeliveryWindow setFieldNo(Long value) {
    this.mNo = value;
    return this;
  }

  public Long getFieldNp() {
    return mNp;
  }

  public DeliveryWindow setFieldNp(Long value) {
    this.mNp = value;
    return this;
  }

  public Long getFieldNr() {
    return mNr;
  }

  public DeliveryWindow setFieldNr(Long value) {
    this.mNr = value;
    return this;
  }

  public Long getFieldNu() {
    return mNu;
  }

  public DeliveryWindow setFieldNu(Long value) {
    this.mNu = value;
    return this;
  }

  public Long getFieldNz() {
    return mNz;
  }

  public DeliveryWindow setFieldNz(Long value) {
    this.mNz = value;
    return this;
  }

  public Long getFieldOm() {
    return mOm;
  }

  public DeliveryWindow setFieldOm(Long value) {
    this.mOm = value;
    return this;
  }

  public Long getFieldPa() {
    return mPa;
  }

  public DeliveryWindow setFieldPa(Long value) {
    this.mPa = value;
    return this;
  }

  public Long getFieldPe() {
    return mPe;
  }

  public DeliveryWindow setFieldPe(Long value) {
    this.mPe = value;
    return this;
  }

  public Long getFieldPf() {
    return mPf;
  }

  public DeliveryWindow setFieldPf(Long value) {
    this.mPf = value;
    return this;
  }

  public Long getFieldPg() {
    return mPg;
  }

  public DeliveryWindow setFieldPg(Long value) {
    this.mPg = value;
    return this;
  }

  public Long getFieldPh() {
    return mPh;
  }

  public DeliveryWindow setFieldPh(Long value) {
    this.mPh = value;
    return this;
  }

  public Long getFieldPk() {
    return mPk;
  }

  public DeliveryWindow setFieldPk(Long value) {
    this.mPk = value;
    return this;
  }

  public Long getFieldPl() {
    return mPl;
  }

  public DeliveryWindow setFieldPl(Long value) {
    this.mPl = value;
    return this;
  }

  public Long getFieldPm() {
    return mPm;
  }

  public DeliveryWindow setFieldPm(Long value) {
    this.mPm = value;
    return this;
  }

  public Long getFieldPn() {
    return mPn;
  }

  public DeliveryWindow setFieldPn(Long value) {
    this.mPn = value;
    return this;
  }

  public Long getFieldPr() {
    return mPr;
  }

  public DeliveryWindow setFieldPr(Long value) {
    this.mPr = value;
    return this;
  }

  public Long getFieldPs() {
    return mPs;
  }

  public DeliveryWindow setFieldPs(Long value) {
    this.mPs = value;
    return this;
  }

  public Long getFieldPt() {
    return mPt;
  }

  public DeliveryWindow setFieldPt(Long value) {
    this.mPt = value;
    return this;
  }

  public Long getFieldPw() {
    return mPw;
  }

  public DeliveryWindow setFieldPw(Long value) {
    this.mPw = value;
    return this;
  }

  public Long getFieldPy() {
    return mPy;
  }

  public DeliveryWindow setFieldPy(Long value) {
    this.mPy = value;
    return this;
  }

  public Long getFieldQa() {
    return mQa;
  }

  public DeliveryWindow setFieldQa(Long value) {
    this.mQa = value;
    return this;
  }

  public Long getFieldRe() {
    return mRe;
  }

  public DeliveryWindow setFieldRe(Long value) {
    this.mRe = value;
    return this;
  }

  public Long getFieldRo() {
    return mRo;
  }

  public DeliveryWindow setFieldRo(Long value) {
    this.mRo = value;
    return this;
  }

  public Long getFieldRs() {
    return mRs;
  }

  public DeliveryWindow setFieldRs(Long value) {
    this.mRs = value;
    return this;
  }

  public Long getFieldRu() {
    return mRu;
  }

  public DeliveryWindow setFieldRu(Long value) {
    this.mRu = value;
    return this;
  }

  public Long getFieldRw() {
    return mRw;
  }

  public DeliveryWindow setFieldRw(Long value) {
    this.mRw = value;
    return this;
  }

  public Long getFieldSa() {
    return mSa;
  }

  public DeliveryWindow setFieldSa(Long value) {
    this.mSa = value;
    return this;
  }

  public Long getFieldSb() {
    return mSb;
  }

  public DeliveryWindow setFieldSb(Long value) {
    this.mSb = value;
    return this;
  }

  public Long getFieldSc() {
    return mSc;
  }

  public DeliveryWindow setFieldSc(Long value) {
    this.mSc = value;
    return this;
  }

  public Long getFieldSd() {
    return mSd;
  }

  public DeliveryWindow setFieldSd(Long value) {
    this.mSd = value;
    return this;
  }

  public Long getFieldSe() {
    return mSe;
  }

  public DeliveryWindow setFieldSe(Long value) {
    this.mSe = value;
    return this;
  }

  public Long getFieldSg() {
    return mSg;
  }

  public DeliveryWindow setFieldSg(Long value) {
    this.mSg = value;
    return this;
  }

  public Long getFieldSh() {
    return mSh;
  }

  public DeliveryWindow setFieldSh(Long value) {
    this.mSh = value;
    return this;
  }

  public Long getFieldSi() {
    return mSi;
  }

  public DeliveryWindow setFieldSi(Long value) {
    this.mSi = value;
    return this;
  }

  public Long getFieldSj() {
    return mSj;
  }

  public DeliveryWindow setFieldSj(Long value) {
    this.mSj = value;
    return this;
  }

  public Long getFieldSk() {
    return mSk;
  }

  public DeliveryWindow setFieldSk(Long value) {
    this.mSk = value;
    return this;
  }

  public Long getFieldSl() {
    return mSl;
  }

  public DeliveryWindow setFieldSl(Long value) {
    this.mSl = value;
    return this;
  }

  public Long getFieldSm() {
    return mSm;
  }

  public DeliveryWindow setFieldSm(Long value) {
    this.mSm = value;
    return this;
  }

  public Long getFieldSn() {
    return mSn;
  }

  public DeliveryWindow setFieldSn(Long value) {
    this.mSn = value;
    return this;
  }

  public Long getFieldSo() {
    return mSo;
  }

  public DeliveryWindow setFieldSo(Long value) {
    this.mSo = value;
    return this;
  }

  public Long getFieldSr() {
    return mSr;
  }

  public DeliveryWindow setFieldSr(Long value) {
    this.mSr = value;
    return this;
  }

  public Long getFieldSs() {
    return mSs;
  }

  public DeliveryWindow setFieldSs(Long value) {
    this.mSs = value;
    return this;
  }

  public Long getFieldSt() {
    return mSt;
  }

  public DeliveryWindow setFieldSt(Long value) {
    this.mSt = value;
    return this;
  }

  public Long getFieldSv() {
    return mSv;
  }

  public DeliveryWindow setFieldSv(Long value) {
    this.mSv = value;
    return this;
  }

  public Long getFieldSx() {
    return mSx;
  }

  public DeliveryWindow setFieldSx(Long value) {
    this.mSx = value;
    return this;
  }

  public Long getFieldSy() {
    return mSy;
  }

  public DeliveryWindow setFieldSy(Long value) {
    this.mSy = value;
    return this;
  }

  public Long getFieldSz() {
    return mSz;
  }

  public DeliveryWindow setFieldSz(Long value) {
    this.mSz = value;
    return this;
  }

  public Long getFieldTc() {
    return mTc;
  }

  public DeliveryWindow setFieldTc(Long value) {
    this.mTc = value;
    return this;
  }

  public Long getFieldTd() {
    return mTd;
  }

  public DeliveryWindow setFieldTd(Long value) {
    this.mTd = value;
    return this;
  }

  public Long getFieldTf() {
    return mTf;
  }

  public DeliveryWindow setFieldTf(Long value) {
    this.mTf = value;
    return this;
  }

  public Long getFieldTg() {
    return mTg;
  }

  public DeliveryWindow setFieldTg(Long value) {
    this.mTg = value;
    return this;
  }

  public Long getFieldTh() {
    return mTh;
  }

  public DeliveryWindow setFieldTh(Long value) {
    this.mTh = value;
    return this;
  }

  public Long getFieldTj() {
    return mTj;
  }

  public DeliveryWindow setFieldTj(Long value) {
    this.mTj = value;
    return this;
  }

  public Long getFieldTk() {
    return mTk;
  }

  public DeliveryWindow setFieldTk(Long value) {
    this.mTk = value;
    return this;
  }

  public Long getFieldTl() {
    return mTl;
  }

  public DeliveryWindow setFieldTl(Long value) {
    this.mTl = value;
    return this;
  }

  public Long getFieldTm() {
    return mTm;
  }

  public DeliveryWindow setFieldTm(Long value) {
    this.mTm = value;
    return this;
  }

  public Long getFieldTn() {
    return mTn;
  }

  public DeliveryWindow setFieldTn(Long value) {
    this.mTn = value;
    return this;
  }

  public Long getFieldTo() {
    return mTo;
  }

  public DeliveryWindow setFieldTo(Long value) {
    this.mTo = value;
    return this;
  }

  public Long getFieldTr() {
    return mTr;
  }

  public DeliveryWindow setFieldTr(Long value) {
    this.mTr = value;
    return this;
  }

  public Long getFieldTt() {
    return mTt;
  }

  public DeliveryWindow setFieldTt(Long value) {
    this.mTt = value;
    return this;
  }

  public Long getFieldTv() {
    return mTv;
  }

  public DeliveryWindow setFieldTv(Long value) {
    this.mTv = value;
    return this;
  }

  public Long getFieldTw() {
    return mTw;
  }

  public DeliveryWindow setFieldTw(Long value) {
    this.mTw = value;
    return this;
  }

  public Long getFieldTz() {
    return mTz;
  }

  public DeliveryWindow setFieldTz(Long value) {
    this.mTz = value;
    return this;
  }

  public Long getFieldUa() {
    return mUa;
  }

  public DeliveryWindow setFieldUa(Long value) {
    this.mUa = value;
    return this;
  }

  public Long getFieldUg() {
    return mUg;
  }

  public DeliveryWindow setFieldUg(Long value) {
    this.mUg = value;
    return this;
  }

  public Long getFieldUm() {
    return mUm;
  }

  public DeliveryWindow setFieldUm(Long value) {
    this.mUm = value;
    return this;
  }

  public Long getFieldUs() {
    return mUs;
  }

  public DeliveryWindow setFieldUs(Long value) {
    this.mUs = value;
    return this;
  }

  public Long getFieldUy() {
    return mUy;
  }

  public DeliveryWindow setFieldUy(Long value) {
    this.mUy = value;
    return this;
  }

  public Long getFieldUz() {
    return mUz;
  }

  public DeliveryWindow setFieldUz(Long value) {
    this.mUz = value;
    return this;
  }

  public Long getFieldVa() {
    return mVa;
  }

  public DeliveryWindow setFieldVa(Long value) {
    this.mVa = value;
    return this;
  }

  public Long getFieldVc() {
    return mVc;
  }

  public DeliveryWindow setFieldVc(Long value) {
    this.mVc = value;
    return this;
  }

  public Long getFieldVe() {
    return mVe;
  }

  public DeliveryWindow setFieldVe(Long value) {
    this.mVe = value;
    return this;
  }

  public Long getFieldVg() {
    return mVg;
  }

  public DeliveryWindow setFieldVg(Long value) {
    this.mVg = value;
    return this;
  }

  public Long getFieldVi() {
    return mVi;
  }

  public DeliveryWindow setFieldVi(Long value) {
    this.mVi = value;
    return this;
  }

  public Long getFieldVn() {
    return mVn;
  }

  public DeliveryWindow setFieldVn(Long value) {
    this.mVn = value;
    return this;
  }

  public Long getFieldVu() {
    return mVu;
  }

  public DeliveryWindow setFieldVu(Long value) {
    this.mVu = value;
    return this;
  }

  public Long getFieldWf() {
    return mWf;
  }

  public DeliveryWindow setFieldWf(Long value) {
    this.mWf = value;
    return this;
  }

  public Long getFieldWs() {
    return mWs;
  }

  public DeliveryWindow setFieldWs(Long value) {
    this.mWs = value;
    return this;
  }

  public Long getFieldXk() {
    return mXk;
  }

  public DeliveryWindow setFieldXk(Long value) {
    this.mXk = value;
    return this;
  }

  public Long getFieldYe() {
    return mYe;
  }

  public DeliveryWindow setFieldYe(Long value) {
    this.mYe = value;
    return this;
  }

  public Long getFieldYt() {
    return mYt;
  }

  public DeliveryWindow setFieldYt(Long value) {
    this.mYt = value;
    return this;
  }

  public Long getFieldZa() {
    return mZa;
  }

  public DeliveryWindow setFieldZa(Long value) {
    this.mZa = value;
    return this;
  }

  public Long getFieldZm() {
    return mZm;
  }

  public DeliveryWindow setFieldZm(Long value) {
    this.mZm = value;
    return this;
  }

  public Long getFieldZw() {
    return mZw;
  }

  public DeliveryWindow setFieldZw(Long value) {
    this.mZw = value;
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

  public DeliveryWindow copyFrom(DeliveryWindow instance) {
    this.mAd = instance.mAd;
    this.mAe = instance.mAe;
    this.mAf = instance.mAf;
    this.mAg = instance.mAg;
    this.mAi = instance.mAi;
    this.mAl = instance.mAl;
    this.mAll = instance.mAll;
    this.mAm = instance.mAm;
    this.mAn = instance.mAn;
    this.mAo = instance.mAo;
    this.mAq = instance.mAq;
    this.mAr = instance.mAr;
    this.mAs = instance.mAs;
    this.mAt = instance.mAt;
    this.mAu = instance.mAu;
    this.mAw = instance.mAw;
    this.mAx = instance.mAx;
    this.mAz = instance.mAz;
    this.mBa = instance.mBa;
    this.mBb = instance.mBb;
    this.mBd = instance.mBd;
    this.mBe = instance.mBe;
    this.mBf = instance.mBf;
    this.mBg = instance.mBg;
    this.mBh = instance.mBh;
    this.mBi = instance.mBi;
    this.mBj = instance.mBj;
    this.mBl = instance.mBl;
    this.mBm = instance.mBm;
    this.mBn = instance.mBn;
    this.mBo = instance.mBo;
    this.mBq = instance.mBq;
    this.mBr = instance.mBr;
    this.mBs = instance.mBs;
    this.mBt = instance.mBt;
    this.mBv = instance.mBv;
    this.mBw = instance.mBw;
    this.mBy = instance.mBy;
    this.mBz = instance.mBz;
    this.mCa = instance.mCa;
    this.mCc = instance.mCc;
    this.mCd = instance.mCd;
    this.mCf = instance.mCf;
    this.mCg = instance.mCg;
    this.mCh = instance.mCh;
    this.mCi = instance.mCi;
    this.mCk = instance.mCk;
    this.mCl = instance.mCl;
    this.mCm = instance.mCm;
    this.mCn = instance.mCn;
    this.mCo = instance.mCo;
    this.mCr = instance.mCr;
    this.mCu = instance.mCu;
    this.mCv = instance.mCv;
    this.mCw = instance.mCw;
    this.mCx = instance.mCx;
    this.mCy = instance.mCy;
    this.mCz = instance.mCz;
    this.mDe = instance.mDe;
    this.mDj = instance.mDj;
    this.mDk = instance.mDk;
    this.mDm = instance.mDm;
    this.mDo = instance.mDo;
    this.mDz = instance.mDz;
    this.mEc = instance.mEc;
    this.mEe = instance.mEe;
    this.mEg = instance.mEg;
    this.mEh = instance.mEh;
    this.mEr = instance.mEr;
    this.mEs = instance.mEs;
    this.mEt = instance.mEt;
    this.mFi = instance.mFi;
    this.mFj = instance.mFj;
    this.mFk = instance.mFk;
    this.mFm = instance.mFm;
    this.mFo = instance.mFo;
    this.mFr = instance.mFr;
    this.mGa = instance.mGa;
    this.mGb = instance.mGb;
    this.mGd = instance.mGd;
    this.mGe = instance.mGe;
    this.mGf = instance.mGf;
    this.mGg = instance.mGg;
    this.mGh = instance.mGh;
    this.mGi = instance.mGi;
    this.mGl = instance.mGl;
    this.mGm = instance.mGm;
    this.mGn = instance.mGn;
    this.mGp = instance.mGp;
    this.mGq = instance.mGq;
    this.mGr = instance.mGr;
    this.mGs = instance.mGs;
    this.mGt = instance.mGt;
    this.mGu = instance.mGu;
    this.mGw = instance.mGw;
    this.mGy = instance.mGy;
    this.mHk = instance.mHk;
    this.mHm = instance.mHm;
    this.mHn = instance.mHn;
    this.mHr = instance.mHr;
    this.mHt = instance.mHt;
    this.mHu = instance.mHu;
    this.mId = instance.mId;
    this.mIe = instance.mIe;
    this.mIl = instance.mIl;
    this.mIm = instance.mIm;
    this.mIn = instance.mIn;
    this.mIo = instance.mIo;
    this.mIq = instance.mIq;
    this.mIr = instance.mIr;
    this.mIs = instance.mIs;
    this.mIt = instance.mIt;
    this.mJe = instance.mJe;
    this.mJm = instance.mJm;
    this.mJo = instance.mJo;
    this.mJp = instance.mJp;
    this.mKe = instance.mKe;
    this.mKg = instance.mKg;
    this.mKh = instance.mKh;
    this.mKi = instance.mKi;
    this.mKm = instance.mKm;
    this.mKn = instance.mKn;
    this.mKp = instance.mKp;
    this.mKr = instance.mKr;
    this.mKw = instance.mKw;
    this.mKy = instance.mKy;
    this.mKz = instance.mKz;
    this.mLa = instance.mLa;
    this.mLb = instance.mLb;
    this.mLc = instance.mLc;
    this.mLi = instance.mLi;
    this.mLk = instance.mLk;
    this.mLr = instance.mLr;
    this.mLs = instance.mLs;
    this.mLt = instance.mLt;
    this.mLu = instance.mLu;
    this.mLv = instance.mLv;
    this.mLy = instance.mLy;
    this.mMa = instance.mMa;
    this.mMc = instance.mMc;
    this.mMd = instance.mMd;
    this.mMe = instance.mMe;
    this.mMf = instance.mMf;
    this.mMg = instance.mMg;
    this.mMh = instance.mMh;
    this.mMk = instance.mMk;
    this.mMl = instance.mMl;
    this.mMm = instance.mMm;
    this.mMn = instance.mMn;
    this.mMo = instance.mMo;
    this.mMp = instance.mMp;
    this.mMq = instance.mMq;
    this.mMr = instance.mMr;
    this.mMs = instance.mMs;
    this.mMt = instance.mMt;
    this.mMu = instance.mMu;
    this.mMv = instance.mMv;
    this.mMw = instance.mMw;
    this.mMx = instance.mMx;
    this.mMy = instance.mMy;
    this.mMz = instance.mMz;
    this.mNa = instance.mNa;
    this.mNc = instance.mNc;
    this.mNe = instance.mNe;
    this.mNf = instance.mNf;
    this.mNg = instance.mNg;
    this.mNi = instance.mNi;
    this.mNl = instance.mNl;
    this.mNo = instance.mNo;
    this.mNp = instance.mNp;
    this.mNr = instance.mNr;
    this.mNu = instance.mNu;
    this.mNz = instance.mNz;
    this.mOm = instance.mOm;
    this.mPa = instance.mPa;
    this.mPe = instance.mPe;
    this.mPf = instance.mPf;
    this.mPg = instance.mPg;
    this.mPh = instance.mPh;
    this.mPk = instance.mPk;
    this.mPl = instance.mPl;
    this.mPm = instance.mPm;
    this.mPn = instance.mPn;
    this.mPr = instance.mPr;
    this.mPs = instance.mPs;
    this.mPt = instance.mPt;
    this.mPw = instance.mPw;
    this.mPy = instance.mPy;
    this.mQa = instance.mQa;
    this.mRe = instance.mRe;
    this.mRo = instance.mRo;
    this.mRs = instance.mRs;
    this.mRu = instance.mRu;
    this.mRw = instance.mRw;
    this.mSa = instance.mSa;
    this.mSb = instance.mSb;
    this.mSc = instance.mSc;
    this.mSd = instance.mSd;
    this.mSe = instance.mSe;
    this.mSg = instance.mSg;
    this.mSh = instance.mSh;
    this.mSi = instance.mSi;
    this.mSj = instance.mSj;
    this.mSk = instance.mSk;
    this.mSl = instance.mSl;
    this.mSm = instance.mSm;
    this.mSn = instance.mSn;
    this.mSo = instance.mSo;
    this.mSr = instance.mSr;
    this.mSs = instance.mSs;
    this.mSt = instance.mSt;
    this.mSv = instance.mSv;
    this.mSx = instance.mSx;
    this.mSy = instance.mSy;
    this.mSz = instance.mSz;
    this.mTc = instance.mTc;
    this.mTd = instance.mTd;
    this.mTf = instance.mTf;
    this.mTg = instance.mTg;
    this.mTh = instance.mTh;
    this.mTj = instance.mTj;
    this.mTk = instance.mTk;
    this.mTl = instance.mTl;
    this.mTm = instance.mTm;
    this.mTn = instance.mTn;
    this.mTo = instance.mTo;
    this.mTr = instance.mTr;
    this.mTt = instance.mTt;
    this.mTv = instance.mTv;
    this.mTw = instance.mTw;
    this.mTz = instance.mTz;
    this.mUa = instance.mUa;
    this.mUg = instance.mUg;
    this.mUm = instance.mUm;
    this.mUs = instance.mUs;
    this.mUy = instance.mUy;
    this.mUz = instance.mUz;
    this.mVa = instance.mVa;
    this.mVc = instance.mVc;
    this.mVe = instance.mVe;
    this.mVg = instance.mVg;
    this.mVi = instance.mVi;
    this.mVn = instance.mVn;
    this.mVu = instance.mVu;
    this.mWf = instance.mWf;
    this.mWs = instance.mWs;
    this.mXk = instance.mXk;
    this.mYe = instance.mYe;
    this.mYt = instance.mYt;
    this.mZa = instance.mZa;
    this.mZm = instance.mZm;
    this.mZw = instance.mZw;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<DeliveryWindow> getParser() {
    return new APIRequest.ResponseParser<DeliveryWindow>() {
      public APINodeList<DeliveryWindow> parseResponse(String response, APIContext context, APIRequest<DeliveryWindow> request, String header) throws MalformedResponseException {
        return DeliveryWindow.parseResponse(response, context, request, header);
      }
    };
  }
}
