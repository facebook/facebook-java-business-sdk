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

public class CustomAudienceUsersPostCrossPlatform {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<CUSTOM_AUDIENCE_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new CustomAudience(id, context).createUser()
      .setPayload("{\"schema\":[\"EMAIL\",\"MADID\",\"APPUID\",\"LOOKALIKE_VALUE\"],\"app_ids\":[\"<appID>\"],\"data\":[[\"b36a83701f1c3191e19722d6f90274bc1b5501fe69ebf33313e440fe4b0fe210\",\"6032d997-3ab0-4de0-aa16-8af0e5b482fb\",\"1234567890\",\"0.9\"],[\"2b3b2b9ce842ab8b6a6c614cb1f9604bb8a0d502d1af49c526b72b10894e95b5\",\"B67385F8-9A82-4670-8C0A-6F9EA7513F5F\",\"\",\"0\"],[\"898628e28890f937bdf009391def42879c401a4bcf1b5fd24e738d9f5da8cbbb\",\"\",\"9876543210\",\"0.4\"]]}")
      .execute();

  }
}