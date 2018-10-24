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

public class MultiPromoteYourPage {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    // User get
    User user = new User(id, context).get()
      .execute();
    String user_id = user.getId();

    // Get page access token and page_id
    APINodeList<Page> pages = new User(id, context).getAccounts()
      .requestAccessTokenField()
      .execute();
    String page_id = pages.get(0).getId();

    // Switch access token to page access token
    context = new APIContext(pages.get(0).getFieldAccessToken()).enableDebug(true);
    // Page feed create
    PagePost pagepost = new Page(page_id, context).createFeed()
      .setMessage("This is a test value")
      .execute();
    String pagepost_id = pagepost.getId();

    // Switch access token back to user access token
    context = new APIContext(access_token).enableDebug(true);
    // User adaccounts get
    APINodeList<AdAccount> adaccounts = new User(user_id, context).getAdAccounts()
      .execute();
    String adaccount_id = adaccounts.get(0).getId();

    // AdCampaign create
    Campaign adcampaign = new AdAccount(adaccount_id, context).createCampaign()
      .setName("My campaign")
      .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
      .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
      .execute();
    String adcampaign_id = adcampaign.getId();

    // AdSet create
    AdSet adset = new AdAccount(adaccount_id, context).createAdSet()
      .setName("My Reach Ad Set")
      .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_REACH)
      .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
      .setBidAmount(2L)
      .setDailyBudget(1000L)
      .setCampaignId(adcampaign_id)
      .setTargeting(
          new Targeting()
            .setFieldGeoLocations(
              new TargetingGeoLocation()
                .setFieldCountries(Arrays.asList("US"))
            )
        )
      .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
      .setPromotedObject("{\"page_id\":\"" + page_id + "\"}")
      .execute();
    String adset_id = adset.getId();

    // AdCreative create page post
    AdCreative adcreative = new AdAccount(adaccount_id, context).createAdCreative()
      .setName("Sample Promoted Post")
      .setObjectStoryId(page_id + "_" + pagepost_id)
      .execute();
    String adcreative_id = adcreative.getId();

    // AdGroup create
    new AdAccount(adaccount_id, context).createAd()
      .setName("My Ad")
      .setAdsetId(adset_id)
      .setCreative(
          new AdCreative()
            .setFieldId(adcreative_id)
        )
      .setStatus(Ad.EnumStatus.VALUE_PAUSED)
      .execute();

  }
}