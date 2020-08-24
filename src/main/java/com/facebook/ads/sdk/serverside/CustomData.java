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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * CustomData contains parameters to send additional data we can use for ads delivery optimization.
 */
public class CustomData {

  @SerializedName("value")
  private Float value = null;

  @SerializedName("currency")
  private String currency = null;

  @SerializedName("content_name")
  private String contentName = null;

  @SerializedName("content_category")
  private String contentCategory = null;

  @SerializedName("content_ids")
  private List<String> contentIds = null;

  @SerializedName("contents")
  private List<Content> contents = null;

  @SerializedName("content_type")
  private String contentType = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("predicted_ltv")
  private Float predictedLtv;

  @SerializedName("num_items")
  private String numItems = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("search_string")
  private String searchString = null;

  @SerializedName("item_number")
  private String itemNumber = null;

  @SerializedName("delivery_category")
  private DeliveryCategory deliveryCategory = null;

  private HashMap<String, String> customProperties = null;

  /**
   * Default Constructor.
   */
  public CustomData() {
  }

  /**
   * Constructor.
   *
   * @param value a numeric value associated with this event
   * @param currency currency code for the value specified
   * @param contentName name of the page or product associated with the event
   * @param contentCategory category of the content associated with the event
   * @param contentIds content IDs associated with the event, such as product SKUs for items in an
   * AddToCart
   * @param contents list of Content objects that contain the product info
   * @param contentType either 'product' or 'product_group'
   * @param orderId order ID for this transaction
   * @param predictedLtv predicted lifetime value of a conversion event
   * @param numItems number of items that a user tries to buy during checkout
   * @param status status of the registration event
   * @param searchString a search query made by a user
   * @param deliveryCategory type of delivery for a purchase event.
   * @param itemNumber the item number
   * @param customProperties Custom Properties to be added to the Custom Data
   */
  public CustomData(Float value, String currency, String contentName,
      String contentCategory, List<String> contentIds,
      List<Content> contents, String contentType, String orderId, Float predictedLtv,
      String numItems, String status, String searchString, DeliveryCategory deliveryCategory, String itemNumber,
      HashMap<String, String> customProperties) {
    this.value = value;
    this.currency = currency;
    this.contentName = contentName;
    this.contentCategory = contentCategory;
    this.contentIds = contentIds;
    this.contents = contents;
    this.contentType = contentType;
    this.orderId = orderId;
    this.predictedLtv = predictedLtv;
    this.numItems = numItems;
    this.status = status;
    this.searchString = searchString;
    this.deliveryCategory = deliveryCategory;
    this.itemNumber = itemNumber;
    this.customProperties = customProperties;
  }

  /**
   * Set a numeric value associated with this event. This could be a monetary value or a value in
   * some other metric.
   * <p> Example: 142.54.
   *
   * @param value a numeric value associated with this event
   * @return CustomData
   */
  public CustomData value(Float value) {
    this.value = value;
    return this;
  }

  /**
   * A numeric value associated with this event. This could be a monetary value or a value in some
   * other metric.
   * <p> Example: 142.54.
   *
   * @return value
   */
  public Float getValue() {
    return value;
  }

  /**
   * Set a numeric value associated with this event. This could be a monetary value or a value in
   * some other metric.
   * <p> Example: 142.54.
   *
   * @param value a numeric value associated with this event
   */
  public void setValue(Float value) {
    this.value = value;
  }

  /**
   * Set currency code for the value specified, if applicable. Currency must be a valid ISO 4217
   * three digit currency code.
   *
   * @param currency currency code for the value specified
   * @return CustomData
   */
  public CustomData currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * The currency code for the value specified, if applicable. Currency must be a valid ISO 4217
   * three digit currency code.
   *
   * @return currency
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Set currency code for the value specified, if applicable. Currency must be a valid ISO 4217
   * three digit currency code.
   *
   * @param currency currency code for the value specified
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * Set name of the page or product associated with the event.
   *
   * <p> Example: lettuce.
   *
   * @param contentName name of the page or product associated with the event
   * @return CustomData
   */
  public CustomData contentName(String contentName) {
    this.contentName = contentName;
    return this;
  }

  /**
   * The name of the page or product associated with the event.
   *
   * <p> Example: lettuce.
   *
   * @return contentName
   */
  public String getContentName() {
    return contentName;
  }

  /**
   * Set name of the page or product associated with the event.
   *
   * <p> Example: lettuce.
   *
   * @param contentName name of the page or product associated with the event
   */
  public void setContentName(String contentName) {
    this.contentName = contentName;
  }

  /**
   * Set category of the content associated with the event.
   *
   * <p>Example: grocery
   *
   * @param contentCategory category of the content associated with the event.
   * @return CustomData
   */
  public CustomData contentCategory(String contentCategory) {
    this.contentCategory = contentCategory;
    return this;
  }

  /**
   * The category of the content associated with the event.
   *
   * <p>Example: grocery
   *
   * @return contentCategory
   */
  public String getContentCategory() {
    return contentCategory;
  }

  /**
   * Set category of the content associated with the event.
   *
   * <p>Example: grocery
   *
   * @param contentCategory category of the content associated with the event.
   */
  public void setContentCategory(String contentCategory) {
    this.contentCategory = contentCategory;
  }

  /**
   * Set content IDs associated with the event, such as product SKUs for items in an AddToCart
   * event: [ABC123, XYZ789]. If content_type is a product, then your content IDs must be an array
   * with a single string value. Otherwise, this array can contain any number of string values.
   *
   * @param contentIds content IDs associated with the event
   * @return CustomData
   */
  public CustomData contentIds(List<String> contentIds) {
    this.contentIds = contentIds;
    return this;
  }

  /**
   * The content IDs associated with the event, such as product SKUs for items in an AddToCart
   * event: [ABC123, XYZ789]. If content_type is a product, then your content IDs must be an array
   * with a single string value. Otherwise, this array can contain any number of string values.
   *
   * @return contentIds
   */
  public List<String> getContentIds() {
    return contentIds;
  }

  /**
   * Set content IDs associated with the event, such as product SKUs for items in an AddToCart
   * event: [ABC123, XYZ789]. If content_type is a product, then your content IDs must be an array
   * with a single string value. Otherwise, this array can contain any number of string values.
   *
   * @param contentIds content IDs associated with the event
   */
  public void setContentIds(List<String> contentIds) {
    this.contentIds = contentIds;
  }

  /**
   * Set a list of Content objects that contain the product IDs associated with the event plus
   * information about the products. id, quantity, and item_price are available fields.
   *
   * <p>Example: [{id:ABC123,quantity :2,item_price:5.99}, {id:XYZ789,quantity:2, item_price:9.99}]
   *
   * @param contents list of Content objects that contain the products associated with the event
   * @return CustomData
   */
  public CustomData contents(List<Content> contents) {
    this.contents = contents;
    return this;
  }

  /**
   * Add a Content objects that contain the product IDs associated with the event plus information
   * about the products. id, quantity, and item_price are available fields.
   *
   * <p>Example: {id:ABC123,quantity :2,item_price:5.99}
   *
   * @param content Content objects that contain the product associated with the event
   * @return CustomData
   */
  public CustomData addContent(Content content) {
    if (this.contents == null) {
      this.contents = new ArrayList<Content>();
    }
    this.contents.add(content);
    return this;
  }

  /**
   * A list of Content objects that contain the product IDs associated with the event plus
   * information about the products. id, quantity, and item_price are available fields.
   *
   * <p>Example: [{id:ABC123,quantity :2,item_price:5.99}, {id:XYZ789,quantity:2, item_price:9.99}]
   *
   * @return contents
   */
  public List<Content> getContents() {
    return contents;
  }

  /**
   * Set a list of Content objects that contain the product IDs associated with the event plus
   * information about the products. id, quantity, and item_price are available fields.
   *
   * <p>Example: [{id:ABC123,quantity :2,item_price:5.99}, {id:XYZ789,quantity:2, item_price:9.99}]
   *
   * @param contents list of Content objects that contain the products associated with the event
   */
  public void setContents(List<Content> contents) {
    this.contents = contents;
  }

  /**
   * Set a String equal to either product or product_group. Set to product if the keys you send
   * content_ids or contents represent products. Set to product_group if the keys you send in
   * content_ids represent product groups.
   *
   * @param contentType product or product_group
   * @return CustomData
   */
  public CustomData contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * A String equal to either product or product_group. Set to product if the keys you send
   * content_ids or contents represent products. Set to product_group if the keys you send in
   * content_ids represent product groups.
   *
   * @return contentType
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * Set a String equal to either product or product_group. Set to product if the keys you send
   * content_ids or contents represent products. Set to product_group if the keys you send in
   * content_ids represent product groups.
   *
   * @param contentType product or product_group
   */
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  /**
   * Set order ID for this transaction as a String.
   *
   * <p>Example: order1234.
   *
   * @param orderId order ID for this transaction
   * @return CustomData
   */
  public CustomData orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * The order ID for this transaction as a String.
   *
   * <p>Example: order1234.
   *
   * @return orderId
   */
  public String getOrderId() {
    return orderId;
  }

  /**
   * Set order ID for this transaction as a String.
   *
   * <p>Example: order1234.
   *
   * @param orderId order ID for this transaction
   */
  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  /**
   * Set predicted lifetime value of a conversion event, as a String.
   *
   * <p>Example: 432.12.
   *
   * @param predictedLtv predicted lifetime value of a conversion event
   * @return CustomData
   */
  public CustomData predictedLtv(Float predictedLtv) {
    this.predictedLtv = predictedLtv;
    return this;
  }

  /**
   * The predicted lifetime value of a conversion event, as a String.
   *
   * <p>Example: 432.12.
   *
   * @return predictedLtv
   */
  public Float getPredictedLtv() {
    return predictedLtv;
  }

  /**
   * Set predicted lifetime value of a conversion event, as a String.
   *
   * <p>Example: 432.12.
   *
   * @param predictedLtv predicted lifetime value of a conversion event
   */
  public void setPredictedLtv(Float predictedLtv) {
    this.predictedLtv = predictedLtv;
  }

  /**
   * Set number of items that a user tries to buy during checkout. Use only with InitiateCheckout
   * events.
   *
   * @param numItems number of items that a user tries to buy during checkout
   * @return CustomData
   */
  public CustomData numItems(String numItems) {
    this.numItems = numItems;
    return this;
  }

  /**
   * The number of items that a user tries to buy during checkout. Use only with InitiateCheckout
   * events.
   *
   * @return numItems
   */
  public String getNumItems() {
    return numItems;
  }

  /**
   * Set number of items that a user tries to buy during checkout. Use only with InitiateCheckout
   * events.
   *
   * @param numItems number of items that a user tries to buy during checkout
   */
  public void setNumItems(String numItems) {
    this.numItems = numItems;
  }

  /**
   * Set status of the registration event, as a String. Use only with CompleteRegistration events.
   *
   * @param status status of the registration event
   * @return CustomData
   */
  public CustomData status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the registration event, as a String. Use only with CompleteRegistration events.
   *
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Set status of the registration event, as a String. Use only with CompleteRegistration events.
   *
   * @param status status of the registration event
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * A search query made by a use. Use only with Search events. Example: 'lettuce'.
   *
   * @return searchString
   */
  public String getSearchString() {
    return searchString;
  }

  /**
   * Set a search query made by a use. Use only with Search events.
   *
   * @param searchString a search query made by a use
   */
  public void setSearchString(String searchString) {
    this.searchString = searchString;
  }

  /**
   * Set a search query made by a use. Use only with Search events.
   *
   * @param searchString a search query made by a use
   * @return CustomData
   */
  public CustomData searchString(String searchString) {
    this.searchString = searchString;
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
  public CustomData deliveryCategory(DeliveryCategory deliveryCategory) {
    this.deliveryCategory = deliveryCategory;
    return this;
  }

  /**
   * Set the item number
   *
   * @param itemNumber Item number
   * @return CustomData
   */
  public CustomData itemNumber(String itemNumber) {
    this.itemNumber = itemNumber;
    return this;
  }

  /**
   * Get the item number
   *
   * @return itemNumber
   */
  public String getItemNumber() {
    return itemNumber;
  }

  /**
   * Set the item number
   *
   * @param itemNumber Item number
   */
  public void setItemNumber(String itemNumber) {
    this.itemNumber = itemNumber;
  }

  /**
   * Gets the custom properties to be included in the Custom Data.
   * If our predefined object properties don't suit your needs, you can include your own, custom properties.
   * Custom properties can be used with both standard and custom events, and can help you further define custom audiences.
   * This behavior is the same for Server-Side API and Facebook Pixel. See (https://developers.facebook.com/docs/marketing-api/server-side-api/parameters/custom-data#custom-properties)
   * Eg: '{ 'warehouse_location' : 'washington', 'package_size' : 'L'}'
   *
   * @return customProperties
   */
  public HashMap<String, String> getCustomProperties() {
    return customProperties;
  }

  /**
   * Sets the custom properties to be included in the Custom Data.
   *
   * @param customProperties custom properties property bag to be included in the Custom Data.
   * Eg: '{ 'warehouse_location' : 'washington', 'package_size' : 'L'}'
   */
  public void setCustomProperties(HashMap<String,String> customProperties) {
    this.customProperties = customProperties;
  }

  /**
   * Sets the custom properties to be included in the Custom Data.
   *
   * @param customProperties custom properties property bag to be included in the Custom Data.
   * Eg: '{ 'warehouse_location' : 'washington', 'package_size' : 'L'}'
   *
   * @return CustomData
   */
  public CustomData customProperties(HashMap<String,String> customProperties) {
    this.customProperties = customProperties;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomData customData = (CustomData) o;
    return Objects.equals(this.value, customData.value)
        && Objects.equals(this.currency, customData.currency)
        && Objects.equals(this.contentName, customData.contentName)
        && Objects.equals(this.contentCategory, customData.contentCategory)
        && Objects.equals(this.contentIds, customData.contentIds)
        && Objects.equals(this.contents, customData.contents)
        && Objects.equals(this.contentType, customData.contentType)
        && Objects.equals(this.orderId, customData.orderId)
        && Objects.equals(this.predictedLtv, customData.predictedLtv)
        && Objects.equals(this.numItems, customData.numItems)
        && Objects.equals(this.status, customData.status)
        && Objects.equals(this.searchString, customData.searchString)
        && Objects.equals(this.deliveryCategory, customData.deliveryCategory)
        && Objects.equals(this.itemNumber, customData.itemNumber)
        && Objects.equals(this.customProperties, customData.customProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        value,
        currency,
        contentName,
        contentCategory,
        contentIds,
        contents,
        contentType,
        orderId,
        predictedLtv,
        numItems,
        status,
        searchString,
        deliveryCategory,
        itemNumber,
        customProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomData {\n");

    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    contentName: ").append(toIndentedString(contentName)).append("\n");
    sb.append("    contentCategory: ").append(toIndentedString(contentCategory)).append("\n");
    sb.append("    contentIds: ").append(toIndentedString(contentIds)).append("\n");
    sb.append("    contents: ").append(toIndentedString(contents)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    predictedLtv: ").append(toIndentedString(predictedLtv)).append("\n");
    sb.append("    numItems: ").append(toIndentedString(numItems)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    searchString: ").append(toIndentedString(searchString)).append("\n");
    sb.append("    deliveryCategory: ").append(toIndentedString(deliveryCategory)).append("\n");
    sb.append("    itemNumber: ").append(toIndentedString(itemNumber)).append("\n");
    sb.append("    customProperties: ").append(toIndentedString(customProperties)).append("\n");
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
