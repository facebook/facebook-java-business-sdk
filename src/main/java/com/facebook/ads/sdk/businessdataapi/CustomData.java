
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
import java.util.List;

public class CustomData {

    @SerializedName("value")
    private Float value = null;

    @SerializedName("currency")
    private String currency = null;

    @SerializedName("contents")
    private List<Content> contents = null;

    @SerializedName("order_id")
    private String orderId = null;

    @SerializedName("status")
    private String status = null;

    @SerializedName("shipping_contact")
    private UserData shippingContact = null;

    @SerializedName("billing_contact")
    private UserData billingContact = null;

    @SerializedName("external_order_id")
    private String externalOrderId = null;

    @SerializedName("original_order_id")
    private String originalOrderId = null;

    @SerializedName("message")
    private String message = null;

    /**
     * Default Constructor.
     */
    public CustomData() {
    }

    /**
     * @param value           value of the order Eg: 123.45
     * @param currency        currency involved in the transaction Eg: usd
     * @param contents        Array of Content Objects. Use {Content} class to
     *                        define a content.
     * @param orderId         Unique id representing the order
     * @param status          Status of order
     * @param shippingContact Shipping contact information. User {UserData} class to
     *                        define a contact.
     * @param billingContact  Billing contact information. User {UserData} class to
     *                        define a contact.
     * @param externalOrderId Unique ID representing the order, universal across
     *                        multiple categories from the business
     * @param originalOrderId Original order id for refund. For Refund event only.
     * @param message         Reason for refund. For Refund event only.
     */
    public CustomData(Float value, String currency, List<Content> contents, String orderId, String status,
            UserData shippingContact, UserData billingContact, String externalOrderId, String originalOrderId,
            String message) {
        this.value = value;
        this.currency = currency;
        this.contents = contents;
        this.orderId = orderId;
        this.status = status;
        this.shippingContact = shippingContact;
        this.billingContact = billingContact;
        this.externalOrderId = externalOrderId;
        this.originalOrderId = originalOrderId;
        this.message = message;
    }

    /**
     * Gets the total value of the order. A numeric value associated with this
     * event. This could be a monetary value or a value in some other metric.
     * Example: 142.54.
     *
     * @return value
     */
    public Float getValue() {
        return this.value;
    }

    /**
     * Sets the value of the custom data.
     *
     * @param value A numeric value associated with this event. This could be a
     *              monetary value or a value in some other metric. Example: 142.54.
     */
    public void setValue(Float value) {
        this.value = value;
    }

    /**
     * Sets the value of the custom data.
     *
     * @param value A numeric value associated with this event. This could be a
     *              monetary value or a value in some other metric. Example: 142.54.
     * @return CustomData
     */
    public CustomData value(Float value) {
        this.value = value;
        return this;
    }

    /**
     * Gets the currency for the custom data. The currency for the value specified,
     * if applicable. Currency must be a valid ISO 4217 three digit currency code.
     * Example: 'usd'
     *
     * @return currency
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * Sets the currency for the custom data.
     *
     * @param currency The currency for the value specified, if applicable. Currency
     *                 must be a valid ISO 4217 three digit currency code. Example:
     *                 'usd'
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Sets the currency for the custom data.
     *
     * @param currency The currency for the value specified, if applicable. Currency
     *                 must be a valid ISO 4217 three digit currency code. Example:
     *                 'usd'
     * @return CustomData
     */
    public CustomData currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Gets the contents for the custom data. An array of Content objects that
     * contain the product IDs associated with the event plus information about the
     * products. Example: [{'id':'ABC123','quantity' :2,'price':5.99},
     * {'id':'XYZ789','quantity':2, 'price':9.99}]
     *
     * @return Contents
     */
    public List<Content> getContents() {
        return this.contents;
    }

    /**
     * Sets the contents for the custom data.
     *
     * @param contents An array of Content objects that contain the product IDs
     *                 associated with the event plus information about the
     *                 products. Example: [{'id':'ABC123','quantity'
     *                 :2,'price':5.99}, {'id':'XYZ789','quantity':2, 'price':9.99}]
     */
    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    /**
     * Sets the contents for the custom data.
     *
     * @param contents An array of Content objects that contain the product IDs
     *                 associated with the event plus information about the
     *                 products. Example: [{'id':'ABC123','quantity'
     *                 :2,'item_price':5.99}, {'id':'XYZ789','quantity':2,
     *                 'item_price':9.99}]
     * @return CustomData
     */
    public CustomData contents(List<Content> contents) {
        this.contents = contents;
        return this;
    }

    /**
     * Gets the order id for the custom data. order_id is the order ID for this
     * transaction as a String. Example: 'order1234'
     *
     * @return orderId
     */
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * Sets the order_id for the custom data.
     *
     * @param orderId The order ID for this transaction as a String. Example:
     *                'order1234'
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Sets the order_id for the custom data.
     *
     * @param orderId The order ID for this transaction as a String. Example:
     *                'order1234'
     * @return CustomData
     */
    public CustomData orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * Gets the status of order. Status of the order, as a String.
     *
     * @return Status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Gets the status of order.
     *
     * @param status Status of the order, as a String.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the status of the registration event.
     *
     * @param status Status of the registration event, as a String.
     * @return CustomData
     */
    public CustomData status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Gets the shipping contact of the order. An Object contains the user data of
     * shipping contact. Use {UserData} to construct the object.
     *
     * @return shippingContact
     */
    public UserData getShippingContact() {
        return this.shippingContact;
    }

    /**
     * Sets the shipping contact of the order.
     *
     * @param shippingContact An Object contains the user data of shipping contact.
     *                        Use {UserData} to construct the object.
     */
    public void setShippingContact(UserData shippingContact) {
        this.shippingContact = shippingContact;
    }

    /**
     * Sets the shipping contact of the order.
     *
     * @param shippingContact An Object contains the user data of shipping contact.
     *                        Use {UserData} to construct the object.
     * @return CustomData
     */
    public CustomData shippingContact(UserData shippingContact) {
        this.shippingContact = shippingContact;
        return this;
    }

    /**
     * Gets the billing contact of the order. An Object contains the user data of
     * billing contact. Use {UserData} to construct the object.
     *
     * @return billingContact
     */
    public UserData getBillingContact() {
        return this.billingContact;
    }

    /**
     * Sets the billing contact of the order.
     *
     * @param billingContact An Object contains the user data of billing contact.
     *                       Use {UserData} to construct the object.
     */
    public void setBillingContact(UserData billingContact) {
        this.billingContact = billingContact;
    }

    /**
     * Sets the billing contact of the order.
     *
     * @param billingContact An Object contains the user data of billing contact.
     *                       Use {UserData} to construct the object.
     * @return CustomData
     */
    public CustomData billingContact(UserData billingContact) {
        this.billingContact = billingContact;
        return this;
    }

    /**
     * Gets the unique id of the order. Unique ID representing the order, universal
     * across multiple categories from the business.
     *
     * @return externalOrderId
     */
    public String getExternalOrderId() {
        return this.externalOrderId;
    }

    /**
     * Sets the unique id of the order.
     *
     * @param externalOrderId Unique ID representing the order, universal across
     *                        multiple categories from the business.
     */
    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId;
    }

    /**
     * Sets the unique id of the order.
     *
     * @param externalOrderId Unique ID representing the order, universal across
     *                        multiple categories from the business.
     * @return CustomData
     */
    public CustomData externalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId;
        return this;
    }

    /**
     * Gets the unique id of the original order. Original order id for refund. For
     * Refund event only.
     *
     * @return originalOrderId
     */
    public String getOriginalOrderId() {
        return this.originalOrderId;
    }

    /**
     * Sets the unique id of the original order.
     *
     * @param originalOrderId Original order id for refund. For Refund event only.
     */
    public void setOriginalOrderId(String originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    /**
     * Sets the unique id of the original order.
     *
     * @param originalOrderId Original order id for refund. For Refund event only.
     * @return CustomData
     */
    public CustomData originalOrderId(String originalOrderId) {
        this.originalOrderId = originalOrderId;
        return this;
    }

    /**
     * Gets the unique id of the original order. Reason for refund. For Refund event
     * only.
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the unique id of the original order.
     *
     * @param message Reason for refund. For Refund event only.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Sets the unique id of the original order.
     *
     * @param message Reason for refund. For Refund event only.
     * @return CustomData
     */
    public CustomData message(String message) {
        this.message = message;
        return this;
    }

}
