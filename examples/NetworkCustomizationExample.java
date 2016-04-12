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

import java.io.IOException;
import java.util.Map;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import com.google.gson.JsonElement;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APIRequest;

public class NetworkCustomizationExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final Long ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);

  public static void main(String[] args) {
    try {
      // IMPORTANT NOTE:
      // This is an over-simplified code example.
      // In real products, please log the error and determine
      // whether a retry is needed to prevent duplicated API calls.
      APIRequest.changeRequestExecutor(new APIRequest.DefaultRequestExecutor(){
        public static final int MAX_RETRY = 3;
        @Override
        public String sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException{
          String response;
          int retry = 0;
          while(true) {
            try {
              response = super.sendPost(apiUrl, allParams, context);
              break;
            } catch (APIException e) {
              retry++;
              if (retry >= MAX_RETRY) throw e;
              if (e instanceof APIException.FailedRequestException && e.getMessage() != null) {
                JsonElement isTransient = e.getRawResponseAsJsonObject().get("is_transient");
                if (isTransient != null && isTransient.getAsBoolean() == false) throw e;
              }
              try {
                Thread.sleep(3000);
              } catch (InterruptedException e1) {
                e1.printStackTrace();
              }
            } catch (IOException e) {
              retry++;
              if (retry >= MAX_RETRY) throw e;
              try {
                Thread.sleep(3000);
              } catch (InterruptedException e1) {
                e1.printStackTrace();
              }
            }
          }
          return response;
        }
      });

      AdAccount account = new AdAccount(ACCOUNT_ID, context);
      Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .execute();
      System.out.println(campaign.fetch());
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
