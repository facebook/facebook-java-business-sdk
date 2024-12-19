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

public class AdAccountCustomAudiencesPostDynamicEventValueBasedLookalikeCustomAudience {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createCustomAudience()
      .setName("Test Value-Based lookalike from Pixel")
      .setSubtype(CustomAudience.EnumSubtype.VALUE_LOOKALIKE)
      .setLookalikeSpec("{\"origin_event_sources\":[{\"id\":\"<sourceID>\",\"event_names\":[\"AddToCart\"]}],\"type\":\"custom_ratio\",\"ratio\":0.01,\"country\":\"US\"}")
      .execute();

  }
}