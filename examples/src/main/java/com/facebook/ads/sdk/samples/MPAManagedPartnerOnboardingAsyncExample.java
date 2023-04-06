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

import com.google.gson.JsonObject;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.BatchRequest;
import com.facebook.ads.sdk.Business;
import com.facebook.ads.sdk.APIResponse;
import com.facebook.ads.sdk.AsyncSession;
import com.facebook.ads.sdk.APIException;

import java.util.List;

public class MPAManagedPartnerOnboardingAsyncExample {
    public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
    public static final String APP_SECRET = "YOUR_APP_SECRET";
    public static final String APP_ID = "YOUR_APP_ID";
    public static final String BIZ_ID = "YOUR_PARENT_BUSINESS_MANAGER_ID";

    public static void main(String[] args) throws APIException {
        APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET, APP_ID, false);

        BatchRequest batch = new BatchRequest(context);

        Business biz = new Business(BIZ_ID, context);
        biz.createManagedPartnerBusiness()
                .setNoAdAccount(true)
                .setChildBusinessExternalId("<vendor id>")
                .setCatalogId("Parent Catalog ID")
                .setName("Merchant Name")
                .setPageName("Merchant Page Name")
                .setPageProfileImageUrl("https://www.example.com/logo.png")
                .setSellerExternalWebsiteUrl("https://www.example.com/logo.png")
                .addToBatch(batch);

        List<APIResponse> response = batch.execute(true);

        String async_session_id = response.get(0).getRawResponseAsJsonObject().get("id").getAsString();

        AsyncSession async_session = new AsyncSession(async_session_id, context);
        async_session = async_session.get().requestIdField().requestResultField().requestStatusField().execute();
        String status = async_session.getFieldStatus();

        if (status == "COMPLETED") {
            JsonObject obj = async_session.getRawResponseAsJsonObject();
            String child_bm_id = obj.get("result").getAsJsonObject().get("id").getAsString();
        } else {
            System.out.println("Status: " + status);
        }
    }
}
