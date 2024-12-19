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

public class AdAccountAdSetsPostOptimizePostEngagement {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdSet()
      .setName("My First Adset")
      .setLifetimeBudget(20000L)
      .setStartTime("2024-07-29T17:55:06-0700")
      .setEndTime("2024-08-08T17:55:06-0700")
      .setCampaignId("<adCampaignLinkClicksID>")
      .setBidAmount(500L)
      .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
      .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_POST_ENGAGEMENT)
      .setTargeting(
          new Targeting()
            .setFieldAgeMax(24L)
            .setFieldAgeMin(20L)
            .setFieldBehaviors(Arrays.asList(
              new IDName()
                .setFieldId(6002714895372L)
                .setFieldName("All travelers")
            ))
            .setFieldDevicePlatforms(Arrays.asList(Targeting.EnumDevicePlatforms.VALUE_DESKTOP))
            .setFieldFacebookPositions(Arrays.asList("feed"))
            .setFieldGenders(Arrays.asList(1L))
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCities(Arrays.asList(
                  new TargetingGeoLocationCity()
                    .setFieldDistanceUnit("mile")
                    .setFieldKey(777934L)
                    .setFieldRadius(10L)
                ))
                .setFieldCountries(Arrays.asList("US"))
                .setFieldRegions(Arrays.asList(
                  new TargetingGeoLocationRegion()
                    .setFieldKey("4081")
                ))
            )
            .setFieldLifeEvents(Arrays.asList(
              new IDName()
                .setFieldId(6002714398172L)
                .setFieldName("Newlywed (1 year)")
            ))
            .setFieldPublisherPlatforms(Arrays.asList("facebook"))
        )
      .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
      .execute();

  }
}