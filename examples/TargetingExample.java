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

import java.util.Arrays;
import java.util.Collections;

public class TargetingExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);

  public static void main(String[] args) {
    try {
      AdAccount account = new AdAccount(ACCOUNT_ID, context);

      Targeting targeting = new Targeting()
          .setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList("US")))
          .setFieldAgeMin(18L)
          .setFieldAgeMax(30L)
          .setFieldGenders(Collections.singletonList(1L)) // 0 - All (default), 1 - Men, 2 - Women
          .setFieldLocales(Arrays.asList(6L, 24L)) // 6 - English (US), 24 - English (UK)
          .setFieldUserOs(Arrays.asList("Android", "iOS"));

      Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .execute();

      AdSet adset = account.createAdSet()
        .setName("Java SDK Test AdSet")
        .setCampaignId(campaign.getFieldId())
        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
        .setDailyBudget(1000L)
        .setBidAmount(100L)
        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
        .setTargeting(targeting)
        .execute();

    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
