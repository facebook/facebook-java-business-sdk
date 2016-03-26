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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdCreative;
import com.facebook.ads.sdk.AdImage;
import com.facebook.ads.sdk.AdAccount.EnumBillingEvent;
import com.facebook.ads.sdk.AdAccount.EnumCampaignStatus;
import com.facebook.ads.sdk.AdAccount.EnumAdSetStatus;
import com.facebook.ads.sdk.AdAccount.EnumCampaignObjective;
import com.facebook.ads.sdk.AdAccount.EnumOptimizationGoal;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Targeting;
import com.facebook.ads.sdk.TargetingGeoLocation;
import com.facebook.ads.sdk.TargetingGeoLocationZip;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;

public class BasicExample {

  public static final String ACCESS_TOKEN = "[Your access token]";
  public static final Long ACCOUNT_ID = [Your ad account id];
  public static final String APP_SECRET = "[Your app secret]";
  public static final File imageFile = new File("[path to image file for test]");
  
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
  public static void main(String[] args) {
    try {
      Targeting targeting = new Targeting().setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList(new String[]{"US"})));
      AdAccount account = new AdAccount(ACCOUNT_ID, context);
      
      // Creation
      Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(EnumCampaignObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(EnumCampaignStatus.VALUE_PAUSED)
        .execute();
      AdSet adset = account.createAdSet()
        .setName("Java SDK Test AdSet")
        .setCampaignId(campaign.getFieldId())
        .setStatus(EnumAdSetStatus.VALUE_PAUSED)
        .setBillingEvent(EnumBillingEvent.VALUE_IMPRESSIONS)
        .setDailyBudget(1000L)
        .setBidAmount(100L)
        .setOptimizationGoal(EnumOptimizationGoal.VALUE_IMPRESSIONS)
        .setTargeting(targeting)
        .execute();
      AdImage image = account.createAdImage()
        .addUploadFile("file", imageFile)
        .execute();
      AdCreative creative = account.createAdCreative()
        .setTitle("Java SDK Test Creative")
        .setBody("Java SDK Test Creative")
        .setImageHash(image.getFieldHash())
        .setLinkUrl("www.facebook.com")
        .setObjectUrl("www.facebook.com")
        .execute();
      Ad ad = account.createAd()
        .setName("Java SDK Test ad")
        .setAdsetId(Long.parseLong(adset.getId()))
        .setCreative(creative)
        .setStatus("PAUSED")
        .setBidAmount(100L)
        .execute();
      System.out.println("Creation done!");
      
      // Get after creation
      campaign.fetch(); // fetch() is just a shortcut for *.get().requestAllFields().execute()
      adset.fetch();
      ad.fetch();
      System.out.println(campaign);
      System.out.println(adset);
      System.out.println("Get after creation done!");

      // get all available ad accounts
      for (AdAccount adAccountAll : AdAccount.fetchAll(100, context)) {
        System.out.println(adAccountAll);
      }
      System.out.println("Getting all ad accounts done!");
      
      // call edge to get adsets
      for(AdSet as : campaign.getAdSets().requestAllFields().execute()) {
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
