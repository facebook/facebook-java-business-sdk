/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdAccount.EnumCampaignStatus;
import com.facebook.ads.sdk.AdAccount.EnumCampaignObjective;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.APIException;

public class QuickStartExample {

  public static final String ACCESS_TOKEN = "[Your Access Token]";
  public static final Long ACCOUNT_ID = [Your Ad Account ID];
  public static final String APP_SECRET = "[Your App Secret]";
  
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
  public static void main(String[] args) {
    try {
      AdAccount account = new AdAccount(ACCOUNT_ID, context);
      Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(EnumCampaignObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(EnumCampaignStatus.VALUE_PAUSED)
        .execute();
      System.out.println(campaign.fetch());
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
