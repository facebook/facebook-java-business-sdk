/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * <p>You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify,
 * and distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 *
 * <p>As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.facebook.ads.sdk.serverside;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;


public class Content {

  @SerializedName("id")
  private String productId = null;
  @SerializedName("quantity")
  private Long quantity = null;
  @SerializedName("item_price")
  private Float itemPrice = null;

  /**
   * Default Constructor.
   */
  public Content() {
  }

  /**
   * Constructor.
   *
   * @param productId product id
   * @param quantity number of product
   * @param itemPrice single item Price
   */
  public Content(String productId, Long quantity, Float itemPrice) {
    this.productId = productId;
    this.quantity = quantity;
    this.itemPrice = itemPrice;
  }

  /**
   * Get Product Id.
   *
   * @return Product Id
   */
  public String getProductId() {
    return productId;
  }

  /**
   * Set Product Id
   *
   * @param productId product Id
   */
  public void setProductId(String productId) {
    this.productId = productId;
  }

  /**
   * Set Product Id
   *
   * @param productId product Id
   * @return Content
   */
  public Content productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get number of product.
   *
   * @return quantity
   */
  public Long getQuantity() {
    return quantity;
  }

  /**
   * Set number of product.
   *
   * @param quantity number of items
   */
  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  /**
   * Set number of product.
   *
   * @param quantity number of items
   * @return Content
   */
  public Content quantity(Long quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get Item Price.
   *
   * @return item price
   */
  public Float getItemPrice() {
    return itemPrice;
  }

  /**
   * Set Item Price.
   *
   * @param itemPrice single item price
   */
  public void setItemPrice(Float itemPrice) {
    this.itemPrice = itemPrice;
  }

  /**
   * Get Item Price.
   *
   * @param itemPrice single item price
   * @return Content
   */
  public Content itemPrice(Float itemPrice) {
    this.itemPrice = itemPrice;
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        productId,
        quantity,
        itemPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Content {\n");

    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    itemPrice: ").append(toIndentedString(itemPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first
   * line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
