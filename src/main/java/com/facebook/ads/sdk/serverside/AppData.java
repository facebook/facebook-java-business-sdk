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

 public class AppData{

    @SerializedName("anon_id")
    private String anonId = null;

    @SerializedName("application_tracking_enabled")
    private boolean applicationTrackingEnabled = false;

    @SerializedName("advertiser_tracking_enabled")
    private boolean advertiserTrackingEnabled = false;

    @SerializedName("extinfo")
    private ExtendedDeviceInfo extinfo = null;

    /**
     * Default Constructor.
     */
    public AppData() {
    }

    public String getAnonId() {
        return this.anonId;
    }

    public void setAnonId(String anonId) {
        this.anonId = anonId;
    }

    public boolean isApplicationTrackingEnabled() {
        return this.applicationTrackingEnabled;
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

    public boolean getAdvertiserTrackingEnabled() {
        return this.advertiserTrackingEnabled;
    }

    public void setAdvertiserTrackingEnabled(boolean advertiserTrackingEnabled) {
        this.advertiserTrackingEnabled = advertiserTrackingEnabled;
    }

    public ExtendedDeviceInfo getExtinfo() {
        return this.extinfo;
    }

    public void setExtinfo(ExtendedDeviceInfo extinfo) {
        this.extinfo = extinfo;
    }

    public AppData anonId(String anonId) {
        setAnonId(anonId);
        return this;
    }

    public AppData applicationTrackingEnabled(boolean applicationTrackingEnabled) {
        setApplicationTrackingEnabled(applicationTrackingEnabled);
        return this;
    }

    public AppData advertiserTrackingEnabled(boolean advertiserTrackingEnabled) {
        setAdvertiserTrackingEnabled(advertiserTrackingEnabled);
        return this;
    }

    public AppData extinfo(ExtendedDeviceInfo extinfo) {
        setExtinfo(extinfo);
        return this;
    }

 }
