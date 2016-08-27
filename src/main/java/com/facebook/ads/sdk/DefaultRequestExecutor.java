package com.facebook.ads.sdk;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;

public class DefaultRequestExecutor implements IRequestExecutor {

    private static final Map<String, String> fileToContentTypeMap = new HashMap<String, String>();
    static {
        fileToContentTypeMap.put(".atom", "application/atom+xml");
        fileToContentTypeMap.put(".rss", "application/rss+xml");
        fileToContentTypeMap.put(".xml", "application/xml");
        fileToContentTypeMap.put(".csv", "text/csv");
        fileToContentTypeMap.put(".txt", "text/plain");
    }

    public String execute(String method, String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
        if ("GET".equals(method)) return sendGet(apiUrl, allParams, context);
        else if ("POST".equals(method)) return sendPost(apiUrl, allParams, context);
        else if ("DELETE".equals(method)) return sendDelete(apiUrl, allParams, context);
        else throw new IllegalArgumentException("Unsupported http method. Currently only GET, POST, and DELETE are supported");
    }

    public String sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
        StringBuilder urlString = new StringBuilder(apiUrl);
        boolean firstEntry = true;
        for (Map.Entry entry : allParams.entrySet()) {
            urlString.append((firstEntry ? "?" : "&") + URLEncoder.encode(entry.getKey().toString(), "UTF-8") + "=" + URLEncoder.encode(convertToString(entry.getValue()), "UTF-8"));
            firstEntry = false;
        }
        URL url = new URL(urlString.toString());
        context.log("Request:");
        context.log("GET: " + url.toString());
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", APIConfig.USER_AGENT);
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

        return readResponse(con);
    }

    public String sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
        String boundary = "--------------------------" + new Random().nextLong();
        URL url = new URL(apiUrl);
        context.log("Post: " + url.toString());
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", APIConfig.USER_AGENT);
        con.setRequestProperty("Content-Type","multipart/form-data; boundary=" + boundary);
        con.setDoOutput(true);

        int contentLength = getContentLength(allParams, boundary, context);

        con.setRequestProperty("Content-Length", "" + contentLength);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        for (Map.Entry entry : allParams.entrySet()) {
            writeStringInUTF8Bytes(wr, "--" + boundary + "\r\n");
            if (entry.getValue() instanceof File) {
                File file = (File) entry.getValue();
                String contentType = getContentTypeForFile(file);
                writeStringInUTF8Bytes(wr, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + file.getName() + "\"\r\n");
                if (contentType != null) {
                    writeStringInUTF8Bytes(wr, "Content-Type: " + contentType + "\r\n");
                }
                writeStringInUTF8Bytes(wr, "\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = fileInputStream.read(buffer)) >= 0) {
                    wr.write(buffer, 0, count);
                }
                writeStringInUTF8Bytes(wr, "\r\n");
                fileInputStream.close();
            } else if (entry.getValue() instanceof byte[]) {
                byte[] bytes = (byte[]) entry.getValue();
                writeStringInUTF8Bytes(wr, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + "chunkfile" + "\"\r\n\r\n");
                wr.write(bytes, 0, bytes.length);
                writeStringInUTF8Bytes(wr, "\r\n");
            } else {
                writeStringInUTF8Bytes(wr, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
                writeStringInUTF8Bytes(wr, convertToString(entry.getValue()));
                writeStringInUTF8Bytes(wr, "\r\n");
            }
        }
        writeStringInUTF8Bytes(wr, "--" + boundary + "--\r\n");

        wr.flush();
        wr.close();

        return readResponse(con);
    }

    public String sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException {
        StringBuilder urlString = new StringBuilder(apiUrl);
        boolean firstEntry = true;
        for (Map.Entry entry : allParams.entrySet()) {
            urlString.append((firstEntry ? "?" : "&") + URLEncoder.encode(entry.getKey().toString(), "UTF-8") + "=" + URLEncoder.encode(convertToString(entry.getValue()), "UTF-8"));
            firstEntry = false;
        }
        URL url = new URL(urlString.toString());
        context.log("Delete: " + url.toString());
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        con.setRequestMethod("DELETE");
        con.setRequestProperty("User-Agent", APIConfig.USER_AGENT);

        return readResponse(con);
    }

    private static String getContentTypeForFile(File file) {
        for (Map.Entry entry : fileToContentTypeMap.entrySet()) {
            if (file.getName().endsWith((String)entry.getKey())) {
                return (String) entry.getValue();
            }
        }
        return null;
    }

    private static int getContentLength(Map<String, Object> allParams, String boundary, APIContext context) throws IOException {
        int contentLength = 0;
        for (Map.Entry entry : allParams.entrySet()) {
            contentLength += ("--" + boundary + "\r\n").length();
            if (entry.getValue() instanceof File) {
                File file = (File) entry.getValue();
                String contentType = getContentTypeForFile(file);
                contentLength += getLengthAndLog(context, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + file.getName() + "\"\r\n");
                if (contentType != null) {
                    contentLength += getLengthAndLog(context, "Content-Type: " + contentType + "\r\n");
                }
                contentLength += getLengthAndLog(context, "\r\n");
                contentLength += file.length();
                contentLength += getLengthAndLog(context, "\r\n");
            } else if (entry.getValue() instanceof byte[]) {
                byte[] bytes = (byte[]) entry.getValue();
                contentLength += getLengthAndLog(context, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + "chunkfile" + "\"\r\n");
                contentLength += bytes.length;
                contentLength += getLengthAndLog(context, "\r\n");
            } else {
                contentLength += getLengthAndLog(context, "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
                contentLength += getLengthAndLog(context, convertToString(entry.getValue()));
                contentLength += getLengthAndLog(context, "\r\n");
            }
        }
        contentLength += getLengthAndLog(context, "--" + boundary + "--\r\n");
        return contentLength;
    }

    private static String convertToString(Object input) {
        if (input == null) {
            return "null";
        } else if (input instanceof Map) {
            Gson gson = new Gson();
            return gson.toJson((Map)input);
        } else if (input instanceof List) {
            Gson gson = new Gson();
            return gson.toJson((List)input);
        } else {
            return input.toString();
        }
    }

    private static String readResponse(HttpsURLConnection con) throws APIException, IOException {
        try {
            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch(Exception e) {

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            throw new APIException.FailedRequestException(response.toString(), e);
        }
    }

    private static int getLengthAndLog(APIContext context, String input) throws IOException {
        context.log(input);
        return input.getBytes("UTF-8").length;
    }

    private static void writeStringInUTF8Bytes(DataOutputStream wr, String input) throws IOException {
        wr.write(input.getBytes("UTF-8"));
    }
}