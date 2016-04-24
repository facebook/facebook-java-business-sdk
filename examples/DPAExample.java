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

import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdCreative;
import com.facebook.ads.sdk.AdCreativeLinkData;
import com.facebook.ads.sdk.AdCreativeObjectStorySpec;
import com.facebook.ads.sdk.AdPreview;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINode;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.Business;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.CustomAudience;
import com.facebook.ads.sdk.OffsitePixel;
import com.facebook.ads.sdk.ProductCatalog;
import com.facebook.ads.sdk.ProductFeed;
import com.facebook.ads.sdk.ProductFeedUpload;
import com.facebook.ads.sdk.ProductItem;
import com.facebook.ads.sdk.ProductSet;
import com.facebook.ads.sdk.Targeting;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DPAExample {
  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final File imageFile = new File(ExampleConfig.IMAGE_FILE);
  public static final String FEED_FILE_PATH = ExampleConfig.DPA_FEED_FILE_PATH;
  public static final Long BUSINESS_ID = ExampleConfig.BUSINESS_ID;
  public static final String pageId = ExampleConfig.PAGE_ID;

  APIContext context = new APIContext(ACCESS_TOKEN).enableDebug(true);
  AdAccount account = new AdAccount(ACCOUNT_ID, context);
  Business business = new Business(BUSINESS_ID, context);
  ProductCatalog catalog = null;
  ProductFeed feed = null;
  ProductSet productSet = null;
  ProductFeedUpload upload = null;
  CustomAudience audience = null;
  OffsitePixel pixel = null;

  public static void main(String[] args) {
    try {
      DPAExample example = new DPAExample();
      example.createProductCatalog();
      example.createPixel();
      example.createDPA();
      System.out.println("All Done!");
    } catch (APIException e) {
      e.printStackTrace();
    }
  }

  public void createProductCatalog() throws APIException {
    catalog = business.createProductCatalog()
        .setName("SDK Test Product Catalog")
        .execute();
    productSet = catalog.createProductSet()
        .setFilter("{\"condition\":{\"i_contains\":\"new\"}}")
        .setName("SDK Test Product Set")
        .execute();
    feed = catalog.createProductFeed()
        .setName("SDK Test Product Feed")
        .setSchedule("{\"interval\":\"DAILY\", \"url\":\"http://www.example.com/sample_feed.tsv\", \"hour\":2}")
        .execute();
    upload = feed.createUpload()
        .addUploadFile("file", new File(FEED_FILE_PATH))
        .execute();
  }

  public void createPixel() throws APIException {
    // Probably need to accept new "Terms of Service" before doing this on new accounts
    pixel = account.createOffsitePixel()
        .setName("JAVA SDK Test Pixel")
        .execute();
    APINode productAudience = account.createProductAudience()
        .setName("JAVA SDK Test Product Audience")
        .setProductSetId(productSet.getFieldId())
        .setInclusions("[{\"retention_seconds\":86400,\"rule\":{\"event\":{\"eq\":\"AddToCart\"}}}]")
        .setSubtype(AdAccount.EnumSubtype.VALUE_WEBSITE)
        .execute();
    audience = new CustomAudience(productAudience.getId(), context).fetch();
  }

  public void createDPA() throws APIException {
    Campaign dpaCampaign = account.createCampaign()
        .setName("JAVA SDK DPA Test Campaign")
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .setObjective(Campaign.EnumObjective.VALUE_PRODUCT_CATALOG_SALES)
        .setPromotedObject("{\"product_catalog_id\": \"" + catalog.getFieldId() + "\", \"product_set_id\":\"" + productSet.getFieldId() + "\"}")
        .execute();
    AdSet adset = account.createAdSet()
        .setCampaignId(dpaCampaign.getFieldId())
        .setName("JAVA SDK DPA Test AdSet")
        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
        .setBidAmount(500L)
        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_OFFSITE_CONVERSIONS)
        .setDailyBudget(2500L)
        .setPromotedObject("{\"pixel_id\": " + pixel.getFieldId() + ", \"product_set_id\":\"" + productSet.getFieldId() + "\"}")
        .setTargeting(
            new Targeting()
            .setFieldAgeMin(60L)
            .setFieldAgeMax(65L)
            .setFieldGeoLocations("{\"countries\": [\"US\"]}")
            .setFieldDynamicAudienceIds(Arrays.asList(audience.getFieldId()))
            )
        .execute();
    AdCreative creative = account
        .createAdCreative()
        .setObjectStorySpec(
            new AdCreativeObjectStorySpec()
            .setFieldPageId(pageId)
            .setFieldTemplateData(
                new AdCreativeLinkData()
                .setFieldName("Name: {{product.price}}")
                .setFieldLink("www.pandaparadise.net")
                .setFieldDescription("Description {{product.description}}")
                .setFieldMessage("Message {{product.name | titleize}}")
                )
            )
        .setName("Java SDK DPA Test Creative")
        .setProductSetId(productSet.getId())
        .execute();

    Ad ad = account.createAd()
        .setCreative(creative)
        .setAdsetId(adset.getId())
        .setStatus(Ad.EnumStatus.VALUE_PAUSED)
        .setName("SDK Test ad")
        .setBidAmount(100L)
        .execute();

    ProductItem productItem = null;
    // After feed upload, it takes a few seconds for server to parse the file and actually load the product items
    try {
      do {
        Thread.sleep(5000);
        List<ProductItem> productItems = feed.getProducts().execute();
        if (productItems.size() > 0) productItem = productItems.get(0);
        System.out.println("Waiting for products to be sync'ed. ProductItems size: " + productItems.size() + "; ProductItem: " + productItem);
      } while (productItem == null);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    creative.getPreviews()
    .setAdFormat(AdPreview.EnumAdFormat.VALUE_DESKTOP_FEED_STANDARD)
    .setProductItemIds(Arrays.asList("catalog:" + catalog.getId() + ":" + "REJfMQ==" /*base64_encode of 'DB_1'*/))
    .execute();
  }
}
