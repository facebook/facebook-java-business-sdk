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

public class AdAccountCampaignsPost {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createCampaign()
      .setName("My campaign")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_TRAFFIC)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setParam("special_ad_categories", "[]")
      .execute();

    new AdAccount(id, context).createCampaign()
      .setName("Lead generation campaign")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_LEADS)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setParam("special_ad_categories", "[]")
      .execute();

    new AdAccount(id, context).createCampaign()
      .setName("Local ad campaign")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_AWARENESS)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setParam("special_ad_categories", "[]")
      .execute();

    new AdAccount(id, context).createCampaign()
      .setName("Mobile App Installs Campaign")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_APP_PROMOTION)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setParam("special_ad_categories", "[]")
      .execute();

    new AdAccount(id, context).createCampaign()
      .setName("App Installs Campaign with Dynamic Product Ads")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_APP_PROMOTION)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setParam("special_ad_categories", "[]")
      .execute();

    new AdAccount(id, context).createCampaign()
      .setName("Video Views campaign")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_ENGAGEMENT)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setParam("special_ad_categories", "[]")
      .execute();

    new AdAccount(id, context).createCampaign()
      .setName("My First Campaign")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_ENGAGEMENT)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setParam("special_ad_categories", "[]")
      .execute();

    new AdAccount(id, context).createCampaign()
      .setName("My First Campaign")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_ENGAGEMENT)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setParam("special_ad_categories", "[]")
      .execute();

    new AdAccount(id, context).createCampaign()
      .setName("My First Campaign with daily budget")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_LEADS)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setDailyBudget(1000L)
      .setParam("special_ad_categories", "[]")
      .execute();

    new AdAccount(id, context).createCampaign()
      .setName("My First Campaign with special ad categories")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_LEADS)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setDailyBudget(1000L)
      .setParam("special_ad_categories", "[]")
      .setParam("special_ad_category_country", "[\"MX\"]")
      .execute();

  }
}