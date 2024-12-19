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

public class AdAccountCampaignsPostMAIA {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createCampaign()
      .setName("Mobile App Installs Campaign")
      .setObjective(Campaign.EnumObjective.VALUE_OUTCOME_APP_PROMOTION)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .setParam("special_ad_categories", "[]")
      .execute();

  }
}