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

public class AdAccountAdSetsPostBehaviorTargeting {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdSet()
      .setName("My AdSet")
      .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_REACH)
      .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
      .setBidAmount(2L)
      .setDailyBudget(1000L)
      .setCampaignId("<adCampaignConversionsID>")
      .setTargeting(
          new Targeting()
            .setFieldBehaviors(Arrays.asList(
              new IDName()
                .setFieldId(6007101597783L)
                .setFieldName("Business Travelers")
            , 
              new IDName()
                .setFieldId(6004386044572L)
                .setFieldName("Android Owners (All)")
            ))
            .setFieldFacebookPositions(Arrays.asList("feed"))
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCountries(Arrays.asList("US"))
            )
        )
      .execute();

  }
}