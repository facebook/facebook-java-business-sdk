package com.facebook.ads.sdk.insights;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Xardas
 * Date: 26.03.16
 * Time: 21:52
 */
public enum InsightsActionAttributionWindowsEnum {
  @SerializedName("1d_view")
  VALUE_1D_VIEW("1d_view"),
  @SerializedName("7d_view")
  VALUE_7D_VIEW("7d_view"),
  @SerializedName("28d_view")
  VALUE_28D_VIEW("28d_view"),
  @SerializedName("1d_click")
  VALUE_1D_CLICK("1d_click"),
  @SerializedName("7d_click")
  VALUE_7D_CLICK("7d_click"),
  @SerializedName("28d_click")
  VALUE_28D_CLICK("28d_click"),
  @SerializedName("default")
  VALUE_DEFAULT("default"),
  NULL(null);

  private String value;

  private InsightsActionAttributionWindowsEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}