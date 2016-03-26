package com.facebook.ads.sdk.insights;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Xardas
 * Date: 26.03.16
 * Time: 22:01
 */
public enum InsightsDatePresetEnum {
  @SerializedName("today")
  VALUE_TODAY("today"),
  @SerializedName("yesterday")
  VALUE_YESTERDAY("yesterday"),
  @SerializedName("last_3_days")
  VALUE_LAST_3_DAYS("last_3_days"),
  @SerializedName("this_week")
  VALUE_THIS_WEEK("this_week"),
  @SerializedName("last_week")
  VALUE_LAST_WEEK("last_week"),
  @SerializedName("last_7_days")
  VALUE_LAST_7_DAYS("last_7_days"),
  @SerializedName("last_14_days")
  VALUE_LAST_14_DAYS("last_14_days"),
  @SerializedName("last_28_days")
  VALUE_LAST_28_DAYS("last_28_days"),
  @SerializedName("last_30_days")
  VALUE_LAST_30_DAYS("last_30_days"),
  @SerializedName("last_90_days")
  VALUE_LAST_90_DAYS("last_90_days"),
  @SerializedName("this_month")
  VALUE_THIS_MONTH("this_month"),
  @SerializedName("last_month")
  VALUE_LAST_MONTH("last_month"),
  @SerializedName("this_quarter")
  VALUE_THIS_QUARTER("this_quarter"),
  @SerializedName("last_3_months")
  VALUE_LAST_3_MONTHS("last_3_months"),
  @SerializedName("lifetime")
  VALUE_LIFETIME("lifetime"),
  NULL(null);

  private String value;

  private InsightsDatePresetEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}