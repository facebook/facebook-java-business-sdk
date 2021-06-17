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

package com.facebook.ads.sdk.signal;

import com.facebook.ads.sdk.serverside.DeliveryCategory;

public class Content {
    private com.facebook.ads.sdk.businessdataapi.Content businessDataContent = new com.facebook.ads.sdk.businessdataapi.Content();
    private com.facebook.ads.sdk.serverside.Content serverSideContent = new com.facebook.ads.sdk.serverside.Content();

    /**
     * Default Constructor.
     */
    public Content() {
    }

    /**
     * @param id                Product Id of the Item.
     * @param quantity          Quantity of the Item.
     * @param price             Subtotal for the content/product.
     * @param itemPrice         Price per unit of the content/product.
     * @param title             Title of the listed Item.
     * @param description       Product description used for the item.
     * @param brand             Brand of the item.
     * @param category          Category of the Item.
     * @param deliveryCategory  The type of delivery for a purchase event
     * @param tax               Subtotal tax for the content/product.
     * @param externalContentId Unique ID for the contents/products that are being
     *                          involved in the customer interaction.
     */
    public Content(String id, Long quantity, Float price, Float itemPrice, String title, String description,
            String brand, String category, DeliveryCategory deliveryCategory, Float tax, String externalContentId) {
        this.businessDataContent.setId(id);
        this.businessDataContent.setQuantity(quantity);
        this.businessDataContent.setPrice(price);
        this.businessDataContent.setTitle(title);
        this.businessDataContent.setTax(tax);
        this.businessDataContent.setExternalContentId(externalContentId);

        this.serverSideContent.setProductId(id);
        this.serverSideContent.setQuantity(quantity);
        this.serverSideContent.setItemPrice(itemPrice);
        this.serverSideContent.setTitle(title);
        this.serverSideContent.setDescription(description);
        this.serverSideContent.setBrand(brand);
        this.serverSideContent.setCategory(category);
        this.serverSideContent.setDeliveryCategory(deliveryCategory);
    }

    /**
     * Gets the Product Id of the Item. A string representing the unique Id for the
     * product. Example: XYZ.
     *
     * @return id
     */
    public SignalResponse<String, String> getId() {
        return new SignalResponse<String, String>(this.businessDataContent.getId(),
                this.serverSideContent.getProductId());
    }

    /**
     * Sets the Product Id of the Item.
     *
     * @param id A string representing the unique Id for the product. Example: XYZ.
     */
    public void setId(String id) {
        this.serverSideContent.setProductId(id);
        this.businessDataContent.setId(id);
    }

    /**
     * Sets the Product Id of the Item.
     *
     * @param id is a string representing the unique id for the product. Example:
     *           XYZ.
     * @return Content
     */
    public Content id(String id) {
        this.serverSideContent.setProductId(id);
        this.businessDataContent.setId(id);
        return this;
    }

    /**
     * Gets the quantity of the Item. The number/quantity of the content that is
     * being involved in the customer interaction. Example: 5
     *
     * @return quantity
     */
    public SignalResponse<Long, Long> getQuantity() {
        return new SignalResponse<Long, Long>(this.serverSideContent.getQuantity(),
                this.businessDataContent.getQuantity());
    }

    /**
     * Sets the quantity of the Item.
     *
     * @param quantity The number/quantity of the product that is being involved in
     *                 the customer interaction. Example: 5
     */
    public void setQuantity(Long quantity) {
        this.serverSideContent.setQuantity(quantity);
        this.businessDataContent.setQuantity(quantity);
    }

    /**
     * Sets the quantity of the Content/Item.
     *
     * @param quantity The number/quantity of the product that is being involved in
     *                 the customer interaction. Example: 5
     * @return Content
     */
    public Content quantity(Long quantity) {
        this.serverSideContent.setQuantity(quantity);
        this.businessDataContent.setQuantity(quantity);
        return this;
    }

    /**
     * Gets the item price for the Product. The item price or price per unit of the
     * product. Example: '123.45'
     *
     * @return itemPrice
     */
    public SignalResponse<Float, Float> getItemPrice() {
        return new SignalResponse<Float, Float>(this.serverSideContent.getItemPrice(), null);
    }

    /**
     * Sets the item price for the Content.
     *
     * @param itemPrice The item price or price per unit of the product. Example:
     *                  '123.45'
     */
    public void setItemPrice(Float itemPrice) {
        this.serverSideContent.setItemPrice(itemPrice);
    }

    /**
     * Sets the item price for the Content.
     *
     * @param itemPrice The item price or price per unit of the product. Example:
     *                  '123.45'
     * @return Content
     */
    public Content itemPrice(Float itemPrice) {
        this.serverSideContent.setItemPrice(itemPrice);
        return this;
    }

    /**
     * Gets the Title of the listed Item. A string representing the Title for the
     * product.
     *
     * @return title
     */
    public SignalResponse<String, String> getTitle() {
        return new SignalResponse<String, String>(this.serverSideContent.getTitle(),
                this.businessDataContent.getTitle());
    }

    /**
     * Sets the Title of the listed Item.
     *
     * @param title A string representing the Title for the product.
     */
    public void setTitle(String title) {
        this.serverSideContent.setTitle(title);
        this.businessDataContent.setTitle(title);
    }

    /**
     * Sets the Title of the Item.
     *
     * @param title is a string representing listed title for the product.
     * @return Content
     */
    public Content title(String title) {
        this.serverSideContent.setTitle(title);
        this.businessDataContent.setTitle(title);
        return this;
    }

    /**
     * Gets the Description of the listed Item. A string representing the
     * Description for the product.
     *
     * @return description
     */
    public SignalResponse<String, String> getDescription() {
        return new SignalResponse<String, String>(this.serverSideContent.getDescription(), null);
    }

    /**
     * Sets the Description of the listed Item.
     *
     * @param description A string representing the Description for the product.
     */
    public void setDescription(String description) {
        this.serverSideContent.setDescription(description);
    }

    /**
     * Sets the Product Description of the Item.
     *
     * @param description is a string representing the description for the product.
     * @return Content
     */
    public Content description(String description) {
        this.serverSideContent.setDescription(description);
        return this;
    }

    /**
     * Gets the Brand of the listed Item. A string representing the Brand for the
     * product.
     *
     * @return brand
     */
    public SignalResponse<String, String> getbrand() {
        return new SignalResponse<String, String>(this.serverSideContent.getBrand(), null);
    }

    /**
     * Sets the Brand of the listed Item.
     *
     * @param brand A string representing the Brand for the product.
     */
    public void setbrand(String brand) {
        this.serverSideContent.setBrand(brand);
    }

    /**
     * Sets the Brand of the Product.
     *
     * @param brand is a string representing the Brand for the product.
     * @return Content
     */
    public Content brand(String brand) {
        this.serverSideContent.setBrand(brand);
        return this;
    }

    /**
     * Gets the Category of the listed Item. A string representing the Category for
     * the product.
     *
     * @return Category
     */
    public SignalResponse<String, String> getCategory() {
        return new SignalResponse<String, String>(this.serverSideContent.getCategory(), null);
    }

    /**
     * Sets the Category of the listed Item.
     *
     * @param category A string representing the Category for the product.
     */
    public void setCategory(String category) {
        this.serverSideContent.setCategory(category);
    }

    /**
     * Sets the Category of the Product.
     *
     * @param category is a string representing the Category for the product.
     * @return Content
     */
    public Content category(String category) {
        this.serverSideContent.setCategory(category);
        return this;
    }

    /**
     * Gets the delivery category.
     *
     * @return DeliveryCategory
     */
    public SignalResponse<DeliveryCategory, DeliveryCategory> getDeliveryCategory() {
        return new SignalResponse<DeliveryCategory, DeliveryCategory>(this.serverSideContent.getDeliveryCategory(),
                null);
    }

    /**
     * Sets the type of delivery for a purchase event.
     *
     * @param deliveryCategory The delivery category.
     */
    public void setdeliverycategory(DeliveryCategory deliveryCategory) {
        this.serverSideContent.setDeliveryCategory(deliveryCategory);
    }

    /**
     * Sets the type of delivery for a purchase event.
     *
     * @param deliveryCategory The delivery category.
     * @return Content
     */
    public Content deliveryCategory(DeliveryCategory deliveryCategory) {
        this.serverSideContent.setDeliveryCategory(deliveryCategory);
        return this;
    }

    /**
     * Gets the total tax of the Item. The total tax for the products that are being
     * involved in the customer interaction. Example: 45.5
     *
     * @return Tax
     */
    public SignalResponse<Float, Float> getTax() {
        return new SignalResponse<Float, Float>(null, this.businessDataContent.getTax());
    }

    /**
     * Sets the total tax of the Item.
     *
     * @param tax The total tax for the products that are being involved in the
     *            customer interaction. Example: 45.5
     */
    public void setTax(Float tax) {
        this.businessDataContent.setTax(tax);
    }

    /**
     * Sets the total tax of the Item.
     *
     * @param tax The total tax for the products that are being involved in the
     *            customer interaction. Example: 45.5
     * @return Content
     */
    public Content tax(Float tax) {
        this.businessDataContent.setTax(tax);
        return this;
    }

    /**
     * Gets the external id for this order item The external id for the products
     * that are being involved in the customer interaction.
     *
     * @return ExternalContentId
     */
    public SignalResponse<String, String> getExternalContentId() {
        return new SignalResponse<String, String>(null, this.businessDataContent.getExternalContentId());
    }

    /**
     * Sets the external id for this order item
     *
     * @param externalContentId The external id for the products that are being
     *                          involved in the customer interaction.
     */
    public void setExternalcontentid(String externalContentId) {
        this.businessDataContent.setExternalContentId(externalContentId);
    }

    /**
     * Sets the total tax of the Item.
     *
     * @param externalContentId The total tax for the products that are being
     *                          involved in the customer interaction.
     * @return Content
     */
    public Content externalContentId(String externalContentId) {
        this.businessDataContent.setExternalContentId(externalContentId);
        return this;
    }

    /**
     * Gets the total price of the Item. The total price for the products that are
     * being involved in the customer interaction. Example: '123.45'
     *
     * @return Price
     */
    public SignalResponse<Float, Float> getPrice() {
        return new SignalResponse<Float, Float>(null, this.businessDataContent.getPrice());
    }

    /**
     * Sets the total price of the Item.
     *
     * @param price The total price for the products that are being involved in the
     *              customer interaction. Example: '123.45'
     */
    public void setPrice(Float price) {
        this.businessDataContent.setPrice(price);
    }

    /**
     * Sets the total price of the Item.
     *
     * @param price The total price for the products that are being involved in the
     *              customer interaction. Example: '123.45'
     * @return Content
     */
    public Content price(Float price) {
        this.businessDataContent.setPrice(price);
        return this;
    }

    /**
     * Gets the constructed content for Business Data API
     *
     * @return businessDataContent
     */
    public com.facebook.ads.sdk.businessdataapi.Content getBusinessDataContent() {
        return this.businessDataContent;
    }

    /**
     * Gets the constructed content for Conversion API
     *
     * @return serverSideContent
     */
    public com.facebook.ads.sdk.serverside.Content getServerSideContent() {
        return this.serverSideContent;
    }

}
