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

public class AdAccountAdSetsPostCreateAudienceNetwork {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdSet()
      .setName("My Ad Set")
      .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_LINK_CLICKS)
      .setBillingEvent(AdSet.EnumBillingEvent.VALUE_LINK_CLICKS)
      .setBidAmount(2L)
      .setDailyBudget(1000L)
      .setCampaignId("<adCampaignLinkClicksID>")
      .setTargeting(
          new Targeting()
            .setFieldDevicePlatforms(Arrays.asList(Targeting.EnumDevicePlatforms.VALUE_MOBILE))
            .setFieldFacebookPositions(Arrays.asList("feed"))
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCountries(Arrays.asList("US"))
            )
            .setFieldPublisherPlatforms(Arrays.asList("facebook", "audience_network"))
        )
      .execute();

  }
}