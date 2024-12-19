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

public class AdAccountAdSetsPostAdSetCreateCpaAppEvents {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdSet()
      .setName("A CPA Ad Set optimized for App Events")
      .setCampaignId("<adCampaignAppInstallsID>")
      .setDailyBudget(300L)
      .setStartTime("2024-08-05T17:55:15-0700")
      .setEndTime("2024-08-12T17:55:15-0700")
      .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
      .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_OFFSITE_CONVERSIONS)
      .setBidAmount(100L)
      .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
      .setPromotedObject("{\"application_id\":\"<appID>\",\"object_store_url\":\"<appLink>\",\"custom_event_type\":\"PURCHASE\"}")
      .setTargeting(
          new Targeting()
            .setFieldFacebookPositions(Arrays.asList("feed"))
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCountries(Arrays.asList("US"))
            )
            .setFieldUserOs(Arrays.asList("iOS"))
        )
      .execute();

  }
}