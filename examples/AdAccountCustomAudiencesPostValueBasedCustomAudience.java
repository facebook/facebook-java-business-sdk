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

public class AdAccountCustomAudiencesPostValueBasedCustomAudience {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createCustomAudience()
      .setName("Value-Based Custom Audience")
      .setSubtype(CustomAudience.EnumSubtype.VALUE_CUSTOM)
      .setIsValueBased(true)
      .setCustomerFileSource(CustomAudience.EnumCustomerFileSource.VALUE_PARTNER_PROVIDED_ONLY)
      .execute();

  }
}