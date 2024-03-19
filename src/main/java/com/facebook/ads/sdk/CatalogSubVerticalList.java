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
public class CatalogSubVerticalList extends APINode {
  @SerializedName("appliances")
  private Object mAppliances = null;
  @SerializedName("baby_feeding")
  private Object mBabyFeeding = null;
  @SerializedName("baby_transport")
  private Object mBabyTransport = null;
  @SerializedName("beauty")
  private Object mBeauty = null;
  @SerializedName("bedding")
  private Object mBedding = null;
  @SerializedName("cameras")
  private Object mCameras = null;
  @SerializedName("cameras_and_photos")
  private Object mCamerasAndPhotos = null;
  @SerializedName("cell_phones_and_smart_watches")
  private Object mCellPhonesAndSmartWatches = null;
  @SerializedName("cleaning_supplies")
  private Object mCleaningSupplies = null;
  @SerializedName("clo_offer")
  private Object mCloOffer = null;
  @SerializedName("clothing")
  private Object mClothing = null;
  @SerializedName("clothing_accessories")
  private Object mClothingAccessories = null;
  @SerializedName("computer_components")
  private Object mComputerComponents = null;
  @SerializedName("computers_and_tablets")
  private Object mComputersAndTablets = null;
  @SerializedName("computers_laptops_and_tablets")
  private Object mComputersLaptopsAndTablets = null;
  @SerializedName("diapering_and_potty_training")
  private Object mDiaperingAndPottyTraining = null;
  @SerializedName("digital_product_offer")
  private Object mDigitalProductOffer = null;
  @SerializedName("electronic_accessories_and_cables")
  private Object mElectronicAccessoriesAndCables = null;
  @SerializedName("electronics_accessories")
  private Object mElectronicsAccessories = null;
  @SerializedName("furniture")
  private Object mFurniture = null;
  @SerializedName("health")
  private Object mHealth = null;
  @SerializedName("home")
  private Object mHome = null;
  @SerializedName("home_goods")
  private Object mHomeGoods = null;
  @SerializedName("household_and_cleaning_supplies")
  private Object mHouseholdAndCleaningSupplies = null;
  @SerializedName("jewelry")
  private Object mJewelry = null;
  @SerializedName("large_appliances")
  private Object mLargeAppliances = null;
  @SerializedName("local_service_business_item")
  private Object mLocalServiceBusinessItem = null;
  @SerializedName("local_service_business_restaurant")
  private Object mLocalServiceBusinessRestaurant = null;
  @SerializedName("loyalty_offer")
  private Object mLoyaltyOffer = null;
  @SerializedName("nursery")
  private Object mNursery = null;
  @SerializedName("printers_and_scanners")
  private Object mPrintersAndScanners = null;
  @SerializedName("printers_scanners_and_fax_machines")
  private Object mPrintersScannersAndFaxMachines = null;
  @SerializedName("product_discount")
  private Object mProductDiscount = null;
  @SerializedName("projectors")
  private Object mProjectors = null;
  @SerializedName("shoes")
  private Object mShoes = null;
  @SerializedName("shoes_and_footwear")
  private Object mShoesAndFootwear = null;
  @SerializedName("software")
  private Object mSoftware = null;
  @SerializedName("televisions_and_monitors")
  private Object mTelevisionsAndMonitors = null;
  @SerializedName("test_child_sub_vertical")
  private Object mTestChildSubVertical = null;
  @SerializedName("test_grand_child_sub_vertical")
  private Object mTestGrandChildSubVertical = null;
  @SerializedName("test_sub_vertical")
  private Object mTestSubVertical = null;
  @SerializedName("test_sub_vertical_alias")
  private Object mTestSubVerticalAlias = null;
  @SerializedName("test_sub_vertical_data_object")
  private Object mTestSubVerticalDataObject = null;
  @SerializedName("third_party_electronics")
  private Object mThirdPartyElectronics = null;
  @SerializedName("third_party_toys_and_games")
  private Object mThirdPartyToysAndGames = null;
  @SerializedName("toys")
  private Object mToys = null;
  @SerializedName("toys_and_games")
  private Object mToysAndGames = null;
  @SerializedName("tvs_and_monitors")
  private Object mTvsAndMonitors = null;
  @SerializedName("vehicle_manufacturer")
  private Object mVehicleManufacturer = null;
  @SerializedName("video_game_consoles_and_video_games")
  private Object mVideoGameConsolesAndVideoGames = null;
  @SerializedName("video_games_and_consoles")
  private Object mVideoGamesAndConsoles = null;
  @SerializedName("video_projectors")
  private Object mVideoProjectors = null;
  @SerializedName("watches")
  private Object mWatches = null;
  protected static Gson gson = null;

  public CatalogSubVerticalList() {
  }

  public String getId() {
    return null;
  }
  public static CatalogSubVerticalList loadJSON(String json, APIContext context, String header) {
    CatalogSubVerticalList catalogSubVerticalList = getGson().fromJson(json, CatalogSubVerticalList.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(catalogSubVerticalList.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    catalogSubVerticalList.context = context;
    catalogSubVerticalList.rawValue = json;
    catalogSubVerticalList.header = header;
    return catalogSubVerticalList;
  }

  public static APINodeList<CatalogSubVerticalList> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<CatalogSubVerticalList> catalogSubVerticalLists = new APINodeList<CatalogSubVerticalList>(request, json, header);
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
          catalogSubVerticalLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return catalogSubVerticalLists;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                catalogSubVerticalLists.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            catalogSubVerticalLists.setPaging(previous, next);
            if (context.hasAppSecret()) {
              catalogSubVerticalLists.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              catalogSubVerticalLists.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  catalogSubVerticalLists.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              catalogSubVerticalLists.add(loadJSON(obj.toString(), context, header));
            }
          }
          return catalogSubVerticalLists;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              catalogSubVerticalLists.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return catalogSubVerticalLists;
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
              catalogSubVerticalLists.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return catalogSubVerticalLists;
          }

          // Sixth, check if it's pure JsonObject
          catalogSubVerticalLists.clear();
          catalogSubVerticalLists.add(loadJSON(json, context, header));
          return catalogSubVerticalLists;
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


  public Object getFieldAppliances() {
    return mAppliances;
  }

  public CatalogSubVerticalList setFieldAppliances(Object value) {
    this.mAppliances = value;
    return this;
  }

  public Object getFieldBabyFeeding() {
    return mBabyFeeding;
  }

  public CatalogSubVerticalList setFieldBabyFeeding(Object value) {
    this.mBabyFeeding = value;
    return this;
  }

  public Object getFieldBabyTransport() {
    return mBabyTransport;
  }

  public CatalogSubVerticalList setFieldBabyTransport(Object value) {
    this.mBabyTransport = value;
    return this;
  }

  public Object getFieldBeauty() {
    return mBeauty;
  }

  public CatalogSubVerticalList setFieldBeauty(Object value) {
    this.mBeauty = value;
    return this;
  }

  public Object getFieldBedding() {
    return mBedding;
  }

  public CatalogSubVerticalList setFieldBedding(Object value) {
    this.mBedding = value;
    return this;
  }

  public Object getFieldCameras() {
    return mCameras;
  }

  public CatalogSubVerticalList setFieldCameras(Object value) {
    this.mCameras = value;
    return this;
  }

  public Object getFieldCamerasAndPhotos() {
    return mCamerasAndPhotos;
  }

  public CatalogSubVerticalList setFieldCamerasAndPhotos(Object value) {
    this.mCamerasAndPhotos = value;
    return this;
  }

  public Object getFieldCellPhonesAndSmartWatches() {
    return mCellPhonesAndSmartWatches;
  }

  public CatalogSubVerticalList setFieldCellPhonesAndSmartWatches(Object value) {
    this.mCellPhonesAndSmartWatches = value;
    return this;
  }

  public Object getFieldCleaningSupplies() {
    return mCleaningSupplies;
  }

  public CatalogSubVerticalList setFieldCleaningSupplies(Object value) {
    this.mCleaningSupplies = value;
    return this;
  }

  public Object getFieldCloOffer() {
    return mCloOffer;
  }

  public CatalogSubVerticalList setFieldCloOffer(Object value) {
    this.mCloOffer = value;
    return this;
  }

  public Object getFieldClothing() {
    return mClothing;
  }

  public CatalogSubVerticalList setFieldClothing(Object value) {
    this.mClothing = value;
    return this;
  }

  public Object getFieldClothingAccessories() {
    return mClothingAccessories;
  }

  public CatalogSubVerticalList setFieldClothingAccessories(Object value) {
    this.mClothingAccessories = value;
    return this;
  }

  public Object getFieldComputerComponents() {
    return mComputerComponents;
  }

  public CatalogSubVerticalList setFieldComputerComponents(Object value) {
    this.mComputerComponents = value;
    return this;
  }

  public Object getFieldComputersAndTablets() {
    return mComputersAndTablets;
  }

  public CatalogSubVerticalList setFieldComputersAndTablets(Object value) {
    this.mComputersAndTablets = value;
    return this;
  }

  public Object getFieldComputersLaptopsAndTablets() {
    return mComputersLaptopsAndTablets;
  }

  public CatalogSubVerticalList setFieldComputersLaptopsAndTablets(Object value) {
    this.mComputersLaptopsAndTablets = value;
    return this;
  }

  public Object getFieldDiaperingAndPottyTraining() {
    return mDiaperingAndPottyTraining;
  }

  public CatalogSubVerticalList setFieldDiaperingAndPottyTraining(Object value) {
    this.mDiaperingAndPottyTraining = value;
    return this;
  }

  public Object getFieldDigitalProductOffer() {
    return mDigitalProductOffer;
  }

  public CatalogSubVerticalList setFieldDigitalProductOffer(Object value) {
    this.mDigitalProductOffer = value;
    return this;
  }

  public Object getFieldElectronicAccessoriesAndCables() {
    return mElectronicAccessoriesAndCables;
  }

  public CatalogSubVerticalList setFieldElectronicAccessoriesAndCables(Object value) {
    this.mElectronicAccessoriesAndCables = value;
    return this;
  }

  public Object getFieldElectronicsAccessories() {
    return mElectronicsAccessories;
  }

  public CatalogSubVerticalList setFieldElectronicsAccessories(Object value) {
    this.mElectronicsAccessories = value;
    return this;
  }

  public Object getFieldFurniture() {
    return mFurniture;
  }

  public CatalogSubVerticalList setFieldFurniture(Object value) {
    this.mFurniture = value;
    return this;
  }

  public Object getFieldHealth() {
    return mHealth;
  }

  public CatalogSubVerticalList setFieldHealth(Object value) {
    this.mHealth = value;
    return this;
  }

  public Object getFieldHome() {
    return mHome;
  }

  public CatalogSubVerticalList setFieldHome(Object value) {
    this.mHome = value;
    return this;
  }

  public Object getFieldHomeGoods() {
    return mHomeGoods;
  }

  public CatalogSubVerticalList setFieldHomeGoods(Object value) {
    this.mHomeGoods = value;
    return this;
  }

  public Object getFieldHouseholdAndCleaningSupplies() {
    return mHouseholdAndCleaningSupplies;
  }

  public CatalogSubVerticalList setFieldHouseholdAndCleaningSupplies(Object value) {
    this.mHouseholdAndCleaningSupplies = value;
    return this;
  }

  public Object getFieldJewelry() {
    return mJewelry;
  }

  public CatalogSubVerticalList setFieldJewelry(Object value) {
    this.mJewelry = value;
    return this;
  }

  public Object getFieldLargeAppliances() {
    return mLargeAppliances;
  }

  public CatalogSubVerticalList setFieldLargeAppliances(Object value) {
    this.mLargeAppliances = value;
    return this;
  }

  public Object getFieldLocalServiceBusinessItem() {
    return mLocalServiceBusinessItem;
  }

  public CatalogSubVerticalList setFieldLocalServiceBusinessItem(Object value) {
    this.mLocalServiceBusinessItem = value;
    return this;
  }

  public Object getFieldLocalServiceBusinessRestaurant() {
    return mLocalServiceBusinessRestaurant;
  }

  public CatalogSubVerticalList setFieldLocalServiceBusinessRestaurant(Object value) {
    this.mLocalServiceBusinessRestaurant = value;
    return this;
  }

  public Object getFieldLoyaltyOffer() {
    return mLoyaltyOffer;
  }

  public CatalogSubVerticalList setFieldLoyaltyOffer(Object value) {
    this.mLoyaltyOffer = value;
    return this;
  }

  public Object getFieldNursery() {
    return mNursery;
  }

  public CatalogSubVerticalList setFieldNursery(Object value) {
    this.mNursery = value;
    return this;
  }

  public Object getFieldPrintersAndScanners() {
    return mPrintersAndScanners;
  }

  public CatalogSubVerticalList setFieldPrintersAndScanners(Object value) {
    this.mPrintersAndScanners = value;
    return this;
  }

  public Object getFieldPrintersScannersAndFaxMachines() {
    return mPrintersScannersAndFaxMachines;
  }

  public CatalogSubVerticalList setFieldPrintersScannersAndFaxMachines(Object value) {
    this.mPrintersScannersAndFaxMachines = value;
    return this;
  }

  public Object getFieldProductDiscount() {
    return mProductDiscount;
  }

  public CatalogSubVerticalList setFieldProductDiscount(Object value) {
    this.mProductDiscount = value;
    return this;
  }

  public Object getFieldProjectors() {
    return mProjectors;
  }

  public CatalogSubVerticalList setFieldProjectors(Object value) {
    this.mProjectors = value;
    return this;
  }

  public Object getFieldShoes() {
    return mShoes;
  }

  public CatalogSubVerticalList setFieldShoes(Object value) {
    this.mShoes = value;
    return this;
  }

  public Object getFieldShoesAndFootwear() {
    return mShoesAndFootwear;
  }

  public CatalogSubVerticalList setFieldShoesAndFootwear(Object value) {
    this.mShoesAndFootwear = value;
    return this;
  }

  public Object getFieldSoftware() {
    return mSoftware;
  }

  public CatalogSubVerticalList setFieldSoftware(Object value) {
    this.mSoftware = value;
    return this;
  }

  public Object getFieldTelevisionsAndMonitors() {
    return mTelevisionsAndMonitors;
  }

  public CatalogSubVerticalList setFieldTelevisionsAndMonitors(Object value) {
    this.mTelevisionsAndMonitors = value;
    return this;
  }

  public Object getFieldTestChildSubVertical() {
    return mTestChildSubVertical;
  }

  public CatalogSubVerticalList setFieldTestChildSubVertical(Object value) {
    this.mTestChildSubVertical = value;
    return this;
  }

  public Object getFieldTestGrandChildSubVertical() {
    return mTestGrandChildSubVertical;
  }

  public CatalogSubVerticalList setFieldTestGrandChildSubVertical(Object value) {
    this.mTestGrandChildSubVertical = value;
    return this;
  }

  public Object getFieldTestSubVertical() {
    return mTestSubVertical;
  }

  public CatalogSubVerticalList setFieldTestSubVertical(Object value) {
    this.mTestSubVertical = value;
    return this;
  }

  public Object getFieldTestSubVerticalAlias() {
    return mTestSubVerticalAlias;
  }

  public CatalogSubVerticalList setFieldTestSubVerticalAlias(Object value) {
    this.mTestSubVerticalAlias = value;
    return this;
  }

  public Object getFieldTestSubVerticalDataObject() {
    return mTestSubVerticalDataObject;
  }

  public CatalogSubVerticalList setFieldTestSubVerticalDataObject(Object value) {
    this.mTestSubVerticalDataObject = value;
    return this;
  }

  public Object getFieldThirdPartyElectronics() {
    return mThirdPartyElectronics;
  }

  public CatalogSubVerticalList setFieldThirdPartyElectronics(Object value) {
    this.mThirdPartyElectronics = value;
    return this;
  }

  public Object getFieldThirdPartyToysAndGames() {
    return mThirdPartyToysAndGames;
  }

  public CatalogSubVerticalList setFieldThirdPartyToysAndGames(Object value) {
    this.mThirdPartyToysAndGames = value;
    return this;
  }

  public Object getFieldToys() {
    return mToys;
  }

  public CatalogSubVerticalList setFieldToys(Object value) {
    this.mToys = value;
    return this;
  }

  public Object getFieldToysAndGames() {
    return mToysAndGames;
  }

  public CatalogSubVerticalList setFieldToysAndGames(Object value) {
    this.mToysAndGames = value;
    return this;
  }

  public Object getFieldTvsAndMonitors() {
    return mTvsAndMonitors;
  }

  public CatalogSubVerticalList setFieldTvsAndMonitors(Object value) {
    this.mTvsAndMonitors = value;
    return this;
  }

  public Object getFieldVehicleManufacturer() {
    return mVehicleManufacturer;
  }

  public CatalogSubVerticalList setFieldVehicleManufacturer(Object value) {
    this.mVehicleManufacturer = value;
    return this;
  }

  public Object getFieldVideoGameConsolesAndVideoGames() {
    return mVideoGameConsolesAndVideoGames;
  }

  public CatalogSubVerticalList setFieldVideoGameConsolesAndVideoGames(Object value) {
    this.mVideoGameConsolesAndVideoGames = value;
    return this;
  }

  public Object getFieldVideoGamesAndConsoles() {
    return mVideoGamesAndConsoles;
  }

  public CatalogSubVerticalList setFieldVideoGamesAndConsoles(Object value) {
    this.mVideoGamesAndConsoles = value;
    return this;
  }

  public Object getFieldVideoProjectors() {
    return mVideoProjectors;
  }

  public CatalogSubVerticalList setFieldVideoProjectors(Object value) {
    this.mVideoProjectors = value;
    return this;
  }

  public Object getFieldWatches() {
    return mWatches;
  }

  public CatalogSubVerticalList setFieldWatches(Object value) {
    this.mWatches = value;
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

  public CatalogSubVerticalList copyFrom(CatalogSubVerticalList instance) {
    this.mAppliances = instance.mAppliances;
    this.mBabyFeeding = instance.mBabyFeeding;
    this.mBabyTransport = instance.mBabyTransport;
    this.mBeauty = instance.mBeauty;
    this.mBedding = instance.mBedding;
    this.mCameras = instance.mCameras;
    this.mCamerasAndPhotos = instance.mCamerasAndPhotos;
    this.mCellPhonesAndSmartWatches = instance.mCellPhonesAndSmartWatches;
    this.mCleaningSupplies = instance.mCleaningSupplies;
    this.mCloOffer = instance.mCloOffer;
    this.mClothing = instance.mClothing;
    this.mClothingAccessories = instance.mClothingAccessories;
    this.mComputerComponents = instance.mComputerComponents;
    this.mComputersAndTablets = instance.mComputersAndTablets;
    this.mComputersLaptopsAndTablets = instance.mComputersLaptopsAndTablets;
    this.mDiaperingAndPottyTraining = instance.mDiaperingAndPottyTraining;
    this.mDigitalProductOffer = instance.mDigitalProductOffer;
    this.mElectronicAccessoriesAndCables = instance.mElectronicAccessoriesAndCables;
    this.mElectronicsAccessories = instance.mElectronicsAccessories;
    this.mFurniture = instance.mFurniture;
    this.mHealth = instance.mHealth;
    this.mHome = instance.mHome;
    this.mHomeGoods = instance.mHomeGoods;
    this.mHouseholdAndCleaningSupplies = instance.mHouseholdAndCleaningSupplies;
    this.mJewelry = instance.mJewelry;
    this.mLargeAppliances = instance.mLargeAppliances;
    this.mLocalServiceBusinessItem = instance.mLocalServiceBusinessItem;
    this.mLocalServiceBusinessRestaurant = instance.mLocalServiceBusinessRestaurant;
    this.mLoyaltyOffer = instance.mLoyaltyOffer;
    this.mNursery = instance.mNursery;
    this.mPrintersAndScanners = instance.mPrintersAndScanners;
    this.mPrintersScannersAndFaxMachines = instance.mPrintersScannersAndFaxMachines;
    this.mProductDiscount = instance.mProductDiscount;
    this.mProjectors = instance.mProjectors;
    this.mShoes = instance.mShoes;
    this.mShoesAndFootwear = instance.mShoesAndFootwear;
    this.mSoftware = instance.mSoftware;
    this.mTelevisionsAndMonitors = instance.mTelevisionsAndMonitors;
    this.mTestChildSubVertical = instance.mTestChildSubVertical;
    this.mTestGrandChildSubVertical = instance.mTestGrandChildSubVertical;
    this.mTestSubVertical = instance.mTestSubVertical;
    this.mTestSubVerticalAlias = instance.mTestSubVerticalAlias;
    this.mTestSubVerticalDataObject = instance.mTestSubVerticalDataObject;
    this.mThirdPartyElectronics = instance.mThirdPartyElectronics;
    this.mThirdPartyToysAndGames = instance.mThirdPartyToysAndGames;
    this.mToys = instance.mToys;
    this.mToysAndGames = instance.mToysAndGames;
    this.mTvsAndMonitors = instance.mTvsAndMonitors;
    this.mVehicleManufacturer = instance.mVehicleManufacturer;
    this.mVideoGameConsolesAndVideoGames = instance.mVideoGameConsolesAndVideoGames;
    this.mVideoGamesAndConsoles = instance.mVideoGamesAndConsoles;
    this.mVideoProjectors = instance.mVideoProjectors;
    this.mWatches = instance.mWatches;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<CatalogSubVerticalList> getParser() {
    return new APIRequest.ResponseParser<CatalogSubVerticalList>() {
      public APINodeList<CatalogSubVerticalList> parseResponse(String response, APIContext context, APIRequest<CatalogSubVerticalList> request, String header) throws MalformedResponseException {
        return CatalogSubVerticalList.parseResponse(response, context, request, header);
      }
    };
  }
}
