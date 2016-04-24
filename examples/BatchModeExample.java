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
import java.util.Arrays;
import java.util.List;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.BatchRequest;
import com.facebook.ads.sdk.Targeting;
import com.facebook.ads.sdk.TargetingGeoLocation;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APIResponse;

public class BatchModeExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final File imageFile = new File(ExampleConfig.IMAGE_FILE);

  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);
  public static void main(String[] args) {
    try {
      Targeting targeting = new Targeting().setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList("US")));
      AdAccount account = new AdAccount(ACCOUNT_ID, context);

      // Creation of Ad
      BatchRequest batch = new BatchRequest(context);
      account.createCampaign()
        .setName("Java SDK Batch Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .addToBatch(batch, "campaignRequest");
      account.createAdSet()
        .setName("Java SDK Batch Test AdSet")
        .setCampaignId("{result=campaignRequest:$.id}")
        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
        .setDailyBudget(1000L)
        .setBidAmount(100L)
        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
        .setTargeting(targeting)
        .addToBatch(batch, "adsetRequest");
      account.createAdImage()
        .addUploadFile("file", imageFile)
        .addToBatch(batch, "imageRequest");
      account.createAdCreative()
        .setTitle("Java SDK Batch Test Creative")
        .setBody("Java SDK Batch Test Creative")
        .setImageHash("{result=imageRequest:$.images.*.hash}")
        .setLinkUrl("www.facebook.com")
        .setObjectUrl("www.facebook.com")
        .addToBatch(batch, "creativeRequest");
      account.createAd()
        .setName("Java SDK Batch Test ad")
        .setAdsetId("{result=adsetRequest:$.id}")
        .setCreative("{creative_id:{result=creativeRequest:$.id}}")
        .setStatus("PAUSED")
        .setBidAmount(100L)
        .addToBatch(batch);
      List<APIResponse> responses = batch.execute();

      // Obtain the IDs of the newly created objects
      Ad ad = ((Ad)responses.get(4)).fetch();
      AdSet adSet = new AdSet(ad.getFieldAdsetId(), context).fetch();
      Campaign campaign = new Campaign(adSet.getFieldCampaignId(), context);

      // Load
      batch = new BatchRequest(context);
      ad.get().requestAllFields().addToBatch(batch);
      adSet.get().requestAllFields().addToBatch(batch);
      campaign.get().requestAllFields().addToBatch(batch);
      responses = batch.execute();

      System.out.println((Ad) responses.get(0));
      System.out.println((AdSet) responses.get(1));
      System.out.println((Campaign) responses.get(2));

      // Delete
      batch = new BatchRequest(context);
      //ad.delete().addToBatch(batch); // Deleting campaign automatically deletes ad and adset.
      //adSet.delete().addToBatch(batch); // Deleting campaign automatically deletes ad and adset.
      campaign.delete().addToBatch(batch);
      responses = batch.execute();
      System.out.println(responses.get(0));
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
