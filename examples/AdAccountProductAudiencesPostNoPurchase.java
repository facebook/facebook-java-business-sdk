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

public class AdAccountProductAudiencesPostNoPurchase {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createProductAudience()
      .setName("Test Product Audience")
      .setProductSetId("<productSetID>")
      .setInclusions("[{\"retention_seconds\":86400,\"rule\":{\"event\":{\"eq\":\"AddToCart\"}}},{\"retention_seconds\":72000,\"rule\":{\"event\":{\"eq\":\"ViewContent\"}}}]")
      .setExclusions("[{\"retention_seconds\":172800,\"rule\":{\"event\":{\"eq\":\"Purchase\"}}}]")
      .execute();

  }
}