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

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class AppData {

    @SerializedName("application_tracking_enabled")
    private boolean applicationTrackingEnabled = false;

    @SerializedName("advertiser_tracking_enabled")
    private boolean advertiserTrackingEnabled = false;

    @SerializedName("app_user_id")
    private String appUserId = null;

    @SerializedName("campaign_ids")
    private String campaignIds = null;

    @SerializedName("consider_views")
    private boolean considerViews = false;

    @SerializedName("extinfo")
    private ExtendedDeviceInfo extinfo = null;

    @SerializedName("include_dwell_data")
    private boolean includeDwellData = false;

    @SerializedName("include_video_data")
    private boolean includeVideoData = false;

    @SerializedName("install_referrer")
    private String installReferrer = null;

    @SerializedName("installer_package")
    private String installerPackage = null;

    @SerializedName("receipt_data")
    private String receiptData = null;

    @SerializedName("url_schemes")
    private List<String> urlSchemes = null;

    @SerializedName("windows_attribution_id")
    private String windowsAttributionId = null;

    /**
     * Default Constructor.
     */
    public AppData() {
    }

    public AppData(boolean applicationTrackingEnabled, boolean advertiserTrackingEnabled, String appUserId, String campaignIds, boolean considerViews, ExtendedDeviceInfo extinfo, boolean includeDwellData, boolean includeVideoData, String installReferrer, String installerPackage, String receiptData, List<String> urlSchemes, String windowsAttributionId) {
        this.applicationTrackingEnabled = applicationTrackingEnabled;
        this.advertiserTrackingEnabled = advertiserTrackingEnabled;
        this.appUserId = appUserId;
        this.campaignIds = campaignIds;
        this.considerViews = considerViews;
        this.extinfo = extinfo;
        this.includeDwellData = includeDwellData;
        this.includeVideoData = includeVideoData;
        this.installReferrer = installReferrer;
        this.installerPackage = installerPackage;
        this.receiptData = receiptData;
        this.urlSchemes = urlSchemes;
        this.windowsAttributionId = windowsAttributionId;
    }

    public boolean isApplicationTrackingEnabled() {
        return this.applicationTrackingEnabled;
    }

    public AppData applicationTrackingEnabled(boolean applicationTrackingEnabled) {
        setApplicationTrackingEnabled(applicationTrackingEnabled);
        return this;
    }

    public boolean getApplicationTrackingEnabled() {
        return this.applicationTrackingEnabled;
    }

    public void setApplicationTrackingEnabled(boolean applicationTrackingEnabled) {
        this.applicationTrackingEnabled = applicationTrackingEnabled;
    }

    public boolean isAdvertiserTrackingEnabled() {
        return this.advertiserTrackingEnabled;
    }

    public AppData advertiserTrackingEnabled(boolean advertiserTrackingEnabled) {
        setAdvertiserTrackingEnabled(advertiserTrackingEnabled);
        return this;
    }

    public boolean getAdvertiserTrackingEnabled() {
        return this.advertiserTrackingEnabled;
    }

    public void setAdvertiserTrackingEnabled(boolean advertiserTrackingEnabled) {
        this.advertiserTrackingEnabled = advertiserTrackingEnabled;
    }

    public AppData extinfo(ExtendedDeviceInfo extinfo) {
        setExtinfo(extinfo);
        return this;
    }

    public ExtendedDeviceInfo getExtinfo() {
        return this.extinfo;
    }

    public void setExtinfo(ExtendedDeviceInfo extinfo) {
        this.extinfo = extinfo;
    }

    public AppData appUserId(String appUserId) {
        setAppUserId(appUserId);
        return this;
    }

    public String getAppUserId() {
        return this.appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    public AppData campaignIds(String campaignIds) {
        setCampaignIds(campaignIds);
        return this;
    }

    public String getCampaignIds() {
        return this.campaignIds;
    }

    public void setCampaignIds(String campaignIds) {
        this.campaignIds = campaignIds;
    }

    public AppData considerViews(boolean considerViews) {
        setConsiderViews(considerViews);
        return this;
    }

    public boolean isConsiderViews() {
        return this.considerViews;
    }

    public boolean getConsiderViews() {
        return this.considerViews;
    }

    public void setConsiderViews(boolean considerViews) {
        this.considerViews = considerViews;
    }

    public AppData includeDwellData(boolean includeDwellData) {
        setIncludeDwellData(includeDwellData);
        return this;
    }

    public boolean isIncludeDwellData() {
        return this.includeDwellData;
    }

    public boolean getIncludeDwellData() {
        return this.includeDwellData;
    }

    public void setIncludeDwellData(boolean includeDwellData) {
        this.includeDwellData = includeDwellData;
    }

    public AppData includeVideoData(boolean includeVideoData) {
        setIncludeVideoData(includeVideoData);
        return this;
    }

    public boolean isIncludeVideoData() {
        return this.includeVideoData;
    }

    public boolean getIncludeVideoData() {
        return this.includeVideoData;
    }

    public void setIncludeVideoData(boolean includeVideoData) {
        this.includeVideoData = includeVideoData;
    }

    public AppData installReferrer(String installReferrer) {
        setInstallReferrer(installReferrer);
        return this;
    }

    public String getInstallReferrer() {
        return this.installReferrer;
    }

    public void setInstallReferrer(String installReferrer) {
        this.installReferrer = installReferrer;
    }
    public AppData installerPackage(String installerPackage) {
        setInstallerPackage(installerPackage);
        return this;
    }

    public String getInstallerPackage() {
        return this.installerPackage;
    }

    public void setInstallerPackage(String installerPackage) {
        this.installerPackage = installerPackage;
    }

    public AppData receiptData(String receiptData) {
        setReceiptData(receiptData);
        return this;
    }

    public String getReceiptData() {
        return this.receiptData;
    }

    public void setReceiptData(String receiptData) {
        this.receiptData = receiptData;
    }

    public AppData urlSchemes(List<String> urlSchemes) {
        setUrlSchemes(urlSchemes);
        return this;
    }

    public List<String> getUrlSchemes() {
        return this.urlSchemes;
    }

    public void setUrlSchemes(List<String> urlSchemes) {
        this.urlSchemes = urlSchemes;
    }

    public AppData windowsAttributionId(String windowsAttributionId) {
        setWindowsAttributionId(windowsAttributionId);
        return this;
    }

    public String getWindowsAttributionId() {
        return this.windowsAttributionId;
    }

    public void setWindowsAttributionId(String windowsAttributionId) {
        this.windowsAttributionId = windowsAttributionId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AppData)) {
            return false;
        }
        AppData appData = (AppData) o;
        return applicationTrackingEnabled == appData.applicationTrackingEnabled
            && advertiserTrackingEnabled == appData.advertiserTrackingEnabled
            && Objects.equals(appUserId, appData.appUserId)
            && Objects.equals(campaignIds, appData.campaignIds)
            && considerViews == appData.considerViews
            && Objects.equals(extinfo, appData.extinfo)
            && includeDwellData == appData.includeDwellData
            && includeVideoData == appData.includeVideoData
            && Objects.equals(installReferrer, appData.installReferrer)
            && Objects.equals(installerPackage, appData.installerPackage)
            && Objects.equals(receiptData, appData.receiptData)
            && Objects.equals(urlSchemes, appData.urlSchemes)
            && Objects.equals(windowsAttributionId, appData.windowsAttributionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            applicationTrackingEnabled,
            advertiserTrackingEnabled,
            appUserId,
            campaignIds,
            considerViews,
            extinfo,
            includeDwellData,
            includeVideoData,
            installReferrer,
            installerPackage,
            receiptData,
            urlSchemes,
            windowsAttributionId);
    }

    @Override
    public String toString() {
        return "{" +
            " applicationTrackingEnabled='" + isApplicationTrackingEnabled() + "'" +
            ", advertiserTrackingEnabled='" + isAdvertiserTrackingEnabled() + "'" +
            ", appUserId='" + getAppUserId() + "'" +
            ", campaignIds='" + getCampaignIds() + "'" +
            ", considerViews='" + isConsiderViews() + "'" +
            ", extinfo='" + getExtinfo() + "'" +
            ", includeDwellData='" + isIncludeDwellData() + "'" +
            ", includeVideoData='" + isIncludeVideoData() + "'" +
            ", installReferrer='" + getInstallReferrer() + "'" +
            ", installerPackage='" + getInstallerPackage() + "'" +
            ", receiptData='" + getReceiptData() + "'" +
            ", urlSchemes='" + getUrlSchemes() + "'" +
            ", windowsAttributionId='" + getWindowsAttributionId() + "'" +
            "}";
    }


}
