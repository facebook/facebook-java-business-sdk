package com.facebook.ads.sdk.insights;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Xardas
 * Date: 26.03.16
 * Time: 21:56
 */
public enum InsightsActionReportTimeEnum {
  @SerializedName("impression")
  VALUE_IMPRESSION("impression"),
  @SerializedName("conversion")
  VALUE_CONVERSION("conversion"),
  NULL(null);

  private String value;

  private InsightsActionReportTimeEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}