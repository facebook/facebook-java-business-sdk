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
public class ManagedPartnerBusiness extends APINode {
  @SerializedName("ad_account")
  private AdAccount mAdAccount = null;
  @SerializedName("catalog_segment")
  private ProductCatalog mCatalogSegment = null;
  @SerializedName("extended_credit")
  private ManagedPartnerExtendedCredit mExtendedCredit = null;
  @SerializedName("page")
  private Page mPage = null;
  @SerializedName("seller_business_info")
  private Object mSellerBusinessInfo = null;
  @SerializedName("seller_business_status")
  private String mSellerBusinessStatus = null;
  @SerializedName("template")
  private List<Object> mTemplate = null;
  protected static Gson gson = null;

  public ManagedPartnerBusiness() {
  }

  public String getId() {
    return null;
  }
  public static ManagedPartnerBusiness loadJSON(String json, APIContext context, String header) {
    ManagedPartnerBusiness managedPartnerBusiness = getGson().fromJson(json, ManagedPartnerBusiness.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(managedPartnerBusiness.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    managedPartnerBusiness.context = context;
    managedPartnerBusiness.rawValue = json;
    managedPartnerBusiness.header = header;
    return managedPartnerBusiness;
  }

  public static APINodeList<ManagedPartnerBusiness> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<ManagedPartnerBusiness> managedPartnerBusinesss = new APINodeList<ManagedPartnerBusiness>(request, json, header);
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
          managedPartnerBusinesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return managedPartnerBusinesss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                managedPartnerBusinesss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            managedPartnerBusinesss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              managedPartnerBusinesss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              managedPartnerBusinesss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  managedPartnerBusinesss.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              managedPartnerBusinesss.add(loadJSON(obj.toString(), context, header));
            }
          }
          return managedPartnerBusinesss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              managedPartnerBusinesss.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return managedPartnerBusinesss;
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
              managedPartnerBusinesss.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return managedPartnerBusinesss;
          }

          // Sixth, check if it's pure JsonObject
          managedPartnerBusinesss.clear();
          managedPartnerBusinesss.add(loadJSON(json, context, header));
          return managedPartnerBusinesss;
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


  public AdAccount getFieldAdAccount() {
    if (mAdAccount != null) {
      mAdAccount.context = getContext();
    }
    return mAdAccount;
  }

  public ManagedPartnerBusiness setFieldAdAccount(AdAccount value) {
    this.mAdAccount = value;
    return this;
  }

  public ManagedPartnerBusiness setFieldAdAccount(String value) {
    Type type = new TypeToken<AdAccount>(){}.getType();
    this.mAdAccount = AdAccount.getGson().fromJson(value, type);
    return this;
  }
  public ProductCatalog getFieldCatalogSegment() {
    if (mCatalogSegment != null) {
      mCatalogSegment.context = getContext();
    }
    return mCatalogSegment;
  }

  public ManagedPartnerBusiness setFieldCatalogSegment(ProductCatalog value) {
    this.mCatalogSegment = value;
    return this;
  }

  public ManagedPartnerBusiness setFieldCatalogSegment(String value) {
    Type type = new TypeToken<ProductCatalog>(){}.getType();
    this.mCatalogSegment = ProductCatalog.getGson().fromJson(value, type);
    return this;
  }
  public ManagedPartnerExtendedCredit getFieldExtendedCredit() {
    return mExtendedCredit;
  }

  public ManagedPartnerBusiness setFieldExtendedCredit(ManagedPartnerExtendedCredit value) {
    this.mExtendedCredit = value;
    return this;
  }

  public ManagedPartnerBusiness setFieldExtendedCredit(String value) {
    Type type = new TypeToken<ManagedPartnerExtendedCredit>(){}.getType();
    this.mExtendedCredit = ManagedPartnerExtendedCredit.getGson().fromJson(value, type);
    return this;
  }
  public Page getFieldPage() {
    if (mPage != null) {
      mPage.context = getContext();
    }
    return mPage;
  }

  public ManagedPartnerBusiness setFieldPage(Page value) {
    this.mPage = value;
    return this;
  }

  public ManagedPartnerBusiness setFieldPage(String value) {
    Type type = new TypeToken<Page>(){}.getType();
    this.mPage = Page.getGson().fromJson(value, type);
    return this;
  }
  public Object getFieldSellerBusinessInfo() {
    return mSellerBusinessInfo;
  }

  public ManagedPartnerBusiness setFieldSellerBusinessInfo(Object value) {
    this.mSellerBusinessInfo = value;
    return this;
  }

  public String getFieldSellerBusinessStatus() {
    return mSellerBusinessStatus;
  }

  public ManagedPartnerBusiness setFieldSellerBusinessStatus(String value) {
    this.mSellerBusinessStatus = value;
    return this;
  }

  public List<Object> getFieldTemplate() {
    return mTemplate;
  }

  public ManagedPartnerBusiness setFieldTemplate(List<Object> value) {
    this.mTemplate = value;
    return this;
  }



  public static enum EnumPartitionType {
      @SerializedName("AUTH")
      VALUE_AUTH("AUTH"),
      @SerializedName("FIXED")
      VALUE_FIXED("FIXED"),
      @SerializedName("FIXED_WITHOUT_PARTITION")
      VALUE_FIXED_WITHOUT_PARTITION("FIXED_WITHOUT_PARTITION"),
      ;

      private String value;

      private EnumPartitionType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSurveyBusinessType {
      @SerializedName("ADVERTISER")
      VALUE_ADVERTISER("ADVERTISER"),
      @SerializedName("AGENCY")
      VALUE_AGENCY("AGENCY"),
      @SerializedName("APP_DEVELOPER")
      VALUE_APP_DEVELOPER("APP_DEVELOPER"),
      @SerializedName("PUBLISHER")
      VALUE_PUBLISHER("PUBLISHER"),
      ;

      private String value;

      private EnumSurveyBusinessType(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumTimezoneId {
      @SerializedName("0")
      VALUE_0("0"),
      @SerializedName("1")
      VALUE_1("1"),
      @SerializedName("2")
      VALUE_2("2"),
      @SerializedName("3")
      VALUE_3("3"),
      @SerializedName("4")
      VALUE_4("4"),
      @SerializedName("5")
      VALUE_5("5"),
      @SerializedName("6")
      VALUE_6("6"),
      @SerializedName("7")
      VALUE_7("7"),
      @SerializedName("8")
      VALUE_8("8"),
      @SerializedName("9")
      VALUE_9("9"),
      @SerializedName("10")
      VALUE_10("10"),
      @SerializedName("11")
      VALUE_11("11"),
      @SerializedName("12")
      VALUE_12("12"),
      @SerializedName("13")
      VALUE_13("13"),
      @SerializedName("14")
      VALUE_14("14"),
      @SerializedName("15")
      VALUE_15("15"),
      @SerializedName("16")
      VALUE_16("16"),
      @SerializedName("17")
      VALUE_17("17"),
      @SerializedName("18")
      VALUE_18("18"),
      @SerializedName("19")
      VALUE_19("19"),
      @SerializedName("20")
      VALUE_20("20"),
      @SerializedName("21")
      VALUE_21("21"),
      @SerializedName("22")
      VALUE_22("22"),
      @SerializedName("23")
      VALUE_23("23"),
      @SerializedName("24")
      VALUE_24("24"),
      @SerializedName("25")
      VALUE_25("25"),
      @SerializedName("26")
      VALUE_26("26"),
      @SerializedName("27")
      VALUE_27("27"),
      @SerializedName("28")
      VALUE_28("28"),
      @SerializedName("29")
      VALUE_29("29"),
      @SerializedName("30")
      VALUE_30("30"),
      @SerializedName("31")
      VALUE_31("31"),
      @SerializedName("32")
      VALUE_32("32"),
      @SerializedName("33")
      VALUE_33("33"),
      @SerializedName("34")
      VALUE_34("34"),
      @SerializedName("35")
      VALUE_35("35"),
      @SerializedName("36")
      VALUE_36("36"),
      @SerializedName("37")
      VALUE_37("37"),
      @SerializedName("38")
      VALUE_38("38"),
      @SerializedName("39")
      VALUE_39("39"),
      @SerializedName("40")
      VALUE_40("40"),
      @SerializedName("41")
      VALUE_41("41"),
      @SerializedName("42")
      VALUE_42("42"),
      @SerializedName("43")
      VALUE_43("43"),
      @SerializedName("44")
      VALUE_44("44"),
      @SerializedName("45")
      VALUE_45("45"),
      @SerializedName("46")
      VALUE_46("46"),
      @SerializedName("47")
      VALUE_47("47"),
      @SerializedName("48")
      VALUE_48("48"),
      @SerializedName("49")
      VALUE_49("49"),
      @SerializedName("50")
      VALUE_50("50"),
      @SerializedName("51")
      VALUE_51("51"),
      @SerializedName("52")
      VALUE_52("52"),
      @SerializedName("53")
      VALUE_53("53"),
      @SerializedName("54")
      VALUE_54("54"),
      @SerializedName("55")
      VALUE_55("55"),
      @SerializedName("56")
      VALUE_56("56"),
      @SerializedName("57")
      VALUE_57("57"),
      @SerializedName("58")
      VALUE_58("58"),
      @SerializedName("59")
      VALUE_59("59"),
      @SerializedName("60")
      VALUE_60("60"),
      @SerializedName("61")
      VALUE_61("61"),
      @SerializedName("62")
      VALUE_62("62"),
      @SerializedName("63")
      VALUE_63("63"),
      @SerializedName("64")
      VALUE_64("64"),
      @SerializedName("65")
      VALUE_65("65"),
      @SerializedName("66")
      VALUE_66("66"),
      @SerializedName("67")
      VALUE_67("67"),
      @SerializedName("68")
      VALUE_68("68"),
      @SerializedName("69")
      VALUE_69("69"),
      @SerializedName("70")
      VALUE_70("70"),
      @SerializedName("71")
      VALUE_71("71"),
      @SerializedName("72")
      VALUE_72("72"),
      @SerializedName("73")
      VALUE_73("73"),
      @SerializedName("74")
      VALUE_74("74"),
      @SerializedName("75")
      VALUE_75("75"),
      @SerializedName("76")
      VALUE_76("76"),
      @SerializedName("77")
      VALUE_77("77"),
      @SerializedName("78")
      VALUE_78("78"),
      @SerializedName("79")
      VALUE_79("79"),
      @SerializedName("80")
      VALUE_80("80"),
      @SerializedName("81")
      VALUE_81("81"),
      @SerializedName("82")
      VALUE_82("82"),
      @SerializedName("83")
      VALUE_83("83"),
      @SerializedName("84")
      VALUE_84("84"),
      @SerializedName("85")
      VALUE_85("85"),
      @SerializedName("86")
      VALUE_86("86"),
      @SerializedName("87")
      VALUE_87("87"),
      @SerializedName("88")
      VALUE_88("88"),
      @SerializedName("89")
      VALUE_89("89"),
      @SerializedName("90")
      VALUE_90("90"),
      @SerializedName("91")
      VALUE_91("91"),
      @SerializedName("92")
      VALUE_92("92"),
      @SerializedName("93")
      VALUE_93("93"),
      @SerializedName("94")
      VALUE_94("94"),
      @SerializedName("95")
      VALUE_95("95"),
      @SerializedName("96")
      VALUE_96("96"),
      @SerializedName("97")
      VALUE_97("97"),
      @SerializedName("98")
      VALUE_98("98"),
      @SerializedName("99")
      VALUE_99("99"),
      @SerializedName("100")
      VALUE_100("100"),
      @SerializedName("101")
      VALUE_101("101"),
      @SerializedName("102")
      VALUE_102("102"),
      @SerializedName("103")
      VALUE_103("103"),
      @SerializedName("104")
      VALUE_104("104"),
      @SerializedName("105")
      VALUE_105("105"),
      @SerializedName("106")
      VALUE_106("106"),
      @SerializedName("107")
      VALUE_107("107"),
      @SerializedName("108")
      VALUE_108("108"),
      @SerializedName("109")
      VALUE_109("109"),
      @SerializedName("110")
      VALUE_110("110"),
      @SerializedName("111")
      VALUE_111("111"),
      @SerializedName("112")
      VALUE_112("112"),
      @SerializedName("113")
      VALUE_113("113"),
      @SerializedName("114")
      VALUE_114("114"),
      @SerializedName("115")
      VALUE_115("115"),
      @SerializedName("116")
      VALUE_116("116"),
      @SerializedName("117")
      VALUE_117("117"),
      @SerializedName("118")
      VALUE_118("118"),
      @SerializedName("119")
      VALUE_119("119"),
      @SerializedName("120")
      VALUE_120("120"),
      @SerializedName("121")
      VALUE_121("121"),
      @SerializedName("122")
      VALUE_122("122"),
      @SerializedName("123")
      VALUE_123("123"),
      @SerializedName("124")
      VALUE_124("124"),
      @SerializedName("125")
      VALUE_125("125"),
      @SerializedName("126")
      VALUE_126("126"),
      @SerializedName("127")
      VALUE_127("127"),
      @SerializedName("128")
      VALUE_128("128"),
      @SerializedName("129")
      VALUE_129("129"),
      @SerializedName("130")
      VALUE_130("130"),
      @SerializedName("131")
      VALUE_131("131"),
      @SerializedName("132")
      VALUE_132("132"),
      @SerializedName("133")
      VALUE_133("133"),
      @SerializedName("134")
      VALUE_134("134"),
      @SerializedName("135")
      VALUE_135("135"),
      @SerializedName("136")
      VALUE_136("136"),
      @SerializedName("137")
      VALUE_137("137"),
      @SerializedName("138")
      VALUE_138("138"),
      @SerializedName("139")
      VALUE_139("139"),
      @SerializedName("140")
      VALUE_140("140"),
      @SerializedName("141")
      VALUE_141("141"),
      @SerializedName("142")
      VALUE_142("142"),
      @SerializedName("143")
      VALUE_143("143"),
      @SerializedName("144")
      VALUE_144("144"),
      @SerializedName("145")
      VALUE_145("145"),
      @SerializedName("146")
      VALUE_146("146"),
      @SerializedName("147")
      VALUE_147("147"),
      @SerializedName("148")
      VALUE_148("148"),
      @SerializedName("149")
      VALUE_149("149"),
      @SerializedName("150")
      VALUE_150("150"),
      @SerializedName("151")
      VALUE_151("151"),
      @SerializedName("152")
      VALUE_152("152"),
      @SerializedName("153")
      VALUE_153("153"),
      @SerializedName("154")
      VALUE_154("154"),
      @SerializedName("155")
      VALUE_155("155"),
      @SerializedName("156")
      VALUE_156("156"),
      @SerializedName("157")
      VALUE_157("157"),
      @SerializedName("158")
      VALUE_158("158"),
      @SerializedName("159")
      VALUE_159("159"),
      @SerializedName("160")
      VALUE_160("160"),
      @SerializedName("161")
      VALUE_161("161"),
      @SerializedName("162")
      VALUE_162("162"),
      @SerializedName("163")
      VALUE_163("163"),
      @SerializedName("164")
      VALUE_164("164"),
      @SerializedName("165")
      VALUE_165("165"),
      @SerializedName("166")
      VALUE_166("166"),
      @SerializedName("167")
      VALUE_167("167"),
      @SerializedName("168")
      VALUE_168("168"),
      @SerializedName("169")
      VALUE_169("169"),
      @SerializedName("170")
      VALUE_170("170"),
      @SerializedName("171")
      VALUE_171("171"),
      @SerializedName("172")
      VALUE_172("172"),
      @SerializedName("173")
      VALUE_173("173"),
      @SerializedName("174")
      VALUE_174("174"),
      @SerializedName("175")
      VALUE_175("175"),
      @SerializedName("176")
      VALUE_176("176"),
      @SerializedName("177")
      VALUE_177("177"),
      @SerializedName("178")
      VALUE_178("178"),
      @SerializedName("179")
      VALUE_179("179"),
      @SerializedName("180")
      VALUE_180("180"),
      @SerializedName("181")
      VALUE_181("181"),
      @SerializedName("182")
      VALUE_182("182"),
      @SerializedName("183")
      VALUE_183("183"),
      @SerializedName("184")
      VALUE_184("184"),
      @SerializedName("185")
      VALUE_185("185"),
      @SerializedName("186")
      VALUE_186("186"),
      @SerializedName("187")
      VALUE_187("187"),
      @SerializedName("188")
      VALUE_188("188"),
      @SerializedName("189")
      VALUE_189("189"),
      @SerializedName("190")
      VALUE_190("190"),
      @SerializedName("191")
      VALUE_191("191"),
      @SerializedName("192")
      VALUE_192("192"),
      @SerializedName("193")
      VALUE_193("193"),
      @SerializedName("194")
      VALUE_194("194"),
      @SerializedName("195")
      VALUE_195("195"),
      @SerializedName("196")
      VALUE_196("196"),
      @SerializedName("197")
      VALUE_197("197"),
      @SerializedName("198")
      VALUE_198("198"),
      @SerializedName("199")
      VALUE_199("199"),
      @SerializedName("200")
      VALUE_200("200"),
      @SerializedName("201")
      VALUE_201("201"),
      @SerializedName("202")
      VALUE_202("202"),
      @SerializedName("203")
      VALUE_203("203"),
      @SerializedName("204")
      VALUE_204("204"),
      @SerializedName("205")
      VALUE_205("205"),
      @SerializedName("206")
      VALUE_206("206"),
      @SerializedName("207")
      VALUE_207("207"),
      @SerializedName("208")
      VALUE_208("208"),
      @SerializedName("209")
      VALUE_209("209"),
      @SerializedName("210")
      VALUE_210("210"),
      @SerializedName("211")
      VALUE_211("211"),
      @SerializedName("212")
      VALUE_212("212"),
      @SerializedName("213")
      VALUE_213("213"),
      @SerializedName("214")
      VALUE_214("214"),
      @SerializedName("215")
      VALUE_215("215"),
      @SerializedName("216")
      VALUE_216("216"),
      @SerializedName("217")
      VALUE_217("217"),
      @SerializedName("218")
      VALUE_218("218"),
      @SerializedName("219")
      VALUE_219("219"),
      @SerializedName("220")
      VALUE_220("220"),
      @SerializedName("221")
      VALUE_221("221"),
      @SerializedName("222")
      VALUE_222("222"),
      @SerializedName("223")
      VALUE_223("223"),
      @SerializedName("224")
      VALUE_224("224"),
      @SerializedName("225")
      VALUE_225("225"),
      @SerializedName("226")
      VALUE_226("226"),
      @SerializedName("227")
      VALUE_227("227"),
      @SerializedName("228")
      VALUE_228("228"),
      @SerializedName("229")
      VALUE_229("229"),
      @SerializedName("230")
      VALUE_230("230"),
      @SerializedName("231")
      VALUE_231("231"),
      @SerializedName("232")
      VALUE_232("232"),
      @SerializedName("233")
      VALUE_233("233"),
      @SerializedName("234")
      VALUE_234("234"),
      @SerializedName("235")
      VALUE_235("235"),
      @SerializedName("236")
      VALUE_236("236"),
      @SerializedName("237")
      VALUE_237("237"),
      @SerializedName("238")
      VALUE_238("238"),
      @SerializedName("239")
      VALUE_239("239"),
      @SerializedName("240")
      VALUE_240("240"),
      @SerializedName("241")
      VALUE_241("241"),
      @SerializedName("242")
      VALUE_242("242"),
      @SerializedName("243")
      VALUE_243("243"),
      @SerializedName("244")
      VALUE_244("244"),
      @SerializedName("245")
      VALUE_245("245"),
      @SerializedName("246")
      VALUE_246("246"),
      @SerializedName("247")
      VALUE_247("247"),
      @SerializedName("248")
      VALUE_248("248"),
      @SerializedName("249")
      VALUE_249("249"),
      @SerializedName("250")
      VALUE_250("250"),
      @SerializedName("251")
      VALUE_251("251"),
      @SerializedName("252")
      VALUE_252("252"),
      @SerializedName("253")
      VALUE_253("253"),
      @SerializedName("254")
      VALUE_254("254"),
      @SerializedName("255")
      VALUE_255("255"),
      @SerializedName("256")
      VALUE_256("256"),
      @SerializedName("257")
      VALUE_257("257"),
      @SerializedName("258")
      VALUE_258("258"),
      @SerializedName("259")
      VALUE_259("259"),
      @SerializedName("260")
      VALUE_260("260"),
      @SerializedName("261")
      VALUE_261("261"),
      @SerializedName("262")
      VALUE_262("262"),
      @SerializedName("263")
      VALUE_263("263"),
      @SerializedName("264")
      VALUE_264("264"),
      @SerializedName("265")
      VALUE_265("265"),
      @SerializedName("266")
      VALUE_266("266"),
      @SerializedName("267")
      VALUE_267("267"),
      @SerializedName("268")
      VALUE_268("268"),
      @SerializedName("269")
      VALUE_269("269"),
      @SerializedName("270")
      VALUE_270("270"),
      @SerializedName("271")
      VALUE_271("271"),
      @SerializedName("272")
      VALUE_272("272"),
      @SerializedName("273")
      VALUE_273("273"),
      @SerializedName("274")
      VALUE_274("274"),
      @SerializedName("275")
      VALUE_275("275"),
      @SerializedName("276")
      VALUE_276("276"),
      @SerializedName("277")
      VALUE_277("277"),
      @SerializedName("278")
      VALUE_278("278"),
      @SerializedName("279")
      VALUE_279("279"),
      @SerializedName("280")
      VALUE_280("280"),
      @SerializedName("281")
      VALUE_281("281"),
      @SerializedName("282")
      VALUE_282("282"),
      @SerializedName("283")
      VALUE_283("283"),
      @SerializedName("284")
      VALUE_284("284"),
      @SerializedName("285")
      VALUE_285("285"),
      @SerializedName("286")
      VALUE_286("286"),
      @SerializedName("287")
      VALUE_287("287"),
      @SerializedName("288")
      VALUE_288("288"),
      @SerializedName("289")
      VALUE_289("289"),
      @SerializedName("290")
      VALUE_290("290"),
      @SerializedName("291")
      VALUE_291("291"),
      @SerializedName("292")
      VALUE_292("292"),
      @SerializedName("293")
      VALUE_293("293"),
      @SerializedName("294")
      VALUE_294("294"),
      @SerializedName("295")
      VALUE_295("295"),
      @SerializedName("296")
      VALUE_296("296"),
      @SerializedName("297")
      VALUE_297("297"),
      @SerializedName("298")
      VALUE_298("298"),
      @SerializedName("299")
      VALUE_299("299"),
      @SerializedName("300")
      VALUE_300("300"),
      @SerializedName("301")
      VALUE_301("301"),
      @SerializedName("302")
      VALUE_302("302"),
      @SerializedName("303")
      VALUE_303("303"),
      @SerializedName("304")
      VALUE_304("304"),
      @SerializedName("305")
      VALUE_305("305"),
      @SerializedName("306")
      VALUE_306("306"),
      @SerializedName("307")
      VALUE_307("307"),
      @SerializedName("308")
      VALUE_308("308"),
      @SerializedName("309")
      VALUE_309("309"),
      @SerializedName("310")
      VALUE_310("310"),
      @SerializedName("311")
      VALUE_311("311"),
      @SerializedName("312")
      VALUE_312("312"),
      @SerializedName("313")
      VALUE_313("313"),
      @SerializedName("314")
      VALUE_314("314"),
      @SerializedName("315")
      VALUE_315("315"),
      @SerializedName("316")
      VALUE_316("316"),
      @SerializedName("317")
      VALUE_317("317"),
      @SerializedName("318")
      VALUE_318("318"),
      @SerializedName("319")
      VALUE_319("319"),
      @SerializedName("320")
      VALUE_320("320"),
      @SerializedName("321")
      VALUE_321("321"),
      @SerializedName("322")
      VALUE_322("322"),
      @SerializedName("323")
      VALUE_323("323"),
      @SerializedName("324")
      VALUE_324("324"),
      @SerializedName("325")
      VALUE_325("325"),
      @SerializedName("326")
      VALUE_326("326"),
      @SerializedName("327")
      VALUE_327("327"),
      @SerializedName("328")
      VALUE_328("328"),
      @SerializedName("329")
      VALUE_329("329"),
      @SerializedName("330")
      VALUE_330("330"),
      @SerializedName("331")
      VALUE_331("331"),
      @SerializedName("332")
      VALUE_332("332"),
      @SerializedName("333")
      VALUE_333("333"),
      @SerializedName("334")
      VALUE_334("334"),
      @SerializedName("335")
      VALUE_335("335"),
      @SerializedName("336")
      VALUE_336("336"),
      @SerializedName("337")
      VALUE_337("337"),
      @SerializedName("338")
      VALUE_338("338"),
      @SerializedName("339")
      VALUE_339("339"),
      @SerializedName("340")
      VALUE_340("340"),
      @SerializedName("341")
      VALUE_341("341"),
      @SerializedName("342")
      VALUE_342("342"),
      @SerializedName("343")
      VALUE_343("343"),
      @SerializedName("344")
      VALUE_344("344"),
      @SerializedName("345")
      VALUE_345("345"),
      @SerializedName("346")
      VALUE_346("346"),
      @SerializedName("347")
      VALUE_347("347"),
      @SerializedName("348")
      VALUE_348("348"),
      @SerializedName("349")
      VALUE_349("349"),
      @SerializedName("350")
      VALUE_350("350"),
      @SerializedName("351")
      VALUE_351("351"),
      @SerializedName("352")
      VALUE_352("352"),
      @SerializedName("353")
      VALUE_353("353"),
      @SerializedName("354")
      VALUE_354("354"),
      @SerializedName("355")
      VALUE_355("355"),
      @SerializedName("356")
      VALUE_356("356"),
      @SerializedName("357")
      VALUE_357("357"),
      @SerializedName("358")
      VALUE_358("358"),
      @SerializedName("359")
      VALUE_359("359"),
      @SerializedName("360")
      VALUE_360("360"),
      @SerializedName("361")
      VALUE_361("361"),
      @SerializedName("362")
      VALUE_362("362"),
      @SerializedName("363")
      VALUE_363("363"),
      @SerializedName("364")
      VALUE_364("364"),
      @SerializedName("365")
      VALUE_365("365"),
      @SerializedName("366")
      VALUE_366("366"),
      @SerializedName("367")
      VALUE_367("367"),
      @SerializedName("368")
      VALUE_368("368"),
      @SerializedName("369")
      VALUE_369("369"),
      @SerializedName("370")
      VALUE_370("370"),
      @SerializedName("371")
      VALUE_371("371"),
      @SerializedName("372")
      VALUE_372("372"),
      @SerializedName("373")
      VALUE_373("373"),
      @SerializedName("374")
      VALUE_374("374"),
      @SerializedName("375")
      VALUE_375("375"),
      @SerializedName("376")
      VALUE_376("376"),
      @SerializedName("377")
      VALUE_377("377"),
      @SerializedName("378")
      VALUE_378("378"),
      @SerializedName("379")
      VALUE_379("379"),
      @SerializedName("380")
      VALUE_380("380"),
      @SerializedName("381")
      VALUE_381("381"),
      @SerializedName("382")
      VALUE_382("382"),
      @SerializedName("383")
      VALUE_383("383"),
      @SerializedName("384")
      VALUE_384("384"),
      @SerializedName("385")
      VALUE_385("385"),
      @SerializedName("386")
      VALUE_386("386"),
      @SerializedName("387")
      VALUE_387("387"),
      @SerializedName("388")
      VALUE_388("388"),
      @SerializedName("389")
      VALUE_389("389"),
      @SerializedName("390")
      VALUE_390("390"),
      @SerializedName("391")
      VALUE_391("391"),
      @SerializedName("392")
      VALUE_392("392"),
      @SerializedName("393")
      VALUE_393("393"),
      @SerializedName("394")
      VALUE_394("394"),
      @SerializedName("395")
      VALUE_395("395"),
      @SerializedName("396")
      VALUE_396("396"),
      @SerializedName("397")
      VALUE_397("397"),
      @SerializedName("398")
      VALUE_398("398"),
      @SerializedName("399")
      VALUE_399("399"),
      @SerializedName("400")
      VALUE_400("400"),
      @SerializedName("401")
      VALUE_401("401"),
      @SerializedName("402")
      VALUE_402("402"),
      @SerializedName("403")
      VALUE_403("403"),
      @SerializedName("404")
      VALUE_404("404"),
      @SerializedName("405")
      VALUE_405("405"),
      @SerializedName("406")
      VALUE_406("406"),
      @SerializedName("407")
      VALUE_407("407"),
      @SerializedName("408")
      VALUE_408("408"),
      @SerializedName("409")
      VALUE_409("409"),
      @SerializedName("410")
      VALUE_410("410"),
      @SerializedName("411")
      VALUE_411("411"),
      @SerializedName("412")
      VALUE_412("412"),
      @SerializedName("413")
      VALUE_413("413"),
      @SerializedName("414")
      VALUE_414("414"),
      @SerializedName("415")
      VALUE_415("415"),
      @SerializedName("416")
      VALUE_416("416"),
      @SerializedName("417")
      VALUE_417("417"),
      @SerializedName("418")
      VALUE_418("418"),
      @SerializedName("419")
      VALUE_419("419"),
      @SerializedName("420")
      VALUE_420("420"),
      @SerializedName("421")
      VALUE_421("421"),
      @SerializedName("422")
      VALUE_422("422"),
      @SerializedName("423")
      VALUE_423("423"),
      @SerializedName("424")
      VALUE_424("424"),
      @SerializedName("425")
      VALUE_425("425"),
      @SerializedName("426")
      VALUE_426("426"),
      @SerializedName("427")
      VALUE_427("427"),
      @SerializedName("428")
      VALUE_428("428"),
      @SerializedName("429")
      VALUE_429("429"),
      @SerializedName("430")
      VALUE_430("430"),
      @SerializedName("431")
      VALUE_431("431"),
      @SerializedName("432")
      VALUE_432("432"),
      @SerializedName("433")
      VALUE_433("433"),
      @SerializedName("434")
      VALUE_434("434"),
      @SerializedName("435")
      VALUE_435("435"),
      @SerializedName("436")
      VALUE_436("436"),
      @SerializedName("437")
      VALUE_437("437"),
      @SerializedName("438")
      VALUE_438("438"),
      @SerializedName("439")
      VALUE_439("439"),
      @SerializedName("440")
      VALUE_440("440"),
      @SerializedName("441")
      VALUE_441("441"),
      @SerializedName("442")
      VALUE_442("442"),
      @SerializedName("443")
      VALUE_443("443"),
      @SerializedName("444")
      VALUE_444("444"),
      @SerializedName("445")
      VALUE_445("445"),
      @SerializedName("446")
      VALUE_446("446"),
      @SerializedName("447")
      VALUE_447("447"),
      @SerializedName("448")
      VALUE_448("448"),
      @SerializedName("449")
      VALUE_449("449"),
      @SerializedName("450")
      VALUE_450("450"),
      @SerializedName("451")
      VALUE_451("451"),
      @SerializedName("452")
      VALUE_452("452"),
      @SerializedName("453")
      VALUE_453("453"),
      @SerializedName("454")
      VALUE_454("454"),
      @SerializedName("455")
      VALUE_455("455"),
      @SerializedName("456")
      VALUE_456("456"),
      @SerializedName("457")
      VALUE_457("457"),
      @SerializedName("458")
      VALUE_458("458"),
      @SerializedName("459")
      VALUE_459("459"),
      @SerializedName("460")
      VALUE_460("460"),
      @SerializedName("461")
      VALUE_461("461"),
      @SerializedName("462")
      VALUE_462("462"),
      @SerializedName("463")
      VALUE_463("463"),
      @SerializedName("464")
      VALUE_464("464"),
      @SerializedName("465")
      VALUE_465("465"),
      @SerializedName("466")
      VALUE_466("466"),
      @SerializedName("467")
      VALUE_467("467"),
      @SerializedName("468")
      VALUE_468("468"),
      @SerializedName("469")
      VALUE_469("469"),
      @SerializedName("470")
      VALUE_470("470"),
      @SerializedName("471")
      VALUE_471("471"),
      @SerializedName("472")
      VALUE_472("472"),
      @SerializedName("473")
      VALUE_473("473"),
      @SerializedName("474")
      VALUE_474("474"),
      @SerializedName("475")
      VALUE_475("475"),
      @SerializedName("476")
      VALUE_476("476"),
      @SerializedName("477")
      VALUE_477("477"),
      @SerializedName("478")
      VALUE_478("478"),
      @SerializedName("479")
      VALUE_479("479"),
      @SerializedName("480")
      VALUE_480("480"),
      ;

      private String value;

      private EnumTimezoneId(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumVertical {
      @SerializedName("ADVERTISING")
      VALUE_ADVERTISING("ADVERTISING"),
      @SerializedName("AUTOMOTIVE")
      VALUE_AUTOMOTIVE("AUTOMOTIVE"),
      @SerializedName("CONSUMER_PACKAGED_GOODS")
      VALUE_CONSUMER_PACKAGED_GOODS("CONSUMER_PACKAGED_GOODS"),
      @SerializedName("ECOMMERCE")
      VALUE_ECOMMERCE("ECOMMERCE"),
      @SerializedName("EDUCATION")
      VALUE_EDUCATION("EDUCATION"),
      @SerializedName("ENERGY_AND_UTILITIES")
      VALUE_ENERGY_AND_UTILITIES("ENERGY_AND_UTILITIES"),
      @SerializedName("ENTERTAINMENT_AND_MEDIA")
      VALUE_ENTERTAINMENT_AND_MEDIA("ENTERTAINMENT_AND_MEDIA"),
      @SerializedName("FINANCIAL_SERVICES")
      VALUE_FINANCIAL_SERVICES("FINANCIAL_SERVICES"),
      @SerializedName("GAMING")
      VALUE_GAMING("GAMING"),
      @SerializedName("GOVERNMENT_AND_POLITICS")
      VALUE_GOVERNMENT_AND_POLITICS("GOVERNMENT_AND_POLITICS"),
      @SerializedName("HEALTH")
      VALUE_HEALTH("HEALTH"),
      @SerializedName("LUXURY")
      VALUE_LUXURY("LUXURY"),
      @SerializedName("MARKETING")
      VALUE_MARKETING("MARKETING"),
      @SerializedName("NON_PROFIT")
      VALUE_NON_PROFIT("NON_PROFIT"),
      @SerializedName("NOT_SET")
      VALUE_NOT_SET("NOT_SET"),
      @SerializedName("ORGANIZATIONS_AND_ASSOCIATIONS")
      VALUE_ORGANIZATIONS_AND_ASSOCIATIONS("ORGANIZATIONS_AND_ASSOCIATIONS"),
      @SerializedName("OTHER")
      VALUE_OTHER("OTHER"),
      @SerializedName("PROFESSIONAL_SERVICES")
      VALUE_PROFESSIONAL_SERVICES("PROFESSIONAL_SERVICES"),
      @SerializedName("RESTAURANT")
      VALUE_RESTAURANT("RESTAURANT"),
      @SerializedName("RETAIL")
      VALUE_RETAIL("RETAIL"),
      @SerializedName("TECHNOLOGY")
      VALUE_TECHNOLOGY("TECHNOLOGY"),
      @SerializedName("TELECOM")
      VALUE_TELECOM("TELECOM"),
      @SerializedName("TRAVEL")
      VALUE_TRAVEL("TRAVEL"),
      ;

      private String value;

      private EnumVertical(String value) {
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

  public ManagedPartnerBusiness copyFrom(ManagedPartnerBusiness instance) {
    this.mAdAccount = instance.mAdAccount;
    this.mCatalogSegment = instance.mCatalogSegment;
    this.mExtendedCredit = instance.mExtendedCredit;
    this.mPage = instance.mPage;
    this.mSellerBusinessInfo = instance.mSellerBusinessInfo;
    this.mSellerBusinessStatus = instance.mSellerBusinessStatus;
    this.mTemplate = instance.mTemplate;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<ManagedPartnerBusiness> getParser() {
    return new APIRequest.ResponseParser<ManagedPartnerBusiness>() {
      public APINodeList<ManagedPartnerBusiness> parseResponse(String response, APIContext context, APIRequest<ManagedPartnerBusiness> request, String header) throws MalformedResponseException {
        return ManagedPartnerBusiness.parseResponse(response, context, request, header);
      }
    };
  }
}
