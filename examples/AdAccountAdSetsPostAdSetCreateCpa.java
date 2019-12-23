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

public class AdAccountAdSetsPostAdSetCreateCpa {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<AD_ACCOUNT_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new AdAccount(id, context).createAdSet()
      .setName("A CPA Ad Set")
      .setCampaignId("<adCampaignLinkClicksID>")
      .setDailyBudget(5000L)
      .setStartTime("2019-12-12T23:42:39-0800")
      .setEndTime("2019-12-19T23:42:39-0800")
      .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
      .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_REACH)
      .setBidAmount(1000L)
      .setPromotedObject("{\"page_id\":\"<pageID>\"}")
      .setTargeting(
          new Targeting()
            .setFieldFacebookPositions(Arrays.asList("feed"))
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCountries(Arrays.asList("US"))
            )
        )
      .setParam("user_os", "iOS")
      .setParam("publisher_platforms", "facebook")
      .setParam("device_platforms", "mobile")
      .execute();

  }
}