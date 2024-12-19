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

public class AdAccountAdCreativesPostCreateAdCreativeCustomizationCanvasVideo {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdCreative()
      .setObjectStorySpec(
          new AdCreativeObjectStorySpec()
            .setFieldPageId("<pageID>")
            .setFieldVideoData(
              new AdCreativeVideoData()
                .setFieldCallToAction(
                  new AdCreativeLinkDataCallToAction()
                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_LEARN_MORE)
                    .setFieldValue(
                      new AdCreativeLinkDataCallToActionValue()
                        .setFieldLink("<canvasURI>")
                    )
                )
                .setFieldImageUrl("<imageURL>")
                .setFieldMessage("English Creative message")
                .setFieldRetailerItemIds(Arrays.asList(0L, 0L, 0L, 0L))
                .setFieldTitle("English Creative title")
                .setFieldVideoId("<videoID>")
            )
        )
      .setProductSetId("<productSetID>")
      .execute();

  }
}