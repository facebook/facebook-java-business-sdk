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
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdCreative;
import com.facebook.ads.sdk.AdCreativeLinkData;
import com.facebook.ads.sdk.AdCreativeObjectStorySpec;
import com.facebook.ads.sdk.AdImage;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.Targeting;
import com.facebook.ads.sdk.TargetingGeoLocation;
import com.facebook.ads.sdk.APIException;

public class BasicExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final String PAGE_ID = ExampleConfig.PAGE_ID;
  public static final File imageFile = new File(ExampleConfig.IMAGE_FILE);

  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);
  public static void main(String[] args) {
    try {
      Targeting targeting = new Targeting().setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList("US")));
      AdAccount account = new AdAccount(ACCOUNT_ID, context);

      // Creation
      Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .execute();
      System.out.println(campaign);
      AdSet adset = account.createAdSet()
        .setName("Java SDK Test AdSet")
        .setCampaignId(campaign.getFieldId())
        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
        .setDailyBudget(500L)
        .setBidAmount(100L)
        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
        .setTargeting(targeting)
        .setRedownload(true)
        .execute();
      System.out.println(adset);
      AdImage image = account.createAdImage()
        .addUploadFile("file", imageFile)
        .execute();
      AdCreativeLinkData link = (new AdCreativeLinkData())
        .setFieldMessage("AdCreativeLinkData MSG")
        .setFieldLink("www.facebook.com")
        .setFieldImageHash(image.getFieldHash())
        .setFieldCaption("www.facebook.com");
      AdCreativeObjectStorySpec spec = (new AdCreativeObjectStorySpec())
        .setFieldPageId(PAGE_ID)
        .setFieldLinkData(link);
      AdCreative creative = account.createAdCreative()
        .setName("Java SDK Test Creative")
        .setObjectStorySpec(spec)
        .execute();
      Ad ad = account.createAd()
        .setName("Java SDK Test ad")
        .setAdsetId(Long.parseLong(adset.getId()))
        .setCreative(creative)
        .setStatus("PAUSED")
        .setBidAmount(100L)
        .setRedownload(true)
        .execute();
      System.out.println("Creation done!");

      // Get after creation
      campaign.fetch(); // fetch() is just a shortcut for *.get().requestAllFields().execute()
      adset.fetch();
      ad.fetch();
      System.out.println(campaign);
      System.out.println(adset);
      System.out.println(ad);
      System.out.println("Get after creation done!");

      // call edge to get adsets
      for(AdSet as : campaign.getAdSets().requestAllFields().execute()) {
        for(Ad a : as.getAds().requestAllFields().execute()) {
          System.out.println(a);
        }
        System.out.println(as);
      }
      System.out.println("Get from edge done!");

      // Get with static methods
      System.out.println(Campaign.fetchById(campaign.getFieldId(), context));
      System.out.println(AdSet.fetchById(adset.getFieldId(), context));
      System.out.println("Get with static methods done!");

      // Update
      campaign.update()
        .setName("Updated Java SDK Test Campaign")
        .execute();
      adset.update()
        .setName("Updated Java SDK Test AdSet")
        .execute();
      System.out.println("Update done!");

      // Get after update
      campaign.fetch();
      adset.fetch();
      System.out.println(campaign);
      System.out.println(adset);
      System.out.println("Get after update done!");

      // Delete
      campaign.delete().execute();
      adset.delete().execute();
      System.out.println("Deletion done!");

      // Get after deletion
      campaign.fetch();
      adset.fetch();
      System.out.println(campaign);
      System.out.println(adset);
      for(AdSet as : campaign.getAdSets().requestAllFields().execute()) {
        System.out.println(as);
      }
      System.out.println("Get after deletion done!");
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
