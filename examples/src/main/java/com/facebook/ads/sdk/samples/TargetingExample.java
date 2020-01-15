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
 */
package com.facebook.ads.sdk.samples;

import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.Targeting;
import com.facebook.ads.sdk.TargetingGeoLocation;

import java.util.Arrays;

public class TargetingExample {

    public static void main(String[] args) {
        try {
            AdAccount account = new AdAccount(ExampleConfig.ACCOUNT_ID, ExampleConfig.CONTEXT);

            Targeting targeting = new Targeting()
                    .setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList("US")))
                    .setFieldAgeMin(18L)
                    .setFieldAgeMax(30L)
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
