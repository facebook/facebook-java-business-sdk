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

public class AdAccountAdSetsPostAdSetCreateCpa {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdSet()
      .setName("A CPA Ad Set")
      .setCampaignId("<adCampaignLinkClicksID>")
      .setDailyBudget(5000L)
      .setStartTime("2024-07-27T00:47:13-0700")
      .setEndTime("2024-08-03T00:47:13-0700")
      .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
      .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_REACH)
      .setBidAmount(1000L)
      .setPromotedObject("{\"page_id\":\"<pageID>\"}")
      .setTargeting(
          new Targeting()
            .setFieldFacebookPositions(Arrays.asList("feed"))
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCountries(Arrays.asList("US"))
            )
        )
      .setParam("user_os", "iOS")
      .setParam("publisher_platforms", "facebook")
      .setParam("device_platforms", "mobile")
      .execute();

  }
}