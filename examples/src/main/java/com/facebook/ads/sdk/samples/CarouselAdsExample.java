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

import java.io.File;
import java.util.Arrays;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdCreative;
import com.facebook.ads.sdk.AdCreativeLinkData;
import com.facebook.ads.sdk.AdCreativeObjectStorySpec;
import com.facebook.ads.sdk.AdImage;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.Targeting;
import com.facebook.ads.sdk.TargetingGeoLocation;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.Ad;

public class CarouselAdsExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);
  public static final File imageFile = new File(ExampleConfig.IMAGE_FILE);
  public static final String pageId = ExampleConfig.PAGE_ID;

  public static void main(String[] args) {
    try {
      AdAccount account = new AdAccount(ACCOUNT_ID, context);
      Targeting targeting = new Targeting()
          .setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList("US")))
          .setFieldAgeMin(18L)
          .setFieldAgeMax(30L)
          .setFieldUserOs(Arrays.asList("Android", "iOS"));

      Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Carousel Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .execute();

      AdSet adset = account.createAdSet()
        .setName("Java SDK Test Carousel AdSet")
        .setCampaignId(campaign.getFieldId())
        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
        .setDailyBudget(1000L)
        .setBidAmount(100L)
        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
        .setTargeting(targeting)
        .execute();

      AdImage image = account.createAdImage()
        .addUploadFile("file", imageFile)
        .execute();
      JsonArray childAttachments = new JsonArray();
      JsonObject attachment1 = new JsonObject();
      attachment1.addProperty("link", "https://www.example.com");
      attachment1.addProperty("description", "www.example.com");
      attachment1.addProperty("image_hash", image.getFieldHash());
      childAttachments.add(attachment1);
      JsonObject attachment2 = new JsonObject();
      attachment2.addProperty("link", "https://www.example.com");
      attachment2.addProperty("description", "www.example.com");
      attachment2.addProperty("image_hash", image.getFieldHash());
      childAttachments.add(attachment2);
      JsonObject attachment3 = new JsonObject();
      attachment3.addProperty("link", "https://www.example.com");
      attachment3.addProperty("description", "www.example.com");
      attachment3.addProperty("picture", "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
      childAttachments.add(attachment3);

      AdCreative creative = account.createAdCreative()
          .setTitle("Java SDK Test Carousel Creative")
          .setBody("Java SDK Test Carousel Creative")
          .setObjectStorySpec(new AdCreativeObjectStorySpec()
              .setFieldLinkData(new AdCreativeLinkData()
                   .setFieldChildAttachments(childAttachments.toString())
                   .setFieldLink("www.example.com"))
              .setFieldPageId(pageId)
          )
          .setLinkUrl("www.example.com")
          .execute();

      Ad ad = account.createAd()
          .setName("Java SDK Test Carousel ad")
          .setAdsetId(Long.parseLong(adset.getId()))
          .setCreative(creative)
          .setStatus("PAUSED")
          .setBidAmount(100L)
          .setRedownload(true)
          .execute();

    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
