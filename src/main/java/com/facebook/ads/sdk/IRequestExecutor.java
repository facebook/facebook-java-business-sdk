package com.facebook.ads.sdk;

import java.io.IOException;
import java.util.Map;

public interface IRequestExecutor {
    String execute(String method, String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    String sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    String sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    String sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
}