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

public class AdsPixelEventsPost {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<ADS_PIXEL_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdsPixel(id, context).createEvent()
      .setData("[{\"event_name\":\"PageView\",\"event_time\":1721461428,\"user_data\":{\"fbc\":\"fb.1.1554763741205.AbCdEfGhIjKlMnOpQrStUvWxYz1234567890\",\"fbp\":\"fb.1.1558571054389.1098115397\",\"em\":\"309a0a5c3e211326ae75ca18196d301a9bdbd1a882a4d2569511033da23f0abd\"}}]")
      .execute();

  }
}