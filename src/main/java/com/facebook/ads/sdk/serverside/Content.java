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
  @SerializedName("title")
  private String title = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("brand")
  private String brand = null;
  @SerializedName("category")
  private String category = null;
  @SerializedName("delivery_category")
  private DeliveryCategory deliveryCategory = null;

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
   * @param title product title
   * @param description product description
   * @param brand product brand
   * @param category product category
   * @param deliveryCategory type of delivery for a purchase event
   */
  public Content(String productId, Long quantity, Float itemPrice, String title, String description, String brand, String category, DeliveryCategory deliveryCategory) {
    this.productId = productId;
    this.quantity = quantity;
    this.itemPrice = itemPrice;
    this.title = title;
    this.description = description;
    this.brand = brand;
    this.category = category;
    this.deliveryCategory = deliveryCategory;
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
   * Set Item Price.
   *
   * @param itemPrice single item price
   * @return Content
   */
  public Content itemPrice(Float itemPrice) {
    this.itemPrice = itemPrice;
    return this;
  }

  /**
   * Get title.
   *
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set title
   *
   * @param title Title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Set Title
   *
   * @param title Title
   * @return Content
   */
  public Content title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get description.
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set description
   *
   * @param description Description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Set description
   *
   * @param description Description
   * @return Content
   */
  public Content description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get brand.
   *
   * @return brand
   */
  public String getBrand() {
    return brand;
  }

  /**
   * Set brand
   *
   * @param brand Brand
   */
  public void setBrand(String brand) {
    this.brand = brand;
  }

  /**
   * Set brand
   *
   * @param brand Brand
   * @return Content
   */
  public Content brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get category.
   *
   * @return category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Set category
   *
   * @param category Category
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Set category
   *
   * @param category Category
   * @return Content
   */
  public Content category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Type of delivery for a purchase event. Example: in_store.
   *
   * @return deliveryCategory
   */
  public DeliveryCategory getDeliveryCategory() {
    return deliveryCategory;
  }

  /**
   * Set a Type of delivery for a purchase event.
   *
   * @param deliveryCategory type of delivery
   */
  public void setDeliveryCategory(DeliveryCategory deliveryCategory) {
    this.deliveryCategory = deliveryCategory;
  }

  /**
   * Set a Type of delivery for a purchase event.
   *
   * @param deliveryCategory type of delivery
   * @return CustomData
   */
  public Content deliveryCategory(DeliveryCategory deliveryCategory) {
    this.deliveryCategory = deliveryCategory;
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      productId,
      quantity,
      itemPrice,
      title,
      description,
      brand,
      category,
      deliveryCategory
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Content {\n");

    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    itemPrice: ").append(toIndentedString(itemPrice)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    deliveryCategory: ").append(toIndentedString(deliveryCategory)).append("\n");
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
