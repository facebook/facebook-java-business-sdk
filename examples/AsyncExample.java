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
import com.facebook.ads.sdk.insights.InsightsBreakdownsEnum;

import java.io.File;
import java.util.Collections;

public class AsyncExample {

  public static final String ACCESS_TOKEN = "[Your access token]";
  public static final String ACCOUNT_ID = "[Your ad account id]";
  public static final String APP_SECRET = "[Your app secret]";
  public static final File imageFile = new File("[path to image file for test]");

  
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
  public static void main(String[] args) {
    try {
      Ad ad = new AdAccount(ACCOUNT_ID, context).getAds().requestIdField()
          .setParam("limit", 1).execute().head();
      Ad.APIRequestGetInsightsAsync adInsights = ad.getInsightsAsync();
      adInsights.setFields("cpm,cpp");
      adInsights.setBreakdowns(Collections.singletonList(InsightsBreakdownsEnum.VALUE_AGE));
      adInsights.setTimeRange("{\"since\":\"2016-01-01\",\"until\":\"2016-02-02\"}");
      AdReportRun adReportRun = adInsights.execute().head();
      // get actual data
      adReportRun.fetch();
      System.out.println(adReportRun);
      while (adReportRun.getFieldIsRunning()) {
        Thread.sleep(1000);
        adReportRun = adReportRun.fetch();
      }
      APINodeList<AdsInsights> insights = adReportRun.getInsights().requestAllFields().execute();

      for (AdsInsights insight : insights) {
        System.out.println(insight);
      }
      System.out.println("Finished getting async insights for ads");

      // same goes for campaign, adsrt and adaccount
      Campaign campaign = new AdAccount(ACCOUNT_ID, context).getCampaigns().requestIdField()
          .setParam("limit", 1).execute().head();
      Campaign.APIRequestGetInsightsAsync campaignInsights = campaign.getInsightsAsync();
      adInsights.setFields("cpm,cpp");
      adInsights.setBreakdowns(Collections.singletonList(InsightsBreakdownsEnum.VALUE_COUNTRY));
      adInsights.setTimeRange("{\"since\":\"2016-01-01\",\"until\":\"2016-02-02\"}");
      adReportRun = campaignInsights.execute().head();
      // get actual data
      adReportRun.fetch();
      System.out.println(adReportRun);
      while (adReportRun.getFieldIsRunning()) {
        Thread.sleep(1000);
        adReportRun = adReportRun.fetch();
      }
      insights = adReportRun.getInsights().requestAllFields().execute();

      for (AdsInsights insight : insights) {
        System.out.println(insight);
      }
      System.out.println("Finished getting async insights for campaigns");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
