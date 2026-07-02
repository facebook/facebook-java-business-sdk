package com.facebook.ads.sdk;

import org.junit.Assert;
import org.junit.Test;

public class TargetingAutomationTest {

  public static void main(String[] args) {
    try {
      new TargetingAutomationTest().testIndividualSettingParsing();
      System.out.println("TEST PASSED!");
    } catch (Throwable t) {
      t.printStackTrace();
      System.exit(1);
    }
  }

  @Test
  public void testIndividualSettingParsing() {
    String json = "{\"advantage_audience\":1,\"individual_setting\":{\"geo\":1}}";
    TargetingAutomation targetingAutomation = TargetingAutomation.loadJSON(json, new APIContext("dummy_token"), "");
    
    Object individualSetting = targetingAutomation.getFieldIndividualSetting();
    Assert.assertNotNull(individualSetting);
    
    System.out.println("individualSetting: " + individualSetting);
    System.out.println("individualSetting class: " + individualSetting.getClass().getName());
    
    String serialized = targetingAutomation.toString();
    System.out.println("serialized: " + serialized);
    
    Assert.assertTrue("Serialized string should contain \"geo\":1", 
        serialized.contains("\"geo\":1") && !serialized.contains("\"geo\":1.0"));
  }
}
