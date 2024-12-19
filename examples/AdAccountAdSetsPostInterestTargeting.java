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

public class AdAccountAdSetsPostInterestTargeting {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdSet()
      .setName("My First AdSet")
      .setDailyBudget(10000L)
      .setBidAmount(300L)
      .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
      .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_REACH)
      .setCampaignId("<adCampaignLinkClicksID>")
      .setPromotedObject("{\"page_id\":\"<pageID>\"}")
      .setTargeting(
          new Targeting()
            .setFieldAgeMax(24L)
            .setFieldAgeMin(20L)
            .setFieldDevicePlatforms(Arrays.asList(Targeting.EnumDevicePlatforms.VALUE_MOBILE))
            .setFieldFacebookPositions(Arrays.asList("feed"))
            .setFieldFlexibleSpec(Arrays.asList(
              new FlexibleTargeting()
                .setFieldInterests(Arrays.asList(
                  new IDName()
                    .setFieldId("<adsInterestID>")
                    .setFieldName("<adsInterestName>")
                ))
            ))
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
            .setFieldPublisherPlatforms(Arrays.asList("facebook", "audience_network"))
        )
      .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
      .execute();

  }
}