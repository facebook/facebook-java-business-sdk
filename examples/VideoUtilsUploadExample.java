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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import com.facebook.ads.sdk.APIConfig;
import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdAccount.EnumUploadPhase;
import com.facebook.ads.sdk.AdCreative;
import com.facebook.ads.sdk.AdCreativeObjectStorySpec;
import com.facebook.ads.sdk.AdCreativeVideoData;
import com.facebook.ads.sdk.AdImage;
import com.facebook.ads.sdk.AdReportRun;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.AdsInsights;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.Targeting;
import com.facebook.ads.sdk.TargetingGeoLocation;
import com.facebook.ads.utils.VideoUtils;
import com.facebook.ads.utils.VideoUtils.ProgressCallback;
import com.google.gson.JsonObject;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINode;
import com.facebook.ads.sdk.APIRequest;
import com.facebook.ads.sdk.Ad;

public class VideoUtilsUploadExample {

  public static final String DEFAULT_API_BASE = APIConfig.DEFAULT_API_BASE;
  public static final String DEFAULT_API_VERSION = APIConfig.DEFAULT_API_VERSION;
  public static final String DEFAULT_VIDEO_API_BASE = APIConfig.DEFAULT_VIDEO_API_BASE;

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final String PAGE_ID = ExampleConfig.PAGE_ID;
  public static final File imageFile = new File(ExampleConfig.IMAGE_FILE);
  public static final File videoFile = new File(ExampleConfig.VIDEO_FILE);
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);

  public static void main(String[] args) throws IOException {
    Targeting targeting = new Targeting().setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList(new String[]{"US"})));
    AdAccount account = new AdAccount(ACCOUNT_ID, context);
    try {
      // NOT RECOMMENDED: Upload in one API call
      String videoId0 = VideoUtils.uploadSmallVideoFile(account, videoFile);

      // RECOMMENDED: Upload in chunks
      String videoId1 = VideoUtils.uploadVideoFileInChunks(account, videoFile);

      // NOT RECOMMENDED: Upload in one API call with callback
      String videoId2 = VideoUtils.uploadSmallVideoFile(account, videoFile, true, new ProgressCallback(){
        @Override
        public void onProgressUpdate(int event, int progress) {
          String eventName = null;
          switch(event){
            case ProgressCallback.EVENT_UPLOAD_PROGRESS:
              eventName = "upload progress";
              break;
            case ProgressCallback.EVENT_UPLOAD_COMPLETE:
              eventName = "upload complete";
              break;
            case ProgressCallback.EVENT_SERVER_ENCODING_PROGRESS:
              eventName = "encoding progress";
              break;
            case ProgressCallback.EVENT_SERVER_ENCODING_COMPLETE:
              eventName = "encoding complete";
              break;
          }
          System.out.println("Event: " + eventName + "; Progress: " + progress);
        }});

      // RECOMMENDED: Upload in chunks with callback
      String videoId3 = VideoUtils.uploadVideoFileInChunks(account, videoFile, 5, true, new ProgressCallback(){

        @Override
        public void onProgressUpdate(int event, int progress) {
          String eventName = null;
          switch(event){
            case ProgressCallback.EVENT_UPLOAD_PROGRESS:
              eventName = "upload progress";
              break;
            case ProgressCallback.EVENT_UPLOAD_COMPLETE:
              eventName = "upload complete";
              break;
            case ProgressCallback.EVENT_SERVER_ENCODING_PROGRESS:
              eventName = "encoding progress";
              break;
            case ProgressCallback.EVENT_SERVER_ENCODING_COMPLETE:
              eventName = "encoding complete";
              break;
          }
          System.out.println("Event: " + eventName + "; Progress: " + progress);
        }});

      // Creating video ads
      Campaign campaign = account.createCampaign()
          .setName("Java SDK Test Video Campaign")
          .setObjective(Campaign.EnumObjective.VALUE_VIDEO_VIEWS)
          .setSpendCap(10000L)
          .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
          .execute();
      AdSet adset = account.createAdSet()
          .setName("Java SDK Test Video AdSet")
          .setCampaignId(campaign.getFieldId())
          .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
          .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
          .setDailyBudget(1000L)
          .setBidAmount(100L)
          .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_VIDEO_VIEWS)
          .setTargeting(targeting)
          .setRedownload(true)
          .execute();
      System.out.println(adset);
      AdImage image = account.createAdImage()
        .addUploadFile("file", imageFile)
        .execute();

      AdCreative creative = account.createAdCreative()
          .setTitle("Java SDK Test Video Creative")
          .setBody("Java SDK Test Video Creative")
          .setObjectStorySpec(
              new AdCreativeObjectStorySpec().setFieldVideoData(
                  new AdCreativeVideoData()
                      .setFieldImageHash(image.getFieldHash())
                      .setFieldVideoId(videoId3)
                      .setFieldDescription("Java SDK Test Video Description")
             ).setFieldPageId(PAGE_ID)
          )
          .execute();
      Ad ad = account.createAd()
          .setName("Java SDK Test Video ad")
          .setAdsetId(Long.parseLong(adset.getId()))
          .setCreative(creative)
          .setStatus("PAUSED")
          .setBidAmount(100L)
          .setRedownload(true)
          .execute();
      System.out.println("Video Ad Creation done!");
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
