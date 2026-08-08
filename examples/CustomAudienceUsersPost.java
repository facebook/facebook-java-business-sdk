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

public class CustomAudienceUsersPost {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<CUSTOM_AUDIENCE_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new CustomAudience(id, context).createUser()
      .setPayload("{\"schema\":[\"EMAIL\",\"LOOKALIKE_VALUE\"],\"data\":[[\"9b431636bd164765d63c573c346708846af4f68fe3701a77a3bdd7e7e5166254\",44.5],[\"8cc62c145cd0c6dc444168eaeb1b61b351f9b1809a579cc9b4c9e9d7213a39ee\",140],[\"4eaf70b1f7a797962b9d2a533f122c8039012b31e0a52b34a426729319cb792a\",0],[\"98df8d46f118f8bef552b0ec0a3d729466a912577830212a844b73960777ac56\",0.9]]}")
      .execute();

  }
}
