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

public class PagePostsEdgePagePostCreateCarousel {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<PAGE_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new Page(id, context).getPosts()
      .setParam("message", "Browse our latest products")
      .setParam("published", "0")
      .setParam("child_attachments", "[{\"link\":\"<link>\",\"name\":\"Product 1\",\"description\":\"$4.99\",\"image_hash\":\"<imageHash>\"},{\"link\":\"<link>\",\"name\":\"Product 2\",\"description\":\"$4.99\",\"image_hash\":\"<imageHash>\"},{\"link\":\"<link>\",\"name\":\"Product 3\",\"description\":\"$4.99\",\"image_hash\":\"<imageHash>\"},{\"link\":\"<link>\",\"name\":\"Product 4\",\"description\":\"$4.99\",\"image_hash\":\"<imageHash>\"}]")
      .setParam("caption", "WWW.EXAMPLE.COM")
      .setParam("link", "http://www.example.com/products")
      .execute();

  }
}