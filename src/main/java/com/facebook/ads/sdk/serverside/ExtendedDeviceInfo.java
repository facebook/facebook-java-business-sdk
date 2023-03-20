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

import java.util.Objects;
import java.util.ArrayList;

public class ExtendedDeviceInfo {

    static int EXT_INFO_ARRAY_MAX_SIZE = 16;

    static int EXT_INFO_VERSION        = 0;
    static int APP_PACKAGE_NAME        = 1;
    static int SHORT_VERSION           = 2;
    static int LONG_VERSION            = 3;
    static int OS_VERSION              = 4;
    static int DEVICE_MODEL_NAME       = 5;
    static int LOCALE                  = 6;
    static int TIMEZONE_ABBREVIATION   = 7;
    static int CARRIER                 = 8;
    static int SCREEN_WIDTH            = 9;
    static int SCREEN_HEIGHT           = 10;
    static int SCREEN_DENSITY          = 11;
    static int CPU_CORE_COUNT          = 12;
    static int TOTAL_DISK_SPACE_GB     = 13;
    static int FREE_DISK_SPACE_GB      = 14;
    static int DEVICE_TIME_ZONE        = 15;

    private ArrayList<String> extendedDeviceInfoArray = null;

    public ArrayList<String> getExtendedDeviceInfoArray() {
        return extendedDeviceInfoArray;
    }

    public ExtendedDeviceInfo() {
        extendedDeviceInfoArray = new ArrayList<String>(ExtendedDeviceInfo.EXT_INFO_ARRAY_MAX_SIZE);
        System.out.println(extendedDeviceInfoArray.size());
    }

    public ExtendedDeviceInfo extinfoVersion(String extinfoVersion) {
        setExtinfoVersion(extinfoVersion);
        return this;
    }

    public String getExtinfoVersion() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.EXT_INFO_VERSION);
    }

    public void setExtinfoVersion(String extinfoVersion) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.EXT_INFO_VERSION, extinfoVersion);
    }

    public ExtendedDeviceInfo appPackageName(String appPackageName) {
        setAppPackageName(appPackageName);
        return this;
    }

    public String getAppPackageName() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.APP_PACKAGE_NAME);
    }

    public void setAppPackageName(String appPackageName) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.APP_PACKAGE_NAME, appPackageName);
    }

    public ExtendedDeviceInfo shortVersion(String shortVersion) {
        setShortVersion(shortVersion);
        return this;
    }

    public String getShortVersion() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.SHORT_VERSION);
    }

    public void setShortVersion(String shortVersion) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.SHORT_VERSION, shortVersion);
    }

    public ExtendedDeviceInfo longVersion(String longVersion) {
        setLongVersion(longVersion);
        return this;
    }

    public String getLongVersion() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.LONG_VERSION);
    }

    public void setLongVersion(String longVersion) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.LONG_VERSION, longVersion);
    }

    public ExtendedDeviceInfo osVersion(String osVersion) {
        setOsVersion(osVersion);
        return this;
    }

    public String getOsVersion() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.OS_VERSION);
    }

    public void setOsVersion(String osVersion) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.OS_VERSION, osVersion);
    }

    public ExtendedDeviceInfo deviceModelName(String deviceModelName) {
        setDeviceModelName(deviceModelName);
        return this;
    }

    public String getDeviceModelName() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.DEVICE_MODEL_NAME);
    }

    public void setDeviceModelName(String deviceModelName) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.DEVICE_MODEL_NAME, deviceModelName);
    }

    public ExtendedDeviceInfo locale(String locale) {
        setLocale(locale);
        return this;
    }

    public String getLocale() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.LOCALE);
    }

    public void setLocale(String locale) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.LOCALE, locale);
    }

    public ExtendedDeviceInfo timezoneAbbreviation(String timezoneAbbreviation) {
        setTimezoneAbbreviation(timezoneAbbreviation);
        return this;
    }

    public String getTimezoneAbbreviation() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.TIMEZONE_ABBREVIATION);
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.TIMEZONE_ABBREVIATION, timezoneAbbreviation);
    }

    public ExtendedDeviceInfo carrier(String carrier) {
        setCarrier(carrier);
        return this;
    }

    public String getCarrier() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.CARRIER);
    }

    public void setCarrier(String carrier) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.CARRIER, carrier);
    }

    public ExtendedDeviceInfo screenWidth(int screenWidth) {
        setScreenWidth(screenWidth);
        return this;
    }

    public int getScreenWidth() {
        return Integer.parseInt(this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.SCREEN_WIDTH));
    }

    public void setScreenWidth(int screenWidth) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.SCREEN_WIDTH, String.valueOf(screenWidth));
    }

    public ExtendedDeviceInfo screenHeight(int screenHeight) {
        setScreenHeight(screenHeight);
        return this;
    }

    public int getScreenHeight() {
        return Integer.parseInt(this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.SCREEN_HEIGHT));
    }

    public void setScreenHeight(int screenHeight) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.SCREEN_HEIGHT, String.valueOf(screenHeight));
    }

    public ExtendedDeviceInfo screenDensity(String screenDensity) {
        setScreenDensity(screenDensity);
        return this;
    }

    public String getScreenDensity() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.SCREEN_DENSITY);
    }

    public void setScreenDensity(String screenDensity) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.SCREEN_DENSITY, screenDensity);
    }

    public ExtendedDeviceInfo cpuCoresCount(int cpuCoresCount) {
        setCpuCoresCount(cpuCoresCount);
        return this;
    }

    public int getCpuCoresCount() {
        return Integer.parseInt(this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.CPU_CORE_COUNT));
    }

    public void setCpuCoresCount(int cpuCoresCount) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.CPU_CORE_COUNT, String.valueOf(cpuCoresCount));
    }

    public ExtendedDeviceInfo totalDiskGB(int totalDiskGB) {
        setTotalDiskGB(totalDiskGB);
        return this;
    }

    public int getTotalDiskGB() {
        return Integer.parseInt(this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.TOTAL_DISK_SPACE_GB));
    }

    public void setTotalDiskGB(int totalDiskGB) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.TOTAL_DISK_SPACE_GB, String.valueOf(totalDiskGB));
    }

    public ExtendedDeviceInfo freeDiskGB(int freeDiskGB) {
        setFreeDiskGB(freeDiskGB);
        return this;
    }

    public int getFreeDiskGB() {
        return Integer.parseInt(this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.FREE_DISK_SPACE_GB));
    }

    public void setFreeDiskGB(int freeDiskGB) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.FREE_DISK_SPACE_GB, String.valueOf(freeDiskGB));
    }

    public ExtendedDeviceInfo deviceTimeZone(String deviceTimeZone) {
        setDeviceTimeZone(deviceTimeZone);
        return this;
    }

    public String getDeviceTimeZone() {
        return this.extendedDeviceInfoArray.get(ExtendedDeviceInfo.DEVICE_TIME_ZONE);
    }

    public void setDeviceTimeZone(String deviceTimeZone) {
        this.extendedDeviceInfoArray.add(ExtendedDeviceInfo.DEVICE_TIME_ZONE, deviceTimeZone);
    }

    @Override
    public String toString() {
        return "{" +
            " extinfoVersion='" + getExtinfoVersion() + "'" +
            ", appPackageName='" + getAppPackageName() + "'" +
            ", shortVersion='" + getShortVersion() + "'" +
            ", longVersion='" + getLongVersion() + "'" +
            ", osVersion='" + getOsVersion() + "'" +
            ", deviceModelName='" + getDeviceModelName() + "'" +
            ", locale='" + getLocale() + "'" +
            ", timezoneAbbreviation='" + getTimezoneAbbreviation() + "'" +
            ", carrier='" + getCarrier() + "'" +
            ", screenWidth='" + getScreenWidth() + "'" +
            ", screenHeight='" + getScreenHeight() + "'" +
            ", screenDensity='" + getScreenDensity() + "'" +
            ", cpuCoresCount='" + getCpuCoresCount() + "'" +
            ", totalDiskGB='" + getTotalDiskGB() + "'" +
            ", freeDiskGB='" + getFreeDiskGB() + "'" +
            ", deviceTimeZone='" + getDeviceTimeZone() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ExtendedDeviceInfo)) {
            return false;
        }
        ExtendedDeviceInfo extendedDeviceInfo = (ExtendedDeviceInfo) o;
        return Objects.equals(getExtinfoVersion(), extendedDeviceInfo.getExtinfoVersion()) &&
            Objects.equals(getAppPackageName(), extendedDeviceInfo.getAppPackageName()) &&
            Objects.equals(getShortVersion(), extendedDeviceInfo.getShortVersion()) &&
            Objects.equals(getLongVersion(), extendedDeviceInfo.getLongVersion()) &&
            Objects.equals(getOsVersion(), extendedDeviceInfo.getOsVersion()) &&
            Objects.equals(getDeviceModelName(), extendedDeviceInfo.getDeviceModelName()) &&
            Objects.equals(getLocale(), extendedDeviceInfo.getLocale()) &&
            Objects.equals(getTimezoneAbbreviation(), extendedDeviceInfo.getTimezoneAbbreviation()) &&
            Objects.equals(getCarrier(), extendedDeviceInfo.getCarrier()) &&
            getScreenWidth() == extendedDeviceInfo.getScreenWidth() &&
            getScreenHeight() == extendedDeviceInfo.getScreenHeight() &&
            Objects.equals(getScreenDensity(), extendedDeviceInfo.getScreenDensity()) &&
            getCpuCoresCount() == extendedDeviceInfo.getCpuCoresCount() &&
            getTotalDiskGB() == extendedDeviceInfo.getTotalDiskGB() &&
            getFreeDiskGB() == extendedDeviceInfo.getFreeDiskGB() &&
            Objects.equals(getDeviceTimeZone(), extendedDeviceInfo.getDeviceTimeZone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExtinfoVersion(), getAppPackageName(), getShortVersion(), getLongVersion(),
            getOsVersion(), getDeviceModelName(), getLocale(), getTimezoneAbbreviation(), getCarrier(), getScreenWidth(),
            getScreenHeight(), getScreenDensity(), getCpuCoresCount(), getTotalDiskGB(), getFreeDiskGB(), getDeviceTimeZone());
    }
}
