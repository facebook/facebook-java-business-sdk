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

public class AttributionSetting {
    @SerializedName("inactivity_window_hours")
    private Integer inactivityWindowHours = null;

    @SerializedName("reattribution_window_hours")
    private Integer reattributionWindowHours = null;

    public AttributionSetting() {
    }

    public AttributionSetting(Integer inactivityWindowHours, Integer reattributionWindowHours) {
      this.inactivityWindowHours = inactivityWindowHours;
      this.reattributionWindowHours = reattributionWindowHours;
    }

    public AttributionSetting inactivityWindowHours(Integer inactivityWindowHours) {
      this.inactivityWindowHours = inactivityWindowHours;
      return this;
    }

    public Integer getInactivityWindowHours() {
      return inactivityWindowHours;
    }

    public void setInactivityWindowHours(Integer inactivityWindowHours) {
      this.inactivityWindowHours = inactivityWindowHours;
    }

    public AttributionSetting reattributionWindowHours(Integer reattributionWindowHours) {
      this.reattributionWindowHours = reattributionWindowHours;
      return this;
    }

    public Integer getReattributionWindowHours() {
      return reattributionWindowHours;
    }

    public void setReattributionWindowHours(Integer reattributionWindowHours) {
      this.reattributionWindowHours = reattributionWindowHours;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      AttributionSetting attributionSetting = (AttributionSetting) o;

      return Objects.equals(this.inactivityWindowHours, attributionSetting.inactivityWindowHours)
        && Objects.equals(this.reattributionWindowHours, attributionSetting.reattributionWindowHours);
    }

    @Override
    public int hashCode() {
      return Objects.hash(inactivityWindowHours, reattributionWindowHours);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AttributionSetting {\n");
      sb.append("    inactivityWindowHours: ").append(toIndentedString(inactivityWindowHours)).append("\n");
      sb.append("    reattributionWindowHours: ").append(toIndentedString(reattributionWindowHours)).append("\n");
      sb.append("}");
      return sb.toString();
    }

    private String toIndentedString(Object o) {
      if (o == null) {
        return "null";
      }
      return o.toString().replace("\n", "\n    ");
    }
}
