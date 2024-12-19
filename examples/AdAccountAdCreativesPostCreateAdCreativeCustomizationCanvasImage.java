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

public class AdAccountAdCreativesPostCreateAdCreativeCustomizationCanvasImage {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdCreative()
      .setObjectStorySpec(
          new AdCreativeObjectStorySpec()
            .setFieldLinkData(
              new AdCreativeLinkData()
                .setFieldCallToAction(
                  new AdCreativeLinkDataCallToAction()
                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_LEARN_MORE)
                )
                .setFieldCustomizationRulesSpec(Arrays.asList(
                  new AdCustomizationRuleSpec()
                    .setFieldCustomizationSpec("{\"language\":\"en_XX\"}")
                , 
                  new AdCustomizationRuleSpec()
                    .setFieldCustomizationSpec("{\"language\":\"fr_XX\"}")
                    .setFieldLink("<canvasURIFR>")
                    .setFieldMessage("French Creative message")
                    .setFieldName("French Creative title")
                ))
                .setFieldLink("<canvasURI>")
                .setFieldMessage("English Creative message")
                .setFieldName("English Creative title")
                .setFieldPicture("<imageURL>")
                .setFieldRetailerItemIds(Arrays.asList(0L, 0L, 0L, 0L))
            )
            .setFieldPageId("<pageID>")
        )
      .setProductSetId("<productSetID>")
      .execute();

  }
}