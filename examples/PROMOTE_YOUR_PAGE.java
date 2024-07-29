/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

import com.facebook.ads.sdk.*;
import java.io.File;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PROMOTE_YOUR_PAGE {
  private static boolean inCleanUp = false;
  public static void run() throws APIException {
      String access_token = "<ACCESS_TOKEN>";
      String app_id = "<APP_ID>";
      String account_id = "act_<ACCOUNT_ID>";
      String page_id = "<PAGE_ID>";
      String ads_image_hash = "<IMAGE_HASH>";
      String page_link = "https://facebook.com/<PAGE_ID>";
      APIContext context = new APIContext(access_token).enableDebug(false);
      APIContext.disableCrashReport();

      // Step 1: Create an ad campaign
      Campaign campaign = new AdAccount(account_id, context).createCampaign()
        .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_TRAFFIC)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .setBuyingType("AUCTION")
        .setName("My Campaign")
        .setSpecialAdCategories(Arrays.asList())
        .execute();
      String campaign_id = campaign.getId();
      System.out.println("Campaign ID: " + campaign_id);


      // Step 2: Under the campaign, create an ad set with some buying options
      AdSet adSet = new AdAccount(account_id, context).createAdSet()
        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
        .setTargeting(
          new Targeting()
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCountries(Arrays.asList("US"))
            )
        )
        .setDailyBudget(100L)
        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
        .setBidAmount(20L)
        .setCampaignId(campaign_id)
        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_REACH)
        .setPromotedObject("{\"page_id\": \"" + page_id + "\"}")
        .setName("My AdSet")
        .execute();
      String ad_set_id = adSet.getId();
      System.out.println("Ad Set ID: " + ad_set_id);
      	
      // Step 3: Create an ad creative with your amazing design
      //         This ad creative is promoting your page
      AdCreative creative = new AdAccount(account_id, context).createAdCreative()
        .setName("Creative")
        .setObjectStorySpec(
          new AdCreativeObjectStorySpec()
            .setFieldLinkData(
              new AdCreativeLinkData()
                .setFieldCallToAction(
                  new AdCreativeLinkDataCallToAction()
                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_LIKE_PAGE)
                    .setFieldValue(
                      new AdCreativeLinkDataCallToActionValue()
                        .setFieldPage(page_id)
                    )
                )
                .setFieldImageHash(ads_image_hash)
                .setFieldLink(page_link)
                .setFieldMessage("Creative message")
            )
            .setFieldPageId(page_id)
        )
        .setDegreesOfFreedomSpec("{\"creative_features_spec\": {\"standard_enhancements\": {\"enroll_status\": \"OPT_IN\"}}}")
        .execute();
      String creative_id = creative.getId();
      System.out.println("Creative ID: " + creative_id);

      // Step 4: Create an ad under your ad set with your ad creative
      Ad ad = new AdAccount(account_id, context).createAd()
        .setStatus(Ad.EnumStatus.VALUE_PAUSED)
        .setAdsetId(ad_set_id)
        .setName("My Ad")
        .setCreative(
          new AdCreative()
            .setFieldId(creative_id)
        )
        .setParam("ad_format", "DESKTOP_FEED_STANDARD")
        .execute();
      String ad_id = ad.getId();
      System.out.println("Ad ID: " + ad_id);
  }

  public static void main (String args[]) throws APIException {
    inCleanUp = false;
    try {
      run();
    } catch (APIException e) {
      if (!inCleanUp) throw e;
    }
  }
}
