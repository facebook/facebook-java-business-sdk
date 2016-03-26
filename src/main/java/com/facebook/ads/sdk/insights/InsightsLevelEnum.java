package com.facebook.ads.sdk.insights;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Xardas
 * Date: 26.03.16
 * Time: 21:35
 */
public enum InsightsLevelEnum {
  @SerializedName("ad")
  VALUE_AD("ad"),
  @SerializedName("adset")
  VALUE_ADSET("adset"),
  @SerializedName("campaign")
  VALUE_CAMPAIGN("campaign"),
  NULL(null);

  private String value;

  private InsightsLevelEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}