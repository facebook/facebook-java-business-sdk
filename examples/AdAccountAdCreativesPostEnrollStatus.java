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

public class AdAccountAdCreativesPostEnrollStatus {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdCreative()
      .setName("Sample Promoted")
      .setObjectStorySpec(
          new AdCreativeObjectStorySpec()
            .setFieldLinkData(
              new AdCreativeLinkData()
                .setFieldImageHash("<imageHash>")
                .setFieldLink("<imageURL>")
                .setFieldMessage("try it out")
            )
            .setFieldPageId("<pageID>")
        )
      .setParam("degrees_of_freedom_spec", "{\"creative_features_spec\":\"{\"standard_enhancements\":\"{\\"enroll_status\\":\\"OPT_IN\\"}\"}\"}")
      .setParam("special_ad_categories", "[]")
      .execute();

  }
}