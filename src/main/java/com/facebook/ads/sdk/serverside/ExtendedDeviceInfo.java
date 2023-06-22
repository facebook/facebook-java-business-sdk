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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class ExtendedDeviceInfo {

    private static final int EXT_INFO_ARRAY_MAX_SIZE = 16;

    private static final int EXT_INFO_VERSION        = 0;
    private static final int APP_PACKAGE_NAME        = 1;
    private static final int SHORT_VERSION           = 2;
    private static final int LONG_VERSION            = 3;
    private static final int OS_VERSION              = 4;
    private static final int DEVICE_MODEL_NAME       = 5;
    private static final int LOCALE                  = 6;
    private static final int TIMEZONE_ABBREVIATION   = 7;
    private static final int CARRIER                 = 8;
    private static final int SCREEN_WIDTH            = 9;
    private static final int SCREEN_HEIGHT           = 10;
    private static final int SCREEN_DENSITY          = 11;
    private static final int CPU_CORE_COUNT          = 12;
    private static final int TOTAL_DISK_SPACE_GB     = 13;
    private static final int FREE_DISK_SPACE_GB      = 14;
    private static final int DEVICE_TIME_ZONE        = 15;

    private final String[] extendedDeviceInfoArray = new String[EXT_INFO_ARRAY_MAX_SIZE];

    public List<String> getExtendedDeviceInfoArray() {
        return Arrays.stream(extendedDeviceInfoArray).map(it -> it != null ? it : "").collect(toList());
    }

    public ExtendedDeviceInfo extinfoVersion(String extinfoVersion) {
        setExtinfoVersion(extinfoVersion);
        return this;
    }

    public String getExtinfoVersion() {
        return this.extendedDeviceInfoArray[EXT_INFO_VERSION];
    }

    public void setExtinfoVersion(String extinfoVersion) {
        this.extendedDeviceInfoArray[EXT_INFO_VERSION] = extinfoVersion;
    }

    public ExtendedDeviceInfo appPackageName(String appPackageName) {
        setAppPackageName(appPackageName);
        return this;
    }

    public String getAppPackageName() {
        return this.extendedDeviceInfoArray[APP_PACKAGE_NAME];
    }

    public void setAppPackageName(String appPackageName) {
        this.extendedDeviceInfoArray[APP_PACKAGE_NAME] = appPackageName;
    }

    public ExtendedDeviceInfo shortVersion(String shortVersion) {
        setShortVersion(shortVersion);
        return this;
    }

    public String getShortVersion() {
        return this.extendedDeviceInfoArray[SHORT_VERSION];
    }

    public void setShortVersion(String shortVersion) {
        this.extendedDeviceInfoArray[SHORT_VERSION] = shortVersion;
    }

    public ExtendedDeviceInfo longVersion(String longVersion) {
        setLongVersion(longVersion);
        return this;
    }

    public String getLongVersion() {
        return this.extendedDeviceInfoArray[LONG_VERSION];
    }

    public void setLongVersion(String longVersion) {
        this.extendedDeviceInfoArray[LONG_VERSION] = longVersion;
    }

    public ExtendedDeviceInfo osVersion(String osVersion) {
        setOsVersion(osVersion);
        return this;
    }

    public String getOsVersion() {
        return this.extendedDeviceInfoArray[OS_VERSION];
    }

    public void setOsVersion(String osVersion) {
        this.extendedDeviceInfoArray[OS_VERSION] = osVersion;
    }

    public ExtendedDeviceInfo deviceModelName(String deviceModelName) {
        setDeviceModelName(deviceModelName);
        return this;
    }

    public String getDeviceModelName() {
        return this.extendedDeviceInfoArray[DEVICE_MODEL_NAME];
    }

    public void setDeviceModelName(String deviceModelName) {
        this.extendedDeviceInfoArray[DEVICE_MODEL_NAME] = deviceModelName;
    }

    public ExtendedDeviceInfo locale(String locale) {
        setLocale(locale);
        return this;
    }

    public String getLocale() {
        return this.extendedDeviceInfoArray[LOCALE];
    }

    public void setLocale(String locale) {
        this.extendedDeviceInfoArray[LOCALE] = locale;
    }

    public ExtendedDeviceInfo timezoneAbbreviation(String timezoneAbbreviation) {
        setTimezoneAbbreviation(timezoneAbbreviation);
        return this;
    }

    public String getTimezoneAbbreviation() {
        return this.extendedDeviceInfoArray[TIMEZONE_ABBREVIATION];
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.extendedDeviceInfoArray[TIMEZONE_ABBREVIATION] = timezoneAbbreviation;
    }

    public ExtendedDeviceInfo carrier(String carrier) {
        setCarrier(carrier);
        return this;
    }

    public String getCarrier() {
        return this.extendedDeviceInfoArray[CARRIER];
    }

    public void setCarrier(String carrier) {
        this.extendedDeviceInfoArray[CARRIER] = carrier;
    }

    public ExtendedDeviceInfo screenWidth(Integer screenWidth) {
        setScreenWidth(screenWidth);
        return this;
    }

    public Integer getScreenWidth() {
        final String screenWithStr = this.extendedDeviceInfoArray[SCREEN_WIDTH];
        return screenWithStr != null ? Integer.parseInt(screenWithStr) : null;
    }

    public void setScreenWidth(Integer screenWidth) {
        this.extendedDeviceInfoArray[SCREEN_WIDTH] = screenWidth != null ? String.valueOf(screenWidth) : null;
    }

    public ExtendedDeviceInfo screenHeight(Integer screenHeight) {
        setScreenHeight(screenHeight);
        return this;
    }

    public Integer getScreenHeight() {
        final String screenHeightStr = this.extendedDeviceInfoArray[SCREEN_HEIGHT];
        return screenHeightStr != null ? Integer.parseInt(screenHeightStr) : null;
    }

    public void setScreenHeight(Integer screenHeight) {
        this.extendedDeviceInfoArray[SCREEN_HEIGHT] = screenHeight != null ? String.valueOf(screenHeight) : null;
    }

    public ExtendedDeviceInfo screenDensity(String screenDensity) {
        setScreenDensity(screenDensity);
        return this;
    }

    public String getScreenDensity() {
        return this.extendedDeviceInfoArray[SCREEN_DENSITY];
    }

    public void setScreenDensity(String screenDensity) {
        this.extendedDeviceInfoArray[SCREEN_DENSITY] = screenDensity;
    }

    public ExtendedDeviceInfo cpuCoresCount(Integer cpuCoresCount) {
        setCpuCoresCount(cpuCoresCount);
        return this;
    }

    public Integer getCpuCoresCount() {
        final String cpuCoresCount = this.extendedDeviceInfoArray[CPU_CORE_COUNT];
        return cpuCoresCount != null ? Integer.parseInt(cpuCoresCount) : null;
    }

    public void setCpuCoresCount(Integer cpuCoresCount) {
        this.extendedDeviceInfoArray[CPU_CORE_COUNT] = cpuCoresCount != null ? String.valueOf(cpuCoresCount) : null;
    }

    public ExtendedDeviceInfo totalDiskGB(Integer totalDiskGB) {
        setTotalDiskGB(totalDiskGB);
        return this;
    }

    public Integer getTotalDiskGB() {
        final String totalDiskGBStr = this.extendedDeviceInfoArray[TOTAL_DISK_SPACE_GB];
        return totalDiskGBStr != null ? Integer.parseInt(totalDiskGBStr) : null;
    }

    public void setTotalDiskGB(Integer totalDiskGB) {
        this.extendedDeviceInfoArray[TOTAL_DISK_SPACE_GB] = totalDiskGB != null ? String.valueOf(totalDiskGB) : null;
    }

    public ExtendedDeviceInfo freeDiskGB(Integer freeDiskGB) {
        setFreeDiskGB(freeDiskGB);
        return this;
    }

    public Integer getFreeDiskGB() {
        final String freeDiskGBStr = this.extendedDeviceInfoArray[FREE_DISK_SPACE_GB];
        return freeDiskGBStr != null ? Integer.parseInt(freeDiskGBStr) : null;
    }

    public void setFreeDiskGB(Integer freeDiskGB) {
        this.extendedDeviceInfoArray[FREE_DISK_SPACE_GB] = freeDiskGB != null ? String.valueOf(freeDiskGB) : null;
    }

    public ExtendedDeviceInfo deviceTimeZone(String deviceTimeZone) {
        setDeviceTimeZone(deviceTimeZone);
        return this;
    }

    public String getDeviceTimeZone() {
        return this.extendedDeviceInfoArray[DEVICE_TIME_ZONE];
    }

    public void setDeviceTimeZone(String deviceTimeZone) {
        this.extendedDeviceInfoArray[DEVICE_TIME_ZONE] = deviceTimeZone;
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
