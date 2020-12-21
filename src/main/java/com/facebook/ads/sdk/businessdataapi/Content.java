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

package com.facebook.ads.sdk.businessdataapi;

import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("id")
    private String id = null;

    @SerializedName("quantity")
    private Long quantity = null;

    @SerializedName("price")
    private Float price = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("tax")
    private Float tax = null;

    @SerializedName("external_content_id")
    private String externalContentId = null;

    /**
     * Default Constructor.
     */
    public Content() {
    }

    /**
     * @param id                Product Id of the Item.
     * @param quantity          Quantity of the Item.
     * @param price             Subtotal for the content/product.
     * @param title             Title of the listed Item.
     * @param tax               Subtotal tax for the content/product.
     * @param externalContentId Unique ID for the contents/products that are being
     *                          involved in the customer interaction.
     */
    public Content(String id, Long quantity, Float price, String title, Float tax, String externalContentId) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
        this.tax = tax;
        this.externalContentId = externalContentId;
    }

    /**
     * Gets the Product Id of the Item. A string representing the unique Id for the
     * product. Example: XYZ.
     *
     * @return Product Id
     *
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the Product Id of the Item.
     *
     * @param id A string representing the unique Id for the product. Example: XYZ.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the Product Id of the Item.
     *
     * @param id is a string representing the unique id for the product. Example:
     *           XYZ.
     * @return Content
     */
    public Content id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Gets the quantity of the Item. The number/quantity of the content that is
     * being involved in the customer interaction. Example: 5
     *
     * @return Quantity
     */
    public Long getQuantity() {
        return this.quantity;
    }

    /**
     * Sets the quantity of the Item.
     *
     * @param quantity The number/quantity of the product that is being involved in
     *                 the customer interaction. Example: 5
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the quantity of the Content/Item.
     *
     * @param quantity The number/quantity of the product that is being involved in
     *                 the customer interaction. Example: 5
     *
     * @return Content
     */
    public Content quantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Gets the total price of the Item. The total price for the products that are
     * being involved in the customer interaction. Example: '123.45'
     *
     * @return Price
     */
    public Float getPrice() {
        return this.price;
    }

    /**
     * Sets the total price of the Item.
     *
     * @param price The total price for the products that are being involved in the
     *              customer interaction. Example: '123.45'
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Sets the total price of the Item.
     *
     * @param price The total price for the products that are being involved in the
     *              customer interaction. Example: '123.45'
     * @return Content
     */
    public Content price(Float price) {
        this.price = price;
        return this;
    }

    /**
     * Gets the Title of the listed Item. A string representing the Title for the
     * product.
     *
     * @return Title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the Title of the listed Item.
     *
     * @param title A string representing the Title for the product.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the Title of the Item.
     *
     * @param title is a string representing listed title for the product.
     *
     * @return Content
     */
    public Content title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Gets the total tax of the Item. The total tax for the products that are being
     * involved in the customer interaction. Example: 45.5
     *
     * @return tax
     */
    public Float getTax() {
        return this.tax;
    }

    /**
     * Sets the total tax of the Item.
     *
     * @param tax The total tax for the products that are being involved in the
     *            customer interaction. Example: 45.5
     */
    public void setTax(Float tax) {
        this.tax = tax;
    }

    /**
     * Sets the total tax of the Item.
     *
     * @param tax The total tax for the products that are being involved in the
     *            customer interaction. Example: 45.5
     * @return Content
     */
    public Content tax(Float tax) {
        this.tax = tax;
        return this;
    }

    /**
     * Gets the external id for this order item The external id for the products
     * that are being involved in the customer interaction.
     *
     * @return externalContentId
     */
    public String getExternalContentId() {
        return this.externalContentId;
    }

    /**
     * Sets the external id for this order item
     *
     * @param externalContentId The external id for the products that are being
     *                          involved in the customer interaction.
     */
    public void setExternalContentId(String externalContentId) {
        this.externalContentId = externalContentId;
    }

    /**
     * Sets the external id for this order item
     *
     * @param externalContentId The external id for the products that are being
     *                          involved in the customer interaction.
     * @return Content
     */
    public Content externalContentID(String externalContentId) {
        this.externalContentId = externalContentId;
        return this;
    }

}
