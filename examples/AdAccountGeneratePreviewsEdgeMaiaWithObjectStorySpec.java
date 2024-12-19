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

public class AdAccountGeneratePreviewsEdgeMaiaWithObjectStorySpec {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).getGeneratePreviews()
      .setCreative(
          new AdCreative()
            .setFieldObjectStorySpec(
              new AdCreativeObjectStorySpec()
                .setFieldLinkData(
                  new AdCreativeLinkData()
                    .setFieldCallToAction(
                      new AdCreativeLinkDataCallToAction()
                        .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_USE_APP)
                        .setFieldValue(
                          new AdCreativeLinkDataCallToActionValue()
                            .setFieldLink("<url>")
                        )
                    )
                    .setFieldDescription("Description")
                    .setFieldLink("<url>")
                    .setFieldMessage("Message")
                    .setFieldName("Name")
                    .setFieldPicture("<imageURL>")
                )
                .setFieldPageId("<pageID>")
            )
        )
      .setAdFormat(AdPreview.EnumAdFormat.VALUE_MOBILE_FEED_STANDARD)
      .execute();

  }
}