/**
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
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

public class ProductCatalogHotelsPost {
  public static void main (String args[]) throws APIException {

    String access_token = "<ACCESS_TOKEN>";
    String app_secret = "<APP_SECRET>";
    String app_id = "<APP_ID>";
    String id = "<PRODUCT_CATALOG_ID>";
    APIContext context = new APIContext(access_token).enableDebug(true);

    new ProductCatalog(id, context).createHotel()
      .setHotelId("h_1")
      .setName("Sample Hotel")
      .setDescription("hotel description")
      .setBrand("hotel brand")
      .setUrl("http://www.example.com/samplehotel")
      .setImages("[{\"image_url\":\"https://www.example.com/pic1.jpg\",\"tags\":[\"front view\",\"balcony\"]},{\"image_url\":\"http://www.example.com/pic2.jpg\",\"tags\":[\"lobby view\"]}]")
      .setAddress("{\"street_address\":\"1 Hacker Way\",\"city\":\"Menlo Park\",\"region\":\"California\",\"country\":\"United States\",\"postal_code\":\"94025\",\"neighborhoods\":[\"Palo Alto\",\"Menlo Park\"],\"latitude\":37.484116,\"longitude\":-122.148244}")
      .setGuestRatings("[{\"score\":7.8,\"max_score\":10,\"rating_system\":\"sample_rating\",\"number_of_raters\":780}]")
      .setStarRating((double) 4)
      .setPhone("+351234123456")
      .execute();

  }
}