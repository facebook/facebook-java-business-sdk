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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdCreative;
import com.facebook.ads.sdk.AdImage;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.CustomAudience;
import com.facebook.ads.sdk.Targeting;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.facebook.ads.sdk.CustomAudience.EnumSubtype;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.Ad;

public class CustomAudienceExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final File imageFile = new File(ExampleConfig.IMAGE_FILE);
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);

  public static void main(String[] args) {
    try {
      AdAccount account = new AdAccount(ACCOUNT_ID, context);

      CustomAudience audience = account.createCustomAudience()
        .setName("Java SDK Test Custom Audience")
        .setDescription("Test Audience")
        .setSubtype(EnumSubtype.VALUE_CUSTOM)
        .execute();

      // Audience payload schema
      JsonArray schema = new JsonArray();
      schema.add(new JsonPrimitive("EMAIL_SHA256"));
      schema.add(new JsonPrimitive("PHONE_SHA256"));

      // Audience payload data
      JsonArray personA = new JsonArray();
      personA.add(new JsonPrimitive(sha256("aaa@example.com")));
      personA.add(new JsonPrimitive(sha256("1234567890")));
      JsonArray personB = new JsonArray();
      personB.add(new JsonPrimitive(sha256("bbb@example.com")));
      personB.add(new JsonPrimitive(sha256("1234567890")));
      JsonArray personC = new JsonArray();
      personC.add(new JsonPrimitive(sha256("ccc@example.com")));
      personC.add(new JsonPrimitive(sha256("1234567890")));

      JsonArray data = new JsonArray();
      data.add(personA);
      data.add(personB);
      data.add(personC);

      JsonObject payload = new JsonObject();
      payload.add("schema", schema);
      payload.add("data", data);

      audience.createUser()
        .setPayload(payload.toString())
        .execute();

      System.out.println(audience.fetch());

      Targeting targeting = new Targeting().setFieldCustomAudiences("[{id:" + audience.getId() + "}]");

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
          .setRedownload(true)
          .requestAllFields()
          .execute();
        System.out.println(adset);
        AdImage image = account.createAdImage()
          .addUploadFile("file", imageFile)
          .execute();
        AdCreative creative = account.createAdCreative()
          .setTitle("Java SDK Test Creative")
          .setBody("Java SDK Test Creative")
          .setImageHash(image.getFieldHash())
          .setLinkUrl("www.facebook.com")
          .setObjectUrl("www.facebook.com")
          .execute();
        Ad ad = account.createAd()
          .setName("Java SDK Test ad")
          .setAdsetId(Long.parseLong(adset.getId()))
          .setCreative(creative)
          .setStatus("PAUSED")
          .setBidAmount(100L)
          .setRedownload(true)
          .execute();
    } catch (APIException e) {
      e.printStackTrace();
    }
  }

  public static String sha256(String message) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(message.getBytes(StandardCharsets.UTF_8));
      return toHex(hash);
    } catch(Exception e){
      return null;
    }
  }

  public static String toHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
        sb.append(String.format("%1$02x", b));
    }
    return sb.toString();
  }
}
