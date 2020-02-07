/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

 import com.facebook.ads.sdk.*;
import java.io.File;
import java.util.Arrays;

public class AdAccountAdCreativesPostCreateDynamicAdCustomization {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdCreative()
      .setName("Dynamic Ad Template Creative Sample")
      .setObjectStorySpec(
          new AdCreativeObjectStorySpec()
            .setFieldPageId("<pageID>")
            .setFieldTemplateData(
              new AdCreativeLinkData()
                .setFieldCustomizationRulesSpec(Arrays.asList(
                  new AdCustomizationRuleSpec()
                    .setFieldCustomizationSpec("{\"language\":\"en_XX\"}")
                , 
                  new AdCustomizationRuleSpec()
                    .setFieldCustomizationSpec("{\"language\":\"fr_XX\"}")
                    .setFieldDescription("French Description {{product.description}}")
                    .setFieldLink("http://www.example.com/frenchurl")
                    .setFieldMessage("French Test {{product.name | titleize}}")
                    .setFieldName("French Headline {{product.price}}")
                    .setFieldTemplateUrlSpec(
                      new AdCreativeTemplateURLSpec()
                        .setFieldWeb("{\"url\":\"http://www.example.com/frenchdeeplink\"}")
                    )
                ))
                .setFieldDescription("English Description {{product.description}}")
                .setFieldLink("http://www.example.com/englishurl")
                .setFieldMessage("English Test {{product.name | titleize}}")
                .setFieldName("English Headline {{product.price}}")
            )
        )
      .setProductSetId("<productSetID>")
      .setTemplateUrlSpec("{\"web\":{\"url\":\"http://www.example.com/englishdeeplink\"}}")
      .execute();

  }
}