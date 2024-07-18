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

public class AttributionData {
    @SerializedName("scope")
    private String scope = null;

    @SerializedName("visit_time")
    private Long visitTime = null;

    @SerializedName("ad_id")
    private String adId = null;

    @SerializedName("adset_id")
    private String adsetId = null;

    @SerializedName("campaign_id")
    private String campaignId = null;

    @SerializedName("attribution_share")
    private Float attributionShare = null;

    @SerializedName("attribution_model")
    private AttributionModelEnum attributionModel = null;

    @SerializedName("attr_window")
    private Integer attributionWindow = null;
    
    /**
     * Default constructor
     */
    public AttributionData() {
    }

    /**
     * Constructor
     * 
     * @param scope Touchpoint type
     * @param visitTime Time that the campaign_id or fbc was first received
     * @param adId Meta-provided ad id from URL/deeplink
     * @param adsetId Meta-provided adset id from URL/deeplink
     * @param campaignId Meta-provided campaign id from URL/deeplink
     * @param attributionShare [0-1] weight of credit assigned to the visit
     * @param attributionModel Attribution model used to attribute the event
     */
    public AttributionData(String scope, Long visitTime, String adId, String adsetId, String campaignId, 
        Float attributionShare, AttributionModelEnum attributionModel, Integer attributionWindow) {
      this.scope = scope;
      this.visitTime = visitTime;
      this.adId = adId;
      this.adsetId = adsetId;
      this.campaignId = campaignId;
      this.attributionShare = attributionShare;
      this.attributionModel = attributionModel;
      this.attributionWindow = attributionWindow;
    }

    /**
     * Set scope
     * 
     * @param scope Touchpoint type
     * @return AttributionData
     */
    public AttributionData scope(String scope) {
      this.scope = scope;
      return this;
    }

    /**
     * Get scope
     * 
     * @return scope
     */
    public String getScope() {
      return scope;
    }

    /**
     * Set scope
     * 
     * @param scope Touchpoint type
     */
    public void setScope(String scope) {
      this.scope = scope;
    }

    /**
     * Set visitTime
     * 
     * @param visitTime Time that the campaign_id or fbc was first received
     * @return AttributionData
     */
    public AttributionData visitTime(Long visitTime) {
      this.visitTime = visitTime;
      return this;
    }

    /**
     * Get visitTime
     * 
     * @return visitTime
     */
    public Long getVisitTime() {
      return visitTime;
    }

    /**
     * Set visitTime
     * 
     * @param visitTime Time that the campaign_id or fbc was first received
     */
    public void setVisitTime(Long visitTime) {
      this.visitTime = visitTime;
    }

    /**
     * Set adId
     * 
     * @param adId Meta-provided ad id from URL/deeplink
     * @return AttributionData
     */
    public AttributionData adId(String adId) {
      this.adId = adId;
      return this;
    }

    /**
     * Get adId
     * 
     * @return adId
     */
    public String getAdId() {
      return adId;
    }

    /**
     * Set adId
     * 
     * @param adId Meta-provided ad id from URL/deeplink
     */
    public void setAdId(String adId) {
      this.adId = adId;
    }

    /**
     * Set adsetId
     * 
     * @param adsetId Meta-provided adset id from URL/deeplink
     * @return AttributionData
     */
    public AttributionData adsetId(String adsetId) {
      this.adsetId = adsetId;
      return this;
    }

    /**
     * Get adsetId
     * 
     * @return adsetId
     */
    public String getAdsetId() {
      return adsetId;
    }

    /**
     * Set adsetId
     * 
     * @param adsetId Meta-provided adset id from URL/deeplink
     */
    public void setAdsetId(String adsetId) {
      this.adsetId = adsetId;
    }

    /**
     * Set campaignId
     * 
     * @param campaignId Meta-provided campaign id from URL/deeplink
     * @return AttributionData
     */
    public AttributionData campaignId(String campaignId) {
      this.campaignId = campaignId;
      return this;
    }

    /**
     * Get campaignId
     * 
     * @return campaignId
     */
    public String getCampaignId() {
      return campaignId;
    }

    /**
     * Set campaignId
     * 
     * @param campaignId Meta-provided campaign id from URL/deeplink
     */
    public void setCampaignId(String campaignId) {
      this.campaignId = campaignId;
    }

    /**
     * Set attributionShare
     * 
     * @param attributionShare [0-1] weight of credit assigned to the visit
     * @return AttributionData
     */
    public AttributionData attributionShare(Float attributionShare) {
      this.attributionShare = attributionShare;
      return this;
    }

    /**
     * Get attributionShare
     * 
     * @return attributionShare
     */
    public Float getAttributionShare() {
      return attributionShare;
    }

    /**
     * Set attributionShare
     * 
     * @param attributionShare [0-1] weight of credit assigned to the visit
     */
    public void setAttributionShare(Float attributionShare) {
      this.attributionShare = attributionShare;
    }

    /**
     * Set attributionModel
     * 
     * @param attributionModel Attribution model used to attribute the event.
     * @return AttributionData
     */
    public AttributionData attributionModel(AttributionModelEnum attributionModel) {
      this.attributionModel = attributionModel;
      return this;
    }

    /**
     * Get attributionModel
     * 
     * @return attributionModel
     */
    public AttributionModelEnum getAttributionModel() {
      return attributionModel;
    }

    /**
     * Set attributionModel
     * 
     * @param attributionModel Attribution model used to attribute the event.
     */
    public void setAttributionModel(AttributionModelEnum attributionModel) {
      this.attributionModel = attributionModel;
    }

    /**
     * Set attributionWindow
     * 
     * @param attributionWindow Attribution window in days.
     * @return AttributionData
     */
    public AttributionData attributionWindow(Integer attributionWindow) {
        this.attributionWindow = attributionWindow;
        return this;
      }
  
      /**
       * Get attributionWindow
       * 
       * @return attributionWindow
       */
      public Integer getAttributionWindow() {
        return attributionWindow;
      }
  
      /**
       * Set attributionWindow
       * 
       * @param attributionWindow Attribution window in days.
       */
      public void setAttributionWindow(Integer attributionWindow) {
        this.attributionWindow = attributionWindow;
      }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      AttributionData attributionData = (AttributionData) o;

      return Objects.equals(this.scope, attributionData.scope)
        && Objects.equals(this.visitTime, attributionData.visitTime)
        && Objects.equals(this.adId, attributionData.adId)
        && Objects.equals(this.adsetId, attributionData.adsetId)
        && Objects.equals(this.campaignId, attributionData.campaignId)
        && Objects.equals(this.attributionShare, attributionData.attributionShare)
        && Objects.equals(this.attributionModel, attributionData.attributionModel)
        && Objects.equals(this.attributionWindow, attributionData.attributionWindow);
    }

    @Override
    public int hashCode() {
      return Objects.hash(scope, visitTime, adId, adsetId, campaignId, attributionShare, attributionModel, attributionWindow);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AttributionData {\n");
      sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
      sb.append("    visitTime: ").append(toIndentedString(visitTime)).append("\n");
      sb.append("    adId: ").append(toIndentedString(adId)).append("\n");
      sb.append("    adsetId: ").append(toIndentedString(adsetId)).append("\n");
      sb.append("    campaignId: ").append(toIndentedString(campaignId)).append("\n");
      sb.append("    attributionShare: ").append(toIndentedString(attributionShare)).append("\n");
      sb.append("    attributionModel: ").append(toIndentedString(attributionModel)).append("\n");
      sb.append("    attributionWindow: ").append(toIndentedString(attributionWindow)).append("\n");
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
