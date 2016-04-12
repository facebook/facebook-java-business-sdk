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

import java.util.Arrays;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdReportRun;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.AdsInsights.EnumDatePreset;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;

public class AsyncInsightsExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final String CAMPAIGN_ID = ExampleConfig.CAMPAIGN_ID;
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);

  public static void main(String[] args) {
    try {
      AdReportRun report = new Campaign(CAMPAIGN_ID, context).getInsightsAsync()
          .setDatePreset(EnumDatePreset.VALUE_LAST_90_DAYS)
          .setActionBreakdowns(Arrays.asList(AdsInsights.EnumActionBreakdowns.VALUE_ACTION_TYPE))
          .setBreakdowns(Arrays.asList(AdsInsights.EnumBreakdowns.VALUE_GENDER))
          .requestAllFields()
          .execute()
          .head();
      try {
        while (report.fetch().getFieldAsyncPercentCompletion() != 100) {
          System.out.println("Waiting for async insights..." + report.getFieldAsyncPercentCompletion() + "%");
          Thread.sleep(3000);
        }
        APINodeList<AdsInsights> insights = report.getInsights().execute();
        System.out.println(insights);
      } catch(InterruptedException e) {
        System.out.println("Interrupted!");
      }
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
