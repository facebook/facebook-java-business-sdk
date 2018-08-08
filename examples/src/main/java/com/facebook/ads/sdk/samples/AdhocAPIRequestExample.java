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

import java.io.File;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.APIRequest;

public class AdhocAPIRequestExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);
  public static final File imageFile = new File(ExampleConfig.IMAGE_FILE);

  public static void main(String[] args) {
    try {
      APIRequest<AdAccount> request = new APIRequest<AdAccount>(context, "me", "/adaccounts", "GET", AdAccount.getParser());
      APINodeList<AdAccount> accounts = (APINodeList<AdAccount>)(request.execute());
      for (AdAccount account : accounts) {
        System.out.println("account: " + account);
        APIRequest<Campaign> campaigns_request = new APIRequest<Campaign>(context, "act_" + account.getId(), "/campaigns", "GET", null, Campaign.getParser())
            .requestField("name");
        APINodeList<Campaign> campaigns = (APINodeList<Campaign>)(campaigns_request.execute());
        System.out.println("campaigns: " + campaigns);
        for (Campaign campaign : campaigns) {
          System.out.println("campaign: " + campaign);
        }
      };
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
