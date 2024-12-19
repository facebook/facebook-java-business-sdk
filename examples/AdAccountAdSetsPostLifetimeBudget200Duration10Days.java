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

public class AdAccountAdSetsPostLifetimeBudget200Duration10Days {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdSet()
      .setName("My First Adset")
      .setLifetimeBudget(20000L)
      .setStartTime("2024-07-29T17:54:57-0700")
      .setEndTime("2024-08-08T17:54:57-0700")
      .setCampaignId("<adCampaignLinkClicksID>")
      .setBidAmount(100L)
      .setBillingEvent(AdSet.EnumBillingEvent.VALUE_LINK_CLICKS)
      .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_LINK_CLICKS)
      .setTargeting(
          new Targeting()
            .setFieldFacebookPositions(Arrays.asList("feed"))
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCountries(Arrays.asList("US"))
            )
            .setFieldPublisherPlatforms(Arrays.asList("facebook", "audience_network"))
        )
      .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
      .execute();

  }
}