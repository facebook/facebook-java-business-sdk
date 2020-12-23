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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.facebook.ads.sdk.serverside.DeliveryCategory;

public class CustomData {

    private com.facebook.ads.sdk.businessdataapi.CustomData businessDataCustomData = new com.facebook.ads.sdk.businessdataapi.CustomData();
    private com.facebook.ads.sdk.serverside.CustomData serverSideCustomData = new com.facebook.ads.sdk.serverside.CustomData();

    /**
     * Default Constructor.
     */
    public CustomData() {
    }

    /**
     * params both Business Data API and Conversion API consume
     *
     * @param value            value of the item Eg: 123.45
     * @param currency         currency involved in the transaction Eg: usd
     * @param contents         Array of Content Objects. Use {Content} class to
     *                         define a content.
     * @param orderId          Unique id representing the order
     * @param status           Status of the registration in Registration event. Use
     *                         only with CompleteRegistration events for Conversion
     *                         API. Use only with Purchase or UpdateOrder events for
     *                         Business Data API params only Conversion API consumes
     * @param contentName      name of the Content Eg: lettuce
     * @param contentCategory  category of the content Eg: grocery
     * @param contentIds       list of content unique ids involved in the event
     * @param contentType      Type of the Content group or Product SKU
     * @param predictedLtv     Predicted LifeTime Value for the customer involved in
     *                         the event
     * @param numItems         Number of items involved
     * @param searchString     query string used for the Search event
     * @param itemNumber       The item number
     * @param deliveryCategory The type of delivery for a purchase event
     * @param customProperties Custom Properties to be added to the Custom Data
     *                         params only Business Data API consumes
     * @param shippingContact  Shipping contact information. User {UserData} class
     *                         to define a contact.
     * @param billingContact   Billing contact information. User {UserData} class to
     *                         define a contact.
     * @param externalOrderId  Unique ID representing the order, universal across
     *                         multiple categories from the business
     * @param originalOrderId  Original order id for refund. For Refund event only.
     * @param message          Reason for refund. For Refund event only.
     */
    public CustomData(Float value, String currency, String contentName, String contentCategory, List<String> contentIds,
            List<Content> contents, String contentType, String orderId, Float predictedLtv, String numItems,
            String status, String searchString, DeliveryCategory deliveryCategory, String itemNumber,
            HashMap<String, String> customProperties, UserData shippingContact, UserData billingContact,
            String externalOrderId, String originalOrderId, String message) {

        this.setContents(contents);

        this.serverSideCustomData.setValue(value);
        this.serverSideCustomData.setContentName(contentName);
        this.serverSideCustomData.setContentCategory(contentCategory);
        this.serverSideCustomData.setContentIds(contentIds);
        this.serverSideCustomData.setContentType(contentType);
        this.serverSideCustomData.setOrderId(orderId);
        this.serverSideCustomData.setPredictedLtv(predictedLtv);
        this.serverSideCustomData.setNumItems(numItems);
        this.serverSideCustomData.setStatus(status);
        this.serverSideCustomData.setSearchString(searchString);
        this.serverSideCustomData.setDeliveryCategory(deliveryCategory);
        this.serverSideCustomData.setItemNumber(itemNumber);
        this.serverSideCustomData.setCustomProperties(customProperties);

        this.businessDataCustomData.setValue(value);
        this.businessDataCustomData.setCurrency(currency);
        this.businessDataCustomData.setOrderId(orderId);
        this.businessDataCustomData.setStatus(status);
        this.businessDataCustomData.setShippingContact(shippingContact.getBusinessDataUserData());
        this.businessDataCustomData.setBillingContact(billingContact.getBusinessDataUserData());
        this.businessDataCustomData.setExternalOrderId(externalOrderId);
        this.businessDataCustomData.setOriginalOrderId(originalOrderId);
        this.businessDataCustomData.setMessage(message);
    }

    /**
     * Gets the value of the custom data. A numeric value associated with this
     * event. This could be a monetary value or a value in some other metric.
     * Example: 142.54.
     *
     * @return value
     */
    public SignalResponse<Float, Float> getValue() {
        return new SignalResponse<Float, Float>(this.serverSideCustomData.getValue(),
                this.businessDataCustomData.getValue());
    }

    /**
     * Sets the value of the custom data.
     *
     * @param value A numeric value associated with this event. This could be a
     *              monetary value or a value in some other metric. Example: 142.54.
     */
    public void setValue(Float value) {
        this.businessDataCustomData.setValue(value);
        this.serverSideCustomData.setValue(value);
    }

    /**
     * Sets the value of the custom data.
     *
     * @param value A numeric value associated with this event. This could be a
     *              monetary value or a value in some other metric. Example: 142.54.
     * @return CustomData
     */
    public CustomData value(Float value) {
        this.businessDataCustomData.setValue(value);
        this.serverSideCustomData.setValue(value);
        return this;
    }

    /**
     * Gets the currency for the custom data. The currency for the value specified,
     * if applicable. Currency must be a valid ISO 4217 three digit currency code.
     * Example: 'usd'
     *
     * @return currency
     */
    public SignalResponse<String, String> getCurrency() {
        return new SignalResponse<String, String>(this.serverSideCustomData.getCurrency(),
                this.businessDataCustomData.getCurrency());
    }

    /**
     * Sets the currency for the custom data.
     *
     * @param currency The currency for the value specified, if applicable. Currency
     *                 must be a valid ISO 4217 three digit currency code. Example:
     *                 'usd'
     */
    public void setCurrency(String currency) {
        this.businessDataCustomData.setCurrency(currency);
        this.serverSideCustomData.setCurrency(currency);
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
        this.businessDataCustomData.setCurrency(currency);
        this.serverSideCustomData.setCurrency(currency);
        return this;
    }

    /**
     * Gets the contents for the custom data. An array of Content objects that
     * contain the product IDs associated with the event plus information about the
     * products. id, quantity, and itemprice are available fields. Example:
     * [{'id':'ABC123','quantity' :2,'itemprice':5.99}, {'id':'XYZ789','quantity':2,
     * 'itemprice':9.99}]
     *
     * @return Contents
     */
    public SignalResponse<List<com.facebook.ads.sdk.serverside.Content>, List<com.facebook.ads.sdk.businessdataapi.Content>> getContents() {
        return new SignalResponse<List<com.facebook.ads.sdk.serverside.Content>, List<com.facebook.ads.sdk.businessdataapi.Content>>(
                this.serverSideCustomData.getContents(), this.businessDataCustomData.getContents());
    }

    /**
     * Sets the contents for the custom data.
     *
     * @param contents An array of Content objects that contain the product IDs
     *                 associated with the event plus information about the
     *                 products. id, quantity, and itemprice are available fields.
     *                 Example: [{'id':'ABC123','quantity' :2,'itemprice':5.99},
     *                 {'id':'XYZ789','quantity':2, 'itemprice':9.99}]
     */
    public void setContents(List<Content> contents) {
        List<com.facebook.ads.sdk.businessdataapi.Content> businessDataContents = new ArrayList<com.facebook.ads.sdk.businessdataapi.Content>();
        List<com.facebook.ads.sdk.serverside.Content> serverSideContents = new ArrayList<com.facebook.ads.sdk.serverside.Content>();
        for (Content content : contents) {
            businessDataContents.add(content.getBusinessDataContent());
            serverSideContents.add(content.getServerSideContent());
        }
        this.businessDataCustomData.setContents(businessDataContents);
        this.serverSideCustomData.setContents(serverSideContents);
    }

    /**
     * Sets the contents for the custom data.
     *
     * @param contents An array of Content objects that contain the product IDs
     *                 associated with the event plus information about the
     *                 products. id, quantity, and itemprice are available fields.
     *                 Example: [{'id':'ABC123','quantity' :2,'itemprice':5.99},
     *                 {'id':'XYZ789','quantity':2, 'itemprice':9.99}]
     * @return CustomData
     */
    public CustomData contents(List<Content> contents) {
        this.setContents(contents);
        return this;
    }

    /**
     * Gets the order id for the custom data. orderid is the order ID for this
     * transaction as a String. Example: 'order1234'
     *
     * @return orderId
     */
    public SignalResponse<String, String> getOrderId() {
        return new SignalResponse<String, String>(this.serverSideCustomData.getOrderId(),
                this.businessDataCustomData.getOrderId());
    }

    /**
     * Sets the orderid for the custom data.
     *
     * @param orderId The order ID for this transaction as a String. Example:
     *                'order1234'
     */
    public void setOrderId(String orderId) {
        this.businessDataCustomData.setOrderId(orderId);
        this.serverSideCustomData.setOrderId(orderId);
    }

    /**
     * Sets the orderid for the custom data.
     *
     * @param orderId The order ID for this transaction as a String. Example:
     *                'order1234'
     * @return CustomData
     */
    public CustomData orderId(String orderId) {
        this.businessDataCustomData.setOrderId(orderId);
        this.serverSideCustomData.setOrderId(orderId);
        return this;
    }

    /**
     * Status of the registration in Registration event or Status of the order in
     * Purchase/UpdateOrder event. - Used only with CompleteRegistration events for
     * Conversion API. - Used only with Purchase or UpdateOrder events for Business
     * Data API
     *
     * @return status
     */
    public SignalResponse<String, String> getStatus() {
        return new SignalResponse<String, String>(this.serverSideCustomData.getStatus(),
                this.businessDataCustomData.getStatus());
    }

    /**
     * Sets status of the registration in Registration event or status of the order
     * in Purchase/UpdateOrder event. - Used only with CompleteRegistration events
     * for Conversion API. - Used only with Purchase or UpdateOrder events for
     * Business Data API
     *
     * @param status status, as a String.
     */
    public void setStatus(String status) {
        this.serverSideCustomData.setStatus(status);
        this.businessDataCustomData.setStatus(status);
    }

    /**
     * Sets status of the registration in Registration event or status of the order
     * in Purchase/UpdateOrder event. - Used only with CompleteRegistration events
     * for Conversion API. - Used only with Purchase or UpdateOrder events for
     * Business Data API
     *
     * @param status status, as a String.
     * @return CustomData
     */
    public CustomData status(String status) {
        this.serverSideCustomData.setStatus(status);
        this.businessDataCustomData.setStatus(status);
        return this;
    }

    /**
     * Gets the content name for the custom data. The name of the page or product
     * associated with the event. The name of the page or product associated with
     * the event. Example: 'lettuce'
     *
     * @return ContentName
     */
    public SignalResponse<String, String> getContentName() {
        return new SignalResponse<String, String>(this.serverSideCustomData.getContentName(), null);
    }

    /**
     * Sets the content name for the custom data.
     *
     * @param contentName The name of the page or product associated with the event.
     *                    Example: 'lettuce'
     */
    public void setContentName(String contentName) {
        this.serverSideCustomData.setContentName(contentName);
    }

    /**
     * Sets the content name for the custom data.
     *
     * @param contentName The name of the page or product associated with the event.
     *                    Example: 'lettuce'
     * @return CustomData
     */
    public CustomData contentName(String contentName) {
        this.serverSideCustomData.setContentName(contentName);
        return this;
    }

    /**
     * Gets the content category for the custom data. The category of the content
     * associated with the event. Example: 'grocery'
     *
     * @return contentCategory
     */
    public SignalResponse<String, String> getContentCategory() {
        return new SignalResponse<String, String>(this.serverSideCustomData.getContentCategory(), null);
    }

    /**
     * Sets the contentcategory for the custom data.
     *
     * @param contentCategory The category of the content associated with the event.
     *                        Example: 'grocery'
     */
    public void setContentCategory(String contentCategory) {
        this.serverSideCustomData.setContentCategory(contentCategory);
    }

    /**
     * Sets the contentcategory for the custom data.
     *
     * @param contentCategory The category of the content associated with the event.
     *                        Example: 'grocery'
     * @return CustomData
     */
    public CustomData contentCategory(String contentCategory) {
        this.serverSideCustomData.setContentCategory(contentCategory);
        return this;
    }

    /**
     * Gets the contentids for the custom data. The content IDs associated with the
     * event, such as product SKUs for items in an AddToCart, represented as Array
     * of string. If contenttype is a product, then your content IDs must be an
     * array with a single string value. Otherwise, this array can contain any
     * number of string values. Example: ['ABC123', 'XYZ789']
     *
     * @return contentIds
     */
    public SignalResponse<List<String>, List<String>> getContentIds() {
        return new SignalResponse<List<String>, List<String>>(this.serverSideCustomData.getContentIds(), null);
    }

    /**
     * Sets the contentids for the custom data.
     *
     * @param contentIds The content IDs associated with the event, such as product
     *                   SKUs for items in an AddToCart, represented as Array of
     *                   string. If contenttype is a product, then your content IDs
     *                   must be an array with a single string value. Otherwise,
     *                   this array can contain any number of string values.
     *                   Example: ['ABC123', 'XYZ789']
     */
    public void setContentIds(List<String> contentIds) {
        this.serverSideCustomData.setContentIds(contentIds);
    }

    /**
     * Sets the contentids for the custom data.
     *
     * @param contentIds The content IDs associated with the event, such as product
     *                   SKUs for items in an AddToCart, represented as Array of
     *                   string. If contenttype is a product, then your content IDs
     *                   must be an array with a single string value. Otherwise,
     *                   this array can contain any number of string values.
     *                   Example: ['ABC123', 'XYZ789']
     * @return CustomData
     */
    public CustomData contentIds(List<String> contentIds) {
        this.serverSideCustomData.setContentIds(contentIds);
        return this;
    }

    /**
     * Gets the content type for the custom data. A String equal to either product
     * or productgroup. Set to product if the keys you send contentids or contents
     * represent products. Set to productgroup if the keys you send in contentids
     * represent product groups.
     *
     * @return contentType
     */
    public SignalResponse<String, String> getContentType() {
        return new SignalResponse<String, String>(this.serverSideCustomData.getContentType(), null);
    }

    /**
     * Sets the content type for the custom data. A String equal to either product
     * or productgroup. Set to product if the keys you send contentids or contents
     * represent products. Set to productgroup if the keys you send in contentids
     * represent product groups.
     *
     * @param contentType A string equal to either product or productgroup. Set to
     *                    product if the keys you send contentids or contents
     *                    represent products. Set to productgroup if the keys you
     *                    send in contentids represent product groups.
     */
    public void setContentType(String contentType) {
        this.serverSideCustomData.setContentType(contentType);
    }

    /**
     * Sets the content type for the custom data.
     *
     * @param contentType A string equal to either product or productgroup. Set to
     *                    product if the keys you send contentids or contents
     *                    represent products. Set to productgroup if the keys you
     *                    send in contentids represent product groups.
     * @return CustomData
     */
    public CustomData contentType(String contentType) {
        this.serverSideCustomData.setContentType(contentType);
        return this;
    }

    /**
     * Gets the predicted LifeTimeValue for the (user) in custom data. The predicted
     * lifetime value of a conversion event, as a String. Example: '432.12'
     *
     * @return pridictedLtv
     */
    public SignalResponse<Float, Float> getPredictedLtv() {
        return new SignalResponse<Float, Float>(this.serverSideCustomData.getPredictedLtv(), null);
    }

    /**
     * Sets the predicted LifeTimeValue for the custom data.
     *
     * @param predictedLtv The predicted lifetime value of a conversion event, as a
     *                     String. Example: '432.12'
     */
    public void setPredictedLtv(Float predictedLtv) {
        this.serverSideCustomData.setPredictedLtv(predictedLtv);
    }

    /**
     * Sets the predicted LifeTimeValue for the custom data.
     *
     * @param predictedLtv The predicted lifetime value of a conversion event, as a
     *                     String. Example: '432.12'
     * @return CustomData
     */
    public CustomData predictedLtv(Float predictedLtv) {
        this.serverSideCustomData.setPredictedLtv(predictedLtv);
        return this;
    }

    /**
     * Gets the number of items for the custom data. The number of items that a user
     * tries to buy during checkout. Use only with InitiateCheckout type events.
     * Example: 5
     *
     * @return numItems
     */
    public SignalResponse<String, String> getNumItems() {
        return new SignalResponse<String, String>(this.serverSideCustomData.getNumItems(), null);
    }

    /**
     * Sets the number of items for the custom data.
     *
     * @param numItems The number of items that a user tries to buy during checkout.
     *                 Use only with InitiateCheckout type events. Example: 5
     */
    public void setNumItems(String numItems) {
        this.serverSideCustomData.setNumItems(numItems);
    }

    /**
     * Sets the number of items for the custom data.
     *
     * @param numItems The number of items that a user tries to buy during checkout.
     *                 Use only with InitiateCheckout type events. Example: 5
     * @return CustomData
     */
    public CustomData numItems(String numItems) {
        this.serverSideCustomData.setNumItems(numItems);
        return this;
    }

    /**
     * Gets the search string for the custom data. A search query made by a user.Use
     * only with Search events. Eg: 'lettuce'
     *
     * @return searchString
     */
    public SignalResponse<String, String> getSearchString() {
        return new SignalResponse<String, String>(this.serverSideCustomData.getSearchString(), null);
    }

    /**
     * Sets the search string for the custom data.
     *
     * @param searchString A search query made by a user.Use only with Search
     *                     events. Eg: 'lettuce'
     */
    public void setSearchString(String searchString) {
        this.serverSideCustomData.setSearchString(searchString);
    }

    /**
     * Sets the search string for the custom data.
     *
     * @param searchString A search query made by a user.Use only with Search
     *                     events. Eg: 'lettuce'
     * @return CustomData
     */
    public CustomData searchString(String searchString) {
        this.serverSideCustomData.setSearchString(searchString);
        return this;
    }

    /**
     * Gets the item number.
     *
     * @return itemNumber
     */
    public SignalResponse<String, String> getItemNumber() {
        return new SignalResponse<String, String>(this.serverSideCustomData.getItemNumber(), null);
    }

    /**
     * Sets the item number.
     *
     * @param itemNumber The item number.
     */
    public void setItemNumber(String itemNumber) {
        this.serverSideCustomData.setItemNumber(itemNumber);
    }

    /**
     * Sets the item number.
     *
     * @param itemNumber The item number.
     * @return CustomData
     */
    public CustomData itemNumber(String itemNumber) {
        this.serverSideCustomData.setItemNumber(itemNumber);
        return this;
    }

    /**
     * Gets the delivery category.
     *
     * @return deliveryCategory
     */
    public SignalResponse<DeliveryCategory, DeliveryCategory> getDeliveryCategory() {
        return new SignalResponse<DeliveryCategory, DeliveryCategory>(this.serverSideCustomData.getDeliveryCategory(),
                null);
    }

    /**
     * Sets the type of delivery for a purchase event.
     *
     * @param deliveryCategory The delivery category.
     */
    public void setdeliverycategory(DeliveryCategory deliveryCategory) {
        this.serverSideCustomData.setDeliveryCategory(deliveryCategory);
    }

    /**
     * Sets the type of delivery for a purchase event.
     *
     * @param deliveryCategory The delivery category.
     * @return CustomData
     */
    public CustomData deliveryCategory(DeliveryCategory deliveryCategory) {
        this.serverSideCustomData.setDeliveryCategory(deliveryCategory);
        return this;
    }

    /**
     * Gets the custom properties to be included in the Custom Data. If our
     * predefined object properties don't suit your needs, you can include your own,
     * custom properties. Custom properties can be used with both standard and
     * custom events, and can help you further define custom audiences. This
     * behavior is the same for Server-Side API and Facebook Pixel.
     *
     * @return customProperties
     */
    public SignalResponse<HashMap<String, String>, HashMap<String, String>> getCustomProperties() {
        return new SignalResponse<HashMap<String, String>, HashMap<String, String>>(
                this.serverSideCustomData.getCustomProperties(), null);
    }

    /**
     * Sets the custom properties to be included in the Custom Data. If our
     * predefined object properties don't suit your needs, you can include your own,
     * custom properties. Custom properties can be used with both standard and
     * custom events, and can help you further define custom audiences. This
     * behavior is the same for Server-Side API and Facebook Pixel.
     *
     * @param customProperties custom properties property bag to be included in the
     *                         Custom Data. Eg: '{ 'warehouselocation' :
     *                         'washington', 'packagesize' : 'L'}'
     */
    public void setCustomProperties(HashMap<String, String> customProperties) {
        this.serverSideCustomData.setCustomProperties(customProperties);
    }

    /**
     * Sets the search string for the custom data.
     *
     * @param customProperties A custom properties property bag to be included in
     *                         the Custom Data. If our predefined object properties
     *                         don't suit your needs, you can include your own,
     *                         custom properties. Custom properties can be used with
     *                         both standard and custom events, and can help you
     *                         further define custom audiences. This behavior is the
     *                         same for Server-Side API and Facebook Pixel.
     * @return CustomData
     */
    public CustomData customProperties(HashMap<String, String> customProperties) {
        this.serverSideCustomData.setCustomProperties(customProperties);
        return this;
    }

    /**
     * Gets the shippingcontact for Purchase/Update Order event. shippingcontact of
     * an order
     *
     * @return shippingContact
     */
    public SignalResponse<com.facebook.ads.sdk.serverside.UserData, com.facebook.ads.sdk.businessdataapi.UserData> getShippingContact() {
        return new SignalResponse<com.facebook.ads.sdk.serverside.UserData, com.facebook.ads.sdk.businessdataapi.UserData>(
                null, this.businessDataCustomData.getShippingContact());
    }

    /**
     * Sets the shippingcontact for Purchase/Update Order event.
     *
     * @param shippingContact shipping contact of an order, use {SignalUserData} to
     *                        build
     */
    public void setShippingContact(UserData shippingContact) {
        this.businessDataCustomData.setShippingContact(shippingContact.getBusinessDataUserData());
    }

    /**
     * Sets the shippingcontact for Purchase/Update Order event.
     *
     * @param shippingContact shipping contact of an order, use {SignalUserData} to
     *                        build
     * @return CustomData
     */
    public CustomData shippingContact(UserData shippingContact) {
        this.businessDataCustomData.setShippingContact(shippingContact.getBusinessDataUserData());
        return this;
    }

    /**
     * Gets the billingcontact for Purchase/Update Order event. billingcontact of an
     * order
     *
     * @return BillingContact
     */
    public SignalResponse<com.facebook.ads.sdk.serverside.UserData, com.facebook.ads.sdk.businessdataapi.UserData> getBillingContact() {
        return new SignalResponse<com.facebook.ads.sdk.serverside.UserData, com.facebook.ads.sdk.businessdataapi.UserData>(
                null, this.businessDataCustomData.getBillingContact());
    }

    /**
     * Sets the billingcontact for Purchase/Update Order event.
     *
     * @param billingContact billing contact of an order, use {SignalUserData} to
     *                       build
     */
    public void setBillingContact(UserData billingContact) {
        this.businessDataCustomData.setBillingContact(billingContact.getBusinessDataUserData());
    }

    /**
     * Sets the billingcontact for Purchase/Update Order event.
     *
     * @param billingContact billing contact of an order, use {SignalUserData} to
     *                       build
     * @return CustomData
     */
    public CustomData billingContact(UserData billingContact) {
        this.businessDataCustomData.setBillingContact(billingContact.getBusinessDataUserData());
        return this;
    }

    /**
     * Gets the unique id of the order. Unique ID representing the order, universal
     * across multiple categories from the business.
     *
     * @return externalOrderId
     */
    public SignalResponse<String, String> getExternalOrderId() {
        return new SignalResponse<String, String>(null, this.businessDataCustomData.getExternalOrderId());
    }

    /**
     * Sets the unique id of the order.
     *
     * @param externalOrderId Unique ID representing the order, universal across
     *                        multiple categories from the business.
     */
    public void setExternalOrderId(String externalOrderId) {
        this.businessDataCustomData.setExternalOrderId(externalOrderId);
    }

    /**
     * Sets the unique id of the order.
     *
     * @param externalOrderId Unique ID representing the order, universal across
     *                        multiple categories from the business.
     * @return CustomData
     */
    public CustomData externalOrderId(String externalOrderId) {
        this.businessDataCustomData.setExternalOrderId(externalOrderId);
        return this;
    }

    /**
     * Gets the unique id of the original order. Original order id for refund. For
     * Refund event only.
     *
     * @return originalOrderId
     */
    public SignalResponse<String, String> getOriginalOrderId() {
        return new SignalResponse<String, String>(null, this.businessDataCustomData.getOriginalOrderId());
    }

    /**
     * Sets the unique id of the original order.
     *
     * @param originalOrderId Original order id for refund. For Refund event only.
     */
    public void setOriginalOrderId(String originalOrderId) {
        this.businessDataCustomData.setOriginalOrderId(originalOrderId);
    }

    /**
     * Sets the unique id of the original order.
     *
     * @param originalOrderId Original order id for refund. For Refund event only.
     * @return CustomData
     */
    public CustomData originalOrderId(String originalOrderId) {
        this.businessDataCustomData.setOriginalOrderId(originalOrderId);
        return this;
    }

    /**
     * Gets the unique id of the original order. Reason for refund. For Refund event
     * only.
     *
     * @return message
     */
    public SignalResponse<String, String> getMessage() {
        return new SignalResponse<String, String>(null, this.businessDataCustomData.getMessage());
    }

    /**
     * Sets the unique id of the original order.
     *
     * @param message Reason for refund. For Refund event only.
     */
    public void setMessage(String message) {
        this.businessDataCustomData.setMessage(message);
    }

    /**
     * Sets the unique id of the original order.
     *
     * @param message Reason for refund. For Refund event only.
     * @return CustomData
     */
    public CustomData message(String message) {
        this.businessDataCustomData.setMessage(message);
        return this;
    }

    /**
     * Gets the constructed custom data for Business Data API
     *
     * @return businessDataCustomData
     */
    public com.facebook.ads.sdk.businessdataapi.CustomData getBusinessDataCustomData() {
        return this.businessDataCustomData;
    }

    /**
     * Gets the constructed custom data for Business Data API
     *
     * @return serverSideCustomData
     */
    public com.facebook.ads.sdk.serverside.CustomData getServerSideCustomData() {
        return this.serverSideCustomData;
    }
}
